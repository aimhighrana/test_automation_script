package Page;

import Utils.BasePage;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ListView extends Locators {

	Common common = new Common(driver);
	Properties obj = new Properties();

	public ListView(RemoteWebDriver d) throws FileNotFoundException {

		super(d);

	}

	/**
	 * user_Should_Be_Able_To_Add_A_New_View_For_The_List_Page
	 * 
	 */
	public void user_Should_Be_Able_To_Add_A_New_View_For_The_List_Page() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.waitForElement(dropDownViewICon);

		common.findElementBy(dropDownViewICon, "Click on View drop-down icon").click();

		common.waitForElement(newViewOption);

		common.findElementBy(newViewOption, "Click on New view option from drop-down").click();

		String viewStr = common.generateRandomChars(5);

		common.findElementBy(inputViewName, "Enter new view name:: " + viewStr).click();
		common.type(inputViewName, viewStr);

		common.findElementBy(saveButtonView, "Click on Save button").click();
		common.pause(10);

		common.assertElementPresent("//h4[normalize-space()='Material Master - " + viewStr + "']");

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value" + " of Material master table:: " + strFirstValue);
			common.log("First value of Material master table:: " + strFirstValue);
		}

		common.findElementBy(dropDownViewICon, "Click on View drop-down icon").click();

		common.waitForElement(defaultViewOption);

		common.findElementBy(defaultViewOption, "Click on Default view option from drop-down").click();
		common.pause(10);

		String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue);
		common.log("First value of Material master table:: " + strFirstValue);

	}

	/**
	 * user_Should_Be_Able_To_Select_Multiple_Records_At_A_Time
	 * 
	 */
	public void user_Should_Be_Able_To_Select_Multiple_Records_At_A_Time() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		for (int i = 1; i <= 6; i++) {
			System.out.println("select " + i + " checkbox of record");
			common.log("select " + i + " checkbox of record");
			driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]//label")).click();
		}

	}

	/**
	 * user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page
	 * 
	 */
	public void user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.waitForElement(dropDownViewICon);

		common.findElementBy(settingIcon, "Click on Setting icon").click();

		common.waitForElement(inputViewName);
		String viewStr = common.generateRandomChars(5);

		common.findElementBy(inputViewName, "Enter new view name:: " + viewStr).clear();
		common.type(inputViewName, viewStr);

		common.findElementBy(saveButtonView, "Click on Save button").click();
		common.pause(10);

		common.assertElementPresent("//h4[normalize-space()='Material Master - " + viewStr + "']");

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value" + " of Material master table:: " + strFirstValue);
			common.log("First value of Material master table:: " + strFirstValue);
		}
	}

	/**
	 * user_Should_Be_Able_To_Delete_The_Added_View
	 * 
	 */
	public void user_Should_Be_Able_To_Delete_The_Added_View() {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();

		common.findElementBy(threeDotsIconForView, "Click on three dots icon at top right corner").click();
		common.waitForElement(deleteViewOption);

		common.findElementBy(deleteViewOption, "Click on Delete view option").click();

		common.waitForElement(confirmDeleteView);

		common.findElementBy(confirmDeleteView, "Click on Confirm button in Delete popup").click();

		common.pause(10);

		common.assertElementPresent(createdOnFilter);

	}

	/**
	 * verify_The_Pagination_On_List_Page_Should_Work_As_Expected
	 * 
	 */
	public void verify_The_Pagination_On_List_Page_Should_Work_As_Expected() {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();
		common.pause(15);

		for (int i = 0; i <= 3; i++) {
			String paginationStr = driver.findElement(By.xpath(paginationValue)).getText();

			System.out.println("Paginaton value :: " + paginationStr);
			common.log("Pagination value :: " + paginationStr);

			common.findElementBy(nextPage, "Click on next button in pagination").click();
			common.pause(5);
		}

	}
	

	/**
	 * user_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records
	 * 
	 */
	public void user_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records() {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();

		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);
		

		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.pause(5);
		common.findElementBy(flowMaterialMasterRecordoption, "Click on Material master record option").click();
		common.pause(10);
		common.assertElementPresent(headerData);
		common.findElementBy(closeIcon, "Click on close icon").click();
		
		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.pause(5);
		common.findElementBy(formClassnClassTypeOption, "Click on Class and Class Type option").click();
		common.pause(10);
		common.assertElementPresent(classType1);
		common.findElementBy(closeIcon, "Click on close icon").click();
		

	}
	/**
	 * user_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records
	 * 
	 */
	public void user_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records() {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();

		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);
		

		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(downloadTemplatesOption, "Click on Download templates option").click();
		common.pause(5);
		common.findElementBy(descriptionOption, "Click on Description option").click();
		common.pause(10);
		

	}

}
