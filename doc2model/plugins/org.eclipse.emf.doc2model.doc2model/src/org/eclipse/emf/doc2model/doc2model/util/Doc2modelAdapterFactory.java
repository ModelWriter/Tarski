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
package org.eclipse.emf.doc2model.doc2model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.doc2model.doc2model.*;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage
 * @@generated
 */
public class Doc2modelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected static Doc2modelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	public Doc2modelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Doc2modelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @@return whether this factory is applicable for the type of the object.
	 * @@generated
	 */
	@@Override
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
	 * @@generated
	 */
	protected Doc2modelSwitch<Adapter> modelSwitch =
		new Doc2modelSwitch<Adapter>() {
			@@Override
			public Adapter caseDoc2Model(Doc2Model object) {
				return createDoc2ModelAdapter();
			}
			@@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@@Override
			public Adapter caseInitialModel(InitialModel object) {
				return createInitialModelAdapter();
			}
			@@Override
			public Adapter caseMatch(Match object) {
				return createMatchAdapter();
			}
			@@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@@Override
			public Adapter caseElementSelection(ElementSelection object) {
				return createElementSelectionAdapter();
			}
			@@Override
			public Adapter caseCurrentContainerSelection(CurrentContainerSelection object) {
				return createCurrentContainerSelectionAdapter();
			}
			@@Override
			public Adapter caseLastElementCreatedSelection(LastElementCreatedSelection object) {
				return createLastElementCreatedSelectionAdapter();
			}
			@@Override
			public Adapter caseStaticElementSelection(StaticElementSelection object) {
				return createStaticElementSelectionAdapter();
			}
			@@Override
			public Adapter caseLastContainerConsideringMatchOrder(LastContainerConsideringMatchOrder object) {
				return createLastContainerConsideringMatchOrderAdapter();
			}
			@@Override
			public Adapter caseCreateElementAction(CreateElementAction object) {
				return createCreateElementActionAdapter();
			}
			@@Override
			public Adapter caseFillAttributeAction(FillAttributeAction object) {
				return createFillAttributeActionAdapter();
			}
			@@Override
			public Adapter caseTransformHandledText(TransformHandledText object) {
				return createTransformHandledTextAdapter();
			}
			@@Override
			public Adapter caseEPackageReference(EPackageReference object) {
				return createEPackageReferenceAdapter();
			}
			@@Override
			public Adapter caseRegexTextTransformer(RegexTextTransformer object) {
				return createRegexTextTransformerAdapter();
			}
			@@Override
			public Adapter caseStringReplacementTextTransformer(StringReplacementTextTransformer object) {
				return createStringReplacementTextTransformerAdapter();
			}
			@@Override
			public Adapter caseReferenceAction(ReferenceAction object) {
				return createReferenceActionAdapter();
			}
			@@Override
			public Adapter caseReferenceStaticElementAction(ReferenceStaticElementAction object) {
				return createReferenceStaticElementActionAdapter();
			}
			@@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@@Override
			public Adapter caseContainerSelectionObject(ContainerSelectionObject object) {
				return createContainerSelectionObjectAdapter();
			}
			@@Override
			public Adapter caseParameterObject(ParameterObject object) {
				return createParameterObjectAdapter();
			}
			@@Override
			public Adapter caseActionResultObject(ActionResultObject object) {
				return createActionResultObjectAdapter();
			}
			@@Override
			public Adapter caseActivity(Activity object) {
				return createActivityAdapter();
			}
			@@Override
			public Adapter caseMatchingResultObject(MatchingResultObject object) {
				return createMatchingResultObjectAdapter();
			}
			@@Override
			public Adapter caseActionWithInParameter(ActionWithInParameter object) {
				return createActionWithInParameterAdapter();
			}
			@@Override
			public Adapter caseObjectContainer(ObjectContainer object) {
				return createObjectContainerAdapter();
			}
			@@Override
			public Adapter caseReferenceElementAction(ReferenceElementAction object) {
				return createReferenceElementActionAdapter();
			}
			@@Override
			public Adapter caseSetContainerAction(SetContainerAction object) {
				return createSetContainerActionAdapter();
			}
			@@Override
			public Adapter caseActionWithOutParameter(ActionWithOutParameter object) {
				return createActionWithOutParameterAdapter();
			}
			@@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param target the object to adapt.
	 * @@return the adapter for the <code>target</code>.
	 * @@generated
	 */
	@@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Doc2Model <em>Doc2 Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2Model
	 * @@generated
	 */
	public Adapter createDoc2ModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Configuration
	 * @@generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.InitialModel <em>Initial Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.InitialModel
	 * @@generated
	 */
	public Adapter createInitialModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Match
	 * @@generated
	 */
	public Adapter createMatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Rule
	 * @@generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Action
	 * @@generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ElementSelection <em>Element Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ElementSelection
	 * @@generated
	 */
	public Adapter createElementSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection <em>Current Container Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection
	 * @@generated
	 */
	public Adapter createCurrentContainerSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.LastElementCreatedSelection <em>Last Element Created Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.LastElementCreatedSelection
	 * @@generated
	 */
	public Adapter createLastElementCreatedSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.StaticElementSelection <em>Static Element Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.StaticElementSelection
	 * @@generated
	 */
	public Adapter createStaticElementSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder <em>Last Container Considering Match Order</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder
	 * @@generated
	 */
	public Adapter createLastContainerConsideringMatchOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction <em>Create Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.CreateElementAction
	 * @@generated
	 */
	public Adapter createCreateElementActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.FillAttributeAction <em>Fill Attribute Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.FillAttributeAction
	 * @@generated
	 */
	public Adapter createFillAttributeActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.TransformHandledText <em>Transform Handled Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.TransformHandledText
	 * @@generated
	 */
	public Adapter createTransformHandledTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.EPackageReference <em>EPackage Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.EPackageReference
	 * @@generated
	 */
	public Adapter createEPackageReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.RegexTextTransformer <em>Regex Text Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.RegexTextTransformer
	 * @@generated
	 */
	public Adapter createRegexTextTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer <em>String Replacement Text Transformer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer
	 * @@generated
	 */
	public Adapter createStringReplacementTextTransformerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceAction <em>Reference Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceAction
	 * @@generated
	 */
	public Adapter createReferenceActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction <em>Reference Static Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction
	 * @@generated
	 */
	public Adapter createReferenceStaticElementActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Value
	 * @@generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject <em>Container Selection Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject
	 * @@generated
	 */
	public Adapter createContainerSelectionObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ParameterObject <em>Parameter Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ParameterObject
	 * @@generated
	 */
	public Adapter createParameterObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ActionResultObject <em>Action Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionResultObject
	 * @@generated
	 */
	public Adapter createActionResultObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.Activity
	 * @@generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.MatchingResultObject <em>Matching Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.MatchingResultObject
	 * @@generated
	 */
	public Adapter createMatchingResultObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ActionWithInParameter <em>Action With In Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionWithInParameter
	 * @@generated
	 */
	public Adapter createActionWithInParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ObjectContainer <em>Object Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ObjectContainer
	 * @@generated
	 */
	public Adapter createObjectContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ReferenceElementAction <em>Reference Element Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ReferenceElementAction
	 * @@generated
	 */
	public Adapter createReferenceElementActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.SetContainerAction <em>Set Container Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.SetContainerAction
	 * @@generated
	 */
	public Adapter createSetContainerActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter <em>Action With Out Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.ActionWithOutParameter
	 * @@generated
	 */
	public Adapter createActionWithOutParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Doc2modelAdapterFactory
@


1.1
log
@first commit for doc2model api
@
text
@a196 4
			public Adapter caseCallActivityAction(CallActivityAction object) {
				return createCallActivityActionAdapter();
			}
			@@Override
a626 14
	 * Creates a new adapter for an object of class '{@@link org.eclipse.emf.doc2model.doc2model.CallActivityAction <em>Call Activity Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @@return the new adapter.
	 * @@see org.eclipse.emf.doc2model.doc2model.CallActivityAction
	 * @@generated
	 */
	public Adapter createCallActivityActionAdapter() {
		return null;
	}

	/**
@

