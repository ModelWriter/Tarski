package eu.modelwriter.specification.editor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

import eu.modelwriter.configuration.alloy.trace.LoadItem;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.specification.editor.scanner.MetaModelPartitionScanner;

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

  public static HashMap<String, Integer> getPartitionsLinesByType(IDocument document,
      String partitionType) {
    HashMap<String, Integer> lines = new HashMap<String, Integer>();
    final Scanner scanner = new Scanner(document.get());
    int lineNumber = 0;
    try {
      while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        final int offset = document.getLineOffset(lineNumber);
        if (document.getPartition(offset).getType().equals(partitionType)) {
          lines.put(line, lineNumber);
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

  public static HashMap<String, IRegion> getPartitionsInfoByType(IDocument document,
      String partitionType) {
    HashMap<String, IRegion> lines = new HashMap<String, IRegion>();
    final Scanner scanner = new Scanner(document.get());
    int lineNumber = 0;
    try {
      while (scanner.hasNextLine()) {
        final String line = scanner.nextLine();
        final int offset = document.getLineOffset(lineNumber);
        if (document.getPartition(offset).getType().equals(partitionType)) {
          lines.put(line, document.getLineInformation(lineNumber));
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

  public static List<LoadItem> getLoadsFromDoc(IDocument document)
      throws IOException, BadLocationException, IndexOutOfBoundsException, TraceException {
    List<LoadItem> loads = new ArrayList<>();
    HashMap<String, Integer> aliasLines =
        getPartitionsLinesByType(document, MetaModelPartitionScanner.META_MODEL_LOADALIAS);
    for (String alias : aliasLines.keySet()) {
      String modelPath = "/", instancePath = "/";
      int aliasOffset = aliasLines.get(alias);
      alias = alias.substring(alias.indexOf("@") + 1);
      for (int i = 1; i <= 2; i++) {
        IRegion lineInfo = document.getLineInformation(aliasOffset + i);
        String line = document.get(lineInfo.getOffset(), lineInfo.getLength());
        if (line.toLowerCase().contains("loadmodel@")) {
          modelPath = line.substring(line.indexOf("@") + 1);
        } else if (line.toLowerCase().contains("loadinstance@")) {
          instancePath = line.substring(line.indexOf("@") + 1);
        }
      }
      LoadItem load = new LoadItem(alias, modelPath, instancePath);
      loads.add(load);
    }
    return loads;
  }

}
