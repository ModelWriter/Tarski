package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class IdentifierSuggestionProvider extends AbstractAIESuggestionProvider {

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
    return context instanceof IdentifierContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().modelSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().packageImportSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().bodySP());
    addParent(AIESuggestionProviderSingletonFactory.instance().invariantSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().preconditionSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().postconditionSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().initialSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().derivationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().unrestrictedNameSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
