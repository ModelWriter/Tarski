package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class InvariantSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    InvariantSuggestionProvider.startSuggestions.add(CompletionTokens._callable);
    InvariantSuggestionProvider.startSuggestions.add(CompletionTokens._invariant);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    // TODO Auto-generated method stub

  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return InvariantSuggestionProvider.startSuggestions;
  }

}
