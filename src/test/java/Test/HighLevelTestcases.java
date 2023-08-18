package Test;

import Utils.BasePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class HighLevelTestcases extends BasePage {

	/**
	 * 1
	 * verifying Material Master Creation WorkFlow 1
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verifying_Material_Master_Creation_WorkFlow_1(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Workflow 1 Test cases");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().addNewMaterialMaster();
		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatus();
		objectService().loginPage().approver_SignIn();
		objectService().materialMaster().approveMaterialCreationByApprover();
		objectService().materialMaster().viewMaterialMasterProcessLog();
	}
	/**
	 * 2
	 * verifying Material Creation Default Values WorkFlow 3
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verifying_Material_Creation_Default_Values_WorkFlow_3(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Workflow 3 Test cases");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialMaster().verifyDefaultValuesOnSequentialFlow();
		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().loginPage().reviewer_SignIn();
		objectService().materialMaster().approveStatusByReviewerWorkFlow3();
		objectService().materialMaster().viewMaterialMasterProcessLog();
		objectService().loginPage().approver_SignIn();
		objectService().materialMaster().approveMaterialCreationByApprover();
		objectService().materialMaster().viewMaterialMasterProcessLog();
	}
}
