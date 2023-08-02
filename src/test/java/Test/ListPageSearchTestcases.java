package Test;

import com.beust.jcommander.Parameter;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import Page.ListPageSearch;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class ListPageSearchTestcases extends BasePage {


	/**
	 * List Page Search Module
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */

	/**1
	 * List View : To verify that user is able to search record based on created on/modified on date in column filter
	 **/
	@Test
	@Parameters("env")
	public void verify_Search_CreatedModified_On_Date_In_The_Column_Filter(String env) throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: QAA-TC-1/QAA-TC-33");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter();
	}

	/**
	 * 2
	 * List View : To verify that user is able to search based on Material description, Material group, base unit of measure, industry sector and Material type in column filter
	 **/
	@Test
	@Parameters("env")
	public void verify_Search_Based_On_MatrialDesc_Group_Type_Industry_Sector_BaseUnitOfMeasure_In_The_Column_Filter(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: QAA-TC-34/QAA-TC-35");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_AbleToSearch_BasedOn_MaterialDesc_Group_Type_Indus_BaseUnitOfMeasure_In_Column_Filter();
	}

	/**--3--**/
	@Test
	@Parameters("env")
	public void verify_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: MDMF-TC-6198");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_AbleTo_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value();
	}

	/**--4--**/
	@Test
	@Parameters("env")
	public void verify_User_Should_Be_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: MDMF-TC-6201");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions();
	}

	/**--5--**/
	@Test
	@Parameters("env")
	public void verify_User_Should_Be_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: MDMF-TC-6204");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button();
	}

	/**
	 * 6
	 * List View : To verify that the user can apply multiple filters for multiple fields in advance filter search
	 **/
	@Test
	@Parameters("env")
	public void verify_User_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: QAA-TC-36");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search();
	}

	/**--7--**/
	@Test
	@Parameters("env")
	public void verify_User_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: MDMF-TC-6211/MDMF-TC-6212/MDMF-TC-6213");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button();
	}

	/**--8--**/
	@Test
	@Parameters("env")
	public void verify_User_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: MDMF-TC-6214");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button();
	}

	/**
	 * 9
	 * List View : To verify that user can apply column filter and advance filter at a time and club the searches
	 **/
	@Test
	@Parameters("env")
	public void verify_User_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches(String env)
			throws InterruptedException, IOException, AWTException, Exception {
		log("Testcase: QAA-TC-37");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches();
	}

	/**
	 * 10
	 * List View : To verify that column sort functionality is working on list page for fields.
	 **/
	@Test
	@Parameters("env")
	public void verify_Column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: QAA-TC-38");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields();
	}

	/**--11--**/
	@Test
	@Parameters("env")
	public void verify_The_User_Is_Able_To_Delete_The_Saved_Filter(String env) throws InterruptedException, IOException, Exception {
		log("Testcase: MDMF-TC-6217");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button();
		objectService().listPageSearch().verify_The_User_Is_Able_To_Delete_The_Saved_Filter();
	}

	/**
	 * 12
	 * List View : To verify that the pagination show count should be working fine after applying filters
	 **/
	@Test
	@Parameters("env")
	public void verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: QAA-TC-39");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters();
	}

	/**
	 * 13
	 * List View : To verify that user can search using special characters in 'Manufacturer Part number' field
	 **/
	@Test
	@Parameters("env")
	public void verify_User_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field(String env)
			throws InterruptedException, IOException, Exception {
		log("Testcase: QAA-TC-90");
		objectService().loginPage().goToURL(env);
		objectService().loginPage().initiator_SignIn();
		objectService().listPageSearch().user_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field();
	}

}
