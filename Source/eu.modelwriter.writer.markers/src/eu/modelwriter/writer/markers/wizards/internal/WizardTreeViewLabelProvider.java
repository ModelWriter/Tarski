package eu.modelwriter.writer.markers.wizards.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;

public class WizardTreeViewLabelProvider extends LabelProvider {
	
	 // Label provider state: preserve case of file names/directories
	  boolean preserveCase;
	// The listeners
	  private List listeners = new ArrayList();
	@Override
	public String getText(Object element) {
		
		if (element instanceof IResource){
			return ((IResource) element).getName();
		}
		else if (element instanceof IMarker){
			return ((IMarker) element).MESSAGE;
		}
		else{
			return "Unknown type: " + element.getClass();
		}
		
	}
	 /**
	   * Sets the preserve case attribute
	   * 
	   * @param preserveCase
	   *            the preserve case attribute
	   */
	  public void setPreserveCase(boolean preserveCase) {
	    this.preserveCase = preserveCase;

	    // Since this attribute affects how the labels are computed,
	    // notify all the listeners of the change.
	    LabelProviderChangedEvent event = new LabelProviderChangedEvent(this);
	    for (int i = 0, n = listeners.size(); i < n; i++) {
	      ILabelProviderListener ilpl = (ILabelProviderListener) listeners
	          .get(i);
	      ilpl.labelProviderChanged(event);
	    }
	  }
	
}
