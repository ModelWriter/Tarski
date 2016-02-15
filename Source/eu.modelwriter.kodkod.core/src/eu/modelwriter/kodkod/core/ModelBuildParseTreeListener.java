package eu.modelwriter.kodkod.core;

import java.util.ArrayList;
import java.util.HashMap;

import eu.modelwriter.kodkod.core.model.Atom;
import eu.modelwriter.kodkod.core.model.Relation;
import eu.modelwriter.kodkod.core.model.Tuple;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.core.recognizer.KodkodBaseListener;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProductContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleSetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.VarContext;

public class ModelBuildParseTreeListener extends KodkodBaseListener {

  private static Universe universe;
  private Relation currentRelation;
  private String currentRelationName;
  private Tuple currentTuple;
  private boolean isUniverseOK;
  private boolean isLowerBound;
  private ArrayList<String> domainNRange;
  private HashMap<Relation, ArrayList<String>> domainNRange4Rel;

  public ModelBuildParseTreeListener() {
    ModelBuildParseTreeListener.universe = new Universe();
  }

  /**
   * universe tamamlanmissa, su anki atomun referansi, universe un icinden bulunur, su anki tuple a
   * bu referans eklenir. <br>
   * universe tamamlanmamissa universe e yeni atom eklenir.
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
  public void enterProduct(final ProductContext ctx) {
    this.domainNRange.add(ctx.left.getText());
    this.domainNRange.add(ctx.right.getText());
    super.enterProduct(ctx);
  }

  /**
   * su anki relation ismi belirlenir ve bound u belirlenir.
   */
  @Override
  public void enterRelation(final RelationContext ctx) {
    this.currentRelationName = ctx.IDENTIFIER().getText();
    this.currentRelation = new Relation(this.currentRelationName);
    this.isLowerBound = true;
    this.domainNRange = new ArrayList<String>();
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
  public void enterVar(final VarContext ctx) {
    super.enterVar(ctx);
  }

  @Override
  public void exitProduct(final ProductContext ctx) {
    super.exitProduct(ctx);
  }

  @Override
  public void exitRelations(final RelationsContext ctx) {
    if (!ModelBuildParseTreeListener.universe.contains(this.currentRelation)) {
      ModelBuildParseTreeListener.universe.addRelation(this.currentRelation);
    }
  }

  @Override
  public void exitTupleSet(final TupleSetContext ctx) {
    this.isLowerBound = false;
  }

  @Override
  public void exitUniverse(final UniverseContext ctx) {
    this.isUniverseOK = true;
  }

  @Override
  public void exitVar(final VarContext ctx) {
    super.exitVar(ctx);
  }

  public Universe getUniverse() {
    return ModelBuildParseTreeListener.universe;
  }

  public void setUniverseOK(final boolean isUniverseOK) {
    this.isUniverseOK = isUniverseOK;
  }
}
