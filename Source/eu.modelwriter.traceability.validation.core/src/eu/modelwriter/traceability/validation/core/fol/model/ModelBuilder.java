package eu.modelwriter.traceability.validation.core.fol.model;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseListener;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SetContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.TupleContext;

public class ModelBuilder extends FOLBaseListener {

  private Universe universe;
  private Relation relation;
  private Tuple tuple;
  private Atom atom;

  public ModelBuilder() {
    this.universe = new Universe();
  }

  @Override
  public void enterSet(SetContext ctx) {
    this.relation = new Relation(ctx.RELATION_NAME().getText());
    this.universe.addRelation(this.relation);
  }

  @Override
  public void exitSet(SetContext ctx) {
    this.relation = null;
  }

  @Override
  public void enterTuple(TupleContext ctx) {
    this.tuple = new Tuple(ctx.getText());
    this.relation.addTuple(this.tuple);
  }

  @Override
  public void exitTuple(TupleContext ctx) {
    this.tuple = null;
  }

  public Universe getUniverse() {
    return this.universe;
  }

  @Override
  public void visitTerminal(TerminalNode node) {
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
