package eu.modelwriter.core.alloyinecore.ui.editor.instance.reconciling;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import eu.modelwriter.core.alloyinecore.structure.instance.Instance;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.AIEInstanceEditor;
import eu.modelwriter.core.alloyinecore.ui.editor.reconciling.AIESyntacticReconcilingStrategy;
import eu.modelwriter.core.alloyinecore.ui.editor.util.EditorUtils;

public class AIEInstanceSyntacticReconcilingStrategy extends AIESyntacticReconcilingStrategy {

  public AIEInstanceSyntacticReconcilingStrategy(final ISourceViewer sourceViewer,
      final ITextEditor editor) {
    super(sourceViewer, editor);
  }

  @Override
  public void reconcile(final IRegion partition) {
    try {
      noErrors = true;
      removeOldAnnotations();
      URI uri = URI.createPlatformResourceURI(iFile.getFullPath().toString(), true);
      Instance parsedInstance =
          EditorUtils.parseInstanceDocument(document, uri, new BaseErrorListener() {
            @Override
            public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol,
                final int line, final int charPositionInLine, final String msg,
                final RecognitionException e) {
              noErrors = false;
              createErrorAnnotation((Token) offendingSymbol, msg);
            }
          });
      // Set module and refresh outline
      ((AIEInstanceEditor) editor).setInstance(parsedInstance, true);
    } catch (final Exception e1) {
      e1.printStackTrace();
    }
  }
}
