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
import eu.modelwriter.kodkod.core.printer.NotifyPrinter;
import eu.modelwriter.kodkod.editor.scanners.RelationModelPartitionScanner;
import eu.modelwriter.visualization.Notifier;

public class VisualizationSubscriber implements Notifier {
  enum NOTIFY_MODE {
    ADD_TUPLE, REMOVE_TUPLE, MOVE_TO_UPPER, MOVE_TO_LOWER
  }

  IDocument document;

  public VisualizationSubscriber(final IDocument document) {
    this.document = document;
  }

  @Override
  public void addTupleNotify(final String arg0, final List<String> arg1, final String arg2) {
    this.run(arg0, arg1, arg2, NOTIFY_MODE.ADD_TUPLE);
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

  @Override
  public void moveToLower(final String arg0, final List<String> arg1) {
    this.run(arg0, arg1, NOTIFY_MODE.MOVE_TO_LOWER);
  }

  @Override
  public void moveToUpper(final String arg0, final List<String> arg1) {
    this.run(arg0, arg1, NOTIFY_MODE.MOVE_TO_UPPER);
  }

  @Override
  public void notify(final Serializable arg0) {}

  @Override
  public void removeTupleNotify(final String arg0, final List<String> arg1, final String arg2) {
    this.run(arg0, arg1, arg2, NOTIFY_MODE.REMOVE_TUPLE);
  }

  private void run(final String relationName, final List<String> tuple, final NOTIFY_MODE MODE) {
    this.run(relationName, tuple, null, MODE);
  }

  private void run(final String relationName, final List<String> tuple, final String bound,
      final NOTIFY_MODE MODE) {
    final ITypedRegion universePartition =
        this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_UNIVERSE);
    final ITypedRegion relBoundPartition =
        this.getPartition(RelationModelPartitionScanner.RELATION_MODEL_REL_BOUND);
    final ModelBuildVisitor v = new ModelBuildVisitor();

    final NotifyPrinter printer = new NotifyPrinter();
    String documentString = this.document.get();

    final Atom atomsOfTuple[] = new Atom[tuple.size()];
    for (int i = 0; i < atomsOfTuple.length; i++) {
      atomsOfTuple[i] = new Atom(tuple.get(i));
    }
    switch (MODE) {
      case ADD_TUPLE:
        v.getUniverse().getRelation(relationName)
            .addAtomWithTuple(bound.equals("lower") ? true : false, atomsOfTuple);
        documentString = printer.addTuple(relationName, tuple, bound);
        break;
      case REMOVE_TUPLE:
        v.getUniverse().getRelation(relationName).removeTuple(atomsOfTuple);
        documentString = printer.removeTuple(relationName, tuple, bound);
        break;
      case MOVE_TO_UPPER:
        v.getUniverse().getRelation(relationName).getTuple(atomsOfTuple).setLowerBound(false);
        documentString = printer.moveToUpper(relationName, tuple);
        break;
      case MOVE_TO_LOWER:
        v.getUniverse().getRelation(relationName).getTuple(atomsOfTuple).setLowerBound(true);
        documentString = printer.moveToLower(relationName, tuple);
        break;
      default:
        break;
    }

    final String printerResult = documentString;
    final int start = universePartition.getOffset();
    final int end = relBoundPartition.getOffset() + relBoundPartition.getLength();

    Display.getDefault().syncExec(new Runnable() {
      @Override
      public void run() {
        try {
          VisualizationSubscriber.this.document.replace(start, end, printerResult);
        } catch (final BadLocationException e) {
          e.printStackTrace();
        }
      }
    });
  }
}
