package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDetailContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EModelElementRefContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EAnnotationSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._annotation);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof EDetailContext) {
        suggestions.add(ModelCompletionTokens._comma);
        suggestions.add(ModelCompletionTokens._rightParenthesis);
      } else if (lastToken instanceof EAnnotationContext
          || lastToken instanceof EModelElementContext
          || lastToken instanceof EModelElementRefContext) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementSP()
            .getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementRefSP()
            .getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._annotation)) {
        suggestions.add(ModelCompletionTokens._singleQuote);
        suggestions.add(ModelCompletionTokens._leftParenthesis);
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(ModelCompletionTokens._leftParenthesis);
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftParenthesis)) {
        suggestions.add(ModelCompletionTokens._singleQuote);
      } else if (lastToken.getText().equals(ModelCompletionTokens._comma)) {
        suggestions.add(ModelCompletionTokens._singleQuote);
      } else if (lastToken.getText().equals(ModelCompletionTokens._rightParenthesis)) {
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftCurly)) {
        suggestions.addAll(
            spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementSP()
            .getStartSuggestions());
        suggestions.addAll(spFactory.eModelElementRefSP()
            .getStartSuggestions());
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
    return context instanceof EAnnotationContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.ePackageSP());
    addParent(spFactory.eClassSP());
    addParent(spFactory.eAttributeSP());
    addParent(spFactory.eReferenceSP());
    addParent(spFactory.eOperationSP());
    addParent(spFactory.eParameterSP());
    addParent(spFactory.eDatatypeSP());
    addParent(spFactory.eEnumSP());
    addParent(spFactory.eEnumliteralSP());
    addParent(spFactory.eAnnotationSP());
    addParent(spFactory.eModelElementSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.eDetailSP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.eModelElementSP());
    addChild(spFactory.eModelElementRefSP());
  }

}
