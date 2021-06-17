package pagesObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import controllers.Executor;
import helpers.BrowserActions;
import helpers.Reporting;

public class HomePage {

	public WebDriver driver;
	public Reporting report;
	public BrowserActions browserAction;
	public String browserName;
	public String imgPath;
	public Map<String, String> testCaseData;

	public HomePage(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData) {

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
	@FindBy(how = How.XPATH, using = "//div[@id='international-overlay']//button")
	private WebElement countryPopUpCloseButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'shop men')]")
	private WebElement shopMenLink;

	@FindBy(how = How.XPATH, using = "//a[@id='header-nav-mobile']")
	private WebElement TopMenuLink;

	@FindBy(how = How.XPATH, using = "(//a[@id='header-nav-signin-anchor'])[2]")
	private WebElement HeaderSignInLink;

	@FindBy(how = How.XPATH, using = "(//a[@id='header-nav-signin-anchor'])[1]")
	private WebElement HeaderSignInLink_Mobile;

	@FindBy(how = How.XPATH, using = "//select[@id='create-account-title']//option")
	private List<WebElement> title;

	@FindBy(how = How.XPATH, using = "//nav[@id='header-nav']/following-sibling::div//a")
	private WebElement searchIcon1;

	@FindBy(how = How.XPATH, using = "(//nav[@id='header-nav-bag-wrapper']/preceding-sibling::div/a)[3]")
	private WebElement searchIcon2;

	@FindBy(how = How.XPATH, using = "//input[@id='search-input']")
	private WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//input[@id='header-nav-search-input']")
	private WebElement searchBox1;

	@FindBy(how = How.XPATH, using = "//article/a")
	private WebElement productImg_SKU;

	@FindBy(how = How.XPATH, using = "//div[@data-testid='product-cell']/a")
	private WebElement productImg_SKU1;

	@FindBy(how = How.ID, using = "account-settings-title")
	private WebElement accountsettings_Title_drpdown;

	@FindBy(how = How.ID, using = "account-settings-gender")
	private WebElement accountsettings_Title_drpdown_JP;

	@FindBy(how = How.XPATH, using = "//input[@id='account-settings-firstname']")
	private WebElement accountSettings_firstName;

	@FindBy(how = How.XPATH, using = "//input[@id='account-settings-lastname']")
	private WebElement accountsettings_lastname;

	@FindBy(how = How.XPATH, using = "//input[@id='account-settings-zipcode']")
	private WebElement accountsettings_zipcode;

	@FindBy(how = How.XPATH, using = "//select[@id='account-settings-title']")
	private WebElement accountsettings_nameTitle_mb;

	@FindBy(how = How.XPATH, using = "//select[@id='account-settings-gender']")
	private WebElement accountsettings_nameTitle_mb_JP;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-settings-title-container']")
	private WebElement accountsettings_nameTitle;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-settings-gender-container']")
	private WebElement accountsettings_nameTitle_JP;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-settings-country-container']")
	private WebElement accountsettings_Country;

	@FindBy(how = How.XPATH, using = "//select[@id='account-settings-country']")
	private WebElement accountsettings_Country_mob;

	@FindBy(how = How.XPATH, using = "//input[@id='account-settings-email']")
	private WebElement accountsettings_email;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-settings-day-container']")
	private WebElement accountsettings_day;

	@FindBy(how = How.XPATH, using = "//select[@id='account-settings-day']")
	private WebElement accountsettings_day_mob;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-settings-month-container']")
	private WebElement accountsettings_month;

	@FindBy(how = How.XPATH, using = "//select[@id='account-settings-month']")
	private WebElement accountsettings_month_mob;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-account-settings-year-container']")
	private WebElement accountsettings_year;

	@FindBy(how = How.XPATH, using = "//select[@id='account-settings-year']")
	private WebElement accountsettings_year_mob;

	@FindBy(how = How.XPATH, using = "(//form[@id='accountSettingsForm']//div[contains(@class,'account-settings-form-content-group')])[5]/button")
	private WebElement accountsettings_savechanges;

	@FindBy(how = How.XPATH, using = "(//a[@id='header-nav-signin-anchor']/following-sibling::ul/li/a)[5]")
	private WebElement accountSettings;

	@FindBy(how = How.XPATH, using = "//input[@id='global-newsletter']/following-sibling::label")
	private WebElement global_newsLetter;

	@FindBy(how = How.XPATH, using = "//input[@id='global-newsletter']")
	private WebElement global_newsLetterinp;

	@FindBy(how = How.XPATH, using = "((//form[@id='accountSettingsForm']/div)[5]//button)[1]")
	private WebElement saveButton_myaccount;

	@FindBy(how = How.XPATH, using = "(//form[@id='accountSettingsForm']/div)[3]//h3")
	private WebElement acountdetailslabel;

	@FindBy(how = How.XPATH, using = "//li//span/a[@id='header-nav-signin-anchor']/../../a")
	private WebElement myaccountlink;

	@FindBy(how = How.XPATH, using = "((((//div[@id='mobile-menu']/div)[2]/div)[last()]/div)[2]/div)[4]//a")
	private WebElement accountsetting_mob;

	@FindBy(how = How.ID, using = "(//form[@id='accountSettingsForm']//h3)[1]")
	private WebElement myaccount_infoHeader;

	@FindBy(how = How.XPATH, using = "(//a[@id='header-nav-signin-anchor'])[2]")
	private WebElement myAccountHeaderLink;

	@FindBy(how = How.XPATH, using = "//a[@id='header-nav-signin-anchor']/following-sibling::ul/li[contains(@class,'logout')]/a")
	private WebElement signoutmyaccount;

	@FindBy(how = How.XPATH, using = "((//div[@id='mm-11']/div)[2]//div/a)[last()]")
	private WebElement signoutmyaccount_mob;

	@FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
	private WebElement btnAcceptAllCookies;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"close-toggle-main\"]")
	private WebElement chatbotCloseButton_Web;
	
	

	/**
	 * ==========================================================================
	 * =====================Page Related Methods=================================
	 * ==========================================================================
	 */

	/**
	 * @description : Closes the Choose Country Overlay that appears in the Home
	 *              Page Note : Country Overlay Does not appears in the Jenkins Env
	 *              thus set as false
	 * @throws Exception
	 */
	public void closeCountrySelectPopUp() throws Exception {
		if (!testCaseData.get("CountryCode").contains("US")) {
			browserAction.waitForElementClickable(countryPopUpCloseButton);
			browserAction.clickJS(countryPopUpCloseButton, imgPath, "Cancel Country Pop up");
		}
	}

	
	public void godFunction() throws Exception{
		
	}
	
	
	public void closeCountrySelectPopUp(Map<String, String> testData) throws Exception {
		
		Thread th = Thread.currentThread();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					boolean run = true;
					
					// System.out.println("Performing operation in Asynchronous Task Start");
				//	WebElement chatbotClose;
					String url = Executor.URL;
					System.out.println("Another Thread execution is on");
					while (run) {
						
						//if(url.equals(driver.getCurrentUrl())) {
							System.out.println("Executing............" + browserAction.isElementPresent(chatbotCloseButton_Web));
							if (browserAction.isElementPresent(chatbotCloseButton_Web)) {
								System.out.println("Found Chatbot");
								th.suspend();
								System.out.println("Chatbot present : " + browserAction.isElementDisplayed(chatbotCloseButton_Web, 1));
								browserAction.click(chatbotCloseButton_Web, imgPath, "Click performed to Close Chatbot");
								th.resume();
							//	Thread.currentThread().stop();
							//	run = false;
							}else {
								System.out.println("Chatbot Element Not found");
							}
							//th.resume();
//						}else {
//							url = driver.getCurrentUrl();
//						}
//						
						
						
//						System.out.println("Performing operation in Asynchronous Task Start");
//						if (testData.get("Browser_Name").contains("edge")
//								|| testData.get("Browser_Name").contains("Windows")
//								|| testData.get("Browser_Name").contains("Mac")
//								|| testData.get("Browser_Name").contains("Firefox")) {
//							chatbotClose = driver
//									.findElement(By.xpath("//*[@id=\"cts-tab\"]/div/img[contains(@src,'close')]"));
//						} else {
//							chatbotClose = driver.findElement(By.xpath("//*[@id=\"close-toggle-main\"]"));
//						}
						
					//	System.out.println("Chatbot present : " + browserAction.isElementDisplayed(chatbotClose, 1));

//						if (browserAction.isElementPresent(chatbotClose)) {
//							browserAction.clickJS(chatbotClose, imgPath, "Click performed to Close Chatbot");
//							Thread.currentThread().stop();
//							run = false;
//						}
					}
					System.out.println("Performing operation in Asynchronous Task Stop");

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		browserAction.WaittoPageLoad();
		browserAction.isDisplayedClickAgain(btnAcceptAllCookies, btnAcceptAllCookies, 2, 60);
		browserAction.isDisplayedClickAgain(countryPopUpCloseButton, countryPopUpCloseButton, 30, 60);

	}

	/**
	 * @description : Click on Sign In Link in the Header
	 * @throws Exception
	 */
	public void clickSignInLink() throws Exception {
		String headerSignInLinkXPath = "(//a[@id='header-nav-signin-anchor'])[2]";
		browserAction.waitForElementPresence(headerSignInLinkXPath);
		browserAction.clickJS(HeaderSignInLink, imgPath, "Click Performed on Sign In Button");
	}

	/**
	 * @description : Enter SKUID on the Search Input Field
	 * @param value : SKUID
	 * @return
	 * @throws Exception
	 */
	public void enterTextOnSearchBox(String value) throws Exception {

		if (testCaseData.get("ProductSearchInput").equalsIgnoreCase("0")) {
			browserAction.setText(searchBox, value, "", "Text Set in search Box as : " + value);
			browserAction.Submit(searchBox);
			browserAction.waitForElementClickable(productImg_SKU1);
			browserAction.clickJS(productImg_SKU1, imgPath, "Click Performed on Product of Style Id : " + value);
		} else if (testCaseData.get("ProductSearchInput").equalsIgnoreCase("1")) {
			browserAction.setText(searchBox1, value, "", "Text Set in search Box as : " + value);
			browserAction.Submit(searchBox1);
			browserAction.waitForElementClickable(productImg_SKU);
			browserAction.clickJS(productImg_SKU, imgPath, "Click Performed on Product of Style Id : " + value);
		}
		browserAction.WaittoPageLoad();
	}

	/**
	 * @description : click on the Search Icon on Top Right - Header
	 * @throws Exception
	 */
	public void clickSearchIcon() throws Exception {

		if ((browserName.contains("Firefox"))) {
			browserAction.waitForElementClickable(searchIcon1);
			browserAction.clickJS(searchIcon1, "", "Search Icon");
		} else if (browserName.contains("Linux")) {
			browserAction.waitForElementClickable(searchIcon2);
			browserAction.click(searchIcon2, "", "Search Icon");
		} else if (browserName.contains("Android")) {
			browserAction.waitForElementClickable(searchIcon2);
			browserAction.clickJS(searchIcon2, "", "Search Icon");
		} else {
			// browserAction.waitForElementClickable(searchIcon1);
			browserAction.waitForElementVisibility(searchIcon1);
			browserAction.clickJS(searchIcon1, "", "Search Icon");
		}
	}

	/**
	 * @description : Click on Search ICON | enter SKU | Click on Searched Product
	 * @param styleId
	 * @throws Exception
	 */
	public void selectProductBySearch(String styleId) throws Exception {
		browserAction.WaittoPageLoad();
		clickSearchIcon();
		enterTextOnSearchBox(styleId);
	}

}