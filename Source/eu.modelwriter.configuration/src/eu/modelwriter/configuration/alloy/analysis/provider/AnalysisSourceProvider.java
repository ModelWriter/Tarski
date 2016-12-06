package eu.modelwriter.configuration.alloy.analysis.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

public class AnalysisSourceProvider extends AbstractSourceProvider {

  public static enum AnalysisState {
    ACTIVE, PASSIVE, PROCESSING
  }

  public static enum AnalysisType {
    REASON_RELATION, DISCOVER_ATOM, REASON_RELATION_FOR_ATOM
  }

  public static enum EvaluationState {
    OPEN, CLOSE
  }

  public static enum AnalysisFilter {
    OPEN, CLOSE
  }

  public static final String ANALYSIS_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.analysisState";
  public static final String ANALYSIS_TYPE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.reasoningType";
  public static final String EVALUATION_STATE =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.evaluationState";
  public static final String ANALYSIS_FILTER =
      "eu.modelwriter.configuration.alloy.analysissourceprovider.analysisFilter";

  private AnalysisState currentState = AnalysisState.PASSIVE;

  private AnalysisType analysisType;

  private EvaluationState evaluationState = EvaluationState.CLOSE;

  private AnalysisFilter analysisFilter = AnalysisFilter.OPEN;

  @Override
  public void dispose() {}

  @SuppressWarnings("rawtypes")
  @Override
  public Map getCurrentState() {
    final Map<String, Object> map = new HashMap<>(1);

    if (currentState == AnalysisState.ACTIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisState.ACTIVE.toString());
      if (analysisType == AnalysisType.DISCOVER_ATOM) {
        map.put(AnalysisSourceProvider.ANALYSIS_TYPE, AnalysisType.DISCOVER_ATOM.toString());
      } else if (analysisType == AnalysisType.REASON_RELATION) {
        map.put(AnalysisSourceProvider.ANALYSIS_TYPE, AnalysisType.REASON_RELATION.toString());
      } else if (analysisType == AnalysisType.REASON_RELATION_FOR_ATOM) {
        map.put(AnalysisSourceProvider.ANALYSIS_TYPE,
            AnalysisType.REASON_RELATION_FOR_ATOM.toString());
      }
    } else if (currentState == AnalysisState.PASSIVE) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisState.PASSIVE.toString());
    } else if (currentState == AnalysisState.PROCESSING) {
      map.put(AnalysisSourceProvider.ANALYSIS_STATE, AnalysisState.PROCESSING.toString());
    }

    if (evaluationState == EvaluationState.OPEN) {
      map.put(AnalysisSourceProvider.EVALUATION_STATE, EvaluationState.OPEN.toString());
    } else if (evaluationState == EvaluationState.CLOSE) {
      map.put(AnalysisSourceProvider.EVALUATION_STATE, EvaluationState.CLOSE.toString());
    }

    if (analysisFilter == AnalysisFilter.OPEN) {
      map.put(AnalysisSourceProvider.ANALYSIS_FILTER, AnalysisFilter.OPEN.toString());
    } else if (analysisFilter == AnalysisFilter.CLOSE) {
      map.put(AnalysisSourceProvider.ANALYSIS_FILTER, AnalysisFilter.CLOSE.toString());
    }

    return map;
  }

  @Override
  public String[] getProvidedSourceNames() {
    return new String[] {AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisSourceProvider.ANALYSIS_TYPE, AnalysisSourceProvider.EVALUATION_STATE,
        AnalysisSourceProvider.ANALYSIS_FILTER};
  }

  public void setActive(final AnalysisType TYPE) {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisState.ACTIVE.toString());
    currentState = AnalysisState.ACTIVE;
    setAnalysisType(TYPE);
  }

  public void setPassive() {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisState.PASSIVE.toString());
    currentState = AnalysisState.PASSIVE;
  }

  public void setProcessing() {
    this.fireSourceChanged(ISources.WORKBENCH, AnalysisSourceProvider.ANALYSIS_STATE,
        AnalysisState.PROCESSING.toString());
    currentState = AnalysisState.PROCESSING;
  }

  public AnalysisType getAnalysisType() {
    return analysisType;
  }

  public AnalysisState getAnalysisState() {
    return currentState;
  }

  public void setAnalysisType(final AnalysisType analysisType) {
    this.analysisType = analysisType;
  }

  public EvaluationState getEvaluationState() {
    return evaluationState;
  }

  public void setEvaluationState(final EvaluationState evaluationState) {
    this.evaluationState = evaluationState;
  }

  public AnalysisFilter getAnalysisFilter() {
    return analysisFilter;
  }

  public void setAnalysisFilter(final AnalysisFilter analysisFilter) {
    this.analysisFilter = analysisFilter;
  }
}
