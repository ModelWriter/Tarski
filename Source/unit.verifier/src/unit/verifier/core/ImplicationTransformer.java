package unit.verifier.core;

import unit.verifier.core.CoreParser.DisjunctionContext;
import unit.verifier.core.CoreParser.ExprContext;
import unit.verifier.core.CoreParser.ImplicationContext;
import unit.verifier.core.CoreParser.NegationContext;
import unit.verifier.core.CoreParser.ParenthesesContext;

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
