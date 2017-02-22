package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EPackageSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(ModelCompletionTokens._package);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(ModelCompletionTokens._package);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(ModelCompletionTokens._colon);
      } else if (lastToken instanceof IdentifierContext) {
        suggestions.add(ModelCompletionTokens._equals);
      } else if (lastToken instanceof EAnnotationContext || lastToken instanceof EPackageContext
          || lastToken instanceof EClassifierContext || lastToken instanceof InvariantContext) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.ePackageSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.eClassifierSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.invariantSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._equals)) {
        suggestions.add(ModelCompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftCurly)) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.ePackageSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.eClassifierSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.invariantSP().getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightCurly)
          || lastToken.getText().equals(ModelCompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EPackageContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eNamedElementSP());
    addParent(spFactory.ePackageSP());
    addParent(spFactory.modelSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.visibilityKindSP());
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.indentifierSP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.ePackageSP());
    addChild(spFactory.eClassifierSP());
    addChild(spFactory.invariantSP());
  }

}
