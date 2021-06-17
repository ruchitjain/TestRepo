package pagesObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import controllers.Executor;
import helpers.BrowserActions;
import helpers.Reporting;

public class MensReadyToWearPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;

	public MensReadyToWearPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {

		driver = driverObj;
		report = reportObj;
		this.testCaseData = testCaseData;
		browserName = Executor.Devices[Integer.parseInt(Thread.currentThread().getName()) - 1];
		imgPath = report.imagePath;
		browserAction = new BrowserActions(driver, report);
		PageFactory.initElements(driver, this);
	}

	/**
	 * ==========================================================================
	 * =================PAGE ELEMENT LOCATORS====================================
	 * ==========================================================================
	 */
	@FindBy(how = How.XPATH, using = "(//select[contains(@name,'size')])[1]")
	private WebElement productSize;

	@FindBy(how = How.XPATH, using = "//select[@name='size']/option")
	private List<WebElement> productSizeSelectOptions;

	@FindBy(how = How.XPATH, using = "(//div[@data-module='productSizes'])[1]/div/div/span/span/span/span/span/span")
	private WebElement selectDropdown_spanAttr;

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'select2-size')]/li/span/child::span[1]")
	private List<WebElement> productSizeList;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : To Select size of the Product
	 * @throws Exception
	 */
	public void SelectProductSize() throws Exception {

		browserAction.WaittoPageLoad();
		browserAction.isElementDisplayed(productSize, 4);
		browserAction.waitForElementClickable(productSize);

		if (testCaseData.get("Browser_Name").contains("MacSafari")) {
			browserAction.selectFirstAvailableValueFromList(productSize, selectDropdown_spanAttr, productSizeList,
					imgPath, "First Available Size from List Selected Successfully");
		} else if (testCaseData.get("Browser_Name").contains("Firefox")) {
			SelectProductSizeFirefox();
		} else {
			browserAction.selectFromDD_ifAttributeExist(productSize, "data-available", "true", report.imagePath,
					"Product Size Selected from Drop Down");
		}

	}

	/**
	 * @description : To Select the size of product (Firefox)
	 * @throws Exception
	 */
	public boolean SelectProductSizeFirefox() throws Exception {
		boolean clicked = false;
		try {
			if (browserAction.isElementDisplayed(productSize, 4)) {
				Select s = new Select(productSize);
				for (int i = 1; i < s.getOptions().size(); i++) {
					if (s.getOptions().get(i).getAttribute("data-available").equals("true")) {
						browserAction.click(selectDropdown_spanAttr);
						productSizeList.get(i).click();
						clicked = true;
						break;
					}
				}
			} else {
				report.logStepToReport(LogStatus.FAIL, "Select Product", "Product Not Available", report.imagePath);
				browserAction.quitBrowser();
				clicked = false;
			}
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Select", "Product does not has size option", report.imagePath);
			clicked = false;
			throw new Exception("Test Case Failed");
		}
		return clicked;

	}



}