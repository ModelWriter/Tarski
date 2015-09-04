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
package eu.modelwriter.marker;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;

public class ResourceDeltaPrinter implements IResourceDeltaVisitor {
  public boolean visit(IResourceDelta delta) {
    IResource res = delta.getResource();
    switch (delta.getKind()) {
      case IResourceDelta.ADDED:
        System.out.print("Resource ");
        System.out.print(res.getFullPath());
        System.out.println(" was added.");
        break;
      case IResourceDelta.REMOVED:
        System.out.print("Resource ");
        System.out.print(res.getFullPath());
        System.out.println(" was removed.");
        break;
      case IResourceDelta.CHANGED:
        System.out.print("Resource ");
        System.out.print(delta.getFullPath());
        System.out.println(" has changed.");
        int flags = delta.getFlags();
        if ((flags & IResourceDelta.CONTENT) != 0) {
          System.out.println("--> Content Change");
        }
        if ((flags & IResourceDelta.REPLACED) != 0) {
          System.out.println("--> Content Replaced");
        }
        if ((flags & IResourceDelta.MARKERS) != 0) {
          System.out.println("--> Marker Change");
          IMarkerDelta[] markers = delta.getMarkerDeltas();
          // if interested in markers, check these deltas
          for (IMarkerDelta iMarkerDelta : markers) {
            System.out.println(iMarkerDelta.getAttribute(IMarker.CHAR_START));
            switch (iMarkerDelta.getKind()) {
              case IResourceDelta.ADDED:
                System.out.println("Added");
                break;
              case IResourceDelta.REMOVED:
                System.out.println("Removed");
                break;
              case IResourceDelta.CHANGED:
                System.out.println("Changed");
                break;
            }
          }
        }
        break;
    }
    return true; // visit the children
  }
}
