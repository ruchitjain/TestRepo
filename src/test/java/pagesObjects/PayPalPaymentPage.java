package pagesObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import controllers.Executor;
import helpers.BrowserActions;

import helpers.Reporting;

public class PayPalPaymentPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;

	public PayPalPaymentPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {
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
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement paypalLoginEmail;

	@FindBy(how = How.XPATH, using = "//button[@id='btnNext']")
	private WebElement paypalLoginNext;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement paypalLoginPassword;

	@FindBy(how = How.XPATH, using = "//div/button[@id='btnLogin']")
	private WebElement paypalLoginSubmit;

	@FindBy(how = How.XPATH, using = "//button[@class='btn full confirmButton continueButton']")
	private WebElement paypalLoggedInCardContinue;

	@FindBy(how = How.XPATH, using = "//button[@id='payment-submit-btn']")
	private WebElement paypalLoggedInCardContinue1;

	@FindBy(how = How.XPATH, using = "//h2[@id='ShipTo']/..//button")
	private WebElement paypalchangeShippingAddrbtn;

	@FindBy(how = How.XPATH, using = "//button[@id='payment-submit-btn']")
	private WebElement continueSelectShipTo;

//	@FindBy(how = How.XPATH, using = "//button[@id='payment-submit-btn']")
//	private WebElement paypalPaywithConfirmationContinuebtn_RO;

	@FindBy(how = How.XPATH, using = "//button[@id='payment-submit-btn'] | //div//input[@id='confirmButtonTop']")
	private WebElement paypalPaywithConfirmationContinuebtn_RO;

	@FindBy(how = How.XPATH, using = "//div//input[@id='confirmButtonTop']")
	private WebElement paypalPaywithConfirmationContinuebtn;

	@FindBy(how = How.XPATH, using = "//div[@id='button']/button")
	private WebElement paypalContinue_NZ;

	@FindBy(how = How.XPATH, using = "//button[@id='payment-submit-btn']")
	private WebElement paypalContinue_RO;

	@FindBy(how = How.XPATH, using = "//div[@id='button']/input[@id='confirmButtonTop']")
	private WebElement paypalLoggedInAgreeContinue1;

	@FindBy(how = How.XPATH, using = "//h2[@id='ShipTo']/following-sibling::div/button/span")
	private WebElement changelinkPaypalExpress;

	@FindBy(how = How.XPATH, using = "//div[@id='shippingAddress']//a[contains(text(),'Change')]")
	private WebElement changeShipToPP;

	@FindBy(how = How.XPATH, using = "(//h2[@id='ShipTo']/following::div/button)[1]")
	private WebElement changeShipToPP_RO;

	@FindBy(how = How.XPATH, using = "//div[@id='shippingAddress']/div/h2")
	private WebElement ShipToheaderPP;

	@FindBy(how = How.XPATH, using = "//h2[@id='ShipTo']/../following-sibling::div//button/span[contains(text(),'Change')]")
	private WebElement changeaddressPaypal;

	@FindBy(how = How.XPATH, using = "//h2[@id='ShipTo']/..//button/span")
	private WebElement changeShipAddr;

	@FindBy(how = How.XPATH, using = "//section//h2")
	private WebElement pay_with;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'PayPal.com')]")
	private WebElement paypal_policies;

	@FindBy(how = How.XPATH, using = "(//a[@id='leftLink']//span)[2]")
	private WebElement addNewAddressPP;

	@FindBy(how = How.ID, using = "country")
	private WebElement countrySelectPP;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingFirstName']")
	private WebElement firstNameTextInputPP;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingLastName']")
	private WebElement lastNameTextInputPP;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingLine1']")
	private WebElement shipToAddressLine1TextInputPP;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingLine2']")
	private WebElement shipToAddressLine2TextInputPP;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingCity']")
	private WebElement cityTextInputPP;

	@FindBy(how = How.ID, using = "shippingState")
	private WebElement stateSelectDropdownPP;

	@FindBy(how = How.XPATH, using = "//input[@id='shippingPostalCode']")
	private WebElement postalCodeTextInputPP;

	@FindBy(how = How.XPATH, using = "//input[@id='proceedButton']")
	private WebElement saveButtonPP;

	@FindBy(how = How.XPATH, using = "//ul[@class='items']")
	private WebElement shipTOAddressList;

	@FindBy(how = How.XPATH, using = "//span[@class='full-address']")
	private List<WebElement> shipToAddresesDropdownPP;

	@FindBy(how = How.XPATH, using = "//div//select[@id='shippingDropdown']")
	private WebElement shipTodropdownPP;

	@FindBy(how = How.XPATH, using = "//div//select[@id='shippingDropdown']/option")
	private List<WebElement> shipTodropdownPPoptions;

	@FindBy(how = How.XPATH, using = "//section[@data-testid='pay-with']/following-sibling::div/div/button")
	private WebElement linkCardButton_PageLoad;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : Used to Login into Paypal Account
	 * @throws Exception
	 */

	public void loginIntoPayPalAccount() throws Exception {

		String paypalemail = null;
		String paypalPassword = null;

		// =================New Update================================//
		if (testCaseData.get("Payment_MethodType").equals("Paypal")) {
			paypalemail = testCaseData.get("Paypal_user_email");
			paypalPassword = testCaseData.get("Paypal_user_password");
		} else if (testCaseData.get("Payment_MethodType").equals("PaypalExpress")) {
			paypalemail = testCaseData.get("Paypal_user_email");
			paypalPassword = testCaseData.get("Paypal_user_password");
		}
		// ==========================================================//

		browserAction.waitForURLChange("express-checkout&token", 1000l, 10);

		browserAction.waitForElementClickable(paypalLoginEmail);
		browserAction.setText(paypalLoginEmail, paypalemail, imgPath,
				"Text Set in Paypal Login ID as : " + paypalemail);

		browserAction.staticWait(1);
		browserAction.click(paypalLoginNext, imgPath, "Click Performed on Login Button");

		browserAction.WaittoPageLoad();
		browserAction.waitForElementClickable(paypalLoginPassword);
		browserAction.click(paypalLoginPassword);
		browserAction.setTextJS(paypalLoginPassword, paypalPassword, imgPath,
				"Text Set in Paypal Password as : " + paypalPassword);

		browserAction.staticWait(1);
		if (browserName.contains("Android") || browserName.contains("Linux")) {
			browserAction.clickJS(paypalLoginSubmit, imgPath, "Click Performed on Login Submit Button");
		} else {
			browserAction.clickJS(paypalLoginSubmit, "", "Click Performed on Login Submit Button");
		}
		browserAction.WaittoPageLoad();
		// browserAction.staticWait(5);

	}

	/**
	 * @description : Used to Select Paypal Terms and Condition
	 * @throws Exception
	 */
	public void selectPaypalTermCondition() throws Exception {

		browserAction.WaittoPageLoad();

		browserAction.waitForPageDOMLoad(5000l);
		if (testCaseData.get("CountryCode").contains("US")) {
			browserAction.waitForElementClickable(paypal_policies);
		}
		browserAction.waitForElementClickable(paypalPaywithConfirmationContinuebtn_RO);
		browserAction.scrollToElementUsingJS(paypalPaywithConfirmationContinuebtn_RO);
		browserAction.clickJS(paypalPaywithConfirmationContinuebtn_RO, "", "paypalLogged-InAgree-Continue, Clicked");
		browserAction.WaittoPageLoad();
	}

	/**
	 * @description : Select Paypal Express Terms and condition
	 * @throws Exception
	 */
	public void selectPaypalExpressTermCondition() throws Exception {

		browserAction.WaittoPageLoad();
		browserAction.waitForPageDOMLoad(5000l);
		browserAction.waitForElementClickable(linkCardButton_PageLoad);

		if (testCaseData.get("CountryCode").equals("US")) {
			browserAction.waitForElementClickable(paypal_policies);
		}
		browserAction.scrollToElementUsingJS(paypalPaywithConfirmationContinuebtn_RO);
		browserAction.waitForElementClickable(paypalPaywithConfirmationContinuebtn_RO);
		browserAction.clickJS(paypalPaywithConfirmationContinuebtn_RO, "", "paypalLogged-InAgree-Continue, Clicked");
		browserAction.WaittoPageLoad();

		/*
		 * Wait till user navigates back to Gucci Site
		 */

		browserAction.waitForURLChange("/checkout/single#step", 2000l, 15);

	}

	/**
	 * @description : Select Existing Address depending on Postal Code and Other
	 *              Keys in PaypalExpress
	 * @return
	 * @throws Exception
	 */
	public boolean selectExistingShipToAddress() throws Exception {

		boolean existAdddress = false;
		browserAction.WaittoPageLoad();
		browserAction.waitForElementClickable(changeaddressPaypal);
		browserAction.clickJS(changeaddressPaypal);

		existAdddress = browserAction.selectFromDD(shipTodropdownPP, testCaseData,
				testCaseData.get("ShippingAddress_ZipCode"), testCaseData.get("ShippingAddress_City"), "",
				"Ship To Address from PayPal");
		return existAdddress;
	}

}