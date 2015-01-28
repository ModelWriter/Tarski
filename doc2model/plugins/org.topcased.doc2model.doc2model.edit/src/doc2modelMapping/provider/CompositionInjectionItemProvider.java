/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositionInjectionItemProvider.java,v 1.4 2009/05/11 06:38:54 tfaure Exp $
 */
package doc2modelMapping.provider;


import doc2modelMapping.CompositionInjection;
import doc2modelMapping.Doc2modelMappingPackage;

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
 * This is the item provider adapter for a {@link doc2modelMapping.CompositionInjection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositionInjectionItemProvider
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
    public CompositionInjectionItemProvider(AdapterFactory adapterFactory)
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

            addStereotypeToApplyPropertyDescriptor(object);
            addSpecificNamespaceURIPropertyDescriptor(object);
            addOwningClassPropertyDescriptor(object);
            addAssociationNamePropertyDescriptor(object);
            addAttributeNamePropertyDescriptor(object);
            addNewInstanceForEachCompositionPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Stereotype To Apply feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addStereotypeToApplyPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_StereotpyeApplicableInjection_stereotypeToApply_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_StereotpyeApplicableInjection_stereotypeToApply_feature", "_UI_StereotpyeApplicableInjection_type"),
                 Doc2modelMappingPackage.Literals.STEREOTPYE_APPLICABLE_INJECTION__STEREOTYPE_TO_APPLY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Specific Namespace URI feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSpecificNamespaceURIPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InstanceCreationInjection_specificNamespaceURI_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InstanceCreationInjection_specificNamespaceURI_feature", "_UI_InstanceCreationInjection_type"),
                 Doc2modelMappingPackage.Literals.INSTANCE_CREATION_INJECTION__SPECIFIC_NAMESPACE_URI,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Owning Class feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOwningClassPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CompositionInjection_owningClass_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CompositionInjection_owningClass_feature", "_UI_CompositionInjection_type"),
                 Doc2modelMappingPackage.Literals.COMPOSITION_INJECTION__OWNING_CLASS,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Association Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAssociationNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CompositionInjection_associationName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CompositionInjection_associationName_feature", "_UI_CompositionInjection_type"),
                 Doc2modelMappingPackage.Literals.COMPOSITION_INJECTION__ASSOCIATION_NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Attribute Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAttributeNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CompositionInjection_attributeName_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CompositionInjection_attributeName_feature", "_UI_CompositionInjection_type"),
                 Doc2modelMappingPackage.Literals.COMPOSITION_INJECTION__ATTRIBUTE_NAME,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the New Instance For Each Composition feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNewInstanceForEachCompositionPropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_CompositionInjection_newInstanceForEachComposition_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_CompositionInjection_newInstanceForEachComposition_feature", "_UI_CompositionInjection_type"),
                 Doc2modelMappingPackage.Literals.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns CompositionInjection.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object)
    {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/CompositionInjection"));
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
        String label = ((CompositionInjection)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_CompositionInjection_type") :
            getString("_UI_CompositionInjection_type") + " " + label;
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

        switch (notification.getFeatureID(CompositionInjection.class))
        {
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__STEREOTYPE_TO_APPLY:
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__SPECIFIC_NAMESPACE_URI:
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__OWNING_CLASS:
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ASSOCIATION_NAME:
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__ATTRIBUTE_NAME:
            case Doc2modelMappingPackage.COMPOSITION_INJECTION__NEW_INSTANCE_FOR_EACH_COMPOSITION:
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
