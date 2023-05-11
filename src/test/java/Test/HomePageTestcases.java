package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class HomePageTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * List Page Search Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**--1--**/
	@Test
	@Parameters("env")
	public void verify_That_In_INBOX_Folder_RecordId_Other_Data_And_Functionality_Should_Be_Working_Fine(String env) throws InterruptedException, IOException, AWTException {
		common.log("TC --MDMF-TC-1946--");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		homePage.verify_That_In_INBOX_Folder_RecordId_Other_Data_And_Functionality_Should_Be_Working_Fine();

	}

	/**--2--**/
	@Test
	@Parameters("env")
	public void verify_That_Different_Options_Will_Be_Present_Under_Action_Button(String env) throws InterruptedException, IOException, AWTException {
		common.log("TC --MDMF-TC-1955--");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		homePage.verify_That_Different_Options_Will_Be_Present_Under_Action_Button();

	}

	/**--3--**/
	@Test
	@Parameters("env")
	public void verify_Column_Details_Displayed_In_Task_Folders(String env) throws InterruptedException, IOException, AWTException {
		common.log("TC --MDMF-TC-5619--");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		homePage.verify_Column_Details_Displayed_In_Task_Folders();
	}

	/**--4--**/
	@Test
	@Parameters("env")
	public void verify_Failed_Records_Column_For_Cross_Dataset_Integration_Daxe_Process_Log_Tasks(String env) throws InterruptedException, IOException, AWTException {
		common.log("TC --MDMF-TC-5623--");
		loginPage.goToURL();
		loginPage.check_SignIn(env);
		homePage.verify_Failed_Records_Column_For_Cross_Dataset_Integration_Daxe_Process_Log_Tasks();
	}
}
