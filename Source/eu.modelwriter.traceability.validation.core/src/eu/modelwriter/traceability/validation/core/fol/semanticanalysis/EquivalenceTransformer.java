package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import eu.modelwriter.traceability.validation.core.fol.Utilities;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.EquivalenceContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;

public class EquivalenceTransformer extends FOLBaseVisitor<Object> {

  @Override
  public Object visitEquivalence(EquivalenceContext ctx) {
    ConjunctionContext conjunctionContext = equivalenceTransform(ctx);
    Utilities.moveUp(ctx, conjunctionContext);
    return super.visitEquivalence(ctx);
  }

  private ConjunctionContext equivalenceTransform(EquivalenceContext ctx) {

    ExprContext cloneLeft = Utilities.cloneExprContext(ctx.left);
    ExprContext cloneRight = Utilities.cloneExprContext(ctx.right);

    NegationContext leftNegation = Utilities.createNegationContext(cloneLeft);
    NegationContext rightNegation = Utilities.createNegationContext(cloneRight);

    ExprContext leftContext = Utilities.createDisjunctionContext(leftNegation, ctx.right);
    ExprContext rightContext = Utilities.createDisjunctionContext(ctx.left, rightNegation);

    ParenthesesContext leftParentheses = Utilities.createParenthesesContext(leftContext);
    ParenthesesContext rightParentheses = Utilities.createParenthesesContext(rightContext);

    return Utilities.createConjunctionContext(leftParentheses, rightParentheses);

  }

}
