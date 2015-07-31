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
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
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
import org.eclipse.ui.part.PluginTransfer;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.model.EcoreEditorDragListener;
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
          window.getActivePage().addPartListener(new IPartListener2() {

            @Override
            public void partActivated(IWorkbenchPartReference partRef) {
              if (partRef instanceof IViewReference)
                return;
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


                  // ResourcesPlugin.getWorkspace() .addResourceChangeListener(new
                  // IResourceChangeListener() {
                  //
                  // @Override public void resourceChanged(IResourceChangeEvent event) {
                  // List<IMarker> list = MarkerFactory.findAllMarkers(eFile);
                  //
                  // for (IMarker iMarker : list) { MarkerFactory.updateMarkerfromXML(iMarker,
                  // eFile); }
                  //
                  // } }, IResourceChangeEvent.POST_BUILD);

                }
              }
            }

            @Override
            public void partBroughtToTop(IWorkbenchPartReference partRef) {
              // TODO Auto-generated method stub

            }

            @Override
            public void partClosed(IWorkbenchPartReference partRef) {
              // TODO Auto-generated method stub

            }

            @Override
            public void partDeactivated(IWorkbenchPartReference partRef) {
              removeSelectionChangeListener(partRef);

            }

            @Override
            public void partOpened(IWorkbenchPartReference partRef) {
              // TODO Auto-generated method stub
            }

            @Override
            public void partHidden(IWorkbenchPartReference partRef) {
              // TODO Auto-generated method stub

            }

            @Override
            public void partVisible(IWorkbenchPartReference partRef) {
              // TODO Auto-generated method stub
            }

            @Override
            public void partInputChanged(IWorkbenchPartReference partRef) {

            }

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
      try {
        allMarkers = MarkerFactory.findMarkersAsArrayList(file);
        if (allMarkers == null)
          return;
        Iterator<IMarker> iter = allMarkers.iterator();
        while (iter.hasNext()) {
          IMarker marker = iter.next();
          try {
            if (marker.getAttribute(MarkerFactory.LEADER_ID) == null
                && marker.getAttribute(MarkerFactory.GROUP_ID) != null) {
              iter.remove();
            }
          } catch (CoreException e) {
            e.printStackTrace();
          }
        }
        MarkElement markers[] = new MarkElement[allMarkers.size()];
        int i = 0;
        for (IMarker iMarker : allMarkers) {
          markers[i] = new MarkElement(iMarker);
          i++;
        }
        if (!treeViewer.getTree().isDisposed())
          treeViewer.setInput(markers);
      } catch (CoreException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Initializes drag and drop for given EcoreEditor.
   */
  private void initDragAndDrop(EcoreEditor eEditor) {
    TreeViewer treeViewer = (TreeViewer) eEditor.getViewer();
    int ops = DND.DROP_COPY | DND.DROP_MOVE;
    Transfer[] transfers =
        new Transfer[] {TextTransfer.getInstance(), PluginTransfer.getInstance()};
    treeViewer.addDragSupport(ops, transfers, new EcoreEditorDragListener(eEditor));
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
            // TODO Auto-generated catch block
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
              int offset = (int) iMarker.getAttribute(IMarker.CHAR_START);
              int length = (int) iMarker.getAttribute(IMarker.CHAR_END) - offset;
              String id = (String) iMarker.getAttribute(IMarker.SOURCE_ID);
              RangeMarker rm = new RangeMarker(offset, length);
              mapRangeMarker.put(id, rm);

              rm.apply(document);
              mapMarker.put(id, iMarker);
            } catch (CoreException | MalformedTreeException | BadLocationException e) {
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
            try {
              int start = entry.getValue().getOffset();
              int end = entry.getValue().getOffset() + entry.getValue().getLength();
              System.out.println("Old Start: " + marker.getAttribute(IMarker.CHAR_START) + " - "
                  + "Old End: " + marker.getAttribute(IMarker.CHAR_END));
              marker.setAttribute(IMarker.CHAR_START, start);
              marker.setAttribute(IMarker.CHAR_END, end);
              System.out.println("New Start: " + start + " - " + "New End: " + end);
            } catch (CoreException e) {
              e.printStackTrace();
            }
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

    // eEditor.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
    //
    // @Override
    // public void selectionChanged(SelectionChangedEvent event) {
    //
    // if (preMarker != null) {
    // try {
    // if (event.getSelection().isEmpty()) {
    // preMarker.delete();
    // } else {
    // preMarker.setAttribute("uri",
    // EcoreUtil.getURI((ENamedElement) preSelection.getFirstElement()).toString());
    //
    // String xpath = XMLDOMHelper.findNodeAndGetXPath(
    // ((ENamedElement) preSelection.getFirstElement()).getName(),
    // eFile.getLocation().toFile().getAbsolutePath());
    // preMarker.setAttribute("xpath", xpath);
    //
    // preMarker.setAttribute(IMarker.TEXT,
    // ((ENamedElement) preSelection.getFirstElement()).getName());
    // preMarker.setAttribute(IMarker.MESSAGE,
    // ((ENamedElement) preSelection.getFirstElement()).getName());
    // preMarker = null;
    // preSelection = null;
    // }
    // } catch (CoreException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // if (preSelection == null || preSelection.getFirstElement() instanceof ENamedElement) {
    // preSelection = (ITreeSelection) event.getSelection();
    // preMarker =
    // MarkerFactory.findMarkerByTreeSelection((ITreeSelection) event.getSelection(), eFile);
    // eEditor.getViewer().refresh();
    //
    // }
    // }
    // });
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

}
