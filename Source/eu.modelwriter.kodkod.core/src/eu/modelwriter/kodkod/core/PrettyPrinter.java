package eu.modelwriter.kodkod.core;

import java.util.List;

import eu.modelwriter.kodkod.core.recognizer.KodkodBaseVisitor;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ArityContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.BitWidthContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.FormulaContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.OptionContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.OptionsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProblemContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SharingContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SkolemDepthContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.SymmetryBreakingContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleSetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;

public class PrettyPrinter extends KodkodBaseVisitor<String> {
  String problem = "";

  @Override
  public String visitArity(final ArityContext ctx) {
    return ctx != null ? ctx.getText() : "";
  }

  @Override
  public String visitAtom(final AtomContext ctx) {
    return ctx.IDENTIFIER() == null ? ctx.INT().getText() : ctx.IDENTIFIER().getText();
  }

  @Override
  public String visitOptions(final OptionsContext ctx) {
    String optionsString = "";
    final List<OptionContext> options = ctx.option();

    OptionContext optionContext = options.get(0);
    if (optionContext instanceof SymmetryBreakingContext) {
      optionsString += "\t" + "symmetry_breaking: "
          + ((SymmetryBreakingContext) optionContext).integer().getText();
    } else if (optionContext instanceof BitWidthContext) {
      optionsString += "\t" + "bit_width: " + ((BitWidthContext) optionContext).integer().getText();
    } else if (optionContext instanceof SkolemDepthContext) {
      optionsString +=
          "\t" + "skolem_depth: " + ((SkolemDepthContext) optionContext).integer().getText();
    } else if (optionContext instanceof SharingContext) {
      optionsString += "\t" + "sharing: " + ((SharingContext) optionContext).integer().getText();
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
    this.problem += "options{\n";
    this.problem += this.visitOptions(ctx.options());
    this.problem += "\n}\n\n";

    this.problem += "universe{\n";
    this.problem += this.visitUniverse(ctx.universe());
    this.problem += "\n}\n\n";

    this.problem += "relations{\n";
    for (final RelationsContext relation : ctx.relations()) {
      this.problem += this.visitRelations(relation) + "\n";
    }
    this.problem += "\n}\n\n";

    for (final FormulaContext formula : ctx.formula()) {
      this.problem += formula.getText() + "\n";
    }

    return this.problem;
  }

  @Override
  public String visitRelations(final RelationsContext ctx) {
    String relationsString = "";
    relationsString += "\t" + ctx.relation().getText();
    relationsString += " " + this.visitArity(ctx.arity()) + ": ";
    relationsString += ctx.expression() == null ? "" : ctx.expression().getText();
    relationsString += "[";

    final List<TupleSetContext> tupleSet = ctx.tupleSet();
    TupleSetContext tupleSetContext = tupleSet.get(0);
    relationsString += this.visitTupleSet(tupleSetContext);

    for (int i = 1; i < tupleSet.size(); i++) {
      tupleSetContext = tupleSet.get(i);
      relationsString += ",\n\t\t" + this.visitTupleSet(tupleSetContext);
    }
    relationsString += "]";
    return relationsString;
  }

  @Override
  public String visitTuple(final TupleContext ctx) {
    String tupleString = "";
    tupleString += "[";

    final List<AtomContext> atom = ctx.atom();
    final AtomContext atomContext = atom.get(0);
    tupleString += this.visitAtom(atomContext);

    for (int i = 0; i < atom.size(); i++) {
      tupleString += ", " + this.visitAtom(atomContext);
    }

    tupleString += "]";
    return tupleString;
  }

  @Override
  public String visitTupleSet(final TupleSetContext ctx) {
    String tupleSetString = "";
    tupleSetString += "{\n";

    final List<TupleContext> tuple = ctx.tuple();
    TupleContext tupleContext = tuple.get(0);
    tupleSetString += "\t\t" + this.visitTuple(tupleContext);

    for (int i = 1; i < tuple.size(); i++) {
      tupleContext = tuple.get(i);
      tupleSetString += ",\n\t\t" + this.visitTuple(tupleContext);
    }

    tupleSetString += "\n\t}";
    return tupleSetString;
  }

  @Override
  public String visitUniverse(final UniverseContext ctx) {
    String universeString = "";
    final List<AtomContext> atoms = ctx.atom();
    AtomContext atomContext = atoms.get(0);
    universeString += "\t" + this.visitAtom(atomContext);
    for (int i = 1; i < atoms.size(); i++) {
      atomContext = atoms.get(i);
      universeString += ", " + this.visitAtom(atomContext);
    }
    return universeString;
  }
}
