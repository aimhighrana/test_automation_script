package Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import Page.LoginPage;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

	/**--1--**/
	@Test
	public void verify_The_User_Should_Be_Able_To_Add_A_New_View_For_The_List_Page() throws InterruptedException, IOException {
		common.log("TC --MDMF-TC-1671/MDMF-TC-1672--/MDMF-TC-1673--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.user_Should_Be_Able_To_Add_A_New_View_For_The_List_Page();

	}
	 

	/**--2--**/
	@Test
	public void verify_User_Should_Be_Able_To_Select_Multiple_Records_At_A_Time() throws InterruptedException, IOException {
		common.log("TC --MDMF-TC-1687--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.user_Should_Be_Able_To_Select_Multiple_Records_At_A_Time();

	}
	
	/**--3--**/
	@Test
	public void verify_User_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page() throws InterruptedException, IOException {
		common.log("TC --MDMF-TC-1696--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page();

	}
	 
	
	/**--4--**/
	@Test
	public void verify_The_User_Should_Be_Able_To_Delete_The_Added_View() throws InterruptedException, IOException {
		common.log("TC --MDMF-TC-1697--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page();
		listView.user_Should_Be_Able_To_Delete_The_Added_View();

	}
	
	/**--5--**/
	@Test
	public void verify_The_Pagination_On_List_Page_Should_Work_As_Expected() throws InterruptedException, IOException {
		common.log("TC --MDMF-TC-1707--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.verify_The_Pagination_On_List_Page_Should_Work_As_Expected();

	}
	
	/**--6--**/
	@Test
	public void verify_The_User_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records() throws InterruptedException, IOException {
	//	common.log("--MDMF-TC-1707--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.user_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records();

	}
	
	/**--7--**/
	@Test
	public void verify_The_User_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records() throws InterruptedException, IOException {
	//	common.log("--MDMF-TC-1707--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listView.user_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records();

	}


}
