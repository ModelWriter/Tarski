package eu.modelwriter.writer.markers.wizards.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.Wizard;

import eu.modelwriter.writer.markers.actions.MarkElement;
import eu.modelwriter.writer.markers.actions.Serialization;

public class MappingWizard extends Wizard {

	public MarkerMatchPage page;
	ArrayList<MarkElement> markElements;

	public MappingWizard() {
		super();

		markElements = new ArrayList<MarkElement>();
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
			if (object2 instanceof IMarker)
				markElements.add(new MarkElement((IMarker) object2));
		}
		try {
			Serialization.getInstance().toString(markElements);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
