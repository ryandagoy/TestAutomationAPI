package com.qa.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TC_Reqres_POST_001 {

    String baseURI = RestAssured.baseURI = "https://reqres.in/";

    @Test
    public void POST_createEmployee() {

        RequestSpecification
                request = given().header("Content-Type", "application/json").body("{\n" +
                "   \"name\": \"ryan\",\n" +
                "   \"job\": \"qa\"\n"  +
                "}");

        Response response = request.when().post("api/users");
        response.prettyPrint();
        //verify response code
        response.then().assertThat().statusCode(201);
        System.out.println("\n" + "POST_createEmployee is passed");

    }

    @Test
    public void POST_registerEmployeeSuccessful() {

        RequestSpecification httpRequest = RestAssured.given();

        /*
            Translate JSON request into a JSONObject

            {
                "email": "eve.holt@reqres.in",
                "password": "pistol"
            }
         */

        JSONObject payload = new JSONObject();

        payload.put("email", "michael.lawson@reqres.in");
        payload.put("password", "password");

        httpRequest.baseUri(baseURI);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(payload.toString());

        System.out.println("Request:");
        System.out.println("========");
        //print API request log
        httpRequest.log().all();

        Response response = httpRequest.when().post("api/register");

        System.out.println("\n" + "Response:");
        System.out.println("========");
        //print API response
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("\n" + "registerEmployeeSuccessful is passed");

    }

    @Test
    public void POST_registerEmployeeUnsuccessful() {

//        RequestSpecification
//                request = given().header("Content-Type", "application/json").body("{\n" +
//                "    \"email\": \"sydney@fife\"\n" +
//                "}");
//
//        Response response = request.when().post("api/register");
//        response.prettyPrint();
//        //verify response code
//        response.then().assertThat().statusCode(400);
//        System.out.println("\n" + "registerEmployeeUnsuccessful is passed");

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject payload = new JSONObject();

        payload.put("email", "sydney@fife");

        httpRequest.baseUri(baseURI);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(payload.toString());

        System.out.println("Request:");
        System.out.println("========");
        //print API request log
        httpRequest.log().all();

        Response response = httpRequest.when().post("api/register");

        System.out.println("\n" + "Response:");
        System.out.println("========");
        //print API response
        response.prettyPrint();
        response.then().assertThat().statusCode(400);
        System.out.println("\n" + "registerEmployeeUnsuccessful is passed");

    }

}
