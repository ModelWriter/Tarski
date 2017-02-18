package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class OptionSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    OptionSuggestionProvider.startSuggestions.addAll(CompletionTokens._option);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    if (closerToken instanceof ParserRuleContext) {
      if (context.equals(closerToken)) {
        suggestions.addAll(getStartSuggestions());
      }
    } else
      if (closerToken instanceof TerminalNode) {
        if (CompletionTokens._option.contains(closerToken.getText())) {
          suggestions.add(CompletionTokens._colon);
        }
      }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof OptionContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return OptionSuggestionProvider.startSuggestions;
  }

}
