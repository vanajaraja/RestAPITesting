package org.sam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAAPI extends BaseClass {

	/*
	 * public static void main(String[] args) throws ParseException {
	 * 
	 * RestAssured.baseURI = "https://titan-watches-new.atlassian.net";
	 * 
	 * Response post = RestAssured.given().header("Content-Type",
	 * "application/json").auth().preemptive() .basic("vanajasadasivam@gmail.com",
	 * "zTNsQ0Gufw44hgNmHhbe43ED").body(PayLoad.createIssue()).when()
	 * .post("/rest/api/2/issue");
	 * 
	 * // post.get
	 * 
	 * statusCode(post); String resp = getResp(post); System.out.println(resp);
	 * String issueId = getStringvalue(resp, "key");
	 * 
	 * Response get = RestAssured.given().header("Content-Type",
	 * "application/json").auth().preemptive() .basic("vanajasadasivam@gmail.com",
	 * "zTNsQ0Gufw44hgNmHhbe43ED").when() .get("/rest/api/2/issue/" + issueId);
	 * 
	 * statusCode(get); String getResp = getResp(get); System.out.println(getResp);
	 * getStringvalue(getResp, "key"); String description1 = getStringvalue(getResp,
	 * "description"); System.out.println("description " + description1);
	 * 
	 * Response update = RestAssured.given().header("Content-Type",
	 * "application/json").auth().preemptive() .basic("vanajasadasivam@gmail.com",
	 * "zTNsQ0Gufw44hgNmHhbe43ED").body(PayLoad.updateIssue()).when()
	 * .put("/rest/api/2/issue/" + issueId);
	 * 
	 * statusCode(update);
	 * 
	 * Response get1 = RestAssured.given().header("Content-Type",
	 * "application/json").auth().preemptive() .basic("vanajasadasivam@gmail.com",
	 * "zTNsQ0Gufw44hgNmHhbe43ED").when() .get("/rest/api/2/issue/" + issueId);
	 * 
	 * statusCode(get1); String getResp1 = getResp(get1);
	 * System.out.println(getResp1); getStringvalue(getResp1, "key"); String
	 * description2 = getStringvalue(getResp, "description");
	 * System.out.println("description " + description2);
	 * 
	 * assertEquals(description1, description2); assertTrue("Passed",
	 * description1.equalsIgnoreCase(description2));
	 * 
	 * 
	 * //RestAssured.given().
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) throws ParseException { // File
	 * jsonFile = new File
	 * ("C:\\Users\\vanaj\\Desktop\\Vanaja\\Testing Tools\\SampleTestFile.json");
	 * String jsonFile ="[\r\n" + "{\r\n" + "\"name\": \"Vanaja\",\r\n" +
	 * "\"Education\":\"BE\",\r\n" + "\"Role\":\"Automation tester\",\r\n" +
	 * "\"Skilset\":[\"Selenium\", \"Rest Assured\",\"SOAP UI\",\"POSTMAN\",\"TestNG\"]\r\n"
	 * + "\r\n" + "},\r\n" + "{\r\n" + "\"name\": \"Rajappa\",\r\n" +
	 * "\"Education\":\"BE\",\r\n" + "\"Role\":\"Solution Architect\",\r\n" +
	 * "\"Skilset\":[\"Power point\", \"Excel\",\"Devops\",\"API\",\"Reports\"]\r\n"
	 * + "\r\n" + "}\r\n" + "]"; JSONParser parser = new JSONParser(); Object object
	 * = parser.parse(jsonFile); JSONArray jsonArray = (JSONArray) object; for (int
	 * i = 0; i < jsonArray.size(); i++) { Object object2 = jsonArray.get(i);
	 * JSONObject jb1 = (JSONObject) object2; JSONArray skillset = (JSONArray)
	 * jb1.get("Skilset");
	 * 
	 * Iterator<String> iterator = skillset.iterator(); while (iterator.hasNext()) {
	 * System.out.println(iterator.next());
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */
	public static void testMultipleHeader() throws ParseException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://api.realworld.io";

		Response post = RestAssured.given().header("Content-Type", "application/json").header("Accept", "*/*")
				.body(PayLoad.signUPUser()).when().post("/api/users");

		statusCode(post);
		String getResp = getResp(post);
		System.out.println(getResp);
		getStringvalue(getResp, "errors");
	}

	public static void main(String[] args) throws ParseException {
		// testMultipleHeader();
		int[] arr = { 1, 2, 3, 1, 1, 1, 3 };
		validateduplciatedigit(arr);
	}

	public static void validateduplciatedigit(int[] array) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (mp.containsKey(array[i])) {
				mp.put(array[i], mp.get(array[i]) + 1);
			} else {
				mp.put(array[i], 1);
			}
		}

		Set<Entry<Integer, Integer>> entrySet = mp.entrySet();

		for (Entry<Integer, Integer> entry : entrySet) {

			System.out.println(entry.getKey() + " Count of didgit" + entry.getValue());

		}
	}
}
