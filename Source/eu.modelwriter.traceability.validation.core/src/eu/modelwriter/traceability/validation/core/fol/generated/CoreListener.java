package eu.modelwriter.traceability.validation.core.fol.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link CoreParser}.
 */
public interface CoreListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   */
  void enterSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   */
  void exitSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#set}.
   * 
   * @param ctx the parse tree
   */
  void enterSet(CoreParser.SetContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#set}.
   * 
   * @param ctx the parse tree
   */
  void exitSet(CoreParser.SetContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#tuple}.
   * 
   * @param ctx the parse tree
   */
  void enterTuple(CoreParser.TupleContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#tuple}.
   * 
   * @param ctx the parse tree
   */
  void exitTuple(CoreParser.TupleContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#sentence}.
   * 
   * @param ctx the parse tree
   */
  void enterSentence(CoreParser.SentenceContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#sentence}.
   * 
   * @param ctx the parse tree
   */
  void exitSentence(CoreParser.SentenceContext ctx);

  /**
   * Enter a parse tree produced by the {@code parentheses} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterParentheses(CoreParser.ParenthesesContext ctx);

  /**
   * Exit a parse tree produced by the {@code parentheses} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitParentheses(CoreParser.ParenthesesContext ctx);

  /**
   * Enter a parse tree produced by the {@code negation} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterNegation(CoreParser.NegationContext ctx);

  /**
   * Exit a parse tree produced by the {@code negation} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitNegation(CoreParser.NegationContext ctx);

  /**
   * Enter a parse tree produced by the {@code quantification} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterQuantification(CoreParser.QuantificationContext ctx);

  /**
   * Exit a parse tree produced by the {@code quantification} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitQuantification(CoreParser.QuantificationContext ctx);

  /**
   * Enter a parse tree produced by the {@code conjunction} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterConjunction(CoreParser.ConjunctionContext ctx);

  /**
   * Exit a parse tree produced by the {@code conjunction} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitConjunction(CoreParser.ConjunctionContext ctx);

  /**
   * Enter a parse tree produced by the {@code disjunction} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterDisjunction(CoreParser.DisjunctionContext ctx);

  /**
   * Exit a parse tree produced by the {@code disjunction} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitDisjunction(CoreParser.DisjunctionContext ctx);

  /**
   * Enter a parse tree produced by the {@code implication} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterImplication(CoreParser.ImplicationContext ctx);

  /**
   * Exit a parse tree produced by the {@code implication} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitImplication(CoreParser.ImplicationContext ctx);

  /**
   * Enter a parse tree produced by the {@code equivalance} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterEquivalance(CoreParser.EquivalanceContext ctx);

  /**
   * Exit a parse tree produced by the {@code equivalance} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitEquivalance(CoreParser.EquivalanceContext ctx);

  /**
   * Enter a parse tree produced by the {@code relation} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterRelation(CoreParser.RelationContext ctx);

  /**
   * Exit a parse tree produced by the {@code relation} labeled alternative in
   * {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitRelation(CoreParser.RelationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#quantifer}.
   * 
   * @param ctx the parse tree
   */
  void enterQuantifer(CoreParser.QuantiferContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#quantifer}.
   * 
   * @param ctx the parse tree
   */
  void exitQuantifer(CoreParser.QuantiferContext ctx);
}
