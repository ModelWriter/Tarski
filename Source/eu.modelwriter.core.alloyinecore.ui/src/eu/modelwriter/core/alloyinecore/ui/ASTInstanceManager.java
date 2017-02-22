package eu.modelwriter.core.alloyinecore.ui;

import org.eclipse.emf.common.util.URI;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

public class ASTInstanceManager extends ASTManager {

  public ASTInstanceManager() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Element parseString(String text, URI uri) throws Exception {
    hasSyntaxError = false;
    AlloyInEcoreParser parser = createParser(text, uri);
    parser.instance(null);
    changeListeners.forEach(l -> l.onASTChange(parser.instance));
    return parser.instance;
  }
}
