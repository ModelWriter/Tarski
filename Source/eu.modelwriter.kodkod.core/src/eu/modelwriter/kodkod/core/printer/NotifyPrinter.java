package eu.modelwriter.kodkod.core.printer;

import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import eu.modelwriter.kodkod.core.KodkodAnalyzer;
import eu.modelwriter.kodkod.core.recognizer.KodkodLexer;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.AtomContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.ProblemContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.RelationsContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.TupleSetContext;
import eu.modelwriter.kodkod.core.recognizer.KodkodParser.UniverseContext;

public class NotifyPrinter extends PrettyPrinter {
  enum PRINT_MODE {
    PRINT_MODEL, ADD_TUPLE, REMOVE_TUPLE, MOVE_TO_UPPER, MOVE_TO_LOWER;
    static String relationName = null;
    static List<String> tuple = null;
    static String bound = null;
  }

  String problem = "";
  PRINT_MODE CURRENT_MODE = PRINT_MODE.PRINT_MODEL;
  String currentRelationName;
  String currentBound;

  public String addTuple(final String relationName, final List<String> tuple, final String bound) {
    this.print(PRINT_MODE.ADD_TUPLE, relationName, tuple, bound);
    return this.problem;
  }

  KodkodParser getParser(final String kodkodString) {
    final ANTLRInputStream input = new ANTLRInputStream(kodkodString);
    final KodkodLexer lexer = new KodkodLexer(input);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    return new KodkodParser(tokens);
  }

  String getStandartTupleSetString(final List<TupleContext> tuples) {
    String tupleSetString = "";
    if (tuples.size() > 0) {
      TupleContext tupleContext = tuples.get(0);
      if (tupleContext != null) {
        tupleSetString += "\t\t" + this.visitTuple(tupleContext);
      }

      for (int i = 1; i < tuples.size(); i++) {
        tupleContext = tuples.get(i);
        tupleSetString += ",\n\t\t" + this.visitTuple(tupleContext);
      }
    }
    return tupleSetString;
  }

  String makeTupleString(final List<String> atoms) {
    String tupleString = "";
    tupleString += "[";

    final String atom = atoms.get(0);
    if (atom != null) {
      tupleString += atom;
    }

    for (int i = 1; i < atoms.size(); i++) {
      tupleString += ", " + atoms.get(i);
    }

    tupleString += "]";
    return tupleString;
  }

  public String moveToLower(final String relationName, final List<String> tuple) {
    this.print(PRINT_MODE.MOVE_TO_LOWER, relationName, tuple, null);
    return this.problem;
  }

  public String moveToUpper(final String relationName, final List<String> tuple) {
    this.print(PRINT_MODE.MOVE_TO_UPPER, relationName, tuple, null);
    return this.problem;
  }

  private void print(final PRINT_MODE MODE, final String relationName, final List<String> tuple,
      final String bound) {
    this.CURRENT_MODE = MODE;
    PRINT_MODE.relationName = relationName;
    PRINT_MODE.tuple = tuple;
    PRINT_MODE.bound = bound;
    this.visit(KodkodAnalyzer.problem);
  }

  public String removeTuple(final String relationName, final List<String> tuple,
      final String bound) {
    this.print(PRINT_MODE.REMOVE_TUPLE, relationName, tuple, bound);
    return this.problem;
  }

  List<TupleContext> removeTupleContextFromList(final List<TupleContext> tuples) {
    final Iterator<TupleContext> iterator = tuples.iterator();
    TupleContext tupleContext;

    while (iterator.hasNext()) {
      tupleContext = iterator.next();
      final List<AtomContext> atoms = tupleContext.atom();
      boolean trueTuple = true;
      for (int i = 0; i < atoms.size(); i++) {
        final AtomContext atomContext = atoms.get(i);
        final String atomContextString = atomContext.INT() == null
            ? atomContext.IDENTIFIER().getText() : atomContext.INT().getText();
        if (!atomContextString.equals(PRINT_MODE.tuple.get(i))) {
          trueTuple = false;
        }
      }
      if (trueTuple) {
        iterator.remove();
        break;
      }
    }
    return tuples;
  }

  @Override
  public String visitProblem(final ProblemContext ctx) {
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
    return this.problem;
  }

  @Override
  public String visitRelations(final RelationsContext ctx) {
    String relationsString = "";
    this.currentRelationName = ctx.relation().getText();
    relationsString += "\t" + this.currentRelationName;
    relationsString += " " + this.visitArity(ctx.arity()) + ": ";
    relationsString += ctx.expression() == null ? "" : this.visit(ctx.expression());
    relationsString += "[";

    this.currentBound = "lower";
    TupleSetContext lowerBoundTupleSet = ctx.tupleSet(0);
    if (lowerBoundTupleSet == null) {
      lowerBoundTupleSet = new TupleSetContext(ctx, ctx.invokingState);
      ctx.tupleSet().add(lowerBoundTupleSet);
    }
    relationsString += this.visitTupleSet(lowerBoundTupleSet);

    this.currentBound = "upper";
    TupleSetContext upperBoundTupleSet = ctx.tupleSet(1);
    if (upperBoundTupleSet == null && PRINT_MODE.relationName.equals(this.currentRelationName)) {
      switch (this.CURRENT_MODE) {
        case MOVE_TO_UPPER:
          upperBoundTupleSet = ctx.tupleSet(0);
          break;
        case ADD_TUPLE:
        case REMOVE_TUPLE:
          if (PRINT_MODE.bound.equals("upper")) {
            upperBoundTupleSet = ctx.tupleSet(0);
          }
          break;
        default:
          break;
      }
    }
    if (upperBoundTupleSet != null) {
      relationsString += "," + this.visitTupleSet(upperBoundTupleSet);
    }

    relationsString += "]";
    return relationsString;
  }

  @Override
  public String visitTupleSet(final TupleSetContext ctx) {
    String tupleSetString = "";
    tupleSetString += "{\n";

    List<TupleContext> tuples = ctx.tuple();

    boolean OK = false;
    switch (this.CURRENT_MODE) {
      case ADD_TUPLE:
        tupleSetString += this.getStandartTupleSetString(tuples);

        if (PRINT_MODE.relationName.equals(this.currentRelationName)) {
          final String tupleString = this.makeTupleString(PRINT_MODE.tuple);
          if (PRINT_MODE.bound.equals("lower")) {
            OK = true;
          } else if (this.currentBound.equals("upper")) {
            OK = true;
          }
          if (OK) {
            if (tuples.size() < 1) {
              tupleSetString += "\t\t" + tupleString;
            } else {
              tupleSetString += ",\n\t\t" + tupleString;
            }
          }
        }
        break;
      case REMOVE_TUPLE:
        if (PRINT_MODE.relationName.equals(this.currentRelationName)) {
          if (PRINT_MODE.bound.equals("lower")) {
            OK = true;
          } else if (this.currentBound.equals("upper")) {
            OK = true;
          }
          if (OK) {
            tuples = this.removeTupleContextFromList(tuples);
          }
        }
        tupleSetString += this.getStandartTupleSetString(tuples);
        break;
      case MOVE_TO_LOWER:
        tupleSetString += this.getStandartTupleSetString(tuples);
        if (PRINT_MODE.relationName.equals(this.currentRelationName)) {
          if (this.currentBound.equals("lower")) {
            final String tupleString = this.makeTupleString(PRINT_MODE.tuple);
            if (tuples.size() < 1) {
              tupleSetString += "\t\t" + tupleString;
            } else {
              tupleSetString += ",\n\t\t" + tupleString;
            }
          }
        }
        break;
      case MOVE_TO_UPPER:
        if (this.currentBound.equals("lower")) {
          if (PRINT_MODE.relationName.equals(this.currentRelationName)) {
            tuples = this.removeTupleContextFromList(tuples);
          }
          tupleSetString += this.getStandartTupleSetString(tuples);
        } else if (this.currentBound.equals("upper")) {
          tupleSetString += this.getStandartTupleSetString(tuples);
        }
        break;
      default:
        tupleSetString += this.getStandartTupleSetString(tuples);
        break;
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
    if (this.CURRENT_MODE == PRINT_MODE.ADD_TUPLE && PRINT_MODE.tuple.size() == 1) {
      if (ctx.atom().size() < 1) {
        universeString += "\t" + PRINT_MODE.tuple.get(0);
      } else {
        universeString += ", " + PRINT_MODE.tuple.get(0);
      }
    }
    return universeString;
  }
}
