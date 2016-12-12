package eu.modelwriter.kodkod.editor.manager.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import eu.modelwriter.kodkod.core.model.Atom;
import eu.modelwriter.kodkod.core.model.Relation;
import eu.modelwriter.kodkod.core.model.Tuple;
import eu.modelwriter.kodkod.core.model.Universe;

public class UniverseTransformer {
  private static UniverseTransformer transformer;

  public static UniverseTransformer getInstance() {
    if (UniverseTransformer.transformer == null) {
      UniverseTransformer.transformer = new UniverseTransformer();
    }

    return UniverseTransformer.transformer;
  }

  private final HashMap<String, String> relwithParent = new HashMap<>();
  private final HashMap<String, List<List<String>>> relwithTypes = new HashMap<>();

  UniverseTransformer() {}

  public eu.modelwriter.kodkod.visualization.model.Universe transformKodkod2Vis(
      final Universe kodkodUniverse) {
    final eu.modelwriter.kodkod.visualization.model.Universe visUniverse =
        new eu.modelwriter.kodkod.visualization.model.Universe();

    for (final Relation kodkodRelation : kodkodUniverse.getRelations()) {
      eu.modelwriter.kodkod.visualization.model.Relation visRelation =
          new eu.modelwriter.kodkod.visualization.model.Relation(kodkodRelation.getName());
      visUniverse.addRelation(visRelation);
      visRelation = this.transformKodkodRel2VisRel(visRelation, kodkodRelation);
      for (final Tuple kodkodTuple : kodkodRelation.getTuples()) {
        final eu.modelwriter.kodkod.visualization.model.Tuple visTuple =
            new eu.modelwriter.kodkod.visualization.model.Tuple(kodkodTuple.getText());
        visTuple.setBound(kodkodTuple.isLowerBound() ? "lower" : "upper");
        visRelation.addTuple(visTuple);
        for (final Atom kodkodAtom : kodkodTuple.getAtoms()) {
          final eu.modelwriter.kodkod.visualization.model.Atom visAtom =
              new eu.modelwriter.kodkod.visualization.model.Atom(kodkodAtom.getText());
          visTuple.addAtom(visAtom);
          visAtom.setData(kodkodAtom.getData());
          visAtom.setId(kodkodAtom.getId());
        }
      }
    }

    for (final Entry<String, String> entry : this.relwithParent.entrySet()) {
      final eu.modelwriter.kodkod.visualization.model.Relation parent =
          visUniverse.getRelation(entry.getValue());
      final eu.modelwriter.kodkod.visualization.model.Relation relation =
          visUniverse.getRelation(entry.getKey());
      relation.setParent(parent);
    }

    for (final Entry<String, List<List<String>>> entry : this.relwithTypes.entrySet()) {
      final eu.modelwriter.kodkod.visualization.model.Relation relation =
          visUniverse.getRelation(entry.getKey());
      for (final List<String> types : entry.getValue()) {
        final eu.modelwriter.kodkod.visualization.model.Relation[] typesArray =
            new eu.modelwriter.kodkod.visualization.model.Relation[types.size()];
        for (int i = 0; i < typesArray.length; i++) {
          typesArray[i] = visUniverse.getRelation(types.get(i));
        }
        relation.addTypes(typesArray);
      }
    }

    return visUniverse;
  }

  private eu.modelwriter.kodkod.visualization.model.Relation transformKodkodRel2VisRel(
      final eu.modelwriter.kodkod.visualization.model.Relation visRel, final Relation kodkodRel) {

    if (kodkodRel.getParent() != null) {
      this.relwithParent.put(visRel.getName(), kodkodRel.getParent().getName());
    }

    final List<List<String>> visRelTypes = new ArrayList<>();
    final List<List<Relation>> types = kodkodRel.getTypes();
    for (final List<Relation> list : types) {
      final ArrayList<String> visRelType = new ArrayList<>();
      visRelTypes.add(visRelType);
      for (final Relation relation : list) {
        visRelType.add(relation.getName());
      }
    }
    this.relwithTypes.put(visRel.getName(), visRelTypes);

    visRel.setId(kodkodRel.getId());
    visRel.setAbstract(kodkodRel.isAbstract());
    visRel.setEnum(kodkodRel.isEnum());
    visRel.setMeta(kodkodRel.isMeta());
    visRel.setPrivate(kodkodRel.isPrivate());
    if (kodkodRel.getMultiplicity() != null) {
      switch (kodkodRel.getMultiplicity()) {
        case LONE:
          visRel.setMultiplicity(eu.modelwriter.kodkod.visualization.model.Relation.Multiplicity.LONE);
          break;
        case ONE:
          visRel.setMultiplicity(eu.modelwriter.kodkod.visualization.model.Relation.Multiplicity.ONE);
          break;
        case SOME:
          visRel.setMultiplicity(eu.modelwriter.kodkod.visualization.model.Relation.Multiplicity.SOME);
          break;
        default:
          break;
      }
    }
    return visRel;
  }

}
