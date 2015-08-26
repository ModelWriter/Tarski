/*
 * 
 */
package ReqModel.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class ReqModelModelingAssistantProviderOfProductEditPart extends
		ReqModel.diagram.providers.ReqModelModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002);
		return types;
	}

}
