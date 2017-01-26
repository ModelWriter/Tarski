package eu.modelwriter.core.alloyinecore.ui;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "eu.modelwriter.core.alloyinecore.ui"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;

  public Activator() {}

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    getImageRegistry();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
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

  public static Shell getShell() {
    return getActiveWorkbenchWindow().getShell();
  }

  public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
  }

  @Override
  protected void initializeImageRegistry(ImageRegistry reg) {
    loadImages(reg, "/icons/full/obj16");
    loadImages(reg, "/icons/full/exp16");
    loadImages(reg, "/icons/full/ovr16");
  }

  private void loadImages(ImageRegistry reg, String folderPath) {
    Enumeration<String> files = plugin.getBundle().getEntryPaths(folderPath);
    while (files.hasMoreElements()) {
      String path = files.nextElement();
      URL entry = plugin.getBundle().getEntry(path);
      ImageDescriptor desc = ImageDescriptor.createFromURL(entry);
      reg.put(new File(path).getName().replace(".gif", ""), desc);
    }
  }
}
