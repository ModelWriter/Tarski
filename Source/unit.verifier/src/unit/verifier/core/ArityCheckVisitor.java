package unit.verifier.core;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

/**
 * Created by emre.kirmizi on 23.10.2015.
 */
@SuppressWarnings("rawtypes")
public class ArityCheckVisitor extends CoreBaseVisitor {

  private Vocabulary vocab;

  public ArityCheckVisitor() {
    super();
    this.vocab = new Vocabulary();
  }

  @Override
  public Object visitSet(CoreParser.SetContext ctx) {
    int ac = 0;
    List<TupleContext> tuples = ctx.tuple();
    
    for (int i = 0; i < tuples.size(); i++) {
      TupleContext context = tuples.get(i);

      int count = context.IDENTIFIER().size();
      int offset = context.IDENTIFIER().get(0).getSymbol().getCharPositionInLine();
      int line = context.IDENTIFIER().get(0).getSymbol().getLine();
      
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
