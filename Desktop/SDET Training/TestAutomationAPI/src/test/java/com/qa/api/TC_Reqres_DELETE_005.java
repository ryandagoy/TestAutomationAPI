package com.qa.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TC_Reqres_DELETE_005 {

    String baseURI = RestAssured.baseURI = "https://reqres.in/";

    @Test
    public void DELETE_deleteEmployee() {

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.baseUri(baseURI);
        httpRequest.header("Content-Type", "application/json");

        System.out.println("Request:");
        System.out.println("========");
        //print API request log
        httpRequest.log().all();

        Response response = httpRequest.when().delete("/api/users/2");

        System.out.println("\n" + "Response:");
        System.out.println("========");
        //print API response
        response.prettyPrint();
        response.then().assertThat().statusCode(204);
        System.out.println("\n" + "deleteEmployee is passed");

    }

}
