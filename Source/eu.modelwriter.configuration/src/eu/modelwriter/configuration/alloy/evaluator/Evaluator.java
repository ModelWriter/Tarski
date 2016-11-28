package eu.modelwriter.configuration.alloy.evaluator;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Computer;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorFatal;
import edu.mit.csail.sdg.alloy4.ErrorType;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4.Util.BooleanPref;
import edu.mit.csail.sdg.alloy4.Version;
import edu.mit.csail.sdg.alloy4.XMLNode;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.sim.SimInstance;
import edu.mit.csail.sdg.alloy4compiler.sim.SimTuple;
import edu.mit.csail.sdg.alloy4compiler.sim.SimTupleset;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.A4SolutionReader;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Tuple;
import edu.mit.csail.sdg.alloy4compiler.translator.A4TupleSet;
import kodkod.engine.fol2sat.HigherOrderDeclException;

public class Evaluator implements Computer {
  private String filename = null;
  /** True if Alloy Analyzer should enable the new Implicit This name resolution. */
  private static final BooleanPref ImplicitThis = new BooleanPref("ImplicitThis");

  /** This enum defines the set of possible message verbosity levels. */
  private enum Verbosity {
    /** Level 0. */
    DEFAULT("0", "low"),
    /** Level 1. */
    VERBOSE("1", "medium"),
    /** Level 2. */
    DEBUG("2", "high"),
    /** Level 3. */
    FULLDEBUG("3", "debug only");
    /** Returns true if it is greater than or equal to "other". */
    public boolean geq(final Verbosity other) {
      return ordinal() >= other.ordinal();
    }

    /** This is a unique String for this value; it should be kept consistent in future versions. */
    private final String id;
    /** This is the label that the toString() method will return. */
    private final String label;

    /** Constructs a new Verbosity value with the given id and label. */
    private Verbosity(final String id, final String label) {
      this.id = id;
      this.label = label;
    }

    /**
     * Given an id, return the enum value corresponding to it (if there's no match, then return
     * DEFAULT).
     */
    private static Verbosity parse(final String id) {
      for (final Verbosity vb : Verbosity.values()) {
        if (vb.id.equals(id)) {
          return vb;
        }
      }
      return DEFAULT;
    }

    /** Returns the human-readable label for this enum value. */
    @Override
    public final String toString() {
      return label;
    }

    /** Saves this value into the Java preference object. */
    private void set() {
      Preferences.userNodeForPackage(Util.class).put("Verbosity", id);
    }

    /**
     * Reads the current value of the Java preference object (if it's not set, then return DEFAULT).
     */
    private static Verbosity get() {
      return Verbosity.parse(Preferences.userNodeForPackage(Util.class).get("Verbosity", ""));
    }
  };

  @Override
  public final String compute(final Object input) throws Exception {
    if (input instanceof File) {
      filename = ((File) input).getAbsolutePath();
      return "";
    }
    if (!(input instanceof String)) {
      return "";
    }
    final String str = (String) input;
    if (str.trim().length() == 0) {
      return ""; // Empty line
    }
    Module root = null;
    A4Solution ans = null;
    try {
      final Map<String, String> fc = new LinkedHashMap<>();
      final XMLNode x = new XMLNode(new File(filename));
      if (!x.is("alloy")) {
        throw new Exception();
      }
      String mainname = null;
      for (final XMLNode sub : x) {
        if (sub.is("instance")) {
          mainname = sub.getAttribute("filename");
          break;
        }
      }
      if (mainname == null) {
        throw new Exception();
      }
      for (final XMLNode sub : x) {
        if (sub.is("source")) {
          final String name = sub.getAttribute("filename");
          final String content = sub.getAttribute("content");
          fc.put(name, content);
        }
      }
      root = CompUtil.parseEverything_fromFile(A4Reporter.NOP, fc, mainname,
          Version.experimental && Evaluator.ImplicitThis.get() ? 2 : 1);
      ans = A4SolutionReader.read(root.getAllReachableSigs(), x);
      for (final ExprVar a : ans.getAllAtoms()) {
        root.addGlobal(a.label, a);
      }
      for (final ExprVar a : ans.getAllSkolems()) {
        root.addGlobal(a.label, a);
      }
    } catch (final Throwable ex) {
      throw new ErrorFatal("Failed to read or parse the XML file.");
    }
    try {
      final Expr e = CompUtil.parseOneExpression_fromString(root, str);
      if ("yes".equals(System.getProperty("debug")) && Verbosity.get() == Verbosity.FULLDEBUG) {
        final SimInstance simInst = Evaluator.convert(root, ans);
        return simInst.visitThis(e).toString() + (simInst.wasOverflow() ? " (OF)" : "");
      } else {
        return ans.eval(e).toString();
      }
    } catch (final HigherOrderDeclException ex) {
      throw new ErrorType("Higher-order quantification is not allowed in the evaluator.");
    }
  }

  /** Converts an A4Solution into a SimInstance object. */
  private static SimInstance convert(final Module root, final A4Solution ans) throws Err {
    final SimInstance ct = new SimInstance(root, ans.getBitwidth(), ans.getMaxSeq());
    for (final Sig s : ans.getAllReachableSigs()) {
      if (!s.builtin) {
        ct.init(s, Evaluator.convert(ans.eval(s)));
      }
      for (final edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field f : s.getFields()) {
        if (!f.defined) {
          ct.init(f, Evaluator.convert(ans.eval(f)));
        }
      }
    }
    for (final ExprVar a : ans.getAllAtoms()) {
      ct.init(a, Evaluator.convert(ans.eval(a)));
    }
    for (final ExprVar a : ans.getAllSkolems()) {
      ct.init(a, Evaluator.convert(ans.eval(a)));
    }
    return ct;
  }

  /** Converts an A4TupleSet into a SimTupleset object. */
  private static SimTupleset convert(final Object object) throws Err {
    if (!(object instanceof A4TupleSet)) {
      throw new ErrorFatal("Unexpected type error: expecting an A4TupleSet.");
    }
    final A4TupleSet s = (A4TupleSet) object;
    if (s.size() == 0) {
      return SimTupleset.EMPTY;
    }
    final List<SimTuple> list = new ArrayList<>(s.size());
    final int arity = s.arity();
    for (final A4Tuple t : s) {
      final String[] array = new String[arity];
      for (int i = 0; i < t.arity(); i++) {
        array[i] = t.atom(i);
      }
      list.add(SimTuple.make(array));
    }
    return SimTupleset.make(list);
  }
}
