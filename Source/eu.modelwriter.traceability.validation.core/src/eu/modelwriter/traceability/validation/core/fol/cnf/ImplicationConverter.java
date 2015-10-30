package eu.modelwriter.traceability.validation.core.fol.cnf;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ImplicationContext;

public class ImplicationConverter extends ParseTreePrinter {

  @Override
  public String visitImplication(ImplicationContext ctx) {
    String left = this.visit(ctx.left);
    String right = this.visit(ctx.right);

    String str = "not (" + left + ") or " + right;

    return str;
  }

}
