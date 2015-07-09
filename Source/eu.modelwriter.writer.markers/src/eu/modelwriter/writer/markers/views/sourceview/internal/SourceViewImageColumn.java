package eu.modelwriter.writer.markers.views.sourceview.internal;

import org.eclipse.swt.graphics.Image;

import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class SourceViewImageColumn extends SourceViewColumn {

	@Override
	public String getTitle() {
		return "Remove";
	}

	@Override
	public Image getImage(Object element) {
		// if (element instanceof MarkElement) {
		// return ((MarkElement) element).getId();
		// }
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_DELETE);
	}

	@Override
	public int getWidth() {
		return 25;
	}

	@Override
	public String getText(Object element) {
		return null;
	}
}
