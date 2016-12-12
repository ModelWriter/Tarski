// Generated from C:/Users/Mete/IdeaProjects/TestJavaProject/src/kodkod\Arithmetic.g4 by ANTLR 4.5.1
package eu.modelwriter.core.arithmetic.example;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticParser}.
 */
public interface ArithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ArithmeticParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ArithmeticParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ArithmeticParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ArithmeticParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ArithmeticParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ArithmeticParser.ExprContext ctx);
}