package Page;

import Utils.Common;
import Utils.Locators;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class ProcessLog extends Locators {

	Common common = new Common(driver);
	Properties obj = new Properties();

	public ProcessLog(WebDriver driver) throws FileNotFoundException {

		super(driver);

	}

	/**
	 * Process log: verify That User Is Able To View Email Logs When Email Notification Is Configured
	 * 
	 */
	public void verify_That_User_Is_Able_To_View_Email_Logs_In_Process_Log() {

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		common.pause(5);
		common.findElementBy(dataTab,"Click on Data tab").click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(15);

		//If default view not appear then select it from View dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.findElementBy(actionIconForFirstValue,"Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(viewPLog,"Select view process log option").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {
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

			System.out.println("Step :: click on view email logs");
			common.log("Click on view email logs");

			driver.findElement(By.xpath(viewEmailLogs)).click();
			common.waitForElement(viewDetailsHeader);

			//If record available then it will print
			if (common.isElementDisplayed("//div[@class='message-list f-col']//tr[1]//td[1]")) {
				List<WebElement> ele = driver.findElements(By.xpath(firstRecordOfEmailLogs));

				for (WebElement e : ele) {
					System.out.println("Step :: First record is displaying:: >>" + e.getText());
					common.log("First record is displaying :: >>" + e.getText());
				}
			}

			common.pause(5);

			System.out.println("Step :: Close View email logs page ");
			common.log("Close View email logs page ");
			common.findElement(crossIconViewEmailLogs).click();

			System.out.println("Step :: Close process log page ");
			common.log("Close View process log page ");
			common.waitForElement(closeIconForProcessLog);
			common.findElement(closeIconForProcessLog).click();
		}
		else {
			String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
			System.out.println("Step :: View process log: "+strProcessLog);
			common.log("View process log: "+strProcessLog);
		}
	}
	/**
	 * Process log: verify Tooltip Is Visible For Comment Icon In Side Sheet
	 *
	 */
	public void verify_Tooltip_Is_Visible_For_Comment_Icon_In_Side_Sheet() {

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.refreshPage();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(15);

		//If default view not appear then select it from View dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(viewPLog, "Select view process log option").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {
			common.waitForElement(processLogTitle);
			String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
			System.out.println("Step :: Process Log Title is ::" + pLog);
			common.log("Process Log Title is ::" + pLog);

			String strComment = driver.findElement(By.xpath(commentIconProcessLog)).getAttribute("libtooltip");
			System.out.println("Step :: Comment tooltip ::" + strComment);
			common.log("Comment tooltip ::" + strComment);

			common.findElementBy(commentIconProcessLog,"Click on comment icon").click();

			common.waitForElement(chatBoxComment);
			common.findElementBy(chatBoxComment,"Verified chat box");
		}
		else {
			String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
			System.out.println("Step :: View process log: "+strProcessLog);
			common.log("View process log: "+strProcessLog);
		}
	}
	/**
	 * Process log: verify Tooltip Is Visible For External Icon In Sidesheet
	 *
	 */
	public void verify_Tooltip_Is_Visible_For_External_Icon_In_Sidesheet() {

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.refreshPage();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(15);

		//If default view not appear then select it from View dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.pause(10);
		common.findElementBy(viewPLog, "Select view process log option").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {
			common.waitForElement(processLogTitle);
			String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
			System.out.println("Step :: Process Log Title is ::" + pLog);
			common.log("Process Log Title is ::" + pLog);

			String strExternalICon = driver.findElement(By.xpath(externalIcon)).getAttribute("libtooltip");
			System.out.println("Step :: External Icon tooltip ::" + strExternalICon);
			common.log("External Icon tooltip ::" + strExternalICon);

			common.findElementBy(externalIcon,"Click on External icon").click();

		}
		else {
			String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
			System.out.println("Step :: View process log: "+strProcessLog);
			common.log("View process log: "+strProcessLog);
		}
	}
	/**
	 * Process log: verify User Is Able To View The View Integration Log
	 *
	 */
	public void verify_User_Is_Able_To_View_The_View_Integration_Log() {

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();
		common.refreshPage();

		common.pause(5);
		common.findElementBy(dataTab, "Click on Data tab").click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(15);

		//If default view not appear then select it from View dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitForElement(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitForElement(sapMaterialNumberFilter);
		common.log("Click on SAP Material Number tab");
		common.jsClick(sapMaterialNumberFilter);

		common.pause(10);
		common.findElement(sapMaterialNumberInputField).click();
		common.findElementBy(sapMaterialNumberInputField, "Enter value in textarea : 000").sendKeys("000");
		common.findElement(sapMaterialNumberInputField).sendKeys(Keys.ENTER);
		common.pause(5);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = driver.findElement(By.xpath(firstValuematerialMaster)).getText();

		System.out.println("First value of Material master table:: " + strFirstValue);
		common.log("First value of Material master table:: " + strFirstValue);

		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.waitForElement(viewPLog);
		common.findElementBy(viewPLog, "Select view process log option").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {
			common.waitForElement(processLogTitle);
			String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
			System.out.println("Step :: Process Log Title is ::" + pLog);
			common.log("Process Log Title is ::" + pLog);
			common.findElementBy(processLogTitle,"Expand Process log").click();

		}
		else {
			String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
			System.out.println("Step :: View process log: "+strProcessLog);
			common.log("View process log: "+strProcessLog);
		}

		//this loop will find which record has View integration logs under Process log
		for (int i=1;i<=10;i++)
		{
			if (common.isElementDisplayed(viewIntegrationLogs))
			{
				common.findElementBy(viewIntegrationLogs,"Click on View Integration Logs").click();
				common.waitForElement(integrationLogsHeader);
				common.findElementBy(integrationLogsHeader,"Integration Logs header verified");
				common.pause(5);
				common.findElementBy(closeIntegrationLogsView,"Close Integration logs view").click();
				common.pause(5);
				common.findElementBy(closeIconForProcessLog,"Close Process log view").click();
				break;
			}
			else
			{
				common.findElementBy(closeIconForProcessLog,"Close Process log view").click();
				common.findElementBy("//tbody/tr[1]/td["+i+"]//..//button//span//mat-icon","Click on action icon for next record").click();

				common.waitForElement(viewPLog);
				common.findElementBy(viewPLog, "Select view process log option").click();
				common.pause(10);

				if (common.isElementDisplayed(processLogTitle)) {
					common.waitForElement(processLogTitle);
					String pLog = driver.findElement(By.xpath(processLogTitle)).getText();
					System.out.println("Step :: Process Log Title is ::" + pLog);
					common.log("Process Log Title is ::" + pLog);
					common.findElementBy(processLogTitle,"Expand Process log").click();

				}
				else {
					String strProcessLog = common.findElementBy("//div[@class='mdo-notice f-row mdo-notice-info']","Getting logs from view process log").getText();
					System.out.println("Step :: View process log: "+strProcessLog);
					common.log("View process log: "+strProcessLog);
				}
			}
		}

	}

}
