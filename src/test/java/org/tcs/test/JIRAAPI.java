package org.tcs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JIRAAPI extends BaseClass {

	public static void main(String[] args) throws ParseException {

		RestAssured.baseURI = "https://titan-watches-new.atlassian.net";

		Response post = RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic("vanajasadasivam@gmail.com", "zTNsQ0Gufw44hgNmHhbe43ED").body(PayLoad.createIssue()).when()
				.post("/rest/api/2/issue");
		
	//	post.get

		statusCode(post);
		String resp = getResp(post);
		System.out.println(resp);
		String issueId = getStringvalue(resp, "key");

		Response get = RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic("vanajasadasivam@gmail.com", "zTNsQ0Gufw44hgNmHhbe43ED").when()
				.get("/rest/api/2/issue/" + issueId);

		statusCode(get);
		String getResp = getResp(get);
		System.out.println(getResp);
		getStringvalue(getResp, "key");
		String description1 = getStringvalue(getResp, "description");
		System.out.println("description " + description1);

		Response update = RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic("vanajasadasivam@gmail.com", "zTNsQ0Gufw44hgNmHhbe43ED").body(PayLoad.updateIssue()).when()
				.put("/rest/api/2/issue/" + issueId);

		statusCode(update);
		
		Response get1 = RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic("vanajasadasivam@gmail.com", "zTNsQ0Gufw44hgNmHhbe43ED").when()
				.get("/rest/api/2/issue/" + issueId);

		statusCode(get1);
		String getResp1 = getResp(get1);
		System.out.println(getResp1);
		getStringvalue(getResp1, "key");
		String description2 = getStringvalue(getResp, "description");
		System.out.println("description " + description2);
		
		assertEquals(description1, description2);
		assertTrue("Passed", description1.equalsIgnoreCase(description2));
		
		
		//RestAssured.given().

	}

}
