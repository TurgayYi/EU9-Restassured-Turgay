package com.cydeo.day3;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class ORDSApiTestsWithParameters {


    @BeforeAll
    public static void init(){

        baseURI = "http://44.195.19.167:8000";


    }

    /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */

    @DisplayName("GET request to /countries with Query Param")
    @Test
    public void test1(){





    }




}
