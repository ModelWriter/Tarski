package eu.modelwriter.core.alloyinecore.ui.editor.document;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Document;
import org.eclipse.ui.part.FileEditorInput;

import eu.modelwriter.core.alloyinecore.ui.editor.partition.AIEFastPartitioner;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.AIEPartitionTokenScanner;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.mapping.cs2as.CS2ASMapping;

public class AIEDocument extends Document {
  public static final String EDITOR_ID = "eu.modelwriter.core.alloyinecore.ui.editor";
  private EObject ecoreRoot;
  private IFile iFile;
  private final CS2ASMapping mapping;
  private final AIEFastPartitioner partitioner;

  public AIEDocument() {
    mapping = new CS2ASMapping();
    partitioner =
        new AIEFastPartitioner(new AIEPartitionTokenScanner(), IAIEPartitions.ALL_PARTITIONS);
    partitioner.connect(this);
    this.setDocumentPartitioner(IAIEPartitions.AIE_PARTITIONING, partitioner);
  }

  public void setEcoreRoot(final EObject ecoreRoot) {
    this.ecoreRoot = ecoreRoot;
  }

  /**
   * 
   * @return current ecore object
   */
  public EObject getEcoreRoot() {
    return ecoreRoot;
  }


  /**
   * Saves editor input to current ecore file.
   * 
   * @param overwrite
   * @param element
   * 
   * @return true if succeed.
   */
  public boolean saveInEcore(final Object element, final boolean overwrite) {
    if (overwrite) { // Save as
      if (element instanceof FileEditorInput) {
        mapping.parseAndSave(get(),
            URI.createFileURI(((FileEditorInput) element).getFile().getFullPath().toString()));
      }
    } else { // Save
      mapping.parseAndSave(get(),
          URI.createPlatformResourceURI(iFile.getFullPath().toString(), true));
    }
    return true;
  }

  public void setFile(final IFile iFile) {
    this.iFile = iFile;
  }
}
