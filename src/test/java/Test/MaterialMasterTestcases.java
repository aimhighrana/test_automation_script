package Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import Page.LoginPage;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	public void addNewMaterialMaster() throws InterruptedException, IOException {
		common.log("TC:Add new material master record");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.addNewMaterialMaster();

	}

	/**
	 * View Process-log Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void viewProcessLog() throws InterruptedException, IOException {
		common.log("TC:Add new material master record and check process log");
		loginPage.goToURL();
		loginPage.check_SignIn();
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
	public void verifyApproveStatus() throws InterruptedException, IOException {
		common.log("TC:Add new material master record and approve from Reviewer side");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn();
		materialmaster.approveStatus();

	}

	/**
	 * claim status
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyClaimStatus() throws InterruptedException, IOException {
		common.log("TC:Add new material master record and Claim status from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn();
		materialmaster.claimStatus();

	}

	/**
	 * Verification of save as draft feature
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifySaveAsDraft() {
		common.log("TC:Add new material master record and Verify save as draft from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		loginPage.revSignIn();
		materialmaster.saveDraft();
		

	}

	/**
	 * Change record
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyChange() {
		common.log("TC:Verify edit and update existing record");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.doUpdate();

	}

	/**
	 * copy record
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyCopyRecord() {
		common.log("TC:Verify copy existing record");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.copyRecord();
		

	}

	/**
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void addNewMaterialMasterWithGenerateDescription() throws InterruptedException, IOException {
		common.log("TC:Add new material master record with description");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.createMaterialMasterWithGenerateDesc();
		

	}

	/**
	 * claim & unclaim status
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyClaimUnClaimStatus() throws InterruptedException, IOException {
		common.log("TC:Add new material master record and Verify un-claim status from reviewer");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterCompletedProcessLog();
		loginPage.revSignIn();
		materialmaster.claimUnclaimStatus();
		

	}
	/**
	 * Verification of rejection Flow feature
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyRejectionFlowForNewRrecord() {
		common.log("TC:Add new material master record and Reject the flow from Approver and Reviewer side");
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.addNewMaterialMaster();
		materialmaster.viewMaterialMasterProcessLog();
		materialmaster.rejectionFlowFromApprover();
		loginPage.revSignIn();
		materialmaster.rejectionFlowFromReviewer();
	}

	/**
	 * Verify Draft Approval Record Process Scenario
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void verifyDraftApprovalRecord() throws InterruptedException, IOException {

		verifyClaimUnClaimStatus();
		driver.quit();

	}

}
