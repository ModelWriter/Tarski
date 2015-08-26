/*
 * 
 */
package ReqModel.diagram.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * @generated
 */
public class DiagramPreferenceInitializer extends AbstractPreferenceInitializer {

	/**
	 * @generated
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = getPreferenceStore();
		ReqModel.diagram.preferences.DiagramGeneralPreferencePage
				.initDefaults(store);
		ReqModel.diagram.preferences.DiagramAppearancePreferencePage
				.initDefaults(store);
		ReqModel.diagram.preferences.DiagramConnectionsPreferencePage
				.initDefaults(store);
		ReqModel.diagram.preferences.DiagramPrintingPreferencePage
				.initDefaults(store);
		ReqModel.diagram.preferences.DiagramRulersAndGridPreferencePage
				.initDefaults(store);

	}

	/**
	 * @generated
	 */
	protected IPreferenceStore getPreferenceStore() {
		return ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
				.getPreferenceStore();
	}
}
