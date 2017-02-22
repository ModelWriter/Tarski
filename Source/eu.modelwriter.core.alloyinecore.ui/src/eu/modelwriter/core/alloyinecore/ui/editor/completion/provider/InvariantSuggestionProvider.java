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
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class InvariantSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(CompletionTokens._callable);
    startSuggestions.add(CompletionTokens._invariant);
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
      if (lastToken.getText().equals(CompletionTokens._callable)) {
        suggestions.add(CompletionTokens._invariant);
      } else if (lastToken.getText().equals(CompletionTokens._invariant)) {
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
            spFactory.formulaSP().getStartSuggestions());
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof InvariantContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.ePackageSP());
    addParent(spFactory.eClassSP());
    addParent(spFactory.eDatatypeSP());
    addParent(spFactory.eEnumSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.indentifierSP());
    addChild(spFactory.formulaSP());
  }

}
