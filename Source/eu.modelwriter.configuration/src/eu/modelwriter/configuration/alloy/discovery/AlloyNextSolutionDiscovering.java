package eu.modelwriter.configuration.alloy.discovery;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;

public class AlloyNextSolutionDiscovering {

  private A4Solution ans;
  private Map<String, Integer> discoverSigs;
  private static AlloyNextSolutionDiscovering instance;
  private Map<SigType, List<AtomType>> oldDiscoverSigs;
  private Map<FieldType, List<TupleType>> oldDiscoverRelations;
  String xmlFileLoc = InstanceTranslatorDiscovering.baseFileDirectory + "discovering.xml";

  public static AlloyNextSolutionDiscovering getInstance() {
    if (AlloyNextSolutionDiscovering.instance == null) {
      AlloyNextSolutionDiscovering.instance = new AlloyNextSolutionDiscovering();
      AlloyNextSolutionDiscovering.instance.oldDiscoverSigs = new HashMap<>();
      AlloyNextSolutionDiscovering.instance.oldDiscoverRelations = new HashMap<>();
    }

    return AlloyNextSolutionDiscovering.instance;
  }

  public void next() {
    if (!this.parse()) {
      this.ans = null;
      this.discoverSigs = null;
      return;
    }
    this.removeOldDiscovering();
    this.discovering();
  }

  private boolean parse() {
    if (this.ans == null || this.discoverSigs == null) {
      return false;
    }

    try {
      final A4Solution previousAns = this.ans;
      this.ans = this.ans.next();
      if (this.ans.satisfiable() && !this.ans.equals(previousAns)) {
        this.ans.writeXML(this.xmlFileLoc);

        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
          builder = factory.newDocumentBuilder();
          final File file = new File(this.xmlFileLoc);
          final Document document = builder.parse(file);
          final Node instance = document.getElementsByTagName("instance").item(0);
          instance.getAttributes().removeNamedItem("command");

          Transformer transformer;
          try {
            transformer = TransformerFactory.newInstance().newTransformer();
            final DOMSource source = new DOMSource(document);
            final StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
          } catch (final Exception e) {
          }

          return true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
        }
      } else {
        this.ans = null;
        this.discoverSigs = null;
        JOptionPane.showMessageDialog(null, "There is not any discovering.", "Next Solution",
            JOptionPane.INFORMATION_MESSAGE);
      }
    } catch (final Err e1) {
      e1.printStackTrace();
    }
    return false;
  }

  private void removeOldDiscovering() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final Iterator<Entry<SigType, List<AtomType>>> oldDiscoverAtomsIterator =
        this.oldDiscoverSigs.entrySet().iterator();
    final EList<SigType> sigTypes = documentRoot.getAlloy().getInstance().getSig();
    while (oldDiscoverAtomsIterator.hasNext()) {
      final Map.Entry<SigType, List<AtomType>> entry = oldDiscoverAtomsIterator.next();
      for (final SigType sigType : sigTypes) {
        if (sigType.getID() == entry.getKey().getID()) {
          for (final AtomType oldAtomType : entry.getValue()) {
            final Iterator<AtomType> atomIter = sigType.getAtom().iterator();
            while (atomIter.hasNext()) {
              final AtomType atomType = atomIter.next();
              if (oldAtomType.getLabel().equals(atomType.getLabel())) {
                atomIter.remove();
              }
            }
          }
        }
      }
    }

    final Iterator<Entry<FieldType, List<TupleType>>> oldDiscoverRelationsIterator =
        this.oldDiscoverRelations.entrySet().iterator();
    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();
    while (oldDiscoverRelationsIterator.hasNext()) {
      final Entry<FieldType, List<TupleType>> entry = oldDiscoverRelationsIterator.next();
      for (final FieldType fieldType : fieldTypes) {
        if (fieldType.getID() == entry.getKey().getID()) {
          for (final TupleType oldTupleType : entry.getValue()) {
            final Iterator<TupleType> tupleIter = fieldType.getTuple().iterator();
            final AtomType oldAtomType0 = oldTupleType.getAtom().get(0);
            final AtomType oldAtomType1 = oldTupleType.getAtom().get(1);
            while (tupleIter.hasNext()) {
              final TupleType tupleType = tupleIter.next();
              final AtomType atomType0 = tupleType.getAtom().get(0);
              final AtomType atomType1 = tupleType.getAtom().get(1);
              if (oldAtomType0.getLabel().equals(atomType0.getLabel())
                  && oldAtomType1.getLabel().equals(atomType1.getLabel())) {
                tupleIter.remove();
              }
            }
          }
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    this.oldDiscoverRelations.clear();
    this.oldDiscoverSigs.clear();
  }

  public void finishNext() {
    this.ans = null;
  }

  public DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(this.xmlFileLoc));
    } catch (final IOException e) {
      return null;
    }
    if (list == null || list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  public A4Solution getAns() {
    return this.ans;
  }

  public void setAns(final A4Solution ans) {
    this.ans = ans;
  }

  public Map<SigType, List<AtomType>> getOldDiscoverSigs() {
    return this.oldDiscoverSigs;
  }

  public Map<FieldType, List<TupleType>> getOldDiscoverRelations() {
    return this.oldDiscoverRelations;
  }

  public void setDiscoverSigs(final Map<String, Integer> discoverSigs) {
    this.discoverSigs = discoverSigs;
  }

  private void discovering() {
    final DocumentRoot documentRootDiscovering = this.getDocumentRoot();
    DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootDiscovering == null) {
      return;
    }

    int discoveredAtomCount = 0;
    int discoveredRelationCount = 0;

    final String moduleName = AlloyUtilities.getOriginalModuleName();

    final Map<TupleType, String> reasonedTuples_D = new HashMap<>();
    final Map<AtomType, String> discoveredAtoms_D = new HashMap<>();

    for (final SigType sigType_D : documentRootDiscovering.getAlloy().getInstance().getSig()) {
      if (!sigType_D.getLabel().contains(moduleName)) {
        continue;
      }
      final String label = sigType_D.getLabel();
      final String sigName = label.substring(label.indexOf("/") + 1);
      if (!this.discoverSigs.containsKey(sigName)) {
        continue;
      }

      final int discoveredAtomSize = sigType_D.getAtom().size();
      discoveredAtomCount += discoveredAtomSize;
      for (int i = 0; i < discoveredAtomSize; i++) {
        discoveredAtoms_D.put(sigType_D.getAtom().get(i), sigName);
      }

      final int id = sigType_D.getID();
      for (final FieldType fieldType_D : documentRootDiscovering.getAlloy().getInstance()
          .getField()) {
        for (final TypesType typesType_D : fieldType_D.getTypes()) {
          for (int i = 0; i < typesType_D.getType().size(); i++) {
            if (typesType_D.getType().get(i).getID() == id) {
              for (final TupleType tupleType_D : fieldType_D.getTuple()) {
                for (final AtomType atomType : tupleType_D.getAtom()) {
                  if (atomType.getLabel().contains(moduleName)) {
                    reasonedTuples_D.put(tupleType_D, fieldType_D.getLabel());
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }

    final Map<String, Integer> label2AtomIndex = new HashMap<>();

    for (final Entry<AtomType, String> entry : discoveredAtoms_D.entrySet()) {
      final AtomType atomType_D = entry.getKey();
      final String sigName = entry.getValue();
      final int index = this.addStrayedAtom2Sig(documentRootOriginal, entry.getValue()); // W
      documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

      final SigType sigType =
          AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigName));
      if (AlloyNextSolutionDiscovering.getInstance().getOldDiscoverSigs().get(sigType) == null) {
        AlloyNextSolutionDiscovering.getInstance().getOldDiscoverSigs().put(sigType,
            new ArrayList<>(Arrays.asList(sigType.getAtom().get(index))));
      } else {
        AlloyNextSolutionDiscovering.getInstance().getOldDiscoverSigs().get(sigType)
        .add(sigType.getAtom().get(index));
      }

      label2AtomIndex.put(atomType_D.getLabel(), index);
    }

    for (final Entry<TupleType, String> entry : reasonedTuples_D.entrySet()) {
      documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

      final TupleType tupleType_D = entry.getKey();
      final String fieldName = entry.getValue();
      final EList<FieldType> fieldTypesList =
          documentRootOriginal.getAlloy().getInstance().getField();
      for (final FieldType fieldType_O : fieldTypesList) {
        documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R
        if (fieldType_O.getLabel().equals(fieldName)) {

          final String sourceAtomLabel = tupleType_D.getAtom().get(0).getLabel();
          final String sourceAtomType = sourceAtomLabel.substring(sourceAtomLabel.indexOf("/") + 1);
          final Integer sourceAtomIndex = label2AtomIndex.get(sourceAtomLabel);

          final String targetAtomLabel = tupleType_D.getAtom().get(1).getLabel();
          final String targetAtomType = targetAtomLabel.substring(targetAtomLabel.indexOf("/") + 1);
          final Integer targetAtomIndex = label2AtomIndex.get(targetAtomLabel);

          AtomType atomType_OS = null, atomType_OT = null;
          final EList<SigType> sigTypes = documentRootOriginal.getAlloy().getInstance().getSig();
          for (final SigType sigType : sigTypes) {
            String label = sigType.getLabel();
            label = label.substring(label.indexOf("/") + 1);
            if (sourceAtomType.contains(label)) {
              if (sourceAtomIndex != null) {
                atomType_OS = sigType.getAtom().get(sourceAtomIndex);
              } else {
                atomType_OS = this.getOriginalAtomType(documentRootOriginal, sourceAtomLabel);
              }
            }
            if (targetAtomType.contains(label)) {
              if (targetAtomIndex != null) {
                atomType_OT = sigType.getAtom().get(targetAtomIndex);
              } else {
                atomType_OT = this.getOriginalAtomType(documentRootOriginal, targetAtomLabel);
              }
            }
          }

          final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
          tupleType.getAtom().add(atomType_OS);
          tupleType.getAtom().add(atomType_OT);
          tupleType.setReasoned(true);
          discoveredRelationCount++;

          documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R
          for (final FieldType fieldType : documentRootOriginal.getAlloy().getInstance()
              .getField()) {
            if (fieldType.getLabel().equals(fieldName)) {
              fieldType.getTuple().add(tupleType);
            }
          }

          if (AlloyNextSolutionDiscovering.getInstance().getOldDiscoverRelations()
              .get(fieldType_O) == null) {
            AlloyNextSolutionDiscovering.getInstance().getOldDiscoverRelations().put(fieldType_O,
                new ArrayList<>(Arrays.asList(tupleType)));
          } else {
            AlloyNextSolutionDiscovering.getInstance().getOldDiscoverRelations().get(fieldType_O)
            .add(tupleType);
          }

          AlloyUtilities.writeDocumentRoot(documentRootOriginal); // W
        }
      }
    }

    if (discoveredAtomCount == 0) {
      JOptionPane.showMessageDialog(null, "There is not any discovering.", "Discover on Atoms",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Successfully added " + discoveredAtomCount + " discovered atoms.", "Reason on Relations",
          JOptionPane.WARNING_MESSAGE);
    }
    if (discoveredRelationCount == 0) {
      JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null,
          "Successfully added " + discoveredRelationCount + " reasons for discovered atoms.",
          "Reason on Relations", JOptionPane.WARNING_MESSAGE);
    }
  }

  private AtomType getOriginalAtomType(final DocumentRoot documentRootOriginal,
      final String name_R) {
    final String name = name_R.substring(0, name_R.indexOf("_"));
    final int id = Integer.parseInt(name_R.substring(name_R.indexOf("_") + 1, name_R.indexOf("$")));

    for (final SigType sigType : documentRootOriginal.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(label.indexOf("/") + 1);
      if (label.equals(name)) {
        return sigType.getAtom().get(id);
      }
    }
    return null;
    // return
    // AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
  }

  private int addStrayedAtom2Sig(final DocumentRoot documentRoot, final String sigName) {
    int count = 0;
    final String id = MarkerFactory.generateId(documentRoot);

    final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
    atomType.setLabel(id);
    atomType.setReasoned(true);

    for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(sigType.getLabel().indexOf("/") + 1);
      if (label.equals(sigName)) {
        sigType.getAtom().add(atomType);
        count = sigType.getAtom().size();
        break;
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    return count - 1;
  }
}
