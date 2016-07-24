package eu.modelwriter.configuration.alloy.reasoning;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class AlloyNextSolution {

  private A4Solution ans;
  private Map<String, List<String>> reasonRelations;
  private static AlloyNextSolution alloyNextSolution;
  private Map<FieldType, List<TupleType>> oldReasons;
  String xmlFileLoc = InstanceTranslatorReasoning.baseFileDirectory + "reasoning.xml";

  public static AlloyNextSolution getInstance() {
    if (AlloyNextSolution.alloyNextSolution == null) {
      AlloyNextSolution.alloyNextSolution = new AlloyNextSolution();
      AlloyNextSolution.alloyNextSolution.oldReasons = new HashMap<>();
    }

    return AlloyNextSolution.alloyNextSolution;
  }

  public void next() {
    if (!this.parse()) {
      this.ans = null;
      this.reasonRelations = null;
      return;
    }
    this.removeOldReasoning();
    this.reasoning();
  }

  private boolean parse() {
    if (this.ans == null || this.reasonRelations == null) {
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
        this.reasonRelations = null;
        JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Next Solution",
            JOptionPane.INFORMATION_MESSAGE);
      }
    } catch (final Err e1) {
      e1.printStackTrace();
    }
    return false;
  }

  private void removeOldReasoning() {
    final Iterator<Entry<FieldType, List<TupleType>>> iterator =
        this.oldReasons.entrySet().iterator();

    final DocumentRoot documentRoot = AlloyUtilities.getDocumentRoot();

    final EList<FieldType> fieldTypes = documentRoot.getAlloy().getInstance().getField();

    while (iterator.hasNext()) {
      final Entry<FieldType, List<TupleType>> entry = iterator.next();

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

    this.oldReasons.clear();
  }

  private void reasoning() {
    final DocumentRoot documentRootReasoning = this.getDocumentRoot();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootReasoning == null) {
      return;
    }

    int reasonCount = 0;
    for (final FieldType fieldType_R : documentRootReasoning.getAlloy().getInstance().getField()) {
      for (final FieldType fieldType_O : documentRootOriginal.getAlloy().getInstance().getField()) {
        if (!fieldType_R.getLabel().equals(fieldType_O.getLabel())) {
          continue;
        }

        final int sourceId_R = fieldType_R.getParentID();
        final String sourceSigName_R =
            AlloyUtilities.getSigNameById(sourceId_R, documentRootReasoning);
        if (!this.reasonRelations.containsKey(sourceSigName_R)
            || !this.reasonRelations.get(sourceSigName_R).contains(fieldType_R.getLabel())) {
          continue;
        }

        final int sourceId_O = fieldType_O.getParentID();
        final String sourceSigName_O =
            AlloyUtilities.getSigNameById(sourceId_O, documentRootOriginal);
        if (!this.reasonRelations.containsKey(sourceSigName_O)
            || !this.reasonRelations.get(sourceSigName_O).contains(fieldType_O.getLabel())) {
          continue;
        }

        if (!sourceSigName_O.equals(sourceSigName_R)) {
          continue;
        }

        if (fieldType_O.getTuple().size() == fieldType_R.getTuple().size()) {
          continue;
        }

        for (final TupleType tuple_R : fieldType_R.getTuple()) {
          final AtomType atomType0_R =
              this.getOriginalAtomType(tuple_R.getAtom().get(0).getLabel());
          final AtomType atomType1_R =
              this.getOriginalAtomType(tuple_R.getAtom().get(1).getLabel());

          if (atomType0_R == null || atomType1_R == null) {
            continue;
          }

          final List<TupleType> tuples = new ArrayList<>();
          boolean exists = false;
          for (final TupleType tuple_O : fieldType_O.getTuple()) {
            if (atomType0_R.getLabel().equals(tuple_O.getAtom().get(0).getLabel())
                && atomType1_R.getLabel().equals(tuple_O.getAtom().get(1).getLabel())) {
              exists = true;
            }
          }

          if (!exists || fieldType_O.getTuple().size() == 0) {
            final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
            tupleType.getAtom().add(atomType0_R);
            tupleType.getAtom().add(atomType1_R);
            tupleType.setReasoned(true);

            tuples.add(tupleType);
            reasonCount++;
          }
          if (AlloyNextSolution.getInstance().getOldReasons().get(fieldType_O) == null) {
            AlloyNextSolution.getInstance().getOldReasons().put(fieldType_O, tuples);
          } else {
            AlloyNextSolution.getInstance().getOldReasons().get(fieldType_O).addAll(tuples);
          }
          fieldType_O.getTuple().addAll(tuples);
        }
      }
    }

    if (reasonCount == 0) {
      JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Successfully added " + reasonCount + " reason.",
          "Reason on Relations", JOptionPane.WARNING_MESSAGE);
    }
    AlloyUtilities.writeDocumentRoot(documentRootOriginal);
  }

  private AtomType getOriginalAtomType(final String name_R) {
    if (name_R.contains("/")) {
      return null;
    }
    final String name = name_R.substring(0, name_R.indexOf("_"));
    final int id = Integer.parseInt(name_R.substring(name_R.indexOf("_") + 1, name_R.indexOf("$")));

    return AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
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

  public Map<String, List<String>> getReasonRelations() {
    return this.reasonRelations;
  }

  public void setReasonRelations(final Map<String, List<String>> reasonRelations) {
    this.reasonRelations = reasonRelations;
  }

  public Map<FieldType, List<TupleType>> getOldReasons() {
    return this.oldReasons;
  }

  public void setOldReasons(final Map<FieldType, List<TupleType>> oldReasons) {
    this.oldReasons = oldReasons;
  }
}
