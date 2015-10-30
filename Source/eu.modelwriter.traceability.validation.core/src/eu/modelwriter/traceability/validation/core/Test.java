package eu.modelwriter.traceability.validation.core;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Test {
  public static StringBuilder convert(StringBuilder builder) {
    ANTLRInputStream input = new ANTLRInputStream(builder.toString());
    CoreLexer lexer = new CoreLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CoreParser parser = new CoreParser(tokens);
    ParseTree tree = parser.specification();

    CnfConverter bcc = new CnfConverter();
    bcc.visit(tree);

    // Test.showParseTree(parser, tree);

    return bcc.getBuilder();
  }

  public static void main(String[] args) {
    ANTLRInputStream input = null;
    File file = new File(
        "../eu.modelwriter.traceability.validation.core/src/eu/modelwriter/traceability/validation/core/example.core");
    try {
      input = new ANTLRFileStream(file.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }
    CoreLexer lexer = new CoreLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CoreParser parser = new CoreParser(tokens);
    ParseTree tree = parser.specification();

    ArityCheckVisitor myVisitor = new ArityCheckVisitor();
    myVisitor.visit(tree);

    // SentenceTransformer transformer = new SentenceTransformer();
    // transformer.visit(tree);

    /** ------------------------------------------------------------------ **/

    // Test.showParseTree(parser, tree);

    CnfConverter bcc = new CnfConverter();
    bcc.visit(tree);

    StringBuilder firstIter = bcc.getBuilder();
    StringBuilder secondIter = Test.convert(firstIter);
    StringBuilder thirdIter = Test.convert(secondIter);
    /** ------------------------------------------------------------------ **/

    SemanticProcess semanticProcess = new SemanticProcess();
    semanticProcess.visit(tree);

    /***********************************/

    EquivalanceTransformer equivalanceTransformer = new EquivalanceTransformer();
    equivalanceTransformer.visit(tree);

    ImplicationTransformer implicationTransformer = new ImplicationTransformer();
    implicationTransformer.visit(tree);

    NegationTransformer negationTransformer = new NegationTransformer();
    negationTransformer.visit(tree);

    ParenthesesTransformer parenthesesTransformer = new ParenthesesTransformer();
    parenthesesTransformer.visit(tree);

    showParseTree(parser, tree);

    /***********************************/


  }

  public static void showParseTree(CoreParser parser, ParseTree t) {
    // // show AST in GUI
    JFrame frame = new JFrame("Antlr AST");

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(0, 0, 500, 500);

    TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), t);
    viewr.setScale(0.8); // scale a little
    scrollPane.getViewport().add(viewr);

    frame.add(scrollPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 500);
    frame.setVisible(true);
  }
}
