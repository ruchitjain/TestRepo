package pagesObjects;

import java.util.HashMap;
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
import helpers.PageObjectUtils;
import helpers.Reporting;

public class BillingAddressPage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;
	public Map<String, String> addressData;
	public PageObjectUtils pageObjUtil;

	public BillingAddressPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {

		driver = driverObj;
		report = reportObj;
		this.testCaseData = testCaseData;
		browserName = Executor.Devices[Integer.parseInt(Thread.currentThread().getName()) - 1];
		imgPath = report.imagePath;
		browserAction = new BrowserActions(driver, report);
		pageObjUtil = new PageObjectUtils(testCaseData);
		addressData = new HashMap<String, String>();
		PageFactory.initElements(driver, this);
	}

	/**
	 * ==========================================================================
	 * =================PAGE ELEMENT LOCATORS====================================
	 * ==========================================================================
	 */

	@FindBy(how = How.ID, using = "input-credit-card-number")
	private WebElement paymentCardNumberInput;

	@FindBy(how = How.ID, using = "select2-payment-billing-title-container")
	private WebElement billingAddress_TitleDropdown;

	@FindBy(how = How.ID, using = "payment-billing-title")
	private WebElement billingAddress_TitleDropdown_Select;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-title-results']/li")
	private List<WebElement> billingAddress_TitleDropdownResults;

	@FindBy(how = How.ID, using = "payment-billing-country")
	private WebElement billingAddress_CountryDropdown_Select;

	// @FindBy(how = How.ID, using = "select2-payment-billing-country-container")
	@FindBy(how = How.XPATH, using = "//span[@id='select2-payment-billing-country-container']/../..")
	private WebElement billingAddress_CountryDropdown;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-country-results']/li")
	private List<WebElement> billingAddress_CountryDropdownResults;

	@FindBy(how = How.ID, using = "payment-billing-address-name")
	private WebElement billingAddress_FirstName;

	@FindBy(how = How.ID, using = "payment-billing-address-last-name")
	private WebElement billingAddress_LastName;

	@FindBy(how = How.ID, using = "payment-billing-address-name-right")
	private WebElement billingAddress_FirstName_JP;

	@FindBy(how = How.ID, using = "payment-billing-address-last-name-middle")
	private WebElement billingAddress_LastName_JP;

	@FindBy(how = How.ID, using = "payment-billing-address-name-katakana")
	private WebElement billingAddress_FirstName_JP_Katakana;

	@FindBy(how = How.ID, using = "payment-billing-address-last-name-katakana")
	private WebElement billingAddress_LastName_JP_Katakana;

	@FindBy(how = How.ID, using = "payment-billing-address-address")
	private WebElement billingAddress_AddressLine1;

	@FindBy(how = How.ID, using = "payment-billing-address-address-line2")
	private WebElement billingAddress_AddressLine2;

	@FindBy(how = How.ID, using = "payment-billing-address-city")
	private WebElement billingAddress_City;

	@FindBy(how = How.ID, using = "payment-billing-address-city-middle-down")
	private WebElement billingAddress_City_Other;

	@FindBy(how = How.ID, using = "payment-billing-address-city-right-up")
	private WebElement billingAddress_City_JP;

	@FindBy(how = How.ID, using = "payment-billing-province")
	private WebElement billingAddress_StateDropdown_Select;

	@FindBy(how = How.ID, using = "select2-payment-billing-province-container")
	private WebElement billingAddress_StateDropdown;

	@FindBy(how = How.ID, using = "payment-billing-province-right-down")
	private WebElement billingAddress_StateDropdown_Other_Select;

	@FindBy(how = How.ID, using = "select2-payment-billing-province-right-down-container")
	private WebElement billingAddress_StateDropdown_Other;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-province-results']/li")
	private List<WebElement> billingAddress_StateDropdownResults;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-province-right-down-results']/li")
	private List<WebElement> billingAddress_StateDropdownResults_Other;

	@FindBy(how = How.ID, using = "payment-billing-address-area")
	private WebElement billingAddress_AreaDropDown_Select;

	@FindBy(how = How.ID, using = "select2-payment-billing-address-area-container")
	private WebElement billingAddress_AreaDropDown;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-address-area-results']/li")
	private List<WebElement> billingAddress_AreaDropDownResults;

	@FindBy(how = How.ID, using = "payment-billing-prefecture-left-up")
	private WebElement billingAddress_PrefectureDropDown_Select_JP;

	@FindBy(how = How.ID, using = "select2-payment-billing-prefecture-left-up-container")
	private WebElement billingAddress_PrefectureDropDown_JP;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-prefecture-left-up-results']/li")
	private List<WebElement> billingAddress_PrefectureDropDownResults_JP;

	@FindBy(how = How.ID, using = "payment-billing-address-subdivision")
	private WebElement billingAddress_DistrictDropDown_Select;

	@FindBy(how = How.ID, using = "select2-payment-billing-address-subdivision-container")
	private WebElement billingAddress_DistrictDropDown;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-address-subdivision-results']/li")
	private List<WebElement> billingAddress_DistrictDropDownResults;

	@FindBy(how = How.ID, using = "payment-billing-address-zip-code")
	private WebElement billingAddress_Zipcode;

	@FindBy(how = How.ID, using = "payment-billing-address-zip-code-left-down")
	private WebElement billingAddress_Zipcode_Other;

	@FindBy(how = How.ID, using = "payment-billing-address-zip-code-long")
	private WebElement billingAddress_Zipcode_JP;

	@FindBy(how = How.ID, using = "search-zip-code-button")
	private WebElement billingAddress_ALookupButton_JP;

	@FindBy(how = How.ID, using = "payment-billing-phone-country")
	private WebElement billingAddress_PhoneExtensionDropdown_Select;

	@FindBy(how = How.ID, using = "select2-payment-billing-phone-country-container")
	private WebElement billingAddress_PhoneExtensionDropdown;

	@FindBy(how = How.ID, using = "payment-billing-address-phone")
	private WebElement billingAddress_PhoneNumber;

	@FindBy(how = How.ID, using = "payment-billing-address-gender")
	private WebElement billingAddress_GenderDropdown_Select;

	@FindBy(how = How.ID, using = "select2-payment-billing-address-gender-container")
	private WebElement billingAddress_GenderDropdown;

	@FindBy(how = How.XPATH, using = "//ul[@id='select2-payment-billing-address-gender-results']/li")
	private List<WebElement> billingAddress_GenderDropdownResults;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	public void add_Billing_Address(String addressType) throws Exception {

		addressData = pageObjUtil.setAddressDataMap(addressType);

		addAddress(addressData);
	}

	/**
	 * @description : Click on title drop down and Select title from drop down Note:
	 *              For case of JP, it is gender instead of title
	 * 
	 * 
	 * @throws Exception
	 */

	public void addTitle() throws Exception {

		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {

			if (browserName.contains("Android") || browserName.contains("Linux")) {
				browserAction.waitForElementClickable(billingAddress_GenderDropdown_Select);

				/*
				 * Temporary fix applied due to bug in application
				 */

				browserAction.selectFromDD(billingAddress_GenderDropdown_Select, addressData.get("gender"), "",
						"Gender Selected as " + addressData.get("gender"));

			} else {
				browserAction.click(billingAddress_GenderDropdown, "", "Click Performed on Gender Dropdown");

				browserAction.waitForPageDOMLoad(2000l);

				/*
				 * Temporary fix applied due to bug in application
				 */

				browserAction.selectFromListOfWebElemet_Equals(billingAddress_GenderDropdownResults,
						addressData.get("gender"), imgPath, "Gender Selected as " + addressData.get("gender"));

			}
		} else {

			if (browserName.contains("Android") || browserName.contains("Linux")) {
				browserAction.waitForElementClickable(billingAddress_TitleDropdown_Select);
				browserAction.selectFromDD(billingAddress_TitleDropdown_Select, addressData.get("title"), "",
						"Title Selected as " + addressData.get("title"));
			} else {
				browserAction.click(billingAddress_TitleDropdown, "", "Click Performed on Title Dropdown");
				browserAction.waitForPageDOMLoad(2000l);

				browserAction.selectFromListOfWebElemet_Equals(billingAddress_TitleDropdownResults,
						addressData.get("title"), imgPath, "Title Selected as " + addressData.get("title"));
			}
		}
	}

	/**
	 * @description : Checks if the country name matches the expected country name
	 * 
	 * @returns boolean - True if name matches else false
	 * @throws Exception
	 */
	public boolean validateCountryName() throws Exception {

		report.logStepToReport(LogStatus.INFO, "Validate Country Name",
				"Validating Country Name - Expected Value : " + addressData.get("country"), "");

		String countryValue = "";

		if (browserName.contains("Android") || browserName.contains("Linux")) {

			countryValue = browserAction.getSelectedOptionFromSelect(billingAddress_CountryDropdown_Select);
		} else {
			countryValue = browserAction.getText(billingAddress_CountryDropdown);
		}

		if (countryValue.equalsIgnoreCase(addressData.get("country"))) {
			report.logStepToReport(LogStatus.INFO, "Validate Country Name", "Country Name Validation Passed" + "<br>"
					+ "Expected Value : " + addressData.get("country") + "<br>" + "Actual Value : " + countryValue, "");
			return true;
		} else {
			report.logStepToReport(LogStatus.INFO, "Validate Country Name", "Country Name Validation Failed" + "<br>"
					+ "Expected Value : " + addressData.get("country") + "<br>" + "Actual Value : " + countryValue, "");
			return false;
		}
	}

	/**
	 * @description : Changes Country Name -Selects the country name (specified in
	 *              test data) from Drop down
	 * 
	 * 
	 * @throws Exception
	 */
	public void changeCountryName() throws Exception {
		report.logStepToReport(LogStatus.INFO, "Change Country Name",
				"Changing Country Name to :" + addressData.get("country"), "");
		if (browserName.contains("Android") || browserName.contains("Linux")) {
			browserAction.waitForElementClickable(billingAddress_CountryDropdown_Select);
			browserAction.selectFromDD(billingAddress_CountryDropdown_Select, addressData.get("country"), "",
					"Country Selected as " + addressData.get("country"));
		} else {
			browserAction.scrollToElementUsingJS(paymentCardNumberInput);
			browserAction.waitForPageDOMLoad(2000l);
			browserAction.waitForElementClickable(billingAddress_CountryDropdown);
			browserAction.click(billingAddress_CountryDropdown, "", "Click Performed on Country Dropdown");
			browserAction.waitForPageDOMLoad(2000l);
			browserAction.selectFromListOfWebElemet_Equals(billingAddress_CountryDropdownResults,
					addressData.get("country"), imgPath, "Country Selected as : " + addressData.get("country"));
		}
	}

	/**
	 * @description : Adds first Name (& First Name Katakana in case of JP) as
	 *              specified in test data
	 * 
	 * 
	 * @throws Exception
	 */

	public void addFirstName() throws Exception {

		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			browserAction.waitForElementClickable(billingAddress_FirstName_JP);
			browserAction.setText(billingAddress_FirstName_JP, addressData.get("firstName"), "",
					"First Name Set as : " + addressData.get("firstName"));
			browserAction.waitForElementClickable(billingAddress_FirstName_JP_Katakana);
			browserAction.setText(billingAddress_FirstName_JP_Katakana, addressData.get("firstNameKatakana"), "",
					"First Name Katakana Set as : " + addressData.get("firstNameKatakana"));

		} else {
			browserAction.waitForElementClickable(billingAddress_FirstName);
			browserAction.setText(billingAddress_FirstName, addressData.get("firstName"), "",
					"First Name Set as : " + addressData.get("firstName"));
		}
	}

	/**
	 * @description : Adds Last Name (& Last Name Katakana in case of JP) as
	 *              specified in test data
	 * 
	 * 
	 * @throws Exception
	 */

	public void addLastName() throws Exception {

		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			browserAction.waitForElementClickable(billingAddress_LastName_JP);
			browserAction.setText(billingAddress_LastName_JP, addressData.get("lastName"), "",
					"Last Name Set as : " + addressData.get("lastName"));

			browserAction.waitForElementClickable(billingAddress_LastName_JP_Katakana);
			browserAction.setText(billingAddress_LastName_JP_Katakana, addressData.get("lastNameKatakana"), "",
					"Last Name Katakana Set as : " + addressData.get("lastNameKatakana"));
		} else {
			browserAction.waitForElementClickable(billingAddress_LastName);
			browserAction.setText(billingAddress_LastName, addressData.get("lastName"), "",
					"Last Name Set as : " + addressData.get("lastName"));
		}
	}

	/**
	 * @description : Adds Last Name (& Last Name Katakana in case of JP) as
	 *              specified in test data
	 * 
	 * 
	 * @throws Exception
	 */

	public void addAddressLine1() throws Exception {

		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			/*
			 * No Action to perform here as address is pulled from Lookup
			 */
		} else {
			browserAction.waitForElementClickable(billingAddress_AddressLine1);
			browserAction.setText(billingAddress_AddressLine1, addressData.get("addressLine1"), "",
					"Address Line 1 Set as : " + addressData.get("addressLine1"));
		}
	}

	/**
	 * @description : Adds Address Line 1 (except for JP) as specified in test data
	 * 
	 * @throws Exception
	 */
	public void addAddressLine2() throws Exception {
		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			/*
			 * No Action to perform here as address is pulled from Lookup
			 */
		} else {
			browserAction.waitForElementClickable(billingAddress_AddressLine2);
			browserAction.setText(billingAddress_AddressLine2, addressData.get("addressLine2"), "",
					"Address Line 2 Set as : " + addressData.get("addressLine2"));
		}
	}

	/**
	 * @description : Validates Phones Extension - Country value from test data
	 * 
	 * @returns boolean - true if validation is successful else false
	 * @throws Exception
	 */
	public boolean validatePhoneExtension() throws Exception {
		report.logStepToReport(LogStatus.INFO, "Validate Phone Extension ",
				"Validating Phone Extension and Country Name - Expected Value - " + addressData.get("phoneExtension")
						+ " " + addressData.get("country"),
				"");
		String phoneExtension = "";

		if (browserName.contains("Android") || browserName.contains("Linux")) {
			phoneExtension = browserAction.getSelectedOptionFromSelect(billingAddress_PhoneExtensionDropdown_Select);
			browserAction.scrollToElementUsingJS(billingAddress_PhoneExtensionDropdown_Select);
		} else {
			phoneExtension = browserAction.getText(billingAddress_PhoneExtensionDropdown);
			browserAction.scrollToElementUsingJS(billingAddress_PhoneExtensionDropdown);
		}

		if (phoneExtension.contains(addressData.get("phoneExtension"))
				&& phoneExtension.contains(addressData.get("country"))) {
			report.logStepToReport(LogStatus.INFO, "Validate Phone Extension ",
					"Validation of Phone Extension and Country Name Successful" + "<br>" + "Expected Value - "
							+ addressData.get("phoneExtension") + " " + addressData.get("country") + "<br>"
							+ "Actual Value - " + phoneExtension,
					"");
			return true;
		} else {
			report.logStepToReport(LogStatus.FAIL, "Validate Phone Extension ",
					"Validation of Phone Extension and Country Name Failed " + "<br>" + "Expected Value - "
							+ addressData.get("phoneExtension") + " " + addressData.get("country") + "<br>"
							+ "Actual Value - " + phoneExtension,
					"");
			return false;
		}
	}

	/**
	 * @description : Adds phone Number as specified in test data
	 * 
	 * @throws Exception
	 */
	public void addPhoneNumber() throws Exception {
		browserAction.waitForElementClickable(billingAddress_PhoneNumber);
		browserAction.setText(billingAddress_PhoneNumber, addressData.get("phoneNumber"), "",
				"Phone Number Set as : " + addressData.get("phoneNumber"));
	}

	/**
	 * @description : Adds City Name (except for JP) as specified in test data Note:
	 *              For HK clicks on district drop down & selects district from drop
	 *              down
	 * @throws Exception
	 */
	public void addCity() throws Exception {
		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {
			/*
			 * No Action to perform here as address is pulled from Lookup
			 */
		} else if (addressData.get("countryCode").equalsIgnoreCase("HK")) {
			browserAction.waitForPageDOMLoad(1000l);
			if (browserName.contains("Android") || browserName.contains("Linux")) {
				browserAction.waitForElementClickable(billingAddress_DistrictDropDown_Select);
				browserAction.waitForPageDOMLoad(2000l);
				browserAction.selectFromDD(billingAddress_DistrictDropDown_Select, addressData.get("city"), "",
						"District Selected as " + addressData.get("city"));
			} else {
				browserAction.waitForElementClickable(billingAddress_DistrictDropDown);
				browserAction.waitForPageDOMLoad(2000l);
				browserAction.click(billingAddress_DistrictDropDown);
				browserAction.waitForPageDOMLoad(2000l);
				browserAction.selectFromListOfWebElemet_Equals(billingAddress_DistrictDropDownResults,
						addressData.get("city"), imgPath, "District Selected as " + addressData.get("city"));
			}
		} else if (addressData.get("countryCode").equalsIgnoreCase("AE")
				|| addressData.get("countryCode").equalsIgnoreCase("BG")
				|| addressData.get("countryCode").equalsIgnoreCase("CZ")
				|| addressData.get("countryCode").equalsIgnoreCase("AE")
				|| addressData.get("countryCode").equalsIgnoreCase("FI")
				|| addressData.get("countryCode").equalsIgnoreCase("HU")
				|| addressData.get("countryCode").equalsIgnoreCase("KW")
				|| addressData.get("countryCode").equalsIgnoreCase("NO")
				|| addressData.get("countryCode").equalsIgnoreCase("PL")
				|| addressData.get("countryCode").equalsIgnoreCase("PT")
				|| addressData.get("countryCode").equalsIgnoreCase("QA")
				|| addressData.get("countryCode").equalsIgnoreCase("RO")
				|| addressData.get("countryCode").equalsIgnoreCase("SA")
				|| addressData.get("countryCode").equalsIgnoreCase("SI")
				|| addressData.get("countryCode").equalsIgnoreCase("SE")
				|| addressData.get("countryCode").equalsIgnoreCase("TR")
				|| addressData.get("countryCode").equalsIgnoreCase("AU")
				|| addressData.get("countryCode").equalsIgnoreCase("CA")
				|| addressData.get("countryCode").equalsIgnoreCase("NZ")
				|| addressData.get("countryCode").equalsIgnoreCase("US")) {
			browserAction.waitForElementClickable(billingAddress_City);
			browserAction.setText(billingAddress_City, addressData.get("city"), "",
					"City Set as : " + addressData.get("city"));
		} else {
			browserAction.waitForElementClickable(billingAddress_City_Other);
			browserAction.setText(billingAddress_City_Other, addressData.get("city"), "",
					"City Set as : " + addressData.get("city"));
		}
	}

	/**
	 * @description : Clicks on State/ Province/ County drop down & Selects State/
	 *              Province/ County Name as specified in test data down
	 * @throws Exception
	 */
	public void addStateProvince() throws Exception {
		browserAction.waitForPageDOMLoad(1000l);
		if (addressData.get("countryCode").equalsIgnoreCase("HK")) {
			if (browserName.contains("Android") || browserName.contains("Linux")) {
				browserAction.waitForElementClickable(billingAddress_AreaDropDown_Select);
				browserAction.selectFromDD(billingAddress_AreaDropDown_Select, addressData.get("state"), "",
						"Area Selected as " + addressData.get("state"));
			} else {
				browserAction.click(billingAddress_AreaDropDown);
				browserAction.selectFromListOfWebElemet_Equals(billingAddress_AreaDropDownResults,
						addressData.get("state"), imgPath, "Area Selected as " + addressData.get("state"));
			}
		} else if (addressData.get("countryCode").equalsIgnoreCase("AU")
				|| addressData.get("countryCode").equalsIgnoreCase("NZ")
				|| addressData.get("countryCode").equalsIgnoreCase("CA")
				|| addressData.get("countryCode").equalsIgnoreCase("US")) {

			if (browserName.contains("Android") || browserName.contains("Linux")) {
				browserAction.waitForElementClickable(billingAddress_StateDropdown_Select);
				browserAction.selectFromDD(billingAddress_StateDropdown_Select, addressData.get("state"), "",
						"State/province Selected as " + addressData.get("state"));
			} else {
				browserAction.click(billingAddress_StateDropdown);
				browserAction.selectFromListOfWebElemet_Equals(billingAddress_StateDropdownResults,
						addressData.get("state"), imgPath, "State/province Selected as " + addressData.get("state"));
			}
		} else if (addressData.get("countryCode").equalsIgnoreCase("IE")
				|| addressData.get("countryCode").equalsIgnoreCase("IT")
				|| addressData.get("countryCode").equalsIgnoreCase("ES")
				|| addressData.get("countryCode").equalsIgnoreCase("CH")
				|| addressData.get("countryCode").equalsIgnoreCase("UK")) {

			if (browserName.contains("Android") || browserName.contains("Linux")) {
				browserAction.waitForElementClickable(billingAddress_StateDropdown_Other_Select);
				browserAction.selectFromDD(billingAddress_StateDropdown_Other_Select, addressData.get("state"), "",
						"State/province Selected as " + addressData.get("state"));
			} else {
				browserAction.click(billingAddress_StateDropdown_Other);
				browserAction.waitForPageDOMLoad(1000l);
				browserAction.selectFromListOfWebElemet_Equals(billingAddress_StateDropdownResults_Other,
						addressData.get("state"), imgPath, "State/province Selected as " + addressData.get("state"));
			}
		}

	}

	/**
	 * @description : Validates that address(prefecture, city & Address Line 1)
	 *              fetched by Lookup (for JP) is not empty
	 * @returns : boolean - true if validation is successful and else otherwise
	 * @throws Exception
	 */
	public boolean validateAddressDetailsFilledByLookup() throws Exception {
		report.logStepToReport(LogStatus.INFO, "Validate Address Details(from JP Lookup)",
				"Validating non null values are fetched from A Lookup for JP ", "");
		browserAction.waitForPageDOMLoad(2000l);

		String prefecture = "";
		String city = "";
		String addressLine1 = "";

		if (browserName.contains("Android") || browserName.contains("Linux")) {
			prefecture = browserAction.getText(billingAddress_PrefectureDropDown_Select_JP);
		} else {
			prefecture = browserAction.getText(billingAddress_PrefectureDropDown_JP);
		}
		city = browserAction.getAttribute(billingAddress_City_JP, "value");
		addressLine1 = browserAction.getAttribute(billingAddress_AddressLine1, "value");

		if (prefecture.length() > 0 && city.length() > 0 && addressLine1.length() > 0) {
			report.logStepToReport(LogStatus.INFO, "Validate Address Details(from JP Lookup)",
					"Validating Non Null values are fetched from A Lookup for JP ", "");
			return true;
		} else {
			report.logStepToReport(LogStatus.FAIL, "Validate Address Details(from JP Lookup)",
					"Validation Failed - Null Values fetched from Lookup ", imgPath);
			return false;
		}
	}

	/**
	 * @description : Adds postal code as specified in test data In case of JP -
	 *              Postal code is added and Lookup button is clicked and fetched
	 *              details are validated by validateAddressDetailsFilledByLookup()
	 *              function
	 * @throws Exception
	 */
	public void addPostalCode() throws Exception {
		if (addressData.get("countryCode").equalsIgnoreCase("JP")) {

			browserAction.waitForElementClickable(billingAddress_Zipcode_JP);
			browserAction.setText(billingAddress_Zipcode_JP, addressData.get("zipcode"), "",
					"Zip Code Set as : " + addressData.get("zipcode"));

			browserAction.waitForElementClickable(billingAddress_ALookupButton_JP);
			browserAction.click(billingAddress_ALookupButton_JP, "", "Click Performed on A Lookup button");

			if (validateAddressDetailsFilledByLookup()) {
				return;
			} else {
				throw new Exception("Validation of Address Fetched from JP lookup Failed");
			}

		} else if (addressData.get("countryCode").equalsIgnoreCase("AE")
				|| addressData.get("countryCode").equalsIgnoreCase("BG")
				|| addressData.get("countryCode").equalsIgnoreCase("CZ")
				|| addressData.get("countryCode").equalsIgnoreCase("AE")
				|| addressData.get("countryCode").equalsIgnoreCase("FI")
				|| addressData.get("countryCode").equalsIgnoreCase("HU")
				|| addressData.get("countryCode").equalsIgnoreCase("KW")
				|| addressData.get("countryCode").equalsIgnoreCase("NO")
				|| addressData.get("countryCode").equalsIgnoreCase("PL")
				|| addressData.get("countryCode").equalsIgnoreCase("PT")
				|| addressData.get("countryCode").equalsIgnoreCase("QA")
				|| addressData.get("countryCode").equalsIgnoreCase("RO")
				|| addressData.get("countryCode").equalsIgnoreCase("SI")
				|| addressData.get("countryCode").equalsIgnoreCase("SE")
				|| addressData.get("countryCode").equalsIgnoreCase("TR")
				|| addressData.get("countryCode").equalsIgnoreCase("AU")
				|| addressData.get("countryCode").equalsIgnoreCase("CA")
				|| addressData.get("countryCode").equalsIgnoreCase("NZ")
				|| addressData.get("countryCode").equalsIgnoreCase("US")) {
			browserAction.waitForElementClickable(billingAddress_Zipcode);
			browserAction.setText(billingAddress_Zipcode, addressData.get("zipcode"));
		} else {
			browserAction.waitForElementClickable(billingAddress_Zipcode_Other);
			browserAction.setText(billingAddress_Zipcode_Other, addressData.get("zipcode"), "",
					"Zip Code Set as : " + addressData.get("zipcode"));
		}
	}

	/**
	 * @description : Adds address details - makes a call to various other functions
	 *              validateCountryName() ,changeCountryName(), addTitle(),
	 *              addFirstName(), addLastName(), addAddressLine1(),
	 *              addAddressLine2(), addStateProvince(), addCity(),
	 *              addPostalCode(), validatePhoneExtension(), addPhoneNumber(),
	 *              saveAddress()
	 * 
	 * @param addressData - object of type Map<String, String> which contains the
	 *                    address details that needs to be added
	 * @throws Exception
	 */

	public void addAddress(Map<String, String> addressData) throws Exception {
		browserAction.scrollToElementUsingJS(billingAddress_AddressLine1);
		report.logStepToReport(LogStatus.INFO, "Wallet Page | Add Billing address", "Adding Billing address", imgPath);
		this.addressData = addressData;

		browserAction.WaittoPageLoad();

		if (!validateCountryName()) {
			changeCountryName();
		}

		addTitle();

		addFirstName();

		addLastName();

		addAddressLine1();

		addAddressLine2();

		if (addressData.get("stateFlag").equalsIgnoreCase("Yes")) {
			addStateProvince();
		}

		if (addressData.get("cityFlag").equalsIgnoreCase("Yes")) {
			addCity();
		}

		if (addressData.get("zipcodeFlag").equalsIgnoreCase("Yes")) {
			addPostalCode();
		}

		validatePhoneExtension();

		addPhoneNumber();

	}

}