package eu.modelwriter.traceability.validation.core.fol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.QuantiferContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.QuantificationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.SentenceContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.SetContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.TupleContext;

public class SemanticProcess extends CoreBaseVisitor<Boolean> {

  ArrayList<String> setList = new ArrayList<String>();
  Map<String, String> variableValueMap = new HashMap<String, String>();
  String op;
  String identifier;

  @Override
  public Boolean visitTuple(TupleContext ctx) {
    String relationName = ((SetContext) ctx.parent).RELATION_NAME().getText();
    for (TerminalNode node : ctx.IDENTIFIER()) {
      relationName += "_" + node.getText();
    }
    setList.add(relationName);
    return super.visitTuple(ctx);
  }

  @Override
  public Boolean visitSentence(SentenceContext ctx) {
    ExprContext expr = ctx.expr();

    boolean result = visit(expr);
    System.out.println(result);

    return result;
  }

  @Override
  public Boolean visitConjunction(ConjunctionContext ctx) {
    ExprContext leftContext = ctx.left;
    ExprContext rightContext = ctx.right;

    boolean leftResult = visit(leftContext);
    boolean rightResult = visit(rightContext);

    return leftResult && rightResult;
  }

  @Override
  public Boolean visitDisjunction(DisjunctionContext ctx) {
    ExprContext leftContext = ctx.left;
    ExprContext rightContext = ctx.right;

    boolean leftResult = visit(leftContext);
    boolean rightResult = visit(rightContext);

    return leftResult || rightResult;
  }

  @Override
  public Boolean visitNegation(NegationContext ctx) {
    ExprContext expr = ctx.expr();
    boolean result = visit(expr);

    return !result;
  }

  @Override
  public Boolean visitRelation(RelationContext ctx) {

    return findRelation(ctx);
  }

  public Boolean findRelation(RelationContext expr) {
    String relationName = expr.RELATION_NAME().getText();
    for (TerminalNode node : expr.IDENTIFIER()) {
      if (node.getText().equals("x")) /** değişecekkkk */
        relationName += "_" + variableValueMap.get("x");
      else
        relationName += "_" + node.getText();
    }

    return setList.contains(relationName);
  }

  @Override
  public Boolean visitQuantification(QuantificationContext ctx) {

    visit(ctx.quantifer());

    /** To test **/
    ArrayList<String> constants = new ArrayList<>();
    constants.add("a");
    constants.add("b");
    constants.add("c");
    constants.add("d");
    /*****/
    boolean result = false;

    for (String value : constants) {
      variableValueMap.put("x", value); // Değiştirilecek
      result = visit(ctx.expr());

      if (op.equals("all") && !result)
        return false;
      else if (op.equals("some") && result)
        return true;
      else if (op.equals("no") && result)
        return false;
    }
    return result;
  }

  @Override
  public Boolean visitQuantifer(QuantiferContext ctx) {
    op = ctx.op.getText();
    identifier = ctx.IDENTIFIER().get(0).getText();

    return super.visitQuantifer(ctx);
  }


}
