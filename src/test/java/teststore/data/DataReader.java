package teststore.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String, String>> GetJsonDataToHashmap() throws IOException {
		//covert json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\teststore\\data\\LoginInfo.json"));
		//convert string to hashmap -ge dependency Jackson databind
		ObjectMapper mapper =new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		
		
	});
		return data;

}

}
