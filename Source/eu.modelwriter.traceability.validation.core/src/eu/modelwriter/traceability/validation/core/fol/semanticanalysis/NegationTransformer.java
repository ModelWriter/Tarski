package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import eu.modelwriter.traceability.validation.core.fol.Utilities;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;

public class NegationTransformer extends FOLBaseVisitor<Object> {

  /**
   * Converting negative conjunction expression to disjunction expression with De Morgan's Law.
   */
  private ExprContext negationOnConjunction(final ConjunctionContext expr) {
    ExprContext leftNegationContext;
    ExprContext rightNegationContext;

    if (!(expr.left instanceof RelationContext)) {
      leftNegationContext = this.negationTransformer(expr.left);
    } else {
      leftNegationContext = Utilities.createNegationContext(expr.left);
    }

    if (!(expr.right instanceof RelationContext)) {
      rightNegationContext = this.negationTransformer(expr.right);
    } else {
      rightNegationContext = Utilities.createNegationContext(expr.right);
    }

    return Utilities.createDisjunctionContext(leftNegationContext, rightNegationContext);
  }

  /**
   * Converting negative disjunction expression to conjunction expression with De Morgan's Law.
   */
  private ExprContext negationOnDisjunction(final DisjunctionContext expr) {
    ExprContext leftNegationContext;
    ExprContext rightNegationContext;

    if (!(expr.left instanceof RelationContext)) {
      leftNegationContext = this.negationTransformer(expr.left);
    } else {
      leftNegationContext = Utilities.createNegationContext(expr.left);
    }

    if (!(expr.right instanceof RelationContext)) {
      rightNegationContext = this.negationTransformer(expr.right);
    } else {
      rightNegationContext = Utilities.createNegationContext(expr.right);
    }

    return Utilities.createConjunctionContext(leftNegationContext, rightNegationContext);
  }

  /**
   * Applying De Morgan's Law for parentheses expressions.
   */
  private ExprContext negationOnParentheses(final NegationContext ctx) {
    final ExprContext newExprContext =
        this.negationTransformer(((ParenthesesContext) ctx.expr()).expr());
    newExprContext.parent = ctx.expr();
    ((ParenthesesContext) ctx.expr()).children.remove(1);
    ((ParenthesesContext) ctx.expr()).children.add(1, newExprContext);

    final ExprContext child = ctx.expr();
    Utilities.moveUp(ctx, child);
    return newExprContext;
  }

  /**
   * Applying conversion rules based on type of expression.
   */
  private ExprContext negationTransformer(final ExprContext expr) {
    if (expr instanceof DisjunctionContext) {
      return this.negationOnDisjunction((DisjunctionContext) expr);
    } else if (expr instanceof ConjunctionContext) {
      return this.negationOnConjunction((ConjunctionContext) expr);
    } else if (expr instanceof NegationContext) {
      return this.reverse((NegationContext) expr);
    } else if (expr instanceof RelationContext) {
      return Utilities.createNegationContext(expr);
    } else if (expr instanceof ParenthesesContext) {
      return this.negationTransformer(((ParenthesesContext) expr).expr());
    }
    return null;
  }

  private ExprContext reverse(final NegationContext expr) {
    return expr.expr();
  }

  /**
   * Simplify negation expression.
   */
  @Override
  public Object visitNegation(final NegationContext ctx) {
    if (ctx.expr() instanceof ParenthesesContext) {
      // De Morgan's Law
      this.negationOnParentheses(ctx);
    } else if (ctx.expr() instanceof NegationContext) {
      // double negation elimination
      if (((NegationContext) ctx.expr()).expr() instanceof NegationContext) {
        this.visitNegation((NegationContext) ((NegationContext) ctx.expr()).expr());
      }
      Utilities.moveUp(ctx, ((NegationContext) ctx.expr()).expr());
    }
    return super.visitNegation(new NegationContext(new ExprContext()));
  }

}
