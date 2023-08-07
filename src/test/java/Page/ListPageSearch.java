package Page;

import Page.ServiceHelper.AuthenticationService;
import Page.ServiceHelper.EnvironmentService;
import Page.contracts.IAuthenticationService;
import Page.contracts.IEnvironmentService;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class ListPageSearch extends Locators {

	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;
	public ListPageSearch(WebDriver driver) throws Exception {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();

	}

	/**
	 * Verify User Able To Search Created Modified On Date In Column Filter
	 *
	 */
	public void user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();

		common.waitUntilElementToBeVisible(search);
		if (common.isElementDisplayed(clearSearchField))
		{
			common.findElementBy(clearSearchField, "Clear the search field").click();
			common.pause(5);
		}
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.waitUntilElementToBeVisible(dataTab);
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.findElementBy(createdOnFilter, "Click on Created on Filter").click();

		common.waitUntilElementToBeVisible(date3);

		common.findElementBy(date3, "Click on 3rd date").click();

		common.findElementBy(endDateTab, "Click on End tab in Datepicker").click();

		common.findElementBy(date10, "Click on 10th date").click();
		common.pause(10);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();

		common.waitUntilElementToBeVisible(modifiedOnFilter);

		common.findElementBy(modifiedOnFilter, "Click on Modified on Filter").click();

		common.findElementBy(date3, "Click on 3rd date").click();

		common.findElementBy(endDateTab, "Click on End tab in Datepicker").click();

		common.findElementBy(date10, "Click on 10th date").click();
		common.pause(10);

		action.sendKeys(Keys.ESCAPE).perform();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);

			common.assertElementPresent(firstValueMaterialMaster);
		}

	}

	/**
	 * Verify User Able To Search Based On Material Description Group Type, Industry, Base Unit Of Measure In Column Filter
	 *
	 */
	public void user_AbleToSearch_BasedOn_MaterialDesc_Group_Type_Indus_BaseUnitOfMeasure_In_Column_Filter() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.pause(5);
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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);
		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
		common.log("First value of Material master table: " + strFirstValue);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.pause(10);
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Material Type tab");
		common.jsClick(filterMaterialType);

		common.waitUntilElementToBeVisible(valueSparePart_MaterialTypeFilter);
		common.findElementBy(valueSparePart_MaterialTypeFilter, "Select value Spare part for Material Type filter")
				.click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue1 = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue1);
		}
		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.pause(10);
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Material Description tab");
		common.jsClick(filterMaterialDesc);
		common.waitUntilElementToBeVisible(input_MaterialDescFilter);
		common.log("Enter 'BALL' in  Material Description textarea");
		common.type(input_MaterialDescFilter, "BALL");

		common.log("Click on Enter for save details");
		common.findElementBy(input_MaterialDescFilter, "").sendKeys(Keys.ENTER);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue2 = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue2);
		}
		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.pause(10);
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Base Unit Of Measure tab");
		common.jsClick(filterBaseUnitOfMeasure);

		common.waitUntilElementToBeVisible(valuePercentage_BaseUnitFilter);
		common.findElementBy(valuePercentage_BaseUnitFilter, "Select Percentage value").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue3 = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue3);
		}

	}

	/**
	 * verify User Able To Search Work For Dropdown Type Field While Selecting a Value
	 *
	 */
	public void user_AbleTo_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value() {

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
		common.findElementBy(filterStatusDropdown, "Click on Status filter dropdown and Enter System").click();
		common.type(filterStatusDropdown, "System");
		common.pause(10);

		String strFirstValue = common.findElement(firstValueOfStatus).getText();
		common.log("Status Of First value of Material master table: " + strFirstValue);

		common.findElementBy(clearIconForStatusFilter, "Clear applied filter").click();
		common.pause(10);

		common.findElement(filterModifiedByDropdown).click();
//		common.findElementBy(filterModifiedByDropdown, "Click on Modified By filter dropdown and Enter Reviewer")
//				.click();
		common.pause(10);
		common.type(filterModifiedByDropdown, "Reviewer");
		common.pause(10);

		String strFirstValue1 = common.findElement(firstValueOfModifiedBy).getText();
		common.log("Modified By Of First value of Material master table: " + strFirstValue1);

		common.findElementBy(clearIconForModifiedByFilter, "Clear applied filter").click();
	}

	/**
	 * Verify User Able To Apply The Filters Using IsNot Conditions
	 *
	 */
	public void user_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions() {

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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(isNotFilter, "Select Is not filter").click();
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
		common.log("First value of Material master table: " + strFirstValue);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.pause(10);
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Material Type tab");
		common.jsClick(filterMaterialType);

		common.waitUntilElementToBeVisible(valueSparePart_MaterialTypeFilter);

		common.findElementBy(isNotFilter, "Select Is not filter").click();
		common.findElementBy(valueSparePart_MaterialTypeFilter, "Select value Spare part for Material Type filter")
				.click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue1 = common.findElement(firstValueMaterialMaster).getText();
		common.log("First value of Material master table: " + strFirstValue1);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Base Unit Of Measure tab");
		common.jsClick(filterBaseUnitOfMeasure);

		common.waitUntilElementToBeVisible(valuePercentage_BaseUnitFilter);

		common.findElementBy(isNotFilter, "Select Is not filter").click();
		common.findElementBy(valuePercentage_BaseUnitFilter, "Select Percentage value").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue3 = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue3);
		}

	}

	/**
	 * Verify User Able To Reset Filters In Advance Filter Using The Reset Button
	 *
	 */
	public void user_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button() {

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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(5);
		common.waitUntilElementToBeVisible(valueFMCG_IndustrySectorFilter);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();
		common.pause(5);
		common.findElementBy(applyFilterButton,"Click on Apply button").click();

		common.waitUntilElementToBeVisible(appliedIndusSectorFilter);
		common.findElementBy(appliedIndusSectorFilter,"Industry Sector filter is applied");

		common.pause(5);
		common.findElementBy(threeDotsAdvanceFilter, "Click on Three dots").click();

		common.findElementBy(resetButton, "Click on Reset button").click();

		if (common.isElementDisplayed(confirmButton)) {
			common.findElementBy(confirmButton, "Click on Confirm button in popup").click();
		}
		common.pause(5);
		common.isElementNotDisplayed(appliedIndusSectorFilter);
		common.log("Verify applied Industry Sector filter is not appear");

	}

	/**
	 * Verify user Can Apply Multiple Filters For Multiple Fields In Advance Filter Search
	 *
	 */
	public void user_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search() {

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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);

		common.log("Click on Base Unit Of Measure tab");
		common.jsClick(filterBaseUnitOfMeasure);

		common.waitUntilElementToBeVisible(valuePercentage_BaseUnitFilter);

		common.pause(10);
		common.findElementBy(valuePercentage_BaseUnitFilter, "Select Percentage value").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue3 = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue3);
		}

	}

	/**
	 * Verify User Can Save The Filter Applied On Different Fields Using The Save As Button
	 *
	 */
	public void user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button() {

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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);
		}

		common.findElementBy(threeDotsIconAppliedFilter, "Click on three dots button beside Advance filter icon")
				.click();

		common.findElementBy(saveAsOption, "Select Save as option").click();
		common.pause(5);

		String strFilter = common.generateRandomChars(5);
		common.log("Enter filter name in input field: " + strFilter);
		common.type(filterNameInput, strFilter);

		common.findElementBy(saveButtonFilterPopup, "Click on Save button in popup").click();

		common.pause(10);
		common.refreshPage();
		common.pause(10);

		common.assertElementPresent(firstValueMaterialMaster);

		common.findElementBy(storedFiltersIcon, "Click on stored filters layer icon").click();
		common.pause(10);

		common.findElementBy((WebElement) By.xpath("//button[normalize-space()='" + strFilter + "']"), "Select last created filter").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table after select filter: " + strFirstValue);
		}

	}

	/**
	 * Verify User Can Cancel The Filter Applied On Different Fields Using The Save As Button
	 *
	 */
	public void user_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button() {

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

			common.waitUntilElementToBeVisible(viewDropDownIcon);
			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);
		}

		common.findElementBy(threeDotsIconAppliedFilter, "Click on three dots button beside Advance filter icon")
				.click();

		common.findElementBy(saveAsOption, "Select Save as option").click();
		common.pause(5);

		String strFilter = common.generateRandomChars(5);
		common.log("Enter filter name in input field: " + strFilter);
		common.type(filterNameInput, strFilter);

		common.findElementBy(cancelButtonFilterPopup, "Click on Cancel button in popup").click();

		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {

			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table after select filter: " + strFirstValue);
		}
	}

	/**
	 * Verify User Can Apply The Column Filter And Advanced Filter At A Time And Club The Searches
	 *
	 */
	public void user_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches() {

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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);
		}

		user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter();
	}

	/**
	 * Verify Column Sort Functionality Should Work As Expected On The List Page For Fields
	 *
	 */
	public void column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields() {

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
		common.waitUntilElementToBeVisible(firstValueCreatedOnDateInTable);
		String strFirstValue = common.findElement(firstValueCreatedOnDateInTable).getText();
		common.log("Created On date of Material master before sorting: " + strFirstValue);

		String strFirstValue1 = common.findElement(firstValueCreatedOnDateInTable).getText();
		common.log("Created On date of Material master after sorting: " + strFirstValue1);

	}

	/**
	 * Verify The User Is Able To Delete The Saved Filter
	 *
	 */
	public void verify_The_User_Is_Able_To_Delete_The_Saved_Filter() {

		common.findElementBy(threeDotsIconAppliedFilter, "Click on three dots button beside Advance filter icon")
				.click();

		common.findElementBy(deleteSavedFilters, "Click on Delete option").click();
		common.pause(5);

	}

	/**
	 * Verify The Pagination Show Count Should Be Working Fine After Applying Filters
	 *
	 */
	public void verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters() {

		common.pause(5);
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
		String paginationStr = common.findElement(paginationValue).getText();
		common.log("Pagination value before applying filter: " + paginationStr);

		common.pause(5);

		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.log("Click on Industry sector tab");
		common.jsClick(filterIndustrySector);

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String paginationStr1 = common.findElement(paginationValue).getText();
		common.log("Pagination value after applying filter: " + paginationStr1);

		common.assertTwoValuesAreNotEqual(paginationStr, paginationStr1);
	}

	/**
	 * Verify User Can Search Using Special Characters In Manufacturer Part Number Filter Field
	 *
	 */
	public void user_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field() {

		common.pause(5);
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
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(filterIndustrySector);

		common.findElementBy(manufacturerPartNumFilterTab, "Click on Manufacturer Part Number filter tab").click();

		common.waitUntilElementToBeVisible(inputManufacturerPartNumFilter);

		common.pause(5);
		common.log("Enter special characters");
		common.type(inputManufacturerPartNumFilter, "#$%");

		common.findElementBy(inputManufacturerPartNumFilter, "").sendKeys(Keys.ENTER);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue2 = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue2);
		}

	}


	/**
	 * Verify User Able To Search Follow Fuzzy Logic,Verify Results And Clear Search
	 *
	 */
	public void user_Able_To_Search_Follow_Fuzzy_Logic_Verify_Results_And_Clear_Search() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.waitUntilElementToBeVisible(dataTab);
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.waitUntilElementToBeVisible(searchB);
		common.findElementBy(searchB,"Click on Search field and search '123' ").click();
		common.findElement(searchB).sendKeys("123");
		common.pause(10);

		//verify searched material master record present
		common.waitUntilElementToBeVisible((WebElement) By.xpath("//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"));
		String strSearchedValue = common.findElement((WebElement) By.xpath("//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
		common.log("Searched value: " + strSearchedValue);

		common.findElementBy(applySearch,"Click on Apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);

			common.assertElementPresent(firstValueMaterialMaster);
		}

		common.findElementBy(clearSearch,"Clear the searched value from search field").click();

		common.waitUntilElementToBeVisible(searchPlaceHolder);
		common.assertElementPresent(searchPlaceHolder);

	}

	/**
	 * Verify While Clearing The Text Search It Should Not Impact Any Applied Filters
	 *
	 */
	public void verify_While_Clearing_The_Text_Search_It_Should_Not_Impact_Any_Applied_Filters() {

		common.pause(5);
		common.findElementBy(filterStatusDropdown, "Click on Status filter dropdown and Enter System").click();
		common.type(filterStatusDropdown, "System");
		common.pause(10);

		common.findElementBy(searchB,"Click on Search field and search '123' ").click();
		common.findElement(searchB).sendKeys("123");
		common.pause(10);

		//verify searched material master record present
		common.waitUntilElementToBeVisible((WebElement) By.xpath("//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"));
		String strSearchedValue = common.findElement((WebElement) By.xpath("//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
		common.log("Searched value: " + strSearchedValue);

		common.findElementBy(applySearch,"Click on Apply button").click();
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue = common.findElement(firstValueMaterialMaster).getText();
			common.log("First value of Material master table: " + strFirstValue);

			common.assertElementPresent(firstValueMaterialMaster);
		}
		common.pause(10);
		common.findElementBy(clearSearch,"Clear the searched value from search field").click();
		common.jsClick(clearSearch);

		common.waitUntilElementToBeVisible(searchPlaceHolder);
		common.assertElementPresent(searchPlaceHolder);

		common.log("Verify filtered status available");
		common.assertElementPresent((WebElement) By.xpath("//span[normalize-space()='Status']//..//span[normalize-space()='System']"));

	}

	/**
	 * User Should Be Able To Club The Text Search With Other List Page Filter
	 *
	 */
	public void user_Should_Be_Able_To_Club_The_Text_Search_With_Other_List_Page_Filter() {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.waitUntilElementToBeVisible(dataTab);
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);
		}

		common.findElementBy(searchB,"Click on Search field and search '123' ").click();
		common.findElement(searchB).sendKeys("123");
		common.pause(10);

		//verify searched material master record present
		common.waitUntilElementToBeVisible((WebElement) By.xpath("//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]"));
		String strSearchedValue = common.findElement((WebElement) By.xpath("//mat-card[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
		common.log("Searched value: " + strSearchedValue);

		common.findElementBy(applySearch,"Click on Apply button").click();
		common.pause(10);

		common.findElementBy(filterStatusDropdown, "Click on Status filter dropdown and Enter System").click();
		common.type(filterStatusDropdown, "System");
		common.pause(10);

		if (common.isElementDisplayed(firstValueMaterialMaster)) {
			String strFirstValue = common.findElement((WebElement) By.xpath("//tbody/tr[1]")).getText();
			common.log("First value of Material master table: " + strFirstValue);

			common.assertElementPresent(firstValueMaterialMaster);
		}
		common.pause(10);

	}
}
