package eu.modelwriter.kodkod.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eu.modelwriter.kodkod.core.model.Atom;
import eu.modelwriter.kodkod.core.model.Relation;
import eu.modelwriter.kodkod.core.model.Tuple;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodBaseListener;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelBoundContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;

public class ModelBuildParseTreeListener extends KodkodBaseListener {

  private static Universe universe;
  private Relation currentRelation;
  private String currentRelationName;
  private Tuple currentTuple;
  private boolean isUniverseOK;

  public ModelBuildParseTreeListener() {
    ModelBuildParseTreeListener.universe = new Universe();
  }

  /**
   * universe tamamlanmissa, su anki atomun referansi, universe un icinden bulunur, su anki tuple a
   * bu referans eklenir. <br>
   * universe tamamlanmamissa univers e yeni atom eklenir.
   */
  @Override
  public void enterAtom(final AtomContext ctx) {
    if (this.isUniverseOK) {
      final ArrayList<Atom> atoms = ModelBuildParseTreeListener.universe.getAtoms();
      for (final Atom atom : atoms) {
        if (atom.getText().equals(ctx.getText())) {
          this.currentTuple.addAtom(atom);
          break;
        }
      }
    }
  }

  /**
   * su anki relation ismi belirlenir.
   */
  @Override
  public void enterRelation(final RelationContext ctx) {
    this.currentRelationName = ctx.IDENTIFIER().getText();
  }

  /**
   * yeni relation olusturulur ve referansi universe e eklenir.
   */
  @Override
  public void enterRelBound(final RelBoundContext ctx) {
    this.enterRelation(ctx.relation);
    final Iterator<Relation> relations =
        ModelBuildParseTreeListener.universe.getRelations().iterator();
    while (relations.hasNext()) {
      final Relation relation = relations.next();
      if (relation.getName().equals(this.currentRelationName)) {
        relations.remove();
      }
    }
    this.currentRelation = new Relation(this.currentRelationName);
    ModelBuildParseTreeListener.universe.addRelation(this.currentRelation);
  }

  /**
   * yeni tuple olusturulur ve referansi su anki relation a eklenir.
   */
  @Override
  public void enterTuple(final TupleContext ctx) {
    this.currentTuple = new Tuple(ctx.getText());
    this.currentRelation.addTuple(this.currentTuple);
  }

  /**
   * yeni universe olusturulur.
   */
  @Override
  public void enterUniverse(final UniverseContext ctx) {
    for (final AtomContext atomContext : ctx.atoms) {
      final Atom atom = new Atom(atomContext.getText());
      if (!ModelBuildParseTreeListener.universe.contains(atom)) {
        ModelBuildParseTreeListener.universe.addAtom(atom);
      }
    }
  }

  /**
   * su anki iliskinin arity si 1 den buyukse; <br>
   * bu coklu iliskinin hangi diger iliskiler arasinda oldugunu bulmak icin; <br>
   * ilk tuple daki atomlarin tipleri, unary iliskiler arasindan bulunur. bu tipler bir diziye
   * atilip su anki coklu iliskinin tipleri olarak eklenir.
   */
  @Override
  public void exitRelBound(final RelBoundContext ctx) {
    if (this.currentRelation.getArity() > 1) {
      final Tuple firstTupleOfCurrentRelation = this.currentRelation.getTuples().get(0);
      final ArrayList<Atom> atomsOfFirstTuple = firstTupleOfCurrentRelation.getAtoms();
      final ArrayList<Relation> relationsInTheUniverse =
          ModelBuildParseTreeListener.universe.getRelations();
      final ArrayList<Relation> unaryRelations = new ArrayList<Relation>();
      for (final Relation r : relationsInTheUniverse) {
        if (r.getArity() == 1) {
          unaryRelations.add(r);
        }
      }
      final Relation[] types = new Relation[this.currentRelation.getArity()];
      for (int i = 0; i < this.currentRelation.getArity(); i++) {
        final Atom a = atomsOfFirstTuple.get(i);
        for (final Relation unaryRelation : unaryRelations) {
          final List<Tuple> tuples = unaryRelation.getTuples();
          for (final Tuple t : tuples) {
            final Atom atomInTheUnaryRelation = t.getAtom(0);
            if (atomInTheUnaryRelation.getText().equals(a.getText()) && types[i] == null) {
              types[i] = unaryRelation;
              break;
            }
          }
        }
      }
      this.currentRelation.setParent(types[0]);
      this.currentRelation.addTypes(types);
    }
  }

  @Override
  public void exitUniverse(final UniverseContext ctx) {
    this.isUniverseOK = true;
  }

  public Universe getUniverse() {
    return ModelBuildParseTreeListener.universe;
  }
}
