head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.28.07;	author tfaure;	state Exp;
branches;
next	;
commitid	6e914b8d90e34567;


desc
@@


1.1
log
@first commit for doc2model api edit
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.doc2model.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.doc2model.doc2model.Doc2Model;
import org.eclipse.emf.doc2model.doc2model.Doc2modelFactory;
import org.eclipse.emf.doc2model.doc2model.Doc2modelPackage;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@@link org.eclipse.emf.doc2model.doc2model.Doc2Model} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @@generated
 */
public class Doc2ModelItemProvider
	extends ObjectContainerItemProvider
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
	 * @@generated
	 */
	public Doc2ModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addInitialActionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Initial Action feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	protected void addInitialActionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Doc2Model_initialAction_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Doc2Model_initialAction_feature", "_UI_Doc2Model_type"),
				 Doc2modelPackage.Literals.DOC2_MODEL__INITIAL_ACTION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@@link org.eclipse.emf.edit.command.AddCommand}, {@@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@@link org.eclipse.emf.edit.command.MoveCommand} in {@@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Doc2modelPackage.Literals.DOC2_MODEL__CONFIGURATION);
			childrenFeatures.add(Doc2modelPackage.Literals.DOC2_MODEL__RULES);
			childrenFeatures.add(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_MATCHES);
			childrenFeatures.add(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Doc2Model.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Doc2Model"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public String getText(Object object) {
		return getString("_UI_Doc2Model_type");
	}

	/**
	 * This handles model notifications by calling {@@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Doc2Model.class)) {
			case Doc2modelPackage.DOC2_MODEL__CONFIGURATION:
			case Doc2modelPackage.DOC2_MODEL__RULES:
			case Doc2modelPackage.DOC2_MODEL__OWNED_MATCHES:
			case Doc2modelPackage.DOC2_MODEL__OWNED_ACTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@generated
	 */
	@@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__CONFIGURATION,
				 Doc2modelFactory.eINSTANCE.createConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__RULES,
				 Doc2modelFactory.eINSTANCE.createRule()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_MATCHES,
				 Doc2modelFactory.eINSTANCE.createMatch()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createCreateElementAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createFillAttributeAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createRegexTextTransformer()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createStringReplacementTextTransformer()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createReferenceStaticElementAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createReferenceElementAction()));

		newChildDescriptors.add
			(createChildParameter
				(Doc2modelPackage.Literals.DOC2_MODEL__OWNED_ACTIONS,
				 Doc2modelFactory.eINSTANCE.createSetContainerAction()));
	}

}
@
