package controllers;

import java.io.File;
import java.util.List;
import java.util.Map;

import helpers.FunctionBank;
import helpers.JsonReader;

public class TestDataCollector {

	public static String defaultpath, createUserDataPath, shippingAddressDataPath, billingAddressDataPath,
			functionalityAvalabilityDataPath, paymentTypeDataPath, paypalPaymentDataPath, productSkuDataPath,
			monogramProductSkuDataPath, consignmentSkuDataPath, codThresholdProductSkuDataPath, generalInfoSkuDataPath,
			testCasesDataPath;

	public static List<Map<String, String>> accountCreationData, shippingAddressData, billingAddressData,
			functionalityFlag, paymentsMethod, paypalPaymnetdata, product_sku, monogram_product_sku, consignment_sku,
			codThreshold_product_sku, general_info;

	public List<Map<String, String>> testcasesList;

	TestDataCollector() {
		generateTestDatafilepaths();
		collectTestData();
		testcasesList = JsonReader.getallTestdataMap(testCasesDataPath, "TestCase");
	}

	public static void generateTestDatafilepaths() {
		defaultpath = System.getProperty("user.dir") + File.separator + "TestData";

		createUserDataPath = FunctionBank.concatfilepath(defaultpath, "AccountCreation", "AccountCreation.json");
		shippingAddressDataPath = FunctionBank.concatfilepath(defaultpath, "AddressData", "ShippingAddress.json");
		billingAddressDataPath = FunctionBank.concatfilepath(defaultpath, "AddressData", "BillingAddress.json");
		functionalityAvalabilityDataPath = FunctionBank.concatfilepath(defaultpath, "FunctionalityFlag",
				"FunctionalityFlag.json");
		paymentTypeDataPath = FunctionBank.concatfilepath(defaultpath, "PaymentMethods", "PaymentMethods.json");
		paypalPaymentDataPath = FunctionBank.concatfilepath(defaultpath, "PaymentMethods",
				"PaymentMethods_Paypal.json");
		productSkuDataPath = FunctionBank.concatfilepath(defaultpath, "Product_SKU", "Product_SKU.json");
		generalInfoSkuDataPath = FunctionBank.concatfilepath(defaultpath, "General_Info", "GeneralInfo.json");
		testCasesDataPath = FunctionBank.concatfilepath(defaultpath, "TestCases", "");
	}

	public static void collectTestData() {
		accountCreationData = JsonReader.getlistofTestdataMap(createUserDataPath, "createAccount");
		shippingAddressData = JsonReader.getlistofTestdataMap(shippingAddressDataPath, "shippingAddress");
		billingAddressData = JsonReader.getlistofTestdataMap(billingAddressDataPath, "billingAddress");
		functionalityFlag = JsonReader.getlistofTestdataMap(functionalityAvalabilityDataPath, "functionality");
		paymentsMethod = JsonReader.getlistofTestdataMap(paymentTypeDataPath, "paymentMethods");
		paypalPaymnetdata = JsonReader.getlistofTestdataMap(paypalPaymentDataPath, "paypalpayment");
		product_sku = JsonReader.getlistofTestdataMap(productSkuDataPath, "product_sku");
		general_info = JsonReader.getlistofTestdataMap(generalInfoSkuDataPath, "generalInfo");
	}

	// TestCases - DataCollection
	public List<Map<String, String>> getTestDataList() {
		for (Map<String, String> testData : testcasesList) {
			FunctionBank.concat_AccountCreation_Address_Functionality_PaymentTestData_GeneralInfo(testData,
					TestDataCollector.accountCreationData, TestDataCollector.shippingAddressData,
					TestDataCollector.billingAddressData, TestDataCollector.functionalityFlag,
					TestDataCollector.paymentsMethod, TestDataCollector.paypalPaymnetdata,
					TestDataCollector.product_sku, TestDataCollector.general_info);
		}
		return testcasesList;
	}

}
