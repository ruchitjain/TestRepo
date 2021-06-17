package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class PropertiesReader {
	private static final Logger log = Logger.getLogger(PropertiesReader.class);

	private static PropertiesReader envProperties;

	private Properties properties;

	public PropertiesReader() {
		properties = loadProperties();
	}

	public PropertiesReader(String propertyFile) {
		properties = loadProperties(propertyFile);
	}

	// To load Properties file

	public Properties loadProperties() {
		File file = new File("./src/main/resources/configuration.properties");
		FileInputStream fileInput = null;
		Properties props = new Properties();

		try {

			fileInput = new FileInputStream(file);
			props.load(fileInput);
			fileInput.close();
			file = null;

		} catch (FileNotFoundException e) {
			log.error("config.properties is missing or corrupt : " + e.getMessage());
		} catch (IOException e) {
			log.error("read failed due to: " + e.getMessage());
		}

		return props;
	}

	// Overloaded function to load Properties file

	public Properties loadProperties(String propertyFile) {
		File file = new File("./src/main/resources/" + propertyFile + ".properties");
		FileInputStream fileInput = null;
		Properties props = new Properties();

		try {

			fileInput = new FileInputStream(file);

			props.load(fileInput);
			fileInput.close();
		} catch (FileNotFoundException e) {
			log.error("" + propertyFile + ".properties is missing or corrupt : " + e.getMessage());
		} catch (IOException e) {
			log.error("read failed due to: " + e.getMessage());
		}

		return props;
	}

	// To get Instance of Properties Reader

	public static PropertiesReader getInstance() {
		if (envProperties == null) {
			envProperties = new PropertiesReader();
		}

		return envProperties;
	}

	// To get Property on the basis of key

	public String getProperty(String key) {
		System.out.println(properties.toString());
		return properties.getProperty(key);
	}

}
