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
		common.pause(5);
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "click on Material master from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(search);
		common.pause(5);

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
		common.pause(5);

		if (common.isElementDisplayed(materialCreationRecord)) {
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitForElement(materialTypeField);

			common.waitForElement(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitForElement(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitForElement(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitForElement(germanLanguage);

		} else if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption,"Click on Sequential Material flow").click();

			common.waitForElement(materialTypeField);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.pause(5);
			common.waitForElement(dropValue);
			common.findElementBy(dropValue, "Select option").click();

		}

		String strMaterialType = driver.findElement(By.xpath(materialTypeField)).getAttribute("value");
		System.out.println("Step :: Verified Material Type field: " + strMaterialType);
		common.log("Verified Material Type field: " + strMaterialType);

		String strMaterialGroup = driver.findElement(By.xpath(materialGroupField)).getAttribute("value");
		System.out.println("Step :: Verified Material Group field: " + strMaterialGroup);
		common.log("Verified Material Group field: " + strMaterialGroup);

		String strIndustrySector = driver.findElement(By.xpath(industrySectorField)).getAttribute("value");
		System.out.println("Step :: Verified Industry sector field: " + strIndustrySector);
		common.log("Verified Industry sector field: " + strIndustrySector);

		common.findElementBy(plantDataAddHierarchy, "Click on Plant Data - add... button").click();
		common.waitForElement(searchBoxHierarchy);
		common.findElementBy(searchBoxHierarchy, "Search value: PLANT 0001").sendKeys("PLANT 0001");
		common.pause(5);
		common.waitForElement(selectSearchedOption);
		common.findElementBy(selectSearchedOption, "Select searched option").click();
		common.waitForElement(applyBtn);
		common.findElementBy(applyBtn, "Click on Apply button").click();
		common.pause(5);

		common.findElementBy(valuationDataAddHierarchy, "Click on Valuation Data - add... button").click();
		common.waitForElement(searchBoxHierarchy);
		common.pause(5);
		common.findElementBy(searchBoxHierarchy, "Search value: N.A -- Not Applicable").sendKeys("N.A");
		common.waitForElement(selectSearchedOption);
		common.pause(5);
		if (common.isElementDisplayed("//input[@aria-checked='true']//.."))
		{
			common.log("Already checked checkbox");
			common.findElementBy(applyBtn, "Click on Apply button").click();
			common.pause(10);
		}
		else {
			common.findElementBy(selectSearchedOption, "Select searched option").click();
			common.findElementBy(applyBtn, "Click on Apply button").click();
			common.pause(10);
		}

		String strValuationType = driver.findElement(By.xpath(valuationTypeField)).getAttribute("value");
		System.out.println("Step :: Verified Valuation Type field: " + strValuationType);
		common.log("Verified Valuation Type field: " + strValuationType);

		common.findElementBy(scenarioIdDisabled, "Verify Scenario ID field is disabled");

		if (common.isElementDisplayed(searchClassDropdown)) {
			common.findElementBy(searchClassDropdown, "Click on Search class dropdown").click();
			common.waitForElement(searchBoxClassDropdown);
			common.pause(10);
			common.findElementBy(searchBoxClassDropdown, "Click on Search box").click();
			common.pause(10);
//		common.findElementBy(searchBoxClassDropdown,"Search the value: Hood").sendKeys("Hood");

			common.waitForElement(selectFirstValueClassDropdown);
			common.findElementBy(selectFirstValueClassDropdown, "Select first value").click();
			common.pause(5);
			common.waitForElement(firstOptionSearchClass);
			String strValueClassDropdown = driver.findElement(By.xpath(firstOptionSearchClass)).getText();
			common.log("Selected value: " + strValueClassDropdown);

			//verifying attributes after select class
			common.log("Verified generated attributes: " + typeAttributes + " & " + gritAttributes);
			common.assertElementPresent(typeAttributes);
			common.assertElementPresent(gritAttributes);
		}

		common.findElementBy(submitBtn, "Click on submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {

			System.out.println("Step :: Showing mandatory errors");
			common.log("Showing mandatory error");
			List<WebElement> webElements = driver.findElements(By.xpath("//p[@class='small ng-star-inserted']"));

			for (WebElement e : webElements) {
				System.out.println("Error: " + e.getText());
				common.log("Error: " + e.getText());
			}
		}

		if (common.isElementDisplayed(planingCycleField)) {
			common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
			common.pause(50);
			common.findElementBy(dnuFixedPeriods, "Fill DNU Fixed periods field").sendKeys("5");
			common.findElementBy(lastForecastField, "Fill last forecast field").sendKeys("10");
		}
		common.findElementBy(submitBtn, "Click on submit button").click();
		common.pause(10);
		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
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
		common.pause(10);
		common.findElement(approveBtn).click();
		common.pause(10);

		if (common.isElementDisplayed(plantData0001)) {

			common.findElementBy(plantData0001, "Verify Selected Plant data 'PLANT 0001'");
			common.findElementBy(valuationDataNA, "Verify Selected valuation data 'N.A -- Not Applicable'");
		}
		System.out.println("Step :: click on Approve button");
		common.log("Click on Approve button");

		common.findElement(approveButton).click();
		common.pause(10);
		common.waitForElement(inboxMenu);
		common.findElementBy(inboxMenu,"Inbox menu verified");

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

		System.out.println("Step :: Click on edit");
		common.log("Click on edit");
		common.findElement(edit).click();
		common.pause(10);

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption,"Click on SequentialMaterial option").click();
			common.waitForElement(plantDataAddHierarchy);

			common.findElementBy(plantDataAddHierarchy,"Click on Add plant data hierarchy").click();
			common.waitForElement(plantDataOption0002);
			common.pause(5);
			if (common.isElementDisplayed("//input[@aria-checked='true']"))
			{
				common.log("Uncheck the selected hierarchy");
				common.jsClick("//input[@aria-checked='true']");
			}
			common.findElementBy(plantDataOption0002,"Select option '0002'").click();
			common.findElementBy(applyFilterButton,"Click on Apply button").click();


		}
		else {

			System.out.println("Step :: Click on material creation process");
			common.log("Click on material master creation process");
			driver.findElement(By.xpath(materialCreationRecord)).click();
			common.pause(10);
			common.waitForElement(headerData);
			common.pause(10);

			test.log(LogStatus.INFO, "Step :: Select Industry Sector ");
			System.out.println("Step :: Select Industry Sector");
			common.log("Select Industry Sector");
			common.waitForElement(industrySec);
			common.findElement(industrySec).click();
			common.pause(5);
			common.findElement(dropValue).click();

			common.waitForElement(plantDataAddHierarchy);

			common.findElementBy(plantDataAddHierarchy, "Click on Add plant data hierarchy").click();
			common.waitForElement(plantDataOption0002);
			if (common.isElementDisplayed("//input[@aria-checked='true']")) {
				common.findElementBy("//input[@aria-checked='true']", "Uncheck the selected hierarchy").click();
			}
			common.findElementBy(plantDataOption0002, "Select option '0002'").click();
			common.findElementBy(applyFilterButton, "Click on Apply button").click();

		}

		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(10);

		//if duplicate record appear then click on continue and something went occurred then refresh page and submit again
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}

		if (common.isElementDisplayed(errorMessage)) {

			System.out.println("Step :: Showing mandatory errors");
			common.log("Showing mandatory error");
			List<WebElement> webElements = driver.findElements(By.xpath("//p[@class='small ng-star-inserted']"));

			for (WebElement e : webElements) {
				System.out.println("Error: " + e.getText());
				common.log("Error: " + e.getText());
			}
		}

	}

	/**
	 *  Extend : To verify that user is able to save the record with the extension process
	 */
	public void verify_User_Is_Able_To_Save_The_Record_With_The_Extension_Process() {

		if (common.isElementDisplayed(sequentialHeader))
		{
			if (common.isElementDisplayed(planingCycleField)) {
				common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
				common.findElementBy(dnuFixedPeriods, "Fill DNU Fixed periods field").sendKeys("5");
				common.findElementBy(lastForecastField, "Fill last forecast field").sendKeys("10");
			}
			else if (common.isElementDisplayed(unitOfWeightField)) {
				common.waitForElement(unitOfWeightField);
				common.findElementBy(unitOfWeightField, "Click on Unit Of Weight dropdown").click();
				common.pause(5);
				common.waitForElement(dropValue);
				common.findElementBy(dropValue, "Select option").click();
				common.findElementBy(volumeUnitField, "Click on Volume Unit field").click();
				common.pause(5);
				common.waitForElement(dropValue);
				common.findElementBy(dropValue, "Select option").click();
			}
		}
		else {
			common.pause(5);
			common.waitForElement(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitForElement(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();
			common.pause(5);
			common.waitForElement(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();
			common.waitForElement(germanLanguage);

			common.findElementBy(materialTypeField, "Click on material type field").click();
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

		test.log(LogStatus.INFO, "Step :: Click on save button");
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(2);

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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
			common.waitForElement(errorMessage);
			common.log("Rule applied");
			String errorStr = common.findElement(errorMessage).getText();
			common.log("Error showing: " + errorStr);

			common.findElementBy(viewRecord, "Click on View record link text").click();

			common.pause(10);
			String duplicateRecordStr = common.findElement("//*[@id=\"right-side-nav-1\"]/div/ng-component/pros-duplicate-records-datatable/div/div[2]/div[3]/table/tbody/tr[1]/td[3]/lib-text-line/p").getText();
			common.log("Duplicate Object number: " + duplicateRecordStr);
			System.out.println("Duplicate Object number: " + duplicateRecordStr);
		}
		else {
			common.log("Rule not applied");
		}
	}

	public void duplicacy_Check_Is_Working_At_The_Time_Of_Copy_Event() {
		System.out.println("Step :: Click on Data tab");
		common.log("Click on Data tab");
		common.waitForElement(dataTab);
		driver.findElement(By.xpath(dataTab)).click();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
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

		driver.findElement(By.xpath(statusFilter)).sendKeys("System");
		common.pause(10);
		String mmN = driver.findElement(By.xpath(materialMasterNum)).getText();
		System.out.println("Step:: Material master number is ::" + mmN);

		common.pause(10);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		System.out.println("Step :: Click on copy");
		common.log("Click on copy");
		common.pause(5);
		common.findElement(copy).click();
		common.pause(5);

		common.findElementBy(sequentialMaterialOption,"Select Sequential Material").click();
		common.waitForElement(copyButton);
		common.findElementBy(headerData,"Header data verified");

		common.findElementBy(copyButton, "Click on Copy button").click();
		common.waitForElement(submitBtn);
		common.findElementBy(submitBtn,"Click on Submit button").click();
		common.pause(10);
		if (common.isElementDisplayed(errorMessage)) {

			common.log("Rule applied");
			common.waitForElement(errorMessage);
			String errorStr = common.findElement(errorMessage).getText();
			common.log("Error showing: " + errorStr);

			common.findElementBy(viewRecord, "Click on View record link text").click();

			common.pause(10);
			String duplicateRecordStr = common.findElement("//*[@id=\"right-side-nav-1\"]/div/ng-component/pros-duplicate-records-datatable/div/div[2]/div[3]/table/tbody/tr[1]/td[3]/lib-text-line/p").getText();
			common.log("Duplicate Object number: " + duplicateRecordStr);
			System.out.println("Duplicate Object number: " + duplicateRecordStr);
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
		common.waitForElement(sequentialMaterialOption);
		common.findElementBy(sequentialMaterialOption,"Click on Sequential Material").click();
		common.waitForElement(saveButtonFilterPopup);
		common.findElementBy(saveButtonFilterPopup,"Click on Save").click();
		common.pause(10);

		if (common.isElementDisplayed(errorMessage)) {

			common.log("Rule applied");
			common.waitForElement(errorMessage);
			String errorStr = common.findElement(errorMessage).getText();
			common.log("Error showing: " + errorStr);

			common.findElementBy(viewRecord, "Click on View record link text").click();

			common.pause(10);
			String duplicateRecordStr = common.findElement("//*[@id=\"right-side-nav-1\"]/div/ng-component/pros-duplicate-records-datatable/div/div[2]/div[3]/table/tbody/tr[1]/td[3]/lib-text-line/p").getText();
			common.log("Duplicate Object number: " + duplicateRecordStr);
			System.out.println("Duplicate Object number: " + duplicateRecordStr);
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

		test.log(LogStatus.INFO, "Step :: Home tab opened");
		System.out.println("Step :: Home tab opened");
		common.log("Home tab opened");

		common.waitForElement(inboxMenu);
		test.log(LogStatus.INFO, "Step :: click on My request Menu ");
		System.out.println("Step :: click on My request Menu");
		common.log("Click on inbox Menu");
		driver.findElement(By.xpath(myReqTab)).click();
		common.pause(10);

		//If first value appear in Inbox menu then it will reject the flow from Approve option

		if (common.isElementDisplayed(firstActionIconForInbox) == true) {

			common.waitForElement(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox,"Click on first record action icon").click();
			common.pause(10);

			common.findElementBy(approveVal,"Click on approve option").click();
			common.waitForElement(materialDescReviewer);

			if (common.isElementDisplayed(materialDescReviewer)) {
				common.findElementBy(materialDescReviewer, "Enter description").sendKeys("material desc");

				common.findElementBy(divisionField, "Select Division field").click();
				common.findElementBy(dropValue, "Select value").click();

				common.findElementBy(manufacturerField, "Enter Manufacturer number").sendKeys("54321");
				common.findElementBy(oldMaterialNumField, "Enter Old material number").sendKeys("12345");

				common.findElementBy(approveButtonReviewer, "Click on Approve").click();

				common.waitForElement(duplicateRecordFirst);

				String duplicateRecordStr = common.findElement(duplicateRecordFirst).getText();
				common.log("Duplicate Object number: " + duplicateRecordStr);
				System.out.println("Duplicate Object number: " + duplicateRecordStr);
			}
			else {
				common.findElementBy(approveButtonReviewer, "Click on Approve").click();

				common.waitForElement(duplicateRecordFirst);

				String duplicateRecordStr = common.findElement(duplicateRecordFirst).getText();
				common.log("Duplicate Object number: " + duplicateRecordStr);
				System.out.println("Duplicate Object number: " + duplicateRecordStr);
			}
		}
	}
	public void select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset()
	{
		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "click on Material master from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(search);
		common.pause(5);

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
		common.pause(5);

		if(common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption,"Click on Sequential Material flow").click();

			common.waitForElement(materialTypeField);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.pause(5);
			common.waitForElement(dropValue);
			common.findElementBy(dropValue, "Select option").click();
		}
		else {
			common.waitForElement(materialCreationRecord);
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitForElement(materialTypeField);

			common.waitForElement(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitForElement(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitForElement(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitForElement(germanLanguage);
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
			common.waitForElement(errorMessage);

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
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
			common.waitForElement(errorMessage);

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
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
			common.waitForElement(errorMessage);

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
			common.log("Error showing for UDR rule: " + errorStr);
			for (int i = 0; i <= 15; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.findElementBy(materialDescReviewer, "Enter valid numerical value between 0 TO 9 in Material description field").sendKeys("5");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(2);
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
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

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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
			common.waitForElement(errorMessage);

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
			common.log("Error showing for UDR rule: " + errorStr);
			common.pause(5);
			common.findElementBy(materialDescReviewer, "Remove value from in Material description field").click();
			common.pause(5);
			common.findElementBy(materialDescReviewer, "Add '.' after value in Material description field").sendKeys(".");

			common.findElementBy(submitBtn, "Click on submit button").click();

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
		}
		else {

			common.log("Rule not applied");
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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
			common.waitForElement(errorMessage);
			common.log("Rule applied");

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
			common.log("Error showing for UDR rule: " + errorStr);

			common.findElementBy(materialDescReviewer, "Click on Material description field").click();
			common.pause(5);
			common.findElementBy(materialDescReviewer, "Enter 10 length value from in Material description field").sendKeys("1234");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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

			common.waitForElement(errorMessage);

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
			common.log("Error showing for UDR rule: " + errorStr);

			common.findElementBy(materialDescReviewer, "Click on Material description field").click();
			common.pause(5);
			for (int i = 0; i <= 15; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.findElementBy(materialDescReviewer, "Enter numeric value less than 10 in Material description field").sendKeys("5");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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
			common.waitForElement(errorMessage);
			common.log("Rule applied");

			String errorStr = common.findElement("//p[@class='small ng-star-inserted']").getText();
			common.log("Error showing for UDR rule: " + errorStr);

			common.findElementBy(materialDescReviewer, "Click on Material description field").click();
			common.pause(5);
			for (int i = 0; i <= 15; i++) {
				common.findElement(materialDescReviewer).sendKeys(Keys.BACK_SPACE);
			}
			common.findElementBy(materialDescReviewer, "Enter numeric value greater than 10 in Material description field").sendKeys("15");
			common.findElementBy(submitBtn, "Click on submit button").click();
			common.pause(10);
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
		}
		else {
			common.log("Rule not applied");
			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
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
		common.findElement(materialDescLabel).click();
		common.pause(5);
		common.findElementBy(submitBtn,"Click on submit button").click();

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
	}
	/**
	 * verify Transformation Rule Is Working Fine With Remove Leading Zeros
	 *
	 */
	public void verify_Transformation_Rule_Is_Working_Fine_With_Remove_Leading_Zeros() {
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.findElementBy(materialDescReviewer,"Enter value with zeros in Material description field : 00000material").sendKeys("00000material");
		common.findElement(materialDescLabel).click();
		common.pause(5);
		common.findElementBy(submitBtn,"Click on submit button").click();

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
	}
	public void verify_Description_on_Summary_Page()
	{
		common.refreshPage();
		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.waitForElement(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.pause(5);
		common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
		common.pause(10);

		String strDescription = common.findElementBy(materialDescReviewer,"Get value from material description field").getAttribute("value");
		common.log("Value of Material description field: "+strDescription);
		strDescription.contains("0");
	}
	public void verify_Remove_Leading_Zeros_From_Description_on_Summary_Page()
	{
		common.refreshPage();
		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.waitForElement(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.pause(5);
		common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
		common.pause(5);

		common.waitForElement(materialDescReviewer);
		String strDescription = common.findElementBy(materialDescReviewer,"Get value from material description field").getAttribute("value");
		common.log("Value of Material description field: "+strDescription);

		boolean b = !strDescription.contains("0");
		assert b;
	}
	public void verify_Description_Field_For_ConstantValue_on_Summary_Page()
	{
		common.refreshPage();
		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(actionIconForFirstValue);
		common.findElementBy(actionIconForFirstValue, "Click on action button for first value").click();
		common.findElementBy(summaryOption, "Click on Summary option").click();
		common.pause(5);
		common.findElementBy(sequentialMaterialOption, "Click on sequentialMaterial option").click();
		common.pause(10);

		String strDescription = common.findElementBy(materialDescReviewer,"Get value from material description field").getAttribute("value");
		common.log("Value of Material description field: "+strDescription);
		boolean b = strDescription.contains("QA");
		assert b;
	}

	/**
	 * verify Description Generator Short And Long Description Should Auto Populate
	 *
	 */
	public void verify_Description_Generator_Short_And_Long_Description_Should_Auto_Populate() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(search);
		common.pause(5);

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
		common.pause(5);

		if (common.isElementDisplayed(materialCreationRecord)) {
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitForElement(materialTypeField);

			common.waitForElement(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitForElement(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitForElement(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitForElement(germanLanguage);


		} else if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption,"Click on Sequential Material flow").click();

			common.waitForElement(materialTypeField);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.pause(5);
common.waitForElement(dropValue);
			common.findElementBy(dropValue, "Select option").click();

		}

		if (!common.isElementDisplayed(classField)) {
			common.findElementBy(generateDesc, "Click on Generate description button").click();
		}
		common.pause(5);
		common.findElementBy(classField,"Click on class dropdown").click();
		common.waitForElement(bearingBallClassOption);
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

		common.findElementBy(generateDescriptionLabel, "Click on Generate description button").click();
		common.pause(10);
		String shortDescStr = common.findElement(shortDescriptionField).getAttribute("value");
		common.log("Short Description auto populate: "+shortDescStr);
		System.out.println("Short Description auto populate: "+shortDescStr);

		String longDescStr = common.findElement(longDescriptionField).getAttribute("value");
		common.log("Long Description auto populate: "+longDescStr);
		System.out.println("Long Description auto populate: "+longDescStr);


		common.findElementBy(submitBtn, "Click on submit button").click();
		common.pause(10);

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: "+successStr);
		common.waitForElement(dataTab);

	}
	/**
	 * verify Description Generator Language Grid And PO Text Grid Should Be AutoPopulate
	 *
	 */
	public void verify_Description_Generator_Language_Grid_And_PO_Text_Grid_Should_Be_Auto_Populate() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "click on Material master from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");
		common.waitForElement(search);
		common.pause(5);

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
		common.pause(5);

		if (common.isElementDisplayed(materialCreationRecord)) {
			common.findElementBy(materialCreationRecord, "Click on Material Creation option").click();

			common.waitForElement(materialTypeField);

			common.waitForElement(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitForElement(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitForElement(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();

			common.waitForElement(germanLanguage);


		} else if (common.isElementDisplayed(sequentialMaterialOption)) {
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material flow").click();

			common.waitForElement(materialTypeField);

			common.findElementBy(xPlantMaterialStatusField, "Click on x-plant material status").click();
			common.pause(5);
			common.waitForElement(dropValue);
			common.findElementBy(dropValue, "Select option").click();

		}

		common.waitForElement(classField);
		common.findElementBy(classField, "Click on class dropdown").click();
		common.waitForElement(bearingBallClassOption);
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
		common.pause(5);
		common.findElement(materialDescReviewer).click();
		common.findElement(materialDescReviewer).click();
		common.pause(10);

		common.findElementBy(generateDescriptionLabel, "Click on Generate description button").click();
		common.pause(10);
		String shortDescStr = common.findElement(shortDescriptionField).getAttribute("value");
		common.log("Short Description auto populate: " + shortDescStr);
		System.out.println("Short Description auto populate: " + shortDescStr);

		String longDescStr = common.findElement(longDescriptionField).getAttribute("value");
		common.log("Long Description auto populate: " + longDescStr);
		System.out.println("Long Description auto populate: " + longDescStr);

		List<WebElement> languageDescription = driver.findElements(By.xpath("//div[contains(text(),'Material Description')]//..//..//..//..//..//..//lib-input[1]//div[1]//div//input[1]"));

		for (WebElement e : languageDescription) {

			System.out.println("Language Grid Material descriptions: " + e.getAttribute("value"));
			common.log("Language Grid Material descriptions: " + e.getAttribute("value"));
		}

		common.findElementBy(submitBtn, "Click on submit button").click();

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: " + successStr);
		common.waitForElement(dataTab);
	}
	/**
	 * Creation - verify Mandatory Field On Execution Page At Edit Time
	 */
	public void verify_Mandatory_Field_On_Execution_Page_At_Edit_Time() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		driver.findElement(By.xpath(dataTab)).click();
		common.waitForElement(materialMaster);

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

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.pause(5);
			common.findElementBy(sequentialMaterialOption,"Click on SequentialMaterial option").click();


		}
		else
		{
			System.out.println("Step :: Click on material creation process");
			common.log("Click on material master creation process");
			driver.findElement(By.xpath(materialCreationRecord)).click();
			common.pause(10);
			common.waitForElement(headerData);
			common.pause(10);

			if (common.isElementDisplayed(actionIconLanguage)) {

				common.findElementBy(actionIconLanguage, "Click on action icon for added language").click();
				common.waitForElement(deleteRowOption);
				common.findElementBy(deleteRowOption, "Click on delete row option").click();
				common.pause(5);
			}
		}
		common.waitForElement(addPlantData);
		common.findElementBy(addPlantData,"Click on Add Plant data").click();
		common.pause(5);
		common.waitForElement(searchPlantData);
		if (common.isElementDisplayed("//input[@aria-checked='true']")) {
			common.log("Uncheck the selected hierarchy");
			common.jsClick("//input[@aria-checked='true']");
		}
		common.findElementBy(searchPlantData,"Enter value 0002").sendKeys("0002");
		common.waitForElement(searchedPantValue);
		common.pause(5);
		common.findElementBy(searchedPantValue,"Select searched value").click();
		common.pause(5);
		common.findElementBy(applyFilterButton,"Click on apply button").click();
		common.pause(5);
		common.findElement(materialDescLabel).click();
		common.findElement(materialDescLabel).click();

		test.log(LogStatus.INFO, "Step :: Click on save button");
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(10);

		if (common.isElementDisplayed("//p[normalize-space()='Fix the following errors to proceed']")) {
			//Verifying Error for mandatory fields
			common.assertElementPresent("//p[normalize-space()='Fix the following errors to proceed']");
			common.waitForElement("//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div[1]//p");

			String strError = common.findElement("//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div[1]//p").getText();
			common.log("Error: " + strError);
		}
	}

	/**
	 * Extend - verify Able To Extend Multiple Similar Child Hierarchies At The Same Time
	 */
	public void verify_Able_To_Extend_Multiple_Similar_Child_Hierarchies_At_The_Same_Time() {

		common.waitForElement(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		driver.findElement(By.xpath(dataTab)).click();
		common.waitForElement(materialMaster);

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

		if (common.isElementDisplayed(sequentialMaterialOption))
		{
			common.pause(5);
			common.findElementBy(sequentialMaterialOption,"Click on SequentialMaterial option").click();
			common.pause(10);
			common.waitForElement(addPlantData);
			common.findElementBy(addPlantData,"Click on Add Plant data").click();
			common.waitForElement(searchPlantData);
			if (common.isElementDisplayed("//input[@aria-checked='true']")) {
				common.findElementBy("//input[@aria-checked='true']", "Uncheck the selected hierarchy").click();
			}
			common.findElementBy(searchPlantData,"Enter value 0002").sendKeys("0002");
			common.waitForElement(searchedPantValue);
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

			if (common.isElementDisplayed(planingCycleField)) {
				common.findElementBy(planingCycleField, "Fill planing cycle field").sendKeys("10");
				common.pause(5);
//				common.findElementBy(dnuFixedPeriods, "Fill DNU Fixed periods field").sendKeys("5");
//				common.pause(5);
//				common.findElementBy(lastForecastField, "Fill last forecast field").sendKeys("10");
			}

		}
		else
		{

			System.out.println("Step :: Click on material creation process");
			common.log("Click on material master creation process");
			driver.findElement(By.xpath(materialCreationRecord)).click();
			common.pause(10);
			common.waitForElement(headerData);
			common.waitForElement(addPlantData);
			common.findElementBy(addPlantData,"Click on Add Plant data").click();
			common.waitForElement(searchPlantData);
			common.pause(5);
			if (common.isElementDisplayed("//input[@aria-checked='true']")) {
				common.findElementBy("//input[@aria-checked='true']", "Uncheck the selected hierarchy").click();
			}
			common.findElementBy(searchPlantData,"Enter value 0002").sendKeys("0002");
			common.waitForElement(searchedPantValue);
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

			test.log(LogStatus.INFO, "Step :: Click on save button");
			System.out.println("Step :: Click on save button");
			common.log("Click on save button");
			common.waitForElement(uSaveBtn);
			driver.findElement(By.xpath(uSaveBtn)).click();
			common.pause(10);

			if (common.isElementDisplayed(actionIconLanguage)) {

				common.findElementBy(actionIconLanguage, "Click on action icon for added language").click();
				common.waitForElement(deleteRowOption);
				common.findElementBy(deleteRowOption, "Click on delete row option").click();
				common.pause(5);
			}
			common.waitForElement(addRowLanguageGrid);
			common.findElementBy(addRowLanguageGrid, "Click on Add row button in Language grid section").click();
			common.pause(5);
			common.waitForElement(languageInput);
			common.findElementBy(languageInput, "Click on Language dropdown").click();

			common.waitForElement(germanLanguage);
			common.findElementBy(germanLanguage, "Select German language from option").click();

			common.findElementBy(materialDescFormView, "Enter material description").sendKeys("Test");
			common.findElementBy(saveFormView, "Click on save on form view").click();
			common.waitForElement(germanLanguage);

			common.findElementBy(materialTypeField, "Click on material type field").click();
			common.pause(5);
			common.findElementBy(dropValue3, "Select value from options").click();
			common.pause(5);

			common.findElementBy(materialGroupField, "Click on material group field").click();
			common.pause(5);
			common.findElementBy(dropValue3, "Select value from options").click();
			common.pause(5);
		}
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(10);

		if (common.isElementDisplayed("//p[normalize-space()='Fix the following errors to proceed']")) {
			//Verifying Error for mandatory fields
			common.assertElementPresent("//p[normalize-space()='Fix the following errors to proceed']");
			common.waitForElement("//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div[1]//p");

			String strError = common.findElement("//div[@class='f-col sidesheetcontent-listing ng-star-inserted']/div[@class='f-col mdo-justify ng-star-inserted']/div[1]//p").getText();
			common.log("Error: " + strError);
		}
	}
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Leading_Spaces_On_Transaction_Page()
	{
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
			common.pause(10);
			common.findElementBy(materialDescReviewer, "Enter value in material description field with leading spaces").sendKeys("        Test");
			String value1 = common.findElement(materialDescReviewer).getAttribute("value");
			System.out.println("value of description field: "+value1);
			common.log("value of description field: "+value1);

			common.pause(5);
			common.findElementBy(materialDescLabel,"Click on material description label").click();
			common.pause(5);
			String value2 = common.findElement(materialDescReviewer).getAttribute("value");
			System.out.println("new value of description field: "+value2);
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

			common.waitForElement("//div[@class='cdk-overlay-pane']");
			String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
			common.log("Message display: " + successStr);
			common.waitForElement(dataTab);
	}
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_Trailing_Spaces_On_Transaction_Page() {
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description field with leading spaces").sendKeys("Test          ");
		String value1 = common.findElement(materialDescReviewer).getAttribute("value");
		System.out.println("value of description field: " + value1);
		common.log("value of description field: " + value1);

		common.pause(5);
		common.findElementBy(materialDescLabel, "Click on material description label").click();
		common.pause(5);
		String value2 = common.findElement(materialDescReviewer).getAttribute("value");
		System.out.println("new value of description field: " + value2);
		common.log("new value of description field: " + value2);

		//verifying rule applied or not
		if (value1.equals(value2)) {
			common.log("Rule not applied");
			common.log("Trailing spaces removed");
		} else {

			common.log("Rule applied");
		}

		common.findElementBy(submitBtn, "Click on submit button").click();

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: " + successStr);
		common.waitForElement(dataTab);
	}
	public void verify_Transformation_Rule_Of_Type_EMPTY_SPACE_With_Remove_All_Spaces_On_Transaction_Page()
	{
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description field with spaces").sendKeys("Test  test  test ");
		String value1 = common.findElement(materialDescReviewer).getAttribute("value");
		System.out.println("value of description field: "+value1);
		common.log("value of description field: "+value1);

		common.pause(5);
		common.findElementBy(materialDescLabel,"Click on material description label").click();
		common.pause(5);
		String value2 = common.findElement(materialDescReviewer).getAttribute("value");
		System.out.println("new value of description field: "+value2);
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

		common.waitForElement("//div[@class='cdk-overlay-pane']");
		String successStr = common.findElement("//div[@class='cdk-overlay-pane']").getText();
		common.log("Message display: " + successStr);
		common.waitForElement(dataTab);
	}

	public void verify_Transformation_Rule_Of_Type_Concatenation_With_Remove_All_Spaces_On_Transaction_Page()
	{
		select_Flow_And_Fill_Mandatory_Fields_From_Material_Master_Dataset();
		common.pause(10);
		common.findElementBy(materialDescReviewer, "Enter value in material description").sendKeys("Test");
		String materialDesc = common.findElement(materialDescReviewer).getAttribute("value");
		System.out.println("value of description field: "+materialDesc);
		common.log("value of description field: "+materialDesc);

		common.findElementBy(grossWeightField, "Enter value in Gross weight").sendKeys("10");
		String grossWeight = common.findElement(grossWeightField).getAttribute("value");
		System.out.println("value of Gross Weight field: "+grossWeight);
		common.log("value of Gross Weight field: "+grossWeight);

		common.findElementBy(grossWeightField, "Enter value in Authorization group").sendKeys("qa");
		String authorizationGroup = common.findElement(grossWeightField).getAttribute("value");
		System.out.println("value of Authorization group field: "+grossWeight);
		common.log("value of Authorization group field: "+grossWeight);

		common.pause(5);
		common.findElementBy(grossWeightLabel,"Click on Gross weight label").click();
		common.pause(5);

		common.waitForElement(volumeField);
		String volume = common.findElement(volumeField).getAttribute("value");
		System.out.println("value of volume field: "+volume);
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
		common.waitForElement(dataTab);
		common.findElement(dataTab).click();
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.waitForElement(actionIconForFirstValue);
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
