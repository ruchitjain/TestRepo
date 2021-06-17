package helpers;

import java.util.HashMap;
import java.util.Map;
import controllers.TestDataCollector;

public class PageObjectUtils {

	public Map<String, String> testCaseData;

	public PageObjectUtils(Map<String, String> testCaseData) {
		this.testCaseData = testCaseData;
	}

	public Map<String, String> setAddressDataMap(String addressCountryType) {

		Map<String, String> addressDataMap = new HashMap<String, String>();
		if (addressCountryType.equalsIgnoreCase("Billing-Self")) {

			addressDataMap.put("title", testCaseData.get("Billing_SC_Address_Title"));
			addressDataMap.put("firstName", testCaseData.get("Billing_SC_Address_FirstName"));
			addressDataMap.put("lastName", testCaseData.get("Billing_SC_Address_LastName"));
			addressDataMap.put("addressLine1", testCaseData.get("Billing_SC_Address_AddressLine1"));
			addressDataMap.put("addressLine2", testCaseData.get("Billing_SC_Address_AddressLine2"));
			addressDataMap.put("city", testCaseData.get("Billing_SC_Address_City"));
			addressDataMap.put("state", testCaseData.get("Billing_SC_Address_State"));
			addressDataMap.put("zipcode", testCaseData.get("Billing_SC_Address_ZipCode"));
			addressDataMap.put("company", testCaseData.get("Billing_SC_Address_Company"));
			addressDataMap.put("phoneNumber", testCaseData.get("Billing_SC_Address_PhoneNumber"));
			addressDataMap.put("alternatePhoneNumber", testCaseData.get("Billing_SC_Address_AlternativePhone"));
			addressDataMap.put("country", testCaseData.get("Billing_SC_Address_country"));
			addressDataMap.put("phoneExtension", testCaseData.get("phone_extension"));
			addressDataMap.put("countryCode", testCaseData.get("CountryCode"));
			addressDataMap.put("stateFlag", testCaseData.get("StateDD_Flag"));
			addressDataMap.put("zipcodeFlag", testCaseData.get("Zipcode_Flag"));
			addressDataMap.put("cityFlag", testCaseData.get("city_flag"));
			addressDataMap.put("genderFlag", testCaseData.get("gender_flag"));

			if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")) {
				addressDataMap.put("firstNameKatakana", testCaseData.get("Billing_SC_Address_FirstName_Katakana"));
				addressDataMap.put("lastNameKatakana", testCaseData.get("Billing_SC_Address_LastName_Katakana"));
				addressDataMap.put("gender", testCaseData.get("Billing_SC_Address_Gender"));
			}

			for (Map<String, String> flagElement : TestDataCollector.functionalityFlag) {
				if (flagElement.get("CountryCode").equalsIgnoreCase(testCaseData.get("CountryCode"))) {
					addressDataMap.put("stateFlag", flagElement.get("StateDD_Flag"));
					addressDataMap.put("zipcodeFlag", flagElement.get("Zipcode_Flag"));
					addressDataMap.put("cityFlag", flagElement.get("city_flag"));
					addressDataMap.put("genderFlag", flagElement.get("gender_flag"));
					addressDataMap.put("geographicalGroup", flagElement.get("Geographical_Group"));
					break;
				}
			}

			return addressDataMap;

		} else if (addressCountryType.equalsIgnoreCase("Shipping-Self")) {
			addressDataMap.put("title", testCaseData.get("ShippingAddress_Title"));
			addressDataMap.put("firstName", testCaseData.get("ShippingAddress_FirstName"));
			addressDataMap.put("lastName", testCaseData.get("ShippingAddress_LastName"));
			addressDataMap.put("addressLine1", testCaseData.get("ShippingAddress_AddressLine1"));
			addressDataMap.put("addressLine2", testCaseData.get("ShippingAddress_AddressLine2"));
			addressDataMap.put("city", testCaseData.get("ShippingAddress_City"));
			addressDataMap.put("state", testCaseData.get("ShippingAddress_State"));
			addressDataMap.put("zipcode", testCaseData.get("ShippingAddress_ZipCode"));
			addressDataMap.put("company", testCaseData.get("ShippingAddress_Company"));
			addressDataMap.put("phoneNumber", testCaseData.get("ShippingAddress_PhoneNumber"));
			addressDataMap.put("alternatePhoneNumber", testCaseData.get("ShippingAddress_AlternativePhone"));
			addressDataMap.put("country", testCaseData.get("ShippingAddress_country"));
			addressDataMap.put("phoneExtension", testCaseData.get("phone_extension"));
			addressDataMap.put("countryCode", testCaseData.get("CountryCode"));
			addressDataMap.put("stateFlag", testCaseData.get("StateDD_Flag"));
			addressDataMap.put("zipcodeFlag", testCaseData.get("Zipcode_Flag"));
			addressDataMap.put("cityFlag", testCaseData.get("city_flag"));
			addressDataMap.put("genderFlag", testCaseData.get("gender_flag"));
			addressDataMap.put("geographicalGroup", testCaseData.get("Geographical_Group"));
			if (testCaseData.get("CountryCode").equalsIgnoreCase("JP")) {
				addressDataMap.put("firstNameKatakana", testCaseData.get("ShippingAddress_FirstName_Katakana"));
				addressDataMap.put("lastNameKatakana", testCaseData.get("ShippingAddress_LastName_Katakana"));
				addressDataMap.put("gender", testCaseData.get("ShippingAddress_Gender"));
			}

			return addressDataMap;
		} else if (addressCountryType.equalsIgnoreCase("Billing-Other")) {

			addressDataMap.put("title", testCaseData.get("Billing_DC_Address_Title"));
			addressDataMap.put("firstName", testCaseData.get("Billing_DC_Address_FirstName"));
			addressDataMap.put("lastName", testCaseData.get("Billing_DC_Address_LastName"));
			addressDataMap.put("addressLine1", testCaseData.get("Billing_DC_Address_AddressLine1"));
			addressDataMap.put("addressLine2", testCaseData.get("Billing_DC_Address_AddressLine2"));
			addressDataMap.put("city", testCaseData.get("Billing_DC_Address_City"));
			addressDataMap.put("state", testCaseData.get("Billing_DC_Address_State"));
			addressDataMap.put("zipcode", testCaseData.get("Billing_DC_Address_ZipCode"));
			addressDataMap.put("company", testCaseData.get("Billing_DC_Address_Company"));
			addressDataMap.put("phoneNumber", testCaseData.get("Billing_DC_Address_PhoneNumber"));
			addressDataMap.put("alternatePhoneNumber", testCaseData.get("Billing_DC_Address_AlternativePhone"));
			addressDataMap.put("country", testCaseData.get("Billing_DC_Address_country"));
			addressDataMap.put("phoneExtension", testCaseData.get("phone_extension"));
			addressDataMap.put("countryCode", testCaseData.get("Billing_DC_CountryCode"));
			addressDataMap.put("title", testCaseData.get("Billing_DC_Address_Title"));

			for (Map<String, String> flagElement : TestDataCollector.general_info) {
				if (flagElement.get("CountryCode").equalsIgnoreCase(testCaseData.get("Billing_DC_CountryCode"))) {
					addressDataMap.put("phoneExtension", flagElement.get("phone_extension"));
					break;
				}
			}

			for (Map<String, String> flagElement : TestDataCollector.functionalityFlag) {
				if (flagElement.get("CountryCode").equalsIgnoreCase(testCaseData.get("Billing_DC_CountryCode"))) {
					addressDataMap.put("stateFlag", flagElement.get("StateDD_Flag"));
					addressDataMap.put("zipcodeFlag", flagElement.get("Zipcode_Flag"));
					addressDataMap.put("cityFlag", flagElement.get("city_flag"));
					addressDataMap.put("genderFlag", flagElement.get("gender_flag"));
					addressDataMap.put("geographicalGroup", flagElement.get("Geographical_Group"));
					break;
				}
			}

			if (testCaseData.get("Billing_DC_CountryCode").equalsIgnoreCase("JP")) {
				addressDataMap.put("firstNameKatakana", testCaseData.get("Billing_DC_Address_FirstName_Katakana"));
				addressDataMap.put("lastNameKatakana", testCaseData.get("Billing_DC_Address_LastName_Katakana"));
				addressDataMap.put("gender", testCaseData.get("Billing_DC_Address_Gender"));
			}

			return addressDataMap;
		} else {
			return null;
		}

	}

}
