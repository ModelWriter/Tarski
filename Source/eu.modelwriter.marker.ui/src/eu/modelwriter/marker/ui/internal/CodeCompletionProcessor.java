package eu.modelwriter.marker.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class CodeCompletionProcessor implements IContentAssistProcessor {

  private final IContextInformation[] NO_CONTEXTS = {};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
    try {
      final IDocument document = viewer.getDocument();
      final IRegion region = document.getLineInformationOfOffset(offset);
      final int start = region.getOffset();
      final String prefix = document.get(start, offset - start);
      final int spaceCharOffset = prefix.lastIndexOf(" ") + 1;
      for (int i = 0; i < CodeScanner.keywords.length; i++) {
        if (CodeScanner.keywords[i]
            .startsWith(prefix.substring(prefix.lastIndexOf(" ") + 1, prefix.length()))) {
          proposals.add(new CompletionProposal(CodeScanner.keywords[i], start + spaceCharOffset,
              offset - (start + spaceCharOffset), CodeScanner.keywords[i].length()));
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
