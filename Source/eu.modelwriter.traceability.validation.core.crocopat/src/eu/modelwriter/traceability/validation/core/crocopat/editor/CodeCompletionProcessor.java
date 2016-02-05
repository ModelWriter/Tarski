package eu.modelwriter.traceability.validation.core.crocopat.editor;

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

public class CodeCompletionProcessor implements IContentAssistProcessor {

  private final IContextInformation[] NO_CONTEXTS = {};
  private final char[] activationChars = new char[] {'(', '{'};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
    try {
      final IDocument document = viewer.getDocument();
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

        for (int i = 0; i < CodeScanner.keywords.length; i++) {
          if (CodeScanner.keywords[i].startsWith(s)) {
            proposals.add(new CompletionProposal(CodeScanner.keywords[i], temp + 1, s.length(),
                CodeScanner.keywords[i].length()));
          }
        }
      } else if (c == '(') {
        document.replace(temp, 1, "()");
      } else if (c == '{') {
        document.replace(temp, 1, "{\n\n}");
      }

      if (proposals.isEmpty() && s == "") {
        for (int i = 0; i < CodeScanner.keywords.length; i++) {
          proposals.add(new CompletionProposal(CodeScanner.keywords[i], temp + 1, s.length(),
              CodeScanner.keywords[i].length()));
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
    return this.activationChars;
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
