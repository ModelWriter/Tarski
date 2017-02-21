package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class PostconditionSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(CompletionTokens._postcondition);
    startSuggestions.add(CompletionTokens._ensures);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof IdentifierContext) {
        suggestions.add(CompletionTokens._leftParenthesis);
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof FormulaContext) {
        suggestions.add(CompletionTokens._semicolon);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._postcondition)
          || lastToken.getText().equals(CompletionTokens._ensures)) {
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.add(CompletionTokens._doubleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.DOUBLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._rightParenthesis);
      } else if (lastToken.getText().equals(CompletionTokens._rightParenthesis)) {
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().formulaSP().getStartSuggestions());
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof PostconditionContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().indentifierSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().formulaSP());
  }

}
