package org.eclipse.emf.doc2model.engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.doc2model.doc2model.Activity;
import org.eclipse.emf.doc2model.doc2model.ContainerSelectionObject;
import org.eclipse.emf.doc2model.doc2model.CreateElementAction;
import org.eclipse.emf.doc2model.doc2model.ElementSelection;
import org.eclipse.emf.doc2model.doc2model.FillAttributeAction;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.doc2model.MatchingResultObject;
import org.eclipse.emf.doc2model.doc2model.ReferenceAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceElementAction;
import org.eclipse.emf.doc2model.doc2model.ReferenceStaticElementAction;
import org.eclipse.emf.doc2model.doc2model.RegexTextTransformer;
import org.eclipse.emf.doc2model.doc2model.SetContainerAction;
import org.eclipse.emf.doc2model.doc2model.StringReplacementTextTransformer;
import org.eclipse.emf.doc2model.doc2model.TransformHandledText;
import org.eclipse.emf.doc2model.doc2model.Value;
import org.eclipse.emf.doc2model.engine.contracts.VariableResolver;
import org.eclipse.emf.doc2model.engine.exceptions.ActionException;
import org.eclipse.emf.doc2model.engine.selection.ContainerSelectionManager;
import org.eclipse.emf.doc2model.engine.selection.EObjectAdder;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;
import org.eclipse.emf.doc2model.engine.utils.EMFUtil;
import org.eclipse.emf.doc2model.engine.utils.RegexUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ActionParser {

	private final ActionRegistry registry = new ActionRegistry();
	private final ContainerSelectionManager containerSelectionManger;
	private List<VariableResolverInstance> variablesResolver = null;
	private Doc2ModelEngineServices services;
	private List<Action> currentActionsHandled = new LinkedList<Action>();
	private Match currentMatch;
	private ValueResolver resolver = new ValueResolver();
	private List<String> currentMatchResult;

	public ActionParser(Doc2ModelEngineServices services,
			ContainerSelectionManager containerSelectionManger) {
		this.services = services;
		this.containerSelectionManger = containerSelectionManger;
	}

	protected void set(EObject eobject, EStructuralFeature att, Object obj) {
		if (att.isMany()) {
			((Collection) eobject.eGet(att)).add(obj);
		} else {
			eobject.eSet(att, obj);
		}
	}

	protected void parse(TransformHandledText action) {
		if (action instanceof RegexTextTransformer) {
			parse((RegexTextTransformer) action);
		} else if (action instanceof StringReplacementTextTransformer) {
			parse((StringReplacementTextTransformer) action);
		}
	}

	protected List<VariableResolverInstance> getAllVariables() {
		if (variablesResolver == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(
							"org.eclipse.emf.doc2model.engine.variable");
			variablesResolver = new ArrayList<VariableResolverInstance>(
					elements.length);
			for (IConfigurationElement element : elements) {
				String toReplace = element.getAttribute("variableName");
				VariableResolver resolver;
				try {
					resolver = (VariableResolver) element
							.createExecutableExtension("variableResolver");
					VariableResolverInstance instance = new VariableResolverInstance(
							toReplace, resolver);
					variablesResolver.add(instance);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return variablesResolver;
	}

	private class VariableResolverInstance {
		private final VariableResolver resolver;
		private final String toReplace;

		public VariableResolverInstance(String toReplace,
				VariableResolver resolver) {
			this.toReplace = toReplace;
			this.resolver = resolver;
		}
	}

	/**
	 * Parse the list of actions given in parameter.
	 * 
	 * @param actions
	 *            , list of actions
	 * @param result
	 *            , the result of the match
	 * @param match
	 *            , th match to link to a container
	 * @throws ActionException
	 */
	public void parse(List<Action> actions, List<String> result, Match match)
			throws ActionException {
		currentMatchResult = result;
		currentActionsHandled.addAll(actions);
		currentMatch = match;
		// the actions are analysed in store order.
		// If an action doesn't have all its precondition ok it is analysed
		// again next loop
		// we determine error in loop if two times there is the same number of
		// elements
		// in the list of actions (no change)
		int nbElements = currentActionsHandled.size();
		int flag = 0;
		while (!currentActionsHandled.isEmpty() && flag != 2) {
			for (Iterator<Action> i = currentActionsHandled.iterator(); i
					.hasNext();) {
				Action a = i.next();
				if (doParse(a)) {
					i.remove();
				}
			}
			if (nbElements == currentActionsHandled.size()) {
				flag++;
			} else {
				flag = 0;
				nbElements = currentActionsHandled.size();
			}
		}
		if (flag == 2) {
			throw new ActionException("your action is not correct"
					+ currentActionsHandled);
		}
		currentMatchResult = null;
		currentMatch = null;
		resolver.clear();
		currentActionsHandled.clear();
	}

	protected boolean doParse(Action topAction) throws ActionException {
		if (topAction instanceof Activity) {
			return doParse((Activity) topAction);
		} else if (topAction instanceof CreateElementAction) {
			return doParse((CreateElementAction) topAction);
		} else if (topAction instanceof FillAttributeAction) {
			return doParse((FillAttributeAction) topAction);
		} else if (topAction instanceof ReferenceAction) {
			return doParse((ReferenceAction) topAction);
		} else if (topAction instanceof TransformHandledText) {
			return doParse((TransformHandledText) topAction);
		} else if (topAction instanceof SetContainerAction) {
			return doParse((SetContainerAction) topAction);
		} else if (topAction instanceof Activity) {
			return doParse((Activity) topAction);
		}
		return false;
	}

	protected boolean doParse(Activity topAction) throws ActionException {
		List<Action> actionsInActivity = new ArrayList<Action>(topAction
				.getActions().size());
		actionsInActivity.addAll(topAction.getActions());
		int nbElements = actionsInActivity.size();
		int flag = 0;
		// the actions are analysed in store order.
		// If an action doesn't have all its precondition ok it is analysed
		// again next loop
		// we determine error in loop if two times there is the same number of
		// elements
		// in the list of actions (no change)
		while (!actionsInActivity.isEmpty() && flag != 2) {
			for (Iterator<Action> i = actionsInActivity.iterator(); i.hasNext();) {
				Action a = i.next();
				if (doParse(a)) {
					i.remove();
				}
			}
			if (nbElements == actionsInActivity.size()) {
				flag++;
			} else {
				flag = 0;
				nbElements = actionsInActivity.size();
			}
		}
		if (flag == 2) {
			throw new ActionException("your action is not correct"
					+ currentActionsHandled);
		} else {
			return true;
		}
	}

	/**
	 * This action sets the element given in parameter as a container and linked
	 * the match to it
	 * 
	 * @param topAction
	 * @return true if all parameters were set
	 * @throws ActionException
	 *             if problem occurs during parsing
	 */
	protected boolean doParse(SetContainerAction topAction)
			throws ActionException {
		Object in = getValue(topAction.getIn());
		if (!checkValid(in, EObject.class)) {
			return false;
		}
		containerSelectionManger
				.setCurrentContainer((EObject) in, currentMatch);
		return true;
	}

	/**
	 * Analyse a {@link RegexTextTransformer}
	 * 
	 * @param action
	 * @param text
	 * @return
	 */
	protected String analyse(RegexTextTransformer action, String text) {
		String result = text;
		String patternForGroupingAndRegex = action
				.getPatternForGroupingAndRegex();
		if (patternForGroupingAndRegex != null
				&& patternForGroupingAndRegex.length() > 0) {
			try {
				Pattern compile = RegexUtils.INSTANCE
						.compile(patternForGroupingAndRegex);
				result = RegexUtils.getValueManagingGroup(compile
						.matcher(result));
			} catch (PatternSyntaxException e) {
			}
		}
		return result;
	}

	/**
	 * Analyse a {@link StringReplacementTextTransformer}
	 * 
	 * @param action
	 * @return
	 */
	protected String analyse(StringReplacementTextTransformer action) {
		String result = action.getStringReplacement();
		List<VariableResolverInstance> resolvers = getAllVariables();
		for (VariableResolverInstance instance : resolvers) {
			String pattern = "{" + instance.toReplace + "}";
			if (result.contains(pattern)) {
				result = result.replace(pattern, instance.resolver
						.getValue(services));
			}
		}
		return result;
	}

	/**
	 * Transform a text to another
	 * 
	 * @param topAction
	 * @return true if all parameters were set
	 * @throws ActionException
	 *             if problem occurs during parsing
	 */
	protected boolean doParse(TransformHandledText topAction)
			throws ActionException {
		Object in = getValue(topAction.getIn());
		String result = "";
		if (topAction instanceof RegexTextTransformer) {
			if (!checkValid(in, String.class)) {
				return false;
			}
			String text = (String) in;
			RegexTextTransformer regex = (RegexTextTransformer) topAction;
			result = analyse(regex, text);
		} else if (topAction instanceof StringReplacementTextTransformer) {
			StringReplacementTextTransformer replacement = (StringReplacementTextTransformer) topAction;
			result = analyse(replacement);
		}
		if (topAction.getOut() != null) {
			resolver.setValue(topAction.getOut(), result);
		}
		return true;
	}

	/**
	 * Like a fill attribute action but works for all type
	 * 
	 * @return true if all parameters were set
	 * @throws ActionException
	 *             if problem occurs during parsing
	 */
	protected boolean doParse(ReferenceAction topAction) throws ActionException {
		Object in = getValue(topAction.getCurrentElement());
		if (!checkValid(in, EObject.class)) {
			return false;
		}
		EObject eobject = (EObject) in;
		if (topAction instanceof ReferenceElementAction) {
			ReferenceElementAction referenceElement = (ReferenceElementAction) topAction;
			Object reference = getValue(referenceElement.getToAssign());
			if (!checkValid(reference, null)) {
				return false;
			}
			EAttribute attribute = EMFUtil.getEAttributeByName(
					eobject.eClass(), referenceElement.getReferenceAttribute());
			if (reference instanceof String) {
				reference = EMFUtil.getCorrespondingValue4Type(attribute,
						(String) reference);
			}
			set(eobject, attribute, reference);
			return true;
		} else if (topAction instanceof ReferenceStaticElementAction) {
			ReferenceStaticElementAction staticElement = (ReferenceStaticElementAction) topAction;
			set(eobject, EMFUtil.getFeatureByName(eobject.eClass(),
					staticElement.getReferenceAttribute()), staticElement
					.getElement());
			return true;
		}
		// TODO error log
		throw new ActionException("bad");
	}

	/**
	 * Fill an attribute with a value set, only for string value
	 * 
	 * @param topAction
	 * @return true if all parameters were set
	 * @throws ActionException
	 *             if problem occurs during parsing
	 */
	protected boolean doParse(FillAttributeAction topAction)
			throws ActionException {
		Object element = getValue(topAction.getEobjectContainingAttribute());
		if (!checkValid(element, EObject.class)) {
			return false;
		}
		EObject eobject = (EObject) element;
		Object textObject = getValue(topAction.getIn());
		if (!checkValid(textObject, String.class)) {
			return false;
		}
		String text = (String) textObject;
		EAttribute att = EMFUtil.getEAttributeByName(eobject.eClass(),
				topAction.getAttribute());
		if (att != null) {
			Object obj = EMFUtil.getCorrespondingValue4Type(att, text);
			if (obj != null) {
				set(eobject, att, obj);
				return true;
			}
		}
		// normally ok
		throw new ActionException("problem during fill atribute");
	}

	/**
	 * Create an element
	 * 
	 * @param topAction
	 *            , the action
	 * @return true if all parameters were set
	 * @throws ActionException
	 *             if problem occurs during parsing
	 */
	protected boolean doParse(CreateElementAction topAction)
			throws ActionException {
		Value containerValue = topAction.getContainer();
		Notifier container = getContainer(containerValue);
		if (container == null) {
			return false;
		}
		if (topAction.getContainer() instanceof ContainerSelectionObject) {
			ContainerSelectionObject selection = (ContainerSelectionObject) topAction
					.getContainer();
			EObjectAdder adder = new EObjectAdder(container, selection
					.getSelection());
			EPackage pack = EPackage.Registry.INSTANCE.getEPackage(topAction
					.getEpackage().getUri());
			if (pack != null) {
				EClassifier eClassifier = pack.getEClassifier(topAction
						.getEClassName());
				if (eClassifier instanceof EClass) {
					EClass eclass = (EClass) eClassifier;
					EObject created = pack.getEFactoryInstance().create(eclass);
					registry.remember(created, topAction);
					adder.add(created);
					resolver.setValue(topAction.getNewElement(), created);
				}
			}
		} else {
			// TODO
		}
		return true;
	}

	/**
	 * Returns the container associated of the value
	 * 
	 * @param containerValue
	 * @return
	 */
	protected Notifier getContainer(Value containerValue) {
		Object value = getValue(containerValue);
		if (value instanceof Notifier) {
			return (Notifier) value;
		}
		return null;
	}

	protected boolean checkValid(Object object, Class c) throws ActionException {
		if (object == null) {
			return false;
		}
		if (c != null && !c.isInstance(object)) {
			throw new ActionException("not valid value");
		}
		return true;
	}

	/**
	 * Returns the object associated to a value
	 * 
	 * @param value
	 * @return
	 */
	protected Object getValue(Value value) {
		if (value instanceof ContainerSelectionObject) {
			ElementSelection selection = ((ContainerSelectionObject) value)
					.getSelection();
			return containerSelectionManger.getContainer(selection,
					currentMatch);
		} else if (value instanceof MatchingResultObject) {
			MatchingResultObject result = (MatchingResultObject) value;
			if (currentMatchResult != null
					&& currentMatchResult.size() > result.getIndex()) {
				return currentMatchResult.get(result.getIndex());
			}
		} else {
			return resolver.getValue(value);
		}
		return null;
	}

}
