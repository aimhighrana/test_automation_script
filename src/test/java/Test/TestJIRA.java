package Test;

import java.text.Format.Field;

import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.Issue.FluentCreate;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class TestJIRA {

//	@Test
//	public void Test_Jira() {
//		BasicCredentials creds = new BasicCredentials("rahul.sharma@prospecta.com", "mhOmIVBUNB4TOAy43bJIE1D1");
//		JiraClient jira = new JiraClient("https://prospectasoftware.atlassian.net/", creds);
//
//		System.out.println(creds.toString());
//		System.out.println(jira.toString());
//		try {
//
//			Issue issue = jira.getIssue("ITSM-7787");
//
//			System.out.println(issue);
//
//			System.out.println(issue.getKey());
//
////            Issue newIssue = jira.createIssue("IT Service Management (ITSM)", "New Implementation")
////                    .field(Field.SUMMARY, "Creating issue with automation")
////                    .field(Field.DESCRIPTION, "Testing automation with jira integration")
////                    .field(Field.REPORTER, "Rahul Sharma")
/////                   .field(Field.ASSIGNEE, "rahul")
////                    .execute();
////            System.out.println(newIssue);
//
//		} catch (JiraException ex) {
//			System.err.println(ex.getMessage());
//
//			if (ex.getCause() != null)
//				System.err.println(ex.getCause().getMessage());
//		}
//
//	}

	BasicCredentials creds = new BasicCredentials("rahul.sharma@prospecta.com", "mhOmIVBUNB4TOAy43bJIE1D1");
	JiraClient jira = new JiraClient("https://prospectasoftware.atlassian.net/", creds);

	public void createNewJiraIssue(String projectName, String defectType, String defectSummary,
			String defectDescription) {
		try {
//			if (result.getStatus() == ITestResult.FAILURE) {

			/* Create new issue */

			Issue newIssue = jira.createIssue(projectName, "IT Service Management (ITSM)")
					.field(defectType, "New Implementation").field(defectSummary, "Creating issue with automation")
					.field(defectDescription, "jira integrations")
//                    .field(Field.SUMMARY, "Creating issue with automation")
//                    .field(Field.DESCRIPTION, "Testing automation with jira integration")
//                    .field(Field.REPORTER, "Rahul Sharma")
////                    .field(Field.ASSIGNEE, "rahul")
					.execute();
			System.out.println(newIssue);

//			}
		} catch (JiraException ex) {
			System.err.println(ex.getMessage());

			if (ex.getCause() != null)
				System.err.println(ex.getCause().getMessage());
		}
	}

}
