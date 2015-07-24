package eu.modelwriter.marker;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

// plug-in must be loaded for resource change listener to work
public class ResourceManager implements IResourceChangeListener {
  private static ResourceManager manager;

  private ResourceManager() {
    ResourcesPlugin.getWorkspace().addResourceChangeListener(this,
        IResourceChangeEvent.POST_CHANGE);
  }

  public static void shutdown() {
    if (manager != null) {
      ResourcesPlugin.getWorkspace().removeResourceChangeListener(manager);

      manager = null;
    }
  }

  public static ResourceManager getManager() {
    if (manager == null)
      manager = new ResourceManager();
    return manager;
  }

  @Override
  public void resourceChanged(IResourceChangeEvent event) {
    // TODO Process events here.
    System.out.println("ModelWriter Marker Updater - resource change event");
    try {
      event.getDelta().accept(new IResourceDeltaVisitor() {
        public boolean visit(IResourceDelta delta) throws CoreException {
          StringBuffer buf = new StringBuffer(80);
          switch (delta.getKind()) {
            case IResourceDelta.ADDED:
              buf.append("ADDED");
              break;
            case IResourceDelta.REMOVED:
              buf.append("REMOVED");
              break;
            case IResourceDelta.CHANGED:
              buf.append("CHANGED");
              break;
            default:
              buf.append("[");
              buf.append(delta.getKind());
              buf.append("]");
              break;
          }
          buf.append(" ");
          buf.append(delta.getResource());
          System.out.println(buf);
          return true;
        }
      });
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }



}
