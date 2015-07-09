package eu.modelwriter.writer.markers.hyperlinkdetectors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class PreferencesHyperlink implements IHyperlink {

	private final IRegion fUrlRegion;

	public PreferencesHyperlink(IRegion urlRegion) {
		fUrlRegion = urlRegion;
	}

	@Override
	public IRegion getHyperlinkRegion() {
		return fUrlRegion;
	}

	@Override
	public String getTypeLabel() {
		return null;
	}

	@Override
	public String getHyperlinkText() {
		return "Open Mapped Element";
	}

	@Override
	public void open() {
		PreferencesUtil.createPreferenceDialogOn(Display.getDefault().getActiveShell(), null, null, null).open();
	}
}
