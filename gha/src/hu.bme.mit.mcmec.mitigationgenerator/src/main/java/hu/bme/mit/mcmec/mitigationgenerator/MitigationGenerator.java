package hu.bme.mit.mcmec.mitigationgenerator;

import hu.bme.mit.theta.xta.XtaProcess;
import hu.bme.mit.theta.xta.XtaSystem;
import hu.bme.mit.theta.xta.dsl.XtaDslManager;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

/**
 * The type Mitigation generator.
 */
public class MitigationGenerator {
    private static final String UPPAAL_CMD = "/bin-Linux/verifyta -t1";
    private final String sourceFile;

    private XtaSystem xtaSystem;
    private final String xtaFile;
    private final JSONObject issues;
    private final BufferedReader sourceReader;
    private BufferedWriter sourceWriter;
    private final String queryFile;
    private final String uppaalHome;
    private List<String> mutexes;
    private Map<Integer, String> environments;
    private List<String> lines;
    private int counter = 0;

    private MitigationGenerator(String uppaalHome, String xtaFile, String issues, String sourceCode, String queryFile) {
        BufferedReader sourceReader = null;
        try {
            FileInputStream inputStream = new FileInputStream(xtaFile);
            xtaSystem = XtaDslManager.createSystem(inputStream);
            sourceReader = new BufferedReader(new FileReader(new File(sourceCode)));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sourceReader = sourceReader;
        this.issues = new JSONObject(issues);
        this.queryFile = queryFile;
        this.uppaalHome = uppaalHome;
        this.xtaFile = xtaFile;
        this.lines = new ArrayList<>();
        this.sourceFile = sourceCode;
    }

    /**
     * Generate mitigation.
     *
     * @param uppaalHome the uppaal home
     * @param xtaFile    the xta file
     * @param issues     the issues
     * @param sourceCode the source code
     * @param queryFile  the query file
     */
    public static void generateMitigation(String uppaalHome, String xtaFile, String issues, String sourceCode,  String queryFile)
    {
        MitigationGenerator mitigationGenerator = new MitigationGenerator(uppaalHome, xtaFile, issues, sourceCode, queryFile);
        mitigationGenerator.run();
    }

    private void run() {
        try {
            read();
            sourceReader.close();
            sourceWriter = new BufferedWriter(new FileWriter(new File(sourceFile)));
            query();
            fix();
            eliminate();
            write();
            sourceWriter.flush();
            sourceWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void eliminate() {
        for(int i = 0; i<lines.size() - 1; i++)
        {
            if(lines.get(i).contains("mtx_unlock") && lines.get(i).replace("mtx_unlock", "mtx_lock").equals(lines.get(i+1)))
            {
                lines.remove(i);
                lines.remove(i);

            }
        }
    }

    private void write() throws IOException {
        for(String s : lines)
        {
            sourceWriter.write(s);
            sourceWriter.newLine();
        }
        File result = new File(sourceFile);
    }

    private void read() throws IOException {
        String line;
        while((line = sourceReader.readLine()) != null)
        {
            lines.add(line);
        }
    }

    private void fix() {
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i< issues.getJSONArray("issues").length(); i++) {
            JSONArray jsonArray = issues.getJSONArray("issues").getJSONObject(i).getJSONArray("values");
            String mutex = null;
            for (int j = 0; j < jsonArray.length(); j++) {
                String possibleMutex = environments.get(jsonArray.getInt(j));
                if (possibleMutex != null) mutex = possibleMutex;
            }
            if (mutex == null) mutex = mutexes.get(0);

            for (int j = 0; j < jsonArray.length(); j++) {
                if(environments.get(jsonArray.getInt(j)) == null || !environments.get(jsonArray.getInt(j)).equals(mutex))
                {
                    counter = 0;
                    for(int k : values)
                        if(k<jsonArray.getInt(j)) counter+=2;
                    values.add(jsonArray.getInt(j));
                    lines.add(jsonArray.getInt(j) + counter-1, "mtx_lock(&" + mutex.replace("var_", "") + ");");
                    lines.add(jsonArray.getInt(j) + counter + 1, "mtx_unlock(&" + mutex.replace("var_", "") + ");");
                }
            }
        }
    }

    private void query() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(queryFile)));
        mutexes = new ArrayList<>();
        environments = new HashMap<>();
        Map<Integer, String> locations = new HashMap<>();
        for (hu.bme.mit.theta.core.decl.VarDecl<?> varDecl : xtaSystem.getDataVars()) {
            if(varDecl.toString().contains("mutex")) mutexes.add(varDecl.getName());
        }
        for (XtaProcess xtaProcess : xtaSystem.getProcesses()) {
            for (XtaProcess.Loc loc : xtaProcess.getLocs()) {
                String[] tokens = loc.getName().split("_");
                try {
                    locations.put(Integer.parseInt(tokens[tokens.length - 1]), loc.getName());
                }
                catch (NumberFormatException e)
                {
                }
            }
        }

        for(int i = 0; i< issues.getJSONArray("issues").length(); i++)
        {
            JSONArray jsonArray = issues.getJSONArray("issues").getJSONObject(i).getJSONArray("values");
            for(int j = 0; j<jsonArray.length();j++)
            {
                environments.put(jsonArray.getInt(j), null);
                for(String s : mutexes) {
                    String loc = locations.get(jsonArray.getInt(j));
                    bufferedWriter.write("//" + jsonArray.getInt(j) + " " + s);
                    bufferedWriter.newLine();
                    bufferedWriter.write("E<>(" + loc.replaceFirst("_", ".") + " & " + s + " == 0)");
                    bufferedWriter.newLine();
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();

        Process pr =  Runtime.getRuntime().exec(uppaalHome + UPPAAL_CMD + " " + xtaFile + " " + queryFile);
        BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line, lastLine = null;
        while((line = input.readLine()) != null)
        {
            if(line.contains("Formula is NOT satisfied."))
                getLine(Integer.parseInt(lastLine.split(" at line ")[1]), queryFile);
            lastLine = line;
        }

    }

    private void getLine(int lineNo, String queryFilename) {

        String uLine;
        String lastMutex;
        int lastNo = 0;
        try {

            FileReader fileReader = new FileReader(new File(queryFilename));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for(int i = 1; i<lineNo;i++)
            {
                uLine = bufferedReader.readLine();
                if(uLine.startsWith("//")) {
                    lastNo = Integer.parseInt(uLine.substring(2).split(" ")[0]);
                    lastMutex = uLine.substring(2).split(" ")[1];
                    environments.replace(lastNo, lastMutex);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
