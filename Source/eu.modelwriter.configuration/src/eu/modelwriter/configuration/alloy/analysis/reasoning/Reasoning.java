package eu.modelwriter.configuration.alloy.analysis.reasoning;

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
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;

public class Reasoning implements IAlloyAnalyzer {

  private static Reasoning instance;
  private static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter reasoning ".replace(" ", System.getProperty("file.separator"));
  private static final String alsPath = Reasoning.baseFileDirectory + "reasoning.als";
  private static final String xmlPath = Reasoning.baseFileDirectory + "reasoning.xml";
  private static Map<String, List<String>> reasonRelations;
  private static List<A4Solution> solutions;
  private static List<Map<Integer, List<TupleType>>> reasonedTuples;
  private static int currentSolutionIndex;
  private static int MAX_NEXT_SOLUTION_ATTEMPT = 25;
  private static int CURRENT_NEXT_SOLUTION_ATTEMPT;

  private Reasoning() {}

  public static Reasoning getInstance() {
    if (Reasoning.instance == null) {
      Reasoning.instance = new Reasoning();
      Reasoning.reasonRelations = new HashMap<>();
      Reasoning.solutions = new ArrayList<>();
      Reasoning.reasonedTuples = new ArrayList<>();
    }

    return Reasoning.instance;
  }

  @Override
  public boolean start() throws Err {
    final File reasoningXml = new File(Reasoning.xmlPath);
    if (reasoningXml.exists()) {
      reasoningXml.delete();
    }
    final File reasoningAls = new File(Reasoning.alsPath);
    if (reasoningAls.exists()) {
      reasoningAls.delete();
    }

    final InstanceTranslator4Reasoning instanceTranslator =
        new InstanceTranslator4Reasoning(Reasoning.baseFileDirectory, Reasoning.alsPath);
    instanceTranslator.translate();
    Reasoning.reasonRelations = instanceTranslator.getReasonRelations();

    final AlloySolutionFinder parser = new AlloySolutionFinder(Reasoning.alsPath);
    final A4Solution solution = parser.find();

    if (solution == null || !solution.satisfiable()) {
      return false;
    }

    solution.writeXML(Reasoning.xmlPath);
    parse(Reasoning.xmlPath);
    Reasoning.solutions.add(solution);
    Reasoning.currentSolutionIndex = 0;
    Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT = 0;

    return reasoning(RUN_TYPE.START);
  }

  @Override
  public boolean next() throws Err {
    A4Solution solution;
    if (Reasoning.solutions.size() == Reasoning.currentSolutionIndex + 1) {
      solution = Reasoning.solutions.get(Reasoning.currentSolutionIndex).next();
      if (solution.equals(Reasoning.solutions.get(Reasoning.currentSolutionIndex))) {
        return false;
      } else if (solution.satisfiable()) {
        Reasoning.solutions.add(solution);
        Reasoning.currentSolutionIndex++;
      } else {
        return false;
      }
    } else {
      solution = Reasoning.solutions.get(Reasoning.currentSolutionIndex + 1);
      Reasoning.currentSolutionIndex++;
    }

    solution.writeXML(Reasoning.xmlPath);
    parse(Reasoning.xmlPath);

    return reasoning(RUN_TYPE.NEXT);
  }

  @Override
  public boolean previous() throws Err {
    A4Solution solution;
    if (Reasoning.currentSolutionIndex == 0) {
      return false;
    } else {
      solution = Reasoning.solutions.get(Reasoning.currentSolutionIndex - 1);
      Reasoning.currentSolutionIndex--;
    }

    solution.writeXML(Reasoning.xmlPath);
    parse(Reasoning.xmlPath);

    return reasoning(RUN_TYPE.PREVIOUS);
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

  private void deleteOldReasoning(final RUN_TYPE runType) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    int solutionNumber = runType == RUN_TYPE.NEXT ? Reasoning.currentSolutionIndex - 1
        : runType == RUN_TYPE.PREVIOUS ? Reasoning.currentSolutionIndex + 1 : -1;
    solutionNumber = solutionNumber >= Reasoning.reasonedTuples.size() ? -1 : solutionNumber;
    if (solutionNumber == -1) {
      return;
    }

    final Iterator<Entry<Integer, List<TupleType>>> oldReasonedTuplesIterator =
        Reasoning.reasonedTuples.get(solutionNumber).entrySet().iterator();
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

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  @Override
  public void finish() {
    Reasoning.solutions.clear();
    Reasoning.currentSolutionIndex = 0;
    Reasoning.reasonRelations.clear();
    Reasoning.reasonedTuples.clear();
  }

  public DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(Reasoning.xmlPath));
    } catch (final IOException e) {
      return null;
    }
    if (list == null || list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  private boolean reasoning(final RUN_TYPE runType) throws Err {
    deleteOldReasoning(runType);

    int reasonedTupleCount = 0;
    if (Reasoning.solutions.size() > Reasoning.reasonedTuples.size()) {

      final Map<Integer, List<TupleType>> newReasonedTuples = findReasonedTuples();
      Reasoning.reasonedTuples.add(newReasonedTuples);

      if (!isValidAndUniqueReason(newReasonedTuples)) {
        if (Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT > Reasoning.MAX_NEXT_SOLUTION_ATTEMPT) {
          final boolean rollBackSucceed = rollBackNextAttemption(false);
          if (rollBackSucceed) {
            final Map<Integer, List<TupleType>> unacceptedTupleTypes = filterAcceptedTupleTypes(
                Reasoning.reasonedTuples.get(Reasoning.currentSolutionIndex));
            writeReasonedTupleTypes(unacceptedTupleTypes);
            reasonedTupleCount = calcReasonedTupleCount(unacceptedTupleTypes);
          }
          return false;
        }
        Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT++;
        return next();
      } else {
        if (Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT > 0) {
          rollBackNextAttemption(true);
        }
        writeReasonedTupleTypes(newReasonedTuples);
        reasonedTupleCount = calcReasonedTupleCount(newReasonedTuples);
      }
    } else {
      final Map<Integer, List<TupleType>> existingReasonedTuples =
          Reasoning.reasonedTuples.get(Reasoning.currentSolutionIndex);
      if (!isValidAndUniqueReason(existingReasonedTuples)) {
        if (runType.equals(RUN_TYPE.NEXT)) {
          return next();
        } else if (runType.equals(RUN_TYPE.PREVIOUS)) {
          return previous();
        }
      }
      writeReasonedTupleTypes(existingReasonedTuples);
      reasonedTupleCount = calcReasonedTupleCount(existingReasonedTuples);
    }

    JOptionPane.showMessageDialog(null,
        "Reasoning on relations successfully completed.\nReasoned relation count: "
            + reasonedTupleCount,
            "Reasoning on Relations", JOptionPane.WARNING_MESSAGE);
    return true;
  }

  /**
   * filters accepted tupleTypes and returns unaccepted ones.
   *
   * @param newReasonedTuples
   * @return
   */
  private Map<Integer, List<TupleType>> filterAcceptedTupleTypes(
      final Map<Integer, List<TupleType>> newReasonedTuples) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    final Map<Integer, List<TupleType>> unacceptedTupleTypes = new HashMap<>();

    final Iterator<FieldType> fieldIterator =
        documentRoot.getAlloy().getInstance().getField().iterator();
    while (fieldIterator.hasNext()) {
      final FieldType oldFieldType = fieldIterator.next();
      final int fieldId = oldFieldType.getID();
      final List<TupleType> newTupleTypes = newReasonedTuples.get(fieldId);
      if (newTupleTypes != null) {
        final List<TupleType> unacceptedTupleTypesList = new ArrayList<>();
        for (final TupleType newTupleType : newTupleTypes) {
          if (!isTupleAccepted(fieldId, newTupleType)) { // IF REASONED TUPLE IS NOT ACCEPTED DURING
            // ANALYSIS.
            unacceptedTupleTypesList.add(newTupleType);
          }
        }
        unacceptedTupleTypes.put(fieldId, unacceptedTupleTypesList);
      }
    }

    return unacceptedTupleTypes;
  }

  /**
   * checks if tupleType is accepted in persistence file.
   *
   * @param fieldId
   * @param tupleType
   * @return
   */
  private boolean isTupleAccepted(final int fieldId, final TupleType tupleType) {
    return AlloyUtilities.getDocumentRoot().getAlloy().getInstance().getField().stream()
        .filter(f -> f.getID() == fieldId).findFirst().get().getTuple().stream()
        .anyMatch(t -> (t.getAtom().get(0).getLabel().equals(tupleType.getAtom().get(0).getLabel())
            && t.getAtom().get(1).getLabel().equals(tupleType.getAtom().get(1).getLabel())));
  }

  private void writeReasonedTupleTypes(final Map<Integer, List<TupleType>> newReasonedTuples) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final Iterator<FieldType> fieldIterator =
        documentRoot.getAlloy().getInstance().getField().iterator();
    while (fieldIterator.hasNext()) {
      final FieldType oldFieldType = fieldIterator.next();
      final int fieldId = oldFieldType.getID();
      final List<TupleType> newTupleTypes = newReasonedTuples.get(fieldId);
      if (newTupleTypes != null) {
        oldFieldType.getTuple().addAll(newTupleTypes);
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  private boolean rollBackNextAttemption(final boolean lastSolutionIsValid) {
    final int lastSolutionIndex = Reasoning.solutions.size() - 1;
    int validSolutionIndex = lastSolutionIsValid ? lastSolutionIndex
        : lastSolutionIndex - Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT - 1;
    Reasoning.currentSolutionIndex =
        lastSolutionIsValid ? lastSolutionIndex - Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT
            : lastSolutionIndex - Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT - 1;
    Reasoning.CURRENT_NEXT_SOLUTION_ATTEMPT = 0;

    validSolutionIndex = validSolutionIndex > 0 ? validSolutionIndex : 0;
    Reasoning.currentSolutionIndex =
        Reasoning.currentSolutionIndex > 0 ? Reasoning.currentSolutionIndex : 0;

        if (Reasoning.reasonedTuples.get(validSolutionIndex).size() == 0) {
          finish();
          return false;
        }

        Reasoning.solutions.set(Reasoning.currentSolutionIndex,
            Reasoning.solutions.get(validSolutionIndex));
        Reasoning.reasonedTuples.set(Reasoning.currentSolutionIndex,
            Reasoning.reasonedTuples.get(validSolutionIndex));

        for (int i = lastSolutionIndex; i > Reasoning.currentSolutionIndex; i--) {
          Reasoning.solutions.remove(i);
          Reasoning.reasonedTuples.remove(i);
        }
        return true;
  }

  private int calcReasonedTupleCount(final Map<Integer, List<TupleType>> newReasonedTuples) {
    int reasonedTupleCount = 0;
    for (final Entry<Integer, List<TupleType>> entry : newReasonedTuples.entrySet()) {
      reasonedTupleCount += entry.getValue().size();
    }
    return reasonedTupleCount;
  }

  private Map<Integer, List<TupleType>> findReasonedTuples() throws Err {
    final DocumentRoot documentRootReasoning = getDocumentRoot();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();

    final Map<Integer, List<TupleType>> newReasonedTuples = new HashMap<>();

    for (final FieldType fieldType_R : documentRootReasoning.getAlloy().getInstance().getField()) {
      for (final FieldType fieldType_O : documentRootOriginal.getAlloy().getInstance().getField()) {
        if (!fieldType_R.getLabel().equals(fieldType_O.getLabel())) {
          continue;
        }

        final int sourceId_R = fieldType_R.getParentID();
        final String sourceSigName_R =
            AlloyUtilities.getSigNameById(sourceId_R, documentRootReasoning);
        if (!Reasoning.reasonRelations.containsKey(sourceSigName_R)
            || !Reasoning.reasonRelations.get(sourceSigName_R).contains(fieldType_R.getLabel())) {
          continue;
        }

        final int sourceId_O = fieldType_O.getParentID();
        final String sourceSigName_O =
            AlloyUtilities.getSigNameById(sourceId_O, documentRootOriginal);
        if (!Reasoning.reasonRelations.containsKey(sourceSigName_O)
            || !Reasoning.reasonRelations.get(sourceSigName_O).contains(fieldType_O.getLabel())) {
          continue;
        }

        if (!sourceSigName_O.equals(sourceSigName_R)) {
          continue;
        }

        if (fieldType_O.getTuple().size() == fieldType_R.getTuple().size()) {
          continue;
        }

        for (final TupleType tuple_R : fieldType_R.getTuple()) {
          AtomType atomType0_R = getOriginalAtomType(tuple_R.getAtom().get(0).getLabel());
          final AtomType atomType1_R = getOriginalAtomType(tuple_R.getAtom().get(1).getLabel());

          if (atomType0_R == null || atomType1_R == null) {
            continue;
          }

          boolean exists = false;
          for (final TupleType tuple_O : fieldType_O.getTuple()) {
            if (atomType0_R.getLabel().equals(tuple_O.getAtom().get(0).getLabel())
                && atomType1_R.getLabel().equals(tuple_O.getAtom().get(1).getLabel())) {
              exists = true;
              break;
            }
          }

          if (!exists || fieldType_O.getTuple().size() == 0) {
            final TupleType tupleType_O = persistenceFactory.eINSTANCE.createTupleType();
            if (atomType0_R.equals(atomType1_R)) {
              atomType0_R = AlloyUtilities.cloneAtomType(atomType0_R);
            }
            tupleType_O.getAtom().addAll(Arrays.asList(new AtomType[] {atomType0_R, atomType1_R}));
            tupleType_O.setReasoned(true);

            if (newReasonedTuples.get(fieldType_O.getID()) == null) {
              newReasonedTuples.put(fieldType_O.getID(),
                  new ArrayList<>(Arrays.asList(tupleType_O)));
            } else {
              newReasonedTuples.get(fieldType_O.getID()).add(tupleType_O);
            }
          }
        }
      }
    }
    return newReasonedTuples;
  }

  private boolean isValidAndUniqueReason(final Map<Integer, List<TupleType>> reasonedTuples) {
    final Map<Integer, List<TupleType>> unacceptedTupleTypes =
        filterAcceptedTupleTypes(reasonedTuples);
    final int unacceptedReasonedTupleCount = calcReasonedTupleCount(unacceptedTupleTypes);

    if (unacceptedReasonedTupleCount == 0) { // 1
      return false;
    }
    // dont swap 1 and 2
    if (Reasoning.solutions.size() == 1) { // 2
      return true;
    }

    if (getUnmatchedExistingReasoningCount(unacceptedTupleTypes) == Reasoning.reasonedTuples.size()
        - 1) {
      return true;
    }
    return false;
  }

  private int getUnmatchedExistingReasoningCount(
      final Map<Integer, List<TupleType>> reasonedTuples) {
    int unMatchedExistingReasoningCount = 0;
    for (int solutionNumber = 0; solutionNumber < Reasoning.reasonedTuples
        .size(); solutionNumber++) {
      if (solutionNumber == Reasoning.currentSolutionIndex) {
        continue;
      }
      final Map<Integer, List<TupleType>> existingReasonedTuples =
          Reasoning.reasonedTuples.get(solutionNumber);
      for (final Entry<Integer, List<TupleType>> newReasonsedTuplesEntry : reasonedTuples
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
            final String atom0Label_New = tupleType_New.getAtom().get(0).getLabel();
            final String atom1Label_New = tupleType_New.getAtom().get(1).getLabel();

            final boolean anyMatchOldTuple = tupleList_Old.stream().anyMatch(
                tupleType_Old -> tupleType_Old.getAtom().get(0).getLabel().equals(atom0Label_New)
                && tupleType_Old.getAtom().get(1).getLabel().equals(atom1Label_New));

            if (anyMatchOldTuple) {
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
    return unMatchedExistingReasoningCount;
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
