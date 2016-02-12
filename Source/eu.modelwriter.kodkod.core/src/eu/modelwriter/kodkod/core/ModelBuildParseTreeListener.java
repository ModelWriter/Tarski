package eu.modelwriter.kodkod.core;

import eu.modelwriter.kodkod.core.model.Atom;
import eu.modelwriter.kodkod.core.model.Relation;
import eu.modelwriter.kodkod.core.model.Tuple;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodBaseListener;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.CartesianProductContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.NestedMultiplicityContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SetOperationsOnTypesContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleSetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;

public class ModelBuildParseTreeListener extends KodkodBaseListener {

  private static Universe universe;
  private Relation currentRelation;
  private String currentRelationName;
  private Tuple currentTuple;
  private boolean isUniverseOK;
  private boolean isLowerBound;

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
    if (!this.isUniverseOK) {
      final Atom newAtom = new Atom(ctx.getText());
      if (!ModelBuildParseTreeListener.universe.contains(newAtom)) {
        ModelBuildParseTreeListener.universe.getAtoms().add(newAtom);
      }
    } else {
      final Atom atom = ModelBuildParseTreeListener.universe.getAtom(ctx.getText());
      if (atom != null) {
        this.currentTuple.addAtom(atom);
      }
    }
  }

  @Override
  public void enterCartesianProduct(final CartesianProductContext ctx) {
    super.enterCartesianProduct(ctx);
  }

  @Override
  public void enterNestedMultiplicity(final NestedMultiplicityContext ctx) {
    super.enterNestedMultiplicity(ctx);
  }

  /**
   * su anki relation ismi belirlenir ve bound u belirlenir.
   */
  @Override
  public void enterRelation(final RelationContext ctx) {
    this.currentRelationName = ctx.IDENTIFIER().getText();
    this.currentRelation = new Relation(this.currentRelationName);
    this.isLowerBound = true;
  }

  @Override
  public void enterSet(final SetContext ctx) {
    super.enterSet(ctx);
  }

  @Override
  public void enterSetOperationsOnTypes(final SetOperationsOnTypesContext ctx) {
    super.enterSetOperationsOnTypes(ctx);
  }

  /**
   * yeni tuple olusturulur ve referansi su anki relation a eklenir.
   */
  @Override
  public void enterTuple(final TupleContext ctx) {
    this.currentTuple = new Tuple(ctx.getText());
    this.currentTuple.setLowerBound(this.isLowerBound);
    this.currentRelation.addTuple(this.currentTuple);
  }

  /**
   * yeni universe olusturulur.
   */
  @Override
  public void enterUniverse(final UniverseContext ctx) {
    this.isUniverseOK = false;
  }

  @Override
  public void exitRelations(final RelationsContext ctx) {
    ModelBuildParseTreeListener.universe.addRelation(this.currentRelation);
  }

  @Override
  public void exitTupleSet(final TupleSetContext ctx) {
    this.isLowerBound = false;
  }

  @Override
  public void exitUniverse(final UniverseContext ctx) {
    this.isUniverseOK = true;
  }

  public Universe getUniverse() {
    return ModelBuildParseTreeListener.universe;
  }
}
