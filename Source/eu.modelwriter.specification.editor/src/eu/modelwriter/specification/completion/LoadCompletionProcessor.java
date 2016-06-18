package eu.modelwriter.specification.completion;

import java.util.ArrayList;
import java.util.List;

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

public class LoadCompletionProcessor extends MetaModelCompletionProcessor {

  private List<IFile> emfFiles;

  private final char[] activationChars = new char[] {'@'};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
    this.emfFiles = new ArrayList<IFile>();
    final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    try {
      this.processContainer(root);
    } catch (final CoreException e) {
      e.printStackTrace();
    }

    final IDocument document = viewer.getDocument();

    Character c = null;
    try {
      c = document.getChar(offset - 1);
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    int temp = offset - 1;
    String s = "";

    if (Character.isAlphabetic(c)) {
      while (Character.isAlphabetic(c) || c == '/' || c == '.') {
        s += c;
        temp--;
        try {
          c = document.getChar(temp);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
      s = new StringBuilder(s).reverse().toString();

      for (final IFile emfFile : this.emfFiles) {
        final String path = emfFile.getFullPath().toString();
        if (path.toUpperCase().startsWith(s.toUpperCase())) {
          proposals.add(new CompletionProposal(path, temp + 1, s.length(), path.length()));
        }
      }
    } else {
      // if the last edited char is non-alphabetic then may be user wants the relation list.
      if (this.activationChars[0] == c) {
        for (final IFile emfFile : this.emfFiles) {
          final String path = emfFile.getFullPath().toString();
          proposals.add(new CompletionProposal(path, temp + 1, s.length(), path.length()));
        }
      }
    }

    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return this.activationChars;
  }

  private void processContainer(final IContainer container) throws CoreException {
    final IResource[] members = container.members();
    for (final IResource member : members) {
      if (member instanceof IContainer) {
        if (member.isAccessible()) {
          this.processContainer((IContainer) member);
        }
      } else if (member instanceof IFile) {
        final IFile file = (IFile) member;
        if (file.getFileExtension().equals("ecore")) {
          this.emfFiles.add((IFile) member);
        }
      }
    }
  }
}
