package eu.modelwriter.traceability.validation.core;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link CoreParser}
 * .
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *        type.
 */
public interface CoreVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#set}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSet(CoreParser.SetContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#tuple}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTuple(CoreParser.TupleContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#sentence}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSentence(CoreParser.SentenceContext ctx);

  /**
   * Visit a parse tree produced by the {@code parentheses} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParentheses(CoreParser.ParenthesesContext ctx);

  /**
   * Visit a parse tree produced by the {@code negation} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNegation(CoreParser.NegationContext ctx);

  /**
   * Visit a parse tree produced by the {@code quantification} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQuantification(CoreParser.QuantificationContext ctx);

  /**
   * Visit a parse tree produced by the {@code conjunction} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConjunction(CoreParser.ConjunctionContext ctx);

  /**
   * Visit a parse tree produced by the {@code disjunction} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDisjunction(CoreParser.DisjunctionContext ctx);

  /**
   * Visit a parse tree produced by the {@code implication} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImplication(CoreParser.ImplicationContext ctx);

  /**
   * Visit a parse tree produced by the {@code equivalance} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEquivalance(CoreParser.EquivalanceContext ctx);

  /**
   * Visit a parse tree produced by the {@code relation} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRelation(CoreParser.RelationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#quantifer}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQuantifer(CoreParser.QuantiferContext ctx);
}
