package org.eclipse.emf.doc2model.doc2model.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;
import org.eclipse.emf.doc2model.doc2model.Match;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.doc2model.doc2model.Match} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MatchItemProvider
	extends ObjectContainerItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchItemProvider(AdapterFactory adapterFactory) {
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

			addUriPropertyDescriptor(object);
			addHigherThanPropertyDescriptor(object);
			addLowerThanPropertyDescriptor(object);
			addRulePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_uri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_uri_feature", "_UI_Match_type"),
				 Doc2modelPackage.Literals.MATCH__URI,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Higher Than feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHigherThanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_higherThan_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_higherThan_feature", "_UI_Match_type"),
				 Doc2modelPackage.Literals.MATCH__HIGHER_THAN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lower Than feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLowerThanPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_lowerThan_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_lowerThan_feature", "_UI_Match_type"),
				 Doc2modelPackage.Literals.MATCH__LOWER_THAN,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRulePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Match_rule_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Match_rule_feature", "_UI_Match_type"),
				 Doc2modelPackage.Literals.MATCH__RULE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns Match.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Match"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Match_type") + ((Match)object).getUri();
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

		switch (notification.getFeatureID(Match.class)) {
			case Doc2modelPackage.MATCH__URI:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
