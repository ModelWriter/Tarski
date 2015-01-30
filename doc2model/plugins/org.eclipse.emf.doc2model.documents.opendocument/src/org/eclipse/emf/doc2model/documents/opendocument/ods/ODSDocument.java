package org.eclipse.emf.doc2model.documents.opendocument.ods;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.doc2model.documents.AbstractZipDocument;
import org.eclipse.emf.doc2model.documents.constants.ConfigurationConstants;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.documents.opendocument.helper.ODSHelper;
import org.eclipse.emf.doc2model.documents.xml.XMLParser;
import org.w3c.dom.Node;

/**
 * The Class ODSDocument.
 */
public class ODSDocument extends AbstractZipDocument{
	private List<String> currentRow = null;

	private int currentIndex = -1;

	private Node currentNode = null;

	public ODSDocument(File documentFile, Map<String, Object> configuration) {
		super(documentFile, configuration);
	}

	@Override
	protected Collection<XMLParser> getXmlParsers(String idForDocument) {
		Collection<XMLParser> result = new LinkedList<XMLParser>();
		if (ConfigurationConstants.CONTENT.equals(idForDocument)) {
			XMLParser content = new XMLParser(getUnzipper().getFile(
					ODSHelper.CONTENTS_FILE_NAME), idForDocument);
			result.add(content);
		}
		return result;
	}

	public String getStyle() {
		return "";
	}

	@Override
	public boolean next() {
		boolean result = true;
		// in ODS files there is acolumn repeat attribute so we init a list with
		// row information
		// it's better for column number calculation and current text
		// until we have not parsed the row we din't continue to browse the xml
		if (getXMLParser().getCurrentNode() != currentNode) {
			// for each new row we init a cache
			if (ODSHelper.ROW.equals(getXMLParser().getCurrentNode()
					.getNodeName())) {
				currentNode = getXMLParser().getCurrentNode();
				currentRow = new LinkedList<String>();
				for (int i = 0; i < currentNode.getChildNodes().getLength(); i++) {
					Node child = currentNode.getChildNodes().item(i);
					if (ODSHelper.CELL.equals(child.getNodeName())) {
						fillRowWithcell(child);
					}
				}
				currentIndex = 0;
				result = true;
			} else {
				result = super.next();
			}
		} else {
			if (currentIndex == currentRow.size() - 1) {
				currentIndex = -1;
				currentRow = null;
				result = super.next();
			} else {
				currentIndex++;
				result = true;
			}
		}
		return result;
	}

	public String getText() {
		// retur nvalue from current row else empty string
		if (currentRow != null && currentIndex != -1) {
			return currentRow.get(currentIndex);
		} else {
			return "";
		}
	}

	private void fillRowWithcell(Node theNode) {
		// we fill the current row with the content of the cell repeated each
		// time depending on repeat attribute
		int count = 1;
		if (ODSHelper.CELL.equals(theNode.getNodeName())) {
			Node attribute = theNode.getAttributes().getNamedItem(
					ODSHelper.COL_REPEAT);
			if (attribute != null) {
				count = Integer.valueOf(attribute.getTextContent());
			}
		}
		String found = "";
		for (int i = 0; i < theNode.getChildNodes().getLength()
				&& found.length() == 0; i++) {
			Node child = theNode.getChildNodes().item(i);
			if (ODSHelper.PARA.equals(child.getNodeName())) {
				found = child.getTextContent();
			}
		}
		if (isLast(theNode) && found.length() == 0) {
			count = 1;
		}
		for (int j = 0; j < count; j++) {
			currentRow.add(found);
		}

	}

	private boolean isLast(Node theNode) {
		int length = theNode.getParentNode().getChildNodes().getLength() - 1;
		int cursor = 0;
		for (int i = 0; i < theNode.getParentNode().getChildNodes().getLength(); i++) {
			if (theNode.getParentNode().getChildNodes().item(i) == theNode) {
				cursor = i;
				break;
			}
		}
		return (cursor == length);
	}

	public String getTextCorrespondingToCurrentStyle() {
		return null;
	}

	@Override
	public int getColumnNumber() {
		return currentIndex;
	}

	public Object get(String property) {
		if (PropertyConstants.COLUMN.equals(property)) {
			return getColumnNumber();
		} else if (PropertyConstants.ROW.equals(property)) {
			return getRowNumber();
		} else if (PropertyConstants.TEXT.equals(property)) {
			return getText();
		}
		return super.get(property);
	}

	private int getRowNumber() {
		return 0;
	}

}
