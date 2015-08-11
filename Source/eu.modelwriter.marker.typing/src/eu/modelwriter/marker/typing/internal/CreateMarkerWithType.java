package eu.modelwriter.marker.typing.internal;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;

import eu.modelwriter.marker.internal.MarkerFactory;
import eu.modelwriter.marker.typing.alloy.AlloyParser;

public class CreateMarkerWithType {
	
	public static final String MARKER_TYPE = "MARKER_TYPE";

	public static IMarker createMarker(IResource resource, ISelection selection, String type) {
		IMarker marker = null;

		try {
		  AlloyParser ap = new AlloyParser("C:\\Users\\anil.ozturk\\Desktop\\grandpa.als");
			if (selection instanceof ITextSelection)
				marker = MarkerFactory.createMarker(resource, (ITextSelection) selection);
			else if (selection instanceof ITreeSelection)
				marker = MarkerFactory.createMarker(resource, (ITreeSelection) selection);
			
			marker.setAttribute(MARKER_TYPE, type);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return marker;
	}

}
