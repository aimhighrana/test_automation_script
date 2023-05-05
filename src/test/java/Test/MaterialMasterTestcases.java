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
	 * View Process-log Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void view_Process_Log(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and check process log");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();

	}

	/**
	 * Approve request module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Approve_Status(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and approve from Reviewer side");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn(env);
		materialmaster.approveStatus();

	}

	/**
	 * claim status
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Claim_Status(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record and Claim status from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn(env);
		materialmaster.claimStatus();

	}

	/**
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
	 * Change record
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Change(String env) {
		common.log("TC:Verify edit and update existing record");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.doUpdate();

	}

	/**
	 * copy record
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Copy_Record(String env) {
		common.log("TC:Verify copy existing record");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.copyRecord();
		

	}

	/**
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void add_New_Material_Master_With_Generate_Description(String env) throws InterruptedException, IOException {
		common.log("TC:Add new material master record with description");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialmaster.createMaterialMasterWithGenerateDesc();
		

	}

	/**
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
