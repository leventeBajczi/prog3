// Generated from Issue.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.model2uppaal.dsl.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IssueParser}.
 */
public interface IssueListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IssueParser#issues}.
	 * @param ctx the parse tree
	 */
	void enterIssues(IssueParser.IssuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link IssueParser#issues}.
	 * @param ctx the parse tree
	 */
	void exitIssues(IssueParser.IssuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link IssueParser#issue}.
	 * @param ctx the parse tree
	 */
	void enterIssue(IssueParser.IssueContext ctx);
	/**
	 * Exit a parse tree produced by {@link IssueParser#issue}.
	 * @param ctx the parse tree
	 */
	void exitIssue(IssueParser.IssueContext ctx);
	/**
	 * Enter a parse tree produced by {@link IssueParser#threads}.
	 * @param ctx the parse tree
	 */
	void enterThreads(IssueParser.ThreadsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IssueParser#threads}.
	 * @param ctx the parse tree
	 */
	void exitThreads(IssueParser.ThreadsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IssueParser#thread}.
	 * @param ctx the parse tree
	 */
	void enterThread(IssueParser.ThreadContext ctx);
	/**
	 * Exit a parse tree produced by {@link IssueParser#thread}.
	 * @param ctx the parse tree
	 */
	void exitThread(IssueParser.ThreadContext ctx);
	/**
	 * Enter a parse tree produced by {@link IssueParser#io}.
	 * @param ctx the parse tree
	 */
	void enterIo(IssueParser.IoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IssueParser#io}.
	 * @param ctx the parse tree
	 */
	void exitIo(IssueParser.IoContext ctx);
}