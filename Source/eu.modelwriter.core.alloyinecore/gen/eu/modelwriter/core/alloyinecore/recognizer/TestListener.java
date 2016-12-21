// Generated from /home/ferhat/IdeaProjects/eu.modelwriter.core.alloyinecore/src/eu/modelwriter/core/alloyinecore/recognizer/Test.g4 by ANTLR 4.6
package eu.modelwriter.core.alloyinecore.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(TestParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(TestParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equal}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterEqual(TestParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitEqual(TestParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code in}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterIn(TestParser.InContext ctx);
	/**
	 * Exit a parse tree produced by the {@code in}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitIn(TestParser.InContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterAnd(TestParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitAnd(TestParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paranthesis}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void enterParanthesis(TestParser.ParanthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paranthesis}
	 * labeled alternative in {@link TestParser#formula}.
	 * @param ctx the parse tree
	 */
	void exitParanthesis(TestParser.ParanthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pexpression}
	 * labeled alternative in {@link TestParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPexpression(TestParser.PexpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pexpression}
	 * labeled alternative in {@link TestParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPexpression(TestParser.PexpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code union}
	 * labeled alternative in {@link TestParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnion(TestParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code union}
	 * labeled alternative in {@link TestParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnion(TestParser.UnionContext ctx);
}