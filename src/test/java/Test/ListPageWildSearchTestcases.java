package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ListPageWildSearchTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * List Page Wild Search Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**1
	 * List View : To verify that the search follows fuzzy logic
	 **/
	@Test
	@Parameters("env")
	public void verify_The_Search_Should_Follow_Fuzzy_Logic_Verify_Results_And_Clear_Search(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-5501/MDMF-TC-5503/MDMF-TC-5504/MDMF-TC-5497");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		listPageSearch.user_Able_To_Search_Follow_Fuzzy_Logic_Verify_Results_And_Clear_Search();

	}

	/**--2--**/
	@Test
	@Parameters("env")
	public void verify_While_Clearing_The_Text_Search_It_Should_Not_Impact_Any_Applied_Filters(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase:MDMF-TC-5505");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		listPageSearch.user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter();
		listPageSearch.verify_While_Clearing_The_Text_Search_It_Should_Not_Impact_Any_Applied_Filters();

	}

	/**
	 * 3
	 * List View : To verify that user is able to club the text search with other list page filter
	 **/
	@Test
	@Parameters("env")
	public void verify_The_User_Should_Be_Able_To_Club_The_Text_Search_With_Other_List_Page_Filter(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("TC:MDMF-TC-5506");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		listPageSearch.user_Should_Be_Able_To_Club_The_Text_Search_With_Other_List_Page_Filter();

	}
}
