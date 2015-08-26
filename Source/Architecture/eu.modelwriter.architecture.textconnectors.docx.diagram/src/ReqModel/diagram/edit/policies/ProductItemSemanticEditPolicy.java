/*
 * 
 */
package ReqModel.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class ProductItemSemanticEditPolicy extends
		ReqModel.diagram.edit.policies.ReqModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ProductItemSemanticEditPolicy() {
		super(ReqModel.diagram.providers.ReqModelElementTypes.Product_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001 == req
				.getElementType()) {
			return getGEFWrapper(new ReqModel.diagram.edit.commands.RequirementLevelCreateCommand(
					req));
		}
		if (ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002 == req
				.getElementType()) {
			return getGEFWrapper(new ReqModel.diagram.edit.commands.RequirementCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
