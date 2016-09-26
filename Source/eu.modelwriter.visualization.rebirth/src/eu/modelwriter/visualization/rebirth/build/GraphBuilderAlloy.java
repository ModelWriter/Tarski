package eu.modelwriter.visualization.rebirth.build;

import java.io.File;

import javax.swing.JPanel;

import org.eclipse.emf.common.util.URI;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;
import eu.modelwriter.visualization.rebirth.input.IGraphInput;

public class GraphBuilderAlloy implements IGraphBuilder {
  private final DocumentRoot documentRoot;

  public GraphBuilderAlloy(final IGraphInput graphInput) {
    documentRoot = (DocumentRoot) graphInput.get();

  }

  @SuppressWarnings("unchecked")
  private String writeDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    final String alsPath = documentRoot.getAlloy().getInstance().getFilename();
    final String specName = alsPath.substring(
        alsPath.lastIndexOf(File.separator, alsPath.lastIndexOf(".")));
    final String xmlFilePath = "temp" + File.separator + specName + ".xml";
    modelIO.write(URI.createFileURI(xmlFilePath), documentRoot);
    return xmlFilePath;
  }

  @Override
  public JPanel build() {
    final String xmlFilePath = writeDocumentRoot();
    final File file = new File(xmlFilePath);
    AlloyInstance instance = null;
    try {
      instance = StaticInstanceReader.parseInstance(file);
    } catch (final Err e) {
      e.printStackTrace();
    }
    final VizState myState = new VizState(instance);
    final VizGraphPanel panel = new VizGraphPanel(myState, false);

    return panel;
  }
}
