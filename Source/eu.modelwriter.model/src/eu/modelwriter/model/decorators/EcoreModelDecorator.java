package eu.modelwriter.model.decorators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.PlatformUI;

import eu.modelwriter.writer.markers.internal.FileDecorator;
import eu.modelwriter.writer.markers.internal.MarkerFactory;

public class EcoreModelDecorator extends LabelProvider implements ILightweightLabelDecorator {

  public static final String ICON = "/icons/Black.gif";
  private static Color color = new Color(null, 255, 192, 0);

  @Override
  public void decorate(Object resource, IDecoration decoration) {

    if (resource instanceof EClassImpl) {
      IFile file = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
          .getActiveEditor().getEditorInput();
      IMarker marker = MarkerFactory.findMarkerByLocationUri(file, "");
      if (marker != null) {
        decoration.addOverlay(ImageDescriptor.createFromFile(FileDecorator.class, ICON),
            IDecoration.BOTTOM_RIGHT);
        decoration.setForegroundColor(color);
      }
    }
  }

}
