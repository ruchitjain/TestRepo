package controllers;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import helpers.Reporting;

public interface ModuleInterface {

	public void testCasesSelection(WebDriver driverObj, Reporting reportObj, Map<String, String> testCaseData,
			TestDataCollector testDatacollector);

}
