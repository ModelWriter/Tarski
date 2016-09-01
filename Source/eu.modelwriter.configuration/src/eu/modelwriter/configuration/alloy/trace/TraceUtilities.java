package eu.modelwriter.configuration.alloy.trace;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;

import eu.modelwriter.configuration.internal.EcoreUtilities;
import eu.modelwriter.configuration.internal.EditorUtilities;

public final class TraceUtilities {

  /**
   * Finds "-- loadModel@" tags and loads it with aliases
   * 
   * @param alloyPath
   * @throws TraceException
   */
  public static HashMap<String, EObject> getLoadedModels(String alloyFilePath)
      throws TraceException {
    final HashMap<String, EObject> alias2ModelRoot = new HashMap<>();

    List<String> lines = EditorUtilities.getPartitionsByRules(new File(alloyFilePath),
        "-- loadModel", "--loadModel");
    String line = "";
    String path = "";
    try {
      for (int x = 0; x < lines.size(); x++) {
        line = lines.get(x);
        path = line.substring(line.indexOf("@") + 1, line.indexOf(" as")).trim();
        String alias = line.substring(line.indexOf(" as") + 3).trim();
        EObject root = EcoreUtilities.getRootObject(path);
        if (root != null) {
          alias2ModelRoot.put(alias, root);
        }
      }
    } catch (IndexOutOfBoundsException e) {
      throw new TraceException("An error occured while parsing alloy file. \n Line: " + line);
    } catch (IOException e) {
      throw new TraceException("Can't load file from: " + path);
    }
    return alias2ModelRoot;
  }

  /**
   * 
   * @param alloyFilePath alloy file to parsed
   * @param partitionRules load partition rules e.g. "--loadInstance" or "-- loadModel"
   * @return loaded paths as IFile
   * @throws TraceException
   */
  public static HashMap<String, IFile> getLoadedPaths(String alloyFilePath,
      String... partitionRules) throws TraceException {
    final HashMap<String, IFile> alias2Path = new HashMap<>();

    List<String> lines =
        EditorUtilities.getPartitionsByRules(new File(alloyFilePath), partitionRules);
    String line = "";
    try {
      for (int x = 0; x < lines.size(); x++) {
        line = lines.get(x);
        final String path = line.substring(line.indexOf("@") + 1, line.indexOf(" as")).trim();
        final String alias = line.substring(line.indexOf(" as") + 3).trim();
        final IFile iFile = EditorUtilities.getIFileFromPath(path);
        if (iFile != null) {
          alias2Path.put(alias, iFile);
        }
      }
    } catch (IndexOutOfBoundsException e) {
      throw new TraceException("An error occured while parsing alloy file. \n Line: " + line);
    }
    return alias2Path;
  }

}
