package eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.JoinContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnionContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.ExpressionCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class JoinSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    return new HashSet<>();
  }

  @Override
  protected void initParentProviders() {
    parents.add(spFactory.expressionSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(spFactory.expressionSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof ExpressionContext) {
        if (((UnionContext) context).left != null
            && ((UnionContext) context).left.equals(lastToken)) {
          suggestions.add(ExpressionCompletionTokens._join);
        } else if (((UnionContext) context).right != null
            && ((UnionContext) context).right.equals(lastToken)) {
          // end of context.
          suggestions.addAll(getParentProviderSuggestions(context, lastToken));
        }
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ExpressionCompletionTokens._join)) {
        suggestions.addAll(spFactory.expressionSP().getStartSuggestions());
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof JoinContext;
  }

}
