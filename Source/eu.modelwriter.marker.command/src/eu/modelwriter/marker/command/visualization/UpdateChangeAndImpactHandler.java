package eu.modelwriter.marker.command.visualization;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.selectionwizard.SelectionWizard;

public class UpdateChangeAndImpactHandler extends AbstractHandler {

  IEditorPart editor;
  IFile file;
  ISelection selection;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (AlloyUtilities.isExists()) {
      this.editor =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
      this.file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .getActiveEditor().getEditorInput().getAdapter(IFile.class);
      this.selection =
          PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
      AlloyUtilities.setImpactAndChanged(this.getMarkerFromEditor());
      Visualization.showViz(Visualization.container);
    }
    return null;
  }

  private IMarker getMarkerFromEditor() {
    IMarker beChanged = null;
    if (this.selection instanceof ITextSelection) {
      final TextSelection textSelection = (TextSelection) this.selection;

      final ArrayList<IMarker> markerList =
          MarkerFactory.findMarkersInSelection(this.file, textSelection);
      if (markerList != null) {
        if (markerList.size() == 1) {
          beChanged = markerList.get(0);
        } else if (markerList.size() > 1) {
          final SelectionWizard selectionWizard = new SelectionWizard(markerList);
          final WizardDialog selectionDialog =
              new WizardDialog(MarkerActivator.getShell(), selectionWizard);
          if (selectionDialog.open() == 1) {
            return null;
          }
          beChanged = selectionWizard.getSelectedMarker();
        }
      }
    } else if (this.selection instanceof ITreeSelection) {
      final ITreeSelection treeSelection = (ITreeSelection) this.selection;
      if (this.selection != null
          && ((ITreeSelection) this.selection).getFirstElement() instanceof IMarker) {
        beChanged = (IMarker) ((ITreeSelection) this.selection).getFirstElement();
      } else if (this.selection != null && this.editor instanceof EcoreEditor) {
        if (treeSelection.getFirstElement() instanceof ENamedElement
            && ((ENamedElement) treeSelection.getFirstElement()).getName() != null
            && !((ENamedElement) treeSelection.getFirstElement()).getName().isEmpty()) {

          final URI uri = EcoreUtil.getURI((ENamedElement) treeSelection.getFirstElement());

          beChanged = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        } else if (!((EObject) treeSelection.getFirstElement() instanceof EModelElement)) {
          final URI uri = EcoreUtil.getURI((EObject) treeSelection.getFirstElement());
          beChanged = MarkerFactory.findMarkersByUri(this.file, uri.toString());
        }
      }
    }
    return beChanged;
  }

}
