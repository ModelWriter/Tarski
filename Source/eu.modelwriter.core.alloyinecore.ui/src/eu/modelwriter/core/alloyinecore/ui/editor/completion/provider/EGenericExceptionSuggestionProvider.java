package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericExceptionContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EGenericExceptionSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions
    .addAll(spFactory.eGenericTypeSP()
        .getStartSuggestions());
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(spFactory.eOperationSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(spFactory.eGenericTypeSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    suggestions.addAll(getParentProviderSuggestions(context, lastToken));
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EGenericExceptionContext;
  }

}
