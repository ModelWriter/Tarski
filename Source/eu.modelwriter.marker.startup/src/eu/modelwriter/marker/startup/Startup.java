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
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
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

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkElementUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.internal.MarkerUpdater;
import eu.modelwriter.marker.model.SelectionChangeListener;
import eu.modelwriter.marker.ui.views.masterview.MasterView;

public class Startup implements IStartup {

  private IWorkbenchWindow window = null;

  public static IMarker preMarker = null;
  public static ITreeSelection preSelection = null;

  @Override
  public void earlyStartup() {
    System.out.println("My plugin has been early started");
    final IWorkbench workbench = PlatformUI.getWorkbench();
    workbench.getDisplay().asyncExec(new Runnable() {
      public void run() {
        window = workbench.getActiveWorkbenchWindow();
        if (window != null) {
          IEditorPart part = window.getActivePage().getActiveEditor();
          initMasterView(part);
          window.getActivePage().addPartListener(new IPartListener2() {
            @Override
            public void partActivated(IWorkbenchPartReference partRef) {
              if (partRef instanceof IViewReference) {
                return;
              }

              if (partRef.getPart(false) instanceof IEditorPart) {
                IEditorPart editor = (IEditorPart) partRef.getPart(false);
                initMasterView(editor);
                if (editor instanceof EcoreEditor) {
                  EcoreEditor eEditor = (EcoreEditor) editor;
                  initDecoratingLabelProvider(eEditor);
                  // initDragAndDrop(eEditor);
                  // initResourceChangeListener(eEditor);
                  initSelectionChangeListener(eEditor);

                  eEditor.getViewer().refresh();

                  // When change model, fix Xml file
                  iniResourceChangeListener(eEditor);
                }
              }
            }

            @Override
            public void partBroughtToTop(IWorkbenchPartReference partRef) {}

            @Override
            public void partClosed(IWorkbenchPartReference partRef) {
              IEditorPart editor;
              if (partRef.getPart(false) instanceof IEditorPart)
                editor = (IEditorPart) partRef.getPart(false);
              else
                return;

              if (editor instanceof EcoreEditor) {
                EcoreEditor eEditor = (EcoreEditor) editor;
                IFileEditorInput input = (IFileEditorInput) eEditor.getEditorInput();
                IFile eFile = input.getFile();
                List<IMarker> list = MarkerFactory.findMarkers(eFile);
                for (IMarker iMarker : list) {
                  try {
                    if (iMarker.getAttribute("oldText") != null
                        && iMarker.getAttribute("oldUri") != null) {
                      iMarker.setAttribute(IMarker.TEXT, iMarker.getAttribute("oldText"));
                      iMarker.setAttribute(IMarker.MESSAGE, iMarker.getAttribute("oldText"));
                      iMarker.setAttribute("uri", iMarker.getAttribute("oldUri"));
                      iMarker.setAttribute("oldText", null);
                      iMarker.setAttribute("oldUri", null);
                    }
                  } catch (CoreException e) {
                    e.printStackTrace();
                  }
                }
              }
              removeSelectionChangeListener(partRef);
              SelectionChangeListener.preMarker = null;
              SelectionChangeListener.preSelection = null;
            }

            @Override
            public void partDeactivated(IWorkbenchPartReference partRef) {
              removeSelectionChangeListener(partRef);
            }

            @Override
            public void partOpened(IWorkbenchPartReference partRef) {}

            @Override
            public void partHidden(IWorkbenchPartReference partRef) {}

            @Override
            public void partVisible(IWorkbenchPartReference partRef) {}

            @Override
            public void partInputChanged(IWorkbenchPartReference partRef) {}
          });

          // If the an EcoreEditor is already opened before the part listener added.
          IEditorPart editor = window.getActivePage().getActiveEditor();
          if (editor instanceof EcoreEditor) {
            initDecoratingLabelProvider((EcoreEditor) editor);
          }
        }
      }
    });
  }

  private void initMasterView(IEditorPart editor) {
    IFile file = editor.getEditorInput().getAdapter(IFile.class);
    TreeViewer treeViewer = MasterView.getTreeViewer();
    if (treeViewer != null) {
      ArrayList<IMarker> allMarkers;
      allMarkers = MarkerFactory.findMarkersAsArrayList(file);
      if (allMarkers == null)
        return;
      Iterator<IMarker> iter = allMarkers.iterator();
      while (iter.hasNext()) {
        IMarker marker = iter.next();
        if (MarkElementUtilities.getLeaderId(marker) == null
            && MarkElementUtilities.getGroupId(marker) != null) {
          iter.remove();
        }
      }
      MarkElement markers[] = new MarkElement[allMarkers.size()];
      int i = 0;
      for (IMarker iMarker : allMarkers) {
        markers[i] = new MarkElement(iMarker);
        i++;
      }
      if (!treeViewer.getTree().isDisposed()) {
        treeViewer.setInput(markers);
      }
      treeViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
    }
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
      ILabelDecorator decorator = window.getWorkbench().getDecoratorManager().getLabelDecorator();
      treeViewer.setLabelProvider(new DecoratingLabelProvider(labelProvider, decorator));
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
              int offset = MarkElementUtilities.getStart(iMarker);
              int length = MarkElementUtilities.getLength(iMarker);
              String id = MarkElementUtilities.getSourceId(iMarker);
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
            System.out.println("Old Start: " + MarkElementUtilities.getStart(marker) + " - "
                + "Old End: " + (MarkElementUtilities.getEnd(marker)));
            MarkElementUtilities.setStart(marker, start);
            MarkElementUtilities.setEnd(marker, end);
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
    eEditor.getViewer().addSelectionChangedListener(SelectionChangeListener.getInstance(eFile));

    return false;
  }

  private void removeSelectionChangeListener(IWorkbenchPartReference partRef) {
    if (partRef.getPart(false) instanceof IEditorPart) {
      IEditorPart editor = (IEditorPart) partRef.getPart(false);
      initMasterView(editor);
      if (editor instanceof EcoreEditor) {
        EcoreEditor eEditor = (EcoreEditor) editor;
        IFileEditorInput eInput = (IFileEditorInput) eEditor.getEditorInput();
        IFile eFile = eInput.getFile();
        ((EcoreEditor) editor).getViewer()
            .removeSelectionChangedListener(SelectionChangeListener.getInstance(eFile));
      }
    }
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
        if (delta == null)
          return;
        int flags = delta.getFlags();
        if (delta.getKind() == IResourceDelta.CHANGED && (flags & IResourceDelta.CONTENT) != 0) {

          List<IMarker> list = MarkerFactory.findMarkers(eFile);

          if (eFile.getFileExtension().equals("ecore")) {
            for (IMarker iMarker : list) {
              setOldTextAndUri(iMarker);
              try {
                MarkerFactory.updateMarkerfromXMLForModel(iMarker, eFile);
              } catch (Exception e) {
              }
              try {
                if (iMarker != null && MarkElementUtilities.getLinenumber(iMarker) == -1) {
                  try {
                    MarkerUpdater.updateTargetsToDelete(iMarker);
                    MarkerUpdater.updateSourcesToDelete(iMarker);
                  } catch (Exception e) {
                  }
                  iMarker.delete();
                }
              } catch (CoreException e) {
                e.printStackTrace();
              }
            }
          } else if (eFile.getFileExtension().equals("reqif")) {
            for (IMarker iMarker : list) {
              setOldTextAndUri(iMarker);
              try {
                MarkerFactory.updateMarkerfromXMLForReqIf(iMarker, eFile);
              } catch (Exception e) {
              }
              try {
                if (iMarker != null && MarkElementUtilities.getLinenumber(iMarker) == -1) {
                  try {
                    MarkerUpdater.updateTargetsToDelete(iMarker);
                    MarkerUpdater.updateSourcesToDelete(iMarker);
                  } catch (Exception e) {
                  }
                  iMarker.delete();
                }

              } catch (CoreException e) {
                e.printStackTrace();
              }
            }
          } else {
            for (IMarker iMarker : list) {
              setOldTextAndUri(iMarker);
              try {
                MarkerFactory.updateMarkerfromXMLForInstance(iMarker, eFile);
              } catch (Exception e) {
              }
              try {
                if (iMarker != null && MarkElementUtilities.getLinenumber(iMarker) == -1) {
                  try {
                    MarkerUpdater.updateTargetsToDelete(iMarker);
                    MarkerUpdater.updateSourcesToDelete(iMarker);
                  } catch (Exception e) {
                  }
                  iMarker.delete();
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
            iMarker.setAttribute("oldText", null);
            iMarker.setAttribute("oldUri", null);
          }
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    }, IResourceChangeEvent.POST_BUILD);
  }
}
