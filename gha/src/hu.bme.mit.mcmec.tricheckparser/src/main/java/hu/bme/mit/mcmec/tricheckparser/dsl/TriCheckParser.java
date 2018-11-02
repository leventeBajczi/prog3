package hu.bme.mit.mcmec.tricheckparser.dsl;


import hu.bme.mit.mcmec.tricheckparser.dsl.gen.*;
import org.antlr.v4.runtime.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * The type Tri check parser.
 */
public class TriCheckParser {

    private static String textOut;
    private static int counter = 0;

    /**
     * Parse litmus into query.
     *
     * @param litmusDirectory the litmus directory
     * @param outFile         the out file
     */
    public static void parseLitmusIntoQuery(String litmusDirectory, String outFile) {
        counter = 0;
        textOut = "";
        for(File f : (new File(litmusDirectory).listFiles()))
        {
            if(!f.toString().endsWith(".litmus"))
                continue;
            ANTLRInputStream inputStream = null;
            try {
                inputStream = new ANTLRFileStream(f.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            TriCheckLitmusLexer triCheckLitmusLexer = new TriCheckLitmusLexer(inputStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(triCheckLitmusLexer);
            TriCheckLitmusParser triCheckLitmusParser = new TriCheckLitmusParser(commonTokenStream);
            TriCheckLitmusParser.LitmusContext fileContext = triCheckLitmusParser.litmus();

            MyTriCheckLitmusVisitor myTriCheckLitmusVisitor = new MyTriCheckLitmusVisitor();
            myTriCheckLitmusVisitor.visit(fileContext);

            myTriCheckLitmusVisitor.threads.forEach(TriCheckParser::print);

        }
        File fOut = new File(outFile);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fOut);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textOut);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private static void print(String key, List<String> value)
    {
        textOut = textOut.concat("issue tricheck_").concat("" + counter++).concat(" { ");
        value.forEach(s -> textOut = textOut.concat(s).concat(value.get(value.size() -1) == s ? "" : " : "));
        textOut = textOut.concat(" } \n\n");
    }
}

/**
 * The type My tri check litmus visitor.
 */
class MyTriCheckLitmusVisitor extends TriCheckLitmusBaseVisitor
{
    /**
     * The Lines.
     */
    List<String> lines;
    /**
     * The Threads.
     */
    Map<String, List<String>>  threads;

    /**
     * Instantiates a new My tri check litmus visitor.
     */
    public MyTriCheckLitmusVisitor()
    {
        lines = new ArrayList<>();
        threads = new HashMap<>();
    }

    /**
     * Visit threads object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitThreads(TriCheckLitmusParser.ThreadsContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit thread object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitThread(TriCheckLitmusParser.ThreadContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit line object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitLine(TriCheckLitmusParser.LineContext ctx) {

        String text = "";



        if(ctx.RELAXED() != null)
            text = text.concat("relaxed ");
        else if(ctx.RELEASE() != null)
            text = text.concat("release ");
        else if(ctx.ACQUIRE() != null)
            text = text.concat("acquire ");
        else if(ctx.SEQ_CST() != null)
            text = text.concat("seq_cst ");

        if(ctx.LOAD() != null)
            text = text.concat("load");
        else if(ctx.STORE() != null)
            text = text.concat("store");

        if(threads.containsKey(ctx.RICHTEXT(ctx.RICHTEXT().size() - 1).toString()))
        {
            threads.get(ctx.RICHTEXT(ctx.RICHTEXT().size() - 1).toString()).add(text);
        }

        else
        {
            threads.put(ctx.RICHTEXT(ctx.RICHTEXT().size() - 1).toString(), new ArrayList<>());
            threads.get(ctx.RICHTEXT(ctx.RICHTEXT().size() - 1).toString()).add(text);
        }


        return visitChildren(ctx);
    }




}