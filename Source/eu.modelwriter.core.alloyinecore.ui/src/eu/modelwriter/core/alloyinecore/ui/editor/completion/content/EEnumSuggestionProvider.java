package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.TemplateSignatureContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EEnumSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    EEnumSuggestionProvider.startSuggestions
    .addAll(VisibilityKindSuggestionProvider.startSuggestions);
    EEnumSuggestionProvider.startSuggestions.add(CompletionTokens._enum);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._enum);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.addAll(TemplateSignatureSuggestionProvider.startSuggestions);
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof TemplateSignatureContext) {
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EEnumLiteralSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (lastToken instanceof EEnumLiteralContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EEnumLiteralSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (lastToken instanceof InvariantContext) {
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EEnumLiteralSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(CompletionTokens._serializable);
        suggestions.add(CompletionTokens._notSerializable);
        suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EEnumLiteralSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (lastToken.getText().equals(CompletionTokens._serializable)
          || lastToken.getText().equals(CompletionTokens._notSerializable)) {
        suggestions.add(CompletionTokens._rightCurly);
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)
          || lastToken.getText().equals(CompletionTokens._semicolon)) {
        if (context.getParent().getParent() instanceof EPackageContext) {
          suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
          suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
          suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
          suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
        }
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof EEnumContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return EEnumSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassifierSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().VisibilityKindSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().UnrestrictedNameSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().TemplateSignatureSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eAnnotationSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().eEnumliteralSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().InvariantSP());
  }

}
