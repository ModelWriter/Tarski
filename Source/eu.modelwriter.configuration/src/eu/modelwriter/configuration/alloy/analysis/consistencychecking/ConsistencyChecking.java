package eu.modelwriter.configuration.alloy.analysis.consistencychecking;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;

import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import eu.modelwriter.configuration.alloy.analysis.AlloySolutionFinder;

public class ConsistencyChecking {
  private static ConsistencyChecking instance;
  public static String baseFileDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation()
      + " .modelwriter validation ".replace(" ", System.getProperty("file.separator"));
  private static final String alsPath = ConsistencyChecking.baseFileDirectory + "validation.als";

  public static ConsistencyChecking getInstance() {
    if (ConsistencyChecking.instance == null) {
      ConsistencyChecking.instance = new ConsistencyChecking();
    }

    return ConsistencyChecking.instance;
  }

  public boolean check() {
    final File validationAls = new File(ConsistencyChecking.alsPath);
    if (validationAls.exists()) {
      validationAls.delete();
    }

    final InstanceTranslator4ConsistencyChecking instanceTranslator =
        new InstanceTranslator4ConsistencyChecking(ConsistencyChecking.baseFileDirectory,
            ConsistencyChecking.alsPath);
    instanceTranslator.translate();

    final AlloySolutionFinder parser = new AlloySolutionFinder(ConsistencyChecking.alsPath);
    final A4Solution solution = parser.find();
    if (solution == null || !solution.satisfiable()) {
      return false;
    }
    return true;
  }
}
