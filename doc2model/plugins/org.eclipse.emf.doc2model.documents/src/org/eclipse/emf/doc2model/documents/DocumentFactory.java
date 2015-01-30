package org.eclipse.emf.doc2model.documents;

import java.util.Map;

/**
 * Interface DocumentFactory
 * 
 * @author tristan.faure@atosorigin.com
 */
public interface DocumentFactory {
	/**
	 * loadDocument gives the document corresponding
	 * 
	 * @param documentFile
	 *            the file to load
	 */
	IDocument loadDocument(String uriPath);

	/**
	 * loadDocument gives the document corresponding
	 * 
	 * @param documentFile
	 *            the file to load
	 * @param options
	 *            , configuration are constants, Strings allows plugin extending
	 *            interfaces to define custom configuration standards are
	 *            defined in interface
	 *            org.eclipse.emf.doc2model.documents.constants
	 *            .ConfigurationConstants
	 */
	IDocument loadDocument(String uriPath, Map<String, Object> options);

	/**
	 * Determines if the factory can load the document
	 * 
	 * @param uriPath
	 * @return
	 */
	boolean handles(String uriPath);
}@
