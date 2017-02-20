package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.BodyContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericExceptionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PostconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PreconditionContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EOperationSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    EOperationSuggestionProvider.startSuggestions
    .addAll(VisibilityKindSuggestionProvider.startSuggestions);
    EOperationSuggestionProvider.startSuggestions.add(CompletionTokens._static);
    EOperationSuggestionProvider.startSuggestions.add(CompletionTokens._operation);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._static);
        suggestions.add(CompletionTokens._operation);
      } else if (lastToken instanceof TemplateSignatureContext) {
        // operation name
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(CompletionTokens._leftParenthesis);
      } else if (lastToken instanceof EParameterContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._rightParenthesis);
      } else if (lastToken instanceof EGenericElementTypeContext) {
        suggestions.addAll(MultiplicitySuggestionProvider.startSuggestions);
        suggestions.add(CompletionTokens._throws);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(CompletionTokens._throws);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EGenericExceptionContext) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext || lastToken instanceof PreconditionContext
          || lastToken instanceof BodyContext || lastToken instanceof PostconditionContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(PreconditionSuggestionProvider.startSuggestions);
        suggestions.addAll(BodySuggestionProvider.startSuggestions);
        suggestions.addAll(PostconditionSuggestionProvider.startSuggestions);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._static)) {
        suggestions.add(CompletionTokens._operation);
      } else if (lastToken.getText().equals(CompletionTokens._operation)) {
        suggestions.addAll(TemplateSignatureSuggestionProvider.startSuggestions);
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.addAll(EParameterSuggestionProvider.startSuggestions);
      } else if (lastToken.getText().equals(CompletionTokens._rightParenthesis)) {
        suggestions.add(CompletionTokens._colon);
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        // operation return type
      } else if (lastToken.getText().equals(CompletionTokens._throws)) {
        // exception type
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(CompletionTokens._ordered);
        suggestions.add(CompletionTokens._notOrdered);
        suggestions.add(CompletionTokens._unique);
        suggestions.add(CompletionTokens._notUnique);
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(PreconditionSuggestionProvider.startSuggestions);
        suggestions.addAll(BodySuggestionProvider.startSuggestions);
        suggestions.addAll(PostconditionSuggestionProvider.startSuggestions);
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.addAll(EParameterSuggestionProvider.startSuggestions);
        // exception types
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
    return context instanceof EOperationContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return EOperationSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eTypedElementSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().VisibilityKindSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().TemplateSignatureSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().UnrestrictedNameSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eParameterSP());
    // addChild(AIESuggestionProviderSingletonFactory.instance().eGenericElementTypeSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().MultiplicitySP());
    // addChild(AIESuggestionProviderSingletonFactory.instance().eGenericExceptionSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().PreconditionSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().BodySP());
    addChild(AIESuggestionProviderSingletonFactory.instance().PostconditionSP());
  }

}
