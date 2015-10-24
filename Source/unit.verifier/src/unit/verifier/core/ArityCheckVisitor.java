package unit.verifier.core;

import java.util.List;

import unit.verifier.core.CoreParser.TupleContext;

/**
 * Created by emre.kirmizi on 23.10.2015.
 */
@SuppressWarnings("rawtypes")
public class ArityCheckVisitor extends CoreBaseVisitor {
  public ArityCheckVisitor() {
    super();
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
      } else if (ac != count) {
        String errorString =
            "\nArity Problem. Check it! [Line:{" + line + "}, Position:{" + offset + "}]";
        System.err.print(errorString);
      }
    }
    return super.visitSet(ctx);
  }
}
