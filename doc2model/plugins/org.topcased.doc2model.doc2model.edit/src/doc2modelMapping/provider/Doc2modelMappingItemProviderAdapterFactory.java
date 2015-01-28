/**
 * <copyright>
 * </copyright>
 *
 * $Id: Doc2modelMappingItemProviderAdapterFactory.java,v 1.4 2009/05/11 06:38:54 tfaure Exp $
 */
package doc2modelMapping.provider;

import doc2modelMapping.util.Doc2modelMappingAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Doc2modelMappingItemProviderAdapterFactory extends Doc2modelMappingAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Doc2modelMappingItemProviderAdapterFactory()
    {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.doc2model} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected doc2modelItemProvider doc2modelItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.doc2model}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createdoc2modelAdapter()
    {
        if (doc2modelItemProvider == null)
        {
            doc2modelItemProvider = new doc2modelItemProvider(this);
        }

        return doc2modelItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.DocStyle} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocStyleItemProvider docStyleItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.DocStyle}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDocStyleAdapter()
    {
        if (docStyleItemProvider == null)
        {
            docStyleItemProvider = new DocStyleItemProvider(this);
        }

        return docStyleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.Hierarchy} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HierarchyItemProvider hierarchyItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.Hierarchy}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createHierarchyAdapter()
    {
        if (hierarchyItemProvider == null)
        {
            hierarchyItemProvider = new HierarchyItemProvider(this);
        }

        return hierarchyItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.AttributeTag} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeTagItemProvider attributeTagItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.AttributeTag}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAttributeTagAdapter()
    {
        if (attributeTagItemProvider == null)
        {
            attributeTagItemProvider = new AttributeTagItemProvider(this);
        }

        return attributeTagItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.TagElement} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TagElementItemProvider tagElementItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.TagElement}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTagElementAdapter()
    {
        if (tagElementItemProvider == null)
        {
            tagElementItemProvider = new TagElementItemProvider(this);
        }

        return tagElementItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.TagAttribute} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TagAttributeItemProvider tagAttributeItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.TagAttribute}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTagAttributeAdapter()
    {
        if (tagAttributeItemProvider == null)
        {
            tagAttributeItemProvider = new TagAttributeItemProvider(this);
        }

        return tagAttributeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.StyleAttribute} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StyleAttributeItemProvider styleAttributeItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.StyleAttribute}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createStyleAttributeAdapter()
    {
        if (styleAttributeItemProvider == null)
        {
            styleAttributeItemProvider = new StyleAttributeItemProvider(this);
        }

        return styleAttributeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.NewClassInjection} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NewClassInjectionItemProvider newClassInjectionItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.NewClassInjection}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createNewClassInjectionAdapter()
    {
        if (newClassInjectionItemProvider == null)
        {
            newClassInjectionItemProvider = new NewClassInjectionItemProvider(this);
        }

        return newClassInjectionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.CompositionInjection} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompositionInjectionItemProvider compositionInjectionItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.CompositionInjection}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createCompositionInjectionAdapter()
    {
        if (compositionInjectionItemProvider == null)
        {
            compositionInjectionItemProvider = new CompositionInjectionItemProvider(this);
        }

        return compositionInjectionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.AttributeInjection} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeInjectionItemProvider attributeInjectionItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.AttributeInjection}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAttributeInjectionAdapter()
    {
        if (attributeInjectionItemProvider == null)
        {
            attributeInjectionItemProvider = new AttributeInjectionItemProvider(this);
        }

        return attributeInjectionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.ReferenceInjection} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReferenceInjectionItemProvider referenceInjectionItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.ReferenceInjection}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createReferenceInjectionAdapter()
    {
        if (referenceInjectionItemProvider == null)
        {
            referenceInjectionItemProvider = new ReferenceInjectionItemProvider(this);
        }

        return referenceInjectionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.RegExAttribute} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegExAttributeItemProvider regExAttributeItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.RegExAttribute}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRegExAttributeAdapter()
    {
        if (regExAttributeItemProvider == null)
        {
            regExAttributeItemProvider = new RegExAttributeItemProvider(this);
        }

        return regExAttributeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.RegEx} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegExItemProvider regExItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.RegEx}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRegExAdapter()
    {
        if (regExItemProvider == null)
        {
            regExItemProvider = new RegExItemProvider(this);
        }

        return regExItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.NewClassInjectionComposite} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NewClassInjectionCompositeItemProvider newClassInjectionCompositeItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.NewClassInjectionComposite}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createNewClassInjectionCompositeAdapter()
    {
        if (newClassInjectionCompositeItemProvider == null)
        {
            newClassInjectionCompositeItemProvider = new NewClassInjectionCompositeItemProvider(this);
        }

        return newClassInjectionCompositeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.ColumnMatchElement} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColumnMatchElementItemProvider columnMatchElementItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.ColumnMatchElement}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createColumnMatchElementAdapter()
    {
        if (columnMatchElementItemProvider == null)
        {
            columnMatchElementItemProvider = new ColumnMatchElementItemProvider(this);
        }

        return columnMatchElementItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.ColumnMatchAttribute} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ColumnMatchAttributeItemProvider columnMatchAttributeItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.ColumnMatchAttribute}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createColumnMatchAttributeAdapter()
    {
        if (columnMatchAttributeItemProvider == null)
        {
            columnMatchAttributeItemProvider = new ColumnMatchAttributeItemProvider(this);
        }

        return columnMatchAttributeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link doc2modelMapping.TextFormatter} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TextFormatterItemProvider textFormatterItemProvider;

    /**
     * This creates an adapter for a {@link doc2modelMapping.TextFormatter}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTextFormatterAdapter()
    {
        if (textFormatterItemProvider == null)
        {
            textFormatterItemProvider = new TextFormatterItemProvider(this);
        }

        return textFormatterItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory()
    {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
    {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type)
    {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type)
    {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type)
    {
        if (isFactoryForType(type))
        {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter)))
            {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener)
    {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener)
    {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification)
    {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null)
        {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose()
    {
        if (doc2modelItemProvider != null) doc2modelItemProvider.dispose();
        if (docStyleItemProvider != null) docStyleItemProvider.dispose();
        if (hierarchyItemProvider != null) hierarchyItemProvider.dispose();
        if (attributeTagItemProvider != null) attributeTagItemProvider.dispose();
        if (tagElementItemProvider != null) tagElementItemProvider.dispose();
        if (tagAttributeItemProvider != null) tagAttributeItemProvider.dispose();
        if (styleAttributeItemProvider != null) styleAttributeItemProvider.dispose();
        if (newClassInjectionItemProvider != null) newClassInjectionItemProvider.dispose();
        if (compositionInjectionItemProvider != null) compositionInjectionItemProvider.dispose();
        if (attributeInjectionItemProvider != null) attributeInjectionItemProvider.dispose();
        if (referenceInjectionItemProvider != null) referenceInjectionItemProvider.dispose();
        if (regExAttributeItemProvider != null) regExAttributeItemProvider.dispose();
        if (regExItemProvider != null) regExItemProvider.dispose();
        if (newClassInjectionCompositeItemProvider != null) newClassInjectionCompositeItemProvider.dispose();
        if (columnMatchElementItemProvider != null) columnMatchElementItemProvider.dispose();
        if (columnMatchAttributeItemProvider != null) columnMatchAttributeItemProvider.dispose();
        if (textFormatterItemProvider != null) textFormatterItemProvider.dispose();
    }

}
