package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import eu.modelwriter.traceability.validation.core.fol.Utilities;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ImplicationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;

public class ImplicationTransformer extends FOLBaseVisitor<Object> {

  /**
   * According to Implication Elimination Rule, implication expressions converting to disjunction
   * statement.
   */
  private DisjunctionContext implicationTransform(final ImplicationContext ctx) {

    ExprContext leftContext;
    final ExprContext rightContext = ctx.right;
    ParenthesesContext parenthesesContext;

    // If expression is negative expression, getting expression in negation context.
    if (ctx.left instanceof NegationContext) {
      leftContext = ((NegationContext) ctx.left).expr();
    } else {
      // If expression is not negative expression, adding parentheses for priorities of expressions.
      parenthesesContext = Utilities.createParenthesesContext(ctx.left);
      leftContext = Utilities.createNegationContext(parenthesesContext);
    }

    return Utilities.createDisjunctionContext(leftContext, rightContext);
  }

  @Override
  public Object visitImplication(final ImplicationContext ctx) {
    final DisjunctionContext disjunctionContext = this.implicationTransform(ctx);
    Utilities.moveUp(ctx, disjunctionContext);
    return super.visitImplication(ctx);
  }

}
