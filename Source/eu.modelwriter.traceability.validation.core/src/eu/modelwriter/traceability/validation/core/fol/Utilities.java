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

  /**
   * Cloning expression to create new same expression.
   */
  public static ExprContext cloneExprContext(final ExprContext expr) {

    final ExprContext clone = createContextType(expr);

    clone.copyFrom(expr);

    for (final ParseTree child : expr.children) {
      if (child instanceof TerminalNode) {
        clone.addChild(new TerminalNodeImpl(((TerminalNode) child).getSymbol()));
      } else if (child instanceof ExprContext) {
        final ExprContext cloneChild = cloneExprContext((ExprContext) child);
        clone.addChild(cloneChild);
        setLeftRight(clone, cloneChild);
      } else if (child instanceof Token) {
        clone.addChild(new CommonToken((Token) child));
      }
    }
    return clone;
  }

  /**
   * Creating conjunction expression.
   */
  public static ConjunctionContext createConjunctionContext(final ExprContext leftContext,
      final ExprContext rightContext) {

    final ConjunctionContext conjunctionContext = new ConjunctionContext(new ExprContext());
    final TerminalNodeImpl andNode = new TerminalNodeImpl(new CommonToken(10, "and"));

    // Setting context parents.
    leftContext.parent = conjunctionContext;
    andNode.parent = conjunctionContext;
    rightContext.parent = conjunctionContext;

    conjunctionContext.left = leftContext;
    conjunctionContext.right = rightContext;

    // Adding conjunction expression's children.
    conjunctionContext.addChild(leftContext);
    conjunctionContext.addChild(andNode);
    conjunctionContext.addChild(rightContext);

    return conjunctionContext;
  }

  /**
   * Creating expression based on type of expression.
   */
  public static ExprContext createContextType(final ExprContext expr) {

    if (expr instanceof DisjunctionContext) {
      return new DisjunctionContext(new ExprContext());
    } else if (expr instanceof ConjunctionContext) {
      return new ConjunctionContext(new ExprContext());
    } else if (expr instanceof ParenthesesContext) {
      return new ParenthesesContext(new ExprContext());
    } else if (expr instanceof QuantificationContext) {
      return new QuantificationContext(new ExprContext());
    } else if (expr instanceof NegationContext) {
      return new NegationContext(new ExprContext());
    } else if (expr instanceof RelationContext) {
      return new RelationContext(new ExprContext());
    }

    return null;
  }

  /**
   * Creating disjunction expression.
   */
  public static DisjunctionContext createDisjunctionContext(final ExprContext leftContext,
      final ExprContext rightContext) {

    final DisjunctionContext disjunctionContext = new DisjunctionContext(new ExprContext());
    final TerminalNodeImpl orNode = new TerminalNodeImpl(new CommonToken(12, "or"));

    // Setting context parents.
    leftContext.parent = disjunctionContext;
    rightContext.parent = disjunctionContext;
    orNode.parent = disjunctionContext;

    disjunctionContext.left = leftContext;
    disjunctionContext.right = rightContext;

    // Adding disjunction expression's children.
    disjunctionContext.addChild(leftContext);
    disjunctionContext.addChild(orNode);
    disjunctionContext.addChild(rightContext);

    return disjunctionContext;
  }

  /**
   * Creating negation expression.
   */
  public static NegationContext createNegationContext(final ExprContext expr) {

    final NegationContext negationContext = new NegationContext(new ExprContext());
    final TerminalNodeImpl notNode = new TerminalNodeImpl(new CommonToken(FOLParser.NOT, "not"));

    // Setting context parents.
    notNode.parent = negationContext;
    expr.parent = negationContext;

    // Adding negation expression's children.
    negationContext.addChild(notNode);
    negationContext.addChild(expr);

    return negationContext;
  }

  /**
   * Creating parentheses expression.
   */
  public static ParenthesesContext createParenthesesContext(final ExprContext expr) {

    final ParenthesesContext parenthesesContext = new ParenthesesContext(new ExprContext());
    final TerminalNodeImpl leftParenthes = new TerminalNodeImpl(new CommonToken(FOLParser.LP, "("));
    final TerminalNodeImpl rightParenthes =
        new TerminalNodeImpl(new CommonToken(FOLParser.RP, ")"));

    // Setting context parents.
    leftParenthes.parent = parenthesesContext;
    rightParenthes.parent = parenthesesContext;
    expr.parent = parenthesesContext;

    // Adding parentheses expression's children.
    parenthesesContext.addChild(leftParenthes);
    parenthesesContext.addChild(expr);
    parenthesesContext.addChild(rightParenthes);

    return parenthesesContext;
  }

  /**
   * Removing excess parentheses.
   */
  public static void moveUp(final ExprContext ctx, final ExprContext child) {
    RuleContext parent = new RuleContext();
    parent = ctx.parent;
    child.parent = parent;
    if (parent instanceof ExprContext) {
      final ExprContext expr = (ExprContext) parent;
      final int index = expr.children.indexOf(ctx);
      expr.children.remove(index);
      expr.children.add(index, child);
      setChild(expr, child, index);
    } else if (parent instanceof SentenceContext) {
      final SentenceContext sent = (SentenceContext) parent;
      final int index = sent.children.indexOf(ctx);
      sent.children.remove(index);
      sent.children.add(index, child);
    }
  }

  /**
   * Setting parentheses expression's left and right statements.
   */
  private static void setChild(final ExprContext parent, final ExprContext child, final int index) {
    if (parent instanceof DisjunctionContext) {
      if (index == 0) {
        ((DisjunctionContext) parent).left = child;
      } else {
        ((DisjunctionContext) parent).right = child;
      }
    } else if (parent instanceof ConjunctionContext) {
      if (index == 0) {
        ((ConjunctionContext) parent).left = child;
      } else {
        ((ConjunctionContext) parent).right = child;
      }
    } else if (parent instanceof QuantificationContext) {
      ((QuantificationContext) parent).scope = child;
    }
  }

  /**
   * Setting left and right statements of conjunction or disjunction expression.
   */
  private static void setLeftRight(final ExprContext clone, final ExprContext child) {
    if (clone instanceof ConjunctionContext) {
      final ConjunctionContext conjunctionContext = (ConjunctionContext) clone;
      if (conjunctionContext.left == null) {
        conjunctionContext.left = child;
      } else if (conjunctionContext.right == null) {
        conjunctionContext.right = child;
      }
    } else if (clone instanceof DisjunctionContext) {
      final DisjunctionContext disjunctionContext = (DisjunctionContext) clone;
      if (disjunctionContext.left == null) {
        disjunctionContext.left = child;
      } else if (disjunctionContext.right == null) {
        disjunctionContext.right = child;
      }
    }
  }

  public static void showParseTree(final FOLParser parser, final ParseTree t) {

    final JFrame frame = new JFrame("Antlr AST");

    final JScrollPane scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(0, 0, 500, 500);

    final TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), t);
    viewr.setScale(0.8); // scale a little
    scrollPane.getViewport().add(viewr);

    frame.add(scrollPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 500);
    frame.setVisible(true);
  }

}
