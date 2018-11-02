package hu.bme.mit.mcmec.verifier;

import java.io.*;


/**
 * The type Verifier.
 */
public class Verifier {

    private static final String UPPAAL_CMD = "/bin-Linux/verifyta -t1";

    /**
     * Verify string.
     *
     * @param uppaalHome    the uppaal home
     * @param xtaFilename   the xta filename
     * @param queryFileName the query file name
     * @return the string
     */
    public static String verify(String uppaalHome, String xtaFilename, String queryFileName) {
        String originalList = "{\"issues\":[";
	    StringBuilder list = new StringBuilder(originalList);
	    try {
            Process pr =  Runtime.getRuntime().exec(uppaalHome + UPPAAL_CMD + " " + xtaFilename + " " + queryFileName);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            int lastLineNo = 0;

            try {
                while ((line = input.readLine()) != null)
                    if(line.contains("Verifying"))
                        lastLineNo = Integer.parseInt(line.split(" ")[line.split(" ").length-1]);
                    else if(line.contains("is satisfied"))
                        list.append("{").append(getLine(lastLineNo, queryFileName)).append("},");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	if(list.toString().equals(originalList)) return "";
        list = new StringBuilder(list.substring(0, list.length() - 1) + "]}");
        return list.toString();
    }

    private static String getLine(int line, String queryFilename) {

        String uppaalLine = "", uLine;
        try {

            FileReader fileReader = new FileReader(new File(queryFilename));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for(int i = 1; i<line;i++)
            {
                uLine = bufferedReader.readLine();
                if(uLine.startsWith("//"))
                    uppaalLine = "\"name\": \"" + uLine.substring(2) + "\", \"values\": [";
            }
            uLine = bufferedReader.readLine();

            int i;
            for(i = 0; i<uLine.split("&").length - 1;i++)
            {
                uppaalLine = uppaalLine.concat(uLine.split( "&")[i].split("_")[uLine.split( "&")[i].split("_").length - 1] + ", ");
            }            
            uppaalLine = uppaalLine.concat(uLine.split( "&")[i].split("_")[uLine.split( "&")[i].split("_").length - 1]);
            uppaalLine = uppaalLine.substring(0, uppaalLine.length() - 1) + "]";
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uppaalLine;
    }

}

