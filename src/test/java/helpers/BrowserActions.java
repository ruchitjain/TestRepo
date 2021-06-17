
package helpers;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class BrowserActions {
	public WebDriver driver;
	public JavascriptExecutor jse;
	public Reporting report;
	public WebDriverWait wait;
	public Actions actions;

	public BrowserActions(WebDriver driver, Reporting report) {
		this.driver = driver;
		this.report = report;
		actions = new Actions(driver);
		jse = (JavascriptExecutor) driver;
	}

	// Wait for Page Load
	public void WaittoPageLoad() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void staticWait(int seconds) {
		for (int i = 1; i <= seconds; i++) {
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Click on Web Element
	public boolean click(WebElement element) throws Exception {
		boolean clicked = false;
		try {
			element.click();
			clicked = true;
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Perform Click",
					"Click Operation Failed - Exception Generated - " + e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");

		}
		return clicked;
	}

	// Click on Web Element and log step in report
	public boolean click(WebElement element, String imagePath, String message) throws Exception {
		boolean clicked = false;
		try {
			element.click();
			clicked = true;
			report.logStepToReport(LogStatus.INFO, "Perform Click", message, imagePath);
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "Perform Click",
					"Click Operation Failed - Exception Generated - " + e.getMessage().split("Session info:")[0],
					report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	// Click on Web Element using Action Class
	public boolean clickAction(WebElement element) throws Exception {
		boolean clicked = false;
		try {
			actions.moveToElement(element).click().build().perform();
			clicked = true;
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "Perform Click",
					"Click Operation Failed - Exception Generated -" + e.getMessage().split("Session info:")[0],
					report.imagePath);

			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	// Click on Web Element using Action Class and log step in report
	public boolean clickAction(WebElement element, String imagePath, String message) throws Exception {
		boolean clicked = false;
		try {
			actions.moveToElement(element).click().build().perform();
			clicked = true;
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath);
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "CICK NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	// Double Click on Web Element using Action Class
	public boolean doubleclickAction(WebElement element) throws Exception {

		boolean clicked = false;

		try {
			actions.doubleClick(element).build().perform();
			clicked = true;
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "CICK NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	public boolean click_noQuit(WebElement element) throws Exception {

		boolean clicked = false;
		try {
			element.click();
			clicked = true;
		} catch (Exception e) {

			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	// Double Click on Web Element using Action Class and log step in report
	public boolean doubleclickAction(WebElement element, String imagePath, String message) throws Exception {
		boolean clicked = false;

		try {
			actions.doubleClick(element).build().perform();
			clicked = true;
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath);
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "CICK NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	// Click on Web Element using JavaScriptExecuter
	public boolean clickJS(WebElement element) throws Exception {
		boolean clicked = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			clicked = true;
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "CICK NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	// Click on Web Element using JavaScriptExecuter and log step in report
	public boolean clickJS(WebElement element, String imagePath, String message) throws Exception {
		boolean clicked = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			clicked = true;
			report.logStepToReport(LogStatus.INFO, "Perform Click", message, imagePath);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Perform Click Operation Failed",
					"Exception Generated as - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	public boolean Submit(WebElement element) throws Exception {
		boolean submited = false;
		try {
			element.submit();
			submited = true;
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "SUBMIT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return submited;
	}

	public boolean Submit(WebElement element, String imagePath, String message) throws Exception {
		boolean submited = false;
		try {
			element.submit();
			submited = true;
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath);
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "SUBMIT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return submited;
	}

	// Get text of Web element
	public String getText(WebElement element) throws Exception {
		String elementText = null;
		try {
			elementText = element.getText();
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Get Text of Element",
					"Get Text Operation Failed - Exception Generated - " + e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			// quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return elementText;
	}

	// Get text of Web element
	public String getSelectedOptionFromSelect(WebElement element) throws Exception {
		String elementText = null;
		try {
			Select select = new Select(element);
			elementText = select.getFirstSelectedOption().getText();
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Get First Selected Option of Select",
					"Get First Selected Option-  Operation Failed - Exception Generated - "
							+ e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			// quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return elementText;
	}

	// Set Text of Web element
	public boolean setText(WebElement element, String value) throws Exception {
		boolean settext = false;
		try {
			element.clear();
			element.sendKeys(value);
			settext = true;
			report.logStepToReport(LogStatus.INFO, "Clear Element & Set Text",
					"Element Value Successfully Set as : " + value, "");
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "Clear Element & Set Text",
					"Clear Element & Set Text Operation failed - Exception Generated - "
							+ e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return settext;
	}

	// Set Text of Web element and log step in report
	public boolean setText(WebElement element, String value, String imagePath, String message) throws Exception {
		boolean settext = false;
		try {
			element.clear();
			element.sendKeys(value);
			settext = true;
			report.logStepToReport(LogStatus.INFO, "Clear and Set Text", message, imagePath);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Set Text Operation Failed",
					"Exception Generated as - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return settext;
	}

	// Set Text of Web element using java script executor
	public boolean setTextJS(WebElement element, String value, String imagePath, String message) throws Exception {
		boolean settext = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
			settext = true;
			report.logStepToReport(LogStatus.INFO, "Input", message, imagePath);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "SET TEXT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
			// driver.quit();
		}
		return settext;
	}

	// Set Text of Web element using java script executor
	public boolean sendKeys(WebElement element, Keys key) {
		boolean sendkey = false;
		try {
			element.sendKeys(key);
			sendkey = true;
		} catch (Exception e) {
			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
		return sendkey;
	}

	// Scroll to WebElement using JS
	public boolean scrollToElementUsingJS(WebElement element) {
		boolean scroll = false;
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			scroll = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scroll;
	}

	// Scroll to WebElement using Actions
	public boolean scrollToElementUsingActions(WebElement element) {
		boolean scroll = false;
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			scroll = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scroll;
	}

	// Wait for Web Element visibility and log step in report if element is not
	// visible
	public void waitForElementVisibility(WebElement element) {
		try {
			wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
	}

	public void waitForElementPresence(String xPATH) {

		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPATH)));
		} catch (Exception e) {
			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
	}

	public boolean waitForElementClickable(WebElement element) throws Exception {
		boolean clickable = false;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			clickable = true;
		} catch (Exception e) {
			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
		return clickable;
	}

	// Select value from Drop Down & log step in report
	public boolean selectFromDD(WebElement element, String value, String imagePath, String message) throws Exception {
		boolean selected = false;
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			selected = true;
			report.logStepToReport(LogStatus.INFO, "Select from Select Dropdown", message, imagePath);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Select from Select Dropdown",
					"Select from Select Dropdown Operation failed - Exception Generated - "
							+ e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return selected;
	}

	// Select value from Drop Down & log step in report
	public boolean selectFromDD(WebElement element, Map<String, String> testData, String zipCodeValue, String cityValue,
			String imagePath, String message) throws Exception {
		boolean selected = false;

		try {
			Select select = new Select(element);
			List<WebElement> elements = select.getOptions();
			String valueToSelect = "";
			for (WebElement e : elements) {
				if (testData.get("Zipcode_Flag").equalsIgnoreCase("Yes")
						&& testData.get("city_flag").equalsIgnoreCase("Yes") && e.getText().contains(zipCodeValue)
						&& e.getText().contains(cityValue)) {
					valueToSelect = e.getText();
					break;
				} else if (testData.get("Zipcode_Flag").equalsIgnoreCase("Yes")
						&& testData.get("city_flag").equalsIgnoreCase("No") && e.getText().contains(zipCodeValue)) {
					valueToSelect = e.getText();
					break;
				} else if (testData.get("Zipcode_Flag").equalsIgnoreCase("No")
						&& testData.get("city_flag").equalsIgnoreCase("Yes") && e.getText().contains(cityValue)) {
					valueToSelect = e.getText();
					break;
				}
			}

			select.selectByVisibleText(valueToSelect);
			selected = true;
			report.logStepToReport(LogStatus.INFO, "Select from Select Dropdown", message, imagePath);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Select from Select Dropdown",
					"Select from Select Dropdown Operation failed - Exception Generated - "
							+ e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return selected;
	}

	// Select value from Drop Down using Java script executor & log step in report
	public boolean selectFromDDJS(WebElement element, String value, String imagePath, String message) throws Exception {
		boolean selected = false;
		try {
			((JavascriptExecutor) driver).executeScript(
					"var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }",
					element, value);
			selected = true;
			report.logStepToReport(LogStatus.INFO, "Select from Select Dropdown", message, imagePath);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Select from Select Dropdown",
					"Select from Select Dropdown Operation Failed - Exception Generated as - "
							+ e.getMessage().split("Session info:")[0],
					report.imagePath);
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return selected;
	}

	// Select value from Drop Down using Java script executor, based on index & log
	// step in report
	public boolean selectByIndexFromDDJS(WebElement element, int index, String imagePath, String message)
			throws Exception {
		boolean selected = false;
		try {
			((JavascriptExecutor) driver).executeScript(
					"var select = arguments[0]; select.options[arguments[1]].selected = true; ", element,
					String.valueOf(index));
			selected = true;
			report.logStepToReport(LogStatus.INFO, "Select", message, imagePath);

		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return selected;
	}

	// Check for presence of alert on web page
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			Ex.printStackTrace();
			return false;
		} catch (Exception Ex) {
			Ex.printStackTrace();
			return false;
		}
	}

	public boolean clickonAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (NoAlertPresentException Ex) {
			Ex.printStackTrace();
			return false;
		} catch (Exception Ex) {
			Ex.printStackTrace();
			return false;
		}
	}

	// Check for presence of web element
	public boolean isElementPresent(WebElement element, int timeout) {
		boolean presence = false;
		for (int i = 0; i < timeout; i++) {
			try {
				Thread.sleep(1000);
				presence = element.isEnabled() || element.isDisplayed();
				if (presence) {
					return presence;
				}
			} catch (Exception Ex) {
				Ex.printStackTrace();
			}
			System.err.println("Timeout Exception for element -" + Thread.currentThread().getStackTrace());
		}
		return presence;
	}

	// Select value from a list
	public boolean selectValueFromList_JSClick(List<WebElement> elements, String valuetoselect, String imagePath,
			String details) throws Exception {

		boolean IsValueSelected = false;
		try {
			for (WebElement element : elements) {
				if (element.getText().contains(valuetoselect)) {
					clickJS(element);
					IsValueSelected = true;
					report.logStepToReport(LogStatus.INFO, "Select", valuetoselect + " selected", imagePath);
					break;
				}
			}
		} catch (Exception e) {

			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return IsValueSelected;
	}

	public boolean selectValueFromList(List<WebElement> elements, String valuetoselect, String imagePath,
			String message) throws Exception {
		boolean IsValueSelected = false;
		try {
			for (WebElement e : elements) {
				if (e.getText().contains(valuetoselect)) {
					e.click();
					IsValueSelected = true;
					report.logStepToReport(LogStatus.INFO, "Select", valuetoselect + " selected", imagePath);
					break;
				}
			}
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return IsValueSelected;
	}

	public boolean selectFromList_JSClick(List<WebElement> elist, String textToselect1, String textToselect2,
			String imagePath, String message) throws Exception {
		boolean isselected = false;
		try {
			for (int i = 0; i < elist.size(); i++) {
				System.out.println(elist.get(i).getText());
				if (elist.get(i).getText().contains(textToselect1) && elist.get(i).getText().contains(textToselect2)) {
					clickJS(elist.get(i));
					report.logStepToReport(LogStatus.INFO, "Select", textToselect1 + " selected", imagePath);
					isselected = true;
					break;
				}
			}
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return isselected;
	}

	public boolean selectFromList(List<WebElement> elist, String textToselect1, String textToselect2, String imagePath,
			String message) throws Exception {
		boolean isselected = false;
		try {
			for (int i = 0; i < elist.size(); i++) {
				System.out.println(elist.get(i).getText());
				if (elist.get(i).getText().contains(textToselect1) && elist.get(i).getText().contains(textToselect2)) {
					clickJS(elist.get(i));
					report.logStepToReport(LogStatus.INFO, "Select", textToselect1 + " selected", imagePath);
					isselected = true;
					break;
				}
			}
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return isselected;
	}

	public boolean selectFromList(List<WebElement> e, String textToselect1, String textToselect2, String imagePath,
			String message, String countrycode) throws Exception {
		boolean isselected = false;
		try {
			for (int i = 1; i < e.size(); i++) {
				System.out.println(i);
				System.out.println(e.get(i).getText());
				if ((e.get(i).getText().contains(textToselect1)) && (e.get(i).getText().contains(textToselect2))) {
					clickJS(e.get(i));
					report.logStepToReport(LogStatus.INFO, "Select", textToselect1 + " selected", imagePath);
					isselected = true;
					break;
				} else if ((e.get(i).getText().contains(textToselect1)) && countrycode.equalsIgnoreCase("HK")) {
					clickJS(e.get(i));
					report.logStepToReport(LogStatus.INFO, "Select", textToselect1 + " selected", imagePath);
					isselected = true;
					break;
				}
			}
		} catch (Exception ex) {
			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + ex.getMessage().split("Session info:")[0], report.imagePath);

			ex.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}

		return isselected;
	}

	public void mouseHoverOnElementUsingActions(WebElement element, String imagePath, String message) throws Exception {
		try {
			actions = new Actions(driver);
			actions.moveToElement(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
			// quitBrowser();
			// throw new Exception("Test Case Failed");
		}
	}

	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	public String getCurrentURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String navigateToCurrentURLwithBasicAuthentication(String authenticationID, String authenticationPass) {

		String url = driver.getCurrentUrl().replace("https://", "");
		url = "https://" + authenticationID + ":" + authenticationPass + "@" + url;
		driver.navigate().to(url);
		return url;
	}

	public void getURL(String url) {
		driver.get(url);
		;
	}

	public void pageRefresh() {
		driver.navigate().refresh();
	}

	public void wait(int n) {
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		} while (t1 - t0 < n);
	}

	public boolean isElementPresent(WebElement element) {
		boolean flag = false;
		driver.manage().timeouts().implicitlyWait(1l, TimeUnit.SECONDS);
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			flag = false;
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			flag = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		return flag;
	}

	public void selectFromList_FirefoxUsingRobot(WebElement element, List<WebElement> e, String textToselect,
			String page, String imagePath, String message) throws Exception {

		click(element, imagePath, message);
		wait(2000);
		for (int i = 0; i < e.size(); i++) {
			if ((e.get(i).getText().contains(textToselect))) {
				try {
					Robot rb = new Robot();
					for (int k = 0; k < i; k++) {
						rb.keyPress(KeyEvent.VK_DOWN);
						wait(500);
					}
					rb.keyRelease(KeyEvent.VK_DOWN);
					wait(1000);
					rb.keyPress(KeyEvent.VK_ENTER);
					wait(1000);
					rb.keyRelease(KeyEvent.VK_ENTER);
				} catch (Exception ex) {
				}
				break;
			}
		}
	}

	public boolean selectFromList(WebElement element, List<WebElement> e, String textToselect, String imagePath,
			String message) throws Exception {
		boolean select = false;
		try {
			element.click();

			for (int i = 0; i < e.size(); i++) {
				if ((e.get(i).getText().contains(textToselect))) {
					e.get(i).click();
					select = true;
					report.logStepToReport(LogStatus.INFO, "Select from List of Elements(Dropdown)", message,
							imagePath);
					break;
				}
			}

			if (select == false) {
				report.logStepToReport(LogStatus.FAIL, "Select from List of Elements(Dropdown)",
						"Select from List of Elements(Dropdown) Operation Failed - " + textToselect
								+ " text not found in List",
						report.imagePath);
			}

		} catch (Exception ex) {

			report.logStepToReport(LogStatus.FAIL, "Select from List of Elements(Dropdown)",
					"Select from List of Elements(Dropdown) Operation Failed - Exception Generated as - "
							+ ex.getMessage().split("Session info:")[0],
					report.imagePath);

			ex.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return select;
	}

	public boolean mouseHoverJScript(WebElement HoverElement) throws Exception {
		boolean mousehover = false;
		try {
			if (isElementPresent(HoverElement)) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
				mousehover = true;
			} else {
				System.out.println("Element was not visible to hover " + "\n");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(
					"Element with " + HoverElement + "is not attached to the page document" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering" + e.getStackTrace());
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return mousehover;
	}

	// Switch to new Window
	public boolean switchToNewWindow(String NavType, String imagePath, String message) throws Exception {
		// String currentWindow = driver.getWindowHandle();
		boolean switchTowindows = false;
		try {
			Set<String> availableWindows = driver.getWindowHandles();
			Iterator<String> itr = availableWindows.iterator();
			String parentWindow = itr.next();

			if (NavType.contains("child")) {
				driver.switchTo().window(itr.next());
				switchTowindows = true;
				// report.logStepToReport(LogStatus.INFO, "Navigate on Child Window", message,
				// imagePath);
			} else {
				Set<String> availableWin = driver.getWindowHandles();
				if (availableWin.size() == 1) {
					driver.switchTo().window(itr.next());
					switchTowindows = true;
					System.out.println("Checkpoint");
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return switchTowindows;
	}

	public boolean switchTochildWindowHandle(String parentwindow, String imagePath, String message) throws Exception {
		// String currentWindow = driver.getWindowHandle();
		boolean switchTowindows = false;
		try {
			Set<String> availableWindows = driver.getWindowHandles();
			Iterator<String> itr = availableWindows.iterator();
			while (itr.hasNext()) {
				String ChildWindow = itr.next();
				if (!parentwindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					driver.manage().window().maximize();
					switchTowindows = true;
					report.logStepToReport(LogStatus.INFO, "Navigate on Child Window", message, imagePath);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return switchTowindows;
	}

	public boolean switchToParentWindow(String parentWin, String imagePath, String message) throws Exception {
		boolean switchTowindow = false;
		try {
			driver.switchTo().window(parentWin);
			switchTowindow = true;
			report.logStepToReport(LogStatus.INFO, "Navigate on Parent Window", message, imagePath);
		} catch (Exception e) {
			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return switchTowindow;
	}

	/**
	 * 
	 * @param element
	 * @param imagePath
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public boolean switchToFrame(WebElement element, String imagePath, String message) throws Exception {
		boolean switchTowindow = false;
		try {
			driver.switchTo().frame(element);
			switchTowindow = true;
			// report.logStepToReport(LogStatus.INFO, "Navigate on Amazon", message,
			// imagePath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Test Case Failed");
		}
		return switchTowindow;
	}

	public boolean switchBackToDefaultContent(String imagePath, String message) throws Exception {
		boolean switchTowindow = false;
		try {
			driver.switchTo().defaultContent();
			switchTowindow = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return switchTowindow;
	}

	/**
	 * 
	 * @param elementList
	 * @return
	 * @throws Exception
	 */
	public int countOfListElement(List<WebElement> elementList) throws Exception {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			if (!elementList.isEmpty()) {
				count = elementList.size();
			}
		} catch (Exception Ex) {

			System.err.println("Timeout Exception for element -" + Thread.currentThread().getStackTrace());

			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return count;
	}

	public String getPageSource() {
		return driver.getPageSource();

	}

	public boolean isSelected(WebElement e) {
		boolean selected = false;
		try {
			if (e.isSelected()) {
				selected = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return selected;

	}

	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WebElement findElementByxPpath(String xpath) throws Exception {
		try {
			return driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			e.printStackTrace();
			report.logStepToReport(LogStatus.FAIL, "Find Element By Xpath : " + xpath,
					"Failed to Find Element - Exception Generated - " + e.getMessage(), "");
			throw e;
		}

	}

	public String getAttribute(WebElement element, String attribute) throws Exception {
		String value = "";
		try {
			value = element.getAttribute(attribute);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Get Attribute Value",
					"Failed to get Attribute Value - Exception Generated - " + e.getMessage(), "");
			e.printStackTrace();
		} finally {
			return value;
		}

	}

	public void waitForPageDOMLoad(Long wait) throws Exception {
		Thread.sleep(wait);
	}

	public void selectFromListOfWebElemet_Equals(List<WebElement> elementList, String textToSelect, String imagePath,
			String message) throws Exception {
		boolean elementFound = false;
		try {
			for (WebElement element : elementList) {
				if (element.getText().equals(textToSelect)) {
					element.click();
					elementFound = true;
					break;
				}
			}
			if (elementFound == true) {
				report.logStepToReport(LogStatus.INFO, "Select from Elements List", message, "");
			} else {
				report.logStepToReport(LogStatus.FAIL, "Select from Elements List",
						"Failed to find exact value in list | Value searched - " + textToSelect, imagePath);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.logStepToReport(LogStatus.FAIL, "Select from Elements List",
					"Failed to Select Elements from List - Exception Generated - " + e.getMessage(), imagePath);
		}
	}

	public boolean isElementDisplayed(WebElement element, int timeout) {
		boolean presence = false;
		for (int i = 0; i < timeout; i++) {
			try {
				Thread.sleep(1000);
				presence = element.isDisplayed();
				if (presence) {
					return presence;
				}
			} catch (Exception Ex) {
				Ex.printStackTrace();
			}
		}
		System.err.println("Timeout Exception for element -" + Thread.currentThread().getStackTrace());
		return presence;
	}

	public boolean selectValueFromList_usingIndex(List<WebElement> elements, String index, String imagePath,
			String message) throws Exception {
		boolean IsValueSelected = false;
		int counter = 0;
		try {
			for (WebElement e : elements) {
				if (counter == 1) {
					e.click();
					IsValueSelected = true;
					report.logStepToReport(LogStatus.INFO, "Select",
							e.getText().replaceAll(" ", "").trim() + " selected", imagePath);
					break;
				}
				counter++;
			}
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "DROP DOWN SELECT NOT PERFORMED",
					"EXCEPTION - " + e.getMessage().split("Session info:")[0], report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return IsValueSelected;
	}

	// Select value from Drop Down if attribute value exist & log step in report
	public boolean selectFromDD_ifAttributeExist(WebElement element, String attribute, String attributeValue,
			String imagePath, String message) throws Exception {
		boolean selected = false;
		try {
			Select select = new Select(element);
			for (int i = 1; i < select.getOptions().size(); i++) {
				if (select.getOptions().get(i).getAttribute(attribute).equals(attributeValue)) {
					select.selectByIndex(i);
					selected = true;
					report.logStepToReport(LogStatus.INFO, "Select from Select Dropdown", message, imagePath);
					break;
				}
			}
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Select from Select Dropdown",
					"Select from Select Dropdown Operation failed - Exception Generated as - "
							+ e.getMessage().split("Session info:")[0],
					report.imagePath);

			e.printStackTrace();
			quitBrowser();
			throw new Exception("Test Case Failed");
		}
		return selected;
	}

	public String getTextOfWebElement(WebElement element) {
		try {
			return element.getText().trim();
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			return element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getTextOfWebElement(WebElement element, String fromSearchString, String fromSearchUsingIndex,
			int fromForwardIndex, String toSearchString, String toSearchUsingIndex, int toForwardIndex) {
		try {
			if (fromSearchUsingIndex.contains("first") && toSearchUsingIndex.contains("first")) {
				return element.getText().substring(element.getText().indexOf(fromSearchString) + fromForwardIndex,
						element.getText().indexOf(toSearchString) + toForwardIndex).trim();
			} else if (fromSearchUsingIndex.contains("first") && toSearchUsingIndex.contains("last")) {
				return element.getText().substring(element.getText().indexOf(fromSearchString) + fromForwardIndex,
						element.getText().lastIndexOf(toSearchString) + toForwardIndex).trim();
			} else if (fromSearchUsingIndex.contains("last") && toSearchUsingIndex.contains("first")) {
				return element.getText().substring(element.getText().lastIndexOf(fromSearchString) + fromForwardIndex,
						element.getText().indexOf(toSearchString) + toForwardIndex).trim();
			} else if (fromSearchUsingIndex.contains("last") && toSearchUsingIndex.contains("last")) {
				return element.getText().substring(element.getText().lastIndexOf(fromSearchString) + fromForwardIndex,
						element.getText().lastIndexOf(toSearchString) + toForwardIndex).trim();
			} else {
				return "";
			}
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			return element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getTextOfWebElement(WebElement element, int fromIndex, String toSearchString, int toForwardIndex) {
		try {
			return element.getText().substring(fromIndex, element.getText().indexOf(toSearchString) + toForwardIndex)
					.trim();
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			return element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getTextOfWebElement(WebElement element, String searchString, String searchUsingIndex,
			int forwardIndex) {
		try {
			if (searchUsingIndex.contains("first")) {
				return element.getText().substring(element.getText().indexOf(searchString) + forwardIndex).trim();
			} else if (searchUsingIndex.contains("last")) {
				return element.getText().substring(element.getText().lastIndexOf(searchString) + forwardIndex).trim();
			} else {
				return "";
			}
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			return element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public void waitForURLChange(String url, Long waitInterval, int counter) {
		try {
			while (counter > 0) {
				Thread.sleep(waitInterval);
				if (driver.getCurrentUrl().contains(url)) {
					return;
				}
				counter--;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Select value from Drop Down if attribute value exist & log step in report
	public boolean selectFirstAvailableValueFromList(WebElement selectElement, WebElement listElement,
			List<WebElement> listElementResults, String imagePath, String message) throws Exception {
		boolean clicked = false;
		try {
			// click(listElement);
			Select s = new Select(selectElement);
			for (int i = 1; i < s.getOptions().size(); i++) {
				if (s.getOptions().get(i).getAttribute("data-available").equals("true")) {
					click(listElement);
					listElementResults.get(i).click();
					clicked = true;
					break;
				}
			}
			report.logStepToReport(LogStatus.INFO, "Select Element from Dropdown List", message, imagePath);
		} catch (Exception e) {
			e.printStackTrace();
			report.logStepToReport(LogStatus.FAIL, "Select Element from Dropdown List",
					"Select Element from Dropdown List Operation Failed Due to Exception : " + e.getLocalizedMessage(),
					imagePath);
			clicked = false;
			throw new Exception("Test Case Failed");
		}
		return clicked;
	}

	public boolean isDisplayedClickAgain(WebElement elementToWait, WebElement elementToClick, int initialWait,
			int FinalWait) {
		boolean flgClicked = false;
		driver.manage().timeouts().implicitlyWait(initialWait, TimeUnit.SECONDS);
		try {
			if (elementToWait.isDisplayed()) {
				flgClicked = clickJS(elementToClick);
			}
		} catch (Exception e) {
			System.out.println("Element not displayed");
		}
		driver.manage().timeouts().implicitlyWait(FinalWait, TimeUnit.SECONDS);
		return flgClicked;
	}
}