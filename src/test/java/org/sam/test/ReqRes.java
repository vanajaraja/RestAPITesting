package org.sam.test;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqRes extends BaseClass {
    public static void main(String[] args) throws ParseException {

        RestAssured.baseURI = "https://reqres.in";

        Response response = RestAssured.given().queryParam("page", "2")
                .header("Content-Type", "application/json").when().get("/api/users");

        statusCode(response);
        System.out.println(getResp(response));
        String resp = getResp(response);
        getvalue(resp, "page");

        Response createRes = RestAssured.given().header("Content-Type", "application/json")
                .body(PayLoad.createUser()).when()
                .post("/api/users");

        statusCode(createRes);
        System.out.println(getResp(createRes));
        getStringvalue(getResp(createRes), "name");


        Response updateRes = RestAssured.given().header("Content-Type", "application/json")
                .body(PayLoad.updateUser()).when().put("/api/users/2");

        statusCode(updateRes);
        System.out.println(getResp(updateRes));
        getStringvalue(getResp(updateRes), "job");
    }
}
