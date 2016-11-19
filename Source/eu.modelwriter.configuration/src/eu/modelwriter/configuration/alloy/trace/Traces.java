package eu.modelwriter.configuration.alloy.trace;

public final class Traces {

  private static TraceRepo mTraceRepo;

  private static TraceManager mTraceManager;

  public static void clearRepo() {
    getRepo().clear();
  }

  public static TraceManager getManager() {
    if (mTraceManager == null)
      mTraceManager = new TraceManager(getRepo());
    return mTraceManager;
  }

  public static TraceRepo getRepo() {
    if (mTraceRepo == null)
      mTraceRepo = new TraceRepo();
    return mTraceRepo;
  }
}
