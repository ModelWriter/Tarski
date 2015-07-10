package eu.modelwriter.writer.markers.views.sourceview.internal;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class SourceViewLengthColumn extends SourceViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof MarkElement) {
			return Integer.toString(((MarkElement) element).getLength());
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "Length";
	}

	public int getWidth() {
		return 50;

	}
}
