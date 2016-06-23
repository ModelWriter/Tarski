package eu.modelwriter.traceability.validation.editor.base;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class ValidationWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
