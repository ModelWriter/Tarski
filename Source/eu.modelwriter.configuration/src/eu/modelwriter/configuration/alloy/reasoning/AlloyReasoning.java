package eu.modelwriter.configuration.alloy.reasoning;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class AlloyReasoning {

  static String filename = InstanceTranslatorReasoning.baseFileDirectory + "reasoning.als";

  public void reasoning() {
    if (!AlloyValidator.validate()) {
      JOptionPane.showMessageDialog(null,
          "There is not any reasoning. Because instance is inconsistent.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (AlloyValidator.isCanceled) {
      return;
    }

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

    AlloyValidatorReasoning.validate();
    final Map<String, List<String>> reasonRelations = AlloyValidatorReasoning.reasonRelations;
    final AlloyParserForReasoning parser = new AlloyParserForReasoning(AlloyReasoning.filename);

    AlloyNextSolution.getInstance().setReasonRelations(reasonRelations);

    final DocumentRoot documentRootReasoning = parser.parse();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootReasoning == null) {
      JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
      return;
    }

    if (AlloyValidator.isCanceled) {
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
          final AtomType atomType0_R =
              AlloyReasoning.getOriginalAtomType(tuple_R.getAtom().get(0).getLabel());
          final AtomType atomType1_R =
              AlloyReasoning.getOriginalAtomType(tuple_R.getAtom().get(1).getLabel());

          if (atomType0_R == null || atomType1_R == null) {
            continue;
          }

          final List<TupleType> tuples = new ArrayList<>();
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

      if (AlloyValidator.isCanceled) {
        return;
      }

    }

    if (AlloyValidator.isCanceled) {
      return;
    }

    AlloyUtilities.writeDocumentRoot(documentRootOriginal);

    if (reasonCount == 0) {
      JOptionPane.showMessageDialog(null, "There is not any reasoning.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Successfully added " + reasonCount + " reason.",
          "Reason on Relations", JOptionPane.WARNING_MESSAGE);
    }
  }

  private static AtomType getOriginalAtomType(final String name_R) {
    if (name_R.contains("/")) {
      return null;
    }
    final String name = name_R.substring(0, name_R.indexOf("_"));
    final int id = Integer.parseInt(name_R.substring(name_R.indexOf("_") + 1, name_R.indexOf("$")));

    return AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
  }
}
