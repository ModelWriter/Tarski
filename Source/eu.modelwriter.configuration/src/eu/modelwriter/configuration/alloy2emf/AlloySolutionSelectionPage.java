package eu.modelwriter.configuration.alloy2emf;

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

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.internal.AlloyUtilities;

public class AlloySolutionSelectionPage extends AlloyToEMFWizardPage {

  private List<A4Solution> solutions = new ArrayList<A4Solution>();
  private int currentSolutionIndex = 0;

  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static Frame frame;
  private static File f = null;
  public static Composite container;
  private static String xmlFileLocation =
      ".modelwriter alloy_example_output0.xml".replace(" ", System.getProperty("file.separator"));

  public AlloySolutionSelectionPage() {
    this("AlloySolutionSelectionPage");
  }

  private static String getLocation() {
    return ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + xmlFileLocation;
  }

  protected AlloySolutionSelectionPage(String pageName) {
    super(pageName);
    setTitle("Alloy Solutions");
    // setDescription("Select a Alloy solution to continue");
  }

  @Override
  public void createControl(Composite parent) {
    final Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new GridLayout(1, false));
    container.setLayoutData(new GridData(SWT.FILL));

    AlloySolutionSelectionPage.container =
        new Composite(container, SWT.EMBEDDED | SWT.NO_BACKGROUND);
    AlloySolutionSelectionPage.container
        .setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
    AlloySolutionSelectionPage.frame = null;
    AlloySolutionSelectionPage.f = null;
    AlloySolutionSelectionPage.graph = null;
    AlloySolutionSelectionPage.myState = null;

    final Composite buttonContainer = new Composite(container, SWT.NULL);
    buttonContainer.setLayout(new GridLayout(3, false));
    buttonContainer.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, false, 1, 1));

    Button prevButton = new Button(buttonContainer, SWT.PUSH);
    prevButton.setText("Previous Solution");
    prevButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        if (currentSolutionIndex > 0) {
          currentSolutionIndex = currentSolutionIndex - 1;
          showSolution();
        }
      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {}
    });

    Button nextButton = new Button(buttonContainer, SWT.PUSH);
    nextButton.setText("Next Solution");
    nextButton.addSelectionListener(new SelectionListener() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        try {
          A4Solution nextSol = currentSolution().next();
          if (nextSol.satisfiable()) {
            solutions.add(nextSol);
            currentSolutionIndex = currentSolutionIndex < (solutions.size() - 1)
                ? currentSolutionIndex + 1 : (solutions.size() - 1);
            showSolution();
          }
        } catch (Err e1) {
          e1.printStackTrace();
          setErrorMessage("An error has occured while getting next solution.");
        }

      }

      @Override
      public void widgetDefaultSelected(SelectionEvent e) {}
    });

    setControl(container);
    if (!solutions.isEmpty()) {
      showSolution();
    }
  }

  private void showViz() {
    if (AlloySolutionSelectionPage.container == null) {
      return;
    }

    if (!AlloyUtilities.isExists()) {
      if (AlloySolutionSelectionPage.frame != null) {
        if (AlloySolutionSelectionPage.frame.getComponentCount() > 0) {
          AlloySolutionSelectionPage.frame.removeAll();
        }
        AlloySolutionSelectionPage.frame.add(new JPanel());
      } else if (AlloySolutionSelectionPage.frame == null) {
        AlloySolutionSelectionPage.frame = SWT_AWT.new_Frame(AlloySolutionSelectionPage.container);
        AlloySolutionSelectionPage.frame.add(new JPanel());
      }
      return;
    }
    AlloySolutionSelectionPage.f = new File(getLocation());
    try {
      if (!AlloySolutionSelectionPage.f.exists()) {
        throw new IOException("File " + getLocation() + " does not exist.");
      }
      final AlloyInstance instance =
          StaticInstanceReader.parseInstance(AlloySolutionSelectionPage.f);

      AlloyUtilities.setAllImpactsAndChanges(instance);

      AlloySolutionSelectionPage.myState = new VizState(instance);

      // FE
      AlloySolutionSelectionPage.myState.mergeArrows.put(null, false);

      if (AlloySolutionSelectionPage.frame == null) {
        AlloySolutionSelectionPage.frame = SWT_AWT.new_Frame(AlloySolutionSelectionPage.container);
      }

      if (AlloySolutionSelectionPage.graph != null
          && AlloySolutionSelectionPage.frame.getComponent(0) != null) {
        AlloySolutionSelectionPage.frame.remove(AlloySolutionSelectionPage.graph);
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
      AlloySolutionSelectionPage.graph =
          new VizGraphPanel(AlloySolutionSelectionPage.myState, false);
      AlloySolutionSelectionPage.frame.removeAll();
      AlloySolutionSelectionPage.frame.add(AlloySolutionSelectionPage.graph);
      AlloySolutionSelectionPage.frame.setVisible(true);
      AlloySolutionSelectionPage.frame.setAlwaysOnTop(true);
      AlloySolutionSelectionPage.graph.alloyGetViewer().alloyRepaint();

    } catch (final Err | IOException e) {
      e.printStackTrace();
      setErrorMessage("An error has occured while Alloy visualization.");
    }
  }

  @Override
  public void dispose() {
    container = null;
    super.dispose();
  }

  public void setFirstSolution(A4Solution firstSolution) {
    if (solutions.isEmpty()) {
      solutions.add(firstSolution);
      currentSolutionIndex = 0;
      showSolution();
    } else {
      solutions.clear();
      solutions.add(firstSolution);
      currentSolutionIndex = 0;
      showSolution();
    }
  }

  public A4Solution currentSolution() {
    return solutions.get(currentSolutionIndex);
  }

  public void showSolution() {
    try {
      setDescription("Current solution: " + currentSolutionIndex + "\n");
      currentSolution().writeXML(getLocation());
      showViz();
    } catch (final Err e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean backPressed() {
    solutions.clear();
    currentSolutionIndex = 0;
    return true;
  }

  @Override
  public boolean nextPressed() throws Exception {
    AlloyToEMFWizard wizard = (AlloyToEMFWizard) getWizard();
    wizard.getAlloyToEmf().setSolution(currentSolution());
    return super.nextPressed();
  }

}
