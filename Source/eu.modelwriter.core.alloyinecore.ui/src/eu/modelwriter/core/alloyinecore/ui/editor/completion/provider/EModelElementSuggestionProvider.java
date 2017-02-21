package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EModelElementSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        AIESuggestionProviderSingletonFactory.instance().eAnnotationSP().getStartSuggestions());
    startSuggestions.addAll(
        AIESuggestionProviderSingletonFactory.instance().eNamedElementSP().getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EModelElementContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eNamedElementSP());
  }

}
