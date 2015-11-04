package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.model.Atom;
import eu.modelwriter.traceability.validation.core.fol.model.Relation;
import eu.modelwriter.traceability.validation.core.fol.model.Tuple;
import eu.modelwriter.traceability.validation.core.fol.model.Universe;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
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
  int i = 1;
  HashMap<String, String> quantOfIdent = new HashMap<String, String>();
  HashMap<String, String> constOfValue = new HashMap<String, String>();
  HashMap<String, Boolean> truthOfValue = new HashMap<String, Boolean>();

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
    ArrayList<String> ops = new ArrayList<String>();

    int identifierCount = 0;
    for (QuantifierContext quantifierContext : ctx.quantifier()) {
      String op = quantifierContext.op.getText().toLowerCase();
      ops.add(op);
      for (TerminalNode terminalNode : quantifierContext.IDENTIFIER()) {
        identifiers.add(terminalNode);
        identifierCount++;
        this.quantOfIdent.put(terminalNode.getText(), op);
        this.truthOfValue.put(terminalNode.getText(), false);
      }
    }

    boolean result = false;

    if (identifierCount == 1) {
      for (Atom atom : this.universe.getAtoms()) {
        this.constOfValue.put(identifiers.get(0).getText(), atom.getText());
        result = this.visit(ctx.expr());
        this.constOfValue.remove(identifiers.get(0).getText());
        int truth = 0;
        for (String op : ops) {
          if (op.equals("all") && !result) { // if result is false, all is not valid.
            truth--;
          } else if (op.equals("some") && result) { // if result is true, some is valid.
            truth++;
          } else if (op.equals("no") && result) { // if result is true, no is not valid.
            truth--;
          }
        }
      }
    } else if (identifierCount == 2) {
      for (Atom atom1 : this.universe.getAtoms()) {
        for (Atom atom2 : this.universe.getAtoms()) {
          this.constOfValue.put(identifiers.get(0).getText(), atom1.getText());
          this.constOfValue.put(identifiers.get(1).getText(), atom2.getText());
          result = this.visit(ctx.expr());
          this.constOfValue.remove(identifiers.get(1).getText());
          int truth = 0;
          for (String op : ops) {
            if (op.equals("all") && !result) { // if result is false, all is not valid.
              truth--;
            } else if (op.equals("some") && result) { // if result is true, some is valid.
              truth++;
            } else if (op.equals("no") && result) { // if result is true, no is not valid.
              truth--;
            }
          }
        }
        this.constOfValue.remove(identifiers.get(0).getText());
      }
    } else if (identifierCount == 3) {
      for (Atom atom1 : this.universe.getAtoms()) {
        for (Atom atom2 : this.universe.getAtoms()) {
          for (Atom atom3 : this.universe.getAtoms()) {
            this.constOfValue.put(identifiers.get(0).getText(), atom1.getText());
            this.constOfValue.put(identifiers.get(1).getText(), atom2.getText());
            this.constOfValue.put(identifiers.get(2).getText(), atom3.getText());
            result = this.visit(ctx.expr());
            this.constOfValue.remove(identifiers.get(2).getText());
            int truth = 0;
            for (String op : ops) {
              if (op.equals("all") && !result) { // if result is false, all is not valid.
                truth--;
              } else if (op.equals("some") && result) { // if result is true, some is valid.
                truth++;
              } else if (op.equals("no") && result) { // if result is true, no is not valid.
                truth--;
              }
            }
          }
          this.constOfValue.remove(identifiers.get(1).getText());
        }
        this.constOfValue.remove(identifiers.get(0).getText());
      }
    }
    return result;
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
        String constant = this.constOfValue.get(relIdents.get(i).getText());
        if (constant == null) { // some z | R(z,d);
          if (tuple.getAtom(i).getText().equals(relIdents.get(i).getText())) {
            truth++;
          }
        } else {
          if (tuple.getAtom(i).getText().equals(constant)) {
            truth++;
            this.truthOfValue.replace(relIdents.get(i).getText(), true);
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
    this.constOfValue = new HashMap<String, String>();
    this.truthOfValue = new HashMap<String, Boolean>();

    ExprContext expr = ctx.expr();

    boolean result = this.visit(expr);
    System.out.println(ctx.getText() + " = " + result + " " + this.i++);

    return result;
  }
}
