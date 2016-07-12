package eu.modelwriter.configuration.alloy.analysis.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class AnalysisSourceProvider extends AbstractSourceProvider {

  public enum State {
    ANALYSIS, NEXT, STOP
  }

  public static final String STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.activity";

  public static final String ANALYSIS = "ANALYSIS";

  public static final String NEXT = "NEXT";

  public static final String STOP = "STOP";

  private State currentState = State.STOP;

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
    this.currentState = State.ANALYSIS;
  }

  public void setNext() {
    this.fireSourceChanged(ISources.WORKBENCH, STATE, NEXT);
    this.currentState = State.NEXT;
  }

  public void setStop() {
    this.fireSourceChanged(ISources.WORKBENCH, STATE, STOP);
    this.currentState = State.STOP;
  }
}
