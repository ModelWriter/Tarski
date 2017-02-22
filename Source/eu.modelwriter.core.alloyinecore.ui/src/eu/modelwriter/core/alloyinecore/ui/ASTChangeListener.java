package eu.modelwriter.core.alloyinecore.ui;

import eu.modelwriter.core.alloyinecore.structure.base.Element;

public interface ASTChangeListener {
  @SuppressWarnings("rawtypes")
  void onASTChange(Element element);

}
