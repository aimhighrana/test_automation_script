package Test;

import java.io.IOException;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTestcases extends BasePage {

	/**
	 * Login Module
	 * 
	 * @throws IOException
	 */
	@Test
	@Parameters({ "env", "testCaseId" })
	public void loginPage(String env, String testCaseId) throws InterruptedException, IOException, Exception {
		log("Testcase:" + testCaseId);		
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
	}
	
}
