package eu.modelwriter.traceability.validation.editor.base.document;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

import eu.modelwriter.traceability.validation.editor.base.ValidationPartitionScanner;

public class ValidationDocumentProvider extends FileDocumentProvider {

  @Override
  protected IDocument createDocument(final Object element) throws CoreException {
    final IDocument document = super.createDocument(element);
    if (document != null) {
      final IDocumentPartitioner partitioner = new FastPartitioner(new ValidationPartitionScanner(),
          ValidationPartitionScanner.PARTITION_TYPES);
      partitioner.connect(document);
      document.setDocumentPartitioner(partitioner);
    }
    return document;
  }
}
