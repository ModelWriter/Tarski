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
package eu.modelwriter.marker.model.decorators;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import eu.modelwriter.marker.MarkerActivator;
import eu.modelwriter.marker.internal.MarkerFactory;

public class EcoreModelDecorator extends LabelProvider implements ILightweightLabelDecorator {
  private static Color color_blue = new Color(null, 30, 144, 255);
  private static Color color_maroon = new Color(null, 176, 48, 96);

  @Override
  public void decorate(Object resource, IDecoration decoration) {

    if (resource instanceof ENamedElement) {
      ENamedElement namedElement = (ENamedElement) resource;
      Resource eResource = namedElement.eResource();
      if (eResource == null)
        return;
      URI eUri = eResource.getURI();
      IResource iResource = null;
      if (eUri.isPlatformResource()) {
        String platformString = eUri.toPlatformString(true);
        iResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
      }
      if (iResource == null)
        return;

      AbstractUIPlugin plugin = MarkerActivator.getDefault();
      ImageRegistry imageRegistry = plugin.getImageRegistry();
      IMarker marker = null;
      URI uri = EcoreUtil.getURI(namedElement);
      marker = MarkerFactory.findMarkersByUri(iResource, uri.toString());

      if (marker != null) {
        try {
          if (marker.getType().equals(MarkerFactory.MARKER_MARKING)) {
            decoration.addOverlay(
                ImageDescriptor
                    .createFromImage(imageRegistry.get(MarkerActivator.Images.IMAGE_BLACK_ID)),
                IDecoration.BOTTOM_RIGHT);
            decoration.setForegroundColor(color_blue);
          } else {
            decoration.addOverlay(
                ImageDescriptor
                    .createFromImage(imageRegistry.get(MarkerActivator.Images.IMAGE_RED_ID)),
                IDecoration.BOTTOM_RIGHT);
            decoration.setForegroundColor(color_maroon);
          }
        } catch (CoreException e) {
          e.printStackTrace();
        }
        // EClass or EDataType
        if (namedElement instanceof EClassifier) {
          System.out.println("Classifier: " + namedElement.getName());
          EClassifier eC = (EClassifier) namedElement;
          System.out.println(eC.getEPackage().getNsURI());
          System.out.println(eC.getClassifierID());
        }
        if (namedElement instanceof EStructuralFeature) {
          System.out.println("Structural Feature: " + namedElement.getName());
          EStructuralFeature eS = (EStructuralFeature) namedElement;
          System.out.println(eS.getEContainingClass().getName());
          System.out.println(eS.getFeatureID());
        }
      }
    } else if (resource instanceof EObject) {
      EObject element = (EObject) resource;
      URI eUri = EcoreUtil.getURI(element);

      Resource eResource = element.eResource();
      if (eResource == null)
        return;
      IResource iResource = null;
      if (eUri.isPlatformResource()) {
        String platformString = eUri.toPlatformString(true);
        iResource = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
      }
      if (iResource == null)
        return;

      AbstractUIPlugin plugin = MarkerActivator.getDefault();
      ImageRegistry imageRegistry = plugin.getImageRegistry();
      try {
        IMarker marker = MarkerFactory.findMarkersByUri(iResource, eUri.toString());
        if (marker != null) {
          if (marker.getType().equals(MarkerFactory.MARKER_MARKING)) {
            decoration.addOverlay(
                ImageDescriptor
                    .createFromImage(imageRegistry.get(MarkerActivator.Images.IMAGE_BLACK_ID)),
                IDecoration.BOTTOM_RIGHT);
            decoration.setForegroundColor(color_blue);
          } else {
            decoration.addOverlay(
                ImageDescriptor
                    .createFromImage(imageRegistry.get(MarkerActivator.Images.IMAGE_RED_ID)),
                IDecoration.BOTTOM_RIGHT);
            decoration.setForegroundColor(color_maroon);
          }
        }
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
  }
}
