package eu.modelwriter.configuration.alloy.reasoning;

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
import eu.modelwriter.configuration.alloy.RUN_TYPE;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;

public class AlloyOtherSolutionReasoning {

  private static AlloyOtherSolutionReasoning instance;
  private static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter reasoning ".replace(" ", System.getProperty("file.separator"));
  private static final String alsPath =
      AlloyOtherSolutionReasoning.baseFileDirectory + "reasoning.als";
  private static final String xmlPath =
      AlloyOtherSolutionReasoning.baseFileDirectory + "reasoning.xml";
  private static Map<String, List<String>> reasonRelations;
  private static List<A4Solution> solutions;
  private static List<Map<Integer, List<TupleType>>> reasonedTuples;
  private static int currentSolutionIndex;
  private static int MAX_NEXT_SOLUTION_ATTEMPT = 25;
  private static int CURRENT_NEXT_SOLUTION_ATTEMPT;

  public static AlloyOtherSolutionReasoning getInstance() {
    if (AlloyOtherSolutionReasoning.instance == null) {
      AlloyOtherSolutionReasoning.instance = new AlloyOtherSolutionReasoning();
      AlloyOtherSolutionReasoning.reasonRelations = new HashMap<>();
      AlloyOtherSolutionReasoning.solutions = new ArrayList<>();
      AlloyOtherSolutionReasoning.reasonedTuples = new ArrayList<>();
    }

    return AlloyOtherSolutionReasoning.instance;
  }

  public boolean start() throws Err {
    final File reasoningXml = new File(AlloyOtherSolutionReasoning.xmlPath);
    if (reasoningXml.exists()) {
      reasoningXml.delete();
    }
    final File reasoningAls = new File(AlloyOtherSolutionReasoning.alsPath);
    if (reasoningAls.exists()) {
      reasoningAls.delete();
    }

    final InstanceTranslatorReasoning instanceTranslator = new InstanceTranslatorReasoning(
        AlloyOtherSolutionReasoning.baseFileDirectory, AlloyOtherSolutionReasoning.alsPath);
    instanceTranslator.translate();
    AlloyOtherSolutionReasoning.reasonRelations = instanceTranslator.getReasonRelations();

    if (!AlloyValidatorReasoning.validate(AlloyOtherSolutionReasoning.alsPath)) {
      return false;
    }

    final AlloyParserForReasoning parser =
        new AlloyParserForReasoning(AlloyOtherSolutionReasoning.alsPath);
    final A4Solution solution = parser.parse();
    if (solution.satisfiable()) {
      solution.writeXML(AlloyOtherSolutionReasoning.xmlPath);
      parse(AlloyOtherSolutionReasoning.xmlPath);
      AlloyOtherSolutionReasoning.solutions.add(solution);
      AlloyOtherSolutionReasoning.currentSolutionIndex = 0;
      AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT = 0;
    }

    return reasoning(RUN_TYPE.START);
  }

  public boolean next() throws Err {
    A4Solution solution;
    if (AlloyOtherSolutionReasoning.solutions
        .size() == AlloyOtherSolutionReasoning.currentSolutionIndex + 1) {
      solution = AlloyOtherSolutionReasoning.solutions
          .get(AlloyOtherSolutionReasoning.currentSolutionIndex).next();
      if (solution.equals(AlloyOtherSolutionReasoning.solutions
          .get(AlloyOtherSolutionReasoning.currentSolutionIndex))) {
        return false;
      } else if (solution.satisfiable()) {
        AlloyOtherSolutionReasoning.solutions.add(solution);
        AlloyOtherSolutionReasoning.currentSolutionIndex++;
      } else {
        return false;
      }
    } else {
      solution = AlloyOtherSolutionReasoning.solutions
          .get(AlloyOtherSolutionReasoning.currentSolutionIndex + 1);
      AlloyOtherSolutionReasoning.currentSolutionIndex++;
    }

    solution.writeXML(AlloyOtherSolutionReasoning.xmlPath);
    parse(AlloyOtherSolutionReasoning.xmlPath);

    return reasoning(RUN_TYPE.NEXT);
  }

  public boolean previous() throws Err {
    A4Solution solution;
    if (AlloyOtherSolutionReasoning.currentSolutionIndex == 0) {
      return false;
    } else {
      solution = AlloyOtherSolutionReasoning.solutions
          .get(AlloyOtherSolutionReasoning.currentSolutionIndex - 1);
      AlloyOtherSolutionReasoning.currentSolutionIndex--;
    }

    solution.writeXML(AlloyOtherSolutionReasoning.xmlPath);
    parse(AlloyOtherSolutionReasoning.xmlPath);

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

  private void removeOldReasoning(final RUN_TYPE runType) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();
    int solutionNumber = runType == RUN_TYPE.NEXT
        ? AlloyOtherSolutionReasoning.currentSolutionIndex - 1
            : runType == RUN_TYPE.PREVIOUS ? AlloyOtherSolutionReasoning.currentSolutionIndex + 1 : -1;
    solutionNumber =
        solutionNumber >= AlloyOtherSolutionReasoning.reasonedTuples.size() ? -1 : solutionNumber;
        if (solutionNumber == -1) {
          return;
        }

        final Iterator<Entry<Integer, List<TupleType>>> oldReasonedTuplesIterator =
            AlloyOtherSolutionReasoning.reasonedTuples.get(solutionNumber).entrySet().iterator();
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

        final int reasonedTupleCount =
            calcReasonedTupleCount(AlloyOtherSolutionReasoning.reasonedTuples.get(solutionNumber));
        MarkerFactory.rewindId(reasonedTupleCount, documentRoot);

        AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  public void finish() {
    AlloyOtherSolutionReasoning.solutions.clear();
    AlloyOtherSolutionReasoning.currentSolutionIndex = 0;
    AlloyOtherSolutionReasoning.reasonRelations.clear();
    AlloyOtherSolutionReasoning.reasonedTuples.clear();
  }

  public DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    List list = null;
    try {
      list = modelIO.read(URI.createFileURI(AlloyOtherSolutionReasoning.xmlPath));
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
    return AlloyOtherSolutionReasoning.solutions.size() == 0 ? null
        : AlloyOtherSolutionReasoning.solutions
        .get(AlloyOtherSolutionReasoning.currentSolutionIndex);
  }

  private boolean reasoning(final RUN_TYPE runType) throws Err {
    removeOldReasoning(runType);

    final DocumentRoot documentRootReasoning = getDocumentRoot();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();

    int reasonedTupleCount = 0;
    if (AlloyOtherSolutionReasoning.solutions.size() > AlloyOtherSolutionReasoning.reasonedTuples
        .size()) {
      final Map<Integer, List<TupleType>> newReasonedTuples =
          findReasonedTuples(documentRootOriginal, documentRootReasoning);
      reasonedTupleCount = calcReasonedTupleCount(newReasonedTuples);
      AlloyOtherSolutionReasoning.reasonedTuples.add(newReasonedTuples);
      if (reasonedTupleCount == 0 || isRequiredPass(reasonedTupleCount, newReasonedTuples)) {
        if (AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT > AlloyOtherSolutionReasoning.MAX_NEXT_SOLUTION_ATTEMPT) {
          final boolean rollBackSucceed = rollBackNextAttemption(false);
          if (rollBackSucceed) {
            addNewReasoning(AlloyOtherSolutionReasoning.reasonedTuples
                .get(AlloyOtherSolutionReasoning.currentSolutionIndex));
          }
          return false;
        }
        AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT++;
        return next();
      } else {
        if (AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT > 0) {
          rollBackNextAttemption(true);
        }
        addNewReasoning(newReasonedTuples);
      }
    } else {
      final Map<Integer, List<TupleType>> existingReasonedTuples =
          AlloyOtherSolutionReasoning.reasonedTuples
          .get(AlloyOtherSolutionReasoning.currentSolutionIndex);
      reasonedTupleCount = calcReasonedTupleCount(existingReasonedTuples);
      addNewReasoning(existingReasonedTuples);
    }

    JOptionPane.showMessageDialog(null,
        "Reasoning on relations successfully completed.\nReasoned relation count: "
            + reasonedTupleCount,
            "Reasoning on Relations", JOptionPane.WARNING_MESSAGE);
    return true;
  }

  private boolean rollBackNextAttemption(final boolean lastSolutionIsValid) {
    final int lastSolutionIndex = AlloyOtherSolutionReasoning.solutions.size() - 1;
    int validSolutionIndex = lastSolutionIsValid ? lastSolutionIndex
        : lastSolutionIndex - AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT - 1;
    AlloyOtherSolutionReasoning.currentSolutionIndex = lastSolutionIsValid
        ? lastSolutionIndex - AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT
            : lastSolutionIndex - AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT - 1;
    AlloyOtherSolutionReasoning.CURRENT_NEXT_SOLUTION_ATTEMPT = 0;

    validSolutionIndex = validSolutionIndex > 0 ? validSolutionIndex : 0;
    AlloyOtherSolutionReasoning.currentSolutionIndex =
        AlloyOtherSolutionReasoning.currentSolutionIndex > 0
        ? AlloyOtherSolutionReasoning.currentSolutionIndex : 0;

        if (AlloyOtherSolutionReasoning.reasonedTuples.get(validSolutionIndex).size() == 0) {
          finish();
          return false;
        }

        AlloyOtherSolutionReasoning.solutions.set(AlloyOtherSolutionReasoning.currentSolutionIndex,
            AlloyOtherSolutionReasoning.solutions.get(validSolutionIndex));
        AlloyOtherSolutionReasoning.reasonedTuples.set(AlloyOtherSolutionReasoning.currentSolutionIndex,
            AlloyOtherSolutionReasoning.reasonedTuples.get(validSolutionIndex));

        for (int i = lastSolutionIndex; i > AlloyOtherSolutionReasoning.currentSolutionIndex; i--) {
          AlloyOtherSolutionReasoning.solutions.remove(i);
          AlloyOtherSolutionReasoning.reasonedTuples.remove(i);
        }
        return true;
  }

  private void addNewReasoning(final Map<Integer, List<TupleType>> newReasonedTuples) {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final Iterator<FieldType> fieldIterator =
        documentRoot.getAlloy().getInstance().getField().iterator();
    while (fieldIterator.hasNext()) {
      final FieldType fieldType = fieldIterator.next();
      final List<TupleType> tuples = newReasonedTuples.get(fieldType.getID());
      if (tuples != null) {
        fieldType.getTuple().addAll(tuples);
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);
  }

  private int calcReasonedTupleCount(final Map<Integer, List<TupleType>> newReasonedTuples) {
    int reasonedTupleCount = 0;
    for (final Entry<Integer, List<TupleType>> entry : newReasonedTuples.entrySet()) {
      reasonedTupleCount += entry.getValue().size();
    }
    return reasonedTupleCount;
  }

  private Map<Integer, List<TupleType>> findReasonedTuples(final DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootReasoning) throws Err {
    final Map<Integer, List<TupleType>> newReasonedTuples = new HashMap<>();

    for (final FieldType fieldType_R : documentRootReasoning.getAlloy().getInstance().getField()) {
      for (final FieldType fieldType_O : documentRootOriginal.getAlloy().getInstance().getField()) {
        if (!fieldType_R.getLabel().equals(fieldType_O.getLabel())) {
          continue;
        }

        final int sourceId_R = fieldType_R.getParentID();
        final String sourceSigName_R =
            AlloyUtilities.getSigNameById(sourceId_R, documentRootReasoning);
        if (!AlloyOtherSolutionReasoning.reasonRelations.containsKey(sourceSigName_R)
            || !AlloyOtherSolutionReasoning.reasonRelations.get(sourceSigName_R)
            .contains(fieldType_R.getLabel())) {
          continue;
        }

        final int sourceId_O = fieldType_O.getParentID();
        final String sourceSigName_O =
            AlloyUtilities.getSigNameById(sourceId_O, documentRootOriginal);
        if (!AlloyOtherSolutionReasoning.reasonRelations.containsKey(sourceSigName_O)
            || !AlloyOtherSolutionReasoning.reasonRelations.get(sourceSigName_O)
            .contains(fieldType_O.getLabel())) {
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

  private boolean isRequiredPass(final int reasonedRelationCount,
      final Map<Integer, List<TupleType>> newReasonedTuples) {
    boolean requirePass = true;

    if (AlloyOtherSolutionReasoning.solutions.size() == 1) {
      return false;
    }

    int unMatchedExistingReasoningCount = 0;
    if (reasonedRelationCount > 0) {
      for (int solutionNumber = 0; solutionNumber < AlloyOtherSolutionReasoning.reasonedTuples
          .size(); solutionNumber++) {
        if (solutionNumber == AlloyOtherSolutionReasoning.currentSolutionIndex) {
          continue;
        }
        final Map<Integer, List<TupleType>> existingReasonedTuples =
            AlloyOtherSolutionReasoning.reasonedTuples.get(solutionNumber);
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
      if (unMatchedExistingReasoningCount == AlloyOtherSolutionReasoning.reasonedTuples.size()
          - 1) {
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
