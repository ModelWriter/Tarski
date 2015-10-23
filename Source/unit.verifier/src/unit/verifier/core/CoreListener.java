// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package unit.verifier.core;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link CoreParser}.
 */
public interface CoreListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link CoreParser#arity}.
   * 
   * @param ctx the parse tree
   */
  void enterArity(CoreParser.ArityContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#binaryOperation}.
   * 
   * @param ctx the parse tree
   */
  void enterBinaryOperation(CoreParser.BinaryOperationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#declaration}.
   * 
   * @param ctx the parse tree
   */
  void enterDeclaration(CoreParser.DeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#expression}.
   * 
   * @param ctx the parse tree
   */
  void enterExpression(CoreParser.ExpressionContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#formula}.
   * 
   * @param ctx the parse tree
   */
  void enterFormula(CoreParser.FormulaContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#innerDeclaration}.
   * 
   * @param ctx the parse tree
   */
  void enterInnerDeclaration(CoreParser.InnerDeclarationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#model}.
   * 
   * @param ctx the parse tree
   */
  void enterModel(CoreParser.ModelContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#models}.
   * 
   * @param ctx the parse tree
   */
  void enterModels(CoreParser.ModelsContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#quantification}.
   * 
   * @param ctx the parse tree
   */
  void enterQuantification(CoreParser.QuantificationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#relation}.
   * 
   * @param ctx the parse tree
   */
  void enterRelation(CoreParser.RelationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#sentences}.
   * 
   * @param ctx the parse tree
   */
  void enterSentences(CoreParser.SentencesContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   */
  void enterSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#unaryOperation}.
   * 
   * @param ctx the parse tree
   */
  void enterUnaryOperation(CoreParser.UnaryOperationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#arity}.
   * 
   * @param ctx the parse tree
   */
  void exitArity(CoreParser.ArityContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#binaryOperation}.
   * 
   * @param ctx the parse tree
   */
  void exitBinaryOperation(CoreParser.BinaryOperationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#declaration}.
   * 
   * @param ctx the parse tree
   */
  void exitDeclaration(CoreParser.DeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#expression}.
   * 
   * @param ctx the parse tree
   */
  void exitExpression(CoreParser.ExpressionContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#formula}.
   * 
   * @param ctx the parse tree
   */
  void exitFormula(CoreParser.FormulaContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#innerDeclaration}.
   * 
   * @param ctx the parse tree
   */
  void exitInnerDeclaration(CoreParser.InnerDeclarationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#model}.
   * 
   * @param ctx the parse tree
   */
  void exitModel(CoreParser.ModelContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#models}.
   * 
   * @param ctx the parse tree
   */
  void exitModels(CoreParser.ModelsContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#quantification}.
   * 
   * @param ctx the parse tree
   */
  void exitQuantification(CoreParser.QuantificationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#relation}.
   * 
   * @param ctx the parse tree
   */
  void exitRelation(CoreParser.RelationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#sentences}.
   * 
   * @param ctx the parse tree
   */
  void exitSentences(CoreParser.SentencesContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   */
  void exitSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#unaryOperation}.
   * 
   * @param ctx the parse tree
   */
  void exitUnaryOperation(CoreParser.UnaryOperationContext ctx);
}
