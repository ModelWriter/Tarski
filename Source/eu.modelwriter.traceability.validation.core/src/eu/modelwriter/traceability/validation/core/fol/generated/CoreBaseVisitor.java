// Generated from C:/Users/emre.kirmizi/IdeaProjects/Core/src/Antlr\Core.g4 by ANTLR 4.5.1
package eu.modelwriter.traceability.validation.core.fol.generated;

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
  public T visitConjunction(CoreParser.ConjunctionContext ctx) {
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
  public T visitDisjunction(CoreParser.DisjunctionContext ctx) {
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
  public T visitEquivalance(CoreParser.EquivalanceContext ctx) {
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
  public T visitImplication(CoreParser.ImplicationContext ctx) {
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
  public T visitNegation(CoreParser.NegationContext ctx) {
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
  public T visitParentheses(CoreParser.ParenthesesContext ctx) {
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
  public T visitQuantifer(CoreParser.QuantiferContext ctx) {
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
  public T visitSentence(CoreParser.SentenceContext ctx) {
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
  public T visitSet(CoreParser.SetContext ctx) {
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
  public T visitTuple(CoreParser.TupleContext ctx) {
    return this.visitChildren(ctx);
  }
}
