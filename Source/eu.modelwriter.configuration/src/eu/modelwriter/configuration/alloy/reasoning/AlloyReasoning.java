package eu.modelwriter.configuration.alloy.reasoning;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class AlloyReasoning {

  public static void main(final String[] args) {
    final AlloyReasoning alloyReasoning = new AlloyReasoning();

    alloyReasoning.reasoning();
  }

  String filename = InstanceTranslatorReasoning.baseFileDirectory + "reasoning.als";

  private AtomType getOriginalAtomType(final String name_R) {

    final String name = name_R.substring(0, name_R.indexOf("_"));
    final int id = Integer.parseInt(name_R.substring(name_R.indexOf("_") + 1, name_R.indexOf("$")));

    return AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
  }

  public void reasoning() {
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
    if (!AlloyValidator.validate()) {
      JOptionPane.showMessageDialog(null,
          "There is not any reasoning. Because instance is inconsistent.", "Reason on Relations",
          JOptionPane.INFORMATION_MESSAGE);
    }
    AlloyValidatorReasoning.validate();
    final List<String> reasonRelations = AlloyValidatorReasoning.reasonRelations;
    final AlloyParserForReasoning parser = new AlloyParserForReasoning(this.filename);

    AlloyNextSolution.getInstance().setReasonRelations(reasonRelations);

    final DocumentRoot documentRootReasoning = parser.parse();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootReasoning == null) {
      return;
    }

    int reasonCount = 0;
    for (final FieldType fieldType_R : documentRootReasoning.getAlloy().getInstance().getField()) {
      if (!reasonRelations.contains(fieldType_R.getLabel())) {
        continue;
      }
      for (final FieldType fieldType_O : documentRootOriginal.getAlloy().getInstance().getField()) {

        if (fieldType_R.getLabel().equals(fieldType_O.getLabel())) {
          if (fieldType_O.getTuple().size() != fieldType_R.getTuple().size()) {
            for (final TupleType tuple_R : fieldType_R.getTuple()) {
              final AtomType atomType0_R =
                  this.getOriginalAtomType(tuple_R.getAtom().get(0).getLabel());
              final AtomType atomType1_R =
                  this.getOriginalAtomType(tuple_R.getAtom().get(1).getLabel());
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
              if (AlloyNextSolution.getInstance().getOldReasons().get(fieldType_O) == null)
                AlloyNextSolution.getInstance().getOldReasons().put(fieldType_O, tuples);
              else
                AlloyNextSolution.getInstance().getOldReasons().get(fieldType_O).addAll(tuples);
              fieldType_O.getTuple().addAll(tuples);
            }
          }
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

}
