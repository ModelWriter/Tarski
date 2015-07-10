package eu.modelwriter.writer.markers.views.targetview.internal;

import eu.modelwriter.writer.markers.actions.MarkElement;

public class TargetViewPathColumn extends TargetViewColumn {

	@Override
	public String getText(Object element) {
		if (element instanceof MarkElement) {
			return ((MarkElement) element).getPath();
		}
		return "";
	}

	@Override
	public String getTitle() {
		return "Path";
	}

	public int getWidth() {
		return 350;
	}
}
