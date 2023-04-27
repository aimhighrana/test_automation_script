package Page;

import Utils.Common;
import Utils.Locators;
import au.com.bytecode.opencsv.CSVWriter;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Flow extends Locators {

	RemoteWebDriver driver;
	Common common = new Common(driver);
	Properties obj = new Properties();

	public Flow(WebDriver driver2) throws FileNotFoundException {
		// driver = d;
		super(driver2);
		common = new Common(driver2);
		PageFactory.initElements(this.driver, this);

	}

	public String userName = "qa_admin@yopmail.com";
	public String password = "Welcome@123";

	String code = "";

	/**
	 * check url design table datta
	 * 
	 */
	public void checkdesignTBLData() {

		test.log(LogStatus.INFO, "Step :: Enter value in email field");
		System.out.println("Step :: Enter value in email field");
		common.log("Enter the value in email field");
		common.findElement(userNameField).sendKeys(userName);

		common.pause(10);
		common.findElement(continueButton).click();
		common.pause(5);

		test.log(LogStatus.INFO, "Step :: Entering password");
		System.out.println("Step :: Entering password");
		common.log("Step :: Entering password");
		common.pause(10);
		common.findElement(PasswordField).sendKeys(password);
		common.pause(12);

		test.log(LogStatus.INFO, "Step :: click on login button");
		System.out.println("Step :: Click on login button");
		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(15);

		test.log(LogStatus.INFO, "Step :: Click on floe tab");
		System.out.println("Step :: Click on Flow tab");
		common.log("click on Flow tab");
		driver.findElement(By.xpath(flowtab)).click();

		common.waitForElement(manageFlowBtn);
		test.log(LogStatus.INFO, "Step :: click on manage Flow button");
		System.out.println("Step :: Click on manage Flow button");
		common.log("click on manage Flow button");
		common.findElement(manageFlowBtn).click();

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));

		common.waitForElement(design);
		common.findElement(design).click();
		common.waitForElement(spac);
		if (driver.findElement(By.xpath(spac)).isDisplayed()) {
			common.pause(25);
			List<WebElement> myList = driver.findElements(By.xpath(spacRecord));

			List<String> all_elements_text = new ArrayList<>();

			for (int i = 0; i < myList.size(); i++) {

				all_elements_text.add(myList.get(i).getText());
				test.log(LogStatus.INFO, "Step :: Table records are ::" + myList.get(i).getText());
				System.out.println("Table records are:: " + myList.get(i).getText());

			}
		} else {
			test.log(LogStatus.INFO, "Step :: An error occured");
			System.out.println("An error occured!!");
		}

	}

	public void checkDescriptionChange() throws IOException, ParseException {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();

		System.out.println("Step :: click on Material master from leftnav");

		common.log("Click on Material master from leftnav");
		common.waitForElement(dMaterialMaster);
		common.findElement(dMaterialMaster).click();
		common.pause(40);

		// Path of the excel file
		FileInputStream fs = new FileInputStream("/Users/adroid/Downloads/Prospecta/Record Numbers for Sandbox.xlsx");
		// Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

       /**
        * Set the loop count as per the no of rows in sheet
        */
		for (int j = 8; j < 105; j++) {
			sheet.getRow(j).getCell(0);

			System.out.println("Row value:" + j);
			System.out.println("record is ==>" + sheet.getRow(j).getCell(0));

			common.pause(40);
			System.out.println("Step :: Enter values in search box: " + sheet.getRow(j).getCell(0));
			common.log("Enter the value in search box ");
			common.findElement(dSearchBox).clear();
			common.pause(5);
			common.findElement(dSearchBox).sendKeys("" + sheet.getRow(j).getCell(0) + "");
			common.pause(25);

			common.findElement(apply).click();
			common.pause(30);
			System.out.println("Step :: click on three dot icon");
			common.findElement(thDot).click();

			test.log(LogStatus.INFO, "click on edit ");
			System.out.println("Step :: click on edit");
			common.findElement(edit).click();
			common.pause(15);

			test.log(LogStatus.INFO, "click on description change ");
			System.out.println("Step :: click on description change");
			common.findElement(dChange).click();

			common.waitForElement(uSaveBtn);
			test.log(LogStatus.INFO, "click on save button");
			System.out.println("Step :: click on save button");

			common.pause(5);

			common.findElement(uSaveBtn).click();
			common.pause(150);
			File csv = new File(System.getProperty("user.dir"), "/OutPut.csv");

			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

			if (common.isDisplayed(allerros) == true) {
				common.findElement(ccrsicon).click();

				common.pause(10);

				// writer.writeNext("FAIL\t");

				// System.out.println("FAIL\t");

				/**
				 * code block to verify the view process log
				 */
				System.out.println("Step :: click on three dot icon");
				common.findElement(thDot).click();
				common.waitForElement(viewPLog);

				common.findElement(viewPLog).click();
				common.waitForElement(pTitle);

				String fullXpath = String.format(currentDate, common.currentDate());
				System.out.println("Current date is ==>" + common.currentDate());
				common.waitForElement(fullXpath);
				
				if (common.isDisplayed(fullXpath)) {
					common.findElement(fullXpath).click();
					System.out.println("Status is ==>" + common.findElement(statusSuccessTxt).getText());

					writer.writeNext("FAIL", "Success");
					common.findElement(crossP).click();

				} else {
					writer.writeNext("FAIL", "Error");
					System.out.println("Stauts is :: Error");
					common.findElement(crossP).click();
				}

			} else {

				common.pause(30);

				// writer.writeNext("PASS\t");
				/**
				 * code block to verify the view process log
				 */
				System.out.println("Step :: click on three dot icon");
				common.findElement(thDot).click();
				common.waitForElement(viewPLog);

				common.findElement(viewPLog).click();
				common.waitForElement(pTitle);

				String fullXpath = String.format(currentDate, common.currentDate());
				System.out.println("Current date is ==>" + common.currentDate());
				common.waitForElement(fullXpath);
				common.findElement(fullXpath).click();
				if (common.isDisplayed(statusSuccessTxt)) {
					System.out.println("Status is ==>" + common.findElement(statusSuccessTxt).getText());

					writer.writeNext("PASS", "Success");
					common.findElement(crossP).click();

				} else {
					writer.writeNext("PASS", "Error");
					System.out.println("Stauts is :: Error");
					common.findElement(crossP).click();
				}

			}

			writer.close();

			common.pause(3);

		}

	}
	//
	public void checkDescriptionChangeForProdEnv() throws IOException, ParseException {

		common.waitForElement(dataTab);

		common.findElement(dataTab).click();

		System.out.println("Step :: click on Material master from leftnav");

		common.log("Click on Material master from leftnav");
		common.waitForElement(dMaterialMaster);
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

			System.out.println("Row value:" + j);
			System.out.println("record is ==>" + sheet.getRow(j).getCell(0));

		//	common.pause(40);
	     	common.waitForElement(dSearchBox);
			System.out.println("Step :: Enter values in search box: " + sheet.getRow(j).getCell(0));
			common.log("Enter the value in search box ");
			common.findElement(dSearchBox).clear();
			common.pause(5);
			common.findElement(dSearchBox).sendKeys("" + sheet.getRow(j).getCell(0) + "");
			//common.pause(25);

			common.waitForElement(apply);
			common.findElement(apply).click();
			//common.pause(30);
			common.waitForElement(thDot);
			System.out.println("Step :: click on three dot icon");
			common.findElement(thDot).click();

			common.waitForElement(edit);
			test.log(LogStatus.INFO, "click on edit ");
			System.out.println("Step :: click on edit");
			common.findElement(edit).click();
		//	common.pause(15);
           common.waitForElement(dChange);
			test.log(LogStatus.INFO, "click on description change ");
			System.out.println("Step :: click on description change");
			common.findElement(dChange).click();

			common.waitForElement(uSaveBtn);
			test.log(LogStatus.INFO, "click on save button");
			System.out.println("Step :: click on save button");

			common.pause(20);

			common.findElement(uSaveBtn).click();
			common.pause(75);
			File csv = new File(System.getProperty("user.dir"), "/OutPut.csv");

			CSVWriter writer = new CSVWriter(new FileWriter(csv, true));

			if (common.isDisplayed(allerros) == true) {
				common.findElement(ccrsicon).click();

				common.pause(10);

				writer.writeNext("FAIL\t  "+sheet.getRow(j).getCell(0));

				System.out.println("FAIL\t  "+sheet.getRow(j).getCell(0));

				/**
				 * code block to verify the view process log
				 */
//				System.out.println("Step :: click on three dot icon");
//				common.findElement(thDot).click();
//				common.waitForElement(viewPLog);
//
//				common.findElement(viewPLog).click();
//				common.waitForElement(pTitle);
//
//				String fullXpath = String.format(currentDate, common.currentDate());
//				System.out.println("Current date is ==>" + common.currentDate());
//				common.waitForElement(fullXpath);
//				
//				if (common.isDisplayed(fullXpath)) {
//					common.findElement(fullXpath).click();
//					System.out.println("Status is ==>" + common.findElement(statusSuccessTxt).getText());
//
//
//					XSSFCell str = sheet.getRow(j).getCell(0);
//					String strVal = str.toString();
//					writer.writeNext("FAIL, Success",strVal);
//					common.findElement(crossP).click();
//
//				} else {
//
//					XSSFCell str = sheet.getRow(j).getCell(0);
//					String strVal = str.toString();
//					writer.writeNext("FAIL, Error", strVal);
//					System.out.println("Stauts is :: Error");
//					common.findElement(crossP).click();
//				}

			} else {

				common.pause(30);

				 writer.writeNext("PASS\t  "+sheet.getRow(j).getCell(0));
				 System.out.println("PASS\t  "+sheet.getRow(j).getCell(0));
				/**
				 * code block to verify the view process log
				 */
//				System.out.println("Step :: click on three dot icon");
//				common.findElement(thDot).click();
//				common.waitForElement(viewPLog);
//
//				common.findElement(viewPLog).click();
//				common.waitForElement(pTitle);
//
//				String fullXpath = String.format(currentDate, common.currentDate());
//				System.out.println("Current date is ==>" + common.currentDate());
//				common.waitForElement(fullXpath);
//				common.findElement(fullXpath).click();
//				if (common.isDisplayed(statusSuccessTxt)) {
//					System.out.println("Status is ==>" + common.findElement(statusSuccessTxt).getText());
//
//					XSSFCell str = sheet.getRow(j).getCell(0);
//					String strVal = str.toString();
//					writer.writeNext("PASS, Success",strVal);
//					common.findElement(crossP).click();
//
//				} else {
//
//					XSSFCell str = sheet.getRow(j).getCell(0);
//					String strVal = str.toString();
//					writer.writeNext("PASS, Error", strVal);
//					System.out.println("Stauts is :: Error");
//					common.findElement(crossP).click();
//				}

			}

			writer.close();

		 

		}

		
	}
}
