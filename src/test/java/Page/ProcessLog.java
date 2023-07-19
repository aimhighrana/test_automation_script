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
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

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

			common.pause(10);
			String status = driver.findElement(By.xpath(statusCom)).getText();
			System.out.println("Step :: Process Log Status is ::" + status);
			common.log("Process Log Status is ::" + status);
			assertEquals(status, "COMPLETED");

			System.out.println("Step :: click on view email logs");
			common.log("Click on view email logs");

			driver.findElement(By.xpath(viewEmailLogs)).click();
			common.waitForElement(viewDetailsHeader);

			List<WebElement> eleColumns = driver.findElements(By.xpath("(//tr[@role='row'])[1]//th"));
			common.log("Columns in email logs page :: >>");
			for (WebElement e : eleColumns) {
				System.out.println(e.getText());
				common.log(e.getText());
			}

			//If record available then it will print
			if (common.isElementDisplayed("//div[@class='message-list f-col']//tr[1]//td[1]")) {
				List<WebElement> emailRecords = driver.findElements(By.xpath(firstRecordOfEmailLogs));

				for (WebElement e : emailRecords) {
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
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

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
		common.findElement(dataTab).click();

		test.log(LogStatus.INFO, "Step :: click on material master number from left nav");
		System.out.println("Step :: click on Material master from left nav");
		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

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
		common.findElement(dataTab).click();

		common.log("Click on Material master from left nav");

		common.waitForElement(search);
		test.log(LogStatus.INFO, "Step :: search for material master ");
		common.type(search, "Material Master");
		common.waitForElement(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

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

		String strFirstValue = driver.findElement(By.xpath(firstValueMaterialMaster)).getText();

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
		for (int i=1;i<=3;i++)
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
	/**
	 * verify Classification Data Changes Maintained In The Process_Log
	 *
	 */
	public void verify_Classification_Data_Changes_Maintained_In_The_Process_Log() {

		common.waitForElement(dataTab);
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
		common.pause(10);

		if(common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.waitForElement(unitOfWeightField);
			common.findElementBy(unitOfWeightField,"Click on Unit Of Weight field").click();
			common.waitForElement(dropValue1);
			common.findElementBy(dropValue1,"Select first option").click();

		}
		else {

			System.out.println("Step :: Click on material master record role");
			common.log("Click on material master workflow role");
			driver.findElement(By.xpath(materrialMasterRecordOption)).click();
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

			common.findElementBy(plusStorageData, "Click on plus icon for Storage Data hierarchy");

			common.findElementBy(firstOptionStorageData, "Select first option for Storage Data hierarchy");

			common.findElementBy(applyFilterButton, "Click on apply button");
			common.pause(5);
		}
		System.out.println("Step :: Click on save button");
		common.log("Click on save button");
		common.waitForElement(uSaveBtn);
		driver.findElement(By.xpath(uSaveBtn)).click();
		common.pause(20);

		//if duplicate record appear then click on continue and something went occurred then refresh page and submit again
		if (common.isDisplayed(duplicateRecordHeader) == true) {

			System.out.println("Step :: Duplicate records");
			driver.findElement(By.xpath(continueDuplicateRecord)).click();
		} else {

			System.out.println("Step :: No duplicate records");
		}
		if(common.isDisplayed("//div[@class='mdo-notice f-row mdo-notice-error']")==true)
		{

			System.out.println("Step :: Something went error appear");
			common.refreshPage();
			common.pause(10);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			test.log(LogStatus.INFO, "Step :: Click on save button");
			System.out.println("Step :: Click on save button");
			common.log("Click on save button");
			driver.findElement(By.xpath(uSaveBtn)).click();
			common.pause(40);
		}
		else {

			System.out.println("Step :: No Something went error");
		}
		common.waitForElement(actionIconForFirstValue);
		driver.findElement(By.xpath(actionIconForFirstValue)).click();

		test.log(LogStatus.INFO, "Step :: Click on view process log");
		System.out.println("Step :: Click on viewProcess log");
		common.log("Click on view Process log");
		common.waitForElement(viewProcessLogOption);
		driver.findElement(By.xpath(viewProcessLogOption)).click();
		common.pause(5);

		common.waitForElement(processLogStatus);
		String viewProcessLog = driver.findElement(By.xpath(processLogStatus)).getText();
		System.out.println("Step :: View Process log =>>" + viewProcessLog);
		common.log("View Process log =>>" + viewProcessLog);
		driver.findElement(By.xpath(processLogTitle)).click();
		common.pause(10);

		common.waitForElement(statusCom);
		String status = driver.findElement(By.xpath(statusCom)).getText();
		System.out.println("Step :: Process Log Status is ::" + status);
		common.log("Process Log Status is ::" + status);
		assertEquals(status, "COMPLETED");
		common.pause(10);
		System.out.println("Step :: click on view change ");
		common.log("Click on view change");
		common.findElement(completedViewProcessLog).click();
		common.pause(10);

		common.waitForElement(headerData);
		Boolean header = driver.findElement(By.xpath(headerData)).isDisplayed();
		test.log(LogStatus.INFO, "Step :: -- Header title is displaying ");
		System.out.println("Step :: Header Title is displaying:: >>" + header);
		common.log("Title is Header data :: >>" + header);

		common.waitForElement(fieldNameHeader);
		common.findElementBy(fieldNameHeader,"Field Name header is available");
		common.findElementBy(beforeChangeHeader,"Before Change header is available");
		common.findElementBy(afterChangeHeader,"After Change header is available");
		String str1[] = {"Field name","Before change","After change"};

		//this loop will fetch one by one data from field name, before change, after change
		for (int i =0; i<str1.length;i++)
		{
			int j = i+1;
			if (common.isElementDisplayed("//div[3]/table[1]/tbody[1]/tr[1]/td[1]"))
			{
				String str = driver.findElement(By.xpath("//div[3]/table[1]/tbody[1]/tr[1]/td["+j+"]")).getText();
				common.log(str1[i]+":"+str);
			}
		}

		common.findElementBy(closeIcoForViewChange,"Click on close icon for view change").click();
		common.waitForElement(closeIconForProcessLog);
		common.findElementBy(instanceDiagramIcon,"Click on Instance Diagram icon").click();
		common.waitForElement(processFlowHeader);
		common.findElementBy(instanceDiagramImage,"Instance diagram verified");
		common.pause(5);
		common.findElementBy(closeIconProcessFlow,"Close Process flow page").click();
		common.waitForElement(closeIconForProcessLog);
		common.findElementBy(viewPotentialOwner,"Click on View link text in Potential Owner column").click();
		common.pause(10);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@role='menu']//div//div[@role='menuitem']"));
		common.log("List of potential owner displaying :: >>" );
		for (WebElement e  : ele)
		{
			common.log(e.getText());
		}

	}

}
