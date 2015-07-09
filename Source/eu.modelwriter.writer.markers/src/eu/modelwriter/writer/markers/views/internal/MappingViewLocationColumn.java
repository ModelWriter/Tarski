package eu.modelwriter.writer.markers.views.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class MappingViewLocationColumn extends MappingViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof MarkElement) {
			return ((MarkElement) element).getLinenumber();
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "Line Number";
	}

	public int getWidth() {
		return 300;
	}
}
