/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
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
    return new Status(severity, MarkerActivator.PLUGIN_ID, code, message, exception);
  }

  public static void log(IStatus status) {
    MarkerActivator.getDefault().getLog().log(status);
  }
}
