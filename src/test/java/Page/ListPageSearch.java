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

public class ListPageSearch extends Locators {

	Common common = new Common(driver);
	Properties obj = new Properties();

	public ListPageSearch(RemoteWebDriver d) throws FileNotFoundException {

		super(d);

	}

	/**
	 * user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter
	 * 
	 */
	public void user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();

		common.waitForElement(dataTab);

		common.findElementBy(createdOnFilter, "Click on Created on Filter").click();

		common.waitForElement(date3);

		common.findElementBy(date3, "Click on 3rd date").click();

		common.findElementBy(endDateTab, "Click on End tab in Datepicker").click();

		common.findElementBy(date10, "Click on 10th date").click();
		common.pause(10);

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.tagName("body")), 0, 0);

		action.moveByOffset(10, 20).click().build().perform();

		common.waitForElement(modifiedOnFilter);

		common.findElementBy(modifiedOnFilter, "Click on Modified on Filter").click();

		common.findElementBy(date3, "Click on 3rd date").click();

		common.findElementBy(endDateTab, "Click on End tab in Datepicker").click();

		common.findElementBy(date10, "Click on 10th date").click();
		common.pause(20);

		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.tagName("body")), 0, 0);

		action1.moveByOffset(20, 200).click().build().perform();
		common.pause(10);
		common.waitForElement(firstValuematerialMaster);

		String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue);
		common.log("First value of Material master table:: " + strFirstValue);

		common.assertElementPresent(firstValuematerialMaster);

	}

	/**
	 * user_AbleToSearch_BasedOn_MaterialDesc_Group_Type_Indus_BaseUnitOfMeasure_In_Column_Filter
	 * 
	 */
	public void user_AbleToSearch_BasedOn_MaterialDesc_Group_Type_Indus_BaseUnitOfMeasure_In_Column_Filter() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue);
		common.log("First value of Material master table:: " + strFirstValue);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterMaterialType, "Click on Material Type tab").click();

		common.waitForElement(valueSparePart_MaterialTypeFilter);
		common.findElementBy(valueSparePart_MaterialTypeFilter, "Select value Spare part for Material Type filter")
				.click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue1 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue1);
		common.log("First value of Material master table:: " + strFirstValue1);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterMaterialDesc, "Click on Material Description tab").click();

		common.waitForElement(input_MaterialDescFilter);
		common.type(input_MaterialDescFilter, "BALL");

		common.findElementBy(input_MaterialDescFilter, "").sendKeys(Keys.ENTER);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue2 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue2);
		common.log("First value of Material master table:: " + strFirstValue2);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterBaseUnitOfMeasure, "Click on Base Unit Of Measure tab").click();

		common.waitForElement(valuePercentage_BaseUnitFilter);
		common.findElementBy(valuePercentage_BaseUnitFilter, "Select Percentage value").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue3 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table:: " + strFirstValue3);
			common.log("First value of Material master table:: " + strFirstValue3);
		}

	}

	/**
	 * User_AbleTo_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value
	 * 
	 */
	public void user_AbleTo_Search_Should_Work_For_Dropdown_Type_Field_While_Selecting_a_Value() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.findElementBy(filterStatusDropdown, "Click on Status filter dropdown and Enter System").click();
		common.type(filterStatusDropdown, "System");
		common.pause(10);
		
		String strFirstValue = driver.findElement(By.xpath(firstValueOfStatus)).getText();

		System.out.println("Status Of First value of Material master table:: " + strFirstValue);
		common.log("Status Of First value of Material master table:: " + strFirstValue);

		common.findElementBy(clearIconForStatusFilter, "Clear applied filter").click();
		common.pause(10);
		
		common.findElementBy(filterModifiedByDropdown, "Click on Modified By filter dropdown and Enter Reviewer").click();
		common.type(filterModifiedByDropdown, "Reviewer");
		common.pause(10);
		
		String strFirstValue1 = driver.findElement(By.xpath(firstValueOfModifiedBy)).getText();

		System.out.println("Modified By Of First value of Material master table:: " + strFirstValue1);
		common.log("Modified By Of First value of Material master table:: " + strFirstValue1);

		common.findElementBy(clearIconForModifiedByFilter, "Clear applied filter").click();
	}
	
	/**
	 * user_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions
	 * 
	 */
	public void user_Able_To_Apply_The_Filters_Using_And_IsNot_Conditions() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(isNotFilter, "Select Is not filter").click();
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue);
		common.log("First value of Material master table:: " + strFirstValue);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterMaterialType, "Click on Material Type tab").click();

		common.waitForElement(valueSparePart_MaterialTypeFilter);

		common.findElementBy(isNotFilter, "Select Is not filter").click();
		common.findElementBy(valueSparePart_MaterialTypeFilter, "Select value Spare part for Material Type filter")
				.click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue1 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue1);
		common.log("First value of Material master table:: " + strFirstValue1);

		common.findElementBy(clearAppliedFiler, "Clear Applied filter").click();
		
		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterBaseUnitOfMeasure, "Click on Base Unit Of Measure tab").click();

		common.waitForElement(valuePercentage_BaseUnitFilter);

		common.findElementBy(isNotFilter, "Select Is not filter").click();
		common.findElementBy(valuePercentage_BaseUnitFilter, "Select Percentage value").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue3 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table:: " + strFirstValue3);
			common.log("First value of Material master table:: " + strFirstValue3);
		}

	}
	/**
	 * user_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button
	 * 
	 */
	public void user_Able_To_Reset_Filters_In_Advance_Filter_Using_The_Reset_Button() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);
		common.assertElementPresent(appliedIndusScetoryFilter);
		
		common.findElementBy(threeDotsAdvanceFilter, "Click on Three dots").click();

		common.findElementBy(resetButton, "Click on Reset button").click();
		
		common.findElementBy(confirmButton, "Click on Confirm button in popup").click();

		common.pause(10);
		common.assertElementNotPresent(appliedIndusScetoryFilter);
		
	}
	
	/**
	 * user_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search
	 * 
	 */
	public void user_Can_Apply_Multiple_Filters_For_Multiple_Fields_In_Advance_Filter_Search() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);

		common.findElementBy(filterBaseUnitOfMeasure, "Click on Base Unit Of Measure tab").click();

		common.waitForElement(valuePercentage_BaseUnitFilter);

		common.pause(10);
		common.findElementBy(valuePercentage_BaseUnitFilter, "Select Percentage value").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(20);

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue3 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table:: " + strFirstValue3);
			common.log("First value of Material master table:: " + strFirstValue3);
		}

	}
	/**
	 * user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button
	 * 
	 */
	public void user_Can_Save_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table:: " + strFirstValue);
			common.log("First value of Material master table:: " + strFirstValue);
		}
		
		common.findElementBy(threeDotsIconAppliedFilter, "Click on three dots button beside Advance filter icon").click();
		
		common.findElementBy(saveAsOption, "Select Save as option").click();
		common.pause(5);
		
		String strFilter = common.generateRandomChars(5);

		System.out.println("Step:: Enter filter name in input field: "+strFilter);
		common.log("Step:: Enter filter name in input field: "+strFilter);
		common.type(filterNameInput, strFilter);
		
		common.findElementBy(saveButtonFilterPopup, "Click on Save button in popup").click();
		
		common.pause(10);
		common.refreshPage();
		common.pause(15);
		
		common.assertElementPresent(firstValuematerialMaster);

		common.findElementBy(storedFiltersIcon, "Click on stored filters layer icon").click();
		common.pause(10);

		common.findElementBy("//button[normalize-space()='"+strFilter+"']", "Select last created filter").click();
		common.pause(10);
		
		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table after select filter:: " + strFirstValue);
			common.log("First value of Material master table after select filter:: " + strFirstValue);
		}
		
	}
	/**
	 * user_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button
	 * 
	 */
	public void user_Can_Cancel_The_Filter_Applied_On_Different_Fields_Using_The_Save_As_Button() {
		
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.pause(10);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table:: " + strFirstValue);
			common.log("First value of Material master table:: " + strFirstValue);
		}
		
		common.findElementBy(threeDotsIconAppliedFilter, "Click on three dots button beside Advance filter icon").click();
		
		common.findElementBy(saveAsOption, "Select Save as option").click();
		common.pause(5);
		
		String strFilter = common.generateRandomChars(5);

		System.out.println("Step:: Enter filter name in input field: "+strFilter);
		common.log("Step:: Enter filter name in input field: "+strFilter);
		common.type(filterNameInput, strFilter);
		
		common.findElementBy(cancelButtonFilterPopup, "Click on Cancel button in popup").click();
		
		common.pause(10);
		
		if (common.isElementPresent(firstValuematerialMaster)) {

			String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

			System.out.println("First value of Material master table after select filter:: " + strFirstValue);
			common.log("First value of Material master table after select filter:: " + strFirstValue);
		}
		
	}

	/**
	 * user_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches
	 * 
	 */
	public void user_Can_Apply_The_Column_Filter_And_Advanced_Filter_At_A_Time_And_Club_The_Searches() {
	
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue);
		common.log("First value of Material master table:: " + strFirstValue);
		user_AbleToSearch_CreatedModified_On_Date_In_Column_Filter();
	}

	/**
	 * column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields
	 *
	 */
	public void column_Sort_Functionality_Should_Work_As_Expected_On_The_List_Page_For_Fields() {

		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(firstvalueCreatedOnDateInTable);
		String strFirstValue = driver.findElement(By.xpath(firstvalueCreatedOnDateInTable)).getText();

		System.out.println("Created On date of Material master before sorting:: " + strFirstValue);
		common.log("Created On date of Material master before sorting:: " + strFirstValue);

		common.findElementBy(createdOnSortFilter, "Click on Created On sort filter").click();
		common.pause(10);

		String strFirstValue1 = driver.findElement(By.xpath(firstvalueCreatedOnDateInTable)).getText();

		System.out.println("Created On date of Material master after sorting:: " + strFirstValue1);
		common.log("Created On date of Material master after sorting:: " + strFirstValue1);

	}

	/**
	 * verify_The_User_Is_Able_To_Delete_The_Saved_Filter
	 *
	 */
	public void verify_The_User_Is_Able_To_Delete_The_Saved_Filter() {

		common.findElementBy(threeDotsIconAppliedFilter, "Click on three dots button beside Advance filter icon")
				.click();

		common.findElementBy(deleteSavedFilters, "Click on Delete option").click();
		common.pause(5);

	}
	/**
	 * verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters
	 *
	 */
	public void verify_The_Pagination_Show_Count_Should_Be_Working_Fine_After_Applying_Filters() {


		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		String paginationStr = driver.findElement(By.xpath(paginationValue)).getText();

		System.out.println("Paginaton value before applying filter:: " + paginationStr);
		common.log("Pagination value before applying filter:: " + paginationStr);

		common.pause(5);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.waitForElement(filterIndustrySector);

		common.findElementBy(filterIndustrySector, "Click on Industry sector tab").click();

		common.pause(10);
		common.findElementBy(valueFMCG_IndustrySectorFilter, "Select value FMCG for Industry sector filter").click();

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);


		String paginationStr1 = driver.findElement(By.xpath(paginationValue)).getText();

		System.out.println("Paginaton value after applying filter:: " + paginationStr1);
		common.log("Pagination value after applying filter:: " + paginationStr1);

		common.assertTwoValuesAreNotEqual(paginationStr, paginationStr1);
	}
	/**
	 * user_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field
	 *
	 */
	public void user_Can_Search_Using_Special_Characters_In_Manufacturer_Part_Number_Filter_Field() {
		common.waitForElement(dataTab);

		common.findElementBy(dataTab, "Click on Data tab").click();
		common.waitForElement(search);
		common.type(search, "Material Master");

		common.waitForElement(materialMaster);
		common.findElementBy(materialMaster, "Click on Material master").click();
		common.pause(10);

		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(5);
		common.waitForElement(filterIndustrySector);

		common.findElementBy(manufacturerPartNumFilterTab, "Click on Manufacturer Part Number filter tab").click();

		common.waitForElement(inputManufacturerPartNumFilter);

		System.out.println("Enter special characters");
		common.log("Enter special characters");
		common.type(inputManufacturerPartNumFilter, "#$%");

		common.findElementBy(inputManufacturerPartNumFilter, "").sendKeys(Keys.ENTER);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(15);

		String strFirstValue2 = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue2);
		common.log("First value of Material master table:: " + strFirstValue2);
	}

}
