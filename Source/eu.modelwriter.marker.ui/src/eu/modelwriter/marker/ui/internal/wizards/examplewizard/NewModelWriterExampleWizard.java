package eu.modelwriter.marker.ui.internal.wizards.examplewizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.wizard.AbstractExampleInstallerWizard;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbench;

public class NewModelWriterExampleWizard extends AbstractExampleInstallerWizard {
  private static NewModelWriterExampleWizardPage mwPage;
  List<ProjectDescriptor> projectDescriptors;
  List<FileToOpen> filesToOpen;

  public NewModelWriterExampleWizard() {
    super();
    this.setWindowTitle("Create New Model Writer Example");
    this.projectDescriptors = new ArrayList<>();
    this.filesToOpen = new ArrayList<>();
  }

  @Override
  public void addPages() {
    NewModelWriterExampleWizard.mwPage = new NewModelWriterExampleWizardPage(this, "mwPage",
        "Model Writer Example Page", (ImageDescriptor) null);
    this.addPage(NewModelWriterExampleWizard.mwPage);
  }

  @Override
  protected List<FileToOpen> getFilesToOpen() {
    return this.filesToOpen;
  }

  @Override
  public IWizardPage getNextPage(final IWizardPage page) {
    this.setForcePreviousAndNextButtons(false);
    return NewModelWriterExampleWizard.mwPage;
  }

  @Override
  protected List<ProjectDescriptor> getProjectDescriptors() {
    return this.projectDescriptors;
  }

  @Override
  public void init(final IWorkbench workbench, final IStructuredSelection selection) {
    super.init(workbench, selection);
    this.setWindowTitle("ModelWriter Example Wizard");

    final AbstractExampleInstallerWizard.ProjectDescriptor pd0 =
        new AbstractExampleInstallerWizard.ProjectDescriptor();
    pd0.setDescription("Creates all ModelWriter example projects.");
    pd0.setName("ModelWriter Examples");
    pd0.setContentURI(CommonPlugin.resolve(URI.createURI( // full path
        "platform:/plugin/eu.modelwriter.marker.ui/examples/")));
    this.getProjectDescriptors().add(pd0);

    // final AbstractExampleInstallerWizard.ProjectDescriptor pd1 =
    // new AbstractExampleInstallerWizard.ProjectDescriptor();
    // pd1.setDescription("Creates ModelWriter Ecore example projects.");
    // pd1.setName("ModelWriter Ecore Example");
    // pd1.setContentURI(CommonPlugin.resolve(URI.createURI( // full path
    // "platform:/plugin/eu.modelwriter.marker.ui/examples/EcoreExample")));
    // this.getProjectDescriptors().add(pd1);
    //
    // final AbstractExampleInstallerWizard.ProjectDescriptor pd2 =
    // new AbstractExampleInstallerWizard.ProjectDescriptor();
    // pd2.setDescription("Creates ModelWriter Reqif example projects.");
    // pd2.setName("ModelWriter Reqif Example");
    // pd2.setContentURI(CommonPlugin.resolve(URI.createURI( // full path
    // "platform:/plugin/eu.modelwriter.marker.ui/examples/ReqifExample")));
    // this.getProjectDescriptors().add(pd2);
    //
    // final AbstractExampleInstallerWizard.ProjectDescriptor pd3 =
    // new AbstractExampleInstallerWizard.ProjectDescriptor();
    // pd3.setDescription("Creates ModelWriter Text example projects.");
    // pd3.setName("ModelWriter Text Example");
    // pd3.setContentURI(CommonPlugin.resolve(URI.createURI( // full path
    // "platform:/plugin/eu.modelwriter.marker.ui/examples/TextExample")));
    // this.getProjectDescriptors().add(pd3);

    final AbstractExampleInstallerWizard.FileToOpen fto =
        new AbstractExampleInstallerWizard.FileToOpen();
    fto.setEditorID("");
    fto.setLocation(CommonPlugin // full path
        .resolve(URI.createURI(
            "platform:/plugin/eu.modelwriter.marker.ui/src/eu/modelwriter/marker/ui/internal/wizards/examplewizard/examples/qwe.xml"))
        .toFileString());
    this.getFilesToOpen().add(fto);
  }

  @Override
  public boolean performFinish() {
    try {
      this.installProjectFromDirectory(this.getProjectDescriptors().get(0),
          new NullProgressMonitor());
    } catch (final Exception e) {
      e.printStackTrace();
    }
    return true;
  }
}
