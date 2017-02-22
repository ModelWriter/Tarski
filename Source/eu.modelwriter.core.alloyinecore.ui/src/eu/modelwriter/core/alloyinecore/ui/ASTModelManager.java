package eu.modelwriter.core.alloyinecore.ui;

import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.eclipse.emf.common.util.URI;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.typechecking.TypeChecker;
import eu.modelwriter.core.alloyinecore.typechecking.TypeErrorListener;

public class ASTModelManager extends ASTManager {

  public ASTModelManager() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Element parseString(String text, URI uri) throws Exception {
    hasSyntaxError = false;
    AlloyInEcoreParser parser = createParser(text, uri);
    parser.model();
    changeListeners.forEach(l -> l.onASTChange(parser.model));
    if (!hasSyntaxError) {
      TypeChecker checker = new TypeChecker();
      checker.addErrorListener(new TypeErrorListener() {

        @Override
        public void onTypeWarning(String message, Set<Token> relatedElements) {
          errorListeners.forEach(l -> l.onTypeWarning(message, relatedElements));
        }

        @Override
        public void onTypeError(String message, Set<Token> relatedElements) {
          errorListeners.forEach(l -> l.onTypeError(message, relatedElements));
        }
      });
      checker.check(parser.model);
    }
    return parser.model;
  }
}
