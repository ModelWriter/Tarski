head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.03.02.22.43.36;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	83574b8d94834567;

1.1
date	2010.03.02.22.19.49;	author tfaure;	state Exp;
branches;
next	;
commitid	66574b8d8ee24567;


desc
@@


1.2
log
@drop unused action : call activity. an activity as it is referenced is directly called
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.doc2model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelFactory
 * @@model kind="package"
 * @@generated
 */
public interface Doc2modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	String eNAME = "doc2model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	String eNS_URI = "http://www.eclipse.org/doc2model/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	String eNS_PREFIX = "doc2model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	Doc2modelPackage eINSTANCE = org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl.init();

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl <em>Doc2 Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getDoc2Model()
	 * @@generated
	 */
	int DOC2_MODEL = 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getConfiguration()
	 * @@generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.InitialModelImpl <em>Initial Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.InitialModelImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getInitialModel()
	 * @@generated
	 */
	int INITIAL_MODEL = 2;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ObjectContainerImpl <em>Object Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ObjectContainerImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getObjectContainer()
	 * @@generated
	 */
	int OBJECT_CONTAINER = 26;

	/**
	 * The feature id for the '<em><b>Owned Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int OBJECT_CONTAINER__OWNED_OBJECTS = 0;

	/**
	 * The number of structural features of the '<em>Object Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int OBJECT_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Owned Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL__OWNED_OBJECTS = OBJECT_CONTAINER__OWNED_OBJECTS;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL__CONFIGURATION = OBJECT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL__RULES = OBJECT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Matches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL__OWNED_MATCHES = OBJECT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL__OWNED_ACTIONS = OBJECT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL__INITIAL_ACTION = OBJECT_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Doc2 Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int DOC2_MODEL_FEATURE_COUNT = OBJECT_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Initial Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONFIGURATION__INITIAL_MODEL = 0;

	/**
	 * The feature id for the '<em><b>EPackages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONFIGURATION__EPACKAGES = 1;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONFIGURATION__EXTENSION = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int INITIAL_MODEL__COPY = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int INITIAL_MODEL__REFERENCE = 1;

	/**
	 * The number of structural features of the '<em>Initial Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int INITIAL_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchImpl <em>Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.MatchImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getMatch()
	 * @@generated
	 */
	int MATCH = 3;

	/**
	 * The feature id for the '<em><b>Owned Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCH__OWNED_OBJECTS = OBJECT_CONTAINER__OWNED_OBJECTS;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCH__URI = OBJECT_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Higher Than</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCH__HIGHER_THAN = OBJECT_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Than</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCH__LOWER_THAN = OBJECT_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCH__RULE = OBJECT_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCH_FEATURE_COUNT = OBJECT_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.RuleImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getRule()
	 * @@generated
	 */
	int RULE = 4;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int RULE__MATCH = 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int RULE__ACTIONS = 1;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int RULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getAction()
	 * @@generated
	 */
	int ACTION = 5;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceActionImpl <em>Reference Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ReferenceActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getReferenceAction()
	 * @@generated
	 */
	int REFERENCE_ACTION = 17;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ElementSelectionImpl <em>Element Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ElementSelectionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getElementSelection()
	 * @@generated
	 */
	int ELEMENT_SELECTION = 6;

	/**
	 * The feature id for the '<em><b>EReference Owning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ELEMENT_SELECTION__EREFERENCE_OWNING = 0;

	/**
	 * The number of structural features of the '<em>Element Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ELEMENT_SELECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.CurrentContainerSelectionImpl <em>Current Container Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.CurrentContainerSelectionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getCurrentContainerSelection()
	 * @@generated
	 */
	int CURRENT_CONTAINER_SELECTION = 7;

	/**
	 * The feature id for the '<em><b>EReference Owning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CURRENT_CONTAINER_SELECTION__EREFERENCE_OWNING = ELEMENT_SELECTION__EREFERENCE_OWNING;

	/**
	 * The number of structural features of the '<em>Current Container Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CURRENT_CONTAINER_SELECTION_FEATURE_COUNT = ELEMENT_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.LastElementCreatedSelectionImpl <em>Last Element Created Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.LastElementCreatedSelectionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getLastElementCreatedSelection()
	 * @@generated
	 */
	int LAST_ELEMENT_CREATED_SELECTION = 8;

	/**
	 * The feature id for the '<em><b>EReference Owning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int LAST_ELEMENT_CREATED_SELECTION__EREFERENCE_OWNING = ELEMENT_SELECTION__EREFERENCE_OWNING;

	/**
	 * The number of structural features of the '<em>Last Element Created Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int LAST_ELEMENT_CREATED_SELECTION_FEATURE_COUNT = ELEMENT_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.StaticElementSelectionImpl <em>Static Element Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.StaticElementSelectionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getStaticElementSelection()
	 * @@generated
	 */
	int STATIC_ELEMENT_SELECTION = 9;

	/**
	 * The feature id for the '<em><b>EReference Owning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STATIC_ELEMENT_SELECTION__EREFERENCE_OWNING = ELEMENT_SELECTION__EREFERENCE_OWNING;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STATIC_ELEMENT_SELECTION__ELEMENT = ELEMENT_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Static Element Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STATIC_ELEMENT_SELECTION_FEATURE_COUNT = ELEMENT_SELECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.LastContainerConsideringMatchOrderImpl <em>Last Container Considering Match Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.LastContainerConsideringMatchOrderImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getLastContainerConsideringMatchOrder()
	 * @@generated
	 */
	int LAST_CONTAINER_CONSIDERING_MATCH_ORDER = 10;

	/**
	 * The feature id for the '<em><b>EReference Owning</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int LAST_CONTAINER_CONSIDERING_MATCH_ORDER__EREFERENCE_OWNING = ELEMENT_SELECTION__EREFERENCE_OWNING;

	/**
	 * The number of structural features of the '<em>Last Container Considering Match Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int LAST_CONTAINER_CONSIDERING_MATCH_ORDER_FEATURE_COUNT = ELEMENT_SELECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl <em>Create Element Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getCreateElementAction()
	 * @@generated
	 */
	int CREATE_ELEMENT_ACTION = 11;

	/**
	 * The feature id for the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CREATE_ELEMENT_ACTION__ECLASS_NAME = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Epackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CREATE_ELEMENT_ACTION__EPACKAGE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CREATE_ELEMENT_ACTION__NEW_ELEMENT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CREATE_ELEMENT_ACTION__CONTAINER = ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Create Element Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CREATE_ELEMENT_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionWithInParameterImpl <em>Action With In Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionWithInParameterImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActionWithInParameter()
	 * @@generated
	 */
	int ACTION_WITH_IN_PARAMETER = 25;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_WITH_IN_PARAMETER__IN = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action With In Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_WITH_IN_PARAMETER_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.FillAttributeActionImpl <em>Fill Attribute Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.FillAttributeActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getFillAttributeAction()
	 * @@generated
	 */
	int FILL_ATTRIBUTE_ACTION = 12;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int FILL_ATTRIBUTE_ACTION__IN = ACTION_WITH_IN_PARAMETER__IN;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int FILL_ATTRIBUTE_ACTION__ATTRIBUTE = ACTION_WITH_IN_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Eobject Containing Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE = ACTION_WITH_IN_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Fill Attribute Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int FILL_ATTRIBUTE_ACTION_FEATURE_COUNT = ACTION_WITH_IN_PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.TransformHandledTextImpl <em>Transform Handled Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.TransformHandledTextImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getTransformHandledText()
	 * @@generated
	 */
	int TRANSFORM_HANDLED_TEXT = 13;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int TRANSFORM_HANDLED_TEXT__IN = ACTION_WITH_IN_PARAMETER__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int TRANSFORM_HANDLED_TEXT__OUT = ACTION_WITH_IN_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Transform Handled Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int TRANSFORM_HANDLED_TEXT_FEATURE_COUNT = ACTION_WITH_IN_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.EPackageReferenceImpl <em>EPackage Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.EPackageReferenceImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getEPackageReference()
	 * @@generated
	 */
	int EPACKAGE_REFERENCE = 14;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int EPACKAGE_REFERENCE__URI = 0;

	/**
	 * The number of structural features of the '<em>EPackage Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int EPACKAGE_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.RegexTextTransformerImpl <em>Regex Text Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.RegexTextTransformerImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getRegexTextTransformer()
	 * @@generated
	 */
	int REGEX_TEXT_TRANSFORMER = 15;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REGEX_TEXT_TRANSFORMER__IN = TRANSFORM_HANDLED_TEXT__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REGEX_TEXT_TRANSFORMER__OUT = TRANSFORM_HANDLED_TEXT__OUT;

	/**
	 * The feature id for the '<em><b>Pattern For Grouping And Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX = TRANSFORM_HANDLED_TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regex Text Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REGEX_TEXT_TRANSFORMER_FEATURE_COUNT = TRANSFORM_HANDLED_TEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.StringReplacementTextTransformerImpl <em>String Replacement Text Transformer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.StringReplacementTextTransformerImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getStringReplacementTextTransformer()
	 * @@generated
	 */
	int STRING_REPLACEMENT_TEXT_TRANSFORMER = 16;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STRING_REPLACEMENT_TEXT_TRANSFORMER__IN = TRANSFORM_HANDLED_TEXT__IN;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STRING_REPLACEMENT_TEXT_TRANSFORMER__OUT = TRANSFORM_HANDLED_TEXT__OUT;

	/**
	 * The feature id for the '<em><b>String Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT = TRANSFORM_HANDLED_TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Replacement Text Transformer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int STRING_REPLACEMENT_TEXT_TRANSFORMER_FEATURE_COUNT = TRANSFORM_HANDLED_TEXT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ACTION__REFERENCE_ATTRIBUTE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ACTION__CURRENT_ELEMENT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceStaticElementActionImpl <em>Reference Static Element Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ReferenceStaticElementActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getReferenceStaticElementAction()
	 * @@generated
	 */
	int REFERENCE_STATIC_ELEMENT_ACTION = 18;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_STATIC_ELEMENT_ACTION__REFERENCE_ATTRIBUTE = REFERENCE_ACTION__REFERENCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Current Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_STATIC_ELEMENT_ACTION__CURRENT_ELEMENT = REFERENCE_ACTION__CURRENT_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_STATIC_ELEMENT_ACTION__ELEMENT = REFERENCE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Static Element Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_STATIC_ELEMENT_ACTION_FEATURE_COUNT = REFERENCE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ValueImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getValue()
	 * @@generated
	 */
	int VALUE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int VALUE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int VALUE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ContainerSelectionObjectImpl <em>Container Selection Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ContainerSelectionObjectImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getContainerSelectionObject()
	 * @@generated
	 */
	int CONTAINER_SELECTION_OBJECT = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONTAINER_SELECTION_OBJECT__NAME = VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONTAINER_SELECTION_OBJECT__SELECTION = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container Selection Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CONTAINER_SELECTION_OBJECT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ParameterObjectImpl <em>Parameter Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ParameterObjectImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getParameterObject()
	 * @@generated
	 */
	int PARAMETER_OBJECT = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int PARAMETER_OBJECT__NAME = VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int PARAMETER_OBJECT__KIND = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int PARAMETER_OBJECT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionResultObjectImpl <em>Action Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionResultObjectImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActionResultObject()
	 * @@generated
	 */
	int ACTION_RESULT_OBJECT = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_RESULT_OBJECT__NAME = VALUE__NAME;

	/**
	 * The number of structural features of the '<em>Action Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_RESULT_OBJECT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActivity()
	 * @@generated
	 */
	int ACTIVITY = 23;

	/**
	 * The feature id for the '<em><b>Owned Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTIVITY__OWNED_OBJECTS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTIVITY__ACTIONS = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTIVITY__PARAMETERS = ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTIVITY_FEATURE_COUNT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchingResultObjectImpl <em>Matching Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.MatchingResultObjectImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getMatchingResultObject()
	 * @@generated
	 */
	int MATCHING_RESULT_OBJECT = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCHING_RESULT_OBJECT__NAME = VALUE__NAME;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCHING_RESULT_OBJECT__INDEX = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Matching Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int MATCHING_RESULT_OBJECT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceElementActionImpl <em>Reference Element Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ReferenceElementActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getReferenceElementAction()
	 * @@generated
	 */
	int REFERENCE_ELEMENT_ACTION = 27;

	/**
	 * The feature id for the '<em><b>Reference Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ELEMENT_ACTION__REFERENCE_ATTRIBUTE = REFERENCE_ACTION__REFERENCE_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Current Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ELEMENT_ACTION__CURRENT_ELEMENT = REFERENCE_ACTION__CURRENT_ELEMENT;

	/**
	 * The feature id for the '<em><b>To Assign</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ELEMENT_ACTION__TO_ASSIGN = REFERENCE_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Element Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int REFERENCE_ELEMENT_ACTION_FEATURE_COUNT = REFERENCE_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.SetContainerActionImpl <em>Set Container Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.SetContainerActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getSetContainerAction()
	 * @@generated
	 */
	int SET_CONTAINER_ACTION = 28;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int SET_CONTAINER_ACTION__IN = ACTION_WITH_IN_PARAMETER__IN;

	/**
	 * The number of structural features of the '<em>Set Container Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int SET_CONTAINER_ACTION_FEATURE_COUNT = ACTION_WITH_IN_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionWithOutParameterImpl <em>Action With Out Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionWithOutParameterImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActionWithOutParameter()
	 * @@generated
	 */
	int ACTION_WITH_OUT_PARAMETER = 29;

	/**
	 * The feature id for the '<em><b>Out</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_WITH_OUT_PARAMETER__OUT = 0;

	/**
	 * The number of structural features of the '<em>Action With Out Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int ACTION_WITH_OUT_PARAMETER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.ParameterKind <em>Parameter Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterKind
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getParameterKind()
	 * @@generated
	 */
	int PARAMETER_KIND = 30;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.common.util.URI
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getURI()
	 * @@generated
	 */
	int URI = 31;

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model <em>Doc2 Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Doc2 Model</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model
	 * @@generated
	 */
	EClass getDoc2Model();

	/**
	 * Returns the meta object for the containment reference '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference '<em>Configuration</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model#getConfiguration()
	 * @@see #getDoc2Model()
	 * @@generated
	 */
	EReference getDoc2Model_Configuration();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>Rules</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model#getRules()
	 * @@see #getDoc2Model()
	 * @@generated
	 */
	EReference getDoc2Model_Rules();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getOwnedMatches <em>Owned Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>Owned Matches</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model#getOwnedMatches()
	 * @@see #getDoc2Model()
	 * @@generated
	 */
	EReference getDoc2Model_OwnedMatches();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getOwnedActions <em>Owned Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>Owned Actions</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model#getOwnedActions()
	 * @@see #getDoc2Model()
	 * @@generated
	 */
	EReference getDoc2Model_OwnedActions();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model#getInitialAction <em>Initial Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Initial Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model#getInitialAction()
	 * @@see #getDoc2Model()
	 * @@generated
	 */
	EReference getDoc2Model_InitialAction();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Configuration</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Configuration
	 * @@generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@@link org.eclipse.emf.doc2model.doc2model.Configuration#getInitialModel <em>Initial Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference '<em>Initial Model</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Configuration#getInitialModel()
	 * @@see #getConfiguration()
	 * @@generated
	 */
	EReference getConfiguration_InitialModel();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.Configuration#getEPackages <em>EPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>EPackages</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Configuration#getEPackages()
	 * @@see #getConfiguration()
	 * @@generated
	 */
	EReference getConfiguration_EPackages();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.Configuration#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Extension</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Configuration#getExtension()
	 * @@see #getConfiguration()
	 * @@generated
	 */
	EAttribute getConfiguration_Extension();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.InitialModel <em>Initial Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Initial Model</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.InitialModel
	 * @@generated
	 */
	EClass getInitialModel();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.InitialModel#isCopy <em>Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Copy</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.InitialModel#isCopy()
	 * @@see #getInitialModel()
	 * @@generated
	 */
	EAttribute getInitialModel_Copy();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.InitialModel#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Reference</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.InitialModel#getReference()
	 * @@see #getInitialModel()
	 * @@generated
	 */
	EReference getInitialModel_Reference();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Match</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Match
	 * @@generated
	 */
	EClass getMatch();

	/**
	 * Returns the meta object for the attribute list '{@@link org.eclipse.emf.doc2model.doc2model.Match#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute list '<em>Uri</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getUri()
	 * @@see #getMatch()
	 * @@generated
	 */
	EAttribute getMatch_Uri();

	/**
	 * Returns the meta object for the reference list '{@@link org.eclipse.emf.doc2model.doc2model.Match#getHigherThan <em>Higher Than</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference list '<em>Higher Than</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getHigherThan()
	 * @@see #getMatch()
	 * @@generated
	 */
	EReference getMatch_HigherThan();

	/**
	 * Returns the meta object for the reference list '{@@link org.eclipse.emf.doc2model.doc2model.Match#getLowerThan <em>Lower Than</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference list '<em>Lower Than</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getLowerThan()
	 * @@see #getMatch()
	 * @@generated
	 */
	EReference getMatch_LowerThan();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.Match#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Rule</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Match#getRule()
	 * @@see #getMatch()
	 * @@generated
	 */
	EReference getMatch_Rule();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Rule</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Rule
	 * @@generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.Rule#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Match</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Rule#getMatch()
	 * @@see #getRule()
	 * @@generated
	 */
	EReference getRule_Match();

	/**
	 * Returns the meta object for the reference list '{@@link org.eclipse.emf.doc2model.doc2model.Rule#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference list '<em>Actions</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Rule#getActions()
	 * @@see #getRule()
	 * @@generated
	 */
	EReference getRule_Actions();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Action
	 * @@generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ElementSelection <em>Element Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Element Selection</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ElementSelection
	 * @@generated
	 */
	EClass getElementSelection();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.ElementSelection#getEReferenceOwning <em>EReference Owning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>EReference Owning</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ElementSelection#getEReferenceOwning()
	 * @@see #getElementSelection()
	 * @@generated
	 */
	EAttribute getElementSelection_EReferenceOwning();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection <em>Current Container Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Current Container Selection</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection
	 * @@generated
	 */
	EClass getCurrentContainerSelection();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.LastElementCreatedSelection <em>Last Element Created Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Last Element Created Selection</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.LastElementCreatedSelection
	 * @@generated
	 */
	EClass getLastElementCreatedSelection();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.StaticElementSelection <em>Static Element Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Static Element Selection</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.StaticElementSelection
	 * @@generated
	 */
	EClass getStaticElementSelection();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.StaticElementSelection#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Element</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.StaticElementSelection#getElement()
	 * @@see #getStaticElementSelection()
	 * @@generated
	 */
	EReference getStaticElementSelection_Element();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder <em>Last Container Considering Match Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Last Container Considering Match Order</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder
	 * @@generated
	 */
	EClass getLastContainerConsideringMatchOrder();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction <em>Create Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Create Element Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CreateElementAction
	 * @@generated
	 */
	EClass getCreateElementAction();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEClassName <em>EClass Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>EClass Name</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEClassName()
	 * @@see #getCreateElementAction()
	 * @@generated
	 */
	EAttribute getCreateElementAction_EClassName();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEpackage <em>Epackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Epackage</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEpackage()
	 * @@see #getCreateElementAction()
	 * @@generated
	 */
	EReference getCreateElementAction_Epackage();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getNewElement <em>New Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>New Element</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CreateElementAction#getNewElement()
	 * @@see #getCreateElementAction()
	 * @@generated
	 */
	EReference getCreateElementAction_NewElement();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Container</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CreateElementAction#getContainer()
	 * @@see #getCreateElementAction()
	 * @@generated
	 */
	EReference getCreateElementAction_Container();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction <em>Fill Attribute Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Fill Attribute Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.FillAttributeAction
	 * @@generated
	 */
	EClass getFillAttributeAction();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Attribute</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getAttribute()
	 * @@see #getFillAttributeAction()
	 * @@generated
	 */
	EAttribute getFillAttributeAction_Attribute();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getEobjectContainingAttribute <em>Eobject Containing Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Eobject Containing Attribute</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.FillAttributeAction#getEobjectContainingAttribute()
	 * @@see #getFillAttributeAction()
	 * @@generated
	 */
	EReference getFillAttributeAction_EobjectContainingAttribute();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.TransformHandledText <em>Transform Handled Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Transform Handled Text</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.TransformHandledText
	 * @@generated
	 */
	EClass getTransformHandledText();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.EPackageReference <em>EPackage Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>EPackage Reference</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.EPackageReference
	 * @@generated
	 */
	EClass getEPackageReference();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.EPackageReference#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Uri</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.EPackageReference#getUri()
	 * @@see #getEPackageReference()
	 * @@generated
	 */
	EAttribute getEPackageReference_Uri();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.RegexTextTransformer <em>Regex Text Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Regex Text Transformer</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.RegexTextTransformer
	 * @@generated
	 */
	EClass getRegexTextTransformer();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.RegexTextTransformer#getPatternForGroupingAndRegex <em>Pattern For Grouping And Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Pattern For Grouping And Regex</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.RegexTextTransformer#getPatternForGroupingAndRegex()
	 * @@see #getRegexTextTransformer()
	 * @@generated
	 */
	EAttribute getRegexTextTransformer_PatternForGroupingAndRegex();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer <em>String Replacement Text Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>String Replacement Text Transformer</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer
	 * @@generated
	 */
	EClass getStringReplacementTextTransformer();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer#getStringReplacement <em>String Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>String Replacement</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer#getStringReplacement()
	 * @@see #getStringReplacementTextTransformer()
	 * @@generated
	 */
	EAttribute getStringReplacementTextTransformer_StringReplacement();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceAction <em>Reference Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Reference Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceAction
	 * @@generated
	 */
	EClass getReferenceAction();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceAction#getReferenceAttribute <em>Reference Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Reference Attribute</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceAction#getReferenceAttribute()
	 * @@see #getReferenceAction()
	 * @@generated
	 */
	EAttribute getReferenceAction_ReferenceAttribute();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceAction#getCurrentElement <em>Current Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Current Element</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceAction#getCurrentElement()
	 * @@see #getReferenceAction()
	 * @@generated
	 */
	EReference getReferenceAction_CurrentElement();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction <em>Reference Static Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Reference Static Element Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction
	 * @@generated
	 */
	EClass getReferenceStaticElementAction();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Element</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction#getElement()
	 * @@see #getReferenceStaticElementAction()
	 * @@generated
	 */
	EReference getReferenceStaticElementAction_Element();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Value</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Value
	 * @@generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.Value#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Name</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Value#getName()
	 * @@see #getValue()
	 * @@generated
	 */
	EAttribute getValue_Name();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject <em>Container Selection Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Container Selection Object</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject
	 * @@generated
	 */
	EClass getContainerSelectionObject();

	/**
	 * Returns the meta object for the containment reference '{@@link org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference '<em>Selection</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject#getSelection()
	 * @@see #getContainerSelectionObject()
	 * @@generated
	 */
	EReference getContainerSelectionObject_Selection();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ParameterObject <em>Parameter Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Parameter Object</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterObject
	 * @@generated
	 */
	EClass getParameterObject();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.ParameterObject#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Kind</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterObject#getKind()
	 * @@see #getParameterObject()
	 * @@generated
	 */
	EAttribute getParameterObject_Kind();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ActionResultObject <em>Action Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Action Result Object</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionResultObject
	 * @@generated
	 */
	EClass getActionResultObject();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Activity</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Activity
	 * @@generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.Activity#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>Actions</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Activity#getActions()
	 * @@see #getActivity()
	 * @@generated
	 */
	EReference getActivity_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.Activity#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.Activity#getParameters()
	 * @@see #getActivity()
	 * @@generated
	 */
	EReference getActivity_Parameters();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.MatchingResultObject <em>Matching Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Matching Result Object</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.MatchingResultObject
	 * @@generated
	 */
	EClass getMatchingResultObject();

	/**
	 * Returns the meta object for the attribute '{@@link org.eclipse.emf.doc2model.doc2model.MatchingResultObject#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the attribute '<em>Index</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.MatchingResultObject#getIndex()
	 * @@see #getMatchingResultObject()
	 * @@generated
	 */
	EAttribute getMatchingResultObject_Index();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ActionWithInParameter <em>Action With In Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Action With In Parameter</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionWithInParameter
	 * @@generated
	 */
	EClass getActionWithInParameter();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.ActionWithInParameter#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>In</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionWithInParameter#getIn()
	 * @@see #getActionWithInParameter()
	 * @@generated
	 */
	EReference getActionWithInParameter_In();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ObjectContainer <em>Object Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Object Container</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ObjectContainer
	 * @@generated
	 */
	EClass getObjectContainer();

	/**
	 * Returns the meta object for the containment reference list '{@@link org.eclipse.emf.doc2model.doc2model.ObjectContainer#getOwnedObjects <em>Owned Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the containment reference list '<em>Owned Objects</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ObjectContainer#getOwnedObjects()
	 * @@see #getObjectContainer()
	 * @@generated
	 */
	EReference getObjectContainer_OwnedObjects();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceElementAction <em>Reference Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Reference Element Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceElementAction
	 * @@generated
	 */
	EClass getReferenceElementAction();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceElementAction#getToAssign <em>To Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>To Assign</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceElementAction#getToAssign()
	 * @@see #getReferenceElementAction()
	 * @@generated
	 */
	EReference getReferenceElementAction_ToAssign();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.SetContainerAction <em>Set Container Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Set Container Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.SetContainerAction
	 * @@generated
	 */
	EClass getSetContainerAction();

	/**
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter <em>Action With Out Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Action With Out Parameter</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter
	 * @@generated
	 */
	EClass getActionWithOutParameter();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Out</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter#getOut()
	 * @@see #getActionWithOutParameter()
	 * @@generated
	 */
	EReference getActionWithOutParameter_Out();

	/**
	 * Returns the meta object for enum '{@@link org.eclipse.emf.doc2model.doc2model.ParameterKind <em>Parameter Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for enum '<em>Parameter Kind</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterKind
	 * @@generated
	 */
	EEnum getParameterKind();

	/**
	 * Returns the meta object for data type '{@@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for data type '<em>URI</em>'.
	 * @@see org.eclipse.emf.common.util.URI
	 * @@model instanceClass="org.eclipse.emf.common.util.URI"
	 * @@generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the factory that creates the instances of the model.
	 * @@generated
	 */
	Doc2modelFactory getDoc2modelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl <em>Doc2 Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2ModelImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getDoc2Model()
		 * @@generated
		 */
		EClass DOC2_MODEL = eINSTANCE.getDoc2Model();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference DOC2_MODEL__CONFIGURATION = eINSTANCE.getDoc2Model_Configuration();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference DOC2_MODEL__RULES = eINSTANCE.getDoc2Model_Rules();

		/**
		 * The meta object literal for the '<em><b>Owned Matches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference DOC2_MODEL__OWNED_MATCHES = eINSTANCE.getDoc2Model_OwnedMatches();

		/**
		 * The meta object literal for the '<em><b>Owned Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference DOC2_MODEL__OWNED_ACTIONS = eINSTANCE.getDoc2Model_OwnedActions();

		/**
		 * The meta object literal for the '<em><b>Initial Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference DOC2_MODEL__INITIAL_ACTION = eINSTANCE.getDoc2Model_InitialAction();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ConfigurationImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getConfiguration()
		 * @@generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>EPackages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CONFIGURATION__EPACKAGES = eINSTANCE.getConfiguration_EPackages();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute CONFIGURATION__EXTENSION = eINSTANCE.getConfiguration_Extension();

		/**
		 * The meta object literal for the '<em><b>Initial Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CONFIGURATION__INITIAL_MODEL = eINSTANCE.getConfiguration_InitialModel();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.InitialModelImpl <em>Initial Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.InitialModelImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getInitialModel()
		 * @@generated
		 */
		EClass INITIAL_MODEL = eINSTANCE.getInitialModel();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute INITIAL_MODEL__COPY = eINSTANCE.getInitialModel_Copy();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference INITIAL_MODEL__REFERENCE = eINSTANCE.getInitialModel_Reference();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchImpl <em>Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.MatchImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getMatch()
		 * @@generated
		 */
		EClass MATCH = eINSTANCE.getMatch();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute MATCH__URI = eINSTANCE.getMatch_Uri();

		/**
		 * The meta object literal for the '<em><b>Higher Than</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference MATCH__HIGHER_THAN = eINSTANCE.getMatch_HigherThan();

		/**
		 * The meta object literal for the '<em><b>Lower Than</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference MATCH__LOWER_THAN = eINSTANCE.getMatch_LowerThan();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference MATCH__RULE = eINSTANCE.getMatch_Rule();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.RuleImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getRule()
		 * @@generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference RULE__MATCH = eINSTANCE.getRule_Match();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference RULE__ACTIONS = eINSTANCE.getRule_Actions();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getAction()
		 * @@generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ElementSelectionImpl <em>Element Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ElementSelectionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getElementSelection()
		 * @@generated
		 */
		EClass ELEMENT_SELECTION = eINSTANCE.getElementSelection();

		/**
		 * The meta object literal for the '<em><b>EReference Owning</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute ELEMENT_SELECTION__EREFERENCE_OWNING = eINSTANCE.getElementSelection_EReferenceOwning();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.CurrentContainerSelectionImpl <em>Current Container Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.CurrentContainerSelectionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getCurrentContainerSelection()
		 * @@generated
		 */
		EClass CURRENT_CONTAINER_SELECTION = eINSTANCE.getCurrentContainerSelection();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.LastElementCreatedSelectionImpl <em>Last Element Created Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.LastElementCreatedSelectionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getLastElementCreatedSelection()
		 * @@generated
		 */
		EClass LAST_ELEMENT_CREATED_SELECTION = eINSTANCE.getLastElementCreatedSelection();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.StaticElementSelectionImpl <em>Static Element Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.StaticElementSelectionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getStaticElementSelection()
		 * @@generated
		 */
		EClass STATIC_ELEMENT_SELECTION = eINSTANCE.getStaticElementSelection();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference STATIC_ELEMENT_SELECTION__ELEMENT = eINSTANCE.getStaticElementSelection_Element();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.LastContainerConsideringMatchOrderImpl <em>Last Container Considering Match Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.LastContainerConsideringMatchOrderImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getLastContainerConsideringMatchOrder()
		 * @@generated
		 */
		EClass LAST_CONTAINER_CONSIDERING_MATCH_ORDER = eINSTANCE.getLastContainerConsideringMatchOrder();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl <em>Create Element Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.CreateElementActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getCreateElementAction()
		 * @@generated
		 */
		EClass CREATE_ELEMENT_ACTION = eINSTANCE.getCreateElementAction();

		/**
		 * The meta object literal for the '<em><b>EClass Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute CREATE_ELEMENT_ACTION__ECLASS_NAME = eINSTANCE.getCreateElementAction_EClassName();

		/**
		 * The meta object literal for the '<em><b>Epackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CREATE_ELEMENT_ACTION__EPACKAGE = eINSTANCE.getCreateElementAction_Epackage();

		/**
		 * The meta object literal for the '<em><b>New Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CREATE_ELEMENT_ACTION__NEW_ELEMENT = eINSTANCE.getCreateElementAction_NewElement();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CREATE_ELEMENT_ACTION__CONTAINER = eINSTANCE.getCreateElementAction_Container();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.FillAttributeActionImpl <em>Fill Attribute Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.FillAttributeActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getFillAttributeAction()
		 * @@generated
		 */
		EClass FILL_ATTRIBUTE_ACTION = eINSTANCE.getFillAttributeAction();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute FILL_ATTRIBUTE_ACTION__ATTRIBUTE = eINSTANCE.getFillAttributeAction_Attribute();

		/**
		 * The meta object literal for the '<em><b>Eobject Containing Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE = eINSTANCE.getFillAttributeAction_EobjectContainingAttribute();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.TransformHandledTextImpl <em>Transform Handled Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.TransformHandledTextImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getTransformHandledText()
		 * @@generated
		 */
		EClass TRANSFORM_HANDLED_TEXT = eINSTANCE.getTransformHandledText();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.EPackageReferenceImpl <em>EPackage Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.EPackageReferenceImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getEPackageReference()
		 * @@generated
		 */
		EClass EPACKAGE_REFERENCE = eINSTANCE.getEPackageReference();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute EPACKAGE_REFERENCE__URI = eINSTANCE.getEPackageReference_Uri();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.RegexTextTransformerImpl <em>Regex Text Transformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.RegexTextTransformerImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getRegexTextTransformer()
		 * @@generated
		 */
		EClass REGEX_TEXT_TRANSFORMER = eINSTANCE.getRegexTextTransformer();

		/**
		 * The meta object literal for the '<em><b>Pattern For Grouping And Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX = eINSTANCE.getRegexTextTransformer_PatternForGroupingAndRegex();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.StringReplacementTextTransformerImpl <em>String Replacement Text Transformer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.StringReplacementTextTransformerImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getStringReplacementTextTransformer()
		 * @@generated
		 */
		EClass STRING_REPLACEMENT_TEXT_TRANSFORMER = eINSTANCE.getStringReplacementTextTransformer();

		/**
		 * The meta object literal for the '<em><b>String Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT = eINSTANCE.getStringReplacementTextTransformer_StringReplacement();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceActionImpl <em>Reference Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ReferenceActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getReferenceAction()
		 * @@generated
		 */
		EClass REFERENCE_ACTION = eINSTANCE.getReferenceAction();

		/**
		 * The meta object literal for the '<em><b>Reference Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute REFERENCE_ACTION__REFERENCE_ATTRIBUTE = eINSTANCE.getReferenceAction_ReferenceAttribute();

		/**
		 * The meta object literal for the '<em><b>Current Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference REFERENCE_ACTION__CURRENT_ELEMENT = eINSTANCE.getReferenceAction_CurrentElement();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceStaticElementActionImpl <em>Reference Static Element Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ReferenceStaticElementActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getReferenceStaticElementAction()
		 * @@generated
		 */
		EClass REFERENCE_STATIC_ELEMENT_ACTION = eINSTANCE.getReferenceStaticElementAction();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference REFERENCE_STATIC_ELEMENT_ACTION__ELEMENT = eINSTANCE.getReferenceStaticElementAction_Element();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ValueImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getValue()
		 * @@generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute VALUE__NAME = eINSTANCE.getValue_Name();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ContainerSelectionObjectImpl <em>Container Selection Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ContainerSelectionObjectImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getContainerSelectionObject()
		 * @@generated
		 */
		EClass CONTAINER_SELECTION_OBJECT = eINSTANCE.getContainerSelectionObject();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CONTAINER_SELECTION_OBJECT__SELECTION = eINSTANCE.getContainerSelectionObject_Selection();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ParameterObjectImpl <em>Parameter Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ParameterObjectImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getParameterObject()
		 * @@generated
		 */
		EClass PARAMETER_OBJECT = eINSTANCE.getParameterObject();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute PARAMETER_OBJECT__KIND = eINSTANCE.getParameterObject_Kind();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionResultObjectImpl <em>Action Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionResultObjectImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActionResultObject()
		 * @@generated
		 */
		EClass ACTION_RESULT_OBJECT = eINSTANCE.getActionResultObject();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActivityImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActivity()
		 * @@generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference ACTIVITY__ACTIONS = eINSTANCE.getActivity_Actions();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference ACTIVITY__PARAMETERS = eINSTANCE.getActivity_Parameters();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.MatchingResultObjectImpl <em>Matching Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.MatchingResultObjectImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getMatchingResultObject()
		 * @@generated
		 */
		EClass MATCHING_RESULT_OBJECT = eINSTANCE.getMatchingResultObject();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EAttribute MATCHING_RESULT_OBJECT__INDEX = eINSTANCE.getMatchingResultObject_Index();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionWithInParameterImpl <em>Action With In Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionWithInParameterImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActionWithInParameter()
		 * @@generated
		 */
		EClass ACTION_WITH_IN_PARAMETER = eINSTANCE.getActionWithInParameter();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference ACTION_WITH_IN_PARAMETER__IN = eINSTANCE.getActionWithInParameter_In();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ObjectContainerImpl <em>Object Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ObjectContainerImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getObjectContainer()
		 * @@generated
		 */
		EClass OBJECT_CONTAINER = eINSTANCE.getObjectContainer();

		/**
		 * The meta object literal for the '<em><b>Owned Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference OBJECT_CONTAINER__OWNED_OBJECTS = eINSTANCE.getObjectContainer_OwnedObjects();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ReferenceElementActionImpl <em>Reference Element Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ReferenceElementActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getReferenceElementAction()
		 * @@generated
		 */
		EClass REFERENCE_ELEMENT_ACTION = eINSTANCE.getReferenceElementAction();

		/**
		 * The meta object literal for the '<em><b>To Assign</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference REFERENCE_ELEMENT_ACTION__TO_ASSIGN = eINSTANCE.getReferenceElementAction_ToAssign();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.SetContainerActionImpl <em>Set Container Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.SetContainerActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getSetContainerAction()
		 * @@generated
		 */
		EClass SET_CONTAINER_ACTION = eINSTANCE.getSetContainerAction();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.ActionWithOutParameterImpl <em>Action With Out Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.ActionWithOutParameterImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getActionWithOutParameter()
		 * @@generated
		 */
		EClass ACTION_WITH_OUT_PARAMETER = eINSTANCE.getActionWithOutParameter();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference ACTION_WITH_OUT_PARAMETER__OUT = eINSTANCE.getActionWithOutParameter_Out();

		/**
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.ParameterKind <em>Parameter Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.ParameterKind
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getParameterKind()
		 * @@generated
		 */
		EEnum PARAMETER_KIND = eINSTANCE.getParameterKind();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.common.util.URI
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getURI()
		 * @@generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //Doc2modelPackage
@


1.1
log
@first commit for doc2model api
@
text
@a1179 28
	 * The meta object id for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.CallActivityActionImpl <em>Call Activity Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.CallActivityActionImpl
	 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getCallActivityAction()
	 * @@generated
	 */
	int CALL_ACTIVITY_ACTION = 29;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CALL_ACTIVITY_ACTION__ACTIVITY = 0;

	/**
	 * The number of structural features of the '<em>Call Activity Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 * @@ordered
	 */
	int CALL_ACTIVITY_ACTION_FEATURE_COUNT = 1;

	/**
d1187 1
a1187 1
	int ACTION_WITH_OUT_PARAMETER = 30;
d1215 1
a1215 1
	int PARAMETER_KIND = 31;
d1225 1
a1225 1
	int URI = 32;
a1946 21
	 * Returns the meta object for class '{@@link org.eclipse.emf.doc2model.doc2model.CallActivityAction <em>Call Activity Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for class '<em>Call Activity Action</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CallActivityAction
	 * @@generated
	 */
	EClass getCallActivityAction();

	/**
	 * Returns the meta object for the reference '{@@link org.eclipse.emf.doc2model.doc2model.CallActivityAction#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@return the meta object for the reference '<em>Activity</em>'.
	 * @@see org.eclipse.emf.doc2model.doc2model.CallActivityAction#getActivity()
	 * @@see #getCallActivityAction()
	 * @@generated
	 */
	EReference getCallActivityAction_Activity();

	/**
a2612 18
		 * The meta object literal for the '{@@link org.eclipse.emf.doc2model.doc2model.impl.CallActivityActionImpl <em>Call Activity Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.CallActivityActionImpl
		 * @@see org.eclipse.emf.doc2model.doc2model.impl.Doc2modelPackageImpl#getCallActivityAction()
		 * @@generated
		 */
		EClass CALL_ACTIVITY_ACTION = eINSTANCE.getCallActivityAction();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @@generated
		 */
		EReference CALL_ACTIVITY_ACTION__ACTIVITY = eINSTANCE.getCallActivityAction_Activity();

		/**
@

