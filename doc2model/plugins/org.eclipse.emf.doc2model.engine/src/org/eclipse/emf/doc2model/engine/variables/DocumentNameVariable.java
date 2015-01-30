package org.eclipse.emf.doc2model.engine.variables;

import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.engine.contracts.VariableResolver;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;

public class DocumentNameVariable implements VariableResolver {

	public String getValue(Doc2ModelEngineServices service) {
		return (String) service.get(PropertyConstants.DOCUMENT_NAME);
	}

}
