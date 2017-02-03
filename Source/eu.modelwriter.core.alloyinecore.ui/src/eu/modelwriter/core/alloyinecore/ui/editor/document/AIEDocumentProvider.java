package eu.modelwriter.core.alloyinecore.ui.editor.document;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.mapping.as2cs.EcoreTranslator;

public class AIEDocumentProvider extends FileDocumentProvider {
  private final EcoreTranslator translator;

  public AIEDocumentProvider() {
    translator = new EcoreTranslator();
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
      final EObject ecoreRoot =
          EcoreUtilities.getRootObject(editorInput.getFile().getFullPath().toString());
      document.set(translator.translate((EModelElement) ecoreRoot));
      if (document instanceof AIEDocument) {
        ((AIEDocument) document).setEcoreRoot(ecoreRoot);
        ((AIEDocument) document).setFile(iFile);
      }
    } catch (final Exception e) {
      e.printStackTrace();
      document.set("");
    }
  }

  @Override
  protected IDocument createEmptyDocument() {
    return new AIEDocument();
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
    if (document instanceof AIEDocument) {
      ((AIEDocument) document).saveInEcore(element, overwrite);
    }
  }
}
