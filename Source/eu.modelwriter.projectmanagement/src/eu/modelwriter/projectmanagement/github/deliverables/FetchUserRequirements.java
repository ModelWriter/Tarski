package eu.modelwriter.projectmanagement.github.deliverables;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.jface.operation.IRunnableWithProgress;

import eu.modelwriter.projectmanagement.github.Constants;

public class FetchUserRequirements implements IRunnableWithProgress {

	private static FetchUserRequirements instance = null;

	protected FetchUserRequirements() {
		client = new GitHubClient();
		client.setCredentials(Constants.USERNAME, Constants.PASSWORD);

		repositoryId = new RepositoryId(Constants.ORGANIZATION, Constants.REPOSITORY);
	}
	
	public static FetchUserRequirements getInstance() {
		if (instance == null) {
			instance = new FetchUserRequirements();
		}
		return instance;
	}
	
	private GitHubClient client = null;
	
	public GitHubClient getClient() {
		return client;
	}
	private RepositoryId repositoryId = null;
	
	public RepositoryId getRepositoryId() {
		return repositoryId;
	}
	
	private List<Issue> issues = null;

	public List<Issue> getIssues() {
		return issues;
	}

	private List<Issue> loadRequirements() throws IOException {
		Map<String, String> filderdata = new HashMap<String, String>();
		filderdata.put(IssueService.FILTER_LABELS, "User Requirements Document (URD)");
		IssueService iService = new IssueService(client);
		return iService.getIssues(repositoryId, filderdata);
	}

    @Override
    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
        int totalUnitsOfWork = IProgressMonitor.UNKNOWN;
        monitor.beginTask("Performing read. Please wait...", totalUnitsOfWork);
        // This only performs the tasks
		try {
			client.setCredentials(Constants.USERNAME, Constants.PASSWORD);
			System.out.println(getClient().getUser());
			issues = loadRequirements();
		} catch (IOException e) {
			e.printStackTrace();
		}
        monitor.done();
    }

}
