package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	public WebElement findElement(WebElement elementName) {


		String locator = getXPathFromWebElement(elementName);

		//locator = elementName;
		//WebElement ele = driver.findElement(By.xpath(elementName));
		highlightElement(elementName);
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
				} else if (locator.startsWith("//")||locator.startsWith("(//")) {
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
	public WebElement findElementBy(WebElement elementName, String msg) {

		String locator;

		log(msg);

		locator = getXPathFromWebElement(elementName);
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
		js.executeScript("arguments[0].style.border='3px solid yellow'", element);
	}
	public void highlightElementClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);
	}

	public void expandingHeadData() {

		driver.findElement(By.xpath(expandHeaderData.toString())).click();
		driver.findElement(By.xpath(expandPlantData.toString())).click();
		driver.findElement(By.xpath(expandPlant.toString())).click();
		driver.findElement(By.xpath(expandValuationData.toString())).click();

	}

	public void click(String locator) {

		driver.findElement(By.xpath(locator)).click();

	}

	public void click(WebElement locator) {

		driver.findElement(By.xpath(String.valueOf(locator))).click();

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
	public void jsClick(WebElement locator) {
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
	 * @param print Message/Log to be reported.
	 */
	public void log(String print) {
		String message = "Step :: "+print;
		if (message.startsWith("Step")) {
			String[] msg = message.split("::");
			Reporter.log("<br>" + msg[0].trim() + " " + BasePage.step + " : " + msg[1].trim());
			System.out.println(msg[0].trim() + " " + BasePage.step + " : " + msg[1].trim());
			BasePage.step++;
		} else {
			Reporter.log("<br>Message : " + message);
			System.out.println("Message : " + message);
		}
	}

	/**
	 * Get text in a given element.
	 *
	 * @param elementName Locator of element.
	 *
	 * @return text in given element.
	 */
	public String getText(WebElement elementName) {

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
	public String getValue(WebElement locator) {

		return this.findElement(locator).getAttribute("value");
	}

	/**
	 * Checks if given element is being displayed on page.
	 *
	 * @param elementName Locator of element. test the element present if mot
	 *                    contains the elemennts is ok
	 * @return true if displayed else false.
	 */
	public boolean isElementDisplayed(WebElement elementName) {

		WebElement webElement;
		try {
			webElement = driver.findElement(By.xpath(getXPathFromWebElement(elementName)));
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	public boolean isElementNotDisplayed(WebElement elementName) {
		WebElement webElement;
		try {
			webElement = this.findElement(elementName);
			return !webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayed(WebElement elementName) {
		try {
			driver.findElement(By.xpath(String.valueOf(elementName))).isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void waitForElement(WebElement webElement) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//String str = String.valueOf(selector);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getXPathFromWebElement(webElement))));

	}



	private String getXPathFromWebElement(WebElement webElement) {

		String sourceElement = webElement.toString();

		//Split your Source from "->"

		String[] tempArr = sourceElement.split("-> ");

		//Split your Source from ": "

		String[] tempXPathArr = tempArr[1].split(": ");

		//Access first index to get locator name

		String locatorName = tempXPathArr[0];

		//Access Second index to get locator value

		String locatorValue = tempXPathArr[1].substring(0,tempXPathArr[1].length()-1);

		return locatorValue;

	}
	public WebElement waitUntilElementToBeVisible(WebElement element) {
		return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
	}
	public WebDriverWait getWait() {
		// Set time in second to wait for elements
		return new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	/**
	 * Checks if element loaded in browser memory.
	 *
	 * @param locator Locator of element.
	 * @return true if loaded else false.
	 */
	public boolean isElementPresent(WebElement locator) {

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
	public void assertElementNotPresent(WebElement locator) {

		Assert.assertFalse(isElementPresent(locator));
	}

	/**
	 * Assertion to check that given element is present.
	 *
	 * @param locator Locator of element.
	 */
	public void assertElementPresent(WebElement locator) {

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
	public void scrollToElement(WebElement element) throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath(String.valueOf(element)));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(500);
	}

	/**
	 * Clears and type new value into given text-box.
	 *
	 * @param locator
	 *
	 * @param string  New text/value.
	 */
	public void type(WebElement locator, String string) {
		//	this.findElement(locator).clear();
		driver.findElement(By.xpath(getXPathFromWebElement(locator))).sendKeys(string);
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
