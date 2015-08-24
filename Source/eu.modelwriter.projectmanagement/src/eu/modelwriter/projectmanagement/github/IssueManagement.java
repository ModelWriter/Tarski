package eu.modelwriter.projectmanagement.github;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Label;
import org.eclipse.egit.github.core.RepositoryId;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.LabelService;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.MilestoneService;

public class IssueManagement {

	public static void main(String[] args) {

	}
	
	public static Map<String, Integer> deliverables = new HashMap<String, Integer>(); 

	public static void UpdateAll() throws IOException {

		GitHubClient client = new GitHubClient();
		client.setCredentials("ferhaterata", "3140697github");

		RepositoryId repositoryId = new RepositoryId("modelwriter", "WP7");

		IssueManagement.updateTasks(client, repositoryId);
		
//		ModelWriterIssueManagement.loadDeliverableMap(client, repositoryId);
		
//		ModelWriterIssueManagement.updateDeliverables(client, repositoryId);
		

		// org.eclipse.egit.github.core.client.RequestException: Validation
		// Failed (422): Label resource with 'name' field already exists
	}


	private static void loadDeliverableMap(GitHubClient client, RepositoryId repositoryId) throws IOException {
		IssueService iService = new IssueService(client);
		for (Issue issue : iService.getIssues(repositoryId, null)) {
			deliverables.put(issue.getTitle().substring(0, issue.getTitle().indexOf(' ')), issue.getNumber());
		}
	}


	public static void updateDeliverables(GitHubClient client, RepositoryId repositoryId){
		try {
			URL url = new URL("platform:/plugin/eu.modelwriter.projectmanagement/docs/Deliverables - Changes.md");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String line;
			bufferedReader.readLine();
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				if (line.isEmpty())
					continue;
				String[] strings = line.split("\\|");
				System.out.println(strings[1].trim() + " -> " + strings[3].trim() 
													 + " -Month: " + strings[2].trim()
													 + " -Type:  " + strings[4].trim()
													 + " -Access:" + strings[5].trim()
													 + " -Leader:" + strings[6].trim());
				String oldDeliverableCode = strings[1].trim();
				String changedTitle = strings[3].trim();
				if (changedTitle.equals("DELETE")){
					IssueService iService = new IssueService(client);
					Issue issue = getIssueStartsWith(client, repositoryId, oldDeliverableCode);
					issue.setTitle("DELETED: " + issue.getTitle());
					List<Label> labels = new ArrayList<Label>();
					labels.add(getLabelByName(client, repositoryId, "invalid"));
					issue.setLabels(labels);
					issue.setState(IssueService.STATE_CLOSED);
					iService.editIssue(repositoryId, issue);
					continue;
				}
				String taskCode = "T" + changedTitle.substring(1, changedTitle.lastIndexOf('.')); //T1.2 
				String workPackage = "WP" + changedTitle.substring(1, 2); //WP1
				int milestone = Integer.parseInt(strings[2].trim().substring(2, strings[2].indexOf(']')-1));
				String body = "";
				String assignee = "";
				String type = "";
				if (strings[4].trim().equals("SW"))
					type = "Software";
				if (strings[4].trim().equals("Doc."))
					type = "Document";
				String access = strings[5].trim();//Private
				String leader = strings[6].trim(); //AIRBUS
				try {
					Issue issue = null;
					if ((oldDeliverableCode.isEmpty() || oldDeliverableCode.startsWith("NEW")) 
							&& !changedTitle.isEmpty())
					{
						issue = new Issue();
					}else
						issue = getIssueStartsWith(client, repositoryId, oldDeliverableCode);
					List<Label> labels = new ArrayList<Label>();
					labels.add(getLabelByName(client, repositoryId, leader));
					labels.add(getLabelByName(client, repositoryId, access));
					labels.add(getLabelByName(client, repositoryId, type));
					labels.add(getLabelByName(client, repositoryId, workPackage));
					labels.add(getLabelStartsWith(client, repositoryId, taskCode));
					issue.setLabels(labels);
					issue.setTitle(changedTitle);
					MilestoneService mService = new MilestoneService(client);
					issue.setMilestone(mService.getMilestone(repositoryId, milestone));
					IssueService iService = new IssueService(client);
					if ((oldDeliverableCode.isEmpty() || oldDeliverableCode.startsWith("NEW")) 
							&& !changedTitle.isEmpty())
					{
						iService.createIssue(repositoryId, issue);
					}else
						iService.editIssue(repositoryId, issue);					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTasks(GitHubClient client, RepositoryId repositoryId) {
		try {
			URL url = new URL("platform:/plugin/eu.modelwriter.projectmanagement/docs/Tasks - Changes - WP7.md");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String line;
			bufferedReader.readLine();
			bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				if (line.isEmpty())
					continue;
				String[] strings = line.split("\\|");
				System.out.println(strings[1].trim() + " -> " + strings[2].trim());
				try {
					changeLabelNameByTaskCode(client, repositoryId, strings[1].trim(), strings[2].trim());	
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void changeLabelNameByTaskCode(GitHubClient client, RepositoryId repositoryId, String taskCode, String changedName)
			throws IOException {
		LabelService lservice = new LabelService(client);
		
		if (taskCode.isEmpty() && !changedName.isEmpty())
		{
			Label label = new Label();
			label.setName(changedName);
			label.setColor("eb6420");
			lservice.createLabel(repositoryId, label);
		}
		
		for (Label label : lservice.getLabels(repositoryId)) {
			if (label.getName().startsWith(taskCode)) {
				if (changedName.equals("DELETE")) {
					lservice.deleteLabel(repositoryId, label.getName().replace(" ", "%20"));
					break;
				}
				changeLabelName(client, repositoryId, label.getName(), changedName);
				break;
			}
		}
	}

	private static Label getLabelByName(GitHubClient client, RepositoryId repositoryId, String labelName) throws IOException{
		LabelService lservice = new LabelService(client);
		return lservice.getLabel(repositoryId, labelName.replace(" ", "%20"));
	}
	
	private static Label getLabelStartsWith(GitHubClient client, RepositoryId repositoryId, String startsWith) throws IOException{
		LabelService lservice = new LabelService(client);
		for (Label label : lservice.getLabels(repositoryId)) {
			if (label.getName().startsWith(startsWith)) {
				return label;
			}
		}
		return null;
	}
	
	private static Issue getIssueStartsWith(GitHubClient client, RepositoryId repositoryId, String startsWith) throws IOException{
		IssueService iService = new IssueService(client);
		if (deliverables.containsKey(startsWith))
			return iService.getIssue(repositoryId, deliverables.get(startsWith));
		else
			return null;
	}
	
	public static void changeLabelName(GitHubClient client, RepositoryId repositoryId, String labelName, String changedName)
			throws IOException {
		LabelService lservice = new LabelService(client);
		IssueService iservice = new IssueService(client);

		Label label = lservice.getLabel(repositoryId, labelName.replace(" ", "%20"));
		System.out.println(label.getName());

		// Create the label with the changed name
		Label changedLabel = new Label();
		changedLabel.setName(changedName);
		changedLabel.setColor(label.getColor());
		changedLabel = lservice.createLabel(repositoryId, changedLabel);

		// find issues with the existing label
		Map<String, String> filterData = new HashMap<String, String>();
		filterData.put(IssueService.FILTER_LABELS, label.getName());
		List<Issue> issues = iservice.getIssues(repositoryId, filterData);

		// label each issue with the changed label
		for (Issue issue : issues) {
			System.out.println(issue.getTitle());
			List<Label> labels = issue.getLabels();
			// delete the existing label
			for (Iterator<Label> iter = labels.listIterator(); iter.hasNext();) {
				Label l = iter.next();
				if (l.getName().equals(labelName))
					iter.remove();
			}
			// add the new changed label
			labels.add(changedLabel);
			issue.setLabels(labels);
			iservice.editIssue(repositoryId, issue);
			System.out.println(labels.toString());
		}
		// delete the existing label
		lservice.deleteLabel(repositoryId, labelName.replace(" ", "%20"));
	}

}
