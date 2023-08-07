package Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.IOUtils;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import static io.restassured.RestAssured.when;

public class MaterialMasterTestcases extends BasePage {

	/**
	 * 1
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void add_New_Material_Master(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Add new material master record");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();

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
	public void view_Process_Log(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Add new material master record and check process log: QAA-TC-127");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().viewMaterialMasterProcessLog();

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
	public void verify_Approve_Status_From_Reviewer(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Add new material master record and approve from Reviewer side: QAA-TC-123/QAA-TC-124");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
//		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatus();

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
	public void verify_Approve_Status_From_Approver(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Add new material master record and approve from Approver side: QAA-TC-126");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().approveStatus();

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
	public void verify_Claim_Status(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:	MDMF-TC-98/QAA-TC-99");
		log("Testcase:Add new material master record and Claim status from reviewer");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
//		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().claimStatus();
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
	public void verify_Save_As_Draft(String env) throws Exception{
		log("Testcase:Add new material master record and Verify save as draft from reviewer");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().saveDraft();
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
	public void verify_Change(String env) throws Exception{
		log("Testcase:Verify edit and update existing record: QAA-TC-121/QAA-TC-122/QAA-TC-125");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().doUpdate();
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
	public void verify_Copy_Record_And_Approve_From_Reviewer(String env) throws Exception {
		log("Testcase:Verify copy record and approve from reviewer: QAA-TC-129/QAA-TC-130/QAA-TC-132/QAA-TC-133");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().createMaterialMasterWithGenerateDesc();
		objectService().materialMaster().copyRecord();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatus();
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
	public void verify_Copy_Record_If_User_Remove_One_Child_Hierarchy_Other_Child_Hierarchies_Should_Not_Get_Removed(String env) throws Exception {
		log("Testcase:QAA-TC-137/QAA-TC-138/QAA-TC-255/QAA-TC-266");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().createMaterialMasterWithGenerateDesc();
		objectService().materialMaster().verify_Copy_Record_And_Remove_One_Hierarchy_Other_Should_Not_Remove();
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
	public void add_New_Material_Master_With_Generate_Description(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Add new material master record with description/QAA-TC-32");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().createMaterialMasterWithGenerateDesc();
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
	public void verify_Claim_UnClaim_Status(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Add new material master record and Verify un-claim status from reviewer/QAA-TC-19/QAA-TC-20/MDMF-TC-21");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().viewMaterialMasterCompletedProcessLog();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().claimUnclaimStatus();
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
	public void verify_Rejection_Flow_For_New_Record(String env) throws Exception {
		log("Testcase:Add new material master record and Reject the flow from Approver and Reviewer side");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().materialMaster().rejectionFlowFromApprover();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().rejectionFlowFromReviewer();
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
	public void verify_Copy_Record_And_Rejection_Flow_For_New_Record(String env) throws Exception {
		log("Testcase:Verify Copy record and Reject the flow from Approver: QAA-TC-134");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().copyRecord();
		objectService().materialMaster().rejectionFlowFromApprover();
	}

	/**
	 * 14
	 * Copy: Reapproving rejected task from Initiator & final approver approval
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Reapproving_Rejected_Task_From_Initiator_final_Approver_Approval(String env) throws Exception{
		log("Testcase:Reapproving rejected task from Initiator & final approver approval: QAA-TC-135");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().copyRecord();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().rejectionFlowFromReviewer();
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().reApprove_Rejected_Task_Status();
	}

	/**
	 * 15
	 * Change: Verify that user is able to view the process logs & summary after final approval
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_User_Is_Able_To_View_The_Process_Logs_Summary_After_Final_Approval(String env) throws Exception {
		log("Testcase:QAA-TC-127");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatus();
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().viewMaterialMasterCompletedProcessLog();
	}

	/**
	 * 16
	 * Verify Draft Approval Record Process Scenario
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Draft_Approval_Record(String env) throws Exception {
		verify_Claim_UnClaim_Status(env);
		driver.quit();

	}
	/**
	 * Generating Material master records for QAR through the rest assured API
	 * @param env
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void Api(String env) throws InterruptedException, IOException, Exception {
		String baseUrl="https://qar.masterdataonline.com";
		String token = "";

		FileInputStream fis = new FileInputStream("/Users/qamacbookpro/Downloads/PAYLOAD_WITHOUT_ALTERNATE.txt");
		String stringTooLong = IOUtils.toString(fis, "UTF-8");
		//assertThat(stringTooLong).isNotEmpty();
		for (int i = 0;i<=15;i++) {
			RestAssured.baseURI = baseUrl;
			RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token);

			//Calling the Delete API with request body
			Response res = httpRequest.body(stringTooLong).header("Accept", ContentType.JSON.getAcceptHeader()).contentType(ContentType.JSON).post("/process/MDORest/initiate?flowId=kzFWcu2JLr8hrbB3B9n2xhAXwwEq3G2z7UKdl5OkCyG2bBlNvLzebRzW2nHanxpR");

			//Fetching the response code from the request and validating the same
			System.out.println("The response code - " + res.getStatusCode());

			System.out.println("The response message - " + res.getBody().prettyPrint());
		}
	//	Assert.assertEquals(res.getStatusCode(),200);
	}
}
