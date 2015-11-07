package eu.modelwriter.traceability.validation.core.fol.typechecker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.model.Atom;
import eu.modelwriter.traceability.validation.core.fol.model.Relation;
import eu.modelwriter.traceability.validation.core.fol.model.Universe;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLBaseVisitor;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.QuantificationContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.QuantifierContext;
import eu.modelwriter.traceability.validation.core.fol.recognizer.FOLParser.RelationContext;

@SuppressWarnings("rawtypes")
public class TypeCheck extends FOLBaseVisitor {
  Universe universe;
  HashMap<String, TerminalNode> varMap = new HashMap<String, TerminalNode>();
  private boolean errState;

  public TypeCheck(Universe universe) {
    this.universe = universe;
    this.setErrState(false);
  }

  public boolean isErrState() {
    return this.errState;
  }

  public void setErrState(boolean errState) {
    this.errState = errState;
  }

  @Override
  public Object visitQuantification(QuantificationContext ctx) {
    this.varMap = new HashMap<String, TerminalNode>();
    for (TerminalNode identifier : ctx.quantifier().IDENTIFIER()) {
      this.varMap.put(identifier.getText(), identifier);
    }
    super.visitQuantification(ctx);
    Iterator<Entry<String, TerminalNode>> iter = this.varMap.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, TerminalNode> entry = iter.next();
      if (entry.getValue() != null) {
        int offset = entry.getValue().getSymbol().getCharPositionInLine();
        int line = entry.getValue().getSymbol().getLine();
        String errorString = "Variable " + entry.getKey() + " is never used!  " + "[Line:{" + line
            + "}, Position:{" + offset + "}]";
        System.err.println(errorString);
      }
    }
    return null;
  }

  @Override
  public Object visitQuantifier(QuantifierContext ctx) {
    for (TerminalNode identifier : ctx.IDENTIFIER()) {
      if (this.universe.contains(new Atom(identifier.getText()))) {
        int offset = identifier.getSymbol().getCharPositionInLine();
        int line = identifier.getSymbol().getLine();
        String errorString =
            "Variable " + identifier.getText() + " must be different from any atom in the model !  "
                + "[Line:{" + line + "}, Position:{" + offset + "}]";
        System.err.println(errorString);
      }
    }
    return super.visitQuantifier(ctx);
  }

  @Override
  public Object visitRelation(RelationContext ctx) {
    Relation rel = this.universe.getRelation(ctx.RELATION_NAME().getText());
    String errorString = "";
    int offset, line;

    if (rel == null) {
      offset = ctx.start.getCharPositionInLine();
      line = ctx.start.getLine();
      errorString = "Unknown relation " + ctx.RELATION_NAME().getText() + "! " + "[Line:{" + line
          + "}, Position:{" + offset + "}]";
      System.err.println(errorString);
      this.setErrState(true);
    }

    List<TerminalNode> identifiers = ctx.IDENTIFIER();

    for (TerminalNode identifier : identifiers) {
      if (this.varMap.containsKey(identifier.getText())) {
        this.varMap.replace(identifier.getText(), null);
      } else if (!this.universe.contains(new Atom(identifier.getText()))) {
        offset = identifier.getSymbol().getCharPositionInLine();
        line = identifier.getSymbol().getLine();
        errorString = "Unknown variable " + identifier.getText() + " !  " + "[Line:{" + line
            + "}, Position:{" + offset + "}]";
        System.err.println(errorString);
        this.setErrState(true);
      }
    }

    return null;
  }
}
