package eu.modelwriter.visualization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;
import eu.modelwriter.visualization.wizards.createatom.TypeElement;

public class Utility {

  protected static DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list = modelIO.read(URI.createFileURI(XmlCreator.xmlfile));
    if (list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  @SuppressWarnings("unchecked")
  protected static void writeDocumentRoot(DocumentRoot documentRoot) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    modelIO.write(URI.createFileURI(XmlCreator.xmlfile), documentRoot);
  }

  protected static void addDataToRepository(String atomId, String data) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();

    ItemType itemType = getItemById(atomId);
    EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();

    itemType.getEntry().add(entryType);

    entryType.setKey("Data");
    entryType.setValue(data);

    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    Utility.writeDocumentRoot(documentRoot);
  }

  protected static String getDataOfAtom(String type, int index) {
    String atomId = itemIdByIndex(type, index);

    ItemType itemType = getItemById(atomId);

    for (EntryType entryType : itemType.getEntry()) {
      if (entryType.getKey().equals("Data"))
        return entryType.getValue();
    }

    return null;
  }

  protected static ItemType getItemById(final String id) {
    final EList<ItemType> itemTypes = getDocumentRoot().getAlloy().getRepository().getItem();

    for (final ItemType itemType : itemTypes) {
      if (id.equals(itemType.getId())) {
        return itemType;
      }
    }

    return null;
  }

  public static String itemIdByIndex(String type, int index) {
    DocumentRoot documentRoot = getDocumentRoot();
    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      if (sigType.getLabel().equals(type)) {
        return sigType.getAtom().get(index).getLabel();
      }
    }

    return null;
  }

  public static void addAtomToSigType(String type, String name) {
    DocumentRoot documentRoot = getDocumentRoot();
    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();
    String generatedId = generateId(documentRoot, false);

    for (SigType sigType : sigs) {
      if (sigType.getLabel().equals(type)) {
        AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
        atomType.setLabel(generatedId);
        sigType.getAtom().add(atomType);
        break;
      }
    }

    ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    itemType.setId(generatedId);

    if (name != null) {
      EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();
      itemType.getEntry().add(entryType);
      entryType.setKey("Name");
      entryType.setValue(name);
    }

    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    writeDocumentRoot(documentRoot);
  }

  protected static void addAtomToSigTypeWithData(String type, String name, String data) {
    DocumentRoot documentRoot = getDocumentRoot();
    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();
    String generatedId = generateId(documentRoot, false);

    for (SigType sigType : sigs) {
      if (sigType.getLabel().equals(type)) {
        AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
        atomType.setLabel(generatedId);
        sigType.getAtom().add(atomType);
        break;
      }
    }

    ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    EntryType entryTypeName = persistenceFactory.eINSTANCE.createEntryType();
    EntryType entryTypeData = persistenceFactory.eINSTANCE.createEntryType();

    itemType.getEntry().add(entryTypeName);
    itemType.getEntry().add(entryTypeData);
    itemType.setId(generatedId);
    entryTypeName.setKey("Name");
    entryTypeName.setValue(name);
    entryTypeData.setKey("Data");
    entryTypeData.setValue(data);

    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    writeDocumentRoot(documentRoot);
  }

  protected static String generateId(DocumentRoot documentRoot, boolean isWrite) {
    final String base = "0000";
    int nextId = documentRoot.getAlloy().getRepository().getNextId();

    String id = base + nextId;
    id = id.substring(id.length() - 5);

    documentRoot.getAlloy().getRepository().setNextId(++nextId);
    if (isWrite)
      writeDocumentRoot(documentRoot);

    return id;
  }

  public static List<TypeElement> getTypeHierarchy() {
    EList<SigType> sigTypeList = getDocumentRoot().getAlloy().getInstance().getSig();
    Map<Integer, TypeElement> sigIdNameMap = new HashMap<>();
    Map<Integer, Integer> sigIdParentIdMap = new HashMap<>();
    List<TypeElement> topTypeElements = new ArrayList<>();

    for (SigType sigType : sigTypeList) {
      if (sigType.getID() > 3) {
        String type = sigType.getLabel();
        if (sigType.getAbstract() != null && sigType.getAbstract().equals("yes"))
          type += " {abs}";
        if (sigType.getParentID() == 2)
          sigIdNameMap.put(sigType.getID(), new TypeElement(type, true));
        else
          sigIdNameMap.put(sigType.getID(), new TypeElement(type));

        sigIdParentIdMap.put(sigType.getID(), sigType.getParentID());
      }
    }

    Iterator<Entry<Integer, Integer>> iter = sigIdParentIdMap.entrySet().iterator();

    while (iter.hasNext()) {
      Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iter.next();

      TypeElement currentTypeElement = sigIdNameMap.get(entry.getKey());
      TypeElement parentTypeElement = sigIdNameMap.get(entry.getValue());

      if (parentTypeElement != null)
        parentTypeElement.getChildren().add(currentTypeElement);

      if (currentTypeElement.isTop())
        topTypeElements.add(currentTypeElement);
    }

    return topTypeElements;
  }

  public static List<MutableTreeNode> getTypeHierarchyForTree() {
    EList<SigType> sigTypeList = getDocumentRoot().getAlloy().getInstance().getSig();
    Map<Integer, MutableTreeNode> sigIdNameMap = new HashMap<>();
    Map<Integer, Integer> sigIdParentIdMap = new HashMap<>();
    List<MutableTreeNode> topTypeElements = new ArrayList<>();

    for (SigType sigType : sigTypeList) {
      if (sigType.getID() > 3) {
        String type = sigType.getLabel();
        if (sigType.getAbstract() != null && sigType.getAbstract().equals("yes"))
          type += " {abs}";
        if (sigType.getParentID() == 2)
          sigIdNameMap.put(sigType.getID(), new DefaultMutableTreeNode(type));
        else
          sigIdNameMap.put(sigType.getID(), new DefaultMutableTreeNode(type));

        sigIdParentIdMap.put(sigType.getID(), sigType.getParentID());
      }
    }

    Iterator<Entry<Integer, Integer>> iter = sigIdParentIdMap.entrySet().iterator();

    while (iter.hasNext()) {
      Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iter.next();

      MutableTreeNode currentTypeElement = sigIdNameMap.get(entry.getKey());
      MutableTreeNode parentTypeElement = sigIdNameMap.get(entry.getValue());

      if (parentTypeElement != null)
        parentTypeElement.insert(currentTypeElement, parentTypeElement.getChildCount());

      if (currentTypeElement.toString().contains("{abs}"))
        topTypeElements.add(currentTypeElement);
    }

    return topTypeElements;
  }

  private static ArrayList<String> getRelationTypesForFirstSide(final String typeName) {
    final ArrayList<String> relationTypeNames = new ArrayList<String>();

    int TypeId = -1;

    final EList<SigType> sigTypes = getDocumentRoot().getAlloy().getInstance().getSig();
    for (SigType sigType : sigTypes) {
      if (sigType.getLabel().equals(typeName)) {
        TypeId = sigType.getID();
        break;
      }
    }

    final ArrayList<Integer> parentIds = getAllParentIds(TypeId);

    final EList<FieldType> fieldTypes = getDocumentRoot().getAlloy().getInstance().getField();

    for (final FieldType fieldType : fieldTypes) {
      for (final Integer parentId : parentIds) {
        if (fieldType.getParentID() == parentId) {
          relationTypeNames.add(fieldType.getLabel());
          break;
        }
      }
    }

    return relationTypeNames;
  }

  private static ArrayList<Integer> getAllParentIds(int id) {
    final ArrayList<Integer> ids = new ArrayList<Integer>();

    do {
      ids.add(id);
      final SigType sigType = getSigTypeById(id);
      if (sigType.getType().size() == 0) {
        id = sigType.getParentID();
      } else {
        id = sigType.getType().get(0).getID();
      }
    } while (id != 0);

    return ids;
  }

  private static SigType getSigTypeById(final int id) {
    final EList<SigType> sigTypes = getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      if (id == sigType.getID()) {
        return sigType;
      }
    }
    return null;
  }

  public static ArrayList<String> getSuitableRelations(String typeName) {
    ArrayList<String> suitableRelationNames = getRelationTypesForFirstSide(typeName);

    EList<FieldType> fieldList = getDocumentRoot().getAlloy().getInstance().getField();
    ArrayList<String> relations = new ArrayList<>();

    for (String relationName : suitableRelationNames) {
      for (FieldType fieldType : fieldList) {
        if (relationName.equals(fieldType.getLabel())) {
          EList<TypesType> types = fieldType.getTypes();
          for (TypesType typesType : types) {
            String first = getSigTypeById(typesType.getType().get(0).getID()).getLabel();
            String second = getSigTypeById(typesType.getType().get(1).getID()).getLabel();
            relations.add(relationName + " : " + first + " -> " + second);
          }
          break;
        }
      }
    }

    return relations;
  }

  public static ArrayList<SigType> getSigTypeListByParentId(final int id) {
    final ArrayList<SigType> suitableSigTypes = new ArrayList<>();

    final EList<SigType> sigTypes = getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      if (sigType.getParentID() == id) {
        suitableSigTypes.add(sigType);
      }
    }

    return suitableSigTypes;
  }

  public static ArrayList<Integer> getAllChildIds(final int id) {
    final ArrayList<Integer> ids = new ArrayList<Integer>();

    final ArrayList<SigType> sigTypes = getSigTypeListByParentId(id);

    for (final SigType sigType : sigTypes) {
      ids.addAll(getAllChildIds(sigType.getID()));
    }

    ids.add(id);

    return ids;
  }

  public static ArrayList<ArrayList<String>> getSuitableSecondSideTypesOfRelation(
      final String relationName, final String firstSideType) {
    final EList<FieldType> fields = getDocumentRoot().getAlloy().getInstance().getField();

    final int firstSideTypeId = getSigTypeIdByName(firstSideType);

    int id = -1;
    for (final FieldType fieldType : fields) {
      if (fieldType.getLabel().equals(relationName)
          && fieldType.getTypes().get(0).getType().get(0).getID() == firstSideTypeId) {
        id = fieldType.getTypes().get(0).getType().get(1).getID();
      }
    }

    final ArrayList<Integer> suitableIds = getAllChildIds(id);

    EList<SigType> sigList = getDocumentRoot().getAlloy().getInstance().getSig();
    ArrayList<ArrayList<String>> suitableAtoms = new ArrayList<ArrayList<String>>();

    for (SigType sigType : sigList) {
      if (suitableIds.contains(sigType.getID())) {
        EList<AtomType> atomList = sigType.getAtom();
        String sigName = sigType.getLabel();
        int index = 0;
        for (AtomType atomType : atomList) {
          ArrayList<String> suitable = new ArrayList<>();
          suitable.add(sigName);
          suitable.add(sigName + Integer.toString(index));
          suitable.add(getSigTypeName(atomType.getLabel()));
          suitableAtoms.add(suitable);
          index++;
        }
      }
    }


    return suitableAtoms;
  }

  private static String getSigTypeName(String id) {
    ItemType itemType = getItemById(id);

    EList<EntryType> entries = itemType.getEntry();

    for (EntryType entryType : entries) {
      if (entryType.getKey().equals("Name"))
        return entryType.getValue();
    }
    return null;
  }

  public static int getSigTypeIdByName(final String typeName) {
    int id = -1;

    final EList<SigType> sigTypes = getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      if (typeName.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        id = sigType.getID();
      }
    }

    return id;
  }

  public static void addRelation2Markers(String fromId, String toId, final String relation) {
    final DocumentRoot documentRoot = getDocumentRoot();

    final AtomType fromAtom = persistenceFactory.eINSTANCE.createAtomType();
    fromAtom.setLabel(fromId);

    final AtomType toAtom = persistenceFactory.eINSTANCE.createAtomType();
    toAtom.setLabel(toId);

    final TupleType tuple = persistenceFactory.eINSTANCE.createTupleType();
    tuple.getAtom().add(fromAtom);
    tuple.getAtom().add(toAtom);

    final EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fields) {
      if (relation.equals(fieldType.getLabel())) {
        fieldType.getTuple().add(tuple);
        break;
      }
    }

    writeDocumentRoot(documentRoot);
  }


}
