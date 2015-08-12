package eu.modelwriter.marker.ui.internal.preferences;

import eu.modelwriter.marker.ui.internal.views.mappingview.ViewColumn;

public class RefColumn extends ViewColumn {

	@Override
	public String getText(Object element) {
		
		return (String)element;
	}

	@Override
	public String getTitle() {
		
		return "Referances";
	}

}
