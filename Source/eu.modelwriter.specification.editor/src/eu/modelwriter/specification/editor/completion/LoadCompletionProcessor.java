package eu.modelwriter.specification.editor.completion;

import java.util.ArrayList;
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
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

public class LoadCompletionProcessor extends MetaModelCompletionProcessor {

  private final Map<String, IFile> xmiFiles = new HashMap<>();
  private final Map<String, IFile> emfFiles = new HashMap<>();
  private final char[] activationChars = new char[] {'@'};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();

    final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
      xmiFiles.clear();
      emfFiles.clear();
      this.findFiles(root);
    } catch (final CoreException e) {
      e.printStackTrace();
    }

    final IDocument document = viewer.getDocument();
    try {
      Character c = null;
      c = document.getChar(offset - 1);
      int temp = offset - 1;
      StringBuilder builder = new StringBuilder();

      if (Character.isAlphabetic(c)) {
        while (Character.isAlphabetic(c) || c == '/' || c == '.') {
          builder.append(c);
          temp--;
          c = document.getChar(temp);
        }
        builder = builder.reverse();
        addProposals(proposals, document, builder, offset, temp, true);
      } else {
        addProposals(proposals, document, builder, offset, temp, false);
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  private void addProposals(List<ICompletionProposal> proposals, IDocument document,
      StringBuilder builder, int offset, int temp, boolean hasPrefix) {
    try {
      if (document.getPartition(temp).getType()
          .equals(MetaModelPartitionScanner.META_MODEL_LOADMODEL)) {
        for (final String alias : this.emfFiles.keySet()) {
          final String path = this.emfFiles.get(alias).getFullPath().toString();
          String proposal = "";
          if (hasPrefix && path.toLowerCase().startsWith(builder.toString().toLowerCase())) {
            proposal = path + " as " + alias;
          } else if (!hasPrefix) {
            proposal = path + " as " + alias;
          }
          if (!proposal.isEmpty())
            proposals.add(
                new CompletionProposal(proposal, temp + 1, builder.length(), proposal.length()));
        }

      } else if (document.getPartition(temp).getType()
          .equals(MetaModelPartitionScanner.META_MODEL_LOADINSTANCE)) {
        for (final String alias : this.xmiFiles.keySet()) {
          final String path = this.xmiFiles.get(alias).getFullPath().toString();
          String proposal = "";
          if (hasPrefix && path.toLowerCase().startsWith(builder.toString().toLowerCase())) {
            proposal = path + " as " + alias;
          } else if (!hasPrefix) {
            proposal = path + " as " + alias;
          }
          if (!proposal.isEmpty())
            proposals.add(
                new CompletionProposal(proposal, temp + 1, builder.length(), proposal.length()));
        }
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    }
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return this.activationChars;
  }

  private void findFiles(final IContainer container) throws CoreException {
    final IResource[] members = container.members();
    for (final IResource member : members) {
      if (member instanceof IContainer) {
        if (member.isAccessible()) {
          this.findFiles((IContainer) member);
        }
      } else if (member instanceof IFile) {
        final IFile file = (IFile) member;
        if (file.getFileExtension().equals("xmi")) {
          final String name = file.getName().replace(".xmi", "");
          this.xmiFiles.put(name, file);
        } else if (file.getFileExtension().equals("ecore")) {
          final String name = file.getName().replace(".ecore", "");
          this.emfFiles.put(name, file);
        }
      }
    }
  }
}
