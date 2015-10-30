package eu.modelwriter.traceability.validation.core;

import eu.modelwriter.traceability.validation.core.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.CoreParser.ParenthesesContext;

@SuppressWarnings("rawtypes")
public class ParenthesesTransformer extends CoreBaseVisitor {

	@Override
	public Object visitParentheses(ParenthesesContext ctx) {
		ExprContext child = ctx.expr();
		CoreUtilities.moveUp(ctx, child);
		return super.visitParentheses(ctx);
	}
}
