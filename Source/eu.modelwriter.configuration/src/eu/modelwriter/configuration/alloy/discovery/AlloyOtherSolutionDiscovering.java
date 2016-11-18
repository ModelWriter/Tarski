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

public class AlloyOtherSolutionDiscovering {

  private Map<String, Integer> discoverSigs;
  private static AlloyOtherSolutionDiscovering instance;
  private Map<Integer, List<AtomType>> oldDiscoverSigs;
  private Map<Integer, List<TupleType>> oldDiscoverRelations;
  String xmlFileLoc = InstanceTranslatorDiscovering.baseFileDirectory + "discovering.xml";
  private static List<A4Solution> solutions;
  private int currentSolutionIndex;

  public static AlloyOtherSolutionDiscovering getInstance() {
    if (AlloyOtherSolutionDiscovering.instance == null) {
      AlloyOtherSolutionDiscovering.instance = new AlloyOtherSolutionDiscovering();
      AlloyOtherSolutionDiscovering.instance.oldDiscoverSigs = new HashMap<>();
      AlloyOtherSolutionDiscovering.instance.oldDiscoverRelations = new HashMap<>();
      AlloyOtherSolutionDiscovering.solutions = new ArrayList<>();
    }

    return AlloyOtherSolutionDiscovering.instance;
  }

  public boolean next() throws Err {
    A4Solution ans;
    if (AlloyOtherSolutionDiscovering.solutions.size() <= currentSolutionIndex + 1) {
      ans = AlloyOtherSolutionDiscovering.solutions.get(currentSolutionIndex).next();
      if (ans.equals(AlloyOtherSolutionDiscovering.solutions.get(currentSolutionIndex))) {
        return false;
      }
      AlloyOtherSolutionDiscovering.solutions.add(ans);
      currentSolutionIndex++;
    } else {
      ans = AlloyOtherSolutionDiscovering.solutions.get(currentSolutionIndex + 1);
      currentSolutionIndex++;
    }

    if (discoverSigs.isEmpty()) {
      return false;
    }

    if (ans.satisfiable()) {
      ans.writeXML(xmlFileLoc);
      if (!parse()) {
        AlloyOtherSolutionDiscovering.solutions.clear();
        currentSolutionIndex = 0;
        discoverSigs.clear();
        return false;
      }
    } else {
      AlloyOtherSolutionDiscovering.solutions.clear();
      discoverSigs.clear();
      JOptionPane.showMessageDialog(null, "There is not anymore reasoning.", "Next Solution",
          JOptionPane.INFORMATION_MESSAGE);
    }

    removeOldDiscovering();
    return discovering();
  }

  public boolean previous() throws Err {
    A4Solution ans;
    if (currentSolutionIndex - 1 < 0) {
      return false;
    } else {
      ans = AlloyOtherSolutionDiscovering.solutions.get(currentSolutionIndex - 1);
      currentSolutionIndex--;
    }

    if (discoverSigs.isEmpty()) {
      return false;
    }

    if (ans.satisfiable()) {
      ans.writeXML(xmlFileLoc);
      if (!parse()) {
        AlloyOtherSolutionDiscovering.solutions.clear();
        currentSolutionIndex = 0;
        discoverSigs.clear();
        return false;
      }
    } else {
      AlloyOtherSolutionDiscovering.solutions.clear();
      discoverSigs.clear();
      JOptionPane.showMessageDialog(null, "There is not anymore reasoning.", "Previous Solution",
          JOptionPane.INFORMATION_MESSAGE);
    }

    removeOldDiscovering();
    return discovering();
  }

  private boolean parse() {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = factory.newDocumentBuilder();
      final File file = new File(xmlFileLoc);
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
    return false;
  }

  private void removeOldDiscovering() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final Iterator<Entry<Integer, List<AtomType>>> oldDiscoverAtomsIterator =
        oldDiscoverSigs.entrySet().iterator();
    final EList<SigType> sigTypes = documentRoot.getAlloy().getInstance().getSig();
    while (oldDiscoverAtomsIterator.hasNext()) {
      final Entry<Integer, List<AtomType>> entry = oldDiscoverAtomsIterator.next();
      for (final SigType sigType : sigTypes) {
        if (sigType.getID() == entry.getKey()) {
          for (final AtomType oldAtomType : entry.getValue()) {
            final Iterator<AtomType> atomIter = sigType.getAtom().iterator();
            while (atomIter.hasNext()) {
              final AtomType atomType = atomIter.next();
              if (atomType.isReasoned()) {
                if (oldAtomType.getLabel().equals(atomType.getLabel())) {
                  atomIter.remove();
                }
              }
            }
          }
        }
      }
    }

    final Iterator<Entry<Integer, List<TupleType>>> oldDiscoverRelationsIterator =
        oldDiscoverRelations.entrySet().iterator();
    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();
    while (oldDiscoverRelationsIterator.hasNext()) {
      final Entry<Integer, List<TupleType>> entry = oldDiscoverRelationsIterator.next();
      for (final FieldType fieldType : fieldTypes) {
        if (fieldType.getID() == entry.getKey()) {
          for (final TupleType oldTupleType : entry.getValue()) {
            final Iterator<TupleType> tupleIter = fieldType.getTuple().iterator();
            final AtomType oldAtomType0 = oldTupleType.getAtom().get(0);
            final AtomType oldAtomType1 = oldTupleType.getAtom().get(1);
            while (tupleIter.hasNext()) {
              final TupleType tupleType = tupleIter.next();
              if (tupleType.isReasoned()) {
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
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    oldDiscoverRelations.clear();
    oldDiscoverSigs.clear();
  }

  public void finish() {
    AlloyOtherSolutionDiscovering.solutions.clear();
  }

  public DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(xmlFileLoc));
    } catch (final IOException e) {
      return null;
    }
    if (list == null || list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  public A4Solution getCurrentSolution() {
    return AlloyOtherSolutionDiscovering.solutions.get(currentSolutionIndex);
  }

  public Map<Integer, List<AtomType>> getOldDiscoverSigs() {
    return oldDiscoverSigs;
  }

  public Map<Integer, List<TupleType>> getOldDiscoverRelations() {
    return oldDiscoverRelations;
  }

  public void setDiscoverSigs(final Map<String, Integer> discoverSigs) {
    this.discoverSigs = discoverSigs;
  }

  private boolean discovering() {
    final DocumentRoot documentRootDiscovering = getDocumentRoot();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootDiscovering == null) {
      System.err.println("Document root on location " + xmlFileLoc + " is NULL.");
      return false;
    }

    discover(documentRootOriginal, documentRootDiscovering);

    return true;
  }

  private void discover(DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootDiscovering) {
    int discoveredAtomCount = 0;
    int discoveredRelationCount = 0;

    final String moduleName = AlloyUtilities.getOriginalModuleName();

    final Map<TupleType, FieldType> reasonedTuples_D = new HashMap<>();
    final Map<AtomType, String> discoveredAtoms_D = new HashMap<>();

    for (final SigType sigType_D : documentRootDiscovering.getAlloy().getInstance().getSig()) {
      if (!sigType_D.getLabel().contains(moduleName)) {
        continue;
      }
      final String label = sigType_D.getLabel();
      final String sigName = label.substring(label.lastIndexOf("/") + 1);
      if (!discoverSigs.containsKey(sigName)) {
        continue;
      }

      final int discoveredAtomSize = sigType_D.getAtom().size();
      discoveredAtomCount += discoveredAtomSize;
      for (int i = 0; i < discoveredAtomSize; i++) {
        discoveredAtoms_D.put(sigType_D.getAtom().get(i), sigName);
      }

      final int id = sigType_D.getID();
      final ArrayList<Integer> allParentIds =
          AlloyUtilities.getAllParentIds(id, documentRootDiscovering);

      for (final FieldType fieldType_D : documentRootDiscovering.getAlloy().getInstance()
          .getField()) {
        for (final TypesType typesType_D : fieldType_D.getTypes()) {
          for (int i = 0; i < typesType_D.getType().size(); i++) {
            if (allParentIds.contains(typesType_D.getType().get(i).getID())) {
              for (final TupleType tupleType_D : fieldType_D.getTuple()) {
                for (final AtomType atomType : tupleType_D.getAtom()) {
                  if (atomType.getLabel().contains(moduleName)) {
                    reasonedTuples_D.put(tupleType_D, fieldType_D);
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
      final int index = addStrayedAtom2Sig(documentRootOriginal, entry.getValue()); // W
      documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

      final SigType sigType =
          AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigName));
      if (AlloyOtherSolutionDiscovering.getInstance().getOldDiscoverSigs()
          .get(sigType.getID()) == null) {
        AlloyOtherSolutionDiscovering.getInstance().getOldDiscoverSigs().put(sigType.getID(),
            new ArrayList<>(Arrays.asList(sigType.getAtom().get(index))));
      } else {
        AlloyOtherSolutionDiscovering.getInstance().getOldDiscoverSigs().get(sigType.getID())
        .add(sigType.getAtom().get(index));
      }

      label2AtomIndex.put(atomType_D.getLabel(), index);
    }

    for (final Entry<TupleType, FieldType> entry : reasonedTuples_D.entrySet()) {
      documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

      final TupleType tupleType_D = entry.getKey();
      final FieldType fieldType_D = entry.getValue();
      final String fieldName = fieldType_D.getLabel();

      final EList<FieldType> fieldTypesList =
          documentRootOriginal.getAlloy().getInstance().getField();
      for (final FieldType fieldType_O : fieldTypesList) {
        documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

        final String originalParentName = AlloyUtilities.getSigNameById(fieldType_O.getParentID());
        final String discoverParentName =
            AlloyUtilities.getSigNameById(fieldType_D.getParentID(), documentRootDiscovering);

        if (originalParentName.equals(discoverParentName)
            && fieldType_O.getLabel().equals(fieldName)) {

          final String sourceAtomLabel = tupleType_D.getAtom().get(0).getLabel();
          String sourceAtomType = sourceAtomLabel.substring(sourceAtomLabel.lastIndexOf("/") + 1);
          sourceAtomType = sourceAtomType.substring(0, sourceAtomType.indexOf("$"));
          final Integer sourceAtomIndex = label2AtomIndex.get(sourceAtomLabel);
          AtomType atomType_OS = sourceAtomIndex == null
              ? getOriginalAtomType(documentRootOriginal, sourceAtomLabel) : null;

              final String targetAtomLabel = tupleType_D.getAtom().get(1).getLabel();
              String targetAtomType = targetAtomLabel.substring(targetAtomLabel.lastIndexOf("/") + 1);
              targetAtomType = targetAtomType.substring(0, targetAtomType.indexOf("$"));
              final Integer targetAtomIndex = label2AtomIndex.get(targetAtomLabel);
              AtomType atomType_OT = targetAtomIndex == null
                  ? getOriginalAtomType(documentRootOriginal, targetAtomLabel) : null;

                  final EList<SigType> sigTypes = documentRootOriginal.getAlloy().getInstance().getSig();
                  for (final SigType sigType : sigTypes) {
                    String label = sigType.getLabel();
                    label = label.substring(label.lastIndexOf("/") + 1);
                    if (sourceAtomType.equals(label)) {
                      if (sourceAtomIndex != null) {
                        atomType_OS = sigType.getAtom().get(sourceAtomIndex);
                      }
                    }
                    if (targetAtomType.equals(label)) {
                      if (targetAtomIndex != null) {
                        atomType_OT = sigType.getAtom().get(targetAtomIndex);
                      }
                    }
                  }

                  final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
                  if (atomType_OS.equals(atomType_OT)) {
                    atomType_OS = AlloyUtilities.cloneAtomType(atomType_OS);
                  }
                  tupleType.getAtom().add(atomType_OS);
                  tupleType.getAtom().add(atomType_OT);
                  tupleType.setReasoned(true);
                  discoveredRelationCount++;

                  documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R
                  for (final FieldType fieldType : documentRootOriginal.getAlloy().getInstance()
                      .getField()) {
                    if (fieldType.getID() == fieldType_O.getID()) {
                      fieldType.getTuple().add(tupleType);
                      break;
                    }
                  }

                  if (AlloyOtherSolutionDiscovering.getInstance().getOldDiscoverRelations()
                      .get(fieldType_O.getID()) == null) {
                    AlloyOtherSolutionDiscovering.getInstance().getOldDiscoverRelations()
                    .put(fieldType_O.getID(), new ArrayList<>(Arrays.asList(tupleType)));
                  } else {
                    AlloyOtherSolutionDiscovering.getInstance().getOldDiscoverRelations()
                    .get(fieldType_O.getID()).add(tupleType);
                  }

                  AlloyUtilities.writeDocumentRoot(documentRootOriginal); // W
        }
      }
    }

    final String discoveringAtomMessage =
        "Discovering on atoms successfully completed.\nDiscovered atom count: "
            + discoveredAtomCount;
    final String discoveringRelationMessage =
        "Discovering on relations successfully completed.\nDiscovered relation count: "
            + discoveredRelationCount;

    JOptionPane.showMessageDialog(null, discoveringAtomMessage + "\n" + discoveringRelationMessage,
        "Discovering Atom", JOptionPane.INFORMATION_MESSAGE);
  }

  private AtomType getOriginalAtomType(final DocumentRoot documentRootOriginal,
      final String name_R) {
    final String name = name_R.substring(0, name_R.lastIndexOf("_"));
    final int id =
        Integer.parseInt(name_R.substring(name_R.lastIndexOf("_") + 1, name_R.lastIndexOf("$")));

    for (final SigType sigType : documentRootOriginal.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(label.lastIndexOf("/") + 1);
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
      label = label.substring(sigType.getLabel().lastIndexOf("/") + 1);
      if (label.equals(sigName)) {
        sigType.getAtom().add(atomType);
        count = sigType.getAtom().size();
        break;
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    return count - 1;
  }

  public void setFirstAns(final A4Solution ans) {
    AlloyOtherSolutionDiscovering.solutions.clear();
    AlloyOtherSolutionDiscovering.solutions.add(ans);
    currentSolutionIndex = 0;
  }
}
