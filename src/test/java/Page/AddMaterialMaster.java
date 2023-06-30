package Page;

import Utils.BasePage;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AddMaterialMaster extends Locators {

	Common common = new Common(driver);

	public AddMaterialMaster(WebDriver driver) throws FileNotFoundException {

		super(driver);

	}

	/**
	 * Add New Material Master Record
	 *
	 */
	public void addNewMaterialMaster() {

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
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
		test.log(LogStatus.INFO, "Click on new record button");
		System.out.println("Step :: Click on add new record button");
		common.log("Click on add new record button");

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();
		common.pause(5);

		if (common.isElementPresent(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.pause(5);

			common.waitForElement(xPlantMaterialStatusField);
			common.findElementBy(xPlantMaterialStatusField,"Select value from X-Plant Material Status field").click();
			common.waitForElement(dropValue);
			common.findElementBy(dropValue, "Select option").click();

		}else {

			test.log(LogStatus.INFO, "Click on material master workflow roles");
			System.out.println("Step :: Click on material master workflow roles");
			common.log("Click on material master workflow roles");
			common.waitForElement(materialMasterRoleValue);
			driver.findElement(By.xpath(materialMasterRoleValue)).click();

			System.out.println("Step :: Click on Industry sector dropdown and select value");
			common.log("Click on Industry section dropdown and select value");
			common.waitForElement(industrySec);
			common.findElement(industrySec).click();

			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
			common.pause(5);
			// Filling plant records
			common.log("-- Filling plant data --");
			System.out.println("Step :: Select plant value");
			common.log("Select plant value");

			common.findElement(plantdataPlusIcon).click();
			common.waitForElement(plantvalue);
			common.findElement(plantvalue).click();
			common.pause(5);
			common.findElementBy(applyBtn,"Click on apply button").click();

			System.out.println("Step :: Select MRP type");
			common.log("Select MRP type");
			common.waitForElement(mrpTypeField);
			WebElement l = driver.findElement(By.xpath(mrpTypeField));

			// Javascript executor fro scrolling
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);

			common.waitForElement(mrpType);
			common.findElement(mrpType).click();
			common.pause(5);
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();

			common.scrollPage();

			common.waitForElement(loading);
			common.findElementBy(loading,"Click on loading group icon").click();
			common.pause(5);
			common.findElementBy(dropValueLoading,"Select value for Loading group").click();

			System.out.println("Step :: -- Filling valuation data --");
			common.log("-- Filling valuation data --");
			common.waitForElement(valuationPlusIcon);
			common.findElementBy(valuationPlusIcon,"Click on + icon for Valuation").click();

			common.waitForElement(newCheckbox);
			test.log(LogStatus.INFO, "Step :: Select NEW checkbox option and Apply");
			System.out.println("Step :: Select NEW checkbox option and Apply");
			common.findElement(newCheckbox).click();

			common.findElementBy(applyBtn,"Click on apply button").click();

			test.log(LogStatus.INFO, "Step :: Select Valuation Cat. option");
			System.out.println("Step :: Select Valuation Cat. option");
			common.waitForElement(valCat);
			common.findElement(valCat).click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
			common.pause(10);
		}

		//If material type filed appear then select value from it
		if (common.isDisplayed(
				"//p[@class='small strong no-wrap ng-star-inserted'][normalize-space()='Material Type']//..//..//div//input") == true) {

			System.out.println("Step :: Select Material Type");
			driver.findElement(By.xpath(
							"//p[@class='small strong no-wrap ng-star-inserted'][normalize-space()='Material Type']//..//..//div//input"))
					.click();
			driver.findElement(By.xpath("//span[normalize-space()='ERSA -- Spare Part']")).click();

			common.pause(5);
		} else {

			common.log("No need to select Material Type");
		}

		//If Manufacturer part number field appear then fill value for it
		if (common.isDisplayed(manufacturerPartNum) == true) {

			System.out.println("Step :: Enter Manufacturer Part Number");
			driver.findElement(By.xpath(manufacturerPartNum)).sendKeys("12345");
			common.pause(10);
		} else {

			System.out.println("No need to enter Manufacturer Part Number");
		}


		common.pause(5);
		test.log(LogStatus.INFO, "Step :: Click on submit button");
		System.out.println("Step :: click on submit button");
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(2);

		//If duplicate record popup appear then click on continue
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			System.out.println("Duplicate records");
			common.findElementBy(continueDuplicateRecord,"Click on Continue button").click();
			common.pause(10);
		} else {

			System.out.println("Step :: No duplicate records");
		}

		//If something went error occurred then refresh page and select another value and click on submit
		if(common.isDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']")==true)
		{

			System.out.println("Step :: Something went error appear");
			common.log("Something went error appear");
			common.refreshPage();
			common.pause(20);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			test.log(LogStatus.INFO, "Step :: -- click on submit button");
			System.out.println("Step :: click on submit button");
			common.log("click on submit button");
			common.findElement(submitBtn).click();
			common.pause(10);
		}
		else {

			System.out.println("Step :: No Something went error");
		}

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
		common.waitForElement(dataTab);
		test.log(LogStatus.INFO, "Step :: Verifying Data tab available");
		System.out.println("Step :: Verifying Data tab available");

		common.log("Refreshing page for visible latest created record");
		common.refreshPage();
		common.pause(10);

	}

	/**
	 * Add material master role with generate description
	 *
	 */
	public void createMaterialMasterWithGenerateDesc() {

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);

		common.waitForElement(search);
		common.type(search,"Material master");
		common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: click on material master from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.pause(5);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then it select from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(newRecordBtn);
		test.log(LogStatus.INFO, "Step :: click on add  new record button");
		System.out.println("Step :: click on add new record button");
		common.log("Click on add new record button");
		common.pause(10);

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();
		common.pause(5);

		if (common.isElementPresent(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
		}
		else {
			test.log(LogStatus.INFO, "Step :: click on material master workflow roles");
			System.out.println("Step :: click on material master workflow roles");
			common.log("Click on material master workflow roles");
			common.waitForElement(materialMasterRoleValue);

			common.findElement(materialMasterRoleValue).click();
		}
		common.waitForElement(materialGroup);
		common.pause(10);

		if (common.isElementDisplayed(industrySec)) {
			common.waitForElement(industrySec);
			common.findElementBy(industrySec, "Click on Industry sector dropdown and select value from it").click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
		}
		common.pause(5);

		common.findElementBy(generateDesc,"Click on generate description").click();
		common.findElement(generateDesc).click();

		if (common.isElementPresent(xPlantMaterialStatusField))
		{
			common.findElementBy(xPlantMaterialStatusField,"Select value from X-Plant Material Status field").click();
		}

		test.log(LogStatus.INFO, "Step :: Select class value");
		System.out.println("Step :: Select class value");
		common.log("Select class");
		common.waitForElement(claS);
		common.findElement(claS).click();
	//common.waitForElement(classval);
//		common.findElement(classval).click();
		common.pause(3);

		common.findElementBy(sourceListDescription,"Select value from Source - List dropdown").click();
		common.waitForElement(dropValue);
		common.findElement(dropValue).click();

		// Filling plant records
		test.log(LogStatus.INFO, "Step :: -- Filling plant data -- ");
		System.out.println("Step :: -- Filling plant data --");

		test.log(LogStatus.INFO, "Step :: select plant value ");
		System.out.println("Step :: Select plant value");
		common.log("Select plant value");

		common.findElement(plantdataPlusIcon).click();
		common.waitForElement(plantvalue);
		common.findElement(plantvalue).click();

		common.findElementBy(applyBtn,"Click on apply button").click();
		common.scrollPage();

		System.out.println("Step :: Select MRP type");
		common.log("Select MRP type");
		common.waitForElement(mrpType);
		common.pause(25);
		WebElement l = driver.findElement(By.xpath(mrpTypeField));

		// Javascript executor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);
		common.findElement(mrpType).click();
		common.pause(5);
		common.waitForElement(dropValue);
		common.findElement(dropValue).click();

		common.pause(10);
		common.scrollPage();

		common.pause(10);
		System.out.println("Step :: Select Loading type");
		common.log("Select Loading type");
		common.findElement(loading).click();
		common.pause(5);

		common.findElement(dropValueLoading).click();
		test.log(LogStatus.INFO, "Step :: -- Filling valuation data --");
		System.out.println("Step :: -- Filling valuation data --");
		common.findElement(valuationPlusIcon).click();
		common.pause(5);
		common.findElement(newCheckbox).click();

		common.findElementBy(applyBtn,"Click on apply button").click();

		common.waitForElement(valCat);
		common.findElement(valCat).click();
		common.waitForElement(dropValue);
		common.findElement(dropValue).click();

		common.pause(20);
		for (int j = 0; j < 2; j++) {
			common.scrollPage();
		}

		test.log(LogStatus.INFO, "Step :: -- click on submit button");
		System.out.println("Step :: click on submit button");
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(20);

		//If duplicate record popup appear then click on submit
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}

		//If something went error occurred then refresh page select another value and click on submit
		if(common.isDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']")==true)
		{

			System.out.println("Step :: Something went error appear");
			common.refreshPage();
			common.pause(20);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			test.log(LogStatus.INFO, "Step :: -- click on submit button");
			System.out.println("Step :: click on submit button");
			common.log("click on submit button");
			common.findElement(submitBtn).click();

			common.pause(40);
		}
		else {

			System.out.println("Step :: No Something went error");
		}

		common.log("Refreshing the page for visible latest created record");
		common.refreshPage();
		common.pause(15);

		common.waitForElement(searchB);
		String materialMasterNum = common.findElement(materialNumFromTbl).getText();
		test.log(LogStatus.INFO, "Step :: -- Material master number is ");
		System.out.println("Step :: Material master number is ::" + materialMasterNum);
		common.log("Material master number is :: " + materialMasterNum);
		common.pause(30);

		common.waitForConditionIsElementPresent(searchB);
		common.findElementBy(searchB,"Click on Search field and search material master value").click();
		driver.findElement(By.xpath(searchB)).sendKeys(materialMasterNum);
		common.pause(25);
		//verify searched material master record present
		common.log("Material master number is available on table:: " + materialMasterNum);
		common.assertElementPresent("//mark[normalize-space()='" + materialMasterNum + "']");
	}

	/**
	 * Verify Material Master Process Log
	 *
	 */
	public void viewMaterialMasterProcessLog() {
		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(15);

		//If default view not appear then select it from View dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.findElementBy(actionIconForFirstValue,"Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(viewPLog,"Select view process log option").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {
			common.waitForElement(processLogTitle);
			String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
			System.out.println("Step :: Process Log Title is ::" + pLog);
			common.log("Process Log Title is ::" + pLog);

			driver.findElement(By.xpath(processLogTitle)).click();

			common.pause(15);
			String status = driver.findElement(By.xpath(statusCom)).getText();
			System.out.println("Step :: Process Log Status is ::" + status);
			common.log("Process Log Status is ::" + status);
			assertEquals(status, "COMPLETED");

			System.out.println("Step :: click on view change ");
			common.log("Click on view change");
			driver.findElement(By.xpath(completedViewProcessLog)).click();
			common.waitForElement(headerData);
			Boolean header = driver.findElement(By.xpath(headerData)).isDisplayed();
			test.log(LogStatus.INFO, "Step :: -- Header title is displaying ");
			System.out.println("Step :: Header Title is displaying:: >>" + header);
			common.log("Title is Header data :: >>" + header);

			common.pause(5);

			System.out.println("Step :: Close View change page ");
			common.log("Close View change page ");
			common.findElement(closeIcoForViewChange).click();

			System.out.println("Step :: Close process log page ");
			common.log("Close View process log page ");
			common.waitForConditionIsElementPresent(closeIconForProcessLog);
			common.findElement(closeIconForProcessLog).click();
		}
		else {
			String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
			System.out.println("Step :: View process log: "+strProcessLog);
			common.log("View process log: "+strProcessLog);
		}

	}

	/**
	 * Verify Material Master completed Process Log
	 *
	 */
	public void viewMaterialMasterCompletedProcessLog() {

		//wait for search filed
		common.pause(5);
		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		common.pause(5);
		common.refreshPage();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		//wait for first value of table
		common.waitForElement(materialNumFromTbl);

		common.waitForElement(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue,"Click on acton icon for first value").click();

		common.pause(5);
		common.findElementBy(viewPLog,"Click on view process log option ").click();
		common.waitForElement(processLogTitle);
		String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
		System.out.println("Step :: Process Log Title is ::" + pLog);
		common.log("Process Log Title is ::" + pLog);

		driver.findElement(By.xpath(processLogTitle)).click();

		common.waitForElement(statusCom);
		String status = driver.findElement(By.xpath(statusCom)).getText();
		System.out.println("Step :: Process Log Status is ::" + status);
		common.log("Process Log Status is ::" + status);
		assertEquals(status, "COMPLETED");

		System.out.println("Step :: click on view change ");
		common.log("Click on view change");
		common.findElement(completedViewProcessLog).click();

		common.waitForElement(headerData);
		Boolean header = driver.findElement(By.xpath(headerData)).isDisplayed();
		test.log(LogStatus.INFO, "Step :: -- Header title is displaying ");
		System.out.println("Step :: Header Title is displaying:: >>" + header);
		common.log("Title is Header data :: >>" + header);

		//expand header data
//		common.expandingHeadData();

		common.findElementBy(closeIcoForViewChange,"Click on close icon for view change").click();
		common.waitForElement(closeIconForProcessLog);
		common.findElementBy(closeIconForProcessLog,"Click on close icon for Process log popup").click();

	}

	/**
	 * Verify Approve Status
	 *
	 */
	public void approveStatus() {

		//wait for Home tab
		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"Click on Home tab").click();

		//wait for Inbox menu
		common.waitForElement(inboxMenu);
		common.findElementBy(inboxMenu,"Click on Inbox menu").click();
		common.findElement(inboxMenu).click();

		//wait for first value
		common.waitForElement(firstActionIconForInbox);

		test.log(LogStatus.INFO, "Step :: Click on action menu for first row ");
		System.out.println("Step :: Click on action menu for first row");
		common.log("Click on action menu for first row");
		driver.findElement(By.xpath(firstActionIconForInbox)).click();

		System.out.println("Step :: click on approve");
		common.log("Click on approve");
		common.findElement(approveBtn).click();

		common.waitForElement(headerData);
		common.findElementBy(headerData,"Verify Header data appear");

		if (common.isElementDisplayed(sequentialHeader))
		{
			common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("Material desc 123");
			common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
			common.findElementBy(divisionField,"Select value from Division dropdown").click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
			common.pause(5);
		}
		common.waitForElement(approveButton);
		test.log(LogStatus.INFO, "Step :: click on Approve button ");
		System.out.println("Step :: click on Approve button");
		common.findElement(approveButton).click();
		common.pause(2);

		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
		common.waitForElement(inboxMenu);

	}
	/**
	 * Re-Approve Rejected Task
	 *
	 */
	public void reApprove_Rejected_Task_Status() {

		//wait for Home tab
		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"Click on Home tab").click();

		//wait for Inbox menu
		common.waitForElement(myReqTab);
		common.findElementBy(myReqTab,"Click on My Request menu").click();
		common.findElement(myReqTab).click();

		//wait for first value
		common.waitForElement(firstActionIconForInbox);

		test.log(LogStatus.INFO, "Step :: Click on action menu for first row ");
		System.out.println("Step :: Click on action menu for first row");
		common.log("Click on action menu for first row");
		driver.findElement(By.xpath(firstActionIconForInbox)).click();

		System.out.println("Step :: click on approve");
		common.log("Click on approve");
		common.findElement(approveBtn).click();

		common.waitForElement(headerData);
		common.findElementBy(headerData,"Verify Header data appear");

		if (common.isElementDisplayed(sequentialHeader))
		{
			common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("Material desc 123");
			common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
			common.findElementBy(divisionField,"Select value from Division dropdown").click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
		}
		common.waitForElement(approveButton);
		test.log(LogStatus.INFO, "Step :: click on Approve button ");
		System.out.println("Step :: click on Approve button");

		common.findElement(approveButton).click();
		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
		common.waitForElement(inboxMenu);

	}

	/**
	 * Verify Claim Status
	 *
	 */
	public void claimStatus() {

		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"Click on Home tab").click();

		//wait for Inbox menu
		common.waitForElement(inboxMenu);

		test.log(LogStatus.INFO, "Step :: Click on Inbox menu ");
		System.out.println("Step :: Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

		//wait for first value of Inbox menu
		common.waitForElement(firstActionIconForInbox);

		test.log(LogStatus.INFO, "Step :: Click on action menu for first row ");
		System.out.println("Step :: Click on action menu for first row");
		common.log("Click on action menu for first row");
		common.findElement(firstActionIconForInbox).click();
		common.pause(20);

		//If claim option available then select and verify process log
		if (common.isDisplayed(claim) == true) {

			test.log(LogStatus.INFO, "Step :: click on claim");
			System.out.println("Step :: click on claim");
			common.log("Click on claim");
			common.findElement(claim).click();
			common.pause(15);

			test.log(LogStatus.INFO, "Step :: click on my request ");
			System.out.println("Step :: click on my request");
			common.log("Click on my request");

			common.findElement(myReqTab).click();

			common.pause(25);
			common.waitForElement(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on action icon for first value").click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on view Process Log ");
			System.out.println("Step :: click on viewProcessLog");
			common.log("Click on my viewProcessLog");

			common.findElement(processLogOption).click();
			common.pause(20);

			//wait for label
			common.waitForElement(lblText);

			common.pause(10);
		} else {

			System.out.println("Claim option not available");
		}

	}

	/**
	 * Verify Claim Status
	 *
	 */
	public void claimUnclaimStatus() {
		common.pause(15);

		//wait and click on Inbox menu
		common.waitForElement(inboxMenu);
		common.jsClick(inboxMenu);
		common.click(inboxMenu);

		common.waitForElement(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox,"Click on first value action button").click();

		common.pause(5);
		common.waitForElement(claim);
		test.log(LogStatus.INFO, "Step :: click on claim");
		System.out.println("Step :: click on claim");
		common.log("Click on claim");
		common.findElement(claim).click();

		common.waitForElement("//div[@class='cdk-overlay-pane']");

		test.log(LogStatus.INFO, "Step :: click on my request ");
		System.out.println("Step :: click on my request");
		common.log("Click on my request");
		common.pause(10);
		common.findElement(myReqTab).click();

		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(5);

		test.log(LogStatus.INFO, "Step :: click on view Process Log ");
		System.out.println("Step :: click on viewProcessLog");
		common.log("Click on my viewProcessLog");
		common.waitForElement(processLogOption);
		common.findElement(processLogOption).click();
		common.pause(20);
		//wait for label text
		common.waitForElement(lblText);

		common.pause(20);
		common.findElementBy(crossIconS,"Click on close icon").click();

		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(20);

		test.log(LogStatus.INFO, "Step :: Click on unclaim");
		System.out.println("Step :: Click on unclaim");
		common.log("Click on claim");
		common.findElement(unclaim).click();

		//wait and click on Inbox menu
		common.waitForElement(inboxMenu);
		common.findElement(inboxMenu).click();
		common.pause(5);

		common.waitForElement(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox,"Click on first value action icon").click();

		common.waitForElement(processLog);
		common.findElementBy(processLog,"Click on process log").click();

		common.pause(5);
		common.waitForElement(lblText);

		driver.findElement(By.xpath(crossIconS)).click();
		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();

		test.log(LogStatus.INFO, "Step :: click on approve");
		System.out.println("Step :: click on approve");
		common.log("Click on approve");
		driver.findElement(By.xpath(approveVal)).click();
		common.pause(5);

		test.log(LogStatus.INFO, "Step :: click on drop down");
		System.out.println("Step :: click on drop down");
		common.log("Click on drop down");
		driver.findElement(By.xpath(approveDropDownIcon)).click();

		common.pause(5);
		test.log(LogStatus.INFO, "Step :: click on save as draft ");
		System.out.println("Step :: click on save as draft");
		common.log("Click on save as draft");
		driver.findElement(By.xpath(draft)).click();
		common.pause(10);

		//wait for My request header
		common.waitForElement(myRrequestHeader);

	}

	/**
	 * Verify Save as a Draft
	 *
	 */
	public void saveDraft() {
		common.pause(20);
		common.refreshPage();

		test.log(LogStatus.INFO, "Step :: click on material master from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(myReqTab);
		test.log(LogStatus.INFO, "Step :: click on my request ");
		System.out.println("Step :: click on my request");
		common.log("Click on my request");
		driver.findElement(By.xpath(myReqTab)).click();
		driver.findElement(By.xpath(myReqTab)).click();
		common.pause(25);

		//If value appear ion first row then select approve and click on save as draft
		if (common.isDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			driver.findElement(By.xpath(firstActionIconForInbox)).click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on approve");
			System.out.println("Step :: click on approve");
			common.log("Click on my approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			test.log(LogStatus.INFO, "Step :: click on drop down");
			System.out.println("Step :: click on drop down");
			common.log("Click on my drop down");
			driver.findElement(By.xpath(approveDropDownIcon)).click();

			common.pause(5);
			test.log(LogStatus.INFO, "Step :: click on save as draft ");
			System.out.println("Step :: click on save as draft");
			common.log("Click on save as draft");
			driver.findElement(By.xpath(draft)).click();
			common.pause(15);

			//verify My request tab available
			common.assertElementPresent(myReqTab);
		} else {

			test.log(LogStatus.INFO, "No records available");
			System.out.println("No records available");
			common.log("No records available");
		}
	}

	/**
	 * Verify Update Existing Record Scenario
	 *
	 */
	public void doUpdate() {

		test.log(LogStatus.INFO, "Step :: Click on Data tab");
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
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

		if(common.isElementDisplayed(qaFormOption))
		{
			common.findElementBy(qaFormOption, "Click on QA Form option").click();
		}
		else {


			test.log(LogStatus.INFO, "Step :: Click on material master record role ");
			System.out.println("Step :: Click on material master record role");
			common.log("Click on material master workflow role");
			driver.findElement(By.xpath(materrialMasterRecordOption)).click();
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
		}
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
 * Verify Copy Existing Record
 *
 */

	public void copyRecord() {
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(search);
		common.pause(5);

		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = driver.findElement(By.xpath(materialMasterNum)).getText();
		System.out.println("Step:: Material master number is ::" + mmN);

		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		System.out.println("Step :: Click on copy");
		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption,"Select Sequential material option").click();
		}
		else {
			System.out.println("Step :: Click on material workflow");
			common.log("Click on material workflow");
			common.findElement(materrialMasterRecordOption).click();
			common.pause(5);
		}
//		String rN = driver.findElement(By.xpath(recordno)).getAttribute("value");
//		System.out.println("Step:: Record number is == > " + rN);
//		common.log("Record number is == > " + rN);
//		assertEquals(rN, mmN);

		common.waitForElement(plantD);
		String plantData = driver.findElement(By.xpath(plantD)).getText();
		test.log(LogStatus.INFO, "Step :: Field records" + plantData);
		System.out.println("Step:: Field records :" + plantData);

		// verifying records fields
		String plD = "";
		boolean t = driver.findElement(By.xpath(plantDatatwo)).isDisplayed();
		if (t == true) {

			plD = driver.findElement(By.xpath(plantDatatwo)).getText();
			test.log(LogStatus.INFO, "Step :: Plant record is displaying" + plD);
			System.out.println("Plant records is displayed ==>" + plD);
			common.log("Plant records is displayed ==>" + plD);

		} else {
			test.log(LogStatus.INFO, "Step :: Plant record does not displayed");
			System.out.println("Plant records is not displayed");
			common.log("Plant records is not displayed");
		}
		String valD = "";

		if (common.isElementPresent(valuationD)) {
			boolean valData = driver.findElement(By.xpath(valuationD)).isDisplayed();
			if (valData == true) {
				valD = driver.findElement(By.xpath(valuationD)).getText();
				test.log(LogStatus.INFO, "Step :: valuation records is displayed: " + valD);
				System.out.println("Step:: valuation records is displayed: " + valD);
				common.log("valuation records is displayed: " + valD);
			}
		}
		test.log(LogStatus.INFO, "Step :: click on copy button ");
		System.out.println("Step :: click on copy button");
		common.log("Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(10);
		// verifying records in new record form
		String nTitle = driver.findElement(By.xpath(newRecordTitle)).getText();
		test.log(LogStatus.INFO, "Step :: New form title is ::" + nTitle);
		System.out.println("Step :: New form title is ==>" + nTitle);
		common.log("New form title is==>" + nTitle);

		//Verify New plant record
		String nPlantD = "";
		boolean newPlanData = driver.findElement(By.xpath(newPlantD)).isDisplayed();
		if (newPlanData == true) {
			nPlantD = driver.findElement(By.xpath(newPlantD)).getText();
			test.log(LogStatus.INFO, "Step :: New plant record field ==> " + nPlantD);
			System.out.println("Step :: New record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);


			if (common.isElementPresent(valuationD)) {
				String nValuationD = driver.findElement(By.xpath(valuationD)).getText();
				test.log(LogStatus.INFO, "Step :: New form valuation record field ==>" + nValuationD);
				System.out.println("Step :: New form valuation record field ==>" + nValuationD);
				common.log("Step :: New form valuation record is==>" + nValuationD);
				assertEquals(valD, nValuationD);
			}
		} else {
			System.out.println("Step :: New form valuation record field is not displaying");
			common.log("New form valuation record field is not displaying");

		}
		common.pause(20);
		common.findElement(submitBtn).click();
		common.pause(25);

		//If duplicate record popup appear then click on continue button
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}
		common.pause(10);

		common.refreshPage();

		common.pause(10);


	}
	/**
	 * verify Copy Record And Remove One Hierarchy Other Should NotRemove
	 *
	 */

	public void verify_Copy_Record_And_Remove_One_Hierarchy_Other_Should_Not_Remove() {
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(materialMaster);
		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = driver.findElement(By.xpath(materialMasterNum)).getText();
		System.out.println("Step :: Material master number is ::" + mmN);

		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		System.out.println("Step :: Click on copy");
		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		System.out.println("Step :: Click on material workflow");
		common.log("Click on material workflow");
		common.findElement(materrialMasterRecordOption).click();
		common.pause(40);

		String rN = driver.findElement(By.xpath(recordno)).getAttribute("value");
		System.out.println("Step:: Record number is == > " + rN);
		common.log("Record number is == > " + rN);
		assertEquals(rN, mmN);

		String plantData = driver.findElement(By.xpath(plantD)).getText();
		test.log(LogStatus.INFO, "Step :: Field records" + plantData);
		System.out.println("Step:: Field records :" + plantData);

		// verifying records fields
		String plD = "";
		boolean t = driver.findElement(By.xpath(plantDatatwo)).isDisplayed();
		if (t == true) {

			plD = driver.findElement(By.xpath(plantDatatwo)).getText();
			test.log(LogStatus.INFO, "Step :: Plant record is displaying" + plD);
			System.out.println("Plant records is displayed ==>" + plD);
			common.log("Plant records is displayed ==>" + plD);

		} else {
			test.log(LogStatus.INFO, "Step :: Plant record does not displayed");
			System.out.println("Plant records is not displayed");
			common.log("Plant records is not displayed");
		}
		String valD = "";

		if (common.isElementPresent(valuationD)) {
			boolean valData = driver.findElement(By.xpath(valuationD)).isDisplayed();
			if (valData == true) {
				valD = driver.findElement(By.xpath(valuationD)).getText();
				test.log(LogStatus.INFO, "Step :: valuation records is displayed: " + valD);
				System.out.println("Step:: valuation records is displayed: " + valD);
				common.log("valuation records is displayed: " + valD);
			}
		}

		common.findElementBy(valuationDataHierarchy, "Click and remove valuation data hierarchy").click();

		common.log("Verify Plant data hierarchy not removed");
		common.assertElementPresent(plantDataSelected);
		common.pause(5);

		System.out.println("Step :: Click on copy button");
		common.log("Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(10);

		common.findElementBy(valuationPlusIcon,"Click on + icon for Valuation hierarchy").click();
		common.pause(5);

		common.findElementBy(valuationFirstOption,"Select first option from Valuation hierarchy").click();
		common.pause(5);

		common.findElementBy(applyBtn,"Click on Apply button").click();
		common.pause(10);

		common.findElementBy(industrySec, "Select other value from Industry sector dropdown").click();

		common.findElementBy(industrySec, "Clear the value").clear();
		common.waitForElement(dropValue);

		String newIndustrySectorValue = driver.findElement(By.xpath(dropValue3)).getText();
		System.out.println("Step :: New selected value for Industry sector ==>" + newIndustrySectorValue);
		common.log("New selected value for Industry sector==>" + newIndustrySectorValue);

		common.findElementBy(dropValue3, "Select 3rd value").click();
		common.pause(5);


		// verifying records in new record form
		String nTitle = driver.findElement(By.xpath(newRecordTitle)).getText();
		test.log(LogStatus.INFO, "Step :: New form title is ::" + nTitle);
		System.out.println("Step :: New form title is ==>" + nTitle);
		common.log("New form title is==>" + nTitle);

		//Verify New plant record
		String nPlantD = "";
		boolean newPlanData = driver.findElement(By.xpath(newPlantD)).isDisplayed();
		if (newPlanData == true) {
			nPlantD = driver.findElement(By.xpath(newPlantD)).getText();
			test.log(LogStatus.INFO, "Step :: New plant record field ==> " + nPlantD);
			System.out.println("Step :: New record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);


			if (common.isElementPresent(valuationD)) {
				String nValuationD = driver.findElement(By.xpath(valuationD)).getText();
				test.log(LogStatus.INFO, "Step :: New form valuation record field ==>" + nValuationD);
				System.out.println("Step :: New form valuation record field ==>" + nValuationD);
				common.log("Step :: New form valuation record is==>" + nValuationD);
//				assertEquals(valD, nValuationD);
			}
		} else {
			System.out.println("Step :: New form valuation record field is not displaying");
			common.log("New form valuation record field is not displaying");

		}
		common.pause(20);
		common.log("Click on Submit button");
		common.findElement(submitBtn).click();
		common.pause(25);

		//If duplicate record popup appear then click on continue button
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}
		common.pause(10);

		common.refreshPage();

		common.pause(10);

		System.out.println("Step :: Verify Data tab available");
		common.log("Verify Data tab available");
		common.assertElementPresent(dataTab);


	}

	/**
	 * Verify Rejection Flow from Approver
	 *
	 */
	public void rejectionFlowFromApprover() {
		common.pause(20);

		test.log(LogStatus.INFO, "Step :: Go to the Home menu");
		System.out.println("Step :: Go to the Home menu");
		common.log("Go to the Home menu");

		driver.findElement(By.xpath(homeTab)).click();
		common.refreshPage();
		common.pause(25);

		test.log(LogStatus.INFO, "Step :: click on inbox Menu ");
		System.out.println("Step :: click on inbox Menu");
		common.log("Click on inbox Menu");
		driver.findElement(By.xpath(inboxMenu)).click();
		driver.findElement(By.xpath(inboxMenu)).click();
		common.pause(25);

		//If first value appear in Inbox menu then it will reject the flow from Approve option
		if (common.isDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on action button for first value").click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on approve");
			System.out.println("Step :: click on approve");
			common.log("Click on approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			System.out.println("Step :: click on approve drop-down icon");
			common.log("Click on approve drop-down icon");
			common.waitForElement(approveDropDownIcon);
			driver.findElement(By.xpath(approveDropDownIcon)).click();

			common.pause(5);
			test.log(LogStatus.INFO, "Step :: click on Send For Correction Option ");
			System.out.println("Step :: click on Send For Correction Option");
			common.log("Click on Send For Correction Option");
			driver.findElement(By.xpath(sendForCorrectionOption)).click();
			common.pause(15);

			test.log(LogStatus.INFO, "Step :: Enter rejection comment");
			System.out.println("Step :: Enter rejection comment");
			common.log("Enter rejection comment");
			driver.findElement(By.xpath(rejectionCommentBox)).sendKeys("Rejected new record");

			test.log(LogStatus.INFO, "Step :: click on Submit button for rejection Flow ");
			System.out.println("Step :: click on Submit for rejection Flow");
			common.log("Click on Submit for rejection Flow");
			driver.findElement(By.xpath(submitButtonRejectionFlow)).click();
			common.pause(15);

			//wait for My request tab present
			common.waitForElement(myReqTab);
			common.assertElementPresent(myReqTab);
		} else {

			test.log(LogStatus.INFO, "No records available");
			System.out.println("No records available");
			common.log("No records available");
		}
	}

	/**
	 * Verify Rejection Flow from Reviewer
	 *
	 */
	public void rejectionFlowFromReviewer() {
		common.pause(20);
		common.refreshPage();

		test.log(LogStatus.INFO, "Step :: Home tab opened");
		System.out.println("Step :: Home tab opened");
		common.log("Home tab opened");

		common.waitForElement(inboxMenu);
		test.log(LogStatus.INFO, "Step :: click on inbox Menu ");
		System.out.println("Step :: click on inbox Menu");
		common.log("Click on inbox Menu");
		driver.findElement(By.xpath(inboxMenu)).click();
		common.pause(25);

		//If first value appear in Inbox menu then it will reject the flow from Approve option
		if (common.isDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			driver.findElement(By.xpath(firstActionIconForInbox)).click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on approve");
			System.out.println("Step :: click on approve");
			common.log("Click on my approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			test.log(LogStatus.INFO, "Step :: click on approve down icon");
			System.out.println("Step :: click on approve down icon");
			common.log("Click on my down");
			common.waitForElement(approveDropDownIcon);
			driver.findElement(By.xpath(approveDropDownIcon)).click();

			common.pause(5);
			test.log(LogStatus.INFO, "Step :: click on Send For Correction Option ");
			System.out.println("Step :: click on Send For Correction Option");
			common.log("Click on Send For Correction Option");
			driver.findElement(By.xpath(sendForCorrectionOption)).click();
			common.pause(15);

			test.log(LogStatus.INFO, "Step :: Enter rejection comment");
			System.out.println("Step :: Enter rejection comment");
			common.log("Enter rejection comment");
			driver.findElement(By.xpath(rejectionCommentBox)).sendKeys("Rejected new record");

			test.log(LogStatus.INFO, "Step :: click on Submit button for rejection Flow ");
			System.out.println("Step :: click on Submit for rejectoin Flow");
			common.log("Click on Submit for rejection Flow");
			driver.findElement(By.xpath(submitButtonRejectionFlow)).click();
			common.pause(15);

			common.waitForElement(myReqTab);
			common.assertElementPresent(myReqTab);
		} else {

			test.log(LogStatus.INFO, "No records available");
			System.out.println("No records available");
			common.log("No records available");
		}
	}
}
