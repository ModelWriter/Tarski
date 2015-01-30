package org.eclipse.emf.doc2model.engine.selection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.doc2model.doc2model.CurrentContainerSelection;
import org.eclipse.emf.doc2model.doc2model.ElementSelection;
import org.eclipse.emf.doc2model.doc2model.LastContainerConsideringMatchOrder;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.doc2model.StaticElementSelection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class ContainerSelectionManager {

	private EObject container;
	private Map<Match, List<EObject>> allContainers = new HashMap<Match, List<EObject>>();
	private Stack<Match> allMatches = new Stack<Match>();
	private Resource top;

	public void setCurrentContainer(Resource r, Match currentMatch) {
		top = r;
	}

	public void setCurrentContainer(EObject container, Match currentMatch) {
		if (currentMatch != null) {
			allMatches.push(currentMatch);
			List<EObject> eobjects = allContainers.get(currentMatch);
			if (eobjects == null) {
				eobjects = new LinkedList<EObject>();
				allContainers.put(currentMatch, eobjects);
			}
			eobjects.add(container);
		} else {
			this.container = container;
		}

	}

	public Notifier getContainer(ElementSelection select, Match match) {
		if (select instanceof CurrentContainerSelection) {
			CurrentContainerSelection selection = (CurrentContainerSelection) select;
			return getContainer(selection);
		} else if (select instanceof LastContainerConsideringMatchOrder) {
			LastContainerConsideringMatchOrder selection = (LastContainerConsideringMatchOrder) select;
			return getContainer(selection, match);
		} else if (select instanceof StaticElementSelection) {
			StaticElementSelection selection = (StaticElementSelection) select;
			return getContainer(selection);
		}
		return null;
	}

	public Notifier getContainer(CurrentContainerSelection select) {
		return getContainerOrResource(container);
	}

	public Notifier getContainerOrResource(EObject element) {
		if (element == null) {
			return top;
		} else {
			return element;
		}
	}

	public Notifier getContainer(LastContainerConsideringMatchOrder select,
			Match match) {
		if (!allMatches.isEmpty()) {
			Match tmp = allMatches.peek();
			while (!allMatches.isEmpty() && isHigher(match, tmp)) {
				allMatches.pop();
				if (!allMatches.isEmpty()) {
					tmp = allMatches.peek();
				} else {
					return container;
				}
			}
			List<EObject> containers = allContainers.get(tmp);
			if (containers != null && !containers.isEmpty()) {
				return containers.get(containers.size() - 1);
			}

			// for (ListIterator<Match> i =
			// allMatches.listIterator(allMatches.size()) ; i.hasPrevious() ;)
			// {
			// Match m = i.previous() ;
			// if (isLowerOrEquals(m,match))
			// {
			// List<EObject> containers = allContainers.get(m);
			// if (containers != null && !containers.isEmpty())
			// {
			// return containers.get(containers.size() - 1).eContainer();
			// }
			// }
			// }

		}
		// if no container found according to the order, return the default one
		return getContainerOrResource(container);
	}

	public boolean isLowerOrEquals(Match one, Match two) {
		for (Match m : one.getLowerThan()) {
			if (isLowerOrEquals(m, two)) {
				return true;
			}
		}
		return one.equals(two);
	}

	public boolean isHigher(Match one, Match two) {
		for (Match m : one.getHigherThan()) {
			if (isHigher(m, two)) {
				return true;
			}
		}
		return one.equals(two);
	}

	public EObject getContainer(StaticElementSelection select) {
		return select.getElement();
	}

}
