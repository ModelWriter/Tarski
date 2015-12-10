package eu.modelwriter.visualization;

import java.util.ArrayList;
import java.util.Iterator;
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

public class SampleAlloyInstanceCreator {

  private static Map<AlloyAtom, Set<AlloySet>> createAlloyAtom2AlloySetMap(final AlloyModel model) {
    final Map<AlloyAtom, Set<AlloySet>> a2s = new TreeMap<AlloyAtom, Set<AlloySet>>();
    final Set<AlloyType> types = model.getTypes();
    final Set<AlloySet> sets = model.getSets();
    final Object[] setArray = sets.toArray();

    int i = 0, j = 0;
    for (final AlloyType alloyType : types) {
      if (i < types.size() && j < sets.size()) {
        final Set<AlloySet> set = new TreeSet<AlloySet>();
        set.add((AlloySet) setArray[j]);
        a2s.put(new AlloyAtom(alloyType, i), set);
        i++;
        j++;
      }
    }
    return a2s;
  }

  /**
   * Atom2Sets = which atom is in which set? <br>
   * Relation2Tuples = which relation is in which tuple? <br>
   *
   * @param model
   * @return
   */
  public static AlloyInstance createAlloyInstance(final AlloyModel model,
      final boolean isMetamodel) {
    final Map<AlloyAtom, Set<AlloySet>> a2s =
        SampleAlloyInstanceCreator.createAlloyAtom2AlloySetMap(model);
    final Map<AlloyRelation, Set<AlloyTuple>> r2t =
        SampleAlloyInstanceCreator.createAlloyRelation2AlloyTupleMap(model);
    final AlloyInstance instance = new AlloyInstance("", "", model, a2s, r2t, isMetamodel);
    return instance;
  }

  /**
   * AlloyType = Atom <br>
   * AlloySet = Sig <br>
   * AlloyRelation = Field <br>
   * Map<AlloyType, AlloyType> = Inheritence <br>
   *
   * @return
   */
  public static AlloyModel createAlloyModel() {
    final Set<AlloyType> allTypes = SampleAlloyInstanceCreator.createAlloyTypes();
    final Set<AlloySet> allSets = SampleAlloyInstanceCreator.createAlloySets(allTypes);
    final Set<AlloyRelation> allRelations =
        SampleAlloyInstanceCreator.createAlloyRelations(new ArrayList<AlloyType>(allTypes));
    final Map<AlloyType, AlloyType> newmap = SampleAlloyInstanceCreator.createMap(allTypes);
    final AlloyModel model = new AlloyModel(allTypes, allSets, allRelations, newmap);
    return model;
  }

  private static Map<AlloyRelation, Set<AlloyTuple>> createAlloyRelation2AlloyTupleMap(
      final AlloyModel model) {
    final Map<AlloyRelation, Set<AlloyTuple>> r2t =
        new LinkedHashMap<AlloyRelation, Set<AlloyTuple>>();
    final Set<AlloyRelation> relations = model.getRelations();

    for (final AlloyRelation relation : relations) {
      final Set<AlloyTuple> tuples = new TreeSet<AlloyTuple>();
      final Object[] types = relation.getTypes().toArray();

      tuples.add(new AlloyTuple(new AlloyAtom((AlloyType) types[0], 1),
          new AlloyAtom((AlloyType) types[1], 2)));

      r2t.put(relation, tuples);
    }
    return r2t;
  }

  private static Set<AlloyRelation> createAlloyRelations(final List<AlloyType> types) {
    final Set<AlloyRelation> allRelations = new TreeSet<AlloyRelation>();
    final List<AlloyType> firstRelation = new ArrayList<AlloyType>();
    firstRelation.add(types.get(1));
    firstRelation.add(types.get(3));
    final List<AlloyType> secondRelation = new ArrayList<AlloyType>();
    secondRelation.add(types.get(2));
    secondRelation.add(types.get(4));
    final List<AlloyType> thirdRelation = new ArrayList<AlloyType>();
    thirdRelation.add(types.get(2));
    thirdRelation.add(types.get(5));
    allRelations.add(new AlloyRelation("AlloyRelation1", false, false, firstRelation));
    allRelations.add(new AlloyRelation("AlloyRelation2", false, false, secondRelation));
    allRelations.add(new AlloyRelation("AlloyRelation3", false, false, thirdRelation));
    return allRelations;
  }

  private static Set<AlloySet> createAlloySets(final Set<AlloyType> allTypes) {
    final Set<AlloySet> allSets = new TreeSet<AlloySet>();
    final Iterator<AlloyType> iter = allTypes.iterator();
    int i = 0;
    while (iter.hasNext()) {
      final AlloyType alloyType = iter.next();
      allSets.add(new AlloySet("AlloySet" + i++, false, false, alloyType));
    }
    return allSets;
  }

  private static Set<AlloyType> createAlloyTypes() {
    final Set<AlloyType> allTypes = new TreeSet<AlloyType>();
    allTypes.add(new AlloyType("univ", false, true, false, false, false, false));
    for (int i = 0; i < 5; i++) {
      allTypes.add(new AlloyType("AlloyType" + i, false, false, false, false, false, false));
    }
    return allTypes;
  }

  private static Map<AlloyType, AlloyType> createMap(final Set<AlloyType> allTypes) {
    final Map<AlloyType, AlloyType> newmap = new LinkedHashMap<AlloyType, AlloyType>();
    final Iterator<AlloyType> types = allTypes.iterator();
    while (types.hasNext()) {
      final AlloyType alloyType = types.next();
      if (types.hasNext()) {
        newmap.put(alloyType, types.next());
      }
    }
    return newmap;
  }

}
