package tmp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;

import javax.swing.JDialog;

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
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.Field;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.sim.SimInstance;
import edu.mit.csail.sdg.alloy4compiler.sim.SimTuple;
import edu.mit.csail.sdg.alloy4compiler.sim.SimTupleset;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.A4SolutionReader;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Tuple;
import edu.mit.csail.sdg.alloy4compiler.translator.A4TupleSet;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGUI;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import kodkod.engine.fol2sat.HigherOrderDeclException;

public class TestXml {

  private static final BooleanPref ImplicitThis = new BooleanPref("ImplicitThis");
  // static String filename = "C:\\Users\\3\\Desktop\\Alloyyy\\alloyXmlSample.xml";
  // C:\\Users\\Mete\\runtime-EclipseApplication\\.modelwriter\\persistance.xml
  static String filename =
      "C:\\Users\\Mete\\runtime-EclipseApplication\\.modelwriter\\persistence.xml";

  public static void showViz() {
    final String xmlFileName = Util.canon(filename);
    File f = new File(xmlFileName);
    AlloyInstance myInstance = null;
    try {
      if (!f.exists())
        throw new IOException("File " + xmlFileName + " does not exist.");
      myInstance = StaticInstanceReader.parseInstance(f);
    } catch (Err e1) {

      e1.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    VizState myState = null;

    myState = new VizState(myInstance);

    VizGraphPanel graph = new VizGraphPanel(myState, false);
    JDialog dialog = new JDialog();
    dialog.add(graph);
    dialog.setVisible(true);
    dialog.pack();

  }


  public static void main(String[] args) {

    // VizGUI gui = new VizGUI(false, filename, null);
    // gui.loadXML(filename, false);

    showViz();

    Computer evaluator = new Computer() {
      // private String filename = null;

      public final String compute(final Object input) throws Exception {
        // if (input instanceof File) {
        // filename = ((File) input).getAbsolutePath();
        // return "";
        // }
        if (!(input instanceof String))
          return "";
        final String str = (String) input;
        if (str.trim().length() == 0)
          return ""; // Empty line
        Module root = null;
        A4Solution ans = null;
        try {
          Map<String, String> fc = new LinkedHashMap<String, String>();
          XMLNode x = new XMLNode(new File(filename));
          if (!x.is("alloy"))
            throw new Exception();
          String mainname = null;
          for (XMLNode sub : x)
            if (sub.is("instance")) {
              mainname = sub.getAttribute("filename");
              break;
            }
          if (mainname == null)
            throw new Exception();
          for (XMLNode sub : x)
            if (sub.is("source")) {
              String name = sub.getAttribute("filename");
              String content = sub.getAttribute("content");
              fc.put(name, content);
            }
          root = CompUtil.parseEverything_fromFile(A4Reporter.NOP, fc, mainname,
              (Version.experimental && ImplicitThis.get()) ? 2 : 1);
          ans = A4SolutionReader.read(root.getAllReachableSigs(), x);
          for (ExprVar a : ans.getAllAtoms()) {
            root.addGlobal(a.label, a);
          }
          for (ExprVar a : ans.getAllSkolems()) {
            root.addGlobal(a.label, a);
          }
        } catch (Throwable ex) {
          throw new ErrorFatal("Failed to read or parse the XML file.");
        }
        try {
          Expr e = CompUtil.parseOneExpression_fromString(root, str);
          if ("yes".equals(System.getProperty("debug")) && Verbosity.get() == Verbosity.FULLDEBUG) {
            SimInstance simInst = convert(root, ans);
            return simInst.visitThis(e).toString() + (simInst.wasOverflow() ? " (OF)" : "");
          } else
            return ans.eval(e).toString();
        } catch (HigherOrderDeclException ex) {
          throw new ErrorType("Higher-order quantification is not allowed in the evaluator.");
        }
      }
    };

    VizGUI gui = new VizGUI(false, filename, null, null, evaluator);
    try {
      String str = evaluator.compute("eClassifiers");

      System.out.println(str);
    } catch (Exception e) {

      e.printStackTrace();
    }
  }

  private static SimTupleset convert(Object object) throws Err {
    if (!(object instanceof A4TupleSet))
      throw new ErrorFatal("Unexpected type error: expecting an A4TupleSet.");
    A4TupleSet s = (A4TupleSet) object;
    if (s.size() == 0)
      return SimTupleset.EMPTY;
    List<SimTuple> list = new ArrayList<SimTuple>(s.size());
    int arity = s.arity();
    for (A4Tuple t : s) {
      String[] array = new String[arity];
      for (int i = 0; i < t.arity(); i++)
        array[i] = t.atom(i);
      list.add(SimTuple.make(array));
    }
    return SimTupleset.make(list);
  }

  private static SimInstance convert(Module root, A4Solution ans) throws Err {
    SimInstance ct = new SimInstance(root, ans.getBitwidth(), ans.getMaxSeq());
    for (Sig s : ans.getAllReachableSigs()) {
      if (!s.builtin)
        ct.init(s, convert(ans.eval(s)));
      for (Field f : s.getFields())
        if (!f.defined)
          ct.init(f, convert(ans.eval(f)));
    }
    for (ExprVar a : ans.getAllAtoms())
      ct.init(a, convert(ans.eval(a)));
    for (ExprVar a : ans.getAllSkolems())
      ct.init(a, convert(ans.eval(a)));
    return ct;
  }

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
    public boolean geq(Verbosity other) {
      return ordinal() >= other.ordinal();
    }

    /** This is a unique String for this value; it should be kept consistent in future versions. */
    private final String id;
    /** This is the label that the toString() method will return. */
    private final String label;

    /** Constructs a new Verbosity value with the given id and label. */
    private Verbosity(String id, String label) {
      this.id = id;
      this.label = label;
    }

    /**
     * Given an id, return the enum value corresponding to it (if there's no match, then return
     * DEFAULT).
     */
    private static Verbosity parse(String id) {
      for (Verbosity vb : values())
        if (vb.id.equals(id))
          return vb;
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
      return parse(Preferences.userNodeForPackage(Util.class).get("Verbosity", ""));
    }
  };

}
