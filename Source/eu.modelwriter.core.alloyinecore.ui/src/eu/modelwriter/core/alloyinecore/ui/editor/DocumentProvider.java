package eu.modelwriter.core.alloyinecore.ui.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import eu.modelwriter.core.alloyinecore.ui.model.AlloyInEcoreDocument;

public class DocumentProvider extends FileDocumentProvider {

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
}
