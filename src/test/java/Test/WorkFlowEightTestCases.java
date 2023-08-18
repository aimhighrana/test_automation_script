package Test;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utils.BasePage;

public class WorkFlowEightTestCases extends BasePage {
	
	/**
	 * 8
	 * Create Functional Location
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verifying_Functional_Location_Creation_WorkFlow_8(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:Workflow 1 Test cases");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().workFlowEight().verify_Functional_Location_is_Created();


	}

}
