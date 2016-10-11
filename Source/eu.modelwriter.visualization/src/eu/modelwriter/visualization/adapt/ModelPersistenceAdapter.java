package eu.modelwriter.visualization.adapt;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import eu.modelwriter.model.Atom;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.ModelUtil;
import eu.modelwriter.model.Relation;
import eu.modelwriter.model.Tuple;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.InstanceType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.RepositoryType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class ModelPersistenceAdapter implements IModelAdapter {
  public static final ModelPersistenceAdapter instance = new ModelPersistenceAdapter();
  private Map<String, Integer> relationID2id;
  Map<String, AtomType> label2atomType;

  private ModelPersistenceAdapter() {}

  @Override
  public DocumentRoot adapt(final Object input) {
    final ModelManager modelManager = (ModelManager) input;
    final DocumentRoot documentRoot = persistenceFactory.eINSTANCE.createDocumentRoot();
    final int id = 4;
    relationID2id = new HashMap<>();
    label2atomType = new HashMap<>();

    createBaseXml(documentRoot);
    createSigs(documentRoot, modelManager, id);
    createFields(documentRoot, modelManager, id);
    createAtoms(documentRoot, modelManager);
    createTuples(documentRoot, modelManager);

    return null;
  }

  /**
   * TODO DOES NOT SUPPORT 'IN RELATION', (TYPES TYPE...)
   * 
   * @param documentRoot
   * @param modelManager
   */
  private void createTuples(final DocumentRoot documentRoot, final ModelManager modelManager) {
    for (final Tuple tuple : ModelUtil.instance.getTuples()) {
      final Relation relation = tuple.getRelationIn();
      for (final FieldType fieldType : documentRoot.getAlloy().getInstance().getField()) {
        if (fieldType.getID() == relationID2id.get(relation.getID())) {
          final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
          tupleType.setBound(tuple.getBound().toString().toLowerCase());
          fieldType.getTuple().add(tupleType);
          fieldType.setParentID(relationID2id
              .get(tuple.getAtoms().get(0).getRelationsIn().get(0).getName()).intValue());

          final TypesType newTypesType = persistenceFactory.eINSTANCE.createTypesType();
          for (final Atom atom : tuple.getAtoms()) {
            final AtomType atomType = label2atomType.get(atom.getLabel());
            tupleType.getAtom().add(atomType);

            final TypeType newTypeType = persistenceFactory.eINSTANCE.createTypeType();
            final int id = relationID2id.get(atom.getRelationsIn().get(0).getName()).intValue();
            newTypeType.setID(id);
            newTypesType.getType().add(newTypeType);
          }

          boolean exists = false;
          for (final TypesType existingTypesType : fieldType.getTypes()) {
            boolean broken = false;
            for (int i = 0; i < existingTypesType.getType().size(); i++) {
              if (existingTypesType.getType().get(i).getID() != newTypesType.getType().get(i)
                  .getID()) {
                broken = true;
                break;
              }
            }
            if (!broken) {
              exists = true;
              break;
            }
          }
          if (!exists) {
            fieldType.getTypes().add(newTypesType);
          }
        }
      }
    }
  }

  private void createAtoms(final DocumentRoot documentRoot, final ModelManager modelManager) {
    int nextId = 0;
    for (final Atom atom : ModelUtil.instance.getAtoms()) {
      for (final Relation relation : atom.getRelationsIn()) {
        for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
          if (sigType.getID() == relationID2id.get(relation.getID())) {
            final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
            atomType.setBound(atom.getBound().toString().toLowerCase());
            atomType.setLabel(atom.getLabel());
            atomType.setValue(atom.getData().toString());
            sigType.getAtom().add(atomType);

            final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
            itemType.setId(String.valueOf(nextId));
            for (final Entry<String, Object> entry : atom.getAttributes().entrySet()) {
              final EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();
              entryType.setKey(entry.getKey());
              entryType.setValue(entry.getValue().toString());
              itemType.getEntry().add(entryType);
            }
            documentRoot.getAlloy().getRepository().getItem().add(itemType);
            documentRoot.getAlloy().getRepository()
            .setNextId(nextId = documentRoot.getAlloy().getRepository().getNextId() + 1);

            label2atomType.put(atom.getLabel(), atomType);
          }
        }
      }
      if (atom.getRelationsInNames().size() == 0) {
        final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
        atomType.setBound(atom.getBound().toString().toLowerCase());
        atomType.setLabel(atom.getLabel());
        atomType.setValue(atom.getData().toString());

        final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
        itemType.setId(String.valueOf(nextId));
        for (final Entry<String, Object> entry : atom.getAttributes().entrySet()) {
          final EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();
          entryType.setKey(entry.getKey());
          entryType.setValue(entry.getValue().toString());
          itemType.getEntry().add(entryType);
        }
        documentRoot.getAlloy().getRepository().getItem().add(itemType);
        documentRoot.getAlloy().getRepository()
        .setNextId(nextId = documentRoot.getAlloy().getRepository().getNextId() + 1);

        label2atomType.put(atom.getLabel(), atomType);
      }
    }
  }

  private void createFields(final DocumentRoot documentRoot, final ModelManager modelManager,
      int id) {
    for (final Relation relation : ModelUtil.instance.getRelations()) {
      if (relation.getArity() == 2) {
        final FieldType fieldType = persistenceFactory.eINSTANCE.createFieldType();
        fieldType.setID(id++);
        fieldType.setLabel(relation.getName());
        documentRoot.getAlloy().getInstance().getField().add(fieldType);
        relationID2id.put(relation.getID(), id);
      }
    }
  }

  private void createSigs(final DocumentRoot documentRoot, final ModelManager modelManager,
      int id) {
    for (final Relation relation : ModelUtil.instance.getRelations()) {
      if (relation.getArity() == 1) {
        final SigType sigType = persistenceFactory.eINSTANCE.createSigType();
        sigType.setID(id++);
        sigType.setLabel("this/" + relation.getName());
        documentRoot.getAlloy().getInstance().getSig().add(sigType);
        relationID2id.put(relation.getID(), id);
      }
    }
  }

  private void createBaseXml(DocumentRoot documentRoot) {
    documentRoot = persistenceFactory.eINSTANCE.createDocumentRoot();

    final AlloyType alloyType = persistenceFactory.eINSTANCE.createAlloyType();
    documentRoot.setAlloy(alloyType);
    alloyType.setBuilddate("");

    final RepositoryType repositoryType = persistenceFactory.eINSTANCE.createRepositoryType();
    repositoryType.setNextId(0);
    alloyType.setRepository(repositoryType);

    final InstanceType instanceType = persistenceFactory.eINSTANCE.createInstanceType();
    alloyType.setInstance(instanceType);
    instanceType.setBitwidth(0);
    instanceType.setFilename("");
    instanceType.setMaxseq(0);

    final SigType sigSegInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigSegInt);
    sigSegInt.setID(0);
    sigSegInt.setLabel("seq/Int");
    sigSegInt.setParentID(1);
    sigSegInt.setBuiltin("yes");

    final SigType sigInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigInt);
    sigInt.setID(1);
    sigInt.setLabel("Int");
    sigInt.setParentID(2);
    sigInt.setBuiltin("yes");

    final SigType sigUniv = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigUniv);
    sigUniv.setID(2);
    sigUniv.setLabel("univ");
    sigUniv.setBuiltin("yes");

    final SigType sigString = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigString);
    sigString.setID(3);
    sigString.setLabel("String");
    sigString.setParentID(2);
    sigString.setBuiltin("yes");
  }
}
