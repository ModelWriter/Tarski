package eu.modelwriter.marker.action;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MarkerMapping;

public class MarkerMappingAction implements IEditorActionDelegate {

  public MarkerMappingAction() {
    super();
  }

  @Override
  public void run(IAction action) {
    MarkerMapping.getInstance().run();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setActiveEditor(IAction action, IEditorPart targetEditor) {
    // TODO Auto-generated method stub

  }

}
