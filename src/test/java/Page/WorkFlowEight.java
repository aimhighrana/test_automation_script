package Page;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ServiceHelper.AuthenticationService;
import ServiceHelper.EnvironmentService;
import Utils.Common;
import Utils.Locators;
import contracts.IAuthenticationService;
import contracts.IEnvironmentService;

public class WorkFlowEight extends Locators {
	
	Common common;
	IAuthenticationService authenticationService;
	IEnvironmentService environmentService;

	public WorkFlowEight(WebDriver driver) throws Exception {
		super(driver);
		common = new Common(driver);
		PageFactory.initElements(this.driver, this);
		authenticationService = new AuthenticationService();
		environmentService = new EnvironmentService();
	}
	
	/**
	 * To Verify that function location is being created
	 * @throws IOException 
	 *
	 */
	public void verify_Functional_Location_is_Created() throws IOException {
		
		XSSFSheet sheet = common.getDataFromExcelSheet("Functional Location");

		common.waitUntilElementToBeVisible(homeTab);
		common.findElementBy(homeTab, "Click on Home tab").click();

		common.waitUntilElementToBeVisible(dataTab);
		common.findElementBy(dataTab, "Click on Data Tab").click();
		common.waitUntilElementToBeVisible(searchData);
		
		common.log("Search Functional Location");
		common.type(searchData, "Functional Location");
		common.waitUntilElementToBeVisible(buttonCreateFunctionLocation);
		common.findElementBy(buttonCreateFunctionLocation, "Click on Create Function Location").click();
		
		common.waitUntilElementToBeVisible(buttonNewRecord);
		common.findElementBy(buttonNewRecord, "Click on New Record Button").click();
		
		common.waitUntilElementToBeVisible(buttonCreateFunctionalLocation);
		common.findElementBy(buttonCreateFunctionalLocation, "Click on Create Functional Location").click();
		
		common.waitUntilElementToBeVisible(textFunctionalLocationLabel);
		common.findElement(textFunctionalLocationLabel).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		
		
		
		



	}

}
