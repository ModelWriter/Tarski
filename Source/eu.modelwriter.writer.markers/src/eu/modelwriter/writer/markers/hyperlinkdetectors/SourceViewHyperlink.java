package eu.modelwriter.writer.markers.hyperlinkdetectors;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.writer.markers.MarkerActivator;
import eu.modelwriter.writer.markers.actions.MarkElement;
import eu.modelwriter.writer.markers.actions.MarkerFactory;
import eu.modelwriter.writer.markers.actions.Serialization;
import eu.modelwriter.writer.markers.views.SourceView;

public class SourceViewHyperlink implements IHyperlink {

	private final IRegion fUrlRegion;

	public SourceViewHyperlink(IRegion urlRegion) {
		fUrlRegion = urlRegion;
	}

	@Override
	public IRegion getHyperlinkRegion() {
		return fUrlRegion;
	}

	@Override
	public String getTypeLabel() {
		return null;
	}

	@Override
	public String getHyperlinkText() {
		return "Open Mapped Element in Source View";
	}

	@Override
	public void open() {
		try {
			IFile file = (IFile) MarkerActivator.getEditor().getEditorInput().getAdapter(IFile.class);

			IMarker beMapped = MarkerFactory.findMarker(file, fUrlRegion.getOffset());

			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView("eu.modelwriter.writer.markers.views.sourceview");

			ArrayList<MarkElement> sourceElements = null;
			try {
				if ((beMapped != null) && (beMapped.getAttribute(MarkElement.getSourceAttributeName()) != null)) {
					sourceElements = Serialization.getInstance()
							.fromString((String) beMapped.getAttribute(MarkElement.getSourceAttributeName()));
					SourceView.setColumns(sourceElements);
				} else {
					SourceView.setColumns(new ArrayList<MarkElement>());
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
