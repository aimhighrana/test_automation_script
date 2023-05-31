package Page;

import Utils.Common;
import Utils.Locators;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MaterialCreation extends Locators {

	Common common = new Common(driver);

	public MaterialCreation(WebDriver driver) throws FileNotFoundException {

		super(driver);

	}

	/**
	 * verify That Defaults Are Working In The Transaction Screen According To The UserConfigured
	 *
	 */
	public void verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "click on Material master from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(search);

		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//if Default view not appear them click on view dropdown icon and select Default view
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(newRecordBtn);
		System.out.println("Step :: Click on add new record button");
		common.log("Click on add new record button");
		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();

		common.waitForElement(materialCreationRecord);
		common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

		common.waitForElement(materialTypeField);

		String strMaterialType = driver.findElement(By.xpath(materialTypeField)).getAttribute("value");
		System.out.println("Step :: Verified Material Type field: "+strMaterialType);
		common.log("Verified Material Type field: "+strMaterialType);

		String strMaterialGroup = driver.findElement(By.xpath(materialGroupField)).getAttribute("value");
		System.out.println("Step :: Verified Material Group field: "+strMaterialGroup);
		common.log("Verified Material Group field: "+strMaterialGroup);

		String strIndustrySector = driver.findElement(By.xpath(industrySectorField)).getAttribute("value");
		System.out.println("Step :: Verified Industry sector field: "+strIndustrySector);
		common.log("Verified Industry sector field: "+strIndustrySector);

		common.findElementBy(plantDataAddHierarchy,"Click on Plant Data - add... button").click();
		common.waitForElement(searchBoxHierarchy);
		common.findElementBy(searchBoxHierarchy,"Search value: PLANT 0001").sendKeys("PLANT 0001");
		common.waitForElement(selectSearchedOption);
		common.findElementBy(selectSearchedOption,"Select searched option").click();
		common.waitForElement(applyBtn);
		common.findElementBy(applyBtn,"Click on Apply button").click();
		common.pause(5);

		common.findElementBy(valuationDataAddHierarchy,"Click on Valuation Data - add... button").click();
		common.waitForElement(searchBoxHierarchy);
		common.findElementBy(searchBoxHierarchy,"Search value: N.A -- Not Applicable").sendKeys("N.A");
		common.waitForElement(selectSearchedOption);
		common.findElementBy(selectSearchedOption,"Select searched option").click();
		common.findElementBy(applyBtn,"Click on Apply button").click();
		common.pause(10);

		String strValuationType = driver.findElement(By.xpath(valuationTypeField)).getAttribute("value");
		System.out.println("Step :: Verified Valuation Type field: "+strValuationType);
		common.log("Verified Valuation Type field: "+strValuationType);

		common.findElementBy(scenarioIdDisabled, "Verify Scenario ID field is disabled");

		common.findElementBy(searchClassDropdown,"Click on Search class dropdown").click();
		common.waitForElement(searchBoxClassDropdown);
		common.pause(10);
		common.findElementBy(searchBoxClassDropdown,"Click on Search box").click();
		common.pause(10);
//		common.findElementBy(searchBoxClassDropdown,"Search the value: Hood").sendKeys("Hood");

		common.waitForElement(selectFirstValueClassDropdown);
		common.findElementBy(selectFirstValueClassDropdown,"Select first value").click();
		common.waitForElement(firstOptionSearchClass);
		String strValueClassDropdown = driver.findElement(By.xpath(firstOptionSearchClass)).getText();
		common.log("Selected value: "+strValueClassDropdown);

		//verifying attributes after select class
		common.log("Verified generated attributes: "+typeAttributes+" & "+gritAttributes);
		common.assertElementPresent(typeAttributes);
		common.assertElementPresent(gritAttributes);
		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);
		common.waitForElement(dataTab);

	}

	/**
	 * verifying Data On Approve Transaction Screen
	 *
	 */
	public void verifying_Data_On_Approve_Transaction_Screen() {

		//wait for Home tab
		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"Click on Home tab").click();

		//wait for Inbox menu
		common.waitForElement(inboxMenu);
		test.log(LogStatus.INFO, "Step :: Click on Inbox menu ");
		System.out.println("Step :: Click on Inbox menu");
		common.log("Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

		//wait for first value
		common.waitForElement(firstActionIconForInbox);

		test.log(LogStatus.INFO, "Step :: Click on action menu for first row ");
		System.out.println("Step :: Click on action menu for first row");
		common.log("Click on action menu for first row");
		driver.findElement(By.xpath(firstActionIconForInbox)).click();

		test.log(LogStatus.INFO, "Step :: click on approve ");
		System.out.println("Step :: click on approve");
		common.log("Click on approve");
		common.pause(20);
		common.findElement(approveBtn).click();

		common.waitForElement(plantData0001);
		common.findElementBy(plantData0001,"Verify Selected Plant data 'PLANT 0001'");
		common.findElementBy(valuationDataNA,"Verify Selected valuation data 'N.A -- Not Applicable'");

		test.log(LogStatus.INFO, "Step :: click on Approve button ");
		System.out.println("Step :: click on Approve button");
		common.log("Click on submit button");

		common.findElement(approveButton).click();
		common.pause(10);
		common.waitForElement(inboxMenu);

	}
	public void verify_Created_Record_Which_Is_In_System_Status() {

		test.log(LogStatus.INFO, "Step :: Click on Data tab");
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();
		common.refreshPage();

		common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: Click on material master from left nav");
		System.out.println("Step :: Click on Material master from left nav");
		common.log("Click on Material master from left nav");

		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialMasterNumber = driver.findElement(By.xpath(materialMasterNum)).getText();
		System.out.println("Step :: Material master number is ::" + materialMasterNumber);
		System.out.println("Step :: Set filter status as a System");
		common.log("Set filter status as a system");
		driver.findElement(By.xpath(statusFilter)).sendKeys("System");
		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		test.log(LogStatus.INFO, "Step :: Click on edit");
		System.out.println("Step :: Click on edit");
		common.log("Click on edit");

		driver.findElement(By.xpath(edit)).click();
		common.pause(10);
		System.out.println("Step :: Click on material creation process");
		common.log("Click on material master creation process");
		driver.findElement(By.xpath(materialCreationRecord)).click();
		common.pause(10);
		common.waitForElement(headerData);
		common.pause(20);

		test.log(LogStatus.INFO, "Step :: Select Industry Sector ");
		System.out.println("Step :: Select Industry Sector");
		common.log("Select Industry Sector");
		common.waitForElement(industrySec);
		common.findElement(industrySec).click();
		common.pause(5);
		common.findElement(dropValue).click();

		common.findElementBy(plusStorageData, "Click on plus icon for Storage Data hierarchy");

		common.findElementBy(firstOptionStorageData, "Select first option for Storage Data hierarchy");

		common.findElementBy(applyFilterButton, "Click on apply button");
		common.pause(5);

		test.log(LogStatus.INFO, "Step :: Click on save button");
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(80);

		//if duplicate record appear then click on continue and something went occurred then refresh page and submit again
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}
		if(common.isDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']")==true)
		{

			System.out.println("Step :: Something went error appear");
			common.refreshPage();
			common.pause(20);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			test.log(LogStatus.INFO, "Step :: Click on save button");
			System.out.println("Step :: Click on save button");
			common.log("Click on save button");
			driver.findElement(By.xpath(uSaveBtn)).click();
			common.pause(40);
		}
		else {

			System.out.println("Step :: No Something went error");
		}
		common.waitForElement(actionIconForFirstValue);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		test.log(LogStatus.INFO, "Step :: Click on view process log");
		System.out.println("Step :: Click on viewProcess log");
		common.log("Click on view Process log");
		common.waitForElement(viewProcessLogOption);
		driver.findElement(By.xpath(viewProcessLogOption)).click();

		common.waitForElement(processLogStatus);
		String viewProcessLog = driver.findElement(By.xpath(processLogStatus)).getText();

		System.out.println("Step :: View Process log =>>" + viewProcessLog);
		common.log("View Process log =>>" + viewProcessLog);

	}

	/**
	 * Creation - verify Mandatory Field On Execution Page At Edit Time
	 */
	public void verify_Mandatory_Field_On_Execution_Page_At_Edit_Time() {

		test.log(LogStatus.INFO, "Step :: Click on Data tab");
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();
		common.refreshPage();

		common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: Click on material master from left nav");
		System.out.println("Step :: Click on Material master from left nav");
		common.log("Click on Material master from left nav");

		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialMasterNumber = driver.findElement(By.xpath(materialMasterNum)).getText();
		System.out.println("Step :: Material master number is ::" + materialMasterNumber);
		System.out.println("Step :: Set filter status as a System");
		common.log("Set filter status as a system");
		driver.findElement(By.xpath(statusFilter)).sendKeys("System");
		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		test.log(LogStatus.INFO, "Step :: Click on edit");
		System.out.println("Step :: Click on edit");
		common.log("Click on edit");

		driver.findElement(By.xpath(edit)).click();
		common.pause(10);
		System.out.println("Step :: Click on material creation process");
		common.log("Click on material master creation process");
		driver.findElement(By.xpath(materialCreationRecord)).click();
		common.pause(10);
		common.waitForElement(headerData);
		common.pause(20);

		test.log(LogStatus.INFO, "Step :: Click on save button");
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(30);

		//Verifying Error for mandatory fields
		common.assertElementPresent("//p[normalize-space()='Fix the following errors to proceed']");

		for (int i = 1; i < 4; i++) {
			if (driver.findElement(By.xpath("//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div["+i+"]//p")).isDisplayed()) {
				String strError = common.findElement("//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div[" + i + "]//p").getText();
				common.log(strError);
			}
			else
			{
				break;
			}
		}
	}
}
