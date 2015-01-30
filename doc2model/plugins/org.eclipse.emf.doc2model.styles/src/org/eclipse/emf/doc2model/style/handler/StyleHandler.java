package org.eclipse.emf.doc2model.style.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.engine.handler.URIHandler;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;

public class StyleHandler implements URIHandler {

	public List<String> handles(URI uri, Doc2ModelEngineServices services) {
		assert(uri != null && services != null && uri.scheme().equals("style")) ;
		List<String> result = new ArrayList<String>(1);
		String style = uri.opaquePart();
		Object currentStyle = services.get(PropertyConstants.STYLE);
		if (currentStyle instanceof String) {
			String currentStringStyle = (String) currentStyle;
			currentStringStyle = currentStringStyle.replace(" ", "");
			if (style != null && style.equals(currentStringStyle)) {
				Object textObject = services.get(PropertyConstants.TEXT);
				if (textObject instanceof String) {
					String text = (String) textObject;
					result.add(text);
				}
			}
		}
		return result;
	}
}
