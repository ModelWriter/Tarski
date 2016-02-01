package eu.modelwriter.traceability.validation.core.crocopat;

public class UniverseCreateForKodKod {

  static String str = "";

  public static void main(String[] args) {

    int size = 100;
    creatStr(size, size);
    createFile(size);
    createDir(size);
    createRoot();
    createContents(size, size);

    str += "\n\ncontents in Dir -> (Dir + File)\n" + "all d:Dir | not (d in d.^contents)\n"
        + "Root in Dir\n" + "(File + Dir) in Root.*contents";
    System.out.println(str);
  }

  public static void creatStr(int sizeDir, int sizeFile) {
    str += "{";
    for (int i = 0; i < sizeDir - 1; i++) {
      str += "d" + i + ", ";
    }
    for (int i = 0; i < sizeFile - 1; i++) {
      str += "f" + i + ",";
    }
    str = str.substring(0, str.length() - 1);
    str += "}\n\n";
  }

  public static void createFile(int size) {
    str += "File: 1 [ { ";
    for (int i = 0; i < size - 1; i++) {
      str += "(f" + i + "),";
    }
    str = str.substring(0, str.length() - 1);
    str += "} ]\n";
  }

  public static void createDir(int size) {
    str += "Dir: 1 [ { ";
    for (int i = 0; i < size - 1; i++) {
      str += "(d" + i + "),";
    }
    str = str.substring(0, str.length() - 1);
    str += "} ]\n";
  }

  public static void createRoot() {
    str += "Root :1 [{(d0)}]\n";
  }

  public static void createContents(int sizeDir, int sizeFile) {
    str += "contents: [ [ ";
    for (int i = 0; i < sizeDir - 2; i = i + 2) {
      str += "[d" + i + ",d" + (i + 1) + "],";
      str += "[d" + i + ",d" + (i + 2) + "],";
    }
    for (int i = 1; i < sizeDir - 2; i = i + 2) {
      str += "[d" + i + ",f" + (i - 1) + "],";
      str += "[d" + i + ",f" + (i) + "],";
    }
    str += "[d" + (sizeDir - 2) + ",f" + (sizeFile - 2) + "]";
    str += " ] ]\n";
  }

}
