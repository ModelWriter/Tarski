package eu.modelwriter.configuration.alloy.reasoning;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class AlloyReasoning {

  static String filename = InstanceTranslatorReasoning.baseFileDirectory + "reasoning.als";

  public boolean reasoning() {
    final File reasoningXml =
        new File(InstanceTranslatorReasoning.baseFileDirectory + "reasoning.xml");
    if (reasoningXml.exists()) {
      reasoningXml.delete();
    }
    final File reasoningAls =
        new File(InstanceTranslatorReasoning.baseFileDirectory + "reasoning.als");
    if (reasoningAls.exists()) {
      reasoningAls.delete();
    }

    if (!AlloyValidatorReasoning.validate()) {
      JOptionPane.showMessageDialog(null,
          "There is not any reasoning.\nBecause instance is inconsistent.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
      return false;
    }

    final AlloyParserForReasoning parser = new AlloyParserForReasoning(AlloyReasoning.filename);

    AlloyNextSolutionReasoning.getInstance()
    .setReasonRelations(AlloyValidatorReasoning.reasonRelations);

    final DocumentRoot documentRootReasoning = parser.parse();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootReasoning == null) {
      System.err.println("Document root on location " + AlloyReasoning.filename + " is NULL.");
      return false;
    }

    reason(documentRootOriginal, documentRootReasoning);

    return true;
  }

  private void reason(final DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootReasoning) {
    final Map<String, List<String>> reasonRelations = AlloyValidatorReasoning.reasonRelations;
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
