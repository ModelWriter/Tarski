package eu.modelwriter.traceability.validation.core.fol;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.EquivalanceContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ParenthesesContext;

@SuppressWarnings("rawtypes")
public class EquivalanceTransformer extends CoreBaseVisitor {

	@Override
	public Object visitEquivalance(EquivalanceContext ctx) {
		ConjunctionContext conjunctionContext = equivalanceTransform(ctx);
		CoreUtilities.moveUp(ctx, conjunctionContext);
		return super.visitEquivalance(ctx);
	}

	private ConjunctionContext equivalanceTransform(EquivalanceContext ctx) {
		
		ExprContext cloneLeft = CoreUtilities.cloneExprContext(ctx.left);
		ExprContext cloneRight = CoreUtilities.cloneExprContext(ctx.right);

		NegationContext leftNegation = CoreUtilities.createNegationContext(cloneLeft);
		NegationContext rightNegation = CoreUtilities.createNegationContext(cloneRight);

		ExprContext leftContext = CoreUtilities.createDisjunctionContext(leftNegation, ctx.right);
		ExprContext rightContext = CoreUtilities.createDisjunctionContext(ctx.left, rightNegation);

		ParenthesesContext leftParentheses = CoreUtilities.createParenthesesContext(leftContext);
		ParenthesesContext rightParentheses = CoreUtilities.createParenthesesContext(rightContext);

		return CoreUtilities.createConjunctionContext(leftParentheses, rightParentheses);

	}

}
