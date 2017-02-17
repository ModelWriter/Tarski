package eu.modelwriter.core.alloyinecore.ui.editor.completion.conten;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class OptionsSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    OptionsSuggestionProvider.startSuggestions.add(CompletionTokens._options);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    if (closerToken instanceof ParserRuleContext) {
      if (context.equals(closerToken)) {
        suggestions.addAll(getStartSuggestions());
      } else if (closerToken instanceof OptionContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._closeCurly);
      }
    } else if (closerToken instanceof TerminalNode) {
      if (closerToken.getText().equals(CompletionTokens._options)) {
        suggestions.add(CompletionTokens._openCurly);
      } else if (closerToken.getText().equals(CompletionTokens._openCurly)
          || closerToken.getText().equals(CompletionTokens._comma)) {
        suggestions.addAll(OptionSuggestionProvider.startSuggestions);
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof OptionsContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return OptionsSuggestionProvider.startSuggestions;
  }

}
