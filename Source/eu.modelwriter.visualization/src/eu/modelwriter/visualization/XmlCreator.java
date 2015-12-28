package eu.modelwriter.visualization;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

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
import eu.modelwriter.visualization.model.Atom;
import eu.modelwriter.visualization.model.Relation;
import eu.modelwriter.visualization.model.Tuple;
import eu.modelwriter.visualization.model.Universe;

public class XmlCreator {

  private Universe universe;
  protected static String xmlfile;
  protected static DocumentRoot documentRoot;
  private int id;
  private HashMap<EObject, Relation> mapForParent;
  private HashMap<EObject, Relation> mapForTypes;

  public XmlCreator(Universe universe, String xmlfile) {
    XmlCreator.xmlfile = xmlfile;
    DocumentRoot oldDocumentRoot = Utility.getDocumentRoot();
    if (oldDocumentRoot != null)
      documentRoot = oldDocumentRoot;
    else {
      this.universe = universe;
      this.id = 4;
      this.mapForParent = new HashMap<EObject, Relation>();
      this.mapForTypes = new HashMap<EObject, Relation>();

      createBaseXml();
      addRelations();
      setTypes();

      Utility.writeDocumentRoot(documentRoot);
    }
  }

  private void createBaseXml() {
    documentRoot = persistenceFactory.eINSTANCE.createDocumentRoot();

    AlloyType alloyType = persistenceFactory.eINSTANCE.createAlloyType();
    documentRoot.setAlloy(alloyType);
    alloyType.setBuilddate("");

    RepositoryType repositoryType = persistenceFactory.eINSTANCE.createRepositoryType();
    repositoryType.setNextId(0);
    alloyType.setRepository(repositoryType);

    InstanceType instanceType = persistenceFactory.eINSTANCE.createInstanceType();
    alloyType.setInstance(instanceType);
    instanceType.setBitwidth(0);
    instanceType.setFilename("");
    instanceType.setMaxseq(0);

    SigType sigSegInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigSegInt);
    sigSegInt.setID(0);
    sigSegInt.setLabel("seq/Int");
    sigSegInt.setParentID(1);
    sigSegInt.setBuiltin("yes");

    SigType sigInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigInt);
    sigInt.setID(1);
    sigInt.setLabel("Int");
    sigInt.setParentID(2);
    sigInt.setBuiltin("yes");

    SigType sigUniv = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigUniv);
    sigUniv.setID(2);
    sigUniv.setLabel("univ");
    sigUniv.setBuiltin("yes");

    SigType sigString = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigString);
    sigString.setID(3);
    sigString.setLabel("String");
    sigString.setParentID(2);
    sigString.setBuiltin("yes");

  }

  public void setMetamodel(boolean isMetamodel) {
    DocumentRoot documentRoot = Utility.getDocumentRoot();
    if (isMetamodel)
      documentRoot.getAlloy().getInstance().setMetamodel("yes");
    else
      documentRoot.getAlloy().getInstance().setMetamodel(null);

    Utility.writeDocumentRoot(documentRoot);
  }

  private void addRelations() {
    Map<String, String> atomNameIndexMap = new HashMap<>();
    if (universe == null)
      return;
    for (Relation relation : universe.getRelations()) {
      if (relation.getArity() < 2) {
        SigType sigType = persistenceFactory.eINSTANCE.createSigType();
        sigType.setID(id);
        relation.setId(id);
        mapForParent.put(sigType, relation.getParent());
        if (!relation.getTypes().isEmpty())
          mapForTypes.put(sigType, relation);
        id++;
        sigType.setLabel(relation.getName());
        setStatueOfRelation(relation, sigType);
        documentRoot.getAlloy().getInstance().getSig().add(sigType);
        for (Tuple tuple : relation.getTuples()) {
          String index = Utility.generateId(documentRoot, false);
          AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
          atomType.setLabel(index);
          sigType.getAtom().add(atomType);

          ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
          EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();
          itemType.getEntry().add(entryType);

          itemType.setId(index);
          entryType.setKey("Name");
          entryType.setValue(tuple.getAtoms().get(0).getText());
          documentRoot.getAlloy().getRepository().getItem().add(itemType);
          atomNameIndexMap.put(tuple.getAtoms().get(0).getText(), index);
        }
      } else if (relation.getArity() > 1) {
        FieldType fieldType = persistenceFactory.eINSTANCE.createFieldType();
        fieldType.setID(id);
        relation.setId(id);
        mapForParent.put(fieldType, relation.getParent());
        mapForTypes.put(fieldType, relation);
        id++;
        fieldType.setLabel(relation.getName());
        documentRoot.getAlloy().getInstance().getField().add(fieldType);
        for (Tuple tuple : relation.getTuples()) {
          TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
          fieldType.getTuple().add(tupleType);
          for (Atom atom : tuple.getAtoms()) {
            AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
            atomType.setLabel(atomNameIndexMap.get(atom.getText()));
            tupleType.getAtom().add(atomType);
          }
        }
      }
    }

    setParents();

  }

  private void setStatueOfRelation(Relation relation, SigType sigType) {
    if (relation.getMultiplicity() != null) {
      switch (relation.getMultiplicity()) {
        case LONE:
          sigType.setLone("yes");
          break;
        case ONE:
          sigType.setOne("yes");
          break;
        case SOME:
          sigType.setSome("yes");
          break;
        default:
          break;
      }
    }
    if (relation.isAbstract())
      sigType.setAbstract("yes");
    if (relation.isEnum())
      sigType.setEnum("yes");
    if (relation.isMeta())
      sigType.setMeta("yes");
    if (relation.isPrivate())
      sigType.setPrivate("yes");
  }

  private void setParents() {
    Iterator<Entry<EObject, Relation>> iter = mapForParent.entrySet().iterator();
    int countForParentless = 0;

    while (iter.hasNext()) {
      Entry<EObject, Relation> object = (Entry<EObject, Relation>) iter.next();
      if (object.getKey() instanceof SigType) {
        SigType sigType = ((SigType) object.getKey());
        if (object.getValue() != null) {
          Relation parent = universe.getRelation(object.getValue().getName());

          if (parent.getId() == -1)
            countForParentless++;

          sigType.setParentID(parent.getId());

        } else {
          sigType.setParentID(2);
        }
      } else if (object.getKey() instanceof FieldType) {
        FieldType fieldType = ((FieldType) object.getKey());
        if (object.getValue() != null) {
          Relation parent = universe.getRelation(object.getValue().getName());

          if (parent.getId() == -1)
            countForParentless++;

          fieldType.setParentID(parent.getId());

        } else {
          fieldType.setParentID(2);
        }
      }
    }
    if (countForParentless != 0)
      setParents();
  }

  private void setTypes() {
    Iterator<Entry<EObject, Relation>> iter = mapForTypes.entrySet().iterator();

    while (iter.hasNext()) {
      Entry<EObject, Relation> object = (Entry<EObject, Relation>) iter.next();
      if (object.getKey() instanceof SigType) {
        SigType sigType = ((SigType) object.getKey());
        for (List<Relation> types : object.getValue().getTypes()) {
          for (Relation relation : types) {
            Relation relationInUniverse = universe.getRelation(relation.getName());
            TypeType typeType = persistenceFactory.eINSTANCE.createTypeType();
            typeType.setID(relationInUniverse.getId());
            sigType.getType().add(typeType);
          }
        }
      } else if (object.getKey() instanceof FieldType) {
        FieldType fieldType = ((FieldType) object.getKey());
        for (List<Relation> types : object.getValue().getTypes()) {
          TypesType typesType = persistenceFactory.eINSTANCE.createTypesType();
          for (Relation relation : types) {
            Relation relationInUniverse = universe.getRelation(relation.getName());
            TypeType typeType = persistenceFactory.eINSTANCE.createTypeType();
            typeType.setID(relationInUniverse.getId());
            typesType.getType().add(typeType);
          }
          fieldType.getTypes().add(typesType);
        }
      }
    }

  }


}
