package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericSuperTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EClassSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(CompletionTokens._abstract);
    startSuggestions.add(CompletionTokens._class);
    startSuggestions.add(CompletionTokens._interface);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._abstract);
        suggestions.add(CompletionTokens._class);
        suggestions.add(CompletionTokens._interface);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.addAll(spFactory.templateSignatureSP()
            .getStartSuggestions());
        suggestions.add(CompletionTokens._extends);
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof TemplateSignatureContext) {
        suggestions.add(CompletionTokens._extends);
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EGenericSuperTypeContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext || lastToken instanceof EOperationContext
          || lastToken instanceof EStructuralFeatureContext
          || lastToken instanceof InvariantContext) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.eOperationSP().getStartSuggestions());
        suggestions.addAll(spFactory.eStructuralFeatureSP()
            .getStartSuggestions());
        suggestions.addAll(
            spFactory.invariantSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._abstract)) {
        suggestions.add(CompletionTokens._class);
      } else if (lastToken.getText().equals(CompletionTokens._extends)) {
        // TODO super types
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        // TODO super types
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            spFactory.eOperationSP().getStartSuggestions());
        suggestions.addAll(spFactory.eStructuralFeatureSP()
            .getStartSuggestions());
        suggestions.addAll(
            spFactory.invariantSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)
          || lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EClassContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eClassifierSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.visibilityKindSP());
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.templateSignatureSP());
    addChild(spFactory.eGenericSuperTypeSP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.eOperationSP());
    addChild(spFactory.eStructuralFeatureSP());
    addChild(spFactory.invariantSP());
  }

}
