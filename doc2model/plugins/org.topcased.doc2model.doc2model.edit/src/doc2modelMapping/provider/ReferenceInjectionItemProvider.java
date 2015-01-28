/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferenceInjectionItemProvider.java,v 1.5 2009/05/18 07:47:01 tfaure Exp $
 */
package doc2modelMapping.provider;


import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.ReferenceInjection;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

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
 * This is the item provider adapter for a {@link doc2modelMapping.ReferenceInjection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReferenceInjectionItemProvider
    extends DependantInjectionItemProvider
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
    public ReferenceInjectionItemProvider(AdapterFactory adapterFactory)
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

            addAttributeToFindPropertyDescriptor(object);
            addClassReferencedPropertyDescriptor(object);
            addReferenceAttributePropertyDescriptor(object);
            addIsStereotypeReferencePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Attribute To Find feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAttributeToFindPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ReferenceInjection_attributeToFind_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ReferenceInjection_attributeToFind_feature", "_UI_ReferenceInjection_type"),
                 Doc2modelMappingPackage.Literals.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Class Referenced feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addClassReferencedPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ReferenceInjection_classReferenced_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ReferenceInjection_classReferenced_feature", "_UI_ReferenceInjection_type"),
                 Doc2modelMappingPackage.Literals.REFERENCE_INJECTION__CLASS_REFERENCED,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Reference Attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addReferenceAttributePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ReferenceInjection_referenceAttribute_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ReferenceInjection_referenceAttribute_feature", "_UI_ReferenceInjection_type"),
                 Doc2modelMappingPackage.Literals.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Is Stereotype Reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addIsStereotypeReferencePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ReferenceInjection_isStereotypeReference_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ReferenceInjection_isStereotypeReference_feature", "_UI_ReferenceInjection_type"),
                 Doc2modelMappingPackage.Literals.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns ReferenceInjection.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ReferenceInjection"));
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
        String label = ((ReferenceInjection)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_ReferenceInjection_type") :
            getString("_UI_ReferenceInjection_type") + " " + label;
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

        switch (notification.getFeatureID(ReferenceInjection.class))
        {
            case Doc2modelMappingPackage.REFERENCE_INJECTION__ATTRIBUTE_TO_FIND:
            case Doc2modelMappingPackage.REFERENCE_INJECTION__CLASS_REFERENCED:
            case Doc2modelMappingPackage.REFERENCE_INJECTION__REFERENCE_ATTRIBUTE:
            case Doc2modelMappingPackage.REFERENCE_INJECTION__IS_STEREOTYPE_REFERENCE:
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
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
    {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
