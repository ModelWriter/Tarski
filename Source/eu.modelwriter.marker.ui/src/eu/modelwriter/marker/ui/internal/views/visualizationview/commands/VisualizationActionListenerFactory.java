package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisType;
import eu.modelwriter.configuration.alloy.discovery.AlloyDiscovering;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.configuration.alloy.reasoning.AlloyReasoning;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.interpretationwizard.InterpretationWizard;

public class VisualizationActionListenerFactory {
  private static VisualizationActionListenerFactory instance;

  private VisualizationActionListenerFactory() {}

  public VisualizationActionListenerFactory getInsance() {
    if (VisualizationActionListenerFactory.instance == null) {
      VisualizationActionListenerFactory.instance = new VisualizationActionListenerFactory();
    }
    return VisualizationActionListenerFactory.instance;
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
        Display.getDefault().syncExec(new AddRemoveTypeCommand(
            Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation)));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public static ActionListener createNewAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg0) {
        Display.getDefault().syncExec(new CreateNewAtomCommand());
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public static ActionListener deleteAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new DeleteAtomCommand(
            Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation)));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public static ActionListener mappingActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new MappingCommand(
            Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation)));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public static ActionListener removeRelationActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new RemoveRelationCommand(
            Visualization.getMarker(((AlloyTuple) Visualization.rightClickedAnnotation).getStart()),
            Visualization.getMarker(((AlloyTuple) Visualization.rightClickedAnnotation).getEnd()),
            Visualization.relation));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
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
        if (AlloyValidator.validate()) {
          JOptionPane.showMessageDialog(null, "Instance is consistent.", "Consistency Check",
              JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "Instance is inconsistent.", "Consistency Check",
              JOptionPane.WARNING_MESSAGE);
        }

      }
    };
  }

  public static ActionListener reasonActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setAnalysis(AnalysisType.DISCOVER_RELATION);
          }
        });

        final AlloyReasoning alloyReasoning = new AlloyReasoning();
        alloyReasoning.reasoning();
        Visualization.showViz();
      }

    };
  }

  public static ActionListener acceptReasonActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (Visualization.container == null) {
          return;
        }
        final AlloyTuple tuple = (AlloyTuple) Visualization.rightClickedAnnotation;
        final AlloyAtom fromAtom = tuple.getStart();
        final AlloyAtom toAtom = tuple.getEnd();
        final IMarker fromMarker = Visualization.getMarker(fromAtom);
        final IMarker toMarker = Visualization.getMarker(toAtom);

        AlloyUtilities.resetReasoned(fromMarker, toMarker, Visualization.relation);
        Visualization.showViz();
      }

    };
  }

  public static ActionListener discoverActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setAnalysis(AnalysisType.DISCOVER_ATOM);
          }
        });

        final AlloyDiscovering alloyDiscovering = new AlloyDiscovering();
        alloyDiscovering.discovering();
        Visualization.showViz();
      }
    };
  }

  public static ActionListener nextSolutionActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setNext();
          }
        });

        if (Visualization.sourceProvider.getAnalysisType() == AnalysisType.DISCOVER_RELATION) {
          AlloyNextSolutionReasoning.getInstance().next();
        } else if (Visualization.sourceProvider.getAnalysisType() == AnalysisType.DISCOVER_ATOM) {
          AlloyNextSolutionDiscovering.getInstance().next();
        }
        Visualization.showViz();
      }

    };
  }

  public static ActionListener stopAnalysisActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setStop();
          }
        });

        AlloyNextSolutionReasoning.getInstance().finishNext();
        Visualization.showViz();
      }

    };
  }

  public static ActionListener clearAllReasonedActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        AlloyUtilities.clearAllReasonedTuplesAndAtoms();
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();

        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setStop();
          }
        });
      }
    };
  }


  public static ActionListener interpretAtomMenuItemActionListener() {
    return new ActionListener() {

      IMarker selectedMarker;

      @Override
      public void actionPerformed(final ActionEvent e) {
        final AlloyAtom alloyAtom = (AlloyAtom) Visualization.rightClickedAnnotation;

        this.showWizard();
        if (this.selectedMarker == null) {
          return;
        }

        final String sigTypeName = alloyAtom.getType().getName();
        final String stringIndex = alloyAtom.toString().substring(sigTypeName.length());
        int index = 0;
        if (!stringIndex.isEmpty()) {
          index = Integer.parseInt(stringIndex);
        }

        AlloyUtilities.bindAtomToMarker(sigTypeName, index, this.selectedMarker);
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
}
