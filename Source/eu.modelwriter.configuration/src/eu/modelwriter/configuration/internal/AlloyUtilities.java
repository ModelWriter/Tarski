/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.configuration.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JDialog;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.RelationType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;

public class AlloyUtilities {

  final public static String GROUP_ID = "groupId";
  final public static String LEADER_ID = "leaderId";
  final public static String MARKER_URI = "uri";
  final public static String OFFSET = "offset";
  final public static String RESOURCE = "resource";
  public static ResourceSet resourceSet;

  final public static String TEXT = "text";
  public static Map<String, Integer> typeHashMap = new HashMap<String, Integer>();
  public static String xmlFileLocation = "alloyXml.xml";

  public static void addMapping2RelationType(IMarker fromMarker, IMarker toMarker) {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    RelationType relationType = documentRoot.getAlloy().getRelation();

    TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
    relationType.getTuple().add(tupleType);

    AtomType fromAtom = persistenceFactory.eINSTANCE.createAtomType();
    tupleType.getAtom().add(fromAtom);
    fromAtom.setLabel(MarkUtilities.getSourceId(fromMarker));

    AtomType toAtom = persistenceFactory.eINSTANCE.createAtomType();
    tupleType.getAtom().add(toAtom);
    toAtom.setLabel(MarkUtilities.getSourceId(toMarker));

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void addMarkerToRepository(IMarker marker) {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    documentRoot.getAlloy().getRepository().getItem().add(itemType);
    itemType.setId(MarkUtilities.getSourceId(marker));

    AlloyUtilities.setEntries(itemType, marker);

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void addRelation2Markers(IMarker fromMarker, IMarker toMarker, String relation) {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    AtomType fromAtom = persistenceFactory.eINSTANCE.createAtomType();
    fromAtom.setLabel(MarkUtilities.getSourceId(fromMarker));

    AtomType toAtom = persistenceFactory.eINSTANCE.createAtomType();
    toAtom.setLabel(MarkUtilities.getSourceId(toMarker));

    TupleType tuple = persistenceFactory.eINSTANCE.createTupleType();
    tuple.getAtom().add(fromAtom);
    tuple.getAtom().add(toAtom);

    EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (FieldType fieldType : fields) {
      if (relation.equals(fieldType.getLabel())) {
        if (!AlloyUtilities.isContainTuple(fieldType, tuple)) {
          fieldType.getTuple().add(tuple);
        }
        break;
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void addRelation2Markers(IMarker selectedMarker, Object[] checkedMarkers,
      Map<IMarker, String> relationMap) {

    for (Object object : checkedMarkers) {
      if (object instanceof IMarker) {
        IMarker marker = (IMarker) object;
        String relationName = relationMap.get(marker);
        AlloyUtilities.addRelation2Markers(selectedMarker, marker, relationName);
      }
    }
  }

  public static void addTypeToMarker(IMarker marker) {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    AtomType atom = persistenceFactory.eINSTANCE.createAtomType();

    atom.setLabel(MarkUtilities.getSourceId(marker));

    String type = MarkUtilities.getType(marker);

    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      if (type.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        sigType.getAtom().add(atom);
        break;
      }
    }

    if (AlloyUtilities.findItemTypeInRepository(marker) == -1) {
      ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
      documentRoot.getAlloy().getRepository().getItem().add(itemType);
      itemType.setId(MarkUtilities.getSourceId(marker));

      AlloyUtilities.setEntries(itemType, marker);
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static int findItemTypeInRepository(IMarker marker) {
    String markerId = MarkUtilities.getSourceId(marker);

    EList<ItemType> itemTypes = AlloyUtilities.getItemtypes();

    int itemTypeIndex = 0;

    for (ItemType itemType : itemTypes) {
      if (markerId.equals(itemType.getId())) {
        return itemTypeIndex;
      }
      itemTypeIndex++;
    }

    return -1;
  }

  public static ArrayList<Integer> getAllChildIds(int id) {
    ArrayList<Integer> ids = new ArrayList<Integer>();

    ArrayList<SigType> sigTypes = AlloyUtilities.getSigTypeListByParentId(id);

    for (SigType sigType : sigTypes) {
      ids.addAll(AlloyUtilities.getAllChildIds(sigType.getID()));
    }

    ids.add(id);

    return ids;
  }

  public static ArrayList<Integer> getAllParentIds(int id) {
    ArrayList<Integer> ids = new ArrayList<Integer>();

    do {
      ids.add(id);
      SigType sigType = AlloyUtilities.getSigTypeById(id);
      id = sigType.getParentID();
    } while (id != 0);

    return ids;
  }


  public static DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = modelIO.read(AlloyUtilities.getUri());
    if (list.isEmpty()) {
      return null;
    }
    DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  public static EList<FieldType> getFieldTypes() {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    return documentRoot.getAlloy().getInstance().getField();
  }

  /**
   * @param typeName
   * @param side if true, return FieldType List according left side type
   * @return
   */
  public static ArrayList<FieldType> getFieldTypesList(String typeName, boolean side) {
    EList<FieldType> fields = AlloyUtilities.getFieldTypes();
    ArrayList<FieldType> foundFieldTypes = new ArrayList<FieldType>();

    int id = AlloyUtilities.getSigTypeIdByName(typeName);

    for (FieldType fieldType : fields) {
      EList<TypesType> typesTypes = fieldType.getTypes();
      for (TypesType typesType : typesTypes) {
        EList<TypeType> typeTypes = typesType.getType();
        if (side && (typeTypes.get(0).getID() == id)) {
          foundFieldTypes.add(fieldType);
          break;
        } else if (!side && (typeTypes.get(1).getID() == id)) {
          foundFieldTypes.add(fieldType);
          break;
        }
      }
    }

    return foundFieldTypes;
  }

  public static ItemType getItemById(String id) {
    EList<ItemType> itemTypes = AlloyUtilities.getItemtypes();

    for (ItemType itemType : itemTypes) {
      if (id.equals(itemType.getId())) {
        return itemType;
      }
    }

    return null;
  }

  public static EList<ItemType> getItemtypes() {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    return documentRoot.getAlloy().getRepository().getItem();
  }

  public static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/"
        + AlloyUtilities.xmlFileLocation;
  }

  public static Map<IMarker, String> getRelationsOfFirstSideMarker(IMarker selectedMarker) {
    Map<IMarker, String> relationsOfMarker = new HashMap<IMarker, String>();
    if (MarkUtilities.getType(selectedMarker) == null) {
      return relationsOfMarker;
    }
    ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        AlloyUtilities.getFieldTypesList(MarkUtilities.getType(selectedMarker), true);
    String selectedMarkerId = MarkUtilities.getSourceId(selectedMarker);

    for (FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      EList<TupleType> tupleTypes = fieldType.getTuple();
      for (TupleType tupleType : tupleTypes) {
        EList<AtomType> atoms = tupleType.getAtom();
        AtomType firstAtomType = atoms.get(0);
        if (firstAtomType.getLabel().equals(selectedMarkerId)) {
          AtomType secondAtomType = atoms.get(1);
          ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
          IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
              AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
          relationsOfMarker.put(toMarker, fieldType.getLabel());
        }
      }
    }

    return relationsOfMarker;
  }

  public static Map<IMarker, String> getRelationsOfSecondSideMarker(IMarker selectedMarker) {
    Map<IMarker, String> relationsOfMarker = new HashMap<IMarker, String>();
    if (MarkUtilities.getType(selectedMarker) == null) {
      return relationsOfMarker;
    }
    ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        AlloyUtilities.getFieldTypesList(MarkUtilities.getType(selectedMarker), false);
    String selectedMarkerId = MarkUtilities.getSourceId(selectedMarker);

    for (FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      EList<TupleType> tupleTypes = fieldType.getTuple();
      for (TupleType tupleType : tupleTypes) {
        EList<AtomType> atoms = tupleType.getAtom();
        AtomType firstAtomType = atoms.get(1);
        if (firstAtomType.getLabel().equals(selectedMarkerId)) {
          AtomType secondAtomType = atoms.get(0);
          ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
          IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
              AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
          relationsOfMarker.put(toMarker, fieldType.getLabel());
        }
      }
    }

    return relationsOfMarker;
  }

  /**
   * This method is used to get Relations
   *
   * @return
   */
  public static RelationType getRelationType() {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    return documentRoot.getAlloy().getRelation();
  }

  public static ArrayList<String> getRelationTypesForFirstSide(String typeName) {
    ArrayList<String> relationTypeNames = new ArrayList<String>();

    int TypeId = AlloyUtilities.getSigTypeIdByName(typeName);

    ArrayList<Integer> parentIds = AlloyUtilities.getAllParentIds(TypeId);

    EList<FieldType> fieldTypes = AlloyUtilities.getFieldTypes();

    for (FieldType fieldType : fieldTypes) {
      for (Integer parentId : parentIds) {
        if (fieldType.getParentID() == parentId) {
          relationTypeNames.add(fieldType.getLabel());
          break;
        }
      }
    }

    return relationTypeNames;
  }

  public static ArrayList<IMarker> getSecondSideMarkerIdsByMarkerAndRelation(IMarker marker,
      String relation) {
    EList<FieldType> fieldTypes = AlloyUtilities.getFieldTypes();

    String markerId = MarkUtilities.getSourceId(marker);

    ArrayList<IMarker> suitableMarkers = new ArrayList<IMarker>();

    for (FieldType fieldType : fieldTypes) {
      if (fieldType.getLabel().equals(relation)) {
        EList<TupleType> tuples = fieldType.getTuple();
        for (TupleType tupleType : tuples) {
          EList<AtomType> atoms = tupleType.getAtom();
          if (atoms.get(0).getLabel().equals(markerId)) {
            ItemType itemType = AlloyUtilities.getItemById(atoms.get(1).getLabel());
            IMarker suitableMarker = MarkUtilities.getiMarker(itemType.getId(),
                AlloyUtilities.getValueOfEntry(itemType, AlloyUtilities.RESOURCE));
            suitableMarkers.add(suitableMarker);
          }
        }
        break;
      }
    }

    return suitableMarkers;
  }

  /**
   * This method is used to get Target List of iMarker. Also iMarker doesn't contain any marker
   * type.
   *
   * @param iMarker
   * @return
   */
  public static ArrayList<IMarker> getSecondSideMarkerIdsByMarkerAndRelationV2(IMarker iMarker) {
    RelationType relationType = AlloyUtilities.getRelationType();
    EList<TupleType> tupleTypes = relationType.getTuple();

    String markerId = MarkUtilities.getSourceId(iMarker);

    ArrayList<IMarker> suitableMarkers = new ArrayList<IMarker>();

    for (TupleType tupleType : tupleTypes) {
      EList<AtomType> atoms = tupleType.getAtom();
      if (atoms.get(0).getLabel().equals(markerId)) {
        ItemType itemType = AlloyUtilities.getItemById(atoms.get(1).getLabel());
        IMarker suitableMarker = MarkUtilities.getiMarker(itemType.getId(),
            AlloyUtilities.getValueOfEntry(itemType, AlloyUtilities.RESOURCE));
        suitableMarkers.add(suitableMarker);
      }
    }

    return suitableMarkers;
  }

  public static SigType getSigTypeById(int id) {
    EList<SigType> sigTypes = AlloyUtilities.getSigTypes();

    for (SigType sigType : sigTypes) {
      if (id == sigType.getID()) {
        return sigType;
      }
    }
    return null;
  }

  public static int getSigTypeIdByName(String typeName) {
    int id = -1;

    if (AlloyUtilities.typeHashMap.get(typeName) == null) {
      EList<SigType> sigTypes = AlloyUtilities.getSigTypes();

      for (SigType sigType : sigTypes) {
        if (typeName.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
          id = sigType.getID();
          AlloyUtilities.typeHashMap.put(typeName, id);
          break;
        }
      }
    } else {
      id = AlloyUtilities.typeHashMap.get(typeName);
    }
    return id;
  }

  public static ArrayList<SigType> getSigTypeListByParentId(int id) {
    ArrayList<SigType> suitableSigTypes = new ArrayList<>();

    EList<SigType> sigTypes = AlloyUtilities.getSigTypes();

    for (SigType sigType : sigTypes) {
      if (sigType.getParentID() == id) {
        suitableSigTypes.add(sigType);
      }
    }

    return suitableSigTypes;
  }

  public static EList<SigType> getSigTypes() {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    return documentRoot.getAlloy().getInstance().getSig();
  }

  /**
   * This method is used to get source marker list of iMarker. Also iMarker doesn't contain any
   * marker type.
   *
   * @param iMarker
   * @return
   */
  public static ArrayList<IMarker> getSourcesOfRelationMarker(IMarker iMarker) {
    ArrayList<IMarker> sources = new ArrayList<IMarker>();

    RelationType relationType = AlloyUtilities.getRelationType();
    String selectedMarkerId = MarkUtilities.getSourceId(iMarker);

    EList<TupleType> tupleTypes = relationType.getTuple();
    for (TupleType tupleType : tupleTypes) {
      EList<AtomType> atoms = tupleType.getAtom();
      AtomType firstAtomType = atoms.get(1);
      if (firstAtomType.getLabel().equals(selectedMarkerId)) {
        AtomType secondAtomType = atoms.get(0);
        ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
        IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
            AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
        sources.add(toMarker);
      }
    }
    return sources;
  }

  public static ArrayList<String> getSuitableSecondSideTypesOfRelation(String relationName) {
    EList<FieldType> fields = AlloyUtilities.getFieldTypes();

    ArrayList<String> suitableRelationNames = new ArrayList<String>();

    int id = -1;
    for (FieldType fieldType : fields) {
      if (fieldType.getLabel().equals(relationName)) {
        id = fieldType.getTypes().get(0).getType().get(1).getID();
      }
    }

    ArrayList<Integer> suitableIds = AlloyUtilities.getAllChildIds(id);

    for (Integer suitableId : suitableIds) {
      suitableRelationNames.add(AlloyUtilities.getSigTypeById(suitableId).getLabel());
    }

    return suitableRelationNames;
  }



  /**
   * This method is used to when iMarker has marker type and we want to find it's sources both have
   * marker type or not.
   *
   * @param iMarker
   * @return
   */
  public static ArrayList<IMarker> getSumSources(IMarker iMarker) {
    Map<IMarker, String> sourcesMap = AlloyUtilities.getRelationsOfSecondSideMarker(iMarker);
    ArrayList<IMarker> sourcesList = AlloyUtilities.getSourcesOfRelationMarker(iMarker);

    ArrayList<IMarker> resultList = new ArrayList<IMarker>(sourcesList);

    Set<IMarker> sourceMarkers = sourcesMap.keySet();
    Iterator<IMarker> iter = sourceMarkers.iterator();
    while (iter.hasNext()) {
      IMarker iMarkerSet = iter.next();
      if (!sourcesList.contains(iMarkerSet)) {
        resultList.add(iMarkerSet);
      }
    }
    return resultList;
  }

  /**
   * This method is used to get target marker list of iMarker. Also iMarker doesn't contain any
   * marker type.
   *
   * @param iMarker
   * @return
   */
  public static ArrayList<IMarker> getTargetsOfRelationMarker(IMarker iMarker) {
    ArrayList<IMarker> targets = new ArrayList<IMarker>();

    RelationType relationType = AlloyUtilities.getRelationType();
    String selectedMarkerId = MarkUtilities.getSourceId(iMarker);

    EList<TupleType> tupleTypes = relationType.getTuple();
    for (TupleType tupleType : tupleTypes) {
      EList<AtomType> atoms = tupleType.getAtom();
      AtomType firstAtomType = atoms.get(0);
      if (firstAtomType.getLabel().equals(selectedMarkerId)) {
        AtomType secondAtomType = atoms.get(1);
        ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
        IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
            AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
        targets.add(toMarker);

      }
    }

    return targets;
  }

  public static URI getUri() {
    return URI.createFileURI(AlloyUtilities.getLocation());
  }

  public static String getValueOfEntry(ItemType itemType, String key) {
    String value = null;
    EList<EntryType> entries = itemType.getEntry();

    for (EntryType entryType : entries) {
      if (key.equals(entryType.getKey())) {
        value = entryType.getValue();
      }
    }
    return value;
  }

  public static boolean isContainTuple(FieldType fieldType, TupleType searchedTupleType) {
    EList<TupleType> tuples = fieldType.getTuple();
    EList<AtomType> searchedAtoms = searchedTupleType.getAtom();
    for (TupleType tupleType : tuples) {
      EList<AtomType> atoms = tupleType.getAtom();
      if (atoms.get(0).getLabel().equals(searchedAtoms.get(0).getLabel())
          && atoms.get(1).getLabel().equals(searchedAtoms.get(1).getLabel())) {
        return true;
      }
    }
    return false;
  }

  /**
   * @return true if Alloy file parsed and XML file is constructed , false if doesn't.
   */
  public static boolean isExists() {
    Path path = new Path(AlloyUtilities.getLocation());
    return path.toFile().exists() ? true : false;
  }

  public static void removeAllRelationsOfMarker(IMarker marker) {
    if (marker != null) {
      Iterator<Entry<IMarker, String>> iter;
      Map<IMarker, String> relationsOfFirstSide =
          AlloyUtilities.getRelationsOfFirstSideMarker(marker);
      iter = relationsOfFirstSide.entrySet().iterator();

      while (iter.hasNext()) {
        @SuppressWarnings("rawtypes")
        Map.Entry pair = iter.next();
        AlloyUtilities.removeFieldOfMarkers(marker, (IMarker) pair.getKey(),
            (String) pair.getValue());
      }

      Map<IMarker, String> relationsOfSecondSide =
          AlloyUtilities.getRelationsOfSecondSideMarker(marker);
      iter = relationsOfSecondSide.entrySet().iterator();

      while (iter.hasNext()) {
        @SuppressWarnings("rawtypes")
        Map.Entry pair = iter.next();
        AlloyUtilities.removeFieldOfMarkers((IMarker) pair.getKey(), marker,
            (String) pair.getValue());
      }
    }
  }

  public static void removeFieldOfMarkers(IMarker fromMarker, IMarker toMarker,
      String relationName) {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();

    String fromMarkerId = MarkUtilities.getSourceId(fromMarker);
    String toMarkerId = MarkUtilities.getSourceId(toMarker);

    for (FieldType fieldType : fieldTypes) {
      if (fieldType.getLabel().equals(relationName)) {
        Iterator<TupleType> tupleTypesİter = fieldType.getTuple().iterator();
        while (tupleTypesİter.hasNext()) {
          EList<AtomType> atoms = tupleTypesİter.next().getAtom();
          if (atoms.get(0).getLabel().equals(fromMarkerId)
              && atoms.get(1).getLabel().equals(toMarkerId)) {
            tupleTypesİter.remove();
            AlloyUtilities.writeDocumentRoot(documentRoot);
            return;
          }
        }
      }
    }
  }

  /**
   * This method is used to when fromMarker doesn't map toMarker any more.
   *
   * @param fromMarker
   * @param toMarker
   */
  public static void removeMappingFromRelationType(IMarker fromMarker, IMarker toMarker) {
    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    RelationType relationType = AlloyUtilities.getRelationType();

    String fromMarkerId = MarkUtilities.getSourceId(fromMarker);
    String toMarkerId = MarkUtilities.getSourceId(toMarker);

    Iterator<TupleType> iter = relationType.getTuple().iterator();
    while (iter.hasNext()) {
      EList<AtomType> atoms = iter.next().getAtom();
      if (atoms.get(0).getLabel().equals(fromMarkerId)
          && atoms.get(1).getLabel().equals(toMarkerId)) {
        iter.remove();
        AlloyUtilities.writeDocumentRoot(documentRoot);
        return;
      }
    }
  }

  public static void removeMarker(IMarker marker) {
    AlloyUtilities.removeAllRelationsOfMarker(marker);

    AlloyUtilities.removeTypeFromMarker(marker);

    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    int itemTypeIndex = AlloyUtilities.findItemTypeInRepository(marker);
    if (itemTypeIndex == -1) {
      return;
    }
    documentRoot.getAlloy().getRepository().getItem().remove(itemTypeIndex);

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }


  /**
   * Removes relation of given marker
   *
   * @param marker which will be deleted relation of
   */
  public static void removeRelationOfMarker(IMarker marker) {
    String id = MarkUtilities.getSourceId(marker);
    EList<TupleType> tupleTypes = AlloyUtilities.getRelationType().getTuple();
    Iterator<TupleType> iter = tupleTypes.iterator();
    while (iter.hasNext()) {
      TupleType tupleType = iter.next();
      AtomType firstSideAtom = tupleType.getAtom().get(0);
      AtomType secondSideAtom = tupleType.getAtom().get(1);
      if (firstSideAtom.getLabel().equals(id) || secondSideAtom.getLabel().equals(id)) {
        iter.remove();
      }
    }
    AlloyUtilities.writeDocumentRoot(AlloyUtilities.getDocumentRoot());
  }

  public static void removeTypeFromMarker(IMarker marker) {
    if ((MarkUtilities.getType(marker) == null) || MarkUtilities.getType(marker).isEmpty()) {
      return;
    }

    DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    String type = MarkUtilities.getType(marker);

    String markerId = MarkUtilities.getSourceId(marker);

    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      if (type.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        Iterator<AtomType> atomsIter = sigType.getAtom().iterator();
        while (atomsIter.hasNext()) {
          AtomType atomType = atomsIter.next();
          if (atomType.getLabel().equals(markerId)) {
            atomsIter.remove();
            break;
          }
        }
        break;
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  private static void setEntries(ItemType itemType, IMarker marker) {
    if (MarkUtilities.getPath(marker) != null) {
      EntryType resourceEntry = persistenceFactory.eINSTANCE.createEntryType();
      resourceEntry.setKey(AlloyUtilities.RESOURCE);
      resourceEntry.setValue(MarkUtilities.getPath(marker));
      itemType.getEntry().add(resourceEntry);
    }
    if (MarkUtilities.getStart(marker) != -1) {
      EntryType offsetEntry = persistenceFactory.eINSTANCE.createEntryType();
      offsetEntry.setKey(AlloyUtilities.OFFSET);
      offsetEntry.setValue(Integer.toString(MarkUtilities.getStart(marker)));
      itemType.getEntry().add(offsetEntry);
    }
    if (MarkUtilities.getText(marker) != null) {
      EntryType textEntry = persistenceFactory.eINSTANCE.createEntryType();
      textEntry.setKey(AlloyUtilities.TEXT);
      textEntry.setValue(MarkUtilities.getText(marker));
      itemType.getEntry().add(textEntry);
    }
    if (MarkUtilities.getUri(marker) != null) {
      EntryType uriEntry = persistenceFactory.eINSTANCE.createEntryType();
      uriEntry.setKey(AlloyUtilities.MARKER_URI);
      uriEntry.setValue(MarkUtilities.getUri(marker));
      itemType.getEntry().add(uriEntry);
    }
    if (MarkUtilities.getLeaderId(marker) != null) {
      EntryType leaderIdEntry = persistenceFactory.eINSTANCE.createEntryType();
      leaderIdEntry.setKey(AlloyUtilities.LEADER_ID);
      leaderIdEntry.setValue(MarkUtilities.getLeaderId(marker));
      itemType.getEntry().add(leaderIdEntry);
    }
    if (MarkUtilities.getGroupId(marker) != null) {
      EntryType groupIdEntry = persistenceFactory.eINSTANCE.createEntryType();
      groupIdEntry.setKey(AlloyUtilities.GROUP_ID);
      groupIdEntry.setValue(MarkUtilities.getGroupId(marker));
      itemType.getEntry().add(groupIdEntry);
    }
  }

  public static void showViz() {
    final String xmlFileName = Util.canon(AlloyUtilities.getLocation());
    File f = new File(xmlFileName);
    AlloyInstance myInstance = null;
    try {
      if (!f.exists()) {
        throw new IOException("File " + xmlFileName + " does not exist.");
      }
      myInstance = StaticInstanceReader.parseInstance(f);
    } catch (Err e1) {
      e1.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    VizState myState = null;

    myState = new VizState(myInstance);

    // VizCustomizationPanel customizationPanel = new VizCustomizationPanel(null, myState);
    // myState.loadPaletteXML("C:\\Users\\3\\Desktop\\theme.thm");
    // myState.useOriginalName(true);
    VizGraphPanel graph = new VizGraphPanel(myState, false);
    JDialog dialog = new JDialog();
    dialog.add(graph);
    dialog.setVisible(true);
    dialog.pack();
  }

  @SuppressWarnings("unchecked")
  public static void writeDocumentRoot(DocumentRoot documentRoot) {
    @SuppressWarnings("rawtypes")
    ModelIO modelIO = new ModelIO<>();
    modelIO.write(AlloyUtilities.getUri(), documentRoot);
  }
}
