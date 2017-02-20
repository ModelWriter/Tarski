package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.LowerContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UpperContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class MultiplicitySuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    MultiplicitySuggestionProvider.startSuggestions.add(CompletionTokens._leftBracket);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof LowerContext) {
        suggestions.add(CompletionTokens._ellipsis);
        suggestions.addAll(CompletionTokens._stringBounds);
        suggestions.addAll(CompletionTokens._isnullable);
        suggestions.add(CompletionTokens._rightBracket);
      } else if (lastToken instanceof UpperContext) {
        suggestions.addAll(CompletionTokens._isnullable);
        suggestions.add(CompletionTokens._rightBracket);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._leftBracket)) {
        // lower
      } else if (lastToken.getText().equals(CompletionTokens._ellipsis)) {
        // upper
      } else if (CompletionTokens._stringBounds.contains(lastToken.getText())) {
        suggestions.addAll(CompletionTokens._isnullable);
        suggestions.add(CompletionTokens._rightBracket);
      } else if (CompletionTokens._isnullable.contains(lastToken.getText())) {
        suggestions.add(CompletionTokens._rightBracket);
      } else if (lastToken.getText().equals(CompletionTokens._rightBracket)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EMultiplicityContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return MultiplicitySuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eAttributeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eReferenceSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eParameterSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().LowerSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().UpperSP());
  }

}
