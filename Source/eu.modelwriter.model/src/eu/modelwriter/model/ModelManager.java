package eu.modelwriter.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
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

  public Atom addAtom(List<String> sets, final Serializable data, final BOUND bound) {
    if (sets == null) {
      sets = Arrays.asList(new String[] {Universe.SET_UNIV});
    }

    final Atom atom;
    final String id = UUID.randomUUID().toString();
    atom = new Atom(sets, id, data);


    if (sets.get(0).equals(Universe.SET_UNIV)) {
      ModelManager.universe.addStrayedAtom(atom);
    } else {
      final Relation[] relations = ModelManager.universe.getRelations(sets);

      try {
        for (int i = 0; i < relations.length; i++) {
          relations[i].addTuple(new Tuple(relations[i].getName(), id, data, bound, 1, atom));
        }
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
    tuple = new Tuple(set, id, data, bound, arity, atoms);

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
