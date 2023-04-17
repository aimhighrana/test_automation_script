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

public class ListPageSearchTestcases extends BasePage {

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
	public void verify_Search_CreatedModified_On_Date_In_The_Column_Filter() throws InterruptedException, IOException {
		common.log("--MDMF-TC-6196--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter();

	}

	/**--2--**/
	@Test
	public void verify_Search_Based_On_MatrialDesc_Group_Type_Industry_Sector_BaseUnitOfMeasure_In_The_Column_Filter()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6197--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_AbleToSearch_BasedOn_MaterialDesc_Group_Type_Indus_BaseUnitOfMeasure_In_Column_Filter();

	}

	/**--3--**/
	@Test
	public void verify_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6198--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_AbleTo_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value();

	}

	/**--4--**/
	@Test
	public void verify_User_Should_Be_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6201--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions();

	}

	/**--5--**/
	@Test
	public void verify_User_Should_Be_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6204--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button();

	}

	/**--6--**/
	@Test
	public void verify_User_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6210--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search();

	}

	/**--7--**/
	@Test
	public void verify_User_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6211--/--MDMF-TC-6212--/--MDMF-TC-6213--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button();
	}

	/**--8--**/
	@Test
	public void verify_User_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6214--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button();

	}

	/**--9--**/
	@Test
	public void verify_User_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6215--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches();

	}

	/**--10--**/
	@Test
	public void verify_Column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6216--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields();

	}

	/**--11--**/
	@Test
	public void verify_The_User_Is_Able_To_Delete_The_Saved_Filter() throws InterruptedException, IOException {
		common.log("--MDMF-TC-6217--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button();
		listPageSearch.verify_The_User_Is_Able_To_Delete_The_Saved_Filter();
	}

	/**--12--**/
	@Test
	public void verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-6218--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters();
	}

	/**--13--**/
	@Test
	public void verify_User_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field()
			throws InterruptedException, IOException {
		common.log("--MDMF-TC-7338--");
		loginPage.goToURL();
		loginPage.check_SignIn();
		listPageSearch.user_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field();
	}
	
	
}