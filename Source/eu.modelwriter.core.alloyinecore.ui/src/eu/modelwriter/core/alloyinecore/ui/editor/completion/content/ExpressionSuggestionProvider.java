package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class ExpressionSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {}

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    // TODO Auto-generated method stub

  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected void initParentProviders() {
    // TODO Auto-generated method stub

  }

  @Override
  protected void initChildProviders() {
    // TODO Auto-generated method stub

  }

}
