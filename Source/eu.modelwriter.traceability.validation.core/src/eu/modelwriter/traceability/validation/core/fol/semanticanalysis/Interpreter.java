package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.model.Relation;
import eu.modelwriter.traceability.validation.core.fol.model.Tuple;
import eu.modelwriter.traceability.validation.core.fol.model.Universe;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLLexer;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ConjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.DisjunctionContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.ExprContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.NegationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.QuantificationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.QuantifierContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SentenceContext;

public class Interpreter extends FOLBaseVisitor<Boolean> {
  Universe universe;
  HashMap<String, String> quantOfIdent = new HashMap<String, String>();
  HashMap<String, String> constOfIdent = new HashMap<String, String>();

  public Interpreter(Universe universe) {
    this.universe = universe;
  }

  @Override
  public Boolean visitConjunction(ConjunctionContext ctx) {
    boolean leftResult = this.visit(ctx.left);
    boolean rightResult = this.visit(ctx.right);

    return leftResult && rightResult;
  }

  @Override
  public Boolean visitDisjunction(DisjunctionContext ctx) {
    boolean leftResult = this.visit(ctx.left);
    boolean rightResult = this.visit(ctx.right);

    return leftResult || rightResult;
  }

  @Override
  public Boolean visitNegation(NegationContext ctx) {
    boolean result = this.visit(ctx.expr());

    return !result;
  }

  @Override
  public Boolean visitQuantification(QuantificationContext ctx) {
    ArrayList<TerminalNode> identifiers = new ArrayList<TerminalNode>();
    String op = ctx.quantifier().op.getText().toLowerCase();
    int identSize = ctx.quantifier().IDENTIFIER().size();

    for (TerminalNode terminalNode : ctx.quantifier().IDENTIFIER()) {
      identifiers.add(terminalNode);
      this.quantOfIdent.put(terminalNode.getText(), op);
      this.constOfIdent.put(terminalNode.getText(), this.universe.getFirstAtomText());
    }

    boolean result = false;

    for (;;) {
      result = this.visit(ctx.expr());
      if (op.equals("all") && !result) { // if result is false, all is not valid.
        return false;
      } else if (op.equals("some") && result) { // if result is true, some is valid.
        return true;
      } else if (op.equals("no") && result) { // if result is true, no is not valid.
        return false;
      }
      Boolean nextConst =
          this.visit(ctx.quantifier().IDENTIFIER(identSize - 1)); /*
                                                                   * change const of last ident
                                                                   */
      if (!nextConst) { // if all combinations are tried
        if (op.equals("all")) {
          return true;
        } else if (op.equals("some")) {
          return false;
        } else if (op.equals("no")) {
          return true;
        }
      }
    }

  }

  @Override
  public Boolean visitRelation(RelationContext ctx) {
    String relationName = ctx.RELATION_NAME().getText();
    List<TerminalNode> relIdents = ctx.IDENTIFIER();

    Relation relation = this.universe.getRelation(relationName);

    if (relation == null) {
      // System.out.println("Relation is not found. " + this.i);
      return false;
    }

    int arity = relIdents.size();
    if (arity == 0 && relation.getTupleCount() == 0) {
      // System.out.println(relationName + " is an empty set. " + this.i);
      return false;
    }

    int truth = 0;
    for (Tuple tuple : relation.getTuples()) {
      truth = 0;
      for (int i = 0; i < arity; i++) {
        String constant = this.constOfIdent.get(relIdents.get(i).getText());
        if (constant == null) { // some z | R(z,d);
          if (tuple.getAtom(i).getText().equals(relIdents.get(i).getText())) {
            truth++;
          }
        } else {
          if (tuple.getAtom(i).getText().equals(constant)) {
            truth++;
          }
        }
      }
      if (truth == arity) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Boolean visitSentence(SentenceContext ctx) {
    this.quantOfIdent = new HashMap<String, String>();
    this.constOfIdent = new HashMap<String, String>();

    ExprContext expr = ctx.expr();

    boolean result = this.visit(expr);
    System.out.println(ctx.getText() + " = " + result);

    return result;
  }

  @Override
  public Boolean visitTerminal(TerminalNode node) {
    if (node.getSymbol().getType() == FOLLexer.IDENTIFIER
        && node.getParent() instanceof QuantifierContext) {
      QuantifierContext parent = (QuantifierContext) node.getParent();
      String currentConst = this.constOfIdent.get(node.getText());
      String nextConst = this.universe.getNextAtomText(currentConst);

      if (nextConst == null) { // if last const
        nextConst = this.universe.getFirstAtomText();
        this.constOfIdent.replace(node.getText(), nextConst);
        for (int i = 1; i < parent.IDENTIFIER().size(); i++) { // if node is not only identifier of
                                                               // parent
          if (parent.IDENTIFIER(i).getText().equals(node.getText())) {
            this.visit(parent.IDENTIFIER(i - 1)); //
            return true;
          }
        }
        return false; // if node is only identifier of parent
      }
      this.constOfIdent.replace(node.getText(), nextConst); // if not last const
    }
    return true;
  }
}
