package eu.modelwriter.writer.markers.views.propertiesview.internal;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import eu.modelwriter.writer.markers.internal.MarkElement;
import eu.modelwriter.writer.markers.internal.Serialization;

public class MarkerPropertySource implements IPropertySource {
	private MarkElement marker;
	private ArrayList<MarkElement> sources = null;
	private ArrayList<MarkElement> targets = null;
	private static final Object DETAILS = new Object();
	private static final Object SOURCES = new Object();
	private static final Object TARGETS = new Object();

	public MarkerPropertySource(MarkElement marker) throws ClassNotFoundException, IOException, CoreException {
		this.marker = marker;
		IMarker mark = MarkElement.getMarker(marker);
		if ((mark).getAttribute(MarkElement.getTargetAttributeName()) != null)
			targets = Serialization.getInstance()
					.fromString((String) (mark).getAttribute(MarkElement.getTargetAttributeName()));
		if ((mark).getAttribute(MarkElement.getSourceAttributeName()) != null)
			sources = Serialization.getInstance()
					.fromString((String) (mark).getAttribute(MarkElement.getSourceAttributeName()));
	}

	public MarkerPropertySource(MarkElement marker, ArrayList<MarkElement> sources, ArrayList<MarkElement> targets) {
		this.marker = marker;

	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return new IPropertyDescriptor[] { new PropertyDescriptor(DETAILS, "Details"),
				new PropertyDescriptor(SOURCES, "Sources"), new PropertyDescriptor(TARGETS, "Targets") };
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (DETAILS.equals(id)) {
			return new DetailPropertySource(marker);
		} else if (TARGETS.equals(id)) {
			return new RelatedElementPropertySource(targets);
		} else if (SOURCES.equals(id)) {
			return new RelatedElementPropertySource(sources);
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}

}
