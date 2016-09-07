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
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;

public class AlloyNextSolutionReasoning {

  private A4Solution ans;
  private Map<String, List<String>> reasonRelations;
  private static AlloyNextSolutionReasoning instance;
  private Map<Integer, List<TupleType>> oldReasons;
  String xmlFileLoc = InstanceTranslatorReasoning.baseFileDirectory + "reasoning.xml";

  public static AlloyNextSolutionReasoning getInstance() {
    if (AlloyNextSolutionReasoning.instance == null) {
      AlloyNextSolutionReasoning.instance = new AlloyNextSolutionReasoning();
      AlloyNextSolutionReasoning.instance.oldReasons = new HashMap<>();
    }

    return AlloyNextSolutionReasoning.instance;
  }

  public boolean next() {
    if (!parse()) {
      ans = null;
      reasonRelations = null;
      return false;
    }
    removeOldReasoning();
    return reasoning();
  }

  private boolean parse() {
    if (ans == null || reasonRelations == null) {
      return false;
    }

    try {
      final A4Solution previousAns = ans;
      ans = ans.next();
      if (ans.satisfiable() && !ans.equals(previousAns)) {
        ans.writeXML(xmlFileLoc);

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
      } else {
        ans = null;
        reasonRelations = null;
        JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Next Solution",
            JOptionPane.INFORMATION_MESSAGE);
      }
    } catch (final Err e1) {
      e1.printStackTrace();
    }
    return false;
  }

  private void removeOldReasoning() {
    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final Iterator<Entry<Integer, List<TupleType>>> iterator = oldReasons.entrySet().iterator();
    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();
    while (iterator.hasNext()) {
      final Entry<Integer, List<TupleType>> entry = iterator.next();
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

    oldReasons.clear();
  }

  public void finishNext() {
    ans = null;
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

  public A4Solution getAns() {
    return ans;
  }

  public void setAns(final A4Solution ans) {
    this.ans = ans;
  }

  public Map<Integer, List<TupleType>> getOldReasons() {
    return oldReasons;
  }

  public void setReasonRelations(final Map<String, List<String>> reasonRelations) {
    this.reasonRelations = reasonRelations;
  }

  private boolean reasoning() {
    final DocumentRoot documentRootReasoning = getDocumentRoot();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootReasoning == null) {
      JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }

    reason(documentRootOriginal, documentRootReasoning);

    return true;
  }

  private void reason(final DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootReasoning) {
    int discoveredRelationCount = 0;
    for (final FieldType fieldType_R : documentRootReasoning.getAlloy().getInstance().getField()) {
      for (final FieldType fieldType_O : documentRootOriginal.getAlloy().getInstance().getField()) {
        if (!fieldType_R.getLabel().equals(fieldType_O.getLabel())) {
          continue;
        }

        final int sourceId_R = fieldType_R.getParentID();
        final String sourceSigName_R =
            AlloyUtilities.getSigNameById(sourceId_R, documentRootReasoning);
        if (!reasonRelations.containsKey(sourceSigName_R)
            || !reasonRelations.get(sourceSigName_R).contains(fieldType_R.getLabel())) {
          continue;
        }

        final int sourceId_O = fieldType_O.getParentID();
        final String sourceSigName_O =
            AlloyUtilities.getSigNameById(sourceId_O, documentRootOriginal);
        if (!reasonRelations.containsKey(sourceSigName_O)
            || !reasonRelations.get(sourceSigName_O).contains(fieldType_O.getLabel())) {
          continue;
        }

        if (!sourceSigName_O.equals(sourceSigName_R)) {
          continue;
        }

        if (fieldType_O.getTuple().size() == fieldType_R.getTuple().size()) {
          continue;
        }

        for (final TupleType tuple_R : fieldType_R.getTuple()) {
          final AtomType atomType0_R = getOriginalAtomType(tuple_R.getAtom().get(0).getLabel());
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
            final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
            tupleType.getAtom().add(atomType0_R);
            tupleType.getAtom().add(atomType1_R);
            tupleType.setReasoned(true);

            if (AlloyNextSolutionReasoning.getInstance().getOldReasons()
                .get(fieldType_O.getID()) == null) {
              AlloyNextSolutionReasoning.getInstance().getOldReasons().put(fieldType_O.getID(),
                  new ArrayList<>(Arrays.asList(tupleType)));
            } else {
              AlloyNextSolutionReasoning.getInstance().getOldReasons().get(fieldType_O.getID())
              .add(tupleType);
            }

            discoveredRelationCount++;
            fieldType_O.getTuple().add(tupleType);
          }
        }
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRootOriginal);

    JOptionPane.showMessageDialog(null,
        "Discovering on relations successfully completed.\nDiscovered relation count: "
            + discoveredRelationCount,
            "Discovering on Relations", JOptionPane.WARNING_MESSAGE);
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
