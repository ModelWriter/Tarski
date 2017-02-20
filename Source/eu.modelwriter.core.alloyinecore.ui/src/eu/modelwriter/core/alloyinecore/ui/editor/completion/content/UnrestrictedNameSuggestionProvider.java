package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class UnrestrictedNameSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  protected void initStartSuggestions() {
    // TODO do nothing.
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof UnrestrictedNameContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    // TODO return nothing.
    return null;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eAttributeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eReferenceSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eParameterSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumliteralSP());
    // addParent(AIESuggestionProviderSingletonFactory.instance().eTypeParameterSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().PathNameSP());
    // addParent(AIESuggestionProviderSingletonFactory.instance().SegmentSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
