package Test;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import Page.LoginPage;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class MaterialMasterTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * 1
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void add_New_Material_Master(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();

	}

	/**
	 * 2
	 * View Process-log Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void view_Process_Log(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and check process log: MDMF-TC-8405");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();

	}

	/**
	 * 3
	 * Approve request from reviewer
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Approve_Status_From_Reviewer(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and approve from Reviewer side: MDMF-TC-8401/MDMF-TC-8402");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
//		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn(env);
		materialmaster.approveStatus();

	}
	/**
	 * 4
	 * Approve request module
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Approve_Status_From_Approver(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and approve from Approver side: MDMF-TC-8404");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.approveStatus();

	}
	/**
	 * 5
	 * claim status
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Claim_Status(String env) throws InterruptedException, IOException {
		common.log("TC --MDMF-TC-8371--/MDMF-TC-8372");
		common.log("TC:Add new material master record and Claim status from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
//		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn(env);
		materialmaster.claimStatus();
	}

	/**
	 * 6
	 * Verification of save as draft feature
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Save_As_Draft(String env) {
		common.log("TC:Add new material master record and Verify save as draft from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn(env);
		materialmaster.saveDraft();
	}

	/**
	 * 7
	 * Change record
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Change(String env) {
		common.log("TC:Verify edit and update existing record: MDMF-TC-8399/MDMF-TC-8400/MDMF-TC-8403");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.doUpdate();

	}

	/**
	 * 8
	 * Verify copy record and approve from reviewer
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Copy_Record_And_Approve_From_Reviewer(String env) {
		common.log("TC:Verify copy record and approve from reviewer: MDMF-TC-8418/MDMF-TC-8419/MDMF-TC-8422/MDMF-TC-8423");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.createMaterialMasterWithGenerateDesc();
		materialmaster.copyRecord();
		loginPage.revSignIn(env);
		materialmaster.approveStatus();

	}
	/**
	 * 9
	 * Verify copy record and remove one hierarchy, Other should not remove
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Copy_Record_If_User_Remove_One_Child_Hierarchy_Other_Child_Hierarchies_Should_Not_Get_Removed(String env) {
		common.log("TC:MDMF-TC-8427/MDMF-TC-8428/MDMF-TC-8582/MDMF-TC-8699");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.createMaterialMasterWithGenerateDesc();
		materialmaster.verify_Copy_Record_And_Remove_One_Hierarchy_Other_Should_Not_Remove();


	}

	/**
	 * 10
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void add_New_Material_Master_With_Generate_Description(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record with description/MDMF-TC-6195");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.createMaterialMasterWithGenerateDesc();
	}

	/**
	 * 11
	 * claim & unclaim status
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Claim_UnClaim_Status(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and Verify un-claim status from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterCompletedProcessLog();
		loginPage.revSignIn(env);
		materialmaster.claimUnclaimStatus();
	}
	/**
	 * 12
	 * Verification of rejection Flow feature
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Rejection_Flow_For_New_Record(String env) {
		common.log("TC:Add new material master record and Reject the flow from Approver and Reviewer side");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		materialmaster.rejectionFlowFromApprover();
		loginPage.revSignIn(env);
		materialmaster.rejectionFlowFromReviewer();
	}
	/**
	 * 13
	 * Verification of rejection Flow feature for copied record
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Copy_Record_And_Rejection_Flow_For_New_Record(String env) {
		common.log("TC:Verify Copy record and Reject the flow from Approver: MDMF-TC-8424");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.copyRecord();
		materialmaster.rejectionFlowFromApprover();
	}

	/**
	 * 14
	 * Verify Draft Approval Record Process Scenario
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Draft_Approval_Record(String env) throws InterruptedException, IOException {

		verify_Claim_UnClaim_Status(env);
		driver.quit();

	}

}
