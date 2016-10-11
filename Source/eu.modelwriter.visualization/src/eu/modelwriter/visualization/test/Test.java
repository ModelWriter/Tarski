package eu.modelwriter.visualization.test;

import java.util.List;

import javax.swing.JFrame;

import org.eclipse.emf.common.util.URI;

import eu.modelwriter.traceability.core.persistence.DocumentRoot;
import eu.modelwriter.traceability.core.persistence.internal.ModelIO;
import eu.modelwriter.visualization.IVisualization;
import eu.modelwriter.visualization.VisualizationFactory;
import eu.modelwriter.visualization.input.GraphInputFactory;

public class Test {
  public static String xmlFileLocation =
      ".modelwriter persistence.xml".replace(" ", System.getProperty("file.separator"));

  public static DocumentRoot getDocumentRoot() {
    @SuppressWarnings("rawtypes")
    final ModelIO modelIO = new ModelIO<>();
    @SuppressWarnings("rawtypes")
    final List list;
    list = modelIO.read(URI.createFileURI(
        "/home/emre/Documents/eclipse/runtime-EclipseApplication/" + Test.xmlFileLocation));
    if (list.isEmpty()) {
      return null;
    }
    final DocumentRoot documentRoot = (DocumentRoot) list.get(0);
    return documentRoot;
  }

  public static void main(final String[] args) {
    final IVisualization visualization = VisualizationFactory.createVisualizationJGraphx(
        GraphInputFactory.createGraphInputJGraphx(Test.getDocumentRoot()));
    final JFrame frame = new JFrame();
    frame.add(visualization.getGraph());
    frame.setVisible(true);
    frame.setAlwaysOnTop(true);
    frame.pack();


    final IVisualization visualization2 = VisualizationFactory
        .createVisualizationAlloy(GraphInputFactory.createGraphInputAlloy(Test.getDocumentRoot()));
    final JFrame frame2 = new JFrame();
    frame2.add(visualization2.getGraph());
    frame2.setVisible(true);
    frame2.setAlwaysOnTop(true);
    frame2.pack();

  }
}
