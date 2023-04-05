package Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.XML;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Utils.BasePage;
import Utils.Common;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.sf.json.JSONObject;

public class TestAPI {

	static Properties configProperties = null;
	File x = new File(System.getProperty("user.dir"), "/src/test/java/Config/payload.xml");

	private Properties loadProperties(String filePath) {
		File file = new File(filePath);
		FileInputStream fileInput = null;

		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties properties = new Properties();

		try {
			properties.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return properties;
	}

	protected Properties getConfigProperties() {
		if (configProperties == null) {
			configProperties = this.loadProperties(
					Paths.get("src/test/java/Config").toAbsolutePath().normalize().toString() + "//config.properties");

		}
		return configProperties;
	}

	protected String getPropertyValue(String value) {
		Properties properties = getConfigProperties();
		return properties.getProperty(value);
	}

	@Test(invocationCount = 10, threadPoolSize = 5)
	public void apiPost() {

		for (int i = 0; i < 1000; i++) {

			RequestSpecification reqSpec = RestAssured.given().auth()
					.basic(getPropertyValue("BasicAuthUserName"), getPropertyValue("BasicAuthPassword"))
					.contentType(ContentType.XML).body(x);

			Response resp = reqSpec.post(getPropertyValue("apicall"));
			String tl = getPropertyValue("apicall");
			System.out.println("API call :: " + tl);
			Reporter.log("API call ::" + getPropertyValue("apicall"));
			System.out.println("Authentication UserName ::" + getPropertyValue("BasicAuthUserName"));
			Reporter.log("Authentication UserName ::" + getPropertyValue("BasicAuthUserName"));
			Reporter.log("Authentication Password ::" + getPropertyValue("BasicAuthPassword"));
			System.out.println("Authentication Password ::" + getPropertyValue("BasicAuthPassword"));

			System.out.println("Response code => " + resp.statusCode());
			Reporter.log("Response code =>::" + resp.statusCode());
			System.out.println("Response body =>" + resp.body().prettyPrint());
			assertEquals(resp.statusCode(), 200);

		}

	}

	@Test
	public void RecevigEndpoint() {

		RequestSpecification reqSpec = RestAssured.given().header("key", getPropertyValue("KeyValue"))
				.contentType(ContentType.XML).body(x);
		Response resp = reqSpec.post(getPropertyValue("ReceveAPIcall"));
		Reporter.log("API call ::" + getPropertyValue("ReceveAPIcall"));
		System.out.println("API call ::" + getPropertyValue("ReceveAPIcall"));
		Reporter.log("Authorization key::" + getPropertyValue("KeyValue"));
		System.out.println("Response code => " + resp.statusCode());
		Reporter.log("Response code =>::" + resp.statusCode());
		assertEquals(resp.statusCode(), 200);

	}

}
