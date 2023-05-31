package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class MaterialCreationTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 *  To verify that defaults are working in the transaction screen(header, grids)according to the user configured
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void  verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8375/MDMF-TC-8376/MDMF-TC-8377/MDMF-TC-8379/MDMF-TC-8384/MDMF-TC-8385/MDMF-TC-8391");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();

	}
	/**
	 *  Creation: To verify that created record is visible at reviewer's task list
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Created_Record_Is_Visible_At_Reviewer_Task_List(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8392");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		materialmaster.claimStatus();
	}
	/**
	 *  Creation: Data verification for reviewer at transaction screen
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Data_Verification_For_Reviewer_At_Transaction_Screen(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8393/MDMF-TC-8394");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		loginPage.revSignIn(env);
		materialmaster.approveStatus();
	}
	/**
	 *  Creation: Rejecting the request from Approver
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Rejecting_The_Request_From_Approver(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8395");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		materialmaster.rejectionFlowFromApprover();
	}

	/**
	 *  Creation: Approving the request from approver
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Approving_The_Request_From_Approver(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8397");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		materialCreation.verifying_Data_On_Approve_Transaction_Screen();
	}

	/**
	 *  Extend : Extend Plant hierarchy from the created record which is in system status
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Extend_Plant_Hierarchy_From_The_Created_Record_Which_Is_In_System_Status(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8429");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		materialCreation.verify_Created_Record_Which_Is_In_System_Status();
	}

	/**
	 *  Extend:Checking mandatory fields error on the execution page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Checking_Mandatory_Fields_Error_On_The_Execution_Page(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8431");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		materialCreation.verify_Mandatory_Field_On_Execution_Page_At_Edit_Time();
	}
}
