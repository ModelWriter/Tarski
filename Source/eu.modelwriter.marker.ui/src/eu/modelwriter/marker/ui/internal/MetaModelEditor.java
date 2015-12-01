package eu.modelwriter.marker.ui.internal;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.Util;
import edu.mit.csail.sdg.alloy4viz.AlloyInstance;
import edu.mit.csail.sdg.alloy4viz.MagicColor;
import edu.mit.csail.sdg.alloy4viz.MagicLayout;
import edu.mit.csail.sdg.alloy4viz.StaticInstanceReader;
import edu.mit.csail.sdg.alloy4viz.VizGraphPanel;
import edu.mit.csail.sdg.alloy4viz.VizState;
import eu.modelwriter.configuration.alloy.AlloyParserForMetamodel;
import eu.modelwriter.configuration.internal.AlloyUtilities;

public class MetaModelEditor extends MultiPageEditorPart {
  public static final String ID = "eu.modelwriter.marker.ui.views.metamodelview";
  private static VizState myState = null;
  private static VizGraphPanel graph;
  private static Frame frame;
  private static File f = null;
  public static Object rightClickedAnnotation;
  static String xmlFileName = null;

  private TextEditor editor1;

  // void createPage1() {
  // try {
  //
  //
  // final int index = this.addPage(this.editor1, this.getEditorInput());
  // this.setPageText(index, "Source");
  // this.setPartName(this.editor1.getTitle());
  // } catch (final PartInitException e) {
  // ErrorDialog.openError(this.getSite().getShell(), " Error creating nested text editor", null,
  // e.getStatus());
  // }
  // }

  public void createPage0() {
    this.editor1 = new TextEditor();
    final Composite composite = new Composite(this.getContainer(), SWT.EMBEDDED);
    int index = this.addPage(composite);
    this.setPageText(index, "Specification");

    try {
      index = this.addPage(this.editor1, this.getEditorInput());
    } catch (PartInitException e) {
      ErrorDialog.openError(this.getSite().getShell(), " Error creating nested text editor", null,
          e.getStatus());
    }
    this.setPageText(index, "Source");
    this.setPartName(this.editor1.getTitle());

    AlloyParserForMetamodel alloyParserForMetamodel = new AlloyParserForMetamodel(
        ((FileEditorInput) editor1.getEditorInput()).getPath().toString());
    xmlFileName = Util.canon(AlloyUtilities.getLocationForMetamodel(this.editor1.getTitle()));

    MetaModelEditor.frame = null;
    MetaModelEditor.myState = null;
    MetaModelEditor.graph = null;
    MetaModelEditor.f = null;



    if (!AlloyUtilities.isExists()) {
      MetaModelEditor.frame = SWT_AWT.new_Frame(composite);
      MetaModelEditor.frame.add(new JPanel());
      return;
    }
    MetaModelEditor.f = new File(MetaModelEditor.xmlFileName);
    try {
      if (!MetaModelEditor.f.exists()) {
        throw new IOException("File " + MetaModelEditor.xmlFileName + " does not exist.");
      }
      // AlloyUtilities.setMetamodel(this.editor1.getTitle(), true);
      final AlloyInstance instance = StaticInstanceReader.parseInstance(MetaModelEditor.f);

      MetaModelEditor.myState = new VizState(instance);
      MagicLayout.magic(myState);
      MagicColor.magic(myState);

      if (MetaModelEditor.frame == null) {
        MetaModelEditor.frame = SWT_AWT.new_Frame(composite);
      }

      if (MetaModelEditor.graph != null && MetaModelEditor.frame.getComponent(0) != null) {
        MetaModelEditor.frame.remove(MetaModelEditor.graph);
      }

      MetaModelEditor.graph = new VizGraphPanel(MetaModelEditor.myState, false);
      MetaModelEditor.frame.removeAll();
      MetaModelEditor.frame.add(MetaModelEditor.graph);
      MetaModelEditor.frame.setVisible(true);
      MetaModelEditor.frame.setAlwaysOnTop(true);
      MetaModelEditor.graph.alloyGetViewer().alloyRepaint();

    } catch (final Err e1) {
      e1.printStackTrace();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void createPages() {
    this.createPage0();
    // this.createPage1();
  }

  @Override
  public void doSave(final IProgressMonitor monitor) {
    // nothing
  }

  @Override
  public void doSaveAs() {
    // nothing
  }

  @Override
  public boolean isSaveAsAllowed() {
    // TODO Auto-generated method stub
    return false;
  }
}
