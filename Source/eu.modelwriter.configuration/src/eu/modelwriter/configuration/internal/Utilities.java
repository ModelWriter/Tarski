package eu.modelwriter.configuration.internal;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Utilities {

  public static boolean appendToFile(String filePath, String textToAppend) {
    try (FileWriter fw = new FileWriter(filePath, true)) {
      fw.write(textToAppend);
      fw.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean copyFileContent(String sourcePath, String targetPath) {
    FileInputStream fr = null;
    FileOutputStream fw = null;
    try {
      fr = new FileInputStream(sourcePath);
      fw = new FileOutputStream(targetPath);
      FileChannel src = fr.getChannel();
      FileChannel dest = fw.getChannel();
      dest.transferFrom(src, 0, src.size());
      return true;
    } catch (Exception e) {
      return false;
    } finally {
      try {
        fr.close();
        fw.close();
      } catch (Exception e) {
        return false;
      }
    }
  }

  public static void writeToFile(String fileName, StringBuilder builder) {
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
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
