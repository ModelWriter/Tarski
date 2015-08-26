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

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import DocModel.DocModelFactory;
import DocModel.Document;
import DocModel.Paragraph;

public class ModelObserver {

	private Document doc;

	public ModelObserver(){
		
		DocModelFactory factory = DocModelFactory.eINSTANCE;

		doc = factory.createDocument();
		
		Adapter adapter = new AdapterImpl(){
			
			 public void notifyChanged(Notification notification) {
			        System.out
			            .println("Notfication received from the data model. Data model has changed!!!");
			      }
			    };
			    doc.eAdapters().add(adapter);
			    
			 
		}
	
	public void doStuff() {
	    DocModelFactory factory = DocModelFactory.eINSTANCE;
	    Paragraph p = factory.createParagraph();
	    p.setName("deneme");
	    System.out.println("I'm adding a paragraph.");
	    doc.getOwnedParagraph().add(p);
	    System.out.println("I'm changing a entry");
	    doc.getOwnedParagraph().get(0).setName("deneme 2 asd");
	    System.out.println("I'm deleting a entry");
	    doc.getOwnedParagraph().remove(0);
	  }
	
}
