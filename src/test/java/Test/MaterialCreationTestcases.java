package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class MaterialCreationTestcases extends BasePage {


	/**
	 * 1
	 *  To verify that defaults are working in the transaction screen(header, grids)according to the user configured
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-100/QAA-TC-101/QAA-TC-102/QAA-TC-104/QAA-TC-106/QAA-TC-107/QAA-TC-113/QAA-TC-152/QAA-TC-256");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
	}
	/**
	 * 2
	 *  Creation: To verify that created record is visible at reviewer's task list
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Created_Record_Is_Visible_At_Reviewer_Task_List(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-114");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().materialMaster().claimStatus();
	}
	/**
	 * 3
	 *  Creation: Data verification for reviewer at transaction screen
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Data_Verification_For_Reviewer_At_Transaction_Screen(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-115/QAA-TC-116");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatus();
	}
	/**
	 * 4
	 *  Creation: Rejecting the request from Approver
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Rejecting_The_Request_From_Approver(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-117");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().materialMaster().rejectionFlowFromApprover();
	}

	/**
	 * 5
	 *  Creation: Approving the request from approver
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Approving_The_Request_From_Approver(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-119");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().materialCreation().verifying_Data_On_Approve_Transaction_Screen();
	}

	/**
	 * 6
	 *  Extend : Extend Plant hierarchy from the created record which is in system status
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Extend_Plant_Hierarchy_From_The_Created_Record_Which_Is_In_System_Status(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-139");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().materialCreation().verify_Created_Record_Which_Is_In_System_Status();
	}

	/**
	 * 7
	 *  Extend:Checking mandatory fields error on the execution page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Checking_Mandatory_Fields_Error_On_The_Execution_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-141");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().materialCreation().verify_Mandatory_Field_On_Execution_Page_At_Edit_Time();
	}

	/**
	 * 8
	 *  Extend : To verify that user is able to save the record with the extension process
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_User_Is_Able_To_Save_The_Record_With_The_Extension_Process(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-142");
		verify_Checking_Mandatory_Fields_Error_On_The_Execution_Page(env);
		objectService().materialCreation().verify_User_Is_Able_To_Save_The_Record_With_The_Extension_Process();
	}

	/**
	 * 9
	 *  Extend:Reviewer task list checks
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Reviewer_Task_List_Checks(String env) throws Exception {
		log("Testcase:QAA-TC-143/QAA-TC-144/QAA-TC-145");
		verify_That_User_Is_Able_To_Save_The_Record_With_The_Extension_Process(env);
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatus();
	}

	/**
	 * 10
	 * verify that based on the configured rule for description generator, short and long description should auto populate while generating description
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Based_On_The_Configured_Rule_For_Description_Generator_Short_And_Long_Description_Should_Auto_Populate(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-110/QAA-TC-150");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_Description_Generator_Short_And_Long_Description_Should_Auto_Populate();
	}

	/**
	 * 11
	 * verify that after generating description, langauge grid and PO text grid should be auto-populated as per configured description rule and with all languages
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_After_Generating_Description_Language_Grid_And_PO_Text_Grid_Should_Be_Auto_Populated(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-111");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_Description_Generator_Language_Grid_And_PO_Text_Grid_Should_Be_Auto_Populate();
	}

	/**
	 * 12
	 * Creation: Reapproving rejected task from Initiator
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Reapproving_Rejected_Task_From_Initiator(String env) throws Exception {
		log("Testcase:Reapproving rejected task from Initiator: QAA-TC-118");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().rejectionFlowFromApprover();
		objectService().materialMaster().reApprove_Rejected_Task_Status();
	}
	/**
	 * 13
	 * Extend: Reapproving rejected task from Initiator & from final approval step
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void reApproving_Rejected_Task_From_Initiator_And_From_Final_Approval_Step(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-147");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().rejectionFlowFromReviewer();
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().reApprove_Rejected_Task_Status_With_Extend_Plant_Data();
	}

	/**
	 * 14
	 * verify that user should be able to extend multiple similar child hierarchies at the same time
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_User_Should_Be_Able_To_Extend_Multiple_Similar_Child_Hierarchies_At_The_Same_Time(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-149");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		objectService().materialCreation().verify_Able_To_Extend_Multiple_Similar_Child_Hierarchies_At_The_Same_Time();
	}

	/**
	 * 15
	 * Verify that after submitting the record post record saving functionality will be working
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_After_Submitting_The_Record_Post_Record_Saving_Functionality_Will_Be_Working(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-151");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialCreation().verify_Description_For_Newly_Created_Record_on_Summary_Page();
	}
}
