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
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test
	public void Loginpage() throws InterruptedException, IOException {
		loginPage.GotoURL();
		loginPage.Check_SignIn();

	}

}
