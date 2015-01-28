/**
 * <copyright>
 * </copyright>
 *
 * $Id: doc2modelItemProvider.java,v 1.4 2009/05/11 06:38:54 tfaure Exp $
 */
package doc2modelMapping.provider;


import doc2modelMapping.Doc2modelMappingFactory;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.doc2model;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link doc2modelMapping.doc2model} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class doc2modelItemProvider
    extends DynamicElementItemProvider
    implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public doc2modelItemProvider(AdapterFactory adapterFactory)
    {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
    {
        if (itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            addExtensionPropertyDescriptor(object);
            addMetamodelURIPropertyDescriptor(object);
            addProfileURIPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Extension feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addExtensionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_doc2model_extension_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_doc2model_extension_feature", "_UI_doc2model_type"),
                 Doc2modelMappingPackage.Literals.DOC2MODEL__EXTENSION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Metamodel URI feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMetamodelURIPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_doc2model_metamodelURI_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_doc2model_metamodelURI_feature", "_UI_doc2model_type"),
                 Doc2modelMappingPackage.Literals.DOC2MODEL__METAMODEL_URI,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Profile URI feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addProfileURIPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_doc2model_profileURI_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_doc2model_profileURI_feature", "_UI_doc2model_type"),
                 Doc2modelMappingPackage.Literals.DOC2MODEL__PROFILE_URI,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
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
    public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
    {
        if (childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            childrenFeatures.add(Doc2modelMappingPackage.Literals.DOC2MODEL__LINKS);
            childrenFeatures.add(Doc2modelMappingPackage.Literals.DOC2MODEL__HIERARCHY);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child)
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns doc2model.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/doc2model"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((doc2model)object).getExtension();
        return label == null || label.length() == 0 ?
            getString("_UI_doc2model_type") :
            getString("_UI_doc2model_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification)
    {
        updateChildren(notification);

        switch (notification.getFeatureID(doc2model.class))
        {
            case Doc2modelMappingPackage.DOC2MODEL__EXTENSION:
            case Doc2modelMappingPackage.DOC2MODEL__METAMODEL_URI:
            case Doc2modelMappingPackage.DOC2MODEL__PROFILE_URI:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case Doc2modelMappingPackage.DOC2MODEL__LINKS:
            case Doc2modelMappingPackage.DOC2MODEL__HIERARCHY:
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
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.DOC2MODEL__LINKS,
                 Doc2modelMappingFactory.eINSTANCE.createDocStyle()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.DOC2MODEL__LINKS,
                 Doc2modelMappingFactory.eINSTANCE.createTagElement()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.DOC2MODEL__LINKS,
                 Doc2modelMappingFactory.eINSTANCE.createRegEx()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.DOC2MODEL__LINKS,
                 Doc2modelMappingFactory.eINSTANCE.createColumnMatchElement()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.DOC2MODEL__HIERARCHY,
                 Doc2modelMappingFactory.eINSTANCE.createHierarchy()));
    }

}
