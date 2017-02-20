package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EDetailSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  protected void initStartSuggestions() {
    // TODO do nothing.
  }

  @Override
  protected void computeSuggestions(ParserRuleContext context, ParseTree lastToken) {
    lastToken = context;
    context = context.getParent();
    for (final AIESuggestionProvider parentProvider : parents) {
      suggestions.addAll(parentProvider.getSuggestions(context, lastToken));
    }
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
    addParent(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
