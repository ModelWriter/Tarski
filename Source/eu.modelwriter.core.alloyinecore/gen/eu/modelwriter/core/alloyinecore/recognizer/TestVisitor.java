// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/eu/modelwriter/core/alloyinecore/recognizer/Test.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(TestParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code in}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIn(TestParser.InContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(TestParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link TestParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(TestParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code union}
	 * labeled alternative in {@link TestParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(TestParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(TestParser.VariableContext ctx);
}