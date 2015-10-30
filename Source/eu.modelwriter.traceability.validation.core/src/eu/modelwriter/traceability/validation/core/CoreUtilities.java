package eu.modelwriter.traceability.validation.core;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import eu.modelwriter.traceability.validation.core.CoreParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.CoreParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.CoreParser.ParenthesesContext;
import eu.modelwriter.traceability.validation.core.CoreParser.SentenceContext;

public class CoreUtilities {

	public static NegationContext createNegationContext(ExprContext expr) {
		NegationContext negationContext = new NegationContext(new ExprContext());
		TerminalNodeImpl notNode = new TerminalNodeImpl(new CommonToken(11, "not"));

		notNode.parent = negationContext;
		expr.parent = negationContext;

		negationContext.addChild(notNode);
		negationContext.addChild(expr);

		return negationContext;
	}

	public static ParenthesesContext createParenthesesContext(ExprContext expr) {
		ParenthesesContext parenthesesContext = new ParenthesesContext(new ExprContext());
		TerminalNodeImpl leftParenthes = new TerminalNodeImpl(new CommonToken(8, "("));
		TerminalNodeImpl rightParenthes = new TerminalNodeImpl(new CommonToken(9, ")"));

		leftParenthes.parent = parenthesesContext;
		rightParenthes.parent = parenthesesContext;
		expr.parent = parenthesesContext;

		parenthesesContext.addChild(leftParenthes);
		parenthesesContext.addChild(expr);
		parenthesesContext.addChild(rightParenthes);

		return parenthesesContext;
	}

	public static DisjunctionContext createDisjunctionContext(ExprContext leftContext, ExprContext rightContext) {
		DisjunctionContext disjunctionContext = new DisjunctionContext(new ExprContext());
		TerminalNodeImpl orNode = new TerminalNodeImpl(new CommonToken(15, "or"));

		leftContext.parent = disjunctionContext;
		rightContext.parent = disjunctionContext;
		orNode.parent = disjunctionContext;

		disjunctionContext.left = leftContext;
		disjunctionContext.right = rightContext;

		disjunctionContext.addChild(leftContext);
		disjunctionContext.addChild(orNode);
		disjunctionContext.addChild(rightContext);

		return disjunctionContext;
	}

	public static ConjunctionContext createConjunctionContext(ExprContext leftContext, ExprContext rightContext) {
		ConjunctionContext conjunctionContext = new ConjunctionContext(new ExprContext());
		TerminalNodeImpl andNode = new TerminalNodeImpl(new CommonToken(13, "and"));

		leftContext.parent = conjunctionContext;
		andNode.parent = conjunctionContext;
		rightContext.parent = conjunctionContext;

		conjunctionContext.left = leftContext;
		conjunctionContext.right = rightContext;

		conjunctionContext.addChild(leftContext);
		conjunctionContext.addChild(andNode);
		conjunctionContext.addChild(rightContext);

		return conjunctionContext;
	}

	public static void moveUp(ExprContext ctx, ExprContext child) {
		RuleContext parent = new RuleContext();
		parent = ctx.parent;
		child.parent = parent;
		if (parent instanceof ExprContext) {
			ExprContext expr = (ExprContext) parent;
			int index = expr.children.indexOf(ctx);
			expr.children.remove(index);
			expr.children.add(index, child);
		} else if (parent instanceof SentenceContext) {
			SentenceContext sent = (SentenceContext) parent;
			int index = sent.children.indexOf(ctx);
			sent.children.remove(index);
			sent.children.add(index, child);
		}
	}

	public static ExprContext cloneExprContext(ExprContext expr) {
		ExprContext clone = new ExprContext();
		clone.copyFrom(expr);
		expr.children.size();

		for (ParseTree child : expr.children) {
			if (child instanceof TerminalNode) {
				clone.addChild(new TerminalNodeImpl((((TerminalNode) child).getSymbol())));
			} else if (child instanceof ExprContext) {
				clone.addChild(cloneExprContext((ExprContext) child));
			} else if (child instanceof Token) {
				clone.addChild(new CommonToken((Token) child));
			}
		}
		return clone;
	}

}
