/*
 * 
 */
package ReqModel.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class RequirementLevelRequirementLevelOwnedDefinitionCompartmentItemSemanticEditPolicy
		extends
		ReqModel.diagram.edit.policies.ReqModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementLevelRequirementLevelOwnedDefinitionCompartmentItemSemanticEditPolicy() {
		super(
				ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_3001 == req
				.getElementType()) {
			return getGEFWrapper(new ReqModel.diagram.edit.commands.RequirementLevel2CreateCommand(
					req));
		}
		if (ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002 == req
				.getElementType()) {
			return getGEFWrapper(new ReqModel.diagram.edit.commands.Requirement2CreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
