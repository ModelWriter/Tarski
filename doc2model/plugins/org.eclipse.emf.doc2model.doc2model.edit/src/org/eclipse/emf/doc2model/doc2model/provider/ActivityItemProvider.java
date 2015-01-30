package org.eclipse.emf.doc2model.doc2model.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.doc2model.doc2model.Activity;
import org.eclipse.emf.doc2model.doc2model.Doc2modelFactory;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.doc2model.doc2model.Activity} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityItemProvider
	extends ActionItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Doc2modelPackage.Literals.OBJECT_CONTAINER__OWNED_OBJECTS);
			childrenFeatures.add(Doc2modelPackage.Literals.ACTIVITY__ACTIONS);
			childrenFeatures.add(Doc2modelPackage.Literals.ACTIVITY__PARAMETERS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Activity.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Activity"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Activity_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Activity.class)) {
			case Doc2modelPackage.ACTIVITY__OWNED_OBJECTS:
			case Doc2modelPackage.ACTIVITY__ACTIONS:
			case Doc2modelPackage.ACTIVITY__PARAMETERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.OBJECT_CONTAINER__OWNED_OBJECTS,
				 Doc2modelFactory.eINSTANCE.createContainerSelectionObject()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.OBJECT_CONTAINER__OWNED_OBJECTS,
				 Doc2modelFactory.eINSTANCE.createParameterObject()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.OBJECT_CONTAINER__OWNED_OBJECTS,
				 Doc2modelFactory.eINSTANCE.createActionResultObject()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.OBJECT_CONTAINER__OWNED_OBJECTS,
				 Doc2modelFactory.eINSTANCE.createMatchingResultObject()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createCreateElementAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createFillAttributeAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createRegexTextTransformer()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createStringReplacementTextTransformer()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createReferenceStaticElementAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createReferenceElementAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__ACTIONS,
				 Doc2modelFactory.eINSTANCE.createSetContainerAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.ACTIVITY__PARAMETERS,
				 Doc2modelFactory.eINSTANCE.createParameterObject()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == Doc2modelPackage.Literals.OBJECT_CONTAINER__OWNED_OBJECTS ||
			childFeature == Doc2modelPackage.Literals.ACTIVITY__PARAMETERS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
