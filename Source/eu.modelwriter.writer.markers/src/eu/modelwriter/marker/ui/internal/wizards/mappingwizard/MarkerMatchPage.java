package eu.modelwriter.marker.ui.internal.wizards.mappingwizard;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeViewerListener;
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

public class MarkerMatchPage extends WizardPage {

  public CheckboxTreeViewer markTreeViewer = null;
  public static ArrayList<MarkElement> checkedElements = new ArrayList<MarkElement>();

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
    preserveCase.setText("&Show only files that contain Marker(s)");

    markTreeViewer = new CheckboxTreeViewer(composite);
    markTreeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));

    WizardTreeViewContentProvider treeViewerContentProvider = new WizardTreeViewContentProvider();

    // DecoratingLabelProvider decorator = new DecoratingLabelProvider(new
    // WizardTreeViewLabelProvider(), null);
    // markTreeViewer.setLabelProvider(decorator);
    markTreeViewer.setLabelProvider(new WizardTreeViewLabelProvider());
    markTreeViewer.setContentProvider(treeViewerContentProvider);
    ViewerFilter[] filter = new ViewerFilter[] {new WizardTreeViewFilter()};
    markTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot().getProjects());

    // When user checks the checkbox, toggle the preserve case attribute
    // of the label provider
    // preserveCase.addSelectionListener(new SelectionAdapter() {
    // public void widgetSelected(SelectionEvent event) {
    // boolean preserveCase = ((Button) event.widget).getSelection();
    // WizardTreeViewLabelProvider ftlp = (WizardTreeViewLabelProvider)
    // markTreeViewer
    // .getLabelProvider();
    // ftlp.setPreserveCase(preserveCase);
    // }
    // });

//    preserveCase.addSelectionListener(new SelectionAdapter() {
//      public void widgetSelected(SelectionEvent event) {
//        boolean preserveCase = ((Button) event.widget).getSelection();
//
//        if (preserveCase) {
//          markTreeViewer.expandAll();
//          checkedElements = markTreeViewer.getCheckedElements();
//          markTreeViewer.setFilters(filter);
//          markTreeViewer.expandAll();
//          markTreeViewer.setCheckedElements(checkedElements);
//          markTreeViewer.collapseAll();
//        } else {
//          markTreeViewer.expandAll();
//          checkedElements = markTreeViewer.getCheckedElements();
//          markTreeViewer.resetFilters();
//          markTreeViewer.expandAll();
//          markTreeViewer.setCheckedElements(checkedElements);
//          markTreeViewer.collapseAll();
//        }
//
//      }
//    });
    
    if (MappingWizard.checkTargetMarkElements.size() != 0){
      for (MarkElement checkedMarkElement : MappingWizard.checkTargetMarkElements) {
        markTreeViewer.setChecked(MarkElement.getMarker(checkedMarkElement), true);
      }
    }
    
    preserveCase.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent event) {
        boolean preserveCase = ((Button) event.widget).getSelection();

        if (preserveCase) {
          markTreeViewer.setFilters(filter);
          if (MappingWizard.checkTargetMarkElements.size() != 0){
            for (MarkElement checkedMarkElement : MappingWizard.checkTargetMarkElements) {
              markTreeViewer.setChecked(MarkElement.getMarker(checkedMarkElement), true);
            }
          }
        } else {
          markTreeViewer.resetFilters();
          if (MappingWizard.checkTargetMarkElements.size() != 0){
            for (MarkElement checkedMarkElement : MappingWizard.checkTargetMarkElements) {
              markTreeViewer.setChecked(MarkElement.getMarker(checkedMarkElement), true);
            }
          }
        }

      }
    });
     
    markTreeViewer.addTreeListener(new ITreeViewerListener() {
      
      @Override
      public void treeExpanded(TreeExpansionEvent event) {
        
        final Object element = event.getElement();
        final Object[] children = treeViewerContentProvider.getChildren(element);
        for (Object child : children) {
     
          for (MarkElement markElement : MappingWizard.checkTargetMarkElements) {
            try {
              if (child instanceof IMarker && markElement.getId()
                  .equals(((IMarker) child).getAttribute(IMarker.SOURCE_ID))) {
                markTreeViewer.setChecked(child, true);
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
        // TODO Auto-generated method stub
        
      }
    });

    /*
     * TreeItem[] treeItems = markTreeViewer.getTree().getItems();
     * 
     * Control[] control = markTreeViewer.getTree().getChildren();
     * 
     * if (MappingWizard.checkTargetMarkElements != null) { for (TreeItem treeItem : treeItems) {
     * Object object = treeItem.getData(); if (object instanceof IMarker) { for (MarkElement
     * markElement : MappingWizard.checkTargetMarkElements) try { if
     * (markElement.getId().equals(((IMarker) object).getAttribute(IMarker.SOURCE_ID))) {
     * markTreeViewer.setChecked(object, true); } } catch (CoreException e) { // TODO Auto-generated
     * catch block e.printStackTrace(); } }
     * 
     * } }
     */

//    if (MappingWizard.checkTargetMarkElements != null) {
//      markTreeViewer.expandAll();
//
//      for (MarkElement checkedMarkElement : MappingWizard.checkTargetMarkElements) {
//        markTreeViewer.setChecked(MarkElement.getMarker(checkedMarkElement), true);
//      }
//      markTreeViewer.collapseAll();
//
//    }

    // Object[] expandElements = markTreeViewer.getExpandedElements();
    //
    // for (Object object : expandElements) {
    // if (object instanceof IFile
    // && treeViewerContentProvider.getChildren((IFile) object).length != 0) {
    // Object[] markers = treeViewerContentProvider.getChildren((IFile) object);
    // for (Object marker : markers) {
    // for (MarkElement checkedMarker : MappingWizard.checkTargetMarkElements) {
    // try {
    // if (((IMarker) marker).getAttribute(IMarker.SOURCE_ID)
    // .equals(checkedMarker.getId())) {
    // markTreeViewer.setChecked(marker, true);
    // break;
    // }
    // } catch (CoreException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // }
    //
    // }
    // }



//     if (MappingWizard.checkTargetMarkElements != null) {
//     markTreeViewer.addTreeListener(new ITreeViewerListener() {
//    
//     @Override
//     public void treeCollapsed(TreeExpansionEvent event) {}
//    
//     @Override
//     public void treeExpanded(TreeExpansionEvent event) {
//     markTreeViewer.expandAll();
//     final Object element = event.getElement();
//     final Object[] children = treeViewerContentProvider.getChildren(element);
//     for (Object child : children) {
//    
//     for (MarkElement markElement : MappingWizard.checkTargetMarkElements) {
//     try {
//     if (child instanceof IMarker && markElement.getId()
//     .equals(((IMarker) child).getAttribute(IMarker.SOURCE_ID))) {
//     markTreeViewer.setChecked(child, true);
//     }
//     } catch (CoreException e) {
//     // TODO Auto-generated catch block
//     e.printStackTrace();
//     }
//     }
//     }
//    
//     }
//    
//     });
//     }

    // When user checks a checkbox in the tree, check all its children
    setPageComplete(false);
    markTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(CheckStateChangedEvent event) {
        // If the item is checked . . .
        if (event.getChecked()) {
          // . . . check all its children
          if ((event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()))
            return;
          markTreeViewer.setSubtreeChecked(event.getElement(), true);
          
          if (event.getElement() instanceof IMarker){
            IMarker marked = (IMarker) event.getElement();
            MarkElement markedElement = new MarkElement(marked);
            MappingWizard.checkTargetMarkElements.add(markedElement);
            checkedElements.add(markedElement);
          }
          setPageComplete(true);
          /*
           * Object[] obje = markTreeViewer.getCheckedElements(); for (Object object : obje) { if
           * (object instanceof IMarker) { setPageComplete(true); break; } }
           */
        } else {
          if ((event.getElement() instanceof IProject && !((IProject) event.getElement()).isOpen()))
            return;
          markTreeViewer.setSubtreeChecked(event.getElement(), false);
          
          if (event.getElement() instanceof IMarker){
            IMarker marked = (IMarker) event.getElement();
            MarkElement markedElement = new MarkElement(marked);
            checkedElements.remove(markedElement);
            Iterator<MarkElement> iter = MappingWizard.checkTargetMarkElements.iterator();
            while (iter.hasNext()) {
              Object marker = iter.next();
              if (((MarkElement)marker).getId().equals(markedElement.getId())){
                iter.remove();
              }
            }
          }
          setPageComplete(true);
          /*
           * Object[] obje = markTreeViewer.getCheckedElements(); Boolean flag = false; if
           * (obje.length == 0) flag = true; for (Object object : obje) { if (object instanceof
           * IMarker) { flag = true; break; } } if (flag != true) setPageComplete(false);
           */
        }
      }
    });
    setControl(composite);

  }

}
