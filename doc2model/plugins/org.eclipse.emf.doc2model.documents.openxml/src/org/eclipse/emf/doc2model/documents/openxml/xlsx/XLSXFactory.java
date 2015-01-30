package org.eclipse.emf.doc2model.documents.openxml.xlsx;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.DocumentFactory;
import org.eclipse.emf.doc2model.documents.IDocument;

/**
 * A factory for creating XLSX objects.
 */
public class XLSXFactory implements DocumentFactory {

	public XLSXFactory() {
	}

	public IDocument loadDocument(String documentFile) {
		return loadDocument(documentFile, null);
	}

	public IDocument loadDocument(String documentFile,
			Map<String, Object> configuration) {
		return new XLSXDocument(new File(documentFile), configuration);
	}

	public boolean handles(String uriPath) {
		return uriPath != null && uriPath.toLowerCase().endsWith("xlsx");
	}

}
