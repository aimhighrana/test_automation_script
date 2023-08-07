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
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class ProcessLog extends Locators {

	Common common;
	Properties obj = new Properties();
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	public ProcessLog(WebDriver driver) throws FileNotFoundException {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();

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

		common.log("Click on Material master from left nav");

		common.waitUntilElementToBeVisible(search);
		common.log( "search for material master");
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
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
			common.waitUntilElementToBeVisible(processLogTitle);
			String pLog = common.findElement(processLogTitle).getText();
			common.log("Process Log Title is : " + pLog);

			common.findElement(processLogTitle).click();

			common.pause(10);
			String status = common.findElement(statusCom).getText();
			common.log("Process Log Status is : " + status);
			assertEquals(status, "COMPLETED");

			common.log("Click on view email logs");

			common.findElement(viewEmailLogs).click();
			common.waitUntilElementToBeVisible(viewDetailsHeader);

			List<WebElement> eleColumns = driver.findElements(By.xpath("(//tr[@role='row'])[1]//th"));
			common.log("Columns in email logs page : >>");
			for (WebElement e : eleColumns) {
				common.log(e.getText());
				common.log(e.getText());
			}

			//If record available then it will print
			if (common.isElementDisplayed((WebElement) By.xpath("//div[@class='message-list f-col']//tr[1]//td[1]"))) {
				List<WebElement> emailRecords = driver.findElements(By.xpath(String.valueOf(firstRecordOfEmailLogs)));

				for (WebElement e : emailRecords) {
					common.log("First record is displaying : >>" + e.getText());
				}
			}

			common.pause(5);
			common.log("Close View email logs page ");
			common.jsClick(crossIconViewEmailLogs);

			common.log("Close View process log page ");
			common.waitUntilElementToBeVisible(closeIconForProcessLog);
			common.jsClick(closeIconForProcessLog);
		}
		else {
			String strProcessLog = common.findElementBy((WebElement) By.xpath("//div[@class='mdo-notice f-row mdo-notice-info']"),"Getting logs from view process log").getText();
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

		common.log("Click on Material master from left nav");

		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
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
			common.waitUntilElementToBeVisible(processLogTitle);
			String pLog = common.findElement(processLogTitle).getText();
			common.log("Process Log Title is :" + pLog);

			String strComment = common.findElement(commentIconProcessLog).getAttribute("libtooltip");
			common.log("Comment tooltip :" + strComment);

			common.findElementBy(commentIconProcessLog,"Click on comment icon").click();

			common.waitUntilElementToBeVisible(chatBoxComment);
			common.findElementBy(chatBoxComment,"Verified chat box");
		}
		else {
			String strProcessLog = common.findElementBy((WebElement) By.xpath("//div[@class='mdo-notice f-row mdo-notice-info']"),"Getting logs from view process log").getText();
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
		common.log("Click on Material master from left nav");

		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
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
			common.waitUntilElementToBeVisible(processLogTitle);
			String pLog = common.findElement(processLogTitle).getText();
			common.log("Process Log Title is : " + pLog);

			String strExternalICon = common.findElement(externalIcon).getAttribute("libtooltip");
			common.log("External Icon tooltip : " + strExternalICon);

			common.findElementBy(externalIcon,"Click on External icon").click();

		}
		else {
			String strProcessLog = common.findElementBy((WebElement) By.xpath("//div[@class='mdo-notice f-row mdo-notice-info']"),"Getting logs from view process log").getText();
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

		common.waitUntilElementToBeVisible(search);
		common.type(search, "Material Master");
		common.waitUntilElementToBeVisible(materialMaster);
		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from View dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}
		common.waitUntilElementToBeVisible(filterIcon);

		common.findElementBy(filterIcon, "Click on Filter icon").click();
		common.pause(10);
		common.waitUntilElementToBeVisible(sapMaterialNumberFilter);
		common.log("Click on SAP Material Number tab");
		common.jsClick(sapMaterialNumberFilter);

		common.pause(10);
		common.findElement(sapMaterialNumberInputField).click();
		common.findElementBy(sapMaterialNumberInputField, "Enter value in textarea : 000").sendKeys("000");
		common.findElement(sapMaterialNumberInputField).sendKeys(Keys.ENTER);
		common.pause(5);

		common.findElementBy(applyFilterButton, "Click on apply button").click();
		common.pause(10);

		String strFirstValue = common.findElement(firstValueMaterialMaster).getText();

		common.log("First value of Material master table: " + strFirstValue);

		common.findElementBy(actionIconForFirstValue, "Click on first value action icon").click();
		common.waitUntilElementToBeVisible(viewPLog);
		common.findElementBy(viewPLog, "Select view process log option").click();
		common.pause(10);

		if (common.isElementDisplayed(processLogTitle)) {
			common.waitUntilElementToBeVisible(processLogTitle);
			String pLog = common.findElement(processLogTitle).getText();
			common.log("Process Log Title is : " + pLog);
			common.findElementBy(processLogTitle,"Expand Process log").click();

		}
		else {
			String strProcessLog = common.findElementBy((WebElement) By.xpath("//div[@class='mdo-notice f-row mdo-notice-info']"),"Getting logs from view process log").getText();
			common.log("View process log: "+strProcessLog);
		}

		//this loop will find which record has View integration logs under Process log
		for (int i=1;i<=3;i++)
		{
			if (common.isElementDisplayed(viewIntegrationLogs))
			{
				common.findElementBy(viewIntegrationLogs,"Click on View Integration Logs").click();
				common.waitUntilElementToBeVisible(integrationLogsHeader);
				common.findElementBy(integrationLogsHeader,"Integration Logs header verified");
				common.pause(5);
				common.log("close Integration Logs view");
				common.jsClick(closeIntegrationLogsView);
				common.pause(5);
				common.log("Close Process log view");
				common.jsClick(closeIconForProcessLog);

				break;
			}
			else
			{
				common.findElementBy(closeIconForProcessLog,"Close Process log view").click();
				common.findElementBy((WebElement) By.xpath("//tbody/tr[1]/td["+i+"]//..//button//span//mat-icon"),"Click on action icon for next record").click();

				common.waitUntilElementToBeVisible(viewPLog);
				common.findElementBy(viewPLog, "Select view process log option").click();
				common.pause(10);

				if (common.isElementDisplayed(processLogTitle)) {
					common.waitUntilElementToBeVisible(processLogTitle);
					String pLog = common.findElement(processLogTitle).getText();
					common.log("Process Log Title is :" + pLog);
					common.findElementBy(processLogTitle,"Expand Process log").click();

				}
				else {
					String strProcessLog = common.findElementBy((WebElement) By.xpath("//div[@class='mdo-notice f-row mdo-notice-info']"),"Getting logs from view process log").getText();
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

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();
		common.refreshPage();

		common.waitUntilElementToBeVisible(materialMaster);
		common.log("Click on Material master from left nav");

		common.findElement(materialMaster).click();
		common.pause(10);

		//If default view not appear then select it from view dropdown
		if (!common.isElementPresent(defaultView)) {

			common.findElementBy(viewDropDownIcon, "Click on view dropdown icon").click();
			common.pause(2);
			common.findElementBy(defaultViewOption, "Click on Default view option").click();
			common.pause(10);

		}

		String materialMasterNumber = common.findElement(materialMasterNum).getText();
		common.log("Material master number is : " + materialMasterNumber);
		common.log("Set filter status as a system");
		common.findElement(statusFilter).sendKeys("System");
		common.pause(10);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on edit");

		common.findElement(edit).click();
		common.pause(10);

		if(common.isElementDisplayed(sequentialMaterialOption))
		{
			common.findElementBy(sequentialMaterialOption, "Click on Sequential Material option").click();
			common.waitUntilElementToBeVisible(unitOfWeightField);
			common.findElementBy(unitOfWeightField,"Click on Unit Of Weight field").click();
			common.waitUntilElementToBeVisible(dropValue1);
			common.findElementBy(dropValue1,"Select first option").click();

		}
		else {
			common.log("Click on material master workflow role");
			common.findElement(materialMasterRecordOption).click();
			common.pause(10);
			common.waitUntilElementToBeVisible(headerData);
			common.pause(10);

			common.log("Select Industry Sector");
			common.waitUntilElementToBeVisible(industrySec);
			common.findElement(industrySec).click();
			common.pause(5);
			common.findElement(dropValue).click();

			common.findElementBy(plusStorageData, "Click on plus icon for Storage Data hierarchy");

			common.findElementBy(firstOptionStorageData, "Select first option for Storage Data hierarchy");

			common.findElementBy(applyFilterButton, "Click on apply button");
			common.pause(5);
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
		if(common.isElementDisplayed(errorMessage))
		{

			common.log("Showing mandatory error");
			List<WebElement> webElements = driver.findElements(By.xpath("//p[@class='small ng-star-inserted']"));

			for (WebElement e : webElements) {
				common.log("Error: " + e.getText());
			}
			common.refreshPage();
			common.pause(10);
			common.findElement(industrySec).click();
			common.pause(5);

			common.findElement(dropValue).click();
			common.pause(5);
			common.log("Click on save button");
			common.findElement(uSaveBtn).click();
			common.pause(10);
		}
		else {

			common.log("No Something went error");
		}
		common.waitUntilElementToBeVisible(actionIconForFirstValue);
		common.findElement(actionIconForFirstValue).click();

		common.log("Click on view Process log");
		common.waitUntilElementToBeVisible(viewProcessLogOption);
		common.findElement(viewProcessLogOption).click();
		common.pause(5);

		common.waitUntilElementToBeVisible(processLogStatus);
		String viewProcessLog = common.findElement(processLogStatus).getText();
		common.log("View Process log =>>" + viewProcessLog);
		common.findElement(processLogTitle).click();
		common.pause(10);

		common.waitUntilElementToBeVisible(statusCom);
		String status = common.findElement(statusCom).getText();
		common.log("Process Log Status is : " + status);
		assertEquals(status, "COMPLETED");
		common.pause(10);
		common.log("Click on view change");
		common.findElement(completedViewProcessLog).click();
		common.pause(10);

		common.waitUntilElementToBeVisible(headerData);
		Boolean header = common.findElement(headerData).isDisplayed();
		common.log("Title is Header data : >>" + header);

		common.waitUntilElementToBeVisible(fieldNameHeader);
		common.findElementBy(fieldNameHeader,"Field Name header is available");
		common.findElementBy(beforeChangeHeader,"Before Change header is available");
		common.findElementBy(afterChangeHeader,"After Change header is available");
		String str1[] = {"Field name","Before change","After change"};

		//this loop will fetch one by one data from field name, before change, after change
		for (int i =0; i<str1.length;i++)
		{
			int j = i+1;
			if (common.isElementDisplayed((WebElement) By.xpath("//div[3]/table[1]/tbody[1]/tr[1]/td[1]")))
			{
				String str = common.findElement((WebElement) By.xpath("//div[3]/table[1]/tbody[1]/tr[1]/td["+j+"]")).getText();
				common.log(str1[i]+":"+str);
			}
		}

		common.findElementBy(closeIcoForViewChange,"Click on close icon for view change").click();
		common.waitUntilElementToBeVisible(closeIconForProcessLog);
		common.findElementBy(instanceDiagramIcon,"Click on Instance Diagram icon").click();
		common.waitUntilElementToBeVisible(processFlowHeader);
		common.findElementBy(instanceDiagramImage,"Instance diagram verified");
		common.pause(5);
		common.findElementBy(closeIconProcessFlow,"Close Process flow page").click();
		common.waitUntilElementToBeVisible(closeIconForProcessLog);
		common.findElementBy(viewPotentialOwner,"Click on View link text in Potential Owner column").click();
		common.pause(10);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@role='menu']//div//div[@role='menuitem']"));
		common.log("List of potential owner displaying : >>" );
		for (WebElement e  : ele)
		{
			common.log(e.getText());
		}

	}

}
