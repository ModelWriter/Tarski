package org.eclipse.emf.doc2model.engine.selection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.doc2model.doc2model.ElementSelection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class EObjectAdder {

	private Notifier container = null;
	private ElementSelection select;

	public EObjectAdder(Notifier r) {
		this(r, null);
	}

	public EObjectAdder(Notifier container, ElementSelection select) {
		this.select = select;
		this.container = container;
	}

	public void add(EObject created) {
		if (container instanceof Resource) {
			((Resource) container).getContents().add(created);
		} else if (select != null && container instanceof EObject) {
			addUsingSelect((EObject) container, created);
		}

	}

	@SuppressWarnings("unchecked")
	protected void addUsingSelect(EObject theContainer, EObject created) {
		EStructuralFeature feature = theContainer.eClass()
				.getEStructuralFeature(select.getEReferenceOwning());
		if (feature != null && feature.isChangeable() && !feature.isDerived()) {
			if (feature.isMany()) {
				Collection<Object> collection = (Collection<Object>) theContainer
						.eGet(feature);
				if (collection != null) {
					collection.add(created);
				}
			} else {
				theContainer.eSet(feature, created);
			}

		} else {
			// TODO log
		}
	}
}
