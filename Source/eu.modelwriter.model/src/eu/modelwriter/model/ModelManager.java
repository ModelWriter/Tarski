package eu.modelwriter.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;
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

  public Atom addAtom(List<RelationSet> relationSets, final Serializable data, final BOUND bound)
      throws InvalidArityException {
    if (relationSets == null) {
      relationSets = Arrays.asList(new RelationSet[] {});
    }

    final Atom atom;
    final String id = UUID.randomUUID().toString();
    atom = new Atom(relationSets, id, data, bound);

    if (relationSets.size() == 0) {
      ModelManager.universe.addStrayedAtom(atom);
    } else {
      ModelManager.universe.addAtom(atom);
      for (int i = 0; i < relationSets.size(); i++) {
        final Tuple unaryTuple = this.addTuple(relationSets.get(i), data, bound, 1, atom);
        atom.addTuplesIn(unaryTuple);
        relationSets.get(i).addTuple(unaryTuple);
      }
    }
    this.notifyAllObservers(atom, UpdateType.ADD_ATOM);
    return atom;
  }

  public RelationSet addRelationSet(final String name, final int arity) {
    final RelationSet relationSet = new RelationSet(name, arity);
    ModelManager.universe.addRelationSet(relationSet);
    return relationSet;
  }

  public Tuple addTuple(final RelationSet relationSet, final Serializable data, final BOUND bound,
      final int arity, final Atom... atoms) throws InvalidArityException {
    if (arity != atoms.length) {
      throw new InvalidArityException();
    }

    final List<RelationSet> relationSets;
    if (relationSet == null) {
      relationSets = Arrays.asList(new RelationSet[] {});
    } else {
      relationSets = Arrays.asList(new RelationSet[] {relationSet});
    }

    final Tuple tuple;
    final String id = UUID.randomUUID().toString();
    tuple = new Tuple(relationSet, id, data, bound, arity, atoms);

    if (relationSets.size() == 0) {
      ModelManager.universe.addStrayedTuple(tuple);
    } else {
      ModelManager.universe.addTuple(tuple);
      try {
        relationSet.addTuple(tuple);
      } catch (final InvalidArityException e) {
        e.printStackTrace();
      }
    }
    this.notifyAllObservers(tuple, UpdateType.ADD_TUPLE);
    return tuple;
  }

  public void boundAboutToChange(final ModelElement modelElement, final String string)
      throws NoSuchModelElementException {
    if (modelElement instanceof Atom) {
      final Atom atom = this.getAtom(modelElement.getID());
      for (final Tuple tuple : atom.getTuplesIn()) {
        if (tuple.getArity() == 1) {
          tuple.setBound(BOUND.valueOf(string));
          this.notifyAllObservers(tuple, UpdateType.valueOf(string));
        }
      }
    } else if (modelElement instanceof Tuple) {
      final Tuple tuple = this.getTuple(modelElement.getID());
      tuple.setBound(BOUND.valueOf(string));
      this.notifyAllObservers(tuple, UpdateType.valueOf(string));
    }
  }

  public void changeRelationSetsOfAtom(final String id, final List<String> newRelationSetsNames)
      throws InvalidArityException, NoSuchModelElementException {
    final Atom atom = this.getAtom(id);
    final Iterator<Tuple> tuplesInIter = atom.getTuplesIn().iterator();
    while (tuplesInIter.hasNext()) {
      final Tuple tuple = tuplesInIter.next();
      if (tuple.getArity() == 1) {
        this.removeTuple(tuple.getID());
        tuplesInIter.remove();
      }
    }
    final List<RelationSet> newRelationSets = this.getRelationSets(newRelationSetsNames);
    for (final RelationSet relationSet : newRelationSets) {
      final Tuple tuple = this.addTuple(relationSet, atom.getData(), atom.getBound(), 1, atom);
      atom.addTuplesIn(tuple);
      relationSet.addTuple(tuple);
    }
    atom.setRelationSets(newRelationSets);
    this.notifyAllObservers(atom, UpdateType.CHANGE_RELATION_SETS);
  }

  public List<Atom> getAllAtoms() {
    return Stream.concat(ModelManager.universe.getStrayedAtoms().stream(),
        ModelManager.universe.getAtoms().stream()).collect(Collectors.toList());
  }

  public List<String> getAllRelationSetsNames() {
    final List<String> relationSetsNames = new ArrayList<String>();
    for (final RelationSet relationSet : ModelManager.universe.getRelationSets()) {
      relationSetsNames.add(relationSet.getName());
    }
    return relationSetsNames;
  }

  public List<Tuple> getAllTuples() {
    return Stream.concat(ModelManager.universe.getStrayedTuples().stream(),
        ModelManager.universe.getTuples().stream()).collect(Collectors.toList());
  }

  public Atom getAtom(final String id) throws NoSuchModelElementException {
    if (ModelManager.universe.containsStrayedAtom(id)) {
      return ModelManager.universe.getStrayedAtom(id);
    } else if (ModelManager.universe.containsAtom(id)) {
      return ModelManager.universe.getAtom(id);
    }
    throw new NoSuchModelElementException();
  }

  public List<String> getNaryRelationSetNames() {
    final List<String> naryRelationNames = new ArrayList<String>();
    for (final RelationSet relationSet : ModelManager.universe.getRelationSets()) {
      if (relationSet.getArity() > 1) {
        naryRelationNames.add(relationSet.getName());
      }
    }
    return naryRelationNames;
  }

  public RelationSet getRelationSet(final String relationSetName) {
    return ModelManager.universe.getRelationSet(relationSetName);
  }

  public List<RelationSet> getRelationSets() {
    return ModelManager.universe.getRelationSets();
  }

  public List<RelationSet> getRelationSets(final List<String> relationSetNames) {
    final List<RelationSet> relationSets = new ArrayList<RelationSet>();
    for (final String relationSetName : relationSetNames) {
      final RelationSet relationSet = this.getRelationSet(relationSetName);
      if (relationSet != null) {
        relationSets.add(relationSet);
      }
    }
    return relationSets;
  }

  public Tuple getTuple(final String id) throws NoSuchModelElementException {
    if (ModelManager.universe.containsStrayedTuple(id)) {
      return ModelManager.universe.getStrayedTuple(id);
    } else if (ModelManager.universe.containsTuple(id)) {
      return ModelManager.universe.getTuple(id);
    }
    throw new NoSuchModelElementException();
  }

  public List<String> getUnaryRelationSetNames() {
    final List<String> unaryRelationSetNames = new ArrayList<String>();
    unaryRelationSetNames.add("Univ");
    for (final RelationSet relationSet : ModelManager.universe.getRelationSets()) {
      if (relationSet.getArity() == 1) {
        unaryRelationSetNames.add(relationSet.getName());
      }
    }
    return unaryRelationSetNames;
  }

  public boolean removeAtom(final String id) throws NoSuchModelElementException {
    boolean removed = false;
    final Atom atom = this.getAtom(id);
    if (atom.getRelationSets().size() == 0) {
      removed = ModelManager.universe.removeStrayedAtom(id);
    } else {
      removed = ModelManager.universe.removeAtom(id);
      for (final Tuple tupleIn : atom.getTuplesIn()) {
        this.removeTuple(tupleIn.getID());
      }
    }
    if (removed) {
      this.notifyAllObservers(atom, UpdateType.REMOVE_ATOM);
      return true;
    }
    throw new NoSuchModelElementException();
  }

  public boolean removeModelElement(final ModelElement element) throws NoSuchModelElementException {
    if (element instanceof Atom) {
      return this.removeAtom(element.getID());
    } else if (element instanceof Tuple) {
      return this.removeTuple(element.getID());
    }
    throw new NoSuchModelElementException();
  }

  public boolean removeTuple(final String id) throws NoSuchModelElementException {
    boolean removed = false;
    final Tuple tuple = this.getTuple(id);
    if (tuple.getRelationSets().size() == 0) {
      removed = ModelManager.universe.removeStrayedTuple(id);
    } else {
      removed = ModelManager.universe.removeTuple(id);
      final Iterator<RelationSet> relationSetIter = tuple.getRelationSets().iterator();
      while (relationSetIter.hasNext()) {
        final RelationSet relationSet = relationSetIter.next();
        relationSet.removeTuple(tuple.getID());
      }
    }
    if (removed) {
      this.notifyAllObservers(tuple, UpdateType.REMOVE_TUPLE);
      return true;
    }
    throw new NoSuchModelElementException();
  }
}
