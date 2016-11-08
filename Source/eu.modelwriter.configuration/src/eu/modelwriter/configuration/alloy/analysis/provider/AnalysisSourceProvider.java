package eu.modelwriter.configuration.alloy.analysis.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class AnalysisSourceProvider extends AbstractSourceProvider {

  public static enum AnalysisState {
    ACTIVE, PASSIVE
  }

  public static enum ReasoningType {
    DISCOVER_RELATION, DISCOVER_ATOM, DISCOVER_RELATION_FOR_ATOM
  }

  public static final String ANALYSIS_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.analysisState";
  public static final String REASONING_TYPE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.reasoningType";

  public static final String ACTIVE = "ACTIVE";

  public static final String PASSIVE = "PASSIVE";

  private AnalysisState currentState = AnalysisState.PASSIVE;

  private ReasoningType reasoningType;

  @Override
  public void dispose() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Map getCurrentState() {
    final Map<String, Object> map = new HashMap<>(1);

    if (currentState == AnalysisState.ACTIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisSourceProvider.ACTIVE);
      if (reasoningType == ReasoningType.DISCOVER_ATOM) {
        map.put(AnalysisSourceProvider.REASONING_TYPE, ReasoningType.DISCOVER_ATOM);
      } else if (reasoningType == ReasoningType.DISCOVER_RELATION) {
        map.put(AnalysisSourceProvider.REASONING_TYPE, ReasoningType.DISCOVER_RELATION);
      } else if (reasoningType == ReasoningType.DISCOVER_RELATION_FOR_ATOM) {
        map.put(AnalysisSourceProvider.REASONING_TYPE,
            ReasoningType.DISCOVER_RELATION_FOR_ATOM);
      }
    } else if (currentState == AnalysisState.PASSIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisSourceProvider.PASSIVE);
    }

    return map;
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] {AnalysisSourceProvider.ANALYSIS_STATE, AnalysisSourceProvider.REASONING_TYPE};
  }

  public void setActive(final ReasoningType TYPE) {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE, AnalysisSourceProvider.ACTIVE);
    currentState = AnalysisState.ACTIVE;
    setReasoningType(TYPE);
  }

  public void setPassive() {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE, AnalysisSourceProvider.PASSIVE);
    currentState = AnalysisState.PASSIVE;
  }

  public ReasoningType getReasoningType() {
    return reasoningType;
  }

  public void setReasoningType(final ReasoningType reasoningType) {
    this.reasoningType = reasoningType;
  }
}
