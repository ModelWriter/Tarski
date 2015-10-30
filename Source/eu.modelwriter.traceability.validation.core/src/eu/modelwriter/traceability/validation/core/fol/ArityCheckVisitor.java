package eu.modelwriter.traceability.validation.core.fol;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.generated.CoreBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser;
import eu.modelwriter.traceability.validation.core.fol.generated.CoreParser.TupleContext;

/**
 * Created by emre.kirmizi on 23.10.2015.
 */
@SuppressWarnings("rawtypes")
public class ArityCheckVisitor extends CoreBaseVisitor {

  private MyVocabulary vocab;

  public ArityCheckVisitor() {
    super();
    this.vocab = new MyVocabulary();
  }

  @Override
  public Object visitSet(CoreParser.SetContext ctx) {
    int ac = 0;
    int count;
    int offset;
    int line;

    for (TupleContext context : ctx.tuple()) {

      for (TerminalNode node : context.IDENTIFIER()) {
        if (!this.vocab.getAtomList().contains(node.toString())) {
          this.vocab.getAtomList().add(node.toString());
        }
      }

      count = context.IDENTIFIER().size();
      offset = context.IDENTIFIER().get(0).getSymbol().getCharPositionInLine();
      line = context.IDENTIFIER().get(0).getSymbol().getLine();

      if (ac == 0) {
        ac = count;
        this.vocab.getRelationArityMap().put(ctx.start, ac);
      } else if (ac != count) {
        String errorString =
            "\nArity Problem. Check it! [Line:{" + line + "}, Position:{" + offset + "}]";
        System.err.print(errorString);
      }
    }
    return super.visitSet(ctx);
  }
}
