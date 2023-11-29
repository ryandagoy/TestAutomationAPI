package com.qa.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Test;

public class TC_Reqres_PATCH_004 {

    String baseURI = RestAssured.baseURI = "https://reqres.in/";

    @Test
    public void PATCH_updateEmployee() {

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject payload = new JSONObject();

        payload.put("job", "Post man");

        httpRequest.baseUri(baseURI);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(payload.toString());

        System.out.println("Request:");
        System.out.println("========");
        //print API request log
        httpRequest.log().all();

        Response response = httpRequest.when().patch("api/users/2");

        System.out.println("\n" + "Response:");
        System.out.println("========");
        //print API response
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("\n" + "updateEmployee is passed");

    }

}
