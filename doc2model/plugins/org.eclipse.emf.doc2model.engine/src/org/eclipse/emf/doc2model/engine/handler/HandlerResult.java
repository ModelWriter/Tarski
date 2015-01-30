package org.eclipse.emf.doc2model.engine.handler;

import java.util.List;

import org.eclipse.emf.doc2model.doc2model.Match;

public class HandlerResult {
	private Match theMatch;
	private List<String> list;

	public HandlerResult(Match match, List<String> elements) {
		theMatch = match;
		list = elements;
	}

	public Match getMatch() {
		return theMatch;
	}

	public List<String> getResult() {
		return list;
	}
}
