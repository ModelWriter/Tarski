package eu.modelwriter.core.alloyinecore.ui.editor.completion;

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

import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;

public class AIECompletionProcessor implements IContentAssistProcessor {

  private final char[] activationChars = new char[] {'c'};

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();

    final IDocument document = viewer.getDocument();

    final AIECompletionUtil completionUtil = new AIECompletionUtil(document, offset);

    List<String> completionWords;
    try {
      completionWords = completionUtil.getProposals();
    } catch (final BadLocationException e1) {
      return new ICompletionProposal[0];
    }

    Character c = null;
    try {
      c = document.getChar(offset - 1);
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    int temp = offset - 1;
    StringBuilder builder = new StringBuilder();

    if (Character.isAlphabetic(c)) {
      while (Character.isAlphabetic(c)) {
        builder.append(c);
        temp--;
        try {
          c = document.getChar(temp);
        } catch (final BadLocationException e) {
        }
      }
      builder = builder.reverse();

      for (final String word : completionWords) {
        if (word.toLowerCase().startsWith(builder.toString().toLowerCase())) {
          proposals.add(new CompletionProposal(word, temp + 1, builder.length(), word.length()));
        }
      }
    } else {
      for (int i = 0; i < activationChars.length; i++) {
        // if (activationChars[i] == c) {
        for (final String word : completionWords) {
          proposals.add(new CompletionProposal(word, temp + 1, builder.length(), word.length()));
        }
        // }
      }
    }

    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return activationChars;
  }

  private final IContextInformation[] NO_CONTEXTS = {};

  @Override
  public IContextInformation[] computeContextInformation(final ITextViewer viewer,
      final int offset) {
    return NO_CONTEXTS;
  }

  @Override
  public char[] getContextInformationAutoActivationCharacters() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getErrorMessage() {
    return "No completions available.";
  }

  @Override
  public IContextInformationValidator getContextInformationValidator() {
    // TODO Auto-generated method stub
    return null;
  }
}
