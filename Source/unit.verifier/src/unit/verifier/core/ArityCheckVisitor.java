package unit.verifier.core;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;

/**
 * Created by emre.kirmizi on 23.10.2015.
 */
@SuppressWarnings("rawtypes")
public class ArityCheckVisitor extends CoreBaseVisitor {
  public ArityCheckVisitor() {
    super();
  }

  @Override
  public Object visitModel(CoreParser.ModelContext ctx) {
    int ac = 0;
    for (int i = 0; i < ctx.getChildCount(); i++) {
      if (ctx.getChild(i) instanceof CoreParser.ArityContext) {
        CoreParser.ArityContext context = (CoreParser.ArityContext) ctx.getChild(i);
        int count = 0;
        int offset = 0;
        int line = 0;
        for (int j = 0; j < context.getChildCount(); j++) {
          if (((TerminalNodeImpl) context.getChild(j)).getSymbol().getType() == CoreParser.VAR) {
            count++;
            offset = ((TerminalNodeImpl) context.getChild(j)).getSymbol().getCharPositionInLine();
            line = ((TerminalNodeImpl) context.getChild(j)).getSymbol().getLine();
          }
        }
        if (ac == 0) {
          // arityCount.put(ctx,count);
          ac = count;
        } else if (ac != count) {
          String errorString =
              "\nArity Problem. Check it! [Line:{" + line + "}, Position:{" + offset + "}]";
          System.err.print(errorString);
        }
      }
    }
    return super.visitModel(ctx);
  }
}
