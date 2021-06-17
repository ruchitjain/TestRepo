package helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import controllers.Executor;

public class FunctionBank {

	public static String generatebrowserTimeStampEmailId(String browserName) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date currDate = new Date();
		String systemdatetime = dateFormat.format(currDate).replaceAll(":", "").replaceAll("/", "").replaceAll(" ", "");
		String email = browserName + systemdatetime + "@yopmail.com";
		return email;
	}

	public static String generateTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date currDate = new Date();
		String systemdatetime = dateFormat.format(currDate).replaceAll(":", "").replaceAll("/", "").replaceAll(" ", "");

		return systemdatetime;
	}

	public String[] getAllFileName(String filePath) {
		try {
			File folder = new File(filePath);
			File[] listOfFiles = folder.listFiles();
			String[] allFiles = new String[listOfFiles.length];
			int count = 0;
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					allFiles[count++] = listOfFiles[i].getName();
					// System.out.println("File " + listOfFiles[i].getName());
				} else if (listOfFiles[i].isDirectory()) {
					// System.out.println("Directory " + listOfFiles[i].getName());
				}
			}
			return allFiles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String[] getTestDataFileNames() {

		String[] testDataFiles = new XMLReader("config.xml").readTagValues("TESTDATAJSON");
		if (testDataFiles[0].contains("*")) {
			testDataFiles = getAllFileName(Executor.PROJECT_PATH + "/TestData/TestCases");
		}
		return testDataFiles;

	}

	public static String concatfilepath(String string1, String string2, String string3) {
		return string1 + File.separator + string2 + File.separator + string3;

	}

	public static Map<String, String> concat_AccountCreation_Address_Functionality_PaymentTestData_GeneralInfo(
			Map<String, String> testData, List<Map<String, String>> accountCreationData,
			List<Map<String, String>> shippingAddressData, List<Map<String, String>> billingAddressData,
			List<Map<String, String>> functionalityFlag, List<Map<String, String>> paymentsMethod,
			List<Map<String, String>> paypalPaymnetdata, List<Map<String, String>> product_sku,
			List<Map<String, String>> generalInfo) {

		for (Map<String, String> account : accountCreationData) {
			if (account.get("CountryCode").equals(testData.get("CountryCode"))) {
				testData.putAll(account);

				break;
			}
		}

		for (Map<String, String> shippingAddress : shippingAddressData) {
			if (shippingAddress.get("CountryCode").equals(testData.get("CountryCode"))) {
				testData.putAll(shippingAddress);

				break;
			}
		}

		for (Map<String, String> billingAddress : billingAddressData) {
			if (billingAddress.get("CountryCode").equals(testData.get("CountryCode"))) {
				testData.putAll(billingAddress);

				break;
			}
		}

		for (Map<String, String> functionality : functionalityFlag) {
			if (functionality.get("CountryCode").equals(testData.get("CountryCode"))) {
				testData.putAll(functionality);

				break;
			}
		}

		for (Map<String, String> payment : paymentsMethod) {
			if (payment.get("Payment_MethodType").equals(testData.get("Payment_MethodType"))) {
				testData.putAll(payment);

				break;
			}
		}

		for (Map<String, String> paypalPayment : paypalPaymnetdata) {
			if (paypalPayment.get("CountryCode").equals(testData.get("CountryCode"))) {
				testData.putAll(paypalPayment);

				break;
			}
		}

		for (Map<String, String> product : product_sku) {
			if (product.get("CountryCode").equals(testData.get("CountryCode"))) {
				testData.putAll(product);

				break;
			}
		}

		for (Map<String, String> genInfo : generalInfo) {
			if (genInfo.get("CountryCode").equals(testData.get("CountryCode"))) {

				testData.putAll(genInfo);

				break;
			}
		}

		return testData;
	}

	public static String getValueofKeyfromListofMapObj(List<Map<String, String>> listofMap, String mapidentifier1,
			String identifierValue1, String mapidentifier2, String identifierValue2, String key) {
		String value = null;
		for (Map<String, String> map : listofMap) {
			if (map.get(mapidentifier1).contains(identifierValue1)
					&& map.get(mapidentifier2).equalsIgnoreCase(identifierValue2)) {
				value = map.get(key);
				break;
			}
		}
		return value;
	}

	public static Map<String, String> getValueofMapfromListofMapObj(List<Map<String, String>> listofMap,
			String mapidentifier1, String identifierValue1) {

		Map<String, String> value = null;
		for (Map<String, String> map : listofMap) {
			if (map.get(mapidentifier1).contains(identifierValue1)) {
				value = map;
				break;
			}
		}
		return value;
	}

	public static Map<String, String> returnMapObject(Map<String, String> map) {
		Map<String, String> mapObj = new HashMap<String, String>(map);
		return mapObj;
	}

	public static void WriteStringtoTextFile(String fileName, String Content) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write("");
		writer.write(Content);
		writer.close();
	}

	public static void createHTMLFile(String dashboardIndexfilepath, Map<String, String> reportsname)
			throws IOException {
		File f = new File(dashboardIndexfilepath);
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		String addCss = readDataFromFile(Executor.PROJECT_PATH + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "dashboardcss.txt");
		String addjavaScript = readDataFromFile(Executor.PROJECT_PATH + File.separator + "src" + File.separator + "main"
				+ File.separator + "resources" + File.separator + "dashboardjs.txt");
		bw.write("<html>" + addCss);
		bw.write("<html><body style=\"background-color:#FFF8DC;\">\r\n" + "\r\n" + "<div id=\"btnContainer\">\r\n"
				+ "  <button class=\"btn\" onclick=\"listView()\"><i class=\"fa fa-bars\"></i> List</button> \r\n"
				+ "  <button class=\"btn active\" onclick=\"gridView()\"><i class=\"fa fa-th-large\"></i> Grid</button>\r\n"
				+ "</div>\r\n" + "<br>");
		for (Map.Entry<String, String> entry : reportsname.entrySet()) {

			if (entry.getKey().contains("Test_Execution_Summary")) {
				bw.write("<html><body><div class=\"row\">\r\n"
						+ "  <div class=\"row groove\" style=\"background-color:#FFF8DC;\">\r\n"
						+ "<h2><center><a href=" + entry.getValue()
						+ ">GUCCI TEST AUTOMATION SUMMARY REPORT</center></h2>\r\n"
						+ "<h2><center><em>Number of Test to Run : " + Executor.totalTestCases
						+ "</em></center></h2>\r\n" + "</div>\r\n" + "</div>");
			} else {
				bw.write("<html><body><div class=\"row\">\r\n"
						+ "<div class=\"column groove\" style=\"background-color:#90EE90;\">\r\n" + "<h3><a href="
						+ entry.getValue() + "><center><em>" + entry.getKey().replace("_Report", " Report")
						+ "</em></center></h3>\r\n" + "<p>" + "." + "</p>\r\n" + "</div>\r\n"
						+ "<div class=\"column groove\" style=\"background-color:#98FB98;\">\r\n"
						+ "<h3><em>Test Execution Percentage</em></h3>\r\n" + "<p>$" + entry.getKey() + "</p>\r\n"
						+ "</div>\r\n" + "</div>");
			}
		}

		bw.write("<html><body>" + addjavaScript + "</body></html>");
		bw.close();
	}

	public static String readDataFromFile(String filepath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();

		String content = stringBuilder.toString();
		return content;
	}

	public static void replaceDatain_html(String filepath, String matchword, String replacewith) throws IOException {

		try {
			String readhtmlfile = readDataFromFile(filepath);
			Document doc = Jsoup.parse(readhtmlfile);
			Elements matchingElements = doc.getElementsContainingOwnText(matchword);
			for (Element e : matchingElements) {
				e.html(e.html().replace(matchword, "<span class=\"groove\" style=\"background-color: #FFFF00\"><b>"
						+ replacewith + "</b></span>"));
			}
			// System.out.println(doc.toString());

			FileWriter fw = new FileWriter(filepath);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(doc.toString());
			bw.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	/** Copy File */

	public static void copyFile(String fromLocation, String toLocation) throws Exception {

		FileInputStream instream = null;
		FileOutputStream outstream = null;

		try {

			File infile = new File(fromLocation);
			File outfile = new File(toLocation);
			instream = new FileInputStream(infile);
			outstream = new FileOutputStream(outfile);
			byte[] buffer = new byte[1024];

			int length;

			// Copy contents from input stream to output stream using read and write methods

			while ((length = instream.read(buffer)) > 0) {
				outstream.write(buffer, 0, length);
			}

			// Close input / output file streams

			instream.close();
			outstream.close();

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

}
