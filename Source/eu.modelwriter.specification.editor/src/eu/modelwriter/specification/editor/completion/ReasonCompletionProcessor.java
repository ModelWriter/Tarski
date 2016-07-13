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
import eu.modelwriter.configuration.internal.AlloyUtilities;

public class ReasonCompletionProcessor extends MetaModelCompletionProcessor {

  private final char activateSigChar = '@';

  private final char activateRelChar = '.';

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();

    final IDocument document = viewer.getDocument();

    Character c = null;
    try {
      c = document.getChar(offset - 1);
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    int temp = offset - 1;
    StringBuilder builder = new StringBuilder();

    if (Character.isAlphabetic(c)) {
      while (c != this.activateSigChar) {
        builder.append(c);
        temp--;
        try {
          c = document.getChar(temp);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
      builder = builder.reverse();

      if (builder.indexOf(String.valueOf(this.activateRelChar)) != -1) {
        final String sigName =
            builder.substring(0, builder.indexOf(String.valueOf(this.activateRelChar)));
        final String prefix =
            builder.substring(builder.indexOf(String.valueOf(this.activateRelChar)) + 1);

        final ArrayList<String> suitableRels = AlloyUtilities.getRelationTypesForFirstSide(sigName);
        if (suitableRels == null) {
          return null;
        }

        for (final String rel : suitableRels) {
          if (rel.toLowerCase().startsWith(prefix.toLowerCase())) {
            proposals.add(new CompletionProposal(rel, temp + sigName.length() + 2, prefix.length(),
                rel.length()));
          }
        }
      } else {
        for (final String sig : AlloyParserForMetamodel.getSigs()) {
          if (sig.toLowerCase().startsWith(builder.toString().toLowerCase())) {
            proposals.add(new CompletionProposal(sig, temp + 1, builder.length(), sig.length()));
          }
        }
      }
    } else {
      if (c == this.activateSigChar) {
        for (final String sig : AlloyParserForMetamodel.getSigs()) {
          proposals.add(new CompletionProposal(sig, temp + 1, builder.length(), sig.length()));
        }
      } else if (c == this.activateRelChar) {
        try {
          final IRegion lineRegion = document.getLineInformationOfOffset(offset);
          final String line = document.get(lineRegion.getOffset(), lineRegion.getLength());
          final String sigName =
              line.substring(line.indexOf(this.activateSigChar) + 1, line.length() - 1);
          final ArrayList<String> suitableRels =
              AlloyUtilities.getRelationTypesForFirstSide(sigName);
          if (suitableRels == null) {
            return null;
          }
          for (final String rel : suitableRels) {
            proposals.add(new CompletionProposal(rel, temp + 1, builder.length(), rel.length()));
          }
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    }

    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return new char[] {this.activateSigChar, this.activateRelChar};
  }
}
