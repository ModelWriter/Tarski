package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EStructuralFeatureSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    EStructuralFeatureSuggestionProvider.startSuggestions
    .addAll(EAttributeSuggestionProvider.startSuggestions);
    EStructuralFeatureSuggestionProvider.startSuggestions
    .addAll(EReferenceSuggestionProvider.startSuggestions);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EStructuralFeatureContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return EStructuralFeatureSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eTypedElementSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().eAttributeSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eReferenceSP());
  }

}
