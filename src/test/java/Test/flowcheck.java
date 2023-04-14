package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.Test;
import Page.LoginPage;
import Page.flow;
import Utils.BasePage;
import Utils.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;

public class flowcheck extends BasePage {

	public RemoteWebDriver driver;
	Common common = new Common(driver);

	/**
	 * Verify flow tab design records
	 * s
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test
	public void verifyFlow() throws InterruptedException, IOException {
		loginPage.goToURL();
		test.log(LogStatus.INFO, "Navigated to URL");
		Flow.checkdesignTBLData();

	}

	@Test

	void verifyDescriptionChange() throws IOException, ParseException {
		loginPage.qaLogin();
		Flow.checkDescriptionChange();

	}
	
	
	@Test

	void verifyDescriptionChangeProduction() throws IOException, ParseException {
		loginPage.prodLogin();
		Flow.checkDescriptionChangeForProdEnv();

	}


}
