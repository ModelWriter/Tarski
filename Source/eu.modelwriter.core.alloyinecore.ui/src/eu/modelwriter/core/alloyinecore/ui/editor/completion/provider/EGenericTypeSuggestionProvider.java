package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeArgumentContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EGenericTypeSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        AIESuggestionProviderSingletonFactory.instance().pathNameSP().getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericExceptionSP());
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericSuperTypeSP());
    parents.add(AIESuggestionProviderSingletonFactory.instance().eTypeParameterSP());
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericTypeArgumentSP());
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericElementTypeSP());
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericWildcardSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(AIESuggestionProviderSingletonFactory.instance().pathNameSP());
    children.add(AIESuggestionProviderSingletonFactory.instance().eGenericTypeArgumentSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof PathNameContext) {
        suggestions.add(CompletionTokens._leftArrow);
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof EGenericTypeArgumentContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._rightArrow);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._leftArrow)
          || lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eGenericTypeArgumentSP()
            .getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._rightArrow)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EGenericTypeContext;
  }

}
