package com.qa.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TC_Reqres_GET_002 {

    String baseURI = RestAssured.baseURI = "https://reqres.in/";

    @Test
    public void GET_getSingleEmployee() {

        RequestSpecification
                request = given().header("Content-Type", "application/json");

        Response response = request.when().get("/api/users/2");
        response.prettyPrint();
        //verify response code
        response.then().assertThat().statusCode(200);
        System.out.println("\n" + "getSingleEmployee is passed");

    }

    @Test
    public void GET_getListOfEmployees() {

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.baseUri(baseURI);
        httpRequest.header("Content-Type", "application/json");

        System.out.println("Request:");
        System.out.println("========");
        //print API request log
        httpRequest.log().all();

        Response response = httpRequest.when().get("/api/users?page=1");

        System.out.println("\n" + "Response:");
        System.out.println("========");
        //print API response
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("\n" + "getListOfEmployees is passed");

    }

}
