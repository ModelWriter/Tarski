package eu.modelwriter.projectmanagement.github.requirements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlCursor;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Label;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

public class UserRequirementReviewMeetingDocument implements IRunnableWithProgress {

  private static XWPFDocument document;

  List<Issue> requirements = null;

  public UserRequirementReviewMeetingDocument(List<Issue> requirements) {
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
      url = new URL(
          "platform:/plugin/eu.modelwriter.projectmanagement/docs/D1.5.1 Minutes of the User Requirements Review meeting.docx");
      document = new XWPFDocument(url.openConnection().getInputStream());

      XWPFParagraph paragraph = null;
      for (XWPFParagraph p : document.getParagraphs()) {
        if (p.getStyle() != null && p.getStyle().equals("ITEAHeading1")
            && p.getText().equals("User Requirements")) {
          System.out.println(p.getText());
          paragraph = p;
        }
      }

      XmlCursor c = paragraph.getCTP().newCursor();
      c.toNextSibling();
      // iterate reqs
      XWPFParagraph p = document.insertNewParagraph(c);
      p.setStyle("ITEAHeading2");

      XWPFRun run = p.createRun();
      CTR ctr = run.getCTR();
      run.setText("");
      ctr.addNewTab();
      run.setText("Requirement No");
      ctr.addNewTab();
      run.setText("Requirement State");
      ctr.addNewTab();
      run.setText("Requirement Type");

      p.setAlignment(ParagraphAlignment.LEFT);
      c.dispose();
      //
      paragraph = p;
      //

      for (Issue issue : requirements) {
        List<Label> labels = issue.getLabels();
        int issueNumber = issue.getNumber();
        String labelOfUR = "";
        String typeOfUR = "";
        for (Label label : labels) {
          if (label.getName().equals("Mandatory") || label.getName().equals("Desirable")
              || label.getName().equals("Optional") || label.getName().equals("Out of Scope")) {
            labelOfUR = label.getName();
          }
          if (label.getName().equals("confirmed")) {
            typeOfUR = label.getName();
          }
        }

        if (typeOfUR.equals("")) {
          if (issue.getState().equals(IssueService.STATE_CLOSED)) {
            typeOfUR = IssueService.STATE_CLOSED;
          } else {
            typeOfUR = "not desired yet";
          }
        }

        XmlCursor cursor = paragraph.getCTP().newCursor();
        cursor.toNextSibling();
        // iterate reqs
        XWPFParagraph newP = document.insertNewParagraph(cursor);
        newP.setStyle("ITEABodyText");
        XWPFRun r = newP.createRun();
        ctr = r.getCTR();
        ctr.addNewTab();
        r.setText("#" + issueNumber);
        ctr.addNewTab();
        ctr.addNewTab();
        ctr.addNewTab();
        r.setText(typeOfUR);
        ctr.addNewTab();
        ctr.addNewTab();
        ctr.addNewTab();
        if (typeOfUR.equals("closed")) {
          ctr.addNewTab();
        }
        r.setText(labelOfUR);
        newP.setAlignment(ParagraphAlignment.LEFT);
        cursor.dispose();
        //
        paragraph = newP;
      }

      file =
          new File("C:\\ModelWriter\\D1.5.1 Minutes of the User Requirements Review meeting.docx");
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
    } finally {
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
