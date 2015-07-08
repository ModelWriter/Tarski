package eu.modelwriter.writer.markers.views.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

public class MappingViewLocationColumn extends MappingViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof IMarker) {
			try {
				return ((IMarker) element).getAttribute(IMarker.LOCATION).toString();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "Location";
	}

	public int getWidth() {
		return 300;
	}
}
