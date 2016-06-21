package eu.modelwriter.specification.editor.completion;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public abstract class MetaModelCompletionProcessor implements IContentAssistProcessor {

  private final IContextInformation[] NO_CONTEXTS = {};

  @Override
  public IContextInformation[] computeContextInformation(final ITextViewer viewer,
      final int offset) {
    return this.NO_CONTEXTS;
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
