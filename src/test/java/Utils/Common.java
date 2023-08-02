package Utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;

/**
 * Define Common Webdriver
 * 
 * @author Rahul
 */
public class Common extends Locators {

	Date date = new Date();
	protected Wait<WebDriver> wait;
	// protected WebDriver driver;

	public Common(WebDriver driver) {

		super(driver);
	}

	/**
	 * Find web-element for given locator.
	 * 
	 * @param elementName
	 * @return
	 */
	public WebElement findElement(String elementName) {

		String locator;

		locator = elementName;
		WebElement ele = driver.findElement(By.xpath(locator));
		highlightElement(ele);
		int count = 0;
		while (count < 4) {
			try {
				if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
					locator = locator.substring(5); // remove "link=" from
													// locator
					try {
						if (locator.contains(" "))
							return driver.findElement(By.partialLinkText(locator));

						return driver.findElement(By.linkText(locator));
					} catch (Exception e) {
						return null;
					}
				}
				if (locator.startsWith("id=")) {
					locator = locator.substring(3); // remove "id=" from locator
					try {
						return driver.findElement(By.id(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("//")) {
					try {
						return driver.findElement(By.xpath(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("css=")) {

					locator = locator.substring(4); // remove "css=" from
													// locator
					try {
						return driver.findElement(By.cssSelector(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("name=")) {

					locator = locator.substring(5); // remove "name=" from
													// locator
					try {
						return driver.findElement(By.name(locator));
					} catch (Exception e) {
						return null;
					}
				} else {
					try {
						return driver.findElement(By.id(locator));
					} catch (Exception e) {
						return null;
					}

				}
			} catch (StaleElementReferenceException e) {
				e.toString();

				count = count + 1;
				// System.out.println("Trying["+
				// count+"] to recover from a stale element :" +
				// e.getMessage());

			}
			count = count + 4;
		}

		return null;

	}

	public WebElement findElementBy(String elementName, String msg) {

		String locator;

		System.out.println("Step :: " + msg + "\n");
		log(msg);

		locator = elementName;
		WebElement ele = driver.findElement(By.xpath(locator));
		highlightElement(ele);

		int count = 0;
		while (count < 4) {
			try {
				if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
					locator = locator.substring(5); // remove "link=" from
					// locator
					try {
						if (locator.contains(" "))
							return driver.findElement(By.partialLinkText(locator));

						return driver.findElement(By.linkText(locator));
					} catch (Exception e) {
						return null;
					}
				}
				if (locator.startsWith("id=")) {
					locator = locator.substring(3); // remove "id=" from locator
					try {
						return driver.findElement(By.id(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("//") || locator.startsWith("(//")) {
					try {
						return driver.findElement(By.xpath(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("css=")) {

					locator = locator.substring(4); // remove "css=" from
					// locator
					try {
						return driver.findElement(By.cssSelector(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("name=")) {

					locator = locator.substring(5); // remove "name=" from
					// locator
					try {
						return driver.findElement(By.name(locator));
					} catch (Exception e) {
						return null;
					}
				} else {
					try {
						return driver.findElement(By.id(locator));
					} catch (Exception e) {
						return null;
					}

				}
			} catch (StaleElementReferenceException e) {
				e.toString();

				count = count + 1;
				// System.out.println("Trying["+
				// count+"] to recover from a stale element :" +
				// e.getMessage());

			}
			count = count + 4;
		}

		return null;

	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
	}

	public void expandingHeadData() {

		driver.findElement(By.xpath(expandHeaderData)).click();
		driver.findElement(By.xpath(expandPlantData)).click();
		driver.findElement(By.xpath(expandPlant)).click();
		driver.findElement(By.xpath(expandValuationData)).click();

	}

	public void click(String locator) {

		driver.findElement(By.xpath(locator)).click();

	}

	public void dismissAlert() {

		pause(4);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

	}

	public String acceptAlert1() {

		pause(4);
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();

		alert.accept();
		return alerttext;
	}

	/**
	 * Refresh Page
	 * 
	 */
	public void refreshPage() {

		driver.navigate().refresh();
	}

	/**
	 * Current Date to Tomorrow's Date
	 * 
	 * @throws ParseException
	 * 
	 */
	public String currentDate() throws ParseException {

		Date dateNow = new Date();
		SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("dd/MM/yyyy"); // Date
																					// Format
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		String untildate = date_to_string; // Current Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Format

		return untildate;

	}

	/**
	 * Clicks on visible or not visible element.
	 *
	 */
	public void jsClick(String locator) {
		WebElement element = this.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		js.executeScript("return arguments[0].click();", element);
		pause(10);
	}

	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg Message/Log to be reported.
	 */
	public void log(String msg) {
		System.out.println("Step :: " + msg);
		Reporter.log("<br>Step :: " + msg);
	}

	public void log(LogStatus logStatus, String msg) {
		System.out.println("Step :: " + msg);
		Reporter.log("<br>Step :: " + msg);
		test.log(logStatus, msg);
	}

	/**
	 * Get text in a given element.
	 * 
	 * @param elementName Locator of element.
	 * 
	 * @return text in given element.
	 */
	public String getText(String elementName) {

		String text;

		try {
			text = this.findElement(elementName).getText();

		} catch (Exception e) {

			text = "Element was not found";
		}

		return text;
	}

	public void open(String url) {

		driver.get(url);
	}

	/**
	 * Get value of given element dynamically.
	 * 
	 * @param locator Locator of element.
	 * 
	 * @return Dynamic value.
	 */
	public String getValue(String locator) {

		return this.findElement(locator).getAttribute("value");
	}

	/**
	 * Checks if given element is being displayed on page.
	 * 
	 * @param elementName Locator of element. test the element present if mot
	 *                    contains the elemennts is ok
	 * @return true if displayed else false.
	 */
	public boolean isElementDisplayed(String elementName) {

		WebElement webElement;
		try {
			webElement = this.findElement(elementName);
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementNotDisplayed(String elementName) {

		WebElement webElement;
		try {
			webElement = this.findElement(elementName);
			return !webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayed(String elementName) {
		try {
			driver.findElement(By.xpath(elementName)).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Wait till given element is present.
	 * 
	 * @param locator Locator of element.
	 */
	public void waitForConditionIsElementPresent(String locator) {

		for (int second = 0;; second++) {
			if (second >= 10) {
				break;
			}

			try {
				if (isElementPresent(locator))
					break;
			} catch (Throwable failure) {
			}

			pause(30);
		}

	}

	public void waitForElement(String selector) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
	}

	/**
	 * Checks if element loaded in browser memory.
	 * 
	 * @param locator Locator of element.
	 * @return true if loaded else false.
	 */
	public boolean isElementPresent(String locator) {

		WebElement webElement = this.findElement(locator);
		if (webElement != null) {
			return true;
		} else {

			return false;
		}
	}

	public boolean existsElement(String xpath) {
		try {
			driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	/**
	 * Assertion to check that given element is not present.
	 * 
	 * @param locator Locator of element.
	 */
	public void assertElementNotPresent(String locator) {

		Assert.assertFalse(isElementPresent(locator));
	}

	/**
	 * Assertion to check that given element is present.
	 * 
	 * @param locator Locator of element.
	 */
	public void assertElementPresent(String locator) {

		Assert.assertTrue(isElementPresent(locator));
	}

	/**
	 * Pauses for given seconds.
	 * 
	 * @param secs
	 */
	public void pause(int secs) {
		try {
			Thread.sleep(secs * 200);
		} catch (InterruptedException interruptedException) {
		}
	}

	/**
	 * Clears and type new value into given text-box.
	 * 
	 * @param locator
	 * 
	 * @param string  New text/value.
	 */
	public void type(String locator, String string) {

		// this.findElement(locator).clear();
		driver.findElement(By.xpath(locator)).sendKeys(string);

	}

	public String generateRandomChars(int length) {
		return RandomStringUtils.randomAlphabetic(length).toLowerCase();
	}

	public void assertTwoValuesAreEqual(Object value1, Object value2) {
		Assert.assertEquals(value1, value2);
	}

	public void assertTwoValuesAreNotEqual(Object value1, Object value2) {

		Assert.assertNotEquals(value1, value2);
	}

}
