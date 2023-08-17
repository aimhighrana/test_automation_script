package Page;

import ServiceHelper.AuthenticationService;
import ServiceHelper.EnvironmentService;
import Utils.Common;
import Utils.Locators;
import contracts.IAuthenticationService;
import contracts.IEnvironmentService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddMaterialMaster extends Locators {

	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	public AddMaterialMaster(WebDriver driver) throws Exception {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();
	}

	/**
	 * Add New Material Master Record
	 */
	public void addNewMaterialMaster() throws IOException, InterruptedException {

		XSSFSheet sheet = common.getDataFromExcelSheet("Workflow_1_TestCases");

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left side menus");
		common.waitUntilElementToBeVisible(search);

		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//if Default view not appear them click on view dropdown icon and select Default view
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(newRecordBtn);
		common.log("Click on add new record button");

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();
		common.pause(5);
		common.waitUntilElementToBeVisible(flowList);

		//For SANDBOX perspective
		if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.pause(50);

			common.waitUntilElementToBeVisible(materialType);

			common.log("Select Material Type");
			common.findElement(materialType).click();
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Get Material type from Excel: " + sheet.getRow(1).getCell(0));
			common.type(materialType, sheet.getRow(1).getCell(0).getStringCellValue());
			common.pause(5);
			common.findElement(materialType).sendKeys(Keys.DOWN);
			common.findElement(materialType).sendKeys(Keys.ENTER);

			common.pause(5);

			common.findElementBy(industrySec, "Select Industry sector field").click();
			common.findElement(industrySec).click();
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Get Industry sector from Excel: " + sheet.getRow(1).getCell(1));
			common.type(industrySec, sheet.getRow(1).getCell(1).getStringCellValue());
			common.pause(5);
			common.findElement(industrySec).sendKeys(Keys.DOWN);
			common.findElement(industrySec).sendKeys(Keys.ENTER);

			common.log("Enter value in Material description field");
			common.log("Get Material description from Excel: " + sheet.getRow(1).getCell(3));
			common.findElement(materialDescFormView).sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());

			common.findElementBy(materialGroup, "Click on Material Group field").click();
			common.findElement(materialGroup).click();
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Get Material Group from Excel: " + sheet.getRow(1).getCell(2));
			common.findElement(materialGroup).sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
			common.pause(10);
			common.findElement(materialGroup).sendKeys(Keys.DOWN);
			common.findElement(materialGroup).sendKeys(Keys.ENTER);

			common.log("Enter value in Long description field");
			common.log("Get Long description from Excel: " + sheet.getRow(1).getCell(4));
			common.findElement(longDescriptionField).sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());

			common.pause(5);
			common.findElementBy(generalItemCatGroup, "Click on General Item Category Group field").click();
			common.findElement(generalItemCatGroup).click();
			common.waitUntilElementToBeVisible(dropValue);
			common.pause(5);
			common.log("Get General Item Category from Excel: " + sheet.getRow(1).getCell(5));
			common.findElement(generalItemCatGroupInput).sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
			common.pause(10);
			common.findElement(generalItemCatGroupInput).sendKeys(Keys.DOWN);
			common.findElement(generalItemCatGroupInput).sendKeys(Keys.ENTER);

			common.pause(5);
			common.findElement(grossWeightField).click();
			common.log("Enter value in Gross Weight field");
			common.log("Get Gross Weight from Excel: " + sheet.getRow(1).getCell(10));
			String grossWeightValue = String.valueOf(sheet.getRow(1).getCell(10));
			common.findElement(grossWeightField).sendKeys(grossWeightValue);
			common.pause(5);

			common.log("Enter value in Net Weight field");
			common.log("Get Net Weight from Excel: " + sheet.getRow(1).getCell(11));
			String netWeightValue = String.valueOf(sheet.getRow(1).getCell(11));
			common.findElement(netWeightField).sendKeys(netWeightValue);

			common.log("Enter value in Maximum Stock Level field");
			common.log("Get Maximum Level Stock from Excel: " + sheet.getRow(1).getCell(12));
			String maxStockLevelValue = String.valueOf(sheet.getRow(1).getCell(12));
			common.findElement(maxStockLevelField).sendKeys(maxStockLevelValue);

			common.pause(5);
			common.findElementBy(procurementTypeField, "Click on Procurement Type field").click();
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Get Procurement Type from Excel: " + sheet.getRow(1).getCell(13));
			common.type(procurementTypeFieldInput, sheet.getRow(1).getCell(13).getStringCellValue());
			common.pause(10);
			common.findElement(procurementTypeFieldInput).sendKeys(Keys.DOWN);
			common.findElement(procurementTypeFieldInput).sendKeys(Keys.ENTER);

			common.log("Enter value in Planned Delivery Time field");
			common.log("Get Planned Delivery Time from Excel: " + sheet.getRow(1).getCell(14));
			String plannedDeliveryValue = String.valueOf(sheet.getRow(1).getCell(14));
			common.findElement(plannedDeliveryTimeField).sendKeys(plannedDeliveryValue);

			common.log("Enter value in Reorder Point field");
			common.log("Get Reorder Point from Excel: " + sheet.getRow(1).getCell(9));
			String reorderPointValue = String.valueOf(sheet.getRow(1).getCell(9));
			common.findElement(reorderPointField).sendKeys(reorderPointValue);

			common.findElementBy(orderUnitField, "Click on Order Unit field").click();
			common.findElement(orderUnitField).click();
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Get Order Unit from Excel: " + sheet.getRow(1).getCell(7));
			common.type(orderUnitFieldVale, sheet.getRow(1).getCell(7).getStringCellValue());
			common.pause(10);
			common.findElement(orderUnitFieldVale).sendKeys(Keys.DOWN);
			common.findElement(orderUnitFieldVale).sendKeys(Keys.ENTER);
			common.pause(5);

			common.findElementBy(plusIconHersGrid, "Click on plus icon on HERS grid").click();
			common.waitUntilElementToBeVisible(mpnHersGrid);

			common.log("Enter value in MPN HERS Grid field");
			common.log("Get MPN HERS Grid from Excel: " + sheet.getRow(1).getCell(8));
			String mpnHersGridValue = String.valueOf(sheet.getRow(1).getCell(8));
			common.findElement(mpnHersGrid).sendKeys(mpnHersGridValue);
			common.pause(10);

			common.log("Enter value in Manufacturer HERS Grid field");
			common.log("Get Manufacturer HERS Grid from Excel: " + sheet.getRow(1).getCell(15));
//			String manufacturerHersGridValue = String.valueOf(sheet.getRow(1).getCell(15));
//			common.findElement(manufacturerHersGrid).sendKeys(manufacturerHersGridValue);
			common.pause(5);
			common.findElementBy(saveHersGrid, "Click on save on HERS Grid").click();
			common.pause(10);

			//commented because its auto populated
//            common.findElementBy(plantDataAddHierarchy, "Click on Plant Data - add... button").click();
//            common.waitUntilElementToBeVisible(searchBoxHierarchy);
//            common.log("Get Plant Data from Excel: " + sheet.getRow(1).getCell(22));
//            common.findElement(searchBoxHierarchy).sendKeys(sheet.getRow(1).getCell(22).getStringCellValue());
//            common.pause(5);
//            common.waitUntilElementToBeVisible(selectSearchedOption);
//            common.findElementBy(selectSearchedOption, "Select searched option").click();
//            common.waitUntilElementToBeVisible(applyBtn);
//            common.findElementBy(applyBtn, "Click on Apply button").click();

			//added wait for auto populate the hierarchy valuation and forecast
//            common.pause(5);
//            common.waitUntilElementToBeVisible(valuationDataAddHierarchy);

//            common.findElementBy(salesDataAddHierarchy, "Click on Sales Data - add... button").click();
//            common.waitUntilElementToBeVisible(searchBoxHierarchy);
//            common.log("Get Sales Data from Excel: " + sheet.getRow(1).getCell(4));
//            common.findElement(searchBoxHierarchy).sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
//            common.pause(5);
//            common.waitUntilElementToBeVisible(selectSearchedOption);
//            common.findElementBy(selectSearchedOption, "Select searched option").click();
//            common.waitUntilElementToBeVisible(applyBtn);
//            common.findElementBy(applyBtn, "Click on Apply button").click();

//            common.pause(5);
//            common.waitUntilElementToBeVisible(salesOrganisationData);
		}

		//If Manufacturer part number field appear then fill value for it
		common.log("Enter Manufacturer Part Number");
		common.log("Get Manufacturer Part Number from Excel: " + sheet.getRow(1).getCell(6));
		common.type(manufacturerPartNum, sheet.getRow(1).getCell(6).getStringCellValue());
		common.pause(10);

		String automationNumberValue = common.GenerateRandomNumber(8);
		common.findElementBy(automationNumberField,"Enter automation number: "+automationNumberValue).sendKeys(automationNumberValue);

		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(30);
		common.waitUntilElementToBeVisible(errorMessage);

		if (common.isElementDisplayed(errorMessage)) {

			common.log("Showing mandatory error");
			List<WebElement> webElements = driver.findElements(By.xpath("//p[@class='small ng-star-inserted']"));

			for (WebElement e : webElements) {
				common.log("Error: " + e.getText());
			}
		}

		common.log("Enter value in Material description field");
		common.log("Get Material description from Excel: " + sheet.getRow(2).getCell(3));
		common.type(materialDescFormView,sheet.getRow(2).getCell(3).getStringCellValue());
		common.pause(5);

		common.log("Enter value in Long description field");
		common.log("Get Long description from Excel: " + sheet.getRow(2).getCell(4));
		common.type(longDescriptionField,sheet.getRow(2).getCell(4).getStringCellValue());
		common.pause(5);

		common.log("Get Manufacturer number from Excel: " + sheet.getRow(2).getCell(17));
		common.findElementBy(manufacturerFieldValue,"Enter Manufacturer number").sendKeys(sheet.getRow(2).getCell(17).getStringCellValue());
		common.pause(10);

		common.log("Click on Order Unit field");
		common.scrollToElement(clearOrderUnitField);
		common.scrollToElement(clearOrderUnitField);
		common.jsClick(clearOrderUnitField);
		common.jsClick(orderUnitField1);
		common.jsClick(orderUnitField1);
		common.pause(10);
		common.waitUntilElementToBeVisible(dropValue);

		common.log("Get Order Unit from Excel: " + sheet.getRow(2).getCell(7));
		common.type(orderUnitFieldVale, sheet.getRow(2).getCell(7).getStringCellValue());
		common.pause(10);
		common.findElement(orderUnitFieldVale).sendKeys(Keys.DOWN);
		common.findElement(orderUnitFieldVale).sendKeys(Keys.ENTER);
		common.pause(5);

		common.log("Enter value in Reorder Point field");
		common.log("Get Reorder Point from Excel: " + sheet.getRow(2).getCell(9));
		String reorderPointValue = String.valueOf(sheet.getRow(2).getCell(9));
		common.click(reorderPointField);
		common.type(reorderPointField,reorderPointValue);
		common.pause(5);

		common.pause(5);
		common.findElement(grossWeightField).click();
		common.log("Enter value in Gross Weight field");
		common.log("Get Gross Weight from Excel: " + sheet.getRow(2).getCell(10));
		String grossWeightValue = String.valueOf(sheet.getRow(2).getCell(10));
		common.type(grossWeightField,grossWeightValue);
		common.pause(5);

		common.log("Enter value in Net Weight field");
		common.log("Get Net Weight from Excel: " + sheet.getRow(2).getCell(11));
		String netWeightValue = String.valueOf(sheet.getRow(2).getCell(11));
		common.type(netWeightField,netWeightValue);
		common.pause(5);

		common.log("Enter value in Maximum Stock Level field");
		common.log("Get Maximum Level Stock from Excel: " + sheet.getRow(2).getCell(12));
		String maxStockLevelValue = String.valueOf(sheet.getRow(2).getCell(12));
		common.type(maxStockLevelField,maxStockLevelValue);
		common.pause(5);

		common.log("Enter value in Planned Delivery Time field");
		common.log("Get Planned Delivery Time from Excel: " + sheet.getRow(2).getCell(14));
		String plannedDeliveryValue = String.valueOf(sheet.getRow(2).getCell(14));
		common.type(plannedDeliveryTimeField,plannedDeliveryValue);
		common.pause(5);

		common.findElementBy(actionIconHers,"Click on action icon for HERS grid").click();
		common.pause(5);
		common.findElementBy(editHers,"Click on edit").click();
		common.pause(10);

		common.log("Enter value in MPN HERS Grid field");
		common.log("Get MPN HERS Grid from Excel: " + sheet.getRow(2).getCell(8));
		String mpnHersGridValue = String.valueOf(sheet.getRow(2).getCell(8));
		common.type(mpnHersGrid,mpnHersGridValue);
		common.pause(5);

		common.log("Enter value in Manufacturer HERS Grid field");
		common.log("Get Manufacturer HERS Grid from Excel: " + sheet.getRow(2).getCell(15));
//		String manufacturerHersGridValue = String.valueOf(sheet.getRow(2).getCell(15));
//		common.findElement(manufacturerHersGrid).sendKeys(manufacturerHersGridValue);
		common.pause(5);

		common.findElementBy(saveHersGrid, "Click on save on HERS Grid").click();
		common.pause(10);

		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(10000);

		//If duplicate record popup appear then click on continue
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			common.findElementBy(continueDuplicateRecord, "Click on Continue button").click();
			common.pause(10);
		} else {

			common.log("No duplicate records");
		}

		//If something went error occurred then refresh page and select another value and click on submit
		if (common.isElementDisplayed(errorMessage)) {
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
		} else {

			common.log("No Something went error");
		}

		//Wait and get success message fore record creation
		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display:  " + successStr);

		common.waitUntilElementToBeVisible(dataTab);
		common.log("Verifying Data tab available");

		common.log("Refreshing page for visible latest created record");
		common.refreshPage();
		common.pause(10);
	}

	/**
	 * Add material master role with generate description
	 */
	public void createMaterialMasterWithGenerateDesc() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material master");
		common.waitUntilElementToBeVisible(materialMaster);
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
		common.waitUntilElementToBeVisible(newRecordBtn);
		common.log("Click on add new record button");
		common.pause(10);

		WebElement newButton = common.findElement(newRecordBtn);
		newButton.click();
		common.pause(5);

		if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
		} else {
			common.log("Click on material master workflow roles");
			common.waitUntilElementToBeVisible(materialMasterRoleValue);

			common.findElement(materialMasterRoleValue).click();
		}
		common.waitUntilElementToBeVisible(materialGroup);
		common.pause(10);

		if (common.isElementDisplayed(industrySec)) {
			common.waitUntilElementToBeVisible(industrySec);
			common.findElementBy(industrySec, "Click on Industry sector dropdown and select value from it").click();
			common.pause(5);
			if (common.isElementDisplayed(dropValue)) {
				common.waitUntilElementToBeVisible(dropValue);
				common.findElement(dropValue).click();
			}
		}
		common.pause(5);

		common.findElementBy(generateDesc, "Click on generate description").click();
		common.findElement(generateDesc).click();

		if (common.isElementDisplayed(xPlantMaterialStatusField)) {
			common.findElementBy(xPlantMaterialStatusField, "Select value from X-Plant Material Status field").click();
		}

		if (common.isElementDisplayed(sourceListDescription)) {
			common.findElementBy(sourceListDescription, "Select value from Source - List dropdown").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(dropValue);
			common.findElement(dropValue).click();
		}

		// Filling plant records
		common.log("-- Filling plant data --");
		common.log("Select plant value");

		common.findElement(plantdataPlusIcon).click();
		common.waitUntilElementToBeVisible(plantvalue);
		common.findElement(plantvalue).click();

		common.findElementBy(applyBtn, "Click on apply button").click();
		common.pause(5);

		common.log("Select MRP type");
		common.waitUntilElementToBeVisible(mrpType);
		common.pause(25);
		WebElement l = common.findElement(mrpTypeField);

		// Javascript executor
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);
		common.findElement(mrpType).click();
		common.pause(5);
		common.waitUntilElementToBeVisible(dropValue);
		common.findElement(dropValue).click();

		common.pause(10);
		common.log("Select Loading type");
		common.jsClick(loading);
		common.jsClick(loading);
		common.jsClick(loading);
		common.pause(5);
		common.waitUntilElementToBeVisible(dropValueLoading);
		common.findElement(dropValueLoading).click();

		common.log("-- Filling valuation data --");
		common.findElement(valuationPlusIcon).click();
		common.pause(5);
		common.findElement(newCheckbox).click();

		common.findElementBy(applyBtn, "Click on apply button").click();

		common.pause(10);

		if (common.isElementDisplayed(planingCycleField)) {
			common.findElementBy(planingCycleField, "Enter value in planing cycle field").sendKeys("10");
		}

		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(10);

		//If duplicate record popup appear then click on submit
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			common.findElement(continueDuplicateRecord).click();
		} else {

			common.log("No duplicate records");
		}

		//If something went error occurred then refresh page select another value and click on submit
		if (common.isElementDisplayed(errorMessage)) {

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
		} else {

			common.log("No Something went error");
		}

		common.log("Refreshing the page for visible latest created record");
		common.refreshPage();
		common.pause(10);

		common.waitUntilElementToBeVisible(searchB);
		String materialMasterNum = common.findElement(materialNumFromTbl).getText();
		common.log("Material master number is :  " + materialMasterNum);
		common.pause(10);

		common.waitUntilElementToBeVisible(searchB);
		common.findElementBy(searchB, "Click on Search field and search material master value").click();
		common.findElement(searchB).sendKeys(materialMasterNum);
		common.pause(10);
		//verify searched material master record present
		common.log("Material master number is available on table:  " + materialMasterNum);
		WebElement eleMaterialMaster = driver.findElement(By.xpath("//mark[normalize-space()='" + materialMasterNum + "']"));
		common.findElementBy(eleMaterialMaster, "Material master number verified");
	}

	/**
	 * Verify Material Master Process Log
	 */
	public void viewMaterialMasterProcessLog() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left side menus");

		common.waitUntilElementToBeVisible(search);
		common.log("search for material master ");
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from View dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(viewPLog, "Select view process log option").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(closeIconForProcessLog);

		if (common.isElementDisplayed(processLogTitle)) {
			common.waitUntilElementToBeVisible(processLogTitle);
			String pLog = common.findElement(processLogTitle).getText();
			common.log("Process Log Title is : " + pLog);

			common.findElement(processLogTitle).click();

			common.pause(10);
			String status = common.findElement(statusCom).getText();
			common.log("Process Log Status is : " + status);
			assertEquals(status, "COMPLETED");

			common.log("Click on view change");
			common.jsClick(completedViewProcessLog);
			common.pause(5);
			common.waitUntilElementToBeVisible(headerData);
			Boolean header = common.findElement(headerData).isDisplayed();
			common.log("Title is Header data :  >>" + header);
			common.pause(5);

			common.log("Close View change page ");
			common.jsClick(closeIcoForViewChange);
			common.pause(5);

			common.log("Click on view email logs");

			common.findElement(viewEmailLogs).click();
			common.waitUntilElementToBeVisible(viewDetailsHeader);

			List<WebElement> eleColumns = driver.findElements(By.xpath("(//tr[@role='row'])[1]//th"));
			common.log("Columns in email logs page : >>");
			for (WebElement e : eleColumns) {
				common.log(e.getText());
				common.log(e.getText());
			}
			common.pause(5);
			common.log("Close View email logs page ");
			common.jsClick(crossIconViewEmailLogs);
			common.pause(5);
			common.log("Close View process log page ");
			common.jsClick(closeIconForProcessLog);
		} else if (common.isElementDisplayed(errorMessage)){
			String strProcessLog = common.findElementBy(errorMessage, "Getting logs from view process log").getText();
			common.log("View process log:  " + strProcessLog);
		}
		else {
			common.log("Blank page appear in view process log popup");
		}
		common.findElementBy(closeIconForProcessLog,"Close the process log popup").click();
		common.pause(5);
	}

	/**
	 * Verify Material Master completed Process Log
	 */
	public void viewMaterialMasterCompletedProcessLog() {

		//wait for data tab
		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");

		common.waitUntilElementToBeVisible(search);
		common.log("search for material master ");
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
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
		common.waitUntilElementToBeVisible(materialNumFromTbl);

		common.waitUntilElementToBeVisible(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue, "Click on acton icon for first value").click();

		common.pause(5);
		common.findElementBy(viewPLog, "Click on view process log option ").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {

			String pLog = common.findElement(processLogTitle).getText();
			common.log("Process Log Title, Record, Date&Time is is : " + pLog);

			common.findElement(processLogTitle).click();
			common.pause(10);

			common.waitUntilElementToBeVisible(statusCom);
			String status = common.findElement(statusCom).getText();
			common.log("Process Log Status is : " + status);
			assertEquals(status, "COMPLETED");
			common.pause(10);
			common.log("Click on view change");
			common.findElement(completedViewProcessLog).click();
			common.pause(10);

			Boolean header = common.findElement(headerData).isDisplayed();
			common.log("-- Header title is displaying ");
			common.log("Title is Header data :  >>" + header);

			common.waitUntilElementToBeVisible(fieldNameHeader);
			common.findElementBy(fieldNameHeader, "Field Name header is available");
			common.findElementBy(beforeChangeHeader, "Before Change header is available");
			common.findElementBy(afterChangeHeader, "After Change header is available");
			common.log("First row data:  ");
			for (int i = 1; i <= 3; i++) {
				WebElement firstRowData = driver.findElement(By.xpath("//div[3]/table[1]/tbody[1]/tr[1]/td[" + i + "]"));
				if (common.isElementDisplayed(firstRowData)) {
					String str = common.findElement(firstRowData).getText();
					common.log(str);
				}
			}
			//expand header data
			//common.expandingHeadData();

			common.log("Click on close icon for view change");
			common.jsClick(closeIcoForViewChange);
			common.pause(5);

		} else {
			common.log("System activities taking longer than usual , please wait while we process your request and update logs.");
		}
		common.log("Click on close icon for Process log popup");
		common.jsClick(closeIconForProcessLog);

	}

	/**
	 * Verify Approve Status
	 */
	public void approveStatus() {

		//wait for Home tab
		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.pause(5);
		//wait for Inbox menu
		common.waitUntilElementToBeVisible(inboxMenu);
		common.findElementBy(inboxMenu, "Click on Inbox menu").click();
		common.findElement(inboxMenu).click();

		common.pause(10);
		if (common.isElementDisplayed(firstActionIconForInbox)) {
			//wait for first value
			common.waitUntilElementToBeVisible(firstActionIconForInbox);

			common.log("Click on action menu for first row");
			common.findElement(firstActionIconForInbox).click();

			common.log("Click on approve");
			common.findElement(approveBtn).click();

			common.waitUntilElementToBeVisible(headerData);
			common.findElementBy(headerData, "Verify Header data appear");

			if (common.isElementDisplayed(sequentialHeader)) {
				common.findElementBy(materialDescReviewer, "Enter value in Material description field").sendKeys("Material desc 123");
				//	common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
				common.findElementBy(divisionField, "Select value from Division dropdown").click();
				common.waitUntilElementToBeVisible(dropValue);
				common.findElement(dropValue).click();
				common.pause(5);
			}
			//If Manufacturer part number field appear then fill value for it
			if (common.isElementDisplayed(manufacturerPartNum)) {

				common.log("Enter Manufacturer Part Number");
				common.findElement(manufacturerPartNum).sendKeys("12345");
				common.pause(10);
			} else {

				common.log("No need to enter Manufacturer Part Number");
			}
			common.waitUntilElementToBeVisible(approveButton);
			common.findElementBy(approveButton, "Click on Approve").click();
			common.pause(2);

			if (common.isElementDisplayed(duplicateRecordHeader)) {

				common.log("Duplicate records");
				common.findElementBy(continueDuplicateRecord, "CLick on Continue").click();
			} else {

				common.log("No duplicate records");
			}

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display:  " + successStr);
			common.waitUntilElementToBeVisible(inboxMenu);
		} else {
			common.log("Nothing to see here message appear");
		}

	}

	/**
	 * Re-Approve Rejected Task
	 */
	public void reApprove_Rejected_Task_Status() {

		//wait for Home tab
		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		//wait for Inbox menu
		common.waitUntilElementToBeVisible(myReqTab);
		common.findElementBy(myReqTab, "Click on My Request menu").click();
		common.findElement(myReqTab).click();

		//wait for first value
		common.waitUntilElementToBeVisible(firstActionIconForInbox);

		common.log("Click on action menu for first row");
		common.findElement(firstActionIconForInbox).click();

		common.log("Click on approve");
		common.findElement(approveBtn).click();

		common.waitUntilElementToBeVisible(headerData);
		common.findElementBy(headerData, "Verify Header data appear");

		if (common.isElementDisplayed(sequentialHeader)) {
			common.findElementBy(materialDescReviewer, "Enter value in Material description field").sendKeys("Material desc 123");
			//	common.jsClick(oldMaterialNumField);
			//	common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
			common.findElementBy(divisionField, "Select value from Division dropdown").click();
			common.waitUntilElementToBeVisible(dropValue);
			common.findElement(dropValue).click();
		}
		common.waitUntilElementToBeVisible(approveButton);
		common.log("click on Approve button");

		common.findElement(approveButton).click();
		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display:  " + successStr);
		common.waitUntilElementToBeVisible(inboxMenu);
	}

	/**
	 * Verify Claim Status
	 */
	public void claimStatus() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		//wait for Inbox menu
		common.waitUntilElementToBeVisible(inboxMenu);

		common.log("Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

		//wait for first value of Inbox menu
		common.waitUntilElementToBeVisible(firstActionIconForInbox);

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
			common.waitUntilElementToBeVisible(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox, "Click on action icon for first value").click();
			common.pause(10);

			common.log("Click on my viewProcessLog");

			common.findElement(processLogOption).click();
			common.pause(10);

			//wait for label
			common.waitUntilElementToBeVisible(lblText);

			common.pause(10);
		} else {

			common.log("Claim option not available");
		}

	}

	/**
	 * Verify Claim Status
	 */
	public void claimUnclaimStatus() {
		common.pause(10);

		//wait and click on Inbox menu
		common.waitUntilElementToBeVisible(inboxMenu);
		common.jsClick(inboxMenu);
		common.click(inboxMenu);

		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox, "Click on first value action button").click();

		common.pause(5);
		common.waitUntilElementToBeVisible(claim);
		common.log("Click on claim");
		common.findElement(claim).click();

		//wait for success message
		common.waitUntilElementToBeVisible(successMessageToast);

		common.log("Click on my request");
		common.pause(10);
		common.findElement(myReqTab).click();

		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(5);

		common.log("Click on my viewProcessLog");
		common.waitUntilElementToBeVisible(processLogOption);
		common.findElement(processLogOption).click();
		common.pause(10);
		if (common.isElementDisplayed(lblText)) {
			//wait for label text
			common.findElementBy(lblText, "Process log verified");
		}

		common.pause(10);
		common.log("Click on close icon");
		common.jsClick(crossIconS);

		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();
		common.pause(10);

		common.log("Click on claim");
		common.findElement(unclaim).click();

		//wait and click on Inbox menu
		common.waitUntilElementToBeVisible(inboxMenu);
		common.findElement(inboxMenu).click();
		common.pause(5);

		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox, "Click on first value action icon").click();

		common.waitUntilElementToBeVisible(processLog);
		common.findElementBy(processLog, "Click on process log").click();

		common.pause(5);
		common.waitUntilElementToBeVisible(lblText);

		common.jsClick(crossIconS);
		common.pause(5);
		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		common.findElement(firstActionIconForInbox).click();

		common.log("Click on approve");
		common.findElement(approveVal).click();
		common.pause(5);

		common.log("Click on drop down");
		common.findElement(approveDropDownIcon).click();

		common.pause(5);
		common.log("Click on save as draft");
		common.findElement(draft).click();
		common.pause(10);

		//wait for My request header
		common.waitUntilElementToBeVisible(myRrequestHeader);

	}

	/**
	 * Verify Save as a Draft
	 */
	public void saveDraft() {
		common.pause(10);
		common.refreshPage();

		common.log("Click on Material master from left nav");

		common.waitUntilElementToBeVisible(myReqTab);
		common.log("Click on my request");
		common.findElement(myReqTab).click();
		common.findElement(myReqTab).click();
		common.pause(25);

		//If value appear ion first row then select approve and click on save as draft
		if (common.isElementDisplayed(firstActionIconForInbox)) {

			common.waitUntilElementToBeVisible(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox, "Click on action icon for first value").click();
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
	 */
	public void doUpdate() {
		common.log("Click on Data tab");
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.refreshPage();

		common.waitUntilElementToBeVisible(materialMaster);
		common.log("Click on Material master from left nav");
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialMasterNumber = common.findElement(materialMasterNum).getText();
		common.log("Material master number is : " + materialMasterNumber);
		common.log("Set filter status as a system");
		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		common.findElementBy(actionIconForFirstValue, "Click on action icon for first value").click();

		common.log("Click on edit");
		common.findElement(edit).click();
		common.pause(10);

		if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.pause(5);
		} else {

			common.log("Click on material master workflow role");
			common.findElement(materialMasterRecordOption).click();
			common.pause(10);
			common.waitUntilElementToBeVisible(headerData);
			common.pause(10);

			common.log("Select Industry Sector");
			common.waitUntilElementToBeVisible(industrySec);
			common.findElement(industrySec).click();
			common.pause(5);
			common.findElement(dropValue).click();

			common.findElementBy(plusStorageData, "Click on plus icon for Storage Data hierarchy");

			common.findElementBy(firstOptionStorageData, "Select first option for Storage Data hierarchy");

			common.findElementBy(applyFilterButton, "Click on apply button");
			common.pause(5);
		}

		common.log("Click on save button");
		common.waitUntilElementToBeVisible(uSaveBtn);
		common.findElement(uSaveBtn).click();
		common.pause(10);

		//if duplicate record appear then click on continue and something went occurred then refresh page and submit again
		if (common.isElementDisplayed(duplicateRecordHeader)) {

			common.log("Duplicate records");
			common.findElement(continueDuplicateRecord).click();
		} else {

			common.log("No duplicate records");
		}
		if (common.isElementDisplayed(errorMessage)) {
			common.log("Something went error appear");
			common.refreshPage();
			common.pause(10);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			common.log("Click on save button");
			common.findElement(uSaveBtn).click();
			common.pause(10);
		} else {

			common.log("No Something went error");
		}
		common.waitUntilElementToBeVisible(actionIconForFirstValue);
		common.findElement(actionIconForFirstValue).click();
		common.log("Click on view Process log");
		common.waitUntilElementToBeVisible(viewProcessLogOption);
		common.findElement(viewProcessLogOption).click();

		common.waitUntilElementToBeVisible(processLogStatus);
		String viewProcessLog = common.findElement(processLogStatus).getText();
		common.log("View Process log =>>" + viewProcessLog);

	}

	/**
	 * Verify Copy Existing Record
	 */
	public void copyRecord() {
		common.log("Click on Data tab");
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.refreshPage();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(search);
		common.pause(5);

		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = common.findElement(materialMasterNum).getText();
		common.log("Material master number is : " + mmN);

		common.pause(10);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Select Sequential material option").click();
		} else {
			common.log("Click on material workflow");
			common.findElement(materialMasterRecordOption).click();
			common.pause(5);
		}

		common.waitUntilElementToBeVisible(plantD);
		String plantData = common.findElement(plantD).getText();
		common.log("Field records" + plantData);

		// verifying records fields
		String plD = "";
		boolean t = common.findElement(plantDatatwo).isDisplayed();
		if (t == true) {

			plD = common.findElement(plantDatatwo).getText();
			common.log("Plant records is displayed ==>" + plD);

		} else {
			common.log("Plant records is not displayed");
		}
		String valD = "";

		if (common.isElementDisplayed(valuationD)) {
			boolean valData = common.findElement(valuationD).isDisplayed();
			if (valData == true) {
				valD = common.findElement(valuationD).getText();
				common.log("valuation records is displayed:  " + valD);
			}
		}
		common.log("Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(5);
		common.waitUntilElementToBeVisible(newRecordTitle);
		// verifying records in new record form
		String nTitle = common.findElement(newRecordTitle).getText();
		common.log("New form title is==>" + nTitle);

		//Verify New plant record
		String nPlantD = "";
		boolean newPlanData = common.findElement(newPlantD).isDisplayed();
		if (newPlanData) {
			nPlantD = common.findElement(newPlantD).getText();
			common.log("New record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);


			if (common.isElementDisplayed(valuationD)) {
				String nValuationD = common.findElement(valuationD).getText();
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
	 */

	public void verify_Copy_Record_And_Remove_One_Hierarchy_Other_Should_Not_Remove() {
		common.log("Click on Data tab");
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.refreshPage();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		String mmN = common.findElement(materialMasterNum).getText();
		common.log("Material master number is : " + mmN);

		common.pause(10);
		common.findElementBy(actionIconForFirstValue, "Click on action icon for first value").click();

		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		common.log("Click on material workflow");
		common.findElement(materialMasterRecordOption).click();
		common.pause(10);

		common.waitUntilElementToBeVisible(recordno);
		String rN = common.findElement(recordno).getAttribute("value");
		common.log("Record number is == > " + rN);
		assertEquals(rN, mmN);

		String plantData = common.findElement(plantD).getText();
		common.log("Field records : " + plantData);

		// verifying records fields
		String plD = "";
		boolean t = common.findElement(plantDatatwo).isDisplayed();
		if (t) {
			plD = common.findElement(plantDatatwo).getText();
			common.log("Plant records is displayed ==>" + plD);

		} else {
			common.log("Plant records is not displayed");
		}
		String valD = "";

		if (common.isElementDisplayed(valuationD)) {
			boolean valData = common.findElement(valuationD).isDisplayed();
			if (valData == true) {
				valD = common.findElement(valuationD).getText();
				common.log("valuation records is displayed:  " + valD);
			}
		}

		common.findElementBy(valuationDataHierarchy, "Click and remove valuation data hierarchy").click();

		common.log("Verify Plant data hierarchy not removed");
		common.assertElementPresent(plantDataSelected);
		common.pause(5);

		common.log("Click on copy button");
		common.findElement(copyBtn).click();

		common.pause(5);
		common.waitUntilElementToBeVisible(valuationPlusIcon);
		common.findElementBy(valuationPlusIcon, "Click on + icon for Valuation hierarchy").click();
		common.pause(5);

		common.findElementBy(valuationFirstOption, "Select first option from Valuation hierarchy").click();
		common.pause(5);

		common.findElementBy(applyBtn, "Click on Apply button").click();
		common.pause(10);

		common.findElementBy(industrySec, "Select other value from Industry sector dropdown").click();

		common.findElementBy(industrySec, "Clear the value").clear();
		common.waitUntilElementToBeVisible(dropValue);

		String newIndustrySectorValue = common.findElement(dropValue3).getText();
		common.log("New selected value for Industry sector==>" + newIndustrySectorValue);

		common.findElementBy(dropValue3, "Select 3rd value").click();
		common.pause(5);

		// verifying records in new record form
		String nTitle = common.findElement(newRecordTitle).getText();
		common.log("New form title is==>" + nTitle);

		//Verify New plant record
		String nPlantD = "";
		boolean newPlanData = common.findElement(newPlantD).isDisplayed();
		if (newPlanData) {
			nPlantD = common.findElement(newPlantD).getText();
			common.log("New record plant record field ==>" + nPlantD);
			assertEquals(plD, nPlantD);


			if (common.isElementDisplayed(valuationD)) {
				String nValuationD = common.findElement(valuationD).getText();
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
			common.findElement(continueDuplicateRecord).click();
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
	 */
	public void rejectionFlowFromApprover() {
		common.pause(10);

		common.log("Go to the Home menu");

		common.findElement(homeTab).click();
		common.refreshPage();
		common.pause(25);

		common.findElementBy(inboxMenu, "Click on inbox Menu").click();
		common.findElement(inboxMenu).click();
		common.pause(15);

		//If first value appear in Inbox menu then it will reject the flow from Approve option
		if (common.isElementDisplayed(firstActionIconForInbox)) {

			common.waitUntilElementToBeVisible(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox, "Click on action button for first value").click();
			common.pause(10);

			common.log("Click on approve");
			common.findElement(approveVal).click();
			common.pause(5);

			common.log("Click on approve drop-down icon");
			common.waitUntilElementToBeVisible(approveDropDownIcon);
			common.findElement(approveDropDownIcon).click();

			common.pause(5);
			common.waitUntilElementToBeVisible(sendForCorrectionOption);
			common.log("Click on Send For Correction Option");
			common.findElement(sendForCorrectionOption).click();
			common.pause(5);

			common.waitUntilElementToBeVisible(rejectionCommentBox);
			common.findElementBy(rejectionCommentBox, "Enter rejection comment").sendKeys("Rejected new record");

			common.findElementBy(submitButtonRejectionFlow, "Click on Submit for rejection Flow").click();
			common.pause(10);

			//wait for My request tab present
			common.waitUntilElementToBeVisible(myReqTab);
			common.assertElementPresent(myReqTab);
		} else {

			common.log("No records available");
		}
	}

	/**
	 * Verify Rejection Flow from Reviewer
	 */
	public void rejectionFlowFromReviewer() {
		common.pause(10);
		common.refreshPage();

		common.log("Home tab opened");

		common.waitUntilElementToBeVisible(inboxMenu);
		common.log("Click on inbox Menu");
		common.findElement(inboxMenu).click();
		common.pause(25);

		//If first value appear in Inbox menu then it will reject the flow from Approve option
		if (common.isElementDisplayed(firstActionIconForInbox)) {

			common.waitUntilElementToBeVisible(firstActionIconForInbox);
			common.findElement(firstActionIconForInbox).click();
			common.pause(10);

			common.log("Click on my approve");
			common.findElement(approveVal).click();
			common.pause(5);

			common.log("Click on my down");
			common.waitUntilElementToBeVisible(approveDropDownIcon);
			common.findElement(approveDropDownIcon).click();

			common.pause(5);
			common.log("Click on Send For Correction Option");
			common.findElement(sendForCorrectionOption).click();
			common.pause(10);

			common.log("Enter rejection comment");
			common.findElement(rejectionCommentBox).sendKeys("Rejected new record");

			common.log("Click on Submit for rejection Flow");
			common.findElement(submitButtonRejectionFlow).click();
			common.pause(10);

			common.waitUntilElementToBeVisible(myReqTab);
			common.assertElementPresent(myReqTab);
		} else {

			common.log("No records available");
		}
	}

	/**
	 * Re-Approve Rejected Task Status With Extend Plant Data
	 */
	public void reApprove_Rejected_Task_Status_With_Extend_Plant_Data() {

		//wait for Home tab
		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.pause(5);

		//wait for Inbox menu
		common.waitUntilElementToBeVisible(myReqTab);
		common.findElementBy(myReqTab, "Click on My Request menu").click();
		common.pause(5);

		//wait for first value
		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		common.findElementBy(firstActionIconForInbox, "Click on action menu for first row").click();

		common.log("Click on approve");
		common.waitUntilElementToBeVisible(approveBtn);
		common.findElement(approveBtn).click();

		common.waitUntilElementToBeVisible(headerData);
		common.findElementBy(headerData, "Verify Header data appear");

		if (common.isElementDisplayed(sequentialHeader)) {
			common.findElementBy(materialDescReviewer, "Enter value in Material description field").sendKeys("Material desc 123");
			//	common.findElementBy(oldMaterialNumField,"Enter old Material number").sendKeys("54321");
			common.findElementBy(divisionField, "Select value from Division dropdown").click();
			common.waitUntilElementToBeVisible(dropValue);
			common.findElement(dropValue).click();
		}
		common.waitUntilElementToBeVisible(addPlantData);
		common.findElementBy(addPlantData, "Click on Add Plant data").click();
		common.waitUntilElementToBeVisible(searchPlantData);
		WebElement valueChecked = driver.findElement(By.xpath("//input[@aria-checked='true']"));
		if (common.isElementDisplayed(valueChecked)) {
			common.findElementBy(valueChecked, "Uncheck the selected hierarchy").click();
		}
		common.findElementBy(searchPlantData, "Enter value 004").sendKeys("0004");
		common.waitUntilElementToBeVisible(searchedPantValue);
		common.pause(5);
		common.findElementBy(searchedPantValue, "Select searched value").click();
		common.pause(5);
		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(5);
		if (common.isElementDisplayed(planingCycleField)) {
			common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
		}

		common.pause(10);
		common.waitUntilElementToBeVisible(saveButtonFilterPopup);
		common.findElement(saveButtonFilterPopup).click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: " + successStr);
		common.waitUntilElementToBeVisible(inboxMenu);
	}
	public void approveMaterialCreationByApprover() {

		//wait for Home tab
		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.pause(5);
		//wait for Inbox menu
		common.waitUntilElementToBeVisible(inboxMenu);
		common.findElementBy(inboxMenu, "Click on Inbox menu").click();
		common.findElement(inboxMenu).click();

		common.pause(10);
		if (common.isElementDisplayed(firstActionIconForInbox)) {
			//wait for first value
			common.waitUntilElementToBeVisible(firstActionIconForInbox);

			common.log("Click on action menu for first row");
			common.findElement(firstActionIconForInbox).click();

			common.log("Click on approve");
			common.findElement(approveBtn).click();

			common.waitUntilElementToBeVisible(headerData);
			common.findElementBy(headerData, "Verify Header data appear");
			common.waitUntilElementToBeVisible(approveButton);
			common.findElementBy(approveButton, "Click on Approve").click();
			common.pause(2);

			if (common.isElementDisplayed(duplicateRecordHeader)) {

				common.log("Duplicate records");
				common.findElementBy(continueDuplicateRecord, "CLick on Continue").click();
			} else {

				common.log("No duplicate records");
			}

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display:  " + successStr);
			common.waitUntilElementToBeVisible(inboxMenu);
		} else {
			common.log("Nothing to see here message appear");
		}
	}
}
