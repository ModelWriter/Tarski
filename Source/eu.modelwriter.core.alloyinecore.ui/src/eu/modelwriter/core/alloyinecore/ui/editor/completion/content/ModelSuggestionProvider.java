package eu.modelwriter.core.alloyinecore.ui.editor.completion.content;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.OptionsContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class ModelSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    if (closerToken instanceof ParserRuleContext) {
      if (context.equals(closerToken)) {
        suggestions.addAll(getStartSuggestions());
      } else if (closerToken instanceof OptionsContext) {
        suggestions.add(CompletionTokens._model);
      } else if (closerToken instanceof IdentifierContext) {
        suggestions.add(CompletionTokens._semicolon);
      } else if (closerToken instanceof PackageImportContext) {
        suggestions.addAll(PackageImportSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
      }
    } else if (closerToken instanceof TerminalNode) {
      if (closerToken.getText().equals(CompletionTokens._semicolon)) {
        suggestions.addAll(PackageImportSuggestionProvider.startSuggestions);
        suggestions.addAll(EPackageSuggestionProvider.startSuggestions);
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof ModelContext;
  }

  @Override
  protected void initStartSuggestions() {
    ModelSuggestionProvider.startSuggestions.addAll(OptionsSuggestionProvider.startSuggestions);
    ModelSuggestionProvider.startSuggestions.add(CompletionTokens._model);
    ModelSuggestionProvider.startSuggestions
    .addAll(PackageImportSuggestionProvider.startSuggestions);
    ModelSuggestionProvider.startSuggestions.addAll(EPackageSuggestionProvider.startSuggestions);
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return ModelSuggestionProvider.startSuggestions;
  }

}
