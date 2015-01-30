package org.eclipse.emf.doc2model.documents.openxml.docx;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * The Class DocxFactory.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class DocxFactory implements DocumentFactory {
	/** The instance. */
	private static DocxFactory instance = new DocxFactory();

	/**
	 * Default constructor.
	 */
	public DocxFactory() {
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
			Map<String, Object> configuration) {
		DocxDocument document = new DocxDocument(new File(documentFile),
				configuration);
		return document;
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("docx");
	}

}
