package eu.modelwriter.traceability.validation.core.fol.cnf;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.EquivalanceContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ImplicationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.QuantificationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SentenceContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SetContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SpecificationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.TupleContext;

public class PrettyPrinter extends FOLBaseVisitor<String> {

  private String specification;

  public PrettyPrinter() {}

  public void print() {
    System.out.println(this.specification);
  }

  @Override
  public String visitConjunction(ConjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String op = " " + ctx.op.getText() + " ";

    String str = left + op + right;

    return str;
  }

  @Override
  public String visitDisjunction(DisjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String op = " " + ctx.op.getText() + " ";

    String str = left + op + right;

    return str;
  }

  @Override
  public String visitEquivalance(EquivalanceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String op = " " + ctx.op.getText() + " ";

    String str = left + op + right;

    return str;
  }

  @Override
  public String visitImplication(ImplicationContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String op = " " + ctx.op.getText() + " ";

    String str = left + op + right;

    return str;
  }

  @Override
  public String visitNegation(NegationContext ctx) {
    String op = ctx.op.getText() + " ";
    String str = op + this.visit(ctx.expr());

    return str;
  }

  @Override
  public String visitParentheses(ParenthesesContext ctx) {
    String str;
    if (ctx.expr() instanceof RelationContext) {
      str = this.visit(ctx.expr());
    } else {
      str = "(" + this.visit(ctx.expr()) + ")";
    }
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

    String str = op + identifiers + " | " + this.visit(ctx.expr());

    return str;
  }

  @Override
  public String visitRelation(RelationContext ctx) {
    String str = ctx.getText();

    return str;
  }

  @Override
  public String visitSentence(SentenceContext ctx) {
    String str = "\t" + this.visit(ctx.expr()) + ";\n";

    return str;
  }

  @Override
  public String visitSet(SetContext ctx) {
    String str = "\t" + ctx.getText() + "\n";

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

    this.specification = model + sentences;
    // this.print();
    return this.specification;
  }

  @Override
  public String visitTuple(TupleContext ctx) {
    String str = ctx.getText();

    return str;
  }
}
