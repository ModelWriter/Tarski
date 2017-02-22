package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDetailContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EDetailSuggestionProvider extends AbstractAIESuggestionProvider {

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
    return context instanceof EDetailContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eAnnotationSP());
  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
