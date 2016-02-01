package eu.modelwriter.traceability.validation.core.crocopat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrocopatTest {
  public static void main(String[] args) {
    Runtime rt = Runtime.getRuntime();
    try {
      String exeLocation =
          "./../eu.modelwriter.traceability.validation.core.crocopat/exec/crocopat-2.1.4_win32.exe";
      File exeFile = new File(exeLocation);
      String rmlLocation =
          "./../eu.modelwriter.traceability.validation.core.crocopat/files/List.rml";
      File rmlFile = new File(rmlLocation);

      long startTime = System.currentTimeMillis();
      Process pr = rt.exec(exeFile.getAbsolutePath() + " -e " + rmlFile.getAbsolutePath());
      long stopTime = System.currentTimeMillis();
      long elapsedTime = stopTime - startTime;
      System.out.println(elapsedTime);

      new Thread(new Runnable() {
        public void run() {
          BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
          String line = null;

          try {
            while ((line = input.readLine()) != null)
              System.out.println(line);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }).start();

      pr.waitFor();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
