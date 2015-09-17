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
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import eu.modelwriter.marker.internal.MarkUtilities;

public class DetailPropertySource implements IPropertySource {
  private static final Object ID = new Object();
  private static final Object LENGTH = new Object();
  private static final Object LINE_NUMBER = new Object();
  private static final Object OFFSET = new Object();
  private static final Object PATH = new Object();
  private static final Object TEXT = new Object();
  private static final Object TYPE = new Object();
  private IMarker marker;

  public DetailPropertySource(IMarker marker) {
    this.marker = marker;
  }

  @Override
  public Object getEditableValue() {
    return null;
  }

  @Override
  public IPropertyDescriptor[] getPropertyDescriptors() {
    return new IPropertyDescriptor[] {new PropertyDescriptor(DetailPropertySource.ID, "ID"),
        new PropertyDescriptor(DetailPropertySource.LENGTH, "Length"),
        new PropertyDescriptor(DetailPropertySource.LINE_NUMBER, "Line Number"),
        new PropertyDescriptor(DetailPropertySource.OFFSET, "Offset"),
        new PropertyDescriptor(DetailPropertySource.PATH, "Path"),
        new PropertyDescriptor(DetailPropertySource.TEXT, "Text"),
        new PropertyDescriptor(DetailPropertySource.TYPE, "Type")};
  }

  @Override
  public Object getPropertyValue(Object id) {
    if (this.marker != null) {
      if (DetailPropertySource.ID.equals(id)) {
        return MarkUtilities.getSourceId(this.marker);
      } else if (DetailPropertySource.LENGTH.equals(id)) {
        return MarkUtilities.getLength(this.marker);
      } else if (DetailPropertySource.LINE_NUMBER.equals(id)) {
        return MarkUtilities.getLinenumber(this.marker);
      } else if (DetailPropertySource.OFFSET.equals(id)) {
        return MarkUtilities.getStart(this.marker);
      } else if (DetailPropertySource.PATH.equals(id)) {
        return MarkUtilities.getPath(this.marker);
      } else if (DetailPropertySource.TEXT.equals(id)) {
        return MarkUtilities.getText(this.marker);
      } else if (DetailPropertySource.TYPE.equals(id)) {
        return MarkUtilities.getType(this.marker);
      }
    }
    return "";
  }

  @Override
  public boolean isPropertySet(Object id) {
    return false;
  }

  @Override
  public void resetPropertyValue(Object id) {}

  @Override
  public void setPropertyValue(Object id, Object value) {}
}
