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
public class ReqModelModelingAssistantProviderOfRequirement2EditPart extends
		ReqModel.diagram.providers.ReqModelModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ReqModel.diagram.edit.parts.Requirement2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			ReqModel.diagram.edit.parts.Requirement2EditPart source) {
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
				(ReqModel.diagram.edit.parts.Requirement2EditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			ReqModel.diagram.edit.parts.Requirement2EditPart source,
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
				(ReqModel.diagram.edit.parts.Requirement2EditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			ReqModel.diagram.edit.parts.Requirement2EditPart source,
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
		return doGetRelTypesOnTarget((ReqModel.diagram.edit.parts.Requirement2EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			ReqModel.diagram.edit.parts.Requirement2EditPart target) {
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
				(ReqModel.diagram.edit.parts.Requirement2EditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			ReqModel.diagram.edit.parts.Requirement2EditPart target,
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
