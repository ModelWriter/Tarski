package eu.modelwriter.configuration.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

public class EditorUtilities {

  public static List<String> getPartitionsByType(IDocument document, String partitionType) {
    List<String> lines = new ArrayList<String>();
    final Scanner scanner = new Scanner(document.get());
    int lineNumber = 0;
    try {
      while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        final int offset = document.getLineOffset(lineNumber);
        if (document.getPartition(offset).getType().equals(partitionType)) {
          lines.add(line);
        }
        lineNumber++;
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null)
        scanner.close();
    }
    return lines;
  }

  public static HashMap<String, IRegion> getPartitionInfoByType(IDocument document,
      String partitionType) {
    HashMap<String, IRegion> lines = new HashMap<String, IRegion>();
    final Scanner scanner = new Scanner(document.get());
    int lineNumber = 0;
    try {
      while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        final int offset = document.getLineOffset(lineNumber);
        if (document.getPartition(offset).getType().equals(partitionType)) {
          lines.put(line, new Region(offset, line.length()));
        }
        lineNumber++;
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null)
        scanner.close();
    }

    return lines;
  }

  public static List<String> getPartitionsByRules(File file, String... partitionStrings) {
    List<String> lines = new ArrayList<String>();
    Scanner scanner = null;
    try {
      scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        if (line.trim().startsWith("//") || line.trim().startsWith("/*"))
          continue;
        for (String partition : partitionStrings) {
          if (line.toLowerCase().contains(partition.toLowerCase())) {
            lines.add(line);
            break;
          }
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null)
        scanner.close();
    }
    return lines;
  }

  public static IFile getIFileFromPath(String path) {
    final Path filePath = new Path(path);
    return ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
  }

  public static String getLineByOffset(IDocument document, int offset) {
    final Scanner scanner = new Scanner(document.get());
    int lineNumber = 0;
    try {
      while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        if (lineNumber == document.getLineOfOffset(offset)) {
          return line;
        }
        lineNumber++;
      }
    } catch (BadLocationException e) {
      e.printStackTrace();
    } finally {
      if (scanner != null)
        scanner.close();
    }
    return "";
  }

}
