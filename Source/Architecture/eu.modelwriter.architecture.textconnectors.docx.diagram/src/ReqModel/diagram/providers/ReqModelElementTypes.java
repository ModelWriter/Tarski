/*
 * 
 */
package ReqModel.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class ReqModelElementTypes {

	/**
	 * @generated
	 */
	private ReqModelElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Product_1000 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.Product_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementLevel_2001 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.RequirementLevel_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Requirement_2002 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.Requirement_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementLevel_3001 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.RequirementLevel_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Requirement_3002 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.Requirement_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementRefine_4001 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.RequirementRefine_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType RequirementDependencyTo_4002 = getElementType("eu.modelwriter.architecture.textconnectors.docx.diagram.RequirementDependencyTo_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Product_1000,
					ReqModel.ReqModelPackage.eINSTANCE.getProduct());

			elements.put(RequirementLevel_2001,
					ReqModel.ReqModelPackage.eINSTANCE.getRequirementLevel());

			elements.put(Requirement_2002,
					ReqModel.ReqModelPackage.eINSTANCE.getRequirement());

			elements.put(RequirementLevel_3001,
					ReqModel.ReqModelPackage.eINSTANCE.getRequirementLevel());

			elements.put(Requirement_3002,
					ReqModel.ReqModelPackage.eINSTANCE.getRequirement());

			elements.put(RequirementRefine_4001,
					ReqModel.ReqModelPackage.eINSTANCE.getRequirement_Refine());

			elements.put(RequirementDependencyTo_4002,
					ReqModel.ReqModelPackage.eINSTANCE
							.getRequirement_DependencyTo());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Product_1000);
			KNOWN_ELEMENT_TYPES.add(RequirementLevel_2001);
			KNOWN_ELEMENT_TYPES.add(Requirement_2002);
			KNOWN_ELEMENT_TYPES.add(RequirementLevel_3001);
			KNOWN_ELEMENT_TYPES.add(Requirement_3002);
			KNOWN_ELEMENT_TYPES.add(RequirementRefine_4001);
			KNOWN_ELEMENT_TYPES.add(RequirementDependencyTo_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			return Product_1000;
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			return RequirementLevel_2001;
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			return Requirement_2002;
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			return RequirementLevel_3001;
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return Requirement_3002;
		case ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID:
			return RequirementRefine_4001;
		case ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID:
			return RequirementDependencyTo_4002;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return ReqModel.diagram.providers.ReqModelElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return ReqModel.diagram.providers.ReqModelElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return ReqModel.diagram.providers.ReqModelElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
