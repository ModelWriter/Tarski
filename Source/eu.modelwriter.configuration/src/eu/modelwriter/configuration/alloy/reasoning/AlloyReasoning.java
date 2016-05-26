package eu.modelwriter.configuration.alloy.reasoning;

import java.util.ArrayList;
import java.util.List;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class AlloyReasoning {

  String filename = InstanceTranslatorReasoning.baseFileDirectory + "ValidateFile.als";

  public void reasoning() {
    AlloyValidatorReasoning.validate();
    AlloyParserForReasoning parser = new AlloyParserForReasoning(filename);

    DocumentRoot documentRootReasoning = parser.parse();
    DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();

    for (FieldType fieldType_R : documentRootReasoning.getAlloy().getInstance().getField()) {
      for (FieldType fieldType_O : documentRootOriginal.getAlloy().getInstance().getField()) {

        if (fieldType_R.getLabel().equals(fieldType_O.getLabel())) {
          if (fieldType_O.getTuple().size() != fieldType_R.getTuple().size()) {
            for (TupleType tuple_R : fieldType_R.getTuple()) {
              AtomType atomType0_R = getOriginalAtomType(tuple_R.getAtom().get(0).getLabel());
              AtomType atomType1_R = getOriginalAtomType(tuple_R.getAtom().get(1).getLabel());
              List<TupleType> tuples = new ArrayList<>();
              boolean isDifferent = false;
              for (TupleType tuple_O : fieldType_O.getTuple()) {
                if (!(atomType0_R.getLabel().equals(tuple_O.getAtom().get(0).getLabel())
                    && atomType1_R.getLabel().equals(tuple_O.getAtom().get(1).getLabel()))) {
                  isDifferent = true;
                }
              }
              if (isDifferent || fieldType_O.getTuple().size() == 0) {
                TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
                tupleType.getAtom().add(atomType0_R);
                tupleType.getAtom().add(atomType1_R);
                tupleType.setReasoned(true);

                tuples.add(tupleType);
              }
              fieldType_O.getTuple().addAll(tuples);
            }
          }
        }
      }

    }

    AlloyUtilities.writeDocumentRoot(documentRootOriginal);
  }

  private AtomType getOriginalAtomType(String name_R) {

    String name = name_R.substring(0, name_R.indexOf("_"));
    int id = Integer.parseInt(name_R.substring(name_R.indexOf("_") + 1, name_R.indexOf("$")));

    return AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
  }

  public static void main(String[] args) {
    AlloyReasoning alloyReasoning = new AlloyReasoning();

    alloyReasoning.reasoning();
  }

}
