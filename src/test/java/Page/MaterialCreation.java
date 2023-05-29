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
		common.findElementBy(applyBtn,"Click on Apply button").click();
		common.pause(5);

		common.findElementBy(valuationDataAddHierarchy,"Click on Valuation Data - add... button").click();
		common.waitForElement(searchBoxHierarchy);
		common.findElementBy(searchBoxHierarchy,"Search value: N.A -- Not Applicable").sendKeys("N.A");
		common.waitForElement(selectSearchedOption);
		common.findElementBy(selectSearchedOption,"Select searched option").click();
		common.findElementBy(applyBtn,"Click on Apply button").click();
		common.pause(5);

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
		common.waitForElement(dataTab);

	}

}
