package eu.modelwriter.visualization.rebirth.adapt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import eu.modelwriter.model.Atom;
import eu.modelwriter.model.ModelElement.BOUND;
import eu.modelwriter.model.ModelManager;
import eu.modelwriter.model.Relation;
import eu.modelwriter.model.exception.InvalidArityException;
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
    final Map<String, Atom> atomType2Atom = new HashMap<>();
    try {
      for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
        if (sigType.getID() > 3) {
          final String label = sigType.getLabel().substring(sigType.getLabel().indexOf("/") + 1);
          final Relation relationSet = modelManager.addRelationSet(label, 1);
          for (int i = 0; i < sigType.getAtom().size(); i++) {
            final AtomType atomType = sigType.getAtom().get(i);
            Atom atom;

            atom = modelManager.addAtom(new ArrayList<>(Arrays.asList(relationSet)), label + i,
                null, atomType.getBound() == null ? BOUND.LOWER_BOUND
                    : BOUND.valueOf(atomType.getBound().toLowerCase()));

            atomType2Atom.put(atomType.getLabel(), atom);
          }
        }
      }
      for (final FieldType fieldType : documentRoot.getAlloy().getInstance().getField()) {
        for (final TupleType tupleType : fieldType.getTuple()) {
          final AtomType sourceAtomType = tupleType.getAtom().get(0);
          final AtomType targetAtomType = tupleType.getAtom().get(1);
          final String label = fieldType.getLabel();
          final Relation relationSet = modelManager.addRelationSet(label, 2);
          modelManager.addTuple(relationSet, null,
              tupleType.getBound() == null ? BOUND.LOWER_BOUND
                  : BOUND.valueOf(tupleType.getBound().toLowerCase()),
                  2, atomType2Atom.get(sourceAtomType.getLabel()),
                  atomType2Atom.get(targetAtomType.getLabel()));
        }
      }
    } catch (final InvalidArityException e) {
      e.printStackTrace();
    }
    return modelManager;
  }
}
