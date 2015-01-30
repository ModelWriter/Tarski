package org.eclipse.emf.doc2model.documents.opendocument.odt;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * A factory for creating ODT objects.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class ODTFactory implements DocumentFactory {
	/** The instance. */
	private static ODTFactory instance = new ODTFactory();

	/**
	 * Default constructor.
	 */
	public ODTFactory() {
	}

	/**
	 * Method for implemented interface : architecture.DocumentFactory
	 * 
	 * @return the instance
	 * 
	 * @see architecture.DocumentFactory#getInstance
	 */
	public static DocumentFactory getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.topcased.doc2model.documents.DocumentFactory#loadDocument(java.io
	 * .File)
	 */
	public IDocument loadDocument(String file) {
		return loadDocument(file, null);
	}

	public IDocument loadDocument(String documentFile,
			Map<String, Object> options) {
		ODTDocument document = new ODTDocument(new File(documentFile), options);
		return document;
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("odt");
	}
}
