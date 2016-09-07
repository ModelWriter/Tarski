package eu.modelwriter.configuration.emf2alloy;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class BoundSelectionPage extends EMFToAlloyWizardPage {

  private org.eclipse.swt.widgets.List classList;
  private List<String> classes;
  private String emfAlias;

  protected BoundSelectionPage(String emfAlias, List<String> classes) {
    super("SelectEMFContainer");
    this.emfAlias = emfAlias;
    this.classes = classes;
    setTitle("Bound Selection");
    setDescription("Enter sig bounds");
  }

  @Override
  public void createControl(Composite parent) {
    final Composite container = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    container.setLayout(new FillLayout());
    setTheme();
    Frame frame = SWT_AWT.new_Frame(container);
    frame.setBackground(null);
    GridLayout layout = new GridLayout(0, 3);
    JPanel panel = new JPanel(layout);
    JLabel labelSig = new JLabel("Sig");
    JLabel labelLower = new JLabel("Lower Bound");
    JLabel labelUpper = new JLabel("Upper Bound");
    panel.add(labelSig);
    panel.add(labelLower);
    panel.add(labelUpper);
    for (String sig : classes) {
      JLabel sigLabel = new JLabel(sig);
      SpinnerModel lowerModel = new SpinnerNumberModel();
      SpinnerModel upperModel = new SpinnerNumberModel();
      JSpinner lower = new JSpinner(lowerModel);
      JSpinner upper = new JSpinner(upperModel);
      panel.add(sigLabel);
      panel.add(lower);
      panel.add(upper);
      lowerModel.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
          getEmfToAlloy().updateBounds(sigLabel.getText(), lower.getValue(), upper.getValue());
        }
      });
      upperModel.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
          getEmfToAlloy().updateBounds(sigLabel.getText(), lower.getValue(), upper.getValue());
        }
      });
      lower.setValue(0);
      upper.setValue(3);
    }
    frame.add(panel, BorderLayout.CENTER);
    setControl(container);
  }

  private void setTheme() {
    try {
      /*
       * TODO BUG
       * 
       * A Fatal Error occurs while setting GTK look and feel on Ubuntu 16.04
       * (com.sun.java.swing.plaf.gtk.GTKLookAndFeel).
       * 
       */
      final String LaF = UIManager.getSystemLookAndFeelClassName();
      if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(LaF)) {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } else {
        UIManager.setLookAndFeel(LaF);
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e1) {
      e1.printStackTrace();
    }
  }

  public List<String> getEmfClasses() {
    return classes;
  }

  public void setEmfClasses(List<String> emfClasses) {
    classes = emfClasses;
    for (String clazz : emfClasses) {
      classList.add(clazz);
    }
  }

  public String getEmfAlias() {
    return emfAlias;
  }

  public void setEmfAlias(String emfAlias) {
    this.emfAlias = emfAlias;
  }

  public String getSelectedClass() {
    return classes.get(classList.getSelectionIndex());
  }

  @Override
  public boolean nextPressed() throws Exception {
    return super.nextPressed();
  }

}
