package eu.modelwriter.core.alloyinecore.ui;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

public abstract class ASTManager {

  protected Set<ASTChangeListener> changeListeners = new HashSet<>();
  protected Set<ASTErrorListener> errorListeners = new HashSet<>();
  protected boolean hasSyntaxError = false;

  public ASTManager() {}

  public void addChangeListener(ASTChangeListener listener) {
    changeListeners.add(listener);
  }

  public void removeChangeListener(ASTChangeListener listener) {
    changeListeners.remove(listener);
  }

  public void addErrorListener(ASTErrorListener listener) {
    errorListeners.add(listener);
  }

  public void removeErrorListener(ASTErrorListener listener) {
    errorListeners.remove(listener);
  }

  /**
   * Parses the given document's text.
   * 
   * @param document
   * @param errorListener
   * @return Parsed {@linkplain eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  @SuppressWarnings("rawtypes")
  public Element parseDocument(final IDocument document, final URI uri) throws Exception {
    return parseString(document.get(), uri);
  }

  /**
   * Parses the given text.
   * 
   * @param text
   * @param errorListener
   * @return Parsed {@link eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  @SuppressWarnings("rawtypes")
  public abstract Element parseString(final String text, final URI uri) throws Exception;

  public AlloyInEcoreParser createParser(final String text, final URI uri) {
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(text));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, uri);
    parser.removeErrorListeners();
    parser.addErrorListener(new BaseErrorListener() {

      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
          int charPositionInLine, String msg, RecognitionException e) {
        hasSyntaxError = true;
        errorListeners.forEach(l -> l.onSyntaxError((Token) offendingSymbol, msg));
      }
    });
    return parser;
  }
}
