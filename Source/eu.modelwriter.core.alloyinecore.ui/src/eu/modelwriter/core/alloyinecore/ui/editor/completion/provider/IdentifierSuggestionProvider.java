package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
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
    addParent(spFactory.modelSP());
    addParent(spFactory.packageImportSP());
    addParent(spFactory.ePackageSP());
    addParent(spFactory.bodySP());
    addParent(spFactory.invariantSP());
    addParent(spFactory.preconditionSP());
    addParent(spFactory.postconditionSP());
    addParent(spFactory.initialSP());
    addParent(spFactory.derivationSP());
    addParent(spFactory.unrestrictedNameSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
