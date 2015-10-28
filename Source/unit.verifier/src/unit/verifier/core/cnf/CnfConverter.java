package unit.verifier.core.cnf;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import unit.verifier.core.CoreBaseVisitor;
import unit.verifier.core.CoreParser.ConjunctionContext;
import unit.verifier.core.CoreParser.DisjunctionContext;
import unit.verifier.core.CoreParser.EquivalanceContext;
import unit.verifier.core.CoreParser.ImplicationContext;
import unit.verifier.core.CoreParser.NegationContext;
import unit.verifier.core.CoreParser.ParenthesesContext;
import unit.verifier.core.CoreParser.QuantificationContext;
import unit.verifier.core.CoreParser.RelationContext;
import unit.verifier.core.CoreParser.SentenceContext;
import unit.verifier.core.CoreParser.SetContext;
import unit.verifier.core.CoreParser.SpecificationContext;
import unit.verifier.core.CoreParser.TupleContext;

public class CnfConverter extends CoreBaseVisitor<String> {
  private StringBuilder builder;

  public CnfConverter() {
    this.builder = new StringBuilder();
  }

  public StringBuilder getBuilder() {
    return this.builder;
  }

  @Override
  public String visitConjunction(ConjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = left + " and " + right;
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitDisjunction(DisjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = left + " or " + right;
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitEquivalance(EquivalanceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "(" + left + "->" + right + ") and (" + right + "->" + left + ")";
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitImplication(ImplicationContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "not (" + left + ") or " + right;
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitNegation(NegationContext ctx) {
    String str = "not " + this.visit(ctx.expr());
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitParentheses(ParenthesesContext ctx) {
    String str = "(" + this.visit(ctx.expr()) + ")";
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitQuantification(QuantificationContext ctx) {
    String op = ctx.quantifer().op.getText() + " ";
    String identifiers = "";

    List<TerminalNode> identifierList = ctx.quantifer().IDENTIFIER();
    for (int i = 0; i < identifierList.size() - 1; i++) {
      identifiers += identifierList.get(i).getText() + ", ";
    }
    identifiers += identifierList.get(identifierList.size() - 1).getText();

    String str = op + identifiers + "| " + this.visit(ctx.expr());
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitRelation(RelationContext ctx) {
    String str = ctx.getText();
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitSentence(SentenceContext ctx) {
    String str = this.visit(ctx.expr()) + ";\n";
    // System.out.println(str);
    return str;
  }

  @Override
  public String visitSet(SetContext ctx) {
    String str = ctx.getText() + "\n";
    // System.out.print(str);
    return str;
  }

  @Override
  public String visitSpecification(SpecificationContext ctx) {
    String model = "Model:\n";
    for (SetContext set : ctx.set()) {
      model += this.visit(set);
    }

    String sentences = "\nSentences:\n";
    for (SentenceContext sentence : ctx.sentence()) {
      sentences += this.visit(sentence);
    }

    String specification = model + sentences;
    this.builder.append(specification);
    System.out.println(specification);
    return sentences;
  }

  @Override
  public String visitTuple(TupleContext ctx) {
    String str = ctx.getText();
    // System.out.print(str);
    return str;
  }
}
