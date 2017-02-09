package eu.modelwriter.core.alloyinecore.ui.editor.util;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.model.Instance;
import eu.modelwriter.core.alloyinecore.structure.model.Model;

public final class EditorUtils {

  /**
   * Parses the given document's text.
   * 
   * @param document
   * @param errorListener
   * @return Parsed {@linkplain eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  public static Model parseDocument(final IDocument document, final URI uri,
      final BaseErrorListener errorListener) throws Exception {
    return EditorUtils.parseString(document.get(), uri, errorListener);
  }

  /**
   * Parses the given text.
   * 
   * @param text
   * @param errorListener
   * @return Parsed {@link eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  public static Model parseString(final String text, final URI uri,
      final BaseErrorListener errorListener) throws Exception {
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(text));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens, uri);
    parser.removeErrorListeners();
    parser.addErrorListener(errorListener);
    parser.model();
    return parser.model;
  }

  /**
   * 
   * @param element Root element to start the search
   * @param line
   * @param offset
   * @return
   */
  @SuppressWarnings({"rawtypes"})
  public static Element findElement(final Element element, final int line, final int offset) {
    for (final Object object : element.getOwnedElements()) {
      if (EditorUtils.inContext(((Element) object).getContext(), offset)) {
        return EditorUtils.findElement((Element) object, line, offset);
      } else if (EditorUtils.isInSameLine(((Element) object).getContext(), line)) {
        return (Element) object;
      }
    }
    return element;
  }

  /**
   * 
   * @param context
   * @param offset
   * @return if given offset is in given context, true; otherwise false
   */
  public static boolean inContext(final ParserRuleContext context, final int offset) {
    return context.start.getStartIndex() <= offset && context.stop.getStopIndex() + 1 >= offset;
  }

  public static boolean isInSameLine(final ParserRuleContext context, final int line) {
    ParserRuleContext parent = context.getParent();
    // To get ride of wrappers
    parent = parent != null && parent.start.getStartIndex() == context.start.getStartIndex()
        ? parent.getParent() : parent;
    // if its same line with context and
    // context is not same line with its parent, 'cus we need parent if same line
    return line >= context.start.getLine() && line <= context.stop.getLine() && parent != null
        && parent.start.getLine() != context.start.getLine();
  }

  public static Instance parseInstanceDocument(IDocument document, URI uri,
      BaseErrorListener baseErrorListener) {
    return EditorUtils.parseInstanceString(document.get(), uri, baseErrorListener);
  }

  private static Instance parseInstanceString(String text, URI uri,
      BaseErrorListener baseErrorListener) {
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(text));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(baseErrorListener);
    return parser.instance;
  }
}
