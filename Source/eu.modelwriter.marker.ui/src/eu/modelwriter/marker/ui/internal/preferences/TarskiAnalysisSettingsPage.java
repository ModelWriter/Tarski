package eu.modelwriter.marker.ui.internal.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.ScaleFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import eu.modelwriter.configuration.alloy.analysis.StaticAlloyAnalysisManager;
import eu.modelwriter.marker.ui.Activator;

public class TarskiAnalysisSettingsPage extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {
  private static final String NEXT_SOLUTION_MAX_TIME_SCALE = "nextSolutionMaxTimeScale";
  private static final String FILTER_SOLUTIONS = "filterSolutions";
  private static final String TXT_NEXT_SOLUTION_MAX_TIME =
      "Maximum trying time to find next solution:\n";
  private static final String TXT_FILTER_SOLUTIONS = "Filter Solutions";
  private ScaleFieldEditor nextSolutionMaxTryingTimeScaleFieldEditor;
  private BooleanFieldEditor filterSolutionsBooleanFieldEditor;
  private Integer lastTime;

  public TarskiAnalysisSettingsPage() {
    super("Tarski Analysis Settings", FieldEditorPreferencePage.GRID);
  }

  @Override
  public void init(final IWorkbench workbench) {
    setPreferenceStore(Activator.getDefault().getPreferenceStore());
    setDescription("Tarski Platform Analysis Settings");
  }

  @Override
  protected void createFieldEditors() {
    addField(createFilterSolutions());
    createNextSolMaxTimeScale();
  }

  @Override
  public boolean performOk() {
    super.performOk();
    if (getPreferenceStore().getBoolean(TarskiAnalysisSettingsPage.FILTER_SOLUTIONS)) {
      StaticAlloyAnalysisManager.openAnalysisFilter();
    } else {
      StaticAlloyAnalysisManager.closeAnalysisFilter();
    }

    getPreferenceStore().setValue(TarskiAnalysisSettingsPage.NEXT_SOLUTION_MAX_TIME_SCALE,
        lastTime);
    StaticAlloyAnalysisManager.setNextSolutionMaxTime(lastTime);

    return true;
  }

  // public static Image getImage(final String bundleID, final String path) {
  // assert bundleID != null : "No bundle defined";
  // assert path != null : "No path defined";
  //
  // // if the bundle is not ready then there is no image
  // final Bundle bundle = Platform.getBundle(bundleID);
  // final int bundleState = bundle.getState();
  // if (bundleState != Bundle.ACTIVE && bundleState != Bundle.STARTING
  // && bundleState != Bundle.RESOLVED) {
  // return null;
  // }
  //
  // // look for the image (this will check both the plugin and fragment
  // // folders
  // final URL imagePath = FileLocator.find(bundle, new Path(path), null);
  // final ImageDescriptor mDescriptor = ImageDescriptor.createFromURL(imagePath);
  // return mDescriptor.createImage();
  // }

  private BooleanFieldEditor createFilterSolutions() {
    getPreferenceStore().setValue(TarskiAnalysisSettingsPage.FILTER_SOLUTIONS,
        StaticAlloyAnalysisManager.isAnalysisFilterOpen());

    filterSolutionsBooleanFieldEditor =
        new BooleanFieldEditor(TarskiAnalysisSettingsPage.FILTER_SOLUTIONS,
            TarskiAnalysisSettingsPage.TXT_FILTER_SOLUTIONS, getFieldEditorParent());

    // filterSolutionsBooleanFieldEditor.getLabelControl(getFieldEditorParent())
    // .setImage(TarskiAnalysisSettingsPage.getImage("eu.modelwriter.marker", "icons/filter.png"));

    return filterSolutionsBooleanFieldEditor;
  }

  @Override
  protected void checkState() {
    super.checkState();
    final boolean analysisProcessing = StaticAlloyAnalysisManager.isAnalysisActive()
        || StaticAlloyAnalysisManager.isAnalysisProcessing();
    if (analysisProcessing) {
      setValid(false);
      setErrorMessage("Stop analysis first!.");
      filterSolutionsBooleanFieldEditor.setEnabled(false, getFieldEditorParent());
      nextSolutionMaxTryingTimeScaleFieldEditor.setEnabled(false, getFieldEditorParent());
    } else {
      setValid(true);
      setErrorMessage(null);
      filterSolutionsBooleanFieldEditor.setEnabled(true, getFieldEditorParent());
      nextSolutionMaxTryingTimeScaleFieldEditor.setEnabled(true, getFieldEditorParent());
    }
  }

  private ScaleFieldEditor createNextSolMaxTimeScale() {
    final Integer newValue =
        getPreferenceStore().getInt(TarskiAnalysisSettingsPage.NEXT_SOLUTION_MAX_TIME_SCALE);
    final String valueText = "[" + newValue / 60 + "m: " + newValue % 60 + "s" + "]";

    nextSolutionMaxTryingTimeScaleFieldEditor =
        new ScaleFieldEditor(TarskiAnalysisSettingsPage.NEXT_SOLUTION_MAX_TIME_SCALE,
            TarskiAnalysisSettingsPage.TXT_NEXT_SOLUTION_MAX_TIME + valueText,
            getFieldEditorParent(), 0, 3600, 1, 1);
    nextSolutionMaxTryingTimeScaleFieldEditor.getLabelControl(getFieldEditorParent()).setSize(500,
        50);
    nextSolutionMaxTryingTimeScaleFieldEditor.getScaleControl().setSelection(newValue);

    nextSolutionMaxTryingTimeScaleFieldEditor
    .setPropertyChangeListener(new IPropertyChangeListener() {
      @Override
      public void propertyChange(final PropertyChangeEvent event) {
        if (event.getProperty().equals("field_editor_value") && isValid()) {
          lastTime = (Integer) event.getNewValue();
          final String valueText = "[" + lastTime / 60 + "m: " + lastTime % 60 + "s" + "]";
          nextSolutionMaxTryingTimeScaleFieldEditor.getScaleControl().setToolTipText(valueText);
          nextSolutionMaxTryingTimeScaleFieldEditor
          .setLabelText(TarskiAnalysisSettingsPage.TXT_NEXT_SOLUTION_MAX_TIME + valueText);
        }
      }
    });
    return nextSolutionMaxTryingTimeScaleFieldEditor;
  }
}
