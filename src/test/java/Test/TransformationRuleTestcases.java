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
	 * To verify transformation rule of type "EMPTY SPACE" with "Remove leading Spaces" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Leading_Spaces_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6808");
		log("Pre condition: Transformation Rule must be configured with remove leading spaces option for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Leading_Spaces_On_Transaction_Page();

	}
	/**
	 * 2
	 * To verify transformation rule of type "EMPTY SPACE" with "Remove trailing Spaces" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Trailing_Spaces_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6809");
		log("Pre condition: Transformation Rule must be configured with remove trailing spaces option for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Trailing_Spaces_On_Transaction_Page();

	}

	/**
	 * 3
	 * To verify transformation rule of type "EMPTY SPACE" with "Remove trailing Spaces" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_All_Spaces_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6810");
		log("Pre condition: Transformation Rule must be configured with remove all spaces option for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_All_Spaces_On_Transaction_Page();

	}
	/**
	 * 4
	 * Verify transformation rule of type "Zero" with "Add leading Zeroes" on transaction page
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_Zero_With_Add_Leading_Zeroes_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6813");
		log("Pre condition: Transformation Rule must be configured with Add leading zeros option");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Is_Working_Fine_With_Add_Leading_Zeros();
		materialCreation.verify_Description_on_Summary_Page();
	}

	/**
	 * 5
	 * Verify transformation rule of type "Zero" with "Remove leading Zeroes" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_Zero_With_Remove_Leading_Zeroes_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6814");
		log("Pre condition: Transformation Rule must be configured with Add leading zeros option");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Is_Working_Fine_With_Remove_Leading_Zeros();
		materialCreation.verify_Remove_Leading_Zeros_From_Description_on_Summary_Page();
	}
	/**
	 * 6
	 * To verify the transformation rule of type "Concatenation" with Separation value on transaction page.
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_Transformation_Rule_Of_Type_Concatenation_With_Separation_Value_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6864/MDMF-TC-6865");
		log("Pre condition: Transformation Rule must be configured with Type of Concatenation with Separation option: field1: Material description, field2: Gross weight, field3: Authorization group, Target Field: Volume");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Of_Type_Concatenation_With_Remove_All_Spaces_On_Transaction_Page();

	}
	/**
	 * 7
	 * Verify the transformation rule of type "Constant Value" on transaction page
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_The_Transformation_Rule_Of_Type_Constant_Value_On_Transaction_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-6870");
		log("Pre condition: Transformation Rule must be configured with Constant Value for Material description field: QA");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		materialCreation.verify_Transformation_Rule_Is_Working_Fine_With_Remove_Leading_Zeros();
		materialCreation.verify_Description_Field_For_ConstantValue_on_Summary_Page();
	}
}
