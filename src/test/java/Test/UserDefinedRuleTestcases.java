package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserDefinedRuleTestcases extends BasePage {


	/**
	 * 1
	 * Verify UDR rule with Common operators
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_UDR_Rule_With_Common_Operators(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-55/QAA-TC-58/QAA-TC-59");
		log("Pre condition: UDR Rule must be configured with EQUALS OR NOT EQUALS operator");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_Common_Operators();
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
	public void verify_UDR_Rule_With_Special_Operators(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-56");
		log("Pre condition: UDR Rule must be configured with special operator for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_Special_Operators();
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
	public void validate_Selecting_Header_While_Setup_UDR_With_Numerical_Operator_RANGE(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-57");
		log("Pre condition: UDR Rule must be configured with numeric RANGE operator for Material description field Ex: 0 TO 9");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_Numeric_Range_Operators();
	}

	/**
	 * 4
	 * Validate selecting header, hierarchy and grid fields while setup UDR with ENDSWITH operator
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void validate_Selecting_Header_Hierarchy_And_Grid_Fields_While_Setup_UDR_With_ENDSWITH_Operator(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-60");
		log("Pre condition: UDR Rule must be configured with ENDSWITH operator with adding '.' in value for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_ENDSWITH_Operators();
	}

	/**
	 * 5
	 * Validate selecting header, hierarchy and grid fields while setup UDR with EMPTY operator
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void validate_Selecting_Header_Hierarchy_And_Grid_Fields_While_Setup_UDR_With_EMPTY_Operator(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-61");
		log("Pre condition: UDR Rule must be configured with EMPTY operator for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_EMPTY_Operators();
	}

	/**
	 * 6
	 * Validate selecting header, hierarchy and grid fields while setup UDR with LENGTH operator
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void validate_Selecting_Header_Hierarchy_And_Grid_Fields_While_Setup_UDR_With_LENGTH_Operator(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-62");
		log("Pre condition: UDR Rule must be configured with LENGTH operator with adding '10' value for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_LENGTH_Operators();
	}

	/**
	 * 7
	 * Validate selecting header, hierarchy and grid fields while setup UDR with Numerical Operator - LESS THAN/LESS THAN EQUAL
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void validate_Selecting_Header_Hierarchy_And_Grid_Fields_While_Setup_UDR_With_Numerical_Operator_LESS_THAN_LESS_THAN_EQUAL(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-63");
		log("Pre condition: UDR Rule must be configured with LESS THAN or LESS THAN EQUALS operator with adding '10' value for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_LESS_THAN_LESS_THAN_EQUAL_Operators();
	}

	/**
	 * 8
	 * Validate selecting header, hierarchy and grid fields while setup UDR with Numerical Operator - GREATER THAN/GREATER THAN EQUAL
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void validate_Selecting_Header_Hierarchy_And_Grid_Fields_While_Setup_UDR_With_Numerical_Operator_GREATER_THAN_GREATER_THAN_EQUAL(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-64/QAA-TC-65");
		log("Pre condition: UDR Rule must be configured with GREATER THAN or GREATER THAN EQUALS operator with adding '10' value for Material description field");
		log("Rule for QAH - Material creation process / SANDBOX - SequentialMaterial");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().materialCreation().verify_UDR_Rule_Is_Working_Fine_With_GREATER_THAN_GREATER_THAN_EQUAL_Operators();
	}
}
