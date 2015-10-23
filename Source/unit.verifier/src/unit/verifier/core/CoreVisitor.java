// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package unit.verifier.core;

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
   * Visit a parse tree produced by {@link CoreParser#arity}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArity(CoreParser.ArityContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#binaryOperation}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBinaryOperation(CoreParser.BinaryOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#declaration}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDeclaration(CoreParser.DeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#expression}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(CoreParser.ExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#formula}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFormula(CoreParser.FormulaContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#innerDeclaration}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInnerDeclaration(CoreParser.InnerDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#model}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModel(CoreParser.ModelContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#models}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModels(CoreParser.ModelsContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#quantification}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitQuantification(CoreParser.QuantificationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#relation}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRelation(CoreParser.RelationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#sentences}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSentences(CoreParser.SentencesContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Visit a parse tree produced by {@link CoreParser#unaryOperation}.
   * 
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnaryOperation(CoreParser.UnaryOperationContext ctx);
}
