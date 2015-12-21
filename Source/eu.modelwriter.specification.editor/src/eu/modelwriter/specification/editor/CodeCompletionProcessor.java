package eu.modelwriter.specification.editor;

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

import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.parser.CompModule;
import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;

public class CodeCompletionProcessor implements IContentAssistProcessor {

  private final IContextInformation[] NO_CONTEXTS = {};
  private final char[] activationChars = new char[] {'>', '.', ']', '~', '^', '*', ':', '+'};
  private CompModule module;
  
  @Override
  public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
    try {
      final IDocument document = viewer.getDocument();

      // we try to find the prefix of keyword which is edited in text.
      // we look from last to first offset, if the 'c' is non-alphabetic then stop.
      // Ex: if user write "{on" we take "on" then search the keywords which are acceptable for this prefix.
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
  public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
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
  public String getErrorMessage() {
    return "No completions available.";
  }

  @Override
  public IContextInformationValidator getContextInformationValidator() {
    return null;
  }
}
