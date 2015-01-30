package org.eclipse.emf.doc2model.documents.opendocument.ods;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * A factory for creating ODS objects.
 */
public class ODSFactory implements DocumentFactory {

	/**
	 * Instantiates a new oDS factory.
	 */
	public ODSFactory() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.topcased.document.parser.documents.DocumentFactory#loadDocument(java
	 * .io.File)
	 */
	public IDocument loadDocument(String documentFile) {
		return loadDocument(documentFile, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.topcased.document.parser.documents.DocumentFactory#loadDocument(java
	 * .io.File, java.util.Map)
	 */
	public IDocument loadDocument(String documentFile,
			Map<String, Object> configuration) {
		return new ODSDocument(new File(documentFile), configuration);
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("ods");
	}

}
