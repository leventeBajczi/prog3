package hu.bme.mit.mcmec.tricheckparser;

import hu.bme.mit.mcmec.tricheckparser.dsl.TriCheckParser;
import org.junit.Test;
import org.junit.Assert;

import java.io.*;

/**
 * The type Tri check parser test.
 */
public class TriCheckParserTest {
    private final String prefix = "build/resources/test/";
    private final String[] litmusTestPath =
            {
                    "litmus1",
                    "litmus2"
            };
    private final String[] litmusTestOutput =
            {
                    "issue tricheck_0 { relaxed store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_1 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_2 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_3 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_4 { seq_cst store : relaxed load } \n" +
                            "\n" +
                            "issue tricheck_5 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_6 { seq_cst store : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_7 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_8 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_9 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_10 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_11 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_12 { release store : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_13 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_14 { relaxed store : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_15 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_16 { relaxed store : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_17 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_18 { release store : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_19 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_20 { relaxed store : relaxed load } \n" +
                            "\n" +
                            "issue tricheck_21 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_22 { seq_cst store : relaxed load } \n" +
                            "\n" +
                            "issue tricheck_23 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_24 { relaxed store : relaxed load } \n" +
                            "\n" +
                            "issue tricheck_25 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_26 { release store : relaxed load } \n" +
                            "\n" +
                            "issue tricheck_27 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_28 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_29 { release store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_30 { seq_cst store : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_31 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_32 { relaxed store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_33 { seq_cst store : acquire load } \n" +
                            "\n" +
                            "issue tricheck_34 { release store : relaxed load } \n" +
                            "\n" +
                            "issue tricheck_35 { seq_cst store : acquire load } \n" +
                            "\n",

                    "issue tricheck_0 { seq_cst store : acquire load : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_1 { seq_cst store : seq_cst load : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_2 { seq_cst store : acquire load : seq_cst load } \n" +
                            "\n" +
                            "issue tricheck_3 { seq_cst store : seq_cst load : acquire load } \n" +
                            "\n"
            };


    /**
     * Tri check parser test.
     *
     * @throws IOException the io exception
     */
    @Test
    public void triCheckParserTest() throws IOException {
        File[] files = new File[litmusTestPath.length];
        for(int i = 0; i<litmusTestPath.length; i++) {
            files[i] = new File("test" + i + ".issues");
            while (files[i].exists())
                files[i] = new File(files[i].getAbsolutePath() + "$");
            files[i].deleteOnExit();
        }

        for (int i = 0; i < litmusTestPath.length; i++) {
            TriCheckParser.parseLitmusIntoQuery(prefix + litmusTestPath[i], files[i].getAbsolutePath());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
            String line;
            StringBuilder output= new StringBuilder();
            while((line = bufferedReader.readLine()) != null)
            {
                output.append(line).append("\n");
            }
            bufferedReader.close();
            Assert.assertEquals(output.toString(), litmusTestOutput[i]);
        }
    }
}
