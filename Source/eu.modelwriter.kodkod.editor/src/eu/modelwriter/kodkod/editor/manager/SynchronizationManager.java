package eu.modelwriter.kodkod.editor.manager;

import javax.swing.JPanel;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;

import eu.modelwriter.kodkod.core.KodkodAnalyzer;
import eu.modelwriter.kodkod.core.KodkodAnalyzer.PARSE_AREA;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.editor.RelationModelEditor;
import eu.modelwriter.kodkod.editor.scanners.RelationModelPartitionScanner;
import eu.modelwriter.kodkod.editor.transformer.UniverseTransformer;
import eu.modelwriter.visualization.Visualization;

public class SynchronizationManager {
  private Visualization instance;
  private Universe kodkodUniverse;
  private eu.modelwriter.visualization.model.Universe visUniverse;
  private final KodkodAnalyzer kodkodAnalyzer;

  public SynchronizationManager(final IDocument document) throws BadLocationException {
    this.kodkodAnalyzer = new KodkodAnalyzer();
    this.evaluate(document);
    this.subscribeToVis();
  }

  public void evaluate(final IDocument document) throws BadLocationException {
    this.evaluate(document, null);
  }

  public void evaluate(final IDocument document, final IRegion dirtyRegion) {
    try {
      final ITypedRegion changedPartition =
          dirtyRegion == null ? null : document.getPartition(dirtyRegion.getOffset());
      this.parseRequiredPartitions(document, changedPartition);
      if (this.kodkodUniverse != null) {
        this.runVisualization(this.visUniverse);
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
  }

  private void parseRequiredPartitions(final IDocument document,
      final ITypedRegion changedPartition) throws BadLocationException {
    PARSE_AREA changedArea = null;
    String changedPartitionString;

    if (changedPartition != null) {
      changedPartitionString =
          document.get(changedPartition.getOffset(), changedPartition.getLength());

      switch (changedPartition.getType()) {
        case RelationModelPartitionScanner.RELATION_MODEL_OPTION:
          changedArea = KodkodAnalyzer.PARSE_AREA.OPTIONS;
          break;
        case RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND:
          changedArea = KodkodAnalyzer.PARSE_AREA.RELATION;
          this.setUniverse(changedPartitionString, changedArea);
          break;
        case RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE:
          changedArea = KodkodAnalyzer.PARSE_AREA.UNIVERSE;
          this.setUniverse(changedPartitionString, changedArea);
          break;
        case RelationModelPartitionScanner.DEFAULT_CONTENT_TYPE:
          changedArea = KodkodAnalyzer.PARSE_AREA.FORMULAS;
          break;
        default:
          break;
      }
    } else {
      changedPartitionString = document.get();
      changedArea = KodkodAnalyzer.PARSE_AREA.FULL_DOCUMENT;
      this.setUniverse(changedPartitionString, changedArea);
    }
  }

  private void runVisualization(final eu.modelwriter.visualization.model.Universe visUniverse) {
    this.instance = Visualization.getInstance(visUniverse, "kodkodUniv");
    final JPanel graph = this.instance.getGraph();
    RelationModelEditor.addGraphToFrame(graph);
  }

  private void setUniverse(final String changedPartitionString, final PARSE_AREA changedArea)
      throws BadLocationException {
    this.kodkodUniverse = this.kodkodAnalyzer.parseKodkod(changedPartitionString, changedArea);
    if (this.kodkodUniverse == null) {
      return;
    }
    this.visUniverse = UniverseTransformer.getInstance().transformKodkod2Vis(this.kodkodUniverse);
  }

  private void subscribeToVis() {
    final VisualizationSubscriber vs = new VisualizationSubscriber();
    this.instance.getNotifierList().add(vs);
  }
}
