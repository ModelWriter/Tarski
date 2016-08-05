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
package eu.modelwriter.marker.ui.internal.views.contextualview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;

public class ContextualView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.contextualview";
  private static final String MARKERS_ID = "org.eclipse.ui.ide.MarkersView";
  private static TreeViewer treeViewer;

  public static TreeViewer getTreeViewer() {
    return ContextualView.treeViewer;
  }

  public static void refreshTree() {
    if (ContextualView.treeViewer == null) {
      return;
    }
    if (Activator.getActiveWorkbenchWindow() == null) {
      return;
    }
    if (Activator.getActiveWorkbenchWindow().getActivePage() == null) {
      return;
    }

    if (!ContextualView.treeViewer.getTree().isDisposed()) {
      if (Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor() == null) {
        ContextualView.treeViewer.setInput(new IMarker[0]);
        return;
      }

      final IFile file = Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
          .getEditorInput().getAdapter(IFile.class);
      ArrayList<IMarker> allMarkers;
      allMarkers = MarkerFactory.findMarkersAsArrayList(file);
      final Iterator<IMarker> iter = allMarkers.iterator();
      while (iter.hasNext()) {
        final Object marker = iter.next();
        if (MarkUtilities.getLeaderId((IMarker) marker) == null
            && MarkUtilities.getGroupId((IMarker) marker) != null) {
          iter.remove();
        }
      }
      ContextualView.treeViewer.setInput(allMarkers.toArray());
    }
  }

  private HashMap<String, IMarker> candidateToDel;

  private Tree tree;
  private ArrayList<IMarker> candidateToTypeChanging;
  private ArrayList<IMarker> checkIfHasSource;

  public ContextualView() {
    this.candidateToDel = new HashMap<>();
  }

  @Override
  public void createPartControl(final Composite parent) {

    ContextualView.treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI);
    this.tree = ContextualView.treeViewer.getTree();
    ContextualView.treeViewer.setContentProvider(new ContextualViewTreeContentProvider());

    final ContextualViewTreeLabelProvider baseLabelprovider = new ContextualViewTreeLabelProvider();
    final ILabelDecorator decorator =
        PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    ContextualView.treeViewer
        .setLabelProvider(new DecoratingLabelProvider(baseLabelprovider, decorator));
    this.getSite().setSelectionProvider(ContextualView.treeViewer);

    this.registerContextMenu();

    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

      @Override
      public void run() {
        ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
          @Override
          public void resourceChanged(final IResourceChangeEvent event) {
            if (event.findMarkerDeltas(MarkerFactory.MARKER_MARKING, true).length != 0) {
              if (!ContextualView.this.tree.isDisposed()) {
                ContextualView.refreshTree();
              }
            }
          }
        }, IResourceChangeEvent.POST_CHANGE);
      }
    });

    ContextualView.treeViewer.addDoubleClickListener(new IDoubleClickListener() {

      @Override
      public void doubleClick(final DoubleClickEvent event) {
        final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        final IMarker selected = (IMarker) selection.getFirstElement();
        try {
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), MarkerFactory
              .findMarkerBySourceId(selected.getResource(), MarkUtilities.getSourceId(selected)));
          // final IWorkbenchPage page =
          // PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
          // IViewPart viewPart = page.findView(TargetView.ID);
          // if (viewPart == null) {
          // viewPart = page.showView(TargetView.ID);
          // }
          // if (viewPart instanceof TargetView) {
          // if (MarkUtilities.getType(selected) != null) {
          // final Map<IMarker, String> targets =
          // AlloyUtilities.getRelationsOfFirstSideMarker(selected);
          // TargetView.setColumns(targets.keySet());
          // } else {
          // final ArrayList<IMarker> targets =
          // AlloyUtilities.getTargetsOfMarkerAtRelations(selected);
          // TargetView.setColumns(targets);
          // }
          // }
          // viewPart = page.findView(SourceView.ID);
          // if (viewPart == null) {
          // viewPart = page.showView(SourceView.ID);
          // }
          // if (viewPart instanceof SourceView) {
          // if (MarkUtilities.getType(selected) != null) {
          // final ArrayList<IMarker> sources = AlloyUtilities.getSumSources(selected);
          // SourceView.setColumns(sources);
          // } else {
          // final ArrayList<IMarker> sources =
          // AlloyUtilities.getSourcesOfMarkerAtRelations(selected);
          // SourceView.setColumns(sources);
          // }
          // }
        } catch (final PartInitException e) {
          e.printStackTrace();
        }
      }
    });

    this.tree.addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(final KeyEvent e) {
        if (e.keyCode == SWT.DEL) {
          final IStructuredSelection selection = ContextualView.treeViewer.getStructuredSelection();
          if (selection.isEmpty()) {
            return;
          } else {
            final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
            final TreeItem[] items = ContextualView.treeViewer.getTree().getSelection();
            final List<TreeItem> listItems = Arrays.asList(items);
            ContextualView.this.candidateToDel = new HashMap<>();
            ContextualView.this.candidateToTypeChanging = new ArrayList<>();
            ContextualView.this.checkIfHasSource = new ArrayList<>();
            for (final TreeItem treeItem : listItems) {
              final IMarker iMarker = (IMarker) treeItem.getData();
              if (MarkUtilities.getGroupId(iMarker) == null) {
                AnnotationFactory.removeAnnotation(iMarker);
                ContextualView.this.candidateToDel.put(MarkUtilities.getSourceId(iMarker), iMarker);
                ContextualView.this.checkIfHasSource.add(iMarker);
              } else if (MarkUtilities.getLeaderId(iMarker) != null) {
                ContextualView.this.checkIfHasSource.add(iMarker);
                final IFile file = ResourceUtil.getFile(editor.getEditorInput());
                final List<IMarker> listOfGroup =
                    MarkerFactory.findMarkersByGroupId(file, MarkUtilities.getGroupId(iMarker));
                for (final IMarker iMarker2 : listOfGroup) {
                  AnnotationFactory.removeAnnotation(iMarker2);
                  ContextualView.this.candidateToDel.put(MarkUtilities.getSourceId(iMarker2),
                      iMarker2);
                }
              } else {
                if (ContextualView.this.candidateToDel.containsValue(iMarker)) {
                  continue;
                }
                AnnotationFactory.removeAnnotation(iMarker);
                ContextualView.this.candidateToDel.put(MarkUtilities.getSourceId(iMarker), iMarker);
              }
            }
          }
          try {
            for (final IMarker iMarker : ContextualView.this.checkIfHasSource) {
              ContextualView.this.findCandidateToTypeChangingMarkers(iMarker);
            }
            for (final IMarker candidateMarker : ContextualView.this.candidateToTypeChanging) {
              if (!ContextualView.this.candidateToDel.containsValue(candidateMarker)) {
                AnnotationFactory.convertAnnotationType(candidateMarker, true, false,
                    AlloyUtilities.getTotalTargetCount(candidateMarker));
              }
            }
            for (final Map.Entry<String, IMarker> entry : ContextualView.this.candidateToDel
                .entrySet()) {
              ContextualView.this.deleteFromAlloyXML(entry.getValue());
              entry.getValue().delete();
            }
          } catch (final CoreException e2) {
            e2.printStackTrace();
          }
        }
      }

      @Override
      public void keyReleased(final KeyEvent e) {}
    });
  }

  private void deleteFromAlloyXML(final IMarker beDeleted) {
    if (AlloyUtilities.isExists()) {
      AlloyUtilities.removeMarkerFromRepository(beDeleted);
      if (MarkUtilities.getGroupId(beDeleted) == null
          || MarkUtilities.getLeaderId(beDeleted) != null) {
        AlloyUtilities.removeTypeFromMarker(beDeleted);
        AlloyUtilities.removeRelationOfMarker(beDeleted);
      }
    }
  }

  /**
   * @param selectedMarker from text
   */
  private void findCandidateToTypeChangingMarkers(final IMarker selectedMarker) {

    final Map<IMarker, String> fieldsSources =
        AlloyUtilities.getRelationsOfSecondSideMarker(selectedMarker);
    final ArrayList<IMarker> relationsSources =
        AlloyUtilities.getSourcesOfMarkerAtRelations(selectedMarker);

    for (final IMarker iMarker : fieldsSources.keySet()) {
      if (!this.candidateToTypeChanging.contains(iMarker)) {
        this.candidateToTypeChanging.add(iMarker);
      }
    }

    for (final IMarker iMarker : relationsSources) {
      if (!this.candidateToTypeChanging.contains(iMarker)) {
        this.candidateToTypeChanging.add(iMarker);
      }
    }
  }

  private void registerContextMenu() {
    final MenuManager contextMenu = new MenuManager();
    contextMenu.setRemoveAllWhenShown(true);
    this.getSite().registerContextMenu(contextMenu, ContextualView.treeViewer);
    // Add in the entries for all markers views if this has a different if
    if (!this.getSite().getId().equals(ContextualView.MARKERS_ID)) {
      this.getSite().registerContextMenu(ContextualView.MARKERS_ID, contextMenu, ContextualView.treeViewer);
    }
    final Control control = ContextualView.treeViewer.getControl();
    final Menu menu = contextMenu.createContextMenu(control);
    control.setMenu(menu);
  }

  @Override
  public void setFocus() {
    this.tree.setFocus();
  }
}
