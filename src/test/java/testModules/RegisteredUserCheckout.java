package testModules;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import controllers.ModuleInterface;
import controllers.TestDataCollector;
import helpers.PageObjectUtils;
import helpers.Reporting;
import pagesObjects.AmazonPaymentPage;
import pagesObjects.BillingAddressPage;
import pagesObjects.CreateAccountPage;
import pagesObjects.HomePage;
import pagesObjects.LoginPage;
import pagesObjects.MensReadyToWearPage;
import pagesObjects.OrderConfirmationPage;
import pagesObjects.PayPalPaymentPage;
import pagesObjects.ProductPage;
import pagesObjects.ShippingAddressPage;

public class RegisteredUserCheckout implements ModuleInterface {

	public HomePage objGucciHomePage;

	public MensReadyToWearPage objGucciReadyToWearPage;
	public ProductPage objGucciProductPage;
	public LoginPage objGucciLoginPage;
	public ShippingAddressPage objGucciShippingAddressPage;
	public OrderConfirmationPage objGucciOrderConfirmationPage;
	public CreateAccountPage objGucciCreateAccountPage;
	public PayPalPaymentPage objGucciPayPalPaymentPage;
	public AmazonPaymentPage objGucciAmazonPaymentPage;

	public PageObjectUtils pageObjectUtils;
	public BillingAddressPage objBillingAddressPage;

	@Override
	public void testCasesSelection(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData,
			TestDataCollector testDatacollector) {
		objGucciHomePage = new HomePage(driverObj, reportObj, testCaseData);
		objGucciReadyToWearPage = new MensReadyToWearPage(driverObj, reportObj, testCaseData);
		objGucciProductPage = new ProductPage(driverObj, reportObj, testCaseData);
		objGucciLoginPage = new LoginPage(driverObj, reportObj, testCaseData);
		objGucciShippingAddressPage = new ShippingAddressPage(driverObj, reportObj, testCaseData);
		objGucciOrderConfirmationPage = new OrderConfirmationPage(driverObj, reportObj, testCaseData);
		objGucciCreateAccountPage = new CreateAccountPage(driverObj, reportObj, testCaseData, testDatacollector);
		objGucciPayPalPaymentPage = new PayPalPaymentPage(driverObj, reportObj, testCaseData);
		pageObjectUtils = new PageObjectUtils(testCaseData);
		objBillingAddressPage = new BillingAddressPage(driverObj, reportObj, testCaseData);

		try {
			if (testCaseData.get("Payment_MethodType").contains("Paypal")) {
				paypalCheckout(testCaseData, reportObj);
			} else if (testCaseData.get("Payment_MethodType").contains("Visa")
					|| testCaseData.get("Payment_MethodType").contains("Master")
					|| testCaseData.get("Payment_MethodType").contains("AMEX")
					|| testCaseData.get("Payment_MethodType").contains("DCB")
					|| testCaseData.get("Payment_MethodType").contains("DC")
					|| testCaseData.get("Payment_MethodType").contains("JCB")
					|| testCaseData.get("Payment_MethodType").contains("SWITCH")) {
				cardCheckout(testCaseData, reportObj);
			} else {
				otherPaymentMethodCheckout(testCaseData, reportObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
			reportObj.logStepToReport(LogStatus.FAIL, "Perform Checkout",
					"Perform Checkout Faied - Exception Generated : " + e.getLocalizedMessage(), "");
		}

	}

	/*
	 * Perform Normal Cards Checkout Visa, Master, AMEX, DCB, DC, JCB & Switch
	 */

	public void cardCheckout(Map<String, String> testData, Reporting report) throws Exception {
		/*
		 * Perform Normal Checkout
		 */

		
		
		
		objGucciHomePage.closeCountrySelectPopUp(testData);
		objGucciHomePage.clickSignInLink();
		objGucciCreateAccountPage.createUserAccount();

		objGucciHomePage.selectProductBySearch(testData.get("Style_ID"));
		objGucciReadyToWearPage.SelectProductSize();
		objGucciProductPage.clickAddToCartButton();

		objGucciProductPage.clickCheckOutButton();

		objGucciShippingAddressPage.enterShippingAddress();

		objGucciShippingAddressPage.clickContinueToPaymentButtonMobile();

		// Mobile flow
		objGucciShippingAddressPage.clickCreditCardLinkOnPageOpen(testData);

		objGucciShippingAddressPage.enterPaymentDetails_CARDS();

		if (testData.get("billingAddressSameAsShippingAddressCheckbox").equalsIgnoreCase("True")) {
			objGucciShippingAddressPage.check_BillingAndShipingAddressAreSameCheckBox();
			objGucciShippingAddressPage.clickConfirmDetailsButton();
		} else {
			objGucciShippingAddressPage.uncheck_BillingAndShipingAddressAreSameCheckBox();
			objBillingAddressPage.add_Billing_Address(testData.get("BillingAddressTypeDuringCheckout"));
			objGucciShippingAddressPage.clickConfirmDetailsButton();
		}
		objGucciShippingAddressPage.clickOnGiftingEditButton();

		objGucciShippingAddressPage.addGiftingMessage();

		objGucciShippingAddressPage.clickContinueToPayment_GiftingSection();

		objGucciShippingAddressPage.verifyGiftmessageAdded(
				pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

		objGucciShippingAddressPage.validateSelectedShippingAddress(
				pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

		objGucciShippingAddressPage.validateSelectedCreditCardAndBillingAddressDetails(
				pageObjectUtils.setAddressDataMap(testData.get("BillingAddressTypeDuringCheckout")));

		objGucciShippingAddressPage.acceptgucciTermsandConditionandProceed_CC();

		objGucciShippingAddressPage.clickConfirmAndPayOrderButton();

		objGucciOrderConfirmationPage.Orderconfirmation_Verification();

	}

	/*
	 * Checkout for BPAY, Wire transfer, Affirm Monthly Payments & COD
	 */

	public void otherPaymentMethodCheckout(Map<String, String> testData, Reporting report) throws Exception {
		objGucciHomePage.closeCountrySelectPopUp(testData);
		objGucciHomePage.clickSignInLink();
		objGucciCreateAccountPage.createUserAccount();

		objGucciHomePage.selectProductBySearch(testData.get("Style_ID"));
		objGucciReadyToWearPage.SelectProductSize();
		objGucciProductPage.clickAddToCartButton();

		objGucciProductPage.clickCheckOutButton();

		objGucciShippingAddressPage.enterShippingAddress();

		objGucciShippingAddressPage.clickContinueToPaymentButtonMobile();

		// Mobile flow
		objGucciShippingAddressPage.clickCreditCardLinkOnPageOpen(testData);

		objGucciShippingAddressPage.selectPaymentMode();

		if (testData.get("billingAddressSameAsShippingAddressCheckbox").equalsIgnoreCase("True")) {
			objGucciShippingAddressPage.check_BillingAndShipingAddressAreSameCheckBox();
			objGucciShippingAddressPage.clickConfirmDetailsButton();
		} else {
			objGucciShippingAddressPage.uncheck_BillingAndShipingAddressAreSameCheckBox();
			objBillingAddressPage.add_Billing_Address(testData.get("BillingAddressTypeDuringCheckout"));
			objGucciShippingAddressPage.clickConfirmDetailsButton();
		}
		objGucciShippingAddressPage.clickOnGiftingEditButton();

		objGucciShippingAddressPage.addGiftingMessage();

		objGucciShippingAddressPage.clickContinueToPayment_GiftingSection();

		objGucciShippingAddressPage.verifyGiftmessageAdded(
				pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

		objGucciShippingAddressPage.validateSelectedShippingAddress(
				pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

		objGucciShippingAddressPage.acceptgucciTermsandConditionandProceed_CC();

		objGucciShippingAddressPage.clickConfirmAndPayOrderButton();

		objGucciOrderConfirmationPage.Orderconfirmation_Verification();

	}

	public void paypalCheckout(Map<String, String> testData, Reporting report) throws Exception {
		if (testData.get("Payment_MethodType").equalsIgnoreCase("PaypalExpress")) {

			objGucciHomePage.closeCountrySelectPopUp(testData);

			objGucciHomePage.clickSignInLink();
			objGucciCreateAccountPage.createUserAccount();

			objGucciHomePage.selectProductBySearch(testData.get("Style_ID"));
			objGucciReadyToWearPage.SelectProductSize();

			objGucciProductPage.clickAddToCartButton();
			objGucciProductPage.clickPaypalExpressCheckout();

			objGucciPayPalPaymentPage.loginIntoPayPalAccount();
			objGucciPayPalPaymentPage.selectPaypalExpressTermCondition();
			objGucciShippingAddressPage.validatePaypalAccountText();

			objGucciShippingAddressPage.clickOnGiftingEditButton();

			objGucciShippingAddressPage.addGiftingMessage();

			objGucciShippingAddressPage.clickContinueToPayment_GiftingSection();

			objGucciShippingAddressPage.clickConfirmDetailsButton();

			objGucciShippingAddressPage.verifyGiftmessageAdded(
					pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

			objGucciShippingAddressPage.validateSelectedShippingAddress(
					pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

			objGucciShippingAddressPage.acceptgucciTermsandConditionandProceed_CC();
			objGucciShippingAddressPage.clickConfirmAndPayOrderButton();
			objGucciOrderConfirmationPage.Orderconfirmation_Verification();

		} else if (testData.get("Payment_MethodType").equalsIgnoreCase("Paypal")) {
			objGucciHomePage.closeCountrySelectPopUp(testData);
			objGucciHomePage.clickSignInLink();
			objGucciCreateAccountPage.createUserAccount();
			objGucciHomePage.selectProductBySearch(testData.get("Style_ID"));
			objGucciReadyToWearPage.SelectProductSize();
			objGucciProductPage.clickAddToCartButton();
			objGucciProductPage.clickCheckOutButton();

			objGucciShippingAddressPage.enterShippingAddress();
			objGucciShippingAddressPage.clickContinueToPaymentButtonMobile();

			// Mobile flow
			objGucciShippingAddressPage.clickCreditCardLinkOnPageOpen(testData);

			objGucciShippingAddressPage.selectPaypalPaymentDetails();

			objGucciShippingAddressPage.clickOnGiftingEditButton();

			objGucciShippingAddressPage.addGiftingMessage();

			objGucciShippingAddressPage.clickContinueToPayment_GiftingSection();

			objGucciShippingAddressPage.clickConfirmDetailsButton();

			objGucciShippingAddressPage.validateSelectedShippingAddress(
					pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

			objGucciShippingAddressPage.verifyGiftmessageAdded(
					pageObjectUtils.setAddressDataMap(testData.get("ShippingAddressTypeDuringCheckout")));

			objGucciShippingAddressPage.validatePaypalAccountText();

			objGucciShippingAddressPage.clickPaywithPayPalCTA();
			objGucciPayPalPaymentPage.loginIntoPayPalAccount();
			objGucciPayPalPaymentPage.selectPaypalTermCondition();
			objGucciOrderConfirmationPage.Orderconfirmation_Verification();

		}

	}

}
