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
    // JFrame frame = new JFrame("Antlr AST");
    //
    // JPanel panel = new JPanel();
    // JScrollPane scrollPane = new JScrollPane(panel);
    // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    // scrollPane.setBounds(50, 30, 300, 50);
    //
    // JPanel contentPane = new JPanel(null);
    // contentPane.setPreferredSize(new Dimension(500, 400));
    // contentPane.add(scrollPane);
    // contentPane.add(scrollPane);
    //
    // TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), t);
    // viewr.setScale(1.0); // scale a little
    // panel.add(viewr);
    // frame.add(panel);
    // frame.setContentPane(contentPane);
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setSize(200, 200);
    // frame.setVisible(true);

    ArityCheckVisitor myVisitor = new ArityCheckVisitor();
    myVisitor.visit(t);
  }
}
