package eu.modelwriter.kodkod.editor.manager;

import java.io.Serializable;
import java.util.List;

import eu.modelwriter.visualization.Notifier;

public class VisualizationSubscriber implements Notifier {
  public VisualizationSubscriber() {}

  @Override
  public void addTupleNotify(final String arg0, final List<String> arg1, final String arg2) {
    // TODO Auto-generated method stub

  }

  @Override
  public void moveToLower(final String arg0, final List<String> arg1) {
    // TODO Auto-generated method stub

  }

  @Override
  public void moveToUpper(final String arg0, final List<String> arg1) {
    // TODO Auto-generated method stub

  }

  @Override
  public void notify(final Serializable arg0) {

  }

  @Override
  public void removeTupleNotify(final String arg0, final List<String> arg1) {

  }
}
