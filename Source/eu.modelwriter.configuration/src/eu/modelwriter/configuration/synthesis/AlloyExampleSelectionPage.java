package eu.modelwriter.configuration.synthesis;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.alloy.trace.TraceException;
import eu.modelwriter.configuration.internal.AlloyUtilities;

public class AlloyExampleSelectionPage extends MWizardPage {

  private List<A4Solution> solutions = new ArrayList<A4Solution>();
  private int currentSolutionIndex = 0;
  private Label currentLabel;

  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static Frame frame;
  private static File f = null;
  public static Composite container;
  private static String xmlFileLocation =
      ".modelwriter alloy_example_output0.xml".replace(" ", System.getProperty("file.separator"));

  public AlloyExampleSelectionPage() {
    this("AlloyExampleSelectionPage");
  }

  private static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + xmlFileLocation;
  }

  protected AlloyExampleSelectionPage(String pageName) {
    super(pageName);
    setTitle("Alloy Examples");
    setDescription("Select a Alloy example to continue");
  }

  @Override
  public void createControl(Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(1, false));
    container.setLayoutData(new GridData(SWT.FILL));

    AlloyExampleSelectionPage.container =
        new Composite(container, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    AlloyExampleSelectionPage.container
        .setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
    AlloyExampleSelectionPage.frame = null;
    AlloyExampleSelectionPage.f = null;
    AlloyExampleSelectionPage.graph = null;
    AlloyExampleSelectionPage.myState = null;

    final Composite buttonContainer = new Composite(container, SWT.NULL);
    buttonContainer.setLayout(new GridLayout(3, false));
    buttonContainer.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, false, 1, 1));

    Button prevButton = new Button(buttonContainer, SWT.PUSH);
    prevButton.setText("Previous Example");
    prevButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        currentSolutionIndex = currentSolutionIndex > 0 ? currentSolutionIndex - 1 : 0;
        showSolution();
      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {}
    });
    //
    // @Override
    // public void widgetSelected(SelectionEvent e) {
    // showSolution();
    // }
    //
    // @Override
    // public void widgetDefaultSelected(SelectionEvent e) {}
    // });

    Button nextButton = new Button(buttonContainer, SWT.PUSH);
    nextButton.setText("Next Example");
    nextButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        try {
          int limit = 100, counter = 0;
          A4Solution nextSol = currentSolution().next();
          while (!nextSol.satisfiable() && counter < limit) {
            nextSol = nextSol.next();
            counter++;
          }
          solutions.add(nextSol);
          currentSolutionIndex = currentSolutionIndex < (solutions.size() - 1)
              ? currentSolutionIndex + 1 : (solutions.size() - 1);
          showSolution();
        } catch (Err e1) {
          e1.printStackTrace();
          setErrorMessage("An error has occured while getting next solution.");
        }

      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {}
    });

    setControl(container);
  }

  private void showViz() {
    if (AlloyExampleSelectionPage.container == null) {
      return;
    }
    if (!AlloyUtilities.isExists()) {
      if (AlloyExampleSelectionPage.frame != null) {
        if (AlloyExampleSelectionPage.frame.getComponentCount() > 0) {
          AlloyExampleSelectionPage.frame.removeAll();
        }
        AlloyExampleSelectionPage.frame.add(new JPanel());
      } else if (AlloyExampleSelectionPage.frame == null) {
        AlloyExampleSelectionPage.frame = SWT_AWT.new_Frame(AlloyExampleSelectionPage.container);
        AlloyExampleSelectionPage.frame.add(new JPanel());
      }
      return;
    }
    AlloyExampleSelectionPage.f = new File(getLocation());
    try {
      if (!AlloyExampleSelectionPage.f.exists()) {
        throw new IOException("File " + getLocation() + " does not exist.");
      }
      final AlloyInstance instance =
          StaticInstanceReader.parseInstance(AlloyExampleSelectionPage.f);

      AlloyUtilities.setAllImpactsAndChanges(instance);
      AlloyUtilities.setAllReasonedTuples(instance);
      AlloyUtilities.setAllReasonedAtoms(instance);

      AlloyExampleSelectionPage.myState = new VizState(instance);

      // FE
      AlloyExampleSelectionPage.myState.mergeArrows.put(null, false);

      if (AlloyExampleSelectionPage.frame == null) {
        AlloyExampleSelectionPage.frame = SWT_AWT.new_Frame(AlloyExampleSelectionPage.container);
      }

      if (AlloyExampleSelectionPage.graph != null
          && AlloyExampleSelectionPage.frame.getComponent(0) != null) {
        AlloyExampleSelectionPage.frame.remove(AlloyExampleSelectionPage.graph);
      }

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
      AlloyExampleSelectionPage.graph = new VizGraphPanel(AlloyExampleSelectionPage.myState, false);
      AlloyExampleSelectionPage.frame.removeAll();
      AlloyExampleSelectionPage.frame.add(AlloyExampleSelectionPage.graph);
      AlloyExampleSelectionPage.frame.setVisible(true);
      AlloyExampleSelectionPage.frame.setAlwaysOnTop(true);
      AlloyExampleSelectionPage.graph.alloyGetViewer().alloyRepaint();

    } catch (final Err | IOException e) {
      e.printStackTrace();
      setErrorMessage("An error has occured while Alloy visualization.");
    }
  }

  public void setFirstSolution(A4Solution firstSolution) {
    if (solutions.isEmpty()) {
      solutions.add(firstSolution);
      showSolution();
    }
  }

  public A4Solution currentSolution() {
    return solutions.get(currentSolutionIndex);
  }

  private void showSolution() {
    try {
      setDescription(
          "Select a Alloy example to continue. Current selection : " + currentSolutionIndex);
      currentSolution().writeXML(getLocation());
      showViz();
    } catch (final Err e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean nextPressed() throws TraceException {
    AlloyToEMFWizard wizard = (AlloyToEMFWizard) getWizard();
    wizard.getAlloyToEmf().setAnswer(currentSolution());
    return super.nextPressed();
  }

}
