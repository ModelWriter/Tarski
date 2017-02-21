package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class UnrestrictedNameSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    return new HashSet<>();
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
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eAttributeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eReferenceSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eParameterSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eDatatypeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumliteralSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eTypeParameterSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().pathNameSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().segmentSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
