package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TransformationRuleTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * 1
	 * Verify transformation rule of type "Zero" with "Add leading Zeroes" on transaction page
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_Zero_With_Add_Leading_Zeroes_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		common.log("TC:MDMF-TC-6813");
		common.log("Pre condition: Transformation Rule must be configured with Add leading zeros option");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_Transformation_Rule_Is_Working_Fine_With_Add_Leading_Zeros();
		materialCreation.verify_Description_on_Summary_Page();
	}

	/**
	 * 2
	 * Verify transformation rule of type "Zero" with "Remove leading Zeroes" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_Zero_With_Remove_Leading_Zeroes_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		common.log("TC:MDMF-TC-6814");
		common.log("Pre condition: Transformation Rule must be configured with Add leading zeros option");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_Transformation_Rule_Is_Working_Fine_With_Remove_Leading_Zeros();
		materialCreation.verify_Remove_Leading_Zeros_From_Description_on_Summary_Page();
	}

	/**
	 * 3
	 * Verify the transformation rule of type "Constant Value" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_The_Transformation_Rule_Of_Type_Constant_Value_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		common.log("TC:MDMF-TC-6870");
		common.log("Pre condition: Transformation Rule must be configured with Constant Value for Material description field: QA");
		common.log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		materialCreation.verify_Transformation_Rule_Is_Working_Fine_With_Remove_Leading_Zeros();
		materialCreation.verify_Description_Field_For_ConstantValue_on_Summary_Page();
	}
}
