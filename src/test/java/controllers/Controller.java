
package controllers;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import helpers.Drivers;
import helpers.FunctionBank;
import helpers.Reporting;

public class Controller {

	public WebDriver driver;
	public Reporting report;
	public TestDataCollector testDataCollector;

	public String browserName;
	public String executionPercentage;
	public int totalTestCases = 0, numberofTestFailed = 0, numberofTestPass = 0;
	int numberOfTestTrials = Integer.parseInt(Executor.propReader.getProperty("NumberOfTestTrials"));

	public List<Map<String, String>> testcases;

	public Controller() {

		testDataCollector = new TestDataCollector();
		testcases = testDataCollector.getTestDataList();
		browserName = Executor.Devices[Integer.parseInt(Thread.currentThread().getName()) - 1];
		report = new Reporting(browserName);

	}

	public WebDriver getDriver() throws InterruptedException {

		Drivers utilObj = new Drivers();
		driver = utilObj.OpenBrowser();
		return driver;
	}

	public void controllerMethod() throws Exception {

		Modules FactMethodObj = new Modules();
		System.out.println("Total test cases found - " + testcases.size());

		totalTestCases = testcases.size();
		Executor.totalTestCases = totalTestCases;

		for (Map<String, String> testData : testcases) {
			String testRunStatus = "false";
			int testRunCounter = 0;
			do {

				String testDescription = testData.get("TestCaseName");
				System.out.println("Test case execution start on " + browserName + " with test case description "
						+ testDescription);
				testData.put("Browser_Name", browserName);

				if (testData.get("CountryCode").contains("FI") || testData.get("CountryCode").contains("UAAS")
						|| testData.get("CountryCode").contains("JPA") || testData.get("CountryCode").contains("IAT")
						|| testData.get("CountryCode").contains("AEA")) {

					if (testRunCounter > 0) {
						testDescription = testData.get("TestCaseName") + " : RetryCounter =" + testRunCounter;
					}

					try {

						driver = getDriver();
						report.assignDriverToReport(driver);
						report.startTest(testDescription, browserName);
						report.assignCategory(testData.get("Test_Category"));

						ModuleInterface TestCaseSelectionObj = FactMethodObj
								.testModulesSelection(testData.get("Module"));
						navigateToURL(Executor.propReader.getProperty("username"),
								Executor.propReader.getProperty("password"), testData.get("CountryCode"),
								testData.get("Language"));

						TestCaseSelectionObj.testCasesSelection(this.driver, this.report, testData, testDataCollector);

						report.endTestCase();
						testRunCounter++;
						testRunStatus = report.test.getRunStatus().toString();

						if ((testRunStatus == "fail" && testRunCounter >= numberOfTestTrials)
								|| (testRunStatus == "pass")) {
							if (testRunStatus == "pass") {
								numberofTestPass++;
							} else if (testRunStatus == "fail") {
								numberofTestFailed++;
							}
							report.Summarytest.appendChild(report.test);
							Executor.SummaryReport.endTest(report.test);
							Executor.SummaryReport.flush();
						}

						driver.quit();
					} catch (Exception e) {
						System.err.println("Exception in test execution - " + e.getLocalizedMessage());
						e.printStackTrace();

					}
				}

			} while (testRunStatus == "fail" && testRunCounter < numberOfTestTrials);
		}

		Executor.SummaryReport.endTest(report.Summarytest);
		Executor.SummaryReport.flush();
		String executionResult = getExecutionPercentage();
		FunctionBank.replaceDatain_html(Executor.dashboardIndexfilepath, "$" + browserName + "_Report",
				executionResult);

	}

	public void navigateToURL(String authenticationID, String authenticationPass, String countryCode, String language) {
		String currENV;
		try {

			if (System.getenv("BUILD_TIMESTAMP") != null) {
				String envName = System.getenv("TARGET_ENV");
				currENV = Executor.propReader.getProperty(envName);
			} else {
				currENV = Executor.URL;
			}

			String URL = "https://" + authenticationID + ":" + authenticationPass + "@" + currENV
					+ countryCode.toLowerCase() + "/" + language.toLowerCase() + "/";

			if (browserName.contains("Safari1")) {
				String ipAddress = Executor.IPs[Integer.parseInt(Thread.currentThread().getName()) - 1];
				String currentIP = ipAddress.split(":")[0];
				URL = "http://" + currentIP + ":8080/" + countryCode.toLowerCase() + "/" + language.toLowerCase() + "/";

				String script = "window.location = \'" + URL + "\'";
				((JavascriptExecutor) driver).executeScript(script);

			} else {

				try {
					driver.navigate().to(URL);
					report.logStepToReport(LogStatus.INFO, "Enter", URL, "");
				} catch (Exception e) {
					driver.navigate().refresh();
				}

			}

		} catch (Exception e) {
			System.out.println("EXCEPTION IN NAVIGATION TO URL - " + e.getMessage());
		}
	}

	public void navigateToHome(String country, String language) {
		try {
			String URL = "https://" + Executor.URL + "/" + country + "/" + language + "/";
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("EXCEPTION IN NAVIGATION TO URL - " + e.getMessage());
		}
	}

	public String getExecutionPercentage() throws IOException {
		String executionResult;
		totalTestCases = numberofTestPass + numberofTestFailed;
		DecimalFormat f = new DecimalFormat("##.00");
		double percentage = (double) Math.round(numberofTestPass * 100) / totalTestCases;
		executionPercentage = f.format(percentage);

		executionResult = "\nTest Run : " + totalTestCases + " || " + "Test Pass : " + numberofTestPass + " || "
				+ "Test Fail : " + numberofTestFailed + "\n" + "Pass Percentage : " + executionPercentage + "%";
		System.out.println("*******************************************************");
		System.out.println(executionResult);
		FunctionBank.WriteStringtoTextFile(System.getProperty("user.dir") + File.separator + "ExecutionResult"
				+ File.separator + "executionResults.txt", executionResult);
		System.out.println("*******************************************************");

		executionResult = "\nTest Run : " + totalTestCases + " || " + "Test Pass : " + numberofTestPass + " || "
				+ "Test Fail : " + numberofTestFailed + "\n" + " || Pass Percentage : " + executionPercentage + "%";

		return executionResult;

	}

}
