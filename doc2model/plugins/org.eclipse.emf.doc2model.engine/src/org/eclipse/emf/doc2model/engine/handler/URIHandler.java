package org.eclipse.emf.doc2model.engine.handler;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;

public interface URIHandler {

	public List<String> handles(URI uri, Doc2ModelEngineServices services);

}
