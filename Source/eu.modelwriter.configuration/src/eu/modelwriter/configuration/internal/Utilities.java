package eu.modelwriter.configuration.internal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
}
