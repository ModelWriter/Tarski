package eu.modelwriter.kodkod.editor;

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
	// private final char[] activationChars = new char[] { '[', '(' };

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
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

				for (int i = 0; i < FormulasScanner.formulasKeywords.length; i++) {
					if (FormulasScanner.formulasKeywords[i].startsWith(s)) {
						proposals.add(new CompletionProposal(FormulasScanner.formulasKeywords[i], temp + 1, s.length(),
								FormulasScanner.formulasKeywords[i].length()));
					}
				}
			} else if (c == '(') {
				document.replace(temp, 1, "()");
			} else if (c == '[') {
				document.replace(temp, 1, "[]");
			}

			if (proposals.isEmpty() && s == "") {
				for (int i = 0; i < FormulasScanner.formulasKeywords.length; i++) {
					proposals.add(new CompletionProposal(FormulasScanner.formulasKeywords[i], temp + 1, s.length(),
							FormulasScanner.formulasKeywords[i].length()));
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
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return this.NO_CONTEXTS;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		// return this.activationChars;
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	@Override
	public String getErrorMessage() {
		return "No completions available.";
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
}
