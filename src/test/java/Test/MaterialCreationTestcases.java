package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class MaterialCreationTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 *  To verify that defaults are working in the transaction screen(header, grids)according to the user configured
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void  verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8375/MDMF-TC-8376/MDMF-TC-8377/MDMF-TC-8379/MDMF-TC-8384/MDMF-TC-8385");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();

	}
	/**
	 *  Creation: To verify that created record is visible at reviewer's task list
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	@Parameters("env")
	public void verify_That_Created_Record_Is_Visible_At_Reviewer_Task_List(String env) throws InterruptedException, IOException {
		common.log("TC:MDMF-TC-8392");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		materialCreation.verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured();
		materialmaster.approveStatus();
		materialmaster.claimStatus();


	}
}
