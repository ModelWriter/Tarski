package eu.modelwriter.writer.markers.wizards.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MarkerMatchPage extends WizardPage {

	public CheckboxTreeViewer markTreeViewer = null;

	public MarkerMatchPage() {

		super("Mapping Markers");
		setTitle("Map Markers");
	}

	@Override
	public void createControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		// Add a checkbox to toggle whether the labels preserve case
		Button preserveCase = new Button(composite, SWT.CHECK);
		preserveCase.setText("&Preserve case");

		markTreeViewer = new CheckboxTreeViewer(composite);
		markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

		markTreeViewer.setLabelProvider(new WizardTreeViewLabelProvider());
		markTreeViewer.setContentProvider(new WizardTreeViewContentProvider());
		markTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());

		// When user checks the checkbox, toggle the preserve case attribute
		// of the label provider
		preserveCase.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				boolean preserveCase = ((Button) event.widget).getSelection();
				WizardTreeViewLabelProvider ftlp = (WizardTreeViewLabelProvider) markTreeViewer.getLabelProvider();
				ftlp.setPreserveCase(preserveCase);
			}
		});

		// When user checks a checkbox in the tree, check all its children
		markTreeViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				// If the item is checked . . .
				if (event.getChecked()) {
					// . . . check all its children
					markTreeViewer.setSubtreeChecked(event.getElement(), true);
					Object[] obje = markTreeViewer.getCheckedElements();
					for (Object object : obje) {
						if (object instanceof IMarker) {
							setPageComplete(true);
							break;
						}
					}
				} else {
					Object[] obje = markTreeViewer.getCheckedElements();
					Boolean flag = false;
					for (Object object : obje) {
						if (object instanceof IMarker) {
							flag = true;
							break;
						}
					}
					if (flag != true)
						setPageComplete(false);
				}
			}
		});
		setControl(composite);
		setPageComplete(false);

	}

}
