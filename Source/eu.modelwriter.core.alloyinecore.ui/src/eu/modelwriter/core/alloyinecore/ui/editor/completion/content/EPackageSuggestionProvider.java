package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EPackageSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    EPackageSuggestionProvider.startSuggestions
    .addAll(VisibilityKindSuggestionProvider.startSuggestions);
    EPackageSuggestionProvider.startSuggestions.add(CompletionTokens._package);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._package);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(CompletionTokens._colon);
      } else if (lastToken instanceof IdentifierContext) {
        suggestions.add(CompletionTokens._equals);
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (lastToken instanceof EPackageContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (lastToken instanceof EClassifierContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (lastToken instanceof InvariantContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._equals)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
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
    return context instanceof EPackageContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return EPackageSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eNamedElementSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().ModelSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().VisibilityKindSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().UnrestrictedNameSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().IndentifierSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eClassifierSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().InvariantSP());
  }

}
