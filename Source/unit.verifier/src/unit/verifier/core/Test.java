package unit.verifier.core;

import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Test {
  public static void main(String[] args) {
    ANTLRInputStream input = null;
    try {
      File file = new File("../unit.verifier/src/unit/verifier/core/example.core");
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
    CoreLexer lexer = new CoreLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CoreParser parser = new CoreParser(tokens);
    ParseTree t = parser.specification();

    ArityCheckVisitor myVisitor = new ArityCheckVisitor();
    myVisitor.visit(t);
  }
}
