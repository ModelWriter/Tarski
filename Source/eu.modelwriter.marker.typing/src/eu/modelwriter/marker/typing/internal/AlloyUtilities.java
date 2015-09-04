/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.marker.typing.internal;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JDialog;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
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
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.persistencePackage;
import eu.modelwriter.traceability.core.persistence.util.persistenceResourceFactoryImpl;

public class AlloyUtilities {

  final public static String RESOURCE = "resource";
  final public static String TEXT = "text";
  final public static String OFFSET = "offset";
  final public static String MARKER_URI = "uri";
  final public static String GROUP_ID = "groupId";
  final public static String LEADER_ID = "leaderId";

  public static String xmlFileLocation = "alloyXml.xml";

  public static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + xmlFileLocation;
  }

  public static void createXMLFromAlloy(String filename) {
    try {
      A4Reporter rep = new A4Reporter();

      Module world = CompUtil.parseEverything_fromFile(rep, null, filename);
      A4Options opt = new A4Options();
      opt.originalFilename = filename;
      opt.solver = A4Options.SatSolver.SAT4J;
      Command cmd = world.getAllCommands().get(0);
      A4Solution sol = TranslateAlloyToKodkod.execute_commandFromBook(rep,
          world.getAllReachableSigs(), cmd, opt);
      assert sol.satisfiable();
      sol.writeXML(getLocation());

      clearSigAndFields();

    } catch (Err e) {
      e.printStackTrace();
    }
  }

  private static void clearSigAndFields() {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);
    EList<SigType> sigs = documentRoot.getAlloy().getInstance().getSig();

    for (SigType sigType : sigs) {
      sigType.getAtom().clear();
    }

    EList<FieldType> fields = documentRoot.getAlloy().getInstance().getField();

    for (FieldType fieldType : fields) {
      fieldType.getTuple().clear();
    }

    saveResource(res, documentRoot);
  }

  public static Resource getResource() {
    ResourceSet resourceSet = new ResourceSetImpl();

    // Register the appropriate resource factory to handle all file extensions.
    //
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new persistenceResourceFactoryImpl());

    // Register the package to ensure it is available during loading.
    //
    resourceSet.getPackageRegistry().put(persistencePackage.eNS_URI, persistencePackage.eINSTANCE);

    URI uri = URI.createFileURI(getLocation());

    return resourceSet.getResource(uri, true);

  }

  public static void saveResource(Resource res, DocumentRoot documentRoot) {
    res.getContents().clear();
    res.getContents().add(documentRoot);
    try {
      res.save(null);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public static void addMarkerToRepository(IMarker marker) {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

    ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
    documentRoot.getAlloy().getRepository().getItem().add(itemType);
    itemType.setId(MarkElementUtilities.getSourceId(marker));

    setEntries(itemType, marker);

    saveResource(res, documentRoot);
  }


  public static void addTypeToMarker(IMarker marker) {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

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

    if (findItemTypeInRepository(marker) == null) {
      ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
      documentRoot.getAlloy().getRepository().getItem().add(itemType);
      itemType.setId(MarkElementUtilities.getSourceId(marker));

      setEntries(itemType, marker);
    }

    saveResource(res, documentRoot);
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
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

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

    saveResource(res, documentRoot);

  }

  public static void removeMarker(IMarker marker) {

    removeTypeFromMarker(marker);

    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

    ItemType itemType = findItemTypeInRepository(marker);
    documentRoot.getAlloy().getRepository().getItem().remove(itemType);

    saveResource(res, documentRoot);
  }

  public static void addRelation2Markers(IMarker fromMarker, IMarker toMarker, String relation) {
    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

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
        fieldType.getTuple().add(tuple);
        break;
      }
    }

    saveResource(res, documentRoot);
  }

  public static ItemType findItemTypeInRepository(IMarker marker) {
    String markerId = MarkElementUtilities.getSourceId(marker);

    Resource res = getResource();
    DocumentRoot documentRoot = (DocumentRoot) res.getContents().get(0);

    EList<ItemType> itemTypes = documentRoot.getAlloy().getRepository().getItem();

    for (ItemType itemType : itemTypes) {
      if (markerId.equals(itemType.getId()))
        return itemType;
    }

    return null;
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
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
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

  public static void main(String[] args) {
    createXMLFromAlloy("C:\\Users\\3\\Desktop\\Ecore.als");
  }

}
