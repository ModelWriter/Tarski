package eu.modelwriter.kodkod.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import eu.modelwriter.kodkod.core.model.Atom;
import eu.modelwriter.kodkod.core.model.Relation;
import eu.modelwriter.kodkod.core.model.Tuple;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodBaseVisitor;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProblemContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProductContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleSetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.VarContext;

public class ModelBuildVisitor extends KodkodBaseVisitor<Object> {

  private Universe universe;
  private boolean isLowerBound;
  private final HashMap<String, ArrayList<String>> domainNRange4Rel =
      new HashMap<String, ArrayList<String>>();
  private final HashMap<String, String> unaryNParent = new HashMap<String, String>();

  public Universe getUniverse() {
    return this.universe;
  }

  private void setTypes() {
    for (final Entry<String, ArrayList<String>> entry : this.domainNRange4Rel.entrySet()) {
      final Relation[] types = new Relation[2];
      types[0] = this.universe.getRelation(entry.getValue().get(0));
      types[1] = this.universe.getRelation(entry.getValue().get(1));
      final Relation aRelation = this.universe.getRelation(entry.getKey());

      while (types[0].getParent() != null) {
        types[0] = types[0].getParent();
      }
      aRelation.setParent(types[0]);
      aRelation.addTypes(types);
    }
  }

  private void setUnaryParents() {
    for (final Entry<String, String> entry : this.unaryNParent.entrySet()) {
      this.universe.getRelation(entry.getKey())
          .setParent(this.universe.getRelation(entry.getValue()));
    }
  }

  @Override
  public Atom visitAtom(final AtomContext ctx) {
    final Atom newAtom =
        new Atom(ctx.IDENTIFIER() == null ? ctx.INT().getText() : ctx.IDENTIFIER().getText());
    return newAtom;
  }

  @Override
  public Universe visitProblem(final ProblemContext ctx) {
    this.visitUniverse(ctx.universe());
    final List<RelationsContext> relations = ctx.relations();
    for (final RelationsContext relationsContext : relations) {
      this.universe.addRelation(this.visitRelations(relationsContext));
    }

    this.setUnaryParents();
    this.setTypes();
    return this.universe;
  }

  @Override
  public ArrayList<String> visitProduct(final ProductContext ctx) {
    final ArrayList<String> domainNRange = new ArrayList<String>();
    domainNRange.add((String) this.visit(ctx.left));
    domainNRange.add((String) this.visit(ctx.right));
    return domainNRange;
  }

  @Override
  public String visitRelation(final RelationContext ctx) {
    return ctx.IDENTIFIER().getText();
  }

  @Override
  public Relation visitRelations(final RelationsContext ctx) {
    final Relation newRelation = new Relation(this.visitRelation(ctx.relation()));
    if (ctx.expression() != null) {
      if (this.visit(ctx.expression()) instanceof ArrayList<?>) {
        this.domainNRange4Rel.put(newRelation.getName(),
            (ArrayList<String>) this.visit(ctx.expression()));
      } else {
        this.unaryNParent.put(newRelation.getName(), (String) this.visit(ctx.expression()));
      }
    }

    final TupleSetContext lBtupleSet = ctx.tupleSet(0);
    this.isLowerBound = true;
    final ArrayList<Tuple> lBTuples = this.visitTupleSet(lBtupleSet);
    for (final Tuple tuple : lBTuples) {
      newRelation.addTuple(tuple);
    }

    final TupleSetContext uBtupleSet = ctx.tupleSet(1);
    if (uBtupleSet != null) {
      this.isLowerBound = false;
      final ArrayList<Tuple> uBTuples = this.visitTupleSet(uBtupleSet);
      for (final Tuple tuple : uBTuples) {
        newRelation.addTuple(tuple);
      }
    }
    return newRelation;
  }

  @Override
  public Tuple visitTuple(final TupleContext ctx) {
    final Tuple newTuple = new Tuple();
    final List<AtomContext> atom = ctx.atom();
    for (final AtomContext atomContext : atom) {
      newTuple.addAtom(this.visitAtom(atomContext));
    }
    newTuple.setLowerBound(this.isLowerBound);
    return newTuple;
  }


  @Override
  public ArrayList<Tuple> visitTupleSet(final TupleSetContext ctx) {
    final ArrayList<Tuple> tuples = new ArrayList<Tuple>();
    final List<TupleContext> tuple = ctx.tuple();
    for (final TupleContext tupleContext : tuple) {
      tuples.add(this.visitTuple(tupleContext));
    }
    return tuples;
  }


  @Override
  public Universe visitUniverse(final UniverseContext ctx) {
    this.universe = new Universe();
    final List<AtomContext> atoms = ctx.atom();
    for (final AtomContext atomContext : atoms) {
      this.universe.addAtom(this.visitAtom(atomContext));
    }
    return this.universe;
  }

  @Override
  public String visitVar(final VarContext ctx) {
    return ctx.getText();
  }
}
