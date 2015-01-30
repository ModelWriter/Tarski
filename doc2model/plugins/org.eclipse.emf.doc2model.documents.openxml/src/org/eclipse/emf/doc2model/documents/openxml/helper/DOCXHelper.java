package org.eclipse.emf.doc2model.documents.openxml.helper;

import org.eclipse.emf.doc2model.documents.helper.XMLHelper;
import org.eclipse.emf.doc2model.documents.xml.XMLParser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The Class DOCXHelper.
 * 
 * @author tristan.faure@atosorigin.com
 */
public final class DOCXHelper {

	/** The Constant CONTENTS_FILE_NAME. */
	public static final String CONTENTS_FILE_NAME = "document.xml";

	/** The Constant STYLE_FILE_NAME. */
	public static final String STYLE_FILE_NAME = "styles.xml";

	public static final String DOCUMENT_RELS_FILE_NAME = "document.xml.rels";

	/** The Constant XPATH_ALL_STYLES. */
	public static final String XPATH_ALL_STYLES = "//w:style";

	/** The Constant WORD_STYLE. */
	public static final String WORD_STYLE = "pStyle";

	/** The Constant WORD_STYLE_ATTRIBUTE. */
	public static final String WORD_STYLE_ATTRIBUTE = "w:val";

	/** The Constant WORD_STYLE_PARAGRAPH. */
	public static final String WORD_STYLE_PARAGRAPH = "p";

	/** The Constant WORD_STYLE_PARAGRAPH. */
	public static final String WORD_STYLE_PARAGRAPH_W = "w:p";

	/** The Constant WORD_STYLE_PARAGRAPH_RPR. */
	public static final String WORD_STYLE_PARAGRAPH_RPR = "w:rPr";

	/** The Constant WORD_STYLE_TEXT. */
	public static final String WORD_STYLE_TEXT = "t";

	/** The Constant WORD_STYLE_TEXT. */
	public static final String WORD_STYLE_TEXT_W = "w:t";

	/** The Constant WORD_TAG_CHANGE_INS. */
	public static final String WORD_TAG_CHANGE_INS = "ins";

	/** The Constant WORD_TAG_CHANGE_DEL. */
	public static final String WORD_TAG_CHANGE_DEL = "del";

	/** The Constant WORD_TAG_CHANGE. */
	public static final String WORD_TAG_CHANGE = "pPrChange";

	/** The Constant WORD_TAG_CHANGE_FORMAT. */
	public static final String WORD_TAG_CHANGE_FORMAT = "rPrChange";

	/** The Constant DOCUMENT_BODY */
	public static final String DOCUMENT_BODY = "w:body";

	public static final String RELATIONSHIPS_HEADER = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/header";

	public static final String RELATIONSHIPS_FOOTER = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer";

	public static final String RELATIONSHIPS_COMMENTS = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/comments";

	private static final String WORD_NODE_NAME = "w:name";

	private static final String DOCX_W_STYLE_ID = "w:styleId";

	/**
	 * Instantiates a new dOCX helper.
	 */
	private DOCXHelper() {
	}

	/**
	 * Gets the text for the current node paragraph (<w:p/>) or child
	 * 
	 * @param n
	 *            the node
	 * 
	 * @return the text
	 */
	public static String getTextForParagraphOfGivenNode(Node n) {
		StringBuffer text = new StringBuffer();
		if (n != null) {
			Node parent = n;
			while (parent != null
					&& !WORD_STYLE_PARAGRAPH_W.equals(parent.getNodeName())) {
				parent = parent.getParentNode();
			}
			if (parent != null) {
				Node sibling = XMLHelper.getSibling(parent);
				Node nTmp = parent;
				while (nTmp != sibling) {
					nTmp = XMLHelper.next(nTmp);
					if (nTmp != null
							&& WORD_STYLE_TEXT_W.equals(nTmp.getNodeName())) {
						text.append(nTmp.getTextContent());
					}
				}
			}
		}
		return text.toString();
		// old behavior bellow
		// System.out.println(getNodeForStyleNode(n).getTextContent());
		// return getNodeForStyleNode(n).getTextContent();
	}

	/**
	 * Gets the text node for style node.
	 * 
	 * @param n
	 *            the style node
	 * 
	 * @return the text node for style node
	 */
	public static String getTextNodeForStyleNode(Node n) {
		return getTextNodeForStyleNode(n, null);
		// return getNodeForStyleNode(n).getTextContent();
	}

	/**
	 * Gets the text node for style node. The process will avoid forbidden
	 * properties (rPr) if it matches it the process will conitnue with the
	 * sibling of the parent of the current tag
	 * 
	 * @param n
	 *            the style node
	 * 
	 * @return the text node for style node
	 */
	public static String getTextNodeForStyleNode(Node n,
			String forbiddenProperties) {
		StringBuffer text = new StringBuffer();
		if (n != null && n.getParentNode() != null) {
			Node parent = n.getParentNode();
			while (parent != null
					&& !WORD_STYLE_PARAGRAPH_W.equals(parent.getNodeName())) {
				parent = parent.getParentNode();
			}
			if (parent != null) {
				Node nTmp = n;
				Node sibling = XMLHelper.getSibling(parent);
				while (nTmp != sibling) {
					nTmp = XMLHelper.next(nTmp);
					if (forbiddenProperties != null
							&& forbiddenProperties.length() > 0
							&& WORD_STYLE_PARAGRAPH_RPR.equals(nTmp
									.getNodeName())) {
						if (!rPrOk(nTmp, forbiddenProperties)) {
							nTmp = XMLHelper.getSibling(nTmp.getParentNode());
						}
					}
					if (nTmp != null
							&& WORD_STYLE_TEXT_W.equals(nTmp.getNodeName())) {
						text.append(nTmp.getTextContent());
					}
				}
			}
		}
		return text.toString();
		// old behavior bellow
		// System.out.println(getNodeForStyleNode(n).getTextContent());
		// return getNodeForStyleNode(n).getTextContent();
	}

	private static boolean rPrOk(Node current, String forbiddenProperties) {
		Node tmp = current;
		if (forbiddenProperties == null || forbiddenProperties.length() == 0) {
			return true;
		}
		boolean result = true;
		Node end = XMLHelper.getSibling(tmp);
		while (result && tmp != end) {
			tmp = XMLHelper.next(tmp);
			if (forbiddenProperties.equals(tmp.getNodeName())) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Gets the node for style node.
	 * 
	 * @param n
	 *            the style node
	 * 
	 * @return the node for style node
	 */
	public static Node getNodeForStyleNode(Node n) {
		Node result = null;
		if (WORD_STYLE.equals(XMLHelper.getTagValueWithoutNamespace(n))) {
			Node paragraph = n.getParentNode();
			// get the text
			do {
				paragraph = XMLHelper.next(paragraph);
			} while (paragraph != null
					&& (!WORD_STYLE_PARAGRAPH.equals(XMLHelper
							.getTagValueWithoutNamespace(paragraph)) && (!WORD_STYLE_TEXT
							.equals(XMLHelper
									.getTagValueWithoutNamespace(paragraph)))));
			if (paragraph != null
					&& WORD_STYLE_TEXT.equals(XMLHelper
							.getTagValueWithoutNamespace(paragraph))) {
				result = paragraph;
			}
		}
		return result;
	}

	public static String getStringStyleForStyleNodeInStyleFile(String result,
			XMLParser xml) {
		String theResult = result;
		Node n = xml.evaluateXPathExpression(XPATH_ALL_STYLES, DOCX_W_STYLE_ID,
				result, new DocxNamespaceContext());
		if (n != null) {
			NodeList l = n.getChildNodes();
			boolean found = false;
			for (int i = 0; !found && i < l.getLength(); i++) {
				Node ntmp = l.item(i);
				if (WORD_NODE_NAME.equals(ntmp.getNodeName())) {
					theResult = ntmp.getAttributes().getNamedItem(
							WORD_STYLE_ATTRIBUTE).getNodeValue();
					found = true;
				}
			}
		}
		return theResult;
	}

	/**
	 * Make a jump to the paragraph following the current Node
	 * 
	 * @param n
	 *            , the node to jump
	 * @param s
	 *            , the node name to jump (w:X)
	 * @return the node, null if not found
	 */
	public static Node jumpToNextNodeNamed(Node n, String s) {
		if (s == null || n == null) {
			return null;
		}
		Node result = n;
		do {
			result = XMLHelper.next(result);
		} while (result != null && !s.equals(result.getNodeName()));
		return result;
	}

	/**
	 * Checks if is not a modification.
	 * 
	 * @param currentNode
	 *            the current node
	 * 
	 * @return true, if is not a modification
	 */
	public static boolean isNotAModification(Node currentNode) {
		boolean change = isContainedBySpecificTag(currentNode,
				WORD_TAG_CHANGE_INS, WORD_STYLE_PARAGRAPH)
				|| isContainedBySpecificTag(currentNode, WORD_TAG_CHANGE_DEL,
						WORD_STYLE_PARAGRAPH)
				|| isContainedBySpecificTag(currentNode, WORD_TAG_CHANGE,
						WORD_STYLE_PARAGRAPH)
				|| isContainedBySpecificTag(currentNode,
						WORD_TAG_CHANGE_FORMAT, WORD_STYLE_PARAGRAPH);
		return !change;
	}

	/**
	 * Checks if is contained by specific tag.
	 * 
	 * @param n
	 *            the n
	 * @param search
	 *            the search
	 * @param limit
	 *            the limit
	 * 
	 * @return true, if is contained by specific tag
	 */
	public static boolean isContainedBySpecificTag(Node n, String search,
			String limit) {
		Node tmp = n;
		do {
			tmp = tmp.getParentNode();
		} while (!search.equals(XMLHelper.getTagValueWithoutNamespace(tmp))
				&& !limit.equals(XMLHelper.getTagValueWithoutNamespace(tmp)));

		return search.equals(XMLHelper.getTagValueWithoutNamespace(tmp));
	}
}
