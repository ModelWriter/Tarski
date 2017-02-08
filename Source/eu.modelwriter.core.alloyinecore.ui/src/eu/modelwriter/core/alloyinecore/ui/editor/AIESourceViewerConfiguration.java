package eu.modelwriter.core.alloyinecore.ui.editor;

import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.URLHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.Reconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.ui.editor.autoedit.AIEAutoEditStrategy;
import eu.modelwriter.core.alloyinecore.ui.editor.color.IColorManager;
import eu.modelwriter.core.alloyinecore.ui.editor.hyperlink.AIEHyperlinkDetector;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.reconciling.AIESyntacticReconcilingStrategy;
import eu.modelwriter.core.alloyinecore.ui.editor.scanner.AIECodeScanner;

public class AIESourceViewerConfiguration extends TextSourceViewerConfiguration {
  private final ITextEditor fTextEditor;
  private final IColorManager fColorManager;
  private final String fDocumentPartitioning;
  private AIECodeScanner fCodeScanner;

  /**
   * Creates a new AlloyInEcore source viewer configuration for viewers in the given editor using
   * the given the color manager and the specified document partitioning.
   *
   * @param colorManager the color manager
   * @param editor the editor in which the configured viewer(s) will reside, or <code>null</code> if
   *        none
   * @param partitioning the document partitioning for this configuration, or <code>null</code> for
   *        the default partitioning
   */
  public AIESourceViewerConfiguration(final IColorManager colorManager, final ITextEditor editor,
      final String partitioning) {
    fColorManager = colorManager;
    fTextEditor = editor;
    fDocumentPartitioning = partitioning;
    initializeScanners();
  }

  /**
   * Initializes the scanners.
   */
  protected void initializeScanners() {
    fCodeScanner = new AIECodeScanner(getColorManager());
  }

  /**
   * Returns the color manager for this configuration.
   *
   * @return the color manager
   */
  protected IColorManager getColorManager() {
    return fColorManager;
  }

  /**
   * Returns the editor in which the configured viewer(s) will reside.
   *
   * @return the enclosing editor
   */
  protected ITextEditor getEditor() {
    return fTextEditor;
  }

  @Override
  public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
    return new IHyperlinkDetector[] {
        new AIEHyperlinkDetector(sourceViewer, (AIEEditor) fTextEditor),
        new URLHyperlinkDetector()};
  }

  /*
   * @see SourceViewerConfiguration#getPresentationReconciler(ISourceViewer)
   */
  @Override
  public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {

    final PresentationReconciler reconciler = new PresentationReconciler();
    reconciler.setDocumentPartitioning(IAIEPartitions.AIE_PARTITIONING);

    for (final String partition : IAIEPartitions.ALL_PARTITIONS) {
      final DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getCodeScanner());
      reconciler.setDamager(dr, partition);
      reconciler.setRepairer(dr, partition);
    }

    return reconciler;
  }

  /**
   * Returns the AlloyInEcore source code scanner for this configuration.
   *
   * @return the AlloyInEcore source code scanner
   */
  protected AIECodeScanner getCodeScanner() {
    return fCodeScanner;
  }

  /*
   * @see SourceViewerConfiguration#getDefaultPrefixes(ISourceViewer, String)
   * 
   * @since 2.0
   */
  @Override
  public String[] getDefaultPrefixes(final ISourceViewer sourceViewer, final String contentType) {
    return new String[] {"//", ""};
  }

  /*
   * @see SourceViewerConfiguration#getConfiguredContentTypes(ISourceViewer)
   */
  @Override
  public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
    return IAIEPartitions.ALL_PARTITIONS;
  }

  /*
   * @see
   * org.eclipse.jface.text.source.SourceViewerConfiguration#getConfiguredDocumentPartitioning(org.
   * eclipse.jface.text.source.ISourceViewer)
   */
  @Override
  public String getConfiguredDocumentPartitioning(final ISourceViewer sourceViewer) {
    if (fDocumentPartitioning != null) {
      return fDocumentPartitioning;
    }
    return super.getConfiguredDocumentPartitioning(sourceViewer);
  }

  /*
   * @see
   * org.eclipse.jface.text.source.SourceViewerConfiguration#getHyperlinkDetectorTargets(org.eclipse
   * .jface.text.source.ISourceViewer)
   */
  @Override
  protected Map<String, IAdaptable> getHyperlinkDetectorTargets(final ISourceViewer sourceViewer) {
    final Map<String, IAdaptable> targets = super.getHyperlinkDetectorTargets(sourceViewer);
    targets.put(AIEEditor.editorID, fTextEditor);
    return targets;
  }

  @Override
  public ITextHover getTextHover(final ISourceViewer sourceViewer, final String contentType) {
    return new DefaultTextHover(sourceViewer) {
      @Override
      protected boolean isIncluded(final Annotation annotation) {
        return AIEEditor.PARSER_ERROR_ANNOTATION_TYPE.equals(annotation.getType());
      }
    };
  }

  @Override
  public IAnnotationHover getOverviewRulerAnnotationHover(final ISourceViewer sourceViewer) {
    return new DefaultAnnotationHover();
  }

  @Override
  public IAnnotationHover getAnnotationHover(final ISourceViewer sourceViewer) {
    return new DefaultAnnotationHover();
  }

  /*
   * @see SourceViewerConfiguration#getReconciler(ISourceViewer)
   */
  @Override
  public IReconciler getReconciler(final ISourceViewer sourceViewer) {
    final ITextEditor editor = getEditor();
    if (editor != null && editor.isEditable()) {
      final Reconciler reconciler = new Reconciler();
      final AIESyntacticReconcilingStrategy strategy =
          new AIESyntacticReconcilingStrategy(sourceViewer, editor);
      for (final String partition : IAIEPartitions.ALL_PARTITIONS) {
        reconciler.setReconcilingStrategy(strategy, partition);
      }
      reconciler.setDocumentPartitioning(IAIEPartitions.AIE_PARTITIONING);
      reconciler.setDelay(500);
      reconciler.setProgressMonitor(new NullProgressMonitor());
      return reconciler;
    }
    return null;
  }

  /*
   * @see /
   * org.eclipse.jface.text.source.SourceViewerConfiguration#getAutoEditStrategies(org.eclipse.
   * jface.text.source.ISourceViewer, / java.lang.String)
   */
  @Override
  public IAutoEditStrategy[] getAutoEditStrategies(final ISourceViewer sourceViewer,
      final String contentType) {
    return new IAutoEditStrategy[] {new AIEAutoEditStrategy()};
  }
}
