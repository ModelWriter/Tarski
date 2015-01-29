head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.07.26.14.24.33;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	3f85a4c4d9aa14567;

1.1
date	2010.03.02.22.34.53;	author tfaure;	state Exp;
branches;
next	;
commitid	7a6d4b8d92874567;


desc
@@


1.2
log
@NEW - bug 320747: Provide recognition by regular expression
https://bugs.eclipse.org/bugs/show_bug.cgi?id=320747

add regular expression.
The syntax in uri is
regex:myRegex(zoneGrouped)

or if you want to bufferize the document (be careful no performance test have been done)
regex:myRegex(zoneGrouped)#global
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
package org.eclipse.emf.doc2model.engine.services;

import org.eclipse.emf.doc2model.documents.IDocument;
import org.eclipse.emf.doc2model.engine.selection.ContainerSelectionManager;
import org.eclipse.emf.ecore.EObject;

public class Doc2ModelEngineServices {

	public enum EngineState {BEGIN, PROCESS, END} ;
	private EObject currentContainer;
	private IDocument document;
	private EngineState currentState = EngineState.BEGIN;
	private int count = 0 ;

	public Object get(String property) {
		if (document == null) {
			throw new IllegalStateException("a document should be available");
		}
		return document.get(property);
	}

	public void setCurrentContainer(EObject eObject) {
		currentContainer = eObject;
	}

	public void setDocument(IDocument document) {
		this.document = document;
	}

	public void setContainerManager(
			ContainerSelectionManager containerSelectionManger) {
	}
	
	public void setState (EngineState state)
	{
		this.currentState = state;
	}
	
	public EngineState getCurrentState ()
	{
		return currentState;
	}

	/**
	 * The counter is a variable incremented each next in the document. Useful to mark states in the browse process
	 * @@return
	 */
	public int getCountValue ()
	{
		return count ;
	}
	
	/**
	 * Increment the counter
	 */
	public void incrementCounter() {
		count ++ ;
	}

}
@


1.1
log
@doc2model engine first commit
it understands a part of the action language and run a transformation from documents to models
@
text
@d21 1
d24 2
d44 11
d56 14
@

