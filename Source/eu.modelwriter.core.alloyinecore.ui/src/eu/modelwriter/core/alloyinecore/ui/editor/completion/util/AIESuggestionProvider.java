package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public interface AIESuggestionProvider {
  Set<String> getSuggestions(ParserRuleContext context, ParseTree lastToken);
}
