package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ENamedElementContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class ENamedElementSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        spFactory.eTypedElementSP().getStartSuggestions());
    startSuggestions.addAll(
        spFactory.eClassifierSP().getStartSuggestions());
    startSuggestions.addAll(
        spFactory.ePackageSP().getStartSuggestions());
    startSuggestions.addAll(
        spFactory.eEnumliteralSP().getStartSuggestions());
    return startSuggestions;
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
  protected void initParentProviders() {
    addParent(spFactory.eModelElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.eTypedElementSP());
    addChild(spFactory.eClassifierSP());
    addChild(spFactory.ePackageSP());
    addChild(spFactory.eEnumliteralSP());
  }

}
