package eu.modelwriter.core.alloyinecore.ui.editor.instance;

import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import eu.modelwriter.core.alloyinecore.instance.InstanceParser.InstanceContext;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.color.AIEColorManager;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.document.AIEInstanceDocumentProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.AIEInstanceCodeScanner;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.KeywordListener;
import eu.modelwriter.core.alloyinecore.ui.editor.outline.AIEContentOutlinePage;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIEInstanceEditor extends AIEEditor {

  public static final String editorID =
      "eu.modelwriter.core.alloyinecore.ui.editors.AlloyInEcoreInstanceEditor";

  private AIEContentOutlinePage outlinePage;
  private Element<InstanceContext> parsedInstance;

  public AIEInstanceEditor() {
    aIEColorManager = new AIEColorManager();
    AIEInstanceSourceViewerConfiguration configuration = new AIEInstanceSourceViewerConfiguration(
        aIEColorManager, this, IAIEPartitions.AIE_PARTITIONING);
    setSourceViewerConfiguration(configuration);
    AIEInstanceDocumentProvider provider = new AIEInstanceDocumentProvider();
    provider.setKeywordListener(new KeywordListener() {

      @Override
      public void onKeywordsCollected(Set<String> keywords, Set<String> sfKeywords) {
        ((AIEInstanceCodeScanner) configuration.getCodeScanner()).updateRules(keywords, sfKeywords);
      }
    });
    setDocumentProvider(provider);
  }

  public Element<InstanceContext> getParsedInstance() {
    return parsedInstance;
  }

  @Override
  public void dispose() {
    aIEColorManager.dispose();
    super.dispose();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getAdapter(final Class<T> adapter) {
    if (IContentOutlinePage.class.equals(adapter)) {
      if (outlinePage == null) {
        outlinePage = new AIEContentOutlinePage(getDocumentProvider(), this);
        if (parsedInstance != null) {
          outlinePage.refresh(parsedInstance);
        }
      }
      return (T) outlinePage;
    }
    return super.getAdapter(adapter);
  }

  public void setInstance(final Element<InstanceContext> instance, final boolean refreshOutline) {
    parsedInstance = instance;
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        // Update folding positions
        projectionAnnotations.clear();
        calculateFoldingPositions(parsedInstance);
        updateFoldingStructure();
        // Refresh the outline
        if (outlinePage != null && refreshOutline) {
          outlinePage.refresh(parsedInstance);
        }
        handleCursorPositionChanged();
      }
    });
  }

  @Override
  @SuppressWarnings({"rawtypes"})
  public Element findElement(final int line, final int offset) {
    return EditorUtils.findElement(parsedInstance, line, offset);
  }
}
