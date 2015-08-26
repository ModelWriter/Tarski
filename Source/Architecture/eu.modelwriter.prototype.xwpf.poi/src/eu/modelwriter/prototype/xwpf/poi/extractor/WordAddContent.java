package eu.modelwriter.prototype.xwpf.poi.extractor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRow;

/**
 * This adds content to the word file automatically respecting the existing
 * styles of elements.
 * 
 * @author mrostren < marwa.rostren@obeo.fr >
 *
 */
public class WordAddContent {
	/** the input document as a user model. */
	private XWPFDocument inputDocument;

	/**
	 * The Constructor.
	 * 
	 * @param inputDocument
	 *            the input document.
	 */
	public WordAddContent(XWPFDocument inputDocument) {
		this.inputDocument = inputDocument;
	}

	/**
	 * This adds content to the input document.
	 */
	public void run() {
		modifyContent();
	}

	/**
	 * Modify the content of paragraphs and tables.
	 */
	private void modifyContent() {
		List<IBodyElement> documentElements = inputDocument.getBodyElements();

		int size = documentElements.size();
		for (int i = 0; i < size; i++) {
			IBodyElement element = documentElements.get(i);
			if (element instanceof XWPFParagraph) {
				addStarting((XWPFParagraph) element);
				addEnding((XWPFParagraph) element);
			} else if (element instanceof XWPFTable) {
				modifyTable((XWPFTable) element);
			}
		}
	}

	/**
	 * Adds a message at the start of the paragraph.
	 * 
	 * @param paragraph
	 *            the paragraph to edit.
	 */
	private void addStarting(XWPFParagraph paragraph) {
		if (!paragraph.getRuns().isEmpty()) {
			XWPFRun firstRun = paragraph.getRuns().get(0);
			String currentText = firstRun.getText(0);
			if (currentText != null) {
				firstRun.setText("Start paragraph (" + currentText, 0);
			}
		}
	}

	/**
	 * Adds a message at the end of the paragraph.
	 * 
	 * @param paragraph
	 *            the paragraph to edit.
	 */
	private void addEnding(XWPFParagraph paragraph) {
		if (!paragraph.getRuns().isEmpty()) {
			int index = paragraph.getRuns().size() - 1;
			XWPFRun lastRun = paragraph.getRuns().get(index);
			String currentText = lastRun.getText(0);
			while (currentText == null && index > 0) {
				index--;
				lastRun = paragraph.getRuns().get(index);
				currentText = lastRun.getText(0);
			}
			if (currentText != null) {
				lastRun.setText(currentText + ") End paragraph", 0);
			}
		}
	}

	/**
	 * Modifies a table.
	 * 
	 * @param table
	 *            the table to Edit.
	 */
	private void modifyTable(XWPFTable table) {
		// Be careful we add a row to the same table... the loops can lead to
		// outOfMemory Exception :)
		// Copying the entire existing table row and decide which row will be
		// duplicated
		XWPFTableRow rowToAdd = null;
		int pos = 0;
		List<XWPFTableRow> sourceRows = table.getRows();
		for (int i = 0; i < sourceRows.size(); i++) {
			XWPFTableRow row = sourceRows.get(i);
			if (isFirstRowToCopy(row)) {
				// get the row format and content.
				CTRow ctRow = CTRow.Factory.newInstance();
				ctRow.set(row.getCtRow().copy());

				// create a new row
				rowToAdd = new XWPFTableRow(ctRow, table);
				// XXX NOTE: here I use a single variable to save the new row
				// position. If we need to produce many rows, we will need to
				// use a map to cache information...
				pos = table.getRows().indexOf(row) + 1;
				break;
			}
		}
		if (rowToAdd != null) {
			editRowCellsTexts(rowToAdd);
			// add the newRow to the table
			table.addRow(rowToAdd, pos);
		}
	}

	/**
	 * Returns whether the given row defines a text which must not be empty |
	 * null or not.
	 * 
	 * @param row
	 *            the given row.
	 * @return <code>true</code> if the row defines a text, <code>false</code>
	 *         otherwise.
	 */
	private boolean isFirstRowToCopy(XWPFTableRow row) {
		for (XWPFTableCell cell : row.getTableCells()) {
			// define which row we will copy
			String currentCellText = cell.getText();
			if (currentCellText != null && !"".equals(currentCellText)) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Edits all the row cell texts.
	 * 
	 * @param row
	 *            the row to edit.
	 */
	private void editRowCellsTexts(XWPFTableRow row) {
		// edit the texts of the added row cells
		for (XWPFTableCell cell : row.getTableCells()) {
			String currentCellText = cell.getText();
			if (currentCellText != null && !"".equals(currentCellText)) {
				List<XWPFParagraph> cellParagraphs = cell.getParagraphs();
				int size = cellParagraphs.size();
				XWPFParagraph cellPar = cell.getParagraphs().get(0);
				List<XWPFRun> runs = cellPar.getRuns();
				removeRunsFromParagraph(cellPar, runs, 1, runs.size() - 1);
				if (!runs.isEmpty()) {
					runs.get(0).setText("New Cell", 0);
				}

				// remove all other runs and clean their text contents.
				for (int parPos = 1; parPos < size; parPos++) {
					cellPar = cell.getParagraphs().get(parPos);
					runs = cellPar.getRuns();
					removeRunsFromParagraph(cellPar, runs, 0, runs.size() - 1);
				}
			}
		}
	}

	/**
	 * Removes all specified runs from a given paragraph. All the runs between
	 * the startIndex and the endIndex will be removed from the list.
	 * 
	 * @param paragraph
	 *            the paragraph we need to edit.
	 * @param runs
	 *            the list of all runs in the paragraph.
	 * @param startIndex
	 *            the first run to remove in the paragraph.
	 * @param endIndex
	 *            the last run to remoce in the paragraph.
	 */
	private void removeRunsFromParagraph(XWPFParagraph paragraph,
			List<XWPFRun> runs, int startIndex, int endIndex) {
		cleanTextsOfExistingRuns(runs);
		for (int runIndex = startIndex; runIndex < endIndex + 1; runIndex++) {
			paragraph.removeRun(runIndex);
		}
	}

	/**
	 * Cleans all texts of all the given runs.
	 * 
	 * @param runs
	 *            the given runs.
	 */
	private void cleanTextsOfExistingRuns(List<XWPFRun> runs) {
		if (!runs.isEmpty()) {
			for (int runIndex = 0; runIndex < runs.size(); runIndex++) {
				runs.get(runIndex).setText("", 0);
			}
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
