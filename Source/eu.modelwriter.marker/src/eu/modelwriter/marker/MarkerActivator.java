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

import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class MarkerActivator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "eu.modelwriter.markers"; //$NON-NLS-1$

  // The shared instance
  private static MarkerActivator plugin;

  public class Images {
    public static final String IMAGE_BLACK_ID = "eu.modelwriter.markers.black.image";
    public static final String IMAGE_RED_ID = "eu.modelwriter.markers.red.image";
    public static final String IMAGE_MENU_ID = "eu.modelwriter.markers.menu.image";
    public static final String IMAGE_LINK_ID = "eu.modelwriter.markers.link.image";
    public static final String IMAGE_DELETE_ID = "eu.modelwriter.markers.delete.image";
    public static final String IMAGE_ANNOTATION_ID = "eu.modelwriter.markers.annotation.image";
    public static final String IMAGE_SIG_ID = "eu.modelwriter.markers.sig.image";
    public static final String IMAGE_RELATION_ID = "eu.modelwriter.markers.relation.image";
    public static final String IMAGE_MODELWRITER_ID = "eu.modelwriter.markers.modelwriter.image";
  }

  /**
   * The constructor
   */
  public MarkerActivator() {}

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework. BundleContext )
   */
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework. BundleContext )
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
  public static MarkerActivator getDefault() {
    return plugin;
  }

  /**
   * Returns an image descriptor for the image file at the given plug-in relative path
   *
   * @param path the path
   * @return the image descriptor
   */
  public static ImageDescriptor getImageDescriptor(String path) {
    return imageDescriptorFromPlugin(PLUGIN_ID, path);
  }

  @Override
  protected ImageRegistry createImageRegistry() {
    String[] images = new String[] {Images.IMAGE_BLACK_ID, "/icons/Black.gif", Images.IMAGE_RED_ID,
        "/icons/Red.gif", Images.IMAGE_MENU_ID, "/icons/Menu.gif", Images.IMAGE_LINK_ID,
        "/icons/Link.gif", Images.IMAGE_DELETE_ID, "/icons/Delete.gif", Images.IMAGE_ANNOTATION_ID,
        "/icons/Annotation.gif", Images.IMAGE_SIG_ID, "/icons/sig.png", Images.IMAGE_RELATION_ID,
        "/icons/relation.png", Images.IMAGE_MODELWRITER_ID, "/icons/modelwriter.gif"};
    ImageRegistry imageRegistry = super.createImageRegistry();
    Iterator<String> i = Arrays.asList(images).iterator();
    while (i.hasNext()) {
      String id = i.next();
      String imagePath = i.next();
      imageRegistry.put(id, ImageDescriptor.createFromFile(getClass(), imagePath));
    }
    return imageRegistry;
  }

  public static Shell getShell() {
    return getActiveWorkbenchWindow().getShell();
  }

  public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
  }

  /**
   * Always good to have this static method as when dealing with IResources having a interface to
   * get the editor is very handy
   * 
   * @return
   */
  public static IEditorPart getEditor() {
    return getActiveWorkbenchWindow().getActivePage().getActiveEditor();
  }
}
