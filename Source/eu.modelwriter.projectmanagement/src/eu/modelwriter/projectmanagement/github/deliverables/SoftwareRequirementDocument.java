package eu.modelwriter.projectmanagement.github.deliverables;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlCursor;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Label;
import org.eclipse.jface.operation.IRunnableWithProgress;

import eu.modelwriter.projectmanagement.github.Constants;

public class SoftwareRequirementDocument implements IRunnableWithProgress {
private static XWPFDocument document;
	
	List<Issue> requirements = null;
	public SoftwareRequirementDocument(List<Issue> requirements) {
		this.requirements = requirements;
	}

	@Override
	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
        monitor.beginTask("Performing write. Please wait...", totalUnitsOfWork);
        // This only performs the tasks
        
        URL url;
        FileOutputStream out = null;
        File file;
		try {
			url = new URL("platform:/plugin/eu.modelwriter.projectmanagement/docs/D1.6.2 Software Requirements Document (SRD).docx");
			document = new XWPFDocument(url.openConnection().getInputStream());
			
			XWPFParagraph paragraph = null;
			for (XWPFParagraph p : document.getParagraphs()) {
				if (p.getStyle() != null && p.getStyle().equals("ITEAHeading1") && p.getText().equals("Software Requirements")){
					System.out.println(p.getText());
					paragraph = p;
				}
			}
			
			for (Issue issue : requirements) {		
				XmlCursor cursor = paragraph.getCTP().newCursor();
				cursor.toNextSibling();
				//iterate reqs
				XWPFParagraph newP = document.insertNewParagraph(cursor);
				newP.setStyle("ITEAHeading2");
				List<Label> labels = issue.getLabels();
				String wpNumber ="";
				for (Label label : labels) {
					if (label.getName().startsWith("WP")) {
						wpNumber = label.getName();
						break;
					}
				}
				if (wpNumber != "")
				{
					newP.createRun().setText("REQ-UR-" + wpNumber.substring(0, 3) + "-" + issue.getNumber());
				}
				else{
					newP.createRun().setText("REQ-UR-" + issue.getNumber());
				}
				newP.setAlignment(ParagraphAlignment.LEFT);
				cursor.dispose();
				//
				cursor = newP.getCTP().newCursor();
				cursor.toNextSibling();
				newP = document.insertNewParagraph(cursor);
				newP.setStyle("ITEABodyText");
				XWPFRun r = newP.createRun();
				r.setText(issue.getTitle() + "\n");
				newP.setAlignment(ParagraphAlignment.LEFT);
				r.addBreak();		
				cursor.dispose();
				//
				//
				cursor = newP.getCTP().newCursor();
				cursor.toNextSibling();
				newP = document.insertNewParagraph(cursor);
				newP.setStyle("ITEABodyText");
				r = newP.createRun();
				r.setText("URI: ");
				r.setBold(true);
				r = newP.createRun();
				r.setText("https://github.com/" + Constants.ORGANIZATION + "/" + Constants.REPOSITORY + "/issues/" + issue.getNumber());
				r.setUnderline(UnderlinePatterns.SINGLE);
				r.setColor("00A651");
				newP.setAlignment(ParagraphAlignment.LEFT);
				cursor.dispose();
				//
				cursor = newP.getCTP().newCursor();
				cursor.toNextSibling();
				newP = document.insertNewParagraph(cursor);
				newP.setStyle("ITEABodyText");
				newP.setAlignment(ParagraphAlignment.LEFT);
				r = newP.createRun();
				r.setText("Created: ");
				r.setBold(true);
				SimpleDateFormat dateFormat = 
					      new SimpleDateFormat("dd.MM.yyyy");
				newP.createRun().setText(dateFormat.format(issue.getCreatedAt()));
				cursor.dispose();
				//
				cursor = newP.getCTP().newCursor();
				cursor.toNextSibling();
				newP = document.insertNewParagraph(cursor);
				newP.setStyle("ITEABodyText");
				r = newP.createRun();
				r.setText("Created By: ");
				r.setBold(true);
				newP.createRun().setText(issue.getUser().getLogin());
				newP.setAlignment(ParagraphAlignment.LEFT);
				cursor.dispose();
				//
				cursor = newP.getCTP().newCursor();
				cursor.toNextSibling();
				newP = document.insertNewParagraph(cursor);
				newP.setStyle("ITEABodyText");
				r = newP.createRun();
				r.setText("Assignee: ");
				r.setBold(true);
				if (issue.getAssignee() != null)
					newP.createRun().setText(issue.getAssignee().getLogin());
				else
					newP.createRun().setText("N/A");
				newP.setAlignment(ParagraphAlignment.LEFT);
				cursor.dispose();
				//
				paragraph = newP;
			}
			
			file = new File("C:\\ModelWriter\\D1.6.2 Software Requirements Document (SRD).docx");
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}					
			out = new FileOutputStream(file);
				
			document.write(out);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		

        
        monitor.done();
	}

}
