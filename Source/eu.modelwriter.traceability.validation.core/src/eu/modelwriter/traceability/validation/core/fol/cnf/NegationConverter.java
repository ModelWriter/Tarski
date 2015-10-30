package eu.modelwriter.traceability.validation.core.fol.cnf;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.ParenthesesContext;

public class NegationConverter extends ParseTreePrinter {

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
}
