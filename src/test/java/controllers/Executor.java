package controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;

import helpers.FunctionBank;
import helpers.PropertiesReader;
import helpers.XMLReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Executor {

	public static String uniqueID, Devices[], IPs[], URL, PROJECT_PATH;
	public static Map<String, String> automation_reportsname_map;
	public static String dashboardIndexfilepath;
	public static int noOfDevices, totalTestCases;
	public static ExtentReports SummaryReport;
	public static PropertiesReader propReader = PropertiesReader.getInstance();
	public static String testDataFiles;
	public static String chromedriverpath, firefoxdriverpath, ieEdgedriverpath, iedriverpath;
	public static String folderPath;

	public static void main(String[] args) {

		automation_reportsname_map = new HashMap<String, String>();
		/*****************************************
		 * Browser Drivers
		 ******************************************/
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		// WebDriverManager.iedriver().setup();
		// WebDriverManager.edgedriver().setup();
		firefoxdriverpath = WebDriverManager.firefoxdriver().getBinaryPath();
		chromedriverpath = WebDriverManager.chromedriver().getBinaryPath();
		// ieEdgedriverpath=WebDriverManager.edgedriver().getBinaryPath();
		// iedriverpath=WebDriverManager.iedriver().getBinaryPath();
		/*********************************************************************************/

		PROJECT_PATH = new File("").getAbsolutePath();
		uniqueID = System.getenv("BUILD_TIMESTAMP");

		if (uniqueID != null) {
			uniqueID = System.getenv("BUILD_TIMESTAMP");
		} else {
			uniqueID = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		}

		testDataFiles = System.getenv("SPECIFIC_TESTDATA");

		System.out.println("********************************************************");
		System.out.println("********************************************************");
		System.out.println("**************JENKINS BUILD PARAMETERS******************");
		System.out.println(System.getenv("SPECIFIC_TESTDATA"));
		System.out.println("********************************************************");
		System.out.println("********************************************************");
		System.out.println("********************************************************");
		// testDataFiles= "Japan.json";
		setPrerequisit();

	}

	public static void setPrerequisit() {
		try {

			String reportfolderTimeStampPath = PROJECT_PATH + File.separator + "Reports" + File.separator + uniqueID
					+ File.separator;
			String summaryReportName = "Test_Execution_Summary.html";

			new File(reportfolderTimeStampPath).mkdir();

			SummaryReport = new ExtentReports(reportfolderTimeStampPath + File.separator + summaryReportName, false);
			SummaryReport.loadConfig(new File("extent-config.xml"));

			FunctionBank.copyFile(
					PROJECT_PATH + File.separator + "src" + File.separator + "main" + File.separator + "resources"
							+ File.separator + "guccilogo.png",
					reportfolderTimeStampPath + File.separator + "guccilogo.png");

			SummaryReport.flush();

			automation_reportsname_map.put("Test_Execution_Summary", summaryReportName);

			getXMLConfig();
			new ThreadCreator().startExecution();
			Thread.sleep(60000);

			dashboardIndexfilepath = reportfolderTimeStampPath + File.separator + "index.html";
			FunctionBank.createHTMLFile(dashboardIndexfilepath, automation_reportsname_map);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getXMLConfig() {
		try {

			XMLReader xml = new XMLReader("config.xml");
			URL = xml.readTagVal("URL");
			noOfDevices = Integer.parseInt(xml.readTagVal("NUMOFTHREADS"));
			Devices = new String[noOfDevices];
			IPs = new String[noOfDevices];

			for (int i = 0; i < noOfDevices; i++) {
				Devices[i] = xml.readTagVal("BROWSER" + String.valueOf(i + 1));
				IPs[i] = xml.readTagVal("IPPORT" + String.valueOf(i + 1));
			}
		} catch (Exception e) {
			System.err.println("Exception while reading the config xml..." + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
