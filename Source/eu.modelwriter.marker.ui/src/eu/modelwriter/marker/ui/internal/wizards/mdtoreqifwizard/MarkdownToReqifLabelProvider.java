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
package eu.modelwriter.marker.ui.internal.wizards.mdtoreqifwizard;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.Specification;

public class MarkdownToReqifLabelProvider extends LabelProvider {
  @Override
  public String getText(Object element) {
    if (element instanceof IResource) {
      return ((IResource) element).getName();
    } else if (element instanceof Specification) {
      Specification spec = (Specification) element;
      EList<AttributeValue> listOfAttrVal = spec.getValues();
      for (AttributeValue attributeValue : listOfAttrVal) {
        if (attributeValue instanceof AttributeValueString) {
          AttributeValueString attValStr = (AttributeValueString) attributeValue;
          return attValStr.getTheValue();
        }
      }
    } else if (element instanceof SpecHierarchy) {
      SpecHierarchy spec = (SpecHierarchy) element;
      EList<AttributeValue> listOfAttrVal = spec.getObject().getValues();
      for (AttributeValue attributeValue : listOfAttrVal) {
        if (attributeValue instanceof AttributeValueString) {
          AttributeValueString attValStr = (AttributeValueString) attributeValue;
          return attValStr.getTheValue();
        }
      }
    } else {
      return "Unknown type: " + element.getClass();
    }
    return null;
  }
}
