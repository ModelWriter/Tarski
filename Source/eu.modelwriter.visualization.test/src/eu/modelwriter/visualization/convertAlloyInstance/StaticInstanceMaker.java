package eu.modelwriter.visualization.convertAlloyInstance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyModel;
import edu.mit.csail.sdg.alloy4viz.AlloyRelation;
import edu.mit.csail.sdg.alloy4viz.AlloySet;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import edu.mit.csail.sdg.alloy4viz.AlloyType;
import eu.modelwriter.visualization.convertAlloyInstance.model.Atom;
import eu.modelwriter.visualization.convertAlloyInstance.model.Relation;
import eu.modelwriter.visualization.convertAlloyInstance.model.Tuple;
import eu.modelwriter.visualization.convertAlloyInstance.model.Universe;

public class StaticInstanceMaker {
  private static Map<String, AlloyType> relation2AlloyType = new TreeMap<String, AlloyType>();
  private static Map<String, AlloySet> relation2AlloySet = new TreeMap<String, AlloySet>();
  private static Map<Relation, AlloyRelation> relation2AlloyRelation =
      new HashMap<Relation, AlloyRelation>();
  private static Map<String, AlloyType> atom2AlloyType = new TreeMap<String, AlloyType>();
  private static Map<String, AlloyAtom> atom2AlloyAtom = new TreeMap<String, AlloyAtom>();

  private static Map<AlloyAtom, Set<AlloySet>> createAlloyAtom2AlloySetMap(
      final Universe universe) {
    final Map<AlloyAtom, Set<AlloySet>> a2s = new TreeMap<AlloyAtom, Set<AlloySet>>();
    final ArrayList<Relation> relations = universe.getRelations();

    for (final Relation rel : relations) {
      if (rel.isUnary()) {
        final ArrayList<Tuple> tuples = rel.getTuples();
        for (int i = 0; i < tuples.size(); i++) {
          final Tuple tuple = tuples.get(i);
          final ArrayList<Atom> atoms = tuple.getAtoms();
          for (int j = 0; j < atoms.size(); j++) {
            final Atom a = atoms.get(j);
            final AlloyAtom atom = new AlloyAtom(
                StaticInstanceMaker.relation2AlloyType.get(rel.getName()), i, a.getText());
            final Set<AlloySet> set = new TreeSet<AlloySet>();
            set.add(StaticInstanceMaker.relation2AlloySet.get(rel.getName()));
            a2s.put(atom, set);
            StaticInstanceMaker.atom2AlloyType.put(atom.getOriginalName(), atom.getType());
            StaticInstanceMaker.atom2AlloyAtom.put(a.getText(), atom);
          }
        }
      }
    }

    return a2s;
  }

  private static Map<AlloyRelation, Set<AlloyTuple>> createAlloyRelation2AlloyTupleMap(
      final Universe universe) {
    final Map<AlloyRelation, Set<AlloyTuple>> r2t =
        new LinkedHashMap<AlloyRelation, Set<AlloyTuple>>();
    final ArrayList<Relation> relations = universe.getRelations();

    for (final Relation rel : relations) {
      if (!rel.isUnary()) {
        final ArrayList<Tuple> tuples = rel.getTuples();
        final Set<AlloyTuple> set = new TreeSet<AlloyTuple>();
        for (int i = 0; i < tuples.size(); i++) {
          final Tuple tuple = tuples.get(i);
          final ArrayList<Atom> atoms = tuple.getAtoms();
          final List<AlloyAtom> alloyAtoms = new ArrayList<AlloyAtom>();
          for (int j = 0; j < atoms.size(); j++) {
            final Atom a = atoms.get(j);
            alloyAtoms.add(StaticInstanceMaker.atom2AlloyAtom.get(a.getText()));
          }
          final AlloyTuple alloyTuple = new AlloyTuple(alloyAtoms);
          set.add(alloyTuple);
        }
        r2t.put(StaticInstanceMaker.relation2AlloyRelation.get(rel), set);
      }
    }

    return r2t;
  }

  private static Set<AlloyRelation> createAlloyRelations(final ArrayList<Relation> relations) {
    final Set<AlloyRelation> allRelations = new TreeSet<AlloyRelation>();

    for (final Relation relation : relations) {
      if (!relation.isUnary()) {
        final ArrayList<ArrayList<Relation>> listOfTypes = relation.getListOfTypes();
        for (final ArrayList<Relation> types : listOfTypes) {
          final List<AlloyType> listOfType = new ArrayList<AlloyType>();
          for (final Relation type : types) {
            listOfType.add(StaticInstanceMaker.relation2AlloyType.get(type.getName()));
          }
          if (listOfType.size() <= 1) {
            continue;
          }
          final AlloyRelation rel = new AlloyRelation(relation.getName(), relation.isPrivate(),
              relation.isMeta(), listOfType);
          StaticInstanceMaker.relation2AlloyRelation.put(relation, rel);
          allRelations.add(rel);
        }
      }
    }

    return allRelations;
  }

  private static Set<AlloySet> createAlloySets(final ArrayList<Relation> relations) {
    final Set<AlloySet> allSets = new TreeSet<AlloySet>();

    for (final Relation relation : relations) {
      if (relation.isUnary()) {
        final AlloySet set = new AlloySet(relation.getName(), relation.isPrivate(),
            relation.isMeta(), StaticInstanceMaker.relation2AlloyType.get(relation.getName()));
        StaticInstanceMaker.relation2AlloySet.put(relation.getName(), set);
        allSets.add(set);
      }
    }

    return allSets;
  }

  private static Set<AlloyType> createAlloyTypes(final ArrayList<Relation> relations) {
    final Set<AlloyType> allTypes = new TreeSet<AlloyType>();

    for (final Relation relation : relations) {
      if (relation.isUnary()) {
        final AlloyType type =
            new AlloyType(relation.getName(), relation.isOne(), relation.isAbstract(),
                relation.isBuiltin(), relation.isPrivate(), relation.isMeta(), relation.isEnum());
        StaticInstanceMaker.relation2AlloyType.put(relation.getName(), type);
        allTypes.add(type);
      }
    }

    return allTypes;
  }

  /**
   * Atom2Sets = which atom is in which set? <br>
   * Relation2Tuples = which relation is in which tuple? <br>
   *
   * @param model
   * @return
   */
  public static AlloyInstance createInstance(final Universe universe) {
    final AlloyModel model = StaticInstanceMaker.createModel(universe);

    final Map<AlloyAtom, Set<AlloySet>> a2s =
        StaticInstanceMaker.createAlloyAtom2AlloySetMap(universe);
    final Map<AlloyRelation, Set<AlloyTuple>> r2t =
        StaticInstanceMaker.createAlloyRelation2AlloyTupleMap(universe);

    final AlloyInstance instance = new AlloyInstance("", "", model, a2s, r2t, false);
    return instance;
  }

  private static Map<AlloyType, AlloyType> createMap(final ArrayList<Relation> relations) {
    final Map<AlloyType, AlloyType> newmap = new LinkedHashMap<AlloyType, AlloyType>();

    for (final Relation relation : relations) {
      final Relation parent = relation.getParent();
      if (parent != null) {
        final AlloyType parentType = StaticInstanceMaker.relation2AlloyType.get(parent.getName());
        final AlloyType childType = StaticInstanceMaker.relation2AlloyType.get(relation.getName());
        newmap.put(childType, parentType);
      }
    }

    return newmap;
  }

  /**
   * AlloyType = Relation <br>
   * AlloySet = Sig <br>
   * AlloyRelation = Field <br>
   * Map<AlloyType, AlloyType> = Inheritence <br>
   *
   * @param universe
   *
   * @return
   */
  private static AlloyModel createModel(final Universe universe) {
    final ArrayList<Relation> relations = universe.getRelations();
    final Set<AlloyType> allTypes = StaticInstanceMaker.createAlloyTypes(relations);
    final Set<AlloySet> allSets = StaticInstanceMaker.createAlloySets(relations);
    final Set<AlloyRelation> allRelations = StaticInstanceMaker.createAlloyRelations(relations);
    final Map<AlloyType, AlloyType> newmap = StaticInstanceMaker.createMap(relations);

    final AlloyModel model = new AlloyModel(allTypes, allSets, allRelations, newmap);
    return model;
  }
}
