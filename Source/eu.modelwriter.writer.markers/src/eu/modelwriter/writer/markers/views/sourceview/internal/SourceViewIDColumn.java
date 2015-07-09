package eu.modelwriter.writer.markers.views.sourceview.internal;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class SourceViewIDColumn extends SourceViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof MarkElement) {
			return ((MarkElement) element).getId();
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "ID";
	}

}
