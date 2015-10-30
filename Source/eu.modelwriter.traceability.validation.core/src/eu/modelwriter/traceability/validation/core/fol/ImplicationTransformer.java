package eu.modelwriter.traceability.validation.core.fol;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ImplicationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ParenthesesContext;

@SuppressWarnings("rawtypes")
public class ImplicationTransformer extends CoreBaseVisitor {

	@Override
	public Object visitImplication(ImplicationContext ctx) {
		DisjunctionContext disjunctionContext = implicationTransform(ctx);
		CoreUtilities.moveUp(ctx, disjunctionContext);
		return super.visitImplication(ctx);
	}

	private DisjunctionContext implicationTransform(ImplicationContext ctx) {
		
		ExprContext leftContext;
		ExprContext rightContext = ctx.right;
		ParenthesesContext parenthesesContext;

		if (ctx.left instanceof NegationContext) {
			leftContext = ((NegationContext) ctx.left).expr();
		} else {
			parenthesesContext = CoreUtilities.createParenthesesContext(ctx.left);
			leftContext = CoreUtilities.createNegationContext(parenthesesContext);
		}

		return CoreUtilities.createDisjunctionContext(leftContext, rightContext);
	}

}
