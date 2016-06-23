package eu.modelwriter.marker.command;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import eu.modelwriter.configuration.alloy.AlloyParser;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.Serialization;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerTypeElement;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;
import eu.modelwriter.marker.ui.internal.wizards.markerwizard.MarkerPage;

public class AlloyParseUtil {
  public static void parse(final String filePath) {
    AlloyParseUtil.removeTypesFromMarkers();

    final AlloyParser parser = new AlloyParser(filePath);
    final ArrayList<MarkerTypeElement> roots = parser.getTypes();
    final ArrayList<String> rels = parser.getRels();

    MarkerPage.settings.put("alloyFile", filePath);
    final MarkerTypeElement systemRoot = new MarkerTypeElement("universe");
    for (final MarkerTypeElement root : roots) {
      systemRoot.getChildren().add(root);
    }

    try {
      MarkerPage.settings.put("universe", Serialization.getInstance().toString(systemRoot));
      MarkerPage.settings.put("rels", Serialization.getInstance().toString(rels));
    } catch (final IOException e1) {
      e1.printStackTrace();
    }
    if (Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getActivePage()
        .findView(Visualization.ID) != null) {
      Visualization.showViz();
    }
  }

  private static void removeTypesFromMarkers() {
    for (final IResource iResource : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
      boolean isClosed = false;
      try {
        if (!((IProject) iResource).isOpen()) {
          isClosed = true;
          ((IProject) iResource).open(new NullProgressMonitor());
        }
        for (IMarker iMarker : MarkerFactory.findMarkersAsArrayList(iResource)) {
          if (MarkUtilities.getType(iMarker) != null) {
            if (MappingWizard.findTargetCount(iMarker) != 0) {
              iMarker = MappingWizard.convertAnnotationType(iMarker, false, true);
            }
            MarkUtilities.setType(iMarker, null);
            AlloyUtilities.removeTypeFromMarker(iMarker);
          }
        }
        if (isClosed == true) {
          ((IProject) iResource).close(new NullProgressMonitor());
        }
      } catch (final CoreException e) {
        e.printStackTrace();
      }
    }
  }
}
