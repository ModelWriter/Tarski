package eu.modelwriter.model;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import eu.modelwriter.model.Tuple.BOUND;
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

  public Atom addAtom(String set, final Serializable data, final BOUND bound) {
    if (set == null) {
      set = Universe.SET_UNIV;
    }

    final Atom atom;
    final String id = UUID.randomUUID().toString();
    final String label = set.substring(0, 1) + new Random().nextInt(1000);
    atom = new Atom(set, label, id, data);

    if (set.equals(Universe.SET_UNIV)) {
      ModelManager.universe.addStrayedAtom(atom);
    } else {
      final Relation relation = ModelManager.universe.getRelation(set);

      try {
        relation.addTuple(new Tuple(set, set, id, data, bound, 1, atom));
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

  public Tuple addTuple(String set, final Serializable data, final BOUND bound, final int arity,
      final Atom... atoms) throws InvalidArityException {
    if (arity != atoms.length) {
      throw new InvalidArityException();
    }

    if (set == null) {
      set = Universe.SET_UNIV;
    }

    final Tuple tuple;
    final String id = UUID.randomUUID().toString();
    tuple = new Tuple(set, set, id, data, bound, arity, atoms);

    if (set.equals(Universe.SET_UNIV)) {
      ModelManager.universe.addStrayedTuple(tuple);
    } else {
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
