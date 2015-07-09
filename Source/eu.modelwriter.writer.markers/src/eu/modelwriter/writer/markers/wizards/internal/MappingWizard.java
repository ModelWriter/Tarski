package eu.modelwriter.writer.markers.wizards.internal;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.writer.markers.actions.MarkElement;
import eu.modelwriter.writer.markers.actions.Serialization;

public class MappingWizard extends Wizard {

	public MarkerMatchPage page;
	public ArrayList<MarkElement> targetMarkElements;
	public ArrayList<MarkElement> sourceMarkElements;
	private IMarker sourceMarker;

	public MappingWizard(IMarker sourceMarker) {
		super();
		this.sourceMarker = sourceMarker;
		targetMarkElements = new ArrayList<MarkElement>();
		sourceMarkElements = new ArrayList<MarkElement>();
		setNeedsProgressMonitor(true);
	}

	@Override
	public String getWindowTitle() {

		return "Mapping Markers";
	}

	@Override
	public void addPages() {

		page = new MarkerMatchPage();
		super.addPages();
		this.addPage(page);
	}

	@Override
	public boolean performFinish() {
		Object[] object = this.page.markTreeViewer.getCheckedElements();

		for (Object object2 : object) {
			if (object2 instanceof IMarker) {

				targetMarkElements.add(new MarkElement((IMarker) object2));

				try {
					if (((IMarker) object2).getAttribute(
							MarkElement.getSourceAttributeName()) == null) {
						sourceMarkElements
								.add(new MarkElement((IMarker) sourceMarker));
						((IMarker) object2).setAttribute(
								MarkElement.getSourceAttributeName(),
								Serialization.getInstance()
										.toString(sourceMarkElements));
						sourceMarkElements.clear();
					} else {
						sourceMarkElements = Serialization.getInstance()
								.fromString((String) ((IMarker) object2)
										.getAttribute(MarkElement
												.getSourceAttributeName()));
						sourceMarkElements
								.add(new MarkElement((IMarker) sourceMarker));
						((IMarker) object2).setAttribute(
								MarkElement.getSourceAttributeName(),
								Serialization.getInstance()
										.toString(sourceMarkElements));
						sourceMarkElements.clear();
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		try {
			sourceMarker.setAttribute(MarkElement.getTargetAttributeName(),
					Serialization.getInstance().toString(targetMarkElements));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
