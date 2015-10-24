// Generated from C:/Users/Mete/IdeaProjects/TestJavaProject/src\Core.g4 by ANTLR 4.5.1
package unit.verifier.core;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CoreParser}.
 */
public interface CoreListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CoreParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(CoreParser.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(CoreParser.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(CoreParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(CoreParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(CoreParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(CoreParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(CoreParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(CoreParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantified}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterQuantified(CoreParser.QuantifiedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantified}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitQuantified(CoreParser.QuantifiedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scope}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterScope(CoreParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scope}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitScope(CoreParser.ScopeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binary}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary(CoreParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binary}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary(CoreParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ground}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGround(CoreParser.GroundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ground}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGround(CoreParser.GroundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary(CoreParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary}
	 * labeled alternative in {@link CoreParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary(CoreParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(CoreParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(CoreParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#quantification}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(CoreParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#quantification}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(CoreParser.QuantificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(CoreParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(CoreParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(CoreParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(CoreParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoreParser#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperation(CoreParser.UnaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoreParser#unaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperation(CoreParser.UnaryOperationContext ctx);
}