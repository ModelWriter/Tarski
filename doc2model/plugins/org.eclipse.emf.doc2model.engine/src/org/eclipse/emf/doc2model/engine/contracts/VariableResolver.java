package org.eclipse.emf.doc2model.engine.contracts;

import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;

/**
 * The Interface VariableTransformer. returns the string which will replace the
 * string declared in extension point
 */
public interface VariableResolver {
	String getValue(Doc2ModelEngineServices service);
}
