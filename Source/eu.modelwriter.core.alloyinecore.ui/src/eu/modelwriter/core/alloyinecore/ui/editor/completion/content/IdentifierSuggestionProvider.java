package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class IdentifierSuggestionProvider extends AbstractAIESuggestionProvider {

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
    return context instanceof IdentifierContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    // TODO return nothing.
    return null;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().ModelSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().PackageImportSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().BodySP());
    addParent(AIESuggestionProviderSingletonFactory.instance().InvariantSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().PreconditionSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().PostconditionSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().InitialSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().DerivationSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
