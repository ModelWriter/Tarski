head	1.2;
access;
symbols;
locks; strict;
comment	@# @;


1.2
date	2010.07.26.14.24.38;	author tfaure;	state Exp;
branches;
next	1.1;
commitid	3f8c94c4d9aa54567;

1.1
date	2010.03.02.22.37.22;	author tfaure;	state Exp;
branches;
next	;
commitid	7dbf4b8d93214567;


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
package org.eclipse.emf.doc2model.style.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.engine.handler.URIHandler;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;

public class StyleHandler implements URIHandler {

	public List<String> handles(URI uri, Doc2ModelEngineServices services) {
		assert(uri != null && services != null && uri.scheme().equals("style")) ;
		List<String> result = new ArrayList<String>(1);
		String style = uri.opaquePart();
		Object currentStyle = services.get(PropertyConstants.STYLE);
		if (currentStyle instanceof String) {
			String currentStringStyle = (String) currentStyle;
			currentStringStyle = currentStringStyle.replace(" ", "");
			if (style != null && style.equals(currentStringStyle)) {
				Object textObject = services.get(PropertyConstants.TEXT);
				if (textObject instanceof String) {
					String text = (String) textObject;
					result.add(text);
				}
			}
		}
		return result;
	}
}
@


1.1
log
@first commit for doc2model style handler.
Works correctly for paragraph recognition. next step : managing style for characters
@
text
@d26 1
d33 1
a33 1
			if (style.equals(currentStringStyle)) {
@

