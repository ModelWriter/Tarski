package eu.modelwriter.projectmanagement.handlers;

import org.eclipse.egit.github.core.Issue;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;

public class IssueLabelProvider extends BaseLabelProvider implements ILabelProvider {

  @Override
  public Image getImage(Object element) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getText(Object element) {
    Issue issue = (Issue) element;
    return element == null ? "" : issue.toString() + " - " + issue.getTitle();
  }

}
