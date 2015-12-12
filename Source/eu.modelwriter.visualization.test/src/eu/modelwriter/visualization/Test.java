package eu.modelwriter.visualization;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.mit.csail.sdg.alloy4.ErrorFatal;
import eu.modelwriter.visualization.model.Atom;
import eu.modelwriter.visualization.model.Relation;
import eu.modelwriter.visualization.model.Relation.Multiplicity;
import eu.modelwriter.visualization.model.Universe;

public class Test {
  public static void main(final String[] args) {
    // final Visualization visualization = new Visualization();
    // visualization.showModel();
    // visualization.showMetamodel();

    try {
      JPanel panel = GraphMaker.produceGraph(createFileSystemExample());
      Frame frame = new JFrame("");
      frame.add(panel);
      frame.setVisible(true);
      frame.setSize(600, 600);
    } catch (ErrorFatal e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static Universe createFileSystemExample() {
    Universe universe = new Universe();

    /* Sigs definitions */
    Relation Object = new Relation("Object");
    Relation Directory = new Relation("Directory");
    Relation Root = new Relation("Root");
    Relation File = new Relation("File");
    Relation Word = new Relation("Word");
    Relation Alias = new Relation("Alias");

    Directory.setParent(Object);
    Root.setParent(Directory);
    File.setParent(Object);
    Word.setParent(File);
    Alias.setParent(Object);

    Object.setAbstract(true);
    Root.setMultiplicity(Multiplicity.ONE);

    Atom Root$0 = new Atom("Root$0");

    Atom Directory$0 = new Atom("Directory$0");
    Atom Directory$1 = new Atom("Directory$1");

    Atom Alias$0 = new Atom("Alias$0");
    Atom Alias$1 = new Atom("Alias$1");
    Atom Alias$2 = new Atom("Alias$2");

    Atom Word$0 = new Atom("Word$0");
    Atom Word$1 = new Atom("Word$1");
    Atom Word$2 = new Atom("Word$2");
    Atom Word$3 = new Atom("Word$3");


    Root.addAtomWithTuple(Root$0);

    Directory.addAtomWithTuple(Directory$0);
    Directory.addAtomWithTuple(Directory$1);

    Word.addAtomWithTuple(Word$0);
    Word.addAtomWithTuple(Word$1);
    Word.addAtomWithTuple(Word$2);
    Word.addAtomWithTuple(Word$3);

    Alias.addAtomWithTuple(Alias$0);
    Alias.addAtomWithTuple(Alias$1);
    Alias.addAtomWithTuple(Alias$2);

    /* Sigs definitions end */

    /* Fields definitions */
    Relation contents = new Relation("contents");
    Relation refs = new Relation("refs");

    contents.setParent(Directory);
    refs.setParent(Alias);

    contents.addTypes(Directory, Object);
    refs.addTypes(Alias, Word);

    contents.addAtomWithTuple(Root$0, Alias$0);
    contents.addAtomWithTuple(Root$0, Directory$0);
    contents.addAtomWithTuple(Root$0, Alias$1);
    contents.addAtomWithTuple(Directory$0, Word$0);
    contents.addAtomWithTuple(Directory$0, Directory$1);
    contents.addAtomWithTuple(Directory$1, Word$1);
    contents.addAtomWithTuple(Directory$1, Word$2);
    contents.addAtomWithTuple(Directory$1, Word$3);
    contents.addAtomWithTuple(Directory$1, Alias$2);

    refs.addAtomWithTuple(Alias$2, Word$0);
    refs.addAtomWithTuple(Alias$2, Word$1);
    refs.addAtomWithTuple(Alias$2, Word$2);
    refs.addAtomWithTuple(Alias$2, Word$3);

    /* Fields definitions end */

    universe.addRelation(Object);
    universe.addRelation(Directory);
    universe.addRelation(Root);
    universe.addRelation(File);
    universe.addRelation(Word);
    universe.addRelation(Alias);

    universe.addRelation(contents);
    universe.addRelation(refs);

    return universe;
  }

  public static Universe createInExample() {

    Universe universe = new Universe();

    Relation Ferhat = new Relation("Ferhat");
    Relation Anil = new Relation("Anil");
    Relation Serhat = new Relation("Serhat");

    Atom Ferhat$0 = new Atom("Ferhat$0");
    Atom Ferhat$1 = new Atom("Ferhat$1");
    Atom Ferhat$2 = new Atom("Ferhat$2");

    Atom Anil$0 = new Atom("Anil$0");

    Atom Serhat$0 = new Atom("Serhat$0");
    Atom Serhat$1 = new Atom("Serhat$1");
    Atom Serhat$2 = new Atom("Serhat$2");
    Atom Serhat$3 = new Atom("Serhat$3");
    Atom Serhat$4 = new Atom("Serhat$4");
    Atom Serhat$5 = new Atom("Serhat$5");
    Atom Serhat$6 = new Atom("Serhat$6");


    Ferhat.addAtomWithTuple(Ferhat$0);
    Ferhat.addAtomWithTuple(Ferhat$1);
    Ferhat.addAtomWithTuple(Ferhat$2);

    Anil.addAtomWithTuple(Anil$0);

    Serhat.addAtomWithTuple(Serhat$0);
    Serhat.addAtomWithTuple(Serhat$1);
    Serhat.addAtomWithTuple(Serhat$2);
    Serhat.addAtomWithTuple(Serhat$3);
    Serhat.addAtomWithTuple(Serhat$4);
    Serhat.addAtomWithTuple(Serhat$5);
    Serhat.addAtomWithTuple(Serhat$6);


    Relation emre = new Relation("emre");

    emre.setParent(Ferhat);

    emre.addTypes(Ferhat, Serhat);
    emre.addTypes(Ferhat, Anil);

    emre.addAtomWithTuple(Ferhat$0, Serhat$6);
    emre.addAtomWithTuple(Ferhat$1, Serhat$5);
    emre.addAtomWithTuple(Ferhat$2, Serhat$4);
    emre.addAtomWithTuple(Ferhat$0, Anil$0);

    universe.addRelation(Ferhat);
    universe.addRelation(Anil);
    universe.addRelation(Serhat);
    universe.addRelation(emre);

    return universe;
  }
}
