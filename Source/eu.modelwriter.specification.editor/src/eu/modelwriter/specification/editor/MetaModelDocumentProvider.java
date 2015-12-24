package eu.modelwriter.specification.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/** Document provider is needed for document partitioning.
 *  In our editor, they are just Comment Partition and Default Partition (for codes).
 * @author anil.ozturk
 *
 */
public class MetaModelDocumentProvider extends FileDocumentProvider {
  
  @Override
  protected IDocument createDocument(final Object element) throws CoreException {
    final IDocument document = super.createDocument(element);
    if (document != null) {
      final IDocumentPartitioner partitioner = new FastPartitioner(new MetaModelPartitionScanner(),
          MetaModelPartitionScanner.PARTITION_TYPES);
      partitioner.connect(document);
      document.setDocumentPartitioner(partitioner);
    }
    return document;
  }
}
