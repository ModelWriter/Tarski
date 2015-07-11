package eu.modelwriter.writer.markers.internal;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

public class FileDecorator extends LabelProvider implements
		ILightweightLabelDecorator {

	public static final String ICON = "/icons/sample.gif";
	private static Font font = new Font(null, "Arial", 10, 0);
	private static Color color = new Color(null, 0, 0, 255);

	@Override
	public void decorate(Object resource, IDecoration decoration) {
		int markers = MarkerFactory.findMarkers((IResource) resource).size();
		if (markers > 0) {
			decoration.addOverlay(
					ImageDescriptor.createFromFile(FileDecorator.class, ICON),
					IDecoration.TOP_RIGHT);
			decoration.addPrefix("<MW> ");
			decoration.addSuffix(" " + markers + " marker(s)");
			decoration.setFont(font);
			decoration.setForegroundColor(color);
		}
	}

}
