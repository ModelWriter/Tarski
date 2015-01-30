package org.eclipse.emf.doc2model.documents;

public interface IMultiFileDocument extends IDocument {

	/**
	 * Next file in list of xmls.
	 * 
	 * @return false if there is no next
	 */
	boolean jumpToNextFile();

	/**
	 * Returs to the first xlm file
	 */
	void jumpToStart();
}
