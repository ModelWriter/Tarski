head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.34.53;	author tfaure;	state Exp;
branches;
next	;
commitid	7a6d4b8d92874567;


desc
@@


1.1
log
@doc2model engine first commit
it understands a part of the action language and run a transformation from documents to models
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

	@@SuppressWarnings("unchecked")
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
@
