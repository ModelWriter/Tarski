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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.AlloyRelation;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.RelationType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.SourceType;
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
  final public static String TEXT = "text";

  public static Map<String, Integer> typeHashMap = new HashMap<>();
  public static String xmlFileLocation =
      ".modelwriter persistence.xml".replace(" ", System.getProperty("file.separator"));

  public static int getTotalTargetCount(final IMarker marker) {
    final Map<IMarker, String> fieldsTargets = AlloyUtilities.getRelationsOfFirstSideMarker(marker);
    final ArrayList<IMarker> relationsTargets =
        AlloyUtilities.getTargetsOfMarkerAtRelations(marker);

    return fieldsTargets.size() + relationsTargets.size();
  }

  public static void addMapping2RelationType(IMarker fromMarker, IMarker toMarker) {
    fromMarker = MarkUtilities.getLeaderOfMarker(fromMarker);
    toMarker = MarkUtilities.getLeaderOfMarker(toMarker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final RelationType relationType = documentRoot.getAlloy().getRelation();

    final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
    relationType.getTuple().add(tupleType);

    final AtomType fromAtom = persistenceFactory.eINSTANCE.createAtomType();
    tupleType.getAtom().add(fromAtom);
    fromAtom.setLabel(MarkUtilities.getSourceId(fromMarker));

    final AtomType toAtom = persistenceFactory.eINSTANCE.createAtomType();
    tupleType.getAtom().add(toAtom);
    toAtom.setLabel(MarkUtilities.getSourceId(toMarker));

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void addMarkerToRepository(final IMarker marker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    if (AlloyUtilities.findItemTypeInRepository(marker) == -1) {
      final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
      documentRoot.getAlloy().getRepository().getItem().add(itemType);
      itemType.setId(MarkUtilities.getSourceId(marker));

      AlloyUtilities.setEntries(itemType, marker);
    }
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void addRelation2Markers(IMarker fromMarker, IMarker toMarker,
      final String relation) {
    fromMarker = MarkUtilities.getLeaderOfMarker(fromMarker);
    toMarker = MarkUtilities.getLeaderOfMarker(toMarker);

    final ArrayList<Integer> allParentIdsOfFromMarkerType = AlloyUtilities
        .getAllParentIds(AlloyUtilities.getSigTypeIdByName(MarkUtilities.getType(fromMarker)));
    final ArrayList<Integer> allParentIdsOfToMarkerType = AlloyUtilities
        .getAllParentIds(AlloyUtilities.getSigTypeIdByName(MarkUtilities.getType(toMarker)));

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final AtomType fromAtom = persistenceFactory.eINSTANCE.createAtomType();
    fromAtom.setLabel(MarkUtilities.getSourceId(fromMarker));

    final AtomType toAtom = persistenceFactory.eINSTANCE.createAtomType();
    toAtom.setLabel(MarkUtilities.getSourceId(toMarker));

    final TupleType tuple = persistenceFactory.eINSTANCE.createTupleType();
    tuple.getAtom().add(fromAtom);
    tuple.getAtom().add(toAtom);

    final EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fields) {
      if (!fieldType.getLabel().equals(relation)) {
        continue;
      }
      for (final TypesType typesType : fieldType.getTypes()) {
        if (allParentIdsOfFromMarkerType.contains(typesType.getType().get(0).getID())
            && allParentIdsOfToMarkerType.contains(typesType.getType().get(1).getID())) {
          if (!AlloyUtilities.isContainTuple(fieldType, tuple)) {
            fieldType.getTuple().add(tuple);
          }
          break;
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void addRelation2Markers(IMarker selectedMarker, final Object[] checkedMarkers,
      final Map<IMarker, String> relationMap) {
    selectedMarker = MarkUtilities.getLeaderOfMarker(selectedMarker);

    for (final Object object : checkedMarkers) {
      if (object instanceof IMarker) {
        IMarker marker = (IMarker) object;
        marker = MarkUtilities.getLeaderOfMarker(marker);
        final String relationName = relationMap.get(marker);
        AlloyUtilities.addRelation2Markers(selectedMarker, marker, relationName);
      }
    }
    AnnotationFactory.convertAnnotationType(selectedMarker, false, false,
        AlloyUtilities.getTotalTargetCount(selectedMarker));
  }

  public static AtomType addStrayedAtom2Sig(final String sigName) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final String id = MarkerFactory.generateId();

    final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    itemType.setId(id);
    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
    atomType.setLabel(id);
    atomType.setReasoned(true);

    for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(sigType.getLabel().indexOf("/") + 1);
      if (label.equals(sigName)) {
        sigType.getAtom().add(atomType);
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    return atomType;
  }

  public static AtomType addNewAtom2Sig(final String sigName) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final String id = MarkerFactory.generateId();

    final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    itemType.setId(id);
    documentRoot.getAlloy().getRepository().getItem().add(itemType);

    final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
    atomType.setLabel(id);
    atomType.setReasoned(false);

    for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(sigType.getLabel().indexOf("/") + 1);
      if (label.equals(sigName)) {
        sigType.getAtom().add(atomType);
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    return atomType;
  }

  public static void addTypeToMarker(final IMarker marker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final AtomType atom = persistenceFactory.eINSTANCE.createAtomType();

    atom.setLabel(MarkUtilities.getSourceId(marker));

    final String type = MarkUtilities.getType(marker);

    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    final int idOfTypeSigInSigType = AlloyUtilities.isTypeInSig(type);

    for (final SigType sigType : sigs) {
      if (type.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        sigType.getAtom().add(atom);
      } else if (idOfTypeSigInSigType != -1 && sigType.getID() == idOfTypeSigInSigType) {
        final AtomType typeAtom = persistenceFactory.eINSTANCE.createAtomType();
        typeAtom.setLabel(MarkUtilities.getSourceId(marker));
        sigType.getAtom().add(typeAtom);
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void assignMarker2Atom(final IMarker marker, final AlloyAtom atom) {
    final String atomName = atom.getOriginalName();
    final String sigName = atom.getType().getName();
    final int index = Integer.valueOf(atomName.substring(atomName.indexOf("$") + 1));

    final SigType sigType =
        AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigName));
    final String id = sigType.getAtom().get(index).getLabel();

    final int itemITypeIndex = AlloyUtilities.findItemTypeInRepository(marker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    documentRoot.getAlloy().getRepository().getItem().get(itemITypeIndex).setId(id);
    MarkUtilities.setSourceId(marker, id);
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void bindAtomToMarker(final String sigTypeName, final int index,
      final IMarker selectedMarker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    String atomId = null;

    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();
    final EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();
    final EList<ItemType> items = documentRoot.getAlloy().getRepository().getItem();

    for (final SigType sigType : sigs) {
      String label = sigType.getLabel();
      label = label.substring(label.indexOf("/") + 1);
      if (label.equals(sigTypeName)) {
        final AtomType atomType = sigType.getAtom().get(index);
        atomType.setReasoned(false);
        atomId = atomType.getLabel();
        break;
      }
    }

    for (final FieldType fieldType : fields) {
      for (final TupleType tupleType : fieldType.getTuple()) {
        for (final AtomType atomType : tupleType.getAtom()) {
          if (atomType.getLabel().equals(atomId)) {
            atomType.setReasoned(false);
          }
        }
      }
    }

    final String id = MarkUtilities.getSourceId(selectedMarker);

    for (final ItemType itemType : items) {
      if (itemType.getId().equals(id)) {
        itemType.setId(atomId);
        break;
      }
    }
    MarkUtilities.setSourceId(selectedMarker, atomId);
    MarkUtilities.setType(selectedMarker, sigTypeName);

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void clearAllReasonedTuplesAndAtoms() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();

    for (final FieldType fieldType : fieldTypes) {
      final Iterator<TupleType> tupleIter = fieldType.getTuple().iterator();

      while (tupleIter.hasNext()) {
        final TupleType tupleType = tupleIter.next();
        if (tupleType.isReasoned()) {
          tupleIter.remove();
        }
      }
    }

    final EList<SigType> sigTypes = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      final Iterator<AtomType> atomIter = sigType.getAtom().iterator();
      while (atomIter.hasNext()) {
        final AtomType atomType = atomIter.next();
        if (atomType.isReasoned()) {
          atomIter.remove();
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void clearFields() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    for (final FieldType fieldType : documentRoot.getAlloy().getInstance().getField()) {
      fieldType.getTuple().clear();
    }
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void clearRelation() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    documentRoot.getAlloy().getRelation().getTuple().clear();
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void clearRepository() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    documentRoot.getAlloy().getRepository().getItem().clear();
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void clearSigs() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
      sigType.getAtom().clear();
    }
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static List<String> getAllReasonedAtoms() {
    List<String> result = new ArrayList<String>();
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<SigType> sigTypes = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigTypes) {
      final Iterator<AtomType> atomIter = sigType.getAtom().iterator();
      while (atomIter.hasNext()) {
        final AtomType atomType = atomIter.next();
        if (atomType.isReasoned()) {
          result.add(AlloyUtilities.getAtomNameById(atomType.getLabel()));
        }
      }
    }
    return result;
  }

  public static int findItemTypeInRepository(final IMarker marker) {
    final String markerId = MarkUtilities.getSourceId(marker);

    final EList<ItemType> itemTypes = AlloyUtilities.getItemtypes();

    int itemTypeIndex = 0;

    for (final ItemType itemType : itemTypes) {
      if (markerId.equals(itemType.getId())) {
        return itemTypeIndex;
      }
      itemTypeIndex++;
    }

    return -1;
  }

  public static IMarker findMarker(final String sigTypeName, final int index) {
    final SigType sigType =
        AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigTypeName));
    final EList<AtomType> atoms = sigType.getAtom();

    final String markerId = atoms.get(index).getLabel();

    final ItemType itemType = AlloyUtilities.getItemById(markerId);

    if (itemType == null) {
      return null;
    }

    final String path = AlloyUtilities.getValueOfEntry(itemType, AlloyUtilities.RESOURCE);

    if (path == null) {
      return null;
    }

    final IMarker marker = MarkUtilities.getiMarker(markerId, path);

    return marker;
  }

  public static ArrayList<String> getAllChildNames(final int id) {
    return (ArrayList<String>) AlloyUtilities.getAllChildIds(id).stream()
        .map(p -> AlloyUtilities.getSigNameById(p.intValue())).collect(Collectors.toList());
  }

  public static ArrayList<Integer> getAllChildIds(final int id) {
    final ArrayList<Integer> ids = new ArrayList<>();

    final ArrayList<SigType> sigTypes = AlloyUtilities.getSigTypeListByParentId(id);

    for (final SigType sigType : sigTypes) {
      ids.addAll(AlloyUtilities.getAllChildIds(sigType.getID()));
    }

    ids.add(id);

    return ids;
  }

  public static ArrayList<String> getAllParentNames(final int id) {
    return (ArrayList<String>) AlloyUtilities.getAllParentIds(id).stream()
        .map(p -> AlloyUtilities.getSigNameById(p.intValue())).collect(Collectors.toList());
  }

  public static ArrayList<Integer> getAllParentIds(int id) {
    final ArrayList<Integer> ids = new ArrayList<>();

    do {
      ids.add(id);
      final SigType sigType = AlloyUtilities.getSigTypeById(id);
      if (sigType.getType().size() == 0) {
        id = sigType.getParentID();
      } else {
        id = sigType.getType().get(0).getID();
      }
    } while (id != 0);

    return ids;
  }

  public static ArrayList<Integer> getAllParentIds(int id, final DocumentRoot documentRoot) {
    final ArrayList<Integer> ids = new ArrayList<>();

    do {
      ids.add(id);
      final SigType sigType = AlloyUtilities.getSigTypeById(id, documentRoot);
      if (sigType.getType().size() == 0) {
        id = sigType.getParentID();
      } else {
        id = sigType.getType().get(0).getID();
      }
    } while (id != 0);

    return ids;
  }

  public static SigType getAncestorOfSig(final int id) {
    SigType sigType = AlloyUtilities.getSigTypeById(id);
    while (sigType.getParentID() != 2) {
      sigType = AlloyUtilities.getSigTypeById(sigType.getParentID());
    }

    return sigType;
  }

  public static String getAtomNameById(final String id) {
    final EList<SigType> sigList = AlloyUtilities.getSigTypes(AlloyUtilities.getDocumentRoot());

    for (final SigType sigType : sigList) {
      final EList<AtomType> atoms = sigType.getAtom();
      int index = 0;
      final String sigLabel = sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);

      for (final AtomType atomType : atoms) {
        if (atomType.getLabel().equals(id)) {
          return sigLabel + "$" + index;
        }
        index++;
      }
    }
    return null;
  }

  public static AtomType getAtomTypeBySourceIdFromSig(final DocumentRoot documentRoot,
      final String sourceId) {
    final AlloyType alloyType = documentRoot.getAlloy();

    final EList<SigType> listOfSigs = alloyType.getInstance().getSig();
    for (final SigType sigType : listOfSigs) {
      final EList<AtomType> atoms = sigType.getAtom();
      for (final AtomType atomType : atoms) {
        if (atomType.getLabel().equals(sourceId)) {
          return atomType;
        }
      }
    }
    return null;
  }

  public static ArrayList<String> getChangedAtoms() {
    final EList<SigType> sigList = AlloyUtilities.getSigTypes(AlloyUtilities.getDocumentRoot());
    final ArrayList<String> changedAtoms = new ArrayList<>();

    for (final SigType sigType : sigList) {
      final EList<AtomType> atoms = sigType.getAtom();
      int index = 0;
      final String sigLabel = sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);

      for (final AtomType atomType : atoms) {
        if (atomType.getChanged() != null && atomType.getChanged()) {
          changedAtoms.add(sigLabel + "$" + index);
        }
        index++;
      }
    }
    return changedAtoms;
  }

  public static DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;
    try {
      list = modelIO.read(AlloyUtilities.getUri());
    } catch (final IOException e) {
      return null;
    }
    if (list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  public static DocumentRoot getDocumentRootForMetaModel(final String filename) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(AlloyUtilities.getLocationForMetamodel(filename)));
    } catch (final IOException e) {
      return null;
    }
    if (list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  public static FieldType getFieldTypeByName(final String label) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    for (final FieldType fieldType : documentRoot.getAlloy().getInstance().getField()) {
      if (fieldType.getLabel().equals(label)) {
        return fieldType;
      }
    }
    return null;
  }

  public static EList<FieldType> getFieldTypes() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    return documentRoot.getAlloy().getInstance().getField();
  }

  /**
   * @param typeName
   * @param side if true, return FieldType List according left side type
   * @return
   */
  public static ArrayList<FieldType> getFieldTypesList(final String typeName, final boolean side) {
    final EList<FieldType> fields = AlloyUtilities.getFieldTypes();
    final ArrayList<FieldType> foundFieldTypes = new ArrayList<>();

    final int id = AlloyUtilities.getSigTypeIdByName(typeName);

    final ArrayList<Integer> idList = AlloyUtilities.getAllParentIds(id);

    for (final Integer typeId : idList) {
      for (final FieldType fieldType : fields) {
        final EList<TypesType> typesTypes = fieldType.getTypes();
        for (final TypesType typesType : typesTypes) {
          final EList<TypeType> typeTypes = typesType.getType();
          if (side && typeTypes.get(0).getID() == typeId) {
            foundFieldTypes.add(fieldType);
            break;
          } else if (!side && typeTypes.get(1).getID() == typeId) {
            foundFieldTypes.add(fieldType);
            break;
          }
        }
      }
    }
    return foundFieldTypes;
  }

  public static ArrayList<ArrayList<String>> getImpactedAtoms() {
    final EList<FieldType> fieldList = AlloyUtilities.getFieldTypes();
    final ArrayList<ArrayList<String>> impactedAtoms = new ArrayList<>();

    for (final FieldType fieldType : fieldList) {
      final EList<TupleType> tupleList = fieldType.getTuple();

      for (final TupleType tupleType : tupleList) {
        if (tupleType.getAtom().get(1).getImpact() != null
            && tupleType.getAtom().get(1).getImpact()) {
          final AtomType atom = AlloyUtilities.getAtomTypeBySourceIdFromSig(
              AlloyUtilities.getDocumentRoot(), tupleType.getAtom().get(1).getLabel());
          final AtomType changedAtom = AlloyUtilities.getAtomTypeBySourceIdFromSig(
              AlloyUtilities.getDocumentRoot(), tupleType.getAtom().get(0).getLabel());
          final ArrayList<String> impactedRelations = new ArrayList<>();
          impactedRelations.add(AlloyUtilities.getAtomNameById(atom.getLabel()));
          impactedRelations.add(AlloyUtilities.getAtomNameById(changedAtom.getLabel()));
          impactedAtoms.add(impactedRelations);
        }
      }
    }
    return impactedAtoms;
  }

  public static ItemType getItemById(final String id) {
    final EList<ItemType> itemTypes = AlloyUtilities.getItemtypes();

    for (final ItemType itemType : itemTypes) {
      if (id.equals(itemType.getId())) {
        return itemType;
      }
    }

    return null;
  }

  public static EList<ItemType> getItemtypes() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    return documentRoot.getAlloy().getRepository().getItem();
  }

  public static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/"
        + AlloyUtilities.xmlFileLocation;
  }

  public static String getLocationForMetamodel(final String filename) {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation()
        + System.getProperty("file.separator") + ".modelwriter"
        + System.getProperty("file.separator") + filename + System.getProperty("file.separator")
        + ".xml";
  }

  public static String getOriginalModuleName() {
    final String filePath =
        AlloyUtilities.getDocumentRoot().getAlloy().getSource().get(0).getFilename();
    return filePath.substring(filePath.lastIndexOf(System.getProperty("file.separator")) + 1,
        filePath.lastIndexOf("."));
  }

  private static ArrayList<String> getReasonedAtoms() {
    final EList<SigType> sigList = AlloyUtilities.getSigTypes(AlloyUtilities.getDocumentRoot());
    final ArrayList<String> reasonedAtoms = new ArrayList<>();

    for (final SigType sigType : sigList) {
      final EList<AtomType> atoms = sigType.getAtom();
      int index = 0;
      final String sigLabel = sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);

      for (final AtomType atomType : atoms) {
        if (atomType.isReasoned()) {
          reasonedAtoms.add(sigLabel + "$" + index);
        }
        index++;
      }
    }
    return reasonedAtoms;

  }

  public static Map<IMarker, String> getRelationsOfFirstSideMarker(IMarker selectedMarker) {
    selectedMarker = MarkUtilities.getLeaderOfMarker(selectedMarker);

    final Map<IMarker, String> relationsOfMarker = new HashMap<>();
    if (MarkUtilities.getType(selectedMarker) == null) {
      return relationsOfMarker;
    }
    final ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        AlloyUtilities.getFieldTypesList(MarkUtilities.getType(selectedMarker), true);
    final String selectedMarkerId = MarkUtilities.getSourceId(selectedMarker);

    for (final FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      final EList<TupleType> tupleTypes = fieldType.getTuple();
      for (final TupleType tupleType : tupleTypes) {
        final EList<AtomType> atoms = tupleType.getAtom();
        final AtomType firstAtomType = atoms.get(0);
        if (firstAtomType.getLabel().equals(selectedMarkerId)) {
          final AtomType secondAtomType = atoms.get(1);
          final ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
          final IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
              AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
          relationsOfMarker.put(toMarker, fieldType.getLabel());
        }
      }
    }

    return relationsOfMarker;
  }


  public static String getAtomId(final String sigTypeName, final int index) {
    final SigType sigType =
        AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigTypeName));
    final EList<AtomType> atoms = sigType.getAtom();
    return atoms.get(index).getLabel();
  }

  public static Map<Object, String> getReasonedRelationsOfFSAtom(final String sigTypeName,
      final int index) {
    final String id = AlloyUtilities.getAtomId(sigTypeName, index);
    final Map<Object, String> relationsOfMarker = new HashMap<>();
    final ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        AlloyUtilities.getFieldTypesList(sigTypeName, true);

    for (final FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      final EList<TupleType> tupleTypes = fieldType.getTuple();
      for (final TupleType tupleType : tupleTypes) {
        final EList<AtomType> atoms = tupleType.getAtom();
        final AtomType firstAtomType = atoms.get(0);
        if (firstAtomType.getLabel().equals(id) && tupleType.isReasoned()) {
          final AtomType secondAtomType = atoms.get(1);
          final ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
          Object key = null;
          if (!secondAtomType.isReasoned()) {
            key = MarkUtilities.getiMarker(secondAtomType.getLabel(),
                AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
          } else
            key = AlloyUtilities.getAtomNameById(secondAtomType.getValue());
          relationsOfMarker.put(key, fieldType.getLabel());
        }
      }
    }
    return relationsOfMarker;
  }

  public static Map<Object, String> getReasonedRelationsOfSSAtom(final String sigTypeName,
      final int index) {
    final String id = AlloyUtilities.getAtomId(sigTypeName, index);

    final Map<Object, String> relationsOfMarker = new HashMap<>();
    final ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        AlloyUtilities.getFieldTypesList(sigTypeName, false);

    for (final FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      final EList<TupleType> tupleTypes = fieldType.getTuple();
      for (final TupleType tupleType : tupleTypes) {
        final EList<AtomType> atoms = tupleType.getAtom();
        final AtomType secondAtomType = atoms.get(1);
        if (secondAtomType.getLabel().equals(id) && tupleType.isReasoned()) {
          final AtomType firstAtomType = atoms.get(0);
          final ItemType itemTypeOfAtom = AlloyUtilities.getItemById(firstAtomType.getLabel());
          Object key = null;
          if (!firstAtomType.isReasoned()) {
            key = MarkUtilities.getiMarker(firstAtomType.getLabel(),
                AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
          } else
            key = AlloyUtilities.getAtomNameById(firstAtomType.getLabel());
          relationsOfMarker.put(key, fieldType.getLabel());
        }
      }
    }
    return relationsOfMarker;
  }

  public static Map<IMarker, String> getRelationsOfSecondSideMarker(IMarker selectedMarker) {
    selectedMarker = MarkUtilities.getLeaderOfMarker(selectedMarker);

    final Map<IMarker, String> relationsOfMarker = new HashMap<>();
    if (MarkUtilities.getType(selectedMarker) == null) {
      return relationsOfMarker;
    }
    final ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        AlloyUtilities.getFieldTypesList(MarkUtilities.getType(selectedMarker), false);
    final String selectedMarkerId = MarkUtilities.getSourceId(selectedMarker);

    for (final FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      final EList<TupleType> tupleTypes = fieldType.getTuple();
      for (final TupleType tupleType : tupleTypes) {
        final EList<AtomType> atoms = tupleType.getAtom();
        final AtomType firstAtomType = atoms.get(1);
        if (firstAtomType.getLabel().equals(selectedMarkerId)) {
          final AtomType secondAtomType = atoms.get(0);
          final ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
          final IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
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
  public static RelationType getRelationType(final DocumentRoot documentRoot) {
    return documentRoot.getAlloy().getRelation();
  }

  public static ArrayList<String> getRelationTypesForFirstSide(final String typeName) {
    final ArrayList<String> relationTypeNames = new ArrayList<>();

    final int typeId = AlloyUtilities.getSigTypeIdByName(typeName);

    if (typeId == -1) {
      return null;
    }

    final ArrayList<Integer> parentIds = AlloyUtilities.getAllParentIds(typeId);

    final EList<FieldType> fieldTypes = AlloyUtilities.getFieldTypes();

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

  public static ArrayList<AtomType> getSecondSideAtomsBySourceIdOfFirstSide(
      final DocumentRoot documentRoot, final String sourceId) {
    final AlloyType alloyType = documentRoot.getAlloy();
    final ArrayList<AtomType> atoms = new ArrayList<>();

    final EList<FieldType> listOfField = alloyType.getInstance().getField();
    for (final FieldType fieldType : listOfField) {
      final EList<TupleType> tuples = fieldType.getTuple();
      for (final TupleType tupleType : tuples) {
        if (tupleType.getAtom().get(0).getLabel().equals(sourceId)) {
          atoms.add(tupleType.getAtom().get(1));
        }
      }
    }
    return atoms;
  }

  public static ArrayList<IMarker> getSecondSideMarkerIdsByMarkerAndRelation(IMarker marker,
      final String relation) {
    marker = MarkUtilities.getLeaderOfMarker(marker);

    final EList<FieldType> fieldTypes = AlloyUtilities.getFieldTypes();

    final String markerId = MarkUtilities.getSourceId(marker);

    final ArrayList<IMarker> suitableMarkers = new ArrayList<>();

    for (final FieldType fieldType : fieldTypes) {
      if (fieldType.getLabel().equals(relation)) {
        final EList<TupleType> tuples = fieldType.getTuple();
        for (final TupleType tupleType : tuples) {
          final EList<AtomType> atoms = tupleType.getAtom();
          if (atoms.get(0).getLabel().equals(markerId)) {
            final ItemType itemType = AlloyUtilities.getItemById(atoms.get(1).getLabel());
            final IMarker suitableMarker = MarkUtilities.getiMarker(itemType.getId(),
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
    iMarker = MarkUtilities.getLeaderOfMarker(iMarker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final RelationType relationType = AlloyUtilities.getRelationType(documentRoot);
    final EList<TupleType> tupleTypes = relationType.getTuple();

    final String markerId = MarkUtilities.getSourceId(iMarker);

    final ArrayList<IMarker> suitableMarkers = new ArrayList<>();

    for (final TupleType tupleType : tupleTypes) {
      final EList<AtomType> atoms = tupleType.getAtom();
      if (atoms.get(0).getLabel().equals(markerId)) {
        final ItemType itemType = AlloyUtilities.getItemById(atoms.get(1).getLabel());
        final IMarker suitableMarker = MarkUtilities.getiMarker(itemType.getId(),
            AlloyUtilities.getValueOfEntry(itemType, AlloyUtilities.RESOURCE));
        suitableMarkers.add(suitableMarker);
      }
    }

    return suitableMarkers;
  }

  public static String getSigNameById(final int id) {
    final SigType sigType = AlloyUtilities.getSigTypeById(id);
    return sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);
  }

  public static String getSigNameById(final int id, final DocumentRoot documentRoot) {
    final SigType sigType = AlloyUtilities.getSigTypeById(id, documentRoot);
    return sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);
  }

  public static SigType getSigTypeById(final int id) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<SigType> sigTypes = AlloyUtilities.getSigTypes(documentRoot);

    for (final SigType sigType : sigTypes) {
      if (id == sigType.getID()) {
        return sigType;
      }
    }
    return null;
  }

  public static SigType getSigTypeById(final int id, final DocumentRoot documentRoot) {
    final EList<SigType> sigTypes = AlloyUtilities.getSigTypes(documentRoot);

    for (final SigType sigType : sigTypes) {
      if (id == sigType.getID()) {
        return sigType;
      }
    }
    return null;
  }

  public static int getSigTypeIdByName(final String typeName) {
    int id = -1;
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<SigType> sigTypes = AlloyUtilities.getSigTypes(documentRoot);

    for (final SigType sigType : sigTypes) {
      if (typeName.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        id = sigType.getID();
        break;
      }
    }
    return id;
  }

  public static int getSigTypeIdByName(final String typeName, final DocumentRoot documentRoot) {
    int id = -1;
    final EList<SigType> sigTypes = AlloyUtilities.getSigTypes(documentRoot);

    for (final SigType sigType : sigTypes) {
      if (typeName.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))) {
        id = sigType.getID();
        break;
      }
    }
    return id;
  }

  public static ArrayList<SigType> getSigTypeListByParentId(final int id) {
    final ArrayList<SigType> suitableSigTypes = new ArrayList<>();

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<SigType> sigTypes = AlloyUtilities.getSigTypes(documentRoot);

    for (final SigType sigType : sigTypes) {
      if (sigType.getParentID() == id) {
        suitableSigTypes.add(sigType);
      }
    }

    return suitableSigTypes;
  }

  public static EList<SigType> getSigTypes(final DocumentRoot documentRoot) {
    return documentRoot.getAlloy().getInstance().getSig();
  }

  /**
   * This method is used to get source marker list of iMarker. Also iMarker doesn't contain any
   * marker type.
   *
   * @param iMarker
   * @return
   */
  public static ArrayList<IMarker> getSourcesOfMarkerAtRelations(IMarker iMarker) {
    iMarker = MarkUtilities.getLeaderOfMarker(iMarker);

    final ArrayList<IMarker> sources = new ArrayList<>();
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final RelationType relationType = AlloyUtilities.getRelationType(documentRoot);
    final String selectedMarkerId = MarkUtilities.getSourceId(iMarker);

    final EList<TupleType> tupleTypes = relationType.getTuple();
    for (final TupleType tupleType : tupleTypes) {
      final EList<AtomType> atoms = tupleType.getAtom();
      final AtomType firstAtomType = atoms.get(0);
      final AtomType secondAtomType = atoms.get(1);
      if (secondAtomType.getLabel().equals(selectedMarkerId)) {
        final ItemType itemTypeOfAtom = AlloyUtilities.getItemById(firstAtomType.getLabel());
        final IMarker toMarker = MarkUtilities.getiMarker(firstAtomType.getLabel(),
            AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
        sources.add(toMarker);
      }
    }
    return sources;
  }

  public static ArrayList<String> getSuitableSecondSideTypesOfRelation(final String relationName,
      final String firstSideType) {
    final EList<FieldType> fields = AlloyUtilities.getFieldTypes();

    final ArrayList<String> suitableRelationNames = new ArrayList<>();

    final int firstSideTypeId = AlloyUtilities.getSigTypeIdByName(firstSideType);
    final ArrayList<Integer> parentIdsOfFirstSideType =
        AlloyUtilities.getAllParentIds(firstSideTypeId);

    final ArrayList<Integer> secondSideTypeIds = new ArrayList<>();
    for (final FieldType fieldType : fields) {
      if (fieldType.getLabel().equals(relationName) && parentIdsOfFirstSideType
          .contains(fieldType.getTypes().get(0).getType().get(0).getID())) {
        secondSideTypeIds.add(fieldType.getTypes().get(0).getType().get(1).getID());
      }
    }

    final ArrayList<Integer> suitableIds = new ArrayList<>();
    for (final Integer secondSideTypeId : secondSideTypeIds) {
      suitableIds.addAll(AlloyUtilities.getAllChildIds(secondSideTypeId));
    }

    for (final Integer suitableId : suitableIds) {
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
    iMarker = MarkUtilities.getLeaderOfMarker(iMarker);

    final Map<IMarker, String> sourcesMap = AlloyUtilities.getRelationsOfSecondSideMarker(iMarker);
    final ArrayList<IMarker> sourcesList = AlloyUtilities.getSourcesOfMarkerAtRelations(iMarker);

    final ArrayList<IMarker> resultList = new ArrayList<>(sourcesList);

    final Set<IMarker> sourceMarkers = sourcesMap.keySet();
    final Iterator<IMarker> iter = sourceMarkers.iterator();
    while (iter.hasNext()) {
      final IMarker iMarkerSet = iter.next();
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
  public static ArrayList<IMarker> getTargetsOfMarkerAtRelations(IMarker iMarker) {
    iMarker = MarkUtilities.getLeaderOfMarker(iMarker);

    final ArrayList<IMarker> targets = new ArrayList<>();
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final RelationType relationType = AlloyUtilities.getRelationType(documentRoot);
    final String selectedMarkerId = MarkUtilities.getSourceId(iMarker);

    final EList<TupleType> tupleTypes = relationType.getTuple();
    for (final TupleType tupleType : tupleTypes) {
      final EList<AtomType> atoms = tupleType.getAtom();
      final AtomType firstAtomType = atoms.get(0);
      if (firstAtomType.getLabel().equals(selectedMarkerId)) {
        final AtomType secondAtomType = atoms.get(1);
        final ItemType itemTypeOfAtom = AlloyUtilities.getItemById(secondAtomType.getLabel());
        final IMarker toMarker = MarkUtilities.getiMarker(secondAtomType.getLabel(),
            AlloyUtilities.getValueOfEntry(itemTypeOfAtom, AlloyUtilities.RESOURCE));
        targets.add(toMarker);
      }
    }

    return targets;
  }

  public static URI getUri() {
    return URI.createFileURI(AlloyUtilities.getLocation());
  }

  public static String getValueOfEntry(final ItemType itemType, final String key) {
    String value = null;
    final EList<EntryType> entries = itemType.getEntry();

    for (final EntryType entryType : entries) {
      if (key.equals(entryType.getKey())) {
        value = entryType.getValue();
        break;
      }
    }
    return value;
  }

  public static boolean isAnyReasoned() {

    for (final FieldType fieldType : AlloyUtilities.getFieldTypes()) {
      for (final TupleType tupleType : fieldType.getTuple()) {
        if (tupleType.isReasoned()) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean isContainTuple(final FieldType fieldType,
      final TupleType searchedTupleType) {
    final EList<TupleType> tuples = fieldType.getTuple();
    final EList<AtomType> searchedAtoms = searchedTupleType.getAtom();
    for (final TupleType tupleType : tuples) {
      final EList<AtomType> atoms = tupleType.getAtom();
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
    final Path path = new Path(AlloyUtilities.getLocation());
    return path.toFile().exists() ? true : false;
  }

  public static int isTypeInSig(final String sigTypeName) {

    final SigType sigType =
        AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigTypeName));

    return sigType.getType().isEmpty() ? -1 : sigType.getType().get(0).getID();
  }

  public static void removeAllRelationsOfMarker(IMarker marker) {
    marker = MarkUtilities.getLeaderOfMarker(marker);

    if (marker != null) {
      Iterator<Entry<IMarker, String>> iter;
      final Map<IMarker, String> relationsOfFirstSide =
          AlloyUtilities.getRelationsOfFirstSideMarker(marker);
      iter = relationsOfFirstSide.entrySet().iterator();

      while (iter.hasNext()) {
        @SuppressWarnings("rawtypes")
        final Map.Entry pair = iter.next();
        AlloyUtilities.removeFieldOfMarkers(marker, (IMarker) pair.getKey(),
            (String) pair.getValue());
      }

      final Map<IMarker, String> relationsOfSecondSide =
          AlloyUtilities.getRelationsOfSecondSideMarker(marker);
      iter = relationsOfSecondSide.entrySet().iterator();

      while (iter.hasNext()) {
        @SuppressWarnings("rawtypes")
        final Map.Entry pair = iter.next();
        AlloyUtilities.removeFieldOfMarkers((IMarker) pair.getKey(), marker,
            (String) pair.getValue());
      }
    }
  }

  public static void removeFieldOfMarkers(IMarker fromMarker, IMarker toMarker,
      final String relationName) {
    fromMarker = MarkUtilities.getLeaderOfMarker(fromMarker);
    toMarker = MarkUtilities.getLeaderOfMarker(toMarker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();

    final String fromMarkerId = MarkUtilities.getSourceId(fromMarker);
    final String toMarkerId = MarkUtilities.getSourceId(toMarker);

    for (final FieldType fieldType : fieldTypes) {
      if (fieldType.getLabel().equals(relationName)) {
        final Iterator<TupleType> tupleTypesIter = fieldType.getTuple().iterator();
        while (tupleTypesIter.hasNext()) {
          final EList<AtomType> atoms = tupleTypesIter.next().getAtom();
          if (atoms.get(0).getLabel().equals(fromMarkerId)
              && atoms.get(1).getLabel().equals(toMarkerId)) {
            tupleTypesIter.remove();
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
    fromMarker = MarkUtilities.getLeaderOfMarker(fromMarker);
    toMarker = MarkUtilities.getLeaderOfMarker(toMarker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final RelationType relationType = AlloyUtilities.getRelationType(documentRoot);

    final String fromMarkerId = MarkUtilities.getSourceId(fromMarker);
    final String toMarkerId = MarkUtilities.getSourceId(toMarker);

    final Iterator<TupleType> iter = relationType.getTuple().iterator();
    while (iter.hasNext()) {
      final EList<AtomType> atoms = iter.next().getAtom();
      if (atoms.get(0).getLabel().equals(fromMarkerId)
          && atoms.get(1).getLabel().equals(toMarkerId)) {
        iter.remove();
        AlloyUtilities.writeDocumentRoot(documentRoot);
        return;
      }
    }
  }

  public static void removeMarkerFromRepository(final IMarker marker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final int itemTypeIndex = AlloyUtilities.findItemTypeInRepository(marker);
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
    marker = MarkUtilities.getLeaderOfMarker(marker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final String id = MarkUtilities.getSourceId(marker);
    final EList<TupleType> tupleTypes = AlloyUtilities.getRelationType(documentRoot).getTuple();
    final Iterator<TupleType> iter = tupleTypes.iterator();
    while (iter.hasNext()) {
      final TupleType tupleType = iter.next();
      final AtomType firstSideAtom = tupleType.getAtom().get(0);
      final AtomType secondSideAtom = tupleType.getAtom().get(1);
      if (firstSideAtom.getLabel().equals(id) || secondSideAtom.getLabel().equals(id)) {
        iter.remove();
      }
    }
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void removeTypeFromMarker(final IMarker marker) {
    if (MarkUtilities.compare(marker, MarkUtilities.getLeaderOfMarker(marker))) {
      AlloyUtilities.removeAllRelationsOfMarker(marker);
    }

    if (MarkUtilities.getType(marker) == null || MarkUtilities.getType(marker).isEmpty()) {
      return;
    }

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final String type = MarkUtilities.getType(marker);

    final String markerId = MarkUtilities.getSourceId(marker);

    final int idOfTypeSigInSigType = AlloyUtilities.isTypeInSig(type);

    final EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (final SigType sigType : sigs) {
      if (type.equals(sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1))
          || idOfTypeSigInSigType != -1 && sigType.getID() == idOfTypeSigInSigType) {
        final Iterator<AtomType> atomsIter = sigType.getAtom().iterator();
        while (atomsIter.hasNext()) {
          final AtomType atomType = atomsIter.next();
          if (atomType.getLabel().equals(markerId)) {
            atomsIter.remove();
            break;
          }
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void resetReasoned(IMarker fromMarker, IMarker toMarker,
      final String relationName) {
    fromMarker = MarkUtilities.getLeaderOfMarker(fromMarker);
    toMarker = MarkUtilities.getLeaderOfMarker(toMarker);

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();

    final String fromMarkerId = MarkUtilities.getSourceId(fromMarker);
    final String toMarkerId = MarkUtilities.getSourceId(toMarker);

    for (final FieldType fieldType : fieldTypes) {
      if (fieldType.getLabel().equals(relationName)) {
        final Iterator<TupleType> tupleTypesIter = fieldType.getTuple().iterator();
        while (tupleTypesIter.hasNext()) {
          final TupleType tupleType = tupleTypesIter.next();
          final EList<AtomType> atoms = tupleType.getAtom();
          if (atoms.get(0).getLabel().equals(fromMarkerId)
              && atoms.get(1).getLabel().equals(toMarkerId)) {
            tupleType.setReasoned(false);
            AlloyUtilities.writeDocumentRoot(documentRoot);
            return;
          }
        }
      }
    }
  }

  public static void setAllImpactsAndChanges(final AlloyInstance instance) {
    final Iterator<AlloyAtom> iter = instance.atom2sets.keySet().iterator();

    final ArrayList<String> changedAtoms = AlloyUtilities.getChangedAtoms();
    final ArrayList<ArrayList<String>> impactedAtoms = AlloyUtilities.getImpactedAtoms();
    while (iter.hasNext()) {
      final AlloyAtom alloyAtom = iter.next();
      final String alloyAtomName = alloyAtom.getOriginalName();
      if (changedAtoms.contains(alloyAtomName)) {
        alloyAtom.changed = true;
      }
      for (final ArrayList<String> impactedAtom : impactedAtoms) {
        if (impactedAtom.get(0).equals(alloyAtomName)) {
          alloyAtom.impacted.add(impactedAtom.get(1));
        }
      }
    }
  }

  public static void setAllReasonedAtoms(final AlloyInstance instance) {
    final Iterator<AlloyAtom> iter = instance.atom2sets.keySet().iterator();

    final ArrayList<String> reasonedAtoms = AlloyUtilities.getReasonedAtoms();
    while (iter.hasNext()) {
      final AlloyAtom alloyAtom = iter.next();
      final String alloyAtomName = alloyAtom.getOriginalName();
      if (reasonedAtoms.contains(alloyAtomName)) {
        alloyAtom.isDashed = true;
      }
    }
  }

  public static void setAllReasonedTuples(final AlloyInstance instance) {
    final EList<FieldType> fieldList = AlloyUtilities.getFieldTypes();
    final Map<TupleType, FieldType> reasonedTuplesInFields = new HashMap<>();

    for (final FieldType fieldType : fieldList) {
      final EList<TupleType> tuples = fieldType.getTuple();
      for (final TupleType tupleType : tuples) {
        if (tupleType.isReasoned()) {
          reasonedTuplesInFields.put(tupleType, fieldType);
        }
      }
    }

    for (final Entry<TupleType, FieldType> reasonedEntry : reasonedTuplesInFields.entrySet()) {
      final TupleType tupleType = reasonedEntry.getKey();
      final FieldType fieldType = reasonedEntry.getValue();
      for (final Entry<AlloyRelation, Set<AlloyTuple>> entry : instance.rel2tuples.entrySet()) {
        if (entry.getKey().getName().equals(fieldType.getLabel())) {
          final Iterator<AlloyTuple> tupleSetIter = entry.getValue().iterator();
          while (tupleSetIter.hasNext()) {
            final AlloyTuple alloyTuple = tupleSetIter.next();
            boolean tuplesREqual = true;
            for (int i = 0; i < tupleType.getAtom().size(); i++) {
              if (!AlloyUtilities.getAtomNameById(tupleType.getAtom().get(i).getLabel())
                  .equals(alloyTuple.getAtoms().get(i).getOriginalName())) {
                tuplesREqual = false;
                break;
              }
            }
            if (tuplesREqual) {
              alloyTuple.isDashed = true;
            }
          }
        }
      }
    }
  }

  private static void setEntries(final ItemType itemType, final IMarker marker) {
    if (MarkUtilities.getPath(marker) != null) {
      final EntryType resourceEntry = persistenceFactory.eINSTANCE.createEntryType();
      resourceEntry.setKey(AlloyUtilities.RESOURCE);
      resourceEntry.setValue(MarkUtilities.getPath(marker));
      itemType.getEntry().add(resourceEntry);
    }
    if (MarkUtilities.getStart(marker) != -1) {
      final EntryType offsetEntry = persistenceFactory.eINSTANCE.createEntryType();
      offsetEntry.setKey(AlloyUtilities.OFFSET);
      offsetEntry.setValue(Integer.toString(MarkUtilities.getStart(marker)));
      itemType.getEntry().add(offsetEntry);
    }
    if (MarkUtilities.getText(marker) != null) {
      final EntryType textEntry = persistenceFactory.eINSTANCE.createEntryType();
      textEntry.setKey(AlloyUtilities.TEXT);
      textEntry.setValue(MarkUtilities.getText(marker));
      itemType.getEntry().add(textEntry);
    }
    if (MarkUtilities.getUri(marker) != null) {
      final EntryType uriEntry = persistenceFactory.eINSTANCE.createEntryType();
      uriEntry.setKey(AlloyUtilities.MARKER_URI);
      uriEntry.setValue(MarkUtilities.getUri(marker));
      itemType.getEntry().add(uriEntry);
    }
    if (MarkUtilities.getLeaderId(marker) != null) {
      final EntryType leaderIdEntry = persistenceFactory.eINSTANCE.createEntryType();
      leaderIdEntry.setKey(AlloyUtilities.LEADER_ID);
      leaderIdEntry.setValue(MarkUtilities.getLeaderId(marker));
      itemType.getEntry().add(leaderIdEntry);
    }
    if (MarkUtilities.getGroupId(marker) != null) {
      final EntryType groupIdEntry = persistenceFactory.eINSTANCE.createEntryType();
      groupIdEntry.setKey(AlloyUtilities.GROUP_ID);
      groupIdEntry.setValue(MarkUtilities.getGroupId(marker));
      itemType.getEntry().add(groupIdEntry);
    }
  }

  public static void setImpactAndChanged(final IMarker marker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final AlloyType alloyType = documentRoot.getAlloy();

    if (MarkUtilities.getType(marker) != null) {
      final EList<SigType> listOfSigs = alloyType.getInstance().getSig();
      for (final SigType sigType : listOfSigs) {
        final EList<AtomType> atoms = sigType.getAtom();
        for (final AtomType atomType : atoms) {
          if (atomType.getLabel().equals(MarkUtilities.getSourceId(marker))) {
            atomType.setChanged(true);
          }
        }
      }
      final EList<FieldType> listOfField = alloyType.getInstance().getField();
      for (final FieldType fieldType : listOfField) {
        final EList<TupleType> tuples = fieldType.getTuple();
        for (final TupleType tupleType : tuples) {
          if (tupleType.getAtom().get(0).getLabel().equals(MarkUtilities.getSourceId(marker))) {
            tupleType.getAtom().get(1).setImpact(true);
          }
        }
      }
      AlloyUtilities.writeDocumentRoot(documentRoot);
    }
  }

  public static void setMetamodel(final String filename, final boolean state) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRootForMetaModel(filename);
    if (state == true) {
      documentRoot.getAlloy().getInstance().setMetamodel("yes");
    } else {
      documentRoot.getAlloy().getInstance().setMetamodel(null);
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

  }

  public static void unsetChanged(final IMarker fromMarker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final String sourceIdOfFromMarker = MarkUtilities.getSourceId(fromMarker);
    final AtomType atom =
        AlloyUtilities.getAtomTypeBySourceIdFromSig(documentRoot, sourceIdOfFromMarker);
    atom.setChanged(null);
    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void unsetChangedAndAllImpacted(final IMarker changedMarker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final String sourceIdOfChangedMarker = MarkUtilities.getSourceId(changedMarker);

    final AtomType atom =
        AlloyUtilities.getAtomTypeBySourceIdFromSig(documentRoot, sourceIdOfChangedMarker);
    final ArrayList<AtomType> secondSideAtoms = AlloyUtilities
        .getSecondSideAtomsBySourceIdOfFirstSide(documentRoot, sourceIdOfChangedMarker);

    for (final AtomType atomType : secondSideAtoms) {
      if (atomType.getImpact() != null && atomType.getImpact()) {
        atomType.setImpact(null);
      }
    }

    atom.setChanged(null);

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public static void unsetImpactAndChanged(final IMarker fromMarker, final IMarker toMarker) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final String sourceIdOfFromMarker = MarkUtilities.getSourceId(fromMarker);
    final String sourceIdOfToMarker = MarkUtilities.getSourceId(toMarker);

    final AtomType atom =
        AlloyUtilities.getAtomTypeBySourceIdFromSig(documentRoot, sourceIdOfFromMarker);
    final ArrayList<AtomType> secondSideAtoms =
        AlloyUtilities.getSecondSideAtomsBySourceIdOfFirstSide(documentRoot, sourceIdOfFromMarker);

    int impactCount = 0;
    for (final AtomType atomType : secondSideAtoms) {
      if (atomType.getImpact() != null) {
        impactCount++;
        if (atomType.getLabel().equals(sourceIdOfToMarker)) {
          atomType.setImpact(null);
        }
      }
    }
    if (impactCount == 1) {
      atom.setChanged(null);
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  /**
   * This method doesn't change the sig and relation definitions, also doesn't change actual atoms
   * status.
   *
   * @param file
   * @param content
   */
  public static void updateSpec(final String file, final String content) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final EList<SourceType> sources = documentRoot.getAlloy().getSource();
    for (final SourceType sourceType : sources) {
      if (sourceType.getFilename().equals(file)) {
        sourceType.setContent(content);
        AlloyUtilities.writeDocumentRoot(documentRoot);
        return;
      }
    }
  }

  @SuppressWarnings("unchecked")
  public static void writeDocumentRoot(final DocumentRoot documentRoot) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    modelIO.write(AlloyUtilities.getUri(), documentRoot);
  }

  @SuppressWarnings("unchecked")
  public static void writeDocumentRootForMetamodel(final DocumentRoot documentRoot,
      final String filename) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    modelIO.write(URI.createFileURI(AlloyUtilities.getLocationForMetamodel(filename)),
        documentRoot);
  }

  public static AtomType cloneAtomType(final AtomType atomType) {
    final AtomType clone = persistenceFactory.eINSTANCE.createAtomType();
    clone.setBound(atomType.getBound());
    clone.setChanged(atomType.getChanged());
    clone.setImpact(atomType.getImpact());
    clone.setLabel(atomType.getLabel());
    clone.setReasoned(atomType.isReasoned());
    clone.setValue(atomType.getValue());
    return clone;
  }

  public static String getSigNameByAtomId(final String atomId, final DocumentRoot documentRoot) {
    for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
      for (final AtomType atomType : sigType.getAtom()) {
        if (atomType.getLabel().equals(atomId)) {
          return sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);
        }
      }
    }
    return null;
  }
}
