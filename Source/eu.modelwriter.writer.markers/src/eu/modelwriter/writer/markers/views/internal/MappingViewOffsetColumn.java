package eu.modelwriter.writer.markers.views.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class MappingViewOffsetColumn extends MappingViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof MarkElement) {
			return Integer.toString(((MarkElement) element).getOffset());
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "Offset";
	}

}
