package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserDefinedRuleTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * 1
	 * Verify UDR rule with Common operators
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_UDR_Rule_With_Common_Operators(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-6848");
		common.log("Pre condition: UDR Rule must be configured with equals operator");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_UDR_Rule_Is_Working_Fine_With_Common_Operators();
	}

	/**
	 * 2
	 * Verify UDR rule with Special operators
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_UDR_Rule_With_Special_Operators(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-6849");
		common.log("Pre condition: UDR Rule must be configured with special operator for Material description field");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_UDR_Rule_Is_Working_Fine_With_Special_Operators();
	}

	/**
	 * 3
	 * Validate selecting header, hierarchy and grid fields while setup UDR with Numerical Operator - RANGE
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void validate_Selecting_Header_While_Setup_UDR_With_Numerical_Operator_RANGE(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-6850");
		common.log("Pre condition: UDR Rule must be configured with numeric RANGE operator for Material description field Ex: 0 TO 9");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_UDR_Rule_Is_Working_Fine_With_Numeric_Range_Operators();
	}


}
