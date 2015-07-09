package eu.modelwriter.writer.markers.wizards.internal;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.Wizard;

public class MappingWizard extends Wizard {

	protected MarkerMatchPage page;
	
	public MappingWizard() {
		super();
		/*IWorkspace workSpace = ResourcesPlugin.getWorkspace();
		IProject [] projects = workSpace.getRoot().getProjects();
		
		for (IProject iProject : projects) {
			List<IMarker> markers = MarkerFactory.findAllMarkers(iProject);
			for (IMarker iMarker : markers) {
				try {
					System.out.println(iMarker.getAttribute(IMarker.MESSAGE));
					System.out.println(iMarker.getResource().getName());
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
		
		return "Mapping Markers";
	}
	
	@Override
	public void addPages() {
		
		page = new MarkerMatchPage();
		super.addPages();
	}
	
	@Override
	public boolean performFinish() {
		
		return true;
	}

}
