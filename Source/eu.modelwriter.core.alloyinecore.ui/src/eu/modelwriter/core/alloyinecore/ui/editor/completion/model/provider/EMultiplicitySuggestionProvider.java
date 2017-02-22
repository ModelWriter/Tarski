package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.LowerContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UpperContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EMultiplicitySuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._leftBracket);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof LowerContext) {
        suggestions.add(ModelCompletionTokens._ellipsis);
        suggestions.addAll(ModelCompletionTokens._stringBounds);
        suggestions.addAll(ModelCompletionTokens._isnullable);
        suggestions.add(ModelCompletionTokens._rightBracket);
      } else if (lastToken instanceof UpperContext) {
        suggestions.addAll(ModelCompletionTokens._isnullable);
        suggestions.add(ModelCompletionTokens._rightBracket);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._leftBracket)) {
        // lower
      } else if (lastToken.getText().equals(ModelCompletionTokens._ellipsis)) {
        // upper
      } else if (ModelCompletionTokens._stringBounds.contains(lastToken.getText())) {
        suggestions.addAll(ModelCompletionTokens._isnullable);
        suggestions.add(ModelCompletionTokens._rightBracket);
      } else if (ModelCompletionTokens._isnullable.contains(lastToken.getText())) {
        suggestions.add(ModelCompletionTokens._rightBracket);
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightBracket)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EMultiplicityContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eAttributeSP());
    addParent(spFactory.eReferenceSP());
    addParent(spFactory.eOperationSP());
    addParent(spFactory.eParameterSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.lowerSP());
    addChild(spFactory.upperSP());
  }

}
