/**
 * <copyright>
 * </copyright>
 *
 * $Id: InjectionElementItemProvider.java,v 1.3 2009/05/11 06:38:54 tfaure Exp $
 */
package doc2modelMapping.provider;


import doc2modelMapping.Doc2modelMappingFactory;
import doc2modelMapping.Doc2modelMappingPackage;
import doc2modelMapping.InjectionElement;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
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
 * This is the item provider adapter for a {@link doc2modelMapping.InjectionElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InjectionElementItemProvider
    extends ItemProviderAdapter
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
    public InjectionElementItemProvider(AdapterFactory adapterFactory)
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

            addNamePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object)
    {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_InjectionElement_name_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_InjectionElement_name_feature", "_UI_InjectionElement_type"),
                 Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__NAME,
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
            childrenFeatures.add(Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STRING_FORMAT);
            childrenFeatures.add(Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS);
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
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object)
    {
        String label = ((InjectionElement)object).getName();
        return label == null || label.length() == 0 ?
            getString("_UI_InjectionElement_type") :
            getString("_UI_InjectionElement_type") + " " + label;
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

        switch (notification.getFeatureID(InjectionElement.class))
        {
            case Doc2modelMappingPackage.INJECTION_ELEMENT__NAME:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STRING_FORMAT:
            case Doc2modelMappingPackage.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS:
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
                (Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STRING_FORMAT,
                 Doc2modelMappingFactory.eINSTANCE.createTextFormatter()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS,
                 Doc2modelMappingFactory.eINSTANCE.createNewClassInjection()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS,
                 Doc2modelMappingFactory.eINSTANCE.createCompositionInjection()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS,
                 Doc2modelMappingFactory.eINSTANCE.createAttributeInjection()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS,
                 Doc2modelMappingFactory.eINSTANCE.createReferenceInjection()));

        newChildDescriptors.add
            (createChildParameter
                (Doc2modelMappingPackage.Literals.INJECTION_ELEMENT__STANDARD_OPTIONAL_INJECTIONS,
                 Doc2modelMappingFactory.eINSTANCE.createNewClassInjectionComposite()));
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator()
    {
        return Doc2modelEditPlugin.INSTANCE;
    }

}
