package testModules;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import controllers.ModuleInterface;
import controllers.TestDataCollector;
import helpers.Reporting;
import pagesObjects.AmazonPaymentPage;
import pagesObjects.CreateAccountPage;
import pagesObjects.HomePage;
import pagesObjects.LoginPage;
import pagesObjects.MensReadyToWearPage;
import pagesObjects.OrderConfirmationPage;
import pagesObjects.PayPalPaymentPage;
import pagesObjects.ProductPage;
import pagesObjects.ShippingAddressPage;

public class AmazonCheckout implements ModuleInterface {

	public HomePage objGucciHomePage;

	public MensReadyToWearPage objGucciReadyToWearPage;
	public ProductPage objGucciProductPage;
	public LoginPage objGucciLoginPage;
	public ShippingAddressPage objGucciShippingAddressPage;
	public OrderConfirmationPage objGucciOrderConfirmationPage;
	public PayPalPaymentPage objGucciPayPalPaymentPage;
	public AmazonPaymentPage objGucciAmazonPaymentPage;
	public CreateAccountPage objGucciCreateAccountPage;

	public void testCasesSelection(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData,
			TestDataCollector testDatacollector) {

		objGucciHomePage = new HomePage(driverObj, reportObj, testCaseData);

		objGucciReadyToWearPage = new MensReadyToWearPage(driverObj, reportObj, testCaseData);
		objGucciProductPage = new ProductPage(driverObj, reportObj, testCaseData);
		objGucciLoginPage = new LoginPage(driverObj, reportObj, testCaseData);
		objGucciShippingAddressPage = new ShippingAddressPage(driverObj, reportObj, testCaseData);
		objGucciOrderConfirmationPage = new OrderConfirmationPage(driverObj, reportObj, testCaseData);
		objGucciPayPalPaymentPage = new PayPalPaymentPage(driverObj, reportObj, testCaseData);
		objGucciAmazonPaymentPage = new AmazonPaymentPage(driverObj, reportObj, testCaseData);
		objGucciCreateAccountPage = new CreateAccountPage(driverObj, reportObj, testCaseData,testDatacollector);

		try {

			String testMethod = testCaseData.get("TestID");
			String testCategory = testCaseData.get("Test_Category");
			String paymentMethodType = testCaseData.get("Payment_MethodType");
			System.out.println("Test ID - " + testMethod);

			switch (testCategory) {
			case "Guest User-Checkout":
				switch (paymentMethodType) {
				case "Amazon":
					purchaseOrderForCountry_ENwithAmazon(testCaseData, reportObj);
					break;
				default:
					System.err.println("WRONG Payment Card Type IS ENTERED IN TEST DATA JSON.");
					System.err.println(paymentMethodType + " not found");
					break;
				}
				break;

			case "Registered User-Checkout":
				switch (paymentMethodType) {
				case "Amazon":
					purchaseOrderForCountry_ENwithAmazon_RegisteredUser(testCaseData, reportObj);
					break;
				default:
					System.err.println("WRONG Payment Card Type IS ENTERED IN TEST DATA JSON.");
					System.err.println(paymentMethodType + " not found");
					break;
				}
				break;
			default:
				System.err.println("WRONG TEST CATEGORY IS ENTERED IN TEST DATA JSON.");
				System.err.println(testCategory + " not found");
				break;
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void purchaseOrderForCountry_ENwithAmazon(Map<String, String> testCaseData, Reporting report)
			throws Exception {

		try {

			objGucciHomePage.closeCountrySelectPopUp(testCaseData);
			objGucciHomePage.selectProductBySearch(testCaseData.get("Style_ID"));
			objGucciReadyToWearPage.SelectProductSize();

			objGucciProductPage.clickAddToCartButton();
			objGucciAmazonPaymentPage.clickPayWithAmazonCTAShoppingBagPage();

			objGucciAmazonPaymentPage.loginIntoAmazonAccount();
			objGucciAmazonPaymentPage.selectOrAddAmazonAddressPhoneAndConfirm();
			objGucciAmazonPaymentPage.placeAmazonOrder();

			objGucciOrderConfirmationPage.Orderconfirmation_Verification();
		} catch (Exception e) {
			System.out.println(
					"***********************************EXCEPTION NEW****************************************************");
		}

	}

	public void purchaseOrderForCountry_ENwithAmazon_RegisteredUser(Map<String, String> testCaseData, Reporting report)
			throws Exception {

		objGucciHomePage.closeCountrySelectPopUp(testCaseData);
		objGucciHomePage.clickSignInLink();
		objGucciCreateAccountPage.createUserAccount();
		purchaseOrderForCountry_ENwithAmazon(testCaseData, report);
	}

}
