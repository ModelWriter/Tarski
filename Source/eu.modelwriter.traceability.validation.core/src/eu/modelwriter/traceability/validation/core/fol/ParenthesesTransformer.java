package eu.modelwriter.traceability.validation.core.fol;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ParenthesesContext;

@SuppressWarnings("rawtypes")
public class ParenthesesTransformer extends CoreBaseVisitor {

	@Override
	public Object visitParentheses(ParenthesesContext ctx) {
		ExprContext child = ctx.expr();
		CoreUtilities.moveUp(ctx, child);
		return super.visitParentheses(ctx);
	}
}
