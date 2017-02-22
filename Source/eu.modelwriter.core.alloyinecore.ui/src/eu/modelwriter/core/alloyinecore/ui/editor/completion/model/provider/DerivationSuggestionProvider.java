package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DerivationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class DerivationSuggestionProvider extends AbstractAIESuggestionProvider {


  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._derivation);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof IdentifierContext) {
        suggestions.add(ModelCompletionTokens._colon);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken instanceof ExpressionContext) {
        suggestions.add(ModelCompletionTokens._semicolon);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._derivation)) {
        suggestions.add(ModelCompletionTokens._colon);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._colon)) {
        suggestions.addAll(
            spFactory.expressionSP().getStartSuggestions());
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
    return context instanceof DerivationContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eAttributeSP());
    addParent(spFactory.eReferenceSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.indentifierSP());
    addChild(spFactory.expressionSP());
  }

}
