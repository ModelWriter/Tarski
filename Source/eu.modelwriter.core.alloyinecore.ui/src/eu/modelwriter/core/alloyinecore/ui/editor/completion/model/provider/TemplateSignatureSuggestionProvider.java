package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class TemplateSignatureSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._leftArrow);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof ETypeParameterContext) {
        suggestions.add(ModelCompletionTokens._comma);
        suggestions.add(ModelCompletionTokens._rightArrow);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._leftArrow)
          || lastToken.getText().equals(ModelCompletionTokens._comma)) {
        suggestions.addAll(spFactory.eTypeParameterSP()
            .getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightArrow)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof TemplateSignatureContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eClassSP());
    addParent(spFactory.eOperationSP());
    addParent(spFactory.eDatatypeSP());
    addParent(spFactory.eEnumSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.eTypeParameterSP());
  }

}
