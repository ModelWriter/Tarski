package org.eclipse.emf.doc2model.documents;

import java.io.File;

/**
 * The Interface Document.
 * 
 * @author tristan.faure@atosorigin.com
 */
public interface IDocument {
	/**
	 * Next.
	 * 
	 * @return false if there is no next
	 */
	boolean next();

	/**
	 * Gets the value corresponding to the property
	 * 
	 * @param property
	 *            the property
	 * 
	 * @return the string
	 */
	Object get(String property);

	void call(String operation);

	/**
	 * Get the input file document
	 * 
	 * @return the file
	 */
	File getDocumentFile();

}@
