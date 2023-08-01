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


	/**
	 * Verifyf Login Page Driver
	 *
	 * @param driver
	 * @throws FileNotFoundException
	 */
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
		String URL = null;
		common.log("Open the browser");
		if(env.equals("QAA") || env.equals("QAH") || env.equals("QAR") || env.equals("SAND")) {
			URL = getPropertyValue(env+"_url");
		}
		common.log("Enter the URL: "+URL);
		driver.get(URL);
	}

	
	/**
	 * Verify Sign In Scenario
	 * 
	 */
	public void initiator_SignIn(String env) {

		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon,"Click on profile icon").click();
			driver.findElement(By.xpath(signOut)).click();
			common.pause(10);
		}

		/**
		 * For ALl Environment
		 *
		 */
		if(env.equals("QAA") || env.equals("QAH") || env.equals("QAR") || env.equals("SAND")) {

			common.log("Entering username: " + getPropertyValue(env+"ReqUserName"));
			common.waitForElement(userNameField);
			common.findElement(userNameField).sendKeys(getPropertyValue(env+"ReqUserName"));

			common.log("Click on continue button");
			common.waitForElement(continueButton);
			common.findElement(continueButton).click();
			common.pause(5);

			//If 'Use Password' button display then click on that and then entering password
			if (common.isElementDisplayed(usePasswordButton)) {
				common.findElementBy(usePasswordButton, "Click on Use password button").click();
			}

			common.log("Entering password: " + getPropertyValue(env+"ReqPassword"));
			common.waitForElement(PasswordField);
			common.findElement(PasswordField).sendKeys(getPropertyValue(env+"ReqPassword"));
		}

		common.log("Click on login button");
		common.waitForElement(loginBtn);
		common.findElement(loginBtn).click();

		//Wait for options after login to select QA Sandbox or Tenant 1 or Home page
		common.waitForElement("(//div[@class='mat-list-item-content'])[1]");

		//if SANDBOX env is there then select QA Sandbox option
		if (common.isElementDisplayed("//p[normalize-space()='QA Sandbox']"))
		{
			common.findElementBy("//p[normalize-space()='QA Sandbox']", "Click on QA sandbox").click();
		}

		//if QAR env is there then select Tenant 1 option
		if (common.isElementDisplayed("//p[normalize-space()='Tenant 1']"))
		{
			common.findElementBy("//p[normalize-space()='Tenant 1']","Select Tenant 1").click();
		}

		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"verify Home page appear");
		common.log("Env URL: " + driver.getCurrentUrl());
	}

	/**
	 * As a reviewer sign-in scenario
	 * 
	 */
	public void reviewer_SignIn(String env) {

		//Sign out the approver
		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon,"Click on profile icon").click();
			driver.findElement(By.xpath(signOut)).click();
		}

		common.pause(5);
		common.waitForElement(userNameField);
		common.log("--- User login as reviewer credentials");

		if (env.equals("QAA") || env.equals("QAH") || env.equals("QAR") || env.equals("SAND")) {

			common.log("Enter the value in email field: " + getPropertyValue(env+"RevUserName"));
			WebElement emailField = driver.findElement(By.xpath(revUsernameField));
			emailField.sendKeys(getPropertyValue(env+"RevUserName"));

			WebElement continueBtn = driver.findElement(By.xpath(continueButton));
			continueBtn.click();
			common.pause(10);

			//If 'Use Password' button display then click on that and then entering password
			if (common.isElementDisplayed(usePasswordButton)) {
				common.findElementBy(usePasswordButton, "Click on Use password button").click();
				common.pause(5);
			}

			common.log("Entering password: " + getPropertyValue(env+"RevPassword"));
			WebElement passwordField = driver.findElement(By.xpath(PasswordField));
			passwordField.sendKeys(getPropertyValue(env+"RevPassword"));
		}

		common.pause(5);
		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(5);

		//Wait for options after login to select QA Sandbox or Tenant 1 or Home page
		common.waitForElement("(//div[@class='mat-list-item-content'])[1]");

		//if SANDBOX env is there then select QA Sandbox option
		if (common.isElementDisplayed("//p[normalize-space()='QA Sandbox']"))
		{
			common.findElementBy("//p[normalize-space()='QA Sandbox']", "Click on QA sandbox").click();
		}

		//if QAR env is there then select Tenant 1 option
		if (common.isElementDisplayed("//p[normalize-space()='Tenant 1']"))
		{
			common.findElementBy("//p[normalize-space()='Tenant 1']","Select Tenant 1").click();
		}
		common.waitForElement(homeTab);
		common.findElementBy(homeTab,"verify Home page appear");
		common.log("Env URL: " + driver.getCurrentUrl());

	}

	/**
	 * QA-Login scenario
	 * 
	 */
	public void qaLogin() {
		common.log("Open Url");
		String URL = getPropertyValue("urlFuse");

		driver.get(URL);

		common.log("Enter the value in email field");
		common.findElement(userNameField).sendKeys(getPropertyValue("qaUserName"));

		common.waitForElement(continueButton);
		common.findElement(continueButton).click();

		common.waitForElement(userPasswordLink);
		common.findElement(userPasswordLink).click();
		common.log("Entering password");

		common.waitForElement(nPasswordField);
		driver.findElement(By.xpath(nPasswordField)).sendKeys(getPropertyValue("password"));
		common.pause(10);
		common.log("click on login button");
		common.findElement(loginBtn).click();

		common.log("Click on QA");
		common.waitForElement(qaEnv);
		driver.findElement(By.xpath(qaEnv)).click();

	}
	
	/**
	 * PROD-Login scenario
	 * 
	 */
	public void prodLogin() {

		common.log("Open Url");
		String URL = getPropertyValue("urlProd");

		common.log("Open URL: "+URL);
		driver.get(URL);

		common.log("Enter the value in organization field");
		common.findElement(userNameField).sendKeys("mondelez");
		common.pause(10);
		common.findElement(continueButton).click();
		common.pause(10);
		common.log("Enter the value in email field");
		common.findElement(usernameProd).sendKeys(getPropertyValue("ProdUserName"));

		common.pause(10);
		common.findElement(continueButton).click();
		common.pause(10);

		common.findElement(userPasswordLink).click();

		common.log("Entering password");
		common.pause(10);

		driver.findElement(By.xpath(nPasswordField)).sendKeys("Welcome@123");
		common.pause(10);

		common.log("click on login button");
		common.findElement(loginBtn).click();

		common.log("Click on PROD");
		common.waitForElement(prodEnv);
		driver.findElement(By.xpath(prodEnv)).click();
	}

}
