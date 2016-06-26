package eu.modelwriter.traceability.validation.editor.base.view;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.traceability.validation.core.fol.Test;

public class ParseTreeView extends ViewPart {

  private static JScrollPane scrollPane;

  public static void refresh() {
    scrollPane.getViewport().removeAll();
    scrollPane.getViewport().add((Component) Test.getViewer());
  }

  public ParseTreeView() {}

  @Override
  public void createPartControl(final Composite parent) {
    final Object viewer = Test.getViewer();

    final Composite composite = new Composite(parent, SWT.EMBEDDED);
    final Frame frame = SWT_AWT.new_Frame(composite);
    frame.setTitle("Antlr AST");

    scrollPane = new JScrollPane();
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setBounds(0, 0, 500, 500);

    scrollPane.getViewport().add((Component) viewer);

    frame.add(scrollPane);
    // frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, 500);
    frame.setVisible(true);
  }

  @Override
  public void setFocus() {}
}
