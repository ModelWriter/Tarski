package eu.modelwriter.core.alloyinecore.ui.editor.hyperlink;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.editors.text.TextEditor;

import eu.modelwriter.core.alloyinecore.ui.Activator;

public class AIEHyperlink implements IHyperlink {

  private Region region;

  public AIEHyperlink(int start, int stop) {
    region = new Region(start, stop - start + 1);
  }

  @Override
  public IRegion getHyperlinkRegion() {
    return region;
  }

  @Override
  public String getTypeLabel() {
    return "AIEHyperlink";
  }

  @Override
  public String getHyperlinkText() {
    return "Open declaration";
  }

  @Override
  public void open() {
    TextEditor editor =
        (TextEditor) Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    editor.selectAndReveal(20, 2);
    editor.setFocus();
  }

}
