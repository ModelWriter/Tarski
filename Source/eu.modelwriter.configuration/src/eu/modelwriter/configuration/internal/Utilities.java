package eu.modelwriter.configuration.internal;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.configuration.Activator;

public class Utilities {

  public static final String FILE_SEPERATOR = System.getProperty("file.separator");

  public static boolean appendToFile(final String filePath, final String textToAppend) {
    try (FileWriter fw = new FileWriter(filePath, true)) {
      fw.write(textToAppend);
      fw.close();
      return true;
    } catch (final Exception e) {
      return false;
    }
  }

  public static boolean copyFileContent(final String sourcePath, final String targetPath) {
    FileInputStream fr = null;
    FileOutputStream fw = null;
    try {
      fr = new FileInputStream(sourcePath);
      fw = new FileOutputStream(targetPath);
      final FileChannel src = fr.getChannel();
      final FileChannel dest = fw.getChannel();
      dest.transferFrom(src, 0, src.size());
      return true;
    } catch (final Exception e) {
      return false;
    } finally {
      try {
        fr.close();
        fw.close();
      } catch (final Exception e) {
        return false;
      }
    }
  }

  public static void writeToFile(final String fileName, final StringBuilder builder) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
      final int aLength = builder.length();
      final int aChunk = 1024;// 1 kb buffer to read data from
      final char[] aChars = new char[aChunk];

      for (int aPosStart = 0; aPosStart < aLength; aPosStart += aChunk) {
        final int aPosEnd = Math.min(aPosStart + aChunk, aLength);
        builder.getChars(aPosStart, aPosEnd, aChars, 0); // Create no new buffer
        bw.write(aChars, 0, aPosEnd - aPosStart);// This is faster than just copying one byte at the
        // time
      }
      bw.flush();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public static IFile getIFileFromPath(final String path) {
    final Path filePath = new Path(path);
    // for absolute paths
    IFile iFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(filePath);
    // might be relative path?
    if (iFile == null) {
      iFile = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
    }
    return iFile;
  }

  /**
   * Skips comment lines
   * 
   * @param scanner
   * @return comment free line
   */
  public static String getNextLine(final Scanner scanner) {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line.startsWith("//")) {
        continue; // Its single comment line, skip
      }

      if (line.startsWith("/*")) { // multi line comment
        String skipLine = line;
        while (scanner.hasNextLine() && !skipLine.contains("*/")) { // skip until close tag
          skipLine = scanner.nextLine();
        }
        // in case there is data after comment close tag
        line = skipLine.substring(skipLine.indexOf("*/") + 2);
        if (line.isEmpty()) {
          continue;
        }
      }
      return line;
    }
    return "";
  }

  /**
   * Displays a message dialog on ui thread. (async)
   * 
   * @param title dialog's title
   * @param message dialog's message
   * @param type dialog's type image constant, see @MessageDialog
   */
  public static void showOKDialog(final int type, final String title, final String message) {
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        final MessageDialog warningdialog = new MessageDialog(Activator.getShell(), title, null,
            message, type, new String[] {"OK"}, 0);
        warningdialog.open();
      }
    });
  }

  private final static String whitespace_chars = "" /* dummy empty string for homogeneity */
      + "\\u0009" // CHARACTER TABULATION
      + "\\u000A" // LINE FEED (LF)
      + "\\u000B" // LINE TABULATION
      + "\\u000C" // FORM FEED (FF)
      + "\\u000D" // CARRIAGE RETURN (CR)
      + "\\u0020" // SPACE
      + "\\u0085" // NEXT LINE (NEL)
      + "\\u00A0" // NO-BREAK SPACE
      + "\\u1680" // OGHAM SPACE MARK
      + "\\u180E" // MONGOLIAN VOWEL SEPARATOR
      + "\\u2000" // EN QUAD
      + "\\u2001" // EM QUAD
      + "\\u2002" // EN SPACE
      + "\\u2003" // EM SPACE
      + "\\u2004" // THREE-PER-EM SPACE
      + "\\u2005" // FOUR-PER-EM SPACE
      + "\\u2006" // SIX-PER-EM SPACE
      + "\\u2007" // FIGURE SPACE
      + "\\u2008" // PUNCTUATION SPACE
      + "\\u2009" // THIN SPACE
      + "\\u200A" // HAIR SPACE
      + "\\u2028" // LINE SEPARATOR
      + "\\u2029" // PARAGRAPH SEPARATOR
      + "\\u202F" // NARROW NO-BREAK SPACE
      + "\\u205F" // MEDIUM MATHEMATICAL SPACE
      + "\\u3000" // IDEOGRAPHIC SPACE
      ;
  /* A \s that actually works for Java’s native character set: Unicode */
  private final static String whitespace_charclass = "[" + Utilities.whitespace_chars + "]";

  public static String removeAllWhiteSpaces(final String str) {
    return str.replaceAll(Utilities.whitespace_charclass, "");
  }
}
