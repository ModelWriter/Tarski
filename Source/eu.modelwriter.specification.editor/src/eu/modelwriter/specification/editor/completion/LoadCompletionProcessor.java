package eu.modelwriter.specification.editor.completion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

public class LoadCompletionProcessor extends MetaModelCompletionProcessor {

  private final Map<String, IFile> allXMIFiles = new HashMap<>();
  private final Map<String, IFile> allEcoreFiles = new HashMap<>();
  private final char activationChar = '@';
  private final char[] activationChars = new char[] {activationChar};

  public LoadCompletionProcessor() {
    final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
      allXMIFiles.clear();
      allEcoreFiles.clear();
      findAllEMFFiles(root);
      findAllXMIFiles(root);
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();
    final IDocument document = viewer.getDocument();
    try {
      IRegion lineInfo = document.getLineInformationOfOffset(offset);
      String line = document.get(lineInfo.getOffset(), lineInfo.getLength());

      int activationIndex = line.indexOf(activationChar);
      if (activationIndex != -1) {
        String prefix = line.substring(line.indexOf("@") + 1);
        String type = document.getPartition(offset - 1).getType();
        int replacementOffset = offset - prefix.length();
        addProposals(proposals, prefix, replacementOffset, type);
      }
    } catch (BadLocationException e1) {
      e1.printStackTrace();
    }

    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  private void addProposals(List<ICompletionProposal> proposals, String prefix,
      int replacementOffset, String type) {

    Collection<IFile> files = null;
    if (MetaModelPartitionScanner.META_MODEL_LOADMODEL.equals(type)) {
      files = allEcoreFiles.values();
    } else if (MetaModelPartitionScanner.META_MODEL_LOADINSTANCE.equals(type)) {
      files = allXMIFiles.values();
    }

    if (files == null)
      return;

    for (IFile iFile : files) {
      String path = iFile.getFullPath().toOSString();
      if (path.toLowerCase().startsWith(prefix)
          || iFile.getName().toLowerCase().startsWith(prefix)) {
        proposals.add(new CompletionProposal(path, replacementOffset, prefix.length(),
            path.length(), null, iFile.getName() + " - " + path, null, null));
      }
    }
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return activationChars;
  }

  private void findAllEMFFiles(final IContainer container) throws CoreException {
    final IResource[] members = container.members();
    for (final IResource member : members) {
      if (member instanceof IContainer) {
        if (member.isAccessible()) {
          findAllEMFFiles((IContainer) member);
        }
      } else if (member instanceof IFile) {
        final IFile file = (IFile) member;
        if (file.getFileExtension().equals("ecore")) {
          allEcoreFiles.put(file.getName(), file);
        }
      }
    }
  }

  private void findAllXMIFiles(final IContainer container) throws CoreException {
    final IResource[] members = container.members();
    for (final IResource member : members) {
      if (member instanceof IContainer) {
        if (member.isAccessible()) {
          findAllXMIFiles((IContainer) member);
        }
      } else if (member instanceof IFile) {
        final IFile file = (IFile) member;
        allXMIFiles.put(file.getName(), file);
        // this freezes eclipse
        // try {
        // EObject rootObject = EcoreUtilities.getRootObject(file.getFullPath().toString());
        // if (rootObject != null) {
        // final String nsURI = rootObject.eClass().getEPackage().getNsURI();
        //
        // }
        // } catch (IOException e) {
        // // e.printStackTrace();
        // }
      }
    }
  }
}