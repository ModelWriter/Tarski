package eu.modelwriter.specification.editor.completion;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.configuration.alloy.trace.LoadItem;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.specification.editor.EditorUtilities;

public class TraceCompletionProcessor extends MetaModelCompletionProcessor {

  private final char activateTraceChar = '@';
  private final char activateRouteChar = '.';
  private final char[] activationChars = new char[] {activateTraceChar, activateRouteChar};

  private final Map<String, EPackage> aliasToEMF = new HashMap<String, EPackage>();

  @Override
  public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
    final List<ICompletionProposal> proposals = new ArrayList<>();
    final IDocument document = viewer.getDocument();
    aliasToEMF.clear();

    try {
      List<LoadItem> loads = EditorUtilities.getLoadsFromDoc(document);
      for (LoadItem loadItem : loads) {
        aliasToEMF.put(loadItem.getAlias(), (EPackage) loadItem.getModelRoot());
      }
    } catch (IOException | BadLocationException | IndexOutOfBoundsException | TraceException e1) {
      return null;
    }

    try {
      if (!aliasToEMF.isEmpty()) {
        Character c = null;
        c = document.getChar(offset - 1);
        int temp = offset - 1;
        StringBuilder builder = new StringBuilder();
        if (Character.isAlphabetic(c) || Character.isDigit(c) || c == '.') {
          while (Character.isAlphabetic(c) || Character.isDigit(c) || c == '.') {
            builder.append(c);
            temp--;
            c = document.getChar(temp);
          }
          builder = builder.reverse();
          final boolean newRoute = builder.charAt(builder.length() - 1) == activateRouteChar;
          final String[] split = builder.toString().split("\\.");
          final String prefix = newRoute ? "" : split[split.length - 1];
          if (split.length == 1 && !newRoute) {
            for (String alias : aliasToEMF.keySet()) {
              if (alias.toLowerCase().startsWith(builder.toString().toLowerCase()))
                proposals
                    .add(new CompletionProposal(alias, temp + 1, builder.length(), alias.length()));
            }
          } else if (split.length >= 1) {
            for (String name : getCompletionStrings(split, prefix, newRoute)) {
              final int startOffset = temp + 1 + (builder.length() - (prefix.length()));
              proposals
                  .add(new CompletionProposal(name, startOffset, prefix.length(), name.length()));
            }
          }
        } else {
          if (activateTraceChar == c) {
            for (String alias : aliasToEMF.keySet()) {
              proposals
                  .add(new CompletionProposal(alias, temp + 1, builder.length(), alias.length()));
            }
          }
        }
      } else {
        // No proposals
      }
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    final ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
    proposals.toArray(result);
    return result;
  }

  private List<String> getCompletionStrings(String[] emfRoutes, String prefix, boolean newRoute) {
    final List<String> proposals = new ArrayList<String>();
    final String alias = emfRoutes[0];
    final int lenght = emfRoutes.length + (newRoute ? 0 : -1);
    EObject eContainer = aliasToEMF.get(alias);

    if (eContainer == null)
      return proposals;

    for (int x = 1; x < lenght; x++) {
      String currentRoute = emfRoutes[x];
      for (EObject eObject : eContainer.eContents()) {
        if (eObject instanceof ENamedElement
            && ((ENamedElement) eObject).getName().equals(currentRoute)) {
          eContainer = eObject;
          break;
        }
      }
    }
    for (EObject eObject : eContainer.eContents()) {
      if (eObject instanceof ENamedElement) {
        if (newRoute) {
          proposals.add(((ENamedElement) eObject).getName());
        } else {
          if (((ENamedElement) eObject).getName().toLowerCase().startsWith(prefix.toLowerCase())) {
            proposals.add(((ENamedElement) eObject).getName());
          }
        }
      }
    }
    return proposals;
  }

  @Override
  public char[] getCompletionProposalAutoActivationCharacters() {
    return activationChars;
  }

  @Override
  public String getErrorMessage() {
    return "No completions available.";
  }

}
