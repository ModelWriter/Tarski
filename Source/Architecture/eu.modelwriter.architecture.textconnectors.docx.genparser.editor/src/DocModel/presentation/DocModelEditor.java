/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
/**
 */
package DocModel.presentation;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.celleditor.AdapterFactoryTreeEditor;
import org.eclipse.emf.edit.ui.dnd.EditingDomainViewerDropAdapter;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.UnwrappingSelectionProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.modelwriter.architecture.textconnectors.docx.genparser.notifymanager.MappingManager;

import DocModel.Document;
import DocModel.Node;
import DocModel.Paragraph;
import DocModel.Part;
import DocModel.provider.DocModelItemProviderAdapterFactory;

/**
 * This is an example of a DocModel model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class DocModelEditor extends MultiPageEditorPart implements IEditingDomainProvider,
    ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public class ReverseAdapterFactoryContentProvider extends AdapterFactoryContentProvider {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ReverseAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
      super(adapterFactory);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object[] getChildren(Object object) {
      Object parent = super.getParent(object);
      return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object[] getElements(Object object) {
      Object parent = super.getParent(object);
      return (parent == null ? Collections.EMPTY_SET : Collections.singleton(parent)).toArray();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getParent(Object object) {
      return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean hasChildren(Object object) {
      Object parent = super.getParent(object);
      return parent != null;
    }
  }

  /**
   * This looks up a string in the plugin's plugin.properties file. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  private static String getString(String key) {
    return DocumentModelEditorPlugin.INSTANCE.getString(key);
  }

  /**
   * This looks up a string in plugin.properties, making a substitution. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  private static String getString(String key, Object s1) {
    return DocumentModelEditorPlugin.INSTANCE.getString(key, new Object[] {s1});
  }

  /**
   * This keeps track of the editing domain that is used to track all changes to the model. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected AdapterFactoryEditingDomain editingDomain;

  /**
   * This is the one adapter factory used for providing views of the model. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ComposedAdapterFactory adapterFactory;

  /**
   * This is the content outline page. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected IContentOutlinePage contentOutlinePage;

  /**
   * This is a kludge... <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected IStatusLineManager contentOutlineStatusLineManager;

  /**
   * This is the content outline page's viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TreeViewer contentOutlineViewer;

  /**
   * This is the property sheet page. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected List<PropertySheetPage> propertySheetPages = new ArrayList<PropertySheetPage>();

  /**
   * This is the viewer that shadows the selection in the content outline. The parent relation must
   * be correctly defined for this to work. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TreeViewer selectionViewer;

  /**
   * This inverts the roll of parent and child in the content provider and show parents as a tree.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TreeViewer parentViewer;

  /**
   * This shows how a tree view works. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TreeViewer treeViewer;

  /**
   * This shows how a list view works. A list viewer doesn't support icons. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected ListViewer listViewer;

  /**
   * This shows how a table view works. A table can be used as a list with icons. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TableViewer tableViewer;

  /**
   * This shows how a tree view with columns works. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TreeViewer treeViewerWithColumns;

  /**
   * This keeps track of the active viewer pane, in the book. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected ViewerPane currentViewerPane;

  /**
   * This keeps track of the active content viewer, which may be either one of the viewers in the
   * pages or the content outline viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected Viewer currentViewer;

  /**
   * This listens to which ever viewer is active. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected ISelectionChangedListener selectionChangedListener;

  /**
   * This keeps track of all the {@link org.eclipse.jface.viewers.ISelectionChangedListener}s that
   * are listening to this editor. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected Collection<ISelectionChangedListener> selectionChangedListeners =
      new ArrayList<ISelectionChangedListener>();

  /**
   * This keeps track of the selection of the editor as a whole. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected ISelection editorSelection = StructuredSelection.EMPTY;

  /**
   * The MarkerHelper is responsible for creating workspace resource markers presented in Eclipse's
   * Problems View. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected MarkerHelper markerHelper = new EditUIMarkerHelper();

  /**
   * This listens for when the outline becomes active <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected IPartListener partListener = new IPartListener() {
    @Override
    public void partActivated(IWorkbenchPart p) {
      if (p instanceof ContentOutline) {
        if (((ContentOutline) p).getCurrentPage() == DocModelEditor.this.contentOutlinePage) {
          DocModelEditor.this.getActionBarContributor().setActiveEditor(DocModelEditor.this);

          DocModelEditor.this.setCurrentViewer(DocModelEditor.this.contentOutlineViewer);
        }
      } else if (p instanceof PropertySheet) {
        if (DocModelEditor.this.propertySheetPages.contains(((PropertySheet) p).getCurrentPage())) {
          DocModelEditor.this.getActionBarContributor().setActiveEditor(DocModelEditor.this);
          DocModelEditor.this.handleActivate();
        }
      } else if (p == DocModelEditor.this) {
        DocModelEditor.this.handleActivate();
      }
    }

    @Override
    public void partBroughtToTop(IWorkbenchPart p) {
      // Ignore.
    }

    @Override
    public void partClosed(IWorkbenchPart p) {
      // Ignore.
    }

    @Override
    public void partDeactivated(IWorkbenchPart p) {
      // Ignore.
    }

    @Override
    public void partOpened(IWorkbenchPart p) {
      // Ignore.
    }
  };

  /**
   * Resources that have been removed since last activation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected Collection<Resource> removedResources = new ArrayList<Resource>();

  /**
   * Resources that have been changed since last activation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected Collection<Resource> changedResources = new ArrayList<Resource>();


  /**
   * Resources that have been saved. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected Collection<Resource> savedResources = new ArrayList<Resource>();

  /**
   * Map to store the diagnostic associated with a resource. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected Map<Resource, Diagnostic> resourceToDiagnosticMap =
      new LinkedHashMap<Resource, Diagnostic>();

  /**
   * Controls whether the problem indication should be updated. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected boolean updateProblemIndication = true;

  /**
   * This listens for EMF instance changes.
   */
  protected EContentAdapter changeOnModelNotifier = new EContentAdapter() {


    private void handleDocumentNotification(Notification n) {
      int featureID = n.getFeatureID(Document.class);
      if (featureID == DocModel.DocModelPackage.DOCUMENT__OWNED_PARAGRAPH) {
        // adding a new paragraph
        if (n.getEventType() == Notification.ADD) {
          Paragraph p = (Paragraph) n.getNewValue();
          // p.setId(EcoreUtil.generateUUID());
          System.out.println("New Paragraph was added to the Document: " + p.getName());
        }
        // removing an old paragraph
        else if (n.getEventType() == Notification.REMOVE) {
          Paragraph p = (Paragraph) n.getOldValue();
          System.out.println("Paragraph was deleted from the Document: " + p.getName());
          MappingManager map = MappingManager.getInstance();
          map.removeParagraph(p.getId());
        }
      } else if (featureID == DocModel.DocModelPackage.DOCUMENT__NAME) {
        Paragraph p = (Paragraph) n.getOldValue();
        String old = n.getOldStringValue();
        String newOne = n.getNewStringValue();
        System.out.println("Changing Document name as : " + newOne + " (old name:" + old);
      }
    }

    private void handleNodeNotification(Notification n) {
      int featureID = n.getFeatureID(Document.class);
      if (featureID == DocModel.DocModelPackage.NODE__NAME) {
        Node node = (Node) n.getNotifier();
        String old = n.getOldStringValue();
        String newOne = n.getNewStringValue();
        System.out.println(
            "Changing Node name(id:" + node.getId() + ") as : " + newOne + " (old name:" + old);
        // MappingManager mm = MappingManager.getInstance();
        // mm.changeNodeName(node.getId(), newOne);
      }
    }

    private void handleParagraphNotification(Notification n) {

      int featureID = n.getFeatureID(Paragraph.class);
      // changing the name of the paragraph
      // p.rawText must be equals the p.name
      if (featureID == DocModel.DocModelPackage.PARAGRAPH__NAME) {
        Paragraph p = (Paragraph) n.getNotifier();
        String old = n.getOldStringValue();
        String newOne = n.getNewStringValue();
        System.out.println("old name : '" + old + "' is now : '" + newOne + "'");
        MappingManager map = MappingManager.getInstance();
        map.changeParagraphName(p.getId(), newOne);
      } else if (featureID == DocModel.DocModelPackage.PARAGRAPH__OWNED_NODE) {
        // adding a new paragraph(node)
        if (n.getEventType() == Notification.ADD) {
          Paragraph p = (Paragraph) n.getNewValue();
          // p.setId(EcoreUtil.generateUUID());
          System.out.println("New Paragraph(Node) was added to the Paragraph: " + p.getName());
        }

        // removing an old paragraph(node)
        else if (n.getEventType() == Notification.REMOVE) {
          Paragraph p = (Paragraph) n.getOldValue();
          System.out.println("Paragraph(Node) was deleted from the Paragraph: " + p.getName());
          // Removes all corresponding objects
          MappingManager mm = MappingManager.getInstance();
          mm.removeParagraph(p.getId());
        }

      } else if (featureID == DocModel.DocModelPackage.PARAGRAPH__OWNED_PART) {
        // adding a new part
        if (n.getEventType() == Notification.ADD) {
          Part p = (Part) n.getNewValue();
          // p.setId(EcoreUtil.generateUUID());
          System.out.println("New Part was added to the Paragraph: " + p.getName());
        }
        // removing an old paragraph(node)
        else if (n.getEventType() == Notification.REMOVE) {
          Part p = (Part) n.getNewValue();
          System.out.println("Paragraph(Node) was deleted from the Paragraph: " + p.getName());
        }

      }
    }

    private void handlePartNotification(Notification n) {
      int featureID = n.getFeatureID(Document.class);
      // rawText must be considered as name
      if (featureID == DocModel.DocModelPackage.PART__NAME) {
        Part p = (Part) n.getNotifier();
        String old = n.getOldStringValue();
        String newOne = n.getNewStringValue();
        System.out.println(
            "Changing Part name(id:" + p.getId() + ") as : " + newOne + " (old name:" + old);
        // MappingManager map = MappingManager.getInstance();
        // map.changePartName(p.getId(),newOne);
      } else if (featureID == DocModel.DocModelPackage.PART__NEXT_PART) {
        Part p = (Part) n.getNewValue();
        System.out.println("New Part was added to the Part as its NEXT " + p.getName());
      } else if (featureID == DocModel.DocModelPackage.PART__PREV_PART) {
        Part p = (Part) n.getNewValue();
        System.out.println("New Part was added to the Part as its PREVIOUS " + p.getName());

      }

    }


    // override the notifyChanged method
    @Override
    public void notifyChanged(Notification n) {

      // the superclass handles adding/removing this Adapter to new Books
      super.notifyChanged(n);

      // find out the type of the notifier which could be 'Document', 'Paragraph',
      // 'Part' or 'Node'
      Object notifier = n.getNotifier();
      if (notifier instanceof Document) {
        this.handleDocumentNotification(n);
      } else if (notifier instanceof Paragraph) {
        this.handleParagraphNotification(n);
      } else if (notifier instanceof Node) {
        this.handleNodeNotification(n);
      } else if (notifier instanceof Part) {
        this.handlePartNotification(n);
      }
    }


  };

  /**
   * Adapter used to update the problem indication when resources are demanded loaded. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected EContentAdapter problemIndicationAdapter = new EContentAdapter() {
    @Override
    public void notifyChanged(Notification notification) {

      // System.out.println("problemIndicationAdapter");

      if (notification.getNotifier() instanceof Resource) {
        switch (notification.getFeatureID(Resource.class)) {
          case Resource.RESOURCE__IS_LOADED:
          case Resource.RESOURCE__ERRORS:
          case Resource.RESOURCE__WARNINGS: {
            Resource resource = (Resource) notification.getNotifier();
            Diagnostic diagnostic = DocModelEditor.this.analyzeResourceProblems(resource, null);
            if (diagnostic.getSeverity() != Diagnostic.OK) {
              DocModelEditor.this.resourceToDiagnosticMap.put(resource, diagnostic);
            } else {
              DocModelEditor.this.resourceToDiagnosticMap.remove(resource);
            }

            if (DocModelEditor.this.updateProblemIndication) {
              DocModelEditor.this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
                @Override
                public void run() {
                  DocModelEditor.this.updateProblemIndication();
                }
              });
            }
            break;
          }
        }
      } else {
        super.notifyChanged(notification);
      }
    }

    @Override
    protected void setTarget(Resource target) {
      this.basicSetTarget(target);
    }

    @Override
    protected void unsetTarget(Resource target) {
      this.basicUnsetTarget(target);
      DocModelEditor.this.resourceToDiagnosticMap.remove(target);
      if (DocModelEditor.this.updateProblemIndication) {
        DocModelEditor.this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            DocModelEditor.this.updateProblemIndication();
          }
        });
      }
    }
  };

  /**
   * This listens for workspace changes. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
    @Override
    public void resourceChanged(IResourceChangeEvent event) {
      IResourceDelta delta = event.getDelta();
      try {
        class ResourceDeltaVisitor implements IResourceDeltaVisitor {
          protected ResourceSet resourceSet = DocModelEditor.this.editingDomain.getResourceSet();
          protected Collection<Resource> changedResources = new ArrayList<Resource>();
          protected Collection<Resource> removedResources = new ArrayList<Resource>();

          public Collection<Resource> getChangedResources() {
            return this.changedResources;
          }

          public Collection<Resource> getRemovedResources() {
            return this.removedResources;
          }

          @Override
          public boolean visit(IResourceDelta delta) {
            if (delta.getResource().getType() == IResource.FILE) {
              if (delta.getKind() == IResourceDelta.REMOVED
                  || delta.getKind() == IResourceDelta.CHANGED
                      && delta.getFlags() != IResourceDelta.MARKERS) {
                Resource resource = this.resourceSet.getResource(
                    URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
                if (resource != null) {
                  if (delta.getKind() == IResourceDelta.REMOVED) {
                    this.removedResources.add(resource);
                  } else if (!DocModelEditor.this.savedResources.remove(resource)) {
                    this.changedResources.add(resource);
                  }
                }
              }
              return false;
            }

            return true;
          }
        }

        final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
        delta.accept(visitor);

        if (!visitor.getRemovedResources().isEmpty()) {
          DocModelEditor.this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
              DocModelEditor.this.removedResources.addAll(visitor.getRemovedResources());
              if (!DocModelEditor.this.isDirty()) {
                DocModelEditor.this.getSite().getPage().closeEditor(DocModelEditor.this, false);
              }
            }
          });
        }

        if (!visitor.getChangedResources().isEmpty()) {
          DocModelEditor.this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
              DocModelEditor.this.changedResources.addAll(visitor.getChangedResources());
              if (DocModelEditor.this.getSite().getPage()
                  .getActiveEditor() == DocModelEditor.this) {
                DocModelEditor.this.handleActivate();
              }
            }
          });
        }
      } catch (CoreException exception) {
        DocumentModelEditorPlugin.INSTANCE.log(exception);
      }
    }
  };

  /**
   * This creates a model editor. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public DocModelEditor() {
    super();
    this.initializeEditingDomain();
  }

  /**
   * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void addSelectionChangedListener(ISelectionChangedListener listener) {
    this.selectionChangedListeners.add(listener);
  }

  /**
   * Returns a diagnostic describing the errors and warnings listed in the resource and the
   * specified exception (if any). <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) {
    if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty()) {
      BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR,
          "eu.modelwriter.architecture.textconnectors.docx.genparser.editor", 0,
          DocModelEditor.getString("_UI_CreateModelError_message", resource.getURI()),
          new Object[] {exception == null ? (Object) resource : exception});
      basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
      return basicDiagnostic;
    } else if (exception != null) {
      return new BasicDiagnostic(Diagnostic.ERROR,
          "eu.modelwriter.architecture.textconnectors.docx.genparser.editor", 0,
          DocModelEditor.getString("_UI_CreateModelError_message", resource.getURI()),
          new Object[] {exception});
    } else {
      return Diagnostic.OK_INSTANCE;
    }
  }

  /**
   * This creates a context menu for the viewer and adds a listener as well registering the menu for
   * extension. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void createContextMenuFor(StructuredViewer viewer) {
    MenuManager contextMenu = new MenuManager("#PopUp");
    contextMenu.add(new Separator("additions"));
    contextMenu.setRemoveAllWhenShown(true);
    contextMenu.addMenuListener(this);
    Menu menu = contextMenu.createContextMenu(viewer.getControl());
    viewer.getControl().setMenu(menu);
    this.getSite().registerContextMenu(contextMenu, new UnwrappingSelectionProvider(viewer));

    int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
    Transfer[] transfers = new Transfer[] {LocalTransfer.getInstance(),
        LocalSelectionTransfer.getTransfer(), FileTransfer.getInstance()};
    viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(viewer));
    viewer.addDropSupport(dndOperations, transfers,
        new EditingDomainViewerDropAdapter(this.editingDomain, viewer));
  }

  /**
   * This is the method called to load a resource into the editing domain's resource set based on
   * the editor's input. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void createModel() {
    URI resourceURI = EditUIUtil.getURI(this.getEditorInput());
    Exception exception = null;
    Resource resource = null;
    try {
      // Load the resource through the editing domain.
      //
      resource = this.editingDomain.getResourceSet().getResource(resourceURI, true);
    } catch (Exception e) {
      exception = e;
      resource = this.editingDomain.getResourceSet().getResource(resourceURI, false);
    }

    Diagnostic diagnostic = this.analyzeResourceProblems(resource, exception);
    if (diagnostic.getSeverity() != Diagnostic.OK) {
      this.resourceToDiagnosticMap.put(resource, this.analyzeResourceProblems(resource, exception));
    }

    this.editingDomain.getResourceSet().eAdapters().add(this.problemIndicationAdapter);
    this.editingDomain.getResourceSet().eAdapters().add(this.changeOnModelNotifier);
  }

  /**
   * This is the method used by the framework to install your own controls. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void createPages() {
    // Creates the model from the editor input
    //
    this.createModel();

    // Only creates the other pages if there is something that can be edited
    //
    if (!this.getEditingDomain().getResourceSet().getResources().isEmpty()) {
      // Create a page for the selection tree view.
      //
      {
        ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), DocModelEditor.this) {
          @Override
          public Viewer createViewer(Composite composite) {
            Tree tree = new Tree(composite, SWT.MULTI);
            TreeViewer newTreeViewer = new TreeViewer(tree);
            return newTreeViewer;
          }

          @Override
          public void requestActivation() {
            super.requestActivation();
            DocModelEditor.this.setCurrentViewerPane(this);
          }
        };
        viewerPane.createControl(this.getContainer());

        this.selectionViewer = (TreeViewer) viewerPane.getViewer();
        this.selectionViewer
            .setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));

        this.selectionViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));
        this.selectionViewer.setInput(this.editingDomain.getResourceSet());
        this.selectionViewer.setSelection(
            new StructuredSelection(this.editingDomain.getResourceSet().getResources().get(0)),
            true);
        viewerPane.setTitle(this.editingDomain.getResourceSet());

        new AdapterFactoryTreeEditor(this.selectionViewer.getTree(), this.adapterFactory);

        this.createContextMenuFor(this.selectionViewer);
        int pageIndex = this.addPage(viewerPane.getControl());
        this.setPageText(pageIndex, DocModelEditor.getString("_UI_SelectionPage_label"));
      }

      // Create a page for the parent tree view.
      //
      {
        ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), DocModelEditor.this) {
          @Override
          public Viewer createViewer(Composite composite) {
            Tree tree = new Tree(composite, SWT.MULTI);
            TreeViewer newTreeViewer = new TreeViewer(tree);
            return newTreeViewer;
          }

          @Override
          public void requestActivation() {
            super.requestActivation();
            DocModelEditor.this.setCurrentViewerPane(this);
          }
        };
        viewerPane.createControl(this.getContainer());

        this.parentViewer = (TreeViewer) viewerPane.getViewer();
        this.parentViewer.setAutoExpandLevel(30);
        this.parentViewer
            .setContentProvider(new ReverseAdapterFactoryContentProvider(this.adapterFactory));
        this.parentViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

        this.createContextMenuFor(this.parentViewer);
        int pageIndex = this.addPage(viewerPane.getControl());
        this.setPageText(pageIndex, DocModelEditor.getString("_UI_ParentPage_label"));
      }

      // This is the page for the list viewer
      //
      {
        ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), DocModelEditor.this) {
          @Override
          public Viewer createViewer(Composite composite) {
            return new ListViewer(composite);
          }

          @Override
          public void requestActivation() {
            super.requestActivation();
            DocModelEditor.this.setCurrentViewerPane(this);
          }
        };
        viewerPane.createControl(this.getContainer());
        this.listViewer = (ListViewer) viewerPane.getViewer();
        this.listViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
        this.listViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

        this.createContextMenuFor(this.listViewer);
        int pageIndex = this.addPage(viewerPane.getControl());
        this.setPageText(pageIndex, DocModelEditor.getString("_UI_ListPage_label"));
      }

      // This is the page for the tree viewer
      //
      {
        ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), DocModelEditor.this) {
          @Override
          public Viewer createViewer(Composite composite) {
            return new TreeViewer(composite);
          }

          @Override
          public void requestActivation() {
            super.requestActivation();
            DocModelEditor.this.setCurrentViewerPane(this);
          }
        };
        viewerPane.createControl(this.getContainer());
        this.treeViewer = (TreeViewer) viewerPane.getViewer();
        this.treeViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
        this.treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

        new AdapterFactoryTreeEditor(this.treeViewer.getTree(), this.adapterFactory);

        this.createContextMenuFor(this.treeViewer);
        int pageIndex = this.addPage(viewerPane.getControl());
        this.setPageText(pageIndex, DocModelEditor.getString("_UI_TreePage_label"));
      }

      // This is the page for the table viewer.
      //
      {
        ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), DocModelEditor.this) {
          @Override
          public Viewer createViewer(Composite composite) {
            return new TableViewer(composite);
          }

          @Override
          public void requestActivation() {
            super.requestActivation();
            DocModelEditor.this.setCurrentViewerPane(this);
          }
        };
        viewerPane.createControl(this.getContainer());
        this.tableViewer = (TableViewer) viewerPane.getViewer();

        Table table = this.tableViewer.getTable();
        TableLayout layout = new TableLayout();
        table.setLayout(layout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn objectColumn = new TableColumn(table, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, 100, true));
        objectColumn.setText(DocModelEditor.getString("_UI_ObjectColumn_label"));
        objectColumn.setResizable(true);

        TableColumn selfColumn = new TableColumn(table, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(2, 100, true));
        selfColumn.setText(DocModelEditor.getString("_UI_SelfColumn_label"));
        selfColumn.setResizable(true);

        this.tableViewer.setColumnProperties(new String[] {"a", "b"});
        this.tableViewer.setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
        this.tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

        this.createContextMenuFor(this.tableViewer);
        int pageIndex = this.addPage(viewerPane.getControl());
        this.setPageText(pageIndex, DocModelEditor.getString("_UI_TablePage_label"));
      }

      // This is the page for the table tree viewer.
      //
      {
        ViewerPane viewerPane = new ViewerPane(this.getSite().getPage(), DocModelEditor.this) {
          @Override
          public Viewer createViewer(Composite composite) {
            return new TreeViewer(composite);
          }

          @Override
          public void requestActivation() {
            super.requestActivation();
            DocModelEditor.this.setCurrentViewerPane(this);
          }
        };
        viewerPane.createControl(this.getContainer());

        this.treeViewerWithColumns = (TreeViewer) viewerPane.getViewer();

        Tree tree = this.treeViewerWithColumns.getTree();
        tree.setLayoutData(new FillLayout());
        tree.setHeaderVisible(true);
        tree.setLinesVisible(true);

        TreeColumn objectColumn = new TreeColumn(tree, SWT.NONE);
        objectColumn.setText(DocModelEditor.getString("_UI_ObjectColumn_label"));
        objectColumn.setResizable(true);
        objectColumn.setWidth(250);

        TreeColumn selfColumn = new TreeColumn(tree, SWT.NONE);
        selfColumn.setText(DocModelEditor.getString("_UI_SelfColumn_label"));
        selfColumn.setResizable(true);
        selfColumn.setWidth(200);

        this.treeViewerWithColumns.setColumnProperties(new String[] {"a", "b"});
        this.treeViewerWithColumns
            .setContentProvider(new AdapterFactoryContentProvider(this.adapterFactory));
        this.treeViewerWithColumns
            .setLabelProvider(new AdapterFactoryLabelProvider(this.adapterFactory));

        this.createContextMenuFor(this.treeViewerWithColumns);
        int pageIndex = this.addPage(viewerPane.getControl());
        this.setPageText(pageIndex, DocModelEditor.getString("_UI_TreeWithColumnsPage_label"));
      }

      this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
        @Override
        public void run() {
          DocModelEditor.this.setActivePage(0);
        }
      });
    }

    // Ensures that this editor will only display the page's tab
    // area if there are more than one page
    //
    this.getContainer().addControlListener(new ControlAdapter() {
      boolean guard = false;

      @Override
      public void controlResized(ControlEvent event) {
        if (!this.guard) {
          this.guard = true;
          DocModelEditor.this.hideTabs();
          this.guard = false;
        }
      }
    });

    this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        DocModelEditor.this.updateProblemIndication();
      }
    });
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void dispose() {
    this.updateProblemIndication = false;

    ResourcesPlugin.getWorkspace().removeResourceChangeListener(this.resourceChangeListener);

    this.getSite().getPage().removePartListener(this.partListener);

    this.adapterFactory.dispose();

    if (this.getActionBarContributor().getActiveEditor() == this) {
      this.getActionBarContributor().setActiveEditor(null);
    }

    for (PropertySheetPage propertySheetPage : this.propertySheetPages) {
      propertySheetPage.dispose();
    }

    if (this.contentOutlinePage != null) {
      this.contentOutlinePage.dispose();
    }

    super.dispose();
  }

  /**
   * This is for implementing {@link IEditorPart} and simply saves the model file. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void doSave(IProgressMonitor progressMonitor) {
    // Save only resources that have actually changed.
    //
    final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
    saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED,
        Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
    saveOptions.put(Resource.OPTION_LINE_DELIMITER, Resource.OPTION_LINE_DELIMITER_UNSPECIFIED);

    // Do the work within an operation because this is a long running activity that modifies the
    // workbench.
    //
    WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
      // This is the method that gets invoked when the operation runs.
      //
      @Override
      public void execute(IProgressMonitor monitor) {
        // Save the resources to the file system.
        //
        boolean first = true;
        for (Resource resource : DocModelEditor.this.editingDomain.getResourceSet()
            .getResources()) {
          if ((first || !resource.getContents().isEmpty()
              || DocModelEditor.this.isPersisted(resource))
              && !DocModelEditor.this.editingDomain.isReadOnly(resource)) {
            try {
              long timeStamp = resource.getTimeStamp();
              resource.save(saveOptions);
              if (resource.getTimeStamp() != timeStamp) {
                DocModelEditor.this.savedResources.add(resource);
              }
            } catch (Exception exception) {
              DocModelEditor.this.resourceToDiagnosticMap.put(resource,
                  DocModelEditor.this.analyzeResourceProblems(resource, exception));
            }
            first = false;
          }
        }
      }
    };

    this.updateProblemIndication = false;
    try {
      // This runs the options, and shows progress.
      //
      new ProgressMonitorDialog(this.getSite().getShell()).run(true, false, operation);

      // Refresh the necessary state.
      //
      ((BasicCommandStack) this.editingDomain.getCommandStack()).saveIsDone();
      this.firePropertyChange(IEditorPart.PROP_DIRTY);
    } catch (Exception exception) {
      // Something went wrong that shouldn't.
      //
      DocumentModelEditorPlugin.INSTANCE.log(exception);
    }
    this.updateProblemIndication = true;
    this.updateProblemIndication();
  }

  /**
   * This also changes the editor's input. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void doSaveAs() {
    SaveAsDialog saveAsDialog = new SaveAsDialog(this.getSite().getShell());
    saveAsDialog.open();
    IPath path = saveAsDialog.getResult();
    if (path != null) {
      IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
      if (file != null) {
        this.doSaveAs(URI.createPlatformResourceURI(file.getFullPath().toString(), true),
            new FileEditorInput(file));
      }
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void doSaveAs(URI uri, IEditorInput editorInput) {
    this.editingDomain.getResourceSet().getResources().get(0).setURI(uri);
    this.setInputWithNotify(editorInput);
    this.setPartName(editorInput.getName());
    IProgressMonitor progressMonitor = this.getActionBars().getStatusLineManager() != null
        ? this.getActionBars().getStatusLineManager().getProgressMonitor()
        : new NullProgressMonitor();
    this.doSave(progressMonitor);
  }

  /**
   * This is here for the listener to be able to call it. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  @Override
  protected void firePropertyChange(int action) {
    super.firePropertyChange(action);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EditingDomainActionBarContributor getActionBarContributor() {
    return (EditingDomainActionBarContributor) this.getEditorSite().getActionBarContributor();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public IActionBars getActionBars() {
    return this.getActionBarContributor().getActionBars();
  }

  /**
   * This is how the framework determines which interfaces we implement. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("rawtypes")
  @Override
  public Object getAdapter(Class key) {
    if (key.equals(IContentOutlinePage.class)) {
      return this.showOutlineView() ? this.getContentOutlinePage() : null;
    } else if (key.equals(IPropertySheetPage.class)) {
      return this.getPropertySheetPage();
    } else if (key.equals(IGotoMarker.class)) {
      return this;
    } else {
      return super.getAdapter(key);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public AdapterFactory getAdapterFactory() {
    return this.adapterFactory;
  }

  /**
   * This accesses a cached version of the content outliner. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public IContentOutlinePage getContentOutlinePage() {
    if (this.contentOutlinePage == null) {
      // The content outline is just a tree.
      //
      class MyContentOutlinePage extends ContentOutlinePage {
        @Override
        public void createControl(Composite parent) {
          super.createControl(parent);
          DocModelEditor.this.contentOutlineViewer = this.getTreeViewer();
          DocModelEditor.this.contentOutlineViewer.addSelectionChangedListener(this);

          // Set up the tree viewer.
          //
          DocModelEditor.this.contentOutlineViewer.setContentProvider(
              new AdapterFactoryContentProvider(DocModelEditor.this.adapterFactory));
          DocModelEditor.this.contentOutlineViewer.setLabelProvider(
              new AdapterFactoryLabelProvider(DocModelEditor.this.adapterFactory));
          DocModelEditor.this.contentOutlineViewer
              .setInput(DocModelEditor.this.editingDomain.getResourceSet());

          // Make sure our popups work.
          //
          DocModelEditor.this.createContextMenuFor(DocModelEditor.this.contentOutlineViewer);

          if (!DocModelEditor.this.editingDomain.getResourceSet().getResources().isEmpty()) {
            // Select the root object in the view.
            //
            DocModelEditor.this.contentOutlineViewer.setSelection(
                new StructuredSelection(
                    DocModelEditor.this.editingDomain.getResourceSet().getResources().get(0)),
                true);
          }
        }

        @Override
        public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager,
            IStatusLineManager statusLineManager) {
          super.makeContributions(menuManager, toolBarManager, statusLineManager);
          DocModelEditor.this.contentOutlineStatusLineManager = statusLineManager;
        }

        @Override
        public void setActionBars(IActionBars actionBars) {
          super.setActionBars(actionBars);
          DocModelEditor.this.getActionBarContributor().shareGlobalActions(this, actionBars);
        }
      }

      this.contentOutlinePage = new MyContentOutlinePage();

      // Listen to selection so that we can handle it is a special way.
      //
      this.contentOutlinePage.addSelectionChangedListener(new ISelectionChangedListener() {
        // This ensures that we handle selections correctly.
        //
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
          DocModelEditor.this.handleContentOutlineSelection(event.getSelection());
        }
      });
    }

    return this.contentOutlinePage;
  }

  /**
   * This returns the editing domain as required by the {@link IEditingDomainProvider} interface.
   * This is important for implementing the static methods of {@link AdapterFactoryEditingDomain}
   * and for supporting {@link org.eclipse.emf.edit.ui.action.CommandAction}. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EditingDomain getEditingDomain() {
    return this.editingDomain;
  }

  /**
   * This accesses a cached version of the property sheet. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  public IPropertySheetPage getPropertySheetPage() {
    PropertySheetPage propertySheetPage = new ExtendedPropertySheetPage(this.editingDomain) {
      @Override
      public void setActionBars(IActionBars actionBars) {
        super.setActionBars(actionBars);
        DocModelEditor.this.getActionBarContributor().shareGlobalActions(this, actionBars);
      }

      @Override
      public void setSelectionToViewer(List<?> selection) {
        DocModelEditor.this.setSelectionToViewer(selection);
        DocModelEditor.this.setFocus();
      }
    };
    propertySheetPage
        .setPropertySourceProvider(new AdapterFactoryContentProvider(this.adapterFactory));
    this.propertySheetPages.add(propertySheetPage);

    return propertySheetPage;
  }

  /**
   * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to return this editor's
   * overall selection. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ISelection getSelection() {
    return this.editorSelection;
  }

  /**
   * This returns the viewer as required by the {@link IViewerProvider} interface. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Viewer getViewer() {
    return this.currentViewer;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void gotoMarker(IMarker marker) {
    List<?> targetObjects = this.markerHelper.getTargetObjects(this.editingDomain, marker);
    if (!targetObjects.isEmpty()) {
      this.setSelectionToViewer(targetObjects);
    }
  }

  /**
   * Handles activation of the editor or it's associated views. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected void handleActivate() {
    // Recompute the read only state.
    //
    if (this.editingDomain.getResourceToReadOnlyMap() != null) {
      this.editingDomain.getResourceToReadOnlyMap().clear();

      // Refresh any actions that may become enabled or disabled.
      //
      this.setSelection(this.getSelection());
    }

    if (!this.removedResources.isEmpty()) {
      if (this.handleDirtyConflict()) {
        this.getSite().getPage().closeEditor(DocModelEditor.this, false);
      } else {
        this.removedResources.clear();
        this.changedResources.clear();
        this.savedResources.clear();
      }
    } else if (!this.changedResources.isEmpty()) {
      this.changedResources.removeAll(this.savedResources);
      this.handleChangedResources();
      this.changedResources.clear();
      this.savedResources.clear();
    }
  }

  /**
   * Handles what to do with changed resources on activation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected void handleChangedResources() {

    System.out.println("handleChangedResources");
    if (!this.changedResources.isEmpty() && (!this.isDirty() || this.handleDirtyConflict())) {
      if (this.isDirty()) {
        this.changedResources.addAll(this.editingDomain.getResourceSet().getResources());
      }
      this.editingDomain.getCommandStack().flush();

      this.updateProblemIndication = false;
      for (Resource resource : this.changedResources) {
        if (resource.isLoaded()) {
          resource.unload();
          try {
            resource.load(Collections.EMPTY_MAP);
          } catch (IOException exception) {
            if (!this.resourceToDiagnosticMap.containsKey(resource)) {
              this.resourceToDiagnosticMap.put(resource,
                  this.analyzeResourceProblems(resource, exception));
            }
          }
        }
      }

      if (AdapterFactoryEditingDomain.isStale(this.editorSelection)) {
        this.setSelection(StructuredSelection.EMPTY);
      }

      this.updateProblemIndication = true;
      this.updateProblemIndication();
    }
  }

  /**
   * This deals with how we want selection in the outliner to affect the other views. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void handleContentOutlineSelection(ISelection selection) {
    if (this.currentViewerPane != null && !selection.isEmpty()
        && selection instanceof IStructuredSelection) {
      Iterator<?> selectedElements = ((IStructuredSelection) selection).iterator();
      if (selectedElements.hasNext()) {
        // Get the first selected element.
        //
        Object selectedElement = selectedElements.next();

        // If it's the selection viewer, then we want it to select the same selection as this
        // selection.
        //
        if (this.currentViewerPane.getViewer() == this.selectionViewer) {
          ArrayList<Object> selectionList = new ArrayList<Object>();
          selectionList.add(selectedElement);
          while (selectedElements.hasNext()) {
            selectionList.add(selectedElements.next());
          }

          // Set the selection to the widget.
          //
          this.selectionViewer.setSelection(new StructuredSelection(selectionList));
        } else {
          // Set the input to the widget.
          //
          if (this.currentViewerPane.getViewer().getInput() != selectedElement) {
            this.currentViewerPane.getViewer().setInput(selectedElement);
            this.currentViewerPane.setTitle(selectedElement);
          }
        }
      }
    }
  }

  /**
   * Shows a dialog that asks if conflicting changes should be discarded. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  protected boolean handleDirtyConflict() {
    return MessageDialog.openQuestion(this.getSite().getShell(),
        DocModelEditor.getString("_UI_FileConflict_label"),
        DocModelEditor.getString("_WARN_FileConflict"));
  }

  /**
   * If there is just one page in the multi-page editor part, this hides the single tab at the
   * bottom. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void hideTabs() {
    if (this.getPageCount() <= 1) {
      this.setPageText(0, "");
      if (this.getContainer() instanceof CTabFolder) {
        ((CTabFolder) this.getContainer()).setTabHeight(1);
        Point point = this.getContainer().getSize();
        this.getContainer().setSize(point.x, point.y + 6);
      }
    }
  }

  /**
   * This is called during startup. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void init(IEditorSite site, IEditorInput editorInput) {
    this.setSite(site);
    this.setInputWithNotify(editorInput);
    this.setPartName(editorInput.getName());
    site.setSelectionProvider(this);
    site.getPage().addPartListener(this.partListener);
    ResourcesPlugin.getWorkspace().addResourceChangeListener(this.resourceChangeListener,
        IResourceChangeEvent.POST_CHANGE);
  }

  /**
   * This sets up the editing domain for the model editor. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   */
  protected void initializeEditingDomain() {
    // Create an adapter factory that yields item providers.
    //
    this.adapterFactory =
        new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

    this.adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
    this.adapterFactory.addAdapterFactory(new DocModelItemProviderAdapterFactory());
    this.adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

    // Create the command stack that will notify this editor as commands are executed.
    //
    BasicCommandStack commandStack = new BasicCommandStack();

    // Add a listener to set the most recent command's affected objects to be the selection of the
    // viewer with focus.
    //
    commandStack.addCommandStackListener(new CommandStackListener() {
      @Override
      public void commandStackChanged(final EventObject event) {
        DocModelEditor.this.getContainer().getDisplay().asyncExec(new Runnable() {
          @Override
          public void run() {
            DocModelEditor.this.firePropertyChange(IEditorPart.PROP_DIRTY);

            // Try to select the affected objects.
            //
            Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
            if (mostRecentCommand != null) {
              DocModelEditor.this.setSelectionToViewer(mostRecentCommand.getAffectedObjects());
            }
            for (Iterator<PropertySheetPage> i =
                DocModelEditor.this.propertySheetPages.iterator(); i.hasNext();) {
              PropertySheetPage propertySheetPage = i.next();
              if (propertySheetPage.getControl().isDisposed()) {
                i.remove();
              } else {
                propertySheetPage.refresh();
              }
            }
          }
        });
      }
    });

    // Create the editing domain with a special command stack.
    //
    this.editingDomain = new AdapterFactoryEditingDomain(this.adapterFactory, commandStack,
        new HashMap<Resource, Boolean>());
  }

  /**
   * This is for implementing {@link IEditorPart} and simply tests the command stack. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isDirty() {
    return ((BasicCommandStack) this.editingDomain.getCommandStack()).isSaveNeeded();
  }

  /**
   * This returns whether something has been persisted to the URI of the specified resource. The
   * implementation uses the URI converter from the editor's resource set to try to open an input
   * stream. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected boolean isPersisted(Resource resource) {
    boolean result = false;
    try {
      InputStream stream = this.editingDomain.getResourceSet().getURIConverter()
          .createInputStream(resource.getURI());
      if (stream != null) {
        result = true;
        stream.close();
      }
    } catch (IOException e) {
      // Ignore
    }
    return result;
  }

  /**
   * This always returns true because it is not currently supported. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean isSaveAsAllowed() {
    return true;
  }

  /**
   * This implements {@link org.eclipse.jface.action.IMenuListener} to help fill the context menus
   * with contributions from the Edit menu. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    ((IMenuListener) this.getEditorSite().getActionBarContributor()).menuAboutToShow(menuManager);
  }

  /**
   * This is used to track the active viewer. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected void pageChange(int pageIndex) {
    super.pageChange(pageIndex);

    if (this.contentOutlinePage != null) {
      this.handleContentOutlineSelection(this.contentOutlinePage.getSelection());
    }
  }

  /**
   * This implements {@link org.eclipse.jface.viewers.ISelectionProvider}. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void removeSelectionChangedListener(ISelectionChangedListener listener) {
    this.selectionChangedListeners.remove(listener);
  }

  /**
   * This makes sure that one content viewer, either for the current page or the outline view, if it
   * has focus, is the current one. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void setCurrentViewer(Viewer viewer) {
    // If it is changing...
    //
    if (this.currentViewer != viewer) {
      if (this.selectionChangedListener == null) {
        // Create the listener on demand.
        //
        this.selectionChangedListener = new ISelectionChangedListener() {
          // This just notifies those things that are affected by the section.
          //
          @Override
          public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
            DocModelEditor.this.setSelection(selectionChangedEvent.getSelection());
          }
        };
      }

      // Stop listening to the old one.
      //
      if (this.currentViewer != null) {
        this.currentViewer.removeSelectionChangedListener(this.selectionChangedListener);
      }

      // Start listening to the new one.
      //
      if (viewer != null) {
        viewer.addSelectionChangedListener(this.selectionChangedListener);
      }

      // Remember it.
      //
      this.currentViewer = viewer;

      // Set the editors selection based on the current viewer's selection.
      //
      this.setSelection(this.currentViewer == null ? StructuredSelection.EMPTY
          : this.currentViewer.getSelection());
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void setCurrentViewerPane(ViewerPane viewerPane) {
    if (this.currentViewerPane != viewerPane) {
      if (this.currentViewerPane != null) {
        this.currentViewerPane.showFocus(false);
      }
      this.currentViewerPane = viewerPane;
    }
    this.setCurrentViewer(this.currentViewerPane.getViewer());
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setFocus() {
    if (this.currentViewerPane != null) {
      this.currentViewerPane.setFocus();
    } else {
      this.getControl(this.getActivePage()).setFocus();
    }
  }

  /**
   * This implements {@link org.eclipse.jface.viewers.ISelectionProvider} to set this editor's
   * overall selection. Calling this result will notify the listeners. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  @Override
  public void setSelection(ISelection selection) {
    this.editorSelection = selection;

    for (ISelectionChangedListener listener : this.selectionChangedListeners) {
      listener.selectionChanged(new SelectionChangedEvent(this, selection));
    }
    this.setStatusLineManager(selection);
  }

  /**
   * This sets the selection into whichever viewer is active. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public void setSelectionToViewer(Collection<?> collection) {
    final Collection<?> theSelection = collection;
    // Make sure it's okay.
    //
    if (theSelection != null && !theSelection.isEmpty()) {
      Runnable runnable = new Runnable() {
        @Override
        public void run() {
          // Try to select the items in the current content viewer of the editor.
          //
          if (DocModelEditor.this.currentViewer != null) {
            DocModelEditor.this.currentViewer
                .setSelection(new StructuredSelection(theSelection.toArray()), true);
          }
        }
      };
      this.getSite().getShell().getDisplay().asyncExec(runnable);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void setStatusLineManager(ISelection selection) {
    IStatusLineManager statusLineManager =
        this.currentViewer != null && this.currentViewer == this.contentOutlineViewer
            ? this.contentOutlineStatusLineManager : this.getActionBars().getStatusLineManager();

    if (statusLineManager != null) {
      if (selection instanceof IStructuredSelection) {
        Collection<?> collection = ((IStructuredSelection) selection).toList();
        switch (collection.size()) {
          case 0: {
            statusLineManager.setMessage(DocModelEditor.getString("_UI_NoObjectSelected"));
            break;
          }
          case 1: {
            String text = new AdapterFactoryItemDelegator(this.adapterFactory)
                .getText(collection.iterator().next());
            statusLineManager
                .setMessage(DocModelEditor.getString("_UI_SingleObjectSelected", text));
            break;
          }
          default: {
            statusLineManager.setMessage(DocModelEditor.getString("_UI_MultiObjectSelected",
                Integer.toString(collection.size())));
            break;
          }
        }
      } else {
        statusLineManager.setMessage("");
      }
    }
  }

  /**
   * Returns whether the outline view should be presented to the user. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  protected boolean showOutlineView() {
    return true;
  }

  /**
   * If there is more than one page in the multi-page editor part, this shows the tabs at the
   * bottom. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void showTabs() {
    if (this.getPageCount() > 1) {
      this.setPageText(0, DocModelEditor.getString("_UI_SelectionPage_label"));
      if (this.getContainer() instanceof CTabFolder) {
        ((CTabFolder) this.getContainer()).setTabHeight(SWT.DEFAULT);
        Point point = this.getContainer().getSize();
        this.getContainer().setSize(point.x, point.y - 6);
      }
    }
  }

  /**
   * Updates the problems indication with the information described in the specified diagnostic.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected void updateProblemIndication() {
    if (this.updateProblemIndication) {
      BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK,
          "eu.modelwriter.architecture.textconnectors.docx.genparser.editor", 0, null,
          new Object[] {this.editingDomain.getResourceSet()});
      for (Diagnostic childDiagnostic : this.resourceToDiagnosticMap.values()) {
        if (childDiagnostic.getSeverity() != Diagnostic.OK) {
          diagnostic.add(childDiagnostic);
        }
      }

      int lastEditorPage = this.getPageCount() - 1;
      if (lastEditorPage >= 0 && this.getEditor(lastEditorPage) instanceof ProblemEditorPart) {
        ((ProblemEditorPart) this.getEditor(lastEditorPage)).setDiagnostic(diagnostic);
        if (diagnostic.getSeverity() != Diagnostic.OK) {
          this.setActivePage(lastEditorPage);
        }
      } else if (diagnostic.getSeverity() != Diagnostic.OK) {
        ProblemEditorPart problemEditorPart = new ProblemEditorPart();
        problemEditorPart.setDiagnostic(diagnostic);
        problemEditorPart.setMarkerHelper(this.markerHelper);
        try {
          this.addPage(++lastEditorPage, problemEditorPart, this.getEditorInput());
          this.setPageText(lastEditorPage, problemEditorPart.getPartName());
          this.setActivePage(lastEditorPage);
          this.showTabs();
        } catch (PartInitException exception) {
          DocumentModelEditorPlugin.INSTANCE.log(exception);
        }
      }

      if (this.markerHelper.hasMarkers(this.editingDomain.getResourceSet())) {
        this.markerHelper.deleteMarkers(this.editingDomain.getResourceSet());
        if (diagnostic.getSeverity() != Diagnostic.OK) {
          try {
            this.markerHelper.createMarkers(diagnostic);
          } catch (CoreException exception) {
            DocumentModelEditorPlugin.INSTANCE.log(exception);
          }
        }
      }
    }
  }
}
