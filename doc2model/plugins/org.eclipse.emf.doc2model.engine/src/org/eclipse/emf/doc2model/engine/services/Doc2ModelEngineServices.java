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
	 * @return
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
