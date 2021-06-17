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

public class ProductPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;

	public ProductPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {
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

	@FindBy(how = How.XPATH, using = "//form[@id='product-detail-add-to-shopping-bag-form']/div/button")
	private WebElement addToCartButton;

	@FindBy(how = How.XPATH, using = "(//span[contains(text(),'Bag')])[3]")
	private WebElement bagIcon;

	@FindBy(how = How.XPATH, using = "//div[@id='header-nav-bag']/div/a[contains(text(),'Checkout')]")
	private WebElement bagPageCheckOutButtonMobile;

	@FindBy(how = How.XPATH, using = "//a[@class='header-nav-checkout']")
	private WebElement bagPageCheckOutButtonMobile_JP;

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'header-nav-checkout')]")
	private WebElement checkoutButton;

	@FindBy(how = How.XPATH, using = "//div[@id='AmazonPayButtonMiniCart']")
	private WebElement amazonPayButton;

	@FindBy(how = How.XPATH, using = "//a[@class='header-nav-button-paypal']")
	private WebElement bagHoverlayPayPalButton;

	@FindBy(how = How.XPATH, using = "//a/u[contains(text(),'Add your initials')]")
	private WebElement addYourInitials;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'無料刻印サービス')]")
	private WebElement addYourInitials_JP;

	@FindBy(how = How.ID, using = "initials-input")
	private WebElement initialsInput;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'add to Bag')]")
	private WebElement addToBagButton_MonogramProduct;

	@FindBy(how = How.XPATH, using = "(//button[contains(text(),'ショッピングバッグに追加')])[2]")
	private WebElement addToBagButton_MonogramProduct_JP;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'select-char')]/select)[1]")
	private WebElement firstInitial_Select_JP;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'select-char')]/div/span)[1]")
	private WebElement firstInitial_DropDown_JP;

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'results')]/li")
	private List<WebElement> firstInitial_DropDown_Results_JP;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'select-char')]/select)[2]")
	private WebElement secondInitial_Select_JP;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'select-char')]/div/span)[2]")
	private WebElement secondInitial_DropDown_JP;

	@FindBy(how = How.XPATH, using = "//ul[contains(@id,'results')]/li")
	private List<WebElement> secondInitial_DropDown_Results_JP;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : click on Add to cart button in PDP
	 * @throws Exception
	 */
	public void clickAddToCartButton() throws Exception {
		browserAction.waitForElementClickable(addToCartButton);
		browserAction.clickJS(addToCartButton, "", "Click Performed on 'Add to Shopping Bag' Button");
	}

	/**
	 * @description : Mouse hover on Bag icon
	 * @throws Exception
	 */
	public void hoverBagIcon() throws Exception {
		browserAction.mouseHoverOnElementUsingActions(bagIcon, imgPath, "Mouse hover on Bag Icon");

	}

	/**
	 * @description : Click on Amazon Pay on bag icon Flyout | PDP
	 * @throws Exception
	 */
	public void clickCheckOutButtonAmazonPay() throws Exception {
		browserAction.clickJS(amazonPayButton, "", "Shopping Bag Clicked");
	}

	/**
	 * @description : click on Proceed Checkout on Bag icon flyout | PDP
	 * @throws Exception
	 */
	public void clickCheckOutButton() throws Exception {
		if (browserName.contains("Android") || browserName.contains("Linux")) {
			if (testCaseData.get("CountryCode").equals("JP"))
				browserAction.clickJS(bagPageCheckOutButtonMobile_JP, "", "Click Performed on Checkout Button");
			else
				browserAction.clickJS(bagPageCheckOutButtonMobile, "", "Click Performed on Checkout Button");
		} else {
			// browserAction.waitForElementClickable(checkoutButton);
			browserAction.clickJS(checkoutButton, "", "Click Performed on Checkout Button");
		}
	}

	/**
	 * @description : click on Paypal Express Button on Bag Icon flyout | PDP
	 * @throws Exception
	 */
	public void clickPaypalExpressCheckout() throws Exception {
		browserAction.clickJS(bagHoverlayPayPalButton, "", "PayPal Express button clicked");
	}

}