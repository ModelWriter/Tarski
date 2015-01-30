package org.eclipse.emf.doc2model.documents;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;

/**
 * Abstract Document.
 * 
 * @author tristan.faure@atosorigin.com
 */
public abstract class AbstractDocument implements IMultiFileDocument,
		IXMLDocument {

	private File file;

	/**
	 * Instantiates a new abstract document.
	 * 
	 * @param document
	 *            the document
	 */
	public AbstractDocument(File pFile) {
		this(pFile, null);
	}

	public AbstractDocument(File documentFile, Map<String, Object> configuration) {
		this.file = documentFile;
	}

	/**
	 * @see org.eclipse.emf.doc2model.documents.IDocument.documents.Document#getDocumentFile()
	 */
	public File getDocumentFile() {
		return file;
	}

	/**
	 * @see org.eclipse.emf.doc2model.documents.IDocument.documents.Document#getColumnNumber()
	 */
	public int getColumnNumber() {
		return 0;
	}

	public Object get(String property) {
		if (PropertyConstants.DOCUMENT_NAME.equals(property)) {
			return file.getName();
		}
		return null;
	}
}
