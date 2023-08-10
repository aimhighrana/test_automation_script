package Page;

import ServiceHelper.AuthenticationService;
import ServiceHelper.EnvironmentService;
import Utils.Common;
import Utils.Entity.UserCredential;
import Utils.Enums.UserLoginRole;
import Utils.Locators;
import contracts.IAuthenticationService;
import contracts.IEnvironmentService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.Properties;

public class LoginPage extends Locators {

	// WebDriver driver;
	Common common;
	Properties obj = new Properties();
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

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
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();

	}
	private void userLoginProcess(UserLoginRole loggedinUserRole) {
		UserCredential userCredential = authenticationService.getCredentials(loggedinUserRole,environmentName);

		common.log("Entering username: " + userCredential.getUsername());
		common.waitUntilElementToBeVisible(userNameField);
		common.findElement(userNameField).sendKeys(userCredential.getUsername());

		common.pause(10);
		common.log("Click on continue button");
		common.findElement(continueButton).click();
		common.pause(5);

		// If Use Password button display then click on that and then entering password
		if (common.isElementDisplayed(usePasswordButton)) {

			//	WebElement fieldPasswordHyperlink = common.findElement(usePasswordButton);
			common.log("Use password hyperlink appear");
			common.log("Click on Use password button");
			common.findElement(usePasswordButton).click();
		}
		common.pause(5);
		common.log("Entering password: " + userCredential.getPassword());
		common.findElement(PasswordField).sendKeys(userCredential.getPassword());
	}

	/**
	 * Open URL
	 *
	 */
	public void goToURL(String env) {

		String applicationUrl;
		common.log("Open the browser");
		environmentName = env;
		environmentService.getEnvironmentProperties(environmentName);
		common.log("Environment requested: " + environmentName);
		applicationUrl = getPropertyValue(env+"_url");
		common.log("Enter the URL: " + applicationUrl);
		driver.get(applicationUrl);
	}


	/**
	 * Verify Sign In Scenario
	 *
	 */
	public void initiator_SignIn() throws Exception{

		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon,"Click on profile icon").click();
			common.findElement(signOut).click();
			common.pause(10);
		}

		/**
		 * For ALl Environment
		 *
		 */
		userLoginProcess(UserLoginRole.INITIATOR);

		common.log("Click on login button");
		common.waitUntilElementToBeVisible(loginBtn);
		common.findElement(loginBtn).click();
		common.pause(10);

		//Wait for options after login to select QA Sandbox or Tenant 1 or Home page
		common.waitUntilElementToBeVisible(optionsAsPerEnv);

		//if SANDBOX env is there then select QA Sandbox option
		if (common.isElementDisplayed(qaSandboxOption))
		{
			//WebElement ele = driver.findElement(By.xpath("//p[normalize-space()='QA Sandbox']"));
			common.findElementBy(qaSandboxOption, "Click on QA sandbox").click();
		}

		//if QAR env is there then select Tenant 1 option
		if (common.isElementDisplayed(tenant1Option))
		{
			common.findElementBy(tenant1Option,"Select Tenant 1").click();
		}

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab,"verify Home page appear");
		common.log("Verify Env URL: " + driver.getCurrentUrl());
	}

	/**
	 * As a reviewer sign-in scenario
	 *
	 */
	public void reviewer_SignIn() {

		//Sign out the approver
		if (common.isDisplayed(profileIcon)) {
			common.pause(10);
			common.findElementBy(profileIcon,"Click on profile icon").click();
			common.findElement(signOut).click();
		}
		common.pause(5);
		common.waitUntilElementToBeVisible(userNameField);
		common.log("--- User login as reviewer credentials");

		userLoginProcess(UserLoginRole.REVIEWER);
		common.pause(5);
		common.log("click on login button");
		common.findElement(loginBtn).click();
		common.pause(5);

		//Wait for options after login to select QA Sandbox or Tenant 1 or Home page
		common.waitUntilElementToBeVisible(optionsAsPerEnv);

		//if SANDBOX env is there then select QA Sandbox option
		if (common.isElementDisplayed(qaSandboxOption))
		{
			common.findElementBy(qaSandboxOption, "Click on QA sandbox").click();
		}

		//if QAR env is there then select Tenant 1 option
		if (common.isElementDisplayed(tenant1Option))
		{
			common.findElementBy(tenant1Option,"Select Tenant 1").click();
		}
		common.waitUntilElementToBeVisible(homeTab);
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

		common.waitUntilElementToBeVisible(continueButton);
		common.findElement(continueButton).click();

		common.waitUntilElementToBeVisible(userPasswordLink);
		common.findElement(userPasswordLink).click();
		common.log("Entering password");

		common.waitUntilElementToBeVisible(nPasswordField);
		common.findElement(nPasswordField).sendKeys(getPropertyValue("password"));
		common.pause(10);
		common.log("click on login button");
		common.findElement(loginBtn).click();

		common.log("Click on QA");
		common.waitUntilElementToBeVisible(qaEnv);
		common.findElement(qaEnv).click();

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

		common.findElement(nPasswordField).sendKeys("Welcome@123");
		common.pause(10);

		common.log("click on login button");
		common.findElement(loginBtn).click();

		common.log("Click on PROD");
		common.waitUntilElementToBeVisible(prodEnv);
		common.findElement(prodEnv).click();
	}

}
