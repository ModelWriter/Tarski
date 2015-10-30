package eu.modelwriter.traceability.validation.core.fol;

import org.antlr.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ParenthesesContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.SentenceContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.SpecificationContext;

public class SentenceTransformer extends CoreBaseVisitor {

  NegationContext baseNegationContext = null;

  @Override
  public Object visitParentheses(ParenthesesContext ctx) {
    ExprContext child = ctx.expr();
    RuleContext parent = ctx.parent;

    child.parent = parent;

    if (parent instanceof ExprContext) {
      ExprContext expr = (ExprContext) parent;
      int index = expr.children.indexOf(ctx);
      expr.children.remove(index);
      expr.children.add(index, child);
    }

    return super.visitParentheses(ctx);
  }



  @Override
  public Object visitNegation(NegationContext ctx) {
    // if (ctx.expr() instanceof ParenthesesContext) {
    // if (baseNegationContext == null)
    // baseNegationContext = ctx;
    //
    // ExprContext newExprContext = negationTransformer(((ParenthesesContext) ctx.expr()).expr());
    // newExprContext.parent = ctx.expr();
    // ((ParenthesesContext) ctx.expr()).children.remove(1);
    // ((ParenthesesContext) ctx.expr()).children.add(1, newExprContext);
    //
    //
    // ExprContext child = ctx.expr();
    // RuleContext parent = ctx.parent;
    //
    // child.parent = parent;
    //
    // if (parent instanceof ExprContext) {
    // ExprContext expr = (ExprContext) parent;
    // int index = expr.children.indexOf(ctx);
    // expr.children.remove(index);
    // expr.children.add(index, child);
    // } else if (parent instanceof SentenceContext) {
    // SentenceContext sent = (SentenceContext) parent;
    // int index = sent.children.indexOf(ctx);
    // sent.children.remove(index);
    // sent.children.add(index, child);
    // }
    //
    //
    // }
    return super.visitNegation(ctx);
  }



  private ExprContext negationTransformer(ExprContext expr) {
    if (expr instanceof DisjunctionContext) {
      return negationOnDisjunction((DisjunctionContext) expr);
    } else if (expr instanceof ConjunctionContext) {
      return negationOnConjunction((ConjunctionContext) expr);
    }
    return null;
  }

  private ExprContext negationOnDisjunction(DisjunctionContext expr) {
    ConjunctionContext newConjuctionContext = new ConjunctionContext(expr);
    TerminalNode notNode = (TerminalNode) baseNegationContext.getChild(0);// düzgün yaratılması
                                                                          // gerek
    ExprContext leftNegationContext;
    ExprContext rightNegationContext;

    if (!(expr.left instanceof RelationContext)) {
      leftNegationContext = negationTransformer(expr.left);

    } else {
      leftNegationContext = new NegationContext(expr.left);
      leftNegationContext.addChild(notNode); // düzgün yaratılması gerek
      leftNegationContext.addChild(expr.left);
    }

    if (!(expr.right instanceof RelationContext)) {
      rightNegationContext = negationTransformer(expr.right);

    } else {
      rightNegationContext = new NegationContext(expr.right);
      rightNegationContext.addChild(notNode);// düzgün yaratılması gerek
      rightNegationContext.addChild(expr.right);
    }

    newConjuctionContext.left = leftNegationContext;
    leftNegationContext.parent = newConjuctionContext;
    newConjuctionContext.right = rightNegationContext;
    rightNegationContext.parent = newConjuctionContext;

    newConjuctionContext.addChild(leftNegationContext);
    newConjuctionContext.addChild((TerminalNode) expr.getChild(1)); // Düzeltilcek
    newConjuctionContext.addChild(rightNegationContext);

    return newConjuctionContext;
  }

  private ExprContext negationOnConjunction(ConjunctionContext expr) {
    ConjunctionContext newDisjunctionContext = new ConjunctionContext(expr);
    TerminalNode notNode = (TerminalNode) baseNegationContext.getChild(0);// düzgün yaratılması
                                                                          // gerek
    ExprContext leftNegationContext;
    ExprContext rightNegationContext;

    if (!(expr.left instanceof RelationContext)) {
      leftNegationContext = negationTransformer(expr.left);

    } else {
      leftNegationContext = new NegationContext(expr.left);
      leftNegationContext.addChild(notNode);// düzgün yaratılması gerek
      leftNegationContext.addChild(expr.left);
    }

    if (!(expr.right instanceof RelationContext)) {
      rightNegationContext = negationTransformer(expr.right);

    } else {
      rightNegationContext = new NegationContext(expr.right);
      rightNegationContext.addChild(notNode);// düzgün yaratılması gerek
      rightNegationContext.addChild(expr.right);
    }

    newDisjunctionContext.left = leftNegationContext;
    leftNegationContext.parent = newDisjunctionContext;
    newDisjunctionContext.right = rightNegationContext;
    rightNegationContext.parent = newDisjunctionContext;

    newDisjunctionContext.addChild(leftNegationContext);
    newDisjunctionContext.addChild((TerminalNode) expr.getChild(1)); // Düzeltilcek
    newDisjunctionContext.addChild(rightNegationContext);

    return newDisjunctionContext;
  }

}
