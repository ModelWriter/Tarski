package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class PathNameSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  protected void initStartSuggestions() {
    // TODO do nothing.
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {}

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof PathNameContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    // TODO return nothing.
    return null;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eModelElementRefSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().UnrestrictedNameSP());
    // addChild(AIESuggestionProviderSingletonFactory.instance().SegmentSP());
  }

}
