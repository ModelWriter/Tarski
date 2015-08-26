/*
 * 
 */
package ReqModel.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class ReqModelEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getVisualID(view)) {

			case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.ProductEditPart(view);

			case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementLevelEditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementLevelNameEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementLevelNameEditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementEditPart(view);

			case ReqModel.diagram.edit.parts.RequirementNameEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementNameEditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementLevel2EditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementLevelName2EditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementLevelName2EditPart(
						view);

			case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.Requirement2EditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementName2EditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementName2EditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementRefineEditPart(
						view);

			case ReqModel.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.WrappingLabelEditPart(
						view);

			case ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.RequirementDependencyToEditPart(
						view);

			case ReqModel.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new ReqModel.diagram.edit.parts.WrappingLabel2EditPart(
						view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
