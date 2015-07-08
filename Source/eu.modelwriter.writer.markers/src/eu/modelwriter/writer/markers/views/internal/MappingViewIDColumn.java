package eu.modelwriter.writer.markers.views.internal;

public class MappingViewIDColumn extends MappingViewColumn {

	@Override
	public String getText(Object element) {
		// if (element instanceof MappedMark) {
		// return ((MappedMark) element).getID();
		// } else {
		// return "";
		// }
		return "";
	}

	@Override
	public String getTitle() {
		return "ID";
	}

}
