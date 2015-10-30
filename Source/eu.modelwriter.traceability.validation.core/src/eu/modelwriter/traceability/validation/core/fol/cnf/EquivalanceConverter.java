package eu.modelwriter.traceability.validation.core.fol.cnf;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.EquivalanceContext;

public class EquivalanceConverter extends PrettyPrinter {

  @Override
  public String visitEquivalance(EquivalanceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "(" + left + " -> " + right + ") and (" + right + " -> " + left + ")";

    return str;
  }
}
