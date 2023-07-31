package Test;

import Page.LoginPage;
import Utils.BasePage;
import Utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginPageTestcases extends BasePage {
//    public LoginPageTestcases(WebDriver d) {
//		super(d);
//		// TODO Auto-generated constructor stub
//	}

	public RemoteWebDriver driver;
	Common common = new Common(driver);

	/**
	 * Login Module
	 * 
	 * @throws IOException
	 */
	@Test
	@Parameters({"env","testCaseId"})
	public void loginPage(String env, String testCaseId) throws InterruptedException, IOException, Exception {
		//log("Testcase:QAA-TC-91");
		log("Testcase:"+testCaseId);
		loginPage.goToURL(env);
		loginPage.initiator_SignIn(env);
	}
}
