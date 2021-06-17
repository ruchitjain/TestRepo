package pagesObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import controllers.Executor;
import helpers.BrowserActions;
import helpers.Reporting;

public class AmazonPaymentPage  {
	
	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;
	

	public AmazonPaymentPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {
		driver = driverObj;
		report = reportObj;
		this.testCaseData = testCaseData;
		browserName = Executor.Devices[Integer.parseInt(Thread.currentThread().getName()) - 1];
		imgPath = report.imagePath;
		browserAction = new BrowserActions(driver, report);
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.ID, using = "AmazonPayButtonShoppingBagSummary")
	private WebElement payAmazonCTABagPage;
	

	@FindBy(how = How.XPATH, using = "//div[@id='AmazonPayButtonMiniCart']//img")
	private WebElement payAmazonCTABagPage_minicart;
	

	@FindBy(how = How.XPATH, using = "(//*[@id='order-details-availability-item']/following-sibling::a)[1]")
	private WebElement checkoutBtnShoppingCart;
	

	@FindBy(how = How.XPATH, using = "//div[@id='AmazonPayButtonMiniCart']")
	private WebElement payAmazonCTABagPage_div;
	

	@FindBy(how = How.XPATH, using = "//div[@id='AmazonPayButtonMiniCart']/img")
	private WebElement payAmazonCTABagOverlay;
	

	@FindBy(how = How.XPATH, using = "(//div[@id='AmazonPayButtonMiniCart']/following-sibling::div//div)[3]")
	private WebElement payAmazonCTABagOverlay1;
	

	@FindBy(how = How.XPATH, using = "//input[@id='ap_email']")
	private WebElement amazonLoginEmail;
	

	@FindBy(how = How.XPATH, using = "//input[@id='ap_password']")
	private WebElement amazonLoginPassword;
	

	@FindBy(how = How.XPATH, using = "//button[@class='button-text signin-button-text']")
	private WebElement amazonLoginSubmit;
	

	@FindBy(how = How.XPATH, using = "//ul[@class='info-address-detail']")
	private WebElement selectedAddressAmazon;
	

	@FindBy(how = How.XPATH, using = "//li/a/span[@class='address-text']")
	private WebElement addNewAddressAmazon;
	

	@FindBy(how = How.XPATH, using = "//span[@id='address-ui-widgets-countryCode']")
	private WebElement countryAmazon;
	

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'address-ui-widgets-countryCode-dropdown-nativeId')]")
	private List<WebElement> countryListAmazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressFullName']")
	private WebElement fullNameAmazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressLine1']")
	private WebElement addressL1Amazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressLine2']")
	private WebElement addressL2Amazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressCity']")
	private WebElement cityAmazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressStateOrRegion']")
	private WebElement stateAmazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
	private WebElement zipcodeAmazon;
	

	@FindBy(how = How.XPATH, using = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
	private WebElement phoneAmazon;
	

	@FindBy(how = How.XPATH, using = "//input[@class='a-button-input']")
	private WebElement submitNewAddressAmazon;
	

	@FindBy(how = How.XPATH, using = "//span[@ng-show='address.postalCode']")
	private WebElement listAmazonAddreses;
	

	@FindBy(how = How.XPATH, using = "//span[@class='address-text ng-binding']")
	private List<WebElement> addressListAmazon;
	

	@FindBy(how = How.XPATH, using = "//ul[@class='info-address-detail']")
	private WebElement selectedAddressDetails;
	

	@FindBy(how = How.XPATH, using = "(//span[@class='address-text ng-binding'])[2]")
	private WebElement selectedCountryAddress;
	

	@FindBy(how = How.XPATH, using = "//div/input[contains(@class,'phoneNumber_number')]")
	private WebElement phoneNumberAmazon;
	

	@FindBy(how = How.XPATH, using = "//button[@class='confirm_details_button']")
	private WebElement amazonConfirmButton;
	

	@FindBy(how = How.XPATH, using = "(//label[@class='Checkbox_container ']//span[@class='Checkbox_checkmark'])[1]")
	private WebElement amazonTermCondition;
	

	@FindBy(how = How.XPATH, using = "(//section/h2/following-sibling::a)[1]")
	private WebElement shippingAddress_edit;
	

	@FindBy(how = How.XPATH, using = "(//div[@id='app']//button[@class='place_order'])[1]")
	private WebElement amazonPlaceOrder;
	

	@FindBy(how = How.XPATH, using = "//iframe[@id='OffAmazonPaymentsWidgets0IFrame']")
	private WebElement amazonFrame;
	

	@FindBy(how = How.XPATH, using = "(//a)[1]")
	private WebElement amazonAddressChange;
	

	@FindBy(how = How.XPATH, using = "(//body[@id='body']//ul)[2]//li/a")
	private List<WebElement> amazonAddressbook;
	

	@FindBy(how = How.ID, using = "OffAmazonPaymentsWidgets0IFrame")
	private WebElement amazonaddressFrame;
	

	@FindBy(how = How.ID, using = "a-autoid-0-announce")
	private WebElement doneButton;
	

	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"widget-inner-section\")]//div[contains(@class,\"address-list-container\")]//ul[@class=\"address-list clearfix\"]//li")
	private WebElement addressListAmazonPay;
	

	@FindBy(how = How.XPATH, using = "//ul[@class='pagination']//li[contains(@class,'next')]")
	private WebElement nextButton;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-countryCode")
	private WebElement addAddressCountryDropdown;
	

	@FindBy(how = How.XPATH, using = "(//ul[@class='a-nostyle a-list-link'])[1]//li[@class='a-dropdown-item']")
	private List<WebElement> addAddressCountryDropdownList;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressFullName")
	private WebElement addAddressFullName;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressLine1")
	private WebElement addAddressAddressLine1;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressLine2")
	private WebElement addAddressAddressLine2;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressLine3")
	private WebElement addAddressAddressLine3_JP;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressCity")
	private WebElement addAddressCity;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressStateOrRegion")
	private WebElement addAddressState;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressPostalCode")
	private WebElement addAddressPostalCode;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressPostalCodeOne")
	private WebElement addAddressPostalCodeOne_JP;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressPostalCodeTwo")
	private WebElement addAddressPostalCodeTwo_JP;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressPhoneNumber")
	private WebElement addAddressPhoneNumber;
	

	@FindBy(how = How.XPATH, using = "(//input[@class='a-button-input'])[1]")
	private WebElement addAddressAddAddressButton;
	

	@FindBy(how = How.XPATH, using = "//div[@class='info']//a[contains(.,'+ Add new')]")
	private WebElement addNewButtonUS;
	

	@FindBy(how = How.XPATH, using = "//div[@class='info']//a[contains(.,'+ 新規追加')]")
	private WebElement addNewButton_JP;
	

	@FindBy(how = How.XPATH, using = "//span[@id='address-ui-widgets-enterAddressStateOrRegion']")
	private WebElement addAddressStateDropdown_JP;
	

	@FindBy(how = How.XPATH, using = "(//ul[@class='a-nostyle a-list-link'])//li")
	private List<WebElement> addAddressStateDropdownList_JP;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-original-address-block_id-input")
	private WebElement originalAddressAmazonRecom;
	

	@FindBy(how = How.ID, using = "address-ui-widgets-enterAddressFormContainer")
	private WebElement verifyAddressTextAmazon_US;
	

	@FindBy(how = How.XPATH, using = "//span[@id='a-autoid-2']//span[@class='a-button-inner']")
	private WebElement saveAddressButtonAmazon_US;
	

	boolean addressAdded = false;

	public void clickPayWithAmazonCTAShoppingBagPage() throws Exception {

		if (browserName.contains("Android") || browserName.contains("Linux")) {
			browserAction.clickJS(payAmazonCTABagPage_minicart, imgPath, "Amazon Button");
			browserAction.WaittoPageLoad();
		} else {
			browserAction.WaittoPageLoad();
			browserAction.waitForElementClickable(payAmazonCTABagPage);
			browserAction.click(payAmazonCTABagPage);
		}
	}

	public void loginIntoAmazonAccount() throws Exception {

		String parentWindow = driver.getWindowHandle();
		browserAction.switchToNewWindow("child", "", "Switch to Amazon Login Window");
		browserAction.waitForElementClickable(amazonLoginEmail);
		if (!browserAction.setText(amazonLoginEmail, testCaseData.get("Amazon_loginEmail"), "",
				"Email address entered for Amazon")) {
		}
		browserAction.waitForElementClickable(amazonLoginPassword);
		browserAction.setText(amazonLoginPassword, testCaseData.get("Amazon_loginPassword"), "",
				"Password entered for Amazon");
		browserAction.staticWait(8);
		browserAction.Submit(amazonLoginPassword);
		browserAction.staticWait(8);
		browserAction.switchToParentWindow(parentWindow, "", "Switch back from Amazon Login Window ");
		browserAction.staticWait(8);

	}

	public boolean selectAddressfromBook() throws Exception {
		browserAction.WaittoPageLoad();
		boolean existAdddress = false;
		String parentWindowHandle = driver.getWindowHandle();

		for (WebElement e : amazonAddressbook) {
			if (testCaseData.get("CountryCode").equals("US")
					&& (e.getText().contains(testCaseData.get("ShippingAddress_ZipCode")))
					&& (e.getText().contains(testCaseData.get("ShippingAddress_City").toUpperCase())
							|| e.getText().contains(testCaseData.get("ShippingAddress_City")))
					&& (e.getText().contains(testCaseData.get("ShippingAddress_AddressLine1")))) {
				browserAction.clickJS(e);
				return true;
			} else if (testCaseData.get("CountryCode").equals("JP")
					&& (e.getText()
							.contains((testCaseData.get("ShippingAddress_ZipCode").substring(0, 3) + "-"
									+ testCaseData.get("ShippingAddress_ZipCode").substring(3))))
					&& (e.getText().contains(testCaseData.get("ShippingAddress_State_JP")))
					&& (e.getText().contains(testCaseData.get("ShippingAddress_AddressLine2")))) {
				browserAction.clickJS(e);
				return true;
			}
			if (e.getText().equals("+ Add new") || e.getText().equals("+ 新規追加")) {
				if (addressAdded == true) {
					System.out.println("Added address not visible in Iframe...");
					return false;
				}
				browserAction.waitForElementClickable(e);
				browserAction.click(e);

				if (addAddressInAddressBook(parentWindowHandle)) {
					addressAdded = true;
				} else {
					System.out.println("Exception occurred while adding new address...");
					return false;
				}
				browserAction.WaittoPageLoad();
				browserAction.switchToFrame(amazonFrame, imgPath, "Navigate on Amazon Frame");
				return selectAddressfromBook();
			}
		}

		if (existAdddress == false) {
			System.out
					.println("Address not found........class is..." + nextButton.getAttribute("class").equals("next"));
			if (browserAction.waitForElementClickable(nextButton) && nextButton.getAttribute("class").equals("next")) {
				browserAction.click(nextButton);
				return selectAddressfromBook();
			} else {
				if (testCaseData.get("CountryCode").equals("US")) {
					browserAction.click(addNewButtonUS);
				} else if (testCaseData.get("CountryCode").equals("JP")) {
					browserAction.click(addNewButton_JP);
				}
				if (addAddressInAddressBook(parentWindowHandle)) {
					addressAdded = true;
				} else {
					System.out.println("Exception occurred while adding new address...");
					return false;
				}
				browserAction.WaittoPageLoad();
				browserAction.switchToFrame(amazonFrame, imgPath, "Navigate on Amazon Frame");
				return selectAddressfromBook();
			}
		}
		return existAdddress;
	}

	public boolean selectOrAddAmazonAddressPhoneAndConfirm() throws Exception {
		try {
			if (browserName.contains("Android")) {
				browserAction.WaittoPageLoad();
				browserAction.waitForElementVisibility(amazonFrame);
				browserAction.switchToFrame(amazonFrame, imgPath, "Navigate on Amazon Frame");
				selectAddressfromBook();
				browserAction.WaittoPageLoad();
				browserAction.setText(phoneNumberAmazon, testCaseData.get("ShippingAddress_PhoneNumber"), "",
						testCaseData.get("ShippingAddress_PhoneNumber"));
				browserAction.click(amazonConfirmButton, imgPath, "Confirm Button");
			} else {
				browserAction.WaittoPageLoad();
				browserAction.waitForElementVisibility(amazonFrame);
				browserAction.switchToFrame(amazonaddressFrame, "", "Navigate on Amazon Frame");
				if (!selectAddressfromBook()) {
					System.out.println("Address cannot be selected...");
				}
				browserAction.switchToParentFrame();
				browserAction.setText(phoneNumberAmazon, testCaseData.get("ShippingAddress_PhoneNumber"), "",
						testCaseData.get("ShippingAddress_PhoneNumber"));
				browserAction.staticWait(8);
				browserAction.waitForElementClickable(amazonConfirmButton);
				browserAction.click(amazonConfirmButton);
				browserAction.staticWait(8);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Test Case Failed");
			// return false;
		}
	}

	public void placeAmazonOrder() throws Exception {
		browserAction.staticWait(3);
		browserAction.WaittoPageLoad();
		browserAction.scrollToElementUsingJS(amazonPlaceOrder);
		if (testCaseData.get("CountryCode").contains("US")) {
			browserAction.clickJS(amazonTermCondition, imgPath, "Terms & Condition");
		}
		browserAction.WaittoPageLoad();
		browserAction.isElementDisplayed(amazonPlaceOrder, 1);
		browserAction.clickJS(amazonPlaceOrder, imgPath, "Place Order");

	}

	public boolean addAddressInAddressBook(String parentWindowHandle) throws Exception {

		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> itr = allWindowHandles.iterator();
			while (itr.hasNext()) {
				String currentWindowHandle = itr.next();
				if (!currentWindowHandle.equals(parentWindowHandle)) {
					System.out.println("Window Handle switched successfully...");
					driver.switchTo().window(currentWindowHandle);
				}
			}
			driver.manage().window().maximize();
			if (testCaseData.get("CountryCode").equals("US")) {
				if (!addAddressCountryDropdown.getText().contains("United States")) {
					System.out.println("Default value not set to US...");
					browserAction.click(addAddressCountryDropdown);
					for (WebElement ele : addAddressCountryDropdownList) {
						System.out.println("Dropdown... :" + ele.getText());
						if (ele.getText().contains("United States")) {
							browserAction.click(ele);
							break;
						}
					}
				}
				browserAction.setText(addAddressCity, testCaseData.get("ShippingAddress_City"));
				browserAction.setText(addAddressState, testCaseData.get("ShippingAddress_State"));
				browserAction.setText(addAddressPostalCode, testCaseData.get("ShippingAddress_ZipCode"));
			} else if (testCaseData.get("CountryCode").equals("JP")) {
				if (!addAddressCountryDropdown.getText().contains("Japan")) {
					System.out.println("Default value not set to Japan...");
					browserAction.click(addAddressCountryDropdown);
					for (WebElement ele : addAddressCountryDropdownList) {
						System.out.println("Dropdown... :" + ele.getText());
						if (ele.getText().contains("Japan")) {
							browserAction.click(ele);
							break;
						}
					}
				}
				browserAction.click(addAddressStateDropdown_JP);
				for (WebElement ele : addAddressStateDropdownList_JP) {
					System.out.println("Dropdown... :" + ele.getText());
					if (ele.getText().equals(testCaseData.get("ShippingAddress_State_JP"))) {
						browserAction.click(ele);
						break;
					}
				}
				browserAction.setText(addAddressFullName, "Test User");
				browserAction.setText(addAddressAddressLine3_JP,
						testCaseData.get("ShippingAddress_City") + testCaseData.get("ShippingAddress_State"));
				browserAction.setText(addAddressPostalCodeOne_JP,
						testCaseData.get("ShippingAddress_ZipCode").substring(0, 3));
				browserAction.setText(addAddressPostalCodeTwo_JP,
						testCaseData.get("ShippingAddress_ZipCode").substring(3));
			}
			browserAction.setText(addAddressAddressLine1, testCaseData.get("ShippingAddress_AddressLine1"));
			browserAction.setText(addAddressAddressLine2, testCaseData.get("ShippingAddress_AddressLine2"));
			browserAction.setText(addAddressPhoneNumber, testCaseData.get("ShippingAddress_PhoneNumber"));
			browserAction.clickJS(addAddressAddAddressButton);
			if (driver.getWindowHandles().size() == 2
					&& verifyAddressTextAmazon_US.getText().contains("Verify your address")) {
				browserAction.waitForElementClickable(originalAddressAmazonRecom);
				browserAction.click(originalAddressAmazonRecom);
				browserAction.waitForElementClickable(saveAddressButtonAmazon_US);
				browserAction.click(saveAddressButtonAmazon_US);
			}
			driver.switchTo().window(parentWindowHandle);
			browserAction.staticWait(3);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Test Case Failed");
		}
	}

}
