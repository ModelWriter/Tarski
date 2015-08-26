package eu.modelwriter.prototype.xwpf.poi.extractor;

import java.util.List;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFFootnote;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFtnEdn;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

/**
 * This extracts all styles of all first paragraph's style for each body element
 * of the .docx input document.
 * 
 * @author mrostren < marwa.rostren@obeo.fr >
 *
 */
public class StylesExtractor {
	/** the input document as a user model. */
	private XWPFDocument document;

	/** the paragraph style. */
	private CTPPr pPr;
	/** the paragraph run style. */
	private CTRPr rPr;

	/** the footer paragraph style. */
	private CTPPr pFooterPr;
	/** the footer paragraph run style. */
	private CTRPr rFooterPr;

	/** the header paragraph style. */
	private CTPPr pHeaderPr;
	/** the header paragraph run style. */
	private CTRPr rHeaderPr;

	/** the foot note style. */
	private CTFtnEdn footNoteStyle;

	/** the table cell style. */
	private CTPPr pTableCellPr;

	/** the table cell run style. */
	private CTRPr rTableCellPr;

	/**
	 * Constructor.
	 * 
	 * @param document
	 *            the docx document containing styles to extract.
	 */
	public StylesExtractor(XWPFDocument document) {
		this.document = document;
	}

	/**
	 * This runs the styles extractor.
	 */
	public void run() {
		XWPFHeaderFooterPolicy headerFooterPolicy = document
				.getHeaderFooterPolicy();
		// Start out with all headers
		extractHeadersStyles(headerFooterPolicy);

		// Process all body elements
		for (IBodyElement bodyElement : document.getBodyElements()) {
			if (bodyElement instanceof XWPFParagraph
					&& (pPr == null || rPr == null)) {
				// handle paragraphs
				extractParagraphStyle((XWPFParagraph) bodyElement);
			}
			if (bodyElement instanceof XWPFTable
					&& (pTableCellPr == null || rTableCellPr == null)) {
				// handle paragraphs
				extractTableStyle((XWPFTable) bodyElement);
			}
		}

		// handle endnotes and footnotes
		List<XWPFFootnote> footNotes = document.getFootnotes();
		for (XWPFFootnote footNote : footNotes) {
			CTFtnEdn noteStyle = footNote.getCTFtnEdn();
			if (noteStyle != null) {
				this.footNoteStyle = noteStyle;
				break;
			}
		}

		// Finish up with all the footers
		extractFootersStyles(headerFooterPolicy);
	}

	/**
	 * This extracts the table style.
	 * 
	 * @param table
	 *            the table.
	 */
	public void extractTableStyle(XWPFTable table) {
		// this works recursively to pull embedded tables from tables
		for (XWPFTableRow row : table.getRows()) {
			for (XWPFTableCell cell : row.getTableCells()) {
				String currentCellText = cell.getText();
				if (currentCellText != null) {
					XWPFParagraph cellPar = cell.getParagraphs().get(0);
					pTableCellPr = cellPar.getCTP().getPPr();
					List<XWPFRun> runs = cellPar.getRuns();
					if (!runs.isEmpty()) {
						rTableCellPr = runs.get(0).getCTR().getRPr();
					}
					break;
				}
			}
			break;
		}
	}

	public CTPPr getPTableCellPr() {
		return pTableCellPr;
	}

	public CTRPr getRTableCellPr() {
		return rTableCellPr;
	}

	/**
	 * This extracts all footers styles of a policy.
	 * 
	 * @param headerFooterPolicy
	 *            the header and footer policy containing all headers and
	 *            footers.
	 */
	private void extractFootersStyles(XWPFHeaderFooterPolicy headerFooterPolicy) {
		XWPFFooter firstPageFooter = headerFooterPolicy.getFirstPageFooter();
		if (firstPageFooter != null) {
			extractFooterStyles(firstPageFooter);
		}

		XWPFFooter eventPageFooter = headerFooterPolicy.getEvenPageFooter();
		if (eventPageFooter != null && (rFooterPr == null || pFooterPr == null)) {
			extractFooterStyles(eventPageFooter);
		}

		XWPFFooter defaultPageFooter = headerFooterPolicy.getDefaultFooter();
		if (defaultPageFooter != null
				&& (rFooterPr == null || pFooterPr == null)) {
			extractFooterStyles(defaultPageFooter);
		}
	}

	/**
	 * This extracts all headers styles of a policy.
	 * 
	 * @param headerFooterPolicy
	 *            the header and footer policy containing all headers and
	 *            footers.
	 */
	private void extractHeadersStyles(XWPFHeaderFooterPolicy headerFooterPolicy) {
		XWPFHeader firstPageHeader = headerFooterPolicy.getFirstPageHeader();
		if (firstPageHeader != null) {
			extractHeaderStyles(firstPageHeader);
		}

		XWPFHeader eventPageHeader = headerFooterPolicy.getEvenPageHeader();
		if (eventPageHeader != null && (rHeaderPr == null || pHeaderPr == null)) {
			extractHeaderStyles(eventPageHeader);
		}

		XWPFHeader defaultPageHeader = headerFooterPolicy.getDefaultHeader();
		if (defaultPageHeader != null
				&& (rHeaderPr == null || pHeaderPr == null)) {
			extractHeaderStyles(defaultPageHeader);
		}
	}

	/**
	 * This extracts a footer style.
	 * 
	 * @param paragraph
	 *            the concerned paragraph.
	 */
	private void extractFooterParagraphStyle(XWPFParagraph paragraph) {
		// handle this paragraph runs contents
		pFooterPr = paragraph.getCTP().getPPr();
		for (XWPFRun run : paragraph.getRuns()) {
			rFooterPr = run.getCTR().getRPr();
			break;
		}
	}

	/**
	 * This extracts a footer style.
	 * 
	 * @param footer
	 *            the concerned footer.
	 */
	private void extractFooterStyles(XWPFFooter footer) {
		// Process all body elements
		for (IBodyElement bodyElement : footer.getBodyElements()) {
			if (bodyElement instanceof XWPFParagraph) {
				// handle paragraphs
				extractFooterParagraphStyle((XWPFParagraph) bodyElement);
				break;
			}
		}
	}

	/**
	 * This extracts a header style.
	 * 
	 * @param header
	 *            the concerned header.
	 */
	private void extractHeaderStyles(XWPFHeader header) {
		// Process all body elements
		for (IBodyElement bodyElement : header.getBodyElements()) {
			if (bodyElement instanceof XWPFParagraph) {
				// handle paragraphs
				extractHeaderParagraphStyle((XWPFParagraph) bodyElement);
				break;
			}
		}
	}

	/**
	 * This extracts a paragraph header style.
	 * 
	 * @param paragraph
	 *            the concerned paragraph.
	 */
	private void extractHeaderParagraphStyle(XWPFParagraph paragraph) {

		// handle this paragraph runs contents
		pHeaderPr = paragraph.getCTP().getPPr();
		for (XWPFRun run : paragraph.getRuns()) {
			rHeaderPr = run.getCTR().getRPr();
			break;
		}
	}

	/**
	 * This extracts a paragraph style.
	 * 
	 * @param paragraph
	 *            the concerned paragraph.
	 */
	private void extractParagraphStyle(XWPFParagraph paragraph) {
		// handle this paragraph runs contents
		pPr = paragraph.getCTP().getPPr();
		for (XWPFRun run : paragraph.getRuns()) {
			rPr = run.getCTR().getRPr();
			break;
		}
	}

	public XWPFDocument getDocument() {
		return document;
	}

	public CTPPr getPPR() {
		return pPr;
	}

	public CTRPr getRPR() {
		return rPr;
	}

	public CTPPr getPFooterPr() {
		return pFooterPr;
	}

	public CTRPr getRFooterPr() {
		return rFooterPr;
	}

	public CTPPr getPHeaderPr() {
		return pHeaderPr;
	}

	public CTRPr getRHeaderPr() {
		return rHeaderPr;
	}

	public CTFtnEdn getFootNoteStyle() {
		return footNoteStyle;
	}
}
