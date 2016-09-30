package eu.modelwriter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import eu.modelwriter.model.exception.NoSuchModelElementException;

public class ModelUtil {
  public static final ModelUtil instance = new ModelUtil();

  private ModelUtil() {}

  public ModelElement getModelElement(final String elementID) throws NoSuchModelElementException {
    ModelElement element = null;
    try {
      element = getAtom(elementID);
      return element;
    } catch (final NoSuchModelElementException e) {
      try {
        element = getTuple(elementID);
        return element;
      } catch (final NoSuchModelElementException e1) {
        throw new NoSuchModelElementException();
      }
    }
  }

  public List<String> getAtomIDs() {
    return Stream
        .concat(ModelManager.universe.getStrayedAtoms().stream().map(a -> a.getID()),
            ModelManager.universe.getAtoms().stream().map(a -> a.getID()))
        .collect(Collectors.toList());
  }

  public List<Atom> getAtoms() {
    return Stream.concat(ModelManager.universe.getStrayedAtoms().stream(),
        ModelManager.universe.getAtoms().stream()).collect(Collectors.toList());
  }

  public List<String> getRelationsNames() {
    final List<String> relationsNames = new ArrayList<String>();
    for (final Relation relation : ModelManager.universe.getRelations()) {
      relationsNames.add(relation.getName());
    }
    return relationsNames;
  }

  public List<String> getRelationsIDs() {
    final List<String> relationsIDs = new ArrayList<String>();
    for (final Relation relation : ModelManager.universe.getRelations()) {
      relationsIDs.add(relation.getID());
    }
    return relationsIDs;
  }

  public List<String> getTupleIDs() {
    return Stream
        .concat(ModelManager.universe.getStrayedTuples().stream().map(t -> t.getID()),
            ModelManager.universe.getTuples().stream().map(t -> t.getID()))
        .collect(Collectors.toList());
  }

  public List<Tuple> getTuples() {
    return Stream.concat(ModelManager.universe.getStrayedTuples().stream(),
        ModelManager.universe.getTuples().stream()).collect(Collectors.toList());
  }

  Atom getAtom(final String id) throws NoSuchModelElementException {
    if (ModelManager.universe.containsStrayedAtom(id)) {
      return ModelManager.universe.getStrayedAtom(id);
    } else if (ModelManager.universe.containsAtom(id)) {
      return ModelManager.universe.getAtom(id);
    }
    throw new NoSuchModelElementException();
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

  public Relation getRelation(final String relationID) {
    return ModelManager.universe.getRelation(relationID);
  }

  public List<Relation> getRelations() {
    return ModelManager.universe.getRelations();
  }

  public List<Relation> getRelations(final List<String> relationsIDs) {
    final List<Relation> relations = new ArrayList<Relation>();
    for (final String relationID : relationsIDs) {
      final Relation relation = getRelation(relationID);
      if (relation != null) {
        relations.add(relation);
      }
    }
    return relations;
  }

  public Tuple getTuple(final String tupleID) throws NoSuchModelElementException {
    if (ModelManager.universe.containsStrayedTuple(tupleID)) {
      return ModelManager.universe.getStrayedTuple(tupleID);
    } else if (ModelManager.universe.containsTuple(tupleID)) {
      return ModelManager.universe.getTuple(tupleID);
    }
    throw new NoSuchModelElementException();
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

  public String findRelationID(final String relationName) {
    final String relationID = null;
    // TODO FIND RELATION AND RETURN ID
    return relationID;
  }

  public List<String> findRelationsIDs(final List<String> relationsNames) {
    final List<String> relationIDs = null;
    // TODO FIND RELATION AND RETURN IDS
    return relationIDs;
  }
}
