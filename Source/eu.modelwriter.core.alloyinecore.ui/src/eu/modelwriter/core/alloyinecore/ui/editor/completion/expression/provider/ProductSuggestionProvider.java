package eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ExpressionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.MultContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ProductContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.ExpressionCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class ProductSuggestionProvider extends AbstractAIESuggestionProvider {

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
        if (((ProductContext) context).left != null
            && ((ProductContext) context).left.equals(lastToken)) {
          suggestions.addAll(ExpressionCompletionTokens._mult);
          suggestions.add(ExpressionCompletionTokens._product);
        } else if (((ProductContext) context).right != null
            && ((ProductContext) context).right.equals(lastToken)) {
          // end of context.
          suggestions.addAll(getParentProviderSuggestions(context, lastToken));
        }
      } else if (lastToken instanceof MultContext) {
        if (((ProductContext) context).leftMult != null
            && ((ProductContext) context).leftMult.equals(lastToken)) {
          suggestions.add(ExpressionCompletionTokens._product);
        } else if (((ProductContext) context).rightMult != null
            && ((ProductContext) context).rightMult.equals(lastToken)) {
          suggestions.addAll(spFactory.expressionSP().getStartSuggestions());
        }
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ExpressionCompletionTokens._product)) {
        suggestions.addAll(ExpressionCompletionTokens._mult);
        suggestions.addAll(spFactory.expressionSP().getStartSuggestions());
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ProductContext;
  }

}
