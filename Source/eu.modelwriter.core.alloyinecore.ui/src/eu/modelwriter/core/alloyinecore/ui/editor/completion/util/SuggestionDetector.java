package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.IDocument;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.AnnotationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.EClassSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.EClassifierSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.EDataTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.EEnumSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.EPackageSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.InvariantSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.ModelSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.OptionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.OptionsSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.conten.PackageImportSuggestionProvider;

public class SuggestionDetector {
  private final List<AIESuggestionProvider> suggestionProviders;

  private final IDocument document;
  private final int offset;
  private final ParserRuleContext parentOfCloserNode;
  private final ParseTree closerNode;

  public SuggestionDetector(final IDocument document, final int offset,
      final ParserRuleContext parentOfCloserNode, final ParseTree closerNode) {
    this.document = document;
    this.offset = offset;
    this.parentOfCloserNode = parentOfCloserNode;
    this.closerNode = closerNode;
    suggestionProviders = new ArrayList<>();
    initSuggestionProviders();
  }

  private void initSuggestionProviders() {
    suggestionProviders.add(new AnnotationSuggestionProvider());
    suggestionProviders.add(new EClassifierSuggestionProvider());
    suggestionProviders.add(new EClassSuggestionProvider());
    suggestionProviders.add(new EDataTypeSuggestionProvider());
    suggestionProviders.add(new EEnumSuggestionProvider());
    suggestionProviders.add(new EPackageSuggestionProvider());
    suggestionProviders.add(new InvariantSuggestionProvider());
    suggestionProviders.add(new ModelSuggestionProvider());
    suggestionProviders.add(new OptionsSuggestionProvider());
    suggestionProviders.add(new OptionSuggestionProvider());
    suggestionProviders.add(new PackageImportSuggestionProvider());
  }

  public Set<String> detect() {
    final Set<String> suggestions = new HashSet<>();
    for (final AIESuggestionProvider suggestionProvider : suggestionProviders) {
      suggestions.addAll(suggestionProvider.getSuggestions(parentOfCloserNode, closerNode));
    }
    return suggestions;
  }
}
