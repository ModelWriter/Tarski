/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
package com.modelwriter.architecture.textconnectors.docx.genparser;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.mylyn.docs.intent.markup.builder.ModelDocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;

public class Test {

	public static void main(String[] args) throws IOException {

		//byte[] encoded = Files.readAllBytes(Paths.get("testdata/my.textile"));
		byte[] encoded = Files.readAllBytes(Paths.get("testdata/my.markdown"));
		String markupContent = new String(encoded, Charset.defaultCharset());
		
		ModelDocumentBuilder builder = new ModelDocumentBuilder();

		MarkupParser markupParser = new MarkupParser();
		//markupParser.setMarkupLanguage(new TextileLanguage());
		markupParser.setMarkupLanguage(new MarkdownLanguage());
		markupParser.setBuilder(builder);
		
		markupParser.parse(markupContent);
	
		
		Collection<EObject> correspondingModels = builder.getRoots();
		
		
		// Register the XMI resource factory for the .website extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("markup", new XMIResourceFactoryImpl());
		// Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();
	    // create a resource
	    //Resource resource = resSet.createResource(URI.createURI("model/my_textile.markup"));
	    Resource resource = resSet.createResource(URI.createURI("model/my_markdown.markup"));
	    resource.getContents().addAll(correspondingModels);
	    // now save the content.
	    try {
	      resource.save(Collections.EMPTY_MAP);
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
		

	}

}
