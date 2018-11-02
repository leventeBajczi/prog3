package hu.bme.mit.mcmec.c2xta;

import hu.bme.mit.mcmec.c2xta.c.MyCVisitor;
import hu.bme.mit.mcmec.c2xta.gen.CLexer;
import hu.bme.mit.mcmec.c2xta.gen.CParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;


/*
Constraints:
    - one source file
    - one function per thread without parameter passing (use globals)
    - global mutex and conditional variables
    - atomics are global and declared like `_Atomic <typeSpecifier> <variableName>`, not `_Atomic(<typeSpecifier>) <variableName>`
    - atomics can only be signed integers
 */


/**
 * The type C 2 xta.
 */
public class C2Xta {

    /**
     * Transform.
     *
     * @param sourceName the source name
     * @param outName    the out name
     */
    public static void transform(String sourceName, String outName) {
        C2Xta c2Xta = new C2Xta();
        c2Xta.run(new File(sourceName), new File(outName));
    }

    /**
     * Run.
     *
     * @param source the source
     * @param out    the out
     */
    public void run(File source, File out)
    {

        ANTLRInputStream antlrInputStream = null;
        try {
            InputStream inputStream = new FileInputStream(source);
            antlrInputStream = new ANTLRInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CLexer cLexer = new CLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(cLexer);
        CParser cParser = new CParser(commonTokenStream);
        CParser.CompilationUnitContext fileContext = cParser.compilationUnit();
        MyCVisitor myCVisitor = new MyCVisitor();
        myCVisitor.visit(fileContext);

        try {
            FileWriter fileWriter = new FileWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(myCVisitor.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
