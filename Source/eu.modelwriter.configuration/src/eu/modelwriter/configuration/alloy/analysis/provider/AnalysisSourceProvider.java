package eu.modelwriter.configuration.alloy.analysis.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class AnalysisSourceProvider extends AbstractSourceProvider {

  public static enum AnalysisState {
    ACTIVE, PASSIVE
  }

  public static enum AnalysisType {
    REASON_RELATION, DISCOVER_ATOM, REASON_RELATION_FOR_ATOM
  }

  public static enum EvaluationState {
    OPEN, CLOSE
  }

  public static final String ANALYSIS_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.analysisState";
  public static final String ANALYSIS_TYPE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.reasoningType";
  public static final String EVALUATION_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.evaluationState";

  private AnalysisState currentState = AnalysisState.PASSIVE;

  private AnalysisType reasoningType;

  private EvaluationState evaluationState = EvaluationState.CLOSE;

  @Override
  public void dispose() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Map getCurrentState() {
    final Map<String, Object> map = new HashMap<>(1);

    if (currentState == AnalysisState.ACTIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisState.ACTIVE.toString());
      if (reasoningType == AnalysisType.DISCOVER_ATOM) {
        map.put(AnalysisSourceProvider.ANALYSIS_TYPE, AnalysisType.DISCOVER_ATOM.toString());
      } else if (reasoningType == AnalysisType.REASON_RELATION) {
        map.put(AnalysisSourceProvider.ANALYSIS_TYPE, AnalysisType.REASON_RELATION.toString());
      } else if (reasoningType == AnalysisType.REASON_RELATION_FOR_ATOM) {
        map.put(AnalysisSourceProvider.ANALYSIS_TYPE,
            AnalysisType.REASON_RELATION_FOR_ATOM.toString());
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
    return new String[] {AnalysisSourceProvider.ANALYSIS_STATE, AnalysisSourceProvider.ANALYSIS_TYPE, AnalysisSourceProvider.EVALUATION_STATE};
  }

  public void setActive(final AnalysisType TYPE) {
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

  public AnalysisType getReasoningType() {
    return reasoningType;
  }

  public void setReasoningType(final AnalysisType reasoningType) {
    this.reasoningType = reasoningType;
  }

  public EvaluationState getEvaluationState() {
    return evaluationState;
  }

  public void setEvaluationState(final EvaluationState evaluationState) {
    this.evaluationState = evaluationState;
  }
}