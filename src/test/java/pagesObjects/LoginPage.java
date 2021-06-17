package pagesObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import controllers.Executor;
import helpers.BrowserActions;

import helpers.Reporting;

public class LoginPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;

	public LoginPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {

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
	@FindBy(how = How.ID, using = "guest.email")
	private WebElement guestUserEmailIDTextBox;

	@FindBy(how = How.XPATH, using = "//input[@id='email-input']")
	private WebElement guestUserEmailIDTextBox_SI;

	@FindBy(how = How.XPATH, using = "//form[@id='form']/button")
	private WebElement continueButton_SI;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : enter Guest User email Id
	 * @return
	 * @throws Exception
	 */
	public boolean enterGuestUserEmailID() throws Exception {

		browserAction.WaittoPageLoad();
		browserAction.waitForElementVisibility(guestUserEmailIDTextBox_SI);
		boolean emailentered = false;
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime = ft.format(dNow);
		String emailid = testCaseData.get("GuestUserEmailID").split("@")[0] + datetime
				+ browserName.replaceAll("Windows", "") + "@" + "yopmail.com";

		emailentered = browserAction.setText(guestUserEmailIDTextBox_SI, emailid, "",
				"Guest user Email ID entered as <font color=#00b3b3> '" + emailid + "'");

		testCaseData.put("registeredEmail", emailid);
		return emailentered;
	}

	/**
	 * @description : user enter email and click on Continue button
	 * @throws Exception
	 */
	public void enterGuestUserEmailandContinue() throws Exception {
		if (!testCaseData.get("TestID").contains("Registered User-Checkout")) {
			enterGuestUserEmailID();
			clickContinueButton();
		}

	}

	/**
	 * @description : Click on Continue button : ( Create Account : Okta page)
	 * @throws Exception
	 */
	public void clickContinueButton() throws Exception {
		browserAction.waitForElementClickable(continueButton_SI);
		browserAction.clickJS(continueButton_SI, "", "'Continue' button clicked");

	}

}