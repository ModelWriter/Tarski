package eu.modelwriter.specification.editor;

import java.awt.Frame;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.MultiPageEditorPart;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4graph.GraphViewer;
import edu.mit.csail.sdg.alloy4viz.AlloyAtom;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.MagicColor;
import edu.mit.csail.sdg.alloy4viz.MagicLayout;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.configuration.internal.AlloyUtilities;
import eu.modelwriter.marker.internal.MarkUtilities;
import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.ui.internal.views.visualizationview.Visualization;
import eu.modelwriter.marker.ui.internal.wizards.mappingwizard.MappingWizard;

public class MetaModelEditor extends MultiPageEditorPart {

  // This is the class for Specification Code Editor
  private class Editor extends TextEditor {

    public Editor() {}

    @Override
    protected boolean affectsTextPresentation(final PropertyChangeEvent event) {
      return super.affectsTextPresentation(event);
    }

    @Override
    protected void initializeEditor() {
      super.initializeEditor();
      this.setSourceViewerConfiguration(new MetaModelEditorSourceViewerConfig(this));
      this.setDocumentProvider(new MetaModelDocumentProvider());
    }
  }

  public static Object rightClickedAnnotation;
  static String xmlFileName = null;

  public static final String ERROR_MARKER_ID =
      "eu.modelwriter.marker.specification.editor.errormarker";

  private VizState myState = null;
  private VizGraphPanel graph;
  private Frame frame;
  private File file = null;
  Composite modelEditor;

  private Editor textEditor;

  public MetaModelEditor() {}

  @Override
  protected void createPages() {
    try {
      this.create();
    } catch (final CoreException e) {
      e.printStackTrace();
    }
    if (true) {
      this.addDropListener();
    }
  }

  @Override
  public void doSave(IProgressMonitor monitor) {
    final IEditorPart editor = this.getActiveEditor();
    if (editor instanceof Editor) {
      editor.doSave(monitor);
    } else {
      // do nothing
    }
  }

  @Override
  public void doSaveAs() {
    // do nothing
  }

  @Override
  public boolean isSaveAsAllowed() {
    return false;
  }

  /**
   * This creates editors and parse specification for show meta model.
   * 
   * @throws CoreException
   */
  public void create() throws CoreException {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
        | UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }

    int index;
    this.textEditor = new Editor();

    this.modelEditor = new Composite(this.getContainer(), SWT.EMBEDDED);
    index = this.addPage(this.modelEditor);
    this.setPageText(index, "Specification");

    try {
      index = this.addPage(this.textEditor, this.getEditorInput());
      this.setPageText(index, "Source");
      this.setPartName(this.textEditor.getTitle());
    } catch (final PartInitException e) {
      ErrorDialog.openError(this.getSite().getShell(), " Error creating nested text editor", null,
          e.getStatus());
    }

    @SuppressWarnings("unused")
    final AlloyParserForMetamodel alloyParserForMetamodel = new AlloyParserForMetamodel(
        this.textEditor.getEditorInput().getAdapter(IFile.class).getRawLocation().toString());

    this.frame = null;
    this.myState = null;
    this.graph = null;
    this.file = null;

    this.showMetamodel(true);
  }

  /**
   * This listener is adding to alloy viewer for listen drag and drop actions.
   */
  private void addDropListener() {
    final int acceptableOps = DnDConstants.ACTION_COPY;
    @SuppressWarnings("unused")
    final DropTarget dropTarget =
        new DropTarget(this.graph.alloyGetViewer(), acceptableOps, new DropTargetListener() {
          ISelection selection;
          IFile file;

          private void createMarker(final String type) {
            Display.getDefault().asyncExec(new Runnable() {

              @Override
              public void run() {
                file = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .getActiveEditor().getEditorInput().getAdapter(IFile.class);
                selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                    .getSelectionService().getSelection();
                if (selection instanceof ITextSelection) {
                  IMarker marker;
                  final ITextSelection textSelection = (ITextSelection) selection;
                  final int start = textSelection.getOffset();
                  final int end = textSelection.getOffset() + textSelection.getLength();

                  marker = MarkerFactory.findMarkerWithAbsolutePosition(file, start, end);
                  if (marker == null) {
                    marker = MarkerFactory.createMarker(file, (ITextSelection) selection);
                    AlloyUtilities.addMarkerToRepository(marker);
                  } else if (MarkUtilities.getType(marker) != null) {
                    if (MappingWizard.findTargetCount(marker) != 0) {
                      marker = MappingWizard.convertAnnotationType(marker, true, true);
                    }
                    AlloyUtilities.removeTypeFromMarker(marker);
                  }
                  MarkUtilities.setType(marker, type);
                  AlloyUtilities.addTypeToMarker(marker);
                  Visualization.showViz(MetaModelEditor.this.modelEditor);
                }
              }
            });
          }

          @Override
          public void dragEnter(final DropTargetDragEvent dtde) {
            if (this.isDragOk(dtde) == false) {
              dtde.rejectDrag();
              return;
            }
            dtde.acceptDrag(acceptableOps);
          }

          @Override
          public void dragExit(final DropTargetEvent dte) {}

          @Override
          public void dragOver(final DropTargetDragEvent dtde) {
            if (this.isDragOk(dtde) == false) {
              dtde.rejectDrag();
              return;
            }
            dtde.acceptDrag(acceptableOps);
          }

          @SuppressWarnings("deprecation")
          @Override
          public void drop(final DropTargetDropEvent dtde) {
            final DataFlavor flavor = DataFlavor.stringFlavor;
            DataFlavor chosen = null;
            if (dtde.isLocalTransfer() == false) {
              chosen = DataFlavor.plainTextFlavor;
            } else {
              if (dtde.isDataFlavorSupported(flavor)) {
                chosen = flavor;
              }
            }
            if (chosen == null) {
              dtde.rejectDrop();
              return;
            }

            final int sa = dtde.getSourceActions();
            if ((sa & acceptableOps) == 0) {
              dtde.rejectDrop();
              return;
            }

            Object data = null;
            try {
              dtde.acceptDrop(acceptableOps);
              data = dtde.getTransferable().getTransferData(chosen);
              if (data == null) {
                throw new NullPointerException();
              }
            } catch (final Throwable t) {
              t.printStackTrace();
              dtde.dropComplete(false);
              return;
            }

            final Point mousePoint = dtde.getLocation();
            final GraphViewer graphViewer =
                (GraphViewer) dtde.getDropTargetContext().getComponent();
            final Object annotation =
                graphViewer.alloyGetAnnotationAtXY(mousePoint.x, mousePoint.y);
            if (annotation instanceof AlloyAtom) {
              final AlloyAtom atom = (AlloyAtom) annotation;
              this.createMarker(atom.toString());
              dtde.dropComplete(true);
            }
          }

          @Override
          public void dropActionChanged(final DropTargetDragEvent dtde) {
            if (this.isDragOk(dtde) == false) {
              dtde.rejectDrag();
              return;
            }
            dtde.acceptDrag(acceptableOps);
          }

          private boolean isDragOk(final DropTargetDragEvent dtde) {
            final DataFlavor flavor = DataFlavor.stringFlavor;
            DataFlavor chosen = null;

            if (dtde.isDataFlavorSupported(flavor)) {
              chosen = flavor;
            }

            if (chosen == null) {
              return false;
            }

            final int sourceActions = dtde.getSourceActions();

            if ((sourceActions & acceptableOps) == 0) {
              return false;
            }

            final Point mousePoint = dtde.getLocation();
            final GraphViewer graphViewer =
                (GraphViewer) dtde.getDropTargetContext().getComponent();
            final Object annotation =
                graphViewer.alloyGetAnnotationAtXY(mousePoint.x, mousePoint.y);
            if (annotation instanceof AlloyAtom) {
              final AlloyAtom atom = (AlloyAtom) annotation;
              if (atom.getType().isAbstract) {
                return false;
              }
            } else {
              return false;
            }
            return true;
          }
        }, true);
  }

  private void showMetamodel(final boolean isMagicLayout) {
    MetaModelEditor.xmlFileName =
        Util.canon(AlloyUtilities.getLocationForMetamodel(this.textEditor.getTitle()));

    this.file = new File(MetaModelEditor.xmlFileName);
    try {
      if (!this.file.exists()) {
        throw new IOException("File " + MetaModelEditor.xmlFileName + " does not exist.");
      }
      final AlloyInstance instance = StaticInstanceReader.parseInstance(this.file);

      this.myState = new VizState(instance);
      if (isMagicLayout == true) {
        MagicLayout.magic(this.myState);
        MagicColor.magic(this.myState);
      } else {
        this.myState.resetTheme();
      }

      if (this.frame == null) {
        this.frame = SWT_AWT.new_Frame(this.modelEditor);
      }

      if (this.graph != null && this.frame.getComponent(0) != null) {
        this.frame.remove(this.graph);
      }

      this.graph = new VizGraphPanel(this.myState, false);
      this.frame.removeAll();
      this.frame.add(this.graph);
      this.frame.setVisible(true);
      this.frame.setAlwaysOnTop(true);
      this.graph.alloyGetViewer().alloyRepaint();

      final JMenuItem magicLayoutMenuItem = new JMenuItem("Magic Layout");
      final JMenuItem resetThemeMenuItem = new JMenuItem("Reset Theme");

      this.graph.alloyGetViewer().pop.add(magicLayoutMenuItem, 0);
      this.graph.alloyGetViewer().pop.add(resetThemeMenuItem, 1);

      magicLayoutMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          MetaModelEditor.this.showMetamodel(true);
          MetaModelEditor.this.addDropListener();
        }
      });

      resetThemeMenuItem.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent e) {
          MetaModelEditor.this.showMetamodel(false);
          MetaModelEditor.this.addDropListener();
        }
      });
    } catch (final Err e1) {
      e1.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}
