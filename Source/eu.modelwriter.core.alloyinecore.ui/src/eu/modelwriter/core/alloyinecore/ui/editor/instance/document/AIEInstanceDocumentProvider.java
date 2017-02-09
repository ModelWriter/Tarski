package eu.modelwriter.core.alloyinecore.ui.editor.instance.document;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.core.alloyinecore.structure.base.Repository;
import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.KeywordListener;
import eu.modelwriter.core.alloyinecore.ui.mapping.as2cs.EcoreInstanceTranslator;

public class AIEInstanceDocumentProvider extends FileDocumentProvider {
  private final EcoreInstanceTranslator translator;
  private Repository repository;
  private KeywordListener keywordListener;

  public AIEInstanceDocumentProvider() {
    translator = new EcoreInstanceTranslator();
    repository = new Repository();
  }

  public void setKeywordListener(KeywordListener keywordListener) {
    this.keywordListener = keywordListener;
  }

  @Override
  protected IDocument createDocument(final Object element) throws CoreException {
    final IDocument document = createEmptyDocument();
    if (document != null) {
      setContent(document, (FileEditorInput) element);
    }
    return document;
  }

  private void setContent(final IDocument document, final FileEditorInput editorInput) {
    try {
      final IFile iFile = editorInput.getFile();
      Resource resource = repository.loadResource(editorInput.getFile().getFullPath().toString());
      if (resource != null && !resource.getContents().isEmpty()) {
        final EObject instanceRoot = resource.getContents().get(0);
        document.set(translator.translate(instanceRoot));
        if (document instanceof AIEInstanceDocument) {
          ((AIEInstanceDocument) document).setInstanceRoot(instanceRoot, keywordListener);
          ((AIEInstanceDocument) document).setFile(iFile);
        }
      } else
        throw new Exception("Resource is null or empty. " + resource.getErrors());
    } catch (final Exception e) {
      e.printStackTrace();
      document.set("");
    }
  }

  @Override
  protected IDocument createEmptyDocument() {
    return new AIEInstanceDocument();
  }

  @Override
  protected boolean setDocumentContent(final IDocument document, final IEditorInput editorInput,
      final String encoding) throws CoreException {
    setContent(document, (FileEditorInput) editorInput);
    return true;
  }

  @Override
  protected void doSaveDocument(final IProgressMonitor monitor, final Object element,
      final IDocument document, final boolean overwrite) throws CoreException {
    // Not Implemented
  }
}
