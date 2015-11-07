package eu.modelwriter.traceability.validation.core.fol.typechecker;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.TupleContext;

/**
 * Created by emre.kirmizi on 23.10.2015.
 */
@SuppressWarnings("rawtypes")
public class ArityCheck extends FOLBaseVisitor {

  private final Vocabulary vocab;
  private boolean errState;

  public ArityCheck() {
    super();
    vocab = new Vocabulary();
    setErrState(false);
  }

  public boolean isErrState() {
    return errState;
  }

  public void setErrState(boolean errState) {
    this.errState = errState;
  }

  @Override
  public Object visitRelation(RelationContext ctx) {
    if (vocab.getRelationArityMap().get(ctx.RELATION_NAME().getText()) != ctx.IDENTIFIER().size()) {
      final String errorString = "Arity Problem at Sentence. Check it! [Line:{"
          + ctx.start.getLine() + "}, Position:{" + ctx.start.getCharPositionInLine() + "}]\n";
      System.err.println(errorString);
      setErrState(true);
    }
    return super.visitRelation(ctx);
  }

  @Override
  public Object visitSet(FOLParser.SetContext ctx) {
    int ac = 0;
    int count;
    int offset;
    int line;

    for (final TupleContext context : ctx.tuple()) {

      for (final TerminalNode node : context.IDENTIFIER()) {
        if (!vocab.getAtomList().contains(node.toString())) {
          vocab.getAtomList().add(node.toString());
        }
      }

      count = context.IDENTIFIER().size();
      offset = context.IDENTIFIER().get(0).getSymbol().getCharPositionInLine();
      line = context.IDENTIFIER().get(0).getSymbol().getLine();

      if (ac == 0) {
        ac = count;
        vocab.getRelationArityMap().put(ctx.RELATION_NAME().getText(), ac);
      } else if (ac != count) {
        final String errorString =
            "Arity Problem at Model. Check it! [Line:{" + line + "}, Position:{" + offset + "}]\n";
        System.err.print(errorString);
        setErrState(true);
      }
    }
    return super.visitSet(ctx);
  }
}
