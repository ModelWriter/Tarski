package eu.modelwriter.projectmanagement.github.requirements;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
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

public class FetchUserRequirementReviewMeeting implements IRunnableWithProgress {

  private static FetchUserRequirementReviewMeeting instance = null;

  protected FetchUserRequirementReviewMeeting() {
    client = new GitHubClient();
    client.setCredentials(Constants.USERNAME, Constants.PASSWORD);

    repositoryId = new RepositoryId(Constants.ORGANIZATION, Constants.REPOSITORY);
  }

  public static FetchUserRequirementReviewMeeting getInstance() {
    if (instance == null) {
      instance = new FetchUserRequirementReviewMeeting();
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
    IssueService iService = new IssueService(client);
    Map<String, String> filderdata = new HashMap<String, String>();
    filderdata.put(IssueService.FILTER_LABELS, "User Requirements Document (URD)");
    filderdata.put(IssueService.FILTER_STATE, IssueService.STATE_OPEN);
    List<Issue> issues = iService.getIssues(repositoryId, filderdata);
    filderdata.put(IssueService.FILTER_STATE, IssueService.STATE_CLOSED);
    issues.addAll(iService.getIssues(repositoryId, filderdata));
    class IssueComparator implements Comparator<Issue> {
      @Override
      public int compare(Issue o1, Issue o2) {
        return Integer.compare(o1.getNumber(), o2.getNumber());
      }
    }
    Collections.sort(issues, new IssueComparator());
    return issues;
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
