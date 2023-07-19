package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class HomePageTestcases extends BasePage {


	/**Home Page Module**/
	/**
	 * 1
	 *
	 * [Inbox]:-To verify that in INBOX folder, record Id , other data & functionality should be working fine
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test
	@Parameters("env")
	public void verify_That_In_INBOX_Folder_RecordId_Other_Data_And_Functionality_Should_Be_Working_Fine(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-1946");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_That_In_INBOX_Folder_RecordId_Other_Data_And_Functionality_Should_Be_Working_Fine();
	}

	/**
	 * 2
	 * [Inbox]:-To Verify that different options will be present under action button
	 */
	@Test
	@Parameters("env")
	public void verify_That_Different_Options_Will_Be_Present_Under_Action_Button(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-1955");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_That_Different_Options_Will_Be_Present_Under_Action_Button();
	}

	/**
	 * 3
	 * [System Errors] Verify column details displayed in task folders
	 **/
	@Test
	@Parameters("env")
	public void verify_Column_Details_Displayed_In_Task_Folders(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-5619");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_Column_Details_Displayed_In_Task_Folders();
	}

	/**
	 * 4
	 * [System Errors] Verify failed records column for cross dataset, integration, daxe, process log tasks
	 **/
	@Test
	@Parameters("env")
	public void verify_Failed_Records_Column_For_Cross_Dataset_Integration_Daxe_Process_Log_Tasks(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-5623");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_Failed_Records_Column_For_Cross_Dataset_Integration_Daxe_Process_Log_Tasks();
	}

	/**
	 * Verify that once the record is successful re-trigger for integration record should not reflecting in In-error folder
	 * 5
	 * **/
	@Test
	@Parameters("env")
	public void verify_That_Once_The_Record_Is_Successful_ReTrigger_For_Integration_Record_Should_Not_Reflecting_In_Error_Folder(String env) throws InterruptedException, IOException, AWTException, Exception{
		log("Testcase: MDMF-TC-6798");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_That_Once_The_Record_Is_Successful_ReTrigger_For_Integration_Record_Should_Not_Reflecting_In_Error_Folder();
	}

	/**
	 * 6
	 * [System Errors] : Verify that all the filters type are working in In-error folder
	 **/
	@Test
	@Parameters("env")
	public void verify_That_All_The_Filters_Type_Are_Working_In_Error_Folder(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-6804");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_That_All_The_Filters_Type_Are_Working_In_Error_Folder();
	}

	/**
	 * 7
	 * [In progress]:-To verify that in In progress folder, record Id, other data & functionality should be working fine.
	 **/
	@Test
	@Parameters("env")
	public void verify_That_In_In_progress_Folder_Record_Id_Other_Data_And_Functionality_Should_Be_Working_Fine(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-8366/MDMF-TC-8367");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_That_In_In_progress_Folder_Record_Id_Other_Data_And_Functionality_Should_Be_Working_Fine();
	}

	/**
	 * 8
	 * [Completed]:-To verify that in In progress folder, record Id, other data & functionality should be working fine.
	 **/
	@Test
	@Parameters("env")
	public void verify_That_In_Completed_Folder_Record_Id_Other_Data_Functionality_Should_Be_Working_Fine(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: MDMF-TC-8368/MDMF-TC-8370");
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
		homePage.verify_That_In_Completed_Folder_Record_Id_Other_Data_Functionality_Should_Be_Working_Fine();
	}
}
