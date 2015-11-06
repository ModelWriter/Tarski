package eu.modelwriter.traceability.validation.core.fol;

import java.awt.Toolkit;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ParenthesesContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.QuantificationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SentenceContext;

public class Utilities {

  public static NegationContext createNegationContext(ExprContext expr) {
    NegationContext negationContext = new NegationContext(new ExprContext());
    TerminalNodeImpl notNode = new TerminalNodeImpl(new CommonToken(FOLParser.NOT, "not"));

    notNode.parent = negationContext;
    expr.parent = negationContext;

    negationContext.addChild(notNode);
    negationContext.addChild(expr);

    return negationContext;
  }

  public static ParenthesesContext createParenthesesContext(ExprContext expr) {
    ParenthesesContext parenthesesContext = new ParenthesesContext(new ExprContext());
    TerminalNodeImpl leftParenthes = new TerminalNodeImpl(new CommonToken(FOLParser.LP, "("));
    TerminalNodeImpl rightParenthes = new TerminalNodeImpl(new CommonToken(FOLParser.RP, ")"));

    leftParenthes.parent = parenthesesContext;
    rightParenthes.parent = parenthesesContext;
    expr.parent = parenthesesContext;

    parenthesesContext.addChild(leftParenthes);
    parenthesesContext.addChild(expr);
    parenthesesContext.addChild(rightParenthes);

    return parenthesesContext;
  }

  public static DisjunctionContext createDisjunctionContext(ExprContext leftContext,
      ExprContext rightContext) {
    DisjunctionContext disjunctionContext = new DisjunctionContext(new ExprContext());
    TerminalNodeImpl orNode = new TerminalNodeImpl(new CommonToken(12, "or"));

    leftContext.parent = disjunctionContext;
    rightContext.parent = disjunctionContext;
    orNode.parent = disjunctionContext;

    disjunctionContext.left = leftContext;
    disjunctionContext.right = rightContext;

    disjunctionContext.addChild(leftContext);
    disjunctionContext.addChild(orNode);
    disjunctionContext.addChild(rightContext);

    return disjunctionContext;
  }

  public static ConjunctionContext createConjunctionContext(ExprContext leftContext,
      ExprContext rightContext) {
    ConjunctionContext conjunctionContext = new ConjunctionContext(new ExprContext());
    TerminalNodeImpl andNode = new TerminalNodeImpl(new CommonToken(10, "and"));

    leftContext.parent = conjunctionContext;
    andNode.parent = conjunctionContext;
    rightContext.parent = conjunctionContext;

    conjunctionContext.left = leftContext;
    conjunctionContext.right = rightContext;

    conjunctionContext.addChild(leftContext);
    conjunctionContext.addChild(andNode);
    conjunctionContext.addChild(rightContext);

    return conjunctionContext;
  }

  public static void moveUp(ExprContext ctx, ExprContext child) {
    RuleContext parent = new RuleContext();
    parent = ctx.parent;
    child.parent = parent;
    if (parent instanceof ExprContext) {
      ExprContext expr = (ExprContext) parent;
      int index = expr.children.indexOf(ctx);
      expr.children.remove(index);
      expr.children.add(index, child);
      setChild(expr, child, index);
    } else if (parent instanceof SentenceContext) {
      SentenceContext sent = (SentenceContext) parent;
      int index = sent.children.indexOf(ctx);
      sent.children.remove(index);
      sent.children.add(index, child);
    }
  }

  private static void setChild(ExprContext parent, ExprContext child, int index) {
    if (parent instanceof DisjunctionContext) {
      if (index == 0)
        ((DisjunctionContext) parent).left = child;
      else
        ((DisjunctionContext) parent).right = child;
    } else if (parent instanceof ConjunctionContext) {
      if (index == 0)
        ((ConjunctionContext) parent).left = child;
      else
        ((ConjunctionContext) parent).right = child;
    } else if (parent instanceof QuantificationContext) {
      ((QuantificationContext) parent).scope = child;
    }
  }

  public static ExprContext cloneExprContext(ExprContext expr) {
    ExprContext clone = createContextType(expr);

    clone.copyFrom(expr);
    expr.children.size();

    for (ParseTree child : expr.children) {
      if (child instanceof TerminalNode) {
        clone.addChild(new TerminalNodeImpl((((TerminalNode) child).getSymbol())));
      } else if (child instanceof ExprContext) {
        clone.addChild(cloneExprContext((ExprContext) child));
      } else if (child instanceof Token) {
        clone.addChild(new CommonToken((Token) child));
      }
    }
    return clone;
  }

  public static ExprContext createContextType(ExprContext expr) {

    if (expr instanceof DisjunctionContext)
      return new DisjunctionContext(new ExprContext());
    else if (expr instanceof ConjunctionContext)
      return new ConjunctionContext(new ExprContext());
    else if (expr instanceof ParenthesesContext)
      return new ConjunctionContext(new ExprContext());
    else if (expr instanceof QuantificationContext)
      return new QuantificationContext(new ExprContext());
    else if (expr instanceof NegationContext)
      return new NegationContext(new ExprContext());
    else if (expr instanceof RelationContext)
      return new RelationContext(new ExprContext());

    return null;
  }

  public static void showParseTree(FOLParser parser, ParseTree t) {
    // // show AST in GUI
    JFrame frame = new JFrame("Antlr AST");

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(0, 0, 500, 500);

    TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), t);
    viewr.setScale(0.8); // scale a little
    scrollPane.getViewport().add(viewr);

    frame.add(scrollPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 500);
    frame.setVisible(true);
  }

}
