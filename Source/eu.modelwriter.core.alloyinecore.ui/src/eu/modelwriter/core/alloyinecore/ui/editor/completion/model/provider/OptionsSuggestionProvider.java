package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class OptionsSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._options);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof OptionContext) {
        suggestions.add(ModelCompletionTokens._comma);
        suggestions.add(ModelCompletionTokens._rightCurly);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._options)) {
        suggestions.add(ModelCompletionTokens._leftCurly);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftCurly)
          || lastToken.getText().equals(ModelCompletionTokens._comma)) {
        suggestions.addAll(
            spFactory.optionSP().getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightCurly)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof OptionsContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.modelSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.optionSP());
  }

}
