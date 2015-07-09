package eu.modelwriter.writer.markers.views.internal;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class MappingViewTextColumn extends MappingViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof MarkElement) {
			return ((MarkElement) element).getMessage();
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "Text";
	}

	public int getWidth() {
		return 300;
	}

}
