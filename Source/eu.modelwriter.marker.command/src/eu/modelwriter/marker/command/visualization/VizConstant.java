package eu.modelwriter.marker.command.visualization;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class VizConstant {

  public static String PROPERTY = "reason";


  public static void refreshView() {
    // IWorkbenchPage wbp = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    // wbp.showView("eu.modelwriter.marker.ui.views.visualizationview").getViewSite().getActionBars()
    // .updateActionBars();
    Display.getDefault().asyncExec(new Runnable() {

      @Override
      public void run() {
        IWorkbenchWindow ww = PlatformUI.getWorkbench().getWorkbenchWindows()[0];

        if (ww != null) {
          IViewPart ttv = null;
          IViewPart other1 = null;
          for (IViewPart view : ww.getActivePage().getViews()) {
            if (view != null) {
              if (view.getTitle().equals("Tarski Traceability View"))
                ttv = view;
              else
                other1 = view;
            }
          }
          if (other1 != null)
            other1.setFocus();

          ww.getActivePage().getActiveEditor().setFocus();

          if (ttv != null)
            ttv.setFocus();
        }

      }
    });

  }

}
