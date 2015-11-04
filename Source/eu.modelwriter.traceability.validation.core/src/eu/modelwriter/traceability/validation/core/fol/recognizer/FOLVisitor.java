// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\FOL.g4 by ANTLR 4.5.1
package eu.modelwriter.traceability.validation.core.fol.recognizer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FOLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FOLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FOLParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(FOLParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(FOLParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuple(FOLParser.TupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(FOLParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentheses}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(FOLParser.ParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negation}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(FOLParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code quantification}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantification(FOLParser.QuantificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conjunction}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(FOLParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disjunction}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(FOLParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implication}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplication(FOLParser.ImplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equivalance}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalance(FOLParser.EquivalanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relation}
	 * labeled alternative in {@link FOLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelation(FOLParser.RelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FOLParser#quantifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantifier(FOLParser.QuantifierContext ctx);
}