package Test;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.XML;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.iterable.S3Objects;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.exceptions.CsvValidationException;

import Utils.BasePage;
import Utils.Common;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.sf.json.JSONObject;

public class GETAPI {

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

	@Test
	public void RecevigFroms3Bucket() throws IOException, CsvValidationException {

		
		System.out.format("Objects in S3 bucket %s:\n", "prospecta-sap-btp");

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAUHJXNRPSOH2UCDYH",
				"n6IwuuRytfRPOQThBxseRrakbBpxPwoArejQ22bV");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion(Regions.AP_SOUTHEAST_2).build();

		ListObjectsV2Result result1 = s3Client.listObjectsV2("prospecta-sap-btp");
		List<S3ObjectSummary> objects = result1.getObjectSummaries();

		ArrayList<String> sampleList = new ArrayList<String>();

		for (S3ObjectSummary os : objects) {
			
			
				
			System.out.println("* " + os.getKey());
			sampleList.add(os.getKey());
			String key = os.getKey();
			
			
			
		}
		String[]arr = new String [sampleList.size()];

        //Converting List to Array
        sampleList.toArray(arr);
        File csv = new File(System.getProperty("user.dir"), "/API.csv");
        FileWriter writer = new FileWriter(csv);
        
        for (int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + "  ");
        
		

		List<Map<String, String>> records = getS3Records("prospecta-sap-btp",
				arr[i]);

//		writer.append(String.valueOf(arr[i]) + ",");
		// key >> 
		System.out.println(records);

		String record = String.valueOf(records);

		String result = record.substring(record.indexOf("SAP_DOC_NUM") + 15, record.lastIndexOf("</SAP_DOC_NUMBER"));

		System.out.println("\nExtracted value ::" + result);

		String finalString = result.substring(0, 6);
		System.out.println("\nSAP DOC Number ::" + finalString);
		writer.append(String.valueOf(arr[i]) + "," + finalString + "\n");
		
        }
        writer.close();
	}

	public List<Map<String, String>> getS3Records(String bucket, String key)
			throws IOException, CsvValidationException {
		List<Map<String, String>> records = new ArrayList<>();
		try (CSVReaderHeaderAware reader = getReader(bucket, key)) {
			Map<String, String> values;

			while ((values = reader.readMap()) != null) {
				records.add(values);
			}
			return records;
		}
	}

	

	private CSVReaderHeaderAware getReader(String bucket, String key) {
		CSVParser parser = new CSVParserBuilder().build();
		S3Object object = getS3().getObject(bucket, key);
		InputStreamReader br = new InputStreamReader(object.getObjectContent());
		return (CSVReaderHeaderAware) new CSVReaderHeaderAwareBuilder(br).withCSVParser(parser).build();
	}

	private AmazonS3 getS3() {

		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAUHJXNRPSOH2UCDYH",
				"n6IwuuRytfRPOQThBxseRrakbBpxPwoArejQ22bV");
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion(Regions.AP_SOUTHEAST_2).build();
		return s3Client;

	}

}
