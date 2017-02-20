package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ENamedElementContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class ENamedElementSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    ENamedElementSuggestionProvider.startSuggestions
    .addAll(ETypedElementSuggestionProvider.startSuggestions);
    ENamedElementSuggestionProvider.startSuggestions
    .addAll(EClassifierSuggestionProvider.startSuggestions);
    ENamedElementSuggestionProvider.startSuggestions
    .addAll(EPackageSuggestionProvider.startSuggestions);
    ENamedElementSuggestionProvider.startSuggestions
    .addAll(EEnumLiteralSuggestionProvider.startSuggestions);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ENamedElementContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return ENamedElementSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eModelElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().eTypedElementSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eClassifierSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eEnumliteralSP());
  }

}
