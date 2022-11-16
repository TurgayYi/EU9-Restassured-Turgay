package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HrGetRequests {

    @BeforeAll//BeforeAll is a annotation equals to @BeforeClass in testNg, we use with static method name
    public static void init(){

        RestAssured.baseURI = "http://44.195.19.167:1000/ords/hr";

    }

    @Test
    public void test1(){
        Response response = get("/regions");

        System.out.println("response.statusCode() = " + response.statusCode());

    }

        /*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */

    @DisplayName("Get HR Request")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/regions/2");

        //verify status code
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());

        response.prettyPrint();

        //verify body contains Americas
        assertTrue(response.body().asString().contains("Americas"));


    }






}
