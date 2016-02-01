package eu.modelwriter.traceability.validation.core.crocopat.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;

public class CrocopatExecuteHandler extends AbstractHandler {
  /**
   * The constructor.
   */
  public CrocopatExecuteHandler() {}

  /**
   * the command has been executed, so extract extract the needed information from the application
   * context.
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final Runtime rt = Runtime.getRuntime();
    try {
      final URI exeUri = CommonPlugin.resolve(URI.createURI(
          "platform:/plugin/eu.modelwriter.traceability.validation.core.crocopat/exec/crocopat-2.1.4_win32.exe"));
      final URI fileUri = CommonPlugin.resolve(URI.createURI(
          "platform:/plugin/eu.modelwriter.traceability.validation.core.crocopat/files/List.rml"));

      final Process pr = rt.exec(exeUri.path() + " -e " + fileUri.path());
      final BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
      String line = null;
      while ((line = input.readLine()) != null) {
        System.out.println(line);
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
