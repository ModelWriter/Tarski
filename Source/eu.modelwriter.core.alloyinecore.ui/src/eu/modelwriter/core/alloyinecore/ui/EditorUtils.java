package eu.modelwriter.core.alloyinecore.ui;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.jface.text.IDocument;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.Element;
import eu.modelwriter.core.alloyinecore.structure.Module;

public final class EditorUtils {

  /**
   * Parses the given document's text.
   * 
   * @param document
   * @param errorListener
   * @return Parsed {@linkplain eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  public static Module parseDocument(IDocument document, BaseErrorListener errorListener)
      throws Exception {
    return parseString(document.get(), errorListener);
  }

  /**
   * Parses the given text.
   * 
   * @param text
   * @param errorListener
   * @return Parsed {@link eu.modelwriter.core.alloyinecore.structure.Module} object
   * @throws Exception
   */
  public static Module parseString(String text, BaseErrorListener errorListener) throws Exception {
    final AlloyInEcoreLexer lexer = new AlloyInEcoreLexer(new ANTLRInputStream(text));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(errorListener);
    parser.module();
    return parser.module;
  }

  /**
   * 
   * @param element Root element to start the search
   * @param line
   * @param offset
   * @return
   */
  @SuppressWarnings({"rawtypes"})
  public static Element findElement(Element element, int line, int offset) {
    for (Object object : element.getOwnedElements()) {
      if (inContext(((Element) object).getContext(), offset)) {
        return findElement((Element) object, line, offset);
      } else if (isInSameLine(((Element) object).getContext(), line)) {
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
  public static boolean inContext(ParserRuleContext context, int offset) {
    return context.start.getStartIndex() <= offset && (context.stop.getStopIndex() + 1) >= offset;
  }

  public static boolean isInSameLine(ParserRuleContext context, int line) {
    ParserRuleContext parent = context.getParent();
    // To get ride of wrappers
    parent = parent != null && (parent.start.getStartIndex() == context.start.getStartIndex())
        ? parent.getParent() : parent;
    // if its same line with context and
    // context is not same line with its parent, 'cus we need parent if same line
    return line >= context.start.getLine() && line <= context.stop.getLine()
        && (parent != null && parent.start.getLine() != context.start.getLine());
  }
}
