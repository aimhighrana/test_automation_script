// region Packages & Imports
package Page;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import contracts.*;
import Utils.Common;
import Utils.Locators;
import Utils.Entity.UserCredential;
import Utils.Enums.*;
import ServiceHelper.*;

//endregion

public class LoginPage extends Locators {

	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	// region constructors
	/**
	 * Verify Login Page Driver
	 *
	 * @param driver
	 * @throws FileNotFoundException
	 */
	public LoginPage(WebDriver driver) throws FileNotFoundException {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();
	}
	// end region

	// region private methods

	/*
	 * method to verify user Login process Parameter: UserLoginRole
	 */
	private void userLoginProcess(UserLoginRole loggedinUserRole) {
		UserCredential userCredential = authenticationService.getCredentials(loggedinUserRole);

		WebElement fieldUsername = common.findElement(userNameField);
		common.log(LogStatus.INFO, "Entering username: " + userCredential.getUsername());
		fieldUsername.sendKeys(userCredential.getUsername());

		common.pause(10);
		common.log(LogStatus.INFO, "Click on continue button");
		common.findElement(continueButton).click();
		common.pause(5);

		// If Use Password button display then click on that and then entering password
		if (common.isElementDisplayed(usePasswordButton)) {

			WebElement fieldPasswordHyperlink = common.findElement(usePasswordButton);
			common.log(LogStatus.INFO, "Use password hyperlink appear");
			common.log(LogStatus.INFO, "Click on Use password button");
			fieldPasswordHyperlink.click();
		}
		common.pause(5);
		common.log(LogStatus.INFO, "Entering password: " + userCredential.getPassword());
		WebElement fieldPassword = common.findElement(PasswordField);
		fieldPassword.sendKeys(userCredential.getPassword());
	}

	// end region
	
	public void goToURL(String env) {
		String applicationUrl;
		common.log("Open the browser");
		environmentName = env;
		environmentService.getEnvironmentProperties(env);
		common.log("Environment requested: " + environmentName);
		applicationUrl = getPropertyValue("urlQAEnvironment");
		common.log("Enter the URL: " + applicationUrl);
		driver.get(applicationUrl);
	}

	/**
	 * Verify Sign In Scenario
	 * 
	 */
	public void initiator_SignIn() {

		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon, "Click on profile icon").click();
			driver.findElement(By.xpath(signOut)).click();
			common.pause(10);
		}
		userLoginProcess(UserLoginRole.INITIATOR);

		common.pause(5);
		System.out.println("Step :: Click on login button");
		common.log("Click on login button");
		common.findElement(loginBtn).click();
		common.pause(5);
		common.waitForElement("(//div[@class='mat-list-item-content'])[1]");

		if (common.isElementDisplayed("//p[normalize-space()='QA Sandbox']")) {
			common.findElementBy("//p[normalize-space()='QA Sandbox']", "Click on QA sandbox").click();
		}

		if (common.isElementDisplayed("//p[normalize-space()='Tenant 1']")) {
			common.findElementBy("//p[normalize-space()='Tenant 1']", "Select Tenant 1").click();
		}

		common.waitForElement(homeTab);
		common.findElementBy(homeTab, "verify Home page appear");
		test.log(LogStatus.INFO, "Env URL:: " + driver.getCurrentUrl());
		System.out.println("Step :: Env URL: " + driver.getCurrentUrl());
		common.log("Env URL: " + driver.getCurrentUrl());

	}

	/**
	 * As a reviewer sign-in scenario
	 * 
	 */
	public void reviewer_SignIn() {

		// Sign out the approver
		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon, "Click on profile icon").click();
			driver.findElement(By.xpath(signOut)).click();
		}

		userLoginProcess(UserLoginRole.REVIEWER);
		;

		common.pause(5);
		common.waitForElement(userNameField);
		System.out.println("Step :: --- User login as reviewer credentials");
		common.log("--- User login as reviewer credentials");
		
		common.pause(5);
		test.log(LogStatus.INFO, "click on login button");
		System.out.println("Step :: click on login button");
		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(10);
		if (common.isElementDisplayed("//p[normalize-space()='QA Sandbox']")) {
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

		common.log("Open URL: " + URL);
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
		common.findElement(usernameProd).sendKeys(getPropertyValue("ProdUserName"));

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
