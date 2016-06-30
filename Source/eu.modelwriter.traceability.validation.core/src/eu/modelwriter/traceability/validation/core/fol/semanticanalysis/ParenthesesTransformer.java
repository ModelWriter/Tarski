package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import eu.modelwriter.traceability.validation.core.fol.Utilities;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;

public class ParenthesesTransformer extends FOLBaseVisitor<Object> {

  /**
   * Removing excess parentheses.
   */
  @Override
  public Object visitParentheses(final ParenthesesContext ctx) {
    final ExprContext child = ctx.expr();
    Utilities.moveUp(ctx, child);
    return super.visitParentheses(ctx);
  }
}
