package org.eclipse.emf.doc2model.engine.actions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.ecore.EObject;

public class ActionRegistry {

	private List<EObject> allCreated = new LinkedList<EObject>();
	private Map<EObject, Action> mapping = new HashMap<EObject, Action>();

	public void remember(EObject created, Action action) {
		allCreated.add(created);
		mapping.put(created, action);
	}

}
