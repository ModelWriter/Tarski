package eu.modelwriter.traceability.validation.core.fol.cnf;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.EquivalenceContext;
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

  private final List<String> sentences;

  public PrettyPrinter() {
    this.sentences = new ArrayList<>();
  }

  public List<String> getSentences() {
    return this.sentences;
  }

  public void print() {
    System.out.println(this.specification);
  }

  @Override
  public String visitConjunction(final ConjunctionContext ctx) {
    final String left = this.visit(ctx.left);
    final String right = this.visit(ctx.right);
    final String op = " " + ctx.op.getText() + " ";

    final String str = left + op + right;

    return str;
  }

  @Override
  public String visitDisjunction(final DisjunctionContext ctx) {
    final String left = this.visit(ctx.left);
    final String right = this.visit(ctx.right);
    final String op = " " + ctx.op.getText() + " ";

    final String str = left + op + right;

    return str;
  }

  @Override
  public String visitEquivalence(final EquivalenceContext ctx) {
    final String left = this.visit(ctx.left);
    final String right = this.visit(ctx.right);
    final String op = " " + ctx.op.getText() + " ";

    final String str = left + op + right;

    return str;
  }

  @Override
  public String visitImplication(final ImplicationContext ctx) {
    final String left = this.visit(ctx.left);
    final String right = this.visit(ctx.right);
    final String op = " " + ctx.op.getText() + " ";

    final String str = left + op + right;

    return str;
  }

  @Override
  public String visitNegation(final NegationContext ctx) {
    final String op = ctx.op.getText() + " ";
    final String str = op + this.visit(ctx.expr());

    return str;
  }

  @Override
  public String visitParentheses(final ParenthesesContext ctx) {
    String str;
    if (ctx.expr() instanceof RelationContext) {
      str = this.visit(ctx.expr());
    } else {
      str = "(" + this.visit(ctx.expr()) + ")";
    }
    return str;
  }

  @Override
  public String visitQuantification(final QuantificationContext ctx) {
    String str = "";
    str += ctx.quantifier().op.getText().toLowerCase() + " ";

    final List<TerminalNode> identifierList = ctx.quantifier().IDENTIFIER();
    for (int i = 0; i < identifierList.size() - 1; i++) {
      str += identifierList.get(i).getText() + ", ";
    }
    str += identifierList.get(identifierList.size() - 1).getText() + " ";

    return str + " | " + this.visit(ctx.expr());
  }

  @Override
  public String visitRelation(final RelationContext ctx) {
    final String str = ctx.getText();

    return str;
  }

  @Override
  public String visitSentence(final SentenceContext ctx) {
    final String visit = this.visit(ctx.expr());
    final String sentence = "\t" + visit + ";\n";
    this.sentences.add(visit);

    return sentence;
  }

  @Override
  public String visitSet(final SetContext ctx) {
    final String str = "\t" + ctx.getText() + "\n";

    return str;
  }

  @Override
  public String visitSpecification(final SpecificationContext ctx) {
    String model = "Model:\n";
    for (final SetContext set : ctx.set()) {
      model += this.visit(set);
    }

    String sentences = "\nSentences:\n";
    for (final SentenceContext sentence : ctx.sentence()) {
      sentences += this.visit(sentence);
    }

    this.specification = model + sentences;
    // this.print();
    return this.specification;
  }

  @Override
  public String visitTuple(final TupleContext ctx) {
    final String str = ctx.getText();

    return str;
  }
}
