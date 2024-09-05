package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String, String>> getJasonDataToMap() throws IOException {
		//read Json to Sting
		String jasonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\PurchaseOrder.json"), StandardCharsets.UTF_8);
		//String to Hashmap -> jackson Databind
		ObjectMapper objectMapper = new ObjectMapper();
		List<HashMap<String, String>> data = objectMapper.readValue(jasonContent, new TypeReference<List<HashMap<String, String>>>(){	
		});
		return data;
	}
}
/*
{
	"email" : "srikanthv1709@gmail.com",
	"password" : "Selenium@123",
	"productName: = "ZARA COAT 3"
},
*/