package eu.modelwriter.prototype.xwpf.poi.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * This parses a docx document and launch many operation on it.
 * 
 * @author mrostren < marwa.rostren@obeo.fr >
 *
 */
public class DocumentParser {
	/** the input document as a user model. */
	private XWPFDocument inputDocument;
	/** the input file stream. */
	private FileInputStream iStream;
	/** the input package. */
	private OPCPackage pack;

	/**
	 * This launch the prototype API.
	 * 
	 * @param args
	 *            input arguments.
	 */
	public static void main(String[] args) {

		String fileName = args[0];
		File inputFile = new File(fileName);

		if (!inputFile.exists()) {
			throw new IllegalArgumentException(
					"The input argument must be an absolute file path.");
		}

		DocumentParser parser = new DocumentParser();
		try {
			parser.documentExploration(inputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This explores the document content.
	 * 
	 * @param inputFile
	 *            the input file.
	 * @throws IOException
	 *             if an exception occurs while the document exploration.
	 */
	public void documentExploration(File inputFile) throws IOException {
		try {
			inputDocument = getXWPFDocument(inputFile);
			if (inputDocument != null) {
				/* Extract Text Content from the document */
				WordTextExtractor extractor = new WordTextExtractor(
						inputDocument);
				// Get the document text without styles using an already
				// existing
				// poi class.
				save(extractor.runXWPFWordExtractor(),
						"output/extractedTextNoStyles_UsingXWPFWordExtractor.txt");

				// Get all the document text and styles using a custom class
				save(extractor.runCustomWordExtractor(),
						"output/extractedTextNoStyles_UsingCustomWordTextExtractor.txt");
			}

			/* Add Comments in the document */
			// XXX MRO NOTE: poi API does not allow the creation of new comments
			// yet!

			inputDocument = getXWPFDocument(inputFile);
			if (inputDocument != null) {
				/* Add annotations in the document */
				File annotationFile = new File("resources/annotation.docx");
				if (!inputFile.exists()) {
					throw new IllegalArgumentException(
							"The annotaton file must exist in the resouces folder of the current project.");
				}

				XWPFDocument annotationDocument = getXWPFDocument(annotationFile);
				if (annotationDocument != null) {
					WordChangeStyle styleModifier = new WordChangeStyle(
							inputDocument, annotationDocument);

					styleModifier.run();
					styleModifier.save("output/annotatedVersion.docx");
				}
			}

			inputDocument = getXWPFDocument(inputFile);
			if (inputDocument != null) {
				// Add content to the document respecting existing styles
				WordAddContent contentAdder = new WordAddContent(inputDocument);

				contentAdder.run();
				contentAdder.save("output/AddNewContentVersion.docx");
			}
		} finally {
			if (iStream != null) {
				iStream.close();
			}
			if (pack != null) {
				pack.close();
			}
		}

	}

	/**
	 * This saves the result.
	 * 
	 * @param documentContent
	 *            the document text content.
	 * @param outputFilePath
	 *            the output file path.
	 * @throws IOException
	 *             if a problem occurs while saving.
	 */
	private void save(String documentContent, String outputFilePath)
			throws IOException {
		FileUtils.writeStringToFile(new File(outputFilePath), documentContent);
	}

	/**
	 * Load the input file document as a user model.
	 * 
	 * @param inputFile
	 *            the input file document.
	 * @return the user model.
	 * @throws IOException
	 *             if a problem occurs while loading the input file.
	 */
	public XWPFDocument getXWPFDocument(File inputFile) throws IOException {
		XWPFDocument document = null;
		try {
			iStream = new FileInputStream(inputFile);
			pack = OPCPackage.open(iStream);
			document = new XWPFDocument(pack);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}
