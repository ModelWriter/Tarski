package eu.modelwriter.marker.ui.internal.wizards.examplewizard.examples.TextExample;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Java implements BundleActivator {

  private static BundleContext context;

  static BundleContext getContext() {
    return Java.context;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(final BundleContext bundleContext) throws Exception {
    Java.context = bundleContext;


  }

  /*
   * (non-Javadoc)
   *
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext bundleContext) throws Exception {
    Java.context = null;
  }


}
