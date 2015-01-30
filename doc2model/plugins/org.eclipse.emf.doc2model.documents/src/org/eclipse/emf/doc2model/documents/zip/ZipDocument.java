package org.eclipse.emf.doc2model.documents.zip;

import java.io.File;

import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * The Interface ZipDocument.
 */
public interface ZipDocument extends IDocument {

	/**
	 * 
	 * @param locationToZip
	 */
	File getUnzipLocationDocumentFile();

	void zipToLocation(String locationToZip);
}
