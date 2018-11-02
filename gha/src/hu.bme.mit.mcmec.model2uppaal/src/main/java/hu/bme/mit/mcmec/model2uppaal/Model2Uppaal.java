package hu.bme.mit.mcmec.model2uppaal;

import hu.bme.mit.mcmec.model2uppaal.dsl.IssuesDslManager;
import hu.bme.mit.theta.xta.XtaProcess;
import hu.bme.mit.theta.xta.XtaSystem;
import hu.bme.mit.theta.xta.dsl.XtaDslManager;

import java.io.*;
import java.util.*;

/**
 * The type Model 2 uppaal.
 */
public class Model2Uppaal {

    private XtaSystem xtaSystem;
    private InputStream inputStream;
    private Map<String, List<String>> issueMap;         //Maps issue names to lists of operation types
    private Map<String, List<List<String>>> queryMap;   //Maps issue names to lists of together-problematic states' names

    /**
     * Transform.
     *
     * @param xta     the xta
     * @param issues  the issues
     * @param outName the out name
     */
    public static void transform(String xta, String issues, String outName) {
        Model2Uppaal model2Uppaal = new Model2Uppaal();
        model2Uppaal.run(new File(xta), new File(issues), new File(outName));
    }
    private void run(File xta, File issues, File out)
    {
        try {
            inputStream = new FileInputStream(xta);
            xtaSystem = XtaDslManager.createSystem(inputStream);
            inputStream = new FileInputStream(issues);
            issueMap = IssuesDslManager.parseIssues(inputStream);
            queryMap = new HashMap<>();

            buildQueryList();

            writeQuery(out);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildQueryList() {
        issueMap.forEach((issue, tuples) ->{
            List<List<String>> statesList= new ArrayList<>();
            tuples.forEach(atomic ->
            {
                
                List<String> states = new ArrayList<>();
                xtaSystem.getProcesses().forEach(xtaProcess ->
                {
                    xtaProcess.getLocs().forEach(loc -> {
                        if(locationFitsInstruction(loc, atomic))
                        {
                            states.add(loc.getName());
                        }
                    });
                });
                statesList.add(states);
            });
            queryMap.put(issue, statesList);
        });

    }

    private boolean locationFitsInstruction(XtaProcess.Loc loc, String atomic) {
        return loc.getName().contains(getNameFromIssue(atomic));                //TODO: something more foolproof
    }


    private String getNameFromIssue(String issue) {
        return issue.split(" ")[0] + "_" + issue.split(" ")[1];
    }

    private void writeQuery(File out)
    {
        List<String> lines = new ArrayList<>();
        try {
            FileWriter fileWriter = new FileWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            queryMap.forEach((name, stateListList) ->
            {
                String text = "";
                try {
                    bufferedWriter.write("//" + name + "\n");
                    int maxSize = 0;

                    for(List<String> states : stateListList)
                    {
                        if(states.size() > maxSize) maxSize = states.size();
                    }
                    if(maxSize == 0)
                        return;
                    for(int i = 0; i<Math.pow(maxSize, stateListList.size()); i++)
                    {
                        List<String> projection = new ArrayList<>();
                        int n = i;
                        for(List<String> states : stateListList)
                        {
                            if(states.size() <= n % maxSize)
                                break;
                            projection.add(states.get(n%maxSize));
                            n /= maxSize;
                        }

                        if(projection.size() < stateListList.size() || hasDuplicates(projection))
                            continue;

                        text = projection.get(0).replaceFirst("_", ".");
                        String lineToWrite = "E<>(" + text;
                        boolean ok = true;
                        for(int j = 1; j< stateListList.size(); j++)
                        {
                            text = projection.get(j).replaceFirst("_", ".");
                            lineToWrite = lineToWrite.concat(" & " + text);
                        }

                       lineToWrite = lineToWrite.concat(")\n");
                       for(String item : lines)
                            if(item.equals(lineToWrite))
                                ok = false;
                        if(ok){
                            bufferedWriter.write(lineToWrite);
                            lines.add(lineToWrite);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean hasDuplicates(List<String> projection) {
        java.util.Collections.sort(projection);
        for(int i = 1; i<projection.size(); i++)
        {
            if(projection.get(i).equals(projection.get(i-1))) return true;
        }
        return false;
    }
}
