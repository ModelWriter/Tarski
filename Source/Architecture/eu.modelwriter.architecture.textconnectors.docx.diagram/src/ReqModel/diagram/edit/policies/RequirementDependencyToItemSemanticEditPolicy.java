/*
 * 
 */
package ReqModel.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class RequirementDependencyToItemSemanticEditPolicy extends
		ReqModel.diagram.edit.policies.ReqModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementDependencyToItemSemanticEditPolicy() {
		super(
				ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
