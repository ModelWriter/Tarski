package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelContext;
import eu.modelwriter.core.alloyinecore.structure.base.Element;

public class AIECompletionUtil {
  private static IDocument document;
  private final int offset;

  private AlloyInEcoreLexer cuttedDocLexer;
  private CommonTokenStream cuttedDocTokens;
  private AlloyInEcoreParser cuttedDocParser;

  private int minDistance = Integer.MAX_VALUE;
  private ParseTree closerNode = null;

  public AIECompletionUtil(final IDocument document, final int offset) {
    AIECompletionUtil.document = document;
    this.offset = offset;
  }

  public List<String> getProposals() throws BadLocationException {
    cuttedDocLexer =
        new AlloyInEcoreLexer(new ANTLRInputStream(AIECompletionUtil.document.get(0, offset)));
    cuttedDocTokens = new CommonTokenStream(cuttedDocLexer);
    cuttedDocParser = new AlloyInEcoreParser(cuttedDocTokens);

    final ModelContext cuttedModelCtx = cuttedDocParser.model();

    // TODO find context via AST. Only use AST. You will get true context and true location and then
    // you will be able to put suggestions according to this location.
    // If code below is not true, find true version in facebook message or mail box.

    findCloserNode(cuttedModelCtx);

    if (closerNode == null) {
      closerNode = cuttedModelCtx;
    }

    final ParserRuleContext parentOfCloserNode = (ParserRuleContext) closerNode.getParent();
    if (closerNode instanceof TerminalNode) {
    } else if (closerNode instanceof ParserRuleContext) {
    }

    final SuggestionDetector suggestionDetector =
        new SuggestionDetector(AIECompletionUtil.document, offset, parentOfCloserNode, closerNode);
    final Set<String> detectedSuggestions = suggestionDetector.detect();
    final List<String> allProposals = new ArrayList<>();
    allProposals.addAll(detectedSuggestions);
    return allProposals;
  }

  private void findCloserNode(final ParseTree root) {
    if (root instanceof ParserRuleContext) {
      if (((ParserRuleContext) root).getStart().getStartIndex() <= offset) {
        final int distance = offset - ((ParserRuleContext) root).getStart().getStartIndex();
        if (distance <= minDistance
            && ((ParserRuleContext) root).getStart().getType() != Recognizer.EOF) {
          minDistance = distance;
          closerNode = root;
        }
        if (root.getChildCount() > 0) {
          final List<ParseTree> ownedElements = ((ParserRuleContext) root).children;
          for (int i = 0; i < ownedElements.size(); i++) {
            final ParseTree element = ownedElements.get(i);
            findCloserNode(element);
          }
        }
      }
    } else if (root instanceof TerminalNode) {
      if (((TerminalNode) root).getSymbol().getStartIndex() <= offset) {
        final int distance = offset - ((TerminalNode) root).getSymbol().getStartIndex();
        if (distance <= minDistance) {
          if (!(root instanceof ErrorNode
              && ((TerminalNode) root).getSymbol().getStopIndex() + 1 == offset)) {
            minDistance = distance;
            closerNode = root;
          }
        }
      }
    }
  }

  public static ParserRuleContext getFullContext(final ParserRuleContext cuttedCtx) {
    final AlloyInEcoreLexer lexer =
        new AlloyInEcoreLexer(new ANTLRInputStream(AIECompletionUtil.document.get()));
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final AlloyInEcoreParser parser = new AlloyInEcoreParser(tokens);

    final ModelContext modelContext = parser.model();

    return AIECompletionUtil.findFullContext(modelContext, cuttedCtx);
  }

  private static ParserRuleContext findFullContext(final ParserRuleContext fullCtx,
      final ParserRuleContext cuttedCtx) {
    if (fullCtx.getClass().equals(cuttedCtx.getClass())) {
      try {
        final Field currentElementFieldCuttedCtx =
            cuttedCtx.getClass().getField("current");
        final Field currentElementFieldFullCtx =
            fullCtx.getClass().getField("current");
        if (currentElementFieldCuttedCtx != null && currentElementFieldFullCtx != null) {
          @SuppressWarnings("rawtypes")
          final Element cuttedCtxElement =
          (Element) currentElementFieldCuttedCtx.get(cuttedCtx);
          @SuppressWarnings("rawtypes")
          final Element fullCtxElement =
          (Element) currentElementFieldFullCtx.get(fullCtx);
          if (cuttedCtxElement.getFullLocation().equals(fullCtxElement.getFullLocation())
              && cuttedCtxElement.getUniqueName().equals(fullCtxElement.getUniqueName())) {
            return fullCtx;
          }
        }
      } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
          | IllegalAccessException e) {
        e.printStackTrace();
      }
    } else {
      for (final ParseTree child : fullCtx.children) {
        if (child instanceof ParserRuleContext) {
          final ParserRuleContext context =
              AIECompletionUtil.findFullContext((ParserRuleContext) child, cuttedCtx);
          if (context != null) {
            return context;
          }
        }
      }
    }
    return null;
  }
}
