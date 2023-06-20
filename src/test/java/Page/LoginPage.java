package Page;

import Utils.BasePage;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class LoginPage extends Locators {

	// WebDriver driver;
	Common common = new Common(driver);
	Properties obj = new Properties();


	public LoginPage(WebDriver driver) throws FileNotFoundException {
		// driver = d;
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);

	}

	/**
	 * Open URL
	 * 
	 */
	public void goToURL(String env) {
		String URL;
		if(env.equals("SAND")) {
			URL = getPropertyValue("urlSandBox");

		}
		else {
			URL = getPropertyValue("url");

		}
		System.out.println("Step :: Open Url: "+URL);
		common.log("Open URL: "+URL);
		driver.get(URL);
	}

	
	/**
	 * Verify Sign In Scenario
	 * 
	 */
	public void check_SignIn(String env) {

		if(env.equals("QAH")) {

			System.out.println("Step :: Entering username: " + getPropertyValue("qahReqUserName"));
			common.log("Entering username: " + getPropertyValue("qahReqUserName"));
			common.findElement(userNameField).sendKeys(getPropertyValue("qahReqUserName"));

			common.pause(10);
			System.out.println("Step :: Click on continue button.");
			common.log("Click on continue button.");
			common.findElement(continueButton).click();
			common.pause(5);

			//If Use Password button display then click on that and then entering password
			if (common.isElementPresent(usePasswordButton)) {

				common.findElementBy(usePasswordButton, "Click on Use password button").click();
			}
			common.pause(5);
			System.out.println("Step :: Entering password:: " + getPropertyValue("qahReqPassword"));
			test.log(LogStatus.INFO, "Entering password:: " + getPropertyValue("qahReqPassword"));
			common.log("Entering password: " + getPropertyValue("qahReqPassword"));
			common.findElement(PasswordField).sendKeys(getPropertyValue("qahReqPassword"));

			//wait for Data Tab appear

		}
		else if(env.equals("QAR")){
			System.out.println("Step :: Entering username: " + getPropertyValue("qarReqUserName"));
			common.log("Entering username: " + getPropertyValue("qarReqUserName"));
			common.findElement(userNameField).sendKeys(getPropertyValue("qarReqUserName"));

			common.pause(10);
			System.out.println("Step :: Click on continue button.");
			common.log("Click on continue button.");
			common.findElement(continueButton).click();
			common.pause(5);

			//If Use Password button display then click on that and then entering password
			if (common.isElementPresent(usePasswordButton)) {

				common.findElementBy(usePasswordButton, "Click on Use password button").click();
			}
			common.pause(5);
			System.out.println("Step :: Entering password:: " + getPropertyValue("qarReqPassword"));
			test.log(LogStatus.INFO, "Entering password:: " + getPropertyValue("qarReqPassword"));
			common.log("Entering password: " + getPropertyValue("qarReqPassword"));
			common.findElement(PasswordField).sendKeys(getPropertyValue("qarReqPassword"));

			//wait for Data Tab appear

		}
		else if(env.equals("SAND")){
			System.out.println("Step :: Entering username: " + getPropertyValue("sandBoxReqUserName"));
			common.log("Entering username: " + getPropertyValue("sandBoxReqUserName"));
			common.findElement(userNameField).sendKeys(getPropertyValue("sandBoxReqUserName"));

			common.pause(10);
			System.out.println("Step :: Click on continue button.");
			common.log("Click on continue button.");
			common.findElement(continueButton).click();
			common.pause(5);

			//If Use Password button display then click on that and then entering password
			if (common.isElementPresent(usePasswordButton)) {

				common.findElementBy(usePasswordButton, "Click on Use password button").click();
			}
			common.pause(5);
			System.out.println("Step :: Entering password:: " + getPropertyValue("sandBoxReqPassword"));
			test.log(LogStatus.INFO, "Entering password:: " + getPropertyValue("sandBoxReqPassword"));
			common.log("Entering password: " + getPropertyValue("sandBoxReqPassword"));
			common.findElement(PasswordField).sendKeys(getPropertyValue("sandBoxReqPassword"));

			//wait for Data Tab appear

		}
		common.pause(5);
		test.log(LogStatus.INFO, "Click on Login button");
		System.out.println("Step :: Click on login button");
		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(10);
		if (common.isElementDisplayed("//p[normalize-space()='QA Sandbox']"))
		{
			common.findElementBy("//p[normalize-space()='QA Sandbox']", "Click on QA sandbox").click();
		}

		common.waitForElement(dataTab);
		test.log(LogStatus.INFO, "Env URL:: " + driver.getCurrentUrl());
		System.out.println("Step:: Env URL: " + driver.getCurrentUrl());
		common.log("Env URL: " + driver.getCurrentUrl());

	}

	/**
	 * As a reviewer sign-in scenario
	 * 
	 */
	public void revSignIn(String env) {

		//Sign out the approver
		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon,"Click on profile icon").click();
			driver.findElement(By.xpath(signOut)).click();
		}

		common.pause(5);
		common.waitForElement(userNameField);
		test.log(LogStatus.INFO, "Step :: --- User login as reviewer credentials");
		System.out.println("Step :: --- User login as reviewer credentials");
		common.log("--- User login as reviewer credentials");

		if (env.equals("QAH")) {
			System.out.println("Step :: Enter value in email field: " + getPropertyValue("qahRevUserName"));
			common.log("Enter the value in email field: " + getPropertyValue("qahRevUserName"));
			WebElement emailField = driver.findElement(By.xpath(revUsernameField));
			emailField.sendKeys(getPropertyValue("qahRevUserName"));

			WebElement continueBtn = driver.findElement(By.xpath(continueButton));
			continueBtn.click();
			common.pause(10);
			//If Use Password button display then click on that and then entering password
			if (common.isElementPresent(usePasswordButton)) {

				common.findElementBy(usePasswordButton, "Click on Use password button").click();
				common.pause(5);
			}
			System.out.println("Step :: Entering password: " + getPropertyValue("qahRevPassword"));
			common.log("Entering password: " + getPropertyValue("qahRevPassword"));
			WebElement passwordField = driver.findElement(By.xpath(PasswordField));
			passwordField.sendKeys(getPropertyValue("qahRevPassword"));
		}
		else if (env.equals("QAR"))
		{
			System.out.println("Step :: Enter value in email field: " + getPropertyValue("qarRevUserName"));
			common.log("Enter the value in email field: " + getPropertyValue("qarRevUserName"));
			WebElement emailField = driver.findElement(By.xpath(revUsernameField));
			emailField.sendKeys(getPropertyValue("qarRevUserName"));

			WebElement continueBtn = driver.findElement(By.xpath(continueButton));
			continueBtn.click();
			common.pause(10);
			//If Use Password button display then click on that and then entering password
			if (common.isElementPresent(usePasswordButton)) {

				common.findElementBy(usePasswordButton, "Click on Use password button").click();
				common.pause(5);
			}

			System.out.println("Step :: Entering password: " + getPropertyValue("qarRevPassword"));
			common.log("Entering password: " + getPropertyValue("qarRevPassword"));
			WebElement passwordField = driver.findElement(By.xpath(RevPwdField));
			passwordField.sendKeys(getPropertyValue("qarRevPassword"));
		}
		else if (env.equals("SAND"))
		{
			System.out.println("Step :: Enter value in email field: " + getPropertyValue("sandBoxRevUserName"));
			common.log("Enter the value in email field: " + getPropertyValue("sandBoxRevUserName"));
			common.waitForElement(revUsernameField);
			WebElement emailField = driver.findElement(By.xpath(revUsernameField));
			emailField.sendKeys(getPropertyValue("sandBoxRevUserName"));

			WebElement continueBtn = driver.findElement(By.xpath(continueButton));
			continueBtn.click();
			common.pause(10);
			//If Use Password button display then click on that and then entering password
			if (common.isElementPresent(usePasswordButton)) {

				common.findElementBy(usePasswordButton, "Click on Use password button").click();
				common.pause(5);
			}

			System.out.println("Step :: Entering password: " + getPropertyValue("sandBoxRevPassword"));
			common.log("Entering password: " + getPropertyValue("sandBoxRevPassword"));
			WebElement passwordField = driver.findElement(By.xpath(RevPwdField));
			passwordField.sendKeys(getPropertyValue("sandBoxRevPassword"));
		}
		common.pause(5);
		test.log(LogStatus.INFO, "click on login button");
		System.out.println("Step :: click on login button");
		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(10);
		if (common.isElementDisplayed("//p[normalize-space()='QA Sandbox']"))
		{
			common.findElementBy("//p[normalize-space()='QA Sandbox']", "Click on QA sandbox").click();
		}


	}

	/**
	 * QA-Login scenario
	 * 
	 */
	public void qaLogin() {
		System.out.println("Step :: Open Url");
		String URL = getPropertyValue("urlFuse");

		common.log("Open URL ");
		driver.get(URL);
		test.log(LogStatus.INFO, "Navigated to URL");

		test.log(LogStatus.INFO, "Enter value in email field");
		System.out.println("Step :: Enter value in email field");
		common.log("Enter the value in email field");
		common.findElement(userNameField).sendKeys(getPropertyValue("qaUserName"));

		common.waitForElement(continueButton);
		common.findElement(continueButton).click();

		common.waitForElement(userPasswordLink);
		common.findElement(userPasswordLink).click();

		System.out.println("Step :: Entering password");
		common.log("Entering password");

		common.waitForElement(nPasswordField);
		driver.findElement(By.xpath(nPasswordField)).sendKeys(getPropertyValue("password"));
		common.pause(10);
		test.log(LogStatus.INFO, "Click on Login button");
		System.out.println("Step :: Click on login button");
		common.log("click on login button");
		common.findElement(loginBtn).click();

		test.log(LogStatus.INFO, "Click on QA");
		System.out.println("Step :: Click on QA");
		common.log("Click on QA");
		common.waitForElement(qaEnv);
		driver.findElement(By.xpath(qaEnv)).click();

	}
	
	/**
	 * PROD-Login scenario
	 * 
	 */
	public void prodLogin() {

		System.out.println("Step :: Open Url");
		String URL = getPropertyValue("urlProd");

		common.log("Open URL: "+URL);
		driver.get(URL);
		test.log(LogStatus.INFO, "Navigated to URL");

		
		test.log(LogStatus.INFO, "Enter value in Organization field");
		System.out.println("Step :: Enter value in organization field");
		common.log("Enter the value in organization field");
		common.findElement(userNameField).sendKeys("mondelez");
		common.pause(10);
		common.findElement(continueButton).click();
		common.pause(10);

		
		test.log(LogStatus.INFO, "Enter value in email field");
		System.out.println("Step :: Enter value in email field");
		common.log("Enter the value in email field");
		common.findElement(usenameProd).sendKeys(getPropertyValue("ProdUserName"));

		common.pause(10);
		common.findElement(continueButton).click();
		common.pause(10);

		common.findElement(userPasswordLink).click();

		System.out.println("Step :: Entering password");
		test.log(LogStatus.INFO, "Entering password");
		common.log("Step :: Entering password");
		common.pause(10);

		driver.findElement(By.xpath(nPasswordField)).sendKeys("Welcome@123");
		common.pause(10);

		test.log(LogStatus.INFO, "Click on Login button");
		System.out.println("Step :: Click on login button");
		common.log("click on login button");
		common.findElement(loginBtn).click();

		test.log(LogStatus.INFO, "Click on PROD");
		System.out.println("Step :: Click on PROD");
		common.log("Click on PROD");
		common.waitForElement(prodEnv);
		driver.findElement(By.xpath(prodEnv)).click();

	}

}
