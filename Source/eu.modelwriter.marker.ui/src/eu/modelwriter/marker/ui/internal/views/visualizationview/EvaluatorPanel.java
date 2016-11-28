package eu.modelwriter.marker.ui.internal.views.visualizationview;

import java.io.File;

import javax.swing.JScrollPane;

import edu.mit.csail.sdg.alloy4.OurConsole;
import eu.modelwriter.configuration.alloy.evaluator.Evaluator;

public final class EvaluatorPanel {
  private EvaluatorPanel() {}

  public static JScrollPane getInstance(final String xmlPath) {
    final Evaluator evaluator = new Evaluator();
    final JScrollPane instance = new OurConsole(evaluator, true, "The ", true, "Alloy Evaluator ",
        false, "allows you to type\nin Alloy expressions and see their values.\nFor example, ",
        true, "univ", false,
        " shows the list of all atoms.\n(You can press UP and DOWN to recall old inputs).\n");
    try {
      evaluator.compute(new File(xmlPath));
    } catch (final Exception ex) {
    } // exception should not happen
    return instance;
  }
}
