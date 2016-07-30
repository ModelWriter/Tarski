package eu.modelwriter.configuration.alloy.analysis.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class AnalysisSourceProvider extends AbstractSourceProvider {

  public static enum DiscoveringState {
    ANALYSIS, NEXT, STOP
  }

  public static enum AnalysisType {
    DISCOVER_RELATION, DISCOVER_ATOM
  }

  public static final String STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.activity";

  public static final String ANALYSIS = "ANALYSIS";

  public static final String NEXT = "NEXT";

  public static final String STOP = "STOP";

  private DiscoveringState currentState = DiscoveringState.STOP;

  private AnalysisType analysisType;

  @Override
  public void dispose() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Map getCurrentState() {
    final Map<String, Object> map = new HashMap<>(1);

    if (this.currentState == DiscoveringState.ANALYSIS) {
      map.put(AnalysisSourceProvider.STATE, AnalysisSourceProvider.ANALYSIS);
    } else if (this.currentState == DiscoveringState.NEXT) {
      map.put(AnalysisSourceProvider.STATE, AnalysisSourceProvider.NEXT);
    } else if (this.currentState == DiscoveringState.STOP) {
      map.put(AnalysisSourceProvider.STATE, AnalysisSourceProvider.STOP);
    }

    return map;
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] {AnalysisSourceProvider.STATE};
  }

  public void setAnalysis(final AnalysisType TYPE) {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.STATE, AnalysisSourceProvider.ANALYSIS);
    this.currentState = DiscoveringState.ANALYSIS;
    this.setAnalysisType(TYPE);
  }

  public void setNext() {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.STATE, AnalysisSourceProvider.NEXT);
    this.currentState = DiscoveringState.NEXT;
  }

  public void setStop() {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.STATE, AnalysisSourceProvider.STOP);
    this.currentState = DiscoveringState.STOP;
  }

  public AnalysisType getAnalysisType() {
    return this.analysisType;
  }

  public void setAnalysisType(final AnalysisType analysisType) {
    this.analysisType = analysisType;
  }
}
