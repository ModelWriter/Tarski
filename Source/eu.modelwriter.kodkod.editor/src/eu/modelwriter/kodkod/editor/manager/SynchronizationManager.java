package eu.modelwriter.kodkod.editor.manager;

import javax.swing.JPanel;

import org.eclipse.jface.text.IDocument;

import eu.modelwriter.kodkod.core.ParseTest;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.editor.transformer.UniverseTransformer;
import eu.modelwriter.visualization.Visualization;

public class SynchronizationManager {

  public SynchronizationManager() {
    this.registerToVis();
  }

  public void evaluate(final IDocument document) {
    final Universe universe = this.getKodkodUniverse(document);
    final eu.modelwriter.visualization.model.Universe visUniverse =
        UniverseTransformer.getInstance().transformKodkod2Vis(universe);
    this.runVisualization(visUniverse);
  }

  public JPanel getEditorInputFromVis(final IDocument document) {
    final Universe kodkodUniv = this.getKodkodUniverse(document);
    final eu.modelwriter.visualization.model.Universe visUniverse =
        UniverseTransformer.getInstance().transformKodkod2Vis(kodkodUniv);
    return Visualization.getInstance(visUniverse, "kodkodUniv").getGraph();
  }

  private Universe getKodkodUniverse(final IDocument document) {
    final String fullDocument = document.get();
    final ParseTest test = new ParseTest();
    return test.parseKodkod(fullDocument);
  }

  private void registerToVis() {
    // we will register to Visualization notifier on here.
  }

  private void runVisualization(final eu.modelwriter.visualization.model.Universe universe) {
    Visualization.getInstance("kodkodUniv").showModel();
  }
}
