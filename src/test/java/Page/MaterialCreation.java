package Page;
import ServiceHelper.AuthenticationService;
import ServiceHelper.EnvironmentService;
import Utils.Common;
import Utils.Locators;
import contracts.IAuthenticationService;
import contracts.IEnvironmentService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;

public class MaterialCreation extends Locators {

	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	public MaterialCreation(WebDriver driver) throws FileNotFoundException {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();

	}

	/**
	 * verify That Defaults Are Working In The Transaction Screen According To The UserConfigured
	 *
	 */
	public void verify_That_Defaults_Are_Working_In_The_Transaction_Screen_According_To_The_User_Configured() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(search);
		common.pause(5);

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

		if (common.isElementDisplayed(materialCreationRecord)) {
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitUntilElementToBeVisible(materialType);

			common.waitUntilElementToBeVisible(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitUntilElementToBeVisible(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("New Material");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitUntilElementToBeVisible(germanLanguage);

		} else if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption,"Click on Sequential Material flow").click();

			common.waitUntilElementToBeVisible(materialType);
			String strMaterialType = common.findElement(materialType).getAttribute("value");
			common.log("Verified Material Type field: " + strMaterialType);

			String strMaterialGroup = common.findElement(materialGroupField).getAttribute("value");
			common.log("Verified Material Group field: " + strMaterialGroup);

			String strIndustrySector = common.findElement(industrySectorField).getAttribute("value");
			common.log("Verified Industry sector field: " + strIndustrySector);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status dropdown").click();
			common.findElement(xPlantMaterialStatusField).click();
			common.pause(5);
			common.waitUntilElementToBeVisible(dropValue);
			common.findElementBy(dropValue, "Select option from x-plant material status dropdown").click();

			common.findElementBy(materialDescFormView,"Enter material description").sendKeys("New material");

		}

		common.findElementBy(plantDataAddHierarchy, "Click on Plant Data - add... button").click();
		common.waitUntilElementToBeVisible(searchBoxHierarchy);
		common.findElementBy(searchBoxHierarchy, "Search value: PLANT 0001").sendKeys("PLANT 0001");
		common.pause(5);
		common.waitUntilElementToBeVisible(selectSearchedOption);
		common.findElementBy(selectSearchedOption, "Select searched option").click();
		common.waitUntilElementToBeVisible(applyBtn);
		common.findElementBy(applyBtn, "Click on Apply button").click();

		//added wait for auto populate the hierarchy valuation and forecast
		common.pause(5);
		common.waitUntilElementToBeVisible(valuationDataAddHierarchy);

		if (common.isElementDisplayed(searchClassDropdown)) {
			common.findElementBy(searchClassDropdown, "Click on Search class dropdown").click();
			common.waitUntilElementToBeVisible(searchBoxClassDropdown);
			common.pause(10);
			common.findElementBy(searchBoxClassDropdown, "Click on Search box").click();
			common.pause(10);
			common.waitUntilElementToBeVisible(selectFirstValueClassDropdown);
			common.findElementBy(selectFirstValueClassDropdown, "Select first value").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(firstOptionSearchClass);
			String strValueClassDropdown = common.findElement(firstOptionSearchClass).getText();
			common.log("Selected value: " + strValueClassDropdown);

			//verifying attributes after select class
			common.log("Verified generated attributes: " + typeAttributes + " & " + gritAttributes);
			common.assertElementPresent(typeAttributes);
			common.assertElementPresent(gritAttributes);
		}

		common.findElementBy(submitBtn, "Click on submit button").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(submitBtn);
		if (common.isElementDisplayed(errorMessage)) {

			common.log("Showing mandatory error");
			List<WebElement> webElements = driver.findElements(By.xpath("//p[@class='small ng-star-inserted']"));

			for (WebElement e : webElements) {
				common.log("Error: " + e.getText());
			}
		}

		if (common.isElementPresent(planingCycleField)) {
			common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
			common.pause(5);
			common.findElementBy(addForecastHierarchy,"Click on Add for forecast parameters").click();
			common.pause(5);
			common.findElement(applyFilterButton).click();
			common.pause(5);
			common.waitUntilElementToBeVisible(lastForecastField);
			common.findElementBy(dnuFixedPeriods, "Fill DNU Fixed periods field").sendKeys("5");
			common.findElementBy(lastForecastField, "Fill last forecast field").sendKeys("10");
		}
		common.findElementBy(submitBtn, "Click on submit button").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: "+successStr);
		common.waitUntilElementToBeVisible(dataTab);

	}

	/**
	 * verifying Data On Approve Transaction Screen
	 *
	 */
	public void verifying_Data_On_Approve_Transaction_Screen() {

		//wait for Home tab
		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab,"Click on Home tab").click();

		//wait for Inbox menu
		common.waitUntilElementToBeVisible(inboxMenu);
		common.log("Click on Inbox menu");
		common.findElement(inboxMenu).click();
		common.findElement(inboxMenu).click();

		//wait for first value
		common.waitUntilElementToBeVisible(firstActionIconForInbox);

		common.log("Click on action menu for first row");
		common.findElement(firstActionIconForInbox).click();

		common.log("Click on approve");
		common.pause(10);
		common.findElement(approveBtn).click();
		common.pause(10);

		if (common.isElementDisplayed(plantData0001)) {

			common.findElementBy(plantData0001, "Verify Selected Plant data 'PLANT 0001'");
			common.findElementBy(valuationDataNA, "Verify Selected valuation data 'N.A -- Not Applicable'");
		}
		common.log("Click on Approve button");

		common.findElement(approveButton).click();
		common.pause(10);
		common.waitUntilElementToBeVisible(inboxMenu);
		common.findElementBy(inboxMenu,"Inbox menu verified");

	}

	public void verify_Created_Record_Which_Is_In_System_Status() {

		common.log("Click on Data tab");
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();
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
		common.log("Material master number is :" + materialMasterNumber);
		common.log("Set filter status as a system");
		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on edit");
		common.findElement(edit).click();
		common.pause(10);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption,"Click on SequentialMaterial option").click();
			common.waitUntilElementToBeVisible(plantDataAddHierarchy);

			common.findElementBy(plantDataAddHierarchy,"Click on Add plant data hierarchy").click();
			common.waitUntilElementToBeVisible(plantDataOption0002);
			common.pause(5);
			if (common.isElementDisplayed(selectedHierarchy))
			{
				common.log("Uncheck the selected hierarchy");
				common.jsClick(selectedHierarchy);
			}
			common.findElementBy(plantDataOption0002,"Select option '0002'").click();
			common.findElementBy(applyFilterButton,"Click on Apply button").click();


		}
		else {

			common.log("Click on material master creation process");
			common.findElement(materialCreationRecord).click();
			common.pause(10);
			common.waitUntilElementToBeVisible(headerData);
			common.pause(10);

			common.log("Select Industry Sector");
			common.waitUntilElementToBeVisible(industrySec);
			common.findElement(industrySec).click();
			common.pause(5);
			common.findElement(dropValue).click();

			common.waitUntilElementToBeVisible(plantDataAddHierarchy);

			common.findElementBy(plantDataAddHierarchy, "Click on Add plant data hierarchy").click();
			common.waitUntilElementToBeVisible(plantDataOption0002);
			//Verify if searched value is already selected
			if (common.isElementDisplayed(selectedHierarchy)) {
				common.findElementBy(selectedHierarchy, "Uncheck the selected hierarchy").click();
			}
			common.findElementBy(plantDataOption0002, "Select option '0002'").click();
			common.findElementBy(applyFilterButton, "Click on Apply button").click();

		}

		common.log("Click on save button");
		common.waitUntilElementToBeVisible(uSaveBtn);
		common.findElement(uSaveBtn).click();
		common.pause(10);

		//if duplicate record appear then click on continue and something went occurred then refresh page and submit again
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			common.log("Duplicate records");
			common.findElement(continueDuplicateRecord).click();
		} else {

			common.log("No duplicate records");
		}

		if (common.isElementDisplayed(errorMessage)) {

			common.log("Showing mandatory error");
			List<WebElement> webElements = driver.findElements(By.xpath("//p[@class='small ng-star-inserted']"));

			for (WebElement e : webElements) {
				common.log("Error: " + e.getText());
			}
		}

	}

	/**
	 *  Extend : To verify that user is able to save the record with the extension process
	 */
	public void verify_User_Is_Able_To_Save_The_Record_With_The_Extension_Process() throws InterruptedException {

		if (common.isElementDisplayed(sequentialHeader))
		{
			if (common.isElementPresent(planingCycleField)) {
				common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
				common.pause(5);
				common.findElementBy(addForecastHierarchy,"Click on Add for forecast parameters").click();
				common.pause(5);
				common.findElement(applyFilterButton).click();
				common.pause(10);
				common.findElementBy(dnuFixedPeriods, "Fill DNU Fixed periods field").sendKeys("5");
				common.findElementBy(lastForecastField, "Fill last forecast field").sendKeys("10");
			}
			if (common.isElementDisplayed(unitOfWeightField)) {
				common.waitUntilElementToBeVisible(unitOfWeightField);
				common.scrollToElement(unitOfWeightField);
				common.pause(10);
				common.log("Click on Unit Of Weight dropdown");
				common.jsClick(unitOfWeightField);
				common.jsClick(unitOfWeightField);
				common.pause(5);
				common.waitUntilElementToBeVisible(dropValue1);
				common.findElementBy(dropValue1, "Select option").click();
				common.findElementBy(volumeUnitField,"Click on Volume Unit field").click();
				common.pause(5);
				common.waitUntilElementToBeVisible(dropValue);
				common.findElementBy(dropValue, "Select option").click();
			}
		}
		else {
			common.pause(5);
			common.waitUntilElementToBeVisible(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();
			common.waitUntilElementToBeVisible(germanLanguage);

			common.findElementBy(materialType, "Click on material type field").click();
			common.pause(5);
			common.findElementBy(dropValue3, "Select value from options").click();
			common.pause(5);

//		common.findElementBy(materialGroupField,"Click on material group field").click();
//		common.pause(5);
//		common.findElementBy(dropValue3,"Select value from options").click();
//		common.pause(5);

			common.findElementBy(materialGroupField, "Click on material group field").click();
			common.pause(5);
			common.findElementBy(dropValue3, "Select value from options").click();
			common.pause(5);
		}

		common.log("Click on save button");
		common.waitUntilElementToBeVisible(uSaveBtn);
		common.findElement(uSaveBtn).click();
		common.pause(2);

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: "+successStr);

		//Verifying Data tab visible
		common.findElementBy(dataTab,"Verify Data tab available");
	}

	/**
	 * verify That Exact Match Duplicacy Is Working For Material Creation
	 *
	 */
	public void verify_That_Exact_Match_Duplicacy_Is_Working_For_Material_Creation() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {
			common.waitUntilElementToBeVisible(errorMessage);
			common.log("Rule applied");
			String errorStr = common.findElement(errorMessage).getText();
			common.log("Error showing: " + errorStr);

			common.findElementBy(viewRecord, "Click on View record link text").click();

			common.pause(10);
			String duplicateRecordStr = common.findElement(duplicateRecords).getText();
			common.log("Duplicate Object number: " + duplicateRecordStr);
		}
		else {
			common.log("Rule not applied");
		}
	}

	public void duplicacy_Check_Is_Working_At_The_Time_Of_Copy_Event() {
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

		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		String mmN = common.findElement(materialMasterNum).getText();

		common.pause(10);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		common.findElementBy(sequentialMaterialOption,"Select Sequential Material").click();
		common.waitUntilElementToBeVisible(headerData);
		common.findElementBy(headerData,"Header data verified");

		common.findElementBy(copyButton, "Click on Copy button").click();
		common.waitUntilElementToBeVisible(submitBtn);
		common.findElementBy(submitBtn,"Click on Submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {

			common.log("Rule applied");
			common.waitUntilElementToBeVisible(errorMessage);
			String errorStr = common.findElement(errorMessage).getText();
			common.log("Error showing: " + errorStr);

			common.findElementBy(viewRecord, "Click on View record link text").click();

			common.pause(10);
			String duplicateRecordStr = common.findElement(duplicateRecords).getText();
			common.log("Duplicate Object number: " + duplicateRecordStr);
		}
		else {

			common.log("Rule not applied");
		}

	}

	/**
	 * verify Duplicacy Is Working At Change Event
	 *
	 */
	public void verify_Duplicacy_Is_Working_At_Change_Event() {

		common.log("Click on Data tab");
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
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
		common.log("Material master number is :" + materialMasterNumber);
		common.log("Set filter status as a system");
		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on edit");
		common.findElement(edit).click();

		common.waitUntilElementToBeVisible(sequentialMaterialOption);
		common.findElementBy(sequentialMaterialOption,"Click on Sequential Material").click();
		common.waitUntilElementToBeVisible(saveButtonFilterPopup);
		common.findElementBy(saveButtonFilterPopup,"Click on Save").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {

			common.log("Rule applied");
			common.waitUntilElementToBeVisible(errorMessage);
			String errorStr = common.findElement(errorMessage).getText();
			common.log("Error showing: " + errorStr);

			common.findElementBy(viewRecord, "Click on View record link text").click();

			common.pause(10);
			String duplicateRecordStr = common.findElement(duplicateRecords).getText();
			common.log("Duplicate Object number: " + duplicateRecordStr);
		}
		else {

			common.log("Rule not applied");
		}

	}
	/**
	 * check Duplicacy Is Working At The Time Of Approval From Reviewer
	 *
	 */
	public void check_Duplicacy_Is_Working_At_The_Time_Of_Approval_From_Reviewer() {

		common.pause(10);
		common.refreshPage();

		common.log("Home tab opened");

		common.waitUntilElementToBeVisible(inboxMenu);
		common.log("Click on inbox Menu");
		common.findElement(myReqTab).click();
		common.pause(10);

		//If first value appear in Inbox menu then it will reject the flow from Approve option

		if (common.isElementDisplayed(firstActionIconForInbox) == true) {

			common.waitUntilElementToBeVisible(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on first record action icon").click();
			common.pause(10);

			common.findElementBy(approveVal,"Click on approve option").click();
			common.waitUntilElementToBeVisible(materialDescReviewer);

			if (common.isElementDisplayed(materialDescReviewer)) {
				common.findElementBy(materialDescReviewer, "Enter description").sendKeys("material desc");

				common.findElementBy(divisionField, "Select Division field").click();
				common.findElementBy(dropValue, "Select value").click();

				common.findElementBy(manufacturerField, "Enter Manufacturer number").sendKeys("54321");
				//	common.findElementBy(oldMaterialNumField, "Enter Old material number").sendKeys("12345");

				common.findElementBy(approveButtonReviewer, "Click on Approve").click();

				common.waitUntilElementToBeVisible(duplicateRecordFirst);

				String duplicateRecordStr = common.findElement(duplicateRecordFirst).getText();
				common.log("Duplicate Object number: " + duplicateRecordStr);
			}
			else {
				common.findElementBy(approveButtonReviewer, "Click on Approve").click();

				common.waitUntilElementToBeVisible(duplicateRecordFirst);

				String duplicateRecordStr = common.findElement(duplicateRecordFirst).getText();
				common.log("Duplicate Object number: " + duplicateRecordStr);
			}
		}
	}
	public void select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset()
	{
		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(search);
		common.pause(5);

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

		if(common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption,"Click on Sequential Material flow").click();

			common.waitUntilElementToBeVisible(materialType);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.findElement(xPlantMaterialStatusField).click();
			common.pause(5);
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Select option");
			common.jsClick(dropValue);
			//common.findElementBy(dropValue, "Select option").click();
		}
		else {
			common.waitUntilElementToBeVisible(materialCreationRecord);
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitUntilElementToBeVisible(materialType);

			common.waitUntilElementToBeVisible(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitUntilElementToBeVisible(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitUntilElementToBeVisible(germanLanguage);
		}
	}
	/**
	 * verify UDR Rule Is Working Fine With Common Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_Common_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {
			common.waitUntilElementToBeVisible(errorMessage);

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);
		}
		else {
			common.log("Rule not applied");
		}

	}
	/**
	 * verify UDR Rule Is Working Fine With Special Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_Special_Operators() {
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter regex in Material description field").sendKeys("material$");

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {
			common.waitUntilElementToBeVisible(errorMessage);

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);
		}
		else {
			common.log("Rule not applied");
		}

	}
	/**
	 * verify UDR Rule Is Working Fine With Numeric Range Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_Numeric_Range_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter wrong numerical value in Material description field").sendKeys("100");

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {
			common.log("Rule applied");
			common.waitUntilElementToBeVisible(errorMessage);

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);
			for (int i = 0; i <= 15; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.findElementBy(materialDescReviewer, "Enter valid numerical value between 0 TO 9 in Material description field").sendKeys("5");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(2);
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}

	}
	/**
	 * verify UDR Rule Is Working Fine With EMPTY Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_EMPTY_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("qwerty");

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {

			common.log("Rule applied");

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);
			common.findElementBy(materialDescReviewer, "Remove value from in Material description field").click();
			common.pause(5);
			common.log("Remove value from in Material description field");
			for (int i = 0; i < 10; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.pause(5);
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
	}
	/**
	 * verify UDR Rule Is Working Fine With ENDSWITH Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_ENDSWITH_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("qwerty");

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {

			common.log("Rule applied");
			common.waitUntilElementToBeVisible(errorMessage);

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);
			common.pause(5);
			common.findElementBy(materialDescReviewer, "Remove value from in Material description field").click();
			common.pause(5);
			common.findElementBy(materialDescReviewer, "Add '.' after value in Material description field").sendKeys(".");

			common.findElementBy(submitBtn, "Click on submit button").click();

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
		else {

			common.log("Rule not applied");
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
	}
	/**
	 * verify UDR Rule Is Working Fine With LENGTH Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_LENGTH_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter value in Material description field").sendKeys("qwerty");

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {
			common.waitUntilElementToBeVisible(errorMessage);
			common.log("Rule applied");

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);

			common.findElementBy(materialDescReviewer, "Click on Material description field").click();
			common.pause(5);
			common.findElementBy(materialDescReviewer, "Enter 10 length value from in Material description field").sendKeys("1234");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
	}
	/**
	 * verify UDR Rule Is Working Fine With LESS THAN/LESS THAN EQUAL Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_LESS_THAN_LESS_THAN_EQUAL_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter numeric value greater than 10 in Material description field").sendKeys("15");
		common.pause(5);

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {
			common.log("Rule applied");

			common.waitUntilElementToBeVisible(errorMessage);

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);

			common.findElementBy(materialDescReviewer, "Click on Material description field").click();
			common.pause(5);
			for (int i = 0; i <= 15; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.findElementBy(materialDescReviewer, "Enter numeric value less than 10 in Material description field").sendKeys("5");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");

			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
	}
	/**
	 * verify UDR Rule Is Working Fine With GREATER THAN/GREATER THAN EQUAL Operators
	 *
	 */
	public void verify_UDR_Rule_Is_Working_Fine_With_GREATER_THAN_GREATER_THAN_EQUAL_Operators() {

		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter numeric value less than 10 in Material description field").sendKeys("08");
		common.pause(5);

		common.findElementBy(submitBtn,"Click on submit button").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {
			common.waitUntilElementToBeVisible(errorMessage);
			common.log("Rule applied");

			String errorStr = common.findElement(errorsForRule).getText();
			common.log("Error showing for UDR rule: " + errorStr);

			common.findElementBy(materialDescReviewer, "Click on Material description field").click();
			common.pause(5);
			for (int i = 0; i <= 15; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.findElementBy(materialDescReviewer, "Enter numeric value greater than 10 in Material description field").sendKeys("15");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitUntilElementToBeVisible(successMessageToast);
			String successStr = common.findElement(successMessageToast).getText();
			common.log("Message display: " + successStr);
		}

	}
	/**
	 * verify Transformation Rule Is Working Fine With Add leading Zeros
	 *
	 */
	public void verify_Transformation_Rule_Is_Working_Fine_With_Add_Leading_Zeros() {
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter value in Material description field: material").sendKeys("material");
		common.pause(5);
		common.findElement(materialDescLabel).click();
		common.findElement(materialDescLabel).click();
		common.pause(5);
		common.findElementBy(submitBtn,"Click on submit button").click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: "+successStr);
	}
	/**
	 * verify Transformation Rule Is Working Fine With Remove Leading Zeros
	 *
	 */
	public void verify_Transformation_Rule_Is_Working_Fine_With_Remove_Leading_Zeros() {
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter value with zeros in Material description field : 00000material").sendKeys("00000material");
		common.pause(5);
		common.findElement(materialDescLabel).click();
		common.findElement(materialDescLabel).click();
		common.pause(5);
		common.findElementBy(submitBtn,"Click on submit button").click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: "+successStr);
	}
	public void verify_Description_on_Summary_Page()
	{
		common.refreshPage();
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();
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
		common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
		common.pause(10);

		String strDescription = common.findElementBy(materialDescReviewer,"Get value from material description field").getAttribute("value");
		common.log("Value of Material description field: "+strDescription);
		if (strDescription.contains("0"))
		{
			common.log("Rule applied");
		}
		else {
			common.log("Rule not applied");
		}
	}
	public void verify_Remove_Leading_Zeros_From_Description_on_Summary_Page()
	{
		common.refreshPage();
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();
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
		common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
		common.pause(5);

		common.waitUntilElementToBeVisible(materialDescReviewer);
		String strDescription = common.findElementBy(materialDescReviewer,"Get value from material description field").getAttribute("value");
		common.log("Value of Material description field: "+strDescription);
		if (!strDescription.contains("0"))
		{
			common.log("Rule applied");
		}
		else {
			common.log("Rule not applied");
		}

	}
	public void verify_Description_Field_For_ConstantValue_on_Summary_Page()
	{
		common.refreshPage();
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();
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
		common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
		common.pause(10);

		common.waitUntilElementToBeVisible(materialDescReviewer);
		String strDescription = common.findElementBy(materialDescReviewer,"Get value from material description field").getAttribute("value");
		common.log("Value of Material description field: "+strDescription);

		if (strDescription.contains("QA"))
		{
			common.log("Rule applied");
		}
		else {
			common.log("Rule not applied");
		}
	}

	/**
	 * verify Description Generator Short And Long Description Should Auto Populate
	 *
	 */
	public void verify_Description_Generator_Short_And_Long_Description_Should_Auto_Populate() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(search);
		common.pause(5);

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

		if (common.isElementDisplayed(materialCreationRecord)) {
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitUntilElementToBeVisible(materialType);

			common.waitUntilElementToBeVisible(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitUntilElementToBeVisible(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitUntilElementToBeVisible(germanLanguage);


		} else if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption,"Click on Sequential Material flow").click();

			common.waitUntilElementToBeVisible(materialType);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.findElement(xPlantMaterialStatusField).click();

			common.pause(5);
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Select option");
			common.jsClick(dropValue);

		}
		common.pause(5);
		if(!common.isElementDisplayed(classField)) {
			common.log("Click on Generate description button");
			common.jsClick(generateDesc);
		}

		common.pause(5);
		common.findElementBy(classField,"Click on class dropdown").click();
		common.waitUntilElementToBeVisible(bearingBallClassOption);
		common.findElementBy(bearingBallClassOption,"Select Bearing-Ball option").click();

		common.pause(5);
		common.findElementBy(typeField,"Click on Type dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.pause(5);
		common.findElementBy(widthField,"Click on Width dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.pause(5);
		common.findElementBy(seriesField,"Click on Series dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.pause(5);
		common.findElementBy(insideDiameterField,"Click on INSIDE DIAMETER dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(outsideDiameterField,"Click on OUTSIDE DIAMETER dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(cageMaterialField,"Click on CAGE MATERIAL dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(manufacturerFieldDesc,"Click on MANUFACTURER dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.pause(5);
		common.findElementBy(modelNumberField,"Enter value in Model number field").sendKeys("34567");

		common.findElementBy(rowField,"Click on ROW dropdown").click();
		common.findElementBy(dropValue, "Select value").click();
		common.pause(5);
		common.findElementBy(partNumberField,"Enter value in part number field").sendKeys("54321");
		common.pause(10);

		common.findElement(partNumberLabel).click();
		common.findElement(partNumberLabel).click();
		common.pause(5);

		common.findElementBy(generateDescriptionLabel, "Click on Generate description label").click();
		common.pause(10);
		String shortDescStr = common.findElement(shortDescriptionField).getAttribute("value");
		common.log("Short Description auto populate: "+shortDescStr);

		String longDescStr = common.findElement(longDescriptionField).getAttribute("value");
		common.log("Long Description auto populate: "+longDescStr);

		common.findElementBy(submitBtn, "Click on submit button").click();
		common.pause(5);

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: "+successStr);
		common.waitUntilElementToBeVisible(dataTab);

	}
	/**
	 * verify Description Generator Language Grid And PO Text Grid Should Be AutoPopulate
	 *
	 */
	public void verify_Description_Generator_Language_Grid_And_PO_Text_Grid_Should_Be_Auto_Populate() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(search);
		common.pause(5);

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

		if (common.isElementDisplayed(materialCreationRecord)) {
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitUntilElementToBeVisible(materialType);

			common.waitUntilElementToBeVisible(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitUntilElementToBeVisible(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitUntilElementToBeVisible(germanLanguage);


		} else if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material flow").click();

			common.waitUntilElementToBeVisible(materialType);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.findElement(xPlantMaterialStatusField).click();
			common.pause(5);
			common.waitUntilElementToBeVisible(dropValue);
			common.log("Select option");
			common.jsClick(dropValue);

		}
		common.pause(5);
		if(!common.isElementDisplayed(classField)) {
			common.log("Click on Generate description button");
			common.jsClick(generateDesc);
		}
		common.waitUntilElementToBeVisible(classField);
		common.findElementBy(classField, "Click on class dropdown").click();
		common.waitUntilElementToBeVisible(bearingBallClassOption);
		common.findElementBy(bearingBallClassOption, "Select Bearing-Ball option").click();

		common.pause(5);
		common.findElementBy(typeField, "Click on Type dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(widthField, "Click on Width dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(seriesField, "Click on Series dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.pause(5);
		common.findElementBy(insideDiameterField, "Click on INSIDE DIAMETER dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(outsideDiameterField, "Click on OUTSIDE DIAMETER dropdown").click();
		common.pause(5);
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(cageMaterialField, "Click on CAGE MATERIAL dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(manufacturerFieldDesc, "Click on MANUFACTURER dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.pause(5);
		common.findElementBy(modelNumberField, "Enter value in Model number field").sendKeys("34567");

		common.findElementBy(rowField, "Click on ROW dropdown").click();
		common.findElementBy(dropValue, "Select value").click();

		common.findElementBy(partNumberField, "Enter value in part number field").sendKeys("54321");
		common.pause(10);
		common.jsClick(materialDescReviewer);
		common.pause(10);

		if(!common.isElementDisplayed(classField)) {
			common.log("Click on Generate description button");
			common.jsClick(generateDesc);
		}
		common.pause(10);
		String shortDescStr = common.findElement(shortDescriptionField).getAttribute("value");
		common.log("Short Description auto populate: " + shortDescStr);

		String longDescStr = common.findElement(longDescriptionField).getAttribute("value");
		common.log("Long Description auto populate: " + longDescStr);

		List<WebElement> languageDescription = driver.findElements(By.xpath("//div[contains(text(),'Material Description')]//..//..//..//..//..//..//lib-input[1]//div[1]//div//input[1]"));

		for (WebElement e : languageDescription) {

			common.log("Language Grid Material descriptions: " + e.getAttribute("value"));
		}

		common.findElementBy(submitBtn, "Click on submit button").click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: " + successStr);
		common.waitUntilElementToBeVisible(dataTab);
	}
	/**
	 * Creation - verify Mandatory Field On Execution Page At Edit Time
	 */
	public void verify_Mandatory_Field_On_Execution_Page_At_Edit_Time() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
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
		common.log("Material master number is :" + materialMasterNumber);
		common.log("Set filter status as a system");
		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on edit");
		common.findElement(edit).click();
		common.pause(10);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.pause(5);
			common.findElementBy(sequentialMaterialOption,"Click on SequentialMaterial option").click();

		}
		else
		{
			common.log("Click on material master creation process");
			common.findElement(materialCreationRecord).click();
			common.pause(10);
			common.waitUntilElementToBeVisible(headerData);
			common.pause(10);

			if (common.isElementDisplayed(actionIconLanguage)) {

				common.findElementBy(actionIconLanguage, "Click on action icon for added language").click();
				common.waitUntilElementToBeVisible(deleteRowOption);
				common.findElementBy(deleteRowOption, "Click on delete row option").click();
				common.pause(5);
			}
		}
		common.waitUntilElementToBeVisible(addPlantData);
		common.findElementBy(addPlantData,"Click on Add Plant data").click();
		common.pause(5);
		common.waitUntilElementToBeVisible(searchPlantData);
		if (common.isElementDisplayed(selectedHierarchy)) {
			common.log("Uncheck the selected hierarchy");
			common.jsClick(selectedHierarchy);
		}
		common.findElementBy(searchPlantData,"Enter value 0002").sendKeys("0002");
		common.waitUntilElementToBeVisible(searchedPantValue);
		common.pause(5);
		common.findElementBy(searchedPantValue,"Select searched value").click();
		common.pause(5);
		common.findElementBy(applyFilterButton,"Click on apply button").click();
		common.pause(10);

		//Click on material Description label for auto populate hierarchy
		common.findElement(materialDescLabel).click();
		common.findElement(materialDescLabel).click();

		common.log("Click on save button");
		common.waitUntilElementToBeVisible(uSaveBtn);
		common.findElement(uSaveBtn).click();
		common.pause(10);

		if (common.isElementDisplayed(followingErrorToProceed)) {
			//Verifying Error for mandatory fields
			common.assertElementPresent(followingErrorToProceed);
			common.waitUntilElementToBeVisible(errors);

			String strError = common.findElement(errors).getText();
			common.log("Error: " + strError);
		}
	}

	/**
	 * Extend - verify Able To Extend Multiple Similar Child Hierarchies At The Same Time
	 */
	public void verify_Able_To_Extend_Multiple_Similar_Child_Hierarchies_At_The_Same_Time() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
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
		common.log("Material master number is :" + materialMasterNumber);
		common.log("Set filter status as a system");
		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		common.findElementBy(actionIconForFirstValue,"Click on action icon for first value").click();

		common.log("Click on edit");
		common.findElement(edit).click();
		common.pause(10);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.pause(5);
			common.findElementBy(sequentialMaterialOption,"Click on SequentialMaterial option").click();
			common.pause(10);
			common.waitUntilElementToBeVisible(addPlantData);
			common.findElementBy(addPlantData,"Click on Add Plant data").click();
			common.waitUntilElementToBeVisible(searchPlantData);
			if (common.isElementDisplayed(selectedHierarchy)) {
				common.findElementBy(selectedHierarchy, "Uncheck the selected hierarchy").click();
			}
			common.findElementBy(searchPlantData,"Enter value 0002").sendKeys("0002");
			common.waitUntilElementToBeVisible(searchedPantValue);
			common.pause(5);
			common.findElementBy(searchedPantValue,"Select searched value").click();
			common.pause(5);
			common.findElementBy(applyFilterButton,"Click on apply button").click();
			common.pause(5);

			common.findElementBy(storageDataAdd,"Click on Storage Data add button").click();
			common.pause(5);
			common.findElementBy(firstOptionFromHierarchy,"Select first option from list").click();
			common.findElementBy(applyFilterButton,"Click on apply button").click();
			common.pause(5);

			common.findElementBy(valuationDataAdd,"Click on Valuation Data add button").click();
			common.pause(5);
			common.findElementBy(firstOptionFromHierarchy,"Select first option from list").click();
			common.findElementBy(applyFilterButton,"Click on apply button").click();
			common.pause(5);

			if (common.isElementPresent(planingCycleField)) {
				common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
				common.pause(5);
				common.findElementBy(addForecastHierarchy,"Click on Add for forecast parameters").click();
				common.pause(5);
				common.findElement(applyFilterButton).click();
				common.pause(10);
				common.findElementBy(dnuFixedPeriods, "Fill DNU Fixed periods field").sendKeys("5");
				common.pause(5);
				common.findElementBy(lastForecastField, "Fill last forecast field").sendKeys("10");
			}

		}
		else
		{
			common.log("Click on material master creation process");
			common.findElement(materialCreationRecord).click();
			common.pause(10);
			common.waitUntilElementToBeVisible(headerData);
			common.waitUntilElementToBeVisible(addPlantData);
			common.findElementBy(addPlantData,"Click on Add Plant data").click();
			common.waitUntilElementToBeVisible(searchPlantData);
			common.pause(5);
			if (common.isElementDisplayed(selectedHierarchy)) {
				common.findElementBy(selectedHierarchy, "Uncheck the selected hierarchy").click();
			}
			common.findElementBy(searchPlantData,"Enter value 0002").sendKeys("0002");
			common.waitUntilElementToBeVisible(searchedPantValue);
			common.pause(5);
			common.findElementBy(searchedPantValue,"Select searched value").click();
			common.pause(5);
			common.findElementBy(applyFilterButton,"Click on apply button").click();
			common.pause(5);

			common.findElementBy(storageDataAdd,"Click on Storage Data add button").click();
			common.pause(5);
			common.findElementBy(firstOptionFromHierarchy,"Select first option from list").click();
			common.findElementBy(applyFilterButton,"Click on apply button").click();
			common.pause(5);

			common.findElementBy(valuationDataAdd,"Click on Valuation Data add button").click();
			common.pause(5);
			common.findElementBy(firstOptionFromHierarchy,"Select first option from list").click();
			common.findElementBy(applyFilterButton,"Click on apply button").click();
			common.pause(5);

			common.log("Click on save button");
			common.waitUntilElementToBeVisible(uSaveBtn);
			common.findElement(uSaveBtn).click();
			common.pause(10);

			if (common.isElementDisplayed(actionIconLanguage)) {

				common.findElementBy(actionIconLanguage, "Click on action icon for added language").click();
				common.waitUntilElementToBeVisible(deleteRowOption);
				common.findElementBy(deleteRowOption, "Click on delete row option").click();
				common.pause(5);
			}
			common.waitUntilElementToBeVisible(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitUntilElementToBeVisible(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitUntilElementToBeVisible(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();
			common.waitUntilElementToBeVisible(germanLanguage);

			common.findElementBy(materialType, "Click on material type field").click();
			common.pause(5);
			common.findElementBy(dropValue3, "Select value from options").click();
			common.pause(5);

			common.findElementBy(materialGroupField, "Click on material group field").click();
			common.pause(5);
			common.findElementBy(dropValue3, "Select value from options").click();
			common.pause(5);
		}
		common.log("Click on save button");
		common.waitUntilElementToBeVisible(uSaveBtn);
		common.findElement(uSaveBtn).click();
		common.pause(10);

		if (common.isElementDisplayed(followingErrorToProceed)) {
			//Verifying Error for mandatory fields
			common.assertElementPresent(followingErrorToProceed);
			common.waitUntilElementToBeVisible(errors);

			String strError = common.findElement(errors).getText();
			common.log("Error: " + strError);
		}
	}
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Leading_Spaces_On_Transaction_Page()
	{
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description field with leading spaces").sendKeys("        Test");
		String value1 = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("value of description field: "+value1);

		common.pause(5);
		//Clicking on Material description label(outside the input field) for applying rule
		common.findElementBy(materialDescLabel,"Click on material description label").click();
		common.findElement(materialDescLabel).click();
		common.pause(5);
		String value2 = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("new value of description field: "+value2);

		//verifying rule applied or not
		if (value1.equals(value2))
		{
			common.log("Rule not applied");
			common.log("Leading spaces removed");
		}
		else {
			common.log("Rule applied");
		}

		common.findElementBy(submitBtn, "Click on submit button").click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: " + successStr);
		common.waitUntilElementToBeVisible(dataTab);
	}
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Trailing_Spaces_On_Transaction_Page() {
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description field with leading spaces").sendKeys("Test          ");
		String value1 = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("value of description field: " + value1);

		common.pause(5);
		common.findElementBy(materialDescLabel, "Click on material description label").click();
		common.pause(5);
		String value2 = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("new value of description field: " + value2);

		//verifying rule applied or not
		if (value1.equals(value2)) {
			common.log("Rule not applied");
			common.log("Trailing spaces removed");
		} else {

			common.log("Rule applied");
		}

		common.findElementBy(submitBtn, "Click on submit button").click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: " + successStr);
		common.waitUntilElementToBeVisible(dataTab);
	}
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_All_Spaces_On_Transaction_Page()
	{
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description field with spaces").sendKeys("Test  test  test ");
		String value1 = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("value of description field: "+value1);

		common.pause(5);
		common.findElementBy(materialDescLabel,"Click on material description label").click();
		common.pause(5);
		String value2 = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("new value of description field: "+value2);

		//verifying rule applied or not
		if (value1.equals(value2))
		{
			common.log("Rule not applied");
			common.log("All spaces removed");
		}
		else {

			common.log("Rule applied");
		}

		common.findElementBy(submitBtn, "Click on submit button").click();

		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display: " + successStr);
		common.waitUntilElementToBeVisible(dataTab);
	}

	public void verify_Transformation_Rule_Of_Type_Concatenation_With_Remove_All_Spaces_On_Transaction_Page()
	{
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description").sendKeys("Test");
		String materialDesc = common.findElement(materialDescReviewer).getAttribute("value");
		common.log("value of description field: "+materialDesc);

		common.findElementBy(grossWeightField, "Enter value in Gross weight").sendKeys("10");
		String grossWeight = common.findElement(grossWeightField).getAttribute("value");
		common.log("value of Gross Weight field: "+grossWeight);

		common.findElementBy(grossWeightField, "Enter value in Authorization group").sendKeys("qa");
		String authorizationGroup = common.findElement(grossWeightField).getAttribute("value");
		common.log("value of Authorization group field: "+grossWeight);

		common.pause(5);
		common.findElementBy(grossWeightLabel,"Click on Gross weight label").click();
		common.pause(5);

		common.waitUntilElementToBeVisible(volumeField);
		String volume = common.findElement(volumeField).getAttribute("value");
		common.log("value of volume field: "+volume);

		//verifying rule applied or not
		if (volume.contains("@"))
		{
			common.log("Rule applied");
			common.log("@ is there between two values");
		}
		else {

			common.log("Rule not applied");
		}
	}
	public void verify_Description_For_Newly_Created_Record_on_Summary_Page()
	{
		common.refreshPage();
		common.waitUntilElementToBeVisible(dataTab);
		common.findElement(dataTab).click();
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
		if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
			common.pause(10);
		}
		else if (common.isElementDisplayed(materialMasterRecordOption))
		{
			common.findElementBy(materialMasterRecordOption, "Click on material master option").click();
			common.pause(10);
		}

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='f-col form-area-container ng-star-inserted']//..//p//..//..//input"));
		common.log("All the values of Summary page: ");
		for (WebElement e : list)
		{
			String str = e.getAttribute("value");
			if (!str.equals(""))
			{
				common.log(str);
			}

		}

	}
}
