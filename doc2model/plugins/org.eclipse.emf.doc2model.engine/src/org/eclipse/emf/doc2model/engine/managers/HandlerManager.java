head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.34.52;	author tfaure;	state Exp;
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
package org.eclipse.emf.doc2model.engine.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.engine.handler.HandlerResult;
import org.eclipse.emf.doc2model.engine.handler.URIHandler;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;

public class HandlerManager {
	private static final String extensionPointId = "org.eclipse.emf.doc2model.engine.matchingUriHandler";

	private Map<String, URIHandler> handlers = new HashMap<String, URIHandler>();

	private List<Match> ownedMatches;

	private final Doc2ModelEngineServices services;

	public HandlerManager(EList<Match> ownedMatches,
			Doc2ModelEngineServices services) {
		initHandlers();
		this.ownedMatches = ownedMatches;
		this.services = services;
	}

	private void initHandlers() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(extensionPointId);
		for (IConfigurationElement e : elements) {
			String scheme = e.getAttribute("scheme");
			try {
				URIHandler handler = (URIHandler) e
						.createExecutableExtension("uriHandler");
				handlers.put(scheme, handler);
			} catch (CoreException e1) {
				e1.printStackTrace();
			}
		}
	}

	public HandlerResult handles() {
		for (Match m : ownedMatches) {
			for (URI uri : m.getURI()) {
				URIHandler handler = handlers.get(uri.scheme());
				if (handler != null) {
					List<String> elements = handler.handles(uri, services);
					if (!elements.isEmpty()) {
						return new HandlerResult(m, elements);
					}
				}
			}
		}
		return null;

	}

}
@
