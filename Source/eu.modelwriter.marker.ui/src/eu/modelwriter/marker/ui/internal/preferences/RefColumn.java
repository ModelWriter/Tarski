package eu.modelwriter.marker.ui.internal.preferences;

public class RefColumn extends RefColumnLabelProvider {

	@Override
	public String getText(Object element) {
		
		return (String)element;
	}

	@Override
	public String getTitle() {
		
		return "References";
	}

}
