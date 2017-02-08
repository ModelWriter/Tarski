package eu.modelwriter.core.alloyinecore.ui.editor.instance.scanner;

import java.util.Set;

public interface KeywordListener {
  void onKeywordsCollected(Set<String> keywords, Set<String> sfKeywords);
}
