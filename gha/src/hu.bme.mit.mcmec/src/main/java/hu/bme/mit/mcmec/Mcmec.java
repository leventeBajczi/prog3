package hu.bme.mit.mcmec;

import hu.bme.mit.mcmec.c2xta.C2Xta;
import hu.bme.mit.mcmec.gui.McmecGui;
import hu.bme.mit.mcmec.mitigationgenerator.MitigationGenerator;
import hu.bme.mit.mcmec.model2uppaal.Model2Uppaal;
import hu.bme.mit.mcmec.tricheckparser.dsl.TriCheckParser;
import hu.bme.mit.mcmec.verifier.Verifier;

/**
 * The type Mcmec.
 */
public class Mcmec {
    private static final String MODE_ALL  = "all";
    private static final String MODE_LITMUS2ISSUES = "litmus2issues";
    private static final String MODE_C2XTA = "c2xta";
    private static final String MODE_XTA2QUERY = "xta2query";
    private static final String MODE_QUERY2RESULT = "query2result";
    private static final String MODE_ALL_MITIGATION = "mitigation";
    private static final String MODE_GUI = "gui";

    private static String ISSUES_FILE_NAME = ".issues";
    private static String XTA_FILE_NAME = ".xta";
    private static String QUERY_FILE_NAME = ".query";
    private static String QUERY2_FILE_NAME = ".query";
    private static String LITMUS_FOLDER = null;
    private static String UPPAAL_HOME = null;
    private static String SOURCE_FILE = null;
    private static String MODE = MODE_ALL;

    private static final String PARAM_SHORT_ISSUES = "-i";
    private static final String PARAM_SHORT_LITMUS_FOLDER = "-l";
    private static final String PARAM_SHORT_XTA = "-x";
    private static final String PARAM_SHORT_QUERY = "-q";
    private static final String PARAM_SHORT_QUERY2 = "-q2";
    private static final String PARAM_SHORT_UPPAAL_HOME = "-u";
    private static final String PARAM_SHORT_SOURCE_FILE = "-s";
    private static final String PARAM_SHORT_MODE = "-m";

    private static final String PARAM_LONG_ISSUES = "--issues";
    private static final String PARAM_LONG_LITMUS_FOLDER = "--litmus";
    private static final String PARAM_LONG_XTA = "--xta";
    private static final String PARAM_LONG_QUERY = "--query";
    private static final String PARAM_LONG_QUERY2 = "--query2";
    private static final String PARAM_LONG_UPPAAL_HOME = "--uppaal";
    private static final String PARAM_LONG_SOURCE_FILE = "--source";
    private static final String PARAM_LONG_MODE = "--mode";


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(run(args));
    }

    /**
     * Run string.
     *
     * @param args the args
     * @return the string
     */
    public static String run(String[] args) {
        if(args.length <= 1){
            return "Not enough parameters.";
        }
        for(int i =0; i<args.length-1; i++)
        {
            switch(args[i])
            {
                case PARAM_SHORT_ISSUES:
                case PARAM_LONG_ISSUES:
                    ISSUES_FILE_NAME = args[++i];
                    break;
                case PARAM_SHORT_LITMUS_FOLDER:
                case PARAM_LONG_LITMUS_FOLDER:
                    LITMUS_FOLDER = args[++i];
                    break;
                case PARAM_SHORT_XTA:
                case PARAM_LONG_XTA:
                    XTA_FILE_NAME = args[++i];
                    break;
                case PARAM_SHORT_QUERY:
                case PARAM_LONG_QUERY:
                    QUERY_FILE_NAME = args[++i];
                    break;
                case PARAM_SHORT_QUERY2:
                case PARAM_LONG_QUERY2:
                    QUERY2_FILE_NAME = args[++i];
                    break;
                case PARAM_SHORT_UPPAAL_HOME:
                case PARAM_LONG_UPPAAL_HOME:
                    UPPAAL_HOME = args[++i];
                    break;
                case PARAM_SHORT_SOURCE_FILE:
                case PARAM_LONG_SOURCE_FILE:
                    SOURCE_FILE = args[++i];
                    break;
                case PARAM_SHORT_MODE:
                case PARAM_LONG_MODE:
                    MODE = args[++i];
                    break;
                default:
                    return "Unknown parameter " + args[i] + ". Terminating.";
            }
        }
        String issues;
        switch(MODE)
        {
            case MODE_LITMUS2ISSUES:
                TriCheckParser.parseLitmusIntoQuery(LITMUS_FOLDER, ISSUES_FILE_NAME);
                return "Succesfully transformed litmus tests from " + LITMUS_FOLDER + " to " + ISSUES_FILE_NAME + ".";
            case MODE_C2XTA:
                C2Xta.transform(SOURCE_FILE, XTA_FILE_NAME);
                return "Succesfully transformed source from " + SOURCE_FILE + " to " + XTA_FILE_NAME + ".";
            case MODE_XTA2QUERY:
                Model2Uppaal.transform(XTA_FILE_NAME, ISSUES_FILE_NAME, QUERY_FILE_NAME);
                return "Succesfully transformed model from " + XTA_FILE_NAME + " to " + QUERY_FILE_NAME + " with the help of " + ISSUES_FILE_NAME + ".";
            case MODE_QUERY2RESULT:
                issues = Verifier.verify(UPPAAL_HOME, XTA_FILE_NAME, QUERY_FILE_NAME);
                return issues;
            case MODE_ALL_MITIGATION:
                TriCheckParser.parseLitmusIntoQuery(LITMUS_FOLDER, ISSUES_FILE_NAME);
                C2Xta.transform(SOURCE_FILE, XTA_FILE_NAME);
                Model2Uppaal.transform(XTA_FILE_NAME, ISSUES_FILE_NAME, QUERY_FILE_NAME);
                issues = Verifier.verify(UPPAAL_HOME, XTA_FILE_NAME, QUERY_FILE_NAME);
                if(issues.length() > 0 ){
                    System.out.println(issues);
                    MitigationGenerator.generateMitigation(UPPAAL_HOME, XTA_FILE_NAME, issues, SOURCE_FILE, QUERY2_FILE_NAME);
                    System.out.println("Generated mitigation, re-run program to check correctness...");
                }
                else
                    return "No further issues to mitigate!";

                break;
            case MODE_ALL:
                TriCheckParser.parseLitmusIntoQuery(LITMUS_FOLDER, ISSUES_FILE_NAME);
                C2Xta.transform(SOURCE_FILE, XTA_FILE_NAME);
                Model2Uppaal.transform(XTA_FILE_NAME, ISSUES_FILE_NAME, QUERY_FILE_NAME);
                issues = Verifier.verify(UPPAAL_HOME, XTA_FILE_NAME, QUERY_FILE_NAME);
                if(issues.length() == 0)
                    return "No issues found.";
                else
                    return issues;
            case MODE_GUI:
                McmecGui.setupUI();
                break;
            default:
                return "Wrong application mode. Terminating.";
        }
        return "";
    }

    /**
     * Get uppaal home string.
     *
     * @return the string
     */
    public static String getUppaalHome(){
        return UPPAAL_HOME;
    }

    /**
     * Gets issues file name.
     *
     * @return the issues file name
     */
    public static String getIssuesFileName() {
        return ISSUES_FILE_NAME;
    }

    /**
     * Gets query file name.
     *
     * @return the query file name
     */
    public static String getQueryFileName() {
        return QUERY_FILE_NAME;
    }

    /**
     * Gets xta file name.
     *
     * @return the xta file name
     */
    public static String getXtaFileName() {
        return XTA_FILE_NAME;
    }
}
