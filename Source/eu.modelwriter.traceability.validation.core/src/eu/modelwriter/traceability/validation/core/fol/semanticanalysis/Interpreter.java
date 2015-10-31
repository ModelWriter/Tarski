package eu.modelwriter.traceability.validation.core.fol.semanticanalysis;

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
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.SentenceContext;

public class Interpreter extends FOLBaseVisitor<Boolean> {
  Universe universe;
  int i = 0;
  HashMap<String, String> quantOfIdent = new HashMap<String, String>();

  public Interpreter(Universe universe) {
    this.universe = universe;
  }

  @Override
  public Boolean visitConjunction(ConjunctionContext ctx) {
    ExprContext leftContext = ctx.left;
    ExprContext rightContext = ctx.right;

    boolean leftResult = this.visit(leftContext);
    boolean rightResult = this.visit(rightContext);

    return leftResult && rightResult;
  }

  @Override
  public Boolean visitDisjunction(DisjunctionContext ctx) {
    ExprContext leftContext = ctx.left;
    ExprContext rightContext = ctx.right;

    boolean leftResult = this.visit(leftContext);
    boolean rightResult = this.visit(rightContext);

    return leftResult || rightResult;
  }

  @Override
  public Boolean visitNegation(NegationContext ctx) {
    ExprContext expr = ctx.expr();
    boolean result = this.visit(expr);

    return !result;
  }

  @Override
  public Boolean visitQuantification(QuantificationContext ctx) {
    List<TerminalNode> identifiers = ctx.quantifer().IDENTIFIER();
    String op = ctx.quantifer().op.getText().toLowerCase();
    for (TerminalNode terminalNode : identifiers) {
      this.quantOfIdent.put(terminalNode.getText(), op);
    }
    return this.visit(ctx.expr());
  }

  @Override
  public Boolean visitRelation(RelationContext ctx) {
    String relationName = ctx.RELATION_NAME().getText();
    List<TerminalNode> relIdents = ctx.IDENTIFIER();

    Relation relation = this.universe.getRelation(relationName);

    if (relation == null) {
      System.out.println("Relation is not found. " + this.i);
      return false;
    }
    if (this.quantOfIdent.get(relIdents.get(0).getText()) != null
        && relation.getTupleCount() == 0) {
      System.out.println(relationName + " is an empty set. " + this.i);
      return false;
    }
    int arity = relIdents.size();

    int truth = 0;
    int result = 0;

    try {
      if (arity == 1) {
        for (Atom atom : this.universe.getAtoms()) {
          for (Tuple tuple : relation.getTuples()) {
            if (tuple.getAtom(1).getText().equals(atom.getText())) {
              truth++;
            }
          }
        }
      } else if (arity == 2) {
        for (Atom atom1 : this.universe.getAtoms()) {
          for (Atom atom2 : this.universe.getAtoms()) {
            if (!atom1.getText().equals(atom2.getText())) {
              for (Tuple tuple : relation.getTuples()) {
                if (tuple.getAtom(1).getText().equals(atom1.getText())
                    && tuple.getAtom(2).getText().equals(atom2.getText())) {
                  truth++;
                }
              }
            }
          }
        }
      } else if (arity == 3) {
        for (Atom atom1 : this.universe.getAtoms()) {
          for (Atom atom2 : this.universe.getAtoms()) {
            for (Atom atom3 : this.universe.getAtoms()) {
              if (!atom1.getText().equals(atom2.getText())
                  && !atom1.getText().equals(atom3.getText())
                  && !atom2.getText().equals(atom3.getText())) {
                for (Tuple tuple : relation.getTuples()) {
                  if (tuple.getAtom(1).getText().equals(atom1.getText())
                      && tuple.getAtom(2).getText().equals(atom2.getText())
                      && tuple.getAtom(3).getText().equals(atom3.getText())) {
                    truth++;
                  }
                }
              }
            }
          }
        }
      }
      for (int i = 0; i < arity; i++) {
        if (this.quantOfIdent.get(relIdents.get(i).getText()) != null
            && this.quantOfIdent.get(relIdents.get(i).getText()).equals("all")
            && truth == this.universe.getAtoms().size()) {
          result++;
        } else if (this.quantOfIdent.get(relIdents.get(i).getText()) != null
            && this.quantOfIdent.get(relIdents.get(i).getText()).equals("some") && truth >= 1) {
          result++;
        } else if (this.quantOfIdent.get(relIdents.get(i).getText()) != null
            && this.quantOfIdent.get(relIdents.get(i).getText()).equals("no") && truth == 0) {
          result++;
        }
      }
      if (this.quantOfIdent.get(relIdents.get(0).getText()) == null) {
        arity = 0;
      }
      if (result == arity) { // arity is 0 ? empty set is not defined.
        return true;
      }
    } catch (IndexOutOfBoundsException | NullPointerException e) {
      // TODO: handle exception
      int i = 0;
      i++;
      e.printStackTrace();
    }
    return false;
  }

  @Override
  public Boolean visitSentence(SentenceContext ctx) {
    this.quantOfIdent = new HashMap<String, String>();

    ExprContext expr = ctx.expr();

    boolean result = this.visit(expr);
    System.out.println(result + " " + this.i++);

    return result;
  }
}
