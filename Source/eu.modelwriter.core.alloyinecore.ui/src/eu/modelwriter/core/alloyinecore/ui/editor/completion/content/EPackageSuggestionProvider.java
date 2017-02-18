package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
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
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EPackageSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    EPackageSuggestionProvider.startSuggestions.addAll(CompletionTokens._visibility);
    EPackageSuggestionProvider.startSuggestions.add(CompletionTokens._package);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    if (closerToken instanceof ParserRuleContext) {
      if (context.equals(closerToken)) {
        suggestions.addAll(getStartSuggestions());
      } else if (closerToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._package);
      } else if (closerToken instanceof UnrestrictedNameContext) {
        suggestions.add(CompletionTokens._colon);
      } else if (closerToken instanceof IdentifierContext) {
        suggestions.add(CompletionTokens._equals);
      } else if (closerToken instanceof EAnnotationContext) {
        suggestions.addAll(AnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (closerToken instanceof EPackageContext) {
        suggestions.addAll(AnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (closerToken instanceof EClassifierContext) {
        suggestions.addAll(AnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      } else if (closerToken instanceof InvariantContext) {
        suggestions.addAll(AnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
      }
    } else if (closerToken instanceof TerminalNode) {
      if (closerToken.getText().equals(CompletionTokens._equals)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) closerToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._openCurly);
      } else if (closerToken.getText().equals(CompletionTokens._openCurly)) {
        suggestions.addAll(AnnotationSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
        suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
        suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
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

}
