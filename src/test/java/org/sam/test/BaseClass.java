package org.sam.test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.response.Response;

public class BaseClass {

	public static void statusCode(Response response) {
		System.out.println("Status Code " + response.getStatusCode());

	}

	public static String getResp(Response response) {
		String res = response.getBody().asString();
		return res;

	}

	public static void getvalue(String response, String key) throws ParseException {

		JSONParser j = new JSONParser();
		Object object = j.parse(response);
		JSONObject o = (JSONObject) object;
		Long value = (Long) o.get(key);
		System.out.println(value);

	}

	public static String getStringvalue(String response, String key) throws ParseException {

		JSONParser j = new JSONParser();
		Object object = j.parse(response);
		JSONObject o = (JSONObject) object;
		String value = (String) o.get(key);
		System.out.println(value);
		return value;

	}

}
