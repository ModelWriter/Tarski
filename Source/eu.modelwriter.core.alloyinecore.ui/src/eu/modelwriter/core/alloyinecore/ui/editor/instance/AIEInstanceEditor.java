package eu.modelwriter.core.alloyinecore.ui.editor.instance;

import java.util.Set;

import eu.modelwriter.core.alloyinecore.ui.ASTManager;
import eu.modelwriter.core.alloyinecore.ui.Activator;
import eu.modelwriter.core.alloyinecore.ui.editor.AIEEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.document.AIEInstanceDocumentProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.AIEInstanceCodeScanner;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.KeywordListener;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;

public class AIEInstanceEditor extends AIEEditor {

  public static final String editorID =
      "eu.modelwriter.core.alloyinecore.ui.editors.AlloyInEcoreInstanceEditor";

  public AIEInstanceEditor() {
    super();
  }

  @Override
  protected void initEditor() {
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

  @Override
  protected ASTManager getManagerForEditor() {
    return Activator.getDefault().getInstanceManager();
  }
}
