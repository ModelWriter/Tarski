package eu.modelwriter.kodkod.core;

import java.util.ArrayList;
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

  private Universe universe;
  private boolean isUniverseOK = false;
  private Relation currentRelation;
  private String currentRelationName;
  private Tuple currentTuple;
  private Atom currentAtom;

  /**
   * universe tamamlanmissa, su anki atomun referansi, universe un icinden bulunur, su anki tuple a
   * bu referans eklenir. <br>
   * universe tamamlanmamissa univers e yeni atom eklenir.
   */
  @Override
  public void enterAtom(final AtomContext ctx) {
    if (this.isUniverseOK) {
      final ArrayList<Atom> atoms = this.universe.getAtoms();
      for (final Atom atom : atoms) {
        if (atom.getText().equals(ctx.getText())) {
          this.currentAtom = atom;
        }
      }
      this.currentTuple.addAtom(this.currentAtom);
    } else {
      this.currentAtom = new Atom(ctx.getText());
      if (!this.universe.contains(this.currentAtom)) {
        this.universe.addAtom(this.currentAtom);
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
    this.currentRelation = new Relation(this.currentRelationName);
    this.universe.addRelation(this.currentRelation);
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
    this.universe = new Universe();
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
      final ArrayList<Relation> relationsInTheUniverse = this.universe.getRelations();
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
    return this.universe;
  }
}
