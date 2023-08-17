package Test;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.BasePage;

public class Workflow11Testcases extends BasePage  {

	/**
	 * Workflow 11
	 * Material Master Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	
	@Test
	@Parameters("env")
	public void verify_creation_process_with_System_table_changes(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-ATC-1");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().workflow11().verify_creation_process_with_System_table_changes();

	}
	
	@Test
	@Parameters("env")
	public void verify_change_process_with_System_table_changes(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-ATC-1");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().workflow11().verify_change_process_with_System_table_changes();

	}
}
