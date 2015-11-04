package eu.modelwriter.traceability.validation.core.fol.cnf;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.EquivalenceContext;

public class EquivalanceConverter extends PrettyPrinter {

  @Override
  public String visitEquivalence(EquivalenceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "(" + left + " -> " + right + ") and (" + right + " -> " + left + ")";

    return str;
  }
}
