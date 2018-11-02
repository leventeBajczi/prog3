package hu.bme.mit.mcmec.c2xta;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type C 2 xta test.
 */
public class C2XtaTest {
    private final String prefix = "build/resources/test/";
    private final String[] paths = {
            "test1.c",
            "test2.c"
            };
    private final String[] xtaOutput = {
            "int var_mutex;\n" +
                    "\n" +
                    "chan mutex, main_irstThread, main_econdThread, irstThread, econdThread, main_ain;\n" +
                    "\n" +
                    "\n" +
                    "process firstThread() {\n" +
                    "clock x;\n" +
                    "state\n" +
                    "  firstThread_in,\n" +
                    "  firstThread_start,\n" +
                    "  relaxed_load_global_11,\n" +
                    "  relaxed_store_global_12,\n" +
                    "  final;\n" +
                    "init firstThread_in;\n" +
                    "trans\n" +
                    "  firstThread_in  ->  firstThread_start{ sync irstThread?; },\n" +
                    "  firstThread_start  ->  relaxed_load_global_11{ },\n" +
                    "  relaxed_load_global_11  ->  relaxed_store_global_12{ },\n" +
                    "  relaxed_store_global_12  ->  final{ sync main_irstThread!; };\n" +
                    "}\n" +
                    "\n" +
                    "process main() {\n" +
                    "clock x;\n" +
                    "state\n" +
                    "  main_in,\n" +
                    "  relaxed_store_global_29,\n" +
                    "  thrd_create_0,\n" +
                    "  thrd_create_1,\n" +
                    "  thrd_join_2,\n" +
                    "  thrd_join_3,\n" +
                    "  final;\n" +
                    "init main_in;\n" +
                    "trans\n" +
                    "  main_in  ->  relaxed_store_global_29{ assign var_mutex = 0; },\n" +
                    "  relaxed_store_global_29  ->  thrd_create_0{ sync irstThread!; },\n" +
                    "  thrd_create_0  ->  thrd_create_1{ sync econdThread!; },\n" +
                    "  thrd_create_1  ->  thrd_join_2{ sync main_econdThread?; },\n" +
                    "  thrd_join_2  ->  thrd_join_3{ sync main_irstThread?; },\n" +
                    "  thrd_join_3  ->  final{ sync main_ain!; };\n" +
                    "}\n" +
                    "\n" +
                    "process secondThread() {\n" +
                    "clock x;\n" +
                    "state\n" +
                    "  secondThread_in,\n" +
                    "  secondThread_start,\n" +
                    "  relaxed_store_global_19,\n" +
                    "  relaxed_load_global_20,\n" +
                    "  final;\n" +
                    "init secondThread_in;\n" +
                    "trans\n" +
                    "  secondThread_in  ->  secondThread_start{ sync econdThread?; },\n" +
                    "  secondThread_start  ->  relaxed_store_global_19{ },\n" +
                    "  relaxed_store_global_19  ->  relaxed_load_global_20{ },\n" +
                    "  relaxed_load_global_20  ->  final{ sync main_econdThread!; };\n" +
                    "}\n" +
                    "system firstThread, main, secondThread; \n",
            "\n" +
                    "chan main_hreadFunc2, main_hreadFunc1, hreadFunc1, hreadFunc2, main_ain;\n" +
                    "\n" +
                    "\n" +
                    "process threadFunc1() {\n" +
                    "clock x;\n" +
                    "state\n" +
                    "  threadFunc1_in,\n" +
                    "  threadFunc1_start,\n" +
                    "  relaxed_store_g_sharedInt_20,\n" +
                    "  final;\n" +
                    "init threadFunc1_in;\n" +
                    "trans\n" +
                    "  threadFunc1_in  ->  threadFunc1_start{ sync hreadFunc1?; },\n" +
                    "  threadFunc1_start  ->  relaxed_store_g_sharedInt_20{ },\n" +
                    "  relaxed_store_g_sharedInt_20  ->  final{ sync main_hreadFunc1!; };\n" +
                    "}\n" +
                    "\n" +
                    "process main() {\n" +
                    "clock x;\n" +
                    "state\n" +
                    "  main_in,\n" +
                    "  thrd_create_0,\n" +
                    "  thrd_create_1,\n" +
                    "  thrd_join_2,\n" +
                    "  thrd_join_3,\n" +
                    "  final;\n" +
                    "init main_in;\n" +
                    "trans\n" +
                    "  main_in  ->  thrd_create_0{ sync hreadFunc1!; },\n" +
                    "  thrd_create_0  ->  thrd_create_1{ sync hreadFunc2!; },\n" +
                    "  thrd_create_1  ->  thrd_join_2{ sync main_hreadFunc1?; },\n" +
                    "  thrd_join_2  ->  thrd_join_3{ sync main_hreadFunc2?; },\n" +
                    "  thrd_join_3  ->  final{ sync main_ain!; };\n" +
                    "}\n" +
                    "\n" +
                    "process threadFunc2() {\n" +
                    "clock x;\n" +
                    "state\n" +
                    "  threadFunc2_in,\n" +
                    "  threadFunc2_start,\n" +
                    "  relaxed_store_g_sharedInt_11,\n" +
                    "  final;\n" +
                    "init threadFunc2_in;\n" +
                    "trans\n" +
                    "  threadFunc2_in  ->  threadFunc2_start{ sync hreadFunc2?; },\n" +
                    "  threadFunc2_start  ->  relaxed_store_g_sharedInt_11{ },\n" +
                    "  relaxed_store_g_sharedInt_11  ->  final{ sync main_hreadFunc2!; };\n" +
                    "}\n" +
                    "system threadFunc1, main, threadFunc2; \n"
    };

    /**
     * C 2 xta test.
     *
     * @throws IOException the io exception
     */
    @Test
    public void c2XtaTest() throws IOException {
        File[] files = new File[paths.length];
        for(int i = 0; i<paths.length; i++) {
            files[i] = new File("test" + i + ".xta");
            while (files[i].exists())
                files[i] = new File(files[i].getAbsolutePath() + "$");
            files[i].deleteOnExit();
        }

        for (int i = 0; i < paths.length; i++) {
            C2Xta.transform(prefix + paths[i], files[i].getAbsolutePath());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i]));
            String line;
            StringBuilder output= new StringBuilder();
            while((line = bufferedReader.readLine()) != null)
            {
                output.append(line).append("\n");
            }
            bufferedReader.close();
            Assert.assertEquals(output.toString(), xtaOutput[i]);
        }
    }
}
