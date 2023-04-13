package Utils;

import Page.AddMaterialMaster;
import Page.LoginPage;
import Page.flow;
import Test.MaterialMasterTestcases;
import Test.flowcheck;
import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.ILoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;
import com.itextpdf.html2pdf.HtmlConverter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import javax.mail.MessagingException;
import javax.swing.text.AbstractDocument;

public class BasePage implements ITestListener {


	static Properties configProperties = null;
	static Properties xpathProperties = null;


	protected RemoteWebDriver driver;
	private Common common;
	public static String currentTest; // current running test
	protected String seleniumHub; // Selenium hub IP
	protected String seleniumHubPort; // Selenium hub port
	protected String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;

	// screen-shot folder
	protected static String screenshot_folder_path = null;
	protected static Logger logger = Logger.getLogger("testing");
	public LoginPage loginPage;
	public AddMaterialMaster materialmaster;
	public flow Flow;
	public MaterialMasterTestcases materialMasterTestcases;
	public Locators locators;
	public static ExtentTest test;
	public static ExtentReports report;
	protected static ThreadLocal<RemoteWebDriver> driver1 = new ThreadLocal<>();

	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method) throws MalformedURLException, FileNotFoundException {

		report = new ExtentReports(("user.dir") + "ExtentReportResults.html", true);

		currentTest = method.getName(); // get Name of current test.

		test = report.startTest((this.getClass().getSimpleName() + "::" + method.getName()));
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();

		DesiredCapabilities capability = null;

		String driverPath = getPropertyValue("driverPath");
		String driverFirefoxPath = getPropertyValue("driverFirefoxPath");
		String browser = getPropertyValue("browser");
		String headless = getPropertyValue("headless");

		//String url = getPropertyValue("url");
	    URL url = new URL("http://172.30.88.217:4444/wd/hub");

	            ChromeOptions options = new ChromeOptions();
	            driver = new RemoteWebDriver(url, options);
	            driver.manage().window().maximize();

// 			Mac Path
//        System.setProperty("webdriver.chrome.driver",driverPath);

//			Windowd Path
//			System.setProperty("webdriver.chrome.driver",
//					"C://Users//baps//Documents//chromedriver.exe");

// 			THis for windows
//			ChromeOptions chromeOptions = new ChromeOptions();

		// this is for headless browser code
//			chromeOptions.addArguments("headless");

//			driver = new ChromeDriver(chromeOptions);

//			this for mac to open chrome
//		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver", driverPath);
//			// WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
////			options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
//		//	options.addArguments("-lang= sl");
//			if (headless.equals("true")) {
//				options.addArguments("--headless");
//
//				// options.addArguments("--headless");
//				options.addArguments("window-size=1536x768");
//				// options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
//			}
//		//	options.addArguments("--no-sandbox");
//		//	options.addArguments("--disable-dev-shm-usage");
//			//options.addArguments("--remote-allow-origins=*");
////			DesiredCapabilities cap = new DesiredCapabilities();
////			cap.setBrowserName("chrome");
//			 String remote_url_chrome = "http://localhost:4444/wd/hub";
//
//			options.addArguments("--headless");
//			
//			driver = new RemoteWebDriver(new URL(remote_url_chrome),options);
//		//	driver1.set(new RemoteWebDriver(new URL(remote_url_chrome), options));
//			
//		//	driver = new ChromeDriver(options);
//			//driver1.set("https://fuse-int.masterdataonline.com/ngx-auth/en/index.html#/auth/Marcusone/enter-username");
//			driver.get("https://fuse-int.masterdataonline.com/ngx-auth/en/index.html#/auth/Marcusone/enter-username");
//		} else if (browser.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", driverFirefoxPath);
//			// WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//
//		else if (browser.equals("safari")) {
//
//			driver = new SafariDriver();
//
//		}
//
//		if (!headless.equals("true")) {
//			driver.manage().window().maximize();
//			// driver.manage().window().fullscreen();
//		}

//			driver.manage().window().maximize();

		loginPage = new LoginPage(driver);
		materialmaster = new AddMaterialMaster(driver);
		Flow = new flow(driver);
	}

	protected Properties getConfigProperties() {
		if (configProperties == null) {
			configProperties = this.loadProperties(
					Paths.get("src/test/java/Config").toAbsolutePath().normalize().toString() + "//config.properties");

		}
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
	 * @param testResult
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws JiraException
	 * @throws EmailException
	 * @throws MessagingException
	 */
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException {
		String testName = testResult.getName();
		Reporter.setCurrentTestResult(testResult);
		File img = new File("target" + File.separator + "surefire-reports" + File.separator + testName + ".png");
		if (testResult.getStatus() == 1) {
			log("PASS : " + testResult.getName() + "\n");
			testResult.getThrowable();
		}
		if (testResult.getStatus() == 2) {
			log("FAIL : " + testResult.getName() + "\n");
		//	makeScreenshot(driver, testName);
		//	Reporter.log("Failed : This is failed log from reporter.log" + "<br>", true);
		//	FileOutputStream screenshotStream = new FileOutputStream(img);
		//	screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		//	log("<a target='blank' href='" + testName + ".png'> <img  src='" + testName
		//			+ ".png' height='250' width='500'></img> </a>" + "<br>");
		}
		driver.quit();
	}

	public void makeScreenshot(WebDriver driver, String screenshotName) {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		// Take a screenshot
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		String nameWithExtention = screenshotName + ".png";
		// Copy screenshot to specific folder
		try {
			String reportFolder = "target" + File.separator + "surefire-reports" + File.separator;
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
		Reporter.log(log + "<br>");
	}
}
