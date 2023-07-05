package Test;

import Utils.BasePage;
import Utils.Common;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ProcessLogTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 *Process Log : To verify that user is able to view 'View Email logs' when email notification is configured
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**--1--**/
	@Test
	@Parameters("env")
	public void verify_That_User_Is_Able_To_View_Email_Logs_When_Email_Notification_Is_Configured(String env) throws InterruptedException, IOException, AWTException, Exception {
		common.log("TC:MDMF-TC-5181/MDMF-TC-5183");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		processLog.verify_That_User_Is_Able_To_View_Email_Logs_In_Process_Log();
	}

	/**
	 *Process Log : To verify that tooltip is visible for 'Comment' icon in side sheet
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**--2--**/
	@Test
	@Parameters("env")
	public void verify_That_Tooltip_Is_Visible_For_Comment_Icon_In_Side_Sheet(String env) throws InterruptedException, IOException, AWTException, Exception {
		common.log("TC:MDMF-TC-5188");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		processLog.verify_Tooltip_Is_Visible_For_Comment_Icon_In_Side_Sheet();
	}


	/**
	 *Process Log : To verify that tooltip is visible for 'External icon' in sidesheet
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**--3--**/
	@Test
	@Parameters("env")
	public void verify_That_Tooltip_Is_Visible_For_External_Icon_In_Sidesheet(String env) throws InterruptedException, IOException, AWTException, Exception {
		common.log("TC:MDMF-TC-5189");
		loginPage.goToURL(env);
		loginPage.check_SignIn(env);
		processLog.verify_Tooltip_Is_Visible_For_External_Icon_In_Sidesheet();
	}
}
