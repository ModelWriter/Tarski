package org.eclipse.emf.doc2model.regex.handler;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.engine.handler.URIHandler;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;
import org.eclipse.emf.doc2model.engine.utils.RegexUtils;

public class RegexHandler implements URIHandler {

	private StringBuffer wholeDocument = new StringBuffer();
	public static String ANALYSE_WHOLE_DOCUMENT = "global";
	public int cursor = -1;
	

	public List<String> handles(URI uri, Doc2ModelEngineServices services) {
		assert (uri != null && services != null && uri.scheme().equals("regex"));
		Object obj = services.get(PropertyConstants.TEXT);
		if (obj != null && obj instanceof String && ((String)obj).length() > 0)
		{
			if (cursor != services.getCountValue())
			{
				if (wholeDocument.length() != 0)
				{
					wholeDocument.append(System.getProperty("line.separator"));
				}
				wholeDocument.append(obj);
				cursor = services.getCountValue() ;
			}
		}
		String waitEndDocument = getFragment(uri);
		String string = uri.toString();
		string = string.substring(string.indexOf(":")+1,string.length());
		String regex = string ;
		if (string.contains("#"))
		{
			regex = string.substring(0,string.lastIndexOf("#"));
		}
		boolean wait = waitEndDocument != null
				&& ANALYSE_WHOLE_DOCUMENT.equals(waitEndDocument.toLowerCase()
						.trim());
		Pattern pattern = RegexUtils.INSTANCE.compile(regex);
		if (wait) {
			return manage(pattern, services, wait);
		} else if (!wait) {
			return manage(pattern, services, wait);
		}
		return null;
	}

	private String getFragment(URI uri) {
		String string = uri.toString();
		String waitEndDocument = string.substring(string.lastIndexOf("#")+1,string.length());
		return waitEndDocument;
	}

	protected List<String> manage(Pattern pattern,
			Doc2ModelEngineServices services, boolean wait) {
		String value = null;
		if (wait) {
			value = wholeDocument.toString();
		} else {
			value = (String) services.get(PropertyConstants.TEXT);
		}
		List<String> result = RegexUtils.getValuesManagingGroup(pattern.matcher(value));
		if (wait && result != null && !result.isEmpty())
		{
			wholeDocument = new StringBuffer();
		}
		return result;
	}

}
