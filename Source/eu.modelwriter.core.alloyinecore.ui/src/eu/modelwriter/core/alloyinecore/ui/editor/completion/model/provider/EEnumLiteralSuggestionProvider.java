package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EEnumLiteralSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._literal);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.addAll(spFactory.templateSignatureSP()
            .getStartSuggestions());
        suggestions.add(ModelCompletionTokens._equals);
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.add(ModelCompletionTokens._rightCurly);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (((TerminalNode) lastToken).getSymbol().getType() == AlloyInEcoreLexer.INT) {
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftCurly)) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightCurly)
          || lastToken.getText().equals(ModelCompletionTokens._semicolon)) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EEnumLiteralContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eEnumSP());
    addParent(spFactory.eNamedElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eAnnotationSP());
  }

}
