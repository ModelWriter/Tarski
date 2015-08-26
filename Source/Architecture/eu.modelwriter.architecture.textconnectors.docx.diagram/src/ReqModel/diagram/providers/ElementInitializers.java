/*
 * 
 */
package ReqModel.diagram.providers;

/**
 * @generated
 */
public class ElementInitializers {

	protected ElementInitializers() {
		// use #getInstance to access cached instance
	}

	/**
	 * @generated
	 */
	public static ElementInitializers getInstance() {
		ElementInitializers cached = ReqModel.diagram.part.ReqModelDiagramEditorPlugin
				.getInstance().getElementInitializers();
		if (cached == null) {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.setElementInitializers(cached = new ElementInitializers());
		}
		return cached;
	}
}
