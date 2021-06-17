package helpers;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static helpers.FunctionBank.*;
import static controllers.Executor.*;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class Drivers {

	public WebDriver driver;
	public String driverBasepath = PROJECT_PATH + "/GridFiles/drivers/";

	public static final String USERNAME = propReader.getProperty("USERNAME_BrStck");
	public static final String AUTOMATE_KEY = propReader.getProperty("PASSWORD_BrStck");
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static String buildNumber = "local-" + generateTimeStamp();

	public WebDriver OpenBrowser() {

		if (System.getenv("BUILD_NUMBER") != null) {
			buildNumber = System.getenv("BUILD_NUMBER");
		}

		String currentIP = "http://" + IPs[Integer.parseInt(Thread.currentThread().getName()) - 1] + "/wd/hub";
		String browserCode = Devices[Integer.parseInt(Thread.currentThread().getName()) - 1];
		Cookie cookie = addcookies();

		String deviceName = propReader.getProperty("deviceName");
		int width = Integer.parseInt(propReader.getProperty("width"));
		int height = Integer.parseInt(propReader.getProperty("height"));

		try {
			switch (browserCode) {
			case "InternetExplorer":

				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability("os", "Windows");
				ieCapabilities.setCapability("os_version", "10");
				ieCapabilities.setCapability("browser", "IE");
				ieCapabilities.setCapability("browser_version", "11.0");
				ieCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				ieCapabilities.setCapability("name", "User Checkouts");
				ieCapabilities.setCapability("project", "Gucci-UI-Automation");
				ieCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), ieCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					System.setProperty("webdriver.ie.driver", iedriverpath);
					InternetExplorerOptions ieoptions = new InternetExplorerOptions();
					ieoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
					driver = new InternetExplorerDriver(ieoptions);
					driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), ieCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.navigate().to(propReader.getProperty("add_url"));
				driver.manage().addCookie(cookie);
				driver.manage().window().maximize();

				break;

			case "Firefox":

				DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();

				firefoxCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				firefoxCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
						UnexpectedAlertBehaviour.ACCEPT);
				firefoxCapabilities.setCapability("os", "Windows");
				firefoxCapabilities.setCapability("os_version", "10");
				firefoxCapabilities.setCapability("browser", "Firefox");
				firefoxCapabilities.setCapability("browser_version", "87.0");
				firefoxCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				firefoxCapabilities.setCapability("name", "User Checkouts");
				firefoxCapabilities.setCapability("project", "Gucci-UI-Automation");
				firefoxCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), firefoxCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					System.setProperty("webdriver.gecko.driver", firefoxdriverpath);
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					driver = new FirefoxDriver(firefoxOptions);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), firefoxCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.navigate().to(propReader.getProperty("add_url"));
				driver.manage().addCookie(cookie);
				driver.manage().window().maximize();
				break;

			case "WindowsChrome":

				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				chromeCapabilities.setCapability("browser", "Chrome");
				chromeCapabilities.setCapability("browser_version", "latest");
				chromeCapabilities.setCapability("os", "Windows");
				chromeCapabilities.setCapability("os_version", 10);
				chromeCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				chromeCapabilities.setCapability("name", "User Checkouts");
				chromeCapabilities.setCapability("project", "Gucci-UI-Automation");
				chromeCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), chromeCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					System.setProperty("webdriver.chrome.driver", chromedriverpath);
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					driver = new ChromeDriver(chromeOptions);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), chromeCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();

				break;

			case "WindowsEdge":

				DesiredCapabilities edgeCapabilities = DesiredCapabilities.edge();
				edgeCapabilities.setCapability("os", "Windows");
				edgeCapabilities.setCapability("os_version", "10");
				edgeCapabilities.setCapability("browser", "Edge");
				edgeCapabilities.setCapability("browser_version", "latest");
				edgeCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				edgeCapabilities.setCapability("name", "User Checkouts");
				edgeCapabilities.setCapability("project", "Gucci-UI-Automation");
				edgeCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), edgeCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					System.setProperty("webdriver.edge.driver", ieEdgedriverpath);
					EdgeOptions edgeOptions = new EdgeOptions();
					driver = new EdgeDriver(edgeOptions);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), edgeCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				break;

			case "LinuxChrome":

				DesiredCapabilities linuxChromeCapabilities = DesiredCapabilities.chrome();
				linuxChromeCapabilities.setCapability("browser", "Chrome");
				linuxChromeCapabilities.setCapability("browser_version", "latest");
				linuxChromeCapabilities.setCapability("os", "Windows");
				linuxChromeCapabilities.setCapability("os_version", 10);
				linuxChromeCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				linuxChromeCapabilities.setCapability("name", "User Checkouts");
				linuxChromeCapabilities.setCapability("project", "Gucci-UI-Automation");
				linuxChromeCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), linuxChromeCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					System.setProperty("webdriver.chrome.driver", chromedriverpath);
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--headless");
					chromeOptions.addArguments("--no-sandbox");
					chromeOptions.addArguments("headless", "window-size=1200,600");

					driver = new ChromeDriver(chromeOptions);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), linuxChromeCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				break;

			case "AndroidView":

				DesiredCapabilities mobileview = DesiredCapabilities.chrome();

				if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					ChromeOptions chromeOptions = new ChromeOptions();
					Map<String, String> mobileEmulation = new HashMap<>();
					mobileEmulation.put("deviceName", deviceName);
					chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
					driver = new ChromeDriver(chromeOptions);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), mobileview);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				break;

			case "LinuxView":

				DesiredCapabilities linuxview = DesiredCapabilities.chrome();

				if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					ChromeOptions chromeOptions = new ChromeOptions();
					driver = new ChromeDriver(chromeOptions);
					driver.manage().window().setSize(new Dimension(width, height));
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), linuxview);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				break;

			case "MacChrome":

				DesiredCapabilities macChromeCapabilities = DesiredCapabilities.chrome();
				macChromeCapabilities.setCapability("os", "OS X");
				macChromeCapabilities.setCapability("os_version", "Big Sur");
				macChromeCapabilities.setCapability("browser", "Chrome");
				macChromeCapabilities.setCapability("browser_version", "latest");
				macChromeCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				macChromeCapabilities.setCapability("name", "User Checkouts");
				macChromeCapabilities.setCapability("project", "Gucci-UI-Automation");
				macChromeCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), macChromeCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					System.setProperty("webdriver.chrome.driver", chromedriverpath);
					ChromeOptions chromeOptions = new ChromeOptions();
					driver = new ChromeDriver(chromeOptions);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), macChromeCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				break;

			case "AndroidChrome-SamsungGalaxyTabS7":

				DesiredCapabilities scap = new DesiredCapabilities();
				scap.setCapability("browserstack.video", "true");
				scap.setCapability("browserstack.idleTimeout", "300");
				scap.setCapability("browserstack.debug", "true");
				scap.setCapability("os_version", "10.0");
				scap.setCapability("device", "Samsung Galaxy Tab S7");
				scap.setCapability("real_mobile", "true");
				scap.setCapability("browserstack.local", "false");
				scap.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				scap.setCapability("name", "User Checkouts");
				scap.setCapability("project", "Gucci-UI-Automation");
				scap.setCapability("browserstack.maskCommands", "setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), scap);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), scap);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				break;
				
			case "AndroidChrome-SamsungGalaxyS8":

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("browserstack.video", "true");
				cap.setCapability("browserstack.idleTimeout", "300");
				cap.setCapability("browserstack.debug", "true");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S8");
				cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
				cap.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				cap.setCapability("name", "User Checkouts");
				cap.setCapability("project", "Gucci-UI-Automation");
				cap.setCapability("browserstack.maskCommands", "setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), cap);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), cap);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				break;

			case "AndroidChrome-GooglePixel":

				DesiredCapabilities cap1 = new DesiredCapabilities();
				cap1.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel");
				cap1.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				cap1.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				cap1.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
				cap1.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				cap1.setCapability("name", "User Checkouts");
				cap1.setCapability("project", "Gucci-UI-Automation");
				cap1.setCapability("browserstack.maskCommands", "setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), cap1);
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), cap1);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				break;

			case "AndroidChrome":

				DesiredCapabilities androidcap = new DesiredCapabilities();
				androidcap.setCapability(MobileCapabilityType.DEVICE_NAME, propReader.getProperty("androidDevice"));
				androidcap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				androidcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				// cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
				driver = new RemoteWebDriver(new URL(currentIP), androidcap);
				break;

			case "MacSafari":

				DesiredCapabilities safariDesiredCapabilities = DesiredCapabilities.safari();
				safariDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				safariDesiredCapabilities.setCapability("os", "OS X");
				safariDesiredCapabilities.setCapability("os_version", "Big Sur");
				safariDesiredCapabilities.setCapability("browser", "Safari");
				safariDesiredCapabilities.setCapability("browser_version", "14.0");
				safariDesiredCapabilities.setCapability("browserstack.local", "false");
				safariDesiredCapabilities.setCapability("browserstack.seleniumLogs", "false");
				safariDesiredCapabilities.setCapability("browserstack.debug", "false");
				safariDesiredCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				safariDesiredCapabilities.setCapability("name", "User Checkouts");
				safariDesiredCapabilities.setCapability("project", "Gucci-UI-Automation");
				safariDesiredCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), safariDesiredCapabilities);
				} else if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					driver = new SafariDriver();
				} else {
					driver = new RemoteWebDriver(new URL(currentIP), safariDesiredCapabilities);
				}
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.navigate().to(propReader.getProperty("add_url"));
				driver.manage().addCookie(cookie);
				driver.manage().window().maximize();

				break;

			case "IosSafari":

				DesiredCapabilities iOSDesiredCapabilities = DesiredCapabilities.iphone();
				
				iOSDesiredCapabilities.setCapability("browserstack.video", "true");
				iOSDesiredCapabilities.setCapability("browserstack.idleTimeout", "300");
				iOSDesiredCapabilities.setCapability("browserstack.debug", "true");

				iOSDesiredCapabilities.setCapability("os_version", "14");
				iOSDesiredCapabilities.setCapability("device", "iPhone XS");
				iOSDesiredCapabilities.setCapability("real_mobile", "true");
				iOSDesiredCapabilities.setCapability("browserstack.local", "false");
				iOSDesiredCapabilities.setCapability("browserstack.seleniumLogs", "false");
				iOSDesiredCapabilities.setCapability("browserstack.debug", "false");
				iOSDesiredCapabilities.setCapability("build", "Gucci-UI-Automation_" + buildNumber);
				iOSDesiredCapabilities.setCapability("name", "User Checkouts");
				iOSDesiredCapabilities.setCapability("project", "Gucci-UI-Automation");
				iOSDesiredCapabilities.setCapability("browserstack.maskCommands",
						"setValues, getValues, setCookies, getCookies");

				if (propReader.getProperty("browserStack").equals("true")) {
					driver = new RemoteWebDriver(new URL(URL), iOSDesiredCapabilities);
				} else	if (currentIP.contains("localhost") || currentIP.contains("127.0.0.1")) {
					ChromeOptions chromeOptions = new ChromeOptions();
					Map<String, String> mobileEmulation = new HashMap<>();
					mobileEmulation.put("deviceName", "iPhone X");
					chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
					driver = new ChromeDriver(chromeOptions);
				}else {
					driver = new RemoteWebDriver(new URL(currentIP), iOSDesiredCapabilities);
				}

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.navigate().to(propReader.getProperty("add_url"));
				driver.manage().addCookie(cookie);

				break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return driver;
	}

	public static Cookie addcookies() {
		return new Cookie("ANTANI", "SBLINDA");

	}

}
