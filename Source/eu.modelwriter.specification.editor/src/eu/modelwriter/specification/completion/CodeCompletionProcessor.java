package eu.modelwriter.specification.completion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.parser.CompModule;
import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.specification.scanner.CodeScanner;

public class CodeCompletionProcessor extends MetaModelCompletionProcessor {

  private final char[] activationChars = new char[] {'>', '.', ']', '~', '^', '*', ':', '+'};
  private CompModule module;

  @Override
  public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer,
      final int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
    try {
      final IDocument document = viewer.getDocument();
      // final Character c = document.getChar(offset - 1);
      // final int line = document.getLineOfOffset(offset);
      // final IRegion region = document.getLineInformation(line);
      //
      // if (Character.isWhitespace(c)) {
      // final boolean isMatch =
      // document.get(region.getOffset(), region.getLength()).trim().endsWith("extends");
      // if (isMatch) {
      // for (final String sig : AlloyParserForMetamodel.getSigs()) {
      // proposals.add(new CompletionProposal(sig, offset, sig.length(), sig.length()));
      // }
      // }
      // }

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

        for (int i = 0; i < CodeScanner.keywords.length; i++) {
          if (CodeScanner.keywords[i].startsWith(s)) {
            proposals.add(new CompletionProposal(CodeScanner.keywords[i], temp + 1, s.length(),
                CodeScanner.keywords[i].length()));
          }
        }

        // for (final String sig : AlloyParserForMetamodel.getSigs()) {
        // if (sig.toLowerCase().startsWith(s.toLowerCase())) {
        // proposals.add(new CompletionProposal(sig, temp + 1, s.length(), sig.length()));
        // }
        // }
        //
        // for (final String rel : AlloyParserForMetamodel.getRels()) {
        // if (rel.toLowerCase().startsWith(s.toLowerCase())) {
        // proposals.add(new CompletionProposal(rel, temp + 1, s.length(), rel.length()));
        // }
        // }

      } else {
        // if the last edited char is non-alphabetic then may be user wants the relation list.
        for (int i = 0; i < this.activationChars.length; i++) {
          if (this.activationChars[i] == c) {
            this.module =
                (CompModule) AlloyParserForMetamodel.world.getAllReachableModules().get(0);
            final SafeList<Sig> allSigs = this.module.getAllSigs();
            final ArrayList<String> fieldNames = new ArrayList<String>();
            for (final Sig sig : allSigs) {
              final SafeList<Field> fields = sig.getFields();
              for (final Field field : fields) {
                if (!fieldNames.contains(field.label)) {
                  proposals.add(new CompletionProposal(field.label, temp + 1, s.length(),
                      field.label.length()));
                  fieldNames.add(field.label);
                }
              }
            }
            break;
          }
        }
      }

      // proposals list is still empty, ok then give all keywords like java does.
      if (proposals.isEmpty()) {
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
  public char[] getCompletionProposalAutoActivationCharacters() {
    return this.activationChars;
  }
}
