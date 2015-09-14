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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;

public class MasterView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.markerview";
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

    // if (getSite().getSelectionProvider() == null) {
    // getSite().setSelectionProvider(treeViewer);
    // }

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
    // if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
    // .findView("org.eclipse.ui.views.PropertySheet") != null) {
    // getSite().setSelectionProvider(treeViewer);
    // }
    this.getSite().setSelectionProvider(MasterView.treeViewer);

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
        ArrayList<String> sourceIDs = new ArrayList<String>();
        if (e.keyCode == SWT.DEL) {
          IStructuredSelection selection = MasterView.treeViewer.getStructuredSelection();
          if (selection.isEmpty()) {
            return;
          } else {
            IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
            TreeItem[] items = MasterView.treeViewer.getTree().getSelection();
            MasterView.this.candidateToDelete = new ArrayList<IMarker>();
            for (TreeItem treeItem : items) {
              IMarker iMarker = (IMarker) treeItem.getData();
              try {
                sourceIDs.add((String) iMarker.getAttribute(IMarker.SOURCE_ID));
              } catch (CoreException e2) {
                e2.printStackTrace();
              }
              if (MarkUtilities.getLeaderId(iMarker) != null) {
                IFile file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .getActiveEditor().getEditorInput().getAdapter(IFile.class);

                List<IMarker> listOfGroup =
                    MarkerFactory.findMarkersByGroupId(file, MarkUtilities.getGroupId(iMarker));
                for (IMarker iMarker2 : listOfGroup) {
                  MasterView.this.candidateToDelete.add(iMarker2);
                  AnnotationFactory.removeAnnotation(iMarker2, editor);
                  AlloyUtilities.removeMarker(iMarker2);
                }
              } else {
                MasterView.this.candidateToDelete.add(iMarker);
                AnnotationFactory.removeAnnotation(iMarker, editor);
                AlloyUtilities.removeMarker(iMarker);
              }
            }
          }
          try {
            IMarker[] list = new IMarker[MasterView.this.candidateToDelete.size()];
            int i = 0;
            for (IMarker iMarker : MasterView.this.candidateToDelete) {
              if (!iMarker.exists()) {
                IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                    .getActivePage().getActiveEditor();
                iMarker =
                    MarkerFactory.findMarkerBySourceId(iMarker.getResource(), sourceIDs.get(i));
                AnnotationFactory.removeAnnotation(iMarker, editor);
              }
              MarkerUpdater.updateTargetsToDelete(iMarker);
              MarkerUpdater.updateSourcesToDelete(iMarker);
              list[i] = iMarker;
              i++;
            }
            ResourcesPlugin.getWorkspace().deleteMarkers(list);
          } catch (CoreException e1) {
            e1.printStackTrace();
          }
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {}
    });
  }

  @Override
  public void setFocus() {
    this.tree.setFocus();
  }
}
