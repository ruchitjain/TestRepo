package pagesObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import controllers.Executor;
import helpers.BrowserActions;

import helpers.JsonReader;
import helpers.PageObjectUtils;
import helpers.Reporting;

public class ShippingAddressPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;
	public PageObjectUtils pageObjectUtils;

	public ShippingAddressPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {

		driver = driverObj;
		report = reportObj;
		this.testCaseData = testCaseData;
		browserName = Executor.Devices[Integer.parseInt(Thread.currentThread().getName()) - 1];
		imgPath = report.imagePath;
		browserAction = new BrowserActions(driver, report);
		pageObjectUtils = new PageObjectUtils(testCaseData);
		PageFactory.initElements(driver, this);
	}

	/**
	 * ==========================================================================
	 * =================PAGE ELEMENT LOCATORS====================================
	 * ==========================================================================
	 */
	@FindBy(how = How.XPATH, using = "(//select[contains(@name,'shipping_title')])[1]")
	private WebElement titleSelect;

	@FindBy(how = How.XPATH, using = "(//select[contains(@name,'shipping_gender')])[1]")
	private WebElement titleSelectJP;

	@FindBy(how = How.XPATH, using = "//span[contains(@id,'select2-shipping_gender')]")
	private WebElement titleSelectJP_FF;

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'shipping_gender')]/li")
	private List<WebElement> titleOptions_JP;

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'shipping_title-results')]/li")
	private List<WebElement> titleOptions;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_name')])[1]")
	private WebElement firstNameTextInput;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_last_name')])[1]")
	private WebElement lastNameTextInput;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_address_line_1')])[1]")
	private WebElement shippingAddressLine1TextInput;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_address_line_2')])[1]")
	private WebElement shippingAddressLine2TextInput;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_city')])[1]")
	private WebElement cityTextInput;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_zip_code')])[1]")
	private WebElement postalCodeTextInput;

	@FindBy(how = How.XPATH, using = "(//select[contains(@name,'shipping_state')])[1]")
	private WebElement countrySelect;

	@FindBy(how = How.ID, using = "states-dropdown-field")
	private WebElement countrySelectdrpdwn;

	@FindBy(how = How.XPATH, using = "(//input[contains(@name,'shipping_phone')])[1]")
	private WebElement mobileTextInput;

	@FindBy(how = How.XPATH, using = "(//div[@class='standard-content']/button)[1]")
	private WebElement continueToPaymentButton;

	@FindBy(how = How.XPATH, using = "(//div[@id='shipping-methods']/following-sibling::div//button)[1]")
	private WebElement continueToPayementButtonMobile;

	@FindBy(how = How.ID, using = "input-credit-card-number")
	private WebElement paymentCardNumberInput;

	@FindBy(how = How.ID, using = "input-credit-card-code-new")
	private WebElement paymentCardSecurityCodeInput;

	@FindBy(how = How.ID, using = "input-credit-card-name")
	private WebElement paymentCardNameInput;

	@FindBy(how = How.ID, using = "card_expirationMonth")
	private WebElement paymentCardMonthSelect;

	@FindBy(how = How.ID, using = "card_expirationYear")
	private WebElement paymentCardYearSelect;

	@FindBy(how = How.XPATH, using = "(//button[@class='save-payment-changes verify-payment-type'])[1]")
	private WebElement confirmDetailsButton;

	@FindBy(how = How.XPATH, using = "//div[@id='tab-affirm']//button")
	private WebElement confirmDetails_affirm_Button;

	@FindBy(how = How.XPATH, using = "//div[@id='tab5']//button")
	private WebElement confirmDetails_wireTransfer_Button;

	@FindBy(how = How.XPATH, using = "(//section/h2)[3]")
	private WebElement payment_header;

	@FindBy(how = How.XPATH, using = "(//div[@id='place-order-tooltip']/preceding-sibling::button)[2]")
	private WebElement placeOrderAndPayButton;

	@FindBy(how = How.XPATH, using = "(//div[@id='place-order-tooltip']/preceding-sibling::button)[1]")
	private WebElement placeOrderAndPayButton_affirm_pay;

	@FindBy(how = How.ID, using = "payment-select-shipping-information")
	private WebElement billingAndShippingAddressAreSameCheckBox;

	@FindBy(how = How.XPATH, using = "//select[@id='shipping_area']")
	private WebElement countrySelect_Area_HK;

	@FindBy(how = How.XPATH, using = "//select[@id='shipping_subdivision']")
	private WebElement countrySelect_District_HK_drpdwn;

	@FindBy(how = How.XPATH, using = "//input[@id='shipping_first_name_katakana']")
	private WebElement shippingFirstNameJP;

	@FindBy(how = How.XPATH, using = "//input[@id='shipping_last_name_katakana']")
	private WebElement shippingLastNameJP;

	@FindBy(how = How.XPATH, using = "//a[@data-payment-method='paypal']")
	private WebElement paypalTabUS;

	@FindBy(how = How.XPATH, using = "//a[@data-payment-method='bpay']")
	private WebElement bpayTabUS;

	@FindBy(how = How.XPATH, using = "//a[@data-payment-method='wire-transfer']")
	private WebElement wireTransferTAB;

	@FindBy(how = How.XPATH, using = "//a[@data-payment-method='affirm']")
	private WebElement affirm_paymentTAB;

	@FindBy(how = How.XPATH, using = "//a[@data-payment-method='cash-on-delivery']")
	private WebElement CODTabUS;

	@FindBy(how = How.XPATH, using = "//button[@class='change-button']")
	private WebElement paymnetchangebutton_mobile;

	@FindBy(how = How.XPATH, using = "(//button[@class='change-button']/preceding-sibling::div/ul/li/a)[4]")
	private WebElement BpayTabUS_Mobile;

	@FindBy(how = How.XPATH, using = "(//button[@class='change-button']/preceding-sibling::div/ul/li/a)[3]")
	private WebElement WireTransferTabUS_Mobile;

	@FindBy(how = How.XPATH, using = "(//button[@class='change-button']/preceding-sibling::div/ul/li/a)[3]")
	private WebElement AffirmPaymentTabUS_Mobile;

	@FindBy(how = How.XPATH, using = "(//button[@class='change-button']/preceding-sibling::div/ul/li/a)[5]")
	private WebElement CODTabUS_Mobile;

	@FindBy(how = How.XPATH, using = "//button[@class='save-payment-changes verify-paypal-type']")
	private WebElement paypalConfirmDetailsButton;

	@FindBy(how = How.XPATH, using = "(//div[@id='place-order-tooltip']/../a)[1]")
	private WebElement paypalMethodCTA;

	@FindBy(how = How.XPATH, using = "//input[@name='terms-of-sale']/following-sibling::label")
	private WebElement acceptTermsAndConditionsLabel;

	@FindBy(how = How.XPATH, using = "//input[@name='terms-of-sale']")
	private WebElement acceptTermsAndConditionscheckbox;

	@FindBy(how = How.XPATH, using = "(//section/h2/following-sibling::a)[1]")
	private WebElement shippingAddress_edit;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-card_expirationMonth-container']")
	private WebElement expirtMonth;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-card_expirationYear-container']")
	private WebElement expiryYear;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'select2-card_expirationMonth-result')]")
	private List<WebElement> expMonthList;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'select2-card_expirationYear-result')]")
	private List<WebElement> expYearList;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-shipping_title-container']")
	private WebElement titleSelect_HK;

	@FindBy(how = How.XPATH, using = "(((//h2)[1]//following-sibling::div)[2]//div)[1]//div[@class='shipping-name']")
	private WebElement shippingAddressName;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]//following-sibling::div)[1]/div/div)[2]/div[@class='shipping-name']")
	private WebElement paymentAddressName;

	@FindBy(how = How.XPATH, using = "(//h2)[2]")
	private WebElement giftmethod;

	@FindBy(how = How.ID, using = "Cardinal-CCA-IFrame")
	private WebElement secure3Diframe;

	@FindBy(how = How.ID, using = "sopRequestIframe")
	private WebElement soaprequest_secure3Diframe;

	@FindBy(how = How.XPATH, using = "//input[@name='challengeDataEntry']")
	private WebElement secure3Dpassword;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-shipping_area-results']/li")
	private List<WebElement> country_AreaDropDwn_List_HK;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-shipping_area-container']")
	private WebElement country_AreaDropDwnBtn_HK;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-shipping_subdivision-results']/li")
	private List<WebElement> country_DistrictDropDwn_List_HK;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-shipping_subdivision-container']")
	private WebElement country_DistrictDropDwnBtn_HK;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-states-dropdown-field-results']/li")
	private List<WebElement> stateDropDwnList;

	@FindBy(how = How.XPATH, using = "//span[@id= 'select2-states-dropdown-field-container']")
	private WebElement stateDropDwnBtn;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-shipping_title-results']/li")
	private List<WebElement> titleDropDwn_List;

	@FindBy(how = How.XPATH, using = "(//button[@data-save-address-id = 'checkout-shipping-saved-address'])[1]")
	private WebElement saveChangesButn;

	@FindBy(how = How.XPATH, using = "(//button[@data-save-address-id = 'checkout-shipping-saved-address'])[3]")
	private WebElement saveChangesButn_JP_Mobile;

	@FindBy(how = How.ID, using = "basket-paypal-express")
	private WebElement confirmDetailsButnPayPalChkout;

	@FindBy(how = How.XPATH, using = "(//h2[contains(text(),'Shipping Address')]/following-sibling::div/div[contains(@class,'shipping-item-order-info')])[1]")
	private WebElement preFilledShippingAddress;

	@FindBy(how = How.XPATH, using = "((//h2[contains(text(),'Shipping Address')]/following-sibling::div/div[contains(@class,'shipping-item-order-info')])[1]/div)[1]")
	private WebElement selectedShippingAddress_Name;

	@FindBy(how = How.XPATH, using = "((//h2[contains(text(),'Shipping Address')]/following-sibling::div/div[contains(@class,'shipping-item-order-info')])[1]/div)[2]")
	private WebElement selectedShippingAddress_AddressLine1_2;

	@FindBy(how = How.XPATH, using = "((//h2[contains(text(),'Shipping Address')]/following-sibling::div/div[contains(@class,'shipping-item-order-info')])[1]/div)[3]")
	private WebElement selectedShippingAddress_CityStateZipcode;

	@FindBy(how = How.XPATH, using = "((//h2[contains(text(),'Shipping Address')]/following-sibling::div/div[contains(@class,'shipping-item-order-info')])[1]/div)[4]")
	private WebElement selectedShippingAddress_PhoneExtNumber;

	@FindBy(how = How.XPATH, using = "((//h2)[1]/following-sibling::div/div[1]/div)[1]")
	private WebElement selectedShippingAddress_Name_JP;

	@FindBy(how = How.XPATH, using = "((//h2)[1]/following-sibling::div/div[1]/div)[8]")
	private WebElement selectedShippingAddress_AddressLine1_2_JP;

	@FindBy(how = How.XPATH, using = "((//h2)[1]/following-sibling::div/div[1]/div)[5]")
	private WebElement selectedShippingAddress_Zipcode_JP;

	@FindBy(how = How.XPATH, using = "((//h2)[1]/following-sibling::div/div[1]/div)[9]")
	private WebElement selectedShippingAddress_PhoneExtNumber_JP;

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'credit-card-info')]")
	private List<WebElement> creditCardsInfo;

	@FindBy(how = How.XPATH, using = "//form[@id='shipping-address-order']/div/label")
	private List<WebElement> preSavedAddressList;

	@FindBy(how = How.XPATH, using = "//form/div/div/div/label/div/input[contains(@id,'shipping')]/../following-sibling::div")
	private List<WebElement> preSavedBillingAddressList;

	// @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Shipping
	// Address')]/following-sibling::a[text()='Edit']")

	@FindBy(how = How.XPATH, using = "(//h2)[1]/following-sibling::a[contains(@href,'edit-shipping')]")
	private WebElement shippingAddressEditButton;

	@FindBy(how = How.XPATH, using = "(//div[@id='page']/div/nav/ul/li)[1]")
	private WebElement shippingAddressEditButton_JP_Mobile;

//	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'お届け先・配送方法')]/following-sibling::a[text()='編集']")
//	private WebElement shippingAddressEditButton_JP;

//	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Gifting')]/following-sibling::a[text()='Edit']")

	@FindBy(how = How.XPATH, using = "(//h2)[2]/following-sibling::a[contains(@href,'edit-gifting')]")
	private WebElement giftingEditButton;

	@FindBy(how = How.XPATH, using = "(//h2)[3]/following-sibling::a[contains(@href,'edit-payment')]")
	private WebElement paymentEditButton;

	@FindBy(how = How.XPATH, using = "(//div[@id='page']/div/nav/ul/li)[2]")
	private WebElement giftingEditButton_JP_Mobile;

	@FindBy(how = How.XPATH, using = "(//div[@id='page']/div/nav/ul/li)[3]")
	private WebElement paymentEditButton_JP_Mobile;

	@FindBy(how = How.ID, using = "gifting-gift-message")
	private WebElement giftingMessageTextArea;

	@FindBy(how = How.XPATH, using = "((//h2)[2]/following-sibling::div/div)[1]")
	private WebElement giftingMessageText;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'New Address')]/../input[@type='radio'])[1]")
	private WebElement shippingAddress_NewAddressRadioButton;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'新しい住所')]/../input[@type='radio'])[1]")
	private WebElement shippingAddress_NewAddressRadioButton_JP;

	// @FindBy(how = How.XPATH, using = "(//button[contains(text(),'Continue to
	// Payment')])")
	@FindBy(how = How.XPATH, using = "//form[@id='checkout-gifting-form']/button")
	private WebElement giftingContinueToPayment;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[2]")
	private WebElement selectedCreditCardNumber;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[3]")
	private WebElement selectedCreditCardHolderName;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[4]")
	private WebElement selectedCreditCardExpiry;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[5]")
	private WebElement selectedBillingAddressFirstLastName;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[6]")
	private WebElement selectedBillingAddressAddressLine1_2;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[7]")
	private WebElement selectedBillingAddressCityStateZipcode;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[8]")
	private WebElement selectedBillingAddressPhoneExtNumber;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[6]")
	private WebElement selectedBillingAddressFirstLastName_JP;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[12]")
	private WebElement selectedBillingAddressAddressLine1_2_JP;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[9]")
	private WebElement selectedBillingAddressZipcode_JP;

	@FindBy(how = How.XPATH, using = "(((//h2)[3]/following-sibling::div)[1]/div/div/div)[13]")
	private WebElement selectedBillingAddressPhoneExtNumber_JP;

	@FindBy(how = How.ID, using = "new-credit-card")
	private WebElement paymentSection_NewCreditCardRadioButton;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'New Address')]/../input[@type='radio'])[2]")
	private WebElement billingAddress_NewAddressRadioButton;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'新しい住所')]/../input[@type='radio'])[2]")
	private WebElement billingAddress_NewAddressRadioButton_JP;

	@FindBy(how = How.XPATH, using = "((//h2)[3]/../div)[1]")
	private WebElement paypalAccountText;

	@FindBy(how = How.XPATH, using = "((//h2)[3]/../div/div/div)[2]")
	private WebElement paypalAccountText_Mobile;

	@FindBy(how = How.XPATH, using = "(//h2)[3]/../div/div/div/ul")
	private WebElement paymentMethodLinks;

	@FindBy(how = How.XPATH, using = "(//h2//following-sibling::div//ul/li)[1]")
	private WebElement creditCardLink;

	@FindBy(how = How.XPATH, using = "(//h2//following-sibling::div//ul/li)[1]/a")
	private WebElement creditCardLink_ios;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : Enter Shipping details | checkout shipping page
	 * @throws Exception
	 */
	public void enterShippingAddress() throws Exception {

		Map<String, String> addressData = pageObjectUtils
				.setAddressDataMap(testCaseData.get("ShippingAddressTypeDuringCheckout"));
		selectTitle(addressData);

		

		setFirstName_LastName(addressData);
		// setAddressLine1and2(addressData);
		// enterCity(addressData);
		Thread.sleep(5000l);

		if (testCaseData.get("CountryCode").equals("HK")) {
			selectAreaandDistrictandPhone(addressData);
		} else {
			selectPostalCodeandStateandPhone(addressData);
		}
	}

	/**
	 * @description : Used to click on Continue Button checkout shipping Page
	 * @throws Exception
	 */
	public void clickContinueToPaymentButtonMobile() throws Exception {
		if (browserName.contains("Android") || browserName.contains("Linux") || browserName.contains("MacSafari")) {
			browserAction.waitForPageDOMLoad(3000l);
			// browserAction.waitForElementClickable(continueToPaymentButton);
			browserAction.clickJS(continueToPaymentButton, "", "Click Performed on Continue Button");
		} else {
			browserAction.waitForPageDOMLoad(3000l);
			// browserAction.waitForElementClickable(continueToPayementButtonMobile);
			browserAction.clickJS(continueToPayementButtonMobile, "", "Click Performed on Continue Button");
		}
	}

	/**
	 * @description : used to enter card Payment details | Payment section |
	 *              checkout Billing
	 * @throws Exception
	 */
	public void enterPaymentDetails_CARDS() throws Exception {

		browserAction.WaittoPageLoad();
		// browserAction.waitForElementClickable(paymentCardNumberInput);
		browserAction.waitForPageDOMLoad(3000L);
		browserAction.waitForElementVisibility(paymentCardNumberInput);
		browserAction.click(paymentCardNumberInput);

		browserAction.setTextJS(paymentCardNumberInput, testCaseData.get("Payment_CardNumber"), "",
				"Card Number Set as : " + testCaseData.get("Payment_CardNumber"));
		browserAction.setText(paymentCardSecurityCodeInput, testCaseData.get("Payment_SecurityCode"), "",
				"Security Code Set as : " + testCaseData.get("Payment_SecurityCode"));
		browserAction.setText(paymentCardNameInput, testCaseData.get("Payment_NameOnCard"), "",
				"Card Name Set as : " + testCaseData.get("Payment_NameOnCard"));

		if (browserName.contains("Firefox")) {
			browserAction.waitForPageDOMLoad(2000L);
			browserAction.selectFromList(expirtMonth, expMonthList, testCaseData.get("Payment_ExpiryMonth"), "",
					"Card Expiry Month Selected as : " + testCaseData.get("Payment_ExpiryMonth"));
			browserAction.waitForPageDOMLoad(2000L);
			browserAction.selectFromList(expiryYear, expYearList, testCaseData.get("Payment_ExpiryYear"), "",
					"Card Expiry Year Selected as : " + testCaseData.get("Payment_ExpiryYear"));
		} else {
			browserAction.selectFromDDJS(paymentCardMonthSelect, testCaseData.get("Payment_ExpiryMonth"), "",
					"Card Expiry Month Selected as : " + testCaseData.get("Payment_ExpiryMonth"));
			browserAction.selectFromDDJS(paymentCardYearSelect, testCaseData.get("Payment_ExpiryYear"), "",
					"Card Expiry Year Selected as : " + testCaseData.get("Payment_ExpiryYear"));
		}

	}

	/**
	 * @description : Used to select Paypal Tab : Checkout shipping Section
	 * @throws Exception
	 */
	public void selectPaypalPaymentDetails() throws Exception {
		if (browserName.contains("Android") || browserName.contains("Linux") || browserName.contains("Ios")) {
			browserAction.click(paymnetchangebutton_mobile, "", "Change payment mode");
		}
		browserAction.staticWait(3);
		browserAction.waitForElementClickable(paypalTabUS);
		browserAction.clickJS(paypalTabUS);
		browserAction.clickJS(paypalConfirmDetailsButton, "", "Confirm payment method mode");

	}

	/**
	 * @description : select Payment Mode during checkout
	 * @throws Exception
	 */
	public void selectPaymentMode() throws Exception {
		if (browserName.contains("Linux") || browserName.contains("Android")) {
			selectPaymentMode_Mobile();
		} else {
			selectPaymentMode_Web();
		}
	}

	/**
	 * @description : select Payment mode | Mobile checkout
	 * @throws Exception
	 */
	public void selectPaymentMode_Mobile() throws Exception {

		browserAction.waitForElementClickable(paymnetchangebutton_mobile);
		browserAction.clickJS(paymnetchangebutton_mobile, "", "Click Performed on Change Payment Button");

		if (testCaseData.get("Payment_MethodType").equals("Affirm Monthly Payments")) {
			browserAction.waitForElementVisibility(AffirmPaymentTabUS_Mobile);
			browserAction.waitForElementClickable(AffirmPaymentTabUS_Mobile);
			browserAction.click(AffirmPaymentTabUS_Mobile, "", "Click Peformed on Affirm Monthly Payment Tab");
		} else if (testCaseData.get("Payment_MethodType").equals("Wire Transfer")) {
			browserAction.staticWait(3);
			browserAction.waitForElementClickable(WireTransferTabUS_Mobile);
			browserAction.clickJS(WireTransferTabUS_Mobile, "", "Click Peformed on Wire Transfer Payment Tab");

		} else if (testCaseData.get("Payment_MethodType").equals("COD")) {
			browserAction.staticWait(3);
			if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")
					&& testCaseData.get("Test_Category").contains("Threshold Product")) {
				String paymentMethods = browserAction.getText(paymentMethodLinks);
				if (paymentMethods.contains("代金引換配送")) {
					report.logStepToReport(LogStatus.FAIL, "Validate COD Payment option is not Available",
							"Validation of COD option unavailability Failed", imgPath);
				} else {
					report.logStepToReport(LogStatus.PASS, "Validate COD Payment option is not Available",
							"Validation of COD option unavailability Passed", imgPath);
				}
			} else {
				browserAction.waitForElementClickable(CODTabUS_Mobile);
				browserAction.click(CODTabUS_Mobile, "", "Click Peformed on COD Payment Tab");
			}

		}

		else {
			browserAction.staticWait(3);
			browserAction.waitForElementClickable(BpayTabUS_Mobile);
			browserAction.clickJS(BpayTabUS_Mobile, "", "Click Peformed on BPay Payment Tab");
		}

	}

	/**
	 * @description : select Payment Mode | Web checkout
	 * @throws Exception
	 */
	public void selectPaymentMode_Web() throws Exception {

		if (testCaseData.get("Payment_MethodType").equals("Affirm Monthly Payments")) {
			browserAction.click(affirm_paymentTAB);
			browserAction.clickJS(affirm_paymentTAB, "", "Click Peformed on Affirm Monthly Payment Tab");
		} else if (testCaseData.get("Payment_MethodType").equals("Wire Transfer")) {
			browserAction.staticWait(3);
			browserAction.waitForElementClickable(wireTransferTAB);
			browserAction.clickJS(wireTransferTAB, "", "Click Peformed on Wire Transfer Payment Tab");
		} else if (testCaseData.get("Payment_MethodType").equals("COD")) {
			browserAction.staticWait(3);
			if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")
					&& testCaseData.get("Test_Category").contains("Threshold Product")) {
				String paymentMethods = browserAction.getText(paymentMethodLinks);
				if (paymentMethods.contains("代金引換配送")) {
					report.logStepToReport(LogStatus.FAIL, "Validate COD Payment option is not Available",
							"Validation of COD option unavailability Failed", imgPath);
				} else {
					report.logStepToReport(LogStatus.PASS, "Validate COD Payment option is not Available",
							"Validation of COD option unavailability Passed", imgPath);
				}
			} else {
				browserAction.waitForElementClickable(CODTabUS);
				browserAction.clickJS(CODTabUS, "", "Click Peformed on COD Payment Tab");
			}

		} else {
			browserAction.staticWait(3);
			browserAction.waitForElementClickable(bpayTabUS);
			browserAction.clickJS(bpayTabUS, "", "Click Peformed on BPay Payment Tab");
		}

	}

	/**
	 * @description : Mark Check if the Billing same as shipping checkbox not
	 *              clicked
	 * @throws Exception
	 */
	public void clickBillingAndShipingAddressAreSameCheckBox() throws Exception {

		browserAction.scrollToElementUsingJS(payment_header);
		if (!billingAndShippingAddressAreSameCheckBox.isSelected()) {
			browserAction.clickJS(billingAndShippingAddressAreSameCheckBox, "",
					"'Billing Address and Phone are the same as Shipping Information' Check Box clicked");
		}

		if (!billingAndShippingAddressAreSameCheckBox.isSelected()) {
			browserAction.clickJS(billingAndShippingAddressAreSameCheckBox, "",
					"'Billing Address and Phone are the same as Shipping Information' Check Box clicked");
		}

	}

	/**
	 * @description : Mark un-Check if the Billing same as shipping checkbox clicked
	 * @throws Exception
	 */
	public void uncheck_BillingAndShipingAddressAreSameCheckBox() throws Exception {

		// browserAction.staticWait(2);
		browserAction.scrollToElementUsingJS(payment_header);
		if (billingAndShippingAddressAreSameCheckBox.isSelected()) {
			browserAction.clickJS(billingAndShippingAddressAreSameCheckBox, "",
					"Click Performed on 'Billing Address and Phone are the same as Shipping Information' checkbox to Uncheck");
		}

		if (billingAndShippingAddressAreSameCheckBox.isSelected()) {
			browserAction.clickJS(billingAndShippingAddressAreSameCheckBox, "",
					"Click Performed on 'Billing Address and Phone are the same as Shipping Information' checkbox to Uncheck");
		}

	}

	/**
	 * @description : Mark un-Check if the Billing same as shipping checkbox clicked
	 * @throws Exception
	 */
	public void check_BillingAndShipingAddressAreSameCheckBox() throws Exception {

		browserAction.scrollToElementUsingJS(payment_header);
		if (!billingAndShippingAddressAreSameCheckBox.isSelected()) {
			browserAction.clickJS(billingAndShippingAddressAreSameCheckBox, "",
					"Click Performed on 'Billng Address and Phone are the same as Shipping Information' checkbox to Check");
		}

		if (!billingAndShippingAddressAreSameCheckBox.isSelected()) {
			browserAction.clickJS(billingAndShippingAddressAreSameCheckBox, "",
					"Click Performed on 'Billing Address and Phone are the same as Shipping Information' checkbox to Check");
		}

	}

	/**
	 * @description : click on Confirm Details Button | Appear after payment Mode
	 *              selection
	 * @throws Exception
	 */
	public void clickConfirmDetailsButton() throws Exception {
		browserAction.waitForPageDOMLoad(2000L);
		if (testCaseData.get("Payment_MethodType").equals("Wire Transfer")) {
			clickConfirm_wireTransfer_DetailsButton();
		} else if (testCaseData.get("Payment_MethodType").equals("Affirm Monthly Payments")) {
			clickConfirm_affirm_DetailsButton();
		} else {
			browserAction.scrollToElementUsingJS(payment_header);
			browserAction.clickJS(confirmDetailsButton, "", "Click Performed on Confirm Details Button");
		}
	}

	/**
	 * @description : click on affirm Detail Confirm button
	 * @throws Exception
	 */
	public void clickConfirm_affirm_DetailsButton() throws Exception {
		browserAction.waitForElementClickable(confirmDetails_affirm_Button);
		browserAction.click(confirmDetails_affirm_Button, "", "Click Performed on Confirm Details Button");
	}

	/**
	 * @description : click on Wire Transfer confirm Button
	 * @throws Exception
	 */
	public void clickConfirm_wireTransfer_DetailsButton() throws Exception {
		browserAction.waitForElementClickable(confirmDetails_wireTransfer_Button);
		browserAction.scrollToElementUsingJS(payment_header);
		browserAction.click(confirmDetails_wireTransfer_Button, imgPath, "Click Performed on Confirm Details Button");
	}

	/**
	 * @description : select User Title | Checkout Shipping
	 * @throws Exception
	 */
	public void selectTitle(Map<String, String> addressData) throws Exception {

		browserAction.WaittoPageLoad();

		if (addressData.get("countryCode").equals("JP")) {
			browserAction.staticWait(4);
			if (!browserName.contains("Firefox")) {

				browserAction.selectFromDDJS(titleSelectJP, addressData.get("title"), "",
						"Title Selected from Dropdown as : " + addressData.get("title"));
			} else {
				browserAction.waitForElementClickable(titleSelectJP_FF);
				browserAction.selectFromList(titleSelectJP_FF, titleOptions_JP, addressData.get("title"), "",
						"Title Selected from Dropdown as : " + addressData.get("title"));
			}
		} else if (addressData.get("countryCode").equals("HK")) {
			browserAction.staticWait(4);
			if (!browserName.contains("Firefox")) {

				browserAction.waitForElementClickable(titleSelect);
				browserAction.selectFromDDJS(titleSelect, addressData.get("title"), "",
						"Title Selected from Dropdown as : " + addressData.get("title"));
			} else {
				browserAction.waitForElementClickable(titleSelect_HK);
				browserAction.selectFromList(titleSelect_HK, titleOptions,
						JsonReader.getAddressData(addressData, "title"), "",
						"Title Selected from Dropdown as : " + JsonReader.getAddressData(addressData, "title"));
			}
		} else {
			System.out.println("Skipping title selection as of now--not mandatory for other countries");
		}
		browserAction.WaittoPageLoad();
	}

	/**
	 * @description : select First and LastName | checkout Shipping page
	 * @throws Exception
	 */
	public void setFirstName_LastName(Map<String, String> addressData) throws Exception {
		if (addressData.get("countryCode").equals("JP")) {
			browserAction.waitForElementClickable(shippingLastNameJP);
			browserAction.setText(shippingLastNameJP, addressData.get("lastName"), "",
					"Last Name Set as : " + addressData.get("lastName"));

			browserAction.setText(shippingFirstNameJP, addressData.get("firstName"), "",
					"First Name Set as : " + addressData.get("firstName"));
		}
		browserAction.waitForElementClickable(firstNameTextInput);
		browserAction.setText(firstNameTextInput, addressData.get("firstName"), "",
				"First Name Set as : " + addressData.get("firstName"));
		browserAction.setText(lastNameTextInput, addressData.get("lastName"), "",
				"Last Name Set as : " + addressData.get("lastName"));

	}

	/**
	 * @description : Select Address Line 1 & 2 | checkout Shipping page
	 * @throws Exception
	 */
	public void setAddressLine1and2(Map<String, String> addressData) throws Exception {
		browserAction.setText(shippingAddressLine1TextInput, addressData.get("addressLine1"), "",
				"Address Line 1 Set as : " + addressData.get("addressLine1"));

		browserAction.setText(shippingAddressLine2TextInput, addressData.get("addressLine2"), "",
				"Address Line 2 Set as : " + addressData.get("addressLine2"));
	}

	/**
	 * @description : Enter city | checkout Shipping Page
	 * @throws Exception
	 */
	public void enterCity(Map<String, String> addressData) throws Exception {
		if (!addressData.get("countryCode").equals("HK")) {
			browserAction.setText(cityTextInput, addressData.get("city"), "",
					"City Set as : " + addressData.get("city"));
		}
	}

	/**
	 * @description : select Area and District and Phone Number
	 */
	public void selectAreaandDistrictandPhone(Map<String, String> addressData) throws Exception {

		browserAction.staticWait(6);
		browserAction.scrollToElementUsingJS(shippingAddressLine1TextInput);
		if (browserName.contains("WindowsChrome") || browserName.contains("Firefox")
				|| browserName.contains("MacSafari")) {

			browserAction.selectFromList(country_AreaDropDwnBtn_HK, country_AreaDropDwn_List_HK,
					addressData.get("state"), "", "Area Selected from Dropdown as : " + addressData.get("state"));
			browserAction.setText(mobileTextInput, addressData.get("phoneNumber"), "",
					"Phone Number Set as : " + addressData.get("phoneNumber"));
			browserAction.selectFromList(country_DistrictDropDwnBtn_HK, country_DistrictDropDwn_List_HK,
					addressData.get("city"), "", "District selected from Dropdown as : " + addressData.get("city"));
		} else {

			browserAction.selectFromDD(countrySelect_Area_HK, addressData.get("state"), "",
					"Area Selected from Dropdown as : " + addressData.get("state"));
			browserAction.setText(mobileTextInput, addressData.get("phoneNumber"), "",
					"Phone Number Set as : " + addressData.get("phoneNumber"));
			browserAction.selectFromDD(countrySelect_District_HK_drpdwn, addressData.get("city"), "",
					"District selected from Dropdown as : " + addressData.get("city"));
		}
	}

	/**
	 * @description : Select Postal Code State and Phone
	 * @throws Exception
	 */
	public void selectPostalCodeandStateandPhone(Map<String, String> addressData) throws Exception {
		if (addressData.get("zipcodeFlag").contains("yes")) {
			browserAction.setText(postalCodeTextInput, addressData.get("zipcode"), "",
					"Postal Code Set as : " + addressData.get("zipcode"));
		}
		if (addressData.get("stateFlag").contains("yes")) {
			if (browserName.contains("Android") || browserName.contains("Linux") || browserName.contains("IosSafari")) {
				browserAction.waitForElementClickable(countrySelectdrpdwn);
				browserAction.selectFromDD(countrySelectdrpdwn, addressData.get("state"), "",
						"State Selected from Dropdown as : " + addressData.get("state"));
			} else {
				browserAction.selectFromList(stateDropDwnBtn, stateDropDwnList, addressData.get("state"), "",
						"State Selected from Dropdown as : " + addressData.get("state"));
			}
		}
		browserAction.setTextJS(mobileTextInput, addressData.get("phoneNumber"), "",
				"Phone Number Set as : " + addressData.get("phoneNumber"));
	}

	/**
	 * @description : Click on Pay Order Button | Checkout Shipping Page
	 * @throws Exception
	 */
	public void clickConfirmAndPayOrderButton() throws Exception {

		if (testCaseData.get("Payment_MethodType").equals("Affirm Monthly Payments")) {
			browserAction.waitForElementClickable(placeOrderAndPayButton_affirm_pay);
			browserAction.clickJS(placeOrderAndPayButton_affirm_pay, imgPath,
					"Click Performed on 'Place Order and Pay' Button");
		} else {
			browserAction.waitForElementClickable(placeOrderAndPayButton);
			browserAction.clickJS(placeOrderAndPayButton, imgPath, "Click Performed on 'Place Order and Pay' Button");
		}
		browserAction.WaittoPageLoad();
		// check3DSecurePayment();
	}

	/**
	 * @description : Perform 3D Secure Action | After place Order
	 * @throws Exception
	 */
	public void check3DSecurePayment() throws Exception {
		try {

			if (testCaseData.get("CountryCode").equals("BE") || testCaseData.get("CountryCode").equals("BG")
					|| testCaseData.get("CountryCode").equals("SE") || testCaseData.get("CountryCode").equals("IT")
					|| testCaseData.get("CountryCode").equals("NL") || testCaseData.get("CountryCode").equals("IE")) {
				browserAction.waitForElementVisibility(soaprequest_secure3Diframe);

				if (browserAction.isElementPresent(soaprequest_secure3Diframe)) {
					browserAction.switchToFrame(soaprequest_secure3Diframe, "", "Switch To Secure Frame");
					browserAction.switchToFrame(secure3Diframe, "", "Switch To Secure Frame");

					browserAction.setText(secure3Dpassword, "1234");
					browserAction.Submit(secure3Dpassword);
					browserAction.switchBackToDefaultContent("", "SWITCH TO PARENT WINDOW");
				}
			}
		} catch (Exception e) {
			System.out.println("3D Secure Does not exist");
			browserAction.switchBackToDefaultContent("", "SWITCH TO PARENT WINDOW");
		}
	}

	/**
	 * @description : Select Accept Terms and condition before placing order
	 * @throws Exception
	 */
	public void acceptgucciTermsandConditionandProceed_CC() throws Exception {

		browserAction.WaittoPageLoad();

		if (testCaseData.get("Acknowledgement_Flag").equalsIgnoreCase("yes")) {
			browserAction.waitForPageDOMLoad(2000l);

			if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")
					&& testCaseData.get("Test_Category").contains("Registered")) {
			} else {
				if (!browserName.contains("Linux") && !browserName.contains("Android")) {
					browserAction.waitForElementClickable(shippingAddress_edit);
					browserAction.scrollToElementUsingJS(shippingAddress_edit);
				}
				if (!browserAction.isSelected(acceptTermsAndConditionscheckbox)) {
					// browserAction.staticWait(5);
					browserAction.clickJS(acceptTermsAndConditionscheckbox, imgPath,
							"Accept Terms and condition clicked");
				}
			}
		}

	}

	/**
	 * @description : Click Paypal CTA | Place Order
	 * @throws Exception
	 */
	public void clickPaywithPayPalCTA() throws Exception {

		browserAction.waitForPageDOMLoad(2000l);
		if (testCaseData.get("Acknowledgement_Flag").equalsIgnoreCase("yes")) {
			browserAction.clickJS(acceptTermsAndConditionsLabel, "", "Accept Terms and condition clicked");
		}
		browserAction.click(paypalMethodCTA, "", "Selected payPal Tab");
		browserAction.WaittoPageLoad();
	}

	/*
	 * 
	 */
	public boolean validateSelectedShippingAddress(Map<String, String> addressData) throws Exception {

		if (addressData.get("countryCode").equalsIgnoreCase("JP") && (testCaseData.get("Browser_Name").contains("Linux")
				|| testCaseData.get("Browser_Name").contains("Android"))) {
			report.logStepToReport(LogStatus.PASS, "Validate Selected Shipping Address details",
					"Skipping validation of Selected Shipping Address for JP Android & Linux View", imgPath);
			return true;
		}

		String shippingFormName = "";
		String shippingFormAddress = "";
		String shippingFormCityStateZipcode = "";
		String shippingFormPhoneExtNumber = "";
		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			browserAction.waitForElementClickable(selectedShippingAddress_Name_JP);
			shippingFormName = browserAction.getText(selectedShippingAddress_Name_JP);
			shippingFormAddress = browserAction.getText(selectedShippingAddress_AddressLine1_2_JP);
			shippingFormCityStateZipcode = browserAction.getText(selectedShippingAddress_Zipcode_JP);
			shippingFormPhoneExtNumber = browserAction.getText(selectedShippingAddress_PhoneExtNumber_JP);

		} else {
			browserAction.waitForElementClickable(selectedShippingAddress_Name);
			shippingFormName = browserAction.getText(selectedShippingAddress_Name);
			shippingFormAddress = browserAction.getText(selectedShippingAddress_AddressLine1_2);
			shippingFormCityStateZipcode = browserAction.getText(selectedShippingAddress_CityStateZipcode);
			shippingFormPhoneExtNumber = browserAction.getText(selectedShippingAddress_PhoneExtNumber);
		}

		browserAction.scrollToElementUsingJS(shippingAddressEditButton);
		if (shippingFormName.length() == 0 || shippingFormAddress.length() == 0
				|| shippingFormCityStateZipcode.length() == 0 || shippingFormPhoneExtNumber.length() == 0) {
			report.logStepToReport(LogStatus.FAIL, "Validate Pre Filled Address details",
					"Validation of Selected Shipping Address Failed - Address populated as - " + "<br>" + "Name : "
							+ shippingFormName + "<br>" + "Address : " + shippingFormAddress + "<br>"
							+ "City State Zipcode : " + shippingFormCityStateZipcode + "<br>"
							+ "Phone Extension & Number : " + shippingFormPhoneExtNumber,
					imgPath);
			return false;

		}

		/*
		 * Perform Data validation
		 */

		boolean addressValidation = true;

		if (!(shippingFormName.contains(addressData.get("firstName"))
				&& shippingFormName.contains(addressData.get("lastName")))) {
			addressValidation = false;
		}

		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			if (!(shippingFormAddress.contains(addressData.get("addressLine1")))) {
				addressValidation = false;
			}
		} else {
			if (!(shippingFormAddress.contains(addressData.get("addressLine1"))
					&& shippingFormAddress.contains(addressData.get("addressLine2")))) {
				addressValidation = false;
			}
			if (addressData.get("cityFlag").equalsIgnoreCase("Yes")) {
				if (!shippingFormCityStateZipcode.contains(addressData.get("city"))) {
					addressValidation = false;
				}
			}
		}

		if (addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
			if (!shippingFormCityStateZipcode.replaceAll(" ", "")
					.contains(addressData.get("zipcode").replaceAll(" ", ""))) {
				addressValidation = false;
			}
		}

		/*
		 * Applying fix just to check the flow
		 */
		if (!testCaseData.get("Payment_MethodType").equals("PaypalExpress")) {
			if (!(shippingFormPhoneExtNumber.contains(addressData.get("phoneExtension"))
					&& shippingFormPhoneExtNumber.replaceAll(" ", "").contains(addressData.get("phoneNumber")))) {
				addressValidation = false;
			}
		}

		if (addressValidation == true)

		{
			if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.PASS, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("No")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.PASS, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("No")) {
				report.logStepToReport(LogStatus.PASS, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			} else {
				report.logStepToReport(LogStatus.PASS, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			}
		} else {
			if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.FAIL, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("No")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.FAIL, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("No")) {
				report.logStepToReport(LogStatus.FAIL, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + shippingFormCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			} else {
				report.logStepToReport(LogStatus.FAIL, "Validate Pre Filled Address details",
						"Validation of Selected Shipping Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + shippingFormName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ shippingFormAddress +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + shippingFormPhoneExtNumber,

						imgPath);
			}
		}
		return addressValidation;
	}

	/*
	 * 
	 */
	public boolean validateSelectedCreditCardAndBillingAddressDetails(Map<String, String> addressData)
			throws Exception {

		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")
				&& (testCaseData.get("Browser_Name").contains("Linux")
						|| testCaseData.get("Browser_Name").contains("Android"))) {
			report.logStepToReport(LogStatus.PASS, "Validate Selected Credit Card & Billing Address details",
					"Skipping validation of Selected Credit Card & Billing Address for JP Android & Linux View",
					imgPath);
			return true;
		}

		String creditCardNumber = browserAction.getText(selectedCreditCardNumber);
		creditCardNumber = creditCardNumber.substring(creditCardNumber.lastIndexOf("*") + 1);

		String creditCardHolderName = browserAction.getText(selectedCreditCardHolderName);

		String creditCardExpiry = browserAction.getText(selectedCreditCardExpiry);

		String billingAddressName = "";
		String billingAddressAddressLine1_2 = "";
		String billingAddressCityStateZipcode = "";
		String billingAddressPhoneExtNumber = "";
		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")) {
			billingAddressName = browserAction.getText(selectedBillingAddressFirstLastName_JP);

			billingAddressAddressLine1_2 = browserAction.getText(selectedBillingAddressAddressLine1_2_JP);

			billingAddressCityStateZipcode = browserAction.getText(selectedBillingAddressZipcode_JP);

			billingAddressPhoneExtNumber = browserAction.getText(selectedBillingAddressPhoneExtNumber_JP);
		} else {
			billingAddressName = browserAction.getText(selectedBillingAddressFirstLastName);

			billingAddressAddressLine1_2 = browserAction.getText(selectedBillingAddressAddressLine1_2);

			billingAddressCityStateZipcode = browserAction.getText(selectedBillingAddressCityStateZipcode);

			billingAddressPhoneExtNumber = browserAction.getText(selectedBillingAddressPhoneExtNumber);
		}
		System.out.println("Details of Credit Card - " + creditCardNumber + creditCardHolderName + creditCardExpiry);
		System.out.println("Details of Billing Address - " + billingAddressName + billingAddressAddressLine1_2
				+ billingAddressCityStateZipcode + billingAddressPhoneExtNumber);

		if (creditCardNumber.length() == 0 || creditCardHolderName.length() == 0 || creditCardExpiry.length() == 0
				|| billingAddressName.length() == 0 || billingAddressAddressLine1_2.length() == 0
				|| billingAddressCityStateZipcode.length() == 0 || billingAddressPhoneExtNumber.length() == 0) {
			report.logStepToReport(LogStatus.FAIL, "Validate Selected Credit Card & Billing Address details",
					"Validation of Selected Card & Address Failed - Details Populated as - " + "<br>" + "Card Number : "
							+ creditCardNumber + "<br>" + "Card Holder Name : " + creditCardHolderName + "<br>"
							+ "Card Expiry : " + creditCardExpiry + "<br>" + "Name : " + billingAddressName + "<br>"
							+ "Address : " + billingAddressAddressLine1_2 + "<br>" + "City State Zipcode : "
							+ billingAddressCityStateZipcode + "<br>" + "Phone Extension & Number : "
							+ billingAddressPhoneExtNumber,
					imgPath);

			return false;

		}

		/*
		 * Perform Data validation
		 */

		boolean billingAddressValidations = true;
		boolean creditCardValidations = true;

		if (!(testCaseData.get("Payment_CardNumber").replaceAll(" - ", "").contains(creditCardNumber))) {
			creditCardValidations = false;
		}

		if (!(creditCardHolderName.contains(testCaseData.get("Payment_NameOnCard")))) {
			creditCardValidations = false;
		}

		if (!(creditCardExpiry.contains(testCaseData.get("Payment_ExpiryMonth"))
				&& creditCardExpiry.contains(testCaseData.get("Payment_ExpiryYear")))) {
			creditCardValidations = false;
		}

		if (!(billingAddressName.contains(addressData.get("firstName"))
				&& billingAddressName.contains(addressData.get("lastName")))) {
			billingAddressValidations = false;
		}

		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			if (!(billingAddressAddressLine1_2.contains(addressData.get("addressLine1")))) {
				billingAddressValidations = false;
			}
		} else {
			if (!(billingAddressAddressLine1_2.contains(addressData.get("addressLine1"))
					&& billingAddressAddressLine1_2.contains(addressData.get("addressLine2")))) {
				billingAddressValidations = false;
			}
			if (addressData.get("cityFlag").equalsIgnoreCase("Yes")) {
				if (!billingAddressCityStateZipcode.contains(addressData.get("city"))) {
					billingAddressValidations = false;
				}
			}
		}

		if (addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
			if (!billingAddressCityStateZipcode.replaceAll(" ", "")
					.contains(addressData.get("zipcode").replaceAll(" ", ""))) {
				billingAddressValidations = false;
			}
		}

		/*
		 * Applying fix just to check the flow
		 */
		if (!(billingAddressPhoneExtNumber.contains(addressData.get("phoneExtension"))
				&& billingAddressPhoneExtNumber.replaceAll(" ", "").contains(addressData.get("phoneNumber")))) {
			billingAddressValidations = false;
		}

		if (creditCardValidations == true) {
			report.logStepToReport(LogStatus.PASS, "Validate Credit Card Details",
					"Validation of Selected Credit Card Details Passed "

							+ "<br>" + "Expected Card Holder Name : " + testCaseData.get("Payment_NameOnCard") + "<br>"
							+ "Actual Card Holder Name : " + creditCardHolderName +

							"<br>" + "Expected Card Number : " + testCaseData.get("Payment_CardNumber") + "<br>"
							+ "Actual Card Number : " + creditCardNumber +

							"<br>" + "Expected Card Expiry Month : " + testCaseData.get("Payment_ExpiryMonth") + "<br>"
							+ "Expected Card Expiry Year : " + testCaseData.get("Payment_ExpiryYear") + "<br>"
							+ "Actual Card Expiry : " + creditCardExpiry,

					imgPath);
		} else {
			report.logStepToReport(LogStatus.FAIL, "Validate Credit Card Details",
					"Validation of Selected Credit Card Details Failed "

							+ "<br>" + "Expected Card Holder Name : " + testCaseData.get("Payment_NameOnCard") + "<br>"
							+ "Actual Card Holder Name : " + creditCardHolderName +

							"<br>" + "Expected Card Number : " + testCaseData.get("Payment_CardNumber") + "<br>"
							+ "Actual Card Number : " + creditCardNumber +

							"<br>" + "Expected Card Expiry Month : " + testCaseData.get("Payment_ExpiryMonth") + "<br>"
							+ "Expected Card Expiry Year : " + testCaseData.get("Payment_ExpiryYear") + "<br>"
							+ "Actual Card Expiry : " + creditCardExpiry,

					imgPath);
		}

		if (billingAddressValidations == true) {

			if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.PASS, "Validate Selected Address details",
						"Validation of Selected Billing Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("No")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.PASS, "Validate Selected Address details",
						"Validation of Selected Billing Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("No")) {
				report.logStepToReport(LogStatus.PASS, "Validate Selected Address details",
						"Validation of Selected Billing Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			} else {
				report.logStepToReport(LogStatus.PASS, "Validate Selected Address details",
						"Validation of Selected Billing Address Passed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			}

		} else {
			if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.FAIL, "Validate Selected Address details",
						"Validation of Selected Billing Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("No")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				report.logStepToReport(LogStatus.FAIL, "Validate Selected Address details",
						"Validation of Selected Billing Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected Zip Code : " + addressData.get("zipcode") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			} else if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("No")) {
				report.logStepToReport(LogStatus.FAIL, "Validate Selected Address details",
						"Validation of Selected Billing Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected City : " + addressData.get("city") + "<br>"
								+ "Actual City State Zipcode : " + billingAddressCityStateZipcode +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			} else {
				report.logStepToReport(LogStatus.FAIL, "Validate Selected Address details",
						"Validation of Selected Billing Address Failed "

								+ "<br>" + "Expected Name : " + addressData.get("firstName") + " "
								+ addressData.get("lastName") + "<br>" + "Actual Name : " + billingAddressName +

								"<br>" + "Expected Address Line 1 : " + addressData.get("addressLine1") + "<br>"
								+ "Expected Line 2 : " + addressData.get("addressLine2") + "<br>" + "Actual Address : "
								+ billingAddressAddressLine1_2 +

								"<br>" + "Expected Phone Extension & Phone Number : "
								+ addressData.get("phoneExtension") + " " + addressData.get("phoneNumber") + "<br>"
								+ "Actual Phone Extension & Phone Number : : " + billingAddressPhoneExtNumber,

						imgPath);
			}
		}

		if (creditCardValidations == true && billingAddressValidations == true) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * 
	 */

	public boolean validatePaypalAccountText() throws Exception {
		String paypalText = "";
		if (testCaseData.get("Browser_Name").contains("Linux")
				|| testCaseData.get("Browser_Name").contains("Android")) {
			paypalText = browserAction.getText(paypalAccountText_Mobile);
		} else {
			paypalText = browserAction.getText(paypalAccountText);
		}
		if (paypalText.contains("PayPal account")) {
			report.logStepToReport(LogStatus.PASS, "Validate Paypal Account Text",
					"Validation of Paypal Account Text Successful" + "<br>"
							+ "Expected Value (contained) : PayPal account" + "<br>" + "Actual value : "
							+ browserAction.getText(paypalAccountText),
					"");
			return true;
		} else {
			report.logStepToReport(LogStatus.FAIL, "Validate Paypal Account Text",
					"Validation of Paypal Account Text Failed" + "<br>" + "Expected Value (contained) : PayPal account"
							+ "<br>" + "Actual value : " + browserAction.getText(paypalAccountText),
					"");
			return false;
		}

	}

	/*
	 * description : Select Credit card based on City or Zipcode
	 * 
	 */
	public void selectCreditCardAndSetSecurityCodeforPayment(Map<String, String> addressData) throws Exception {
		browserAction.scrollToElementUsingJS(creditCardsInfo.get(0));
		report.logStepToReport(LogStatus.INFO, "Select Credit Card from Existing card",
				"Selecting Credit Card from Existing(saved) Cards with Billing Address City/Zipcode as : "
						+ addressData.get("city") + "/" + addressData.get("zipcode"),
				imgPath);
		boolean cardFound = false;
		browserAction.waitForPageDOMLoad(2000L);
		String cardId = "";
		for (WebElement cardInfo : creditCardsInfo) {
			String cardDetails = browserAction.getText(cardInfo);
			if (addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")
					&& addressData.get("cityFlag").equalsIgnoreCase("Yes")) {
				if (cardDetails.contains(addressData.get("zipcode")) && cardDetails.contains(addressData.get("city"))) {
					cardId = browserAction.getAttribute(cardInfo, "id");
					cardFound = true;
					break;
				}
			}

			else if (addressData.get("cityFlag").equalsIgnoreCase("Yes")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("No")) {
				if (cardDetails.contains(addressData.get("city"))) {
					cardId = browserAction.getAttribute(cardInfo, "id");
					cardFound = true;
					break;
				}
			}

			else if (addressData.get("cityFlag").equalsIgnoreCase("No")
					&& addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				if (cardDetails.contains(addressData.get("zipcode"))) {
					cardId = browserAction.getAttribute(cardInfo, "id");
					cardFound = true;
					break;
				}
			}

			else {
				report.logStepToReport(LogStatus.FAIL, "Select Credit Card from Existing card",
						"Zipcode & City Flag status No & No - Recheck test data", imgPath);
			}
		}

		if (cardFound == true) {
			cardId = cardId.substring(cardId.lastIndexOf("-") + 1).trim();

			String radioButtonXpath = "//input[@id='payment-credit-card-" + cardId + "']";

			WebElement radioButton = browserAction.findElementByxPpath(radioButtonXpath);
			browserAction.waitForElementVisibility(radioButton);
			browserAction.clickJS(radioButton);

			String securityCodeXPath = "//input[@id='input-credit-card-code-" + cardId + "']";

			WebElement securityCodeInput = browserAction.findElementByxPpath(securityCodeXPath);
			browserAction.waitForElementVisibility(securityCodeInput);
			browserAction.scrollToElementUsingJS(securityCodeInput);
			browserAction.setText(securityCodeInput, testCaseData.get("Payment_SecurityCode"), imgPath,
					"Security Code of Selected Card is Set as : " + testCaseData.get("Payment_SecurityCode"));
		} else {
			report.logStepToReport(LogStatus.FAIL, "Select Credit Card from Existing card",
					"Credit Card Not Found in Existing cards", imgPath);
		}

	}

	/*
	 * description : Select Shipping Address based on City or Zipcode
	 * 
	 */
	public void selectShippingAddressFromPreSavedAddresses(Map<String, String> addressData) throws Exception {
		browserAction.waitForPageDOMLoad(2000L);
		browserAction.scrollToElementUsingJS(preSavedAddressList.get(0));
		report.logStepToReport(LogStatus.INFO, "Select Shipping Address from Existing Addresses",
				"Selecting Shipping Address from Existing(saved) Addresses", imgPath);
		boolean addressFound = false;
		String forAttributeValue = "";
		for (WebElement addressInfo : preSavedAddressList) {
			String addressDetails = browserAction.getText(addressInfo);
			System.out.println(addressDetails);
			if (addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				if (addressDetails.contains(addressData.get("zipcode"))) {
					forAttributeValue = browserAction.getAttribute(addressInfo, "for");
					addressFound = true;
					break;
				}
			}

			if (addressData.get("city").equalsIgnoreCase("Yes")) {
				if (addressDetails.contains(addressData.get("city"))) {
					forAttributeValue = browserAction.getAttribute(addressInfo, "for");
					addressFound = true;
					break;
				}
			}
		}

		if (addressFound == true) {
			String radioButtonXpath = "//input[@id='" + forAttributeValue + "']";
			WebElement radioButton = browserAction.findElementByxPpath(radioButtonXpath);
			browserAction.waitForElementVisibility(radioButton);
			browserAction.scrollToElementUsingJS(radioButton);
			browserAction.clickJS(radioButton, imgPath, "Click Performed on radio button of Selected Shipping Address");
		} else {
			report.logStepToReport(LogStatus.FAIL, "Select Shipping Address from Existing Addresses",
					"Shipping Address Not Found in Existing Addresses", imgPath);
		}

	}

	public void selectBillingAddressFromPreSavedAddresses(Map<String, String> addressData) throws Exception {
		browserAction.waitForPageDOMLoad(2000L);
		browserAction.scrollToElementUsingJS(preSavedBillingAddressList.get(0));
		report.logStepToReport(LogStatus.INFO, "Select Billing Address from Existing Addresses",
				"Selecting Billing Address from Existing(saved) Addresses", imgPath);

		int counter = 0;
		for (WebElement addressInfo : preSavedBillingAddressList) {
			String addressDetails = browserAction.getText(addressInfo);
			System.out.println(addressDetails);
			if (addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
				if (addressDetails.contains(addressData.get("zipcode"))) {
					counter++;
					break;
				}
			}

			if (addressData.get("city").equalsIgnoreCase("Yes")) {
				if (addressDetails.contains(addressData.get("city"))) {
					counter++;
					break;
				}
			}
		}

		if (counter != 0) {
			String radioButtonXpath = "//input[@id='shipping-" + counter + "']";
			WebElement radioButton = browserAction.findElementByxPpath(radioButtonXpath);
			browserAction.waitForElementVisibility(radioButton);
			browserAction.scrollToElementUsingJS(radioButton);
			browserAction.clickJS(radioButton, imgPath, "Click Performed on Radio Button of Selected Billing Address");
		} else {
			report.logStepToReport(LogStatus.FAIL, "Select Billing Address from Existing Addresses",
					"Billing Address Not Found in Existing Billing Addresses", imgPath);
		}

	}

	public void clickOnShippingAddressEditButton(Map<String, String> addressData) throws Exception {

		browserAction.waitForPageDOMLoad(2000L);

		if (addressData.get("countryCode").equalsIgnoreCase("JP") && (testCaseData.get("Browser_Name").contains("Linux")
				|| testCaseData.get("Browser_Name").contains("Android"))) {
			browserAction.waitForElementClickable(shippingAddressEditButton_JP_Mobile);
			browserAction.clickJS(shippingAddressEditButton_JP_Mobile, "",
					"Click Performed on Edit Shipping Address Button");
		} else {
			browserAction.waitForElementClickable(shippingAddressEditButton);
			browserAction.clickJS(shippingAddressEditButton, "", "Click Performed on Edit Shipping Address Button");
		}
	}

	public void clickOnNewAddressRadioButton() throws Exception {
		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")) {
			browserAction.isElementPresent(shippingAddress_NewAddressRadioButton_JP);
			browserAction.clickJS(shippingAddress_NewAddressRadioButton_JP, "",
					"Click Performed on New Address RadioButton");
		} else {
			browserAction.isElementPresent(shippingAddress_NewAddressRadioButton);
			browserAction.clickJS(shippingAddress_NewAddressRadioButton, "",
					"Click Performed on New Address RadioButton");
		}
	}

	public void clickOnNewAddressRadioButton_BillingSection() throws Exception {
		// browserAction.waitForPageDOMLoad(2000L);
		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")) {
			browserAction.isElementPresent(billingAddress_NewAddressRadioButton_JP);
			browserAction.clickJS(billingAddress_NewAddressRadioButton_JP, "",
					"Click Performed on New Address RadioButton");
		} else {
			browserAction.isElementPresent(billingAddress_NewAddressRadioButton);
			browserAction.clickJS(billingAddress_NewAddressRadioButton, "",
					"Click Performed on New Address RadioButton");
		}
	}

	public void clickSaveChangesButton(Map<String, String> addressData) throws Exception {
		browserAction.waitForPageDOMLoad(2000L);
		browserAction.isElementPresent(saveChangesButn);
		if (addressData.get("countryCode").equalsIgnoreCase("JP") && (testCaseData.get("Browser_Name").contains("Linux")
				|| testCaseData.get("Browser_Name").contains("Android"))) {
			browserAction.clickJS(saveChangesButn_JP_Mobile, "", "Click Performed on Save Changes Button");
		} else {
			browserAction.clickJS(saveChangesButn, "", "Click Performed on Save Changes Button");
		}
	}

	public void clickOnGiftingEditButton() throws Exception {
		browserAction.WaittoPageLoad();
		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")
				&& (testCaseData.get("Browser_Name").contains("Linux")
						|| testCaseData.get("Browser_Name").contains("Android"))) {
			browserAction.waitForElementClickable(giftingEditButton_JP_Mobile);
			browserAction.clickJS(giftingEditButton_JP_Mobile, "", "Click Performed on Edit Gifting Button");
			browserAction.waitForPageDOMLoad(5000L);
			browserAction.clickJS(giftingEditButton_JP_Mobile, "", "Click Performed on Edit Gifting Button");
		} else {
			browserAction.waitForElementClickable(giftingEditButton);
			browserAction.clickJS(giftingEditButton, "", "Click Performed on Edit Gifting Button");
			browserAction.waitForPageDOMLoad(5000L);
			browserAction.clickJS(giftingEditButton, "", "Click Performed on Edit Gifting Button");
		}
	}

	public void clickOnPaymentEditButton() throws Exception {
		browserAction.waitForPageDOMLoad(5000L);
		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")
				&& (testCaseData.get("Browser_Name").contains("Linux")
						|| testCaseData.get("Browser_Name").contains("Android"))) {
			browserAction.waitForElementClickable(paymentEditButton_JP_Mobile);
			browserAction.clickJS(paymentEditButton_JP_Mobile, "", "Click Performed on Edit Payment Button");
		} else {
			browserAction.waitForElementClickable(paymentEditButton);
			browserAction.clickJS(paymentEditButton, "", "Click Performed on Edit Payment Button");
		}
	}

	public void addGiftingMessage() throws Exception {
		browserAction.waitForPageDOMLoad(3000L);
		browserAction.isElementPresent(giftingMessageTextArea);
		browserAction.setText(giftingMessageTextArea, testCaseData.get("Order_Gifting_Message"), imgPath,
				"Gifting Message Entered as - " + testCaseData.get("Order_Gifting_Message"));
	}

	public boolean verifyGiftmessageAdded(Map<String, String> addressData) throws Exception {
		browserAction.waitForPageDOMLoad(2000L);

		if (addressData.get("countryCode").equalsIgnoreCase("JP") && (testCaseData.get("Browser_Name").contains("Linux")
				|| testCaseData.get("Browser_Name").contains("Android"))) {
			report.logStepToReport(LogStatus.PASS, "Validate Gifting Message Added",
					"Skipping Gifting Message Validation for JP Android & Linux View ", imgPath);
			return true;
		}

		String giftingMessage = browserAction.getText(giftingMessageText);
		browserAction.scrollToElementUsingJS(giftingEditButton);
		if (giftingMessage.contains(testCaseData.get("Order_Gifting_Message"))) {
			report.logStepToReport(LogStatus.PASS, "Verify Added Gifting Message",
					"Gifting Message Verified " + "<br>" + "Expected Value : "
							+ testCaseData.get("Order_Gifting_Message") + "<br>" + "Actual Value : " + giftingMessage,
					imgPath);
			return true;
		} else {
			report.logStepToReport(LogStatus.FAIL, "Verify Added Gifting Message",
					"Gifting Message Failed " + "<br>" + "Expected Value : " + testCaseData.get("Order_Gifting_Message")
							+ "<br>" + "Actual Value : " + giftingMessage,
					imgPath);
			return false;
		}
	}

	public void clickContinueToPayment_GiftingSection() throws Exception {
		browserAction.waitForPageDOMLoad(2000L);
		browserAction.isElementPresent(giftingContinueToPayment);
		browserAction.clickJS(giftingContinueToPayment, "", "Click Performed on Continue To Payment Button");
	}

	public void clickOnNewCreditCardRadioButton() throws Exception {
		browserAction.isElementPresent(paymentSection_NewCreditCardRadioButton);
		browserAction.clickJS(paymentSection_NewCreditCardRadioButton, "",
				"Click Performed on New Credit Card RadioButton");
	}

	public void clickCreditCardLinkOnPageOpen(Map<String, String> testData) throws Exception {
		if (!(testData.get("Browser_Name").contains("Windows") || testData.get("Browser_Name").contains("MacSafari")
				|| testData.get("Browser_Name").contains("Firefox"))) {
			browserAction.WaittoPageLoad();
			browserAction.waitForElementClickable(creditCardLink);
			if (testData.get("Browser_Name").contains("IosSafari")) {
				browserAction.clickJS(creditCardLink_ios, imgPath, "Click performed on Credit Card Link");
			} else {
				browserAction.scrollToElementUsingActions(shippingAddress_edit);
				browserAction.click(creditCardLink, imgPath, "Click performed on Credit Card Link");
			}
		}
	}

}