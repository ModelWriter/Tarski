package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyTuple;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.ReasoningType;
import eu.modelwriter.configuration.alloy.discovery.AlloyDiscovering;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.configuration.alloy.reasoning.AlloyReasoning;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.interpretationwizard.InterpretationWizard;

public class VisualizationActionListenerFactoryJGraphx {
  public static final VisualizationActionListenerFactoryJGraphx instance =
      new VisualizationActionListenerFactoryJGraphx();

  private VisualizationActionListenerFactoryJGraphx() {}

  public ActionListener refreshActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Visualization.showViz();
      }
    };
  }

  public ActionListener addRemoveTypeActionListener() {
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

  public ActionListener createNewAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg0) {
        Display.getDefault().syncExec(new CreateNewAtomCommand());
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public ActionListener deleteAtomActionListener() {
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

  public ActionListener mappingActionListener() {
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

  public ActionListener removeRelationActionListener() {
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


  public ActionListener resolveActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new ResolveCommand(Visualization.rightClickedAnnotation));
        Visualization.showViz();
      }
    };
  }

  public ActionListener validateActionListener() {
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

  public ActionListener discoverRelationActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setActive(ReasoningType.DISCOVER_RELATION);
          }
        });

        final AlloyReasoning alloyReasoning = new AlloyReasoning();
        final boolean reasoning = alloyReasoning.reasoning();
        if (!reasoning) {
          Visualization.sourceProvider.setPassive();
        }
        Visualization.showViz();
      }

    };
  }

  public ActionListener acceptReasonedRelationActionListener() {
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

  public ActionListener discoverAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setActive(ReasoningType.DISCOVER_ATOM);
          }
        });

        final AlloyDiscovering alloyDiscovering = new AlloyDiscovering();
        final boolean discovering = alloyDiscovering.discovering();
        if (!discovering) {
          Visualization.sourceProvider.setPassive();
        }
        Visualization.showViz();
      }
    };
  }

  public ActionListener nextSolutionActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (Visualization.sourceProvider.getReasoningType() == ReasoningType.DISCOVER_RELATION) {
          final boolean next = AlloyNextSolutionReasoning.getInstance().next();
          if (!next) {
            Visualization.sourceProvider.setPassive();
          }
        } else if (Visualization.sourceProvider.getReasoningType() == ReasoningType.DISCOVER_ATOM) {
          final boolean next = AlloyNextSolutionDiscovering.getInstance().next();
          if (!next) {
            Visualization.sourceProvider.setPassive();
          }
        }
        Visualization.showViz();
      }
    };
  }

  public ActionListener stopAnalysisActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setPassive();
          }
        });

        AlloyNextSolutionReasoning.getInstance().finishNext();
        Visualization.showViz();
      }

    };
  }

  public ActionListener clearAllReasonedActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        AlloyUtilities.clearAllReasonedTuplesAndAtoms();
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();

        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setPassive();
          }
        });
      }
    };
  }


  public ActionListener interpretAtomMenuItemActionListener() {
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
}
