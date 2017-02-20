package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.FormulaContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InvariantContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProviderSingletonFactory;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class InvariantSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    InvariantSuggestionProvider.startSuggestions.add(CompletionTokens._callable);
    InvariantSuggestionProvider.startSuggestions.add(CompletionTokens._invariant);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof IdentifierContext) {
        suggestions.add(CompletionTokens._leftParenthesis);
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof FormulaContext) {
        suggestions.add(CompletionTokens._semicolon);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._callable)) {
        suggestions.add(CompletionTokens._invariant);
      } else if (lastToken.getText().equals(CompletionTokens._invariant)) {
        suggestions.add(CompletionTokens._colon);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftParenthesis)) {
        suggestions.add(CompletionTokens._doubleQuote);
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
        suggestions.addAll(FormulaSuggestionProvider.startSuggestions);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.DOUBLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._rightParenthesis);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._semicolon)) {
        if (context.getParent() instanceof EPackageContext) {
          suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
          suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
          suggestions.addAll(EClassifierSuggestionProvider.startSuggestions);
          suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
        } else if (context.getParent() instanceof EClassContext) {
          suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
          suggestions.addAll(EOperationSuggestionProvider.startSuggestions);
          suggestions.addAll(EStructuralFeatureSuggestionProvider.startSuggestions);
          suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
        } else if (context.getParent() instanceof EDataTypeContext) {
          suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
          suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
        } else if (context.getParent() instanceof EEnumContext) {
          suggestions.addAll(EAnnotationSuggestionProvider.startSuggestions);
          suggestions.addAll(EEnumLiteralSuggestionProvider.startSuggestions);
          suggestions.addAll(InvariantSuggestionProvider.startSuggestions);
        }
      } else if (lastToken instanceof ErrorNode) {
        suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof InvariantContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return InvariantSuggestionProvider.startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    addParent(AIESuggestionProviderSingletonFactory.instance().ePackageSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eClassSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eDatatypeSP());
    addParent(AIESuggestionProviderSingletonFactory.instance().eEnumSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(AIESuggestionProviderSingletonFactory.instance().IndentifierSP());
    addChild(AIESuggestionProviderSingletonFactory.instance().FormulaSP());
  }

}
