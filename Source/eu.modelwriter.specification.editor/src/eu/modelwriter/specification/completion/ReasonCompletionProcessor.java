package eu.modelwriter.specification.completion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;

public class ReasonCompletionProcessor extends MetaModelCompletionProcessor {

  private final char[] activationChars = new char[] {'@'};

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

      for (final String relation : AlloyParserForMetamodel.getRels()) {
        if (relation.startsWith(s)) {
          proposals.add(new CompletionProposal(relation, temp + 1, s.length(), relation.length()));
        }
      }
    } else {
      // if the last edited char is non-alphabetic then may be user wants the relation list.
      for (int i = 0; i < this.activationChars.length; i++) {
        if (this.activationChars[i] == c) {
          for (final String relation : AlloyParserForMetamodel.getRels()) {
            proposals
                .add(new CompletionProposal(relation, temp + 1, s.length(), relation.length()));
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
