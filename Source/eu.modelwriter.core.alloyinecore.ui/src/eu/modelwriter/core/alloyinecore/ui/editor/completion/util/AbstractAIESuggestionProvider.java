package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class AbstractAIESuggestionProvider implements AIESuggestionProvider {
  protected Set<String> suggestions;
  protected List<String> allPossibleTokens;

  public AbstractAIESuggestionProvider() {
    initStartSuggestions();
  }

  @Override
  public Set<String> getSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    suggestions = new HashSet<>();
    if (isCompatibleWithContext(context)) {
      computeSuggestions(context, closerToken);
    }
    return suggestions;
  }

  protected abstract void initStartSuggestions();

  protected abstract void computeSuggestions(ParserRuleContext context, ParseTree closerToken);

  protected abstract boolean isCompatibleWithContext(ParserRuleContext context);

  protected abstract Set<String> getStartSuggestions();
}
