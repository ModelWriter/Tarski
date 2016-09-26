/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
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

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
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

  private static Map<String, String> atomNameIndexMap = new HashMap<String, String>();

  public static void addAtomToSigType(final String type, final String name) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();
    String index = null;

    for (final SigType sigType : sigs) {
      if (sigType.getLabel().equals(type)) {
        final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
        index = Utility.atomNameIndexMap.get(name);
        if (index == null) {
          index = Utility.generateId(documentRoot, false);
          Utility.atomNameIndexMap.put(name, index);

          final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
          itemType.setId(index);

          if (name != null) {
            final EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();
            itemType.getEntry().add(entryType);
            entryType.setKey("Name");
            entryType.setValue(name);
          }

          documentRoot.getAlloy().getRepository().getItem().add(itemType);
        }
        atomType.setLabel(index);

        atomType.setBound(Visualization.getInstance().isLower() ? "lower" : "upper");
        sigType.getAtom().add(atomType);
        break;
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  protected static void addAtomToSigTypeWithData(final String type, final String name,
      final String data) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();
    final String generatedId = Utility.generateId(documentRoot, false);

    for (final SigType sigType : sigs) {
      if (sigType.getLabel().equals(type)) {
        final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
        atomType.setLabel(generatedId);
        sigType.getAtom().add(atomType);
        break;
      }
    }

    final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    final EntryType entryTypeName = persistenceFactory.eINSTANCE.createEntryType();
    final EntryType entryTypeData = persistenceFactory.eINSTANCE.createEntryType();

    itemType.getEntry().add(entryTypeName);
    itemType.getEntry().add(entryTypeData);
    itemType.setId(generatedId);
    entryTypeName.setKey("Name");
    entryTypeName.setValue(name);
    entryTypeData.setKey("Data");
    entryTypeData.setValue(data);

    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    Utility.writeDocumentRoot(documentRoot);
  }

  protected static void addDataToRepository(final String atomId, final String data) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();

    final ItemType itemType = Utility.getItemById(atomId);
    final EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();

    itemType.getEntry().add(entryType);

    entryType.setKey("Data");
    entryType.setValue(data);

    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    Utility.writeDocumentRoot(documentRoot);
  }

  public static void addRelation2Atoms(final String fromId, final String toId,
      final String relation) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();

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

    Utility.writeDocumentRoot(documentRoot);
  }

  public static void changeAtomType(final AlloyAtom alloyAtom, final String newType) {
    final String id = Utility.itemIdByAlloyAtom(alloyAtom);
    Utility.removeRelationFromFieldType(id);
    Utility.removeAtomTypeFromSigType(id);

    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigs) {
      if (sigType.getLabel().equals(newType)) {
        final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
        atomType.setLabel(id);
        int i = 0;
        for (i = 0; i < sigType.getAtom().size(); i++) {
          if (sigType.getAtom().get(i).getLabel().compareTo(atomType.getLabel()) > 0) {
            break;
          }
        }
        sigType.getAtom().add(i == 0 ? 0 : i - 1, atomType);
        break;
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  protected static String generateId(final DocumentRoot documentRoot, final boolean isWrite) {
    final String base = "0000";
    int nextId = documentRoot.getAlloy().getRepository().getNextId();

    String id = base + nextId;
    id = id.substring(id.length() - 5);

    documentRoot.getAlloy().getRepository().setNextId(++nextId);
    if (isWrite) {
      Utility.writeDocumentRoot(documentRoot);
    }

    return id;
  }

  public static ArrayList<Integer> getAllChildIds(final int id) {
    final ArrayList<Integer> ids = new ArrayList<Integer>();

    final ArrayList<SigType> sigTypes = Utility.getSigTypeListByParentId(id);

    for (final SigType sigType : sigTypes) {
      ids.addAll(Utility.getAllChildIds(sigType.getID()));
    }

    ids.add(id);

    return ids;
  }

  private static ArrayList<Integer> getAllParentIds(int id) {
    final ArrayList<Integer> ids = new ArrayList<Integer>();
    do {
      ids.add(id);
      final SigType sigType = Utility.getSigTypeById(id);
      if (sigType.getType().size() == 0) {
        id = sigType.getParentID();
      } else {
        id = sigType.getType().get(0).getID();
      }
    } while (id != 0);

    return ids;
  }

  public static String getAtomNameById(final String id) {
    final ItemType itemType = Utility.getItemById(id);
    final EList<EntryType> entries = itemType.getEntry();

    for (final EntryType entryType : entries) {
      if (entryType.getKey().equals("Name")) {
        return entryType.getValue();
      }
    }

    return null;
  }

  public static AtomType getAtomTypeById(final String id, final String type) {
    final EList<SigType> sigList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigList) {
      if (sigType.getLabel().equals(type)) {
        final EList<AtomType> atomList = sigType.getAtom();
        for (final AtomType atomType : atomList) {
          if (atomType.getLabel().equals(id)) {
            return atomType;
          }
        }
      }
    }
    return null;
  }

  public static String getBoundOfAtomType(final AlloyAtom alloyAtom) {
    final String id = Utility.itemIdByAlloyAtom(alloyAtom);
    final String type = alloyAtom.getType().getName();

    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<SigType> sigList = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigList) {
      if (sigType.getLabel().equals(type)) {
        final EList<AtomType> atomList = sigType.getAtom();
        for (final AtomType atomType : atomList) {
          if (atomType.getLabel().equals(id)) {
            return atomType.getBound();
          }
        }
      }
    }
    return null;
  }

  public static String getBoundOfTupleType(final AlloyTuple alloyTuple, final String relation) {
    final AlloyAtom fromAtom = alloyTuple.getStart();
    final AlloyAtom toAtom = alloyTuple.getEnd();

    final String fromAtomId = Utility.itemIdByAlloyAtom(fromAtom);
    final String toAtomId = Utility.itemIdByAlloyAtom(toAtom);

    final String fromAtomName = Utility.getAtomNameById(fromAtomId);
    final String toAtomName = Utility.getAtomNameById(toAtomId);

    final List<String> tupleList = new ArrayList<>();
    tupleList.add(fromAtomName);
    tupleList.add(toAtomName);

    final DocumentRoot documentRoot = Utility.getDocumentRoot();

    final EList<FieldType> fieldList = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fieldList) {
      if (fieldType.getLabel().equals(relation)) {
        final EList<TupleType> tupleTypeList = fieldType.getTuple();
        for (final TupleType tupleType : tupleTypeList) {
          if (fromAtomId.equals(tupleType.getAtom().get(0).getLabel())
              && toAtomId.equals(tupleType.getAtom().get(1).getLabel())) {
            return tupleType.getBound();
          }
        }
      }
    }
    return null;
  }

  protected static String getDataOfAtom(final String type, final int index) {
    final String atomId = Utility.itemIdByIndex(type, index);

    final ItemType itemType = Utility.getItemById(atomId);

    for (final EntryType entryType : itemType.getEntry()) {
      if (entryType.getKey().equals("Data")) {
        return entryType.getValue();
      }
    }

    return null;
  }

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

  protected static ItemType getItemById(final String id) {
    final EList<ItemType> itemTypes =
        Utility.getDocumentRoot().getAlloy().getRepository().getItem();

    for (final ItemType itemType : itemTypes) {
      if (id.equals(itemType.getId())) {
        return itemType;
      }
    }

    return null;
  }

  /**
   * For example atom is in EmptyList, also it is in List. <br>
   * So that if we know only relationName which is "List", <br>
   * we can find EmptyList with this method.
   *
   * @param atomLabel
   * @param relationName
   * @return
   */
  public static String getRealTypeOfAtom(final String atomLabel, final String relationName) {
    final EList<SigType> sigTypeList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();
    final Map<Integer, String> sigIdNameMap = new HashMap<>();

    for (final SigType sigType : sigTypeList) {
      sigIdNameMap.put(sigType.getID(), sigType.getLabel());
    }

    for (final SigType sigType : sigTypeList) {
      if (!sigType.getType().isEmpty()) {
        final String typeName = sigIdNameMap.get(sigType.getType().get(0).getID());
        if (typeName.equals(relationName)) {
          final EList<AtomType> atomTypes = sigType.getAtom();
          for (final AtomType atomType : atomTypes) {
            if (atomType.getLabel().equals(atomLabel)) {
              return sigType.getLabel();
            }
          }
        }
      }
    }
    return null;
  }

  private static ArrayList<String> getRelationTypesForFirstSide(final String typeName) {
    final ArrayList<String> relationTypeNames = new ArrayList<String>();

    int TypeId = -1;

    final EList<SigType> sigTypes = Utility.getDocumentRoot().getAlloy().getInstance().getSig();
    for (final SigType sigType : sigTypes) {
      if (sigType.getLabel().equals(typeName)) {
        TypeId = sigType.getID();
        break;
      }
    }

    final ArrayList<Integer> parentIds = Utility.getAllParentIds(TypeId);

    final EList<FieldType> fieldTypes =
        Utility.getDocumentRoot().getAlloy().getInstance().getField();

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

  private static SigType getSigTypeById(final int id) {
    final EList<SigType> sigTypes = Utility.getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      if (id == sigType.getID()) {
        return sigType;
      }
    }
    return null;
  }

  public static int getSigTypeIdByName(final String typeName) {
    int id = -1;

    final EList<SigType> sigTypes = Utility.getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      if (typeName.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        id = sigType.getID();
      }
    }

    return id;
  }

  public static ArrayList<SigType> getSigTypeListByParentId(final int id) {
    final ArrayList<SigType> suitableSigTypes = new ArrayList<>();

    final EList<SigType> sigTypes = Utility.getDocumentRoot().getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      if (sigType.getParentID() == id) {
        suitableSigTypes.add(sigType);
      }
    }

    return suitableSigTypes;
  }

  private static String getSigTypeName(final String id) {
    final ItemType itemType = Utility.getItemById(id);

    final EList<EntryType> entries = itemType.getEntry();

    for (final EntryType entryType : entries) {
      if (entryType.getKey().equals("Name")) {
        return entryType.getValue();
      }
    }
    return null;
  }

  public static ArrayList<String> getSuitableRelations(final String typeName) {
    final ArrayList<String> suitableRelationNames = Utility.getRelationTypesForFirstSide(typeName);

    final EList<FieldType> fieldList =
        Utility.getDocumentRoot().getAlloy().getInstance().getField();
    final ArrayList<String> relations = new ArrayList<>();

    for (final String relationName : suitableRelationNames) {
      for (final FieldType fieldType : fieldList) {
        if (relationName.equals(fieldType.getLabel())) {
          final EList<TypesType> types = fieldType.getTypes();
          for (final TypesType typesType : types) {
            final String first =
                Utility.getSigTypeById(typesType.getType().get(0).getID()).getLabel();
            final String second =
                Utility.getSigTypeById(typesType.getType().get(1).getID()).getLabel();
            relations.add(relationName + " : " + first + " -> " + second);
          }
          break;
        }
      }
    }

    return relations;
  }

  public static ArrayList<ArrayList<String>> getSuitableSecondSideTypesOfRelation(
      final String relationName, final String firstSideType, final String firstSideId) {
    final EList<FieldType> fields = Utility.getDocumentRoot().getAlloy().getInstance().getField();

    final int firstSideTypeId = Utility.getSigTypeIdByName(firstSideType);

    int id = -1;
    FieldType foundFieldType = null;
    for (final FieldType fieldType : fields) {
      if (fieldType.getLabel().equals(relationName)
          && fieldType.getTypes().get(0).getType().get(0).getID() == firstSideTypeId) {
        id = fieldType.getTypes().get(0).getType().get(1).getID();
        foundFieldType = fieldType;
        break;
      }
    }

    final ArrayList<Integer> suitableIds = Utility.getAllChildIds(id);

    final EList<SigType> sigList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();
    final ArrayList<ArrayList<String>> suitableAtoms = new ArrayList<ArrayList<String>>();

    for (final SigType sigType : sigList) {
      if (suitableIds.contains(sigType.getID())) {
        final EList<AtomType> atomList = sigType.getAtom();
        final String sigName = sigType.getLabel();
        int index = 0;
        for (final AtomType atomType : atomList) {
          final EList<TupleType> tuples = foundFieldType.getTuple();
          String isCheck = "false";
          for (final TupleType tupleType : tuples) {
            if (tupleType.getAtom().get(0).getLabel().equals(firstSideId)
                && tupleType.getAtom().get(1).getLabel().equals(atomType.getLabel())) {
              isCheck = "true";
            }

          }

          final ArrayList<String> suitable = new ArrayList<>();
          suitable.add(sigName);
          suitable.add(sigName + Integer.toString(index));
          suitable.add(Utility.getSigTypeName(atomType.getLabel()));
          suitable.add(isCheck);
          suitableAtoms.add(suitable);
          index++;
        }
      }
    }


    return suitableAtoms;
  }

  public static TupleType getTupleTypeByAtoms(final AlloyAtom fromAlloyAtom,
      final AlloyAtom toAlloyAtom, final String relation) {
    final String fromAtomId = Utility.itemIdByAlloyAtom(fromAlloyAtom);
    final String toAtomId = Utility.itemIdByAlloyAtom(toAlloyAtom);

    final String fromAtomName = Utility.getAtomNameById(fromAtomId);
    final String toAtomName = Utility.getAtomNameById(toAtomId);

    final List<String> tupleList = new ArrayList<>();
    tupleList.add(fromAtomName);
    tupleList.add(toAtomName);

    final DocumentRoot documentRoot = Utility.getDocumentRoot();

    final EList<FieldType> fieldList = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fieldList) {
      if (fieldType.getLabel().equals(relation)) {
        final EList<TupleType> tupleTypeList = fieldType.getTuple();
        for (final TupleType tupleType : tupleTypeList) {
          if (fromAtomId.equals(tupleType.getAtom().get(0).getLabel())
              && toAtomId.equals(tupleType.getAtom().get(1).getLabel())) {
            return tupleType;
          }
        }
      }
    }
    return null;
  }

  /**
   *
   * @param relationName is relation name
   * @return if type is in the other type, return other type, else return null
   */
  public static String getType(final String relationName) {
    final EList<SigType> sigTypeList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();
    final Map<Integer, String> sigIdNameMap = new HashMap<>();

    for (final SigType sigType : sigTypeList) {
      sigIdNameMap.put(sigType.getID(), sigType.getLabel());
    }

    for (final SigType sigType : sigTypeList) {
      if (sigType.getLabel().equals(relationName)) {
        if (!sigType.getType().isEmpty()) {
          return sigIdNameMap.get(sigType.getType().get(0).getID());
        }
      }
    }
    return null;
  }

  public static List<TypeElement> getTypeHierarchy() {
    final EList<SigType> sigTypeList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();
    final Map<Integer, TypeElement> sigIdNameMap = new HashMap<>();
    final Map<Integer, Integer> sigIdParentIdMap = new HashMap<>();
    final List<TypeElement> topTypeElements = new ArrayList<>();

    for (final SigType sigType : sigTypeList) {
      if (sigType.getID() > 3) {
        String type = sigType.getLabel();
        if (sigType.getAbstract() != null && sigType.getAbstract().equals("yes")) {
          type += " {abs}";
        }
        if (sigType.getParentID() == 2) {
          sigIdNameMap.put(sigType.getID(), new TypeElement(type, true));
        } else {
          sigIdNameMap.put(sigType.getID(), new TypeElement(type));
        }

        sigIdParentIdMap.put(sigType.getID(), sigType.getParentID());
      }
    }

    final Iterator<Entry<Integer, Integer>> iter = sigIdParentIdMap.entrySet().iterator();

    while (iter.hasNext()) {
      final Entry<Integer, Integer> entry = iter.next();

      final TypeElement currentTypeElement = sigIdNameMap.get(entry.getKey());
      final TypeElement parentTypeElement = sigIdNameMap.get(entry.getValue());

      if (parentTypeElement != null) {
        parentTypeElement.getChildren().add(currentTypeElement);
      }

      if (currentTypeElement.isTop()) {
        topTypeElements.add(currentTypeElement);
      }
    }

    return topTypeElements;
  }


  public static List<MutableTreeNode> getTypeHierarchyForTree() {
    final EList<SigType> sigTypeList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();
    final Map<Integer, MutableTreeNode> sigIdNameMap = new HashMap<>();
    final Map<Integer, Integer> sigIdParentIdMap = new HashMap<>();
    final List<MutableTreeNode> topTypeElements = new ArrayList<>();
    final List<MutableTreeNode> topElements = new ArrayList<>();

    for (final SigType sigType : sigTypeList) {
      if (sigType.getID() > 3) {
        String type = sigType.getLabel();
        if (sigType.getAbstract() != null && sigType.getAbstract().equals("yes")) {
          type += " {abs}";
        }
        if (sigType.getParentID() == 2) {
          final DefaultMutableTreeNode node = new DefaultMutableTreeNode(type);
          sigIdNameMap.put(sigType.getID(), node);
          topElements.add(node);
        } else {
          sigIdNameMap.put(sigType.getID(), new DefaultMutableTreeNode(type));
        }
        if (sigType.getParentID() == 0) {
          final Integer parentID = sigIdParentIdMap.get(sigType.getType().get(0).getID());
          if (parentID == 2) {
            final MutableTreeNode node = sigIdNameMap.get(sigType.getID());
            topElements.add(node);
          }
          sigIdParentIdMap.put(sigType.getID(), parentID);
        } else {
          sigIdParentIdMap.put(sigType.getID(), sigType.getParentID());
        }
      }
    }

    final Iterator<Entry<Integer, Integer>> iter = sigIdParentIdMap.entrySet().iterator();

    while (iter.hasNext()) {
      final Entry<Integer, Integer> entry = iter.next();

      final MutableTreeNode currentTypeElement = sigIdNameMap.get(entry.getKey());
      final MutableTreeNode parentTypeElement = sigIdNameMap.get(entry.getValue());

      if (parentTypeElement != null) {
        parentTypeElement.insert(currentTypeElement, parentTypeElement.getChildCount());
      }

      if (currentTypeElement.toString().contains("{abs}")
          || topElements.contains(currentTypeElement)) {
        topTypeElements.add(currentTypeElement);
      }
    }

    return topTypeElements;
  }

  public static String itemIdByAlloyAtom(final AlloyAtom atom) {
    final String stringIndex = atom.toString().substring(atom.getType().getName().length());
    int index = 0;
    if (!stringIndex.isEmpty()) {
      index = Integer.parseInt(stringIndex);
    }

    return Utility.itemIdByIndex(atom.getType().getName(), index);
  }

  public static String itemIdByIndex(final String type, final int index) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigs) {
      if (sigType.getLabel().equals(type)) {
        return sigType.getAtom().get(index).getLabel();
      }
    }

    return null;
  }

  public static void removeAllRelationsOfAtom(final String id) {
    Utility.removeRelationFromFieldType(id);
    Utility.removeAtomTypeFromSigType(id);
    Utility.removeItemIdFromRepository(id);
  }

  public static void removeAtomTypeFromSigType(final String id) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();

    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigs) {
      final Iterator<AtomType> atomsIter = sigType.getAtom().iterator();
      while (atomsIter.hasNext()) {
        final AtomType atomType = atomsIter.next();
        if (atomType.getLabel().equals(id)) {
          atomsIter.remove();
          break;
        }
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  public static void removeItemIdFromRepository(final String id) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final Iterator<ItemType> itemsIter =
        documentRoot.getAlloy().getRepository().getItem().iterator();

    while (itemsIter.hasNext()) {
      final ItemType itemType = itemsIter.next();
      if (itemType.getId().equals(id)) {
        itemsIter.remove();
        break;
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  public static void removeRelation(final String fromId, final String toId, final String relation) {
    if (fromId == null || toId == null || relation == null) {
      return;
    }

    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fields) {
      if (fieldType.getLabel().equals(relation)) {
        final Iterator<TupleType> iterTuples = fieldType.getTuple().iterator();
        while (iterTuples.hasNext()) {
          final TupleType tupleType = iterTuples.next();
          if (fromId.equals(tupleType.getAtom().get(0).getLabel())
              && toId.equals(tupleType.getAtom().get(1).getLabel())) {
            iterTuples.remove();
            break;
          }
        }
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  public static void removeRelationFromFieldType(final String id) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();
    final List<Notifier> notifierList = Visualization.getInstance().getNotifierList();

    for (final FieldType fieldType : fields) {
      final Iterator<TupleType> tuplesIter = fieldType.getTuple().iterator();
      while (tuplesIter.hasNext()) {
        final TupleType tupleType = tuplesIter.next();
        if (tupleType.getAtom().get(0).getLabel().equals(id)
            || tupleType.getAtom().get(1).getLabel().equals(id)) {
          tuplesIter.remove();

          String fromAtomName = getAtomNameById(tupleType.getAtom().get(0).getLabel());
          String toAtomName = getAtomNameById(tupleType.getAtom().get(1).getLabel());

          List<String> tupleList = new ArrayList<>();

          tupleList.add(fromAtomName);
          tupleList.add(toAtomName);

          for (final Notifier notifier : notifierList) {
            notifier.removeTupleNotify(fieldType.getLabel(), tupleList,
                Visualization.getInstance().isLower() ? "lower" : "upper");
          }
        }
      }
    }
    Utility.writeDocumentRoot(documentRoot);
  }

  public static void setBoundOfAtomType(final AlloyAtom alloyAtom, final boolean isLower) {
    final String id = Utility.itemIdByAlloyAtom(alloyAtom);
    final String type = alloyAtom.getType().getName();

    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    final EList<SigType> sigList = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigList) {
      if (sigType.getLabel().equals(type)) {
        boolean flag = false;
        final EList<AtomType> atomList = sigType.getAtom();
        for (final AtomType atomType : atomList) {
          if (atomType.getLabel().equals(id)) {
            final String realTypeOfAtom = Utility.getRealTypeOfAtom(atomType.getLabel(), type);
            flag = true;
            final List<Notifier> notifierList = Visualization.getInstance().getNotifierList();
            final List<String> tupleList = new ArrayList<>();
            tupleList.add(Utility.getAtomNameById(id));
            if (isLower) {
              atomType.setBound("lower");
              for (final Notifier notifier : notifierList) {
                if (realTypeOfAtom != null) {
                  notifier.moveToLower(realTypeOfAtom, type, tupleList);
                } else {
                  notifier.moveToLower(type, tupleList);
                }
              }
            } else {
              atomType.setBound("upper");
              for (final Notifier notifier : notifierList) {
                if (realTypeOfAtom != null) {
                  notifier.moveToUpper(realTypeOfAtom, type, tupleList);
                } else {
                  notifier.moveToUpper(type, tupleList);
                }
              }
            }
            break;
          }
        }
        if (flag) {
          break;
        }
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  public static void setBoundOfTupleType(final AlloyTuple alloyTuple, final String relation,
      final boolean isLower) {
    final AlloyAtom fromAtom = alloyTuple.getStart();
    final AlloyAtom toAtom = alloyTuple.getEnd();

    final String fromAtomId = Utility.itemIdByAlloyAtom(fromAtom);
    final String toAtomId = Utility.itemIdByAlloyAtom(toAtom);

    final String fromAtomName = Utility.getAtomNameById(fromAtomId);
    final String toAtomName = Utility.getAtomNameById(toAtomId);

    final List<String> tupleList = new ArrayList<>();
    tupleList.add(fromAtomName);
    tupleList.add(toAtomName);

    final List<Notifier> notifierList = Visualization.getInstance().getNotifierList();

    final DocumentRoot documentRoot = Utility.getDocumentRoot();

    final EList<FieldType> fieldList = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fieldList) {
      if (fieldType.getLabel().equals(relation)) {
        boolean flag = false;
        final EList<TupleType> tupleTypeList = fieldType.getTuple();
        for (final TupleType tupleType : tupleTypeList) {
          if (fromAtomId.equals(tupleType.getAtom().get(0).getLabel())
              && toAtomId.equals(tupleType.getAtom().get(1).getLabel())) {
            flag = true;
            if (isLower) {
              tupleType.setBound("lower");
              for (final Notifier notifier : notifierList) {
                notifier.moveToLower(relation, tupleList);
              }
            } else {
              tupleType.setBound("upper");
              for (final Notifier notifier : notifierList) {
                notifier.moveToUpper(relation, tupleList);
              }
            }
            break;
          }
        }
        if (flag) {
          break;
        }
      }
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  @SuppressWarnings("unchecked")
  protected static void writeDocumentRoot(final DocumentRoot documentRoot) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    modelIO.write(URI.createFileURI(XmlCreator.xmlfile), documentRoot);
  }
}
