package pagesObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import controllers.Executor;
import helpers.BrowserActions;

import helpers.Reporting;

public class OrderConfirmationPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;

	public OrderConfirmationPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {

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
	@FindBy(how = How.XPATH, using = "//h1[contains(@class,'hero-title')]")
	private WebElement orderConfirmationMsg;

	@FindBy(how = How.XPATH, using = "//div[@id='page']//h1/following-sibling::section//p")
	private WebElement orderNumberConfirmation;

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'View/Print Confirmation')])[1]")
	private WebElement viewPrintConfirmationButton;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : verify the Order confirmation message except Japan
	 * @return
	 * @throws Exception
	 */
	public Boolean verifyOrderConfirmationMessage() throws Exception {
		try {
			browserAction.waitForURLChange("checkout/orderConfirmation", 2000l, 15);
			String registeredEmail = null;
			browserAction.waitForElementVisibility(orderConfirmationMsg);
			String confirmMsg = orderConfirmationMsg.getText();
			String orderNumber = orderNumberConfirmation.getText();
			if (testCaseData.get("Payment_MethodType").contains("PaypalExpress")) {
				registeredEmail = testCaseData.get("Paypal_user_email").toLowerCase();
			} else if (testCaseData.get("Payment_MethodType").contains("Amazon")) {
				registeredEmail = testCaseData.get("Amazon_loginEmail").toLowerCase();
			} else {
				registeredEmail = testCaseData.get("registeredEmail").toLowerCase();
			}

			if (confirmMsg.contains("THANK YOU FOR YOUR ORDER!")) {

				orderNumber = orderNumber.replace("A confirmation email for order", "");
				orderNumber = orderNumber.replace("will be sent shortly to:", "");
				orderNumber = orderNumber.replace(registeredEmail, "").replace("#", "");
				orderNumber = orderNumber.trim().replace("\n", "");

				System.out.println("***********************************");
				System.out.println(orderNumber);
				System.out.println("***********************************");
				testCaseData.put("orderNumber", orderNumber);

				report.assertThat(true,
						"Order successfully placed with order number <font color=#00b3b3> '" + orderNumber + "'",
						"Order confirmation message not verified");

				return true;
			} else {
				report.assertThat(false, "Order successfully placed with confirmation message",
						"Order confirmation message not verified.. message - " + confirmMsg);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.assertThat(false, "Order successfully placed with confirmation message",
					"Order confirmation message not verified due to exception - "
							+ e.getMessage().split("Session info:")[0]);
			throw new Exception("Test Case Failed");
		}

		return false;
	}

	/**
	 * @description : verify the Order confirmation message for Japan
	 * @return
	 * @throws Exception
	 */
	public Boolean verifyOrderConfirmationMessage_JP() throws Exception {
		browserAction.WaittoPageLoad();
		try {
			browserAction.waitForURLChange("checkout/orderConfirmation", 2000l, 15);
			browserAction.waitForElementVisibility(orderConfirmationMsg);
			String confirmMsg = orderConfirmationMsg.getText();
			String orderNumber = orderNumberConfirmation.getText();
			String registeredEmail = null;

			if (testCaseData.get("Payment_MethodType").contains("Amazon")) {
				registeredEmail = testCaseData.get("Amazon_loginEmail").toLowerCase();
			} else {
				registeredEmail = testCaseData.get("registeredEmail").toLowerCase();
			}

			if (confirmMsg.contains("ご注文ありがとうございます。")) {

				orderNumber = orderNumber.replace("ご注文番号#", "").replace("の確認メールは、まもなく以下アドレス宛てに送信いたします。", "")
						.replace("\n", "").replace(registeredEmail, "");
				orderNumber = orderNumber.trim();

				System.out.println(orderNumber);

				System.out.println("***********************************");
				System.out.println(orderNumber);
				System.out.println("***********************************");
				testCaseData.put("orderNumber", orderNumber);
				report.assertThat(true, "Order successfully placed with order number " + orderNumber,
						"Order confirmation message not verified");
				return true;

			} else {
				report.assertThat(false, "Order successfully placed with confirmation message",
						"Order confirmation message not verified.. message - " + confirmMsg);
			}

		} catch (Exception e) {
			report.assertThat(false, "Order successfully placed with confirmation message",
					"Order confirmation message not verified due to exception - " + e.getMessage());
			throw new Exception("Test Case Failed");
		}
		return false;
	}

	/**
	 * @description : verify the Order confirmation message | condition check
	 * @return
	 * @throws Exception
	 */
	public void Orderconfirmation_Verification() throws Exception {
		if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")) {
			verifyOrderConfirmationMessage_JP();
		} else {
			verifyOrderConfirmationMessage();
		}
	}


}