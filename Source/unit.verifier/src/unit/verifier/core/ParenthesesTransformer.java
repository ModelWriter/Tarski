package unit.verifier.core;

import unit.verifier.core.CoreParser.ExprContext;
import unit.verifier.core.CoreParser.ParenthesesContext;

@SuppressWarnings("rawtypes")
public class ParenthesesTransformer extends CoreBaseVisitor {

	@Override
	public Object visitParentheses(ParenthesesContext ctx) {
		ExprContext child = ctx.expr();
		CoreUtilities.moveUp(ctx, child);
		return super.visitParentheses(ctx);
	}
}
