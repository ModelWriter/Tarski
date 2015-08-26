package eu.modelwriter.prototype.xwpf.poi.extractor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.POIXMLException;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFFootnote;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFSDT;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/**
 * This annotate the word file content. We will parse the whole content of the
 * input document and comment every bodyElement with another text content and
 * style.
 * 
 * @author mrostren < marwa.rostren@obeo.fr >
 *
 */
public class WordChangeStyle {
	/** the document containing all new styles. */
	private XWPFDocument styleDocument;
	/** the input document we need to modify. */
	private XWPFDocument inputDocument;
	/** the styles extractor. */
	private StylesExtractor extractor;

	/**
	 * Constructor.
	 * 
	 * @param inputDocument
	 *            the input word document.
	 * @param styleDocument
	 *            the word document containing the new style.
	 */
	public WordChangeStyle(XWPFDocument inputDocument,
			XWPFDocument styleDocument) {
		this.inputDocument = inputDocument;
		this.styleDocument = styleDocument;
	}

	/**
	 * This runs the styles change of the input document.
	 */
	public void run() {
		extractor = new StylesExtractor(styleDocument);
		extractor.run();

		XWPFHeaderFooterPolicy headerFooterPolicy = inputDocument
				.getHeaderFooterPolicy();
		// Start out with all headers
		changeHeadersStyle(headerFooterPolicy);

		// Process all body elements
		for (IBodyElement element : inputDocument.getBodyElements()) {
			changeStylesOfBodyElement(element);
		}

		// handle endnotes and footnotes
		List<XWPFFootnote> footNotes = inputDocument.getFootnotes();
		for (XWPFFootnote footNote : footNotes) {
			// XXX changeFootNotesStyle(footNote);
		}

		// Finish up with all the footers
		changeFootersStyle(headerFooterPolicy);
	}

	/**
	 * This changes the footers styles of a specific policy.
	 * 
	 * @param headerFooterPolicy
	 *            the corresponding policy.
	 */
	private void changeFootersStyle(XWPFHeaderFooterPolicy headerFooterPolicy) {
		XWPFFooter firstPageFooter = headerFooterPolicy.getFirstPageFooter();
		if (firstPageFooter != null) {
			// Process all body elements
			for (IBodyElement element : firstPageFooter.getBodyElements()) {
				changeStylesOfFooterBodyElement(element);
			}
		}

		XWPFFooter eventPageFooter = headerFooterPolicy.getEvenPageFooter();
		if (eventPageFooter != null) {
			// Process all body elements
			for (IBodyElement element : eventPageFooter.getBodyElements()) {
				changeStylesOfFooterBodyElement(element);
			}
		}

		XWPFFooter defaultPageFooter = headerFooterPolicy.getDefaultFooter();
		if (defaultPageFooter != null) {
			// Process all body elements
			for (IBodyElement element : defaultPageFooter.getBodyElements()) {
				changeStylesOfFooterBodyElement(element);
			}
		}
	}

	/**
	 * This changes the headers styles of a specific policy.
	 * 
	 * @param headerFooterPolicy
	 *            the corresponding policy.
	 */
	private void changeHeadersStyle(XWPFHeaderFooterPolicy headerFooterPolicy) {
		XWPFHeader firstPageHeader = headerFooterPolicy.getFirstPageHeader();
		if (firstPageHeader != null) {
			// Process all body elements
			for (IBodyElement element : firstPageHeader.getBodyElements()) {
				changeStylesOfHeaderBodyElement(element);
			}
		}

		XWPFHeader eventPageHeader = headerFooterPolicy.getEvenPageHeader();
		if (eventPageHeader != null) {
			// Process all body elements
			for (IBodyElement element : eventPageHeader.getBodyElements()) {
				changeStylesOfHeaderBodyElement(element);
			}
		}

		XWPFHeader defaultHeader = headerFooterPolicy.getDefaultHeader();
		if (defaultHeader != null) {
			// Process all body elements
			for (IBodyElement element : defaultHeader.getBodyElements()) {
				changeStylesOfHeaderBodyElement(element);
			}
		}
	}

	/**
	 * changes styles of the body element.
	 * 
	 * @param bodyElement
	 *            the bodyElement.
	 */
	public void changeStylesOfHeaderBodyElement(IBodyElement bodyElement) {
		if (bodyElement instanceof XWPFParagraph) {
			// handle paragraphs
			changeStyleOfParagraph((XWPFParagraph) bodyElement,
					extractor.getPHeaderPr(), extractor.getRHeaderPr());
		} else if (bodyElement instanceof XWPFTable) {
			// handle tables
			changeStyleOfTable((XWPFTable) bodyElement,
					extractor.getPTableCellPr(), extractor.getRTableCellPr());
		} else if (bodyElement instanceof XWPFSDT) {
			// XXX:StructuredDocumentTags cannot be changed !
		}
	}

	/**
	 * changes styles of the body element.
	 * 
	 * @param bodyElement
	 *            the bodyElement.
	 */
	public void changeStylesOfFooterBodyElement(IBodyElement bodyElement) {
		if (bodyElement instanceof XWPFParagraph) {
			// handle paragraphs
			changeStyleOfParagraph((XWPFParagraph) bodyElement,
					extractor.getPFooterPr(), extractor.getRFooterPr());
		} else if (bodyElement instanceof XWPFTable) {
			// handle tables
			changeStyleOfTable((XWPFTable) bodyElement,
					extractor.getPTableCellPr(), extractor.getRTableCellPr());
		} else if (bodyElement instanceof XWPFSDT) {
			// XXX:StructuredDocumentTags cannot be changed !
		}
	}

	/**
	 * changes styles of the body element.
	 * 
	 * @param bodyElement
	 *            the bodyElement.
	 */
	public void changeStylesOfBodyElement(IBodyElement bodyElement) {
		if (bodyElement instanceof XWPFParagraph) {
			// handle paragraphs
			changeStyleOfParagraph((XWPFParagraph) bodyElement,
					extractor.getPPR(), extractor.getRPR());
		} else if (bodyElement instanceof XWPFTable) {
			// handle tables
			changeStyleOfTable((XWPFTable) bodyElement,
					extractor.getPTableCellPr(), extractor.getRTableCellPr());
		} else if (bodyElement instanceof XWPFSDT) {
			// XXX:StructuredDocumentTags cannot be changed !
		}
	}

	/**
	 * changes style of the paragraph.
	 * 
	 * @param paragraph
	 *            the paragraph.
	 * @param ppr
	 *            the paragraph style.
	 * @param rpr
	 *            the paragraph run style.
	 */
	public void changeStyleOfParagraph(XWPFParagraph paragraph, CTPPr ppr,
			CTRPr rpr) {
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
				changeHeadersStyle(headerFooterPolicy);
			}

			// handle this paragraph runs contents
			for (XWPFRun run : paragraph.getRuns()) {
				CTRPr rPr = run.getCTR().isSetRPr() ? run.getCTR().getRPr()
						: run.getCTR().addNewRPr();
				rPr.set(rpr);
			}

			// annotate the paragraph at the end
			CTPPr pPr = paragraph.getCTP().isSetPPr() ? paragraph.getCTP()
					.getPPr() : paragraph.getCTP().addNewPPr();

			pPr.set(ppr);

			// // handle comments
			// XXX MRO/Note There is no way to handle the comments styles today
			// using poi.
			if (ctSectPr != null) {
				// handle this paragraph footers
				changeFootersStyle(headerFooterPolicy);
			}
		} catch (IOException e) {
			throw new POIXMLException(e);
		} catch (XmlException e) {
			throw new POIXMLException(e);
		}
	}

	/**
	 * changes styles of table.
	 * 
	 * @param table
	 *            the table.
	 * @param ppr
	 *            the table style.
	 * @param rpr
	 *            the table run style.
	 */
	public void changeStyleOfTable(XWPFTable table, CTPPr ppr, CTRPr rpr) {
		// this works recursively to pull embedded tables from tables
		for (XWPFTableRow row : table.getRows()) {
			// edit the texts of the added row cells
			for (XWPFTableCell cell : row.getTableCells()) {
				String currentCellText = cell.getText();
				if (currentCellText != null) {
					List<XWPFParagraph> cellParagraphs = cell.getParagraphs();
					int size = cellParagraphs.size();
					for (int parPos = 0; parPos < size; parPos++) {
						XWPFParagraph cellPar = cell.getParagraphs()
								.get(parPos);
						CTPPr pPr = cellPar.getCTP().isSetPPr() ? cellPar
								.getCTP().getPPr() : cellPar.getCTP()
								.addNewPPr();
						pPr.set(ppr);

						List<XWPFRun> runs = cellPar.getRuns();
						changeStylesofRuns(runs, rpr);
					}
				}
			}
		}
	}

	/**
	 * Changes the style of all runs.
	 * 
	 * @param runs
	 *            the list of all runs to change.
	 * @param rpr
	 *            the table run style.
	 */
	private void changeStylesofRuns(List<XWPFRun> runs, CTRPr rpr) {
		for (XWPFRun run : runs) {
			CTRPr rPr = run.getCTR().isSetRPr() ? run.getCTR().getRPr() : run
					.getCTR().addNewRPr();
			rPr.set(rpr);
		}
	}

	/**
	 * Saves the result at the output path.
	 * 
	 * @param outputAbsolutePath
	 *            the output absolute path.
	 * @throws IOException
	 *             if a problem occurs while saving.
	 */
	public void save(String outputAbsolutePath) throws IOException {
		OutputStream outputStream = new FileOutputStream(outputAbsolutePath);
		try {
			inputDocument.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outputStream.close();
		}
	}
}
