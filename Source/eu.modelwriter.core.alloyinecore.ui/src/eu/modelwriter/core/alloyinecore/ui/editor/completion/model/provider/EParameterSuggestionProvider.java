package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EParameterSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    return new HashSet<>();
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(ModelCompletionTokens._colon);
      } else if (lastToken instanceof EGenericElementTypeContext) {
        suggestions.addAll(spFactory.multiplicitySP().getStartSuggestions());
        suggestions.add(ModelCompletionTokens._leftCurly);
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(ModelCompletionTokens._leftCurly);
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._static)) {
        suggestions.add(ModelCompletionTokens._operation);
      } else if (lastToken.getText().equals(ModelCompletionTokens._colon)) {
        // parameter type
        final EOperationContext fullContext =
            (EOperationContext) AIECompletionUtil.getFullContext(context.getParent());
        if (fullContext != null) {
          final List<ITarget> targets = fullContext.current.getTargets().stream()
              .map(e -> (ITarget) e).collect(Collectors.toList());
          for (final ITarget target : targets) {
            suggestions.add(target.getRelativeSegment());
          }
        }
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftCurly)) {
        suggestions.add(ModelCompletionTokens._ordered);
        suggestions.add(ModelCompletionTokens._notOrdered);
        suggestions.add(ModelCompletionTokens._unique);
        suggestions.add(ModelCompletionTokens._notUnique);
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._comma)) {
        suggestions.add(ModelCompletionTokens._ordered);
        suggestions.add(ModelCompletionTokens._notOrdered);
        suggestions.add(ModelCompletionTokens._unique);
        suggestions.add(ModelCompletionTokens._notUnique);
      } else if (lastToken.getText().equals(ModelCompletionTokens._ordered)
          || lastToken.getText().equals(ModelCompletionTokens._notOrdered)
          || lastToken.getText().equals(ModelCompletionTokens._unique)
          || lastToken.getText().equals(ModelCompletionTokens._notUnique)) {
        suggestions.add(ModelCompletionTokens._comma);
        suggestions.add(ModelCompletionTokens._rightCurly);
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
    return context instanceof EParameterContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eTypedElementSP());
    addParent(spFactory.eOperationSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eGenericElementTypeSP());
    addChild(spFactory.multiplicitySP());
    addChild(spFactory.eAnnotationSP());
  }

}
