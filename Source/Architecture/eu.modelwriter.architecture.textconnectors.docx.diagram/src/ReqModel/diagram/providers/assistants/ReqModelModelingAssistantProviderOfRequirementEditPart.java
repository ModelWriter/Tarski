/*
 * 
 */
package ReqModel.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class ReqModelModelingAssistantProviderOfRequirementEditPart extends
		ReqModel.diagram.providers.ReqModelModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ReqModel.diagram.edit.parts.RequirementEditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			ReqModel.diagram.edit.parts.RequirementEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(ReqModel.diagram.edit.parts.RequirementEditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			ReqModel.diagram.edit.parts.RequirementEditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ReqModel.diagram.edit.parts.RequirementEditPart) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001);
		}
		if (targetEditPart instanceof ReqModel.diagram.edit.parts.Requirement2EditPart) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001);
		}
		if (targetEditPart instanceof ReqModel.diagram.edit.parts.RequirementEditPart) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002);
		}
		if (targetEditPart instanceof ReqModel.diagram.edit.parts.Requirement2EditPart) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget(
				(ReqModel.diagram.edit.parts.RequirementEditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			ReqModel.diagram.edit.parts.RequirementEditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002);
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002);
		} else if (relationshipType == ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002);
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ReqModel.diagram.edit.parts.RequirementEditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			ReqModel.diagram.edit.parts.RequirementEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource(
				(ReqModel.diagram.edit.parts.RequirementEditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			ReqModel.diagram.edit.parts.RequirementEditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002);
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002);
		} else if (relationshipType == ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002) {
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002);
			types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002);
		}
		return types;
	}

}
