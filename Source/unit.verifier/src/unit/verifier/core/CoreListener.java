// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package unit.verifier.core;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link CoreParser}.
 */
public interface CoreListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link CoreParser#binaryOp}.
   * 
   * @param ctx the parse tree
   */
  void enterBinaryOp(CoreParser.BinaryOpContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void enterExpr(CoreParser.ExprContext ctx);

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
   * Enter a parse tree produced by {@link CoreParser#sentence}.
   * 
   * @param ctx the parse tree
   */
  void enterSentence(CoreParser.SentenceContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#set}.
   * 
   * @param ctx the parse tree
   */
  void enterSet(CoreParser.SetContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   */
  void enterSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#tuple}.
   * 
   * @param ctx the parse tree
   */
  void enterTuple(CoreParser.TupleContext ctx);

  /**
   * Enter a parse tree produced by {@link CoreParser#unaryOp}.
   * 
   * @param ctx the parse tree
   */
  void enterUnaryOp(CoreParser.UnaryOpContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#binaryOp}.
   * 
   * @param ctx the parse tree
   */
  void exitBinaryOp(CoreParser.BinaryOpContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#expr}.
   * 
   * @param ctx the parse tree
   */
  void exitExpr(CoreParser.ExprContext ctx);

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
   * Exit a parse tree produced by {@link CoreParser#sentence}.
   * 
   * @param ctx the parse tree
   */
  void exitSentence(CoreParser.SentenceContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#set}.
   * 
   * @param ctx the parse tree
   */
  void exitSet(CoreParser.SetContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#specification}.
   * 
   * @param ctx the parse tree
   */
  void exitSpecification(CoreParser.SpecificationContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#tuple}.
   * 
   * @param ctx the parse tree
   */
  void exitTuple(CoreParser.TupleContext ctx);

  /**
   * Exit a parse tree produced by {@link CoreParser#unaryOp}.
   * 
   * @param ctx the parse tree
   */
  void exitUnaryOp(CoreParser.UnaryOpContext ctx);
}
