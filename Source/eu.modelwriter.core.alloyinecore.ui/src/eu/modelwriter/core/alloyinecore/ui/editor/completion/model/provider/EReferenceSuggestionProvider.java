package eu.modelwriter.core.alloyinecore.ui.editor.completion.model.provider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.DerivationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EMultiplicityContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.InitialContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.UnrestrictedNameContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.VisibilityKindContext;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.base.ITarget;
import eu.modelwriter.core.alloyinecore.structure.model.GenericElementType;
import eu.modelwriter.core.alloyinecore.structure.model.Reference;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.model.ModelCompletionTokens;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;

public class EReferenceSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(ModelCompletionTokens._static);
    startSuggestions.add(ModelCompletionTokens._model);
    startSuggestions.add(ModelCompletionTokens._ghost);
    startSuggestions.add(ModelCompletionTokens._transient);
    startSuggestions.add(ModelCompletionTokens._volatile);
    startSuggestions.add(ModelCompletionTokens._readonly);
    startSuggestions.add(ModelCompletionTokens._property);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(ModelCompletionTokens._static);
        suggestions.add(ModelCompletionTokens._model);
        suggestions.add(ModelCompletionTokens._ghost);
        suggestions.add(ModelCompletionTokens._transient);
        suggestions.add(ModelCompletionTokens._volatile);
        suggestions.add(ModelCompletionTokens._readonly);
        suggestions.add(ModelCompletionTokens._property);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(ModelCompletionTokens._sharp);
        suggestions.add(ModelCompletionTokens._colon);
      } else if (lastToken instanceof EGenericElementTypeContext) {
        suggestions.addAll(spFactory.multiplicitySP().getStartSuggestions());
        suggestions.add(ModelCompletionTokens._equals);
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(ModelCompletionTokens._equals);
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.derivationSP().getStartSuggestions());
        suggestions.addAll(spFactory.initialSP().getStartSuggestions());
      } else if (lastToken instanceof DerivationContext || lastToken instanceof InitialContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(ModelCompletionTokens._static)) {
        suggestions.add(ModelCompletionTokens._model);
        suggestions.add(ModelCompletionTokens._ghost);
        suggestions.add(ModelCompletionTokens._transient);
        suggestions.add(ModelCompletionTokens._volatile);
        suggestions.add(ModelCompletionTokens._readonly);
        suggestions.add(ModelCompletionTokens._property);
      } else if (lastToken.getText().equals(ModelCompletionTokens._model)
          || lastToken.getText().equals(ModelCompletionTokens._ghost)) {
        suggestions.add(ModelCompletionTokens._transient);
        suggestions.add(ModelCompletionTokens._volatile);
        suggestions.add(ModelCompletionTokens._readonly);
        suggestions.add(ModelCompletionTokens._property);
      } else if (lastToken.getText().equals(ModelCompletionTokens._transient)) {
        suggestions.add(ModelCompletionTokens._volatile);
        suggestions.add(ModelCompletionTokens._readonly);
        suggestions.add(ModelCompletionTokens._property);
      } else if (lastToken.getText().equals(ModelCompletionTokens._volatile)) {
        suggestions.add(ModelCompletionTokens._readonly);
        suggestions.add(ModelCompletionTokens._property);
      } else if (lastToken.getText().equals(ModelCompletionTokens._readonly)) {
        suggestions.add(ModelCompletionTokens._property);
      } else if (lastToken.getText().equals(ModelCompletionTokens._property)) {
        // property name
      } else if (lastToken.getText().equals(ModelCompletionTokens._sharp)) {
        // TODO opposite type
        final EReferenceContext fullContext =
            (EReferenceContext) AIECompletionUtil.getFullContext(context);
        if (fullContext != null) {
          if (fullContext.eReferenceType != null) {
            final GenericElementType eReferenceType = fullContext.eReferenceType.current;
            for (@SuppressWarnings("rawtypes")
            final Element child : eReferenceType.getOwnedElements()) {
              if (child instanceof Reference) {
                suggestions.add(child.getUniqueName());
              }
            }
          }
        }
      } else if (lastToken.getText().equals(ModelCompletionTokens._colon)) {
        // reference type
        final EReferenceContext fullContext =
            (EReferenceContext) AIECompletionUtil.getFullContext(context);
        if (fullContext != null) {
          final List<ITarget> targets = fullContext.current.getTargets().stream()
              .map(e -> (ITarget) e).collect(Collectors.toList());
          for (final ITarget target : targets) {
            suggestions.add(target.getRelativeSegment());
          }
        }
      } else if (lastToken.getText().equals(ModelCompletionTokens._equals)) {
        suggestions.add(ModelCompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(ModelCompletionTokens._leftCurly);
        suggestions.add(ModelCompletionTokens._semicolon);
      } else if (lastToken.getText().equals(ModelCompletionTokens._leftCurly)) {
        suggestions.add(ModelCompletionTokens._key);
        suggestions.add(ModelCompletionTokens._composes);
        suggestions.add(ModelCompletionTokens._derived);
        suggestions.add(ModelCompletionTokens._ordered);
        suggestions.add(ModelCompletionTokens._notOrdered);
        suggestions.add(ModelCompletionTokens._unique);
        suggestions.add(ModelCompletionTokens._notUnique);
        suggestions.add(ModelCompletionTokens._resolve);
        suggestions.add(ModelCompletionTokens._notResolve);
        suggestions.add(ModelCompletionTokens._unsettable);
        suggestions.add(ModelCompletionTokens._notUnsettable);
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.derivationSP().getStartSuggestions());
        suggestions.addAll(spFactory.initialSP().getStartSuggestions());
      } else if (lastToken.getText().equals(ModelCompletionTokens._comma)) {
        suggestions.add(ModelCompletionTokens._composes);
        suggestions.add(ModelCompletionTokens._derived);
        suggestions.add(ModelCompletionTokens._ordered);
        suggestions.add(ModelCompletionTokens._notOrdered);
        suggestions.add(ModelCompletionTokens._unique);
        suggestions.add(ModelCompletionTokens._notUnique);
        suggestions.add(ModelCompletionTokens._resolve);
        suggestions.add(ModelCompletionTokens._notResolve);
        suggestions.add(ModelCompletionTokens._unsettable);
        suggestions.add(ModelCompletionTokens._notUnsettable);
      } else if (lastToken.getText().equals(ModelCompletionTokens._composes)
          || lastToken.getText().equals(ModelCompletionTokens._derived)
          || lastToken.getText().equals(ModelCompletionTokens._ordered)
          || lastToken.getText().equals(ModelCompletionTokens._notOrdered)
          || lastToken.getText().equals(ModelCompletionTokens._unique)
          || lastToken.getText().equals(ModelCompletionTokens._notUnique)
          || lastToken.getText().equals(ModelCompletionTokens._resolve)
          || lastToken.getText().equals(ModelCompletionTokens._notResolve)
          || lastToken.getText().equals(ModelCompletionTokens._unsettable)
          || lastToken.getText().equals(ModelCompletionTokens._notUnsettable)) {
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
    return context instanceof EReferenceContext;
  }

  @Override
  protected void initParentProviders() {
    addParent(spFactory.eStructuralFeatureSP());
  }

  @Override
  protected void initChildProviders() {
    addChild(spFactory.visibilityKindSP());
    addChild(spFactory.unrestrictedNameSP());
    addChild(spFactory.eGenericElementTypeSP());
    addChild(spFactory.multiplicitySP());
    addChild(spFactory.eAnnotationSP());
    addChild(spFactory.derivationSP());
    addChild(spFactory.initialSP());
  }

}
