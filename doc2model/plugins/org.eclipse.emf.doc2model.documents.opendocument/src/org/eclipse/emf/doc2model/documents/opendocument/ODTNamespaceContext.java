package org.eclipse.emf.doc2model.documents.opendocument;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/**
 * The Class ODTNamespaceContext.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class ODTNamespaceContext implements NamespaceContext {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.xml.namespace.NamespaceContext#getNamespaceURI(java.lang.String)
	 */
	public String getNamespaceURI(String prefix) {

		if (prefix == null) {
			throw new NullPointerException("Null prefix");
		} else if ("style".equals(prefix)) {
			return "urn:oasis:names:tc:opendocument:xmlns:style:1.0";
		} else if ("xml".equals(prefix)) {
			return XMLConstants.XML_NS_URI;
		} else if ("text".equals(prefix)) {
			return "urn:oasis:names:tc:opendocument:xmlns:text:1.0";
		}

		return XMLConstants.NULL_NS_URI;

	}

	// This method isn't necessary for XPath processing.
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.namespace.NamespaceContext#getPrefix(java.lang.String)
	 */
	public String getPrefix(String uri) {

		throw new UnsupportedOperationException();

	}

	// This method isn't necessary for XPath processing either.
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.xml.namespace.NamespaceContext#getPrefixes(java.lang.String)
	 */
	public Iterator getPrefixes(String uri) {

		throw new UnsupportedOperationException();

	}

}
