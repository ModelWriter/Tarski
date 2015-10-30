package eu.modelwriter.traceability.validation.core;

import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.CoreParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.CoreParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.CoreParser.EquivalanceContext;
import eu.modelwriter.traceability.validation.core.CoreParser.ImplicationContext;
import eu.modelwriter.traceability.validation.core.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.CoreParser.ParenthesesContext;
import eu.modelwriter.traceability.validation.core.CoreParser.QuantificationContext;
import eu.modelwriter.traceability.validation.core.CoreParser.RelationContext;
import eu.modelwriter.traceability.validation.core.CoreParser.SentenceContext;
import eu.modelwriter.traceability.validation.core.CoreParser.SetContext;
import eu.modelwriter.traceability.validation.core.CoreParser.SpecificationContext;
import eu.modelwriter.traceability.validation.core.CoreParser.TupleContext;

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

    return str;
  }

  @Override
  public String visitDisjunction(DisjunctionContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = left + " or " + right;

    return str;
  }

  @Override
  public String visitEquivalance(EquivalanceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "(" + left + "->" + right + ") and (" + right + "->" + left + ")";

    return str;
  }

  @Override
  public String visitImplication(ImplicationContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "not (" + left + ") or " + right;

    return str;
  }

  @Override
  public String visitNegation(NegationContext ctx) {
    String str = "";
    if (ctx.expr() instanceof ParenthesesContext) {
      ParenthesesContext p = (ParenthesesContext) ctx.expr();
      if (p.expr() instanceof ConjunctionContext) {
        ConjunctionContext conj = (ConjunctionContext) p.expr();
        str = "not (" + this.visit(conj.left) + ") or " + "not (" + this.visit(conj.right) + ")";
      } else if (p.expr() instanceof DisjunctionContext) {
        DisjunctionContext disj = (DisjunctionContext) p.expr();
        str = "not (" + this.visit(disj.left) + ") and " + "not (" + this.visit(disj.right) + ")";
      } else if (p.expr() instanceof NegationContext) {
        NegationContext neg = (NegationContext) p.expr();
        str = this.visit(neg.expr());
      } else {
        str = "not " + this.visit(ctx.expr());
      }
    } else {
      if (ctx.expr() instanceof NegationContext) {
        NegationContext n = (NegationContext) ctx.expr();
        str = this.visit(n.expr());
      } else {
        str = "not " + this.visit(ctx.expr());
      }
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

    String specification = model + sentences;
    this.builder.append(specification);
    System.out.println(specification);
    return sentences;
  }

  @Override
  public String visitTuple(TupleContext ctx) {
    String str = ctx.getText();

    return str;
  }
}
