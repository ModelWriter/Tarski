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
package eu.modelwriter.marker.ui.internal.views.masterview;

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
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.markers.internal.MarkerSupportRegistry;

import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.Activator;
import eu.modelwriter.marker.ui.internal.views.mappingview.SourceView;
import eu.modelwriter.marker.ui.internal.views.mappingview.TargetView;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

@SuppressWarnings("restriction")
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

    if (!MasterView.treeViewer.getTree().isDisposed()) {
      if (Activator.getActiveWorkbenchWindow().getActivePage().getActiveEditor() == null) {
        MasterView.treeViewer.setInput(new IMarker[0]);
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
      MasterView.treeViewer.setInput(allMarkers.toArray());
    }
  }

  private HashMap<String, IMarker> candidateToDel;

  private Tree tree;
  private ArrayList<IMarker> candidateToTypeChanging;
  private ArrayList<IMarker> checkIfHasSource;

  public MasterView() {
    this.candidateToDel = new HashMap<>();
  }

  @Override
  public void createPartControl(final Composite parent) {

    MasterView.treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI);
    this.tree = MasterView.treeViewer.getTree();
    MasterView.treeViewer.setContentProvider(new MasterViewTreeContentProvider());

    final MasterViewTreeLabelProvider baseLabelprovider = new MasterViewTreeLabelProvider();
    final ILabelDecorator decorator =
        PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator();
    MasterView.treeViewer
        .setLabelProvider(new DecoratingLabelProvider(baseLabelprovider, decorator));
    this.getSite().setSelectionProvider(MasterView.treeViewer);

    this.registerContextMenu();

    PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

      @Override
      public void run() {
        ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {
          @Override
          public void resourceChanged(final IResourceChangeEvent event) {
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
      public void doubleClick(final DoubleClickEvent event) {
        final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        final IMarker selected = (IMarker) selection.getFirstElement();
        try {
          IDE.openEditor(Activator.getActiveWorkbenchWindow().getActivePage(), MarkerFactory
              .findMarkerBySourceId(selected.getResource(), MarkUtilities.getSourceId(selected)));
          final IWorkbenchPage page =
              PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
          IViewPart viewPart = page.findView(TargetView.ID);
          if (viewPart == null) {
            viewPart = page.showView(TargetView.ID);
          }
          if (viewPart instanceof TargetView) {
            if (MarkUtilities.getType(selected) != null) {
              final Map<IMarker, String> targets =
                  AlloyUtilities.getRelationsOfFirstSideMarker(selected);
              TargetView.setColumns(targets.keySet());
            } else {
              final ArrayList<IMarker> targets =
                  AlloyUtilities.getTargetsOfMarkerAtRelations(selected);
              TargetView.setColumns(targets);
            }
          }
          viewPart = page.findView(SourceView.ID);
          if (viewPart == null) {
            viewPart = page.showView(SourceView.ID);
          }
          if (viewPart instanceof SourceView) {
            if (MarkUtilities.getType(selected) != null) {
              final ArrayList<IMarker> sources = AlloyUtilities.getSumSources(selected);
              SourceView.setColumns(sources);
            } else {
              final ArrayList<IMarker> sources =
                  AlloyUtilities.getSourcesOfMarkerAtRelations(selected);
              SourceView.setColumns(sources);
            }
          }
        } catch (final PartInitException e) {
          e.printStackTrace();
        }
      }
    });

    this.tree.addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(final KeyEvent e) {
        if (e.keyCode == SWT.DEL) {
          final IStructuredSelection selection = MasterView.treeViewer.getStructuredSelection();
          if (selection.isEmpty()) {
            return;
          } else {
            final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                .getActivePage().getActiveEditor();
            final TreeItem[] items = MasterView.treeViewer.getTree().getSelection();
            final List<TreeItem> listItems = Arrays.asList(items);
            MasterView.this.candidateToDel = new HashMap<>();
            MasterView.this.candidateToTypeChanging = new ArrayList<IMarker>();
            MasterView.this.checkIfHasSource = new ArrayList<IMarker>();
            for (final TreeItem treeItem : listItems) {
              final IMarker iMarker = (IMarker) treeItem.getData();
              if (MarkUtilities.getGroupId(iMarker) == null) {
                AnnotationFactory.removeAnnotation(iMarker);
                MasterView.this.candidateToDel.put(MarkUtilities.getSourceId(iMarker), iMarker);
                MasterView.this.checkIfHasSource.add(iMarker);
              } else if (MarkUtilities.getLeaderId(iMarker) != null) {
                MasterView.this.checkIfHasSource.add(iMarker);
                final IFile file = ResourceUtil.getFile(editor.getEditorInput());
                final List<IMarker> listOfGroup =
                    MarkerFactory.findMarkersByGroupId(file, MarkUtilities.getGroupId(iMarker));
                for (final IMarker iMarker2 : listOfGroup) {
                  AnnotationFactory.removeAnnotation(iMarker2);
                  MasterView.this.candidateToDel.put(MarkUtilities.getSourceId(iMarker2), iMarker2);
                }
              } else {
                if (MasterView.this.candidateToDel.containsValue(iMarker)) {
                  continue;
                }
                AnnotationFactory.removeAnnotation(iMarker);
                MasterView.this.candidateToDel.put(MarkUtilities.getSourceId(iMarker), iMarker);
              }
            }
          }
          try {
            for (final IMarker iMarker : MasterView.this.checkIfHasSource) {
              MasterView.this.findCandidateToTypeChangingMarkers(iMarker);
            }
            for (final IMarker candidateMarker : MasterView.this.candidateToTypeChanging) {
              if (!MasterView.this.candidateToDel.containsValue(candidateMarker)) {
                MappingWizard.convertAnnotationType(candidateMarker, true, false);
              }
            }
            for (final Map.Entry<String, IMarker> entry : MasterView.this.candidateToDel
                .entrySet()) {
              MasterView.this.deleteFromAlloyXML(entry.getValue());
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
    this.getSite().registerContextMenu(contextMenu, MasterView.treeViewer);
    // Add in the entries for all markers views if this has a different if
    if (!this.getSite().getId().equals(MarkerSupportRegistry.MARKERS_ID)) {
      this.getSite().registerContextMenu(MarkerSupportRegistry.MARKERS_ID, contextMenu,
          MasterView.treeViewer);
    }
    final Control control = MasterView.treeViewer.getControl();
    final Menu menu = contextMenu.createContextMenu(control);
    control.setMenu(menu);
  }

  @Override
  public void setFocus() {
    this.tree.setFocus();
  }
}
