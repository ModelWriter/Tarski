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
package DocModel.presentation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

import DocModel.DocModelFactory;
import DocModel.Document;
import DocModel.Paragraph;

public class DocModelObserver extends EContentAdapter {

	private Document doc;
	
	public DocModelObserver(){
		
		DocModelFactory factory = DocModelFactory.eINSTANCE;

		doc = factory.createDocument();
		
		observeModel();
	}
	
	public DocModelObserver(Document d){
		
		doc = d;
		
		observeModel();
	}
	// start observing a Library model
    public void observeModel(){
        doc.eAdapters().add(this);
    }

    //override the notifyChanged method
    public void notifyChanged(Notification n){
        
        super.notifyChanged(n); // the superclass handles adding/removing this Adapter to new Books
        
        // find out the type of the notifier which could be either 'Book' or 'Library'
        Object notifier = n.getNotifier();
        if (notifier instanceof Document) {
        	handleDocumentNotification(n);
        } else if (notifier instanceof Paragraph) {
        	handleParagraphNotification(n);
        }
    }

    // output a message about new books
    private void handleDocumentNotification(Notification n){
        int featureID = n.getFeatureID(Document.class);
        if (featureID == DocModel.DocModelPackage.DOCUMENT__OWNED_PARAGRAPH){
            if (n.getEventType() == Notification.ADD){
                Paragraph p = (Paragraph) n.getNewValue(); 
                System.out.println("New Paragraph was added to the Document: " + p.getName());
            }
            else if(n.getEventType() == Notification.REMOVE){
            	Paragraph p = (Paragraph) n.getOldValue();
            	System.out.println("Paragraph was deleted from the Document: " + p.getName());
            }
        }
    }

    // output a message about a book´s availability
    private void handleParagraphNotification(Notification n){
        int featureID = n.getFeatureID(Paragraph.class);
        if (featureID == DocModel.DocModelPackage.PARAGRAPH__NAME){
        		String old = n.getOldStringValue();
        		String newOne = n.getNewStringValue();
                System.out.println("old name : '" + old + "' is now : '" + newOne + "'");
        }
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
