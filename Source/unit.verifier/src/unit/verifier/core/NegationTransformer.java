package unit.verifier.core;

import unit.verifier.core.CoreParser.ConjunctionContext;
import unit.verifier.core.CoreParser.DisjunctionContext;
import unit.verifier.core.CoreParser.ExprContext;
import unit.verifier.core.CoreParser.NegationContext;
import unit.verifier.core.CoreParser.ParenthesesContext;
import unit.verifier.core.CoreParser.RelationContext;

@SuppressWarnings("rawtypes")
public class NegationTransformer extends CoreBaseVisitor {

	@Override
	public Object visitNegation(NegationContext ctx) {
		if (ctx.expr() instanceof ParenthesesContext) {
			negationOnParentheses(ctx);
		} else if (ctx.expr() instanceof NegationContext) {
			if (((NegationContext) ctx.expr()).expr() instanceof NegationContext)
				visitNegation((NegationContext) ((NegationContext) ctx.expr()).expr());
			CoreUtilities.moveUp(ctx, ((NegationContext) ctx.expr()).expr());
		}
		return super.visitNegation(new NegationContext(new ExprContext()));
	}

	private ExprContext negationOnParentheses(NegationContext ctx) {
		ExprContext newExprContext = negationTransformer(((ParenthesesContext) ctx.expr()).expr());
		newExprContext.parent = ctx.expr();
		((ParenthesesContext) ctx.expr()).children.remove(1);
		((ParenthesesContext) ctx.expr()).children.add(1, newExprContext);

		ExprContext child = ctx.expr();
		CoreUtilities.moveUp(ctx, child);
		return newExprContext;
	}

	private ExprContext negationTransformer(ExprContext expr) {
		if (expr instanceof DisjunctionContext) {
			return negationOnDisjunction((DisjunctionContext) expr);
		} else if (expr instanceof ConjunctionContext) {
			return negationOnConjunction((ConjunctionContext) expr);
		} else if (expr instanceof NegationContext) {
			return reverse((NegationContext) expr);
		} else if (expr instanceof RelationContext) {
			return CoreUtilities.createNegationContext((RelationContext) expr);
		} else if (expr instanceof ParenthesesContext) {
			return negationTransformer(((ParenthesesContext) expr).expr());
		}
		return null;
	}

	private ExprContext reverse(NegationContext expr) {
		return expr.expr();
	}

	private ExprContext negationOnDisjunction(DisjunctionContext expr) {
		ExprContext leftNegationContext;
		ExprContext rightNegationContext;

		if (!(expr.left instanceof RelationContext)) {
			leftNegationContext = negationTransformer(expr.left);
		} else {
			leftNegationContext = CoreUtilities.createNegationContext(expr.left);
		}

		if (!(expr.right instanceof RelationContext)) {
			rightNegationContext = negationTransformer(expr.right);
		} else {
			rightNegationContext = CoreUtilities.createNegationContext(expr.right);
		}

		return CoreUtilities.createConjunctionContext(leftNegationContext, rightNegationContext);
	}

	private ExprContext negationOnConjunction(ConjunctionContext expr) {
		ExprContext leftNegationContext;
		ExprContext rightNegationContext;

		if (!(expr.left instanceof RelationContext)) {
			leftNegationContext = negationTransformer(expr.left);
		} else {
			leftNegationContext = CoreUtilities.createNegationContext(expr.left);
		}

		if (!(expr.right instanceof RelationContext)) {
			rightNegationContext = negationTransformer(expr.right);
		} else {
			rightNegationContext = CoreUtilities.createNegationContext(expr.right);
		}

		return CoreUtilities.createDisjunctionContext(leftNegationContext, rightNegationContext);
	}

}
