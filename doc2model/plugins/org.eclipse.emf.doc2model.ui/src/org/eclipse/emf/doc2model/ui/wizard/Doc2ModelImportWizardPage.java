package org.eclipse.emf.doc2model.ui.wizard;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.doc2model.ui.actions.ImportJob;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

@SuppressWarnings("restriction")
public class Doc2ModelImportWizardPage extends WizardPage {
	protected String SECTION_DESCRIPTION = "fill the data in the fields to import data from document";

	protected String DESCRIPTION = "You can create a model using mapping file and documentation";

	protected String TEMPORARY_EMF_TARGET_FOLDER = "folder destination";

	protected String MAPPING_FILE = "mapping file";

	protected String DOCUMENT_NAME = "document name";

	protected FormToolkit toolkit;

	protected HashMap<String, Text> textfields = new HashMap<String, Text>();

	protected LinkedList<String> tFToSave = new LinkedList<String>();

	protected Composite top;

	protected Preferences preferences;

	protected Workbench workbench;

	protected FileFieldEditor editor;

	private Composite section;

	private Form form;

	protected ImportJob job;

	private boolean createDoc = false;

	private boolean createMapping = false;

	private boolean createTemp = false;

	protected Project currentProject = null;

	public enum BROWSER_TYPE {
		FOLDER, FILE, SAVE, PROJECT, FILE_OUT_WORKSPACE,FOLDER_OUT_WORKSPACE
	};

	protected Doc2ModelImportWizardPage(String pageName,
			Preferences thePreferences) {
		super(pageName);
		preferences = thePreferences;
		workbench = Workbench.getInstance();
		createDoc = true;
		createMapping = true;
		createTemp = true;
	}

	/**
	 * Create A Wizard Page parametring the controls to display if you don't
	 * display some controls please take care to override methods getting the
	 * value necessary for the process
	 * 
	 * @param pageName
	 * @param thePreferences
	 * @param document
	 * @param mapping
	 * @param temp
	 */
	protected Doc2ModelImportWizardPage(String pageName,
			Preferences thePreferences, boolean document, boolean mapping,
			boolean temp) {
		super(pageName);
		preferences = thePreferences;
		workbench = Workbench.getInstance();
		createDoc = document;
		createMapping = mapping;
		createTemp = temp;
	}

	public void createControl(Composite parent) {
		top = new Composite(parent, SWT.NONE);
		top.setLayout(new FillLayout());
		setImageDescriptor(workbench.getSharedImages().getImageDescriptor(
				Wizard.DEFAULT_IMAGE));
		this.setDescription(DESCRIPTION);
		toolkit = new FormToolkit(top.getDisplay());
		setForm(toolkit.createForm(top));
		// create the base form
		getForm().setText("Import Document");
		toolkit.decorateFormHeading(getForm());
		FillLayout layout = new FillLayout();
		layout.spacing = 5;
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		getForm().getBody().setLayout(layout);
		createSection();
		setControl(top);
	}

	@Override
	public void setVisible(boolean visible) {
		top.setVisible(visible);
	}

	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	public boolean isValid() {
		boolean valid = getValueForDocumentName() != null
				&& getValueForDocumentName().length() != 0
				&& getValueForMappingFile() != null
				&& getValueForMappingFile().length() != 0
				&& getValueForTemporaryFolder() != null
				&& getValueForTemporaryFolder().length() != 0;
		return valid;
	}

	public String getValueForDocumentName() {
		if (!createDoc) {
			throw new IllegalStateException(
					"Can't use this method if you don't create field for doc please override this method or change your constructor call");
		}
		return textfields.get(DOCUMENT_NAME).getText();
	}

	public String getValueForMappingFile() {
		if (!createMapping) {
			throw new IllegalStateException(
					"Can't use this method if you don't create field for doc please override this method or change your constructor call");
		}
		return textfields.get(MAPPING_FILE).getText();
	}

	public String getValueForTemporaryFolder() {
		if (!createTemp) {
			throw new IllegalStateException(
					"Can't use this method if you don't create field for doc please override this method or change your constructor call");
		}
		return textfields.get(TEMPORARY_EMF_TARGET_FOLDER).getText();
	}

	private void createSection() {
		setSection(createSection(getForm(), "Data to supply",
				getSECTION_DESCRIPTION(), 3));
		if (createDoc) {
			createRow(getSection(), getForm(), DOCUMENT_NAME,
					BROWSER_TYPE.FILE_OUT_WORKSPACE, true, null);
		}
		if (createMapping) {
			createRow(getSection(), getForm(), MAPPING_FILE, BROWSER_TYPE.FILE,
					true, new String[] { "doc2model" });
		}
		if (createTemp) {
			createRow(getSection(), getForm(), TEMPORARY_EMF_TARGET_FOLDER,
					BROWSER_TYPE.FOLDER_OUT_WORKSPACE, true, null);
		}
	}

	public void performProcess() {
		if (isValid()) {
			for (String s : textfields.keySet()) {
				if (tFToSave.contains(s)) {
					preferences.setValue(s, textfields.get(s).getText());
				}
			}
			job = new ImportJob("Import", getValueForDocumentName(),
					getValueForMappingFile(), getValueForTemporaryFolder());
			job.setUser(true);
			job.schedule();
		} else {
			setErrorMessage("Please fill all the fields");
		}
	}

	protected void createRow(String label, BROWSER_TYPE type, boolean toSave,
			String... extension) {
		createRow(getSection(), getForm(), label, type, toSave, extension);
	}

	protected void createRow(Composite section, Form mForm, final String label,
			BROWSER_TYPE type, boolean toSave, String... extension) {
		toolkit.createLabel(section, label + " : ");
		Text theText = toolkit.createText(section, "", SWT.BORDER);
		theText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		// Button buttonWSPCE = toolkit.createButton(section,
		// "browse workspace", SWT.BUTTON1);
		// buttonWSPCE.addMouseListener(new CustomMouseListener(theText, type,
		// extension));
		Button button = toolkit.createButton(section, "browse", SWT.BUTTON1);
		button.addMouseListener(new CustomMouseListener(theText, type,
				extension));
		textfields.put(label, theText);
		if (extension != null) {
			theText.addModifyListener(new ExtensionChecker(extension));
		}
		if (toSave) {
			tFToSave.add(label);
			String oldString = getPreviousValue(label);
			if (oldString != null) {
				theText.setText(oldString);
			}
		}
	}

	private String getPreviousValue(String label) {
		String value = preferences.getString(label);
		return value;
	}

	private Composite createSection(Form mform, String title, String desc,
			int numColumns) {
		Section section = toolkit.createSection(mform.getBody(),
				Section.TITLE_BAR | Section.DESCRIPTION | Section.EXPANDED);
		section.setText(title);
		section.setDescription(desc);
		// toolkit.createCompositeSeparator(section);
		Composite client = toolkit.createComposite(section);
		GridLayout layout = new GridLayout();
		layout.marginWidth = layout.marginHeight = 1;
		layout.numColumns = numColumns;
		layout.makeColumnsEqualWidth = false;
		client.setLayout(layout);
		section.setClient(client);
		return client;
	}

	public void setTEMPORARY_EMF_TARGET_FOLDER(
			String tEMPORARY_EMF_TARGET_FOLDER) {
		TEMPORARY_EMF_TARGET_FOLDER = tEMPORARY_EMF_TARGET_FOLDER;
	}

	public String getTEMPORARY_EMF_TARGET_FOLDER() {
		return TEMPORARY_EMF_TARGET_FOLDER;
	}

	public void setMAPPING_FILE(String rEQUIREMENT_MAPPING_FILE) {
		MAPPING_FILE = rEQUIREMENT_MAPPING_FILE;
	}

	public String getMAPPING_FILE() {
		return MAPPING_FILE;
	}

	public void setDOCUMENT_NAME(String dOCUMENT_NAME) {
		DOCUMENT_NAME = dOCUMENT_NAME;
	}

	public String getDOCUMENT_NAME() {
		return DOCUMENT_NAME;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String description) {
		DESCRIPTION = description;
	}

	public void setSECTION_DESCRIPTION(String sECTION_DESCRIPTION) {
		SECTION_DESCRIPTION = sECTION_DESCRIPTION;
	}

	public String getSECTION_DESCRIPTION() {
		return SECTION_DESCRIPTION;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Form getForm() {
		return form;
	}

	public void setSection(Composite section) {
		this.section = section;
	}

	public Composite getSection() {
		return section;
	}

	private class ExtensionChecker implements ModifyListener {
		private String[] extension = null;

		private boolean ok = false;

		public ExtensionChecker(String... extensions) {
			extension = extensions;
		}

		public void modifyText(ModifyEvent e) {
			if (extension != null && extension.length != 0
					&& e.getSource() instanceof Text) {
				Text t = (Text) e.getSource();
				String message = "file must end with : ";
				ok = false;
				int i = 0;
				for (String ext : extension) {
					ok = ok || t.getText().endsWith(ext);
					if (i != 0) {
						message += ", ";
					}
					message += ext;
					i++;
				}
				if (ok) {
					setErrorMessage(null);
				} else {
					setErrorMessage(message);
				}
				getWizard().getContainer().updateButtons();
			}
		}

		public boolean isOk() {
			return ok;
		}

	}

	private class CustomMouseListener extends MouseAdapter {
		Text text = null;

		BROWSER_TYPE theType;

		String[] theExtension;

		public CustomMouseListener(Text t, BROWSER_TYPE type,
				String... extension) {
			text = t;
			theType = type;
			theExtension = extension;
		}

		@Override
		public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
			int type;
			if (theType == BROWSER_TYPE.FILE) {
				type = SWT.OPEN;
				ResourceDialog dialog = new ResourceDialog(workbench
						.getDisplay().getActiveShell(), "Resource", type);
				dialog.open();
				if (dialog.getURIText() != null
						&& dialog.getURIText().length() != 0) {
					text.setText(dialog.getURIText());
				}
			} else if (theType == BROWSER_TYPE.FOLDER) {
				type = SWT.SAVE;
				DirectoryDialog dialog = new DirectoryDialog(workbench
						.getDisplay().getActiveShell(), type);
				dialog.open();
				text.setText(dialog.getFilterPath());
			} else if (theType == BROWSER_TYPE.SAVE) {
				type = SWT.SAVE;
				ResourceDialog dialog = new ResourceDialog(workbench
						.getDisplay().getActiveShell(), "Resource", type);
				dialog.open();
				if (dialog.getURIText() != null
						&& dialog.getURIText().length() != 0) {
					text.setText(dialog.getURIText());
				}
			}
			else if (theType == BROWSER_TYPE.FILE_OUT_WORKSPACE)
			{
				FileDialog dialog = new FileDialog(workbench.getDisplay().getActiveShell(),SWT.OPEN);
				String result = dialog.open() ;
				text.setText(result);
			}
			else if (theType == BROWSER_TYPE.FOLDER_OUT_WORKSPACE)
			{
				DirectoryDialog dialog = new DirectoryDialog(workbench.getDisplay().getActiveShell(),SWT.SAVE);
				String result = dialog.open() ;
				text.setText(result);
			}
			// for choosing project
			else if (theType == BROWSER_TYPE.PROJECT) {
				type = SWT.SAVE;

				WorkspaceResourceDialog dialog = new WorkspaceResourceDialog(
						workbench.getDisplay().getActiveShell(),
						new WorkbenchLabelProvider(),
						new WorkbenchContentProvider());
				dialog.setAllowMultiple(false);
				dialog.setTitle("Project Chooser");
				dialog.setMessage("Choose your target Project");
				dialog.setHelpAvailable(false);
				dialog.setShowNewFolderControl(false);
				dialog.setShowFileControl(false);
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				dialog.setValidator(new ISelectionStatusValidator() {
					public IStatus validate(Object[] selection) {
						if (selection != null && selection.length > 0) {
							if (selection[0] instanceof Project) {
								Project project = (Project) selection[0];
								if (project.isAccessible()) {
									return new Status(IStatus.OK,
											"org.eclipse.emf.common.ui", 0, "",
											null);
								}
							}
						}
						return new Status(IStatus.ERROR,
								"org.eclipse.emf.common.ui", 0, "", null);
					}
				});
				dialog.addFilter(new ViewerFilter() {
					@Override
					public boolean select(Viewer viewer, Object parentElement,
							Object element) {
						return element instanceof Project;
					}
				});
				dialog.setInitialSelection(root);
				dialog.setInput(root);
				dialog.open();
				if (dialog.getFirstResult() != null) {
					if (dialog.getFirstResult() instanceof Project) {
						currentProject = (Project) dialog.getFirstResult();
						text
								.setText(currentProject.getLocationURI()
										.toString());
					}
				}
			}
		}
	}

}
