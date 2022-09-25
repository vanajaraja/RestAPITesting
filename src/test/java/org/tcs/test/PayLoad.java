package org.tcs.test;

public class PayLoad {
	
	public static String createUser() {
		return ("{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}");
		
		
	}
	
	public static String updateUser() {
		return ("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}");

	}
	
	public static String createIssue() {
		return ("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"TW\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}");
		

	}
	
	public static String updateIssue() {
		return ("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"        \"summary\": \"Summary\",\r\n" + 
				"        \"description\": \"Description\"\r\n" + 
				"    }\r\n" + 
				"}");
		
	}

}
