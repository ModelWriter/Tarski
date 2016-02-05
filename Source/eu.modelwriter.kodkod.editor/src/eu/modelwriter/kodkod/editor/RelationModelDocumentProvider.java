package eu.modelwriter.kodkod.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/**
 * Document provider is needed for document partitioning. In our editor, they are just Comment
 * Partition and Default Partition (for codes).
 *
 * @author anil.ozturk
 *
 */
public class RelationModelDocumentProvider extends FileDocumentProvider {
  private static IDocument document;

  public static IDocument getDocument() {
    return RelationModelDocumentProvider.document;
  }

  @Override
  protected IDocument createDocument(final Object element) throws CoreException {
    final IDocument document = super.createDocument(element);
    if (document != null) {
      final IDocumentPartitioner partitioner = new FastPartitioner(
          new RelationModelPartitionScanner(), RelationModelPartitionScanner.PARTITION_TYPES);
      partitioner.connect(document);
      document.setDocumentPartitioner(partitioner);
    }
    RelationModelDocumentProvider.document = document;
    return document;
  }
}
