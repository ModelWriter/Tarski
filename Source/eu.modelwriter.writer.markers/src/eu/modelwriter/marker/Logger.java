package eu.modelwriter.marker;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author Mete
 *
 */
public class Logger {
  public static void logInfo(String message) {
    log(IStatus.INFO, IStatus.OK, message, null);
  }

  public static void logError(Throwable exception) {
    logError("MW Marker Unexpected Exception", exception);
  }

  public static void logError(String message, Throwable exception) {
    log(IStatus.ERROR, IStatus.OK, message, exception);
  }

  public static void log(int severity, int code, String message, Throwable exception) {
    log(createStatus(severity, code, message, exception));
  }

  /**
   * @param severity IStatus.OK, IStatus.WARNING, IStatus.ERROR,IStatus.INFO, or IStatus.CANCEL
   * @param code the plug-in-specific status code or IStatus.OK
   * @param message a human-readable message, localized to the current locale
   * @param exception a low-level exception, or null if not applicable
   * @return
   */
  public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
    return new Status(severity, Activator.PLUGIN_ID, code, message, exception);
  }

  public static void log(IStatus status) {
    Activator.getDefault().getLog().log(status);
  }
}
