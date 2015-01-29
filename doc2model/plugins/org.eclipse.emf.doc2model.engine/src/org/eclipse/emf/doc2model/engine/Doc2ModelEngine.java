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
package org.eclipse.emf.doc2model.engine;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.doc2model.Doc2Model;
import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;
import org.eclipse.emf.doc2model.documents.utils.DocumentsUtil;
import org.eclipse.emf.doc2model.engine.exceptions.NoConfigurationException;
import org.eclipse.emf.doc2model.engine.exceptions.NoFactoryFoundException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Doc2ModelEngine {

	private final File inputFile;
	private final File outputFolder;
	private final Doc2Model inputDoc2Model;
	private final ResourceSet globalResourceSet = new ResourceSetImpl();

	public Doc2ModelEngine(File inputFile, File outputFolder, URI inputDoc2model) {
		this.inputFile = inputFile;
		if (!outputFolder.isDirectory()) {
			throw new IllegalArgumentException(
					"Please provide an output folder");
		}
		this.outputFolder = outputFolder;
		inputDoc2Model = initDoc2Model(inputDoc2model);
		if (inputDoc2model == null) {
			throw new IllegalArgumentException(
					"Please provide a correct Doc2Model input uri");
		}
		EcoreUtil.resolveAll(globalResourceSet);

	}

	public Doc2ModelEngine(String inputPath, String outputPath,
			URI inputDoc2model) {
		this.inputFile = new File(inputPath);
		if (!this.inputFile.exists()) {
			throw new IllegalArgumentException(
					"Please provide a correct input path");
		}
		outputFolder = new File(outputPath);
		if (!outputFolder.exists() || !outputFolder.isDirectory()) {
			throw new IllegalArgumentException(
					"Please provide a correct output folder path");
		}
		inputDoc2Model = initDoc2Model(inputDoc2model);
		if (inputDoc2model == null) {
			throw new IllegalArgumentException(
					"Please provide a correct Doc2Model input uri");
		}
		EcoreUtil.resolveAll(globalResourceSet);

	}

	private Doc2Model initDoc2Model(URI inputDoc2modelURI) {
		Resource resource = globalResourceSet.getResource(inputDoc2modelURI,
				true);
		EObject root = resource.getContents().get(0);
		if (root instanceof Doc2Model) {
			return (Doc2Model) root;
		}
		return null;
	}

	public void run() throws NoFactoryFoundException, NoConfigurationException {
		run(null);
	}

	public void run(Map<String, Object> options)
			throws NoFactoryFoundException, NoConfigurationException {
		String absolutePath = inputFile.getAbsolutePath();
		DocumentFactory factory = DocumentsUtil.getFactory(absolutePath);
		if (factory == null) {
			throw new NoFactoryFoundException(absolutePath
					+ " is not recognized");
		}
		IDocument document = factory.loadDocument(absolutePath, options);
		Doc2ModelParserTransformation process = new Doc2ModelParserTransformation(
				document, URI.createFileURI(outputFolder.getAbsolutePath()),
				inputDoc2Model);
		process.transform();
	}

}
@
