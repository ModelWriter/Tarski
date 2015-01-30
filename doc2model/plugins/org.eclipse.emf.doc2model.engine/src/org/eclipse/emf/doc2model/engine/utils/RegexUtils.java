package org.eclipse.emf.doc2model.engine.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	private Map<String, Pattern> patterns = new HashMap<String, Pattern>();
	public static RegexUtils INSTANCE = new RegexUtils();

	public Pattern compile(String regex) {
		Pattern result = patterns.get(regex);
		if (result == null) {
			result = Pattern.compile(regex,Pattern.MULTILINE | Pattern.DOTALL);
			patterns.put(regex, result);
		}
		return result;
	}

	/**
	 * Return the value analyzing group from the Matcher
	 * @param m
	 * @return
	 */
	public static String getValueManagingGroup(Matcher m) {
		List<String> result = getValuesManagingGroup(m);
		if (result != null && !result.isEmpty())
		{
			return result.get(0);
		}
		return "" ;
	}
	
	/**
	 * Return the value analyzing group from the Matcher
	 * @param m
	 * @return
	 */
	public static List<String> getValuesManagingGroup(Matcher m) {
		List<String> result = new LinkedList<String>();
		if (m.matches())
		{
			if (m.groupCount() > 0) {
				for (int i = 1 ; i <= m.groupCount() ; i++)
				{
					result.add(m.group(i));
				}
			}
			else
			{
				result.add(m.group());
			}
		}
		return result;
	}
}
