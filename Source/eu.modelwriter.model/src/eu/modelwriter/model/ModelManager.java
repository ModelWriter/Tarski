package eu.modelwriter.model;

import java.io.Serializable;
import java.util.Random;

import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.observer.Subject;

public class ModelManager extends Subject {
  private static ModelManager manager;
  private static final Universe universe = new Universe();

  public static ModelManager getInstance() {
    if (ModelManager.manager == null) {
      ModelManager.manager = new ModelManager();
    }
    return ModelManager.manager;
  }

  public Atom addAtom(String set, final Serializable data) {
    final Atom atom;
    if (set == null) {
      set = Universe.SET_UNIV;
      // final String id = set + " : " + UUID.randomUUID();
      final String id = set + new Random().nextInt(1000);
      atom = new Atom(set, id, data);

      ModelManager.universe.addStrayedAtom(atom);
    } else {
      // final String id = set + " : " + UUID.randomUUID();
      final String id = set + new Random().nextInt(1000);
      atom = new Atom(set, id, data);

      final Relation relation = ModelManager.universe.getRelation(set);

      try {
        relation.addTuple(new Tuple(set, null, null, 1, null, atom));
      } catch (final InvalidArityException e) {
        e.printStackTrace();
      }
    }
    return atom;
  }

  public Relation addRelation(final String name, final int arity) {
    final Relation relation = new Relation(name, arity);
    ModelManager.universe.addRelation(relation);
    return relation;
  }

  public Tuple addTuple(String set, final Serializable data, final int arity, final String bound,
      final Atom... atoms) throws InvalidArityException {
    final Tuple tuple;
    if (set == null) {
      set = Universe.SET_UNIV;
      // final String id = set + " : " + UUID.randomUUID();
      final String id = set + new Random().nextInt(1000);
      tuple = new Tuple(set, id, data, arity, bound, atoms);

      ModelManager.universe.addStrayedTuple(tuple);
    } else {
      // final String id = set + " : " + UUID.randomUUID();
      final String id = set + new Random().nextInt(1000);
      tuple = new Tuple(set, id, data, arity, bound, atoms);

      final Relation relation = ModelManager.universe.getRelation(set);

      try {
        relation.addTuple(tuple);
      } catch (final InvalidArityException e) {
        e.printStackTrace();
      }
    }
    return tuple;
  }

  public Universe getUniverse() {
    return ModelManager.universe;
  }
}
