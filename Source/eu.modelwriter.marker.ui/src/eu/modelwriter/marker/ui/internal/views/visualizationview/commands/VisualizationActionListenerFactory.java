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
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.ReasoningType;
import eu.modelwriter.configuration.alloy.discovery.AlloyDiscovering;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.configuration.alloy.reasoning.AlloyReasoning;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.configuration.specificreasoning.AlloyNextSolutionReasoningForAtom;
import eu.modelwriter.configuration.specificreasoning.AlloyReasoningForAtom;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.interpretationwizard.InterpretationWizard;

public class VisualizationActionListenerFactory {
  private static VisualizationActionListenerFactory instance;

  public static Set<VisualizationListener> listeners = new HashSet<VisualizationListener>();

  private VisualizationActionListenerFactory() {}

  public static VisualizationActionListenerFactory get() {
    if (VisualizationActionListenerFactory.instance == null) {
      VisualizationActionListenerFactory.instance = new VisualizationActionListenerFactory();
    }
    return VisualizationActionListenerFactory.instance;
  }

  public void registerListener(VisualizationListener listener) {
    if (listener != null) {
      synchronized (listeners) {
        listeners.add(listener);
      }
    }
  }

  public void unregisterListener(VisualizationListener listener) {
    synchronized (listeners) {
      listeners.remove(listener);
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
        IMarker marker = Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation);
        Display.getDefault().syncExec(new AddRemoveTypeCommand(marker));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
        for (VisualizationListener listener : listeners) {
          listener.onAtomRemoved(marker);
        }
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
        IMarker marker = Visualization.getMarker((AlloyAtom) Visualization.rightClickedAnnotation);
        Display.getDefault().syncExec(new DeleteAtomCommand(marker));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
        for (VisualizationListener listener : listeners) {
          listener.onAtomRemoved((AlloyAtom) Visualization.rightClickedAnnotation);
          // listener.onAtomRemoved(marker);
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
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public static ActionListener removeRelationActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        IMarker startMarker =
            Visualization.getMarker(((AlloyTuple) Visualization.rightClickedAnnotation).getStart());
        IMarker endMarker =
            Visualization.getMarker(((AlloyTuple) Visualization.rightClickedAnnotation).getEnd());
        String relation = Visualization.relation;
        Display.getDefault().syncExec(new RemoveRelationCommand(startMarker, endMarker, relation));
        Visualization.showViz();
        AlloyNextSolutionReasoning.getInstance().finishNext();
        for (VisualizationListener listener : listeners) {
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

  public static ActionListener discoverRelationActionListener() {
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

  public static ActionListener discoverRelationForAtomActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            Visualization.sourceProvider.setActive(ReasoningType.DISCOVER_RELATION_FOR_ATOM);
          }
        });
        final AlloyAtom alloyAtom = (AlloyAtom) Visualization.rightClickedAnnotation;

        final String atomType = alloyAtom.getType().getName();
        final String atomName = alloyAtom.toString();

        final AlloyReasoningForAtom alloyReasoningForAtom = new AlloyReasoningForAtom();
        final boolean reasoning = alloyReasoningForAtom.reasoning(atomName, atomType);
        if (!reasoning) {
          Visualization.sourceProvider.setPassive();
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

        for (VisualizationListener listener : listeners) {
          listener.onReasonedRelationAccepted(fromMarker, toMarker, Visualization.relation);
        }
      }
    };
  }

  public static ActionListener discoverAtomActionListener() {
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

  public static ActionListener nextSolutionActionListener() {
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
        } else if (Visualization.sourceProvider
            .getReasoningType() == ReasoningType.DISCOVER_RELATION_FOR_ATOM) {
          final boolean next = AlloyNextSolutionReasoningForAtom.getInstance().next();
          if (!next) {
            Visualization.sourceProvider.setPassive();
          }
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
            Visualization.sourceProvider.setPassive();
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
            Visualization.sourceProvider.setPassive();
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
        for (VisualizationListener listener : listeners) {
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
        for (VisualizationListener listener : listeners) {
          listener.onReasonedRelationAccepted(tuple.getStart(), tuple.getEnd(),
              Visualization.relation);
        }
      }
    };
  }
}
