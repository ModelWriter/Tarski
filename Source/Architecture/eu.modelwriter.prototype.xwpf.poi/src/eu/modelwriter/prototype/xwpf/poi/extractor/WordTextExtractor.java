package eu.modelwriter.prototype.xwpf.poi.extractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.POIXMLException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.model.XWPFCommentsDecorator;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.ICell;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFHyperlink;
import org.apache.poi.xwpf.usermodel.XWPFHyperlinkRun;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFSDTCell;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/**
 * This extracts the word file content. You can use directly the
 * {@link XWPFWordExtractor} to extract the text and you can parse by yourself
 * the whole content of the input document.
 * 
 * @author mrostren < marwa.rostren@obeo.fr >
 *
 */
public class WordTextExtractor {
	/** The new line string. */
	private static final String NEW_LINE = "\n";
	/** the input document as a user model. */
	private XWPFDocument inputDocument;
	/** The list of paragraphs. */
	private List<XWPFParagraph> paragraphs = new ArrayList<>();
	/** The list of tables. */
	private List<XWPFTable> tables = new ArrayList<>();
	/** The list of pictures. */
	private List<XWPFPicture> pictures = new ArrayList<>();
	/** The list of tags. */
	private List<XWPFSDT> tags = new ArrayList<>();
	/** The list of headers. */
	private List<XWPFHeader> headers = new ArrayList<>();
	/** The list of footers. */
	private List<XWPFFooter> footers = new ArrayList<>();
	/** To handle hyperLinks. */
	private boolean fetchHyperlinks;

	/**
	 * Constructor.
	 * 
	 * @param inputDocument
	 *            the input word document.
	 */
	public WordTextExtractor(XWPFDocument inputDocument) {
		this.inputDocument = inputDocument;
	}

	/**
	 * Returns the content of the input word document.
	 * 
	 * @return the content of the input word document.
	 * @throws IOException
	 *             if a problem occurs while extracting the content.
	 */
	public String runXWPFWordExtractor() throws IOException {
		XWPFWordExtractor we = new XWPFWordExtractor(inputDocument);
		String text = we.getText();
		we.close(); // The Extractor cannot be used after close has been called.

		return text;
	}

	/**
	 * Returns the content of the input word document.
	 * 
	 * @return the content of the input word document.
	 */
	public String runCustomWordExtractor() {
		StringBuffer text = new StringBuffer();
		XWPFHeaderFooterPolicy headerFooterPolicy = inputDocument
				.getHeaderFooterPolicy();

		// Start out with all headers
		appendHeadersText(text, headerFooterPolicy);

		// Process all body elements
		for (IBodyElement e : inputDocument.getBodyElements()) {
			appendBodyElementText(text, e);
			text.append('\n');
		}

		// Finish up with all the footers
		appendFootersText(text, headerFooterPolicy);

		// Append statistics
		appendStats(text);

		return text.toString();
	}

	/**
	 * Appends statistics.
	 * 
	 * @param text
	 *            the text we use to append to.
	 */
	private void appendStats(StringBuffer text) {
		text.append("Headers number = ");
		text.append(footers.size());
		text.append(NEW_LINE);
		text.append("Paragraphs number = ");
		text.append(paragraphs.size());
		text.append(NEW_LINE);
		text.append("Tables number = ");
		text.append(tables.size());
		text.append(NEW_LINE);
		text.append("Pictures number = ");
		text.append(pictures.size());
		text.append(NEW_LINE);
		text.append("Tags number = ");
		text.append(tags.size());
		text.append(NEW_LINE);
		text.append("Footers number = ");
		text.append(footers.size());
	}

	/**
	 * Should we also fetch the hyperlinks, when fetching the text content?
	 * Default is to only output the hyperlink label, and not the contents.
	 * 
	 * @param fetch
	 *            To fetch hyperlinks argument. <code>true</code> to output the
	 *            hyperlinks contents, <code>false</code> otherwise.
	 */
	public void setFetchHyperlinks(boolean fetch) {
		fetchHyperlinks = fetch;
	}

	/**
	 * Appends all body element's text.
	 * 
	 * @param text
	 *            the string buffer to append.
	 * @param bodyElement
	 *            the bodyElement.
	 */
	public void appendBodyElementText(StringBuffer text,
			IBodyElement bodyElement) {
		if (bodyElement instanceof XWPFParagraph) {
			// handle paragraphs
			paragraphs.add((XWPFParagraph) bodyElement);
			appendParagraphText(text, (XWPFParagraph) bodyElement);
		} else if (bodyElement instanceof XWPFTable) {
			// handle tables
			tables.add((XWPFTable) bodyElement);
			appendTableText(text, (XWPFTable) bodyElement);
		} else if (bodyElement instanceof XWPFSDT) {
			// handle StructuredDocumentTags
			tags.add((XWPFSDT) bodyElement);
			text.append(((XWPFSDT) bodyElement).getContent().getText());
		}
	}

	/**
	 * Appends paragraphs text.
	 * 
	 * @param text
	 *            the string buffer to append.
	 * @param paragraph
	 *            the paragraph.
	 */
	public void appendParagraphText(StringBuffer text, XWPFParagraph paragraph) {
		try {
			CTSectPr ctSectPr = null;
			if (paragraph.getCTP().getPPr() != null) {
				ctSectPr = paragraph.getCTP().getPPr().getSectPr();
			}

			XWPFHeaderFooterPolicy headerFooterPolicy = null;

			if (ctSectPr != null) {
				// handle this paragraph headers
				headerFooterPolicy = new XWPFHeaderFooterPolicy(inputDocument,
						ctSectPr);
				appendHeadersText(text, headerFooterPolicy);
			}

			// handle this paragraph runs contents
			for (XWPFRun run : paragraph.getRuns()) {
				text.append(run.toString());
				if (run instanceof XWPFHyperlinkRun && fetchHyperlinks) {
					// handle this paragraph run hyperlinks
					XWPFHyperlink link = ((XWPFHyperlinkRun) run)
							.getHyperlink(inputDocument);
					if (link != null) {
						text.append(" <" + link.getURL() + ">");
					}
				}

				// explore pictures in the current run
				if (!run.getEmbeddedPictures().isEmpty()) {
					pictures.addAll(run.getEmbeddedPictures());
				}
			}

			// handle comments
			XWPFCommentsDecorator decorator = new XWPFCommentsDecorator(
					paragraph, null);
			String commentText = decorator.getCommentText();
			if (commentText.length() > 0) {
				text.append(commentText).append('\n');
			}

			// handle endnotes and footnotes
			String footnameText = paragraph.getFootnoteText();
			if (footnameText != null && footnameText.length() > 0) {
				text.append(footnameText + '\n');
			}

			if (ctSectPr != null) {
				// handle this paragraph footers
				appendFootersText(text, headerFooterPolicy);
			}
		} catch (IOException e) {
			throw new POIXMLException(e);
		} catch (XmlException e) {
			throw new POIXMLException(e);
		}

	}

	/**
	 * Appends tables text.
	 * 
	 * @param text
	 *            the string buffer to append.
	 * @param table
	 *            the table.
	 */
	public void appendTableText(StringBuffer text, XWPFTable table) {
		// this works recursively to pull embedded tables from tables
		for (XWPFTableRow row : table.getRows()) {
			List<ICell> cells = row.getTableICells();
			for (int i = 0; i < cells.size(); i++) {
				ICell cell = cells.get(i);
				if (cell instanceof XWPFTableCell) {
					text.append(((XWPFTableCell) cell).getTextRecursively());
				} else if (cell instanceof XWPFSDTCell) {
					text.append(((XWPFSDTCell) cell).getContent().getText());
				}
				if (i < cells.size() - 1) {
					text.append("\t");
				}
			}
			text.append('\n');
		}
	}

	/**
	 * Appends footers text.
	 * 
	 * @param text
	 *            the string buffer to append.
	 * @param headerFooterPolicy
	 *            the header and footer policy which contain all headers and
	 *            footers text.
	 */
	private void appendFootersText(StringBuffer text,
			XWPFHeaderFooterPolicy headerFooterPolicy) {
		if (headerFooterPolicy == null) {
			return;
		}

		appendFooterText(text, headerFooterPolicy.getFirstPageFooter());
		appendFooterText(text, headerFooterPolicy.getEvenPageFooter());
		appendFooterText(text, headerFooterPolicy.getDefaultFooter());
	}

	/**
	 * Appends the footer text content.
	 * 
	 * @param text
	 *            the text to append to.
	 * @param footer
	 *            the footer.
	 */
	private void appendFooterText(StringBuffer text, XWPFFooter footer) {
		if (footer != null) {
			footers.add(footer);
			text.append(footer.getText());
		}
	}

	/**
	 * Appends headers text.
	 * 
	 * @param text
	 *            the string buffer to append.
	 * @param headerFooterPolicy
	 *            the header and footer policy which contain all headers and
	 *            footers text.
	 */
	private void appendHeadersText(StringBuffer text,
			XWPFHeaderFooterPolicy headerFooterPolicy) {
		if (headerFooterPolicy == null) {
			return;
		}

		appendHeaderText(text, headerFooterPolicy.getFirstPageHeader());
		appendHeaderText(text, headerFooterPolicy.getEvenPageHeader());
		appendHeaderText(text, headerFooterPolicy.getDefaultHeader());
	}

	/**
	 * Appends the header text content.
	 * 
	 * @param text
	 *            the text to append to.
	 * @param header
	 *            the header.
	 */
	private void appendHeaderText(StringBuffer text, XWPFHeader header) {
		if (header != null) {
			headers.add(header);
			text.append(header.getText());
		}
	}

	public List<XWPFParagraph> getAllParagraphs() {
		return paragraphs;
	}

	public List<XWPFTable> getAllTables() {
		return tables;
	}

	public List<XWPFPicture> getAllPictures() {
		return pictures;
	}

	public List<XWPFSDT> getAllTags() {
		return tags;
	}

	public List<XWPFHeader> getAllHeaders() {
		return headers;
	}

	public List<XWPFFooter> getAllFooters() {
		return footers;
	}
}
