package eu.modelwriter.marker.command;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;
import eu.modelwriter.marker.ui.views.masterview.MasterView;

public class SourceViewRefreshHandler extends AbstractHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    if (MasterView.getTreeViewer() == null)
      return null;
    if (MasterView.getTreeViewer().getSelection().isEmpty()
        || ((ITreeSelection) MasterView.getTreeViewer().getSelection()).getFirstElement() == null) {
      SourceView.setColumns(new ArrayList<MarkElement>());
      return null;
    }
    ITreeSelection treeSelection = ((ITreeSelection) MasterView.getTreeViewer().getSelection());
    MarkElement markElement = (MarkElement) treeSelection.getFirstElement();
    IMarker marker = markElement.getiMarker();
    SourceView.setColumns(MarkElementUtilities.getSourceList(marker));
    return true;
  }


}
