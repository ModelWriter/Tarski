head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.30.42;	author tfaure;	state Exp;
branches;
next	;
commitid	73794b8d918e4567;


desc
@@


1.1
log
@first commit for doc2model api : documents
this plugin contains interface for IDocument and some utils classes to handle xmls, zip documents
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
package org.eclipse.emf.doc2model.documents.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.doc2model.documents.DocumentFactory;

public class DocumentsUtil {

	private static String extensionPointIdFactory = "org.eclipse.emf.doc2model.documents.factory";
	private static List<DocumentFactory> factories = null;

	/**
	 * Analyse string in parameter and returns a factory ables to load the
	 * document
	 * 
	 * @@param path
	 * @@return the document factory
	 */
	public static DocumentFactory getFactory(String path) {
		if (factories == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(extensionPointIdFactory);
			factories = new ArrayList<DocumentFactory>(elements.length);
			for (IConfigurationElement element : elements) {
				String clazz = element.getAttribute("class");
				Class<?> factory = null;
				try {

					factory = Class.forName(clazz);
				} catch (ClassNotFoundException e) {
					try {
						factory = Platform.getBundle(
								element.getContributor().getName()).loadClass(
								clazz);
					} catch (InvalidRegistryObjectException e1) {
					} catch (ClassNotFoundException e1) {
					}
				}
				if (factory != null) {
					DocumentFactory docFactory;
					try {
						docFactory = (DocumentFactory) factory.newInstance();
						factories.add(docFactory);
					} catch (InstantiationException e1) {
					} catch (IllegalAccessException e1) {
					}
				}
			}
		}
		for (DocumentFactory d : factories) {
			if (d.handles(path)) {
				return d;
			}
		}
		return null;
	}

}
@
