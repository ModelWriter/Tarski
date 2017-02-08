package eu.modelwriter.core.alloyinecore.ui.editor.instance.document;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.FastPartitioner;

import eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner.KeywordListener;
import eu.modelwriter.core.alloyinecore.ui.editor.partition.IAIEPartitions;
import eu.modelwriter.core.alloyinecore.ui.editor.scanner.AIEPartitionScanner;

public class AIEInstanceDocument extends Document {
  private EObject instanceRoot;
  private IFile iFile;
  private Set<String> sfKeywords = new HashSet<>();
  private Set<String> keywords = new HashSet<>();
  private final FastPartitioner partitioner;

  public AIEInstanceDocument() {
    partitioner = new FastPartitioner(new AIEPartitionScanner(), IAIEPartitions.ALL_PARTITIONS);
    partitioner.connect(this);
    this.setDocumentPartitioner(IAIEPartitions.AIE_PARTITIONING, partitioner);
  }

  public void setInstanceRoot(final EObject instanceRoot, KeywordListener keywordListener) {
    this.instanceRoot = instanceRoot;
    collectKeywords(instanceRoot);
    keywordListener.onKeywordsCollected(keywords, sfKeywords);
  }

  private void collectKeywords(EObject eObject) {
    TreeIterator<EObject> iterator = eObject.eAllContents();
    while (iterator.hasNext()) {
      EObject next = iterator.next();
      keywords.add(next.eClass().getName());
      for (EStructuralFeature sf : next.eClass().getEAllStructuralFeatures()) {
        sfKeywords.add(sf.getName());
      }
      ENamedElement container = (ENamedElement) next.eClass().eContainer();
      if (container != null)
        keywords.add(container.getName());
    }
    keywords.add(eObject.eClass().getName());
    for (EStructuralFeature sf : eObject.eClass().getEAllStructuralFeatures()) {
      sfKeywords.add(sf.getName());
    }
  }

  /**
   * 
   * @return current ecore object
   */
  public EObject getEcoreRoot() {
    return instanceRoot;
  }

  public IFile getiFile() {
    return iFile;
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
    // Not Implemented
    return true;
  }

  public void setFile(final IFile iFile) {
    this.iFile = iFile;
  }
}
