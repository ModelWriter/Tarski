package eu.modelwriter.writer.markers.views.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

public class MappingViewIDColumn extends MappingViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof IMarker) {
			try {
				return ((IMarker) element).getAttribute(IMarker.SOURCE_ID).toString();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "ID";
	}

}
