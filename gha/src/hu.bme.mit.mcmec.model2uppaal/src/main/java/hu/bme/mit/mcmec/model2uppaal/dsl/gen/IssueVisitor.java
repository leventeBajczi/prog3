// Generated from Issue.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.model2uppaal.dsl.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IssueParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IssueVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IssueParser#issues}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIssues(IssueParser.IssuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link IssueParser#issue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIssue(IssueParser.IssueContext ctx);
	/**
	 * Visit a parse tree produced by {@link IssueParser#threads}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreads(IssueParser.ThreadsContext ctx);
	/**
	 * Visit a parse tree produced by {@link IssueParser#thread}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThread(IssueParser.ThreadContext ctx);
	/**
	 * Visit a parse tree produced by {@link IssueParser#io}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIo(IssueParser.IoContext ctx);
}