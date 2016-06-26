package eu.modelwriter.traceability.validation.editor.base.completion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import eu.modelwriter.traceability.validation.editor.base.ValidationEditor;
import eu.modelwriter.traceability.validation.editor.base.scanners.SentencesScanner;

public class DefaultCompletionProcessor implements IContentAssistProcessor {

  private final IContextInformation[] NO_CONTEXTS = {};

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

        for (int i = 0; i < SentencesScanner.keywords.length; i++) {
          if (SentencesScanner.keywords[i].startsWith(s)) {
            proposals.add(new CompletionProposal(SentencesScanner.keywords[i], temp + 1, s.length(),
                SentencesScanner.keywords[i].length()));
          }
        }

        for (final String relationName : ValidationEditor.getRelationNames()) {
          if (relationName.toLowerCase().startsWith(s.toLowerCase())) {
            proposals.add(
                new CompletionProposal(relationName, temp + 1, s.length(), relationName.length()));
          }
        }

        for (final String atomName : ValidationEditor.getAtomNames()) {
          if (atomName.toLowerCase().startsWith(s.toLowerCase())) {
            proposals
                .add(new CompletionProposal(atomName, temp + 1, s.length(), atomName.length()));
          }
        }
      }

      // proposals list is still empty, ok then give all keywords like java does.
      if (proposals.isEmpty()) {
        for (int i = 0; i < SentencesScanner.keywords.length; i++) {
          proposals.add(new CompletionProposal(SentencesScanner.keywords[i], temp + 1, s.length(),
              SentencesScanner.keywords[i].length()));
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
  public IContextInformation[] computeContextInformation(final ITextViewer viewer,
      final int offset) {
    return this.NO_CONTEXTS;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return null;
  }

  @Override
  public char[] getContextInformationAutoActivationCharacters() {
    return null;
  }

  @Override
  public IContextInformationValidator getContextInformationValidator() {
    return null;
  }

  @Override
  public String getErrorMessage() {
    return "No completions available.";
  }
}
