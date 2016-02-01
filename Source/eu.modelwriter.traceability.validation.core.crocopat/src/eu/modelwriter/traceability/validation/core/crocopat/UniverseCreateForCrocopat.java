package eu.modelwriter.traceability.validation.core.crocopat;

public class UniverseCreateForCrocopat {

  static String str = "";

  public static void main(String[] args) {

    int size = 100;
    createFile(size);
    createDir(size);
    createRoot();
    createContents(size, size);
    str += "\n\ncontentsCheck() := FA(x,y, (CONT(x,y)) -> (D(x) & (D(y) | F(y))));"
        + "\nDirTransitive(x,y) := (D(x) & TCFAST(CONT(x,y)));"
        + "\nnoBackTransitive() := FA(x,y, DirTransitive(x,y) -> !DirTransitive(y,x));"
        + "\nisRootinDir() := FA (x, (R(x)) -> (D(x)));"
        + "\nTransitive(x,y) := R(x) & TCFAST(CONT(x,y));"
        + "\nReflexiveTransitive(x) := Transitive(_,x) | R(x);"
        + "\nisRefTrans() := FA(x, (D(x) | F(x)) -> ReflexiveTransitive(x));"
        + "\nisValid() := contentsCheck() & isRootinDir() & noBackTransitive() & isRefTrans();"
        + "\nIF (isValid()) {" + "\n\tPRINT \"is a valid.\", ENDL;" + "\n}ELSE {"
        + "  \n\tPRINT \"is not a valid.\", ENDL;" + "\n}";
    System.out.println(str);
  }


  public static void createFile(int size) {
    for (int i = 0; i < size - 1; i++) {
      str += "F(\"F" + i + "\");\n";
    }
    str += "\n";
  }

  public static void createDir(int size) {
    for (int i = 0; i < size - 1; i++) {
      str += "D(\"D" + i + "\");\n";
    }
    str += "\n";
  }

  public static void createRoot() {
    str += "R(\"D0\");\n\n";
  }

  public static void createContents(int sizeDir, int sizeFile) {
    for (int i = 0; i < sizeDir - 2; i = i + 2) {
      str += "CONT(\"D" + i + "\"),(\"D" + (i + 1) + "\");\n";
      str += "CONT(\"D" + i + "\"),(\"D" + (i + 2) + "\");\n";
    }
    for (int i = 1; i < sizeDir - 2; i = i + 2) {
      str += "CONT(\"D" + i + "\"),(\"F" + (i) + "\");\n";
      str += "CONT(\"D" + i + "\"),(\"F" + (i + 1) + "\");\n";
    }
    str += "\n";
  }
}
