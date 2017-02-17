package eu.modelwriter.core.alloyinecore.ui.editor.completion.conten;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.IdentifierContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;;

public class PackageImportSuggestionProvider extends AbstractAIESuggestionProvider {

  public static final Set<String> startSuggestions = new HashSet<>();

  @Override
  protected void initStartSuggestions() {
    PackageImportSuggestionProvider.startSuggestions.add(CompletionTokens._import);
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree closerToken) {
    if (closerToken instanceof ParserRuleContext) {
      if (context.equals(closerToken)) {
        suggestions.addAll(getStartSuggestions());
      } else if (context instanceof IdentifierContext) {
        suggestions.add(CompletionTokens._colon);
      }
    } else if (closerToken instanceof TerminalNode) {
      if (closerToken.getText().equals(CompletionTokens._colon)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) closerToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._semicolon);
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof PackageImportContext;
  }

  @Override
  protected Set<String> getStartSuggestions() {
    return PackageImportSuggestionProvider.startSuggestions;
  }

}
