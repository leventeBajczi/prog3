package hu.bme.mit.mcmec;

import org.junit.Assert;
import org.junit.Test;

/**
 * The type Mcmec test.
 */
public class McmecTest {
    private final String prefix = "build/resources/test/";
    private final String testSource = "test.c";
    private final String uppaalHome = "uppaal_installation";
    private final String litmusFolder = "issues";

    private final int PASSES = 2;       //How many times should we try to mitigate

    /**
     * Mitigation generator tester.
     */
    @Test
    public void mitigationGeneratorTester()
    {
        String[] args = {"-s", prefix + testSource, "-l", prefix + litmusFolder, "-u", prefix + uppaalHome, "-m", "all"};
        if(!Mcmec.run(args).equals("No issues found."))
        {
            args[args.length-1] = "mitigation";
            Assert.assertNotEquals(Mcmec.run(args), "No further issues to mitigate!");
            for(int i = 0; i<PASSES-1; i++) Mcmec.run(args);
            Assert.assertEquals(Mcmec.run(args), "No further issues to mitigate!");
        }
    }
}
