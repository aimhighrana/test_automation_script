package Test;

import Utils.BasePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;

public class ProcessLogTestcases extends BasePage {


	// MDMF-TC-5192/MDMF-TC-5193/MDMF-TC-5431 TC is available in MaterialMasterTestcases
	/**
	 *Process Log : To verify that user is able to view 'View Email logs' when email notification is configured
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 *
	/**--1--**/
	@Test
	@Parameters("env")
	public void verify_That_User_Is_Able_To_View_Email_Logs_When_Email_Notification_Is_Configured(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase:QAA-TC-12/QAA-TC-13/QAA-TC-46/QAA-TC-268/QAA-TC-270");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().processLog().verify_That_User_Is_Able_To_View_Email_Logs_In_Process_Log();
	}

	/**
 	*Process Log : To verify that user is able to view the 'View integration log'
 	*
 	* @throws InterruptedException
 	* @throws IOException
 	*/
	/**--2--**/
	@Test
	@Parameters("env")
	public void verify_That_User_Is_Able_To_View_The_View_Integration_Log(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase:QAA-TC-14/QAA-TC-15");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().processLog().verify_User_Is_Able_To_View_The_View_Integration_Log();
	}

	/**
	 *Process Log : To verify that tooltip is visible for 'Comment' icon in side sheet
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	/**--3--**/
	@Test
	@Parameters("env")
	public void verify_That_Tooltip_Is_Visible_For_Comment_Icon_In_Side_Sheet(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase:QAA-TC-16");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().processLog().verify_Tooltip_Is_Visible_For_Comment_Icon_In_Side_Sheet();
	}

	/**
	 *Process Log : To verify that tooltip is visible for 'External icon' in sidesheet
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	/**--4--**/
	@Test
	@Parameters("env")
	public void verify_That_Tooltip_Is_Visible_For_External_Icon_In_Sidesheet(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase:QAA-TC-17");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().processLog().verify_Tooltip_Is_Visible_For_External_Icon_In_Sidesheet();
	}
	/**
	 *Process Log : Verify Classification data changes maintained in the process log for parent dataset or related dataset record
	 *
	 * @throws InterruptedException
	 * @throws IOException
	 */
	/**--5--**/
	@Test
	@Parameters("env")
	public void verify_Classification_Data_Changes_Maintained_In_The_Process_Log_For_Parent_Dataset_Or_Related_Dataset_Record(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase:QAA-TC-5/QAA-TC-6/QAA-TC-7/QAA-TC-8/QAA-TC-9/QAA-TC-10/QAA-TC-11/QAA-TC-28/QAA-TC-31/QAA-TC-45");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().processLog().verify_Classification_Data_Changes_Maintained_In_The_Process_Log();
	}

}
