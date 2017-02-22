package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EStructuralFeatureContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EStructuralFeatureSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(
        spFactory.eAttributeSP().getStartSuggestions());
    startSuggestions.addAll(
        spFactory.eReferenceSP().getStartSuggestions());
    return startSuggestions;
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
  protected void initParentProviders() {
    addParent(spFactory.eTypedElementSP());
    addParent(spFactory.eClassSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.eAttributeSP());
    addChild(spFactory.eReferenceSP());
  }

}
