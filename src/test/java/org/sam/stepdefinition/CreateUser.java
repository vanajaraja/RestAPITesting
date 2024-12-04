package org.sam.stepdefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.sam.handlers.APIHandler;
import org.sam.test.TestConfig;

public class CreateUser {

    public Response response;
    public APIHandler apiHandler = new APIHandler();

    @When("send valid request using endpoint {string}")
    public void send_valid_request_using_endpoint(String endpoint) {
        response = apiHandler.createUser(endpoint);
    }

    @Then("verify the status code")
    public void verify_the_status_code() {
        System.out.println("Status Code " + response.getStatusCode());
        System.out.println("Response " + response.getBody().asString());
        Assert.assertEquals(201, response.getStatusCode());

    }

    @Then("Verify create user response")
    public void verify_create_user_response() {

        if (response.getStatusCode() == 201) {
            System.out.println("User Created");
        }
    }


}
