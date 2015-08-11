package eu.modelwriter.marker.ui.internal.views.propertiesview;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import eu.modelwriter.marker.internal.MarkElement;

public class MarkerPropertyAdapterFactory implements IAdapterFactory {

  public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
    if (adapterType == IPropertySource.class && adaptableObject instanceof MarkElement) {
      return (T) new DetailPropertySource((MarkElement) adaptableObject);
    } else {
      return (T) new DetailPropertySource(null);
    }
  }

  @Override
  public Class<?>[] getAdapterList() {
    return new Class[] {IPropertySource.class};
  }

}
