package Page;

import Page.ServiceHelper.AuthenticationService;
import Page.ServiceHelper.EnvironmentService;
import Page.contracts.IAuthenticationService;
import Page.contracts.IEnvironmentService;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ListView extends Locators {

	Common common;
	Properties obj = new Properties();
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	public ListView(WebDriver driver) throws FileNotFoundException {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();

	}

	/**
	 * user_Should_Be_Able_To_Add_A_New_View_For_The_List_Page
	 *
	 */
	public void user_Should_Be_Able_To_Add_A_New_View_For_The_List_Page() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.pause(5);
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(dropDownViewICon);

		common.findElementBy(dropDownViewICon, "Click on View drop-down icon").click();

		common.waitUntilElementToBeVisible(newViewOption);

		common.findElementBy(newViewOption, "Click on New view option from drop-down").click();

		String viewStr = common.generateRandomChars(5);

		common.findElementBy(inputViewName, "Enter new view name: " + viewStr).click();
		common.type(inputViewName, viewStr);

		common.findElementBy(saveButtonView, "Click on Save button").click();
		common.pause(10);

		String strView = common.findElementBy((WebElement) By.xpath("//h4[contains(text(),'Material Master')]"),"Verified view").getText();
		common.log("Created new view: "+strView);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();

			common.log("First value of Material master table: " + strFirstValue);
		}

		common.findElementBy(dropDownViewICon, "Click on View drop-down icon").click();

		common.waitUntilElementToBeVisible(defaultViewOption);

		common.findElementBy(defaultViewOption, "Click on Default view option from drop-down").click();
		common.pause(10);

		String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
		common.log("First value of Material master table: " + strFirstValue);
	}

	/**
	 * user_Should_Be_Able_To_Select_Multiple_Records_At_A_Time
	 *
	 */
	public void user_Should_Be_Able_To_Select_Multiple_Records_At_A_Time() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		for (int i = 1; i <= 6; i++) {
			common.log("select " + i + " checkbox of record");
			common.findElement((WebElement) By.xpath("//tbody/tr[" + i + "]/td[1]//label")).click();
		}

	}

	/**
	 * user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page
	 *
	 */
	public void user_Should_Be_Able_To_Create_View_Using_Setting_Icon_In_The_List_Page() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.pause(5);

		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.pause(10);
		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(dropDownViewICon);

		common.findElementBy(settingIcon, "Click on Setting icon").click();

		common.waitUntilElementToBeVisible(inputViewName);
		String viewStr = common.generateRandomChars(5);

		common.findElementBy(inputViewName, "Enter new view name: " + viewStr).clear();
		common.type(inputViewName, viewStr);

		common.pause(10);
		common.findElementBy(saveButtonView, "Click on Save button").click();
		common.pause(10);

		if (common.isElementDisplayed((WebElement) By.xpath("//h4[normalize-space()='Material Master - " + viewStr + "']"))) {

			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);
		}
	}

	/**
	 * user_Should_Be_Able_To_Delete_The_Added_View
	 *
	 */
	public void user_Should_Be_Able_To_Delete_The_Added_View() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.findElement(dataTab).click();

		common.findElementBy(threeDotsIconForView, "Click on three dots icon at top right corner").click();
		common.waitUntilElementToBeVisible(deleteViewOption);

		common.findElementBy(deleteViewOption, "Click on Delete view option").click();

		common.waitUntilElementToBeVisible(confirmDeleteView);

		common.findElementBy(confirmDeleteView, "Click on Confirm button in Delete popup").click();

		common.pause(10);

		common.log("Verified Date created filter appear");
		common.assertElementPresent(createdOnFilter);

	}

	/**
	 * verify_The_Pagination_On_List_Page_Should_Work_As_Expected
	 *
	 */
	public void verify_The_Pagination_On_List_Page_Should_Work_As_Expected() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(paginationValue);
		for (int i = 0; i <= 3; i++) {
			String paginationStr = common.findElement(paginationValue).getText();
			common.log("Pagination value : " + paginationStr);

			common.findElementBy(nextPage, "Click on next button in pagination").click();
			common.pause(5);
		}

	}


	/**
	 * user_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records
	 *
	 */
	public void user_Should_Be_Able_To_View_The_Summary_Of_The_Record_Using_Action_Button_On_The_Records() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.pause(5);
		common.waitUntilElementToBeVisible(flowMaterialMasterRecordoption);
		common.findElementBy(flowMaterialMasterRecordoption, "Click on second option").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(headerData);
		common.log("Verify Header data appear");
		common.findElementBy(closeIcon, "Click on close icon").click();

		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.waitUntilElementToBeVisible(formClassnClassTypeOption);
		common.findElementBy(formClassnClassTypeOption, "Click on third option").click();
		common.pause(5);
		common.waitUntilElementToBeVisible(headerData);
		common.findElementBy(closeIcon, "Click on close icon").click();


	}
	/**
	 * user_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records
	 *
	 */
	public void user_Should_Be_Able_To_Download_Template_Of_The_Record_Using_Action_Button_On_The_Records() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.pause(5);
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(downloadTemplatesOption, "Click on Download templates option").click();
		common.pause(5);
		if (common.isElementDisplayed(descriptionOption))
		{
			common.findElementBy(descriptionOption, "Click on Description option").click();
		}
		else {
			common.log("No template available");
		}
		common.pause(5);
	}

}
