package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import eu.modelwriter.traceability.validation.core.fol.Utilities;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.EquivalenceContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;

public class EquivalenceTransformer extends FOLBaseVisitor<Object> {

  /**
   * According to Biconditional Elimination Rule and Implication Elimination Rule, Equivalence
   * Context translate to Conjunction Context.
   */
  private ConjunctionContext equivalenceTransform(final EquivalenceContext ctx) {

    final ExprContext cloneLeft = Utilities.cloneExprContext(ctx.left);
    final ExprContext cloneRight = Utilities.cloneExprContext(ctx.right);

    // Converting expressions to negative expressions.
    final NegationContext leftNegation = Utilities.createNegationContext(cloneLeft);
    final NegationContext rightNegation = Utilities.createNegationContext(cloneRight);

    // Creating disjunction expression for biconditional elimination rule.
    final ExprContext leftContext = Utilities.createDisjunctionContext(leftNegation, ctx.right);
    final ExprContext rightContext = Utilities.createDisjunctionContext(ctx.left, rightNegation);

    // For prioritize of expressions, adding parentheses.
    final ParenthesesContext leftParentheses = Utilities.createParenthesesContext(leftContext);
    final ParenthesesContext rightParentheses = Utilities.createParenthesesContext(rightContext);

    return Utilities.createConjunctionContext(leftParentheses, rightParentheses);

  }

  @Override
  public Object visitEquivalence(final EquivalenceContext ctx) {
    final ConjunctionContext conjunctionContext = this.equivalenceTransform(ctx);
    Utilities.moveUp(ctx, conjunctionContext);
    return super.visitEquivalence(ctx);
  }

}


