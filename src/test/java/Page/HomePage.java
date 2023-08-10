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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Locators {

	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;
	public HomePage(WebDriver driver) throws Exception {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();
	}

	/**
	 * To verify that in INBOX folder, record Id , other data & functionality should be working fine
	 *
	 */
	public void verify_That_In_INBOX_Folder_RecordId_Other_Data_And_Functionality_Should_Be_Working_Fine() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		common.waitUntilElementToBeVisible(inboxMenu);
		common.findElementBy(inboxMenu, "Verify Inbox menu");
		common.findElementBy(inProgressMenu, "Verify In Progress menu");
		common.findElementBy(completedMenu, "Verify Completed menu");
		common.findElementBy(myReqTab, "Verify My Request menu");

		common.findElementBy(inboxMenu, "Click on Inbox menu").click();

		common.pause(10);
		for (int i = 1; i <= 5; i++) {
			WebElement verifyRecords = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]//p"));
			if (common.isElementDisplayed(verifyRecords)) {
				String recordNumber = common.findElement(verifyRecords).getText();
				common.log(i + " Record number in Inbox menu: " + recordNumber);
			} else {
				break;
			}
		}
	}

	/**
	 * To Verify that different options will be present under action button
	 *
	 */
	public void verify_That_Different_Options_Will_Be_Present_Under_Action_Button() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		common.waitUntilElementToBeVisible(inboxMenu);
		common.findElementBy(inboxMenu, "Click on Inbox menu").click();
		common.waitUntilElementToBeVisible(firstActionIconForInbox);

		WebElement firstRecord = driver.findElement(By.xpath("//tbody/tr[1]/td[3]//p"));
		String recordNumber =  common.findElement(firstRecord).getText();
		common.log("1st Record number in Inbox menu: " + recordNumber);

		common.findElementBy(firstActionIconForInbox, "Click on action icon for first record").click();

		common.findElementBy(approveBtn, "Approve option available");
		common.findElementBy(processLogOption, "Process Log option available");
		common.findElementBy(claim, "Claim option available");

	}
	/**
	 * Verify column details displayed in task folders
	 *
	 */
	public void verify_Column_Details_Displayed_In_Task_Folders() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitUntilElementToBeVisible(systemErrorsTab);

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.pause(5);
		if (common.isElementDisplayed(firstActionIconForInbox)) {
			common.waitUntilElementToBeVisible(firstActionIconForInbox);

			for (int i = 1; i <= 5; i++) {
				WebElement firstRow = driver.findElement(By.xpath("//tbody/tr[" + i + "]"));
				common.waitUntilElementToBeVisible(firstRow);
				String recordWithReason = common.findElement(firstRow).getText();
				common.log(i + " Record with reason: " + recordWithReason);
			}
		}

	}

	/**
	 * Verify failed records column for cross dataset, integration, daxe, process log tasks
	 *
	 */
	public void verify_Failed_Records_Column_For_Cross_Dataset_Integration_Daxe_Process_Log_Tasks() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitUntilElementToBeVisible(systemErrorsTab);

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.pause(5);
		common.waitUntilElementToBeVisible(searchSystemErrorsTab);

		common.waitUntilElementToBeVisible(firstRecordFromList);
		String integrationRecordWithReason = common.findElement(firstRecordFromList).getText();
		common.log("Integration first record with reason: " + integrationRecordWithReason);

		common.log("Search record for 'DAXE'");
		common.findElement(searchSystemErrorsTab).click();
		common.type(searchSystemErrorsTab,"daxe");
		common.pause(10);

		if (common.isElementDisplayed(firstRecordFromList)) {
			String daxeRecordWithReason = common.findElement(firstRecordFromList).getText();
			common.log("DAXE first record with reason: " + daxeRecordWithReason);
			common.pause(5);
		}

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.findElementBy(clearSearchSystemErrorsTab, "Clear searched value").click();

		common.log("Search record for 'Cross dataset'");
		common.findElement(searchSystemErrorsTab).clear();
		common.type(searchSystemErrorsTab, "Cross dataset");
		common.pause(10);

		if (common.isElementDisplayed(firstRecordFromList)) {
			String crossDatasetRecordWithReason = common.findElement(firstRecordFromList).getText();
			common.log("Cross dataset first record with reason: " + crossDatasetRecordWithReason);
		}

	}

	/**
	 * Verify that once the record is successful re-trigger for integration record should not reflecting in In-error folder
	 *
	 */
	public void verify_That_Once_The_Record_Is_Successful_ReTrigger_For_Integration_Record_Should_Not_Reflecting_In_Error_Folder() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		common.waitUntilElementToBeVisible(systemErrorsTab);
		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.pause(5);
		common.waitUntilElementToBeVisible(retriggerIcon);

		common.findElementBy(retriggerIcon, "Click on re-Trigger icon for integration record").click();
		common.pause(10);

		if (common.isElementDisplayed(successRetrigger)) {
			String successMessage = common.findElement(successRetrigger).getText();
			common.log("Success message: " + successMessage);
		}
		else {
			common.log("Unable to re-trigger process");
		}
	}

	/**
	 * Verify that all the filters type are working in In-error folder
	 *
	 */
	public void verify_That_All_The_Filters_Type_Are_Working_In_Error_Folder() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		common.waitUntilElementToBeVisible(systemErrorsTab);
		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.pause(5);
		common.waitUntilElementToBeVisible(searchSystemErrorsTab);

		common.findElementBy(flowFilter, "Click on Flow filter").click();

		String firstOption = common.findElement(firstOptionFilter).getText();
		common.log("First option in flow filter: " + firstOption);

		common.findElementBy(firstOptionFilter,"Select first option").click();

		common.pause(5);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();

		if (common.isElementDisplayed(firstRecordFromList)) {
			String firstRecord = common.findElement(firstRecordFromList).getText();
			common.log("First record after apply flow filter: " + firstRecord);
		}

		common.findElementBy(taskFilter, "Click on Task type filter").click();
		String firstOption1 = common.findElement(firstOptionFilter).getText();
		common.log("First option in task type filter: " + firstOption1);

		common.findElementBy(firstOptionFilter,"Select first option").click();
		common.pause(5);

		action.sendKeys(Keys.ESCAPE).perform();

		if (common.isElementDisplayed(firstRecordFromList)) {
			String firstRecord = common.findElement(firstRecordFromList).getText();
			common.log("First record after apply task type filter: " + firstRecord);
		}
		else {
			common.log("Nothing to see here!");
		}

	}
	/**
	 * To verify that in In progress folder, record Id, other data & functionality should be working fine
	 *
	 */
	public void verify_That_In_In_progress_Folder_Record_Id_Other_Data_And_Functionality_Should_Be_Working_Fine() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		common.waitUntilElementToBeVisible(inProgressMenu);
		common.findElementBy(inProgressMenu, "Click on In Progress menu").click();
		common.pause(5);
		common.findElement(myReqTab).click();
		common.findElement(inProgressMenu).click();

		common.waitUntilElementToBeVisible(firstActionIconForInbox);
		for (int i = 1; i <= 2; i++) {
			WebElement recordsInProgress = driver.findElement(By.xpath("//tbody/tr[" + i + "]"));
			if (common.isElementDisplayed(recordsInProgress)) {
				String firstRecord = common.findElement(recordsInProgress).getText();
				common.log(i + " record of In progress table: " + firstRecord);
			} else {
				common.log("Nothing to see here!");
			}
		}
		common.findElementBy(firstActionIconForInbox, "Click on action menu for first record").click();
		common.pause(5);
		common.findElementBy(viewProcessLogOption, "View process log option is available");

	}
	/**
	 * To verify that in Completed folder, record Id, other data & functionality should be working fine.
	 *
	 */
	public void verify_That_In_Completed_Folder_Record_Id_Other_Data_Functionality_Should_Be_Working_Fine() {

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitUntilElementToBeVisible(inProgressMenu);

		common.findElementBy(completedMenu, "Click on Completed menu").click();
		common.pause(10);

		if (common.isElementDisplayed(firstRecordFromList)) {
			String firstRecord = common.findElement(firstRecordFromList).getText();
			common.log(" record of Completed table: " + firstRecord);
		}
		else {
			common.log("Nothing to see here!");
		}

		if (common.isElementDisplayed(firstRecordFromList)) {
			String firstRecord = common.findElement(firstRecordFromList).getText();
			common.log("!st record of Completed table: " + firstRecord);

			common.waitUntilElementToBeVisible(firstActionIconForInbox);
			common.findElementBy(firstActionIconForInbox, "Click on action menu for first record").click();

			common.findElementBy(viewProcessLogOption, "View process log option is available");
		} else {
			common.log("Nothing to see here!");
		}
	}

}
