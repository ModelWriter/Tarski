package eu.modelwriter.kodkod.editor.manager;

import javax.swing.JPanel;

import org.eclipse.jface.text.IDocument;

import eu.modelwriter.kodkod.core.ModelBuilder;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.editor.RelationModelEditor;
import eu.modelwriter.kodkod.editor.transformer.UniverseTransformer;
import eu.modelwriter.visualization.Visualization;

public class SynchronizationManager {
  public SynchronizationManager() {
    this.registerToVis();
  }

  public void evaluate(final IDocument document) {
    final Universe kodkodUniverse = this.getKodkodUniverse(document);
    final eu.modelwriter.visualization.model.Universe visUniverse =
        UniverseTransformer.getInstance().transformKodkod2Vis(kodkodUniverse);
    this.runVisualization(visUniverse);
  }

  private Universe getKodkodUniverse(final IDocument document) {
    final String fullDocument = document.get();
    final ModelBuilder test = new ModelBuilder();
    return test.parseKodkod(fullDocument);
  }

  private void registerToVis() {
    // we will register to Visualization notifier on here.
  }

  private void runVisualization(final eu.modelwriter.visualization.model.Universe visUniverse) {
    final JPanel graph = Visualization.getInstance(visUniverse, "kodkodUniv").getGraph();
    RelationModelEditor.addGraphToFrame(graph);
  }
}
