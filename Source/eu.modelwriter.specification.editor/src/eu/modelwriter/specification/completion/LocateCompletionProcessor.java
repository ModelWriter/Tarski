package eu.modelwriter.specification.completion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class LocateCompletionProcessor extends MetaModelCompletionProcessor {

  private final char[] activationChars = new char[] {'@'};

  private final String[] completionWords = new String[] {"ReqIF", "EMF", "Text", "Java"};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

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
      while (Character.isAlphabetic(c)) {
        s += c;
        temp--;
        try {
          c = document.getChar(temp);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
      s = new StringBuilder(s).reverse().toString();

      for (final String word : this.completionWords) {
        if (word.toUpperCase().startsWith(s.toUpperCase())) {
          proposals.add(new CompletionProposal(word, temp + 1, s.length(), word.length()));
        }
      }
    } else {
      // if the last edited char is non-alphabetic then may be user wants the relation list.
      for (int i = 0; i < this.activationChars.length; i++) {
        if (this.activationChars[i] == c) {
          for (final String word : this.completionWords) {
            proposals.add(new CompletionProposal(word, temp + 1, s.length(), word.length()));
          }
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
}
