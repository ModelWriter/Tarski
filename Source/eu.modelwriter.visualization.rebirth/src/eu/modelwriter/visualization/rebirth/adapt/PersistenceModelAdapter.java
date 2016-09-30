package eu.modelwriter.visualization.rebirth.adapt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.exception.InvalidArityException;
import eu.modelwriter.model.exception.NoSuchModelElementException;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;

public class PersistenceModelAdapter implements IModelAdapter {
  public static final PersistenceModelAdapter instance = new PersistenceModelAdapter();

  private PersistenceModelAdapter() {}

  @Override
  public ModelManager adapt(final Object input) {
    final DocumentRoot documentRoot = (DocumentRoot) input;
    final ModelManager modelManager = new ModelManager();
    final Map<String, String> atomTypeLabel2AtomID = new HashMap<>();
    try {
      for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
        if (sigType.getID() > 3) {
          final String label = sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);
          final String relationID = modelManager.addRelation(label, 1);
          for (int i = 0; i < sigType.getAtom().size(); i++) {
            final AtomType atomType = sigType.getAtom().get(i);
            final String atomID = modelManager.addAtom(new ArrayList<>(Arrays.asList(relationID)),
                label + i,
                null, atomType.getBound() == null ? BOUND.LOWER_BOUND
                    : BOUND.valueOf(atomType.getBound().toLowerCase()));

            atomTypeLabel2AtomID.put(atomType.getLabel(), atomID);
          }
        }
      }
      for (final FieldType fieldType : documentRoot.getAlloy().getInstance().getField()) {
        for (final TupleType tupleType : fieldType.getTuple()) {
          final AtomType sourceAtomType = tupleType.getAtom().get(0);
          final AtomType targetAtomType = tupleType.getAtom().get(1);
          final String label = fieldType.getLabel();
          final String relationID = modelManager.addRelation(label, 2);
          modelManager.addTuple(relationID, null,
              tupleType.getBound() == null ? BOUND.LOWER_BOUND
                  : BOUND.valueOf(tupleType.getBound().toLowerCase()),
                  2, atomTypeLabel2AtomID.get(sourceAtomType.getLabel()),
                  atomTypeLabel2AtomID.get(targetAtomType.getLabel()));
        }
      }
    } catch (final InvalidArityException | NoSuchModelElementException e) {
      e.printStackTrace();
    }
    return modelManager;
  }
}
