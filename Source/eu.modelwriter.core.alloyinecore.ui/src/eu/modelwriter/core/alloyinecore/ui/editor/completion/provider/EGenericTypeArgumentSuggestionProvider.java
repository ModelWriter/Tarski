package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericTypeArgumentContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EGenericTypeArgumentSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        AIESuggestionProviderSingletonFactory.instance().eGenericTypeSP().getStartSuggestions());
    startSuggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eGenericWildcardSP()
        .getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(AIESuggestionProviderSingletonFactory.instance().eGenericTypeSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(AIESuggestionProviderSingletonFactory.instance().eGenericTypeSP());
    children.add(AIESuggestionProviderSingletonFactory.instance().eGenericWildcardSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EGenericTypeArgumentContext;
  }

}
