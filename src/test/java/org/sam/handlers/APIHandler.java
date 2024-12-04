package org.sam.handlers;

import io.restassured.response.Response;
import org.sam.models.Users;
import org.sam.restassured.RestAssuredExtension;
import org.sam.test.TestConfig;
import org.sam.utility.Utility;

import java.io.File;
import java.io.FileReader;

public class APIHandler {
    public Response response;
    RestAssuredExtension restExtension = new RestAssuredExtension();
    public Response createUser(String endpoint){
        Users users =Utility.createPayload();
        Response response= RestAssuredExtension.sendRequest(TestConfig.baseUrl+endpoint,"post",users,null);
        return response;
    }
}
