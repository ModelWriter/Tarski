package eu.modelwriter.marker.ui.internal.wizards.examplewizard;

import org.eclipse.emf.common.ui.wizard.AbstractExampleInstallerWizard;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

public class NewModelWriterExampleWizardPage extends AbstractExampleInstallerWizard.ProjectPage {
  Composite container;

  public NewModelWriterExampleWizardPage(
      final AbstractExampleInstallerWizard abstractExampleInstallerWizard, final String pageName,
      final String title, final ImageDescriptor titleImage) {
    abstractExampleInstallerWizard.super(pageName, title, titleImage);
  }

  /**
   * Create contents of the wizard.
   *
   * @param parent
   */
  @Override
  public void createControl(final Composite parent) {
    super.createControl(parent);
  }

  public List getProjectList() {
    this.projectList = new org.eclipse.swt.widgets.List(this.container, 0);
    return this.projectList;
  }
}
