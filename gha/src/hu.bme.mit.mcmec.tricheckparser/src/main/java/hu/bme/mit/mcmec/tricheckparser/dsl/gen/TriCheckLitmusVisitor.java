// Generated from TriCheckLitmus.g4 by ANTLR 4.5.3
package hu.bme.mit.mcmec.tricheckparser.dsl.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TriCheckLitmusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TriCheckLitmusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#litmus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitmus(TriCheckLitmusParser.LitmusContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#preliminary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreliminary(TriCheckLitmusParser.PreliminaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(TriCheckLitmusParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#threads}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThreads(TriCheckLitmusParser.ThreadsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(TriCheckLitmusParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TriCheckLitmusParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#thread}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThread(TriCheckLitmusParser.ThreadContext ctx);
	/**
	 * Visit a parse tree produced by {@link TriCheckLitmusParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(TriCheckLitmusParser.LineContext ctx);
}