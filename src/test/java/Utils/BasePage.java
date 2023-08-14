package Utils;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Page.AddMaterialMaster;
import Page.Flow;
import Page.HomePage;
import Page.ListPageSearch;
import Page.ListView;
import Page.LoginPage;
import Page.MaterialCreation;
import Page.ProcessLog;
import ServiceHelper.ObjectService;
import Utils.Enums.BrowserOption;
import contracts.IObjectService;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.rcarz.jiraclient.JiraException;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
public class BasePage implements ITestListener {

	static Properties configProperties = null;

	protected WebDriver driver;
	public static String currentTest; // current running test
	protected static String environmentName = "";
	protected static String test_data_folder_path = null;

	// screen-shot folder
	protected static String screenshot_folder_path = null;
	protected static Logger logger = Logger.getLogger("testing");
	
	public static ExtentTest test;
	public static ExtentReports report;

	private IObjectService objectService;

	public IObjectService objectService() {
		return objectService;
	}

	private void initializeObjects(WebDriver webDriver) throws Exception {		
		objectService = new ObjectService(webDriver);
	}

	private WebDriver getWebDriver(String browserOption, String headless) {
		WebDriver webDriver = null;
		// Run test against chrome browser
		if (browserOption.equals(BrowserOption.CHROME.toString())) {

			ChromeOptions options = new ChromeOptions();
			if (headless.equals("true")) {
				// Run browser in headless mode
				options.addArguments("--headless");
			}
			options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("−−incognito"); // open browser in InCognito mode

			webDriver = new ChromeDriver(options);
		}
		return webDriver;
	}
	
	public static int step = 0;

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws Exception {
		allureEnvironmentWriter(
				ImmutableMap.<String, String>builder().put("User", "Rahul Sharma").put("platform Name", "MAC OS").put("Browser",getPropertyValue("browser")).build(),
				System.getProperty("user.dir") + "/allure-results/");
		currentTest = method.getName(); // get Name of current test.
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		// create folder for storing screenshot
		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();

		// fetch data from config.properties
		String driverPath = getPropertyValue("driverPath");
		String browser = getPropertyValue("browser");
		String headless = getPropertyValue("headless");


		// it will fetch chromedriver from your system
		WebDriverManager.chromedriver().setup();

		driver = getWebDriver(browser, headless);
		initializeObjects(driver);

		// MyScreenRecorder.startRecording(currentTest);
	}

	protected Properties getConfigProperties() {
		if (configProperties == null) {
			configProperties = this
					.loadProperties(Paths.get("").toAbsolutePath().normalize().toString() + "//config.properties");
		}
		return configProperties;
	}

	protected Properties getConfigPropertiesForEnvironment(String propertyFilePath) {
		configProperties = this
				.loadProperties(Paths.get("").toAbsolutePath().normalize().toString() + propertyFilePath);
		return configProperties;
	}

	protected String getPropertyValue(String value) {
		Properties properties = getConfigProperties();
		return properties.getProperty(value);
	}

	private Properties loadProperties(String filePath) {
		File file = new File(filePath);
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties properties = new Properties();

		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	/**
	 * After Method {TearDown}
	 * 
	 * @param testResult
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws JiraException
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws Exception {
		String testName = testResult.getName();
		Reporter.setCurrentTestResult(testResult);
		File img = new File("target" + File.separator + "test-output" + File.separator + testName + ".png");
		if (testResult.getStatus() == 1) {
			log("<font color = 'green'><b><i><u><br>Pass :: " + testResult.getName() + "</u></i></b></font>");
			testResult.getThrowable();
		}
		if (testResult.getStatus() == 2) {
			log("<font color = 'red'><b><i><u><br>Fail :: " + testResult.getName() + "</u></i></b></font>");

			makeScreenshot(driver, testName);
			Reporter.log("Failed : This is failed log from reporter.log" + "<br>", true);
			FileOutputStream screenshotStream = new FileOutputStream(img);
			screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			log("<a target='blank' href='" + testName + ".png'> <img  src='" + testName
					+ ".png' height='250' width='500'></img> </a>" + "<br>");
		}
		Properties properties = getConfigProperties();
		String strCount = getPropertyValue("runCount");
		int i = Integer.parseInt(strCount)+1;
		String count = String.valueOf(i);
		log("count: "+count);
		FileInputStream fis = new FileInputStream("config.properties");
		properties.load(fis);
		fis.close();

		properties.setProperty("runCount", count);
		// Save the updated properties to the file
		FileOutputStream fos = new FileOutputStream("config.properties");
		properties.store(fos, null);
		fos.close();

		String strCount1 = getPropertyValue("runCount");
		int i1 = Integer.parseInt(strCount1);
		log("count1: "+i1);
		// Save the updated properties to the file, preserving comments

		step =0;
		driver.manage().deleteAllCookies();
		driver.quit();
		// MyScreenRecorder.stopRecording();
	}

	public void makeScreenshot(WebDriver driver, String screenshotName) {

		WebDriver augmentedDriver = new Augmenter().augment(driver);
		// Take a screenshot
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		// Copy screenshot to specific folder
		try {
			String reportFolder = "target" + File.separator + "test-output" +File.separator + "FailedScreenshot" +File.separator;
			File screenshotFolder = new File(reportFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			this.log("Failed to capture screenshot: " + e.getMessage());
		}
	}
	
	public void log(String log) {
		System.out.println(log);
		Reporter.log("<font color = 'blue'><b><i><u><br>" + log + "</u></i></b></font>");
	}
}
