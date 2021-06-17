package helpers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import controllers.Executor;

public class Reporting {

	public String folderName, screenshotsFolder, folder, folderpath;

	public WebDriver driver;

	public ExtentReports extentReports;
	public ExtentTest test;

	public ExtentTest Summarytest;

	Date date = new Date();

	public String imagePath = "";

	DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");

	public Reporting() {

	}

	public Reporting(String browserCode) {

		createFolder(browserCode, Executor.uniqueID);
		String stepname = "<font face='Comic sans MS' size='+1' color=#007399> <bold>" + browserCode
				+ "</bold> </font>";
		Summarytest = Executor.SummaryReport.startTest(stepname);
		Executor.SummaryReport.flush();
	}

	public void assignDriverToReport(WebDriver driver) {
		this.driver = driver;
	}

	/** Create Reporting and Screenshot folders */

	public String createFolder(String browserName, String Uniqueid) {
		folderName = "";

		try {

			// Check Reports folder create if not created

			File file = new File(Executor.PROJECT_PATH + File.separator + "Reports");

			if (!file.exists()) {
				if (file.mkdir()) {
				}
			}

			// Check TimeStamp folder create if not created

			folderName = Executor.PROJECT_PATH + File.separator + "Reports" + File.separator + Uniqueid;

			file = new File(folderName);

			if (!file.exists()) {
				if (file.mkdir()) {
				}
			}

			// Create browser folder

			folderName = folderName + File.separator + browserName;

			file = new File(folderName);

			if (!file.exists()) {
				if (file.mkdir()) {
				}
			}

			screenshotsFolder = folderName;

		} catch (Exception e) {
			e.printStackTrace();
		}

		setFolderpath(folderName);
		setfolder(Uniqueid);
		return folderName;
	}

	/** Set Reporting Folder Path */

	public void setFolderpath(String folderpath) {
		this.folderpath = folderpath;
		imagePath = folderpath + File.separator;
	}

	/** Set Reporting Folder */

	public void setfolder(String foldername) {
		this.folder = foldername;
	}

	/** Generate Current Date Number which can be used to create Reporting Folder */

	public static String generateCurrentDateNumber() {
		Date dNow = new Date();
		SimpleDateFormat sFrmt = new SimpleDateFormat("ddMMMyyyy_hhmmss_SSaa");
		String folderName = sFrmt.format(dNow);

		return folderName;
	}

	/** Get screenshot from Screenshots folder */

	public String getscreenshot(String fileName) {
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");
		Date date = new Date();
		String screenshotfile = dateFormat.format(date) + ".png";

		try {
			FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE),
					new File(fileName + screenshotfile));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return Executor.Devices[Integer.parseInt(Thread.currentThread().getName()) - 1] + "/" + screenshotfile;
	}

	/** Log step into the extent report */

	public void logStepToReport(LogStatus status, String stepname, String Details, String filenamePath) {
		if (!filenamePath.equalsIgnoreCase("")) {

			try {
				test.log(status, "<font color=800080> <b> " + stepname,
						"<div align='left' style='float:left'><a " + NewWindowPopUpHTMLCode() + " target='_blank' href="
								+ getscreenshot(imagePath) + ">" + Details + "</a></div>");
				

			} catch (Exception e) {
				test.log(status, "<font color=800080> <b> " + stepname,
						Details + "<div align='right' style='float:right'>Unable to take screenshot</div>");
			}

		} else {
			test.log(status, stepname, Details);
		}

		extentReports.flush();
	}

	/** Assert Expected condition with the Actual Condition */

	public void assertThat(boolean status, String passMessage, String failMessage) {

		if (!status) {

			String line2 = " Expected - " + passMessage + "<br> <b> <font color='red'> Actual - " + failMessage;

			test.log(LogStatus.FAIL, "<font color=800080> <b> Verification Point",
					line2 + "<div align='right' style='float:right'><a " + NewWindowPopUpHTMLCode()
							+ " target='_blank' href=" + getscreenshot(imagePath) + ">Screenshot</a></div>");

		} else {

			String line2 = " Expected - " + passMessage + "<br> <b> <font color='green'> Actual - " + passMessage;

			test.log(LogStatus.PASS, "<font color=800080> <b> Verification Point",
					line2 + "<div align='right' style='float:right'><a " + NewWindowPopUpHTMLCode()
							+ " target='_blank' href=" + getscreenshot(imagePath) + ">Screenshot</a></div>");

		}

		extentReports.flush();

	}

	/** End Test Cases */

	public void endTestCase() {
		extentReports.flush();
		extentReports.endTest(test);
		extentReports.flush();
	}

	/** Copy File */

	public void StartTestInSummaryReport(String bName) {
		String stepname = "<font face='Comic sans MS' size='+1' color=#007399> <bold>" + bName + "</bold> </font>";
		Summarytest = Executor.SummaryReport.startTest(stepname);
		Executor.SummaryReport.flush();
	}

	/** Generate attribute tag to open mentioned file path in new pop up window */

	public String NewWindowPopUpHTMLCode() {
		return "onclick = \"window.open(this.href,'newwindow', 'width="
				+ Executor.propReader.getProperty("ReportPopUpWindowWidth") + ",height="
				+ Executor.propReader.getProperty("ReportPopUpWindowHeight") + "');return false;\"";
	}

	public void logGalenStepToReport(LogStatus status, String stepname, String Details, String filenamePath) {
		if (!filenamePath.equalsIgnoreCase("")) {
			try {
				test.log(status, "<font color=#800080> <b> " + stepname,
						Details + "<div align='right' style='float:right'><a " + NewWindowPopUpHTMLCode()
								+ " target='_blank' href=" + filenamePath + ">Galen Report</a></div>");
				extentReports.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			test.log(status, stepname, Details);
		}

		extentReports.flush();
	}

	public void assignCategory(String category) {
		try {
			test.assignCategory(category);
			extentReports.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startTest(String testName, String browserCode) {
		try {
			String browserReportPath = browserCode + "_Report.html";
			extentReports = new ExtentReports(Executor.PROJECT_PATH + File.separator + "Reports" + File.separator
					+ Executor.uniqueID + File.separator + browserCode + "_Report.html", false);

			Executor.automation_reportsname_map.put(browserCode + "_Report", browserReportPath);

			extentReports.loadConfig(new File("extent-config.xml"));
			test = extentReports.startTest("<font face='Verdana' color=#805500> <bold>" + testName + "</bold> </font>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ExtentTest getCurrentExtentTest() {
		return this.test;
	}

}
