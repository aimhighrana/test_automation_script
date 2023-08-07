package Page;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import ServiceHelper.AuthenticationService;
import ServiceHelper.EnvironmentService;
import Utils.Common;
import Utils.Locators;
import au.com.bytecode.opencsv.CSVWriter;
import contracts.IAuthenticationService;
import contracts.IEnvironmentService;

public class Flow extends Locators {

	RemoteWebDriver driver;
	Common common;
	Properties obj = new Properties();
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;
	public Flow(WebDriver driver2) throws FileNotFoundException {
		// driver = d;
		super(driver2);
		common = new Common(driver2);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();

	}

	public String userName = "qa_admin@yopmail.com";
	public String password = "Welcome@123";

	String code = "";

	/**
	 * check url design table data
	 *
	 */
	public void check_Design_Table_Data() {

		common.log("Enter the value in email field");
		common.findElement(userNameField).sendKeys(userName);

		common.pause(10);
		common.findElement(continueButton).click();
		common.pause(5);

		common.log("Entering password");
		common.pause(10);
		common.findElement(PasswordField).sendKeys(password);
		common.pause(12);

		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(15);

		common.log("click on Flow tab");
		common.findElement(flowTab).click();

		common.waitUntilElementToBeVisible(manageFlowBtn);
		common.log("click on manage Flow button");
		common.findElement(manageFlowBtn).click();

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

		common.waitUntilElementToBeVisible(design);
		common.findElementBy(design,"Click on design").click();
		common.waitUntilElementToBeVisible(spac);
		if (common.findElement(spac).isDisplayed()) {
			common.pause(25);
			List<WebElement> myList = driver.findElements(By.xpath(String.valueOf(spacRecord)));

			List<String> all_elements_text = new ArrayList<>();

			for (int i = 0; i < myList.size(); i++) {

				all_elements_text.add(myList.get(i).getText());
				common.log("Table records are: " + myList.get(i).getText());

			}
		} else {
			common.log("An error occurred!!");
		}

	}

	public void checkDescriptionChange() throws IOException, ParseException {

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab,"Click on Data tab").click();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(dMaterialMaster);
		common.findElement(dMaterialMaster).click();
		common.pause(40);

		// Path of the excel file
		FileInputStream fs = new FileInputStream("Record Numbers for Sandbox.xlsx");
		// Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		/**
		 * Set the loop count as per the no of rows in sheet
		 */
		for (int j = 8; j < 105; j++) {
			sheet.getRow(j).getCell(0);

			common.log("Row value:" + j);
			common.log("record is ==>" + sheet.getRow(j).getCell(0));

			common.pause(40);
			common.log("Enter values in search box: " + sheet.getRow(j).getCell(0));
			common.log("Enter the value in search box ");
			common.findElement(dSearchBox).clear();
			common.pause(5);
			common.findElement(dSearchBox).sendKeys("" + sheet.getRow(j).getCell(0) + "");
			common.pause(25);

			common.findElement(apply).click();
			common.pause(30);
			common.log("click on three dot icon");
			common.findElement(thDot).click();

			common.log("click on edit");
			common.findElement(edit).click();
			common.pause(15);

			common.log("click on description change");
			common.findElement(dChange).click();

			common.waitUntilElementToBeVisible(uSaveBtn);
			common.log("click on save button");

			common.pause(5);

			common.findElement(uSaveBtn).click();
			common.pause(150);
			File csv = new File(System.getProperty("user.dir"), "/OutPut.csv");

			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

			//if error occurred the close popup and check again view process log
			if (common.isDisplayed(allerros) == true) {
				common.findElement(ccrsIcon).click();

				common.pause(10);
				common.findElementBy(thDot,"Click on three dot icon").click();

				common.waitUntilElementToBeVisible(viewPLog);
				common.findElementBy(viewPLog,"Click on View process log").click();
				common.waitUntilElementToBeVisible(pTitle);

				String fullXpath = String.format(common.currentDate(), currentDate);

				common.log("Current date is ==>" + common.currentDate());
				common.waitUntilElementToBeVisible((WebElement) By.xpath(fullXpath));

				if (common.isDisplayed((WebElement) By.xpath(fullXpath))) {
					common.findElement((WebElement) By.xpath(fullXpath)).click();
					common.log("Status is ==>" + common.findElement(statusSuccessTxt).getText());

					writer.writeNext("FAIL", "Success");
					common.findElement(crossP).click();

				} else {
					writer.writeNext("FAIL", "Error");
					common.log("Status is : Error");
					common.findElement(crossP).click();
				}

			} else {

				common.pause(30);

				common.log("click on three dot icon");
				common.findElement(thDot).click();
				common.waitUntilElementToBeVisible(viewPLog);

				common.findElement(viewPLog).click();
				common.waitUntilElementToBeVisible(pTitle);

				String fullXpath = String.format(common.currentDate(), currentDate);
				common.log("Current date is ==>" + common.currentDate());
				common.waitUntilElementToBeVisible((WebElement) By.xpath(fullXpath));
				common.findElement((WebElement) By.xpath(fullXpath)).click();
				if (common.isDisplayed(statusSuccessTxt)) {
					common.log("Status is ==>" + common.findElement(statusSuccessTxt).getText());

					writer.writeNext("PASS", "Success");
					common.findElement(crossP).click();

				} else {
					writer.writeNext("PASS", "Error");
					common.log("Status is : Error");
					common.findElement(crossP).click();
				}

			}

			writer.close();

			common.pause(3);

		}

	}
	//
	public void checkDescriptionChangeForProdEnv() throws IOException, ParseException {

		common.waitUntilElementToBeVisible(dataTab);

		common.findElementBy(dataTab,"Click on Data tab").click();

		common.log("Click on Material master from left nav");
		common.waitUntilElementToBeVisible(dMaterialMaster);
		common.findElement(dMaterialMaster).click();
		common.pause(40);

		// Path of the excel file
		FileInputStream fs = new FileInputStream("/Users/adroid/Downloads/prospectasoftware/rahul sharma.xlsx");
		// Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		/**
		 * Set the loop count as per the no of rows in sheet
		 */
		for (int j = 1226; j < 2357; j++) {
			sheet.getRow(j).getCell(0);

			common.log("Row value:" + j);
			common.log("record is ==>" + sheet.getRow(j).getCell(0));

			//	common.pause(40);
			common.waitUntilElementToBeVisible(dSearchBox);
			common.log("Enter values in search box: " + sheet.getRow(j).getCell(0));
			common.log("Enter the value in search box ");
			common.findElement(dSearchBox).clear();
			common.pause(5);
			common.findElement(dSearchBox).sendKeys("" + sheet.getRow(j).getCell(0) + "");

			common.waitUntilElementToBeVisible(apply);
			common.findElement(apply).click();
			common.waitUntilElementToBeVisible(thDot);
			common.log("click on three dot icon");
			common.findElement(thDot).click();

			common.waitUntilElementToBeVisible(edit);
			common.log("click on edit");
			common.findElement(edit).click();
			common.waitUntilElementToBeVisible(dChange);
			common.log("click on description change");
			common.findElement(dChange).click();

			common.waitUntilElementToBeVisible(uSaveBtn);
			common.log("click on save button");

			common.pause(20);

			common.findElement(uSaveBtn).click();
			common.pause(75);
			File csv = new File(System.getProperty("user.dir"), "/OutPut.csv");

			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

			if (common.isElementDisplayed(allerros)) {
				common.findElement(ccrsIcon).click();

				common.pause(10);

				writer.writeNext("FAIL\t  "+sheet.getRow(j).getCell(0));

				common.log("FAIL\t  "+sheet.getRow(j).getCell(0));


			} else {

				common.pause(30);

				writer.writeNext("PASS\t  "+sheet.getRow(j).getCell(0));
				common.log("PASS\t  "+sheet.getRow(j).getCell(0));

			}

			writer.close();



		}


	}
}
