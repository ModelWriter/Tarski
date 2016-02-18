package eu.modelwriter.kodkod.core.printer;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import eu.modelwriter.kodkod.core.recognizer.KodkodBaseVisitor;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ArityContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.BitWidthContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.FormulaContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.IntegerContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.OptionContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.OptionsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProblemContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SharingContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SkolemDepthContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SymmetryBreakingContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleSetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.VariableContext;

public class PrettyPrinter extends KodkodBaseVisitor<String> {
  private String problem;

  @Override
  public String visitArity(final ArityContext ctx) {
    return ctx != null ? ctx.INT().getText() : "";
  }

  @Override
  public String visitAtom(final AtomContext ctx) {
    return ctx.IDENTIFIER() == null ? ctx.INT().getText() : ctx.IDENTIFIER().getText();
  }

  @Override
  public String visitChildren(final RuleNode arg0) {
    String visitString = "";
    for (int i = 0; i < arg0.getChildCount(); i++) {
      visitString += this.visit(arg0.getChild(i));
    }
    return visitString;
  }

  @Override
  public String visitInteger(final IntegerContext ctx) {
    return ctx != null ? ctx.INT().getText() : "";
  }

  @Override
  public String visitOptions(final OptionsContext ctx) {
    String optionsString = "";
    final List<OptionContext> options = ctx.option();
    OptionContext optionContext = options.get(0);
    if (optionContext != null) {
      if (optionContext instanceof SymmetryBreakingContext) {
        optionsString += "\t" + "symmetry_breaking: "
            + ((SymmetryBreakingContext) optionContext).integer().getText();
      } else if (optionContext instanceof BitWidthContext) {
        optionsString +=
            "\t" + "bit_width: " + ((BitWidthContext) optionContext).integer().getText();
      } else if (optionContext instanceof SkolemDepthContext) {
        optionsString +=
            "\t" + "skolem_depth: " + ((SkolemDepthContext) optionContext).integer().getText();
      } else if (optionContext instanceof SharingContext) {
        optionsString += "\t" + "sharing: " + ((SharingContext) optionContext).integer().getText();
      }
    }

    for (int i = 1; i < options.size(); i++) {
      optionContext = options.get(i);
      if (optionContext instanceof SymmetryBreakingContext) {
        optionsString += ",\n\t" + "symmetry_breaking: "
            + ((SymmetryBreakingContext) optionContext).integer().getText();
      } else if (optionContext instanceof BitWidthContext) {
        optionsString +=
            ",\n\t" + "bit_width: " + ((BitWidthContext) optionContext).integer().getText();
      } else if (optionContext instanceof SkolemDepthContext) {
        optionsString +=
            ",\n\t" + "skolem_depth: " + ((SkolemDepthContext) optionContext).integer().getText();
      } else if (optionContext instanceof SharingContext) {
        optionsString +=
            ",\n\t" + "sharing: " + ((SharingContext) optionContext).integer().getText();
      }
    }
    return optionsString;
  }

  @Override
  public String visitProblem(final ProblemContext ctx) {
    if (ctx.options() != null) {
      this.problem += "options {\n";
      this.problem += this.visitOptions(ctx.options());
      this.problem += "\n}\n\n";
    }

    this.problem += "universe {\n";
    if (ctx.universe() != null) {
      this.problem += this.visitUniverse(ctx.universe());
    }
    this.problem += "\n}\n\n";

    this.problem += "relations {\n";
    if (ctx.relations() != null) {
      for (final RelationsContext relation : ctx.relations()) {
        this.problem += this.visitRelations(relation) + "\n";
      }
    }
    this.problem += "}";

    if (ctx.formula() != null) {
      for (final FormulaContext formula : ctx.formula()) {
        this.problem += this.visit(formula) + "\n";
      }
    }
    return this.problem;
  }

  @Override
  public String visitRelation(final RelationContext ctx) {
    return ctx != null ? ctx.IDENTIFIER().getText() : "";
  }

  @Override
  public String visitRelations(final RelationsContext ctx) {
    String relationsString = "";
    relationsString += "\t" + ctx.relation().getText();
    relationsString += " " + this.visitArity(ctx.arity()) + ": ";
    relationsString += ctx.expression() == null ? "" : this.visit(ctx.expression());
    relationsString += "[";

    TupleSetContext lowerBoundTupleSet = ctx.tupleSet(0);
    if (lowerBoundTupleSet == null) {
      lowerBoundTupleSet = new TupleSetContext(ctx, ctx.invokingState);
      ctx.tupleSet().add(lowerBoundTupleSet);
    }
    relationsString += this.visitTupleSet(lowerBoundTupleSet);

    final TupleSetContext upperBoundTupleSet = ctx.tupleSet(1);
    if (upperBoundTupleSet != null) {
      relationsString += "," + this.visitTupleSet(upperBoundTupleSet);
    }

    relationsString += "]";
    return relationsString;
  }

  @Override
  public String visitTerminal(final TerminalNode node) {
    String nodeText = node == null ? "" : node.getText();
    switch (nodeText) {
      case "[":
      case "{":
      case "(":
      case "!":
      case "~":
      case "^":
      case "*":
      case ".":
      case "]":
      case "}":
      case ")":
        break;
      case ",":
      case ":":
      case "|":
        nodeText = nodeText + " ";
        break;
      case "#":
        nodeText = " " + nodeText;
        break;
      default:
        final ParseTree parent = node.getParent();
        for (int i = 0; i < parent.getChildCount(); i++) {
          final ParseTree child = parent.getChild(i);
          if (child.getText().equals(node.getText())) {
            if (parent.getChild(i + 1) instanceof TerminalNode) {
              nodeText = i == 0 ? "" + nodeText : " " + nodeText;
            } else {
              nodeText = i == 0 ? "" + nodeText + " " : " " + nodeText + " ";
            }
            break;
          }
        }
        break;
    }
    return nodeText;
  }

  @Override
  public String visitTuple(final TupleContext ctx) {
    String tupleString = "";
    tupleString += "[";

    AtomContext atomContext = ctx.atom(0);
    if (atomContext != null) {
      tupleString += this.visitAtom(atomContext);
    }

    for (int i = 1; i < ctx.atom().size(); i++) {
      atomContext = ctx.atom(i);
      tupleString += ", " + this.visitAtom(atomContext);
    }

    tupleString += "]";
    return tupleString;
  }

  @Override
  public String visitTupleSet(final TupleSetContext ctx) {
    String tupleSetString = "";
    tupleSetString += "{\n";

    TupleContext tupleContext = ctx.tuple(0);
    if (tupleContext != null) {
      tupleSetString += "\t\t" + this.visitTuple(tupleContext);
    }

    for (int i = 1; i < ctx.tuple().size(); i++) {
      tupleContext = ctx.tuple(i);
      tupleSetString += ",\n\t\t" + this.visitTuple(tupleContext);
    }

    tupleSetString += "\n\t}";
    return tupleSetString;
  }

  @Override
  public String visitUniverse(final UniverseContext ctx) {
    String universeString = "";
    AtomContext atomContext = ctx.atom(0);
    if (atomContext != null) {
      universeString += "\t" + this.visitAtom(atomContext);
    }
    for (int i = 1; i < ctx.atom().size(); i++) {
      atomContext = ctx.atom(i);
      universeString += ", " + this.visitAtom(atomContext);
    }
    return universeString;
  }

  @Override
  public String visitVariable(final VariableContext ctx) {
    return ctx != null ? ctx.IDENTIFIER().getText() : "";
  }
}
