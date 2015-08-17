package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;

import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerVisibilityHandler extends AbstractHandler {
  private static boolean isHidden = false;

  public static boolean isHidden() {
    return isHidden;
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    AnnotationPreference prefMarking = EditorsUI.getAnnotationPreferenceLookup()
        .getAnnotationPreference(MarkerFactory.ANNOTATION_MARKING);
    AnnotationPreference prefMapping = EditorsUI.getAnnotationPreferenceLookup()
        .getAnnotationPreference(MarkerFactory.ANNOTATION_MAPPING);
    IPreferenceStore store = EditorsUI.getPreferenceStore();
    IDecoratorManager decoratorManager =
        Activator.getDefault().getWorkbench().getDecoratorManager();
    
    if (!isHidden) {
      isHidden = true;
      store.setValue(prefMarking.getOverviewRulerPreferenceKey(), false);
      store.setValue(prefMarking.getVerticalRulerPreferenceKey(), false);
      store.setValue(prefMarking.getTextPreferenceKey(), false);
      store.setValue(prefMapping.getOverviewRulerPreferenceKey(), false);
      store.setValue(prefMapping.getVerticalRulerPreferenceKey(), false);
      store.setValue(prefMapping.getTextPreferenceKey(), false);
      try {
        decoratorManager.setEnabled(MarkerFactory.ECORE_DECORATOR, false);
        decoratorManager.setEnabled(MarkerFactory.FILE_DECORATOR, false);
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } else {
      isHidden = false;
      store.setValue(prefMarking.getOverviewRulerPreferenceKey(), true);
      store.setValue(prefMarking.getVerticalRulerPreferenceKey(), true);
      store.setValue(prefMarking.getTextPreferenceKey(), true);
      store.setValue(prefMapping.getOverviewRulerPreferenceKey(), true);
      store.setValue(prefMapping.getVerticalRulerPreferenceKey(), true);
      store.setValue(prefMapping.getTextPreferenceKey(), true);
      store.setValue(prefMarking.getColorPreferenceKey(), "0,0,255");
      store.setValue(prefMapping.getColorPreferenceKey(), "255,0,0");

      try {
        decoratorManager.setEnabled(MarkerFactory.ECORE_DECORATOR, true);
        decoratorManager.setEnabled(MarkerFactory.FILE_DECORATOR, true);
      } catch (CoreException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    store.needsSaving();

    return null;
  }
}
