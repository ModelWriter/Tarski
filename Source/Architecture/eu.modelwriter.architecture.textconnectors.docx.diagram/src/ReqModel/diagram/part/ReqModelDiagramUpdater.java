/*
 * 
 */
package ReqModel.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

/**
 * @generated
 */
public class ReqModelDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelNodeDescriptor> getSemanticChildren(
			View view) {
		switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getVisualID(view)) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			return getProduct_1000SemanticChildren(view);
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartmentEditPart.VISUAL_ID:
			return getRequirementLevelRequirementLevelOwnedDefinitionCompartment_7001SemanticChildren(view);
		case ReqModel.diagram.edit.parts.RequirementLevelRequirementLevelOwnedDefinitionCompartment2EditPart.VISUAL_ID:
			return getRequirementLevelRequirementLevelOwnedDefinitionCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelNodeDescriptor> getProduct_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ReqModel.Product modelElement = (ReqModel.Product) view.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelNodeDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedDefinition().iterator(); it
				.hasNext();) {
			ReqModel.Definition childElement = (ReqModel.Definition) it.next();
			int visualID = ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID) {
				result.add(new ReqModel.diagram.part.ReqModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID) {
				result.add(new ReqModel.diagram.part.ReqModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelNodeDescriptor> getRequirementLevelRequirementLevelOwnedDefinitionCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ReqModel.RequirementLevel modelElement = (ReqModel.RequirementLevel) containerView
				.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelNodeDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedDefinition().iterator(); it
				.hasNext();) {
			ReqModel.Definition childElement = (ReqModel.Definition) it.next();
			int visualID = ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID) {
				result.add(new ReqModel.diagram.part.ReqModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID) {
				result.add(new ReqModel.diagram.part.ReqModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelNodeDescriptor> getRequirementLevelRequirementLevelOwnedDefinitionCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ReqModel.RequirementLevel modelElement = (ReqModel.RequirementLevel) containerView
				.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelNodeDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedDefinition().iterator(); it
				.hasNext();) {
			ReqModel.Definition childElement = (ReqModel.Definition) it.next();
			int visualID = ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID) {
				result.add(new ReqModel.diagram.part.ReqModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID) {
				result.add(new ReqModel.diagram.part.ReqModelNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getContainedLinks(
			View view) {
		switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getVisualID(view)) {
		case ReqModel.diagram.edit.parts.ProductEditPart.VISUAL_ID:
			return getProduct_1000ContainedLinks(view);
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			return getRequirementLevel_2001ContainedLinks(view);
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			return getRequirement_2002ContainedLinks(view);
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			return getRequirementLevel_3001ContainedLinks(view);
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return getRequirement_3002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getIncomingLinks(
			View view) {
		switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getVisualID(view)) {
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			return getRequirementLevel_2001IncomingLinks(view);
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			return getRequirement_2002IncomingLinks(view);
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			return getRequirementLevel_3001IncomingLinks(view);
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return getRequirement_3002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (ReqModel.diagram.part.ReqModelVisualIDRegistry
				.getVisualID(view)) {
		case ReqModel.diagram.edit.parts.RequirementLevelEditPart.VISUAL_ID:
			return getRequirementLevel_2001OutgoingLinks(view);
		case ReqModel.diagram.edit.parts.RequirementEditPart.VISUAL_ID:
			return getRequirement_2002OutgoingLinks(view);
		case ReqModel.diagram.edit.parts.RequirementLevel2EditPart.VISUAL_ID:
			return getRequirementLevel_3001OutgoingLinks(view);
		case ReqModel.diagram.edit.parts.Requirement2EditPart.VISUAL_ID:
			return getRequirement_3002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getProduct_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirementLevel_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirement_2002ContainedLinks(
			View view) {
		ReqModel.Requirement modelElement = (ReqModel.Requirement) view
				.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_Refine_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DependencyTo_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirementLevel_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirement_3002ContainedLinks(
			View view) {
		ReqModel.Requirement modelElement = (ReqModel.Requirement) view
				.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_Refine_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DependencyTo_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirementLevel_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirement_2002IncomingLinks(
			View view) {
		ReqModel.Requirement modelElement = (ReqModel.Requirement) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_Refine_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_DependencyTo_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirementLevel_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirement_3002IncomingLinks(
			View view) {
		ReqModel.Requirement modelElement = (ReqModel.Requirement) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_Refine_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Requirement_DependencyTo_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirementLevel_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirement_2002OutgoingLinks(
			View view) {
		ReqModel.Requirement modelElement = (ReqModel.Requirement) view
				.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_Refine_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DependencyTo_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirementLevel_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<ReqModel.diagram.part.ReqModelLinkDescriptor> getRequirement_3002OutgoingLinks(
			View view) {
		ReqModel.Requirement modelElement = (ReqModel.Requirement) view
				.getElement();
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_Refine_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Requirement_DependencyTo_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ReqModel.diagram.part.ReqModelLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_Refine_4001(
			ReqModel.Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ReqModel.ReqModelPackage.eINSTANCE
					.getRequirement_Refine()) {
				result.add(new ReqModel.diagram.part.ReqModelLinkDescriptor(
						setting.getEObject(),
						target,
						ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001,
						ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ReqModel.diagram.part.ReqModelLinkDescriptor> getIncomingFeatureModelFacetLinks_Requirement_DependencyTo_4002(
			ReqModel.Requirement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == ReqModel.ReqModelPackage.eINSTANCE
					.getRequirement_DependencyTo()) {
				result.add(new ReqModel.diagram.part.ReqModelLinkDescriptor(
						setting.getEObject(),
						target,
						ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002,
						ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ReqModel.diagram.part.ReqModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_Refine_4001(
			ReqModel.Requirement source) {
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		ReqModel.Requirement destination = source.getRefine();
		if (destination == null) {
			return result;
		}
		result.add(new ReqModel.diagram.part.ReqModelLinkDescriptor(
				source,
				destination,
				ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001,
				ReqModel.diagram.edit.parts.RequirementRefineEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<ReqModel.diagram.part.ReqModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_Requirement_DependencyTo_4002(
			ReqModel.Requirement source) {
		LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor> result = new LinkedList<ReqModel.diagram.part.ReqModelLinkDescriptor>();
		ReqModel.Requirement destination = source.getDependencyTo();
		if (destination == null) {
			return result;
		}
		result.add(new ReqModel.diagram.part.ReqModelLinkDescriptor(
				source,
				destination,
				ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002,
				ReqModel.diagram.edit.parts.RequirementDependencyToEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<ReqModel.diagram.part.ReqModelNodeDescriptor> getSemanticChildren(
				View view) {
			return ReqModelDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ReqModel.diagram.part.ReqModelLinkDescriptor> getContainedLinks(
				View view) {
			return ReqModelDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ReqModel.diagram.part.ReqModelLinkDescriptor> getIncomingLinks(
				View view) {
			return ReqModelDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<ReqModel.diagram.part.ReqModelLinkDescriptor> getOutgoingLinks(
				View view) {
			return ReqModelDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
