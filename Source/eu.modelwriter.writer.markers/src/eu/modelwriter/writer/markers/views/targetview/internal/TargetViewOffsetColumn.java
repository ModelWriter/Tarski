package eu.modelwriter.writer.markers.views.targetview.internal;

import eu.modelwriter.writer.markers.internal.MarkElement;

public class TargetViewOffsetColumn extends TargetViewColumn {

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

	public int getWidth() {
		return 50;
	}
}
