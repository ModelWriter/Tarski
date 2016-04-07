package eu.modelwriter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import eu.modelwriter.model.Tuple.BOUND;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.observer.Subject;
import eu.modelwriter.model.observer.UpdateType;

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
      sets = Arrays.asList(new String[] {});
    }

    final Atom atom;
    final String id = UUID.randomUUID().toString();
    atom = new Atom(sets, id, data);

    if (sets.size() == 0) {
      ModelManager.universe.addStrayedAtom(atom);
    } else {
      ModelManager.universe.addAtom(atom);
      try {
        for (int i = 0; i < sets.size(); i++) {
          final Tuple unaryTuple = new Tuple(sets.get(i), id, data, bound, 1, atom);
          atom.addTuplesIn(unaryTuple);
          ModelManager.universe.getRelation(sets.get(i)).addTuple(unaryTuple);
        }
      } catch (final InvalidArityException e) {
        e.printStackTrace();
      }
    }
    this.notifyAllObservers(atom, UpdateType.ADD_ATOM);
    return atom;
  }

  public Relation addRelation(final String name, final int arity) {
    final Relation relation = new Relation(name, arity);
    ModelManager.universe.addRelation(relation);
    return relation;
  }

  public Tuple addTuple(final String set, final Serializable data, final BOUND bound,
      final int arity, final Atom... atoms) throws InvalidArityException {
    if (arity != atoms.length) {
      throw new InvalidArityException();
    }

    final List<String> sets;
    if (set == null) {
      sets = Arrays.asList(new String[] {});
    } else {
      sets = Arrays.asList(new String[] {set});
    }

    final Tuple tuple;
    final String id = UUID.randomUUID().toString();
    tuple = new Tuple(set, id, data, bound, arity, atoms);

    if (sets.size() == 0) {
      ModelManager.universe.addStrayedTuple(tuple);
    } else {
      ModelManager.universe.addTuple(tuple);
      try {
        ModelManager.universe.getRelation(set).addTuple(tuple);
      } catch (final InvalidArityException e) {
        e.printStackTrace();
      }
    }
    this.notifyAllObservers(tuple, UpdateType.ADD_TUPLE);
    return tuple;
  }

  public List<String> getAllRelationNames() {
    final List<String> relationNames = new ArrayList<String>();
    for (final Relation relation : ModelManager.universe.getRelations()) {
      relationNames.add(relation.getName());
    }
    return relationNames;
  }

  private Atom getAtom(final String id) {
    return ModelManager.universe.getAtom(id);
  }

  public Atom getAtomClone(final String id) {
    return (Atom) ModelManager.universe.getAtom(id).clone();
  }

  public List<String> getNaryRelationNames() {
    final List<String> naryRelationNames = new ArrayList<String>();
    for (final Relation relation : ModelManager.universe.getRelations()) {
      if (relation.getArity() > 1) {
        naryRelationNames.add(relation.getName());
      }
    }
    return naryRelationNames;

  }

  public ArrayList<Relation> getRelationsCopy() {
    return new ArrayList<Relation>(ModelManager.universe.getRelations());
  }

  private Tuple getTuple(final String id) {
    return ModelManager.universe.getTuple(id);
  }

  public Tuple getTupleClone(final String id) {
    return (Tuple) ModelManager.universe.getTuple(id).clone();
  }

  public List<String> getUnaryRelationNames() {
    final List<String> unaryRelationNames = new ArrayList<String>();
    unaryRelationNames.add("Univ");
    for (final Relation relation : ModelManager.universe.getRelations()) {
      if (relation.getArity() == 1) {
        unaryRelationNames.add(relation.getName());
      }
    }
    return unaryRelationNames;
  }

  public boolean removeAtom(final String id) {
    boolean removed = false;
    final Atom atom = this.getAtom(id);
    if (atom.getSets().size() == 0) {
      removed = ModelManager.universe.removeStrayedAtom(id);
    } else {
      removed = ModelManager.universe.removeAtom(id);
    }
    if (removed) {
      this.notifyAllObservers(atom, UpdateType.REMOVE_ATOM);
      return true;
    }
    return false;
  }

  public boolean removeModelElement(final ModelElement element) {
    if (element instanceof Atom) {
      return this.removeAtom(element.getID());
    } else if (element instanceof Tuple) {
      return this.removeTuple(element.getID());
    }
    return false;
  }

  public boolean removeTuple(final String id) {
    boolean removed = false;
    final Tuple tuple = this.getTuple(id);
    if (tuple.getSets().size() == 0) {
      removed = ModelManager.universe.removeStrayedTuple(id);
    } else {
      removed = ModelManager.universe.removeTuple(id);
    }
    if (removed) {
      this.notifyAllObservers(tuple, UpdateType.REMOVE_TUPLE);
      return true;
    }
    return false;
  }
}
