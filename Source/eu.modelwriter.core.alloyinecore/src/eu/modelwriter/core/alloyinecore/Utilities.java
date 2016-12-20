package eu.modelwriter.core.alloyinecore;

import java.awt.Toolkit;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.tree.ParseTree;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;

public class Utilities {


  public static void showParseTree(AlloyInEcoreParser parser, ParseTree tree) {
    // // show AST in GUI
    final JFrame frame = new JFrame("AlloyInECore AST");

    final JScrollPane scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(0, 0, 500, 700);

    final TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
    viewr.setScale(1);
    scrollPane.getViewport().add(viewr);

    frame.add(scrollPane);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 500);
    frame.setVisible(true);
  }

}
