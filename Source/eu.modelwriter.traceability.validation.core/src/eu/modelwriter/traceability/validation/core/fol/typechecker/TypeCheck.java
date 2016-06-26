package eu.modelwriter.traceability.validation.core.fol.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.traceability.validation.core.fol.ValidationError;
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

  HashMap<String, TerminalNode> varMap = new HashMap<>();

  private boolean errState;

  private final List<ValidationError> errors;

  public TypeCheck(final Universe universe) {
    this.universe = universe;
    this.setErrState(false);
    this.errors = new ArrayList<>();
  }

  public List<ValidationError> getErrors() {
    return this.errors;
  }

  public boolean isErrState() {
    return this.errState;
  }

  public void setErrState(final boolean errState) {
    this.errState = errState;
  }

  @Override
  public Object visitQuantification(final QuantificationContext ctx) {
    this.varMap = new HashMap<>();
    for (final TerminalNode identifier : ctx.quantifier().IDENTIFIER()) {
      this.varMap.put(identifier.getText(), identifier);
    }
    super.visitQuantification(ctx);
    final Iterator<Entry<String, TerminalNode>> iter = this.varMap.entrySet().iterator();
    while (iter.hasNext()) {
      final Map.Entry<String, TerminalNode> entry = iter.next();
      if (entry.getValue() != null) {
        final int offset = entry.getValue().getSymbol().getCharPositionInLine();
        final int line = entry.getValue().getSymbol().getLine();
        final String errorString = "Type check error:\nVariable " + entry.getKey()
            + " is never used!  " + "[Line:{" + line + "}, Position:{" + offset + "}]";
        this.errors.add(new ValidationError(line, offset, errorString));
        // System.err.println(errorString);
      }
    }
    return null;
  }

  @Override
  public Object visitQuantifier(final QuantifierContext ctx) {
    for (final TerminalNode identifier : ctx.IDENTIFIER()) {
      if (this.universe.contains(new Atom(identifier.getText()))) {
        final int offset = identifier.getSymbol().getCharPositionInLine();
        final int line = identifier.getSymbol().getLine();
        final String errorString = "Type check error:\nVariable " + identifier.getText()
            + " must be different from any atom in the model !  " + "[Line:{" + line
            + "}, Position:{" + offset + "}]";
        this.errors.add(new ValidationError(line, offset, errorString));
        // System.err.println(errorString);
        this.setErrState(true);
      }
    }
    return super.visitQuantifier(ctx);
  }

  @Override
  public Object visitRelation(final RelationContext ctx) {
    final Relation rel = this.universe.getRelation(ctx.RELATION_NAME().getText());
    String errorString = "";
    int offset = 0, line = 0;

    if (rel == null) {
      offset = ctx.start.getCharPositionInLine();
      line = ctx.start.getLine();
      errorString = "Type check error:\nUnknown relation " + ctx.RELATION_NAME().getText() + "! "
          + "[Line:{" + line + "}, Position:{" + offset + "}]";
      this.errors.add(new ValidationError(line, offset, errorString));
      // System.err.println(errorString);
      this.setErrState(true);
    }

    if (rel.getArity() != ctx.IDENTIFIER().size()) {
      errorString = "Type check error:\nArity Problem at Sentence. Check it! [Line:{" + line
          + "}, Position:{" + offset + "}]\n";
      this.errors.add(new ValidationError(line, offset, errorString));
      // System.err.println(errorString);
      this.setErrState(true);
    }

    final List<TerminalNode> identifiers = ctx.IDENTIFIER();

    for (final TerminalNode identifier : identifiers) {
      if (this.varMap.containsKey(identifier.getText())) {
        this.varMap.replace(identifier.getText(), null);
      } else if (!this.universe.contains(new Atom(identifier.getText()))) {
        offset = identifier.getSymbol().getCharPositionInLine();
        line = identifier.getSymbol().getLine();
        errorString = "Type check error:\nUnknown variable " + identifier.getText() + " !  "
            + "[Line:{" + line + "}, Position:{" + offset + "}]";
        this.errors.add(new ValidationError(line, offset, errorString));
        // System.err.println(errorString);
        this.setErrState(true);
      }
    }

    return null;
  }
}
