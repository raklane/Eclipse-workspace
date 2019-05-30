package utilities;

import java.io.File;
import java.io.IOException;

import com.jayway.jsonpath.JsonPath;


public class JsonReader {
	
	private File jsonFile;
	
	public JsonReader(String fileName) {
		jsonFile = new File(fileName);
	}
	
	public String getLocator(String locator) throws IOException {
		
		return JsonPath.read(jsonFile, "$." + locator);
		
	}

}
