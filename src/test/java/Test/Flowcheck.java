package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utils.BasePage;
import Utils.Common;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.text.ParseException;

public class Flowcheck extends BasePage {

	public RemoteWebDriver driver;
	Common common = new Common(driver);

	/**
	 * Verify Flow tab design records
	 * s
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test
	public void verifyFlow() throws InterruptedException, IOException {
		loginPage.goToURL();
		test.log(LogStatus.INFO, "Navigated to URL");
		flow.check_Design_Table_Data();

	}

	@Test

	void verifyDescriptionChange() throws IOException, ParseException {
		loginPage.qaLogin();
		flow.checkDescriptionChange();

	}
	
	
	@Test

	void verifyDescriptionChangeProduction() throws IOException, ParseException {
		loginPage.prodLogin();
		flow.checkDescriptionChangeForProdEnv();

	}


}
