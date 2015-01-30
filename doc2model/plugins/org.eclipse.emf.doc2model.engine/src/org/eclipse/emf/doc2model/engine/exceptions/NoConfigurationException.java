package org.eclipse.emf.doc2model.engine.exceptions;

public class NoConfigurationException extends Exception {
	public NoConfigurationException() {
		super("configuration is necessary to generate");
	}
}
