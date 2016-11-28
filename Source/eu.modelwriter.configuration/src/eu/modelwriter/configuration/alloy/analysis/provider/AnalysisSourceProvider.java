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

  public static enum EvaluationState {
    OPEN, CLOSE
  }

  public static final String ANALYSIS_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.analysisState";
  public static final String REASONING_TYPE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.reasoningType";
  public static final String EVALUATION_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.evaluationState";

  private AnalysisState currentState = AnalysisState.PASSIVE;

  private ReasoningType reasoningType;

  private EvaluationState evaluationState = EvaluationState.CLOSE;

  @Override
  public void dispose() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Map getCurrentState() {
    final Map<String, Object> map = new HashMap<>(1);

    if (currentState == AnalysisState.ACTIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisState.ACTIVE.toString());
      if (reasoningType == ReasoningType.DISCOVER_ATOM) {
        map.put(AnalysisSourceProvider.REASONING_TYPE, ReasoningType.DISCOVER_ATOM.toString());
      } else if (reasoningType == ReasoningType.DISCOVER_RELATION) {
        map.put(AnalysisSourceProvider.REASONING_TYPE, ReasoningType.DISCOVER_RELATION.toString());
      } else if (reasoningType == ReasoningType.DISCOVER_RELATION_FOR_ATOM) {
        map.put(AnalysisSourceProvider.REASONING_TYPE,
            ReasoningType.DISCOVER_RELATION_FOR_ATOM.toString());
      }
    } else if (currentState == AnalysisState.PASSIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisState.PASSIVE.toString());
    }

    if (evaluationState == EvaluationState.OPEN) {
      map.put(AnalysisSourceProvider.EVALUATION_STATE, EvaluationState.OPEN.toString());
    } else if (evaluationState == EvaluationState.CLOSE) {
      map.put(AnalysisSourceProvider.EVALUATION_STATE, EvaluationState.CLOSE.toString());
    }

    return map;
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] {AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisSourceProvider.REASONING_TYPE, AnalysisSourceProvider.EVALUATION_STATE};
  }

  public void setActive(final ReasoningType TYPE) {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisState.ACTIVE.toString());
    currentState = AnalysisState.ACTIVE;
    setReasoningType(TYPE);
  }

  public void setPassive() {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisState.PASSIVE.toString());
    currentState = AnalysisState.PASSIVE;
  }

  public ReasoningType getReasoningType() {
    return reasoningType;
  }

  public void setReasoningType(final ReasoningType reasoningType) {
    this.reasoningType = reasoningType;
  }

  public EvaluationState getEvaluationState() {
    return evaluationState;
  }

  public void setEvaluationState(final EvaluationState evaluationState) {
    this.evaluationState = evaluationState;
  }
}