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
date	2010.03.02.22.19.51;	author tfaure;	state Exp;
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
package org.eclipse.emf.doc2model.doc2model.impl;

import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.doc2model.doc2model.ActionResultObject;
import org.eclipse.emf.doc2model.doc2model.ActionWithInParameter;
import org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter;
import org.eclipse.emf.doc2model.doc2model.Activity;
import org.eclipse.emf.doc2model.doc2model.AddElementInSelection;
import org.eclipse.emf.doc2model.doc2model.CallActivityAction;
import org.eclipse.emf.doc2model.doc2model.Configuration;
import org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject;
import org.eclipse.emf.doc2model.doc2model.CreateElementAction;
import org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection;
import org.eclipse.emf.doc2model.doc2model.Doc2Model;
import org.eclipse.emf.doc2model.doc2model.Doc2modelFactory;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.EPackageReference;
import org.eclipse.emf.doc2model.doc2model.ElementSelection;
import org.eclipse.emf.doc2model.doc2model.FillAttributeAction;
import org.eclipse.emf.doc2model.doc2model.InitialModel;
import org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder;
import org.eclipse.emf.doc2model.doc2model.LastElementCreatedSelection;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.doc2model.MatchingResultObject;
import org.eclipse.emf.doc2model.doc2model.ObjectContainer;
import org.eclipse.emf.doc2model.doc2model.ParameterKind;
import org.eclipse.emf.doc2model.doc2model.ParameterObject;
import org.eclipse.emf.doc2model.doc2model.ReferenceAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceElementAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction;
import org.eclipse.emf.doc2model.doc2model.RegexTextTransformer;
import org.eclipse.emf.doc2model.doc2model.Rule;
import org.eclipse.emf.doc2model.doc2model.SetContainerAction;
import org.eclipse.emf.doc2model.doc2model.StaticElementSelection;
import org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer;
import org.eclipse.emf.doc2model.doc2model.TransformHandledText;
import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @@generated
 */
public class Doc2modelPackageImpl extends EPackageImpl implements Doc2modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass doc2ModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass initialModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass matchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass elementSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass currentContainerSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass lastElementCreatedSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass staticElementSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass lastContainerConsideringMatchOrderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass createElementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass fillAttributeActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass transformHandledTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass ePackageReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass regexTextTransformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass stringReplacementTextTransformerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass referenceActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass referenceStaticElementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass containerSelectionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass parameterObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass actionResultObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass matchingResultObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass actionWithInParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass objectContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass referenceElementActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass setContainerActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EClass actionWithOutParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EEnum parameterKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see org.eclipse.emf.ecore.EPackage.Registry
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#eNS_URI
	 * @@see #init()
	 * @@generated
	 */
	private Doc2modelPackageImpl() {
		super(eNS_URI, Doc2modelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@@link Doc2modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@see #eNS_URI
	 * @@see #createPackageContents()
	 * @@see #initializePackageContents()
	 * @@generated
	 */
	public static Doc2modelPackage init() {
		if (isInited) return (Doc2modelPackage)EPackage.Registry.INSTANCE.getEPackage(Doc2modelPackage.eNS_URI);

		// Obtain or create and register package
		Doc2modelPackageImpl theDoc2modelPackage = (Doc2modelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Doc2modelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Doc2modelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDoc2modelPackage.createPackageContents();

		// Initialize created meta-data
		theDoc2modelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDoc2modelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Doc2modelPackage.eNS_URI, theDoc2modelPackage);
		return theDoc2modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getDoc2Model() {
		return doc2ModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getDoc2Model_Configuration() {
		return (EReference)doc2ModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getDoc2Model_Rules() {
		return (EReference)doc2ModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getDoc2Model_OwnedMatches() {
		return (EReference)doc2ModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getDoc2Model_OwnedActions() {
		return (EReference)doc2ModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getDoc2Model_InitialAction() {
		return (EReference)doc2ModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getConfiguration_InitialModel() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getConfiguration_EPackages() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getConfiguration_Extension() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getInitialModel() {
		return initialModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getInitialModel_Copy() {
		return (EAttribute)initialModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getInitialModel_Reference() {
		return (EReference)initialModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getMatch() {
		return matchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getMatch_Uri() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getMatch_HigherThan() {
		return (EReference)matchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getMatch_LowerThan() {
		return (EReference)matchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getMatch_Rule() {
		return (EReference)matchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getRule_Match() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getRule_Actions() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getElementSelection() {
		return elementSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getElementSelection_EReferenceOwning() {
		return (EAttribute)elementSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getCurrentContainerSelection() {
		return currentContainerSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getLastElementCreatedSelection() {
		return lastElementCreatedSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getStaticElementSelection() {
		return staticElementSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getStaticElementSelection_Element() {
		return (EReference)staticElementSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getLastContainerConsideringMatchOrder() {
		return lastContainerConsideringMatchOrderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getCreateElementAction() {
		return createElementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getCreateElementAction_EClassName() {
		return (EAttribute)createElementActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getCreateElementAction_Epackage() {
		return (EReference)createElementActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getCreateElementAction_NewElement() {
		return (EReference)createElementActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getCreateElementAction_Container() {
		return (EReference)createElementActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getFillAttributeAction() {
		return fillAttributeActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getFillAttributeAction_Attribute() {
		return (EAttribute)fillAttributeActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getFillAttributeAction_EobjectContainingAttribute() {
		return (EReference)fillAttributeActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getTransformHandledText() {
		return transformHandledTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getEPackageReference() {
		return ePackageReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getEPackageReference_Uri() {
		return (EAttribute)ePackageReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getRegexTextTransformer() {
		return regexTextTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getRegexTextTransformer_PatternForGroupingAndRegex() {
		return (EAttribute)regexTextTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getStringReplacementTextTransformer() {
		return stringReplacementTextTransformerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getStringReplacementTextTransformer_StringReplacement() {
		return (EAttribute)stringReplacementTextTransformerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getReferenceAction() {
		return referenceActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getReferenceAction_ReferenceAttribute() {
		return (EAttribute)referenceActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getReferenceAction_CurrentElement() {
		return (EReference)referenceActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getReferenceStaticElementAction() {
		return referenceStaticElementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getReferenceStaticElementAction_Element() {
		return (EReference)referenceStaticElementActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getValue_Name() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getContainerSelectionObject() {
		return containerSelectionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getContainerSelectionObject_Selection() {
		return (EReference)containerSelectionObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getParameterObject() {
		return parameterObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getParameterObject_Kind() {
		return (EAttribute)parameterObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getActionResultObject() {
		return actionResultObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getActivity_Actions() {
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getActivity_Parameters() {
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getMatchingResultObject() {
		return matchingResultObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EAttribute getMatchingResultObject_Index() {
		return (EAttribute)matchingResultObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getActionWithInParameter() {
		return actionWithInParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getActionWithInParameter_In() {
		return (EReference)actionWithInParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getObjectContainer() {
		return objectContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getObjectContainer_OwnedObjects() {
		return (EReference)objectContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getReferenceElementAction() {
		return referenceElementActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getReferenceElementAction_ToAssign() {
		return (EReference)referenceElementActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getSetContainerAction() {
		return setContainerActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EClass getActionWithOutParameter() {
		return actionWithOutParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getActionWithOutParameter_Out() {
		return (EReference)actionWithOutParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EEnum getParameterKind() {
		return parameterKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Doc2modelFactory getDoc2modelFactory() {
		return (Doc2modelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		doc2ModelEClass = createEClass(DOC2_MODEL);
		createEReference(doc2ModelEClass, DOC2_MODEL__CONFIGURATION);
		createEReference(doc2ModelEClass, DOC2_MODEL__RULES);
		createEReference(doc2ModelEClass, DOC2_MODEL__OWNED_MATCHES);
		createEReference(doc2ModelEClass, DOC2_MODEL__OWNED_ACTIONS);
		createEReference(doc2ModelEClass, DOC2_MODEL__INITIAL_ACTION);

		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__INITIAL_MODEL);
		createEReference(configurationEClass, CONFIGURATION__EPACKAGES);
		createEAttribute(configurationEClass, CONFIGURATION__EXTENSION);

		initialModelEClass = createEClass(INITIAL_MODEL);
		createEAttribute(initialModelEClass, INITIAL_MODEL__COPY);
		createEReference(initialModelEClass, INITIAL_MODEL__REFERENCE);

		matchEClass = createEClass(MATCH);
		createEAttribute(matchEClass, MATCH__URI);
		createEReference(matchEClass, MATCH__HIGHER_THAN);
		createEReference(matchEClass, MATCH__LOWER_THAN);
		createEReference(matchEClass, MATCH__RULE);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__MATCH);
		createEReference(ruleEClass, RULE__ACTIONS);

		actionEClass = createEClass(ACTION);

		elementSelectionEClass = createEClass(ELEMENT_SELECTION);
		createEAttribute(elementSelectionEClass, ELEMENT_SELECTION__EREFERENCE_OWNING);

		currentContainerSelectionEClass = createEClass(CURRENT_CONTAINER_SELECTION);

		lastElementCreatedSelectionEClass = createEClass(LAST_ELEMENT_CREATED_SELECTION);

		staticElementSelectionEClass = createEClass(STATIC_ELEMENT_SELECTION);
		createEReference(staticElementSelectionEClass, STATIC_ELEMENT_SELECTION__ELEMENT);

		lastContainerConsideringMatchOrderEClass = createEClass(LAST_CONTAINER_CONSIDERING_MATCH_ORDER);

		createElementActionEClass = createEClass(CREATE_ELEMENT_ACTION);
		createEAttribute(createElementActionEClass, CREATE_ELEMENT_ACTION__ECLASS_NAME);
		createEReference(createElementActionEClass, CREATE_ELEMENT_ACTION__EPACKAGE);
		createEReference(createElementActionEClass, CREATE_ELEMENT_ACTION__NEW_ELEMENT);
		createEReference(createElementActionEClass, CREATE_ELEMENT_ACTION__CONTAINER);

		fillAttributeActionEClass = createEClass(FILL_ATTRIBUTE_ACTION);
		createEAttribute(fillAttributeActionEClass, FILL_ATTRIBUTE_ACTION__ATTRIBUTE);
		createEReference(fillAttributeActionEClass, FILL_ATTRIBUTE_ACTION__EOBJECT_CONTAINING_ATTRIBUTE);

		transformHandledTextEClass = createEClass(TRANSFORM_HANDLED_TEXT);

		ePackageReferenceEClass = createEClass(EPACKAGE_REFERENCE);
		createEAttribute(ePackageReferenceEClass, EPACKAGE_REFERENCE__URI);

		regexTextTransformerEClass = createEClass(REGEX_TEXT_TRANSFORMER);
		createEAttribute(regexTextTransformerEClass, REGEX_TEXT_TRANSFORMER__PATTERN_FOR_GROUPING_AND_REGEX);

		stringReplacementTextTransformerEClass = createEClass(STRING_REPLACEMENT_TEXT_TRANSFORMER);
		createEAttribute(stringReplacementTextTransformerEClass, STRING_REPLACEMENT_TEXT_TRANSFORMER__STRING_REPLACEMENT);

		referenceActionEClass = createEClass(REFERENCE_ACTION);
		createEAttribute(referenceActionEClass, REFERENCE_ACTION__REFERENCE_ATTRIBUTE);
		createEReference(referenceActionEClass, REFERENCE_ACTION__CURRENT_ELEMENT);

		referenceStaticElementActionEClass = createEClass(REFERENCE_STATIC_ELEMENT_ACTION);
		createEReference(referenceStaticElementActionEClass, REFERENCE_STATIC_ELEMENT_ACTION__ELEMENT);

		valueEClass = createEClass(VALUE);
		createEAttribute(valueEClass, VALUE__NAME);

		containerSelectionObjectEClass = createEClass(CONTAINER_SELECTION_OBJECT);
		createEReference(containerSelectionObjectEClass, CONTAINER_SELECTION_OBJECT__SELECTION);

		parameterObjectEClass = createEClass(PARAMETER_OBJECT);
		createEAttribute(parameterObjectEClass, PARAMETER_OBJECT__KIND);

		actionResultObjectEClass = createEClass(ACTION_RESULT_OBJECT);

		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__ACTIONS);
		createEReference(activityEClass, ACTIVITY__PARAMETERS);

		matchingResultObjectEClass = createEClass(MATCHING_RESULT_OBJECT);
		createEAttribute(matchingResultObjectEClass, MATCHING_RESULT_OBJECT__INDEX);

		actionWithInParameterEClass = createEClass(ACTION_WITH_IN_PARAMETER);
		createEReference(actionWithInParameterEClass, ACTION_WITH_IN_PARAMETER__IN);

		objectContainerEClass = createEClass(OBJECT_CONTAINER);
		createEReference(objectContainerEClass, OBJECT_CONTAINER__OWNED_OBJECTS);

		referenceElementActionEClass = createEClass(REFERENCE_ELEMENT_ACTION);
		createEReference(referenceElementActionEClass, REFERENCE_ELEMENT_ACTION__TO_ASSIGN);

		setContainerActionEClass = createEClass(SET_CONTAINER_ACTION);

		actionWithOutParameterEClass = createEClass(ACTION_WITH_OUT_PARAMETER);
		createEReference(actionWithOutParameterEClass, ACTION_WITH_OUT_PARAMETER__OUT);

		// Create enums
		parameterKindEEnum = createEEnum(PARAMETER_KIND);

		// Create data types
		uriEDataType = createEDataType(URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		doc2ModelEClass.getESuperTypes().add(this.getObjectContainer());
		matchEClass.getESuperTypes().add(this.getObjectContainer());
		currentContainerSelectionEClass.getESuperTypes().add(this.getElementSelection());
		lastElementCreatedSelectionEClass.getESuperTypes().add(this.getElementSelection());
		staticElementSelectionEClass.getESuperTypes().add(this.getElementSelection());
		lastContainerConsideringMatchOrderEClass.getESuperTypes().add(this.getElementSelection());
		createElementActionEClass.getESuperTypes().add(this.getAction());
		fillAttributeActionEClass.getESuperTypes().add(this.getActionWithInParameter());
		transformHandledTextEClass.getESuperTypes().add(this.getActionWithInParameter());
		transformHandledTextEClass.getESuperTypes().add(this.getActionWithOutParameter());
		regexTextTransformerEClass.getESuperTypes().add(this.getTransformHandledText());
		stringReplacementTextTransformerEClass.getESuperTypes().add(this.getTransformHandledText());
		referenceActionEClass.getESuperTypes().add(this.getAction());
		referenceStaticElementActionEClass.getESuperTypes().add(this.getReferenceAction());
		containerSelectionObjectEClass.getESuperTypes().add(this.getValue());
		parameterObjectEClass.getESuperTypes().add(this.getValue());
		actionResultObjectEClass.getESuperTypes().add(this.getValue());
		activityEClass.getESuperTypes().add(this.getAction());
		activityEClass.getESuperTypes().add(this.getObjectContainer());
		matchingResultObjectEClass.getESuperTypes().add(this.getValue());
		actionWithInParameterEClass.getESuperTypes().add(this.getAction());
		referenceElementActionEClass.getESuperTypes().add(this.getReferenceAction());
		setContainerActionEClass.getESuperTypes().add(this.getActionWithInParameter());

		// Initialize classes and features; add operations and parameters
		initEClass(doc2ModelEClass, Doc2Model.class, "Doc2Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDoc2Model_Configuration(), this.getConfiguration(), null, "configuration", null, 1, 1, Doc2Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoc2Model_Rules(), this.getRule(), null, "rules", null, 0, -1, Doc2Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoc2Model_OwnedMatches(), this.getMatch(), null, "ownedMatches", null, 0, -1, Doc2Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoc2Model_OwnedActions(), this.getAction(), null, "ownedActions", null, 0, -1, Doc2Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoc2Model_InitialAction(), this.getAction(), null, "initialAction", null, 0, 1, Doc2Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_InitialModel(), this.getInitialModel(), null, "initialModel", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_EPackages(), this.getEPackageReference(), null, "ePackages", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Extension(), theEcorePackage.getEString(), "extension", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initialModelEClass, InitialModel.class, "InitialModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInitialModel_Copy(), theEcorePackage.getEBoolean(), "copy", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitialModel_Reference(), ecorePackage.getEObject(), null, "reference", null, 0, 1, InitialModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchEClass, Match.class, "Match", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatch_Uri(), theEcorePackage.getEString(), "uri", null, 0, -1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_HigherThan(), this.getMatch(), this.getMatch_LowerThan(), "higherThan", null, 0, -1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_LowerThan(), this.getMatch(), this.getMatch_HigherThan(), "lowerThan", null, 0, -1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Rule(), this.getRule(), this.getRule_Match(), "rule", null, 0, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(matchEClass, this.getURI(), "getURI", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Match(), this.getMatch(), this.getMatch_Rule(), "match", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Actions(), this.getAction(), null, "actions", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementSelectionEClass, ElementSelection.class, "ElementSelection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementSelection_EReferenceOwning(), theEcorePackage.getEString(), "eReferenceOwning", null, 0, 1, ElementSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(elementSelectionEClass, ecorePackage.getEObject(), "getElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(currentContainerSelectionEClass, CurrentContainerSelection.class, "CurrentContainerSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lastElementCreatedSelectionEClass, LastElementCreatedSelection.class, "LastElementCreatedSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(staticElementSelectionEClass, StaticElementSelection.class, "StaticElementSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStaticElementSelection_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, StaticElementSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lastContainerConsideringMatchOrderEClass, LastContainerConsideringMatchOrder.class, "LastContainerConsideringMatchOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(createElementActionEClass, CreateElementAction.class, "CreateElementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateElementAction_EClassName(), ecorePackage.getEString(), "eClassName", null, 0, 1, CreateElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateElementAction_Epackage(), this.getEPackageReference(), null, "epackage", null, 0, 1, CreateElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateElementAction_NewElement(), this.getActionResultObject(), null, "newElement", null, 0, 1, CreateElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateElementAction_Container(), this.getValue(), null, "container", null, 0, 1, CreateElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fillAttributeActionEClass, FillAttributeAction.class, "FillAttributeAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFillAttributeAction_Attribute(), theEcorePackage.getEString(), "attribute", null, 0, 1, FillAttributeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFillAttributeAction_EobjectContainingAttribute(), this.getValue(), null, "eobjectContainingAttribute", null, 0, 1, FillAttributeAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformHandledTextEClass, TransformHandledText.class, "TransformHandledText", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ePackageReferenceEClass, EPackageReference.class, "EPackageReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEPackageReference_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, EPackageReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regexTextTransformerEClass, RegexTextTransformer.class, "RegexTextTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegexTextTransformer_PatternForGroupingAndRegex(), theEcorePackage.getEString(), "patternForGroupingAndRegex", null, 0, 1, RegexTextTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringReplacementTextTransformerEClass, StringReplacementTextTransformer.class, "StringReplacementTextTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringReplacementTextTransformer_StringReplacement(), theEcorePackage.getEString(), "stringReplacement", null, 0, 1, StringReplacementTextTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceActionEClass, ReferenceAction.class, "ReferenceAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceAction_ReferenceAttribute(), theEcorePackage.getEString(), "referenceAttribute", null, 0, 1, ReferenceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceAction_CurrentElement(), this.getValue(), null, "currentElement", null, 0, 1, ReferenceAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceStaticElementActionEClass, ReferenceStaticElementAction.class, "ReferenceStaticElementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceStaticElementAction_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, ReferenceStaticElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValue_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerSelectionObjectEClass, ContainerSelectionObject.class, "ContainerSelectionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerSelectionObject_Selection(), this.getElementSelection(), null, "selection", null, 0, 1, ContainerSelectionObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterObjectEClass, ParameterObject.class, "ParameterObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterObject_Kind(), this.getParameterKind(), "kind", null, 0, 1, ParameterObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionResultObjectEClass, ActionResultObject.class, "ActionResultObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_Actions(), this.getAction(), null, "actions", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_Parameters(), this.getParameterObject(), null, "parameters", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchingResultObjectEClass, MatchingResultObject.class, "MatchingResultObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatchingResultObject_Index(), theEcorePackage.getEInt(), "index", null, 0, 1, MatchingResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionWithInParameterEClass, ActionWithInParameter.class, "ActionWithInParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionWithInParameter_In(), this.getValue(), null, "in", null, 0, 1, ActionWithInParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectContainerEClass, ObjectContainer.class, "ObjectContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectContainer_OwnedObjects(), this.getValue(), null, "ownedObjects", null, 0, -1, ObjectContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceElementActionEClass, ReferenceElementAction.class, "ReferenceElementAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceElementAction_ToAssign(), this.getValue(), null, "toAssign", null, 0, 1, ReferenceElementAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setContainerActionEClass, SetContainerAction.class, "SetContainerAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionWithOutParameterEClass, ActionWithOutParameter.class, "ActionWithOutParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionWithOutParameter_Out(), this.getValue(), null, "out", null, 0, 1, ActionWithOutParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(parameterKindEEnum, ParameterKind.class, "ParameterKind");
		addEEnumLiteral(parameterKindEEnum, ParameterKind.IN);
		addEEnumLiteral(parameterKindEEnum, ParameterKind.OUT);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Doc2modelPackageImpl
@


1.1
log
@first commit for doc2model api
@
text
@a273 7
	private EClass callActivityActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
a970 18
	public EClass getCallActivityAction() {
		return callActivityActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EReference getCallActivityAction_Activity() {
		return (EReference)callActivityActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
a1126 3
		callActivityActionEClass = createEClass(CALL_ACTIVITY_ACTION);
		createEReference(callActivityActionEClass, CALL_ACTIVITY_ACTION__ACTIVITY);

a1293 3
		initEClass(callActivityActionEClass, CallActivityAction.class, "CallActivityAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallActivityAction_Activity(), this.getActivity(), null, "activity", null, 0, 1, CallActivityAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

@

