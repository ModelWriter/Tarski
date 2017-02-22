package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.SegmentContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class SegmentSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.add(ModelCompletionTokens._doubleColon);
    return startSuggestions;
  }

  @Override
  protected void initParentProviders() {
    parents.add(spFactory.pathNameSP());
  }

  @Override
  protected void initChildProviders() {
    children.add(spFactory.unrestrictedNameSP());
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(ModelCompletionTokens._dot);
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._doubleColon)) {
        suggestions.add(ModelCompletionTokens._at);
        suggestions.addAll(spFactory.unrestrictedNameSP()
            .getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._at)) {
        suggestions.addAll(spFactory.unrestrictedNameSP()
            .getStartSuggestions());
      } else if (((TerminalNode) lastToken).getSymbol().getType() == AlloyInEcoreLexer.INT) {
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof SegmentContext;
  }

}
