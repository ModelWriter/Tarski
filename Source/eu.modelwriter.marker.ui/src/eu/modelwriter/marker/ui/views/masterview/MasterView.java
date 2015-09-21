/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.views.masterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.markers.internal.MarkerSupportRegistry;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class MasterView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.masterview";
  private static TreeViewer treeViewer;

  public static TreeViewer getTreeViewer() {
    return MasterView.treeViewer;
  }

  public static void refreshTree() {
    if (MasterView.treeViewer == null) {
      return;
    }
    if (Activator.getActiveWorkbenchWindow() == null) {
      return;
    }
    if (Activator.getActiveWorkbenchWindow().getActivePage() == null) {
      return;
    }

    if (Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor() == null) {
      MasterView.treeViewer.setInput(new IMarker[0]);
      return;
    }

    IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
        .getEditorInput().getAdapter(IFile.class);
    ArrayList<IMarker> allMarkers;
    allMarkers = MarkerFactory.findMarkersAsArrayList(file);
    Iterator<IMarker> iter = allMarkers.iterator();
    while (iter.hasNext()) {
      Object marker = iter.next();
      if ((MarkUtilities.getLeaderId((IMarker) marker) == null)
          && (MarkUtilities.getGroupId((IMarker) marker) != null)) {
        iter.remove();
      }
    }
    if (!MasterView.treeViewer.getTree().isDisposed()) {
      MasterView.treeViewer.setInput(allMarkers.toArray());
    }
  }

  private ArrayList<IMarker> candidateToDelete;

  private Tree tree;
  private ArrayList<IMarker> candidateToTypeChanging;

  public MasterView() {
    this.candidateToDelete = new ArrayList<IMarker>();
  }

  @Override
  public void createPartControl(Composite parent) {

    MasterView.treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI);
    this.tree = MasterView.treeViewer.getTree();
    MasterView.treeViewer.setContentProvider(new MasterViewTreeContentProvider());

    MasterViewTreeLabelProvider baseLabelprovider = new MasterViewTreeLabelProvider();
    ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    MasterView.treeViewer
        .setLabelProvider(new DecoratingLabelProvider(baseLabelprovider, decorator));
    this.getSite().setSelectionProvider(MasterView.treeViewer);

    registerContextMenu();

    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

      @Override
      public void run() {
        ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
          @Override
          public void resourceChanged(IResourceChangeEvent event) {
            if (event.findMarkerDeltas(MarkerFactory.MARKER_MARKING, true).length != 0) {
              if (!MasterView.this.tree.isDisposed()) {
                MasterView.refreshTree();
              }
            }
          }
        }, IResourceChangeEvent.POST_CHANGE);
      }
    });

    MasterView.treeViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        IMarker selected = (IMarker) selection.getFirstElement();
        try {
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), MarkerFactory
              .findMarkerBySourceId(selected.getResource(), (MarkUtilities.getSourceId(selected))));
          IViewPart viewPart =
              Activator.getActiveWorkbenchWindow().getActivePage().showView(TargetView.ID);
          if (viewPart instanceof TargetView) {
            if (MarkUtilities.getType(selected) != null) {
              Map<IMarker, String> targets = AlloyUtilities.getRelationsOfFirstSideMarker(selected);
              TargetView.setColumns(targets.keySet());
            } else {
              ArrayList<IMarker> targets = AlloyUtilities.getTargetsOfMarkerAtRelations(selected);
              TargetView.setColumns(targets);
            }
          }
          viewPart = Activator.getActiveWorkbenchWindow().getActivePage().showView(SourceView.ID);
          if (viewPart instanceof SourceView) {
            if (MarkUtilities.getType(selected) != null) {
              ArrayList<IMarker> sources = AlloyUtilities.getSumSources(selected);
              SourceView.setColumns(sources);
            } else {
              ArrayList<IMarker> sources = AlloyUtilities.getSourcesOfMarkerAtRelations(selected);
              SourceView.setColumns(sources);
            }
          }
        } catch (PartInitException e) {
          e.printStackTrace();
        }
      }
    });

    this.tree.addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.keyCode == SWT.DEL) {
          IStructuredSelection selection = MasterView.treeViewer.getStructuredSelection();
          if (selection.isEmpty()) {
            return;
          } else {
            IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
            TreeItem[] items = MasterView.treeViewer.getTree().getSelection();
            List<TreeItem> listItems = Arrays.asList(items);
            MasterView.this.candidateToDelete = new ArrayList<IMarker>();
            MasterView.this.candidateToTypeChanging = new ArrayList<IMarker>();
            for (TreeItem treeItem : listItems) {
              IMarker iMarker = (IMarker) treeItem.getData();
              if (MarkUtilities.getGroupId(iMarker) == null) {
                AnnotationFactory.removeAnnotation(iMarker, editor);
                MasterView.this.deleteFromAlloyXML(iMarker);
                MasterView.this.candidateToDelete.add(iMarker);
              } else if (MarkUtilities.getLeaderId(iMarker) != null) {
                IFile file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .getActiveEditor().getEditorInput().getAdapter(IFile.class);
                List<IMarker> listOfGroup =
                    MarkerFactory.findMarkersByGroupId(file, MarkUtilities.getGroupId(iMarker));
                for (IMarker iMarker2 : listOfGroup) {
                  if (listItems.contains(iMarker2)) {
                    continue;
                  }
                  AnnotationFactory.removeAnnotation(iMarker2, editor);
                  MasterView.this.deleteFromAlloyXML(iMarker2);
                  MasterView.this.candidateToDelete.add(iMarker2);
                }
              } else {
                AnnotationFactory.removeAnnotation(iMarker, editor);
                MasterView.this.deleteFromAlloyXML(iMarker);
                MasterView.this.candidateToDelete.add(iMarker);
              }
            }
          }
          try {
            for (IMarker iMarker : MasterView.this.candidateToDelete) {
              // findCandidateToTypeChangingMarkers(iMarker);
              // for (IMarker candidateMarker : MasterView.this.candidateToTypeChanging) {
              // MappingWizard.convertAnnotationType(candidateMarker, true);
              // }
              iMarker.delete();
            }
          } catch (CoreException e2) {
            e2.printStackTrace();
          }
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {}
    });
  }

  private void deleteFromAlloyXML(IMarker beDeleted) {
    if (AlloyUtilities.isExists()) {
      AlloyUtilities.removeMarkerFromRepository(beDeleted);
      if ((MarkUtilities.getGroupId(beDeleted) == null)
          || (MarkUtilities.getLeaderId(beDeleted) != null)) {
        AlloyUtilities.removeTypeFromMarker(beDeleted);
        AlloyUtilities.removeRelationOfMarker(beDeleted);
      }
    }
  }

  /**
   * @param selectedMarker from text
   */
  private void findCandidateToTypeChangingMarkers(IMarker selectedMarker) {
    if ((MarkUtilities.getGroupId(selectedMarker) == null)
        || (MarkUtilities.getLeaderId(selectedMarker) != null)) {
      this.candidateToTypeChanging.add(selectedMarker);

      Map<IMarker, String> fieldsSources =
          AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
      ArrayList<IMarker> relationsSources =
          AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

      for (IMarker iMarker : fieldsSources.keySet()) {
        this.candidateToTypeChanging.add(iMarker);
      }

      for (IMarker iMarker : relationsSources) {
        this.candidateToTypeChanging.add(iMarker);
      }
    }
  }

  @Override
  public void setFocus() {
    this.tree.setFocus();
  }

  private void registerContextMenu() {
    MenuManager contextMenu = new MenuManager();
    contextMenu.setRemoveAllWhenShown(true);
    getSite().registerContextMenu(contextMenu, MasterView.treeViewer);
    // Add in the entries for all markers views if this has a different if
    if (!getSite().getId().equals(MarkerSupportRegistry.MARKERS_ID)) {
      getSite().registerContextMenu(MarkerSupportRegistry.MARKERS_ID, contextMenu,
          MasterView.treeViewer);
    }
    Control control = MasterView.treeViewer.getControl();
    Menu menu = contextMenu.createContextMenu(control);
    control.setMenu(menu);
  }
}
