package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import eu.modelwriter.core.alloyinecore.ui.model.AlloyInEcoreDocument;

public class AlloyInEcoreDocumentProvider extends FileDocumentProvider {

  private IDocument document;

  @Override
  protected IDocument createDocument(Object element) throws CoreException {
    document = new AlloyInEcoreDocument(element);
    if (document != null) {
      IDocumentPartitioner partitioner =
          new FastPartitioner(new PartitionScanner(), PartitionScanner.ALL_PARTITIONS);
      partitioner.connect(document);
      document.setDocumentPartitioner(partitioner);
    }
    return document;
  }

  public IDocument getDocument() {
    return document;
  }

  @Override
  protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document,
      boolean overwrite) throws CoreException {
    if (document instanceof AlloyInEcoreDocument) {
      ((AlloyInEcoreDocument) document).saveInEcore(element, overwrite);
    }
  }
}
