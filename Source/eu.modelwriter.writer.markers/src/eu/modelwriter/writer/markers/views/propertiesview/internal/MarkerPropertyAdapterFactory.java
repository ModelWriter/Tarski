package eu.modelwriter.writer.markers.views.propertiesview.internal;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

import eu.modelwriter.writer.markers.internal.MarkElement;

public class MarkerPropertyAdapterFactory implements IAdapterFactory {

  public Object getAdapter(Object adaptableObject, Class adapterType) {
    if (adapterType == IPropertySource.class && adaptableObject instanceof MarkElement) {
      try {
        return new MarkerPropertySource((MarkElement) adaptableObject);
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      return null;
    }
    return adapterType;
  }

  @Override
  public Class<?>[] getAdapterList() {
    return new Class[] {IPropertySource.class};
  }

}
