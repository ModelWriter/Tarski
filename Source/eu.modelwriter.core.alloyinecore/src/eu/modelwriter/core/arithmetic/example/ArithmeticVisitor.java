// Generated from C:/Users/Mete/IdeaProjects/TestJavaProject/src/kodkod\Arithmetic.g4 by ANTLR 4.5.1
package eu.modelwriter.core.arithmetic.example;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ArithmeticParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(ArithmeticParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ArithmeticParser.ExprContext ctx);
}