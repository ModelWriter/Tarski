package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

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
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class InvariantSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._callable);
    startSuggestions.add(ModelCompletionTokens._invariant);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof IdentifierContext) {
        suggestions.add(ModelCompletionTokens._leftParenthesis);
        suggestions.add(ModelCompletionTokens._colon);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken instanceof FormulaContext) {
        suggestions.add(ModelCompletionTokens._semicolon);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._callable)) {
        suggestions.add(ModelCompletionTokens._invariant);
      } else if (lastToken.getText().equals(ModelCompletionTokens._invariant)) {
        suggestions.add(ModelCompletionTokens._colon);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftParenthesis)) {
        suggestions.add(ModelCompletionTokens._doubleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.DOUBLE_QUOTED_STRING) {
        suggestions.add(ModelCompletionTokens._rightParenthesis);
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightParenthesis)) {
        suggestions.add(ModelCompletionTokens._colon);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._colon)) {
        suggestions.addAll(
            spFactory.formulaSP().getStartSuggestions());
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._semicolon)) {
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
