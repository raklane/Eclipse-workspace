package rough;

import utilities.XMLReader;

public class TestXML {
	
	public static void main(String args[]) {
		
		XMLReader xml = new XMLReader(System.getProperty("user.dir") + "\\src\\test\\resources\\locators\\OR.xml");
		
		System.out.println(xml.getLocator("username.css"));
		
	}

}
