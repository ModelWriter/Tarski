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

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.doc2model.doc2model.ActionResultObject;
import org.eclipse.emf.doc2model.doc2model.Activity;
import org.eclipse.emf.doc2model.doc2model.AddElementInSelection;
import org.eclipse.emf.doc2model.doc2model.Configuration;
import org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject;
import org.eclipse.emf.doc2model.doc2model.CreateElementAction;
import org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection;
import org.eclipse.emf.doc2model.doc2model.Doc2Model;
import org.eclipse.emf.doc2model.doc2model.Doc2modelFactory;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.EPackageReference;
import org.eclipse.emf.doc2model.doc2model.FillAttributeAction;
import org.eclipse.emf.doc2model.doc2model.InitialModel;
import org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder;
import org.eclipse.emf.doc2model.doc2model.LastElementCreatedSelection;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.doc2model.MatchingResultObject;
import org.eclipse.emf.doc2model.doc2model.ParameterKind;
import org.eclipse.emf.doc2model.doc2model.ParameterObject;
import org.eclipse.emf.doc2model.doc2model.ReferenceElementAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction;
import org.eclipse.emf.doc2model.doc2model.RegexTextTransformer;
import org.eclipse.emf.doc2model.doc2model.Rule;
import org.eclipse.emf.doc2model.doc2model.StaticElementSelection;
import org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer;
import org.eclipse.emf.doc2model.doc2model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @@generated
 */
public class Doc2modelFactoryImpl extends EFactoryImpl implements Doc2modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public static Doc2modelFactory init() {
		try {
			Doc2modelFactory theDoc2modelFactory = (Doc2modelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/doc2model/1.0"); 
			if (theDoc2modelFactory != null) {
				return theDoc2modelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Doc2modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Doc2modelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Doc2modelPackage.DOC2_MODEL: return createDoc2Model();
			case Doc2modelPackage.CONFIGURATION: return createConfiguration();
			case Doc2modelPackage.INITIAL_MODEL: return createInitialModel();
			case Doc2modelPackage.MATCH: return createMatch();
			case Doc2modelPackage.RULE: return createRule();
			case Doc2modelPackage.CURRENT_CONTAINER_SELECTION: return createCurrentContainerSelection();
			case Doc2modelPackage.LAST_ELEMENT_CREATED_SELECTION: return createLastElementCreatedSelection();
			case Doc2modelPackage.STATIC_ELEMENT_SELECTION: return createStaticElementSelection();
			case Doc2modelPackage.LAST_CONTAINER_CONSIDERING_MATCH_ORDER: return createLastContainerConsideringMatchOrder();
			case Doc2modelPackage.CREATE_ELEMENT_ACTION: return createCreateElementAction();
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION: return createFillAttributeAction();
			case Doc2modelPackage.EPACKAGE_REFERENCE: return createEPackageReference();
			case Doc2modelPackage.REGEX_TEXT_TRANSFORMER: return createRegexTextTransformer();
			case Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER: return createStringReplacementTextTransformer();
			case Doc2modelPackage.REFERENCE_STATIC_ELEMENT_ACTION: return createReferenceStaticElementAction();
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT: return createContainerSelectionObject();
			case Doc2modelPackage.PARAMETER_OBJECT: return createParameterObject();
			case Doc2modelPackage.ACTION_RESULT_OBJECT: return createActionResultObject();
			case Doc2modelPackage.ACTIVITY: return createActivity();
			case Doc2modelPackage.MATCHING_RESULT_OBJECT: return createMatchingResultObject();
			case Doc2modelPackage.REFERENCE_ELEMENT_ACTION: return createReferenceElementAction();
			case Doc2modelPackage.SET_CONTAINER_ACTION: return createSetContainerAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Doc2modelPackage.PARAMETER_KIND:
				return createParameterKindFromString(eDataType, initialValue);
			case Doc2modelPackage.URI:
				return createURIFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Doc2modelPackage.PARAMETER_KIND:
				return convertParameterKindToString(eDataType, instanceValue);
			case Doc2modelPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Doc2Model createDoc2Model() {
		Doc2ModelImpl doc2Model = new Doc2ModelImpl();
		return doc2Model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public InitialModel createInitialModel() {
		InitialModelImpl initialModel = new InitialModelImpl();
		return initialModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Match createMatch() {
		MatchImpl match = new MatchImpl();
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public CurrentContainerSelection createCurrentContainerSelection() {
		CurrentContainerSelectionImpl currentContainerSelection = new CurrentContainerSelectionImpl();
		return currentContainerSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public LastElementCreatedSelection createLastElementCreatedSelection() {
		LastElementCreatedSelectionImpl lastElementCreatedSelection = new LastElementCreatedSelectionImpl();
		return lastElementCreatedSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public StaticElementSelection createStaticElementSelection() {
		StaticElementSelectionImpl staticElementSelection = new StaticElementSelectionImpl();
		return staticElementSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public LastContainerConsideringMatchOrder createLastContainerConsideringMatchOrder() {
		LastContainerConsideringMatchOrderImpl lastContainerConsideringMatchOrder = new LastContainerConsideringMatchOrderImpl();
		return lastContainerConsideringMatchOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public CreateElementAction createCreateElementAction() {
		CreateElementActionImpl createElementAction = new CreateElementActionImpl();
		return createElementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public FillAttributeAction createFillAttributeAction() {
		FillAttributeActionImpl fillAttributeAction = new FillAttributeActionImpl();
		return fillAttributeAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public EPackageReference createEPackageReference() {
		EPackageReferenceImpl ePackageReference = new EPackageReferenceImpl();
		return ePackageReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public RegexTextTransformer createRegexTextTransformer() {
		RegexTextTransformerImpl regexTextTransformer = new RegexTextTransformerImpl();
		return regexTextTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public StringReplacementTextTransformer createStringReplacementTextTransformer() {
		StringReplacementTextTransformerImpl stringReplacementTextTransformer = new StringReplacementTextTransformerImpl();
		return stringReplacementTextTransformer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ReferenceStaticElementAction createReferenceStaticElementAction() {
		ReferenceStaticElementActionImpl referenceStaticElementAction = new ReferenceStaticElementActionImpl();
		return referenceStaticElementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ContainerSelectionObject createContainerSelectionObject() {
		ContainerSelectionObjectImpl containerSelectionObject = new ContainerSelectionObjectImpl();
		return containerSelectionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ParameterObject createParameterObject() {
		ParameterObjectImpl parameterObject = new ParameterObjectImpl();
		return parameterObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ActionResultObject createActionResultObject() {
		ActionResultObjectImpl actionResultObject = new ActionResultObjectImpl();
		return actionResultObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public MatchingResultObject createMatchingResultObject() {
		MatchingResultObjectImpl matchingResultObject = new MatchingResultObjectImpl();
		return matchingResultObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ReferenceElementAction createReferenceElementAction() {
		ReferenceElementActionImpl referenceElementAction = new ReferenceElementActionImpl();
		return referenceElementAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public SetContainerAction createSetContainerAction() {
		SetContainerActionImpl setContainerAction = new SetContainerActionImpl();
		return setContainerAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public ParameterKind createParameterKindFromString(EDataType eDataType, String initialValue) {
		ParameterKind result = ParameterKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public String convertParameterKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Doc2modelPackage getDoc2modelPackage() {
		return (Doc2modelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@deprecated
	 * @@generated
	 */
	@@Deprecated
	public static Doc2modelPackage getPackage() {
		return Doc2modelPackage.eINSTANCE;
	}

} //Doc2modelFactoryImpl
@


1.1
log
@first commit for doc2model api
@
text
@a118 1
			case Doc2modelPackage.CALL_ACTIVITY_ACTION: return createCallActivityAction();
a382 10
	public CallActivityAction createCallActivityAction() {
		CallActivityActionImpl callActivityAction = new CallActivityActionImpl();
		return callActivityAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
@

