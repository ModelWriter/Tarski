package eu.modelwriter.specification.editor.completion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.specification.editor.scanner.SigScanner;

public class SigCompletionProcessor extends MetaModelCompletionProcessor {

  final TraceCompletionProcessor traceCP = new TraceCompletionProcessor();

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();
    try {
      final IDocument document = viewer.getDocument();
      final IRegion lineInfo = document.getLineInformationOfOffset(offset);
      final String lineString = document.get(lineInfo.getOffset(), lineInfo.getLength());
      if (lineString.toLowerCase().contains("-- trace@")
          || lineString.toLowerCase().contains("--trace@")) {
        return traceCP.computeCompletionProposals(viewer, offset);
      }
      // we try to find the prefix of keyword which is edited in text.
      // we look from last to first offset, if the 'c' is non-alphabetic then stop.
      // Ex: if user write "{on" we take "on" then search the keywords which are acceptable for this
      // prefix.
      Character c = document.getChar(offset - 1);
      int temp = offset - 1;
      StringBuilder builder = new StringBuilder();

      if (Character.isAlphabetic(c)) {
        while (Character.isAlphabetic(c)) {
          builder.append(c);
          temp--;
          c = document.getChar(temp);
        }
        builder = builder.reverse();

        for (int i = 0; i < SigScanner.keywords.length; i++) {
          if (SigScanner.keywords[i].startsWith(builder.toString())) {
            proposals.add(new CompletionProposal(SigScanner.keywords[i], temp + 1, builder.length(),
                SigScanner.keywords[i].length()));
          }
        }

        for (final String sig : AlloyParserForMetamodel.getSigs()) {
          if (sig.toLowerCase().startsWith(builder.toString().toLowerCase())) {
            proposals.add(new CompletionProposal(sig, temp + 1, builder.length(), sig.length()));
          }
        }

      } else {
        for (int i = 0; i < SigScanner.keywords.length; i++) {
          proposals.add(new CompletionProposal(SigScanner.keywords[i], temp + 1, builder.length(),
              SigScanner.keywords[i].length()));
        }

        for (final String sig : AlloyParserForMetamodel.getSigs()) {
          proposals.add(new CompletionProposal(sig, temp + 1, builder.length(), sig.length()));
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
    return null;
  }
}
