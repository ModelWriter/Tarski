package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.core.alloyinecore.ui.mapping.as2cs.EcoreTranslator;

public class AlloyInEcoreDocumentProvider extends FileDocumentProvider {

  private EcoreTranslator translator;

  public AlloyInEcoreDocumentProvider() {
    translator = new EcoreTranslator();
  }

  @Override
  protected IDocument createDocument(Object element) throws CoreException {
    IDocument document = createEmptyDocument();
    if (document != null) {
      setContent(document, (FileEditorInput) element);
      IDocumentPartitioner partitioner =
          new FastPartitioner(new PartitionScanner(), PartitionScanner.ALL_PARTITIONS);
      partitioner.connect(document);
      document.setDocumentPartitioner(partitioner);
    }
    return document;
  }

  private void setContent(IDocument document, FileEditorInput editorInput) {
    try {
      IFile iFile = editorInput.getFile();
      EObject ecoreRoot =
          EcoreUtilities.getRootObject(editorInput.getFile().getFullPath().toString());
      document.set(translator.translate((EModelElement) ecoreRoot));
      if (document instanceof AlloyInEcoreDocument) {
        ((AlloyInEcoreDocument) document).setEcoreRoot(ecoreRoot);
        ((AlloyInEcoreDocument) document).setFile(iFile);
      }
    } catch (Exception e) {
      e.printStackTrace();
      document.set("");
    }
  }

  @Override
  protected IDocument createEmptyDocument() {
    return new AlloyInEcoreDocument();
  }

  @Override
  protected boolean setDocumentContent(IDocument document, IEditorInput editorInput,
      String encoding) throws CoreException {
    setContent(document, (FileEditorInput) editorInput);
    return true;
  }

  @Override
  protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document,
      boolean overwrite) throws CoreException {
    if (document instanceof AlloyInEcoreDocument) {
      ((AlloyInEcoreDocument) document).saveInEcore(element, overwrite);
    }
  }
}
