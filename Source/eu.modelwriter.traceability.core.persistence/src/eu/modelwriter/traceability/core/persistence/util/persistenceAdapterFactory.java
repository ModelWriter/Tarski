/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
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
/**
 */
package eu.modelwriter.traceability.core.persistence.util;

import eu.modelwriter.traceability.core.persistence.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.modelwriter.traceability.core.persistence.persistencePackage
 * @generated
 */
public class persistenceAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static persistencePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public persistenceAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = persistencePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected persistenceSwitch<Adapter> modelSwitch =
    new persistenceSwitch<Adapter>() {
      @Override
      public Adapter caseAlloyType(AlloyType object) {
        return createAlloyTypeAdapter();
      }
      @Override
      public Adapter caseAtomType(AtomType object) {
        return createAtomTypeAdapter();
      }
      @Override
      public Adapter caseDocumentRoot(DocumentRoot object) {
        return createDocumentRootAdapter();
      }
      @Override
      public Adapter caseEntryType(EntryType object) {
        return createEntryTypeAdapter();
      }
      @Override
      public Adapter caseFieldType(FieldType object) {
        return createFieldTypeAdapter();
      }
      @Override
      public Adapter caseInstanceType(InstanceType object) {
        return createInstanceTypeAdapter();
      }
      @Override
      public Adapter caseItemType(ItemType object) {
        return createItemTypeAdapter();
      }
      @Override
      public Adapter caseRepositoryType(RepositoryType object) {
        return createRepositoryTypeAdapter();
      }
      @Override
      public Adapter caseSigType(SigType object) {
        return createSigTypeAdapter();
      }
      @Override
      public Adapter caseSourceType(SourceType object) {
        return createSourceTypeAdapter();
      }
      @Override
      public Adapter caseTupleType(TupleType object) {
        return createTupleTypeAdapter();
      }
      @Override
      public Adapter caseTypesType(TypesType object) {
        return createTypesTypeAdapter();
      }
      @Override
      public Adapter caseTypeType(TypeType object) {
        return createTypeTypeAdapter();
      }
      @Override
      public Adapter caseRelationType(RelationType object) {
        return createRelationTypeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.AlloyType <em>Alloy Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.AlloyType
   * @generated
   */
  public Adapter createAlloyTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.AtomType <em>Atom Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.AtomType
   * @generated
   */
  public Adapter createAtomTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.DocumentRoot <em>Document Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.DocumentRoot
   * @generated
   */
  public Adapter createDocumentRootAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.EntryType <em>Entry Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.EntryType
   * @generated
   */
  public Adapter createEntryTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.FieldType <em>Field Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.FieldType
   * @generated
   */
  public Adapter createFieldTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.InstanceType <em>Instance Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.InstanceType
   * @generated
   */
  public Adapter createInstanceTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.ItemType <em>Item Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.ItemType
   * @generated
   */
  public Adapter createItemTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.RepositoryType <em>Repository Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.RepositoryType
   * @generated
   */
  public Adapter createRepositoryTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.SigType <em>Sig Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.SigType
   * @generated
   */
  public Adapter createSigTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.SourceType <em>Source Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.SourceType
   * @generated
   */
  public Adapter createSourceTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.TupleType
   * @generated
   */
  public Adapter createTupleTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.TypesType <em>Types Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.TypesType
   * @generated
   */
  public Adapter createTypesTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.TypeType <em>Type Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.TypeType
   * @generated
   */
  public Adapter createTypeTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link eu.modelwriter.traceability.core.persistence.RelationType <em>Relation Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see eu.modelwriter.traceability.core.persistence.RelationType
   * @generated
   */
  public Adapter createRelationTypeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //persistenceAdapterFactory
