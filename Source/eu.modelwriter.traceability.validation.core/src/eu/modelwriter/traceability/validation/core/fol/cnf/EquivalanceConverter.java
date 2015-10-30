package eu.modelwriter.traceability.validation.core.fol.cnf;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.EquivalanceContext;

public class EquivalanceConverter extends ParseTreePrinter {

  @Override
  public String visitEquivalance(EquivalanceContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "(" + left + " -> " + right + ") and (" + right + " -> " + left + ")";

    return str;
  }
}
