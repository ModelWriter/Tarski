// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package unit.verifier.core;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link CoreVisitor}, which can be extended to
 * create a visitor which only needs to handle a subset of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *        type.
 */
public class CoreBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements CoreVisitor<T> {
  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitArity(CoreParser.ArityContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitBinaryOperation(CoreParser.BinaryOperationContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitDeclaration(CoreParser.DeclarationContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitExpression(CoreParser.ExpressionContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitFormula(CoreParser.FormulaContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitInnerDeclaration(CoreParser.InnerDeclarationContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitModel(CoreParser.ModelContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitModels(CoreParser.ModelsContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitQuantification(CoreParser.QuantificationContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitRelation(CoreParser.RelationContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitSentences(CoreParser.SentencesContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitSpecification(CoreParser.SpecificationContext ctx) {
    return this.visitChildren(ctx);
  }

  /**
   * {@inheritDoc}
   *
   * <p>
   * The default implementation returns the result of calling {@link #visitChildren} on {@code ctx}.
   * </p>
   */
  @Override
  public T visitUnaryOperation(CoreParser.UnaryOperationContext ctx) {
    return this.visitChildren(ctx);
  }
}
