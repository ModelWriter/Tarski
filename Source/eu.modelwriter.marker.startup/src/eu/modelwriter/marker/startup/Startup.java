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
package eu.modelwriter.marker.startup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.RangeMarker;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dnd.IDragAndDropService;

import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.model.EcoreDropAdapter;
import eu.modelwriter.marker.model.SelectionChangeListener;
import eu.modelwriter.marker.ui.internal.views.masterview.MasterView;

public class Startup implements IStartup {

  public static IMarker preMarker = null;

  public static ITreeSelection preSelection = null;
  private boolean isFirst = true;
  private IEditorPart lastEditor;
  private IWorkbenchWindow window = null;

  @Override
  public void earlyStartup() {
    System.out.println("My plugin has been early started");
    final IWorkbench workbench = PlatformUI.getWorkbench();
    workbench.getDisplay().asyncExec(new Runnable() {
      @Override
      public void run() {
        Startup.this.window = workbench.getActiveWorkbenchWindow();
        if (Startup.this.window != null) {
          IEditorPart part = Startup.this.window.getActivePage().getActiveEditor();
          Startup.this.lastEditor = part;
          Startup.this.initMasterView(part);
          if (part instanceof EcoreEditor) {
            Startup.this.initSelectionChangeListener((EcoreEditor) part);
            Startup.this.iniResourceChangeListener((EcoreEditor) part);
            Startup.this.initDrop((EcoreEditor) part);
          }
          Startup.this.window.getActivePage().addPartListener(new IPartListener2() {
            @Override
            public void partActivated(IWorkbenchPartReference partRef) {
              if (partRef instanceof IViewReference) {
                return;
              }

              if (partRef.getPart(false) instanceof IEditorPart) {
                IEditorPart editor = (IEditorPart) partRef.getPart(false);
                if (Startup.this.isFirst == false && Startup.this.lastEditor != null
                    && !Startup.this.lastEditor
                        .equals(Startup.this.window.getActivePage().getActiveEditor())) {
                  MasterView.refreshTree();
                }
                if (editor instanceof EcoreEditor) {
                  EcoreEditor eEditor = (EcoreEditor) editor;
                  Startup.this.initDecoratingLabelProvider(eEditor);
                  Startup.this.initDrop(eEditor);
                  Startup.this.initSelectionChangeListener(eEditor);

                  eEditor.getViewer().refresh();

                  // When change model, fix Xml file
                  Startup.this.iniResourceChangeListener(eEditor);
                }
                Startup.this.lastEditor = Startup.this.window.getActivePage().getActiveEditor();
              }
            }

            @Override
            public void partBroughtToTop(IWorkbenchPartReference partRef) {}

            @Override
            public void partClosed(IWorkbenchPartReference partRef) {
              IEditorPart editor;
              if (partRef.getPart(false) instanceof IEditorPart) {
                editor = (IEditorPart) partRef.getPart(false);
              } else {
                return;
              }

              if (editor instanceof EcoreEditor) {
                EcoreEditor eEditor = (EcoreEditor) editor;
                IFileEditorInput input = (IFileEditorInput) eEditor.getEditorInput();
                IFile eFile = input.getFile();
                List<IMarker> list = MarkerFactory.findMarkers(eFile);
                for (IMarker iMarker : list) {
                  try {
                    // If marker has old Uri and Text, setting these again.
                    if (iMarker.getAttribute("oldText") != null
                        && iMarker.getAttribute("oldUri") != null) {
                      iMarker.setAttribute(IMarker.TEXT, iMarker.getAttribute("oldText"));
                      iMarker.setAttribute(IMarker.MESSAGE, iMarker.getAttribute("oldText"));
                      iMarker.setAttribute("uri", iMarker.getAttribute("oldUri"));

                      // Clearing old Text and Uri.
                      iMarker.setAttribute("oldText", null);
                      iMarker.setAttribute("oldUri", null);
                    }
                  } catch (CoreException e) {
                    e.printStackTrace();
                  }
                }
              }
              // Removing SelectionChangeListener from editor.
              Startup.this.removeSelectionChangeListener(partRef);

              SelectionChangeListener.preMarker = null;
              SelectionChangeListener.preSelection = null;

              MasterView.refreshTree();
            }

            @Override
            public void partDeactivated(IWorkbenchPartReference partRef) {
              Startup.this.removeSelectionChangeListener(partRef);
            }

            @Override
            public void partHidden(IWorkbenchPartReference partRef) {}

            @Override
            public void partInputChanged(IWorkbenchPartReference partRef) {}

            @Override
            public void partOpened(IWorkbenchPartReference partRef) {}

            @Override
            public void partVisible(IWorkbenchPartReference partRef) {}
          });

          // If the an EcoreEditor is already opened before the part listener added.
          IEditorPart editor = Startup.this.window.getActivePage().getActiveEditor();
          if (editor instanceof EcoreEditor) {
            Startup.this.initDecoratingLabelProvider((EcoreEditor) editor);
          }
        }
        Startup.this.isFirst = false;
      }
    });
  }

  private void iniResourceChangeListener(EcoreEditor eEditor) {
    IFileEditorInput input = (IFileEditorInput) eEditor.getEditorInput();
    IFile eFile = input.getFile();
    ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {

      @Override
      public void resourceChanged(IResourceChangeEvent event) {
        IFileEditorInput input = (IFileEditorInput) eEditor.getEditorInput();
        IFile file = input.getFile();
        IResourceDelta delta = event.getDelta().findMember(file.getFullPath());
        if (delta == null) {
          return;
        }
        int flags = delta.getFlags();
        if (delta.getKind() == IResourceDelta.CHANGED && (flags & IResourceDelta.CONTENT) != 0) {

          List<IMarker> list = MarkerFactory.findMarkers(eFile);

          if (eFile.getFileExtension().equals("ecore")) {
            for (IMarker iMarker : list) {
              this.setOldTextAndUri(iMarker);
              try {
                MarkerFactory.updateMarkerfromXMLForModel(iMarker, eFile);
              } catch (Exception e) {
                System.out.println(
                    e.toString() + " ->updateMarkerfromXMLForModel in resourceChange in StartUp");
              }
              try {
                if (iMarker != null && MarkUtilities.getLinenumber(iMarker) == -1) {
                  try {
                    // MarkerUpdater.updateTargetsToDelete(iMarker);
                    // MarkerUpdater.updateSourcesToDelete(iMarker);
                  } catch (Exception e) {
                    System.out.println(e.toString()
                        + " ->updateTargetsToDelete && updateSourcesToDelete - updateMarkerfromXMLForModel in resourceChange in StartUp");
                  }
                  iMarker.delete();
                } else {
                  MarkerUpdater.update(iMarker);
                  // MarkerUpdater.updateTargets(iMarker);
                  // MarkerUpdater.updateSources(iMarker);
                }
              } catch (CoreException e) {
                e.printStackTrace();
              }
            }
          } else if (eFile.getFileExtension().equals("reqif")) {
            for (IMarker iMarker : list) {
              this.setOldTextAndUri(iMarker);
              try {
                MarkerFactory.updateMarkerfromXMLForReqIf(iMarker, eFile);
              } catch (Exception e) {
                System.out.println(
                    e.toString() + " ->updateMarkerfromXMLForReqIf in resourceChange in StartUp");
              }
              try {
                if (iMarker != null && MarkUtilities.getLinenumber(iMarker) == -1) {
                  try {
                    // MarkerUpdater.updateTargetsToDelete(iMarker);
                    // MarkerUpdater.updateSourcesToDelete(iMarker);
                  } catch (Exception e) {
                    System.out.println(e.toString()
                        + " ->updateTargetsToDelete && updateSourcesToDelete - updateMarkerfromXMLForReqIf in resourceChange in StartUp");
                  }
                  iMarker.delete();
                } else {
                  MarkerUpdater.update(iMarker);
                  // MarkerUpdater.updateTargets(iMarker);
                  // MarkerUpdater.updateSources(iMarker);
                }

              } catch (CoreException e) {
                e.printStackTrace();
              }
            }
          } else {
            for (IMarker iMarker : list) {
              this.setOldTextAndUri(iMarker);
              try {
                MarkerFactory.updateMarkerfromXMLForInstance(iMarker, eFile);
              } catch (Exception e) {
                System.out.println(e.toString()
                    + " ->updateMarkerfromXMLForInstance in resourceChange in StartUp");
              }
              try {
                if (iMarker != null && MarkUtilities.getLinenumber(iMarker) == -1) {
                  try {
                    // MarkerUpdater.updateTargetsToDelete(iMarker);
                    // MarkerUpdater.updateSourcesToDelete(iMarker);
                  } catch (Exception e) {
                    System.out.println(e.toString()
                        + " ->updateTargetsToDelete && updateSourcesToDelete - updateMarkerfromXMLForInstance in resourceChange in StartUp");
                  }
                  iMarker.delete();
                } else {
                  MarkerUpdater.update(iMarker);
                  // MarkerUpdater.updateTargets(iMarker);
                  // MarkerUpdater.updateSources(iMarker);
                }
              } catch (CoreException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }

      public void setOldTextAndUri(IMarker iMarker) {
        try {
          if (iMarker.getAttribute("oldText") != null && iMarker.getAttribute("oldUri") != null) {
            // Clearing old Text and Uri.
            iMarker.setAttribute("oldText", null);
            iMarker.setAttribute("oldUri", null);
          }
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    }, IResourceChangeEvent.POST_BUILD);
  }

  /**
   * Initializes decorator for given EcoreEditor.
   */
  private void initDecoratingLabelProvider(EcoreEditor eEditor) {
    TreeViewer treeViewer = (TreeViewer) eEditor.getViewer();
    ILabelProvider labelProvider = (ILabelProvider) treeViewer.getLabelProvider();

    if (labelProvider instanceof DecoratingLabelProvider) {
      return;
    } else {
      ILabelDecorator decorator =
          this.window.getWorkbench().getDecoratorManager().getLabelDecorator();
      treeViewer.setLabelProvider(new DecoratingLabelProvider(labelProvider, decorator));
    }
  }

  private void initDrop(EcoreEditor eEditor) {
    Transfer[] t = new Transfer[] {TextTransfer.getInstance(), LocalTransfer.getInstance(),
        LocalSelectionTransfer.getTransfer(), FileTransfer.getInstance()};
    int ops = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
    
    IDragAndDropService dtSvc = eEditor.getSite().getService(IDragAndDropService.class);
    dtSvc.addMergedDropTarget(eEditor.getViewer().getControl(), ops, t, new EcoreDropAdapter(eEditor));
  }

  private void initMasterView(IEditorPart editor) {
    if (editor == null) {
      return;
    }
    IFile file = editor.getEditorInput().getAdapter(IFile.class);
    TreeViewer treeViewer = MasterView.getTreeViewer();
    if (treeViewer != null) {
      // Finding all markers in given file.
      ArrayList<IMarker> allMarkers;
      allMarkers = MarkerFactory.findMarkersAsArrayList(file);
      if (allMarkers == null) {
        return;
      }
      Iterator<IMarker> iter = allMarkers.iterator();
      while (iter.hasNext()) {
        IMarker marker = iter.next();
        if (MarkUtilities.getLeaderId(marker) == null && MarkUtilities.getGroupId(marker) != null) {
          iter.remove();
        }
      }
      if (!treeViewer.getTree().isDisposed()) {
        treeViewer.setInput(allMarkers.toArray());
      }
      treeViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
    }
  }

  @SuppressWarnings("unused")
  private boolean initResourceChangeListener(EcoreEditor eEditor) {
    ResourcesPlugin.getWorkspace().addResourceChangeListener(new IResourceChangeListener() {

      @Override
      public void resourceChanged(IResourceChangeEvent event) {
        IFileEditorInput input = (IFileEditorInput) eEditor.getEditorInput();
        IFile file = input.getFile();
        IResourceDelta delta = event.getDelta().findMember(file.getFullPath());
        int flags = delta.getFlags();
        if (delta != null && delta.getKind() == IResourceDelta.CHANGED
            && (flags & IResourceDelta.CONTENT) != 0) {

          Scanner scanner = null;
          try {
            scanner = new Scanner(file.getContents(), "UTF-8");
          } catch (CoreException e) {
            e.printStackTrace();
          }
          IDocument document = new Document(scanner.useDelimiter("\\A").next());
          System.out.println("Document before change:\n" + document.get());
          scanner.close();

          InsertEdit edit = new InsertEdit(0, document.get());
          List<IMarker> list = MarkerFactory.findMarkers(file);
          HashMap<String, RangeMarker> mapRangeMarker = new HashMap<String, RangeMarker>();
          HashMap<String, IMarker> mapMarker = new HashMap<String, IMarker>();
          for (IMarker iMarker : list) {
            try {
              int offset = MarkUtilities.getStart(iMarker);
              int length = MarkUtilities.getLength(iMarker);
              String id = MarkUtilities.getSourceId(iMarker);
              RangeMarker rm = new RangeMarker(offset, length);
              mapRangeMarker.put(id, rm);

              rm.apply(document);
              mapMarker.put(id, iMarker);
            } catch (MalformedTreeException | BadLocationException e) {
              e.printStackTrace();
            }
          }

          edit = new InsertEdit(5, "#FERHAT#");
          try {
            edit.apply(document, TextEdit.UPDATE_REGIONS);
          } catch (MalformedTreeException | BadLocationException e1) {
            e1.printStackTrace();
          }

          System.out.println("=========================");
          System.out.println("New Document:\n" + document.get());

          for (Map.Entry<String, RangeMarker> entry : mapRangeMarker.entrySet()) {
            IMarker marker = mapMarker.get(entry.getKey());
            int start = entry.getValue().getOffset();
            int end = entry.getValue().getOffset() + entry.getValue().getLength();
            System.out.println("Old Start: " + MarkUtilities.getStart(marker) + " - " + "Old End: "
                + MarkUtilities.getEnd(marker));
            MarkUtilities.setStart(marker, start);
            MarkUtilities.setEnd(marker, end);
            System.out.println("New Start: " + start + " - " + "New End: " + end);
          }
        }
      }
    }, IResourceChangeEvent.POST_BUILD);
    return false;
  }

  private boolean initSelectionChangeListener(EcoreEditor eEditor) {
    IFileEditorInput eInput = (IFileEditorInput) eEditor.getEditorInput();
    IFile eFile = eInput.getFile();
    // Adding SelectionChangeListener to editor.
    eEditor.getViewer().addSelectionChangedListener(SelectionChangeListener.getInstance(eFile));

    return false;
  }

  private void removeSelectionChangeListener(IWorkbenchPartReference partRef) {
    if (partRef.getPart(false) instanceof IEditorPart) {
      IEditorPart editor = (IEditorPart) partRef.getPart(false);
      this.initMasterView(editor);
      if (editor instanceof EcoreEditor) {
        EcoreEditor eEditor = (EcoreEditor) editor;
        IFileEditorInput eInput = (IFileEditorInput) eEditor.getEditorInput();
        IFile eFile = eInput.getFile();
        // Removing SelectionChangeListener from editor.
        ((EcoreEditor) editor).getViewer()
            .removeSelectionChangedListener(SelectionChangeListener.getInstance(eFile));
      }
    }
  }
}
