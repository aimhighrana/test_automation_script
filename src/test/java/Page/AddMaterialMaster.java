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

	public AddMaterialMaster(WebDriver driver) throws Exception {
		super(driver);
	}

	/**
	 * Add New Material Master Record
	 *
	 */
	public void addNewMaterialMaster() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left side menus");
		common.waitForElement(search);

		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//if Default view not appear them click on view dropdown icon and select Default view
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(newRecordBtn);
		common.log("Click on add new record button");

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();
		common.pause(5);

		//For SANDBOX perspective
		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.pause(5);

			common.waitForElement(xPlantMaterialStatusField);
			common.findElementBy(xPlantMaterialStatusField,"Select value from X-Plant Material Status field").click();
			common.findElement(xPlantMaterialStatusField).click();
			common.pause(5);
			common.waitForElement(dropValue);
			common.findElementBy(dropValue, "Select option").click();

		}
		//For QAH perspective
		else {

			common.log("Click on material master workflow roles");
			common.waitForElement(materialMasterRoleValue);
			driver.findElement(By.xpath(materialMasterRoleValue)).click();

			common.log("Click on Industry section dropdown and select value");
			common.waitForElement(industrySec);
			common.findElement(industrySec).click();

			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
			common.pause(5);
			// Filling plant records
			common.log("-- Filling plant data --");
			common.log("Select plant value");

			common.findElement(plantdataPlusIcon).click();
			common.waitForElement(plantvalue);
			common.findElement(plantvalue).click();
			common.pause(5);
			common.findElementBy(applyBtn,"Click on apply button").click();

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

			common.log("-- Filling valuation data --");
			common.waitForElement(valuationPlusIcon);
			common.findElementBy(valuationPlusIcon,"Click on + icon for Valuation").click();

			common.waitForElement(newCheckbox);
			common.findElement(newCheckbox).click();

			common.findElementBy(applyBtn,"Click on apply button").click();

			common.waitForElement(valCat);
			common.findElement(valCat).click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
			common.pause(10);
		}

		//If material type filed appear then select value from it
		if (common.isElementDisplayed("//p[@class='small strong no-wrap ng-star-inserted'][normalize-space()='Material Type']//..//..//div//input")) {

			common.log("Select Material Type");
			driver.findElement(By.xpath(
							"//p[@class='small strong no-wrap ng-star-inserted'][normalize-space()='Material Type']//..//..//div//input"))
					.click();
			driver.findElement(By.xpath("//span[normalize-space()='ERSA -- Spare Part']")).click();

			common.pause(5);
		} else {

			common.log("No need to select Material Type");
		}

		//If Manufacturer part number field appear then fill value for it
		if (common.isElementDisplayed(manufacturerPartNum)) {

			common.log("Enter Manufacturer Part Number");
			driver.findElement(By.xpath(manufacturerPartNum)).sendKeys("12345");
			common.pause(10);
		} else {

			common.log("No need to enter Manufacturer Part Number");
		}

		common.pause(5);
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(2);

		//If duplicate record popup appear then click on continue
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			common.findElementBy(continueDuplicateRecord,"Click on Continue button").click();
			common.pause(10);
		} else {

			common.log("No duplicate records");
		}

		//If something went error occurred then refresh page and select another value and click on submit
		if(common.isElementDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']"))
		{
			common.log("Something went error appear");
			common.refreshPage();
			common.pause(10);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			common.log("click on submit button");
			common.findElement(submitBtn).click();
			common.pause(10);
		}
		else {

			common.log("No Something went error");
		}

		//Wait and get success message fore record creation
		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);

		common.waitForElement(dataTab);
		common.log("Verifying Data tab available");

		common.log("Refreshing page for visible latest created record");
		common.refreshPage();
		common.pause(10);

	}

	/**
	 * Add material master role with generate description
	 *
	 */
	public void createMaterialMasterWithGenerateDesc() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.waitForElement(search);
		common.type(search,"Material master");
		common.waitForElement(materialMaster);
		common.log("Click on Material master from left side menus");

		common.pause(5);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then it select from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(newRecordBtn);
		common.log("Click on add new record button");
		common.pause(10);

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();
		common.pause(5);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
		}
		else {
			common.log("Click on material master workflow roles");
			common.waitForElement(materialMasterRoleValue);

			common.findElement(materialMasterRoleValue).click();
		}
		common.waitForElement(materialGroup);
		common.pause(10);

		if (common.isElementDisplayed(industrySec)) {
			common.waitForElement(industrySec);
			common.findElementBy(industrySec, "Click on Industry sector dropdown and select value from it").click();
			common.pause(5);
			if (common.isElementDisplayed(dropValue)) {
				common.waitForElement(dropValue);
				common.findElement(dropValue).click();
			}
		}
		common.pause(5);

		common.findElementBy(generateDesc,"Click on generate description").click();
		common.findElement(generateDesc).click();

		if (common.isElementDisplayed(xPlantMaterialStatusField))
		{
			common.findElementBy(xPlantMaterialStatusField,"Select value from X-Plant Material Status field").click();
		}

		if (common.isElementDisplayed(sourceListDescription)) {
			common.findElementBy(sourceListDescription, "Select value from Source - List dropdown").click();
			common.pause(5);
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
		}

		// Filling plant records
		common.log("-- Filling plant data --");
		common.log("Select plant value");

		common.findElement(plantdataPlusIcon).click();
		common.waitForElement(plantvalue);
		common.findElement(plantvalue).click();

		common.findElementBy(applyBtn,"Click on apply button").click();
		common.pause(5);

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
		common.log("Select Loading type");
		common.jsClick(loading);
		common.jsClick(loading);
		common.jsClick(loading);
		common.pause(5);
		common.waitForElement(dropValueLoading);
		common.findElement(dropValueLoading).click();

		common.log("-- Filling valuation data --");
		common.findElement(valuationPlusIcon).click();
		common.pause(5);
		common.findElement(newCheckbox).click();

		common.findElementBy(applyBtn,"Click on apply button").click();

		common.pause(10);

		if (common.isElementDisplayed(planingCycleField))
		{
			common.findElementBy(planingCycleField,"Enter value in planing cycle field").sendKeys("10");
		}

		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(10);

		//If duplicate record popup appear then click on submit
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			common.log("No duplicate records");
		}

		//If something went error occurred then refresh page select another value and click on submit
		if(common.isElementDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']"))
		{

			common.log("Something went error appear");
			common.refreshPage();
			common.pause(10);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			common.log("click on submit button");
			common.findElement(submitBtn).click();

			common.pause(10);
		}
		else {

			common.log("No Something went error");
		}

		common.log("Refreshing the page for visible latest created record");
		common.refreshPage();
		common.pause(10);

		common.waitForElement(searchB);
		String materialMasterNum = common.findElement(materialNumFromTbl).getText();
		common.log("Material master number is :: " + materialMasterNum);
		common.pause(10);

		common.waitForElement(searchB);
		common.findElementBy(searchB,"Click on Search field and search material master value").click();
		driver.findElement(By.xpath(searchB)).sendKeys(materialMasterNum);
		common.pause(10);
		//verify searched material master record present
		common.log("Material master number is available on table:: " + materialMasterNum);
		common.findElementBy("//mark[normalize-space()='" + materialMasterNum + "']","Material master number verified");
	}

	/**
	 * Verify Material Master Process Log
	 *
	 */
	public void viewMaterialMasterProcessLog() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left side menus");

		common.waitForElement(search);
		common.log("search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from View dropdown
		if (!common.isElementDisplayed(defaultView)) {

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
			common.log("Process Log Title is ::" + pLog);

			driver.findElement(By.xpath(processLogTitle)).click();

			common.pause(10);
			String status = driver.findElement(By.xpath(statusCom)).getText();
			common.log("Process Log Status is ::" + status);
			assertEquals(status, "COMPLETED");

			common.log("Click on view change");
			common.jsClick(completedViewProcessLog);
			common.pause(5);
			common.waitForElement(headerData);
			Boolean header = driver.findElement(By.xpath(headerData)).isDisplayed();
			common.log("Title is Header data :: >>" + header);
			common.pause(5);

			common.log("Close View change page ");
			common.jsClick(closeIcoForViewChange);
			common.pause(5);

			common.log("Close View process log page ");
			common.jsClick(closeIconForProcessLog);
		}
		else {
			String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
			common.log("View process log: "+strProcessLog);
		}

	}

	/**
	 * Verify Material Master completed Process Log
	 *
	 */
	public void viewMaterialMasterCompletedProcessLog() {

		//wait for data tab
		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		common.log( "search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

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
		common.pause(10);

		if(common.isElementDisplayed(processLogTitle)) {

			String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
			common.log("Process Log Title, Record, Date&Time is is ::" + pLog);

			driver.findElement(By.xpath(processLogTitle)).click();
			common.pause(10);

			common.waitForElement(statusCom);
			String status = driver.findElement(By.xpath(statusCom)).getText();
			common.log("Process Log Status is ::" + status);
			assertEquals(status, "COMPLETED");
			common.pause(10);
			common.log("Click on view change");
			common.findElement(completedViewProcessLog).click();
			common.pause(10);

			Boolean header = driver.findElement(By.xpath(headerData)).isDisplayed();
			common.log("-- Header title is displaying ");
			common.log("Title is Header data :: >>" + header);

			common.waitForElement(fieldNameHeader);
			common.findElementBy(fieldNameHeader, "Field Name header is available");
			common.findElementBy(beforeChangeHeader, "Before Change header is available");
			common.findElementBy(afterChangeHeader, "After Change header is available");
			common.log("First row data: ");
			for (int i = 1; i <= 3; i++) {
				if (common.isElementDisplayed("//div[3]/table[1]/tbody[1]/tr[1]/td[1]")) {
					String str = driver.findElement(By.xpath("//div[3]/table[1]/tbody[1]/tr[1]/td[" + i + "]")).getText();
					common.log(str);
				}
			}
			//expand header data
			//common.expandingHeadData();

			common.log("Click on close icon for view change");
			common.jsClick(closeIcoForViewChange);
			common.pause(5);

		}
		else {
			common.log("System activities taking longer than usual , please wait while we process your request and update logs.");
		}
		common.log("Click on close icon for Process log popup");
		common.jsClick(closeIconForProcessLog);

	}

	/**
	 * Verify Approve Status
	 *
	 */
	public void approveStatus() {

		//wait for Home tab
		common.waitForElement(homeTab);
		common.pause(5);
		common.findElementBy(homeTab,"Click on Home tab").click();

		//wait for Inbox menu
		common.waitForElement(inboxMenu);
		common.findElementBy(inboxMenu,"Click on Inbox menu").click();
		common.findElement(inboxMenu).click();

		common.pause(10);
		if (common.isElementDisplayed(firstActionIconForInbox)) {
			//wait for first value
			common.waitForElement(firstActionIconForInbox);

			common.log("Click on action menu for first row");
			driver.findElement(By.xpath(firstActionIconForInbox)).click();

			common.log("Click on approve");
			common.findElement(approveBtn).click();

			common.waitForElement(headerData);
			common.findElementBy(headerData, "Verify Header data appear");

			if (common.isElementDisplayed(sequentialHeader)) {
				common.findElementBy(materialDescReviewer, "Enter value in Material description field").sendKeys("Material desc 123");
				//	common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
				common.findElementBy(divisionField, "Select value from Division dropdown").click();
				common.waitForElement(dropValue);
				common.findElement(dropValue).click();
				common.pause(5);
			}
			//If Manufacturer part number field appear then fill value for it
			if (common.isElementDisplayed(manufacturerPartNum)) {

				common.log("Enter Manufacturer Part Number");
				driver.findElement(By.xpath(manufacturerPartNum)).sendKeys("12345");
				common.pause(10);
			} else {

				common.log("No need to enter Manufacturer Part Number");
			}
			common.waitForElement(approveButton);
			common.findElementBy(approveButton, "Click on Approve").click();
			common.pause(2);

			if (common.isElementDisplayed(duplicateRecordHeader)) {

				common.log("Duplicate records");
				driver.findElement(By.xpath(continueDuplicateRecord)).click();
			} else {

				common.log("No duplicate records");
			}

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
			common.waitForElement(inboxMenu);
		}
		else {
			common.log("Nothing to see here message appear");
		}

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

		common.log("Click on action menu for first row");
		driver.findElement(By.xpath(firstActionIconForInbox)).click();

		common.log("Click on approve");
		common.findElement(approveBtn).click();

		common.waitForElement(headerData);
		common.findElementBy(headerData,"Verify Header data appear");

		if (common.isElementDisplayed(sequentialHeader))
		{
			common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("Material desc 123");
		//	common.jsClick(oldMaterialNumField);
		//	common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
			common.findElementBy(divisionField,"Select value from Division dropdown").click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
		}
		common.waitForElement(approveButton);
		common.log("click on Approve button");

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

		common.log("Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

		//wait for first value of Inbox menu
		common.waitForElement(firstActionIconForInbox);

		common.log("Click on action menu for first row");
		common.findElement(firstActionIconForInbox).click();
		common.pause(10);

		//If claim option available then select and verify process log
		if (common.isDisplayed(claim) == true) {

			common.log("Click on claim");
			common.findElement(claim).click();
			common.pause(10);

			common.log("Click on my request");

			common.findElement(myReqTab).click();

			common.pause(25);
			common.waitForElement(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on action icon for first value").click();
			common.pause(10);

			common.log("Click on my viewProcessLog");

			common.findElement(processLogOption).click();
			common.pause(10);

			//wait for label
			common.waitForElement(lblText);

			common.pause(10);
		} else {

			common.log("Claim option not available");
		}

	}

	/**
	 * Verify Claim Status
	 *
	 */
	public void claimUnclaimStatus() {
		common.pause(10);

		//wait and click on Inbox menu
		common.waitForElement(inboxMenu);
		common.jsClick(inboxMenu);
		common.click(inboxMenu);

		common.waitForElement(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox,"Click on first value action button").click();

		common.pause(5);
		common.waitForElement(claim);
		common.log("Click on claim");
		common.findElement(claim).click();

		//wait for success message
		common.waitForElement("//div[@class='cdk-overlay-pane']");

		common.log("Click on my request");
		common.pause(10);
		common.findElement(myReqTab).click();

		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(5);

			common.log("Click on my viewProcessLog");
			common.waitForElement(processLogOption);
			common.findElement(processLogOption).click();
			common.pause(10);
			if (common.isElementDisplayed(lblText)) {
				//wait for label text
				common.findElementBy(lblText,"Process log verified");
			}

		common.pause(10);
			common.log("Click on close icon");
			common.jsClick(crossIconS);

		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(10);

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

		common.jsClick(crossIconS);
		common.pause(5);
		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();

		common.log("Click on approve");
		driver.findElement(By.xpath(approveVal)).click();
		common.pause(5);

		common.log("Click on drop down");
		driver.findElement(By.xpath(approveDropDownIcon)).click();

		common.pause(5);
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
		common.pause(10);
		common.refreshPage();

		common.log("Click on Material master from left nav");

		common.waitForElement(myReqTab);
		common.log("Click on my request");
		common.findElement(myReqTab).click();
		common.findElement(myReqTab).click();
		common.pause(25);

		//If value appear ion first row then select approve and click on save as draft
		if (common.isElementDisplayed(firstActionIconForInbox)) {

			common.waitForElement(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on action icon for first value").click();
			common.pause(10);

			common.log("Click on my approve");
			common.findElement(approveVal).click();
			common.pause(5);

			common.log("Click on my drop down");
			common.findElement(approveDropDownIcon).click();

			common.pause(5);
			common.log("Click on save as draft");
			common.findElement(draft).click();
			common.pause(10);

			//verify My request tab available
			common.assertElementPresent(myReqTab);
		} else {

			common.log("No records available");
		}
	}

	/**
	 * Verify Update Existing Record Scenario
	 *
	 */
	public void doUpdate() {
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		common.waitForElement(materialMaster);
		common.log("Click on Material master from left nav");

		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialMasterNumber = driver.findElement(By.xpath(materialMasterNum)).getText();
		common.log("Material master number is ::" + materialMasterNumber);
		common.log("Set filter status as a system");
		driver.findElement(By.xpath(statusFilter)).sendKeys("System");
		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		common.log("Click on edit");

		driver.findElement(By.xpath(edit)).click();
		common.pause(10);

		if(common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.pause(5);
		}
		else {

			common.log("Click on material master workflow role");
			driver.findElement(By.xpath(materialMasterRecordOption)).click();
			common.pause(10);
			common.waitForElement(headerData);
			common.pause(10);

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

		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(10);

		//if duplicate record appear then click on continue and something went occurred then refresh page and submit again
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			common.log("No duplicate records");
		}
		if(common.isElementDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']"))
		{
			common.log("Something went error appear");
			common.refreshPage();
			common.pause(10);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			common.log("Click on save button");
			driver.findElement(By.xpath(uSaveBtn)).click();
			common.pause(10);
		}
		else {

			common.log("No Something went error");
		}
		common.waitForElement(actionIconForFirstValue);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();
		common.log("Click on view Process log");
		common.waitForElement(viewProcessLogOption);
		driver.findElement(By.xpath(viewProcessLogOption)).click();

		common.waitForElement(processLogStatus);
		String viewProcessLog = driver.findElement(By.xpath(processLogStatus)).getText();
		common.log("View Process log =>>" + viewProcessLog);

	}

	/**
	 * Verify Copy Existing Record
	 *
	 */
	public void copyRecord() {
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		common.log("Click on Material master from left nav");
		common.waitForElement(search);
		common.pause(5);

		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = driver.findElement(By.xpath(materialMasterNum)).getText();
		common.log("Material master number is ::" + mmN);

		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption,"Select Sequential material option").click();
		}
		else {
			common.log("Click on material workflow");
			common.findElement(materialMasterRecordOption).click();
			common.pause(5);
		}
	//		String rN = driver.findElement(By.xpath(recordno)).getAttribute("value");
	//		common.log("Record number is == > " + rN);
	//		assertEquals(rN, mmN);

		common.waitForElement(plantD);
		String plantData = driver.findElement(By.xpath(plantD)).getText();
		common.log("Field records" + plantData);

		// verifying records fields
		String plD = "";
		boolean t = driver.findElement(By.xpath(plantDatatwo)).isDisplayed();
		if (t == true) {

			plD = driver.findElement(By.xpath(plantDatatwo)).getText();
			common.log("Plant records is displayed ==>" + plD);

		} else {
			common.log("Plant records is not displayed");
		}
		String valD = "";

		if (common.isElementDisplayed(valuationD)) {
			boolean valData = driver.findElement(By.xpath(valuationD)).isDisplayed();
			if (valData == true) {
				valD = driver.findElement(By.xpath(valuationD)).getText();
				common.log("valuation records is displayed: " + valD);
			}
		}
		common.log("Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(5);
		common.waitForElement(newRecordTitle);
		// verifying records in new record form
		String nTitle = driver.findElement(By.xpath(newRecordTitle)).getText();
		common.log("New form title is==>" + nTitle);

		//Verify New plant record
		String nPlantD = "";
		boolean newPlanData = driver.findElement(By.xpath(newPlantD)).isDisplayed();
		if (newPlanData) {
			nPlantD = driver.findElement(By.xpath(newPlantD)).getText();
			common.log("New record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);


			if (common.isElementDisplayed(valuationD)) {
				String nValuationD = driver.findElement(By.xpath(valuationD)).getText();
				common.log("New form valuation record is==>" + nValuationD);
				assertEquals(valD, nValuationD);
			}
		} else {
			common.log("New form valuation record field is not displaying");

		}
		common.pause(10);
		common.findElement(submitBtn).click();
		common.pause(25);

		//If duplicate record popup appear then click on continue button
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			common.findElement(continueDuplicateRecord).click();
		} else {

			common.log("No duplicate records");
		}
		common.refreshPage();
		common.pause(10);


	}
	/**
	 * verify Copy Record And Remove One Hierarchy Other Should NotRemove
	 *
	 */

	public void verify_Copy_Record_And_Remove_One_Hierarchy_Other_Should_Not_Remove() {
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		common.log("Click on Material master from left nav");
		common.waitForElement(materialMaster);
		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = driver.findElement(By.xpath(materialMasterNum)).getText();
		common.log("Material master number is ::" + mmN);

		common.pause(10);
		common.findElementBy(actionIconForFirstValue,"Click on action icon for first value").click();

		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		common.log("Click on material workflow");
		common.findElement(materialMasterRecordOption).click();
		common.pause(10);

		common.waitForElement(recordno);
		String rN = driver.findElement(By.xpath(recordno)).getAttribute("value");
		common.log("Record number is == > " + rN);
		assertEquals(rN, mmN);

		String plantData = driver.findElement(By.xpath(plantD)).getText();
		common.log("Field records :" + plantData);

		// verifying records fields
		String plD = "";
		boolean t = driver.findElement(By.xpath(plantDatatwo)).isDisplayed();
		if (t) {
			plD = driver.findElement(By.xpath(plantDatatwo)).getText();
			common.log("Plant records is displayed ==>" + plD);

		} else {
			common.log("Plant records is not displayed");
		}
		String valD = "";

		if (common.isElementDisplayed(valuationD)) {
			boolean valData = driver.findElement(By.xpath(valuationD)).isDisplayed();
			if (valData == true) {
				valD = driver.findElement(By.xpath(valuationD)).getText();
				common.log("valuation records is displayed: " + valD);
			}
		}

		common.findElementBy(valuationDataHierarchy, "Click and remove valuation data hierarchy").click();

		common.log("Verify Plant data hierarchy not removed");
		common.assertElementPresent(plantDataSelected);
		common.pause(5);

		common.log("Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(5);
		common.waitForElement(valuationPlusIcon);
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
		common.log("New selected value for Industry sector==>" + newIndustrySectorValue);

		common.findElementBy(dropValue3, "Select 3rd value").click();
		common.pause(5);


		// verifying records in new record form
		String nTitle = driver.findElement(By.xpath(newRecordTitle)).getText();
		common.log("New form title is==>" + nTitle);

		//Verify New plant record
		String nPlantD = "";
		boolean newPlanData = driver.findElement(By.xpath(newPlantD)).isDisplayed();
		if (newPlanData) {
			nPlantD = driver.findElement(By.xpath(newPlantD)).getText();
			common.log("New record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);


			if (common.isElementDisplayed(valuationD)) {
				String nValuationD = driver.findElement(By.xpath(valuationD)).getText();
				common.log("New form valuation record is==>" + nValuationD);
			}
		} else {
			common.log("New form valuation record field is not displaying");

		}
		common.pause(10);
		common.log("Click on Submit button");
		common.findElement(submitBtn).click();
		common.pause(25);

		//If duplicate record popup appear then click on continue button
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			common.log("No duplicate records");
		}
		common.pause(10);

		common.refreshPage();
		common.pause(10);

		common.log("Verify Data tab available");
		common.assertElementPresent(dataTab);
	}

	/**
	 * Verify Rejection Flow from Approver
	 *
	 */
	public void rejectionFlowFromApprover() {
		common.pause(10);

		common.log("Go to the Home menu");

		driver.findElement(By.xpath(homeTab)).click();
		common.refreshPage();
		common.pause(25);

		common.findElementBy(inboxMenu,"Click on inbox Menu").click();
		common.findElement(inboxMenu).click();
		common.pause(15);

		//If first value appear in Inbox menu then it will reject the flow from Approve option
		if (common.isElementDisplayed(firstActionIconForInbox)) {

			common.waitForElement(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on action button for first value").click();
			common.pause(10);

			common.log("Click on approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			common.log("Click on approve drop-down icon");
			common.waitForElement(approveDropDownIcon);
			driver.findElement(By.xpath(approveDropDownIcon)).click();

			common.pause(5);
			common.waitForElement(sendForCorrectionOption);
			common.log("Click on Send For Correction Option");
			driver.findElement(By.xpath(sendForCorrectionOption)).click();
			common.pause(5);

			common.waitForElement(rejectionCommentBox);
			common.findElementBy(rejectionCommentBox,"Enter rejection comment").sendKeys("Rejected new record");

			common.findElementBy(submitButtonRejectionFlow,"Click on Submit for rejection Flow").click();
			common.pause(10);

			//wait for My request tab present
			common.waitForElement(myReqTab);
			common.assertElementPresent(myReqTab);
		} else {

			common.log("No records available");
		}
	}

	/**
	 * Verify Rejection Flow from Reviewer
	 *
	 */
	public void rejectionFlowFromReviewer() {
		common.pause(10);
		common.refreshPage();

		common.log("Home tab opened");

		common.waitForElement(inboxMenu);
		common.log("Click on inbox Menu");
		common.findElement(inboxMenu).click();
		common.pause(25);

		//If first value appear in Inbox menu then it will reject the flow from Approve option
		if (common.isElementDisplayed(firstActionIconForInbox)) {

			common.waitForElement(firstActionIconForInbox);
			driver.findElement(By.xpath(firstActionIconForInbox)).click();
			common.pause(10);

			common.log("Click on my approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			common.log("Click on my down");
			common.waitForElement(approveDropDownIcon);
			driver.findElement(By.xpath(approveDropDownIcon)).click();

			common.pause(5);
			common.log("Click on Send For Correction Option");
			driver.findElement(By.xpath(sendForCorrectionOption)).click();
			common.pause(10);

			common.log("Enter rejection comment");
			driver.findElement(By.xpath(rejectionCommentBox)).sendKeys("Rejected new record");

			common.log("Click on Submit for rejection Flow");
			driver.findElement(By.xpath(submitButtonRejectionFlow)).click();
			common.pause(10);

			common.waitForElement(myReqTab);
			common.assertElementPresent(myReqTab);
		} else {

			common.log("No records available");
		}
	}
	/**
	 * Re-Approve Rejected Task Status With Extend Plant Data
	 *
	 */
	public void reApprove_Rejected_Task_Status_With_Extend_Plant_Data() {

		//wait for Home tab
		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"Click on Home tab").click();
		common.pause(5);

		//wait for Inbox menu
		common.waitForElement(myReqTab);
		common.findElementBy(myReqTab,"Click on My Request menu").click();
		common.pause(5);

		//wait for first value
		common.waitForElement(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox,"Click on action menu for first row").click();

		common.log("Click on approve");
		common.waitForElement(approveBtn);
		common.findElement(approveBtn).click();

		common.waitForElement(headerData);
		common.findElementBy(headerData,"Verify Header data appear");

		if (common.isElementDisplayed(sequentialHeader))
		{
			common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("Material desc 123");
		//	common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
			common.findElementBy(divisionField,"Select value from Division dropdown").click();
			common.waitForElement(dropValue);
			common.findElement(dropValue).click();
		}
		common.waitForElement(addPlantData);
		common.findElementBy(addPlantData,"Click on Add Plant data").click();
		common.waitForElement(searchPlantData);
		if (common.isElementDisplayed("//input[@aria-checked='true']")) {
			common.findElementBy("//input[@aria-checked='true']", "Uncheck the selected hierarchy").click();
		}
		common.findElementBy(searchPlantData,"Enter value 004").sendKeys("0004");
		common.waitForElement(searchedPantValue);
		common.pause(5);
		common.findElementBy(searchedPantValue,"Select searched value").click();
		common.pause(5);
		common.findElementBy(applyFilterButton,"Click on apply button").click();
		common.pause(5);
		if (common.isElementDisplayed(planingCycleField)) {
			common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
		}

		common.pause(10);
		common.waitForElement(saveButtonFilterPopup);
		common.findElement(saveButtonFilterPopup).click();

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
		common.waitForElement(inboxMenu);
	}
}
