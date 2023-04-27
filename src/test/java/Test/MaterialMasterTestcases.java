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
		loginPage.goToURL();
		loginPage.check_SignIn();
		materialmaster.copyrecord();
		

	}

	/**
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void addNewMaterialMasterWithGenerateDescription() throws InterruptedException, IOException {
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
