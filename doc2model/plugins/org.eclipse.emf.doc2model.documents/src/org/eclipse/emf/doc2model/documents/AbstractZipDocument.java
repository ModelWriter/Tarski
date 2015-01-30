package org.eclipse.emf.doc2model.documents;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.constants.ConfigurationConstants;
import org.eclipse.emf.doc2model.documents.constants.OperationConstants;
import org.eclipse.emf.doc2model.documents.xml.XMLParser;
import org.eclipse.emf.doc2model.documents.xml.XmlParsers;
import org.eclipse.emf.doc2model.documents.zip.Unzipper;
import org.eclipse.emf.doc2model.documents.zip.ZipDocument;
import org.eclipse.emf.doc2model.documents.zip.Zipper;

/**
 * Abstract ZipDocument unzip OO and word.
 * 
 * @author tlandre
 * 
 */
public abstract class AbstractZipDocument extends AbstractDocument implements
		ZipDocument {

	/** The unzipper. */
	private Unzipper unzipper = null;
	/** the zipper */
	private Zipper zipper = null;

	private XmlParsers listOfXmlParsers;

	public AbstractZipDocument(File document) {
		this(document, null);
	}

	public AbstractZipDocument(File documentFile,
			Map<String, Object> configuration) {
		super(documentFile, configuration);
		unzipper = new Unzipper(documentFile);
		getUnzipper().unzip();
		zipper = new Zipper(unzipper.getUnzipDocumentFile());
		listOfXmlParsers = new XmlParsers(this
				.getXmlParsers(ConfigurationConstants.CONTENT));
		if (configuration != null) {
			for (String c : configuration.keySet()) {
				if (c != ConfigurationConstants.CONTENT) {
					Object object = configuration.get(c);
					if (object instanceof Boolean && (Boolean) object) {
						listOfXmlParsers.addAll(getXmlParsers(c));
					}
				}
			}
		}
	}

	public void call(String operation) {
		if (OperationConstants.MOVE_TO_START_OPERATION.equals(operation)) {
			jumpToStart();
		}
	}

	/**
	 * Get XML Parser depending of
	 * 
	 * @param idForDocument
	 * @return the collection of XML Parsers
	 */
	protected abstract Collection<XMLParser> getXmlParsers(String idForDocument);

	public XMLParser getXMLParser() {
		return listOfXmlParsers.getCurrent();
	}

	public boolean next() {
		return listOfXmlParsers.next();
	}

	public boolean jumpToNextFile() {
		return listOfXmlParsers.jumpToNextFile();
	}

	public void zipToLocation(String locationToZip) {
		getZipper().zip(locationToZip);
	}

	public File getUnzipLocationDocumentFile() {
		return getUnzipper().getUnzipDocumentFile();
	}

	public Unzipper getUnzipper() {
		return unzipper;
	}

	public Zipper getZipper() {
		return zipper;
	}

	public XmlParsers getListOfXmlParsers() {
		return listOfXmlParsers;
	}

	public void jumpToStart() {
		listOfXmlParsers.jumpToStart();
	}

	@Override
	public Object get(String property) {
		return super.get(property);
	}

}
