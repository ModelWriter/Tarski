package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EParameterSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    return new HashSet<>();
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(CompletionTokens._colon);
      } else if (lastToken instanceof EGenericElementTypeContext) {
        suggestions.addAll(AIESuggestionProviderSingletonFactory.instance().multiplicitySP()
            .getStartSuggestions());
        suggestions.add(CompletionTokens._leftCurly);
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(CompletionTokens._leftCurly);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._static)) {
        suggestions.add(CompletionTokens._operation);
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        // parameter type
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(CompletionTokens._ordered);
        suggestions.add(CompletionTokens._notOrdered);
        suggestions.add(CompletionTokens._unique);
        suggestions.add(CompletionTokens._notUnique);
        suggestions.addAll(
            AIESuggestionProviderSingletonFactory.instance().eAnnotationSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.add(CompletionTokens._ordered);
        suggestions.add(CompletionTokens._notOrdered);
        suggestions.add(CompletionTokens._unique);
        suggestions.add(CompletionTokens._notUnique);
      } else if (lastToken.getText().equals(CompletionTokens._ordered)
          || lastToken.getText().equals(CompletionTokens._notOrdered)
          || lastToken.getText().equals(CompletionTokens._unique)
          || lastToken.getText().equals(CompletionTokens._notUnique)) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._rightCurly);
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)
          || lastToken.getText().equals(CompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EParameterContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eTypedElementSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eOperationSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().unrestrictedNameSP());
    // addChild(AIESuggestionProviderSingletonFactory.instance().eGenericElementTypeSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().multiplicitySP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
  }

}
