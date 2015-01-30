package org.eclipse.emf.doc2model.engine;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.doc2model.doc2model.Action;
import org.eclipse.emf.doc2model.doc2model.Configuration;
import org.eclipse.emf.doc2model.doc2model.Doc2Model;
import org.eclipse.emf.doc2model.doc2model.Match;
import org.eclipse.emf.doc2model.doc2model.Rule;
import org.eclipse.emf.doc2model.documents.IDocument;
import org.eclipse.emf.doc2model.documents.constants.OperationConstants;
import org.eclipse.emf.doc2model.documents.constants.PropertyConstants;
import org.eclipse.emf.doc2model.engine.actions.ActionParser;
import org.eclipse.emf.doc2model.engine.contracts.ProgressionObserver;
import org.eclipse.emf.doc2model.engine.exceptions.ActionException;
import org.eclipse.emf.doc2model.engine.exceptions.NoConfigurationException;
import org.eclipse.emf.doc2model.engine.handler.HandlerResult;
import org.eclipse.emf.doc2model.engine.managers.HandlerManager;
import org.eclipse.emf.doc2model.engine.selection.ContainerSelectionManager;
import org.eclipse.emf.doc2model.engine.services.Doc2ModelEngineServices;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class Doc2ModelParserTransformation {

	// OPTIONS
	public static final String OPTIONS_NO_COUNT = "no_process_for_count";
	public boolean isCounting = true;

	// FIELDS
	private final IDocument document;
	private final URI outputFolderPath;
	private final Doc2Model inputDoc2Model;
	private final Doc2ModelEngineServices services = new Doc2ModelEngineServices();
	private final ActionParser parser;
	private final HandlerManager manager;
	private final ContainerSelectionManager containerSelectionManager;
	private final Map<String, Object> options;

	/**
	 * Construct a doc2model parser transformation using an IDocument, and
	 * generate to an output folder path using the doc2model
	 * 
	 * @param document
	 * @param outputFolderPath
	 * @param inputDoc2Model
	 */
	public Doc2ModelParserTransformation(IDocument document,
			URI outputFolderPath, Doc2Model inputDoc2Model) {
		this(document, outputFolderPath, inputDoc2Model,
				new HashMap<String, Object>());
	}

	/**
	 * Construct a doc2model parser transformation using an IDocument, and
	 * generate to an output folder path using the doc2model
	 * 
	 * @param document
	 * @param outputFolderPath
	 * @param inputDoc2Model
	 * @param options
	 */
	public Doc2ModelParserTransformation(IDocument document,
			URI outputFolderPath, Doc2Model inputDoc2Model,
			Map<String, Object> options) {
		this.document = document;
		this.options = options;
		services.setDocument(document);
		this.outputFolderPath = outputFolderPath;
		this.inputDoc2Model = inputDoc2Model;
		manager = new HandlerManager(inputDoc2Model.getOwnedMatches(), services);
		containerSelectionManager = new ContainerSelectionManager();
		services.setContainerManager(containerSelectionManager);
		parser = new ActionParser(services, containerSelectionManager);
		manageOptions();
	}

	protected void manageOptions() {
		Object isCountingMap = options.get(OPTIONS_NO_COUNT);
		if (isCountingMap instanceof Boolean) {
			isCounting = (Boolean) isCountingMap;
		}

	}

	public void transform() throws NoConfigurationException {
		transform(new NullProgessionObserver());
	}

	public void transform(ProgressionObserver observer)
			throws NoConfigurationException {
		assert (observer != null);
		if (isCounting) {
			count(observer);
		}
		Resource r = initOutput();
		if (r != null && r.getContents().size() > 0) {
			containerSelectionManager.setCurrentContainer(r.getContents()
					.get(0), null);
		}
		else
		{
			containerSelectionManager.setCurrentContainer(r,null);
		}
		parse(observer);
		try {
			r.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}

	private void parse(ProgressionObserver observer) {
		boolean next = document.next();
		services.incrementCounter();
		while (next) {
			HandlerResult result = manager.handles();
			if (result != null) {
				manageHandlerResult(result);
			}
			// get the rule and create elements
			next = document.next();
			services.incrementCounter();
		}
	}

	protected void manageHandlerResult(HandlerResult result) {
		Match match = result.getMatch();
		// normally match can t be null ...
		if (match != null && result.getResult() != null) {
			Rule ruleCorrespondingToTheMatch = match.getRule();
			if (ruleCorrespondingToTheMatch == null) {
				// TODO throw
			}
			List<Action> actions = ruleCorrespondingToTheMatch.getActions();
			if (actions == null || actions.isEmpty()) {
				// TODO LOG
			} else {
				// EObject container =
				// manageSelection(ruleCorrespondingToTheMatch);
				try {
					parser.parse(actions, result.getResult(), match);
				} catch (ActionException e) {
					// TODO LOG
				}
				// a seclection is only available for one rule. As all the
				// strings
				// returned by the handlers are managed, the selection is
				// cleared
			}
		}
	}

	protected Resource initOutput() throws NoConfigurationException {
		// search in doc2model file info about extension and initialisation
		Configuration conf = inputDoc2Model.getConfiguration();
		Resource r = null;
		if (conf == null) {
			throw new NoConfigurationException();
		}
		String extension = conf.getExtension();
		if (extension != null && !extension.contains(".")) {
			extension = "." + extension;
		}
		if (extension != null && extension.length() > 0) {
			ResourceSet set = inputDoc2Model.eResource().getResourceSet();
			String output = outputFolderPath + "/"
					+ (String) document.get(PropertyConstants.DOCUMENT_NAME)
					+ extension;
			r = set.createResource(URI.createURI(output));
			if (r != null && conf.getInitialModel() != null) {
				EObject init = conf.getInitialModel().getReference();
				if (conf.getInitialModel().isCopy()) {
					init = EcoreUtil.copy(init);
				}
				r.getContents().add(init);
			} else if (inputDoc2Model.getInitialAction() != null) {
				try {
					containerSelectionManager.setCurrentContainer(r, null);
					parser.parse(Collections.singletonList(inputDoc2Model
							.getInitialAction()), null, null);
				} catch (ActionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return r;
	}

	protected void count(ProgressionObserver observer) {
		int i = 0;
		boolean next = document.next();
		while (next) {
			i++;
			next = document.next();
		}
		// in some cases the file needs to be reinit to the start
		document.call(OperationConstants.MOVE_TO_START_OPERATION);
		observer.setMax(i);
	}

	public static class NullProgessionObserver implements ProgressionObserver {
		public void worked(int i) {
		}

		public void warningOrErrorsOccurs() {
		}

		public void setMax(int max) {
		}

		public void notifyNoElementsFounded() {
		}

		public boolean isCanceled() {
			return false;
		}
	}

}
