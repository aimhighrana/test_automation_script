package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DuplicateRuleTestcases extends BasePage {

	/**
	 * 1
	 * Duplicate Rule - To Verify that exact match duplicacy is working
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Exact_Match_Fuzzy_Duplicacy_Is_Working(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6898/MDMF-TC-6899/MDMF-TC-6900/MDMF-TC-6901");
		log("Pre condition: Duplicate Rule must be configured");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Exact_Match_Duplicacy_Is_Working_For_Material_Creation();
	}
	/**
	 * 2
	 * Verify that duplicacy check is working at the time of copy event
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Duplicacy_Check_Is_Working_At_The_Time_Of_Copy_Event(String env) throws Exception {
		log("Testcase:MDMF-TC-6903");
		log("Pre condition: Duplicate Rule must be configured");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().duplicacy_Check_Is_Working_At_The_Time_Of_Copy_Event();

	}

	/**
	 * 3
	 * 	Verify that duplicacy check is working at the time of Change event
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Duplicacy_Check_Is_Working_At_The_Time_Of_Change_Event(String env) throws Exception {
		log("Testcase:MDMF-TC-6904");
		log("Pre condition: Duplicate Rule must be configured");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_Duplicacy_Is_Working_At_Change_Event();
	}

	/**
	 * 4
	 * 	Verify that duplicacy check is working at the time of Approval from reviewer
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Duplicacy_Check_Is_Working_At_The_Time_Of_Approval_From_Reviewer(String env) throws Exception{
		log("Testcase:MDMF-TC-6905");
		log("Pre condition: Duplicate Rule must be configured for reviewer");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialCreation().check_Duplicacy_Is_Working_At_The_Time_Of_Approval_From_Reviewer();
	}

}
