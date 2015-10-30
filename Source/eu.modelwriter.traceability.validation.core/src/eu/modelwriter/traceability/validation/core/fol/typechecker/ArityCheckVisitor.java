package eu.modelwriter.traceability.validation.core.fol.typechecker;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.TupleContext;

/**
 * Created by emre.kirmizi on 23.10.2015.
 */
@SuppressWarnings("rawtypes")
public class ArityCheckVisitor extends FOLBaseVisitor {

  private Vocabulary vocab;

  public ArityCheckVisitor() {
    super();
    this.vocab = new Vocabulary();
  }

  @Override
  public Object visitSet(FOLParser.SetContext ctx) {
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
