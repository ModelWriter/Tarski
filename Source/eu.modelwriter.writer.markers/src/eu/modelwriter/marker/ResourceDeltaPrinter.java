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
