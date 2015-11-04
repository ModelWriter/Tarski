package eu.modelwriter.traceability.validation.core.fol;

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

public class SentencePrinter extends FOLBaseVisitor<String> {
  private StringBuilder builder;

  public SentencePrinter() {
    this.builder = new StringBuilder();
  }

  public StringBuilder getBuilder() {
    return this.builder;
  }

  @Override
  public String visitConjunction(ConjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String str;
    if (!(ctx.parent instanceof ParenthesesContext)) {
      str = "(" + left + " and " + right + ")";
    } else {
      str = left + " and " + right;
    }
    return str;
  }

  @Override
  public String visitDisjunction(DisjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String str;
    if (!(ctx.parent instanceof ParenthesesContext)) {
      str = "(" + left + " or " + right + ")";
    } else {
      str = left + " or " + right;
    }
    return str;
  }

  @Override
  public String visitEquivalance(EquivalanceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String str;
    if (!(ctx.parent instanceof ParenthesesContext)) {
      str = "(" + left + " <-> " + right + ")";
    } else {
      str = left + " <-> " + right;
    }
    return str;
  }

  @Override
  public String visitImplication(ImplicationContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);
    String str;
    if (!(ctx.parent instanceof ParenthesesContext)) {
      str = "(" + left + " -> " + right + ")";
    } else {
      str = left + " -> " + right;
    }
    return str;
  }

  @Override
  public String visitNegation(NegationContext ctx) {
    String str;
    if (ctx.expr() instanceof RelationContext || ctx.expr() instanceof ParenthesesContext) {
      str = "not " + this.visit(ctx.expr());
    } else {
      str = "not" + "(" + this.visit(ctx.expr()) + ")";
    }
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
    String str = "";
    str += ctx.quantifier().op.getText().toLowerCase() + " ";

    List<TerminalNode> identifierList = ctx.quantifier().IDENTIFIER();
    for (int i = 0; i < identifierList.size() - 1; i++) {
      str += identifierList.get(i).getText() + ", ";
    }
    str += identifierList.get(identifierList.size() - 1).getText() + " ";

    return str + " | " + this.visit(ctx.expr());
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

    String specification = model + sentences;
    this.builder.append(specification);
    return sentences;
  }

  @Override
  public String visitTuple(TupleContext ctx) {
    String str = ctx.getText();
    return str;
  }

}
