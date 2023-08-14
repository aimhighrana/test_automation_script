package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utils.BasePage;
import Utils.Common;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.text.ParseException;

public class FlowCheck extends BasePage {


	/**
	 * Verify Flow tab design records
	 * s
	 * @throws InterruptedException
	 * @throws IOException
	 */

	@Test
	public void verifyFlow() throws InterruptedException, IOException {
	//	objectService().loginPage().goToURL(env);
		objectService().flow().check_Design_Table_Data();
	}
	@Test
	void verifyDescriptionChange() throws IOException, ParseException {
		objectService().loginPage().qaLogin();
		objectService().flow().checkDescriptionChange();
	}
	@Test
	void verifyDescriptionChangeProduction() throws IOException, ParseException {
		objectService().loginPage().prodLogin();
		objectService().flow().checkDescriptionChangeForProdEnv();
	}

}
