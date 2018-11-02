package hu.bme.mit.mcmec.model2uppaal.dsl;


import hu.bme.mit.mcmec.model2uppaal.dsl.gen.IssueBaseVisitor;
import hu.bme.mit.mcmec.model2uppaal.dsl.gen.IssueParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type My issue visitor.
 */
public class MyIssueVisitor extends IssueBaseVisitor {
    private Map<String, List<String>> issueList;

    /**
     * Instantiates a new My issue visitor.
     */
    MyIssueVisitor()
    {
        issueList = new HashMap<>();
    }

    /**
     * Visit issue object.
     *
     * @param ctx the ctx
     * @return the object
     */
    @Override
    public Object visitIssue(IssueParser.IssueContext ctx) {
        List<String> issueTuple = new ArrayList<>();
        ctx.threads().thread().forEach(threadContext -> threadContext.io().forEach(ioContext -> fillTuple(issueTuple, ioContext)));
        issueList.put(ctx.NAME().toString(),issueTuple);
        return super.visitIssue(ctx);
    }

    private void fillTuple(List<String> issueTuple, IssueParser.IoContext ioContext) {
        String representation = new String("");
        if(ioContext.RELA() != null)
            representation = representation.concat("relaxed");
        else if(ioContext.RELE() != null)
            representation = representation.concat("release");
        else if(ioContext.ACQ() != null)
            representation = representation.concat("acquire");
        else if(ioContext.SEQ() != null)
            representation = representation.concat("seq_cst");

        if(ioContext.LOAD() != null)
            representation = representation.concat(" load");
        else if(ioContext.STORE() != null)
            representation = representation.concat(" store");

        issueTuple.add(representation);

    }

    /**
     * Gets issue list.
     *
     * @return the issue list
     */
    public Map<String, List<String>> getIssueList() {
        return issueList;
    }
}
