package eu.modelwriter.configuration.alloy.discovery;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.eclipse.emf.common.util.EList;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;

public class AlloyDiscovering {
  private int addStrayedAtom2Sig(final DocumentRoot documentRoot, final String sigName) {
    int count = 0;
    final String id = MarkerFactory.generateId(documentRoot);

    final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
    atomType.setLabel(id);
    atomType.setReasoned(true);

    for (final SigType sigType : documentRoot.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(sigType.getLabel().lastIndexOf("/") + 1);
      if (label.equals(sigName)) {
        sigType.getAtom().add(atomType);
        count = sigType.getAtom().size();
        break;
      }
    }

    AlloyUtilities.writeDocumentRoot(documentRoot);

    return count - 1;
  }

  private final String alsPath =
      InstanceTranslatorDiscovering.baseFileDirectory + "discovering.als";

  private final String xmlPath =
      InstanceTranslatorDiscovering.baseFileDirectory + "discovering.xml";

  public boolean discovering() {
    final File discoveringXml = new File(xmlPath);
    if (discoveringXml.exists()) {
      discoveringXml.delete();
    }
    final File discoveringAls = new File(alsPath);
    if (discoveringAls.exists()) {
      discoveringAls.delete();
    }

    if (!AlloyValidatorDiscovering.validate()) {
      JOptionPane.showMessageDialog(null,
          "There is not any discovering.\nBecause instance is inconsistent.",
          "Discovering on Atoms", JOptionPane.INFORMATION_MESSAGE);
      return false;
    }

    final AlloyParserForDiscovering parser = new AlloyParserForDiscovering(alsPath);

    AlloyNextSolutionDiscovering.getInstance()
    .setDiscoverSigs(AlloyValidatorDiscovering.discoverSigs);

    final DocumentRoot documentRootDiscovering = parser.parse();
    final DocumentRoot documentRootOriginal = AlloyUtilities.getDocumentRoot();
    if (documentRootDiscovering == null) {
      System.err.println("Document root on location " + xmlPath + " is NULL.");
      return false;
    }

    discover(documentRootOriginal, documentRootDiscovering);

    return true;
  }

  private void discover(DocumentRoot documentRootOriginal,
      final DocumentRoot documentRootDiscovering) {
    final Map<String, Integer> discoverSigs = AlloyValidatorDiscovering.discoverSigs;
    int discoveredAtomCount = 0;
    int discoveredRelationCount = 0;

    final String moduleName = AlloyUtilities.getOriginalModuleName();

    final Map<TupleType, String> reasonedTuples_D = new HashMap<>();
    final Map<AtomType, String> discoveredAtoms_D = new HashMap<>();

    for (final SigType sigType_D : documentRootDiscovering.getAlloy().getInstance().getSig()) {
      if (!sigType_D.getLabel().contains(moduleName)) {
        continue;
      }
      final String label = sigType_D.getLabel();
      final String sigName = label.substring(label.lastIndexOf("/") + 1);
      if (!discoverSigs.containsKey(sigName)) {
        continue;
      }

      final int discoveredAtomSize = sigType_D.getAtom().size();
      discoveredAtomCount += discoveredAtomSize;
      for (int i = 0; i < discoveredAtomSize; i++) {
        discoveredAtoms_D.put(sigType_D.getAtom().get(i), sigName);
      }

      final int id = sigType_D.getID();
      for (final FieldType fieldType_D : documentRootDiscovering.getAlloy().getInstance()
          .getField()) {
        for (final TypesType typesType_D : fieldType_D.getTypes()) {
          for (int i = 0; i < typesType_D.getType().size(); i++) {
            if (typesType_D.getType().get(i).getID() == id) {
              for (final TupleType tupleType_D : fieldType_D.getTuple()) {
                for (final AtomType atomType : tupleType_D.getAtom()) {
                  if (atomType.getLabel().contains(moduleName)) {
                    reasonedTuples_D.put(tupleType_D, fieldType_D.getLabel());
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }

    final Map<String, Integer> label2AtomIndex = new HashMap<>();
    for (final Entry<AtomType, String> entry : discoveredAtoms_D.entrySet()) {
      final AtomType atomType_D = entry.getKey();
      final String sigName = entry.getValue();
      final int index = addStrayedAtom2Sig(documentRootOriginal, entry.getValue()); // W
      documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

      final SigType sigType =
          AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(sigName));
      if (AlloyNextSolutionDiscovering.getInstance().getOldDiscoverSigs()
          .get(sigType.getID()) == null) {
        AlloyNextSolutionDiscovering.getInstance().getOldDiscoverSigs().put(sigType.getID(),
            new ArrayList<>(Arrays.asList(sigType.getAtom().get(index))));
      } else {
        AlloyNextSolutionDiscovering.getInstance().getOldDiscoverSigs().get(sigType.getID())
        .add(sigType.getAtom().get(index));
      }

      label2AtomIndex.put(atomType_D.getLabel(), index);
    }

    for (final Entry<TupleType, String> entry : reasonedTuples_D.entrySet()) {
      documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R

      final TupleType tupleType_D = entry.getKey();
      final String fieldName = entry.getValue();
      final EList<FieldType> fieldTypesList =
          documentRootOriginal.getAlloy().getInstance().getField();
      for (final FieldType fieldType_O : fieldTypesList) {
        documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R
        if (fieldType_O.getLabel().equals(fieldName)) {

          final String sourceAtomLabel = tupleType_D.getAtom().get(0).getLabel();
          String sourceAtomType = sourceAtomLabel.substring(sourceAtomLabel.lastIndexOf("/") + 1);
          sourceAtomType = sourceAtomType.substring(0, sourceAtomType.indexOf("$"));
          final Integer sourceAtomIndex = label2AtomIndex.get(sourceAtomLabel);
          AtomType atomType_OS = sourceAtomIndex == null
              ? getOriginalAtomType(documentRootOriginal, sourceAtomLabel) : null;

              final String targetAtomLabel = tupleType_D.getAtom().get(1).getLabel();
              String targetAtomType = targetAtomLabel.substring(targetAtomLabel.lastIndexOf("/") + 1);
              targetAtomType = targetAtomType.substring(0, targetAtomType.indexOf("$"));
              final Integer targetAtomIndex = label2AtomIndex.get(targetAtomLabel);
              AtomType atomType_OT = targetAtomIndex == null
                  ? getOriginalAtomType(documentRootOriginal, targetAtomLabel) : null;

                  final EList<SigType> sigTypes = documentRootOriginal.getAlloy().getInstance().getSig();
                  for (final SigType sigType : sigTypes) {
                    String label = sigType.getLabel();
                    label = label.substring(label.lastIndexOf("/") + 1);
                    if (sourceAtomType.equals(label)) {
                      if (sourceAtomIndex != null) {
                        atomType_OS = sigType.getAtom().get(sourceAtomIndex);
                      }
                    }
                    if (targetAtomType.equals(label)) {
                      if (targetAtomIndex != null) {
                        atomType_OT = sigType.getAtom().get(targetAtomIndex);
                      }
                    }
                  }

                  final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
                  tupleType.getAtom().add(atomType_OS);
                  tupleType.getAtom().add(atomType_OT);
                  tupleType.setReasoned(true);
                  discoveredRelationCount++;

                  documentRootOriginal = AlloyUtilities.getDocumentRoot(); // R
                  for (final FieldType fieldType : documentRootOriginal.getAlloy().getInstance()
                      .getField()) {
                    if (fieldType.getLabel().equals(fieldName)) {
                      fieldType.getTuple().add(tupleType);
                    }
                  }

                  if (AlloyNextSolutionDiscovering.getInstance().getOldDiscoverRelations()
                      .get(fieldType_O.getID()) == null) {
                    AlloyNextSolutionDiscovering.getInstance().getOldDiscoverRelations()
                    .put(fieldType_O.getID(), new ArrayList<>(Arrays.asList(tupleType)));
                  } else {
                    AlloyNextSolutionDiscovering.getInstance().getOldDiscoverRelations()
                    .get(fieldType_O.getID()).add(tupleType);
                  }

                  AlloyUtilities.writeDocumentRoot(documentRootOriginal); // W
        }
      }
    }

    final String discoveringAtomMessage =
        "Discovering on atoms successfully completed.\nDiscovered atom count: "
            + discoveredAtomCount;
    final String discoveringRelationMessage =
        "Discovering on relations successfully completed.\nDiscovered relation count: "
            + discoveredRelationCount;

    JOptionPane.showMessageDialog(null, discoveringAtomMessage + "\n" + discoveringRelationMessage,
        "Discovering Atom", JOptionPane.INFORMATION_MESSAGE);
  }

  private AtomType getOriginalAtomType(final DocumentRoot documentRootOriginal,
      final String name_R) {
    final String name = name_R.substring(0, name_R.lastIndexOf("_"));
    final int id =
        Integer.parseInt(name_R.substring(name_R.lastIndexOf("_") + 1, name_R.lastIndexOf("$")));


    for (final SigType sigType : documentRootOriginal.getAlloy().getInstance().getSig()) {
      String label = sigType.getLabel();
      label = label.substring(label.lastIndexOf("/") + 1);
      if (label.equals(name)) {
        return sigType.getAtom().get(id);
      }
    }
    return null;
    // return
    // AlloyUtilities.getSigTypeById(AlloyUtilities.getSigTypeIdByName(name)).getAtom().get(id);
  }
}
