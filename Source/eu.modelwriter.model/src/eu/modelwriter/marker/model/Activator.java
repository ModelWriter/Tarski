package eu.modelwriter.marker.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.model.samples.MasterView;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "eu.modelwriter.model"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {}

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework. BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    
    getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener2() {
      @Override
      public void partActivated(IWorkbenchPartReference partRef) {
        if (partRef instanceof IViewReference)
          return;
        
        IFile file = partRef.getPage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
        TreeViewer treeViewer = MasterView.getTreeViewer();
        if (treeViewer != null){
          ArrayList<IMarker> allMarkers;
          try {
            allMarkers = MarkerFactory.findMarkersAsArrayList(file);
            Iterator<IMarker> iter = allMarkers.iterator();
            while (iter.hasNext()) {
              Object marker = iter.next();
              try {
                if (((IMarker) marker).getAttribute(MarkerFactory.LEADER_ID) == null
                    && ((IMarker) marker).getAttribute(MarkerFactory.GROUP_ID) != null) {
                  iter.remove();
                }
              } catch (CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }
            treeViewer.setInput(allMarkers);
          } catch (CoreException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        }

        if (partRef.getPart(false) instanceof IEditorPart
            && partRef.getPart(false) instanceof EcoreEditor) {

          EcoreEditor eEditor = (EcoreEditor) partRef.getPart(false);
          TreeViewer viewer = (TreeViewer) eEditor.getViewer();
          ILabelProvider labelProvider = (ILabelProvider) viewer.getLabelProvider();

          if (labelProvider instanceof DecoratingLabelProvider) {
            return;
          } else {
            ILabelDecorator decorator =
                getActiveWorkbenchWindow().getWorkbench().getDecoratorManager().getLabelDecorator();
            viewer.setLabelProvider(new DecoratingLabelProvider(labelProvider, decorator));
          }
        }

      }

      @Override
      public void partBroughtToTop(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub

      }

      @Override
      public void partClosed(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub

      }

      @Override
      public void partDeactivated(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub

      }

      @Override
      public void partOpened(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
      }

      @Override
      public void partHidden(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub

      }

      @Override
      public void partVisible(IWorkbenchPartReference partRef) {
        // TODO Auto-generated method stub
      }

      @Override
      public void partInputChanged(IWorkbenchPartReference partRef) {
        
      }
    });
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework. BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
  }

  public void log(String msg) {
    log(msg, null);
  }

  public void log(String msg, Exception e) {
    getLog().log(new Status(Status.INFO, getBundle().getSymbolicName(), Status.OK, msg, e));
  }

}
