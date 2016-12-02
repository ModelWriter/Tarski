package eu.modelwriter.configuration.alloy.analysis.discovering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import eu.modelwriter.configuration.alloy.analysis.AlloySolutionFinder;
import eu.modelwriter.configuration.alloy.analysis.IAlloyAnalyzer;
import eu.modelwriter.configuration.alloy.analysis.RUN_TYPE;
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

public class Discovering implements IAlloyAnalyzer {

  private static Discovering instance;
  private static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter discovering ".replace(" ", System.getProperty("file.separator"));
  private static final String alsPath = Discovering.baseFileDirectory + "discovering.als";
  private static final String xmlPath = Discovering.baseFileDirectory + "discovering.xml";
  private static Map<String, Integer> discoverSigs;
  private static List<A4Solution> solutions;
  private static List<Map<Integer, List<AtomType>>> discoveredAtoms;
  private static List<Map<Integer, List<TupleType>>> reasonedTuples;
  private static List<Map<String, AtomType>> discoveredAtomLabels2OriginalAtomTypes;
  private static List<Map<String, TupleType>> reasonedTupleStrings2OriginalTupleTypes;
  private static int currentSolutionIndex;
  private static int MAX_NEXT_SOLUTION_ATTEMPT = 25;
  private static int CURRENT_NEXT_SOLUTION_ATTEMPT;

  private Discovering() {}

  public static Discovering getInstance() {
    if (Discovering.instance == null) {
      Discovering.instance = new Discovering();
      Discovering.discoverSigs = new HashMap<>();
      Discovering.solutions = new ArrayList<>();
      Discovering.discoveredAtoms = new ArrayList<>();
      Discovering.reasonedTuples = new ArrayList<>();
      Discovering.discoveredAtomLabels2OriginalAtomTypes = new ArrayList<>();
      Discovering.reasonedTupleStrings2OriginalTupleTypes = new ArrayList<>();
    }

    return Discovering.instance;
  }

  @Override
  public boolean start() throws Err {
    final File discoveringXml = new File(Discovering.xmlPath);
    if (discoveringXml.exists()) {
      discoveringXml.delete();
    }
    final File discoveringAls = new File(Discovering.alsPath);
    if (discoveringAls.exists()) {
      discoveringAls.delete();
    }

    final InstanceTranslator4Discovering instanceTranslator =
        new InstanceTranslator4Discovering(Discovering.baseFileDirectory, Discovering.alsPath);
    instanceTranslator.translate();
    Discovering.discoverSigs = instanceTranslator.getDiscoverSig2ExpectValue();

    final AlloySolutionFinder parser = new AlloySolutionFinder(Discovering.alsPath);
    final A4Solution solution = parser.find();

    if (solution == null || !solution.satisfiable()) {
      return false;
    }

    solution.writeXML(Discovering.xmlPath);
    parse(Discovering.xmlPath);
    Discovering.solutions.add(solution);
    Discovering.currentSolutionIndex = 0;
    Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT = 0;

    return discovering(RUN_TYPE.START);
  }

  @Override
  public boolean next() throws Err {
    A4Solution solution;
    if (Discovering.solutions.size() == Discovering.currentSolutionIndex + 1) {
      solution = Discovering.solutions.get(Discovering.currentSolutionIndex).next();
      if (solution.equals(Discovering.solutions.get(Discovering.currentSolutionIndex))) {
        return false;
      } else if (solution.satisfiable()) {
        Discovering.solutions.add(solution);
        Discovering.currentSolutionIndex++;
      } else {
        return false;
      }
    } else {
      solution = Discovering.solutions.get(Discovering.currentSolutionIndex + 1);
      Discovering.currentSolutionIndex++;
    }

    solution.writeXML(Discovering.xmlPath);
    parse(Discovering.xmlPath);

    return discovering(RUN_TYPE.NEXT);
  }

  @Override
  public boolean previous() throws Err {
    A4Solution solution;
    if (Discovering.currentSolutionIndex == 0) {
      return false;
    } else {
      solution = Discovering.solutions.get(Discovering.currentSolutionIndex - 1);
      Discovering.currentSolutionIndex--;
    }

    solution.writeXML(Discovering.xmlPath);
    parse(Discovering.xmlPath);

    return discovering(RUN_TYPE.PREVIOUS);
  }

  private void parse(final String xmlPath) {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;
    try {
      builder = factory.newDocumentBuilder();
      final File file = new File(xmlPath);
      final Document document = builder.parse(file);
      final Node instance = document.getElementsByTagName("instance").item(0);
      instance.getAttributes().removeNamedItem("command");

      Transformer transformer;
      try {
        transformer = TransformerFactory.newInstance().newTransformer();
        final DOMSource source = new DOMSource(document);
        final StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      } catch (final Exception e) {
      }
    } catch (ParserConfigurationException | SAXException | IOException e) {
      e.printStackTrace();
    }
  }

  private void removeOldDiscovering(final RUN_TYPE runType) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    int solutionNumber = runType == RUN_TYPE.NEXT ? Discovering.currentSolutionIndex - 1
        : runType == RUN_TYPE.PREVIOUS ? Discovering.currentSolutionIndex + 1 : -1;
    solutionNumber = solutionNumber >= Discovering.discoveredAtoms.size() ? -1 : solutionNumber;
    if (solutionNumber == -1) {
      return;
    }

    final Iterator<Entry<Integer, List<AtomType>>> oldDiscoveredAtomsIterator =
        Discovering.discoveredAtoms.get(solutionNumber).entrySet().iterator();
    final EList<SigType> sigTypes = documentRoot.getAlloy().getInstance().getSig();
    while (oldDiscoveredAtomsIterator.hasNext()) {
      final Entry<Integer, List<AtomType>> entry = oldDiscoveredAtomsIterator.next();
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

    final Iterator<Entry<Integer, List<TupleType>>> oldReasonedTuplesIterator =
        Discovering.reasonedTuples.get(solutionNumber).entrySet().iterator();
    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();
    while (oldReasonedTuplesIterator.hasNext()) {
      final Entry<Integer, List<TupleType>> entry = oldReasonedTuplesIterator.next();
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

    final int discoveredAtomCount =
        calcDiscoveredAtomCount(Discovering.discoveredAtoms.get(solutionNumber));
    MarkerFactory.rewindId(discoveredAtomCount, documentRoot);

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  @Override
  public void finish() {
    Discovering.solutions.clear();
    Discovering.currentSolutionIndex = 0;
    Discovering.discoverSigs.clear();
    Discovering.discoveredAtoms.clear();
    Discovering.reasonedTuples.clear();
    Discovering.discoveredAtomLabels2OriginalAtomTypes.clear();
    Discovering.reasonedTupleStrings2OriginalTupleTypes.clear();
  }

  public DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(Discovering.xmlPath));
    } catch (final IOException e) {
      return null;
    }
    if (list == null || list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  private boolean discovering(final RUN_TYPE runType) throws Err {
    removeOldDiscovering(runType);

    final DocumentRoot documentRootDiscovering = getDocumentRoot();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();

    int reasonedTupleCount, appliedReasonedTupleCount = 0;
    int discoveredAtomCount, appliedDiscoveredAtomCount = 0;
    if (Discovering.solutions.size() > Discovering.discoveredAtoms.size()) {
      final Map<Integer, List<AtomType>> newDiscoveredAtoms =
          findDiscoveredAtoms(documentRootOriginal, documentRootDiscovering);
      discoveredAtomCount = calcDiscoveredAtomCount(newDiscoveredAtoms);
      Discovering.discoveredAtoms.add(newDiscoveredAtoms);
      final Map<Integer, List<TupleType>> newReasonedTuples =
          findReasonedTuples(documentRootOriginal, documentRootDiscovering);
      reasonedTupleCount = calcReasonedTupleCount(newReasonedTuples);
      Discovering.reasonedTuples.add(newReasonedTuples);
      if (discoveredAtomCount == 0 || isRequiredPass(reasonedTupleCount, newReasonedTuples,
          discoveredAtomCount, newDiscoveredAtoms)) {
        if (Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT >= Discovering.MAX_NEXT_SOLUTION_ATTEMPT) {
          final boolean rollBackSucceed = rollBackNextAttemption(false);
          if (rollBackSucceed) {
            appliedDiscoveredAtomCount = addNewDiscovering(
                Discovering.discoveredAtoms.get(Discovering.currentSolutionIndex));
            appliedReasonedTupleCount =
                addNewReasoning(Discovering.reasonedTuples.get(Discovering.currentSolutionIndex));
          }
          return false;
        }
        Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT++;
        return next();
      } else {
        if (Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT > 0) {
          rollBackNextAttemption(true);
        }
        appliedDiscoveredAtomCount = addNewDiscovering(newDiscoveredAtoms);
        appliedReasonedTupleCount = addNewReasoning(newReasonedTuples);
      }
    } else {
      final Map<Integer, List<AtomType>> existingDiscoveredAtoms =
          Discovering.discoveredAtoms.get(Discovering.currentSolutionIndex);
      discoveredAtomCount = calcDiscoveredAtomCount(existingDiscoveredAtoms);
      appliedDiscoveredAtomCount = addNewDiscovering(existingDiscoveredAtoms);
      final Map<Integer, List<TupleType>> existingReasonedTuples =
          Discovering.reasonedTuples.get(Discovering.currentSolutionIndex);
      reasonedTupleCount = calcReasonedTupleCount(existingReasonedTuples);
      appliedReasonedTupleCount = addNewReasoning(existingReasonedTuples);
    }

    final String discoveringAtomMessage =
        "Discovering on atoms successfully completed.\nDiscovered atom count: "
            + appliedDiscoveredAtomCount;
    final String discoveringRelationMessage =
        "Reasoning on relations successfully completed.\nReasoned relation count: "
            + appliedReasonedTupleCount;

    JOptionPane.showMessageDialog(null, discoveringAtomMessage + "\n" + discoveringRelationMessage,
        "Discovering Atom", JOptionPane.INFORMATION_MESSAGE);
    return true;
  }

  private boolean rollBackNextAttemption(final boolean lastSolutionIsValid) {
    final int lastSolutionIndex = Discovering.solutions.size() - 1;
    int validSolutionIndex = lastSolutionIsValid ? lastSolutionIndex
        : lastSolutionIndex - Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT - 1;
    Discovering.currentSolutionIndex =
        lastSolutionIsValid ? lastSolutionIndex - Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT
            : lastSolutionIndex - Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT - 1;
    Discovering.CURRENT_NEXT_SOLUTION_ATTEMPT = 0;

    validSolutionIndex = validSolutionIndex > 0 ? validSolutionIndex : 0;
    Discovering.currentSolutionIndex =
        Discovering.currentSolutionIndex > 0 ? Discovering.currentSolutionIndex : 0;

    if (Discovering.discoveredAtoms.get(validSolutionIndex).size() == 0) {
      finish();
      return false;
    }

    Discovering.solutions.set(Discovering.currentSolutionIndex,
        Discovering.solutions.get(validSolutionIndex));
    Discovering.reasonedTuples.set(Discovering.currentSolutionIndex,
        Discovering.reasonedTuples.get(validSolutionIndex));
    Discovering.discoveredAtoms.set(Discovering.currentSolutionIndex,
        Discovering.discoveredAtoms.get(validSolutionIndex));
    Discovering.discoveredAtomLabels2OriginalAtomTypes.set(Discovering.currentSolutionIndex,
        Discovering.discoveredAtomLabels2OriginalAtomTypes.get(validSolutionIndex));
    Discovering.reasonedTupleStrings2OriginalTupleTypes.set(Discovering.currentSolutionIndex,
        Discovering.reasonedTupleStrings2OriginalTupleTypes.get(validSolutionIndex));

    for (int i = lastSolutionIndex; i > Discovering.currentSolutionIndex; i--) {
      Discovering.solutions.remove(i);
      Discovering.reasonedTuples.remove(i);
      Discovering.discoveredAtoms.remove(i);
      Discovering.discoveredAtomLabels2OriginalAtomTypes.remove(i);
      Discovering.reasonedTupleStrings2OriginalTupleTypes.remove(i);
    }
    return true;
  }

  private int addNewReasoning(final Map<Integer, List<TupleType>> newReasonedTuples) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    int addedReasonedTuple = 0;
    final Iterator<FieldType> fieldIterator =
        documentRoot.getAlloy().getInstance().getField().iterator();
    while (fieldIterator.hasNext()) {
      final FieldType oldFieldType = fieldIterator.next();
      final List<TupleType> newTupleTypes = newReasonedTuples.get(oldFieldType.getID());
      if (newTupleTypes != null) {
        for (final TupleType newTupleType : newTupleTypes) {
          final AtomType newAtomType0 = newTupleType.getAtom().get(0);
          final AtomType newAtomType1 = newTupleType.getAtom().get(1);
          final boolean anyMatch = oldFieldType.getTuple().stream()
              .anyMatch(t -> (t.getAtom().get(0).getLabel().equals(newAtomType0.getLabel())
                  && t.getAtom().get(1).getLabel().equals(newAtomType1.getLabel())));
          if (!anyMatch) { // IF REASONED TUPLE ACCEPTED DURING ANALYSIS.
            oldFieldType.getTuple().add(newTupleType);
            addedReasonedTuple++;
          }
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
    return addedReasonedTuple;
  }

  private int calcReasonedTupleCount(final Map<Integer, List<TupleType>> newReasonedTuples) {
    int reasonedTupleCount = 0;
    for (final Entry<Integer, List<TupleType>> entry : newReasonedTuples.entrySet()) {
      reasonedTupleCount += entry.getValue().size();
    }
    return reasonedTupleCount;
  }

  private int addNewDiscovering(final Map<Integer, List<AtomType>> newDiscoveredAtoms) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    int addedDisoveredAtom = 0;
    final Iterator<SigType> sigIterator = documentRoot.getAlloy().getInstance().getSig().iterator();
    while (sigIterator.hasNext()) {
      final SigType oldSigType = sigIterator.next();
      final List<AtomType> newAtomTypes = newDiscoveredAtoms.get(oldSigType.getID());
      if (newAtomTypes != null) { // IF DISCOVERED ATOM INTERPRETED DURING ANALYSIS.
        for (final AtomType newAtomType : newAtomTypes) {
          final boolean anyMatch = oldSigType.getAtom().stream()
              .anyMatch(a -> a.getLabel().equals(newAtomType.getLabel()));
          if (!anyMatch) {
            oldSigType.getAtom().add(newAtomType);
            addedDisoveredAtom++;
          }
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
    return addedDisoveredAtom;
  }

  private int calcDiscoveredAtomCount(final Map<Integer, List<AtomType>> newDiscoveredAtoms) {
    int discoveredAtomCount = 0;
    for (final Entry<Integer, List<AtomType>> entry : newDiscoveredAtoms.entrySet()) {
      discoveredAtomCount += entry.getValue().size();
    }
    return discoveredAtomCount;
  }

  private Map<Integer, List<AtomType>> findDiscoveredAtoms(final DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootDiscovering) throws Err {
    final Map<Integer, List<AtomType>> newDiscoveredAtoms = new HashMap<>();
    final Map<String, AtomType> discoveredAtomLabel2OriginalAtomType = new HashMap<>();

    final String moduleName = AlloyUtilities.getOriginalModuleName();

    for (final SigType sigType_D : documentRootDiscovering.getAlloy().getInstance().getSig()) {
      if (!sigType_D.getLabel().contains(moduleName)) {
        continue;
      }
      final String label = sigType_D.getLabel();
      final String sigName = label.substring(label.lastIndexOf("/") + 1);
      if (!Discovering.discoverSigs.containsKey(sigName)) {
        continue;
      }

      for (final AtomType atomType_D : sigType_D.getAtom()) {
        final String id = MarkerFactory.generateId(documentRootOriginal);
        final AtomType atomType_O = persistenceFactory.eINSTANCE.createAtomType();
        atomType_O.setLabel(id);
        atomType_O.setReasoned(true);

        discoveredAtomLabel2OriginalAtomType.put(atomType_D.getLabel(), atomType_O);

        final SigType sigType_O = AlloyUtilities.getSigTypeById(
            AlloyUtilities.getSigTypeIdByName(sigName, documentRootOriginal), documentRootOriginal);

        if (newDiscoveredAtoms.get(sigType_O.getID()) == null) {
          newDiscoveredAtoms.put(sigType_O.getID(), new ArrayList<>(Arrays.asList(atomType_O)));
        } else {
          newDiscoveredAtoms.get(sigType_O.getID()).add(atomType_O);
        }
      }
    }

    Discovering.discoveredAtomLabels2OriginalAtomTypes.add(discoveredAtomLabel2OriginalAtomType);
    return newDiscoveredAtoms;
  }

  private Map<Integer, List<TupleType>> findReasonedTuples(final DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootDiscovering) throws Err {
    final Map<Integer, List<TupleType>> newReasonedTuples = new HashMap<>();
    final Map<String, TupleType> reasonedTupleString2OriginalTupleType = new HashMap<>();

    final String moduleName = AlloyUtilities.getOriginalModuleName();

    final Map<TupleType, FieldType> reasonedTuples_D = new HashMap<>();

    for (final SigType sigType_D : documentRootDiscovering.getAlloy().getInstance().getSig()) {
      if (!sigType_D.getLabel().contains(moduleName)) {
        continue;
      }
      final String label = sigType_D.getLabel();
      final String sigName = label.substring(label.lastIndexOf("/") + 1);
      if (!Discovering.discoverSigs.containsKey(sigName)) {
        continue;
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

    for (final Entry<TupleType, FieldType> entry : reasonedTuples_D.entrySet()) {

      final TupleType tupleType_D = entry.getKey();
      final FieldType fieldType_D = entry.getValue();
      final String fieldName = fieldType_D.getLabel();

      final EList<FieldType> fieldTypesList =
          documentRootOriginal.getAlloy().getInstance().getField();
      for (final FieldType fieldType_O : fieldTypesList) {

        final String originalParentName =
            AlloyUtilities.getSigNameById(fieldType_O.getParentID(), documentRootOriginal);
        final String discoverParentName =
            AlloyUtilities.getSigNameById(fieldType_D.getParentID(), documentRootDiscovering);

        if (originalParentName.equals(discoverParentName)
            && fieldType_O.getLabel().equals(fieldName)) {

          String sourceAtomLabel = tupleType_D.getAtom().get(0).getLabel();
          AtomType atomType0_O = Discovering.discoveredAtomLabels2OriginalAtomTypes
              .get(Discovering.currentSolutionIndex).get(sourceAtomLabel);
          final String sourceTupleString = sourceAtomLabel;
          if (atomType0_O == null) {
            atomType0_O = getOriginalAtomType(sourceAtomLabel);
            sourceAtomLabel = atomType0_O.getLabel();
          }
          atomType0_O = AlloyUtilities.cloneAtomType(atomType0_O);

          final String targetAtomLabel = tupleType_D.getAtom().get(1).getLabel();
          AtomType atomType1_O = Discovering.discoveredAtomLabels2OriginalAtomTypes
              .get(Discovering.currentSolutionIndex).get(targetAtomLabel);
          String targetTupleString = targetAtomLabel;
          if (atomType1_O == null) {
            atomType1_O = getOriginalAtomType(targetAtomLabel);
            targetTupleString = atomType1_O.getLabel();
          }
          atomType1_O = AlloyUtilities.cloneAtomType(atomType1_O);

          final TupleType tupleType_O = persistenceFactory.eINSTANCE.createTupleType();
          tupleType_O.getAtom().addAll(Arrays.asList(new AtomType[] {atomType0_O, atomType1_O}));
          tupleType_O.setReasoned(true);
          reasonedTupleString2OriginalTupleType.put(sourceTupleString + " -> " + targetTupleString,
              tupleType_O);

          if (newReasonedTuples.get(fieldType_O.getID()) == null) {
            newReasonedTuples.put(fieldType_O.getID(), new ArrayList<>(Arrays.asList(tupleType_O)));
          } else {
            newReasonedTuples.get(fieldType_O.getID()).add(tupleType_O);
          }
        }
      }
    }
    Discovering.reasonedTupleStrings2OriginalTupleTypes.add(reasonedTupleString2OriginalTupleType);
    return newReasonedTuples;
  }

  private boolean isRequiredPass(final int reasonedRelationCount,
      final Map<Integer, List<TupleType>> newReasonedTuples, final int discoveredAtomCount,
      final Map<Integer, List<AtomType>> newDiscoveredAtoms) {
    boolean requirePass = true;

    if (Discovering.solutions.size() == 1) {
      return false;
    }

    int unMatchedExistingDiscoveringCount = 0;
    if (discoveredAtomCount > 0) {
      for (int solutionNumber = 0; solutionNumber < Discovering.discoveredAtoms
          .size(); solutionNumber++) {
        if (solutionNumber == Discovering.currentSolutionIndex) {
          continue;
        }
        final Map<Integer, List<AtomType>> existingDiscoveredAtoms =
            Discovering.discoveredAtoms.get(solutionNumber);
        for (final Entry<Integer, List<AtomType>> newDiscoveredAtomsEntry : newDiscoveredAtoms
            .entrySet()) {
          final Integer sigId = newDiscoveredAtomsEntry.getKey();
          final List<AtomType> atomList_New = newDiscoveredAtomsEntry.getValue();
          if (existingDiscoveredAtoms.containsKey(sigId)) {
            final List<AtomType> atomList_Old = existingDiscoveredAtoms.get(sigId);
            if (atomList_New.size() != atomList_Old.size()) {
              unMatchedExistingDiscoveringCount++;
              break;
            }
            int matchedAtomCount = 0;
            for (final AtomType atomType_New : atomList_New) {
              final String atomLabel_New = atomType_New.getLabel();

              final List<Entry<String, AtomType>> list =
                  Discovering.discoveredAtomLabels2OriginalAtomTypes
                      .get(Discovering.currentSolutionIndex).entrySet().stream()
                      .filter(e -> e.getValue().getLabel().equals(atomLabel_New))
                      .collect(Collectors.toList());
              String atomLabel_New_D = "";
              if (list.size() > 0) {
                atomLabel_New_D = list.get(0).getKey();
              }
              final AtomType atomType_Old = Discovering.discoveredAtomLabels2OriginalAtomTypes
                  .get(solutionNumber).get(atomLabel_New_D);
              if (atomType_Old != null) {
                matchedAtomCount++;
              }
            }
            if (matchedAtomCount != atomList_New.size()) {
              unMatchedExistingDiscoveringCount++;
              break;
            }
          } else {
            unMatchedExistingDiscoveringCount++;
            break;
          }
        }
      }
      if (unMatchedExistingDiscoveringCount == Discovering.discoveredAtoms.size() - 1) {
        requirePass = false;
      }
    }

    int unMatchedExistingReasoningCount = 0;
    if (reasonedRelationCount > 0) {
      for (int solutionNumber = 0; solutionNumber < Discovering.reasonedTuples
          .size(); solutionNumber++) {
        if (solutionNumber == Discovering.currentSolutionIndex) {
          continue;
        }
        final Map<Integer, List<TupleType>> existingReasonedTuples =
            Discovering.reasonedTuples.get(solutionNumber);
        for (final Entry<Integer, List<TupleType>> newReasonsedTuplesEntry : newReasonedTuples
            .entrySet()) {
          final Integer fieldId = newReasonsedTuplesEntry.getKey();
          final List<TupleType> tupleList_New = newReasonsedTuplesEntry.getValue();
          if (existingReasonedTuples.containsKey(fieldId)) {
            final List<TupleType> tupleList_Old = existingReasonedTuples.get(fieldId);
            if (tupleList_New.size() != tupleList_Old.size()) {
              unMatchedExistingReasoningCount++;
              break;
            }
            int matchedTupleCount = 0;
            for (final TupleType tupleType_New : tupleList_New) {
              final AtomType atomType0_New = tupleType_New.getAtom().get(0);
              final String atom0Label_New = atomType0_New.getLabel();

              final AtomType atomType1_New = tupleType_New.getAtom().get(1);
              final String atom1Label_New = atomType1_New.getLabel();

              final List<Entry<String, TupleType>> list =
                  Discovering.reasonedTupleStrings2OriginalTupleTypes
                      .get(Discovering.currentSolutionIndex).entrySet().stream()
                      .filter(e -> (e.getValue().getAtom().get(0).getLabel().equals(atom0Label_New)
                          && e.getValue().getAtom().get(1).getLabel().equals(atom1Label_New)))
                      .collect(Collectors.toList());
              String tupleString_New_D = "";
              if (list.size() > 0) {
                tupleString_New_D = list.get(0).getKey();
              }

              final TupleType tupleType_Old = Discovering.reasonedTupleStrings2OriginalTupleTypes
                  .get(solutionNumber).get(tupleString_New_D);
              if (tupleType_Old != null) {
                matchedTupleCount++;
              }
            }
            if (matchedTupleCount != tupleList_New.size()) {
              unMatchedExistingReasoningCount++;
              break;
            }
          } else {
            unMatchedExistingReasoningCount++;
            break;
          }
        }
      }
      if (unMatchedExistingReasoningCount == Discovering.reasonedTuples.size() - 1) {
        requirePass = false;
      }
    }
    return requirePass;
  }

  private AtomType getOriginalAtomType(final String name_R) {
    if (name_R.contains("/")) {
      return null;
    }
    final String name = name_R.substring(0, name_R.lastIndexOf("_"));
    final int id =
        Integer.parseInt(name_R.substring(name_R.lastIndexOf("_") + 1, name_R.lastIndexOf("$")));

    return AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
  }
}
