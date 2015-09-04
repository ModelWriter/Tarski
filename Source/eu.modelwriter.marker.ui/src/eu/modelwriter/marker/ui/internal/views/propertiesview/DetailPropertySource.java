/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.internal.views.propertiesview;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;

public class DetailPropertySource implements IPropertySource {
  private MarkElement marker;
  private static final Object ID = new Object();
  private static final Object LENGTH = new Object();
  private static final Object LINE_NUMBER = new Object();
  private static final Object OFFSET = new Object();
  private static final Object PATH = new Object();
  private static final Object TEXT = new Object();
  private static final Object TYPE = new Object();

  public DetailPropertySource(MarkElement marker) {
    this.marker = marker;
  }

  @Override
  public Object getEditableValue() {
    return null;
  }

  @Override
  public IPropertyDescriptor[] getPropertyDescriptors() {
    return new IPropertyDescriptor[] {new PropertyDescriptor(ID, "ID"),
        new PropertyDescriptor(LENGTH, "Length"),
        new PropertyDescriptor(LINE_NUMBER, "Line Number"),
        new PropertyDescriptor(OFFSET, "Offset"), new PropertyDescriptor(PATH, "Path"),
        new PropertyDescriptor(TEXT, "Text"), new PropertyDescriptor(TYPE, "Type")};
  }

  @Override
  public Object getPropertyValue(Object id) {
    if (marker != null) {
      if (ID.equals(id)) {
        return MarkElementUtilities.getSourceId(marker.getiMarker());
      } else if (LENGTH.equals(id)) {
        return MarkElementUtilities.getLength(marker.getiMarker());
      } else if (LINE_NUMBER.equals(id)) {
        return MarkElementUtilities.getLinenumber(marker.getiMarker());
      } else if (OFFSET.equals(id)) {
        return MarkElementUtilities.getStart(marker.getiMarker());
      } else if (PATH.equals(id)) {
        return MarkElementUtilities.getPath(marker.getiMarker());
      } else if (TEXT.equals(id)) {
        return MarkElementUtilities.getMessage(marker.getiMarker());
      } else if (TYPE.equals(id)) {
        return MarkElementUtilities.getType(marker.getiMarker());
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
