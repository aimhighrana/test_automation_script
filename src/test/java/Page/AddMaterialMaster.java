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
	Properties obj = new Properties();

	public AddMaterialMaster(WebDriver driver) throws FileNotFoundException {

		super(driver);

	}

	/**
	 * Add New Material Master
	 *
	 */
	public void addNewMaterialMaster() {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();
		test.log(LogStatus.INFO, "click on Material master from leftnav");
		System.out.println("Step :: click on Material master from leftnav");
		common.log("Click on Material master from leftnav");
		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(newRecordBtn);
		test.log(LogStatus.INFO, "click on new record button");
		System.out.println("Step :: click on add new record button");
		common.log("Click on add new record button");

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();

		test.log(LogStatus.INFO, "click on material master workflow roles");
		System.out.println("Step :: click on material master workflow roles");
		common.log("Click on material master workflow roles");
		common.waitForElement(materialMasterroleValue);

		driver.findElement(By.xpath(materialMasterroleValue)).click();
		common.waitForElement(industrySec);

		common.findElement(industrySec).click();
		common.waitForElement(dropValue);
		common.findElement(dropValue).click();
		common.pause(5);
		if (common.isDisplayed(
				"//p[@class='small strong no-wrap ng-star-inserted'][normalize-space()='Material Type']//..//..//div//input") == true) {

			System.out.println("Step :: Select Material Type");
			driver.findElement(By.xpath(
							"//p[@class='small strong no-wrap ng-star-inserted'][normalize-space()='Material Type']//..//..//div//input"))
					.click();
			driver.findElement(By.xpath("//span[normalize-space()='ERSA -- Spare Part']")).click();

			common.pause(10);
		} else {

			System.out.println("No need to select Material Type");
		}

		// Filling plant records
		System.out.println("Step :: -- Filling plant data --");
		test.log(LogStatus.INFO, "Step :: -- Filling plant data --");
		test.log(LogStatus.INFO, "Step :: Select plant value");
		System.out.println("Step :: Select plant value");
		common.log("Select plant value");

		common.findElement(plantdataPlusIcon).click();
		common.waitForElement(plantvalue);
		common.findElement(plantvalue).click();
		common.findElement(applyBtn).click();

		common.waitForElement("//p[contains(text(),'MRP Type')]");
		WebElement l = driver.findElement(By.xpath("//p[contains(text(),'MRP Type')]"));
		// Javascript executor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);

		common.waitForElement(mrpType);
		System.out.println("Step :: Select MRP type");
		common.log("Select MRP type");
		common.findElement(mrpType).click();
		common.pause(10);

		common.waitForElement(dropValue);
		common.findElement(dropValue).click();

		common.pause(5);
		common.scrollPage();
//		test.log(LogStatus.INFO, "Step :: Select MRP controller");
//		System.out.println("Step :: Select MRP controller");
//		common.log("Select MRP controller");
//		common.findElement(mrpController).click();
//		common.pause(10);
//		common.findElement(dropValue).click();
		common.pause(5);
		common.waitForElement(loading);
		common.findElement(loading).click();
		common.pause(5);
		common.findElement(dropValueLoading).click();
		test.log(LogStatus.INFO, "Step :: -- Filling valuation data --");
		System.out.println("Step :: -- Filling valuation data --");
		common.waitForElement(valuationPlusIcon);
		common.findElement(valuationPlusIcon).click();

		common.waitForElement(newCheckbox);

		test.log(LogStatus.INFO, "Step :: Select NEW checkbox option and Apply");
		System.out.println("Step :: Select NEW checkbox option and Apply");
		common.findElement(newCheckbox).click();

		common.findElement(applyBtn).click();
		common.pause(10);

		test.log(LogStatus.INFO, "Step :: Select Valuation Cat. option");
		System.out.println("Step :: Select Valuation Cat. option");
		common.findElement(valCat).click();
		common.pause(5);
		common.findElement(dropValue).click();
		common.pause(10);

		if (common.isDisplayed(
				"//p[@class='xsmall strong ng-star-inserted'][normalize-space()='Manufacturer Part Number']//..//..//..//div//input") == true) {

			System.out.println("Step :: Enter Manufacturer Part Number");
			driver.findElement(By.xpath(
							"//p[@class='xsmall strong ng-star-inserted'][normalize-space()='Manufacturer Part Number']//..//..//..//div//input"))
					.sendKeys("12345");
			common.pause(10);
		} else {

			System.out.println("No need to enter Manufacturer Part Number");
		}


		common.pause(5);
		// p[normalize-space()='Moving Price']//..//..//..//div//input
		// p[normalize-space()='Price Unit']//..//..//..//div//input
		test.log(LogStatus.INFO, "Step :: Click on submit button");
		System.out.println("Step :: click on submit button");
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(20);
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
			common.pause(10);
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
			test.log(LogStatus.INFO, "Step :: -- click on sumbit button");
			System.out.println("Step :: click on submit button");
			common.log("click on submit button");
			common.findElement(submitBtn).click();
			common.pause(40);
		}
		else {

			System.out.println("Step :: No Something went error");
		}


		common.assertElementNotPresent(industrySec);
		test.log(LogStatus.INFO, "Step :: Verifying Data tab available");
		System.out.println("Step :: Verifying Data tab available");

	}

	/**
	 * Add material master role with generate description
	 *
	 */
	public void createMaterialMasterWithGenerateDesc() {
		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: click on materiial master from left nav");
		System.out.println("Step :: click on Material master from leftnav");
		common.log("Click on Material master from leftnav");

		common.pause(10);
		common.findElement(materialMaster).click();
		common.pause(10);
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
		test.log(LogStatus.INFO, "Step :: click on material master workflow roles");
		System.out.println("Step :: click on material master workflow roles");
		common.log("Click on material master workflow roles");
		common.waitForElement(materialMasterroleValue);

		common.findElement(materialMasterroleValue).click();
		common.waitForElement(materialGroup);
		// driver.findElement(By.xpath(materialGroup)).click();
//		test.log(LogStatus.INFO, "Step :: Select material master group value");
//		System.out.println("Step :: Select material group value");
//		common.log("Select material group value");

		// common.findElement(materialGroupValue).click();
		common.pause(10);
//		common.findElement(is).click();
//		common.pause(5);
//		common.findElement(Isval).click();

		common.findElement(industrySec).click();
		common.pause(5);
		common.findElement(dropValue).click();

		common.pause(20);

		common.findElement(generateDesc).click();
		common.findElement(generateDesc).click();
		test.log(LogStatus.INFO, "Step :: Select class");
		System.out.println("Step :: Select class");
		common.log("Selec class");
		common.pause(20);
		common.findElement(claS).click();
		common.findElement(classval).click();
		common.pause(3);

		// Filling plant records
		test.log(LogStatus.INFO, "Step :: -- Filling plant data -- ");
		System.out.println("Step :: -- Filling plant data --");

		test.log(LogStatus.INFO, "Step :: select plant value ");
		System.out.println("Step :: Select plant value");
		common.log("Select plant value");

		common.findElement(plantdataPlusIcon).click();
		common.pause(10);
		common.findElement(plantvalue).click();
		common.findElement(applyBtn).click();
		common.scrollPage();

		common.waitForElement(mrpType);

		common.pause(25);
		WebElement l = driver.findElement(By.xpath("//p[contains(text(),'MRP Type')]"));
		// Javascript executor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);

		common.waitForElement(mrpType);
		System.out.println("Step :: Select MRP type");
		common.log("Select MRP type");
		common.findElement(mrpType).click();
		common.pause(10);

		common.waitForElement(dropValue);
		common.findElement(dropValue).click();

		common.pause(10);
		common.scrollPage();
//		test.log(LogStatus.INFO, "Step :: Select MRP controller");
//		System.out.println("Step :: Select MRP controller");
//		common.log("Select MRP controller");
//		common.findElement(mrpController).click();
//		common.pause(10);
//		common.findElement(dropValue).click();
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

		common.findElement(applyBtn).click();
		common.pause(5);
		common.findElement(valCat).click();
		common.pause(5);
		common.findElement(dropValue).click();

		common.pause(20);
		for (int j = 0; j < 2; j++) {
			common.scrollPage();
		}

//		WebElement l1 = driver.findElement(By.xpath("//h4[contains(text(),'Language Grid')]"));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l1);
//
//		common.pause(10);
//
//		common.findElement(langcheckbox).click();
//		common.pause(10);
//		common.findElement(lngdelButton).click();
//		common.pause(15);
//		common.findElement(purchaseCheckbox).click();
//		common.findElement(lngdelButton).click();
//		common.pause(10);
		test.log(LogStatus.INFO, "Step :: -- click on sumbit button");
		System.out.println("Step :: click on submit button");
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(20);
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
			test.log(LogStatus.INFO, "Step :: -- click on sumbit button");
			System.out.println("Step :: click on submit button");
			common.log("click on submit button");
			common.findElement(submitBtn).click();

			common.pause(40);
		}
		else {

			System.out.println("Step :: No Something went error");
		}
		common.pause(40);

		for (int j = 0; j < 2; j++) {
			common.refreshPage();
		}
		common.pause(20);
		String materialMasterNum = common.findElement(materialNumFromTbl).getText();
		test.log(LogStatus.INFO, "Step :: -- Material maste number is ");
		System.out.println("Step :: Material master number is ::" + materialMasterNum);
		common.log("Material master nubmer is :: " + materialMasterNum);
		common.pause(30);
		common.waitForConditionIsElementPresent(searchB);
		common.findElement(searchB).click();
		driver.findElement(By.xpath(searchB)).sendKeys(materialMasterNum);
		common.pause(25);
		common.assertElementPresent("//mark[normalize-space()='" + materialMasterNum + "']");
	}

	/**
	 * Verify Material Master Process Log
	 *
	 */
	public void viewMaterialMasterProcessLog() {

		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		common.refreshPage();
		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from leftnav");
		common.log("Click on Material master from leftnav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(15);
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialMasterNumber = common.findElement(materialNumFromTbl).getText();
		/**
		 * search box functionality not working hence, placing the code as commented
		 *
		 */
		System.out.println("Step :: Enter value in search box ==>" + materialMasterNumber);
		common.log("Enter the value in search box ==>" + materialMasterNumber);
//		driver.findElement(By.xpath(searchBox)).sendKeys(code);
		common.pause(25);

		common.findElement(actionIconForFirstValue).click();

		common.findElement(viewPLog).click();

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
		common.pause(15);
		Boolean header = driver.findElement(By.xpath(headerData)).isDisplayed();
		test.log(LogStatus.INFO, "Step :: -- Header title is displaying ");
		System.out.println("Step :: Header Title is displaying:: >>" + header);
		common.log("Title is Header data :: >>" + header);

		common.pause(5);

//		String cDate = driver.findElement(By.xpath(creationDate)).getText();
//		System.out.println("Step :: creation date  is :: " + cDate);
//		common.log("creation date is :: " + cDate);

		System.out.println("Step :: Close View change page ");
		common.log("Close View change page ");
		common.findElement(closeIcoForViewChange).click();

		System.out.println("Step :: Close process log page ");
		common.log("Close View process log page ");
		common.waitForConditionIsElementPresent(closeIconForrPrrocessLog);
		common.findElement(closeIconForrPrrocessLog).click();

	}

	/**
	 * Verify Material Master Process Log
	 *
	 */
	public void viewMaterialMasterCompletedProcessLog() {

		common.waitForElement(search);
		common.pause(5);
		common.refreshPage();
		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from leftnav");
		common.log("Click on Material master from leftnav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);
		
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(materialNumFromTbl);
		String materialMasterNumber = common.findElement(materialNumFromTbl).getText();
		/**
		 * search box functionality not working hence, placing the code as commented
		 *
		 */
		common.waitForElement(actionIconForFirstValue);
		common.findElement(actionIconForFirstValue).click();
		common.findElement(viewPLog).click();
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

//		String cDate = driver.findElement(By.xpath(creationDate)).getText();
//		System.out.println("Step :: creation date  is :: " + cDate);
//		common.log("creation date is :: " + cDate);

		common.exandingHeadData();

		common.findElement(closeIcoForViewChange).click();

		common.waitForConditionIsElementPresent(closeIconForrPrrocessLog);
		common.findElement(closeIconForrPrrocessLog).click();

	}

	/**
	 * Verify Approve Status
	 *
	 */
	public void approveStatus() {

		common.waitForElement(inboxMenu);

		test.log(LogStatus.INFO, "Step :: Click on Inbox menu ");
		System.out.println("Step :: Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

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
		common.waitForElement(approveButton);
		test.log(LogStatus.INFO, "Step :: click on Apprrove button ");
		System.out.println("Step :: click on Approve button");
		common.log("Click on submit button");

		common.findElement(approveButton).click();
		common.pause(10);
		common.waitForElement(inboxMenu);

	}

	/**
	 * Verify Claim Status
	 *
	 */
	public void claimStatus() {

		common.waitForElement(inboxMenu);

		test.log(LogStatus.INFO, "Step :: Click on Inbox menu ");
		System.out.println("Step :: Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

		common.waitForElement(firstActionIconForInbox);

		test.log(LogStatus.INFO, "Step :: Click on action menu for first row ");
		System.out.println("Step :: Click on action menu for first row");
		common.log("Click on action menu for first row");
		common.findElement(firstActionIconForInbox).click();
		common.pause(20);

		if (common.isDisplayed(claim) == true) {

			test.log(LogStatus.INFO, "Step :: click on claim");
			System.out.println("Step :: click on claim");
			common.log("Click on claim");
			common.findElement(claim).click();

			common.waitForElement("//div[@id='cdk-overlay-13']");

			test.log(LogStatus.INFO, "Step :: click on my request ");
			System.out.println("Step :: click on my request");
			common.log("Click on my request");

			common.findElement(myReqTab).click();

			common.pause(25);
			common.waitForElement(firstActionIconForInbox);
			common.findElement(firstActionIconForInbox).click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on view Process Log ");
			System.out.println("Step :: click on viewProcessLog");
			common.log("Click on my viewProcessLog");

			common.findElement(processLogOption).click();
			common.pause(20);
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
		common.waitForElement(inboxMenu);
		WebElement inboxClick = driver.findElement(By.xpath(inboxMenu));
		common.jsClick(inboxClick);
		common.click(inboxMenu);
		common.waitForElement(firstActionIconForInbox);

		common.findElement(firstActionIconForInbox).click();
		common.waitForElement(claim);
		test.log(LogStatus.INFO, "Step :: click on claim");
		System.out.println("Step :: click on claim");
		common.log("Click on claim");
		common.findElement(claim).click();

		common.waitForElement("//div[@id='cdk-overlay-13']");

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
		common.waitForElement(lblText);

		common.pause(20);
		driver.findElement(By.xpath(crossIconS)).click();

		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(20);
		test.log(LogStatus.INFO, "Step :: click on unclaim");
		System.out.println("Step :: click on unclaim");
		common.log("Click on claim");
		common.findElement(unclaim).click();

		common.waitForElement(inboxMenu);
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();
		common.waitForElement(firstActionIconForInbox);

		common.findElement(firstActionIconForInbox).click();
		common.waitForElement(processLog);

		common.findElement(processLog).click();

		common.pause(5);
		common.waitForElement(lblText);

		driver.findElement(By.xpath(crossIconS)).click();
		common.waitForElement(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();

		test.log(LogStatus.INFO, "Step :: click on approve");
		System.out.println("Step :: click on approve");
		common.log("Click on my approve");
		driver.findElement(By.xpath(approveVal)).click();
		common.pause(5);

		test.log(LogStatus.INFO, "Step :: click on down");
		System.out.println("Step :: click on down");
		common.log("Click on my down");
		driver.findElement(By.xpath(approveDropDownIcon)).click();

		common.pause(5);
		test.log(LogStatus.INFO, "Step :: click on save as draft ");
		System.out.println("Step :: click on save as draft");
		common.log("Click on save as draft");
		driver.findElement(By.xpath(draft)).click();
		common.pause(10);
		common.waitForElement(myRrequestHeader);

	}

	/**
	 * Verify Save as a Draft
	 *
	 */
	public void saveDraft() {
		common.pause(50);
//		test.log(LogStatus.INFO, "Step :: entered record no is::");
//		System.out.println("entered record no is ::" + code);

		// Fcommon.waitForElement(dataTab);
		// driver.findElement(By.xpath(dataTab)).click();
		common.refreshPage();
		// common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: click on material master from left nav");
		System.out.println("Step :: click on Material master from leftnav");
		common.log("Click on Material master from leftnav");

		// driver.findElement(By.xpath(materialMaster)).click();
		// common.pause(10);
		// common.waitForElement(firstActionIconForInbox);
		// driver.findElement(By.xpath(firstActionIconForInbox)).click();

		common.waitForElement(myReqTab);
		test.log(LogStatus.INFO, "Step :: click on my request ");
		System.out.println("Step :: click on my request");
		common.log("Click on my request");
		driver.findElement(By.xpath(myReqTab)).click();
		driver.findElement(By.xpath(myReqTab)).click();
		common.pause(25);

		if (common.isDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			driver.findElement(By.xpath(firstActionIconForInbox)).click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on approve");
			System.out.println("Step :: click on approve");
			common.log("Click on my approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			test.log(LogStatus.INFO, "Step :: click on down");
			System.out.println("Step :: click on down");
			common.log("Click on my down");
			driver.findElement(By.xpath(approveDropDownIcon)).click();

			common.pause(5);
			test.log(LogStatus.INFO, "Step :: click on save as draft ");
			System.out.println("Step :: click on save as draft");
			common.log("Click on save as draft");
			driver.findElement(By.xpath(draft)).click();
			common.pause(15);

			common.assertElementPresent(myReqTab);
		} else {

			test.log(LogStatus.INFO, "No records available");
			System.out.println("No records available");
			common.log("No records available");
		}
	}

	/**
	 * Verify Update Scenario
	 *
	 */
	public void doUpdate() {
		common.waitForElement(dataTab);

		test.log(LogStatus.INFO, "Step :: Click on Data tab");
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();
		common.refreshPage();

		common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: Click on material master from left nav");
		System.out.println("Step :: Click on Material master from leftnav");
		common.log("Click on Material master from leftnav");

		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);
		
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialmasterNumber = driver.findElement(By.xpath(materialMasterNum)).getText();
		System.out.println("Step :: Material master number is ::" + materialmasterNumber);
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
		test.log(LogStatus.INFO, "Step :: Click on material mastetr record role ");
		System.out.println("Step :: Click on material master record role");
		common.log("Click on material master workflow role");
		driver.findElement(By.xpath(materrialMasterRecordOption)).click();
		common.pause(10);
		common.waitForElement(headerData);
		common.pause(20);

		test.log(LogStatus.INFO, "Step :: Select Industry Sector ");
		System.out.println("Step :: Select Industry Sector");
		common.log("Select Industry Sector");
		common.findElement(industrySec).click();
		common.pause(5);
		common.findElement(dropValue).click();

		common.waitForElement(uSaveBtn);

		test.log(LogStatus.INFO, "Step :: Click on save button");
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(80);

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
		common.pause(20);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		test.log(LogStatus.INFO, "Step :: Click on view process log");
		System.out.println("Step :: Click on viewProcess log");
		common.log("Click on view Process log");
		common.waitForElement(viewProcessLogOption);
		driver.findElement(By.xpath(viewProcessLogOption)).click();

		common.waitForElement(processLogStatus);
		String viewProcessLog = driver.findElement(By.xpath(processLogStatus)).getText();

		System.out.println("Step :: ViewProcess log =>>" + viewProcessLog);
		common.log(" view Process log =>>" + viewProcessLog);

		String test = viewProcessLog;

//		String strProcesLogStatus = test.substring(15, 22);
//		System.out.println("Process log status is:: " + strProcesLogStatus);
//		String exp = "changed";
//		assertEquals(strProcesLogStatus, exp);

	}

	public void copyrecord() {
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();
		common.refreshPage();

		common.waitForElement(materialMaster);
		test.log(LogStatus.INFO, "Step :: click on materiial master from left nav");
		System.out.println("Step :: click on Material master from leftnav");
		common.log("Click on Material master from leftnav");

		driver.findElement(By.xpath(materialMaster)).click();
		common.pause(10);
		
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = driver.findElement(By.xpath(materialMasterNum)).getText();

		System.out.println("Step:: Material master number is ::" + mmN);
		System.out.println("Step :: set filter as System");
		common.log("set filter as system");
		// driver.findElement(By.xpath(filterI)).sendKeys("SYS");
		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		test.log(LogStatus.INFO, "Step :: click on copy ");
		System.out.println("Step :: click on copy");
		common.log("Step :: click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		test.log(LogStatus.INFO, "Step :: click on matetial workflow ");
		System.out.println("Step :: click on material workflow");
		common.log("Step :: click on material workflow");
		common.findElement(materrialMasterRecordOption).click();
		common.pause(40);

		String rN = driver.findElement(By.xpath(recordno)).getAttribute("value");
		System.out.println("record number is == > " + rN);
		assertEquals(rN, mmN);

		String plantData = driver.findElement(By.xpath(plantD)).getText();
		test.log(LogStatus.INFO, "Step :: Field records" + plantData);
		System.out.println("Field records ::" + plantData);
		// verifying records fields

		String plD = "";
		boolean t = driver.findElement(By.xpath(plantDatatwo)).isDisplayed();
		if (t == true) {

			plD = driver.findElement(By.xpath(plantDatatwo)).getText();
			test.log(LogStatus.INFO, "Step :: plant record is displaying" + plD);
			System.out.println("plant records is dispalyed ==>" + plD);

		} else {
			test.log(LogStatus.INFO, "Step :: plant record does not displayed");
			System.out.println("plant records is not dispalyed");
		}
		String valD = "";

		boolean s = driver.findElement(By.xpath(valuationD)).isDisplayed();
		if (s == true) {
			valD = driver.findElement(By.xpath(valuationD)).getText();
			test.log(LogStatus.INFO, "Step :: valuation records is displayed" + valD);
			System.out.println("valuation records is dispalyed");
			System.out.println(valD);
		}

		test.log(LogStatus.INFO, "Step :: click on copy button ");
		System.out.println("Step :: click on copy button");
		common.log("Step :: Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(10);
		// verifying records in new record form
		String nTitle = driver.findElement(By.xpath(newRecordTitle)).getText();
		test.log(LogStatus.INFO, "Step :: new form title is ::" + nTitle);
		System.out.println("Step :: new form title is ==>" + nTitle);
		common.log("Step :: new form title is==>" + nTitle);

		String nPlantD = "";
		boolean n = driver.findElement(By.xpath(newPlantD)).isDisplayed();
		if (n == true) {
			nPlantD = driver.findElement(By.xpath(newPlantD)).getText();
			test.log(LogStatus.INFO, "Step :: new plant record field ==> " + nPlantD);
			System.out.println("Step :: new record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);

			String nValuationD = driver.findElement(By.xpath(valuationD)).getText();
			test.log(LogStatus.INFO, "Step :: new form valuatiion record field ==>" + nValuationD);
			System.out.println("Step :: new form valuatiion record field ==>" + nValuationD);
			common.log("Step :: New form valuation record is==>" + nValuationD);
			assertEquals(valD, nValuationD);
		} else {
			test.log(LogStatus.INFO, "Step :: new form plant record is not displaying ");
			System.out.println("Step :: new form plant record is not displaying ");
			System.out.println("Step :: new form  valuation record field is not displayin");
		}
		common.pause(50);
		// common.type(oldMaterialNumber, "123432");
		common.findElement(submitBtn).click();
		common.pause(25);
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}
		common.pause(10);

		for (int i = 0; i <= 3; i++) {
			common.pause(5);
			common.refreshPage();
		}
		common.pause(15);

		common.findElement(actionIconForFirstValue).click();
		common.pause(3);
		System.out.println("Step ::--------- Navigating for Material master form summary ----------");
		test.log(LogStatus.INFO, "Step :: --------- Navigating for Material master form summary ---------- ");
		common.findElement(summaryval).click();
		common.pause(3);
		common.findElement(materrialMasterRecordOption).click();

		test.log(LogStatus.INFO, "Step :: form title is ==> " + nTitle);
		System.out.println("Step :: form title is ==>" + nTitle);
		common.log("Step :: title is==>" + nTitle);

		common.pause(25);

		// catch all input elements into list
		List<WebElement> myList = driver
				.findElements(By.xpath("//div[@class='f-col form-area-container ng-star-inserted']//input"));

		// myList contains all field values

		List<String> all_elements_text = new ArrayList<>();

		for (int i = 0; i < myList.size(); i++) {

			all_elements_text.add(myList.get(i).getAttribute("value"));

			// to print directly
			System.out.println(myList.get(i).getAttribute("value"));

		}

		boolean n1 = driver.findElement(By.xpath(newPlantD)).isDisplayed();
		if (n1 == true) {
			nPlantD = driver.findElement(By.xpath(newPlantD)).getText();

			test.log(LogStatus.INFO, "Step :: new record plant recrod field " + nPlantD);
			System.out.println("Step :: new record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);

			String nValuationD = driver.findElement(By.xpath(valuationD)).getText();
			test.log(LogStatus.INFO, "Step :: new form valuatioin record field " + nValuationD);
			System.out.println("Step :: new form valuatiion record field ==>" + nValuationD);
			common.log("Step :: New form valuation record is==>" + nValuationD);
			assertEquals(valD, nValuationD);
		} else {
			test.log(LogStatus.INFO, "Step :: new form plant record is not displaying ");
			System.out.println("Step :: new form plant record is not displaying ");
			System.out.println("Step :: new form  valuation record field is not displayin");
		}

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

		if (common.isDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			driver.findElement(By.xpath(firstActionIconForInbox)).click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on approve");
			System.out.println("Step :: click on approve");
			common.log("Click on my approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			test.log(LogStatus.INFO, "Step :: click on approver down icon");
			System.out.println("Step :: click on approve down icon");
			common.log("Click on my down");
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

		if (common.isDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			driver.findElement(By.xpath(firstActionIconForInbox)).click();
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: click on approve");
			System.out.println("Step :: click on approve");
			common.log("Click on my approve");
			driver.findElement(By.xpath(approveVal)).click();
			common.pause(5);

			test.log(LogStatus.INFO, "Step :: click on approver down icon");
			System.out.println("Step :: click on approve down icon");
			common.log("Click on my down");
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
