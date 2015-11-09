package eu.modelwriter.traceability.validation.core.fol.model;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseListener;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SetContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.TupleContext;

public class ModelBuilder extends FOLBaseListener {

  private final Universe universe;
  private Relation relation;
  private Tuple tuple;
  private Atom atom;
  private boolean errState;

  public ModelBuilder() {
    this.universe = new Universe();
    this.setErrState(false);
  }

  private void arityCheckOnModel(final TupleContext ctx) {
    if (this.relation.getTupleCount() > 1
        && this.tuple.getArity() != this.relation.getTuple(0).getArity()) {
      final int line = ctx.IDENTIFIER().get(0).getSymbol().getLine();
      final int offset = ctx.IDENTIFIER().get(0).getSymbol().getCharPositionInLine();
      final String errorString =
          "Arity Problem at Model. Check it! [Line:{" + line + "}, Position:{" + offset + "}]\n";
      System.err.print(errorString);
      this.setErrState(true);
    }
  }

  @Override
  public void enterSet(final SetContext ctx) {
    this.relation = new Relation(ctx.RELATION_NAME().getText());
    this.universe.addRelation(this.relation);
  }

  @Override
  public void enterTuple(final TupleContext ctx) {
    this.tuple = new Tuple(ctx.getText());
    this.relation.addTuple(this.tuple);
  }

  @Override
  public void exitSet(final SetContext ctx) {
    this.relation = null;
  }

  @Override
  public void exitTuple(final TupleContext ctx) {
    this.arityCheckOnModel(ctx);
    this.tuple = null;
  }

  public Universe getUniverse() {
    return this.universe;
  }

  public boolean isErrState() {
    return this.errState;
  }

  public void setErrState(final boolean errState) {
    this.errState = errState;
  }

  @Override
  public void visitTerminal(final TerminalNode node) {
    this.atom = new Atom(node.getText());
    if (this.tuple != null) {
      if (node.getSymbol().getType() == FOLParser.IDENTIFIER) {
        this.tuple.addAtom(this.atom);
        if (!this.universe.contains(this.atom)) {
          this.universe.addAtom(this.atom);
        }
      }
    }
    this.atom = null;
  }
}
