package org.eclipse.emf.doc2model.doc2model.util;

import java.util.List;

import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.doc2model.doc2model.ActionResultObject;
import org.eclipse.emf.doc2model.doc2model.ActionWithInParameter;
import org.eclipse.emf.doc2model.doc2model.Activity;
import org.eclipse.emf.doc2model.doc2model.AddElementInSelection;
import org.eclipse.emf.doc2model.doc2model.Configuration;
import org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject;
import org.eclipse.emf.doc2model.doc2model.CreateElementAction;
import org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection;
import org.eclipse.emf.doc2model.doc2model.Doc2Model;
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
import org.eclipse.emf.doc2model.doc2model.ParameterObject;
import org.eclipse.emf.doc2model.doc2model.ReferenceAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceElementAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction;
import org.eclipse.emf.doc2model.doc2model.RegexTextTransformer;
import org.eclipse.emf.doc2model.doc2model.Rule;
import org.eclipse.emf.doc2model.doc2model.StaticElementSelection;
import org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer;
import org.eclipse.emf.doc2model.doc2model.TransformHandledText;
import org.eclipse.emf.doc2model.doc2model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage
 * @generated
 */
public class Doc2modelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Doc2modelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Doc2modelSwitch() {
		if (modelPackage == null) {
			modelPackage = Doc2modelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Doc2modelPackage.DOC2_MODEL: {
				Doc2Model doc2Model = (Doc2Model)theEObject;
				T result = caseDoc2Model(doc2Model);
				if (result == null) result = caseObjectContainer(doc2Model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.INITIAL_MODEL: {
				InitialModel initialModel = (InitialModel)theEObject;
				T result = caseInitialModel(initialModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.MATCH: {
				Match match = (Match)theEObject;
				T result = caseMatch(match);
				if (result == null) result = caseObjectContainer(match);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.ELEMENT_SELECTION: {
				ElementSelection elementSelection = (ElementSelection)theEObject;
				T result = caseElementSelection(elementSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.CURRENT_CONTAINER_SELECTION: {
				CurrentContainerSelection currentContainerSelection = (CurrentContainerSelection)theEObject;
				T result = caseCurrentContainerSelection(currentContainerSelection);
				if (result == null) result = caseElementSelection(currentContainerSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.LAST_ELEMENT_CREATED_SELECTION: {
				LastElementCreatedSelection lastElementCreatedSelection = (LastElementCreatedSelection)theEObject;
				T result = caseLastElementCreatedSelection(lastElementCreatedSelection);
				if (result == null) result = caseElementSelection(lastElementCreatedSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.STATIC_ELEMENT_SELECTION: {
				StaticElementSelection staticElementSelection = (StaticElementSelection)theEObject;
				T result = caseStaticElementSelection(staticElementSelection);
				if (result == null) result = caseElementSelection(staticElementSelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.LAST_CONTAINER_CONSIDERING_MATCH_ORDER: {
				LastContainerConsideringMatchOrder lastContainerConsideringMatchOrder = (LastContainerConsideringMatchOrder)theEObject;
				T result = caseLastContainerConsideringMatchOrder(lastContainerConsideringMatchOrder);
				if (result == null) result = caseElementSelection(lastContainerConsideringMatchOrder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.CREATE_ELEMENT_ACTION: {
				CreateElementAction createElementAction = (CreateElementAction)theEObject;
				T result = caseCreateElementAction(createElementAction);
				if (result == null) result = caseAction(createElementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.FILL_ATTRIBUTE_ACTION: {
				FillAttributeAction fillAttributeAction = (FillAttributeAction)theEObject;
				T result = caseFillAttributeAction(fillAttributeAction);
				if (result == null) result = caseActionWithInParameter(fillAttributeAction);
				if (result == null) result = caseAction(fillAttributeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.TRANSFORM_HANDLED_TEXT: {
				TransformHandledText transformHandledText = (TransformHandledText)theEObject;
				T result = caseTransformHandledText(transformHandledText);
				if (result == null) result = caseActionWithInParameter(transformHandledText);
				if (result == null) result = caseActionWithOutParameter(transformHandledText);
				if (result == null) result = caseAction(transformHandledText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.EPACKAGE_REFERENCE: {
				EPackageReference ePackageReference = (EPackageReference)theEObject;
				T result = caseEPackageReference(ePackageReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.REGEX_TEXT_TRANSFORMER: {
				RegexTextTransformer regexTextTransformer = (RegexTextTransformer)theEObject;
				T result = caseRegexTextTransformer(regexTextTransformer);
				if (result == null) result = caseTransformHandledText(regexTextTransformer);
				if (result == null) result = caseActionWithInParameter(regexTextTransformer);
				if (result == null) result = caseActionWithOutParameter(regexTextTransformer);
				if (result == null) result = caseAction(regexTextTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.STRING_REPLACEMENT_TEXT_TRANSFORMER: {
				StringReplacementTextTransformer stringReplacementTextTransformer = (StringReplacementTextTransformer)theEObject;
				T result = caseStringReplacementTextTransformer(stringReplacementTextTransformer);
				if (result == null) result = caseTransformHandledText(stringReplacementTextTransformer);
				if (result == null) result = caseActionWithInParameter(stringReplacementTextTransformer);
				if (result == null) result = caseActionWithOutParameter(stringReplacementTextTransformer);
				if (result == null) result = caseAction(stringReplacementTextTransformer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.REFERENCE_ACTION: {
				ReferenceAction referenceAction = (ReferenceAction)theEObject;
				T result = caseReferenceAction(referenceAction);
				if (result == null) result = caseAction(referenceAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.REFERENCE_STATIC_ELEMENT_ACTION: {
				ReferenceStaticElementAction referenceStaticElementAction = (ReferenceStaticElementAction)theEObject;
				T result = caseReferenceStaticElementAction(referenceStaticElementAction);
				if (result == null) result = caseReferenceAction(referenceStaticElementAction);
				if (result == null) result = caseAction(referenceStaticElementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.VALUE: {
				Value value = (Value)theEObject;
				T result = caseValue(value);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.CONTAINER_SELECTION_OBJECT: {
				ContainerSelectionObject containerSelectionObject = (ContainerSelectionObject)theEObject;
				T result = caseContainerSelectionObject(containerSelectionObject);
				if (result == null) result = caseValue(containerSelectionObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.PARAMETER_OBJECT: {
				ParameterObject parameterObject = (ParameterObject)theEObject;
				T result = caseParameterObject(parameterObject);
				if (result == null) result = caseValue(parameterObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.ACTION_RESULT_OBJECT: {
				ActionResultObject actionResultObject = (ActionResultObject)theEObject;
				T result = caseActionResultObject(actionResultObject);
				if (result == null) result = caseValue(actionResultObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.ACTIVITY: {
				Activity activity = (Activity)theEObject;
				T result = caseActivity(activity);
				if (result == null) result = caseAction(activity);
				if (result == null) result = caseObjectContainer(activity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.MATCHING_RESULT_OBJECT: {
				MatchingResultObject matchingResultObject = (MatchingResultObject)theEObject;
				T result = caseMatchingResultObject(matchingResultObject);
				if (result == null) result = caseValue(matchingResultObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.ACTION_WITH_IN_PARAMETER: {
				ActionWithInParameter actionWithInParameter = (ActionWithInParameter)theEObject;
				T result = caseActionWithInParameter(actionWithInParameter);
				if (result == null) result = caseAction(actionWithInParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.OBJECT_CONTAINER: {
				ObjectContainer objectContainer = (ObjectContainer)theEObject;
				T result = caseObjectContainer(objectContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.REFERENCE_ELEMENT_ACTION: {
				ReferenceElementAction referenceElementAction = (ReferenceElementAction)theEObject;
				T result = caseReferenceElementAction(referenceElementAction);
				if (result == null) result = caseReferenceAction(referenceElementAction);
				if (result == null) result = caseAction(referenceElementAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.SET_CONTAINER_ACTION: {
				SetContainerAction setContainerAction = (SetContainerAction)theEObject;
				T result = caseSetContainerAction(setContainerAction);
				if (result == null) result = caseActionWithInParameter(setContainerAction);
				if (result == null) result = caseAction(setContainerAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Doc2modelPackage.ACTION_WITH_OUT_PARAMETER: {
				ActionWithOutParameter actionWithOutParameter = (ActionWithOutParameter)theEObject;
				T result = caseActionWithOutParameter(actionWithOutParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Doc2 Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Doc2 Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoc2Model(Doc2Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialModel(InitialModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatch(Match object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementSelection(ElementSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Current Container Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Current Container Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCurrentContainerSelection(CurrentContainerSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Last Element Created Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Last Element Created Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLastElementCreatedSelection(LastElementCreatedSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Element Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Element Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticElementSelection(StaticElementSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Last Container Considering Match Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Last Container Considering Match Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLastContainerConsideringMatchOrder(LastContainerConsideringMatchOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Element Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateElementAction(CreateElementAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fill Attribute Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fill Attribute Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFillAttributeAction(FillAttributeAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transform Handled Text</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transform Handled Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformHandledText(TransformHandledText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EPackage Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EPackage Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEPackageReference(EPackageReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regex Text Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regex Text Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegexTextTransformer(RegexTextTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Replacement Text Transformer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Replacement Text Transformer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringReplacementTextTransformer(StringReplacementTextTransformer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceAction(ReferenceAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Static Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Static Element Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceStaticElementAction(ReferenceStaticElementAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Selection Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Selection Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerSelectionObject(ContainerSelectionObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterObject(ParameterObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Result Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Result Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionResultObject(ActionResultObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matching Result Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matching Result Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchingResultObject(MatchingResultObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action With In Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action With In Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionWithInParameter(ActionWithInParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectContainer(ObjectContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Element Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Element Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceElementAction(ReferenceElementAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Container Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Container Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetContainerAction(SetContainerAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action With Out Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action With Out Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionWithOutParameter(ActionWithOutParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Doc2modelSwitch
