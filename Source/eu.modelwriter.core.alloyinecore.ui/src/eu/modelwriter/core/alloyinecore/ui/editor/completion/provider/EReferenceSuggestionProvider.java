package eu.modelwriter.core.alloyinecore.ui.editor.completion.provider;

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
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIECompletionUtil;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AbstractAIESuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.CompletionTokens;

public class EReferenceSuggestionProvider extends AbstractAIESuggestionProvider {

  @Override
  public Set<String> getStartSuggestions() {
    final Set<String> startSuggestions = new HashSet<>();
    startSuggestions.addAll(spFactory.visibilityKindSP().getStartSuggestions());
    startSuggestions.add(CompletionTokens._static);
    startSuggestions.add(CompletionTokens._model);
    startSuggestions.add(CompletionTokens._ghost);
    startSuggestions.add(CompletionTokens._transient);
    startSuggestions.add(CompletionTokens._volatile);
    startSuggestions.add(CompletionTokens._readonly);
    startSuggestions.add(CompletionTokens._property);
    return startSuggestions;
  }

  @Override
  protected void computeSuggestions(final ParserRuleContext context, final ParseTree lastToken) {
    if (lastToken instanceof ParserRuleContext) {
      if (lastToken instanceof VisibilityKindContext) {
        suggestions.add(CompletionTokens._static);
        suggestions.add(CompletionTokens._model);
        suggestions.add(CompletionTokens._ghost);
        suggestions.add(CompletionTokens._transient);
        suggestions.add(CompletionTokens._volatile);
        suggestions.add(CompletionTokens._readonly);
        suggestions.add(CompletionTokens._property);
      } else if (lastToken instanceof UnrestrictedNameContext) {
        suggestions.add(CompletionTokens._sharp);
        suggestions.add(CompletionTokens._colon);
      } else if (lastToken instanceof EGenericElementTypeContext) {
        suggestions.addAll(spFactory.multiplicitySP().getStartSuggestions());
        suggestions.add(CompletionTokens._equals);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EMultiplicityContext) {
        suggestions.add(CompletionTokens._equals);
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken instanceof EAnnotationContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.derivationSP().getStartSuggestions());
        suggestions.addAll(spFactory.initialSP().getStartSuggestions());
      } else if (lastToken instanceof DerivationContext || lastToken instanceof InitialContext) {
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
      }
    } else if (lastToken instanceof TerminalNode) {
      if (lastToken.getText().equals(CompletionTokens._static)) {
        suggestions.add(CompletionTokens._model);
        suggestions.add(CompletionTokens._ghost);
        suggestions.add(CompletionTokens._transient);
        suggestions.add(CompletionTokens._volatile);
        suggestions.add(CompletionTokens._readonly);
        suggestions.add(CompletionTokens._property);
      } else if (lastToken.getText().equals(CompletionTokens._model)
          || lastToken.getText().equals(CompletionTokens._ghost)) {
        suggestions.add(CompletionTokens._transient);
        suggestions.add(CompletionTokens._volatile);
        suggestions.add(CompletionTokens._readonly);
        suggestions.add(CompletionTokens._property);
      } else if (lastToken.getText().equals(CompletionTokens._transient)) {
        suggestions.add(CompletionTokens._volatile);
        suggestions.add(CompletionTokens._readonly);
        suggestions.add(CompletionTokens._property);
      } else if (lastToken.getText().equals(CompletionTokens._volatile)) {
        suggestions.add(CompletionTokens._readonly);
        suggestions.add(CompletionTokens._property);
      } else if (lastToken.getText().equals(CompletionTokens._readonly)) {
        suggestions.add(CompletionTokens._property);
      } else if (lastToken.getText().equals(CompletionTokens._property)) {
        // property name
      } else if (lastToken.getText().equals(CompletionTokens._sharp)) {
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
      } else if (lastToken.getText().equals(CompletionTokens._colon)) {
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
      } else if (lastToken.getText().equals(CompletionTokens._equals)) {
        suggestions.add(CompletionTokens._singleQuote);
      } else if (((TerminalNode) lastToken).getSymbol()
          .getType() == AlloyInEcoreLexer.SINGLE_QUOTED_STRING) {
        suggestions.add(CompletionTokens._leftCurly);
        suggestions.add(CompletionTokens._semicolon);
      } else if (lastToken.getText().equals(CompletionTokens._leftCurly)) {
        suggestions.add(CompletionTokens._key);
        suggestions.add(CompletionTokens._composes);
        suggestions.add(CompletionTokens._derived);
        suggestions.add(CompletionTokens._ordered);
        suggestions.add(CompletionTokens._notOrdered);
        suggestions.add(CompletionTokens._unique);
        suggestions.add(CompletionTokens._notUnique);
        suggestions.add(CompletionTokens._resolve);
        suggestions.add(CompletionTokens._notResolve);
        suggestions.add(CompletionTokens._unsettable);
        suggestions.add(CompletionTokens._notUnsettable);
        suggestions.addAll(spFactory.eAnnotationSP().getStartSuggestions());
        suggestions.addAll(spFactory.derivationSP().getStartSuggestions());
        suggestions.addAll(spFactory.initialSP().getStartSuggestions());
      } else if (lastToken.getText().equals(CompletionTokens._comma)) {
        suggestions.add(CompletionTokens._composes);
        suggestions.add(CompletionTokens._derived);
        suggestions.add(CompletionTokens._ordered);
        suggestions.add(CompletionTokens._notOrdered);
        suggestions.add(CompletionTokens._unique);
        suggestions.add(CompletionTokens._notUnique);
        suggestions.add(CompletionTokens._resolve);
        suggestions.add(CompletionTokens._notResolve);
        suggestions.add(CompletionTokens._unsettable);
        suggestions.add(CompletionTokens._notUnsettable);
      } else if (lastToken.getText().equals(CompletionTokens._composes)
          || lastToken.getText().equals(CompletionTokens._derived)
          || lastToken.getText().equals(CompletionTokens._ordered)
          || lastToken.getText().equals(CompletionTokens._notOrdered)
          || lastToken.getText().equals(CompletionTokens._unique)
          || lastToken.getText().equals(CompletionTokens._notUnique)
          || lastToken.getText().equals(CompletionTokens._resolve)
          || lastToken.getText().equals(CompletionTokens._notResolve)
          || lastToken.getText().equals(CompletionTokens._unsettable)
          || lastToken.getText().equals(CompletionTokens._notUnsettable)) {
        suggestions.add(CompletionTokens._comma);
        suggestions.add(CompletionTokens._rightCurly);
      } else if (lastToken.getText().equals(CompletionTokens._rightCurly)
          || lastToken.getText().equals(CompletionTokens._semicolon)) {
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
