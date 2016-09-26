/*******************************************************************************
 * Copyright (c) 2016 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.visualization;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;

import eu.modelwriter.traceability.core.persistence.AtomType;
import eu.modelwriter.traceability.core.persistence.EntryType;
import eu.modelwriter.traceability.core.persistence.FieldType;
import eu.modelwriter.traceability.core.persistence.ItemType;
import eu.modelwriter.traceability.core.persistence.SigType;
import eu.modelwriter.traceability.core.persistence.TupleType;
import eu.modelwriter.traceability.core.persistence.TypeType;
import eu.modelwriter.traceability.core.persistence.TypesType;
import eu.modelwriter.visualization.model.Atom;
import eu.modelwriter.visualization.model.Relation;
import eu.modelwriter.visualization.model.Relation.Multiplicity;
import eu.modelwriter.visualization.model.Universe;

public class XmlToUniverse {

  Universe universe;
  Map<Integer, Relation> idRelationMap;
  Map<Integer, Integer> relationParentMap;
  Map<String, Atom> idAtomMap;

  public XmlToUniverse() {
    universe = new Universe();
    idRelationMap = new HashMap<>();
    relationParentMap = new HashMap<>();
    idAtomMap = new HashMap<>();
  }


  public Universe getUniverse() {
    EList<SigType> sigList = Utility.getDocumentRoot().getAlloy().getInstance().getSig();

    for (SigType sigType : sigList) {
      if (sigType.getID() > 3)
        universe.addRelation(createRelationFromSigType(sigType));
    }

    EList<FieldType> fieldList = Utility.getDocumentRoot().getAlloy().getInstance().getField();

    for (FieldType fieldType : fieldList) {
      universe.addRelation(createRelationFromFieldType(fieldType));
    }

    setParents();

    return universe;
  }

  private Relation createRelationFromSigType(SigType sigType) {
    Relation relation = new Relation(sigType.getLabel());

    relation.setId(sigType.getID());
    checkSigTypeProperties(sigType, relation);
    relationParentMap.put(sigType.getID(), sigType.getParentID());

    EList<AtomType> atomList = sigType.getAtom();

    for (AtomType atomType : atomList) {
      relation.addAtomWithTuple(createAtomFromAtomType(atomType));
    }

    EList<TypeType> typeList = sigType.getType();

    for (TypeType typeType : typeList) {
      relation.addTypes(idRelationMap.get(typeType.getID()));
    }

    idRelationMap.put(sigType.getID(), relation);

    return relation;
  }

  private void checkSigTypeProperties(SigType sigType, Relation relation) {
    if (sigType.getAbstract() != null && sigType.getAbstract().equals("yes")) {
      relation.setAbstract(true);
    }
    if (sigType.getPrivate() != null && sigType.getPrivate().equals("yes")) {
      relation.setPrivate(true);
    }
    if (sigType.getMeta() != null && sigType.getMeta().equals("yes")) {
      relation.setMeta(true);
    }
    if (sigType.getEnum() != null && sigType.getEnum().equals("yes")) {
      relation.setEnum(true);
    }
    if (sigType.getOne() != null && sigType.getOne().equals("yes")) {
      relation.setMultiplicity(Multiplicity.ONE);
    } else if (sigType.getSome() != null && sigType.getSome().equals("yes")) {
      relation.setMultiplicity(Multiplicity.SOME);
    } else if (sigType.getLone() != null && sigType.getLone().equals("yes")) {
      relation.setMultiplicity(Multiplicity.LONE);
    }
  }

  private Atom createAtomFromAtomType(AtomType atomType) {
    ItemType itemType = Utility.getItemById(atomType.getLabel());

    String atomName = "";
    Serializable data = null;

    EList<EntryType> entries = itemType.getEntry();

    for (EntryType entryType : entries) {
      if (entryType.getKey().equals("Name")) {
        atomName = entryType.getValue();
      } else if (entryType.getKey().equals("Data")) {
        try {
          data = Serialization.getInstance().fromString(entryType.getValue());
        } catch (ClassNotFoundException | IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

    Atom atom = new Atom(atomName);
    if (data != null)
      atom.setData(data);

    atom.setId(atomType.getLabel());

    idAtomMap.put(atom.getId(), atom);

    return atom;
  }

  private Relation createRelationFromFieldType(FieldType fieldType) {
    Relation relation = new Relation(fieldType.getLabel());

    relation.setId(fieldType.getID());
    relationParentMap.put(fieldType.getID(), fieldType.getParentID());

    EList<TupleType> tupleList = fieldType.getTuple();

    for (TupleType tupleType : tupleList) {
      relation.addAtomWithTuple(createAtomsFromTupleType(tupleType));
    }

    EList<TypesType> typesList = fieldType.getTypes();

    for (TypesType typesType : typesList) {
      relation.addTypes(createTypesFromTypesType(typesType));
    }

    idRelationMap.put(relation.getId(), relation);

    return relation;
  }

  private Atom[] createAtomsFromTupleType(TupleType tupleType) {
    EList<AtomType> atomList = tupleType.getAtom();
    Atom[] atoms = new Atom[atomList.size()];
    for (int i = 0; i < atomList.size(); i++) {
      atoms[i] = idAtomMap.get(atomList.get(i).getLabel());
    }

    return atoms;
  }

  private Relation[] createTypesFromTypesType(TypesType typesType) {
    EList<TypeType> typeList = typesType.getType();
    Relation[] types = new Relation[typeList.size()];
    for (int i = 0; i < typeList.size(); i++) {
      types[i] = idRelationMap.get(typeList.get(i).getID());
    }

    return types;
  }

  private void setParents() {
    Iterator<Entry<Integer, Integer>> relationParentIter = relationParentMap.entrySet().iterator();

    while (relationParentIter.hasNext()) {
      Entry<Integer, Integer> entry = (Entry<Integer, Integer>) relationParentIter.next();

      Relation relation = idRelationMap.get(entry.getKey());
      Relation parentRelation = idRelationMap.get(entry.getValue());

      relation.setParent(parentRelation);
    }
  }

}
