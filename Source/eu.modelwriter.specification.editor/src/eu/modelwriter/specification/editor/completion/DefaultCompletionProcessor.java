package eu.modelwriter.specification.editor.completion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.specification.editor.scanner.DefaultScanner;

public class DefaultCompletionProcessor extends MetaModelCompletionProcessor {

  private final char[] activationChars = new char[] {'>', '.', ']', '~', '^', '*', ':', '+'};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();
    try {
      final IDocument document = viewer.getDocument();

      // we try to find the prefix of keyword which is edited in text.
      // we look from last to first offset, if the 'c' is non-alphabetic then stop.
      // Ex: if user write "{on" we take "on" then search the keywords which are acceptable for this
      // prefix.
      Character c = document.getChar(offset - 1);
      int temp = offset - 1;
      String s = "";

      if (Character.isAlphabetic(c)) {
        while (Character.isAlphabetic(c)) {
          s += c;
          temp--;
          c = document.getChar(temp);
        }
        s = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < DefaultScanner.keywords.length; i++) {
          if (DefaultScanner.keywords[i].startsWith(s)) {
            proposals.add(new CompletionProposal(DefaultScanner.keywords[i], temp + 1, s.length(),
                DefaultScanner.keywords[i].length()));
          }
        }
      } else {
        // if the last edited char is non-alphabetic then may be user wants the relation list.
        for (int i = 0; i < this.activationChars.length; i++) {
          if (this.activationChars[i] == c) {
            for (final String rel : AlloyParserForMetamodel.getRels()) {
              proposals.add(new CompletionProposal(rel, temp + 1, s.length(), rel.length()));
            }
            break;
          }
        }
      }

      // proposals list is still empty, ok then give all keywords like java does.
      if (proposals.isEmpty()) {
        for (int i = 0; i < DefaultScanner.keywords.length; i++) {
          proposals.add(new CompletionProposal(DefaultScanner.keywords[i], temp + 1, s.length(),
              DefaultScanner.keywords[i].length()));
        }
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
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
