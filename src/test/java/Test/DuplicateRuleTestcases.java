package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DuplicateRuleTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * 1
	 * Duplicate Rule - To Verify that exact match duplicacy is working
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Exact_Match_Fuzzy_Duplicacy_Is_Working(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-6898/MDMF-TC-6899");
		common.log("Pre condition: Duplicate Rule must be configured");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Exact_Match_Duplicacy_Is_Working_For_Material_Creation();

	}

}
