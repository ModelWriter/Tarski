/*
 * 
 */
package ReqModel.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ReqModelVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "eu.modelwriter.architecture.textconnectors.docx.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ReqModel.diagram.edit.parts.ProductEditPart.MODEL_ID
					.equals(view.getType())) {
				return ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return ReqModel.diagram.part.ReqModelVisualIDRegistry.getVisualID(view
				.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				ReqModel.diagram.part.ReqModelDiagramEditorPlugin.getInstance()
						.logError(
								"Unable to parse view type as a visualID number: "
										+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (ReqModel.ReqModelPackage.eINSTANCE.getProduct().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((ReqModel.Product) domainElement)) {
			return ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getModelID(containerView);
		if (!ReqModel.diagram.edit.parts.ProductEditPart.MODEL_ID
				.equals(containerModelID)
				&& !"ReqModel".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ReqModel.diagram.edit.parts.ProductEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			if (ReqModel.ReqModelPackage.eINSTANCE.getRequirementLevel()
					.isSuperTypeOf(domainElement.eClass())) {
				return ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID;
			}
			if (ReqModel.ReqModelPackage.eINSTANCE.getRequirement()
					.isSuperTypeOf(domainElement.eClass())) {
				return ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart.VISUAL_ID:
			if (ReqModel.ReqModelPackage.eINSTANCE.getRequirementLevel()
					.isSuperTypeOf(domainElement.eClass())) {
				return ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID;
			}
			if (ReqModel.ReqModelPackage.eINSTANCE.getRequirement()
					.isSuperTypeOf(domainElement.eClass())) {
				return ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart.VISUAL_ID:
			if (ReqModel.ReqModelPackage.eINSTANCE.getRequirementLevel()
					.isSuperTypeOf(domainElement.eClass())) {
				return ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID;
			}
			if (ReqModel.ReqModelPackage.eINSTANCE.getRequirement()
					.isSuperTypeOf(domainElement.eClass())) {
				return ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getModelID(containerView);
		if (!ReqModel.diagram.edit.parts.ProductEditPart.MODEL_ID
				.equals(containerModelID)
				&& !"ReqModel".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ReqModel.diagram.edit.parts.ProductEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementLevelNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementLevelName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID:
			if (ReqModel.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(ReqModel.Product element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart.VISUAL_ID:
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			return false;
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return ReqModel.diagram.part.ReqModelVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return ReqModel.diagram.part.ReqModelVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return ReqModel.diagram.part.ReqModelVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
