package eu.modelwriter.visualization.convertAlloyInstance;

import eu.modelwriter.visualization.convertAlloyInstance.model.Atom;
import eu.modelwriter.visualization.convertAlloyInstance.model.Relation;
import eu.modelwriter.visualization.convertAlloyInstance.model.Relation.Multiplicity;
import eu.modelwriter.visualization.convertAlloyInstance.model.Universe;

public class Test4ConvertUniverse2AlloyInstance {

  public static Universe createFileSystemExample() {
    final Universe universe = new Universe();

    /* Sigs definitions */
    final Relation Object = new Relation("Object");
    final Relation Directory = new Relation("Directory");
    final Relation Root = new Relation("Root");
    final Relation File = new Relation("File");
    final Relation Word = new Relation("Word");
    final Relation Alias = new Relation("Alias");
    final Relation Ferhat = new Relation("Ferhat");
    final Relation Serhat = new Relation("Serhat");
    final Relation Anil = new Relation("Anil");

    Directory.setParent(Object);
    Directory.setUnary(true);
    Root.setParent(Directory);
    Root.setUnary(true);
    File.setParent(Object);
    File.setUnary(true);
    Word.setParent(File);
    Word.setUnary(true);
    Alias.setParent(Object);
    Alias.setUnary(true);

    Object.setAbstract(true);
    Object.setUnary(true);
    Root.setMultiplicity(Multiplicity.ONE);

    Ferhat.setUnary(true);
    Serhat.setUnary(true);
    Anil.setUnary(true);

    final Atom Root$0 = new Atom("Root$0");

    final Atom Directory$0 = new Atom("Directory$0");
    final Atom Directory$1 = new Atom("Directory$1");

    final Atom Alias$0 = new Atom("Alias$0");
    final Atom Alias$1 = new Atom("Alias$1");
    final Atom Alias$2 = new Atom("Alias$2");

    final Atom Word$0 = new Atom("Word$0");
    final Atom Word$1 = new Atom("Word$1");
    final Atom Word$2 = new Atom("Word$2");
    final Atom Word$3 = new Atom("Word$3");

    final Atom $Ferhat$ = new Atom("$Ferhat$");
    final Atom $Serhat$ = new Atom("$Serhat$");
    final Atom $Anil$ = new Atom("$Anil$");

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

    Serhat.addAtomWithTuple($Serhat$);
    Ferhat.addAtomWithTuple($Ferhat$);
    Anil.addAtomWithTuple($Anil$);

    /* Sigs definitions end */

    /* Fields definitions */
    final Relation contents = new Relation("contents");
    final Relation refs = new Relation("refs");
    final Relation emre = new Relation("emre");

    contents.setParent(Directory);
    contents.addTypes(Directory, Object);

    refs.setParent(Alias);
    refs.addTypes(Alias, Word);

    emre.setParent(Ferhat);
    emre.addTypes(Ferhat, Anil);
    emre.addTypes(Ferhat, Serhat);

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

    emre.addAtomWithTuple($Ferhat$, $Serhat$);
    emre.addAtomWithTuple($Ferhat$, $Anil$);

    /* Fields definitions end */

    universe.addRelation(Object);
    universe.addRelation(Directory);
    universe.addRelation(Root);
    universe.addRelation(File);
    universe.addRelation(Word);
    universe.addRelation(Alias);
    universe.addRelation(Ferhat);
    universe.addRelation(Serhat);
    universe.addRelation(Anil);

    universe.addRelation(contents);
    universe.addRelation(refs);
    universe.addRelation(emre);

    return universe;
  }

  public static void main(final String[] args) {
    final Visualization visualization = new Visualization();
    visualization.show(Test4ConvertUniverse2AlloyInstance.createFileSystemExample());
  }
}
