package unit.verifier.core;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Test {
  public static void main(String[] args) {
    ANTLRInputStream input = null;
    File file = new File("../unit.verifier/src/unit/verifier/core/model.core");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
    CoreLexer lexer = new CoreLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CoreParser parser = new CoreParser(tokens);
    ParseTree t = parser.specification();

    // // show AST in GUI
    JFrame frame = new JFrame("Antlr AST");

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(50, 30, 300, 50);

    TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), t);
    viewr.setScale(1.0); // scale a little
    scrollPane.getViewport().add(viewr);
    frame.add(scrollPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);

    ArityCheckVisitor myVisitor = new ArityCheckVisitor();
    myVisitor.visit(t);
  }
}
