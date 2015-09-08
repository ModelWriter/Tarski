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
package eu.modelwriter.marker.typing.internal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class AlloyUtilities {

  final public static String RESOURCE = "resource";
  final public static String TEXT = "text";
  final public static String OFFSET = "offset";
  final public static String MARKER_URI = "uri";
  final public static String GROUP_ID = "groupId";
  final public static String LEADER_ID = "leaderId";

  public static String xmlFileLocation = "alloyXml.xml";
  public static ResourceSet resourceSet;
  public static Map<String, Integer> typeHashMap = new HashMap<String, Integer>();

  public static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + xmlFileLocation;
  }

  public static URI getUri() {
    return URI.createFileURI(getLocation());
  }

  public static DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = modelIO.read(getUri());
    if (list.isEmpty())
      return null;
    DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  @SuppressWarnings("unchecked")
  public static void writeDocumentRoot(DocumentRoot documentRoot) {
    @SuppressWarnings("rawtypes")
    ModelIO modelIO = new ModelIO<>();
    modelIO.write(getUri(), documentRoot);
  }

  public static void addMarkerToRepository(IMarker marker) {
    DocumentRoot documentRoot = getDocumentRoot();

    ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    documentRoot.getAlloy().getRepository().getItem().add(itemType);
    itemType.setId(MarkElementUtilities.getSourceId(marker));

    setEntries(itemType, marker);

    writeDocumentRoot(documentRoot);
  }


  public static void addTypeToMarker(IMarker marker) {
    DocumentRoot documentRoot = getDocumentRoot();

    AtomType atom = persistenceFactory.eINSTANCE.createAtomType();

    atom.setLabel(MarkElementUtilities.getSourceId(marker));

    String type = "this/" + MarkElementUtilities.getType(marker);

    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      if (type.equals(sigType.getLabel())) {
        sigType.getAtom().add(atom);
        break;
      }
    }

    if (findItemTypeInRepository(marker) == -1) {
      ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
      documentRoot.getAlloy().getRepository().getItem().add(itemType);
      itemType.setId(MarkElementUtilities.getSourceId(marker));

      setEntries(itemType, marker);
    }

    writeDocumentRoot(documentRoot);
  }

  private static void setEntries(ItemType itemType, IMarker marker) {
    if (MarkElementUtilities.getPath(marker) != null) {
      EntryType resourceEntry = persistenceFactory.eINSTANCE.createEntryType();
      resourceEntry.setKey(RESOURCE);
      resourceEntry.setValue(MarkElementUtilities.getPath(marker));
      itemType.getEntry().add(resourceEntry);
    }
    if (MarkElementUtilities.getStart(marker) != -1) {
      EntryType offsetEntry = persistenceFactory.eINSTANCE.createEntryType();
      offsetEntry.setKey(OFFSET);
      offsetEntry.setValue(Integer.toString(MarkElementUtilities.getStart(marker)));
      itemType.getEntry().add(offsetEntry);
    }
    if (MarkElementUtilities.getText(marker) != null) {
      EntryType textEntry = persistenceFactory.eINSTANCE.createEntryType();
      textEntry.setKey(TEXT);
      textEntry.setValue(MarkElementUtilities.getText(marker));
      itemType.getEntry().add(textEntry);
    }
    if (MarkElementUtilities.getUri(marker) != null) {
      EntryType uriEntry = persistenceFactory.eINSTANCE.createEntryType();
      uriEntry.setKey(MARKER_URI);
      uriEntry.setValue(MarkElementUtilities.getUri(marker));
      itemType.getEntry().add(uriEntry);
    }
    if (MarkElementUtilities.getLeaderId(marker) != null) {
      EntryType leaderIdEntry = persistenceFactory.eINSTANCE.createEntryType();
      leaderIdEntry.setKey(LEADER_ID);
      leaderIdEntry.setValue(MarkElementUtilities.getLeaderId(marker));
      itemType.getEntry().add(leaderIdEntry);
    }
    if (MarkElementUtilities.getGroupId(marker) != null) {
      EntryType groupIdEntry = persistenceFactory.eINSTANCE.createEntryType();
      groupIdEntry.setKey(GROUP_ID);
      groupIdEntry.setValue(MarkElementUtilities.getGroupId(marker));
      itemType.getEntry().add(groupIdEntry);
    }
  }

  public static void removeTypeFromMarker(IMarker marker) {
    if (MarkElementUtilities.getType(marker) == null
        || MarkElementUtilities.getType(marker).isEmpty())
      return;

    DocumentRoot documentRoot = getDocumentRoot();

    String type = "this/" + MarkElementUtilities.getType(marker);

    String markerId = MarkElementUtilities.getSourceId(marker);

    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      if (type.equals(sigType.getLabel())) {
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

    writeDocumentRoot(documentRoot);
  }

  public static void removeMarker(IMarker marker) {
    removeAllRelationsOfMarker(marker);

    removeTypeFromMarker(marker);

    DocumentRoot documentRoot = getDocumentRoot();

    int itemTypeIndex = findItemTypeInRepository(marker);
    if (itemTypeIndex == -1)
      return;
    documentRoot.getAlloy().getRepository().getItem().remove(itemTypeIndex);

    writeDocumentRoot(documentRoot);
  }

  public static void removeAllRelationsOfMarker(IMarker marker) {
    Iterator<Entry<IMarker, String>> iter;
    Map<IMarker, String> relationsOfFirstSide = getRelationsOfFirstSideMarker(marker);
    iter = relationsOfFirstSide.entrySet().iterator();

    while (iter.hasNext()) {
      Map.Entry pair = (Map.Entry) iter.next();
      AlloyUtilities.removeRelationOfMarkers(marker, (IMarker) pair.getKey(),
          (String) pair.getValue());
    }

    Map<IMarker, String> relationsOfSecondSide = getRelationsOfSecondSideMarker(marker);
    iter = relationsOfSecondSide.entrySet().iterator();

    while (iter.hasNext()) {
      Map.Entry pair = (Map.Entry) iter.next();
      AlloyUtilities.removeRelationOfMarkers((IMarker) pair.getKey(), marker,
          (String) pair.getValue());
    }
  }

  public static void addRelation2Markers(IMarker fromMarker, IMarker toMarker, String relation) {
    DocumentRoot documentRoot = getDocumentRoot();

    AtomType fromAtom = persistenceFactory.eINSTANCE.createAtomType();
    fromAtom.setLabel(MarkElementUtilities.getSourceId(fromMarker));

    AtomType toAtom = persistenceFactory.eINSTANCE.createAtomType();
    toAtom.setLabel(MarkElementUtilities.getSourceId(toMarker));

    TupleType tuple = persistenceFactory.eINSTANCE.createTupleType();
    tuple.getAtom().add(fromAtom);
    tuple.getAtom().add(toAtom);

    EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (FieldType fieldType : fields) {
      if (relation.equals(fieldType.getLabel())) {
        if (!isContainTuple(fieldType, tuple))
          fieldType.getTuple().add(tuple);
        break;
      }
    }

    writeDocumentRoot(documentRoot);
  }

  public static void addRelation2Markers(IMarker selectedMarker, Object[] checkedMarkers,
      Map<IMarker, String> relationMap) {

    for (Object object : checkedMarkers) {
      if (object instanceof IMarker) {
        IMarker marker = (IMarker) object;
        String relationName = relationMap.get(marker);
        addRelation2Markers(selectedMarker, marker, relationName);
      }
    }
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

  public static int findItemTypeInRepository(IMarker marker) {
    String markerId = MarkElementUtilities.getSourceId(marker);

    DocumentRoot documentRoot = getDocumentRoot();

    EList<ItemType> itemTypes = documentRoot.getAlloy().getRepository().getItem();

    int itemTypeIndex = 0;

    for (ItemType itemType : itemTypes) {
      if (markerId.equals(itemType.getId()))
        return itemTypeIndex;
      itemTypeIndex++;
    }

    return -1;
  }

  public static int getTypeIdByName(String typeName) {
    typeName = "this/" + typeName;
    int id = -1;

    if (typeHashMap.get(typeName) == null) {
      DocumentRoot documentRoot = getDocumentRoot();
      EList<SigType> sigTypes = documentRoot.getAlloy().getInstance().getSig();

      for (SigType sigType : sigTypes) {
        if (sigType.getLabel().equals(typeName)) {
          id = sigType.getID();
          typeHashMap.put(typeName, id);
          break;
        }
      }
    } else {
      id = typeHashMap.get(typeName);
    }
    return id;
  }

  /**
   * @param typeName
   * @param side if true, return FieldType List according left side type
   * @return
   */
  public static ArrayList<FieldType> getFieldTypesList(String typeName, boolean side) {
    DocumentRoot documentRoot = getDocumentRoot();
    EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();
    ArrayList<FieldType> foundFieldTypes = new ArrayList<FieldType>();

    int id = getTypeIdByName(typeName);

    for (FieldType fieldType : fields) {
      EList<TypesType> typesTypes = fieldType.getTypes();
      for (TypesType typesType : typesTypes) {
        EList<TypeType> typeTypes = typesType.getType();
        if (side && typeTypes.get(0).getID() == id) {
          foundFieldTypes.add(fieldType);
          break;
        } else if (!side && typeTypes.get(1).getID() == id) {
          foundFieldTypes.add(fieldType);
          break;
        }
      }
    }

    return foundFieldTypes;
  }

  public static ItemType getItemById(String id) {
    DocumentRoot documentRoot = getDocumentRoot();
    EList<ItemType> itemTypes = documentRoot.getAlloy().getRepository().getItem();

    for (ItemType itemType : itemTypes) {
      if (id.equals(itemType.getId())) {
        return itemType;
      }
    }

    return null;
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



  public static Map<IMarker, String> getRelationsOfFirstSideMarker(IMarker selectedMarker) {
    Map<IMarker, String> relationsOfMarker = new HashMap<IMarker, String>();
    ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        getFieldTypesList(MarkElementUtilities.getType(selectedMarker), true);
    String selectedMarkerId = MarkElementUtilities.getSourceId(selectedMarker);

    for (FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      EList<TupleType> tupleTypes = fieldType.getTuple();
      for (TupleType tupleType : tupleTypes) {
        EList<AtomType> atoms = tupleType.getAtom();
        AtomType firstAtomType = atoms.get(0);
        if (firstAtomType.getLabel().equals(selectedMarkerId)) {
          AtomType secondAtomType = atoms.get(1);
          ItemType itemTypeOfAtom = getItemById(secondAtomType.getLabel());
          IMarker toMarker = MarkElementUtilities.getiMarker(secondAtomType.getLabel(),
              getValueOfEntry(itemTypeOfAtom, RESOURCE));
          relationsOfMarker.put(toMarker, fieldType.getLabel());
        }
      }
    }

    return relationsOfMarker;
  }

  public static Map<IMarker, String> getRelationsOfSecondSideMarker(IMarker selectedMarker) {
    Map<IMarker, String> relationsOfMarker = new HashMap<IMarker, String>();
    ArrayList<FieldType> fieldTypesOfSelectedMarkerType =
        getFieldTypesList(MarkElementUtilities.getType(selectedMarker), false);
    String selectedMarkerId = MarkElementUtilities.getSourceId(selectedMarker);

    for (FieldType fieldType : fieldTypesOfSelectedMarkerType) {
      EList<TupleType> tupleTypes = fieldType.getTuple();
      for (TupleType tupleType : tupleTypes) {
        EList<AtomType> atoms = tupleType.getAtom();
        AtomType firstAtomType = atoms.get(1);
        if (firstAtomType.getLabel().equals(selectedMarkerId)) {
          AtomType secondAtomType = atoms.get(0);
          ItemType itemTypeOfAtom = getItemById(secondAtomType.getLabel());
          IMarker toMarker = MarkElementUtilities.getiMarker(secondAtomType.getLabel(),
              getValueOfEntry(itemTypeOfAtom, RESOURCE));
          relationsOfMarker.put(toMarker, fieldType.getLabel());
        }
      }
    }

    return relationsOfMarker;
  }

  public static void removeRelationOfMarkers(IMarker fromMarker, IMarker toMarker,
      String relationName) {
    DocumentRoot documentRoot = getDocumentRoot();
    EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();

    String fromMarkerId = MarkElementUtilities.getSourceId(fromMarker);
    String toMarkerId = MarkElementUtilities.getSourceId(toMarker);

    for (FieldType fieldType : fieldTypes) {
      if (fieldType.getLabel().equals(relationName)) {
        Iterator<TupleType> tupleTypesİter = fieldType.getTuple().iterator();
        while (tupleTypesİter.hasNext()) {
          EList<AtomType> atoms = tupleTypesİter.next().getAtom();
          if (atoms.get(0).getLabel().equals(fromMarkerId)
              && atoms.get(1).getLabel().equals(toMarkerId)) {
            tupleTypesİter.remove();
            writeDocumentRoot(documentRoot);
            return;
          }
        }
      }
    }

  }

  /**
   * @return true if Alloy file parsed and XML file is constructed , false if doesn't.
   */
  public static boolean isExists() {
    Path path = new Path(AlloyUtilities.getLocation());
    return path.toFile().exists() ? true : false;
  }

  public static void showViz() {
    final String xmlFileName = Util.canon(getLocation());
    File f = new File(xmlFileName);
    AlloyInstance myInstance = null;
    try {
      if (!f.exists())
        throw new IOException("File " + xmlFileName + " does not exist.");
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
}
