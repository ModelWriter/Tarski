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

  @Override
  public Object visitNegation(NegationContext ctx) {
    if (ctx.expr() instanceof ParenthesesContext) {
      negationOnParentheses(ctx);
    } else if (ctx.expr() instanceof NegationContext) {
      if (((NegationContext) ctx.expr()).expr() instanceof NegationContext)
        visitNegation((NegationContext) ((NegationContext) ctx.expr()).expr());
      Utilities.moveUp(ctx, ((NegationContext) ctx.expr()).expr());
    }
    return super.visitNegation(new NegationContext(new ExprContext()));
  }

  private ExprContext negationOnParentheses(NegationContext ctx) {
    ExprContext newExprContext = negationTransformer(((ParenthesesContext) ctx.expr()).expr());
    newExprContext.parent = ctx.expr();
    ((ParenthesesContext) ctx.expr()).children.remove(1);
    ((ParenthesesContext) ctx.expr()).children.add(1, newExprContext);

    ExprContext child = ctx.expr();
    Utilities.moveUp(ctx, child);
    return newExprContext;
  }

  private ExprContext negationTransformer(ExprContext expr) {
    if (expr instanceof DisjunctionContext) {
      return negationOnDisjunction((DisjunctionContext) expr);
    } else if (expr instanceof ConjunctionContext) {
      return negationOnConjunction((ConjunctionContext) expr);
    } else if (expr instanceof NegationContext) {
      return reverse((NegationContext) expr);
    } else if (expr instanceof RelationContext) {
      return Utilities.createNegationContext((RelationContext) expr);
    } else if (expr instanceof ParenthesesContext) {
      return negationTransformer(((ParenthesesContext) expr).expr());
    }
    return null;
  }

  private ExprContext reverse(NegationContext expr) {
    return expr.expr();
  }

  private ExprContext negationOnDisjunction(DisjunctionContext expr) {
    ExprContext leftNegationContext;
    ExprContext rightNegationContext;

    if (!(expr.left instanceof RelationContext)) {
      leftNegationContext = negationTransformer(expr.left);
    } else {
      leftNegationContext = Utilities.createNegationContext(expr.left);
    }

    if (!(expr.right instanceof RelationContext)) {
      rightNegationContext = negationTransformer(expr.right);
    } else {
      rightNegationContext = Utilities.createNegationContext(expr.right);
    }

    return Utilities.createConjunctionContext(leftNegationContext, rightNegationContext);
  }

  private ExprContext negationOnConjunction(ConjunctionContext expr) {
    ExprContext leftNegationContext;
    ExprContext rightNegationContext;

    if (!(expr.left instanceof RelationContext)) {
      leftNegationContext = negationTransformer(expr.left);
    } else {
      leftNegationContext = Utilities.createNegationContext(expr.left);
    }

    if (!(expr.right instanceof RelationContext)) {
      rightNegationContext = negationTransformer(expr.right);
    } else {
      rightNegationContext = Utilities.createNegationContext(expr.right);
    }

    return Utilities.createDisjunctionContext(leftNegationContext, rightNegationContext);
  }

}
