package eu.modelwriter.configuration.alloy.trace;

import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

public final class LoadTraceUtils {

  public static IFile getIFileFromPath(String path) {
    final Path filePath = new Path(path);
    return ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
  }

  /**
   * Skips comment lines
   * 
   * @param scanner
   * @return comment free line
   */
  public static String getNextLine(Scanner scanner) {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line.startsWith("//"))
        continue; // Its single comment line, skip

      if (line.startsWith("/*")) { // multi line comment
        String skipLine = line;
        while (scanner.hasNextLine() && !skipLine.contains("*/")) { // skip until close tag
          skipLine = scanner.nextLine();
        }
        // in case there is data after comment close tag
        line = skipLine.substring(skipLine.indexOf("*/") + 2);
        if (line.isEmpty())
          continue;
      }
      return line;
    }
    return "";
  }

}
