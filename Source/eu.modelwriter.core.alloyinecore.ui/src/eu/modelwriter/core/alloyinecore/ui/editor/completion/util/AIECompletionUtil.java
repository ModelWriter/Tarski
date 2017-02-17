package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreLexer;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.ModelContext;

public class AIECompletionUtil {
  private AlloyInEcoreLexer lexer;
  private CommonTokenStream tokens;
  private AlloyInEcoreParser parser;
  private int offset;

  private int minDistance = Integer.MAX_VALUE;
  private ParseTree closerNode = null;

  public List<String> getProposals(final IDocument document, final int offset)
      throws BadLocationException {
    this.offset = offset;
    lexer = new AlloyInEcoreLexer(new ANTLRInputStream(document.get(0, offset)));
    tokens = new CommonTokenStream(lexer);
    parser = new AlloyInEcoreParser(tokens);

    final ModelContext modelContext = parser.model();

    // TODO find context via AST. Only use AST. You will get true context and true location and then
    // you will be able to put suggestions according to this location.
    // If code below is not true, find true version in facebook message or mail box.

    findCloserNode(modelContext);

    if (closerNode == null) {
      closerNode = modelContext;
    }

    ParserRuleContext parentOfCloserNode = (ParserRuleContext) closerNode.getParent();
    if (closerNode instanceof TerminalNode) {
      // TODO find if closernode is end token of its parent. If you can't, create a class that
      // queries about closernode's parent ended or not?
      // TODO it means any context is closed, and here user wants to get completion
      // if (((TerminalNode) closerNode).getSymbol().equals(parentOfCloserNode.getStop())) {
      // closerNode = parentOfCloserNode;
      // parentOfCloserNode = parentOfCloserNode.getParent();
      // }
    } else if (closerNode instanceof ParserRuleContext) {
      if (parentOfCloserNode == null) {
        parentOfCloserNode = (ParserRuleContext) closerNode;
      }
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
          minDistance = distance;
          closerNode = root;
        }
      }
    }
  }
}
