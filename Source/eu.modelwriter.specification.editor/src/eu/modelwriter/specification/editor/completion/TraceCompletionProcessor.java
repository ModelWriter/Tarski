package eu.modelwriter.specification.editor.completion;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import eu.modelwriter.configuration.internal.EditorUtilities;
import eu.modelwriter.configuration.internal.ModelIO;
import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

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

    List<String> loadModelLines = EditorUtilities.getPartitionsByType(document,
        MetaModelPartitionScanner.META_MODEL_LOADMODEL);
    for (String line : loadModelLines) {
      final String path = line.substring(line.indexOf("@") + 1, line.indexOf(" as ")).trim();
      final String alias = line.substring(line.indexOf("as ") + 3).trim();
      final EPackage root = getRootObject(path);
      if (root != null) {
        aliasToEMF.put(alias, root);
      }
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
          final boolean newRoute = builder.charAt(builder.length() - 1) == this.activateRouteChar;
          final String[] split = builder.toString().split("\\.");
          final String prefix = newRoute ? "" : split[split.length - 1];
          if (split.length == 1 && !newRoute) {
            for (String alias : aliasToEMF.keySet()) {
              if (alias.toLowerCase().startsWith(builder.toString().toLowerCase()))
                proposals
                    .add(new CompletionProposal(alias, temp + 1, builder.length(), alias.length()));
            }
            // for (EPackage root : aliasToEMF.values()) {
            // if (root.getName().toLowerCase().startsWith(builder.toString().toLowerCase()))
            // proposals.add(new CompletionProposal(root.getName(), temp + 1, builder.length(),
            // root.getName().length(), null, root.getName() + " : " + root.getNsURI(), null,
            // null));

          } else if (split.length >= 1) {
            for (String name : getCompletionStrings(split, prefix, newRoute)) {
              final int startOffset = temp + 1 + (builder.length() - (prefix.length()));
              proposals
                  .add(new CompletionProposal(name, startOffset, prefix.length(), name.length()));
            }
          }
        } else {
          if (this.activateTraceChar == c) {
            for (String alias : aliasToEMF.keySet()) {
              proposals
                  .add(new CompletionProposal(alias, temp + 1, builder.length(), alias.length()));
            }
            // for (EPackage root : aliasToEMF.values())
            // proposals.add(new CompletionProposal(root.getName(), temp + 1, builder.length(),
            // root.getName().length(), null, root.getName() + " : " + root.getNsURI(), null,
            // null));
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

  // private EPackage findEMFRootByName(String name) {
  // for (EPackage ePackage : aliasToEMF.values()) {
  // if (ePackage.getName().equals(name))
  // return ePackage;
  // }
  // return null;
  // }

  private EPackage getRootObject(final String xmiFileFullPath) {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;
    try {
      list = modelIO.read(URI.createPlatformResourceURI(xmiFileFullPath, true));
    } catch (final IOException e) {
      return null;
    }
    if (list.isEmpty()) {
      return null;
    }
    return (EPackage) list.get(0);
  }

  private List<String> getCompletionStrings(String[] emfRoutes, String prefix, boolean newRoute) {
    final List<String> proposals = new ArrayList<String>();
    final String alias = emfRoutes[0];
    final int lenght = emfRoutes.length + (newRoute ? 0 : -1);
    EObject eContainer = this.aliasToEMF.get(alias);

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