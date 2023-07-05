package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DuplicateRuleTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

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
		common.log("TC:MDMF-TC-6898/MDMF-TC-6899/MDMF-TC-6900/MDMF-TC-6901");
		common.log("Pre condition: Duplicate Rule must be configured");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Exact_Match_Duplicacy_Is_Working_For_Material_Creation();
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
		common.log("TC:MDMF-TC-6903");
		common.log("Pre condition: Duplicate Rule must be configured");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.duplicacy_Check_Is_Working_At_The_Time_Of_Copy_Event();

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
		common.log("TC:MDMF-TC-6904");
		common.log("Pre condition: Duplicate Rule must be configured");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_Duplicacy_Is_Working_At_Change_Event();
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
		common.log("TC:MDMF-TC-6905");
		common.log("Pre condition: Duplicate Rule must be configured for reviewer");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		loginPage.revSignIn(env);
		materialCreation.check_Duplicacy_Is_Working_At_The_Time_Of_Approval_From_Reviewer();
	}

}
