package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EDataTypeSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        AIESuggestionProviderSingletonFactory.instance().visibilityKindSP().getStartSuggestions());
    startSuggestions.add(CompletionTokens._primitive);
    startSuggestions.add(CompletionTokens._datatype);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._primitive);
        suggestions.add(CompletionTokens._datatype);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().templateSignatureSP()
            .getStartSuggestions());
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof TemplateSignatureContext) {
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext || lastToken instanceof InvariantContext) {
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().invariantSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._primitive)) {
        suggestions.add(CompletionTokens._datatype);
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(CompletionTokens._serializable);
        suggestions.add(CompletionTokens._notSerializable);
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().eAnnotationSP().getStartSuggestions());
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().invariantSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._serializable)
          || lastToken.getText().equals(CompletionTokens._notSerializable)) {
        suggestions.add(CompletionTokens._rightCurly);
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)
          || lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EDataTypeContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassifierSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().visibilityKindSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().unrestrictedNameSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().templateSignatureSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().invariantSP());
  }

}
