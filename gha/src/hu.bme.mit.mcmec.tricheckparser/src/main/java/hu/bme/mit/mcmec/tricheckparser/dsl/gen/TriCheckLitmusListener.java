// Generated from TriCheckLitmus.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.tricheckparser.dsl.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TriCheckLitmusParser}.
 */
public interface TriCheckLitmusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#litmus}.
	 * @param ctx the parse tree
	 */
	void enterLitmus(TriCheckLitmusParser.LitmusContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#litmus}.
	 * @param ctx the parse tree
	 */
	void exitLitmus(TriCheckLitmusParser.LitmusContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#preliminary}.
	 * @param ctx the parse tree
	 */
	void enterPreliminary(TriCheckLitmusParser.PreliminaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#preliminary}.
	 * @param ctx the parse tree
	 */
	void exitPreliminary(TriCheckLitmusParser.PreliminaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#variables}.
	 * @param ctx the parse tree
	 */
	void enterVariables(TriCheckLitmusParser.VariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#variables}.
	 * @param ctx the parse tree
	 */
	void exitVariables(TriCheckLitmusParser.VariablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#threads}.
	 * @param ctx the parse tree
	 */
	void enterThreads(TriCheckLitmusParser.ThreadsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#threads}.
	 * @param ctx the parse tree
	 */
	void exitThreads(TriCheckLitmusParser.ThreadsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(TriCheckLitmusParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(TriCheckLitmusParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TriCheckLitmusParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TriCheckLitmusParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#thread}.
	 * @param ctx the parse tree
	 */
	void enterThread(TriCheckLitmusParser.ThreadContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#thread}.
	 * @param ctx the parse tree
	 */
	void exitThread(TriCheckLitmusParser.ThreadContext ctx);
	/**
	 * Enter a parse tree produced by {@link TriCheckLitmusParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(TriCheckLitmusParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link TriCheckLitmusParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(TriCheckLitmusParser.LineContext ctx);
}