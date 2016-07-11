package eu.modelwriter.marker.command.visualization;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class AnalysisSourceProvider extends AbstractSourceProvider {

  enum State {
    ANALYSIS, NEXT, STOP
  }

  public static final String STATE =
      "eu.modelwriter.marker.command.analysissourceprovider.activity";

  private static final String ANALYSIS = "ANALYSIS";

  private static final String NEXT = "NEXT";

  private static final String STOP = "STOP";

  private final State currentState = State.STOP;

  @Override
  public void dispose() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Map getCurrentState() {
    final Map<String, Object> map = new HashMap<>(1);

    if (this.currentState == State.ANALYSIS) {
      map.put(STATE, ANALYSIS);
    } else if (this.currentState == State.NEXT) {
      map.put(STATE, NEXT);
    } else if (this.currentState == State.STOP) {
      map.put(STATE, STOP);
    }

    return map;
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] {STATE};
  }

  public void setAnalysis() {
    this.fireSourceChanged(ISources.WORKBENCH, STATE, ANALYSIS);
  }

  public void setNext() {
    this.fireSourceChanged(ISources.WORKBENCH, STATE, NEXT);
  }

  public void setStop() {
    this.fireSourceChanged(ISources.WORKBENCH, STATE, STOP);
  }
}
