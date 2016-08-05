package eu.modelwriter.marker.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IWorkbenchWindow;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MasterViewDeleteHandler extends AbstractHandler {

	public static String COMMAND_ID = "eu.modelwriter.marker.command.masterviewdelete";

	private final String MASTERVIEW_ID = "eu.modelwriter.marker.ui.views.masterview";

	private final List<IMarker> delCandidates = new ArrayList<IMarker>();

	private final List<IMarker> switchCandidates = new ArrayList<IMarker>();

	private void deleteFromAlloyXML(final IMarker beDeleted) {
		if (AlloyUtilities.isExists()) {
			AlloyUtilities.removeMarkerFromRepository(beDeleted);
			if (MarkUtilities.getGroupId(beDeleted) == null || MarkUtilities.getLeaderId(beDeleted) != null) {
				AlloyUtilities.removeTypeFromMarker(beDeleted);
				AlloyUtilities.removeRelationOfMarker(beDeleted);
			}
		}
	}

	private void deleteSelections() {
		for (final IMarker iMarker : this.delCandidates) {
			this.deleteFromAlloyXML(iMarker);
			AnnotationFactory.removeAnnotation(iMarker);
			try {
				iMarker.delete();
			} catch (final CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private void determineCandidateMarkers(final IMarker marker) {
		if (MarkUtilities.getLeaderId(marker) != null) { // if the marker is
															// leader marker,
															// then take
															// all
															// of its group
			final List<IMarker> foundMarkers = MarkerFactory.findMarkersByGroupId(marker.getResource(),
					MarkUtilities.getGroupId(marker));
			if (!this.delCandidates.containsAll(foundMarkers)) {
				this.delCandidates.addAll(foundMarkers);
			}
		} else { // if not, just take'em
			if (!this.delCandidates.contains(marker)) {
				this.delCandidates.add(marker);
			}
		}
	}

	private void determineCandidateToSwitch() {
		for (final IMarker candidate : this.delCandidates) {

			final Map<IMarker, String> withType = AlloyUtilities.getRelationsOfSecondSideMarker(candidate);
			for (final IMarker iMarker : withType.keySet()) {
				if (!this.delCandidates.contains(iMarker)) {
					this.switchCandidates.add(iMarker);
				}
			}

			final ArrayList<IMarker> withoutType = AlloyUtilities.getSourcesOfMarkerAtRelations(candidate);
			for (final IMarker iMarker : withoutType) {
				if (!this.delCandidates.contains(iMarker)) {
					this.switchCandidates.add(iMarker);
				}
			}
		}
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// final MessageDialog dialog = new MessageDialog(
		// Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
		// "Warning",
		// null, "Not implemented yet!", MessageDialog.WARNING, new String[]
		// {"OK"}, 0);
		// dialog.open();
		this.delCandidates.clear();
		this.switchCandidates.clear();
		final IWorkbenchWindow window = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow();
		final ISelection selection = window.getSelectionService().getSelection();
		final String partId = window.getPartService().getActivePartReference().getId();

		if (selection != null && selection instanceof ITreeSelection && partId.equals(this.MASTERVIEW_ID)) {
			@SuppressWarnings("rawtypes")
			final Iterator iterator = ((TreeSelection) selection).iterator();
			while (iterator.hasNext()) {
				final Object element = iterator.next();
				if (element instanceof IMarker) {
          this.determineCandidateMarkers((IMarker) element);
        }
			}

			this.determineCandidateToSwitch();
			this.switchColors();
			this.deleteSelections();
		}
		return null;
	}

	private void switchColors() {
		for (final IMarker iMarker : this.switchCandidates) {
      AnnotationFactory.convertAnnotationType(iMarker, true, false,
          AlloyUtilities.getTotalTargetCount(iMarker));
		}
	}
}
