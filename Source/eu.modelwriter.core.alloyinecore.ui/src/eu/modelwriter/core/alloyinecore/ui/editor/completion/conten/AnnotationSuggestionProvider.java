package eu.modelwriter.core.alloyinecore.ui.editor.completion.conten;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class AnnotationSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    AnnotationSuggestionProvider.startSuggestions.add(CompletionTokens._annotation);
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
    return AnnotationSuggestionProvider.startSuggestions;
  }

}
