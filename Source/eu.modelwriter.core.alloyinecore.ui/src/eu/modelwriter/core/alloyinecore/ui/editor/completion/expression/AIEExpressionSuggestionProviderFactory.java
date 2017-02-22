package eu.modelwriter.core.alloyinecore.ui.editor.completion.expression;

import java.util.ArrayList;
import java.util.List;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.provider.ClosureSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.provider.ExpressionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.provider.ReflexiveSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.expression.provider.TransposeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.util.AIESuggestionProvider;

public class AIEExpressionSuggestionProviderFactory {

  public AIESuggestionProvider expressionSP() {
    return new ExpressionSuggestionProvider();
  }

  public AIESuggestionProvider transposeSP() {
    return new TransposeSuggestionProvider();
  }

  public AIESuggestionProvider closureSP() {
    return new ClosureSuggestionProvider();
  }

  public AIESuggestionProvider reflexiveSP() {
    return new ReflexiveSuggestionProvider();
  }

  public List<AIESuggestionProvider> allSuggestionProviders() {
    final List<AIESuggestionProvider> all = new ArrayList<>();
    all.add(expressionSP());
    all.add(transposeSP());
    all.add(closureSP());
    all.add(reflexiveSP());
    return all;
  }
}
