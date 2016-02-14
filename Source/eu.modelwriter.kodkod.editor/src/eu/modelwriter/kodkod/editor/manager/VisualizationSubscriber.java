package eu.modelwriter.kodkod.editor.manager;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.swt.widgets.Display;

import eu.modelwriter.kodkod.core.printer.PrettyPrinter;
import eu.modelwriter.kodkod.editor.scanners.RelationModelPartitionScanner;
import eu.modelwriter.visualization.Notifier;

public class VisualizationSubscriber implements Notifier {
  IDocument document;

  public VisualizationSubscriber(final IDocument document) {
    this.document = document;
  }

  @Override
  public void addTupleNotify(final String arg0, final List<String> arg1, final String arg2) {
    final String relationName = arg0;
    final List<String> tuple = arg1;
    final String bound = arg2;

    System.out.println(
        "relation:" + relationName + "\ntuple:" + tuple + "\nbound:" + bound + "\nwanted add.");

    // final ITypedRegion relBoundPartition =
    // this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);
    // final String relBoundString = this.getPartitionString(relBoundPartition);

    final PrettyPrinter pp = new PrettyPrinter();
    final String documentString = pp.addTuple(this.document.get(), relationName, tuple, bound);

    // final int indexOfRelationLine = relBoundPartition.getOffset();
    // final int lastIndexOfRelationLine = indexOfRelationLine + relBoundPartition.getLength();

    // TODO partiton parser yapilinca sadece partition string gonderilecek ve dokumanda sadece
    // ilgili kisim degistirilecek.
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          VisualizationSubscriber.this.document.replace(0,
              VisualizationSubscriber.this.document.getLength(), documentString);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @SuppressWarnings("unused")
  private String getNewRelationLine4AddedTuple(final String relationLine, final String tupleString,
      final String bound) {
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

  @SuppressWarnings("unused")
  private String getNewRelationLine4RemovedTuple(final String relationLine,
      final String tupleString, final String bound) {
    final String newRelationLine = relationLine;
    // String beforeNewTuple;
    // newRelationLine = newRelationLine.replaceAll("\\{", "[");
    // newRelationLine = newRelationLine.replaceAll("\\}", "]");
    // int index;
    // if (bound.toLowerCase().equals("lower")) {
    // index = newRelationLine.indexOf(":") + 1;
    // newRelationLine = newRelationLine.substring(index);
    // index += newRelationLine.indexOf("[") + 1;
    // newRelationLine = newRelationLine.substring(newRelationLine.indexOf("[") + 1);
    // index += newRelationLine.indexOf("[") + 1; // second '[' is found.
    // beforeNewTuple = relationLine.substring(0, index);
    // newRelationLine = relationLine.replace(beforeNewTuple, beforeNewTuple + tupleString + ",");
    // } else if (bound.toLowerCase().equals("upper"){
    // index = newRelationLine.lastIndexOf("]");
    // newRelationLine = newRelationLine.substring(0, index);
    // index = newRelationLine.lastIndexOf("]");
    // beforeNewTuple = relationLine.substring(0, index);
    // newRelationLine = relationLine.replace(beforeNewTuple, beforeNewTuple + "," + tupleString);
    // }
    return newRelationLine;
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

  @SuppressWarnings("unused")
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

  @Override
  public void moveToLower(final String arg0, final List<String> arg1) {
    final String relationName = arg0;
    final List<String> tuple = arg1;

    System.out.println("relation:" + relationName + "\ntuple:" + tuple + "\nwanted move to lower.");

    // final ITypedRegion relBoundPartition =
    // this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);
    // final String relBoundString = this.getPartitionString(relBoundPartition);

    final PrettyPrinter pp = new PrettyPrinter();
    final String documentString = pp.moveToLower(this.document.get(), relationName, tuple);

    // final int indexOfRelationLine = relBoundPartition.getOffset();
    // final int lastIndexOfRelationLine =
    // relBoundPartition.getOffset() + relBoundPartition.getLength();

    // TODO partiton parser yapilinca sadece partition string gonderilecek ve dokumanda sadece
    // ilgili kisim degistirilecek.
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          VisualizationSubscriber.this.document.replace(0,
              VisualizationSubscriber.this.document.getLength(), documentString);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void moveToUpper(final String arg0, final List<String> arg1) {
    final String relationName = arg0;
    final List<String> tuple = arg1;

    System.out.println("relation:" + relationName + "\ntuple:" + tuple + "\nwanted move to upper.");

    // final ITypedRegion relBoundPartition =
    // this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);
    // final String relBoundString = this.getPartitionString(relBoundPartition);

    final PrettyPrinter pp = new PrettyPrinter();
    final String documentString = pp.moveToUpper(this.document.get(), relationName, tuple);

    // final int indexOfRelationLine = relBoundPartition.getOffset();
    // final int lastIndexOfRelationLine =
    // relBoundPartition.getOffset() + relBoundPartition.getLength();

    // TODO partiton parser yapilinca sadece partition string gonderilecek ve dokumanda sadece
    // ilgili kisim degistirilecek.
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          VisualizationSubscriber.this.document.replace(0,
              VisualizationSubscriber.this.document.getLength(), documentString);
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
    final String relationName = arg0;
    final List<String> tuple = arg1;
    final String bound = arg2;

    System.out.println(
        "relation:" + relationName + "\ntuple:" + tuple + "\nbound:" + bound + "\nwanted remove.");

    // final ITypedRegion relBoundPartition =
    // this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);
    // final String relBoundString = this.getPartitionString(relBoundPartition);

    final PrettyPrinter pp = new PrettyPrinter();
    final String documentString = pp.removeTuple(this.document.get(), relationName, tuple, bound);

    // final int indexOfRelationLine = relBoundPartition.getOffset();
    // final int lastIndexOfRelationLine = indexOfRelationLine + relBoundPartition.getLength();

    // TODO partiton parser yapilinca sadece partition string gonderilecek ve dokumanda sadece
    // ilgili kisim degistirilecek.
    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          VisualizationSubscriber.this.document.replace(0,
              VisualizationSubscriber.this.document.getLength(), documentString);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
