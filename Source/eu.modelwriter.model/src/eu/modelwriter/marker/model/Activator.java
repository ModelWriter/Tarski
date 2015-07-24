package eu.modelwriter.marker.model;

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
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.model.samples.MasterView;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "eu.modelwriter.model"; //$NON-NLS-1$

  // The shared instance
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {}

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework. BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;

    getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener2() {
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
        // TODO Auto-generated method stub

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
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework. BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  private void initMasterView(IEditorPart editor) {
    IFile file = editor.getEditorInput().getAdapter(IFile.class);
    TreeViewer treeViewer = MasterView.getTreeViewer();
    if (treeViewer != null) {
      ArrayList<IMarker> allMarkers;
      try {
        allMarkers = MarkerFactory.findMarkersAsArrayList(file);
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
      ILabelDecorator decorator =
          getActiveWorkbenchWindow().getWorkbench().getDecoratorManager().getLabelDecorator();
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
          List<IMarker> list = MarkerFactory.findAllMarkers(file);
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

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  public static IWorkbenchWindow getActiveWorkbenchWindow() {
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
  }

}
