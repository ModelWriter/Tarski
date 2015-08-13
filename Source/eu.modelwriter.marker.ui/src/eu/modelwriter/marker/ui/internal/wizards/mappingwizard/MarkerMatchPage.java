package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.ArrayList;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import eu.modelwriter.marker.internal.MarkElement;
import org.eclipse.swt.widgets.Label;

public class MarkerMatchPage extends WizardPage {
  public static CheckboxTreeViewer markTreeViewer = null;
  // public static ArrayList<MarkElement> checkedElements;
  ArrayList<MarkElement> beforeMappingTargetMarkElements;

  public MarkerMatchPage(ArrayList<MarkElement> beforeMappingTargetMarkElements) {
    super("Mapping Markers");
    // checkedElements = new ArrayList<MarkElement>();
    this.beforeMappingTargetMarkElements = beforeMappingTargetMarkElements;
    setTitle("Map Markers");
  }

  @Override
  public void createControl(Composite parent) {

    Composite composite = new Composite(parent, SWT.NONE);
    composite.setLayout(new GridLayout(1, false));
    
    Button btnNewButton = new Button(composite, SWT.NONE);
    btnNewButton.addSelectionListener(new SelectionAdapter() {
    	@Override
    	public void widgetSelected(SelectionEvent e) {
    		RelationDialog relationDialog= new RelationDialog(getShell());
    		relationDialog.open();
    	}
    });
    btnNewButton.setText("Add Relation");
    btnNewButton.setEnabled(false);

    markTreeViewer = new CheckboxTreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    WizardTreeViewContentProvider treeViewerContentProvider = new WizardTreeViewContentProvider();

    markTreeViewer.setLabelProvider(new WizardTreeViewLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);
    ViewerFilter[] filter = new ViewerFilter[] {new WizardTreeViewFilter()};
    markTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());

    if (beforeMappingTargetMarkElements.size() != 0) {
      for (MarkElement checkedMarkElement : beforeMappingTargetMarkElements) {
        markTreeViewer.setChecked(MarkElement.getiMarker(checkedMarkElement), true);
      }
    }

    markTreeViewer.addTreeListener(new ITreeViewerListener() {


      @Override
      public void treeExpanded(TreeExpansionEvent event) {

        final Object element = event.getElement();
        final Object[] children = treeViewerContentProvider.getChildren(element);
        for (Object child : children) {

          for (MarkElement markElement : beforeMappingTargetMarkElements) {
            try {
              // if (element instanceof IProject) {
              // IResource[] projectMembers = ((IProject) element).members();
              // for (int i = 0; i < projectMembers.length; i++) {
              // if (projectMembers[i] instanceof IFolder) {
              // IResource[] folderMembers = ((IFolder) projectMembers[i]).members();
              // for (int j = 0; j < folderMembers.length; j++) {
              // if (folderMembers[j] instanceof IFile) {
              // ArrayList<IMarker> markers =
              // MarkerFactory.findMarkersAsArrayList((IFile) folderMembers[j]);
              // if (markers.size() != 0) {
              //
              // }
              // }
              // }
              // } else if (projectMembers[i] instanceof IFile) {
              // ArrayList<IMarker> markers =
              // MarkerFactory.findMarkersAsArrayList((IFile) projectMembers[i]);
              //
              // }
              // }
              // }
              if (child instanceof IMarker && markElement.getId()
                  .equals(((IMarker) child).getAttribute(IMarker.SOURCE_ID))) {
                markTreeViewer.setChecked(child, true);
                // checkedElements.add(new MarkElement((IMarker) child));
              }
            } catch (CoreException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          }
        }
      }

      @Override
      public void treeCollapsed(TreeExpansionEvent event) {

      }
    });

    // When user checks a checkbox in the tree, check all its children
    setPageComplete(false);
    markTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(CheckStateChangedEvent event) {
        if (event.getChecked()) {
          // . . . check all its children
          if ((event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()))
            return;
          markTreeViewer.setSubtreeChecked(event.getElement(), true);

        } else {
          if ((event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()))
            return;
          markTreeViewer.setSubtreeChecked(event.getElement(), false);
        }
        setPageComplete(true);
      }
    });
    markTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
        	if(((ITreeSelection)event.getSelection()).getFirstElement() instanceof IMarker)
        		btnNewButton.setEnabled(true);
        	else 
        		btnNewButton.setEnabled(false);
			
		}
	});
    setControl(composite);
    
        Button preserveCase_1 = new Button(composite, SWT.CHECK);
        preserveCase_1.setText("&Show only files that contain Marker(s)");
        
            preserveCase_1.addSelectionListener(new SelectionAdapter() {
              public void widgetSelected(SelectionEvent event) {
                boolean preserveCase = ((Button) event.widget).getSelection();
        
                if (preserveCase) {
                  markTreeViewer.setFilters(filter);
        //          if (beforeMappingTargetMarkElements.size() != 0) {
        //            for (MarkElement checkedMarkElement : beforeMappingTargetMarkElements) {
        //              markTreeViewer.setChecked(MarkElement.getiMarker(checkedMarkElement), true);
        //            }
        //          }
                } else {
                  markTreeViewer.resetFilters();
        //          if (beforeMappingTargetMarkElements.size() != 0) {
        //            for (MarkElement checkedMarkElement : beforeMappingTargetMarkElements) {
        //              markTreeViewer.setChecked(MarkElement.getiMarker(checkedMarkElement), true);
        //            }
        //          }
                }
        
              }
            });
  }
}
