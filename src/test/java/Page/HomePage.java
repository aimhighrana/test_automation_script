package Page;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

public class HomePage extends Locators {

	Common common = new Common(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(15));
	public HomePage(WebDriver driver) throws FileNotFoundException {

		super(driver);

	}

	/**
	 * To verify that in INBOX folder, record Id , other data & functionality should be working fine
	 * 
	 */
	public void verify_That_In_INBOX_Folder_RecordId_Other_Data_And_Functionality_Should_Be_Working_Fine() {

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(inboxMenu);

		common.findElementBy(inboxMenu, "Verify Inbox menu");
		common.findElementBy(inProgressMenu, "Verify In Progress menu");
		common.findElementBy(completedMenu, "Verify Completed menu");
		common.findElementBy(myReqTab, "Verify My Request menu");

		common.findElementBy(inboxMenu, "Click on Inbox menu").click();

		for (int i= 1; i<=5;i++)
		{
			common.waitForElement("//tbody/tr["+i+"]/td[3]//p");
			String recordNumber =  driver.findElement(By.xpath("//tbody/tr["+i+"]/td[3]//p")).getText();
			System.out.println(i+" Record number in Inbox menu:: " + recordNumber);
			common.log(i+" Record number in Inbox menu:: " + recordNumber);
		}
	}

	/**
	 * To Verify that different options will be present under action button
	 *
	 */
	public void verify_That_Different_Options_Will_Be_Present_Under_Action_Button() {

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(inboxMenu);

		common.findElementBy(inboxMenu, "Click on Inbox menu").click();
		common.waitForElement(firstActionIconForInbox);

		String recordNumber =  driver.findElement(By.xpath("//tbody/tr[1]/td[3]//p")).getText();
		System.out.println("1st Record number in Inbox menu:: " + recordNumber);
		common.log("1st Record number in Inbox menu:: " + recordNumber);

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

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(systemErrorsTab);

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.waitForElement(firstActionIconForInbox);

		for (int i= 1; i<=5;i++)
		{
			common.waitForElement("//tbody/tr["+i+"]");
			String recordWithReason =  driver.findElement(By.xpath("//tbody/tr["+i+"]")).getText();
			System.out.println(i+" Record with reason:: " + recordWithReason);
			common.log(i+" Record with reason:: " + recordWithReason);
		}

	}

	/**
	 * Verify failed records column for cross dataset, integration, daxe, process log tasks
	 *
	 */
	public void verify_Failed_Records_Column_For_Cross_Dataset_Integration_Daxe_Process_Log_Tasks() {

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(systemErrorsTab);

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.waitForElement(searchSystemErrorsTab);

		String integrationRecordWithReason = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
		System.out.println("Integration first record with reason:: " + integrationRecordWithReason);
		common.log("Integration first record with reason:: " + integrationRecordWithReason);

		common.log("Search record for 'DAXE'");
		common.type(searchSystemErrorsTab,"daxe");
		common.pause(10);

		if (common.isElementPresent("//tbody/tr[1]")) {
			String daxeRecordWithReason = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
			System.out.println("DAXE first record with reason:: " + daxeRecordWithReason);
			common.log("DAXE first record with reason:: " + daxeRecordWithReason);
			common.pause(5);
		}

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.findElementBy(clearSearchSystemErrorsTab, "Clear searched value").click();

		common.log("Search record for 'Cross dataset'");
		common.findElement(searchSystemErrorsTab).clear();
		common.type(searchSystemErrorsTab, "Cross dataset");
		common.pause(10);

		if (common.isElementPresent("//tbody/tr[1]")) {
			String crossDatasetRecordWithReason = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
			System.out.println("Cross dataset first record with reason:: " + crossDatasetRecordWithReason);
			common.log("Cross dataset first record with reason:: " + crossDatasetRecordWithReason);
		}

	}

	/**
	 * Verify that once the record is successful re-trigger for integration record should not reflecting in In-error folder
	 *
	 */
	public void verify_That_Once_The_Record_Is_Successful_ReTrigger_For_Integration_Record_Should_Not_Reflecting_In_Error_Folder() {

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(systemErrorsTab);

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.waitForElement(searchSystemErrorsTab);

		common.findElementBy(retriggerIcon, "Click on re-Trigger icon for integration record").click();
		common.pause(10);

		if (common.isElementPresent(successRetrigger)) {
			String successMessage = driver.findElement(By.xpath(successRetrigger)).getText();
			System.out.println("Success message:: " + successMessage);
			common.log("Success message:: " + successMessage);
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

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(systemErrorsTab);

		common.findElementBy(systemErrorsTab, "Click on System Errors menu").click();
		common.waitForElement(searchSystemErrorsTab);

		common.findElementBy(flowFilter, "Click on Flow filter").click();

		String firstOption = driver.findElement(By.xpath(firstOptionFilter)).getText();
		System.out.println("First option in flow filter:: " + firstOption);
		common.log("First option in flow filter:: " + firstOption);

		common.findElementBy(firstOptionFilter,"Select first option").click();

		common.pause(5);

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();

		if (common.isElementPresent("//tbody/tr[1]")) {
			String firstRecord = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
			System.out.println("First record after apply flow filter:: " + firstRecord);
			common.log("First record after apply flow filter:: " + firstRecord);
		}

		common.findElementBy(taskFilter, "Click on Task type filter").click();
		String firstOption1 = driver.findElement(By.xpath(firstOptionFilter)).getText();
		System.out.println("First option in Task type filter:: " + firstOption1);
		common.log("First option in task type filter:: " + firstOption1);

		common.findElementBy(firstOptionFilter,"Select first option").click();
		common.pause(5);

		action.sendKeys(Keys.ESCAPE).perform();

		if (common.isElementPresent("//tbody/tr[1]")) {
			String firstRecord = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
			System.out.println("First record after apply task type filter:: " + firstRecord);
			common.log("First record after apply task type filter:: " + firstRecord);
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

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(inProgressMenu);

		common.findElementBy(inProgressMenu, "Click on In Progress menu").click();
		common.waitForElement(searchSystemErrorsTab);

		for (int i = 1; i <= 2; i++) {
			if (common.isElementPresent("//tbody/tr[" + i + "]")) {
				String firstRecord = driver.findElement(By.xpath("//tbody/tr[" + i + "]")).getText();
				System.out.println(i + " record of In progress table:: " + firstRecord);
				common.log(i + " record of In progress table:: " + firstRecord);
			} else {
				common.log("Nothing to see here!");
			}
		}
			common.findElementBy(firstActionIconForInbox, "Click on action menu for first record").click();

			common.findElementBy(viewProcessLogOption, "View process log option is available");

	}
	/**
	 * To verify that in Completed folder, record Id, other data & functionality should be working fine.
	 *
	 */
	public void verify_That_In_Completed_Folder_Record_Id_Other_Data_Functionality_Should_Be_Working_Fine() {

		common.pause(5);
		common.findElementBy(homeTab, "Click on Home tab").click();
		common.waitForElement(inProgressMenu);

		common.findElementBy(completedMenu, "Click on Completed menu").click();
		common.pause(20);

			if (common.isElementPresent("//tbody/tr[1]")) {
				String firstRecord = driver.findElement(By.xpath("//tbody/tr[1]")).getText();
				System.out.println(" record of Completed table:: " + firstRecord);
				common.log(" record of Completed table:: " + firstRecord);
			}
			else {
				common.log("Nothing to see here!");
			}

		for (int i = 1; i <= 2; i++) {
			if (common.isElementPresent("//tbody/tr[" + i + "]")) {
				String firstRecord = driver.findElement(By.xpath("//tbody/tr[" + i + "]")).getText();
				System.out.println(i + " record of Completed table:: " + firstRecord);
				common.log(i + " record of Completed table:: " + firstRecord);

				common.findElementBy(firstActionIconForInbox, "Click on action menu for first record").click();

				common.findElementBy(viewProcessLogOption, "View process log option is available");
			} else {
				common.log("Nothing to see here!");
			}
		}


	}


}
