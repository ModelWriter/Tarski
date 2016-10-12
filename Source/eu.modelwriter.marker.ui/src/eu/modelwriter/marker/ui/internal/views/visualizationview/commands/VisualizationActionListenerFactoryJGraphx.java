package eu.modelwriter.marker.ui.internal.views.visualizationview.commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxICell;

import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.ReasoningType;
import eu.modelwriter.configuration.alloy.discovery.AlloyDiscovering;
import eu.modelwriter.configuration.alloy.discovery.AlloyNextSolutionDiscovering;
import eu.modelwriter.configuration.alloy.reasoning.AlloyNextSolutionReasoning;
import eu.modelwriter.configuration.alloy.reasoning.AlloyReasoning;
import eu.modelwriter.configuration.alloy.validation.AlloyValidator;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.visualizationview.TraceabilityViewJGraphx;
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
        TraceabilityViewJGraphx.show();
      }
    };
  }

  public ActionListener addRemoveTypeActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new AddRemoveTypeCommand(
            TraceabilityViewJGraphx
            .getMarker((mxICell) TraceabilityViewJGraphx.rightClickedAnnotation)));
        TraceabilityViewJGraphx.show();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public ActionListener createNewAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent arg0) {
        Display.getDefault().syncExec(new CreateNewAtomCommand());
        TraceabilityViewJGraphx.show();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public ActionListener deleteAtomActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new DeleteAtomCommand(
            TraceabilityViewJGraphx
            .getMarker((mxICell) TraceabilityViewJGraphx.rightClickedAnnotation)));
        TraceabilityViewJGraphx.show();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public ActionListener mappingActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new MappingCommand(
            TraceabilityViewJGraphx
            .getMarker((mxICell) TraceabilityViewJGraphx.rightClickedAnnotation)));
        TraceabilityViewJGraphx.show();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }

  public ActionListener removeRelationActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault().syncExec(new RemoveRelationCommand(
            TraceabilityViewJGraphx.getMarker(
                ((mxCell) TraceabilityViewJGraphx.rightClickedAnnotation).getSource()),
            TraceabilityViewJGraphx
            .getMarker(((mxCell) TraceabilityViewJGraphx.rightClickedAnnotation).getTarget()),
            Visualization.relation));
        TraceabilityViewJGraphx.show();
        AlloyNextSolutionReasoning.getInstance().finishNext();
      }
    };
  }


  public ActionListener resolveActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        Display.getDefault()
        .syncExec(new ResolveCommand(TraceabilityViewJGraphx.rightClickedAnnotation));
        TraceabilityViewJGraphx.show();
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
            TraceabilityViewJGraphx.sourceProvider.setActive(ReasoningType.DISCOVER_RELATION);
          }
        });

        final AlloyReasoning alloyReasoning = new AlloyReasoning();
        final boolean reasoning = alloyReasoning.reasoning();
        if (!reasoning) {
          TraceabilityViewJGraphx.sourceProvider.setPassive();
        }
        TraceabilityViewJGraphx.show();
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

      private IMarker interpretAtom(final mxICell fromAtom) {
        showWizard();
        if (selectedMarker == null) {
          return null;
        }

        final String sigTypeName = fromAtom.getValue().toString();
        // TODO TODOOOO
        final String stringIndex = fromAtom.toString().substring(sigTypeName.length());
        int index = 0;
        if (!stringIndex.isEmpty()) {
          index = Integer.parseInt(stringIndex);
        }

        AlloyUtilities.bindAtomToMarker(sigTypeName, index, selectedMarker);
        TraceabilityViewJGraphx.show();
        return selectedMarker;
      }

      @Override
      public void actionPerformed(final ActionEvent e) {
        if (TraceabilityViewJGraphx.container == null) {
          return;
        }
        final mxCell tuple = (mxCell) TraceabilityViewJGraphx.rightClickedAnnotation;
        final mxICell fromAtom = tuple.getSource();
        final mxICell toAtom = tuple.getTarget();
        IMarker fromMarker = TraceabilityViewJGraphx.getMarker(fromAtom);
        IMarker toMarker = TraceabilityViewJGraphx.getMarker(toAtom);

        if (fromMarker == null) {
          fromMarker = interpretAtom(fromAtom);
        } else if (toMarker == null) {
          toMarker = interpretAtom(toAtom);
        }

        AlloyUtilities.resetReasoned(fromMarker, toMarker, TraceabilityViewJGraphx.relation);
        TraceabilityViewJGraphx.show();
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
            TraceabilityViewJGraphx.sourceProvider.setActive(ReasoningType.DISCOVER_ATOM);
          }
        });

        final AlloyDiscovering alloyDiscovering = new AlloyDiscovering();
        final boolean discovering = alloyDiscovering.discovering();
        if (!discovering) {
          TraceabilityViewJGraphx.sourceProvider.setPassive();
        }
        TraceabilityViewJGraphx.show();
      }
    };
  }

  public ActionListener nextSolutionActionListener() {
    return new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (TraceabilityViewJGraphx.sourceProvider
            .getReasoningType() == ReasoningType.DISCOVER_RELATION) {
          final boolean next = AlloyNextSolutionReasoning.getInstance().next();
          if (!next) {
            TraceabilityViewJGraphx.sourceProvider.setPassive();
          }
        } else if (TraceabilityViewJGraphx.sourceProvider
            .getReasoningType() == ReasoningType.DISCOVER_ATOM) {
          final boolean next = AlloyNextSolutionDiscovering.getInstance().next();
          if (!next) {
            TraceabilityViewJGraphx.sourceProvider.setPassive();
          }
        }
        TraceabilityViewJGraphx.show();
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
            TraceabilityViewJGraphx.sourceProvider.setPassive();
          }
        });

        AlloyNextSolutionReasoning.getInstance().finishNext();
        TraceabilityViewJGraphx.show();
      }

    };
  }

  public ActionListener clearAllReasonedActionListener() {
    return new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent e) {
        AlloyUtilities.clearAllReasonedTuplesAndAtoms();
        TraceabilityViewJGraphx.show();
        AlloyNextSolutionReasoning.getInstance().finishNext();

        Activator.getDefault().getWorkbench().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            TraceabilityViewJGraphx.sourceProvider.setPassive();
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
        final AlloyAtom alloyAtom = (AlloyAtom) TraceabilityViewJGraphx.rightClickedAnnotation;

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
        TraceabilityViewJGraphx.show();
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
