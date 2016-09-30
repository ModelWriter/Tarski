package eu.modelwriter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.model.observer.Subject;
import eu.modelwriter.model.observer.UpdateType;

public class ModelManager extends Subject {
  public static final ModelManager instance = new ModelManager();
  static final Universe universe = new Universe();

  /**
   * 
   * @param relations
   * @param label
   * @param data
   * @param bound
   * @return atom id
   * @throws InvalidArityException
   * @throws NoSuchModelElementException
   */
  public String addAtom(final List<String> relationIDs, final String label, final Serializable data,
      final BOUND bound) throws InvalidArityException, NoSuchModelElementException {
    final List<Relation> relations = new ArrayList<>();
    if (relationIDs != null) {
      for (final String relationID : relationIDs) {
        relations.add(ModelManager.universe.getRelation(relationID));
      }
    }

    final Atom atom;
    final String atomID = UUID.randomUUID().toString();
    atom = new Atom(relations, label, atomID, data, bound);

    if (relations.size() == 0) {
      ModelManager.universe.addStrayedAtom(atom);
    } else {
      ModelManager.universe.addAtom(atom);
      for (int i = 0; i < relations.size(); i++) {
        final String tupleID = addTuple(relations.get(i).getID(), data, bound, 1, atomID);
        Tuple unaryTuple = null;
        unaryTuple = ModelUtil.instance.getTuple(tupleID);
        atom.addTupleIn(unaryTuple);
        relations.get(i).addTuple(unaryTuple);
      }
    }
    notifyAllObservers(atom, UpdateType.ADD_ATOM);
    return atomID;
  }

  /**
   * 
   * @param relations
   * @param data
   * @param bound
   * @return atom id
   * @throws InvalidArityException
   * @throws NoSuchModelElementException
   */
  public String addAtom(final List<String> relationIDs, final Serializable data, final BOUND bound)
      throws InvalidArityException, NoSuchModelElementException {
    return addAtom(relationIDs, null, data, bound);
  }

  /**
   * 
   * @param name
   * @param arity
   * @return relation id
   */
  public String addRelation(final String name, final int arity) {
    final String relationID = UUID.randomUUID().toString();
    final Relation relation = new Relation(relationID, name, arity);
    ModelManager.universe.addRelation(relation);
    return relationID;
  }

  /**
   * 
   * @param relation
   * @param data
   * @param bound
   * @param arity
   * @param atomIDs
   * @return tuple id
   * @throws InvalidArityException
   */
  public String addTuple(final String relationID, final Serializable data, final BOUND bound,
      final int arity, final String... atomIDs) throws InvalidArityException {
    if (arity != atomIDs.length) {
      throw new InvalidArityException();
    }

    final Atom[] atoms = new Atom[atomIDs.length];
    for (int i = 0; i < atomIDs.length; i++) {
      try {
        atoms[i] = ModelUtil.instance.getAtom(atomIDs[i]);
      } catch (final NoSuchModelElementException e) {
        e.printStackTrace();
      }
    }
    final Relation relation = ModelUtil.instance.getRelation(relationID);

    final Tuple tuple;
    final String id = UUID.randomUUID().toString();
    tuple = new Tuple(relation, id, data, bound, arity, atoms);

    if (relation == null) {
      ModelManager.universe.addStrayedTuple(tuple);
    } else {
      ModelManager.universe.addTuple(tuple);
      relation.addTuple(tuple);
    }
    notifyAllObservers(tuple, UpdateType.ADD_TUPLE);
    return id;
  }

  public void boundAboutToChange(final ModelElement modelElement, final String string)
      throws NoSuchModelElementException {
    if (modelElement instanceof Atom) {
      final Atom atom = ModelUtil.instance.getAtom(modelElement.getID());
      for (final Tuple tuple : atom.getTuplesIn()) {
        if (tuple.getArity() == 1) {
          tuple.setBound(BOUND.valueOf(string));
          notifyAllObservers(tuple, UpdateType.valueOf(string));
        }
      }
    } else if (modelElement instanceof Tuple) {
      final Tuple tuple = ModelUtil.instance.getTuple(modelElement.getID());
      tuple.setBound(BOUND.valueOf(string));
      notifyAllObservers(tuple, UpdateType.valueOf(string));
    }
  }

  public void changeRelationsInOfAtom(final String atomID, final List<String> newRelationsInNames)
      throws InvalidArityException, NoSuchModelElementException {
    final Atom atom = ModelUtil.instance.getAtom(atomID);
    final Iterator<Tuple> tuplesInIter = atom.getTuplesIn().iterator();
    while (tuplesInIter.hasNext()) {
      final Tuple tuple = tuplesInIter.next();
      if (tuple.getArity() == 1) {
        removeTuple(tuple.getID());
        tuplesInIter.remove();
      }
    }
    final List<Relation> newRelations = ModelUtil.instance.getRelations(newRelationsInNames);
    for (final Relation relation : newRelations) {
      final String tupleID = addTuple(relation.getID(), atom.getData(), atom.getBound(), 1, atomID);
      final Tuple tuple = ModelUtil.instance.getTuple(tupleID);
      atom.addTupleIn(tuple);
      relation.addTuple(tuple);
    }
    atom.setRelationsIn(newRelations);
    notifyAllObservers(atom, UpdateType.CHANGE_RELATION_IN);
  }

  public boolean removeAtom(final String atomID) throws NoSuchModelElementException {
    boolean removed = false;
    final Atom atom = ModelUtil.instance.getAtom(atomID);
    if (atom.getRelationsIn().size() == 0) {
      removed = ModelManager.universe.removeStrayedAtom(atomID);
    } else {
      removed = ModelManager.universe.removeAtom(atomID);
      for (final Tuple tupleIn : atom.getTuplesIn()) {
        removeTuple(tupleIn.getID());
      }
    }
    if (removed) {
      notifyAllObservers(atom, UpdateType.REMOVE_ATOM);
      return true;
    }
    throw new NoSuchModelElementException();
  }

  public boolean removeModelElement(final ModelElement element) throws NoSuchModelElementException {
    if (element instanceof Atom) {
      return removeAtom(element.getID());
    } else if (element instanceof Tuple) {
      return removeTuple(element.getID());
    }
    throw new NoSuchModelElementException();
  }

  public boolean removeTuple(final String tupleID) throws NoSuchModelElementException {
    boolean removed = false;
    final Tuple tuple = ModelUtil.instance.getTuple(tupleID);
    if (tuple.getRelationIn() == null) {
      removed = ModelManager.universe.removeStrayedTuple(tupleID);
    } else {
      removed = ModelManager.universe.removeTuple(tupleID);
      final Relation relation = tuple.getRelationIn();
      relation.removeTuple(tuple.getID());
    }
    if (removed) {
      notifyAllObservers(tuple, UpdateType.REMOVE_TUPLE);
      return true;
    }
    throw new NoSuchModelElementException();
  }
}
