package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import eu.modelwriter.traceability.validation.core.fol.Utilities;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ImplicationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;

public class ImplicationTransformer extends FOLBaseVisitor<Object> {

  @Override
  public Object visitImplication(ImplicationContext ctx) {
    DisjunctionContext disjunctionContext = implicationTransform(ctx);
    Utilities.moveUp(ctx, disjunctionContext);
    return super.visitImplication(ctx);
  }

  private DisjunctionContext implicationTransform(ImplicationContext ctx) {

    ExprContext leftContext;
    ExprContext rightContext = ctx.right;
    ParenthesesContext parenthesesContext;

    if (ctx.left instanceof NegationContext) {
      leftContext = ((NegationContext) ctx.left).expr();
    } else {
      parenthesesContext = Utilities.createParenthesesContext(ctx.left);
      leftContext = Utilities.createNegationContext(parenthesesContext);
    }

    return Utilities.createDisjunctionContext(leftContext, rightContext);
  }

}
