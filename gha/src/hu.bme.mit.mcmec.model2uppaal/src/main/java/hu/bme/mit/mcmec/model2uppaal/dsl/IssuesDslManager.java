package hu.bme.mit.mcmec.model2uppaal.dsl;

import hu.bme.mit.mcmec.model2uppaal.dsl.gen.IssueLexer;
import hu.bme.mit.mcmec.model2uppaal.dsl.gen.IssueParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * The type Issues dsl manager.
 */
public class IssuesDslManager {

    /**
     * Parse issues map.
     *
     * @param inputStream the input stream
     * @return the map
     */
    public static Map<String, List<String>> parseIssues(InputStream inputStream) {
        ANTLRInputStream antlrInputStream = null;
        try {
            antlrInputStream = new ANTLRInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        IssueLexer issueLexer = new IssueLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(issueLexer);
        IssueParser issueParser = new IssueParser(commonTokenStream);
        IssueParser.IssuesContext fileContext = issueParser.issues();
        MyIssueVisitor myIssueVisitor = new MyIssueVisitor();
        myIssueVisitor.visit(fileContext);
        return myIssueVisitor.getIssueList();
    }
}
