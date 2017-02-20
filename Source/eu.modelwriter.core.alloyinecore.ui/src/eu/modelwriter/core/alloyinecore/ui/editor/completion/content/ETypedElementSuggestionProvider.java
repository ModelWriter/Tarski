package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypedElementContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class ETypedElementSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    ETypedElementSuggestionProvider.startSuggestions
    .addAll(EOperationSuggestionProvider.startSuggestions);
    ETypedElementSuggestionProvider.startSuggestions
    .addAll(EParameterSuggestionProvider.startSuggestions);
    ETypedElementSuggestionProvider.startSuggestions
    .addAll(EStructuralFeatureSuggestionProvider.startSuggestions);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ETypedElementContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return ETypedElementSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eNamedElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eParameterSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eStructuralFeatureSP());
  }

}
