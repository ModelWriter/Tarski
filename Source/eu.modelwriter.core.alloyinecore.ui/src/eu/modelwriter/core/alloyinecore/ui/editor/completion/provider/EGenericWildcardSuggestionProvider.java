package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericWildcardContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EGenericWildcardSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(CompletionTokens._question);
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericTypeArgumentSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(AIESuggestionProviderSingletonFactory.instance().eGenericTypeSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof EGenericTypeContext) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._question)) {
        suggestions.add(CompletionTokens._extends);
        suggestions.add(CompletionTokens._super);
      } else if (lastToken.getText().equals(CompletionTokens._extends)
          || lastToken.getText().equals(CompletionTokens._super)) {
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eGenericTypeSP()
            .getStartSuggestions());
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EGenericWildcardContext;
  }

}
