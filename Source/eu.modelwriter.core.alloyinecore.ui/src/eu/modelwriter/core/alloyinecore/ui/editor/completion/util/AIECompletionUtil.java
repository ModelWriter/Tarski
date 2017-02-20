package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

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

public class AIECompletionUtil {
  private AlloyInEcoreLexer lexer;
  private AlloyInEcoreLexer cuttedDocLexer;
  private CommonTokenStream tokens;
  private CommonTokenStream cuttedDocTokens;
  private AlloyInEcoreParser parser;
  private AlloyInEcoreParser cuttedDocParser;
  private int offset;

  private int minDistance = Integer.MAX_VALUE;
  private ParseTree closerNode = null;

  public List<String> getProposals(final IDocument document, final int offset)
      throws BadLocationException {
    this.offset = offset;

    cuttedDocLexer = new AlloyInEcoreLexer(new ANTLRInputStream(document.get(0, offset)));
    cuttedDocTokens = new CommonTokenStream(cuttedDocLexer);
    cuttedDocParser = new AlloyInEcoreParser(cuttedDocTokens);

    lexer = new AlloyInEcoreLexer(new ANTLRInputStream(document.get()));
    tokens = new CommonTokenStream(lexer);
    parser = new AlloyInEcoreParser(tokens);

    final ModelContext cuttedDocModelContext = cuttedDocParser.model();
    final ModelContext modelContext = parser.model();

    // TODO find context via AST. Only use AST. You will get true context and true location and then
    // you will be able to put suggestions according to this location.
    // If code below is not true, find true version in facebook message or mail box.

    findCloserNode(cuttedDocModelContext);

    if (closerNode == null) {
      closerNode = cuttedDocModelContext;
    }

    final ParserRuleContext parentOfCloserNode = (ParserRuleContext) closerNode.getParent();
    if (closerNode instanceof TerminalNode) {
    } else if (closerNode instanceof ParserRuleContext) {
    }

    final SuggestionDetector suggestionDetector =
        new SuggestionDetector(document, offset, parentOfCloserNode, closerNode);
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
}
