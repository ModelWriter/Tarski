package eu.modelwriter.configuration.alloy.analysis;

import org.eclipse.ui.services.ISourceProviderService;

import edu.mit.csail.sdg.alloy4.Err;
import eu.modelwriter.configuration.Activator;
import eu.modelwriter.configuration.alloy.analysis.consistencychecking.ConsistencyChecking;
import eu.modelwriter.configuration.alloy.analysis.discovering.Discovering;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisState;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.AnalysisType;
import eu.modelwriter.configuration.alloy.analysis.provider.AnalysisSourceProvider.EvaluationState;
import eu.modelwriter.configuration.alloy.analysis.reasoning.Reasoning;
import eu.modelwriter.configuration.alloy.analysis.reasoningforatom.ReasoningForAtom;

public class StaticAlloyAnalysisManager {
  private static IAlloyAnalyzer currentAnalyzer;
  private static final AnalysisSourceProvider sourceProvider = (AnalysisSourceProvider) Activator
      .getDefault().getWorkbench().getService(ISourceProviderService.class)
      .getSourceProvider(AnalysisSourceProvider.ANALYSIS_STATE);

  public static boolean isEvaluatorOpen() {
    return StaticAlloyAnalysisManager.sourceProvider.getEvaluationState()
        .equals(EvaluationState.OPEN);
  }

  public static void openEvaluator() {
    StaticAlloyAnalysisManager.sourceProvider.setEvaluationState(EvaluationState.OPEN);
  }

  public static void closeEvaluator() {
    StaticAlloyAnalysisManager.sourceProvider.setEvaluationState(EvaluationState.CLOSE);
  }

  public static boolean checkConsistency() {
    return ConsistencyChecking.getInstance().check();
  }

  public static boolean isAnalysisActive() {
    return StaticAlloyAnalysisManager.sourceProvider.getAnalysisState()
        .equals(AnalysisState.ACTIVE);
  }

  public static boolean isAnalysisProcessing() {
    return StaticAlloyAnalysisManager.sourceProvider.getAnalysisState()
        .equals(AnalysisState.PROCESSING);
  }

  public static boolean startDiscovering() {
    StaticAlloyAnalysisManager.currentAnalyzer = Discovering.getInstance();
    return StaticAlloyAnalysisManager.startAnalysis();
  }

  public static boolean startReasoning() {
    StaticAlloyAnalysisManager.currentAnalyzer = Reasoning.getInstance();
    return StaticAlloyAnalysisManager.startAnalysis();
  }

  public static boolean startReasoningForAtom(final String atomName) {
    StaticAlloyAnalysisManager.currentAnalyzer = ReasoningForAtom.getInstance(atomName);
    return StaticAlloyAnalysisManager.startAnalysis();
  }

  private static boolean startAnalysis() {
    StaticAlloyAnalysisManager.sourceProvider.setProcessing();
    boolean success = true;
    try {
      success = StaticAlloyAnalysisManager.currentAnalyzer.start();
      StaticAlloyAnalysisManager.sourceProvider.setActive(AnalysisType.REASON_RELATION_FOR_ATOM);
    } catch (final Err e) {
      success = false;
      StaticAlloyAnalysisManager.finishAnalysis();
    }
    return success;
  }

  public static boolean nextAnalysis() {
    boolean success = true;
    StaticAlloyAnalysisManager.sourceProvider.setProcessing();
    try {
      success = StaticAlloyAnalysisManager.currentAnalyzer.next();
    } catch (final Err e) {
      return false;
    } finally {
      StaticAlloyAnalysisManager.sourceProvider
          .setActive(StaticAlloyAnalysisManager.sourceProvider.getAnalysisType());
    }
    return success;
  }

  public static boolean previousAnalysis() {
    final boolean success = true;
    StaticAlloyAnalysisManager.sourceProvider.setProcessing();
    try {
      StaticAlloyAnalysisManager.currentAnalyzer.previous();
    } catch (final Err e) {
      return false;
    } finally {
      StaticAlloyAnalysisManager.sourceProvider
          .setActive(StaticAlloyAnalysisManager.sourceProvider.getAnalysisType());
    }
    return success;
  }

  public static void finishAnalysis() {
    if (StaticAlloyAnalysisManager.currentAnalyzer != null) {
      StaticAlloyAnalysisManager.currentAnalyzer.finish();
    }
    StaticAlloyAnalysisManager.sourceProvider.setPassive();
  }
}
