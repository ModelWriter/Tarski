package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.interpretationwizard.InterpretationWizard;

public class VisualizationActionListenerFactory {
  private static VisualizationActionListenerFactory instance;

  public static Set<VisualizationChangeListener> listeners = new HashSet<>();

  private VisualizationActionListenerFactory() {}

  public static VisualizationActionListenerFactory get() {
    if (VisualizationActionListenerFactory.instance == null) {
      VisualizationActionListenerFactory.instance = new VisualizationActionListenerFactory();
    }
    return VisualizationActionListenerFactory.instance;
  }

  public void registerListener(final VisualizationChangeListener listener) {
    if (listener != null) {
      synchronized (VisualizationActionListenerFactory.listeners) {
        VisualizationActionListenerFactory.listeners.add(listener);
      }
    }
  }

  public void unregisterListener(final VisualizationChangeListener listener) {
    synchronized (VisualizationActionListenerFactory.listeners) {
      VisualizationActionListenerFactory.listeners.remove(listener);
    }
  }

  public static ActionListener refreshActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Visualization.showViz();
      }
    };
  }

  public static ActionListener addRemoveTypeActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final IMarker marker =
            Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation);
        Display.getDefault().syncExec(new AddRemoveTypeCommand(marker));
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
      }
    };
  }

  public static ActionListener createNewAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg0) {
        Display.getDefault().syncExec(new CreateNewAtomCommand());
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
      }
    };
  }

  public static ActionListener deleteAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final IMarker marker =
            Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation);
        final String sigTypeName = marker.getAttribute(MarkUtilities.MARKER_TYPE, "");
        final String relUri = marker.getAttribute(MarkUtilities.RELATIVE_URI, "");
        Display.getDefault().syncExec(new DeleteAtomCommand(marker));
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
        for (final VisualizationChangeListener listener : VisualizationActionListenerFactory.listeners) {
          listener.onAtomRemoved(sigTypeName, relUri);
        }
      }
    };
  }

  public static ActionListener mappingActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new MappingCommand(
            Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation)));
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
      }
    };
  }

  public static ActionListener removeRelationActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final IMarker startMarker =
            Visualization.getMarker(((AlloyTuple) Visualization.rightClickedAnnotation).getStart());
        final IMarker endMarker =
            Visualization.getMarker(((AlloyTuple) Visualization.rightClickedAnnotation).getEnd());
        final String relation = Visualization.relation;
        Display.getDefault().syncExec(new RemoveRelationCommand(startMarker, endMarker, relation));
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
        for (final VisualizationChangeListener listener : VisualizationActionListenerFactory.listeners) {
          listener.onRelationRemoved(startMarker, endMarker, relation);
        }
      }
    };
  }


  public static ActionListener resolveActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new ResolveCommand(Visualization.rightClickedAnnotation));
        Visualization.showViz();
      }
    };
  }

  public static ActionListener validateActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (StaticAlloyAnalysisManager.checkConsistency()) {
          JOptionPane.showMessageDialog(null, "Instance is consistent.", "Consistency Check",
              JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "Instance is inconsistent.", "Consistency Check",
              JOptionPane.WARNING_MESSAGE);
        }

      }
    };
  }

  public static ActionListener discoverAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (!StaticAlloyAnalysisManager.startDiscovering()) {
          JOptionPane.showMessageDialog(null, "There is not any discovering.",
              "Discovering on Atoms", JOptionPane.INFORMATION_MESSAGE);
        }
        Visualization.showViz();
      }
    };
  }

  public static ActionListener reasonRelationActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (!StaticAlloyAnalysisManager.startReasoning()) {
          JOptionPane.showMessageDialog(null, "There is not any reasoning.",
              "Reasoning on Relations", JOptionPane.INFORMATION_MESSAGE);
        }
        Visualization.showViz();
      }
    };
  }

  public static ActionListener reasonRelationForAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final AlloyAtom alloyAtom = (AlloyAtom) Visualization.rightClickedAnnotation;

        final String atomType = alloyAtom.getType().getName();
        String atomName = alloyAtom.toString();
        final String numIndex = atomName.substring(atomType.length());
        atomName = numIndex.isEmpty() ? atomName + "0" : atomName;

        if (!StaticAlloyAnalysisManager.startReasoningForAtom(atomName)) {
          JOptionPane.showMessageDialog(null, "There is not any reasoning for atom.",
              "Reasoning for Atom", JOptionPane.INFORMATION_MESSAGE);
        }
        Visualization.showViz();
      }
    };
  }

  public static ActionListener acceptReasonedRelationActionListener() {
    return new ActionListener() {
      IMarker selectedMarker;

      private void showWizard() {
        Display.getDefault().syncExec(new Runnable() {
          @Override
          public void run() {
            final InterpretationWizard wizard = new InterpretationWizard();
            final WizardDialog dialog = new WizardDialog(
                Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getShell(), wizard);
            dialog.open();
            selectedMarker = wizard.getSelectedMarker();
          }
        });
      }

      private IMarker interpretAtom(final AlloyAtom atom) {
        showWizard();
        if (selectedMarker == null) {
          return null;
        }

        final String sigTypeName = atom.getType().getName();
        final String stringIndex = atom.toString().substring(sigTypeName.length());
        int index = 0;
        if (!stringIndex.isEmpty()) {
          index = Integer.parseInt(stringIndex);
        }

        AlloyUtilities.bindAtomToMarker(sigTypeName, index, selectedMarker);
        Visualization.showViz();
        return selectedMarker;
      }

      @Override
      public void actionPerformed(final ActionEvent e) {
        if (Visualization.container == null) {
          return;
        }
        final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
        final AlloyAtom fromAtom = tuple.getStart();
        final AlloyAtom toAtom = tuple.getEnd();
        IMarker fromMarker = Visualization.getMarker(fromAtom);
        IMarker toMarker = Visualization.getMarker(toAtom);

        if (fromMarker == null) {
          fromMarker = interpretAtom(fromAtom);
        } else if (toMarker == null) {
          toMarker = interpretAtom(toAtom);
        }

        AlloyUtilities.resetReasoned(fromMarker, toMarker, Visualization.relation);
        Visualization.showViz();
      }
    };
  }

  public static ActionListener nextSolutionActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (!StaticAlloyAnalysisManager.nextAnalysis()) {
          JOptionPane.showMessageDialog(null, "There is not any other next solution.",
              "Next Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        Visualization.showViz();
      }
    };
  }

  public static ActionListener previousSolutionActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (!StaticAlloyAnalysisManager.previousAnalysis()) {
          JOptionPane.showMessageDialog(null, "There is not any other previous solution.",
              "Previous Solution", JOptionPane.INFORMATION_MESSAGE);
        }
        Visualization.showViz();
      }
    };
  }

  public static ActionListener stopAnalysisActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
      }
    };
  }

  public static ActionListener clearAllReasonedActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        AlloyUtilities.clearAllReasonedTuplesAndAtoms();
        StaticAlloyAnalysisManager.finishAnalysis();
        Visualization.showViz();
      }
    };
  }


  public static ActionListener interpretAtomMenuItemActionListener() {
    return new ActionListener() {

      IMarker selectedMarker;

      @Override
      public void actionPerformed(final ActionEvent e) {
        final AlloyAtom alloyAtom = (AlloyAtom) Visualization.rightClickedAnnotation;

        showWizard();
        if (selectedMarker == null) {
          return;
        }

        final String sigTypeName = alloyAtom.getType().getName();
        final String stringIndex = alloyAtom.toString().substring(sigTypeName.length());
        int index = 0;
        if (!stringIndex.isEmpty()) {
          index = Integer.parseInt(stringIndex);
        }

        AlloyUtilities.bindAtomToMarker(sigTypeName, index, selectedMarker);
        Visualization.showViz();
      }

      private void showWizard() {
        Display.getDefault().syncExec(new Runnable() {
          @Override
          public void run() {
            final InterpretationWizard wizard = new InterpretationWizard();
            final WizardDialog dialog = new WizardDialog(
                Activator.getDefault().getWorkbench().getWorkbenchWindows()[0].getShell(), wizard);
            dialog.open();
            selectedMarker = wizard.getSelectedMarker();
          }
        });
      }
    };
  }

  public static ActionListener acceptAtomAsEMFMenuItemActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        final AlloyAtom alloyAtom = (AlloyAtom) Visualization.rightClickedAnnotation;
        for (final VisualizationChangeListener listener : VisualizationActionListenerFactory.listeners) {
          listener.onAtomAccepted(alloyAtom);
        }
      }
    };
  }

  public static ActionListener acceptRelationAsEMFMenuItemActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
        final AlloyAtom fromAtom = tuple.getStart();
        final AlloyAtom toAtom = tuple.getEnd();
        for (final VisualizationChangeListener listener : VisualizationActionListenerFactory.listeners) {
          listener.onReasonedRelationAccepted(fromAtom, toAtom, Visualization.relation);
        }
      }
    };
  }

  public static ActionListener acceptAllReasonedListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        StaticAlloyAnalysisManager.finishAnalysis();
        for (final VisualizationChangeListener listener : VisualizationActionListenerFactory.listeners) {
          listener.onAllReasonedAccepted();
        }
      }
    };
  }

  public static ActionListener createInstanceElementActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay()
        .asyncExec(new CreateInstanceElementCommand());
      }
    };
  }
}
