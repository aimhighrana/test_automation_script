package Page;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import ServiceHelper.AuthenticationService;
import ServiceHelper.EnvironmentService;
import Utils.Common;
import Utils.Locators;
import contracts.IAuthenticationService;
import contracts.IEnvironmentService;

public class Workflow11 extends Locators {
	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	public Workflow11(WebDriver driver) throws Exception {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();
	}

	public void verify_creation_process_with_System_table_changes() throws IOException {
		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "MRP Controller Auto Extension");
		common.pause(5);
		common.waitUntilElementToBeVisible(autoExtensionDataset);
		common.findElementBy(autoExtensionDataset, "Click on MRP Controller Auto Extension").click();
		common.pause(10);

		// if Default view not appear them click on view dropdown icon and
		// select Default view
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
		common.waitUntilElementToBeVisible(formList);
		common.findElementBy(mrpForm, "Click on MRP Controller option").click();

		common.waitUntilElementToBeVisible(autChange);
		// get data from Sheet1
		ArrayList<String> sheet = common.getColumnData("Sequential QA (decision + paral", "Aut change");

		common.log("Type Aut change");
		common.findElement(autChange).click();
		common.log("Get Aut change from Excel: " +sheet.get(0));
		common.type(autChange, sheet.get(0));
		common.pause(5);

		common.pause(5);
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(10);

		// Wait and get success message fore record creation
		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display:  " + successStr);

		common.waitUntilElementToBeVisible(dataTab);
		common.log("Verifying Data tab available");

		common.log("Refreshing page for visible latest created record");
		common.refreshPage();
		common.pause(10);

		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(summaryOption, "Select summary option").click();
		common.pause(5);
		common.findElementBy(mrpForm, "Select form").click();
		common.pause(15);

		common.log("Aut change value "+common.findElement(autChange).getText().toString());
		String autChangeValue = common.findElement(autChange).getText().toString();
		//assertEquals(autChangeValue,sheet.get(0));
		assertEquals(autChangeValue, sheet.get(0));
		common.pause(10);

	}

	public void verify_change_process_with_System_table_changes() throws IOException {
		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.pause(5);
		common.findElement(dataTab).click();
		common.waitUntilElementToBeVisible(search);
		common.type(search, "MRP Controller Auto Extension");
		common.pause(5);
		common.waitUntilElementToBeVisible(autoExtensionDataset);
		common.findElementBy(autoExtensionDataset, "Click on MRP Controller Auto Extension").click();
		common.pause(10);
		ArrayList<String> sheet = common.getColumnData("Sequential QA (decision + paral", "Aut change");

		// if Default view not appear them click on view dropdown icon and
		// select Default view
		if (!common.isElementDisplayed(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(edit, "Select Edit option").click();
		common.pause(5);
		common.findElementBy(mrpForm, "Select form").click();
		common.pause(5);
		
		

		common.log("Select Aut change");
		common.findElement(autChange).click();
		
		common.type(autChange, sheet.get(0));
		common.pause(5);

		common.pause(5);
		common.log("click on submit button");
		common.findElement(submitBtn).click();
		common.pause(10);

		// Wait and get success message fore record creation
		common.waitUntilElementToBeVisible(successMessageToast);
		String successStr = common.findElement(successMessageToast).getText();
		common.log("Message display:  " + successStr);

		common.waitUntilElementToBeVisible(dataTab);
		common.log("Verifying Data tab available");

		common.log("Refreshing page for visible latest created record");
		common.refreshPage();
		common.pause(10);
		
		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(summaryOption, "Select summary option").click();
		common.pause(5);
		common.findElementBy(mrpForm, "Select form").click();
		common.pause(15);

		common.log("Aut change value "+common.findElement(autChange).getText().toString());
		String autChangeValue = common.findElement(autChange).getText().toString();
		//assertEquals(autChangeValue,sheet.get(0));
		assertEquals(autChangeValue, sheet.get(0));
		common.pause(10);

	

	}

}
