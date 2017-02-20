package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public abstract class AbstractAIESuggestionProvider implements AIESuggestionProvider {

  protected List<AIESuggestionProvider> children;
  protected List<AIESuggestionProvider> parents;
  protected Set<String> suggestions;
  protected List<String> allPossibleTokens;

  public AbstractAIESuggestionProvider() {
    initStartSuggestions();
  }

  @Override
  public Set<String> getSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions = new HashSet<>();
    if (isCompatibleWithContext(context)) {
      initRelatedProviders();
      computeSuggestions(context, lastToken);
    }
    return suggestions;
  }

  private void initRelatedProviders() {
    children = new ArrayList<>();
    parents = new ArrayList<>();
    initParentProviders();
    initChildProviders();
  }

  public void addParent(final AIESuggestionProvider parent) {
    parents.add(parent);
  }

  public void addChild(final AIESuggestionProvider child) {
    children.add(child);
  }

  protected Set<String> getChildProviderSuggestions(final ParserRuleContext context,
      final ParseTree lastToken) {
    final Set<String> suggestions = new HashSet<>();
    for (final ParseTree childContext : context.children) {
      for (final AIESuggestionProvider childProvider : children) {
        if (childContext instanceof ParserRuleContext) {
          suggestions
          .addAll(childProvider.getSuggestions((ParserRuleContext) childContext, lastToken));
        }
      }
    }
    return suggestions;
  }

  protected Set<String> getParentProviderSuggestions(ParserRuleContext context,
      ParseTree lastToken) {
    final Set<String> suggestions = new HashSet<>();
    lastToken = context;
    context = context.getParent();
    for (final AIESuggestionProvider parentProvider : parents) {
      suggestions.addAll(parentProvider.getSuggestions(context, lastToken));
    }
    return suggestions;
  }

  protected abstract void initParentProviders();

  protected abstract void initChildProviders();

  protected abstract void initStartSuggestions();

  protected abstract void computeSuggestions(ParserRuleContext context, ParseTree lastToken);

  protected abstract boolean isCompatibleWithContext(ParserRuleContext context);

  protected abstract Set<String> getStartSuggestions();
}
