/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.visualization;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import eu.modelwriter.traceability.core.persistence.AlloyType;
import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.InstanceType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.RepositoryType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.traceability.core.persistence.persistenceFactory;
import eu.modelwriter.visualization.model.Atom;
import eu.modelwriter.visualization.model.Relation;
import eu.modelwriter.visualization.model.Tuple;
import eu.modelwriter.visualization.model.Universe;

public class XmlCreator {

  protected static String xmlfile;
  protected static DocumentRoot documentRoot;
  private Universe universe;
  private int id;
  private HashMap<EObject, Relation> mapForParent;
  private HashMap<EObject, Relation> mapForTypes;

  public XmlCreator(final Universe universe, final String xmlfile) {
    XmlCreator.xmlfile = xmlfile;
    final DocumentRoot oldDocumentRoot = Utility.getDocumentRoot();
    if (oldDocumentRoot != null && universe == null) {
      XmlCreator.documentRoot = oldDocumentRoot;
    } else {
      this.universe = universe;
      this.id = 4;
      this.mapForParent = new HashMap<EObject, Relation>();
      this.mapForTypes = new HashMap<EObject, Relation>();

      this.createBaseXml();
      this.addRelations();
      this.setTypes();
      this.setParents();

      Utility.writeDocumentRoot(XmlCreator.documentRoot);
    }
  }

  private void addRelations() {
    final Map<String, String> atomNameIndexMap = new HashMap<>();
    if (this.universe == null) {
      return;
    }
    for (final Relation relation : this.universe.getRelations()) {
      if (relation.getArity() < 2) {
        final SigType sigType = persistenceFactory.eINSTANCE.createSigType();
        sigType.setID(this.id);
        relation.setId(this.id);
        this.mapForParent.put(sigType, relation.getParent());
        if (!relation.getTypes().isEmpty()) {
          this.mapForTypes.put(sigType, relation);
        }
        this.id++;
        sigType.setLabel(relation.getName());
        this.setStatueOfRelation(relation, sigType);
        XmlCreator.documentRoot.getAlloy().getInstance().getSig().add(sigType);
        for (final Tuple tuple : relation.getTuples()) {
          if (atomNameIndexMap.get(tuple.getAtoms().get(0).getText()) == null) {
            final String index = Utility.generateId(XmlCreator.documentRoot, false);
            final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();

            atomType.setLabel(index);
            if (tuple.getBound() != null) {
              atomType.setBound(tuple.getBound().toLowerCase());
            }
            sigType.getAtom().add(atomType);

            final ItemType itemType = persistenceFactory.eINSTANCE.createItemType();
            final EntryType entryType = persistenceFactory.eINSTANCE.createEntryType();
            itemType.getEntry().add(entryType);

            itemType.setId(index);
            entryType.setKey("Name");
            entryType.setValue(tuple.getAtoms().get(0).getText());
            XmlCreator.documentRoot.getAlloy().getRepository().getItem().add(itemType);
            atomNameIndexMap.put(tuple.getAtoms().get(0).getText(), index);
          } else {
            if (!relation.getTypes().isEmpty()) {
              final String index = atomNameIndexMap.get(tuple.getAtom(0).getText());
              final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();

              atomType.setLabel(index);
              if (tuple.getBound() != null) {
                atomType.setBound(tuple.getBound().toLowerCase());
              }
              sigType.getAtom().add(atomType);
            }
          }
        }
      } else if (relation.getArity() > 1) {
        final FieldType fieldType = persistenceFactory.eINSTANCE.createFieldType();
        fieldType.setID(this.id);
        relation.setId(this.id);
        this.mapForParent.put(fieldType, relation.getParent());
        this.mapForTypes.put(fieldType, relation);
        this.id++;
        fieldType.setLabel(relation.getName());
        XmlCreator.documentRoot.getAlloy().getInstance().getField().add(fieldType);
        for (final Tuple tuple : relation.getTuples()) {
          final TupleType tupleType = persistenceFactory.eINSTANCE.createTupleType();
          fieldType.getTuple().add(tupleType);
          if (tuple.getBound() != null) {
            tupleType.setBound(tuple.getBound().toLowerCase());
          }
          for (final Atom atom : tuple.getAtoms()) {
            final AtomType atomType = persistenceFactory.eINSTANCE.createAtomType();
            atomType.setLabel(atomNameIndexMap.get(atom.getText()));
            tupleType.getAtom().add(atomType);
          }
        }
      }
    }
  }

  private void createBaseXml() {
    XmlCreator.documentRoot = persistenceFactory.eINSTANCE.createDocumentRoot();

    final AlloyType alloyType = persistenceFactory.eINSTANCE.createAlloyType();
    XmlCreator.documentRoot.setAlloy(alloyType);
    alloyType.setBuilddate("");

    final RepositoryType repositoryType = persistenceFactory.eINSTANCE.createRepositoryType();
    repositoryType.setNextId(0);
    alloyType.setRepository(repositoryType);

    final InstanceType instanceType = persistenceFactory.eINSTANCE.createInstanceType();
    alloyType.setInstance(instanceType);
    instanceType.setBitwidth(0);
    instanceType.setFilename("");
    instanceType.setMaxseq(0);

    final SigType sigSegInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigSegInt);
    sigSegInt.setID(0);
    sigSegInt.setLabel("seq/Int");
    sigSegInt.setParentID(1);
    sigSegInt.setBuiltin("yes");

    final SigType sigInt = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigInt);
    sigInt.setID(1);
    sigInt.setLabel("Int");
    sigInt.setParentID(2);
    sigInt.setBuiltin("yes");

    final SigType sigUniv = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigUniv);
    sigUniv.setID(2);
    sigUniv.setLabel("univ");
    sigUniv.setBuiltin("yes");

    final SigType sigString = persistenceFactory.eINSTANCE.createSigType();
    instanceType.getSig().add(sigString);
    sigString.setID(3);
    sigString.setLabel("String");
    sigString.setParentID(2);
    sigString.setBuiltin("yes");

  }

  public void setMetamodel(final boolean isMetamodel) {
    final DocumentRoot documentRoot = Utility.getDocumentRoot();
    if (isMetamodel) {
      documentRoot.getAlloy().getInstance().setMetamodel("yes");
    } else {
      documentRoot.getAlloy().getInstance().setMetamodel(null);
    }

    Utility.writeDocumentRoot(documentRoot);
  }

  private void setParents() {
    final Iterator<Entry<EObject, Relation>> iter = this.mapForParent.entrySet().iterator();
    int countForParentless = 0;

    while (iter.hasNext()) {
      final Entry<EObject, Relation> object = iter.next();
      if (object.getKey() instanceof SigType) {
        final SigType sigType = (SigType) object.getKey();
        if (object.getValue() != null) {
          final Relation parent = this.universe.getRelation(object.getValue().getName());

          if (parent.getId() == -1) {
            countForParentless++;
          }

          sigType.setParentID(parent.getId());

        } else {
          if (sigType.getType().isEmpty()) {
            sigType.setParentID(2);
          }
        }
      } else if (object.getKey() instanceof FieldType) {
        final FieldType fieldType = (FieldType) object.getKey();
        if (object.getValue() != null) {
          final Relation parent = this.universe.getRelation(object.getValue().getName());

          if (parent.getId() == -1) {
            countForParentless++;
          }

          fieldType.setParentID(parent.getId());

        } else {
          fieldType.setParentID(2);
        }
      }
    }
    if (countForParentless != 0) {
      this.setParents();
    }
  }

  private void setStatueOfRelation(final Relation relation, final SigType sigType) {
    if (relation.getMultiplicity() != null) {
      switch (relation.getMultiplicity()) {
        case LONE:
          sigType.setLone("yes");
          break;
        case ONE:
          sigType.setOne("yes");
          break;
        case SOME:
          sigType.setSome("yes");
          break;
        default:
          break;
      }
    }
    if (relation.isAbstract()) {
      sigType.setAbstract("yes");
    }
    if (relation.isEnum()) {
      sigType.setEnum("yes");
    }
    if (relation.isMeta()) {
      sigType.setMeta("yes");
    }
    if (relation.isPrivate()) {
      sigType.setPrivate("yes");
    }
  }

  private void setTypes() {
    final Iterator<Entry<EObject, Relation>> iter = this.mapForTypes.entrySet().iterator();

    while (iter.hasNext()) {
      final Entry<EObject, Relation> object = iter.next();
      if (object.getKey() instanceof SigType) {
        final SigType sigType = (SigType) object.getKey();
        for (final List<Relation> types : object.getValue().getTypes()) {
          for (final Relation relation : types) {
            final Relation relationInUniverse = this.universe.getRelation(relation.getName());
            final TypeType typeType = persistenceFactory.eINSTANCE.createTypeType();
            typeType.setID(relationInUniverse.getId());
            sigType.getType().add(typeType);
          }
        }
      } else if (object.getKey() instanceof FieldType) {
        final FieldType fieldType = (FieldType) object.getKey();
        for (final List<Relation> types : object.getValue().getTypes()) {
          final TypesType typesType = persistenceFactory.eINSTANCE.createTypesType();
          for (final Relation relation : types) {
            final Relation relationInUniverse = this.universe.getRelation(relation.getName());
            final TypeType typeType = persistenceFactory.eINSTANCE.createTypeType();
            typeType.setID(relationInUniverse.getId());
            typesType.getType().add(typeType);
          }
          fieldType.getTypes().add(typesType);
        }
      }
    }

  }


}
