package com.mxgraph.examples.swing.visualization;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxDomUtils;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxMultiplicity;

public class Visualization extends JFrame {
  private static final long serialVersionUID = 1L;

  public static void main(final String[] args) {
    final Visualization frame = new Visualization();
    JFrame.setDefaultLookAndFeelDecorated(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(870, 640);
    frame.setVisible(true);
  }

  public Visualization() {
    super("Visualization");

    final VisualizationGraphEditor vge = new VisualizationGraphEditor();
    final mxGraph graph = vge.getGraph();
    final mxGraphComponent graphComponent = vge.getGraphComponent();

    graph.setMultiplicities(this.createMultiplicities());
    this.createSample(graph);

    // Initial validation
    graphComponent.validateGraph();

    this.getContentPane().add(graphComponent);
  }

  private mxMultiplicity[] createMultiplicities() {
    final mxMultiplicity[] multiplicities = new mxMultiplicity[3];

    multiplicities[0] =
        new mxMultiplicity(true, "Alias", null, null, 0, String.valueOf(Integer.MAX_VALUE),
            Arrays.asList(new String[] {"Word"}), null, "Alias Must Connect to Word", true);

    multiplicities[1] =
        new mxMultiplicity(true, "Directory", null, null, 0, String.valueOf(Integer.MAX_VALUE),
            Arrays.asList(new String[] {"Word", "Alias", "Directory", "Root"}), null,
            "Directory Must Connect to Object", true);

    multiplicities[2] =
        new mxMultiplicity(true, "Root", null, null, 0, String.valueOf(Integer.MAX_VALUE),
            Arrays.asList(new String[] {"Word", "Alias", "Directory", "Root"}), null,
            "final Directory Must Connect final to Object", true);

    multiplicities[2] = new mxMultiplicity(true, "Word", null, null, 0, "0", null,
        "Word can not connect to any other", null, true);
    return multiplicities;
  }

  private void createSample(final mxGraph graph) {
    final Document xmlDocument = mxDomUtils.createDocument();

    final Element Relation = xmlDocument.createElement("Relation");
    xmlDocument.appendChild(Relation);

    final Element Root$0 = xmlDocument.createElement("Root");
    Relation.appendChild(Root$0);
    Root$0.setAttribute("label", "Root$0");
    final Element Directory$0 = xmlDocument.createElement("Directory");
    Relation.appendChild(Directory$0);
    Directory$0.setAttribute("label", "Directory$0");
    final Element Directory$1 = xmlDocument.createElement("Directory");
    Relation.appendChild(Directory$1);
    Directory$1.setAttribute("label", "Directory$1");
    final Element Alias$0 = xmlDocument.createElement("Alias");
    Relation.appendChild(Alias$0);
    Alias$0.setAttribute("label", "Alias$0");
    final Element Alias$1 = xmlDocument.createElement("Alias");
    Relation.appendChild(Alias$1);
    Alias$1.setAttribute("label", "Alias$1");
    final Element Alias$2 = xmlDocument.createElement("Alias");
    Relation.appendChild(Alias$2);
    Alias$2.setAttribute("label", "Alias$2");
    final Element Word$0 = xmlDocument.createElement("Word");
    Relation.appendChild(Word$0);
    Word$0.setAttribute("label", "Word$0");
    final Element Word$1 = xmlDocument.createElement("Word");
    Relation.appendChild(Word$1);
    Word$1.setAttribute("label", "Word$1");
    final Element Word$2 = xmlDocument.createElement("Word");
    Relation.appendChild(Word$2);
    Word$2.setAttribute("label", "Word$2");
    final Element Word$3 = xmlDocument.createElement("Word");
    Relation.appendChild(Word$3);
    Word$3.setAttribute("label", "Word$3");

    Transformer transformer;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
      final DOMSource source = new DOMSource(xmlDocument);
      final StreamResult console =
          new StreamResult(new File("C:/Users/emre.kirmizi/Desktop/out.xml"));
      // final StreamResult console =
      // new StreamResult(new File("C:/Users/anil.ozturk/Desktop/out.xml"));
      transformer.transform(source, console);
    } catch (TransformerFactoryConfigurationError | TransformerException e) {
      e.printStackTrace();
    }

    final Object parent = graph.getDefaultParent();

    graph.getModel().beginUpdate();
    try {
      final Object R0 = graph.insertVertex(parent, null, Root$0, 350, 20, 80, 30);
      final Object D0 = graph.insertVertex(parent, null, Directory$0, 470, 100, 80, 30);
      final Object D1 = graph.insertVertex(parent, null, Directory$1, 530, 180, 80, 30);
      final Object A0 = graph.insertVertex(parent, null, Alias$0, 350, 100, 80, 30);
      final Object A1 = graph.insertVertex(parent, null, Alias$1, 230, 100, 80, 30);
      final Object A2 = graph.insertVertex(parent, null, Alias$2, 440, 260, 80, 30);
      final Object W0 = graph.insertVertex(parent, null, Word$0, 300, 360, 80, 30);
      final Object W1 = graph.insertVertex(parent, null, Word$1, 400, 360, 80, 30);
      final Object W2 = graph.insertVertex(parent, null, Word$2, 500, 360, 80, 30);
      final Object W3 = graph.insertVertex(parent, null, Word$3, 600, 360, 80, 30);
      graph.insertEdge(parent, null, "contents", R0, A0);
      graph.insertEdge(parent, null, "contents", R0, A1);
      graph.insertEdge(parent, null, "contents", R0, D0);
      graph.insertEdge(parent, null, "contents", D0, D1);
      graph.insertEdge(parent, null, "contents", D0, W0);
      graph.insertEdge(parent, null, "contents", D1, W1);
      graph.insertEdge(parent, null, "contents", D1, W2);
      graph.insertEdge(parent, null, "contents", D1, W3);
      graph.insertEdge(parent, null, "contents", D1, A2);
      graph.insertEdge(parent, null, "refs", A2, W0);
      graph.insertEdge(parent, null, "refs", A2, W1);
      graph.insertEdge(parent, null, "refs", A2, W2);
      graph.insertEdge(parent, null, "refs", A2, W3);
    } finally {
      graph.getModel().endUpdate();
    }
  }
}
