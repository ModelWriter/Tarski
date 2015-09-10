/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.internal.views.propertiesview;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertySource;

public class MarkerPropertyAdapterFactory implements IAdapterFactory {

  @Override
  @SuppressWarnings("unchecked")
  public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
    if ((adapterType == IPropertySource.class) && (adaptableObject instanceof IMarker)) {
      return (T) new DetailPropertySource((IMarker) adaptableObject);
    } else {
      return (T) new DetailPropertySource(null);
    }
  }

  @Override
  public Class<?>[] getAdapterList() {
    return new Class[] {IPropertySource.class};
  }
}
