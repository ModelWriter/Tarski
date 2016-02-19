package eu.modelwriter.kodkod.editor.manager;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.kodkod.core.ModelBuildVisitor;
import eu.modelwriter.kodkod.core.model.Atom;
import eu.modelwriter.kodkod.editor.scanners.RelationModelPartitionScanner;
import eu.modelwriter.visualization.Notifier;

public class VisualizationSubscriber implements Notifier {
  IDocument document;

  public VisualizationSubscriber(final IDocument document) {
    this.document = document;
  }

  @Override
  public void addTupleNotify(final String arg0, final List<String> arg1, final String arg2) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final List<String> tuple = arg1;
          final String bound = arg2;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }

          v.getUniverse().getRelation(relationName)
              .addAtomWithTuple(bound.equals("lower") ? true : false, atomsOfTuple);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation = VisualizationSubscriber.this
              .getNewRelationLine4AddedTuple(relationLine, tuple, bound);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);

          if (tuple.size() == 1) {
            final String universeString =
                VisualizationSubscriber.this.getPartitionString(VisualizationSubscriber.this
                    .getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE));
            final String afterNewAtom = universeString.substring(universeString.indexOf("}"));
            final String newUniverseString =
                universeString.replace(afterNewAtom, ", " + tuple.get(0) + afterNewAtom);
            final int startOfUniverse =
                VisualizationSubscriber.this.document.get().indexOf(universeString);
            final int endOfUniverse = startOfUniverse + universeString.length();
            VisualizationSubscriber.this.document.replace(startOfUniverse, endOfUniverse,
                newUniverseString);
          }
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void addTupleNotify(final String arg0, final String arg1, final List<String> arg2,
      final String arg3) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final String inRelationName = arg1;
          final List<String> tuple = arg2;
          final String bound = arg3;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }

          v.getUniverse().getRelation(relationName)
              .addAtomWithTuple(bound.equals("lower") ? true : false, atomsOfTuple);
          v.getUniverse().getRelation(inRelationName)
              .addAtomWithTuple(bound.equals("lower") ? true : false, atomsOfTuple);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation = VisualizationSubscriber.this
              .getNewRelationLine4AddedTuple(relationLine, tuple, bound);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);

          if (tuple.size() == 1) {
            final String universeString =
                VisualizationSubscriber.this.getPartitionString(VisualizationSubscriber.this
                    .getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE));
            final String afterNewAtom = universeString.substring(universeString.indexOf("}"));
            final String newUniverseString =
                universeString.replace(afterNewAtom, ", " + tuple.get(0) + afterNewAtom);
            final int startOfUniverse =
                VisualizationSubscriber.this.document.get().indexOf(universeString);
            final int endOfUniverse = startOfUniverse + universeString.length();
            VisualizationSubscriber.this.document.replace(startOfUniverse, endOfUniverse,
                newUniverseString);
          }

          final String inRelationLine =
              VisualizationSubscriber.this.getRelationLine(inRelationName);
          final int startOfInRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfInRelationLine = startOfInRelationLine + inRelationLine.length();
          final String newRelationLineOfInRelation = VisualizationSubscriber.this
              .getNewRelationLine4AddedTuple(inRelationLine, tuple, bound);
          VisualizationSubscriber.this.document.replace(startOfInRelationLine, endOfInRelationLine,
              newRelationLineOfInRelation);

        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  private String getNewRelationLine4AddedTuple(final String relationLine, final List<String> tuple,
      final String bound) {
    final String tupleString = this.makeTupleString(tuple);
    String newRelationLine = relationLine;
    String beforeNewTuple;
    newRelationLine = newRelationLine.replaceAll("\\{", "[");
    newRelationLine = newRelationLine.replaceAll("\\}", "]");
    int index;
    if (bound.toLowerCase().equals("lower")) {
      index = newRelationLine.indexOf(":") + 1;
      newRelationLine = newRelationLine.substring(index);
      index += newRelationLine.indexOf("[") + 1;
      newRelationLine = newRelationLine.substring(newRelationLine.indexOf("[") + 1);
      index += newRelationLine.indexOf("[") + 1; // second '[' is found.
      beforeNewTuple = relationLine.substring(0, index);
      newRelationLine = relationLine.replace(beforeNewTuple, beforeNewTuple + tupleString + ",");
    } else if (bound.toLowerCase().equals("upper")) {
      index = newRelationLine.lastIndexOf("]");
      newRelationLine = newRelationLine.substring(0, index);
      index = newRelationLine.lastIndexOf("]");
      beforeNewTuple = relationLine.substring(0, index);
      newRelationLine = relationLine.replace(beforeNewTuple, beforeNewTuple + "," + tupleString);
    }
    return newRelationLine;
  }

  protected String getNewRelationLine4MovedLowerTuple(final String relationLine,
      final List<String> tuple) {
    return null;
  }

  protected String getNewRelationLine4MovedUpperTuple(final String relationLine,
      final List<String> tuple) {
    final StringBuilder builder = new StringBuilder(relationLine);
    final int indexOf = builder.indexOf(tuple.toString());
    builder.delete(indexOf, indexOf + tuple.toString().length());

    System.out.println("");

    return null;
  }

  protected String getNewRelationLine4RemovedTuple(final String relationLine,
      final List<String> tuple, final String bound) {
    return null;
  }

  private ITypedRegion getPartition(final String partitionContentType) {
    final IDocumentExtension3 extension = (IDocumentExtension3) this.document;
    ITypedRegion[] computePartitioning = null;
    try {
      computePartitioning = extension.computePartitioning(IDocumentExtension3.DEFAULT_PARTITIONING,
          0, this.document.getLength(), false);
    } catch (BadLocationException | BadPartitioningException e) {
      e.printStackTrace();
    }

    for (final ITypedRegion iTypedRegion : computePartitioning) {
      if (iTypedRegion.getType().equals(partitionContentType)) {
        return iTypedRegion;
      }
    }
    return null;
  }

  private String getPartitionString(final ITypedRegion partition) {
    String partitionString = null;
    try {
      partitionString = this.document.get(partition.getOffset(), partition.getLength());
    } catch (final BadLocationException e) {
      e.printStackTrace();
    }
    return partitionString;
  }

  private String getRelationLine(final String relationName) {
    String relBoundString = this.getPartitionString(
        this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND));

    String relationLine = "";
    relBoundString = relBoundString.replaceAll("\r", "\n");
    final String[] split = relBoundString.split("\n");
    for (final String line : split) {
      if (line.contains(":")) {
        final String leftSideOfLine = line.substring(0, line.indexOf(':'));
        if (leftSideOfLine.contains(relationName)) {
          relationLine = line;
          break;
        }
      }
    }
    return relationLine;
  }

  String makeTupleString(final List<String> atoms) {
    String tupleString = "";
    tupleString += "[";

    final String atom = atoms.get(0);
    if (atom != null) {
      tupleString += atom;
    }

    for (int i = 1; i < atoms.size(); i++) {
      tupleString += ", " + atoms.get(i);
    }

    tupleString += "]";
    return tupleString;
  }

  @Override
  public void moveToLower(final String arg0, final List<String> arg1) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final List<String> tuple = arg1;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }

          v.getUniverse().getRelation(relationName).getTuple(atomsOfTuple).setLowerBound(true);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation =
              VisualizationSubscriber.this.getNewRelationLine4MovedLowerTuple(relationLine, tuple);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void moveToLower(final String arg0, final String arg1, final List<String> arg2) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final String inRelationName = arg1;
          final List<String> tuple = arg2;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }

          v.getUniverse().getRelation(relationName).getTuple(atomsOfTuple).setLowerBound(true);
          v.getUniverse().getRelation(inRelationName).getTuple(atomsOfTuple).setLowerBound(true);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation =
              VisualizationSubscriber.this.getNewRelationLine4MovedLowerTuple(relationLine, tuple);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);

          final String inRelationLine =
              VisualizationSubscriber.this.getRelationLine(inRelationName);
          final int startOfInRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(inRelationLine);
          final int endOfInRelationLine = startOfInRelationLine + inRelationLine.length();
          final String newRelationLineOfInRelation = VisualizationSubscriber.this
              .getNewRelationLine4MovedLowerTuple(inRelationLine, tuple);
          VisualizationSubscriber.this.document.replace(startOfInRelationLine, endOfInRelationLine,
              newRelationLineOfInRelation);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void moveToUpper(final String arg0, final List<String> arg1) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final List<String> tuple = arg1;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }
          v.getUniverse().getRelation(relationName).getTuple(atomsOfTuple).setLowerBound(false);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation =
              VisualizationSubscriber.this.getNewRelationLine4MovedUpperTuple(relationLine, tuple);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void moveToUpper(final String arg0, final String arg1, final List<String> arg2) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final String inRelationName = arg1;
          final List<String> tuple = arg2;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }
          v.getUniverse().getRelation(relationName).getTuple(atomsOfTuple).setLowerBound(false);
          v.getUniverse().getRelation(inRelationName).getTuple(atomsOfTuple).setLowerBound(false);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation =
              VisualizationSubscriber.this.getNewRelationLine4MovedUpperTuple(relationLine, tuple);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);

          final String inRelationLine =
              VisualizationSubscriber.this.getRelationLine(inRelationName);
          final int startOfInRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(inRelationLine);
          final int endOfInRelationLine = startOfInRelationLine + inRelationLine.length();
          final String newRelationLineOfInRelation = VisualizationSubscriber.this
              .getNewRelationLine4MovedUpperTuple(inRelationLine, tuple);
          VisualizationSubscriber.this.document.replace(startOfInRelationLine, endOfInRelationLine,
              newRelationLineOfInRelation);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void notify(final Serializable arg0) {}

  @Override
  public void removeTupleNotify(final String arg0, final List<String> arg1, final String arg2) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final List<String> tuple = arg1;
          final String bound = arg2;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }

          v.getUniverse().getRelation(relationName).removeTuple(atomsOfTuple);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation = VisualizationSubscriber.this
              .getNewRelationLine4RemovedTuple(relationLine, tuple, bound);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);

          if (tuple.size() == 1) {
            final String universeString =
                VisualizationSubscriber.this.getPartitionString(VisualizationSubscriber.this
                    .getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE));
            final String newUniverseString = "";
            final int startOfUniverse =
                VisualizationSubscriber.this.document.get().indexOf(universeString);
            final int endOfUniverse = startOfUniverse + universeString.length();
            VisualizationSubscriber.this.document.replace(startOfUniverse, endOfUniverse,
                newUniverseString);
          }
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void removeTupleNotify(final String arg0, final String arg1, final List<String> arg2,
      final String arg3) {
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          final String relationName = arg0;
          final String inRelationName = arg1;
          final List<String> tuple = arg2;
          final String bound = arg3;

          final ModelBuildVisitor v = new ModelBuildVisitor();
          final Atom atomsOfTuple[] = new Atom[tuple.size()];
          for (int i = 0; i < atomsOfTuple.length; i++) {
            atomsOfTuple[i] = new Atom(tuple.get(i));
          }
          v.getUniverse().getRelation(relationName).removeTuple(atomsOfTuple);
          v.getUniverse().getRelation(inRelationName).removeTuple(atomsOfTuple);

          final String relationLine = VisualizationSubscriber.this.getRelationLine(relationName);
          final int startOfRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfRelationLine = startOfRelationLine + relationLine.length();
          final String newRelationLineOfRelation = VisualizationSubscriber.this
              .getNewRelationLine4RemovedTuple(relationLine, tuple, bound);
          VisualizationSubscriber.this.document.replace(startOfRelationLine, endOfRelationLine,
              newRelationLineOfRelation);

          if (tuple.size() == 1) {
            final String universeString =
                VisualizationSubscriber.this.getPartitionString(VisualizationSubscriber.this
                    .getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE));
            final String newUniverseString = "";
            final int startOfUniverse =
                VisualizationSubscriber.this.document.get().indexOf(universeString);
            final int endOfUniverse = startOfUniverse + universeString.length();
            VisualizationSubscriber.this.document.replace(startOfUniverse, endOfUniverse,
                newUniverseString);
          }

          final String inRelationLine =
              VisualizationSubscriber.this.getRelationLine(inRelationName);
          final int startOfInRelationLine =
              VisualizationSubscriber.this.document.get().indexOf(relationLine);
          final int endOfInRelationLine = startOfInRelationLine + inRelationLine.length();
          final String newRelationLineOfInRelation = VisualizationSubscriber.this
              .getNewRelationLine4RemovedTuple(inRelationLine, tuple, bound);
          VisualizationSubscriber.this.document.replace(startOfInRelationLine, endOfInRelationLine,
              newRelationLineOfInRelation);

        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
