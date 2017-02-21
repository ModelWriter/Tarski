package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDetailContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementRefContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EAnnotationSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(CompletionTokens._annotation);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof EDetailContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._rightParenthesis);
      } else if (lastToken instanceof EAnnotationContext
          || lastToken instanceof EModelElementContext
          || lastToken instanceof EModelElementRefContext) {
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().eAnnotationSP().getStartSuggestions());
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eModelElementSP()
            .getStartSuggestions());
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eModelElementRefSP()
            .getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._annotation)) {
        suggestions.add(CompletionTokens._singleQuote);
        suggestions.add(CompletionTokens._leftParenthesis);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._leftParenthesis);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (lastToken.getText().equals(CompletionTokens._rightParenthesis)) {
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().eAnnotationSP().getStartSuggestions());
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eModelElementSP()
            .getStartSuggestions());
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eModelElementRefSP()
            .getStartSuggestions());
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
    return context instanceof EAnnotationContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eAttributeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eReferenceSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eParameterSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eDatatypeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumliteralSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eModelElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().eDetailSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eModelElementSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eModelElementRefSP());
  }

}
