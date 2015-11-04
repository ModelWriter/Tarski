// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\FOL.g4 by ANTLR 4.5.1
package eu.modelwriter.traceability.validation.core.fol.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FOLParser}.
 */
public interface FOLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FOLParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(FOLParser.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(FOLParser.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(FOLParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(FOLParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#tuple}.
	 * @param ctx the parse tree
	 */
	void enterTuple(FOLParser.TupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#tuple}.
	 * @param ctx the parse tree
	 */
	void exitTuple(FOLParser.TupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(FOLParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(FOLParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(FOLParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(FOLParser.ParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negation}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegation(FOLParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegation(FOLParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quantification}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterQuantification(FOLParser.QuantificationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quantification}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitQuantification(FOLParser.QuantificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(FOLParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(FOLParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code disjunction}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(FOLParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code disjunction}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(FOLParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implication}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterImplication(FOLParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implication}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitImplication(FOLParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equivalance}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquivalance(FOLParser.EquivalanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equivalance}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquivalance(FOLParser.EquivalanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relation}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelation(FOLParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relation}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelation(FOLParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link FOLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(FOLParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FOLParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(FOLParser.QuantifierContext ctx);
}