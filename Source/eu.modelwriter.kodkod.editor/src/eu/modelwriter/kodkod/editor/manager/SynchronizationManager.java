package eu.modelwriter.kodkod.editor.manager;

import javax.swing.JPanel;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;

import eu.modelwriter.kodkod.core.KodkodAnalyzer;
import eu.modelwriter.kodkod.core.KodkodAnalyzer.PARSE_AREA;
import eu.modelwriter.kodkod.core.model.Universe;
import eu.modelwriter.kodkod.editor.RelationModelEditor;
import eu.modelwriter.kodkod.editor.manager.transformer.UniverseTransformer;
import eu.modelwriter.kodkod.editor.scanners.RelationModelPartitionScanner;
import eu.modelwriter.visualization.Visualization;

public class SynchronizationManager {
  private Visualization instance;
  private Universe kodkodUniverse;
  private eu.modelwriter.visualization.model.Universe visUniverse;
  private final KodkodAnalyzer kodkodAnalyzer;
  private IDocument document;

  public SynchronizationManager(final IDocument document) throws BadLocationException {
    this.kodkodAnalyzer = new KodkodAnalyzer();
    this.document = document;
    this.evaluate(document, null);
    this.subscribeToVis();
  }

  public void evaluate(final IDocument document, final IRegion dirtyRegion) {
    this.document = document;
    try {
      final ITypedRegion changedPartition =
          dirtyRegion == null ? null : document.getPartition(dirtyRegion.getOffset());
      this.parseRequiredPartitions(changedPartition);
      if (this.kodkodUniverse != null) {
        this.runVisualization(this.visUniverse);
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
  }

  private ITypedRegion getPartition(final String partitionContentType) {
    final IDocumentExtension3 extension = (IDocumentExtension3) this.document;
    ITypedRegion[] computePartitioning = null;
    try {
      computePartitioning = extension.computePartitioning(IDocumentExtension3.DEFAULT_PARTITIONING,
          0, this.document.getLength(), false);
    } catch (BadLocationException | BadPartitioningException e) {
      e.printStackTrace();
    }

    for (final ITypedRegion iTypedRegion : computePartitioning) {
      if (iTypedRegion.getType().equals(partitionContentType)) {
        return iTypedRegion;
      }
    }
    return null;
  }

  private String getPartitionString(final ITypedRegion partition) {
    String partitionString = null;
    try {
      partitionString = this.document.get(partition.getOffset(), partition.getLength());
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    return partitionString;
  }

  private void parseRequiredPartitions(final ITypedRegion changedPartition)
      throws BadLocationException {
    PARSE_AREA changedArea = null;
    String changedPartitionString;

    if (changedPartition != null) {
      switch (changedPartition.getType()) {
        case RelationModelPartitionScanner.RELATION_MODEL_OPTION:
          changedArea = KodkodAnalyzer.PARSE_AREA.OPTIONS;
          changedPartitionString = this.getPartitionString(
              this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_OPTION));
          break;
        case RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE:
          changedArea = KodkodAnalyzer.PARSE_AREA.UNIVERSE;
          changedPartitionString = this.getPartitionString(
              this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE));
          changedPartitionString =
              changedPartitionString.substring(changedPartitionString.indexOf("{"));
          this.runParser(changedPartitionString, changedArea);
          break;
        case RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND:
          changedArea = KodkodAnalyzer.PARSE_AREA.RELATION;
          changedPartitionString = this.getPartitionString(
              this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE));
          changedPartitionString =
              changedPartitionString.substring(changedPartitionString.indexOf("{"));
          String relBoundString = this.getPartitionString(
              this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND));
          relBoundString = relBoundString.substring(relBoundString.indexOf("{") + 1,
              relBoundString.lastIndexOf("}"));
          changedPartitionString += relBoundString;
          this.runParser(changedPartitionString, changedArea);
          break;
        case RelationModelPartitionScanner.DEFAULT_CONTENT_TYPE:
          changedArea = KodkodAnalyzer.PARSE_AREA.FORMULAS;
          changedPartitionString = this.document.get();
          this.runParser(changedPartitionString, changedArea);
          break;
        default:
          break;
      }
    } else {
      changedPartitionString = this.document.get();
      changedArea = KodkodAnalyzer.PARSE_AREA.FULL_DOCUMENT;
      this.runParser(changedPartitionString, changedArea);
    }
  }

  private void runParser(final String changedPartitionString, final PARSE_AREA changedArea)
      throws BadLocationException {
    this.kodkodUniverse = this.kodkodAnalyzer.parseKodkod(changedPartitionString, changedArea);
    if (this.kodkodUniverse == null) {
      return;
    }
    this.visUniverse = UniverseTransformer.getInstance().transformKodkod2Vis(this.kodkodUniverse);
  }

  private void runVisualization(final eu.modelwriter.visualization.model.Universe visUniverse) {
    this.instance = Visualization.getInstance(visUniverse, "kodkodUniv");
    final JPanel graph = this.instance.getGraph();
    RelationModelEditor.addGraphToFrame(graph);
  }

  private void subscribeToVis() {
    if (this.instance != null) {
      final VisualizationSubscriber vs = new VisualizationSubscriber(this.document);
      this.instance.getNotifierList().add(vs);
    }
  }
}
