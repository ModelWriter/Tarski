package eu.modelwriter.marker.ui.internal.views.propertiesview;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import eu.modelwriter.marker.internal.MarkElement;

public class MarkerPropertyAdapterFactory implements IAdapterFactory {

  @SuppressWarnings("unchecked")
  public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
    if (adapterType == IPropertySource.class && adaptableObject instanceof MarkElement) {
      return new DetailPropertySource((MarkElement) adaptableObject);
    } else {
      return null;
    }
  }

  @Override
  public Class<?>[] getAdapterList() {
    return new Class[] {IPropertySource.class};
  }

}
