package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ETypeParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class TemplateSignatureSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(CompletionTokens._leftArrow);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof ETypeParameterContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._rightArrow);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._leftArrow)
          || lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().eTypeParameterSP()
            .getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._rightArrow)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof TemplateSignatureContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eDatatypeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().eTypeParameterSP());
  }

}
