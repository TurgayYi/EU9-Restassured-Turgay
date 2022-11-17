package com.cydeo.day3;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class SpartanTestsWithParameters {

    @BeforeAll

    public static void init(){
        baseURI = "http://44.195.19.167:8000";

    }

        /*   Given accept type is Json
          And Id parameter value is 5
          When user sends GET request to /api/spartans/{id}
          Then response status code should be 200
          And response content-type: application/json
          And "Kingsman" should be in response payload
       */

    @DisplayName("GET request to /api/spartans/{id} with id 167")
    @Test
    public void test1(){


        Response response = given().
                accept(ContentType.JSON)
                .and().pathParam("id", 167)
                .when()
                .get("/api/spartans/{id}");

        //verify status code
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());
        //verify Blythe in the json payload/body
        assertTrue(response.body().asString().contains("Kingsman"));



    }

      /*
        TASK
        Given accept type is Json
        And Id parameter value is 600
        When user sends GET request to /api/spartans/{id}
        Then response status code should be 404
        And response content-type: application/json
        And "Not Found" message should be in response payload
     */

    @DisplayName("GET request to /api/spartans/{id} Negative")
    @Test
    public void test2(){

        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id", 600)
                .when()
                .get("/api/spartans/{id}");

        //verify status code 404
        assertEquals(404,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());
        //verify NotFound in the json payload/body
        assertTrue(response.body().asString().contains("Not Found"));



    }






}
