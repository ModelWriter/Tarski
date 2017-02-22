package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PathNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.SegmentContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class PathNameSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    return new HashSet<>();
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        // suggestions.add(CompletionTokens._dot);
        // suggestions.addAll(
        // spFactory.segmentSP().getStartSuggestions());
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof SegmentContext) {
        // suggestions.addAll(
        // spFactory.segmentSP().getStartSuggestions());
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      }
    } else if (lastToken instanceof TerminalNode) {
      if (((TerminalNode) lastToken).getSymbol().getType() == AlloyInEcoreLexer.INT) {
        // suggestions.addAll(
        // spFactory.segmentSP().getStartSuggestions());
        // end of context.
        suggestions.addAll(getParentProviderSuggestions(context, lastToken));
      } else if (lastToken instanceof ErrorNode) {
        // suggestions.addAll(getChildProviderSuggestions(context, lastToken));
      }
    }
  }

  @Override
  protected boolean isCompatibleWithContext(final ParserRuleContext context) {
    return context instanceof PathNameContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eModelElementRefSP());
    addParent(spFactory.eGenericTypeSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.segmentSP());
  }

}
