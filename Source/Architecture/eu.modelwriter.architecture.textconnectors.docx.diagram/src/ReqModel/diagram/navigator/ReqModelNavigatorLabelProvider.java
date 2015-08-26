/*
 * 
 */
package ReqModel.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class ReqModelNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		ReqModel.diagram.part.ReqModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		ReqModel.diagram.part.ReqModelDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof ReqModel.diagram.navigator.ReqModelNavigatorItem
				&& !isOwnView(((ReqModel.diagram.navigator.ReqModelNavigatorItem) element)
						.getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof ReqModel.diagram.navigator.ReqModelNavigatorGroup) {
			ReqModel.diagram.navigator.ReqModelNavigatorGroup group = (ReqModel.diagram.navigator.ReqModelNavigatorGroup) element;
			return ReqModel.diagram.part.ReqModelDiagramEditorPlugin
					.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof ReqModel.diagram.navigator.ReqModelNavigatorItem) {
			ReqModel.diagram.navigator.ReqModelNavigatorItem navigatorItem = (ReqModel.diagram.navigator.ReqModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getVisualID(view)) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?eu.modelwriter.architecture.textconnectors.docx.reqmodel?Product", ReqModel.diagram.providers.ReqModelElementTypes.Product_1000); //$NON-NLS-1$
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?eu.modelwriter.architecture.textconnectors.docx.reqmodel?RequirementLevel", ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001); //$NON-NLS-1$
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?eu.modelwriter.architecture.textconnectors.docx.reqmodel?Requirement", ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002); //$NON-NLS-1$
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?eu.modelwriter.architecture.textconnectors.docx.reqmodel?RequirementLevel", ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_3001); //$NON-NLS-1$
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?eu.modelwriter.architecture.textconnectors.docx.reqmodel?Requirement", ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002); //$NON-NLS-1$
		case ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?eu.modelwriter.architecture.textconnectors.docx.reqmodel?Requirement?Refine", ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001); //$NON-NLS-1$
		case ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?eu.modelwriter.architecture.textconnectors.docx.reqmodel?Requirement?DependencyTo", ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = ReqModel.diagram.part.ReqModelDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null
				&& elementType != null
				&& ReqModel.diagram.providers.ReqModelElementTypes
						.isKnownElementType(elementType)) {
			image = ReqModel.diagram.providers.ReqModelElementTypes
					.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof ReqModel.diagram.navigator.ReqModelNavigatorGroup) {
			ReqModel.diagram.navigator.ReqModelNavigatorGroup group = (ReqModel.diagram.navigator.ReqModelNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof ReqModel.diagram.navigator.ReqModelNavigatorItem) {
			ReqModel.diagram.navigator.ReqModelNavigatorItem navigatorItem = (ReqModel.diagram.navigator.ReqModelNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getVisualID(view)) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			return getProduct_1000Text(view);
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			return getRequirementLevel_2001Text(view);
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			return getRequirement_2002Text(view);
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			return getRequirementLevel_3001Text(view);
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return getRequirement_3002Text(view);
		case ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID:
			return getRequirementRefine_4001Text(view);
		case ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID:
			return getRequirementDependencyTo_4002Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getProduct_1000Text(View view) {
		ReqModel.Product domainModelElement = (ReqModel.Product) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin
					.getInstance()
					.logError(
							"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementLevel_2001Text(View view) {
		IParser parser = ReqModel.diagram.providers.ReqModelParserProvider
				.getParser(
						ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001,
						view.getElement() != null ? view.getElement() : view,
						ReqModel.diagram.part.ReqModelVisualIDRegistry
								.getType(ReqModel.diagram.edit.parts.RequirementLevelNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirement_2002Text(View view) {
		IParser parser = ReqModel.diagram.providers.ReqModelParserProvider
				.getParser(
						ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002,
						view.getElement() != null ? view.getElement() : view,
						ReqModel.diagram.part.ReqModelVisualIDRegistry
								.getType(ReqModel.diagram.edit.parts.RequirementNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementLevel_3001Text(View view) {
		IParser parser = ReqModel.diagram.providers.ReqModelParserProvider
				.getParser(
						ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_3001,
						view.getElement() != null ? view.getElement() : view,
						ReqModel.diagram.part.ReqModelVisualIDRegistry
								.getType(ReqModel.diagram.edit.parts.RequirementLevelName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirement_3002Text(View view) {
		IParser parser = ReqModel.diagram.providers.ReqModelParserProvider
				.getParser(
						ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002,
						view.getElement() != null ? view.getElement() : view,
						ReqModel.diagram.part.ReqModelVisualIDRegistry
								.getType(ReqModel.diagram.edit.parts.RequirementName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementRefine_4001Text(View view) {
		IParser parser = ReqModel.diagram.providers.ReqModelParserProvider
				.getParser(
						ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRequirementDependencyTo_4002Text(View view) {
		IParser parser = ReqModel.diagram.providers.ReqModelParserProvider
				.getParser(
						ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002,
						view.getElement() != null ? view.getElement() : view,
						CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.logError("Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return ReqModel.diagram.edit.parts.ProductEditPart.MODEL_ID
				.equals(ReqModel.diagram.part.ReqModelVisualIDRegistry
						.getModelID(view));
	}

}
