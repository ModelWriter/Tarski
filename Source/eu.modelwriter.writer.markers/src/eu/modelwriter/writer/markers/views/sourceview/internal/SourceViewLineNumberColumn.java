package eu.modelwriter.writer.markers.views.sourceview.internal;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class SourceViewLineNumberColumn extends SourceViewColumn {

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
		return 75;
	}
}
