package helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import controllers.Executor;

public class JsonReader {

	public String filepath = Executor.PROJECT_PATH + "/TestData" + "/TestData.json";
	public static String Addressfilepath = Executor.PROJECT_PATH + "/TestData/AddressData" + "/AddressData.json";

	public static List<Map<String, String>> getlistofTestdataMap(String filepath, String parentElement) {
		List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();

		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filepath));

			JSONObject jsonObject = (JSONObject) obj;
			JSONArray solutions = (JSONArray) jsonObject.get(parentElement);

			@SuppressWarnings("rawtypes")
			Iterator iterator = solutions.iterator();

			while (iterator.hasNext()) {

				String json = iterator.next().toString();

				Map<String, String> map = new HashMap<String, String>();
				ObjectMapper mapper = new ObjectMapper();
				try {
					map = mapper.readValue(json, new TypeReference<Map<String, String>>() {
					});
				} catch (JsonGenerationException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				listOfMaps.add(map);
			}
		} catch (Exception e) {
			System.err.println(
					"Unable to get data from file - " + filepath + " due to exception - " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		return listOfMaps;
	}

	@SuppressWarnings("null")
	public static List<Map<String, String>> getallTestdataMap(String folderpath, String pareenttag) {
		List<Map<String, String>> allTest = new ArrayList<Map<String, String>>();
		String[] allFilePath = null;
		try {
			if (Executor.testDataFiles != null) {
				if (Executor.testDataFiles.equalsIgnoreCase("ALL")) {
					allFilePath = new FunctionBank().getTestDataFileNames();
				} else if (Executor.testDataFiles.contains("#") && Executor.testDataFiles != "ALL") {

					allFilePath = Executor.testDataFiles.split("#");
				} else {
					allFilePath = new String[1];
					allFilePath[0] = Executor.testDataFiles;
				}
			} else {
				allFilePath = new FunctionBank().getTestDataFileNames();
			}

			for (int i = 0; i < allFilePath.length; i++) {
				if (allFilePath[i] != null) {

					if (allFilePath[i].toLowerCase().contains("json")) {
						List<Map<String, String>> currAllTest = getlistofTestdataMap(
								folderpath + File.separator + allFilePath[i], pareenttag);
						for (Map<String, String> testCase : currAllTest) {
							allTest.add(testCase);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allTest;
	}

	public static String getAddressData(Map<String, String> testCaseData, String key) {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(Addressfilepath));
			JSONObject jsonObject = (JSONObject) obj;

			JSONArray addresses = (JSONArray) jsonObject.get("address");

			for (int i = 0; i < addresses.size(); i++) {
				JSONObject item = (JSONObject) addresses.get(i);
				if (item.get("CountryCode").equals(testCaseData.get("CountryCode"))) {
					return (String) item.get(key);
				}
			}

		} catch (Exception e) {
			System.err.println("Unable to parse address json - " + e.getLocalizedMessage());
		}

		return null;
	}
}
