package Test;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class ListViewTestcases extends BasePage {

	// public WebDriver driver;
	Common common = new Common(driver);

	/**
	 * List View Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**
	 * 1
	 * List View : To verify that user is able to Configure a view with the working behavior.
	 **/
	@Test
	@Parameters("env")
	public void verify_The_User_Should_Be_Able_To_Add_A_New_View_For_The_List_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:QAA-TC-233/MDMF-TC-1672/MDMF-TC-1673");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().user_Should_Be_Able_To_Add_A_New_View_For_The_List_Page();
	}
	/**--2--**/
	@Test
	@Parameters("env")
	public void verify_User_Should_Be_Able_To_Select_Multiple_Records_At_A_Time(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-1687");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().user_Should_Be_Able_To_Select_Multiple_Records_At_A_Time();
	}
	
	/**--3--**/
	@Test
	@Parameters("env")
	public void verify_User_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-1696");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page();
	}
	 
	
	/**
	 *4
	 * List View : To verify that user is able to delete the configured view
	 **/
	@Test
	@Parameters("env")
	public void verify_The_User_Should_Be_Able_To_Delete_The_Added_View(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-1697/QAA-TC-234");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page();
		objectService().listView().user_Should_Be_Able_To_Delete_The_Added_View();
	}
	
	/**--5--**/
	@Test
	@Parameters("env")
	public void verify_The_Pagination_On_List_Page_Should_Work_As_Expected(String env) throws InterruptedException, IOException, Exception {
		log("Testcase:MDMF-TC-1707");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().verify_The_Pagination_On_List_Page_Should_Work_As_Expected();
	}
	
	/**--6--**/
	@Test
	@Parameters("env")
	public void verify_The_User_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records(String env) throws InterruptedException, IOException, Exception {
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().user_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records();
	}
	
	/**--7--**/
	@Test
	@Parameters("env")
	public void verify_The_User_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records(String env) throws InterruptedException, IOException, Exception {
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listView().user_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records();
	}


}
