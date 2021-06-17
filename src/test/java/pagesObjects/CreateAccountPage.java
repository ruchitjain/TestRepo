package pagesObjects;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import controllers.Executor;
import controllers.TestDataCollector;
import helpers.BrowserActions;

import helpers.FunctionBank;
import helpers.Reporting;

public class CreateAccountPage {

	public String testDependentEmail = null;
	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;
	public TestDataCollector testCaseDatacollector;

	public CreateAccountPage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData,
			TestDataCollector testCaseDatacollector) {

		driver = driverObj;
		report = reportObj;
		this.testCaseData = testCaseData;
		this.testCaseDatacollector = testCaseDatacollector;
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
	@FindBy(how = How.XPATH, using = "(//a[@id='header-nav-signin-anchor'])[2]")
	private WebElement signinHeaderLink;

	@FindBy(how = How.XPATH, using = "//a[@id='header-nav-bag-anchor']")
	private WebElement bagIconLinkMob;

	@FindBy(how = How.XPATH, using = "(//a[contains(@class, 'create-account-button')])[2]")
	private WebElement createAccountCTA;

	@FindBy(how = How.XPATH, using = "(//a[@class='btn--secondary create-account-button'])[2]")
	private WebElement createAccountHeader;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-email']")
	private WebElement registerNewEmail;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-create-account-month-container']")
	private WebElement dobMonth;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-month']")
	private WebElement dobMonthMob;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-create-account-day-container']")
	private WebElement dobDay;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-day']")
	private WebElement dobDayMob;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-create-account-year-container']")
	private WebElement dobYear;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-year']")
	private WebElement dobYearMob;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'select2-create-account-month-result')]")
	private List<WebElement> dobMonthList;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'select2-create-account-day-result')]")
	private List<WebElement> dobDayList;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'select2-create-account-year-result')]")
	private List<WebElement> dobYearList;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-password']")
	private WebElement passwordCNA;

	@FindBy(how = How.XPATH, using = "//button[@class='js--form-validation-button next-step btn--tertiary']")
	private WebElement continueCNA;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-create-account-title-container']")
	private WebElement tittleCNA;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-title']")
	private WebElement tittleCNAMob;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'select2-create-account-title-result')]")
	private List<WebElement> tittleCNAList;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-firstname']")
	private WebElement firstNameCNA;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-lastname']")
	private WebElement lastNameCNA;

	@FindBy(how = How.XPATH, using = "//input[@id='consentForProfilingAndMarketing']")
	private WebElement profileCNA;

	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'submit-form-button create-account btn')]")
	private WebElement createAccountSubmitCTA;

	@FindBy(how = How.XPATH, using = "//div[@class='thank-you__message']")
	private WebElement accountCreationConfirmMsg;

	@FindBy(how = How.XPATH, using = "//div[@class='thank-you__registered-mail']")
	private WebElement accountCreationEmailConfirmMsg;

	@FindBy(how = How.XPATH, using = "//a[@class='btn--tertiary continue-shopping-button']")
	private WebElement continueShoppingCTA;

	@FindBy(how = How.XPATH, using = "(//a[@id='header-nav-signin-anchor'])[2]")
	private WebElement HeaderSignInLink;

	@FindBy(how = How.XPATH, using = "//form[@id='form']/button")
	private WebElement continueButton_SI;

	@FindBy(how = How.XPATH, using = "//input[@id='email-input']")
	private WebElement guestUserEmailIDTextBox_SI;

	@FindBy(how = How.XPATH, using = "//input[@name='subscribe']")
	private WebElement subscribeCheckBox;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-password']")
	private WebElement userPassword;

	@FindBy(how = How.XPATH, using = "//input[@id='password-input']")
	private WebElement userPassword_SI;

	@FindBy(how = How.ID, using = "title-select")
	private WebElement title_SI_mobile;

	@FindBy(how = How.ID, using = "gender-select")
	private WebElement title_SI_mobile_jp;

	@FindBy(how = How.ID, using = "title-select")
	private WebElement title_SI;

	@FindBy(how = How.ID, using = "gender-select")
	private WebElement title_SI_jp;

	@FindBy(how = How.XPATH, using = "//div[@id='title-select']//ul/li")
	private List<WebElement> title_SI_list;

	@FindBy(how = How.XPATH, using = "//select[@id='title-select']//option")
	private List<WebElement> title_SI_list_mobile1;

	@FindBy(how = How.XPATH, using = "//div[@id='title-select']//ul/li")
	private List<WebElement> title_SI_list_mobile;

	@FindBy(how = How.XPATH, using = "//select[@id='title-select']/option")
	private List<WebElement> title_SI_list_mobile_android;

	@FindBy(how = How.XPATH, using = "//div[@id='gender-select']//ul/li")
	private List<WebElement> title_SI_list_jp;

	@FindBy(how = How.XPATH, using = "//div[@id='gender-select']//ul/li")
	private List<WebElement> title_SI_list_mobile_jp;

	@FindBy(how = How.XPATH, using = "//input[@id='first-name-input']")
	private WebElement firstName_SI;

	@FindBy(how = How.XPATH, using = "//input[@id='last-name-input']")
	private WebElement lastName_SI;

	@FindBy(how = How.XPATH, using = "//input[@id='month-input']")
	private WebElement month_SI;

	@FindBy(how = How.XPATH, using = "//input[@id='day-input']")
	private WebElement day_SI;

	@FindBy(how = How.XPATH, using = "//input[@id='year-input']")
	private WebElement year_SI;

	@FindBy(how = How.XPATH, using = "(//h1/span)[3]")
	private WebElement welcomeText;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-email']")
	private WebElement createAccountEmail;

	@FindBy(how = How.ID, using = "select2-create-account-title-container")
	private WebElement userTitleDropdownContainer;

	@FindBy(how = How.ID, using = "create-account-title")
	private WebElement userTitleDropdown;

	@FindBy(how = How.ID, using = "select2-create-account-gender-container")
	private WebElement userTitleDropdownContainer_Jp;

	@FindBy(how = How.ID, using = "create-account-gender")
	private WebElement userTitleDropdown_Jp;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-firstname']")
	private WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@id='create-account-lastname']")
	private WebElement lastName;

	@FindBy(how = How.XPATH, using = "//button[@class='js--form-validation-button submit-form-button create-account btn--tertiary']")
	private WebElement createAccountButton2;

	@FindBy(how = How.XPATH, using = "//div[@class='thank-you__registered-mail']")
	private WebElement createAccountconfirmation;

	@FindBy(how = How.XPATH, using = "(//span[@role='combobox'])[2]")
	private WebElement dobDayComboboxContainer;

	@FindBy(how = How.XPATH, using = "(//span[@role='combobox'])[1]")
	private WebElement dobMonthComboboxContainer;

	@FindBy(how = How.XPATH, using = "(//span[@role='combobox'])[3]")
	private WebElement dobYearComboboxContainer;

	@FindBy(how = How.ID, using = "create-account-month")
	private WebElement monthCreateAccount;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-month']//option")
	private List<WebElement> monthCreateAccount_Mobile;

	@FindBy(how = How.ID, using = "create-account-day")
	private WebElement dayCreateAccount;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-day']//option")
	private List<WebElement> dayCreateAccount_Mobile;

	@FindBy(how = How.ID, using = "create-account-year")
	private WebElement yearCreateAccount;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-year']//option")
	private List<WebElement> yearCreateAccount_Mobile;

	@FindBy(how = How.XPATH, using = "//button[@class='js--form-validation-button next-step btn--tertiary']")
	private WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//input[@id='marketing-consent']")
	private WebElement keepme_updated_check_SI;

	@FindBy(how = How.XPATH, using = "(//form[@id='form']//button)[4]")
	private WebElement loginConfirm;

	@FindBy(how = How.ID, using = "birth-date-input")
	private WebElement dobCalendar;

	@FindBy(how = How.ID, using = "birth-date-input")
	private WebElement dobCalendarbtn;

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : To Navigate on Create account Page
	 * @throws Exception
	 */

	public void navigationOnCreateAccountPage() throws Exception {
		if (browserName.contains("Android") || browserName.contains("Linux")) {
			browserAction.clickJS(bagIconLinkMob);
			browserAction.clickJS(createAccountCTA);
		} else {
			browserAction.WaittoPageLoad();
			browserAction.mouseHoverJScript(signinHeaderLink);
			browserAction.clickJS(createAccountCTA);
		}
	}

	/**
	 * @description : User enter Email
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public boolean userEnterEmail(String email) throws Exception {
		boolean emailentered = false;
		browserAction.waitForElementClickable(guestUserEmailIDTextBox_SI);
		emailentered = browserAction.setText(guestUserEmailIDTextBox_SI, email, "",
				"Guest user Email ID entered as <font color=#00b3b3> '" + email + "'");
		Thread.sleep(5000);
		return emailentered;
	}

	/**
	 * @description : user click on Continue button : On account creation
	 * @throws Exception
	 */
	public void clickContinueButton() throws Exception {
		browserAction.waitForElementClickable(continueButton_SI);
		browserAction.clickJS(continueButton_SI, "", "'Continue' button clicked");

	}

	/**
	 * @description : User enter Password
	 * @param value
	 * @throws Exception
	 */
	public void userEnterPassword(String value) throws Exception {
		browserAction.waitForElementClickable(userPassword_SI);
		browserAction.setText(userPassword_SI, value, "", "User Entered Password");
	}

	/**
	 * @description User enter first Name
	 * @param value
	 * @throws Exception
	 */
	public void userEnterFirstName(String value) throws Exception {
		browserAction.setText(firstName_SI, value, "", "User Entered First Name : " + value);
	}

	/**
	 * @description : User enter Last Name
	 * @param value
	 * @throws Exception
	 */
	public void userEnterLastName(String value) throws Exception {
		browserAction.setText(lastName_SI, value, "", "User Entered Last Name : " + value);
	}

	/**
	 * @description : User enter Calendar Date
	 * @param value
	 * @throws Exception
	 */
	public void userEnterMobileCalendarDate(String value) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('birth-date-input').type = \"\";");
		browserAction.setText(dobCalendar, value);
	}

	/**
	 * @description : user enter month
	 * @param value
	 * @throws Exception
	 */
	public void userEnterMonth(String value) throws Exception {
		browserAction.setText(month_SI, value, "", "User Entered Month : " + value);
	}

	/**
	 * @description : user enter day
	 * @param value
	 * @throws Exception
	 */
	public void userEnterDay(String value) throws Exception {
		browserAction.setText(day_SI, value, "", "User Entered Day : " + value);
	}

	/**
	 * @description : user enter Year
	 * @param value
	 * @throws Exception
	 */
	public void userEnterYear(String value) throws Exception {
		browserAction.setText(year_SI, value, "", "User Entered Year : " + value);
	}

	/**
	 * @description : user Click on Continue button - Create account region
	 * @throws Exception
	 */
	public void userclickContinue() throws Exception {

		browserAction.click(continueButton_SI, "", "User click Continue");
		browserAction.WaittoPageLoad();
	}

	/**
	 * @description : user select Title
	 * @param valuetoselect
	 * @throws Exception
	 */
	public void selectUserTitle(String valuetoselect) throws Exception {

		if (browserName.contains("Android") || browserName.contains("IosSafari")) {
			browserAction.click(title_SI_mobile);
			browserAction.selectValueFromList(title_SI_list_mobile_android, valuetoselect, "",
					"Title Selected : " + valuetoselect);
		} else if (browserName.contains("Linux")) {
			browserAction.click(title_SI_mobile);
			browserAction.selectValueFromList(title_SI_list_mobile, valuetoselect, "",
					"Title Selected : " + valuetoselect);
		} else {
			browserAction.clickJS(title_SI);
			browserAction.selectValueFromList(title_SI_list, valuetoselect, "", "Title Selected : " + valuetoselect);
		}
	}

	/**
	 * @description : user select title for JP
	 * @param valuetoselect
	 * @throws Exception
	 */
	public void selectUserTitle_jp(String valuetoselect) throws Exception {

		if (browserName.contains("Android")) {
			browserAction.selectFromDD(title_SI_mobile_jp, valuetoselect, "", "Title selected as - " + valuetoselect);
		} else if (browserName.contains("Linux")) {
			browserAction.click(title_SI_mobile_jp);
			browserAction.selectValueFromList(title_SI_list_mobile_jp, valuetoselect, "",
					"Title Selected : " + valuetoselect);
		} else {
			browserAction.clickJS(title_SI_jp);
			browserAction.selectValueFromList(title_SI_list_jp, valuetoselect, "", "Title Selected : " + valuetoselect);
		}
	}

	/**
	 * @description : Used to create user account
	 * @throws Exception
	 */
	public void createUserAccount() throws Exception {

		String dob;
		String newEmail = FunctionBank.generatebrowserTimeStampEmailId(browserName);
		testDependentEmail = newEmail;

		browserAction.waitForPageDOMLoad(5000L);
		userEnterEmail(newEmail);
		browserAction.waitForPageDOMLoad(5000L);
		clickContinueButton();

		if (browserName.contains("Firefox")) {
			System.out.println(driver.getCurrentUrl());
			String urlnew = driver.getCurrentUrl();
			urlnew = urlnew.replaceAll("%2F", "/");
			System.out.println(urlnew);
			browserAction.getURL(urlnew);
			browserAction.WaittoPageLoad();

			userEnterEmail(newEmail);
			clickContinueButton();

		}

		userEnterPassword(testCaseData.get("User_Password"));

		if (testCaseData.get("CountryCode").equals("JP")) {
			selectUserTitle_jp(testCaseData.get("User_Title"));
		} else {
			selectUserTitle(testCaseData.get("User_Title"));
		}

		userEnterFirstName(testCaseData.get("User_FirstName"));
		userEnterLastName(testCaseData.get("User_LastName"));

		if (browserName.contains("Android") || browserName.contains("IosSafari")) {
			dob = testCaseData.get("DOB_Year") + "-" + testCaseData.get("DOB_Month") + "-"
					+ testCaseData.get("DOB_Date");
			userEnterMobileCalendarDate(dob);
		} else {
			userEnterMonth(testCaseData.get("DOB_Month"));
			userEnterDay(testCaseData.get("DOB_Date"));
			userEnterYear(testCaseData.get("DOB_Year"));
		}

		boolean marketingcheckboxexist = clickKeepMeUpdatedCheckbox();
		verify_createaccount_marketing_checkbox(marketingcheckboxexist);
		userclickContinue();

		if (testCaseData.get("CountryCode").equals("JP")) {
			verifyWelocmeMessage(testCaseData.get("User_LastName") + " " + testCaseData.get("User_FirstName"));
			testCaseData.put("registeredEmail", newEmail);
		} else {
			verifyWelocmeMessage(testCaseData.get("User_FirstName") + " " + testCaseData.get("User_LastName"));
			testCaseData.put("registeredEmail", newEmail);
		}

		/*
		 * Fix applied for Paypal Cases Failing due to Authorization Issue
		 */
		if (browserName.contains("Linux")) {
			browserAction.navigateToCurrentURLwithBasicAuthentication(Executor.propReader.getProperty("username"),
					Executor.propReader.getProperty("password"));
		}
		browserAction.WaittoPageLoad();

	}

	/**
	 * @description : use to Login into gucci application
	 * @param testCaseId
	 * @param testIdValue
	 * @param key
	 * @throws Exception
	 */
	public void loginUser(String testCaseId, String testIdValue, String key) throws Exception {

		browserAction.WaittoPageLoad();
		if (testCaseData.get("Module").contains("MyAccount_OrderHistory"))
			testDependentEmail = testCaseData.get("Login_OrderHistory");
		else if (testCaseData.get("Module").contains("RegisteredUserCheckoutModule")) {
			testDependentEmail = testCaseData.get("registeredEmail");
		} else
			testDependentEmail = FunctionBank.getValueofKeyfromListofMapObj(testCaseDatacollector.testcasesList,
					testCaseId, testIdValue, "CountryCode", testCaseData.get("CountryCode"), key);
		if (browserName.contains("Firefox")) {
			browserAction.waitForURLChange("https://qa1.edge.regiongold.com/at/en_gb/access/view?stateToken=", 2000l,
					10);
			System.out.println(driver.getCurrentUrl());
			String urlnew = driver.getCurrentUrl();
			urlnew = urlnew.replaceAll("%2F", "/");
			System.out.println(urlnew);
			browserAction.getURL(urlnew);
			browserAction.WaittoPageLoad();
		}

		if (!testDependentEmail.equals(null)) {

			userEnterEmail(testDependentEmail);
			browserAction.staticWait(1);
			if (browserName.contains("Android") || browserName.contains("Linux")) {
				clickContinueButton();
			} else {
				clickContinueButton();
			}
			userEnterPassword(testCaseData.get("User_Password"));
			browserAction.staticWait(1);
			browserAction.waitForElementClickable(loginConfirm);
			browserAction.click(loginConfirm, imgPath, "Submit");
			browserAction.staticWait(3);
			browserAction.WaittoPageLoad();
			browserAction.staticWait(4);
			System.out.println("*************URL after login***********************");
			System.out.println(driver.getCurrentUrl());
			System.out.println("*************************************");

		}

		if (browserName.contains("Linux")) {
			browserAction.navigateToCurrentURLwithBasicAuthentication(Executor.propReader.getProperty("username"),
					Executor.propReader.getProperty("password"));
		}
	}

	public void loginUser() throws Exception {

		browserAction.WaittoPageLoad();

		testDependentEmail = testCaseData.get("registeredEmail");
		if (!testDependentEmail.equals(null)) {

			userEnterEmail(testDependentEmail);
			browserAction.staticWait(1);
			if (browserName.contains("Android") || browserName.contains("Linux")) {
				clickContinueButton();
			} else {
				clickContinueButton();
			}
			userEnterPassword(testCaseData.get("User_Password"));
			browserAction.staticWait(1);
			browserAction.waitForElementClickable(loginConfirm);
			browserAction.click(loginConfirm, imgPath, "Submit");
			browserAction.staticWait(3);
			browserAction.WaittoPageLoad();
			browserAction.staticWait(4);

		}
	}

	/**
	 * @description : TO click on Keep me Updated Checkbox
	 * @return
	 * @throws Exception
	 */
	public boolean clickKeepMeUpdatedCheckbox() throws Exception {

		boolean clicked = false;
		try {
			if (!keepme_updated_check_SI.isSelected()) {
				clicked = browserAction.clickJS(keepme_updated_check_SI, imgPath, "Click on Keep Me Updated CheckBox ");
			} else {
				clicked = true;
			}
		} catch (Exception e) {
			clicked = false;
		}
		browserAction.WaittoPageLoad();
		return clicked;
	}

	/**
	 * @description : To Verify the Welcome Message
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Boolean verifyWelocmeMessage(String username) throws Exception {
		browserAction.waitForURLChange("my-account", 2000l, 15);
		browserAction.waitForElementVisibility(welcomeText);
		boolean verification = false;
		browserAction.WaittoPageLoad();
		try {
			boolean usernameVeriification = welcomeText.getText().trim().contains(username.toUpperCase())
					|| welcomeText.getText().trim().contains(username);
			report.assertThat(usernameVeriification, username, welcomeText.getText());
			verification = true;
		} catch (Exception e) {
			report.assertThat(false, "Account Created Successfully with <font color=#00b3b3> '" + username + "'",
					"Account Has not been created -" + e.getMessage());
			throw new Exception("Test Case Failed");
		}
		return verification;
	}

	/**
	 * @description : To verify Marketing checkbox existence in create account area
	 * @param existence
	 * @return
	 * @throws Exception
	 */
	public Boolean verify_createaccount_marketing_checkbox(boolean existence) throws Exception {
		boolean verification = false;
		try {
			report.assertThat(String.valueOf(existence).equals(testCaseData.get("ca_marketing_checkbox")),
					"Marketing Check box exist : " + testCaseData.get("ca_marketing_checkbox"),
					"Marketing Check box exist : " + !Boolean.parseBoolean(testCaseData.get("ca_marketing_checkbox")));
			verification = true;
		} catch (Exception e) {
			report.assertThat(false, "Marketing Check box exist : " + testCaseData.get("ca_marketing_checkbox"),
					"Marketing Check box does not exist");
			throw new Exception("Test Case Failed");
		}
		return verification;
	}

	/**
	 * @description : verify User has been created successfully
	 * @param emailid
	 * @return
	 * @throws Exception
	 */
	public Boolean verifyCreateUserConfirmation(String emailid) throws Exception {
		boolean verification = false;
		browserAction.WaittoPageLoad();
		try {
			report.assertThat(createAccountconfirmation.getText().contains(emailid),
					createAccountconfirmation.getText(), createAccountconfirmation.getText());
			verification = true;
		} catch (Exception e) {
			report.assertThat(false, "Account Created Successfully with <font color=#00b3b3> '" + emailid + "'",
					"Account Has not been created -" + e.getMessage());
			throw new Exception("Test Case Failed");
		}
		return verification;
	}

}
